/*
 * module-oss - 存储对接模块
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
package net.linlan.oss.service;

import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.StringUtils;
import net.linlan.commons.script.json.JsonUtils;
import net.linlan.oss.storage.OSSFactory;
import net.linlan.sys.base.entity.BaseApp;
import net.linlan.sys.base.service.BaseAppService;
import net.linlan.sys.comm.dto.FileInfo;
import net.linlan.sys.comm.service.CommFileService;
import net.linlan.sys.comm.storage.FileStorageFactory;
import net.linlan.sys.web.KernelThreadVariable;
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
public class UploadFileOssService {

    @Value("${platform.file.store.thirdOss}")
    private boolean         thirdOss;

    @Value("${platform.file.store.fileServer}")
    private boolean         localFileServer;

    @Resource
    private FileRepository  fileRepository;
    @Resource
    private BaseAppService  baseAppService;
    @Resource
    private CommFileService commFileService;

    /** 前台会员上传附件，会将前台动态的appId和用户Id传入
     * @param file
     * @param context
     * @param appId
     * @param userId
     * @return
     * @throws Exception
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
     * @param file
     * @param context
     * @param appId
     * @param userId
     * @return
     * @throws Exception
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
     * @param file
     * @param userId
     * @param context
     * @return
     * @throws Exception
     */
    public FileInfo uploadFileByAdmin(MultipartFile file, String userId,
                                      String context) throws Exception {
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
        String uploadPath = baseApp.getDescription();
        // 检查允许上传的后缀
        String origName = file.getOriginalFilename();
        String ext = FilenameUtils.getExtension(origName).toLowerCase(Locale.ENGLISH);
        //如果没有通过fileType获取到文件类型，则判断后缀，得到文件类型
        String resclassId = ResourceType.valueOfByExt(ext);
        String fileUrl = null;
        String fileHttpUrl = null;
        String filename = null;
        log.info("文件大小：" + file.getSize());
        log.info("localFileServer本地开关：" + localFileServer);
        log.info("thirdOss本地开关：" + thirdOss);
        log.info("ftpId本地开关：" + ftpId);
        if (localFileServer) {
            //使用文件服务器
            fileUrl = FileStorageFactory.build().uploadSuffix(file.getBytes(), ext);
            filename = fileUrl;
            fileHttpUrl = fileUrl;
        } else if (thirdOss) {
            //将文件上传到第三方云存储中
            fileUrl = OSSFactory.build().uploadSuffix(file.getBytes(), ext);
            filename = fileUrl;
            fileHttpUrl = fileUrl;
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
        log.info("返回结果FileInfo：" + JsonUtils.encode(fileInfo));
        return fileInfo;
    }

}
