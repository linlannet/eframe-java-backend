/*
 * eframe-model - model模型数据模块
 * Copyright © 2020-2025 Linlan (open@linlan.net)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.linlan.sys.comm.service;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson2.JSON;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.sys.base.entity.BaseApp;
import net.linlan.sys.base.service.BaseAppService;
import net.linlan.sys.comm.dto.FileInfo;
import net.linlan.sys.comm.storage.FileStorageFactory;
import net.linlan.sys.web.KernelThreadVariable;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.config.PlatformConfig;
import net.linlan.utils.upload.FileRepository;
import net.linlan.utils.upload.ResourceType;

/**
 *
 * Filename:UploadFileService.java
 * Desc: 统一的上传基础服务
 *
 * @author Linlan
 * CreateTime:3/14/19 4:22 PM
 *
 * @version 1.0
 * @since 1.0
 *
 */
@Service
@Slf4j
public class UploadFileService {

    @Value("${platform.file.store.fileServer}")
    private boolean           localFileServer;

    @Resource
    protected FileRepository  fileRepository;
    @Resource
    protected BaseAppService  baseAppService;
    @Resource
    protected CommFileService commFileService;
    @Resource
    private RedisService      redisService;

    /** 前台会员上传附件，会将前台动态的appId和用户Id传入
     * @param file    文件
     * @param context    上下文路径
     * @param appId    应用ID
     * @param userId    用户ID
     * @return    文件
     * @throws Exception  异常
     */
    public FileInfo uploadFileByMember(MultipartFile file, String context, String appId,
                                       String userId) throws Exception {
        if (StringUtils.isBlank(appId)) {
            return null;
        }

        BaseApp baseApp = baseAppService.findById(appId);
        if (baseApp == null) {
            return null;
        }
        String ftpId = baseApp.getFtpId();
        return doUpload(file, context, ftpId, userId, baseApp, false);
    }

    /** 前台Plat平台上传附件
     * @param file    文件
     * @param context    上下文路径
     * @param appId    应用ID
     * @param userId    用户ID
     * @return    文件
     * @throws Exception  异常
     */
    public FileInfo uploadFileByPlat(MultipartFile file, String context, String appId,
                                     String userId) throws Exception {
        if (StringUtils.isBlank(appId)) {
            return null;
        }

        BaseApp baseApp = baseAppService.findById(appId);
        if (baseApp == null) {
            return null;
        }
        String ftpId = baseApp.getFtpId();
        return doUpload(file, context, ftpId, userId, baseApp, true);
    }

    /** 后台管理上传附件
     * @param file    文件
     * @param userId    用户ID
     * @param context    上下文路径
     * @return    文件
     * @throws Exception  异常
     */
    public FileInfo uploadFileByAdmin(MultipartFile file, String userId,
                                      String context) throws Exception {
        String appId = KernelThreadVariable.getBaseAppId();
        if (StringUtils.isBlank(appId)) {
            return null;
        }
        BaseApp baseApp = baseAppService.findById(KernelThreadVariable.getBaseAppId());
        if (baseApp == null) {
            return null;
        }
        String ftpId = baseApp.getFtpId();
        return doUpload(file, context, ftpId, userId, baseApp, true);
    }

    private FileInfo doUpload(MultipartFile file, String context, String ftpId, String userId,
                              BaseApp baseApp, boolean isAdmin) throws Exception {
        log.info("文件开始上传服务器：" + new Date());
        String appId = baseApp.getId();
        String uploadPath = PlatformConfig.getUploadPath();
        // 检查允许上传的后缀
        String origName = file.getOriginalFilename();
        String ext = FilenameUtils.getExtension(origName).toLowerCase(Locale.ENGLISH);
        //如果没有通过fileType获取到文件类型，则判断后缀，得到文件类型
        String resclassId = ResourceType.valueOfByExt(ext);
        String fileUrl = null;
        String fileHttpUrl = null;
        String filename = null;
        log.info("文件大小：" + file.getSize());
        if (localFileServer) {
            //使用文件服务器
            fileUrl = FileStorageFactory.build().uploadSuffix(file.getBytes(), ext);
            filename = fileUrl;
            fileHttpUrl = fileUrl;
            //        } else if (thirdOss){  // 第三方存储代码移动到oss包中
            //            //将文件上传到第三方云存储中
            //            fileUrl = OSSFactory.build().uploadSuffix(file.getBytes(), ext);
            //            filename = fileUrl;
            //            fileHttpUrl = fileUrl;
        } else {
            //应用服务器本地路径
            filename = fileRepository.storeByExt(uploadPath, ext, file);
            // 加上部署路径
            fileUrl = context + filename;
            fileHttpUrl = fileUrl;
        }
        log.info("文件结束上传服务器：" + new Date());
        //保存新文件
        int fileSize = (int) (file.getSize() / 1024);
        log.info("开始保存本地库commFile数据：" + new Date());
        commFileService.saveOrUpdateByFile(true, filename, appId, resclassId, origName, fileSize,
            ext, isAdmin, userId);
        log.info("结束保存本地库commFile数据：" + new Date());
        FileInfo fileInfo = new FileInfo();
        fileInfo.setOriginFilename(origName);
        fileInfo.setFilename(filename);
        fileInfo.setFileType(ext);
        fileInfo.setFileUrl(fileUrl);
        fileInfo.setFileHttpUrl(fileHttpUrl);
        log.info("返回结果FileInfo：" + JSON.toJSONString(fileInfo));
        return fileInfo;
    }

    /** 前台会员上传附件，会将前台动态的appId和用户Id传入
     * @param file    文件
     * @param context    上下文路径
     * @param appId    应用ID
     * @param userId    用户ID
     * @param refId    参考ID
     * @param refType    参考类型
     * @return    文件
     * @throws Exception  异常
     */
    public FileInfo uploadFileByMemberWithRef(MultipartFile file, String context, String appId,
                                              String userId, String refId,
                                              String refType) throws Exception {
        if (StringUtils.isBlank(appId)) {
            return null;
        }

        BaseApp baseApp = baseAppService.findById(appId);
        if (baseApp == null) {
            return null;
        }
        String ftpId = baseApp.getFtpId();
        return doUploadWithRef(file, context, ftpId, userId, baseApp, false, refId, refType);
    }

    private FileInfo doUploadWithRef(MultipartFile file, String context, String ftpId,
                                     String userId, BaseApp baseApp, boolean isAdmin, String refId,
                                     String refType) throws Exception {
        log.info("文件开始上传服务器：" + new Date());
        String appId = baseApp.getId();
        String uploadPath = PlatformConfig.getUploadPath();
        // 检查允许上传的后缀
        String origName = file.getOriginalFilename();
        String ext = FilenameUtils.getExtension(origName).toLowerCase(Locale.ENGLISH);
        //如果没有通过fileType获取到文件类型，则判断后缀，得到文件类型
        String resclassId = ResourceType.valueOfByExt(ext);
        String fileUrl = null;
        String fileHttpUrl = null;
        String filename = null;
        log.info("文件大小：" + file.getSize());
        if (localFileServer) {
            //使用文件服务器
            fileUrl = FileStorageFactory.build().uploadSuffix(file.getBytes(), ext);
            filename = fileUrl;
            fileHttpUrl = fileUrl;
            //        } else if (thirdOss){  // 第三方存储代码移动到oss包中
            //            //将文件上传到第三方云存储中
            //            fileUrl = OSSFactory.build().uploadSuffix(file.getBytes(), ext);
            //            filename = fileUrl;
            //            fileHttpUrl = fileUrl;
        } else {
            //应用服务器本地路径
            filename = fileRepository.storeByExt(uploadPath, ext, file);
            // 加上部署路径
            fileUrl = context + filename;
            fileHttpUrl = fileUrl;
        }
        log.info("文件结束上传服务器：" + new Date());
        //保存新文件
        int fileSize = (int) (file.getSize() / 1024);
        log.info("开始保存本地库commFile数据：" + new Date());
        commFileService.saveOrUpdateByFileWithRef(true, filename, appId, resclassId, origName,
            fileSize, ext, isAdmin, userId, refId, refType);
        log.info("结束保存本地库commFile数据：" + new Date());
        FileInfo fileInfo = new FileInfo();
        fileInfo.setOriginFilename(origName);
        fileInfo.setFilename(filename);
        fileInfo.setFileType(ext);
        fileInfo.setFileUrl(fileUrl);
        fileInfo.setFileHttpUrl(fileHttpUrl);
        log.info("返回结果FileInfo：" + JSON.toJSONString(fileInfo));
        return fileInfo;
    }

    /** 大文件上传本地服务器
     * @param file  文件
     * @param ftpId     : ftp服务器Id
     * @param hash     : 哈希值
     * @param seq      : 分片序号
     * @param totalNumber      : 总分片数量
     * @return    文件
     * @throws Exception    异常
     *
     */
    public FileInfo fileUploadSlice(MultipartFile file, String ftpId, String hash, Integer seq,
                                    Integer totalNumber) throws Exception {
        if (StringUtils.isBlank(ftpId)) {
            return null;
        }
        if (ObjectUtils.isEmpty(file) || ObjectUtils.isEmpty(hash) || ObjectUtils.isEmpty(seq)
            || ObjectUtils.isEmpty(totalNumber)) {
            return null;
        }
        //设置返回数据
        FileInfo fileInfo = new FileInfo();
        //文件扩展名
        String filenameExtension = org.springframework.util.StringUtils
            .getFilenameExtension(file.getOriginalFilename());
        //String origName = file.getOriginalFilename();//获取源文件名
        //String ext = FilenameUtils.getExtension(origName).toLowerCase(Locale.ENGLISH);//获取扩展名称
        //设置redis 实现秒传
        String resRedis = (String) redisService.get("bigFileUpload:finish:hash:" + hash + ":seq" + seq);
        if (resRedis != null && "200".equals(resRedis)) {//表示已经完成了上传直接跳过
            fileInfo.setOriginFilename(file.getOriginalFilename());
            fileInfo.setFilename(file.getOriginalFilename());
            fileInfo.setFileType(filenameExtension);
            fileInfo.setStatusCode("1");
        } else {
            fileInfo = uploadSliceImpl(file, hash, seq, totalNumber, PlatformConfig.getUploadPath(),
                filenameExtension);
        }
        fileInfo.setFileUrl(PlatformConfig.getUploadPath());
        fileInfo.setFileHttpUrl(
            PlatformConfig.getUploadPath() + File.separator + fileInfo.getFilename());
        return fileInfo;
    }

    private static final Lock lock = new ReentrantLock();

    /**
     * 分片上传
     *
     * @param file     : 文件流
     * @param hash     : 哈希值
     * @param seq      : 分片序号
     * @param totalNumber      : 总分片数量
     * @param uploadPath      : 上传路径
     * @param filenameExtension      : 文件扩展名
     * @return : 分片文件
     */
    public FileInfo uploadSliceImpl(MultipartFile file, String hash, Integer seq,
                                    Integer totalNumber, String uploadPath,
                                    String filenameExtension) {
        RandomAccessFile raf = null;
        FileInfo fileInfo = new FileInfo();//返回对象
        fileInfo.setStatusCode("0");
        try {
            lock.lock();
            try {
                // 创建目标文件夹
                File uploadPathDir = new File(uploadPath);
                log.info("数据库文件上传地址:" + uploadPathDir);
                if (!uploadPathDir.exists()) {
                    log.info("数据库文件上传地址不存在创建");
                    uploadPathDir.mkdir();//如果数据库文件上传地址不存在 则创建
                }

                // 文件存放位置
                String dstFile = String.format("%s%s%s%s%s.%s", uploadPath, File.separator, hash,
                    File.separator, seq, filenameExtension);

                // 上传分片信息存放位置
                String confFile = String.format("%s%s%s%s%s.conf", uploadPath, File.separator, hash,
                    File.separator, hash);

                String confName = " totalNumber: " + totalNumber.toString();//conf内容
                // 创建目标文件夹
                File dir = new File(dstFile).getParentFile();
                log.info("文件上传地址:" + dir);
                if (!dir.exists()) {
                    dir.mkdir();
                    log.info("分片文件上传-创建文件地址");
                    // 所有分片状态设置为0
                    byte[] bytes = confName.getBytes(StandardCharsets.UTF_8); // 使用UTF-8编码
                    Files.write(Paths.get(confFile), bytes);
                }

                // 创建空格文件 名称带seq用于标识分块信息
                raf = new RandomAccessFile(dstFile, "rw");
                // 写入文件流
                log.info("分片文件上传-写入文件流");
                raf.write(file.getBytes());
                redisService.set("bigFileUpload:finish:hash:" + hash + ":seq" + seq, "200", 3600l);
                fileInfo.setOriginFilename(file.getOriginalFilename());
                fileInfo.setFilename(file.getOriginalFilename());
                fileInfo.setFileType(filenameExtension);
                fileInfo.setStatusCode("1"); // 上传成功标记
            } finally {
                lock.unlock();
            }
        } catch (IOException e) {
            // 异常处理
            // ...打印异常日志...
            log.info("文件上传失败:" + e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                // ...打印异常日志...
                log.info("文件流关闭失败:" + e.getMessage());
            }
            log.info("返回结果FileInfo：" + JSON.toJSONString(fileInfo));
            return fileInfo;
        }
    }

    /**
     * 合并分片请求
     * @param ftpId    ftp服务器ID
     * @param fileName    文件名称
     * @param type    类型
     * @param hash    hash值
     * @return    文件
     * @throws Exception  异常
     */
    public FileInfo uploadMerge(String ftpId, String fileName, String type,
                                String hash) throws Exception {
        if (StringUtils.isBlank(ftpId)) {
            return null;
        }
        if (ObjectUtils.isEmpty(hash) || ObjectUtils.isEmpty(fileName) || ObjectUtils.isEmpty(type)
            || ObjectUtils.isEmpty(PlatformConfig.getUploadPath())) {
            return null;
        }
        FileInfo fileInfo = new FileInfo();//返回对象
        //设置返回数据
        fileInfo = uploadMergeImp(fileName, type, hash, PlatformConfig.getUploadPath());
        fileInfo.setFileHttpUrl(PlatformConfig.getUploadPath() + File.separator + hash
                                + File.separator + fileInfo.getFilename());
        return fileInfo;
    }

    /**
     * 合并文件的业务代码
     * @param filename : 文件名
     * @param hash     : 文件哈希值
     * @param type     : 文件类型
     * @param uploadPath     : 上传路径
     * @return 合并后的文件
     */
    public FileInfo uploadMergeImp(String filename, String type, String hash, String uploadPath) {
        FileInfo fileInfo = new FileInfo();//返回对象
        fileInfo.setStatusCode("0");
        // 判断hash对应文件夹是否存在
        File dir = new File(uploadPath + File.separator + hash);
        log.info("文件合并文件hash地址:" + dir);
        if (!dir.exists()) {
            System.out.println("合并失败，请稍后重试");
            return fileInfo;
        }
        // 这里通过FileChannel来实现信息流复制
        FileChannel out = null;
        //文件存放位置
        String dstFile = String.format("%s%s%s%s%s", uploadPath, File.separator, hash,
            File.separator, filename);
        log.info("文件合并文件地址:" + dstFile);
        // 获取目标channel
        try (FileChannel in = new RandomAccessFile(dstFile, "rw").getChannel()) {
            // 分片索引递增
            int index = 0;
            // 开始流位置
            long start = 0;

            while (true) {
                //分片文件名
                String sliceName = String.format("%s%s%s%s%s.%s", uploadPath, File.separator, hash,
                    File.separator, index, type);
                log.info("文件合并文件分片:" + sliceName);
                // 到达最后一个分片 退出循环
                if (!new File(sliceName).exists()) {
                    break;
                }
                // 分片输入流
                out = new RandomAccessFile(sliceName, "r").getChannel();
                // 写入目标channel
                in.transferFrom(out, start, start + out.size());
                // 位移量调整
                start += out.size();
                out.close();
                out = null;
                // 分片索引调整
                index++;
            }
            // 将 FileChannel 转换为 InputStream
            InputStream inputStream = Channels.newInputStream(in);
            String md5pwd = DigestUtils.md5DigestAsHex(inputStream);
            // 上传分片信息存放位置
            String confFile = String.format("%s%s%s%s%s.conf", uploadPath, File.separator, hash,
                File.separator, hash);
            // 将MD5哈希值追加到文件末尾
            try (FileOutputStream fos = new FileOutputStream(confFile, true); // true 表示追加模式
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    PrintWriter pw = new PrintWriter(bos)) {
                pw.print(" md5pwd: " + md5pwd);
            }

            // 文件合并完毕
            in.close();

            // 删除分片文件
            for (int i = 0; i < index; i++) {
                String sliceName = String.format("%s%s%s%s%s.%s", uploadPath, File.separator, hash,
                    File.separator, i, type);
                File sliceFile = new File(sliceName);
                if (sliceFile.exists()) {
                    sliceFile.delete();
                }
                redisService.delete("bigFileUpload:finish:hash:" + hash + ":seq" + i);
            }
            fileInfo.setOriginFilename(filename);
            fileInfo.setFilename(filename);
            fileInfo.setFileType(type);
            fileInfo.setFileUrl(uploadPath + File.separator + hash + File.separator + filename);
            fileInfo.setStatusCode("1");
        } catch (IOException e) {
            // ...记录日志..
            log.info("文件合并失败:" + e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //返回结果
            return fileInfo;
        }
    }

    /**
     * 合并分片请求
     * @param ftpId    ftp服务器ID
     * @param hash    hash值
     * @return    文件
     * @throws Exception  异常
     */
    public FileInfo checkUpload(String ftpId, String hash) throws Exception {
        if (StringUtils.isBlank(ftpId)) {
            return null;
        }
        if (ObjectUtils.isEmpty(hash) || ObjectUtils.isEmpty(PlatformConfig.getUploadPath())) {
            return null;
        }
        //设置返回数据
        return checkUploadImp(hash, PlatformConfig.getUploadPath());
    }

    /**
     * 检查秒传
     *
     * @param hash : 文件hash
     * @param uploadPath : 文件上传路径
     * @return 文件
     * @throws Exception 异常
     */
    public FileInfo checkUploadImp(String hash, String uploadPath) throws Exception {
        //判断文件是否上传成功
        FileInfo fileInfo = new FileInfo();//返回对象
        fileInfo.setStatusCode("0");
        String uploadPathAll = String.format("%s%s%s%s%s.conf", uploadPath, File.separator, hash,
            File.separator, hash);
        log.info("文件上传检查全地址:" + uploadPathAll);
        Path confPath = Paths.get(uploadPathAll);
        //MD5目录不存在文件从未上传过
        if (!Files.exists(confPath.getParent())) {
            log.info("conf文件地址不存在！！！");
            return fileInfo;
        }
        // 读取conf文件内容
        List<String> strings = Files.readAllLines(confPath, StandardCharsets.UTF_8);
        //所有分片上传完成计算文件MD5
        File file = new File(String.format("%s%s%s", uploadPath, File.separator, hash));
        File[] files = file.listFiles();
        String filePath = "";
        String filename = "";
        String type = "";

        // 找到最大的文件
        File largestFile = null;
        for (File f : files) {
            if (!f.getName().contains("conf")) {
                if (f.isFile() && (largestFile == null || f.length() > largestFile.length())) {
                    largestFile = f;
                }
            }
        }

        // 获取最大文件的名称和类型
        if (largestFile != null) {
            filePath = largestFile.getAbsolutePath();
            filename = largestFile.getName();
            if (filename.lastIndexOf(".") != -1 && filename.lastIndexOf(".") != 0) {
                type = filename.substring(filename.lastIndexOf(".") + 1);
            }
            try (InputStream inputStream = new FileInputStream(largestFile)) {
                String md5pwd = DigestUtils.md5DigestAsHex(inputStream);
                log.info("文件上传后台计算md5:" + md5pwd);
                if (strings.stream().anyMatch(line -> line.contains(md5pwd))) {
                    fileInfo.setOriginFilename(filename);
                    fileInfo.setFilename(filename);
                    fileInfo.setFileType(type);
                    fileInfo.setFileUrl(filePath);
                    fileInfo.setFileHttpUrl(filePath);
                    fileInfo.setStatusCode("1");
                }
            }
        }
        return fileInfo;
    }

}
