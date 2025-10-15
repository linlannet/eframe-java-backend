/*
 * eframe-view - view视图逻辑数模块
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
package net.linlan.frame.view.sys.service;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import lombok.extern.slf4j.Slf4j;

import net.linlan.commons.core.DateUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.script.json.JsonMapUtils;
import net.linlan.frame.admin.service.AdminDeptService;
import net.linlan.frame.view.sys.constant.TreeTypeEnum;
import net.linlan.frame.view.sys.param.BaseDictionaryTreeParam;
import net.linlan.sys.base.constant.TypeCodeEnum;
import net.linlan.sys.base.dto.DictionaryInitDto;
import net.linlan.sys.base.dto.TreeNode;
import net.linlan.sys.base.param.TreeParam;
import net.linlan.sys.base.service.*;
import net.linlan.sys.core.dto.CoreRoletypeDto;
import net.linlan.sys.core.service.CoreDepttypeService;
import net.linlan.sys.core.service.CoreOrgtypeService;
import net.linlan.sys.core.service.CoreRoletypeService;
import net.linlan.sys.role.dto.SysRoleDto;
import net.linlan.sys.role.param.MenuTreeParam;
import net.linlan.sys.role.param.SysRoleParam;
import net.linlan.sys.role.service.SysMenuService;
import net.linlan.sys.role.service.SysPositionService;
import net.linlan.sys.role.service.SysRoleService;
import net.linlan.sys.web.KernelConstant;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.constant.Constants;
import static net.linlan.utils.constant.CacheConstants.BASE_DICTIONARY_KEY;

/**
 *
 * Filename DictionaryInitDto,字典统一数据服务类
 * @author Linlan
 * CreateTime 2018-07-07 17:24:27
 *
 */
@Service
@Slf4j
public class FrameDictionaryService {

    @Resource
    private RedisService                     redisService;
    @Resource
    private BaseAppService                   baseAppService;
    @Resource
    private BaseDictionaryService            baseDictionaryService;
    @Resource
    private CoreRoletypeService              coreRoletypeService;
    @Resource
    private SysPositionService               adminPositionService;
    @Resource
    private BaseXzqhService                  baseXzqhService;
    @Resource
    private CoreDepttypeService              coreDepttypeService;
    @Resource
    private CoreOrgtypeService               coreOrgtypeService;
    @Resource
    public SysRoleService                    sysRoleService;
    @Resource
    public SysMenuService                    sysMenuService;
    @Resource
    public AdminDeptService                  adminDeptService;

    /**
     * 避免循环走redis，内存直接读，1小时清空重新拿
     */
    private Map<String, Map<String, String>> dics = new HashMap<>();
    /**
     * 过期时间
     */
    private Date                             expireTime;

    /**
     * 根据typeCode查询字典。
     * 字典缓存：2 小时,字典有调整的时候主动刷新，或者等两小时自动刷新
     * @param typeCode    字典code
     * @return    查询结果Map
     */
    public LinkedHashMap<String, String> getByTypeCode(String typeCode) {
        List<DictionaryInitDto> dist = getDicList(typeCode);
        return dis2Map(dist);
    }

    /**
     * 字典转Map
     * @param   list    输入LIST
     * @return    返回结果
     */
    private LinkedHashMap<String, String> dis2Map(List<DictionaryInitDto> list) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (DictionaryInitDto dic : list) {
            result.put(dic.getCddValue(), dic.getName());
        }
        return result;
    }

    /**
     * 20124 字典获取
     *
     * @param typeCode 字典类型编码
     * @param params 字典查询参数对象
     * @return    返回结果List
     */
    public List<DictionaryInitDto> getDict(String typeCode, BaseDictionaryTreeParam params) {
        if (StringUtils.isNotBlank(params.getTypeCode())) {
            typeCode = params.getTypeCode();
        }
        String parentId = params.getParentId();
        String zparentId = params.getZparentId();
        String roletypeId = params.getRoletypeId();
        List<DictionaryInitDto> dicResult = new ArrayList<>();
        if (StringUtils.isNotEmpty(typeCode) && StringUtils.isNotEmpty(roletypeId)) {
            if (TypeCodeEnum.JSXLK.getKey().equals(typeCode)) {
                dicResult = getAdminRoleSelect(typeCode, roletypeId);
            } else if (TypeCodeEnum.JSFLXLK.getKey().equals(typeCode)) {
                dicResult = getSysRoleTypeSelect(typeCode, roletypeId);
            }
        } else if (StringUtils.isNotEmpty(parentId) && StringUtils.isNotEmpty(typeCode)) {
            dicResult = baseDictionaryService.getAllChild(parentId, typeCode);
        } else if (StringUtils.isNotEmpty(zparentId) && StringUtils.isNotEmpty(typeCode)) {
            dicResult = baseDictionaryService.getChildren(zparentId, typeCode);
        } else if (StringUtils.isNotEmpty(typeCode)) {
            dicResult = getDicList(typeCode);
        }
        return dicResult;
    }

    public List<DictionaryInitDto> getSysRoleTypeSelect(String ypeCode, String roletypeId) {
        CoreRoletypeDto roletypeDto = coreRoletypeService.getDtoById(roletypeId);
        List<DictionaryInitDto> roleTypes = new ArrayList<>();
        DictionaryInitDto baseDictionary = new DictionaryInitDto();
        baseDictionary.setCddValue(roletypeId);
        baseDictionary.setName(roletypeDto.getName());
        roleTypes.add(baseDictionary);
        return roleTypes;
    }

    public List<DictionaryInitDto> getAdminRoleSelect(String typeCode, String roletypeId) {
        SysRoleParam param = new SysRoleParam();
        param.setRoletypeId(roletypeId);
        param.setLimit(10000);
        Page<SysRoleDto> roletypeDtos = sysRoleService.getPageDto(param);
        List<DictionaryInitDto> roleTypes = new ArrayList<>();
        for (SysRoleDto adminRoleDto : roletypeDtos) {
            DictionaryInitDto baseDictionary = new DictionaryInitDto();
            baseDictionary.setCddValue(String.valueOf(adminRoleDto.getId()));
            baseDictionary.setName(adminRoleDto.getName());
            roleTypes.add(baseDictionary);
        }
        return roleTypes;
    }

    public List<DictionaryInitDto> getDicList(String typeCode) {
        List<DictionaryInitDto> dist = redisService.getList(BASE_DICTIONARY_KEY + typeCode);
        if (dist != null && dist.size() > 0) {
            return dist;
        } else {
            List<DictionaryInitDto> dicResult = new ArrayList<>();
            if (TypeCodeEnum.SUYYXLK.getKey().equals(typeCode)) {
                dicResult = baseAppService.getForSelect();
            } else if (TypeCodeEnum.JSXLK.getKey().equals(typeCode)) {
                dicResult = coreRoletypeService.getForSelect(typeCode);
            } else if (TypeCodeEnum.GWXLK.getKey().equals(typeCode)) {
                dicResult = adminPositionService.getForSelect();
            } else {
                dicResult = baseDictionaryService.getInitByTypeCode(typeCode);
            }

            if (dicResult != null && dicResult.size() > 0) {
                redisService.setList(BASE_DICTIONARY_KEY + typeCode, dicResult,
                    KernelConstant.ONE_HOUR_EXPIRE * 2);
            }
            return dicResult;
        }
    }

    public Map<String, String> getDictionaryList(String typeCode) {
        Date now = new Date();
        if (expireTime == null || expireTime.before(now)) {
            dics = new HashMap<>();
            expireTime = new Date(now.getTime() + 60 * 60 * 1000);
        }
        Map<String, String> result = dics.get(typeCode);
        if (result == null || result.size() == 0) {
            List<DictionaryInitDto> list = getDicList(typeCode);
            result = list2Map(list);
            dics.put(typeCode, result);
        }
        return dics.get(typeCode);
    }

    /**
     * 获取反向字典map，
     * key  字典name ，value 字典value
     * @param typeCode    字典code
     * @return    查询结果Map
     */
    public Map<String, String> getRevertDictory(String typeCode) {
        Map<String, String> result = new HashMap<>();
        List<DictionaryInitDto> dictionaries = getDicList(typeCode);
        for (DictionaryInitDto dic : dictionaries) {
            result.put(dic.getName(), dic.getCddValue());
        }
        return result;
    }

    public Map<String, String> list2Map(List<DictionaryInitDto> list) {
        Map<String, String> result = new HashMap<>();
        for (DictionaryInitDto dictionary : list) {
            result.put(dictionary.getCddValue(), dictionary.getName());
        }
        return result;
    }

    /**
     * 列表字典翻译
     * @param list 需要翻译的列表对象
     * @param dicMap 需要翻译的字段和对应的code
     */
    public void translate(List list, Map<String, String> dicMap) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Object obj : list) {
            translateObj(obj, dicMap);
        }
    }

    /**
     * 字典翻译
     * @param obj 需要翻译的对象
     * @param dicMap 需要翻译的字段和对应的code
     */
    public void translateObj(Object obj, Map<String, String> dicMap) {
        if (obj == null) {
            return;
        }
        for (String field : dicMap.keySet()) {
            String objValue = getObjectValue(obj, field);
            if (StringUtils.isEmpty(objValue)) {
                continue;
            }
            String typeCode = dicMap.get(field);
            Map<String, String> dicMaps = getDictionaryList(typeCode);
            String value = dicMaps.get(objValue);
            setObjectValue(field, obj, value);
        }
    }

    /**
     * 字典翻译
     * @param obj 需要翻译的对象
     * @param field 对象的字段
     * @param typeCode 字典代码
     */
    public void translateObj(Object obj, String field, String typeCode) {
        if (obj == null) {
            return;
        }
        String objValue = getObjectValue(obj, field);
        if (StringUtils.isEmpty(objValue)) {
            return;
        }
        Map<String, String> dicMaps = getDictionaryList(typeCode);
        String value = dicMaps.get(objValue);
        setObjectValue(field, obj, value);
    }

    private String getObjectValue(Object obj, String field) {
        Object objectValue = getMethodValue(field, obj);
        String result = "";
        if (objectValue == null) {
            return "";
        }
        if (objectValue instanceof BigDecimal) {
            BigDecimal setScale = ((BigDecimal) objectValue).setScale(2, BigDecimal.ROUND_HALF_UP);
            return setScale.toString();
        }
        if (objectValue instanceof Date) {
            result = DateUtils.format((Date) objectValue, "yyyy-MM-dd");
        } else if (objectValue instanceof String) {
            result = (String) objectValue;
        } else if (objectValue instanceof Integer) {
            return objectValue + "";
        } else if (objectValue instanceof Double) {
            return objectValue + "";
        } else {
            result = objectValue.toString();
        }
        return result;
    }

    private void setObjectValue(String field, Object obj, Object value) {
        setMethodValue(field, obj, value);
    }

    /**
     * @param field
     * @param obj
     * @param args
     * @return return value
     */
    private static Object getMethodValue(String field, Object obj, Object... args) {
        Object resut = "";
        try {
            String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
            Method[] methods = obj.getClass().getMethods();
            if (methods.length <= 0) {
                return resut;
            }
            Method method = null;
            for (int i = 0, len = methods.length; i < len; i++) {
                if (methods[i].getName().equalsIgnoreCase(methodName)) {
                    method = methods[i];
                    break;
                }
            }
            if (method == null) {
                return resut;
            }
            resut = method.invoke(obj, args);
            if (resut == null) {
                resut = "";
            }
            return resut; //返回结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resut;
    }

    /**
     * 给obj属性赋值
     * @param field
     * @param obj
     * @param args
     * @return return value
     */
    private static void setMethodValue(String field, Object obj, Object args) {
        try {
            String methodName = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
            Method[] methods = obj.getClass().getMethods();
            if (methods.length <= 0) {
                return;
            }
            Method method = null;
            for (int i = 0, len = methods.length; i < len; i++) {
                if (methods[i].getName().equalsIgnoreCase(methodName)) {
                    method = methods[i];
                    break;
                }
            }
            if (method == null) {
                return;
            }
            method.invoke(obj, args);
            return; //返回结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * 公共获取树信息,
     * 只获取下一级，不分页
     * @param treeParam 树查询参数
     * @return    返回结果List
     */
    public List<TreeNode> getTree(TreeParam treeParam) {
        List<TreeNode> result = new ArrayList<>();
        if (TreeTypeEnum.MENU.getKey().equals(treeParam.getType())) {
            MenuTreeParam menuParam = (MenuTreeParam) MenuTreeParam.TO.apply(treeParam);
            menuParam.setAppId(Constants.ENT_APP_ID);
            result = sysMenuService.getMenuChildTree(menuParam);
            return result;
        } else if (TreeTypeEnum.ALL_MENU.getKey().equals(treeParam.getType())) {
            MenuTreeParam menuParam = (MenuTreeParam) MenuTreeParam.TO.apply(treeParam);
            menuParam.setAppId(Constants.ENT_APP_ID);
            result = sysMenuService.allMenutreeList(menuParam);
        } else if (TreeTypeEnum.POSITION.getKey().equals(treeParam.getType())) {
            result = adminPositionService.getChildTree(treeParam);
        } else if (TreeTypeEnum.SINGLE_POSITION.getKey().equals(treeParam.getType())) {
            result = adminPositionService.getSingleChildTree(treeParam);
        } else if (TreeTypeEnum.ALL_DEPT.getKey().equals(treeParam.getType())) {
            treeParam.setAppId(Constants.ENT_APP_ID);
            result = adminDeptService.allDepttreeList(treeParam);
        } else if (TreeTypeEnum.ROLE.getKey().equals(treeParam.getType())) {
            treeParam.setAppId(Constants.ENT_APP_ID);
            treeParam.setStatus("0");
            result = sysRoleService.getChildTree(treeParam);
        } else if (TreeTypeEnum.BASE_XZQH.getKey().equals(treeParam.getType())) {
            result = baseXzqhService.getXzqhChildren(treeParam);
        } else if (TreeTypeEnum.CORE_DEPTTYPE.getKey().equals(treeParam.getType())) {
            result = coreDepttypeService.getDeptTypeChildren(treeParam);
        } else if (TreeTypeEnum.CORE_ORGTYPE.getKey().equals(treeParam.getType())) {
            result = coreOrgtypeService.getOrgTypeChildren(treeParam);
        }
        return result;
    }

    /**
     * map转对象。避免循环取值赋值。
     * @param   params  参数
     * @param   clazz  对象类型
     * @return 转换后的对象
     */
    public Object mapToObj(Map<String, Object> params, Class clazz) {
        return JsonMapUtils.mapToObject(params, clazz);
    }

}
