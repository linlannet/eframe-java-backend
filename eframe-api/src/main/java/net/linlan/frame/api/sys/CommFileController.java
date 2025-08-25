/*
 * eframe-api - api接口网关模块
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
package net.linlan.frame.api.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.ObjectUtils;
import net.linlan.commons.core.ResponseResult;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.FrameAdminUser;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.mbiz.constant.HttpStatusEnum;
import net.linlan.frame.view.admin.service.InitialRedisService;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.sys.param.CommFileVoParam;
import net.linlan.frame.view.sys.vo.CommFileVo;
import net.linlan.frame.web.SecurityUtils;
import net.linlan.sys.comm.dto.CommFileDto;
import net.linlan.sys.comm.dto.FileInfo;
import net.linlan.sys.comm.service.CommFileService;
import net.linlan.sys.comm.service.UploadFileService;
import net.linlan.utils.config.PlatformConfig;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.file.FileUtils;
import net.linlan.utils.upload.ResourceType;

/**
 *
 * File控制域:公共文件管理读写控制类
 * @author Linlan
 * CreateTime 2024-11-19 14:58:36
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/system/")
public class CommFileController extends BaseController {

    @Resource
    private CommFileService     baseCommFileService;
    @Resource
    private InitialRedisService initialRedisService;

    /**
     * 获取资源存储清单列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取资源存储清单列表")
    @PreAuthorize("@ss.hasPerms('system:file:list')")
    @GetMapping("file/list")
    @Encrypt
    public ResponseResult<Pagination<CommFileVo>> list(CommFileVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<CommFileDto> result = baseCommFileService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<CommFileVo> vos = Lists.transform(result.getResult(), CommFileVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 资源存储清单导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "资源存储清单导出", category = 52)
    @PreAuthorize("@ss.hasPerms('system:file:export')")
    @PostMapping("file/export")
    @Encrypt
    public void export(HttpServletResponse response, CommFileVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<CommFileDto> result = baseCommFileService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<CommFileVo> vos = Lists.transform(result.getResult(), CommFileVo.DTO);
        ExcelUtil<CommFileVo> util = new ExcelUtil<>(CommFileVo.class);
        util.exportExcel(response, vos, "参数数据");
    }

    /**
     * 根据编号获取文件详细信息
     * @param id    主键ID
     * @return 文件对象
     */
    @PlatLog(value = "根据编号获取文件详细信息")
    @PreAuthorize("@ss.hasPerms('system:file:detail')")
    @GetMapping(value = "file/info")
    @Encrypt
    public ResponseResult<CommFileVo> getInfo(@RequestParam("id") String id) {

        if (StringUtils.isBlank(id)) {
            return failure();
        }
        CommFileDto dto = baseCommFileService.getDtoById(id);
        if (ObjectUtils.isEmpty(dto)) {
            return empty();
        }
        return success(CommFileVo.DTO.apply(dto));
    }

    /**
     * 新增文件
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:file:save')")
    @PlatLog(value = "新增文件", category = 10)
    @PostMapping("file/save")
    @Encrypt
    @LimitScope(name = "commFileSave", key = "commFileSave")
    public ResponseResult<String> save(@Validated @RequestBody CommFileVo input) {
        if (ObjectUtils.isNotEmpty(baseCommFileService.findById(input.getId()))) {
            return error("新增参数'" + input.getId() + "'失败，参数键名已存在");
        }
        baseCommFileService.save(CommFileVo.transTo(input));
        return success();
    }

    /**
     * 修改文件
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:file:update')")
    @PlatLog(value = "修改文件", category = 20)
    @PostMapping("file/update")
    @Encrypt
    @LimitScope(name = "commFileUpdate", key = "commFileUpdate")
    public ResponseResult<String> update(@Validated @RequestBody CommFileVo input) {
        if (ObjectUtils.isNotEmpty(baseCommFileService.findById(input.getId()))) {
            return error("修改参数'" + input.getId() + "'失败，参数键名已存在");
        }
        baseCommFileService.update(CommFileVo.transTo(input));
        return success();
    }

    /**
     * 删除文件
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:file:delete')")
    @PlatLog(value = "删除文件", category = 40)
    @PostMapping("file/delete")
    @Encrypt
    @LimitScope(name = "commFileDelete", key = "commFileDelete")
    public ResponseResult<String> delete(@Validated @RequestBody CommFileVo input) {
        baseCommFileService.deleteByIds(input.getIds());
        return success();
    }

    /**
     * 刷新参数缓存
     * @return 刷新结果
     */
    @PreAuthorize("@ss.hasPerms('system:file:delete')")
    @PlatLog(value = "刷新参数缓存", category = 21)
    @DeleteMapping("file/refreshCache")
    @Encrypt
    @LimitScope(name = "commFileRefresh", key = "commFileRefresh")
    public ResponseResult<String> refreshCache() {
        initialRedisService.resetConfigCache();
        return success();
    }

    @Resource
    private UploadFileService uploadFileService;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete 是否删除
     * @param response 响应
     * @param request 请求
     */
    @PlatLog(value = "通用下载请求")
    @GetMapping("file/download")
    @Encrypt
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response,
                             HttpServletRequest request) {
        try {
            if (!FileUtils.checkAllowDownload(fileName)) {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis()
                                  + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = PlatformConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求（单个）
     * @param response 响应
     * @param request 请求
     * @return 文件对象
     * @throws Exception    异常
     */
    @PlatLog(value = "通用上传请求（单个）", category = 10)
    @PostMapping("file/upload")
    @Encrypt
    public ResponseResult<FileInfo> uploadFile(HttpServletRequest request,
                                               HttpServletResponse response) throws Exception {
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFileMap().entrySet().iterator().next()
                .getValue();
            //hcday add 20201020 判断上传的文件类型，在白名单内才可以
            String origName = multipartFile.getOriginalFilename();
            String ext = FilenameUtils.getExtension(origName).toLowerCase(Locale.ENGLISH);
            if (ResourceType.FILE_SUFFIX.contains(ext)) {//FILE_SUFFIX中不包含xlsx 因此加了判断 DOCUMENT_SUFFIX
                String context = request.getContextPath();
                FrameAdminUser loginUser = SecurityUtils.getLoginUser();
                FileInfo fileInfo = uploadFileService.uploadFileByMember(multipartFile, context,
                    Constants.ENT_APP_ID, loginUser.getUserId());
                return ResponseResult.ok().setResultData(fileInfo);
            }
            return ResponseResult.error(HttpStatusEnum.BAD_REQUEST.getCode(), "文件上传类型错误");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.error(HttpStatusEnum.BAD_REQUEST.getCode(), "文件上传失败");
        }
    }

    /**
     * 通用上传请求（多个）
     * @param files 文件
     * @param request 请求
     * @return 文件列表对象
     * @throws Exception    异常
     */
    @PlatLog(value = "通用上传请求（多个）", category = 10)
    @PostMapping("file/uploads")
    @Encrypt
    public ResponseResult<List<FileInfo>> uploadFiles(List<MultipartFile> files,
                                                      HttpServletRequest request) throws Exception {
        try {
            // 上传文件路径
            FrameAdminUser loginUser = SecurityUtils.getLoginUser();
            List<FileInfo> fileInfos = new ArrayList<>();

            for (MultipartFile file : files) {
                // 上传并返回新文件名称
                try {
                    //hcday add 20201020 判断上传的文件类型，在白名单内才可以
                    String origName = file.getOriginalFilename();
                    String ext = FilenameUtils.getExtension(origName).toLowerCase(Locale.ENGLISH);
                    if (ResourceType.FILE_SUFFIX.contains(ext)) {//FILE_SUFFIX中不包含xlsx 因此加了判断 DOCUMENT_SUFFIX
                        String context = request.getContextPath();
                        FileInfo fileInfo = uploadFileService.uploadFileByMember(file, context,
                            Constants.ENT_APP_ID, loginUser.getUserId());
                        fileInfos.add(fileInfo);
                    }
                    return ResponseResult.error(HttpStatusEnum.BAD_REQUEST.getCode(), "文件上传类型错误");
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResponseResult.error(HttpStatusEnum.BAD_REQUEST.getCode(), "文件上传失败");
                }
            }
            return ResponseResult.ok().setResultData(fileInfos);
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     * @param resource 资源文件路径
     * @param response 响应
     * @param request 请求
     * @throws Exception    异常
     */
    @PlatLog(value = "本地资源通用下载")
    @GetMapping("file/download/resource")
    @Encrypt
    public void resourceDownload(String resource, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        try {
            if (!FileUtils.checkAllowDownload(resource)) {
                throw new Exception(StringUtils.format("资源文件({})非法，不允许下载。 ", resource));
            }
            // 本地资源路径
            String localPath = PlatformConfig.getProfile();
            // 数据库资源地址
            String downloadPath = localPath
                                  + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, downloadName);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

}
