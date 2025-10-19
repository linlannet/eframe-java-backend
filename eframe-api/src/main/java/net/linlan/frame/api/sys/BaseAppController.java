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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.Page;
import com.google.common.collect.Lists;

import net.linlan.annotation.AuthIgnore;
import net.linlan.annotation.Encrypt;
import net.linlan.annotation.LimitScope;
import net.linlan.commons.core.*;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.db.page.Pagination;
import net.linlan.frame.admin.entity.AdminUser;
import net.linlan.frame.admin.service.AdminUserService;
import net.linlan.frame.admin.service.InitialConfigService;
import net.linlan.frame.api.BaseController;
import net.linlan.frame.view.admin.service.InitialRedisService;
import net.linlan.frame.view.admin.utils.ExcelUtil;
import net.linlan.frame.view.admin.vo.AppInitialVo;
import net.linlan.frame.view.sys.param.BaseAppVoParam;
import net.linlan.frame.view.sys.vo.BaseAppVo;
import net.linlan.sys.base.dto.*;
import net.linlan.sys.base.entity.BaseApp;
import net.linlan.sys.base.entity.BaseConfigWhole;
import net.linlan.sys.base.param.*;
import net.linlan.sys.base.service.*;
import net.linlan.sys.role.entity.SysMenu;
import net.linlan.sys.role.service.SysMenuService;
import net.linlan.utils.crypt.ShaUtils;

/**
 *
 * 应用管理读写控制类
 * @author Linlan
 * CreateTime 2024-11-19 14:58:36
 *
 */
@RestController
@RequestMapping("/api/system/")
public class BaseAppController extends BaseController {
    @Resource
    private BaseAppService         baseAppService;
    @Resource
    private InitialRedisService    initialRedisService;
    @Resource
    private BaseXzqhService        baseXzqhService;
    @Resource
    private BaseOrganService       baseOrganService;
    @Resource
    public SysMenuService          sysMenuService;
    @Resource
    private BaseConfigWholeService BaseConfigWholeService;
    @Resource
    private AdminUserService       adminUserService;
    @Resource
    private InitialConfigService   initialConfigService;

    /**
     * 获取应用下拉列表
     * @param param 参数查询对象
     * @return 获取应用下拉列表
     */
    @PlatLog(value = "查询应用下拉列表")
    @AuthIgnore
    @GetMapping("/app/selectList")
    @Encrypt
    public ResponseResult<List<BaseAppDto>> selectList(BaseAppParam param) {
        Page<BaseAppDto> result = baseAppService.getPageDto(param);
        if (result == null) {
            return empty();
        }
        return successPage(result);
    }

    /**
     * 获取应用列表
     * @param param  查询条件
     * @return  返回对象
     */
    @PlatLog(value = "获取应用列表")
    @PreAuthorize("@ss.hasPerms('system:app:list')")
    @GetMapping("/app/list")
    @Encrypt
    public ResponseResult<Pagination<BaseAppDto>> list(BaseAppVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<BaseAppDto> result = baseAppService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        List<BaseAppDto> vos = Lists.transform(result.getResult(), BaseAppVo.DTO);
        return successPage(vos, result.getPageSize(), result.getPageNum(), result.getTotal());
    }

    /**
     * 应用列表导出
     * @param response  响应
     * @param param     导出查询条件
     */
    @PlatLog(value = "应用列表导出", category = 52)
    @PreAuthorize("@ss.hasPerms('system:app:export')")
    @PostMapping("/app/export")
    @Encrypt
    public void export(HttpServletResponse response, BaseAppVoParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return;
        }
        Page<BaseAppDto> result = baseAppService.getPageDto(param.toModelParam());
        if (ObjectUtils.isEmpty(result)) {
            return;
        }
        List<BaseAppDto> vos = Lists.transform(result.getResult(), BaseAppVo.DTO);
        ExcelUtil<BaseAppDto> util = new ExcelUtil<>(BaseAppDto.class);
        util.exportExcel(response, vos, "参数数据");
    }

    /**
     * 根据参数编号获取详细信息
     * @param appId  参数ID
     * @return 当前应用详情
     */
    @PlatLog(value = "根据参数编号获取详细信息")
    @PreAuthorize("@ss.hasPerms('system:app:detail')")
    @GetMapping(value = "/app/{appId}")
    @Encrypt
    public ResponseResult<BaseAppInfoDto> getInfo(@PathVariable String appId) {
        if (ObjectUtils.isEmpty(appId)) {
            return failure();
        }
        BaseAppInfoDto dto = baseAppService.getBaseAppInfoDto(appId);
        if (ObjectUtils.isEmpty(dto)) {
            return empty();
        }
        return success(dto);
    }

    /**
     * 新增应用配置
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:app:save')")
    @PlatLog(value = "新增应用配置", category = 10)
    @PostMapping("/app/save")
    @Encrypt
    @LimitScope(name = "baseAppSave", key = "baseAppSave")
    public ResponseResult<String> save(@Validated @RequestBody BaseAppVo input) {
        if (ObjectUtils.isNotEmpty(baseAppService.findById(input.getId()))) {
            return error("新增参数'" + input.getId() + "'失败，参数键名已存在");
        }
        baseAppService.save(BaseAppVo.transTo(input));
        return success();
    }

    /**
     * 修改应用配置
     * @param input  输入对象
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:app:update')")
    @PlatLog(value = "修改应用配置", category = 20)
    @PostMapping("/app/update")
    @Encrypt
    @LimitScope(name = "baseAppUpdate", key = "baseAppUpdate")
    public ResponseResult<String> update(@Validated @RequestBody BaseAppVo input) {

        baseAppService.update(BaseAppVo.transTo(input));
        return success();
    }

    /**
     * 删除应用配置
     * @param appIds  应用Ids
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:app:delete')")
    @PlatLog(value = "应用配置", category = 40)
    @PostMapping("/app/delete/{appIds}")
    @Encrypt
    @LimitScope(name = "baseAppDelete", key = "baseAppDelete")
    public ResponseResult<String> delete(@PathVariable String[] appIds) {
        baseAppService.deleteByIds(appIds);
        return success();
    }

    /**
     * 应用初始化
     * @param input  输入对象
     * @param id  应用ID
     * @return  操作结果
     */
    @PreAuthorize("@ss.hasPerms('system:app:update')")
    @PlatLog(value = "应用初始化", category = 20)
    @PostMapping("/app/init/{id}")
    @Encrypt
    public ResponseResult init(@RequestBody AppInitialVo input,
                               @PathVariable(value = "id") String id) {
        if (ObjectUtils.isEmpty(input)) {
            return success();
        }

        if (ObjectUtils.isEmpty(input)) {
            error("数据异常");
        }
        JSONArray jsonArray = input.getMenuJsons();
        JSONObject initJson = input.getInitJson();
        String username = input.getUsername();
        String password = input.getPassword();
        BaseApp baseApp = baseAppService.findById(id);
        BaseConfigWhole groupConfigWhole = BaseConfigWholeService.findById(id + "DEPT");
        if (baseApp != null && groupConfigWhole == null) {

            AdminUser adminUser = new AdminUser();
            adminUser.init();
            adminUser.setUsername(username);
            adminUser.setEmail(id);//将APP_ID设为salt码//方便后续导出
            adminUser.setPassword(password);
            adminUser.setCreateType(1);

            String deptId = initJson.getJSONArray("DEPT").toString();
            String roleIds = initJson.getJSONArray("ROLE").toString();

            try {
                if (StringUtils.isNotBlank(deptId)) {
                    deptId = deptId.substring(deptId.indexOf("[") + 2, deptId.indexOf("]") - 1);
                    adminUser.setDeptId(Long.valueOf(deptId));
                }
                if (StringUtils.isNotBlank(roleIds)) {
                    roleIds = roleIds.substring(roleIds.indexOf("[") + 2, roleIds.indexOf("]") - 1);
                    String[] ids = roleIds.split(",");
                    if (ids.length > 0) {
                        for (int i = 0; i < ids.length; i++) {
                            ids[i] = ids[i].substring(ids[i].indexOf(";") + 1);
                        }
                        adminUser.setRoleIds(strToLong(ids));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return error("部门或角色数据异常:" + deptId + "|" + roleIds);
            }

            //存入POSITIONjson
            BaseConfigWhole deptConfigWhole = new BaseConfigWhole();
            deptConfigWhole.setId(id + "DEPT");
            deptConfigWhole.setCfgKey(id + "DEPT");
            //将所需初始化json存入BaseConfigWhole，导出sql时处理
            deptConfigWhole.setCfgValue(initJson.getJSONArray("DEPT").toString());
            deptConfigWhole.setDescription("初始化DEPTjson");
            //存入ROLEjson
            BaseConfigWhole roleConfigWhole = new BaseConfigWhole();
            roleConfigWhole.setId(id + "ROLE");
            roleConfigWhole.setCfgKey(id + "ROLE");
            //将所需初始化json存入BaseConfigWhole，导出sql时处理
            roleConfigWhole.setCfgValue(initJson.getJSONArray("ROLE").toString());
            roleConfigWhole.setDescription("初始化ROLEjson");
            //存入BASE_DATAjson
            BaseConfigWhole baseDataConfigWhole = new BaseConfigWhole();
            baseDataConfigWhole.setId(id + "BASE_DATA");
            baseDataConfigWhole.setCfgKey(id + "BASE_DATA");
            //将所需初始化json存入BaseConfigWhole，导出sql时处理
            baseDataConfigWhole.setCfgValue(initJson.getJSONArray("BASE_DATA").toString());
            baseDataConfigWhole.setDescription("初始化BASE_DATAjson");

            if (!adminUserService.checkUsernameUnique(input.getUsername(), adminUser.getId())) {
                return error("新增用户'" + input.getUsername() + "'失败，登录账号已存在");
            } else if (ObjectUtils.isNotEmpty(adminUser.getMobile()) && !adminUserService
                .checkMobileUnique(adminUser.getMobile(), adminUser.getId())) {
                return error("新增用户'" + input.getUsername() + "'失败，手机号码已存在");
            } else if (ObjectUtils.isNotEmpty(adminUser.getEmail()) && !adminUserService
                .checkEmailUnique(adminUser.getEmail(), adminUser.getId())) {
                return error("新增用户'" + input.getUsername() + "'失败，邮箱账号已存在");
            }
            adminUser.setId(RandomUtils.randomLid());
            adminUser.setCreatorId(getUsername());
            if (StringUtils.isBlank(password)) { //默认一个初始化密码
                password = initialConfigService.selectConfigByKey("sys.user.initPassword");
            }
            adminUser.setPassword(ShaUtils.encryptPassword(password));
            adminUser.setIsAuditAdmin(false);
            adminUser.setIsSelfAdmin(false);
            adminUser.setIsSuperAdmin(true);
            adminUser.setLoginCount(0);
            adminUser.setStatus(1);
            adminUser.setDelFlag(0);
            adminUserService.save(adminUser);

            //开始存初始化菜单
            List<SysMenu> menuIdList = new ArrayList();
            Long maxMenuId = sysMenuService.getMaxMenuId() + 10L;
            for (int i = 0; i < jsonArray.size(); ++i) {
                JSONObject object = jsonArray.getJSONObject(i);
                Long menuId = maxMenuId + (long) menuIdList.size();
                if (object.get("id") != null && object.get("label") != null) {
                    SysMenu adminMenu = this.sysMenuService
                        .findById(Long.valueOf(object.get("id").toString()));
                    if (adminMenu != null) {
                        adminMenu.setId(menuId);
                        adminMenu.setName(object.get("label").toString());
                        adminMenu.setParentId(null);
                        menuIdList.add(adminMenu);
                    }
                }
                JSONObject m = jsonArray.getJSONObject(i);
                if (object.get("children") != null) {
                    JSONArray children = m.getJSONArray("children");
                    menuIdList = saveChildList(children, menuId, menuIdList);
                }
            }

            baseApp.setSpare1("1");//设定标识为已初始化
            sysMenuService.saveOrUpdateMenu(baseApp.getId(), menuIdList);
            baseAppService.update(baseApp);
            BaseConfigWholeService.save(deptConfigWhole);
            BaseConfigWholeService.save(roleConfigWhole);
            BaseConfigWholeService.save(baseDataConfigWhole);
        }
        return success();
    }

    private Long[] strToLong(String[] strs) {
        Long[] arr = new Long[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Long.parseLong(strs[i]);
        }
        return arr;
    }

    /**
     * 刷新参数缓存
     * @return 刷新后的结果
     */
    @PreAuthorize("@ss.hasPerms('system:app:delete')")
    @PlatLog(value = "刷新参数缓存", category = 21)
    @DeleteMapping("/app/refreshCache")
    @Encrypt
    @LimitScope(name = "baseAppRefresh", key = "baseAppRefresh")
    public ResponseResult<String> refreshCache() {
        initialRedisService.resetConfigCache();
        return success();
    }

    /**
     * 顶级行政区划下拉框
     * @param param    查询参数
     * @return  查询结果
     */
    @PlatLog(value = "顶级行政区划下拉框")
    @GetMapping("/app/xzqh/list")
    @Encrypt
    public ResponseResult<Pagination<BaseXzqhDto>> xzqhList(BaseXzqhParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<BaseXzqhDto> result = baseXzqhService.getPageDto(param);
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageSize(), result.getPageNum(),
            result.getTotal());
    }

    /**
     * 管理单位下拉框
     * @param param    查询参数
     * @return  查询结果
     */
    @PlatLog(value = "管理单位下拉框")
    @GetMapping("/app/organ/list")
    @Encrypt
    public ResponseResult<Pagination<KeyValueMapDto>> organList(BaseOrganParam param) {
        if (ObjectUtils.isEmpty(param)) {
            return failure();
        }
        Page<KeyValueMapDto> result = baseOrganService.getKeyValueList(param);
        if (ObjectUtils.isEmpty(result)) {
            return empty();
        }
        return successPage(result.getResult(), result.getPageNum(), result.getPageSize(),
            result.getTotal());
    }

    //子分支内循环
    private List<SysMenu> saveChildList(JSONArray jsonArray, Long pid, List<SysMenu> menuIdList) {
        for (int i = 0; i < jsonArray.size(); ++i) {
            JSONObject object = jsonArray.getJSONObject(i);
            Long id = (menuIdList.get(menuIdList.size() - 1)).getId() + 1L;
            if (object.get("id") != null && object.get("label") != null) {
                SysMenu adminMenu = this.sysMenuService
                    .findById(Long.valueOf(object.get("id").toString()));
                if (adminMenu != null) {
                    adminMenu.setId(id);
                    adminMenu.setName(object.get("label").toString());
                    adminMenu.setParentId(pid);
                    menuIdList.add(adminMenu);
                }
            }

            if (object.get("children") != null) {
                JSONArray child = object.getJSONArray("children");
                this.saveChildList(child, id, menuIdList);
            }
        }
        return menuIdList;
    }

}
