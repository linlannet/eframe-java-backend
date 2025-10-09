/*
 * eframe-java-backend - JAVA开发的企业级后端框架，基于Springboot，采用支持 JAVA 1.8最高版本的framework、security，后端数据访问采用Mybatis框架，支持多种数据库一套代码适配，提供脚手架可快速生成Mapper等，借鉴若依框架，实现最基础的管理员、机构、角色、权限、分组、消息管理，为各类企业级应用提供框架支撑应用扩展。
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
let api = [];
const apiDocListSize = 5
api.push({
    name: 'default',
    order: '1',
    list: []
})
api.push({
    name: '平台通用接口API',
    order: '2',
    list: []
})
api[1].list.push({
    alias: 'ApiStatusMonitorController',
    order: '1',
    link: 'filename:apistatusmonitorcontroller.javadesc:平台当前应用的版本，用于验证进程服务是否正常',
    desc: 'Filename:ApiStatusMonitorController.javaDesc:平台当前应用的版本，用于验证进程服务是否正常',
    list: []
})
api[1].list[0].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/stage/getStatus.do',
    desc: '每次发版前，将版本号进行调整，以明确当前发布的版本和启动的版本是一致的',
});
api.push({
    name: '一体化平台接口API',
    order: '3',
    list: []
})
api[2].list.push({
    alias: 'AdminDeptOpController',
    order: '1',
    link: 'admindept控制域:系统机构部门增删改操作控制类',
    desc: 'AdminDept控制域:系统机构部门增删改操作控制类',
    list: []
})
api[2].list[0].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/dept/save.do',
    desc: '新增部门',
});
api[2].list[0].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/dept/update.do',
    desc: '修改部门',
});
api[2].list[0].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/dept/delete/{deptIds}.do',
    desc: '删除部门',
});
api[2].list[0].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/dept/disable/{id}.do',
    desc: '停用启用部门',
});
api[2].list.push({
    alias: 'AdminDeptEntryController',
    order: '2',
    link: 'admindept控制域:系统机构部门查询读取控制类',
    desc: 'AdminDept控制域:系统机构部门查询读取控制类',
    list: []
})
api[2].list[1].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/dept/list.do',
    desc: '获取部门列表',
});
api[2].list[1].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/dept/page.do',
    desc: '获取部门分页',
});
api[2].list[1].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/dept/list/exclude/{deptId}.do',
    desc: '查询部门列表（排除节点）',
});
api[2].list[1].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/dept/{deptId}.do',
    desc: '根据部门编号获取详细信息',
});
api[2].list[1].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/dept/tree.do',
    desc: '获取部门树',
});
api[2].list.push({
    alias: 'AdminLoginLogEntryController',
    order: '3',
    link: 'adminloginlog控制域:管理员登录日志查询读取控制类',
    desc: 'AdminLoginLog控制域:管理员登录日志查询读取控制类',
    list: []
})
api[2].list[2].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/loginlog/list.do',
    desc: '获取管理员登录日志列表',
});
api[2].list[2].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/loginlog/export.do',
    desc: '获取管理员登录日志列表',
});
api[2].list[2].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/loginlog/{infoIds}.do',
    desc: '删除管理员登录日志',
});
api[2].list[2].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/loginlog/clean.do',
    desc: '清理管理员登录日志',
});
api[2].list[2].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/loginlog/unlock/{username}.do',
    desc: '账户解锁',
});
api[2].list.push({
    alias: 'AdminUserOpController',
    order: '4',
    link: 'adminuser控制域:管理用户增删改操作控制类',
    desc: 'AdminUser控制域:管理用户增删改操作控制类',
    list: []
})
api[2].list[3].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/save.do',
    desc: 'AdminUserOperation.AdminUser数据操作逻辑，根据操作类型，执行新增操作.',
});
api[2].list[3].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/update.do',
    desc: 'AdminUserOperation.AdminUser数据操作逻辑，根据操作类型，执行修改操作.',
});
api[2].list[3].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/disable/{id}.do',
    desc: '停用启用用户',
});
api[2].list[3].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/resetpassword/{ids}.do',
    desc: '重置密码',
});
api[2].list[3].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/delete/{adminIds}.do',
    desc: '删除用户',
});
api[2].list[3].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/export.do',
    desc: '用户数据导出',
});
api[2].list[3].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/importData.do',
    desc: '用户数据导入',
});
api[2].list[3].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/importTemplate.do',
    desc: '用户导入模板下载',
});
api[2].list[3].list.push({
    order: '9',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/resetPwd.do',
    desc: '重置密码',
});
api[2].list[3].list.push({
    order: '10',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/changeStatus.do',
    desc: '用户状态修改',
});
api[2].list[3].list.push({
    order: '11',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/authRole/{adminId}.do',
    desc: '根据用户编号获取授权角色',
});
api[2].list[3].list.push({
    order: '12',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/authRole.do',
    desc: '用户授权角色',
});
api[2].list.push({
    alias: 'AdminUserEntryController',
    order: '5',
    link: 'adminuser控制域:管理用户查询读取控制类',
    desc: 'AdminUser控制域:管理用户查询读取控制类',
    list: []
})
api[2].list[4].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/list.do',
    desc: '获取用户列表',
});
api[2].list[4].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/;	https:/linlan.net/eframe_backend/api/admin/user/{adminId}.do',
    desc: '根据用户编号获取详细信息',
});
api[2].list[4].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/deptTree.do',
    desc: '获取用户部门树列表',
});
api[2].list.push({
    alias: 'BaseAppController',
    order: '6',
    link: 'app控制域:应用管理读写控制类',
    desc: 'App控制域:应用管理读写控制类',
    list: []
})
api[2].list[5].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/selectList.do',
    desc: '获取应用下拉列表',
});
api[2].list[5].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/list.do',
    desc: '获取应用列表',
});
api[2].list[5].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/export.do',
    desc: '应用列表导出',
});
api[2].list[5].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/{appId}.do',
    desc: '根据参数编号获取详细信息',
});
api[2].list[5].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/save.do',
    desc: '新增应用配置',
});
api[2].list[5].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/update.do',
    desc: '修改应用配置',
});
api[2].list[5].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/delete/{appIds}.do',
    desc: '删除应用配置',
});
api[2].list[5].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/init/{id}.do',
    desc: '应用初始化',
});
api[2].list[5].list.push({
    order: '9',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/refreshCache.do',
    desc: '刷新参数缓存',
});
api[2].list[5].list.push({
    order: '10',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/xzqh/list.do',
    desc: '顶级行政区划下拉框',
});
api[2].list[5].list.push({
    order: '11',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/app/organ/list.do',
    desc: '管理单位下拉框',
});
api[2].list.push({
    alias: 'BaseXzqhController',
    order: '7',
    link: 'basexzqh控制域:行政区划管理读写控制类',
    desc: 'BaseXzqh控制域:行政区划管理读写控制类',
    list: []
})
api[2].list[6].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/xzqh/list.do',
    desc: 'GetBaseXzqhlist.获取行政区划管理列表或分页,返回BaseXzqh对象.',
});
api[2].list[6].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/xzqh/export.do',
    desc: 'BaseXzqhOperation.BaseXzqh数据操作逻辑，导出操作.',
});
api[2].list[6].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/xzqh/{id}.do',
    desc: 'GetBaseXzqhbyid.主键获取行政区划管理详细信息.',
});
api[2].list[6].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/xzqh/save.do',
    desc: 'BaseXzqhOperation.新增行政区划管理数据操作逻辑，根据操作类型，执行新增操作.',
});
api[2].list[6].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/xzqh/update.do',
    desc: 'BaseXzqhOperation.修改行政区划管理数据操作逻辑，根据操作类型，执行修改操作.',
});
api[2].list[6].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/xzqh/delete/{ids}.do',
    desc: 'BaseXzqhOperation.删除行政区划管理数据操作逻辑，根据操作类型，执行删除操作.',
});
api[2].list.push({
    alias: 'CoreAccountController',
    order: '8',
    link: 'coreaccount控制域:平台账号信息读写控制类',
    desc: 'CoreAccount控制域:平台账号信息读写控制类',
    list: []
})
api[2].list[7].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/plat/account/list.do',
    desc: 'GetCoreAccountlist.获取平台账号信息列表或分页,返回CoreAccount对象.',
});
api[2].list[7].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/plat/account/getClientSecret.do',
    desc: '平台账户生成密钥对',
});
api[2].list[7].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/plat/account/getKeyParity.do',
    desc: '生成平台密钥对',
});
api[2].list[7].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/account/{id}.do',
    desc: 'GetCoreAccountbyid.主键获取平台账号信息详细信息.',
});
api[2].list[7].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/account/save.do',
    desc: 'CoreAccountOperation.新增平台账号信息数据操作逻辑，根据操作类型，执行新增操作.',
});
api[2].list[7].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/account/update.do',
    desc: 'CoreAccountOperation.修改平台账号信息数据操作逻辑，根据操作类型，执行修改操作.',
});
api[2].list[7].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/account/delete/{ids}.do',
    desc: 'CoreAccountOperation.删除平台账号信息数据操作逻辑，根据操作类型，执行删除操作.',
});
api[2].list.push({
    alias: 'CoreOrganController',
    order: '9',
    link: 'coreorgan控制域:系统机构表读写控制类',
    desc: 'CoreOrgan控制域:系统机构表读写控制类',
    list: []
})
api[2].list[8].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/organ/list.do',
    desc: 'GetCoreOrganlist.获取系统机构表列表或分页,返回CoreOrgan对象.',
});
api[2].list[8].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/organ/{id}.do',
    desc: 'GetCoreOrganbyid.主键获取系统机构表详细信息.',
});
api[2].list[8].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/organ/save.do',
    desc: 'CoreOrganOperation.新增系统机构表数据操作逻辑，根据操作类型，执行新增操作.',
});
api[2].list[8].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/organ/update.do',
    desc: 'CoreOrganOperation.修改系统机构表数据操作逻辑，根据操作类型，执行修改操作.',
});
api[2].list[8].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/organ/delete/{ids}.do',
    desc: 'CoreOrganOperation.删除系统机构表数据操作逻辑，根据操作类型，执行删除操作.',
});
api[2].list[8].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/organ/disable/{id}.do',
    desc: 'CoreOrganOperation.系统机构表数据操作逻辑，根据操作类型，执行停用启用操作.',
});
api[2].list.push({
    alias: 'CoreRighttypeController',
    order: '10',
    link: 'corerighttype控制域:权限分类读写控制类',
    desc: 'CoreRighttype控制域:权限分类读写控制类',
    list: []
})
api[2].list[9].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/righttype/list.do',
    desc: 'GetCoreRighttypelist.获取权限分类列表或分页,返回CoreRighttype对象.',
});
api[2].list[9].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/righttype/export.do',
    desc: 'CoreRighttypeOperation.CoreRighttype数据操作逻辑，导出操作.',
});
api[2].list[9].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/righttype/{id}.do',
    desc: 'GetCoreRighttypebyid.主键获取权限分类详细信息.',
});
api[2].list[9].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/righttype/save.do',
    desc: 'CoreRighttypeOperation.新增权限分类数据操作逻辑，根据操作类型，执行新增操作.',
});
api[2].list[9].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/righttype/update.do',
    desc: 'CoreRighttypeOperation.修改权限分类数据操作逻辑，根据操作类型，执行修改操作.',
});
api[2].list[9].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/righttype/delete/{ids}.do',
    desc: 'CoreRighttypeOperation.删除权限分类数据操作逻辑，根据操作类型，执行删除操作.',
});
api[2].list.push({
    alias: 'CoreRoletypeController',
    order: '11',
    link: 'coreroletype控制域:角色分类读写控制类',
    desc: 'CoreRoletype控制域:角色分类读写控制类',
    list: []
})
api[2].list[10].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/roletype/list.do',
    desc: 'GetCoreRoletypelist.获取角色分类列表或分页,返回CoreRoletype对象.',
});
api[2].list[10].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/roletype/export.do',
    desc: 'CoreRoletypeOperation.CoreRoletype数据操作逻辑，导出操作.',
});
api[2].list[10].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/roletype/{id}.do',
    desc: 'GetCoreRoletypebyid.主键获取角色分类详细信息.',
});
api[2].list[10].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/roletype/save.do',
    desc: 'CoreRoletypeOperation.新增角色分类数据操作逻辑，根据操作类型，执行新增操作.',
});
api[2].list[10].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/roletype/update.do',
    desc: 'CoreRoletypeOperation.修改角色分类数据操作逻辑，根据操作类型，执行修改操作.',
});
api[2].list[10].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/roletype/delete/{ids}.do',
    desc: 'CoreRoletypeOperation.删除角色分类数据操作逻辑，根据操作类型，执行删除操作.',
});
api[2].list.push({
    alias: 'CommFileController',
    order: '12',
    link: 'file控制域:公共文件管理读写控制类',
    desc: 'File控制域:公共文件管理读写控制类',
    list: []
})
api[2].list[11].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/list.do',
    desc: '获取资源存储清单列表',
});
api[2].list[11].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/export.do',
    desc: '资源存储清单导出',
});
api[2].list[11].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/info.do',
    desc: '根据编号获取文件详细信息',
});
api[2].list[11].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/save.do',
    desc: '新增文件',
});
api[2].list[11].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/update.do',
    desc: '修改文件',
});
api[2].list[11].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/delete.do',
    desc: '删除文件',
});
api[2].list[11].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/refreshCache.do',
    desc: '刷新参数缓存',
});
api[2].list[11].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/download.do',
    desc: '通用下载请求',
});
api[2].list[11].list.push({
    order: '9',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/upload.do',
    desc: '通用上传请求（单个）',
});
api[2].list[11].list.push({
    order: '10',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/uploads.do',
    desc: '通用上传请求（多个）',
});
api[2].list[11].list.push({
    order: '11',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/file/download/resource.do',
    desc: '本地资源通用下载',
});
api[2].list.push({
    alias: 'UserPresetController',
    order: '13',
    link: 'powerpreset控制域:_用户权限预置',
    desc: 'PowerPreset控制域:用户权限预置',
    list: []
})
api[2].list[12].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/preset/list.do',
    desc: '用户权限预置列表',
});
api[2].list[12].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/preset/export.do',
    desc: '根据用户权限预置导出',
});
api[2].list[12].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/preset/{configId}.do',
    desc: '根据用户权限预置获取详细信息',
});
api[2].list[12].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/preset/save.do',
    desc: '新增户权限预置',
});
api[2].list[12].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/preset/update.do',
    desc: '修改户权限预置',
});
api[2].list[12].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/preset/delete/{configIds}.do',
    desc: '删除户权限预置',
});
api[2].list[12].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/preset/refreshCache.do',
    desc: '刷新户权限预置缓存',
});
api[2].list.push({
    alias: 'PublicNoticeController',
    order: '14',
    link: 'publicnotice控制域:平台公共消息读写控制类',
    desc: 'PublicNotice控制域:平台公共消息读写控制类',
    list: []
})
api[2].list[13].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/list.do',
    desc: 'GetPublicNoticelist.获取平台公共消息列表或分页,返回PublicNotice对象.',
});
api[2].list[13].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/list/myself.do',
    desc: 'GetPublicNoticelist.获取所有信息列表分页',
});
api[2].list[13].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/export.do',
    desc: 'PublicNoticeOperation.PublicNotice数据操作逻辑，导出操作.',
});
api[2].list[13].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/{id}.do',
    desc: 'GetPublicNoticebyid.主键获取平台公共消息详细信息.',
});
api[2].list[13].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/save.do',
    desc: 'PublicNoticeOperation.新增平台公共消息数据操作逻辑，根据操作类型，执行新增操作.',
});
api[2].list[13].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/update.do',
    desc: 'PublicNoticeOperation.修改平台公共消息数据操作逻辑，根据操作类型，执行修改操作.',
});
api[2].list[13].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/delete/{ids}.do',
    desc: 'PublicNoticeOperation.删除平台公共消息数据操作逻辑，根据操作类型，执行删除操作.',
});
api[2].list[13].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/read/all.do',
    desc: 'PublicNoticeOperation.将当前账户的未读消息全部设置为已读.',
});
api[2].list[13].list.push({
    order: '9',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/read/{ids}.do',
    desc: 'PublicNoticeOperation.将当前账户的未读消息全部设置为已读.',
});
api[2].list[13].list.push({
    order: '10',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/unRead/{ids}.do',
    desc: 'PublicNoticeOperation.将指定的消息设置为未读状态.',
});
api[2].list[13].list.push({
    order: '11',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/notice/num.do',
    desc: 'PublicNoticeOperation..获取获取未读消息数量',
});
api[2].list.push({
    alias: 'PublicUnionMessageController',
    order: '15',
    link: 'publicunionmessage控制域:消息阅读读写控制类',
    desc: 'PublicUnionMessage控制域:消息阅读读写控制类',
    list: []
})
api[2].list[14].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/message/list.do',
    desc: 'GetPublicUnionMessagelist.获取消息阅读列表或分页,返回PublicUnionMessage对象.',
});
api[2].list[14].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/message/export.do',
    desc: 'PublicUnionMessageOperation.PublicUnionMessage数据操作逻辑，导出操作.',
});
api[2].list[14].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/message/{id}.do',
    desc: 'GetPublicUnionMessagebyid.主键获取消息阅读详细信息.',
});
api[2].list[14].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/message/save.do',
    desc: 'PublicUnionMessageOperation.新增消息阅读数据操作逻辑，根据操作类型，执行新增操作.',
});
api[2].list[14].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/message/update.do',
    desc: 'PublicUnionMessageOperation.修改消息阅读数据操作逻辑，根据操作类型，执行修改操作.',
});
api[2].list[14].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/message/delete/{ids}.do',
    desc: 'PublicUnionMessageOperation.删除消息阅读数据操作逻辑，根据操作类型，执行删除操作.',
});
api[2].list[14].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/message/read/{ids}/{status}.do',
    desc: 'PublicUnionMessageOperation.删除消息阅读数据操作逻辑，根据操作类型，执行删除操作.',
});
api[2].list.push({
    alias: 'PublicUnionTodoController',
    order: '16',
    link: 'publicuniontodo控制域:统一待办读写控制类',
    desc: 'PublicUnionTodo控制域:统一待办读写控制类',
    list: []
})
api[2].list[15].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/todo/list.do',
    desc: 'GetPublicUnionTodolist.获取统一待办列表或分页,返回PublicUnionTodo对象.',
});
api[2].list[15].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/todo/export.do',
    desc: 'PublicUnionTodoOperation.PublicUnionTodo数据操作逻辑，导出操作.',
});
api[2].list[15].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/todo/{id}.do',
    desc: 'GetPublicUnionTodobyid.主键获取统一待办详细信息.',
});
api[2].list[15].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/todo/save.do',
    desc: 'PublicUnionTodoOperation.新增统一待办数据操作逻辑，根据操作类型，执行新增操作.',
});
api[2].list[15].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/todo/update.do',
    desc: 'PublicUnionTodoOperation.修改统一待办数据操作逻辑，根据操作类型，执行修改操作.',
});
api[2].list[15].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/todo/delete/{ids}.do',
    desc: 'PublicUnionTodoOperation.删除统一待办数据操作逻辑，根据操作类型，执行删除操作.',
});
api[2].list.push({
    alias: 'ApiAdminUserV1Status',
    order: '17',
    link: '个人信息_业务处理',
    desc: '个人信息业务处理',
    list: []
})
api[2].list[16].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/profile.do',
    desc: '个人资料信息',
});
api[2].list[16].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/info.do',
    desc: '个人信息',
});
api[2].list[16].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/profile.do',
    desc: '修改用户个人信息',
});
api[2].list[16].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/updatePwd.do',
    desc: '个人重置密码',
});
api[2].list[16].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/user/imagePath.do',
    desc: '用户头像上传',
});
api[2].list.push({
    alias: 'BaseConfigWholeController',
    order: '18',
    link: '参数配置_信息操作处理',
    desc: '参数配置信息操作处理',
    list: []
})
api[2].list[17].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/configwhole/list.do',
    desc: '获取参数配置列表',
});
api[2].list[17].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/configwhole/export.do',
    desc: '参数配置导出',
});
api[2].list[17].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/configwhole/{configId}.do',
    desc: '根据参数编号获取详细信息',
});
api[2].list[17].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/configwhole/configKey/{configKey}.do',
    desc: '根据参数键名查询参数值',
});
api[2].list[17].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/configwhole/save.do',
    desc: '新增参数配置',
});
api[2].list[17].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/configwhole/update.do',
    desc: '修改参数配置',
});
api[2].list[17].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/configwhole/delete/{configIds}.do',
    desc: '删除参数配置',
});
api[2].list[17].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/configwhole/refreshCache.do',
    desc: '刷新参数缓存',
});
api[2].list.push({
    alias: 'UserOnlineController',
    order: '19',
    link: '在线用户监控',
    desc: '在线用户监控',
    list: []
})
api[2].list[18].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/online/list.do',
    desc: '获取在线用户列表',
});
api[2].list[18].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/online/{tokenId}.do',
    desc: '在线用户下线',
});
api[2].list.push({
    alias: 'BaseDicTypeController',
    order: '20',
    link: '字典类型信息',
    desc: '字典类型信息',
    list: []
})
api[2].list[19].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictype/list.do',
    desc: '获取字典类型列表',
});
api[2].list[19].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictype/export.do',
    desc: '字典类型导出',
});
api[2].list[19].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictype/{dictId}.do',
    desc: '查询字典类型详细',
});
api[2].list[19].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictype/save.do',
    desc: '新增字典类型',
});
api[2].list[19].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictype/update.do',
    desc: '修改字典类型',
});
api[2].list[19].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictype/delete/{dictIds}.do',
    desc: '删除字典类型',
});
api[2].list[19].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictype/refreshCache.do',
    desc: '刷新字典类型缓存',
});
api[2].list[19].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictype/option/select.do',
    desc: '获取字典选择框列表',
});
api[2].list.push({
    alias: 'SysPositionController',
    order: '21',
    link: '岗位信息操作处理',
    desc: '岗位信息操作处理',
    list: []
})
api[2].list[20].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/position/list.do',
    desc: '获取岗位列表',
});
api[2].list[20].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/position/export.do',
    desc: '岗位列表导出',
});
api[2].list[20].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/position/{postId}.do',
    desc: '根据岗位编号获取详细信息',
});
api[2].list[20].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/position/save.do',
    desc: '新增岗位',
});
api[2].list[20].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/position/update.do',
    desc: '修改岗位',
});
api[2].list[20].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/position/{positionIds}.do',
    desc: '删除岗位',
});
api[2].list[20].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/position/bind/{positionId}.do',
    desc: '绑定角色',
});
api[2].list[20].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/position/unbind/{positionId}.do',
    desc: '解绑角色',
});
api[2].list[20].list.push({
    order: '9',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/position/option/select.do',
    desc: '获取岗位选择框列表',
});
api[2].list.push({
    alias: 'CommLogController',
    order: '22',
    link: '操作日志记录',
    desc: '操作日志记录',
    list: []
})
api[2].list[21].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/commlog/list.do',
    desc: '查看全部日志列表',
});
api[2].list[21].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/commlog/export.do',
    desc: '操作日志导出',
});
api[2].list[21].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/commlog/{ids}.do',
    desc: '操作日志清理',
});
api[2].list.push({
    alias: 'BaseDictionaryController',
    order: '23',
    link: '数据字典信息',
    desc: '数据字典信息',
    list: []
})
api[2].list[22].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictionary/list.do',
    desc: '获取数据字典信息列表',
});
api[2].list[22].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictionary/export.do',
    desc: '数据字典导出',
});
api[2].list[22].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictionary/{dictId}.do',
    desc: '查询字典数据详细',
});
api[2].list[22].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictionary/type/{dictType}.do',
    desc: '根据字典类型查询字典数据信息',
});
api[2].list[22].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictionary/save.do',
    desc: '新增字典',
});
api[2].list[22].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictionary/update.do',
    desc: '修改保存字典',
});
api[2].list[22].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictionary/delete/{dictIds}.do',
    desc: '删除字典',
});
api[2].list[22].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/comm/tree.do',
    desc: '通用字典树获取接口',
});
api[2].list[22].list.push({
    order: '9',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/dictionary/tree.do',
    desc: '字典树获取',
});
api[2].list.push({
    alias: 'ServerInoController',
    order: '24',
    link: '服务器监控',
    desc: '服务器监控',
    list: []
})
api[2].list[23].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/server.do',
    desc: '获取服务器基本信息',
});
api[2].list.push({
    alias: 'SysRegisterController',
    order: '25',
    link: '注册验证',
    desc: '注册验证',
    list: []
})
api[2].list[24].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/register.do',
    desc: '系统用户注册',
});
api[2].list.push({
    alias: 'SysLoginController',
    order: '26',
    link: '登录验证',
    desc: '登录验证',
    list: []
})
api[2].list[25].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/login.do',
    desc: '登录方法',
});
api[2].list[25].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/appUserInfo.do',
    desc: '获取应用用户信息，作用于Work端登录之后进行用户基本信息获取',
});
api[2].list[25].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/appIndexInfo.do',
    desc: '获取应用首页信息，包括菜单含路由信息',
});
api[2].list[25].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/platLogin.do',
    desc: '内部应用，第三方应用登录方法，返回字段少的平台用户对象',
});
api[2].list[25].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/thirdOrgan/login.do',
    desc: '登录方法',
});
api[2].list[25].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/captcha/verify.do',
    desc: '校验验证码',
});
api[2].list.push({
    alias: 'CacheMonitorController',
    order: '27',
    link: '缓存监控',
    desc: '缓存监控',
    list: []
})
api[2].list[26].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/cache.do',
    desc: '获取缓存信息列表',
});
api[2].list[26].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/cache/getNames.do',
    desc: '通过名称前缀获取缓存信息列表',
});
api[2].list[26].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/cache/getKeys/{cacheName}.do',
    desc: '通过名称获取缓存信息列表',
});
api[2].list[26].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/cache/getValue/{cacheName}/{cacheKey}.do',
    desc: '通过名称获取缓存详情',
});
api[2].list[26].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/cache/clearCacheName/{cacheName}.do',
    desc: '通过名称前缀清理缓存',
});
api[2].list[26].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/cache/clearCacheKey/{cacheKey}.do',
    desc: '通过名称清理缓存',
});
api[2].list[26].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/monitor/cache/clearCacheAll.do',
    desc: '清理全部缓存',
});
api[2].list.push({
    alias: 'SysMenuController',
    order: '28',
    link: '菜单信息',
    desc: '菜单信息',
    list: []
})
api[2].list[27].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/list.do',
    desc: '获取菜单列表',
});
api[2].list[27].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/page.do',
    desc: '获取菜单分页',
});
api[2].list[27].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/{menuId}.do',
    desc: '根据菜单编号获取详细信息',
});
api[2].list[27].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/treeselect.do',
    desc: '获取菜单下拉树列表',
});
api[2].list[27].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/treeInit.do',
    desc: '获取菜单下拉初始树列表',
});
api[2].list[27].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/roleMenuTreeselect/{roleId}.do',
    desc: '加载对应角色菜单列表树',
});
api[2].list[27].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu.do',
    desc: '新增单个菜单',
});
api[2].list[27].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu.do',
    desc: '修改菜单',
});
api[2].list[27].list.push({
    order: '9',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/save.do',
    desc: '新增菜单及默认按钮',
});
api[2].list[27].list.push({
    order: '10',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/update.do',
    desc: '修改菜单及默认按钮',
});
api[2].list[27].list.push({
    order: '11',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/delete/{menuIds}.do',
    desc: '删除菜单',
});
api[2].list[27].list.push({
    order: '12',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/menu/disable/{id}.do',
    desc: '停用启用菜单',
});
api[2].list.push({
    alias: 'SysRoleController',
    order: '29',
    link: '角色信息',
    desc: '角色信息',
    list: []
})
api[2].list[28].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/list.do',
    desc: '获取角色列表',
});
api[2].list[28].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/export.do',
    desc: '角色信息导出',
});
api[2].list[28].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/{roleId}.do',
    desc: '根据角色编号获取详细信息',
});
api[2].list[28].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role.do',
    desc: '新增角色',
});
api[2].list[28].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role.do',
    desc: '修改保存角色',
});
api[2].list[28].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/save.do',
    desc: '新增角色及绑定菜单部门',
});
api[2].list[28].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/update.do',
    desc: '修改保存角色及绑定菜单部门',
});
api[2].list[28].list.push({
    order: '8',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/delete/{roleIds}.do',
    desc: '删除角色',
});
api[2].list[28].list.push({
    order: '9',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/disable/{roleId}.do',
    desc: '停用启用角色',
});
api[2].list[28].list.push({
    order: '10',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/bindMenu/{roleId}.do',
    desc: '角色绑定菜单',
});
api[2].list[28].list.push({
    order: '11',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/bindDept/{roleId}.do',
    desc: '角色绑定部门',
});
api[2].list[28].list.push({
    order: '12',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/option/select.do',
    desc: '获取角色选择框列表',
});
api[2].list[28].list.push({
    order: '13',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/authUser/allocatedList.do',
    desc: '查询已分配用户角色列表',
});
api[2].list[28].list.push({
    order: '14',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/authUser/unallocatedList.do',
    desc: '查询未分配用户角色列表',
});
api[2].list[28].list.push({
    order: '15',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/authUser/cancel.do',
    desc: '取消授权用户',
});
api[2].list[28].list.push({
    order: '16',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/authUser/cancelAll.do',
    desc: '批量取消授权用户',
});
api[2].list[28].list.push({
    order: '17',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/authUser/selectAll.do',
    desc: '批量选择用户授权',
});
api[2].list[28].list.push({
    order: '18',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/role/deptTree/{roleId}.do',
    desc: '获取对应角色部门树列表',
});
api[2].list.push({
    alias: 'BaseConfigPartsController',
    order: '30',
    link: '键值配置_信息操作处理',
    desc: '键值配置信息操作处理',
    list: []
})
api[2].list[29].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/parts/list.do',
    desc: '获取键值配置列表',
});
api[2].list[29].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/parts/export.do',
    desc: '键值配置导出',
});
api[2].list[29].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/parts/{cfgKey}.do',
    desc: '根据参数编号获取详细信息',
});
api[2].list[29].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/parts/save.do',
    desc: '新增参数配置',
});
api[2].list[29].list.push({
    order: '5',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/parts/update.do',
    desc: '修改参数配置',
});
api[2].list[29].list.push({
    order: '6',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/parts/delete/{cfgKeys}.do',
    desc: '删除参数配置',
});
api[2].list[29].list.push({
    order: '7',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/system/config/refreshCache.do',
    desc: '刷新参数缓存',
});
api[2].list.push({
    alias: 'SysIndexController',
    order: '31',
    link: '首页入口',
    desc: '首页入口',
    list: []
})
api[2].list[30].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/.do',
    desc: '访问首页，提示语',
});
api[2].list[30].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/index/application.do',
    desc: '工作台应用支撑统计',
});
api[2].list[30].list.push({
    order: '3',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/index/element.do',
    desc: '工作台要素支撑统计',
});
api[2].list[30].list.push({
    order: '4',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/admin/index/manage.do',
    desc: '工作台管理支撑统计',
});
api[2].list.push({
    alias: 'CaptchaEntryController',
    order: '32',
    link: '验证码读取操作处理',
    desc: '验证码读取操作处理',
    list: []
})
api[2].list[31].list.push({
    order: '1',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/open/captcha/get.do',
    desc: '获取验证码',
});
api[2].list[31].list.push({
    order: '2',
    deprecated: 'false',
    url: 'https://linlan.net/eframe_backend/api/open/message/captcha/get.do',
    desc: '获取消息验证码',
});
api.push({
    name: '错误码列表',
    order: '4',
    list: []
})
api.push({
    name: '数据字典',
    order: '5',
    list: []
})
document.onkeydown = keyDownSearch;
function keyDownSearch(e) {
    const theEvent = e;
    const code = theEvent.keyCode || theEvent.which || theEvent.charCode;
    if (code == 13) {
        const search = document.getElementById('search');
        const searchValue = search.value;
        let searchGroup = [];
        for (let i = 0; i < api.length; i++) {

            let apiGroup = api[i];

            let searchArr = [];
            for (let i = 0; i < apiGroup.list.length; i++) {
                let apiData = apiGroup.list[i];
                const desc = apiData.desc;
                if (desc.indexOf(searchValue) > -1) {
                    searchArr.push({
                        order: apiData.order,
                        desc: apiData.desc,
                        link: apiData.link,
                        list: apiData.list
                    });
                } else {
                    let methodList = apiData.list || [];
                    let methodListTemp = [];
                    for (let j = 0; j < methodList.length; j++) {
                        const methodData = methodList[j];
                        const methodDesc = methodData.desc;
                        if (methodDesc.indexOf(searchValue) > -1) {
                            methodListTemp.push(methodData);
                            break;
                        }
                    }
                    if (methodListTemp.length > 0) {
                        const data = {
                            order: apiData.order,
                            desc: apiData.desc,
                            link: apiData.link,
                            list: methodListTemp
                        };
                        searchArr.push(data);
                    }
                }
            }
            if (apiGroup.name.indexOf(searchValue) > -1) {
                searchGroup.push({
                    name: apiGroup.name,
                    order: apiGroup.order,
                    list: searchArr
                });
                continue;
            }
            if (searchArr.length === 0) {
                continue;
            }
            searchGroup.push({
                name: apiGroup.name,
                order: apiGroup.order,
                list: searchArr
            });
        }
        let html;
        if (searchValue == '') {
            const liClass = "";
            const display = "display: none";
            html = buildAccordion(api,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        } else {
            const liClass = "open";
            const display = "display: block";
            html = buildAccordion(searchGroup,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        }
        const Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;
            const links = this.el.find('.dd');
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown);
        };
        Accordion.prototype.dropdown = function (e) {
            const $el = e.data.el;
            $this = $(this), $next = $this.next();
            $next.slideToggle();
            $this.parent().toggleClass('open');
            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp("20").parent().removeClass('open');
            }
        };
        new Accordion($('#accordion'), false);
    }
}

function buildAccordion(apiGroups, liClass, display) {
    let html = "";
    let doc;
    if (apiGroups.length > 0) {
         if (apiDocListSize == 1) {
            let apiData = apiGroups[0].list;
            for (let j = 0; j < apiData.length; j++) {
                html += '<li class="'+liClass+'">';
                html += '<a class="dd" href="#_' + apiData[j].link + '">' + apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
                html += '<ul class="sectlevel2" style="'+display+'">';
                doc = apiData[j].list;
                for (let m = 0; m < doc.length; m++) {
                    let spanString;
                    if (doc[m].deprecated == 'true') {
                        spanString='<span class="line-through">';
                    } else {
                        spanString='<span>';
                    }
                    html += '<li><a href="#_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].href + '">' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + spanString + doc[m].desc + '<span></a> </li>';
                }
                html += '</ul>';
                html += '</li>';
            }
        } else {
            for (let i = 0; i < apiGroups.length; i++) {
                let apiGroup = apiGroups[i];
                html += '<li class="'+liClass+'">';
                html += '<a class="dd" href="#_' + apiGroup.name + '">' + apiGroup.order + '.&nbsp;' + apiGroup.name + '</a>';
                html += '<ul class="sectlevel1">';

                let apiData = apiGroup.list;
                for (let j = 0; j < apiData.length; j++) {
                    html += '<li class="'+liClass+'">';
                    html += '<a class="dd" href="#_'+apiGroup.order+'_'+ apiData[j].order + '_'+ apiData[j].link + '">' +apiGroup.order+'.'+ apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
                    html += '<ul class="sectlevel2" style="'+display+'">';
                    doc = apiData[j].list;
                    for (let m = 0; m < doc.length; m++) {
                       let spanString;
                       if (doc[m].deprecated == 'true') {
                           spanString='<span class="line-through">';
                       } else {
                           spanString='<span>';
                       }
                       html += '<li><a href="#_'+apiGroup.order+'_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].desc + '">'+apiGroup.order+'.' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + spanString + doc[m].desc + '<span></a> </li>';
                   }
                    html += '</ul>';
                    html += '</li>';
                }

                html += '</ul>';
                html += '</li>';
            }
        }
    }
    return html;
}