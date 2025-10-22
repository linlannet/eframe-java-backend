# ent-frame
Version |  Update Time  | Status | Author |  Description
---|---|---|---|---
1.0|2025-08-24 10:30|update|Linlan|desc



# default
# 平台通用接口API
## 平台当前监控状态
### 每次发版前，将版本号进行调整，以明确当前发布的版本和启动的版本是一致的
**URL:** https://linlan.net/eframe_backend/api/stage/getStatus.do

**Type:** GET

**Author:** Linlan
CreateTime:12/19/17 9:00 PM

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 每次发版前，将版本号进行调整，以明确当前发布的版本和启动的版本是一致的

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
any object|object|any object.|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/stage/getStatus.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─any object|object|any object.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "mapKey": {
      "waring": "You may use java.util.Object for Map value; doc-generate can't be handle."
    }
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

# 一体化平台接口API
## 个人信息业务处理
### 个人资料信息
**URL:** https://linlan.net/eframe_backend/api/admin/user/profile.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 个人资料信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/profile.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─user|object|当前用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─password|string|密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─authorities|array|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userId|string|用户UUID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|所属应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|用户机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─token|string|登录令牌|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─viewName|string|昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─needChangePassword|boolean|需要修改密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─email|string|邮箱|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mobile|string|手机号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|头像URL|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginCount|int32|登录次数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginIp|string|上次登录IP|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastUpdatePasswordTime|string|最后修改密码时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─expireTime|string|过期时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginTime|string|登录时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userType|string|用户类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuperAdmin|boolean|是否超级管理员|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginBrowse|string|登录的浏览器|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginOs|string|登录的OS|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─perms|array|权限列表|-
└─roleGroup|string|角色组|-
└─positionGroup|string|岗位组|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "user": {
      "password": "psrnie",
      "username": "merle.larkin",
      "authorities": [
        {
          "object": "any object"
        }
      ],
      "userId": "172",
      "appId": "172",
      "deptId": 700,
      "organId": "172",
      "token": "j0dvum",
      "viewName": "merle.larkin",
      "needChangePassword": true,
      "email": "vivian.streich@hotmail.com",
      "mobile": "(415) 540-6962",
      "imagePath": "w3cs79",
      "loginCount": 258,
      "loginIp": "137.119.212.174",
      "lastUpdatePasswordTime": "2025-10-20 18:25:57",
      "lastTime": "2025-10-20 18:25:57",
      "foreignId": "172",
      "expireTime": "2025-10-20 18:25:57",
      "loginTime": "2025-10-20 18:25:57",
      "userType": "97jicz",
      "isSuperAdmin": true,
      "loginBrowse": "nu52qh",
      "loginOs": "1cw7az",
      "perms": [
        "5oyysd"
      ]
    },
    "roleGroup": "2pnu4o",
    "positionGroup": "ctenby"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 个人信息
**URL:** https://linlan.net/eframe_backend/api/admin/user/info.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 个人信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/info.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|用户LID|-
└─userId|string|用户UUID|-
└─deptId|int64|部门ID|-
└─deptName|string|部门名称|-
└─organId|string|机构ID|-
└─organName|string|机构名称|-
└─name|string|人员姓名|-
└─username|string|用户账号|-
└─nickName|string|用户昵称|-
└─email|string|用户邮箱|-
└─mobile|string|手机号码|-
└─imagePath|string|用户头像|-
└─password|string|密码|-
└─isSuperAdmin|boolean|是否超级管理员|-
└─isAuditAdmin|boolean|是否审计只读管理员|-
└─isSelfAdmin|boolean|是否只管理自己的数据|-
└─status|int32|帐号状态（0未生效 1正常）|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|-
└─lastLoginIp|string|最后登录IP|-
└─lastLoginTime|string|最后登录时间|-
└─description|string|备注,办公地址|-
└─dept|object|部门对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|-
└─roles|array|角色对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|-
└─roleIds|array|角色组|-
└─positionIds|array|岗位组|-
└─roleId|int64|角色ID|-
└─userRoleList|array|角色集合|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|-
└─code|string|验证码|-
└─uuid|string|uuid标识|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:57",
    "lastTime": "2025-10-20 18:25:57",
    "id": 38,
    "userId": "172",
    "deptId": 527,
    "deptName": "merle.larkin",
    "organId": "172",
    "organName": "merle.larkin",
    "name": "merle.larkin",
    "username": "merle.larkin",
    "nickName": "renna.dibbert",
    "email": "vivian.streich@hotmail.com",
    "mobile": "(415) 540-6962",
    "imagePath": "yt9igo",
    "password": "hh4qwf",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 609,
    "delFlag": 5,
    "lastLoginIp": "137.119.212.174",
    "lastLoginTime": "2025-10-20 18:25:57",
    "description": "feb3u7",
    "dept": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:57",
      "lastTime": "2025-10-20 18:25:57",
      "id": 16,
      "organId": "172",
      "parentId": 932,
      "appId": "172",
      "depttypeId": 170,
      "foreignId": "172",
      "createType": 413,
      "type": "w5t9cl",
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "areaCode": "81486",
      "organLeader": "onuo2s",
      "leaderId": "172",
      "leaderMobile": "(415) 540-6962",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "81486",
      "imagePath": "s4b9rl",
      "priority": 734,
      "status": 779,
      "delFlag": 5,
      "description": "r887dc",
      "spare1": "mmuodd",
      "spare2": "s8ihia",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:57",
        "lastTime": "2025-10-20 18:25:57",
        "id": 429,
        "roletypeId": "172",
        "appId": "172",
        "name": "merle.larkin",
        "code": "81486",
        "priority": 278,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 347,
        "description": "h98uxp",
        "areaType": "1tt9gj"
      }
    ],
    "roleIds": [
      921
    ],
    "positionIds": [
      "apb65v"
    ],
    "roleId": 69,
    "userRoleList": [
      {
        "id": 124,
        "deptId": 215,
        "deptName": "merle.larkin",
        "organId": "172",
        "organName": "merle.larkin",
        "roleId": 58,
        "roleName": "merle.larkin",
        "adminId": 339
      }
    ],
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改用户个人信息
**URL:** https://linlan.net/eframe_backend/api/admin/user/profile.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改用户个人信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|用户LID|false|-
└─userId|string|用户UUID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─name|string|人员姓名|false|-
└─username|string|用户账号|false|-
└─nickName|string|用户昵称|false|-
└─email|string|用户邮箱|false|-
└─mobile|string|手机号码|false|-
└─imagePath|string|用户头像|false|-
└─password|string|密码|false|-
└─isSuperAdmin|boolean|是否超级管理员|false|-
└─isAuditAdmin|boolean|是否审计只读管理员|false|-
└─isSelfAdmin|boolean|是否只管理自己的数据|false|-
└─status|int32|帐号状态（0未生效 1正常）|false|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
└─lastLoginIp|string|最后登录IP|false|-
└─lastLoginTime|string|最后登录时间|false|-
└─description|string|备注,办公地址|false|-
└─dept|object|部门对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|false|-
└─roles|array|角色对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|false|-
└─roleIds|array|角色组|false|-
└─positionIds|array|岗位组|false|-
└─roleId|int64|角色ID|false|-
└─userRoleList|array|角色集合|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|false|-
└─code|string|验证码|false|-
└─uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/profile.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:57",
    "lastTime": "2025-10-20 18:25:57",
    "id": 401,
    "userId": "172",
    "deptId": 22,
    "deptName": "merle.larkin",
    "organId": "172",
    "organName": "merle.larkin",
    "name": "merle.larkin",
    "username": "merle.larkin",
    "nickName": "renna.dibbert",
    "email": "vivian.streich@hotmail.com",
    "mobile": "(415) 540-6962",
    "imagePath": "1i0vpy",
    "password": "yrh5v7",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 281,
    "delFlag": 5,
    "lastLoginIp": "137.119.212.174",
    "lastLoginTime": "2025-10-20 18:25:57",
    "description": "tttz5o",
    "dept": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:57",
      "lastTime": "2025-10-20 18:25:57",
      "id": 628,
      "organId": "172",
      "parentId": 37,
      "appId": "172",
      "depttypeId": 632,
      "foreignId": "172",
      "createType": 217,
      "type": "29yjcg",
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "areaCode": "81486",
      "organLeader": "kw6dnq",
      "leaderId": "172",
      "leaderMobile": "(415) 540-6962",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "81486",
      "imagePath": "ypzr9l",
      "priority": 791,
      "status": 866,
      "delFlag": 5,
      "description": "5vgp6t",
      "spare1": "ojlb4x",
      "spare2": "ndxj2j",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:57",
        "lastTime": "2025-10-20 18:25:57",
        "id": 567,
        "roletypeId": "172",
        "appId": "172",
        "name": "merle.larkin",
        "code": "81486",
        "priority": 886,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 153,
        "description": "um2loi",
        "areaType": "gybwcv"
      }
    ],
    "roleIds": [
      180
    ],
    "positionIds": [
      "rfzl0u"
    ],
    "roleId": 202,
    "userRoleList": [
      {
        "id": 334,
        "deptId": 376,
        "deptName": "merle.larkin",
        "organId": "172",
        "organName": "merle.larkin",
        "roleId": 808,
        "roleName": "merle.larkin",
        "adminId": 104
      }
    ],
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": true,
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 个人重置密码
**URL:** https://linlan.net/eframe_backend/api/admin/user/updatePwd.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 个人重置密码

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─oldPassword|string|旧密码|false|-
└─newPassword|string|新密码|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/updatePwd.do --data '{
  "data": {
    "oldPassword": "zp0tmo",
    "newPassword": "n3x96c"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "waring": "You may have used non-display generics."
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 用户头像上传
**URL:** https://linlan.net/eframe_backend/api/admin/user/imagePath.do

**Type:** POST

**Author:** Linlan

**Content-Type:** multipart/form-data

**Description:** 用户头像上传

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
file|file| 文件|true|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: multipart/form-data' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/imagePath.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─imageUrl|string|角色组|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "imageUrl": "www.ben-grant.info"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 公共文件管理读写控制类
### 获取资源存储清单列表
**URL:** https://linlan.net/eframe_backend/api/system/file/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取资源存储清单列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
resclassId|string|资源种类ID|false|-
appId|string|应用ID|false|-
fileName|string|文件名称|false|-
fileIsvalid|boolean|是否有效，0无效1有效|false|-
refId|string|参考ID|false|-
refType|string|类名称|false|-
fileSize|int64|文件大小，单位KB|false|-
fileExtension|string|文件扩展名|false|-
key|string|关键字|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/list.do?key=zz6omw&page=1&fileIsvalid=true&fileSize=998&q=6ppw34&fileExtension=kpj5lg&resclassId=172&limit=10&endTime=2025-10-20 18:20:52&refId=172&orderBy=133&fileName=merle.larkin&appId=172&startTime=2025-10-20 18:20:52&refType=ih8bfd
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|文件路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─resclassId|string|资源种类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─fileName|string|文件名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─fileIsvalid|boolean|是否有效|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─fileExtension|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ids|array|数组|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 342,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "id": "172",
        "resclassId": "172",
        "fileName": "merle.larkin",
        "fileIsvalid": true,
        "createTime": "2025-10-20 18:26:03",
        "fileExtension": "11z18g",
        "ids": [
          "ngo9eb"
        ]
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 资源存储清单导出
**URL:** https://linlan.net/eframe_backend/api/system/file/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 资源存储清单导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
resclassId|string|资源种类ID|false|-
appId|string|应用ID|false|-
fileName|string|文件名称|false|-
fileIsvalid|boolean|是否有效，0无效1有效|false|-
refId|string|参考ID|false|-
refType|string|类名称|false|-
fileSize|int64|文件大小，单位KB|false|-
fileExtension|string|文件扩展名|false|-
key|string|关键字|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/export.do --data 'resclassId=172&page=1&refType=b5m2g9&fileSize=216&limit=10&key=nj8vej&appId=172&fileExtension=wgx5jo&q=s5szm2&orderBy=446&fileName=merle.larkin&fileIsvalid=true&startTime=2025-10-20 18:20:52&refId=172&endTime=2025-10-20 18:20:52'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "bazczz",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据编号获取文件详细信息
**URL:** https://linlan.net/eframe_backend/api/system/file/info.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据编号获取文件详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|   主键ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/info.do?id=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─id|string|文件路径|-
└─resclassId|string|资源种类ID|-
└─fileName|string|文件名称|-
└─fileIsvalid|boolean|是否有效|-
└─createTime|string|创建时间|-
└─fileExtension|string|创建时间|-
└─ids|array|数组|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "id": "172",
    "resclassId": "172",
    "fileName": "merle.larkin",
    "fileIsvalid": true,
    "createTime": "2025-10-20 18:26:03",
    "fileExtension": "5vh33x",
    "ids": [
      "ww09li"
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增文件
**URL:** https://linlan.net/eframe_backend/api/system/file/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/json; charset=utf-8

**Description:** 新增文件

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─id|string|文件路径|false|-
└─resclassId|string|资源种类ID|false|-
└─fileName|string|文件名称|false|-
└─fileIsvalid|boolean|是否有效|false|-
└─createTime|string|创建时间|false|-
└─fileExtension|string|创建时间|false|-
└─ids|array|数组|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/save.do --data '{
  "data": {
    "id": "172",
    "resclassId": "172",
    "fileName": "merle.larkin",
    "fileIsvalid": true,
    "createTime": "2025-10-20 18:26:04",
    "fileExtension": "khpov6",
    "ids": [
      "3vm2d7"
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "841y67",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改文件
**URL:** https://linlan.net/eframe_backend/api/system/file/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/json; charset=utf-8

**Description:** 修改文件

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─id|string|文件路径|false|-
└─resclassId|string|资源种类ID|false|-
└─fileName|string|文件名称|false|-
└─fileIsvalid|boolean|是否有效|false|-
└─createTime|string|创建时间|false|-
└─fileExtension|string|创建时间|false|-
└─ids|array|数组|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/update.do --data '{
  "data": {
    "id": "172",
    "resclassId": "172",
    "fileName": "merle.larkin",
    "fileIsvalid": true,
    "createTime": "2025-10-20 18:26:04",
    "fileExtension": "w1jxb6",
    "ids": [
      "xi6ipo"
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "2bmq1k",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除文件
**URL:** https://linlan.net/eframe_backend/api/system/file/delete.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/json; charset=utf-8

**Description:** 删除文件

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─id|string|文件路径|false|-
└─resclassId|string|资源种类ID|false|-
└─fileName|string|文件名称|false|-
└─fileIsvalid|boolean|是否有效|false|-
└─createTime|string|创建时间|false|-
└─fileExtension|string|创建时间|false|-
└─ids|array|数组|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/delete.do --data '{
  "data": {
    "id": "172",
    "resclassId": "172",
    "fileName": "merle.larkin",
    "fileIsvalid": true,
    "createTime": "2025-10-20 18:26:04",
    "fileExtension": "4d83tj",
    "ids": [
      "gh80ol"
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "1io9xx",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 刷新参数缓存
**URL:** https://linlan.net/eframe_backend/api/system/file/refreshCache.do

**Type:** DELETE

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 刷新参数缓存

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/refreshCache.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "rftw5r",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 通用下载请求
**URL:** https://linlan.net/eframe_backend/api/system/file/download.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 通用下载请求

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
fileName|string|文件名称|false|-
delete|boolean|是否删除|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download.do?fileName=merle.larkin&delete=true
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "l1zfma",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 通用上传请求（单个）
**URL:** https://linlan.net/eframe_backend/api/system/file/upload.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 通用上传请求（单个）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/upload.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─originFilename|string|原文件名|-
└─filename|string|保存文件名|-
└─fileType|string|文件类型|-
└─fileUrl|string|保存路径|-
└─fileHttpUrl|string|保存路径，对外使用的Http或Https路径|-
└─statusCode|string|是否上传成功|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "originFilename": "merle.larkin",
    "filename": "merle.larkin",
    "fileType": "6aup5y",
    "fileUrl": "www.ben-grant.info",
    "fileHttpUrl": "www.ben-grant.info",
    "statusCode": "81486"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 通用上传请求（多个）
**URL:** https://linlan.net/eframe_backend/api/system/file/uploads.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** multipart/form-data

**Description:** 通用上传请求（多个）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
files|file|文件(array of file)|true|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: multipart/form-data' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/uploads.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─originFilename|string|原文件名|-
└─filename|string|保存文件名|-
└─fileType|string|文件类型|-
└─fileUrl|string|保存路径|-
└─fileHttpUrl|string|保存路径，对外使用的Http或Https路径|-
└─statusCode|string|是否上传成功|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "originFilename": "merle.larkin",
      "filename": "merle.larkin",
      "fileType": "wu94z7",
      "fileUrl": "www.ben-grant.info",
      "fileHttpUrl": "www.ben-grant.info",
      "statusCode": "81486"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 本地资源通用下载
**URL:** https://linlan.net/eframe_backend/api/system/file/download/resource.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 本地资源通用下载

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
resource|string|资源文件路径|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download/resource.do?resource=su1pwa
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ceipw4",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 参数配置信息操作处理
### 获取参数配置列表
**URL:** https://linlan.net/eframe_backend/api/system/configwhole/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取参数配置列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
configKey|string|参数键名|false|-
configValue|string|参数键值|false|-
isDisabled|boolean|状态|false|-
remark|string|描述|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/list.do?configValue=sv6gos&limit=10&q=wu6k6r&orderBy=645&endTime=2025-10-20 18:20:52&remark=p9xoz9&page=1&startTime=2025-10-20 18:20:52&configKey=hab3d9&isDisabled=true
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─configId|string|参数主键|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─configKey|string|参数键名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─configValue|string|参数键值|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|状态|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 700,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "configId": "172",
        "configKey": "s0wwln",
        "configValue": "1jdpki",
        "isDisabled": true,
        "remark": "sxruzp"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 参数配置导出
**URL:** https://linlan.net/eframe_backend/api/system/configwhole/export.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 参数配置导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
configKey|string|参数键名|false|-
configValue|string|参数键值|false|-
isDisabled|boolean|状态|false|-
remark|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/export.do --data 'isDisabled=true&q=fh1c0u&limit=10&startTime=2025-10-20 18:20:52&remark=buh8ue&configKey=xgsbsw&orderBy=972&configValue=fubcmh&endTime=2025-10-20 18:20:52&page=1'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "cgleja",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据参数编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/system/configwhole/{configId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据参数编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
configId|string|   配置ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/172.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─configId|string|参数主键|-
└─configKey|string|参数键名|-
└─configValue|string|参数键值|-
└─isDisabled|boolean|状态|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "configId": "172",
    "configKey": "50r1p1",
    "configValue": "jsszfk",
    "isDisabled": true,
    "remark": "oj76w7"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据参数键名查询参数值
**URL:** https://linlan.net/eframe_backend/api/system/configwhole/configKey/{configKey}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据参数键名查询参数值

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
configKey|string|    键值Key|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/configKey/41447l.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─configId|string|参数主键|-
└─configKey|string|参数键名|-
└─configValue|string|参数键值|-
└─isDisabled|boolean|状态|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "configId": "172",
    "configKey": "uhpy34",
    "configValue": "9kwt0m",
    "isDisabled": true,
    "remark": "kmmg15"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增参数配置
**URL:** https://linlan.net/eframe_backend/api/system/configwhole/save.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增参数配置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─configId|string|参数主键|false|-
└─configKey|string|参数键名|false|-
└─configValue|string|参数键值|false|-
└─isDisabled|boolean|状态|false|-
└─remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/save.do --data '{
  "data": {
    "configId": "172",
    "configKey": "2yo5eb",
    "configValue": "8agu6i",
    "isDisabled": true,
    "remark": "wgwizn"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ausn4c",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改参数配置
**URL:** https://linlan.net/eframe_backend/api/system/configwhole/update.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改参数配置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─configId|string|参数主键|false|-
└─configKey|string|参数键名|false|-
└─configValue|string|参数键值|false|-
└─isDisabled|boolean|状态|false|-
└─remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/update.do --data '{
  "data": {
    "configId": "172",
    "configKey": "5e780d",
    "configValue": "bdpv7m",
    "isDisabled": true,
    "remark": "cwvlr6"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "qwfg5t",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除参数配置
**URL:** https://linlan.net/eframe_backend/api/system/configwhole/delete/{configIds}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除参数配置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
configIds|array|   配置Ids,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "mzuhuq",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 刷新参数缓存
**URL:** https://linlan.net/eframe_backend/api/system/configwhole/refreshCache.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 刷新参数缓存

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/refreshCache.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "79r1n8",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 在线用户监控
### 获取在线用户列表
**URL:** https://linlan.net/eframe_backend/api/monitor/online/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取在线用户列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ipaddr|string|   IP地址|false|-
username|string| 用户名|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/list.do?username=merle.larkin&ipaddr=0bssbz
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─tokenId|string|会话编号|-
└─deptName|string|部门名称|-
└─username|string|用户名称|-
└─ipaddr|string|登录IP地址|-
└─loginLocation|string|登录地址|-
└─browser|string|浏览器类型|-
└─os|string|操作系统|-
└─loginTime|int64|登录时间|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "tokenId": "172",
      "deptName": "merle.larkin",
      "username": "merle.larkin",
      "ipaddr": "tv82xt",
      "loginLocation": "minmhr",
      "browser": "exrfix",
      "os": "iu1y1c",
      "loginTime": 1760955652792
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 在线用户下线
**URL:** https://linlan.net/eframe_backend/api/monitor/online/{tokenId}.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 在线用户下线

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tokenId|string|  token令牌|true|-

**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/172.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3yl4pb",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 基础用户扩展信息读写控制类
### Get BaseUserExt list. 获取基础用户扩展信息列表或分页, 返回BaseUserExt对象.
**URL:** https://linlan.net/eframe_backend/api/third/baseuserext/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get BaseUserExt list. 获取基础用户扩展信息列表或分页, 返回BaseUserExt对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
nickname|string|用户昵称|false|-
name|string|真实姓名，加密的姓名|false|-
idNum|string|身份证号码，加密的身份证号码|false|-
idMobile|string|电话|false|-
idType|string|证件类型|false|-
namePy|string|姓名全拼|false|-
sname|string|姓名缩写，外部输入填写的姓名|false|-
nameEn|string|姓名英文|false|-
searchCode|string|查询码，名称的拼音首字母|false|-
sex|string|性别GB_XBDM|false|-
birthday|string|出生日期|false|-
postCode|string|家庭邮政编码|false|-
address|string|地址|false|-
nativePlace|string|籍贯GB_XZQHDM_SHENG|false|-
familyAddress|string|家庭地址|false|-
homeTel|string|住宅电话|false|-
qqNo|string|QQ号码|false|-
weixinId|string|微信用户名|false|-
spareMobile|string|备用手机，紧急手机|false|-
mobileConfirm|boolean|手机是否验证|false|-
emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|false|-
keywords|string|关键字|false|-
intro|string|个人介绍|false|-
comefrom|string|来自|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
spare3|string|备用3|false|-
spare4|string|备用4|false|-
ids|array|id集合|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuserext/list.do?spare4=40tbib&ids=k67ppr&ids=k67ppr&qqNo=q96edd&page=1&namePy=mpvyl6&keywords=823cpq&nameEn=vn3t5g&spare1=wc848k&spare2=oqkeb3&endTime=2025-10-20 18:20:52&spare3=fxgs3t&searchCode=81486&weixinId=172&homeTel=kd05o7&name=merle.larkin&idType=0l9595&orderBy=993&nickname=renna.dibbert&sex=w5m12w&idMobile=(415) 540-6962&startTime=2025-10-20 18:20:52&address=Apt. 410 14910 Erdman Heights， West Caroll， WI 86927&spareMobile=(415) 540-6962&limit=10&idNum=vpmhzq&emergencePhone=1-203-302-2484&intro=irdx33&q=w8d1ks&nativePlace=0bls1h&isMobileConfirm=true&comefrom=ybdyc6&familyAddress=Apt. 410 14910 Erdman Heights， West Caroll， WI 86927&birthday=2025-10-20 18:26:08&sname=merle.larkin&postCode=81486
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|用户ID|-
└─nickname|string|用户昵称|-
└─idName|string|真实姓名，加密的姓名|-
└─idNum|string|身份证号码，加密的身份证号码|-
└─idMobile|string|电话|-
└─idType|string|证件类型|-
└─namePy|string|姓名全拼，BCryptPasswordEncoder密码")|-
└─sname|string|姓名缩写，外部输入填写的姓名|-
└─nameEn|string|姓名英文|-
└─searchCode|string|查询码，名称的拼音首字母|-
└─sex|string|性别GB_XBDM|-
└─birthday|string|出生日期|-
└─postCode|string|家庭邮政编码|-
└─address|string|地址|-
└─nativePlace|string|籍贯GB_XZQHDM_SHENG|-
└─familyAddress|string|家庭地址|-
└─homeTel|string|住宅电话|-
└─qqNo|string|即时通讯QQ号码|-
└─weixinId|string|微信用户名|-
└─weiboId|string|微博用户名|-
└─spareMobile|string|备用手机，紧急手机|-
└─isMobileConfirm|boolean|手机号码是否验证0否1是|-
└─emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|-
└─keywords|string|关键字|-
└─intro|string|个人介绍|-
└─comefrom|string|来自|-
└─imagePath|string|用户图像图标|-
└─userSignature|string|用户签名|-
└─ipRange|string|登录IP地址(";"分隔）|-
└─macCode|string|允许登录MAC地址(";"分隔）|-
└─resume|string|简历，网格平台使用，人所属的网格多个，分隔|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
└─spare3|string|备用3|-
└─spare4|string|备用4|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:08",
      "lastTime": "2025-10-20 18:26:08",
      "id": "172",
      "nickname": "renna.dibbert",
      "idName": "merle.larkin",
      "idNum": "zqipx6",
      "idMobile": "(415) 540-6962",
      "idType": "z6i0cb",
      "namePy": "dghlhx",
      "sname": "merle.larkin",
      "nameEn": "icawjl",
      "searchCode": "81486",
      "sex": "ou4xq6",
      "birthday": "2025-10-20 18:26:08",
      "postCode": "81486",
      "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
      "nativePlace": "ijhrax",
      "familyAddress": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
      "homeTel": "o9769s",
      "qqNo": "67uzac",
      "weixinId": "172",
      "weiboId": "172",
      "spareMobile": "(415) 540-6962",
      "isMobileConfirm": true,
      "emergencePhone": "1-203-302-2484",
      "keywords": "6nukzz",
      "intro": "9194hu",
      "comefrom": "shkuvs",
      "imagePath": "np89c3",
      "userSignature": "xp3lyj",
      "ipRange": "phpjye",
      "macCode": "81486",
      "resume": "goqkcc",
      "spare1": "i2zzxl",
      "spare2": "sc2yj0",
      "spare3": "9htdat",
      "spare4": "hs14po"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get BaseUserExt by id. 主键获取基础用户扩展信息详细信息.
**URL:** https://linlan.net/eframe_backend/api/third/baseuserext/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get BaseUserExt by id. 主键获取基础用户扩展信息详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|用户ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuserext/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|用户ID|-
└─nickname|string|用户昵称|-
└─idName|string|真实姓名，加密的姓名|-
└─idNum|string|身份证号码，加密的身份证号码|-
└─idMobile|string|电话|-
└─idType|string|证件类型|-
└─namePy|string|姓名全拼，BCryptPasswordEncoder密码")|-
└─sname|string|姓名缩写，外部输入填写的姓名|-
└─nameEn|string|姓名英文|-
└─searchCode|string|查询码，名称的拼音首字母|-
└─sex|string|性别GB_XBDM|-
└─birthday|string|出生日期|-
└─postCode|string|家庭邮政编码|-
└─address|string|地址|-
└─nativePlace|string|籍贯GB_XZQHDM_SHENG|-
└─familyAddress|string|家庭地址|-
└─homeTel|string|住宅电话|-
└─qqNo|string|即时通讯QQ号码|-
└─weixinId|string|微信用户名|-
└─weiboId|string|微博用户名|-
└─spareMobile|string|备用手机，紧急手机|-
└─isMobileConfirm|boolean|手机号码是否验证0否1是|-
└─emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|-
└─keywords|string|关键字|-
└─intro|string|个人介绍|-
└─comefrom|string|来自|-
└─imagePath|string|用户图像图标|-
└─userSignature|string|用户签名|-
└─ipRange|string|登录IP地址(";"分隔）|-
└─macCode|string|允许登录MAC地址(";"分隔）|-
└─resume|string|简历，网格平台使用，人所属的网格多个，分隔|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
└─spare3|string|备用3|-
└─spare4|string|备用4|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:08",
    "lastTime": "2025-10-20 18:26:08",
    "id": "172",
    "nickname": "renna.dibbert",
    "idName": "merle.larkin",
    "idNum": "nbvjdj",
    "idMobile": "(415) 540-6962",
    "idType": "hq72jj",
    "namePy": "foppkl",
    "sname": "merle.larkin",
    "nameEn": "4adq8e",
    "searchCode": "81486",
    "sex": "978dvi",
    "birthday": "2025-10-20 18:26:08",
    "postCode": "81486",
    "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "nativePlace": "ogze4w",
    "familyAddress": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "homeTel": "y8g2c8",
    "qqNo": "gqgevv",
    "weixinId": "172",
    "weiboId": "172",
    "spareMobile": "(415) 540-6962",
    "isMobileConfirm": true,
    "emergencePhone": "1-203-302-2484",
    "keywords": "uqt9wq",
    "intro": "666v1r",
    "comefrom": "tmu6bv",
    "imagePath": "d69v9n",
    "userSignature": "x8gcrm",
    "ipRange": "vz0wua",
    "macCode": "81486",
    "resume": "vxb5tr",
    "spare1": "55r4dh",
    "spare2": "1tw8h4",
    "spare3": "rdqy8b",
    "spare4": "llipfk"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseUserExt Operation. 新增基础用户扩展信息数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/third/baseuserext/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/json; charset=utf-8

**Description:** BaseUserExt Operation. 新增基础用户扩展信息数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|用户ID|false|-
└─nickname|string|用户昵称|false|-
└─idName|string|真实姓名，加密的姓名|false|-
└─idNum|string|身份证号码，加密的身份证号码|false|-
└─idMobile|string|电话|false|-
└─idType|string|证件类型|false|-
└─namePy|string|姓名全拼，BCryptPasswordEncoder密码")|false|-
└─sname|string|姓名缩写，外部输入填写的姓名|false|-
└─nameEn|string|姓名英文|false|-
└─searchCode|string|查询码，名称的拼音首字母|false|-
└─sex|string|性别GB_XBDM|false|-
└─birthday|string|出生日期|false|-
└─postCode|string|家庭邮政编码|false|-
└─address|string|地址|false|-
└─nativePlace|string|籍贯GB_XZQHDM_SHENG|false|-
└─familyAddress|string|家庭地址|false|-
└─homeTel|string|住宅电话|false|-
└─qqNo|string|即时通讯QQ号码|false|-
└─weixinId|string|微信用户名|false|-
└─weiboId|string|微博用户名|false|-
└─spareMobile|string|备用手机，紧急手机|false|-
└─isMobileConfirm|boolean|手机号码是否验证0否1是|false|-
└─emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|false|-
└─keywords|string|关键字|false|-
└─intro|string|个人介绍|false|-
└─comefrom|string|来自|false|-
└─imagePath|string|用户图像图标|false|-
└─userSignature|string|用户签名|false|-
└─ipRange|string|登录IP地址(";"分隔）|false|-
└─macCode|string|允许登录MAC地址(";"分隔）|false|-
└─resume|string|简历，网格平台使用，人所属的网格多个，分隔|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─spare3|string|备用3|false|-
└─spare4|string|备用4|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuserext/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:08",
    "lastTime": "2025-10-20 18:26:08",
    "id": "172",
    "nickname": "renna.dibbert",
    "idName": "merle.larkin",
    "idNum": "hbkj0n",
    "idMobile": "(415) 540-6962",
    "idType": "vijfpr",
    "namePy": "8mv278",
    "sname": "merle.larkin",
    "nameEn": "8g346f",
    "searchCode": "81486",
    "sex": "agy4gw",
    "birthday": "2025-10-20 18:26:08",
    "postCode": "81486",
    "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "nativePlace": "cfdsmg",
    "familyAddress": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "homeTel": "l77x60",
    "qqNo": "7j94i1",
    "weixinId": "172",
    "weiboId": "172",
    "spareMobile": "(415) 540-6962",
    "isMobileConfirm": true,
    "emergencePhone": "1-203-302-2484",
    "keywords": "1uu9ev",
    "intro": "7i6f30",
    "comefrom": "ui6y0w",
    "imagePath": "xa0ymg",
    "userSignature": "t17d2i",
    "ipRange": "xrqp45",
    "macCode": "81486",
    "resume": "1ce7pc",
    "spare1": "8keeka",
    "spare2": "2n1l1t",
    "spare3": "mt4jbs",
    "spare4": "l1uivd"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "iz6syg",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseUserExt Operation. 修改基础用户扩展信息数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/third/baseuserext/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/json; charset=utf-8

**Description:** BaseUserExt Operation. 修改基础用户扩展信息数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|用户ID|false|-
└─nickname|string|用户昵称|false|-
└─idName|string|真实姓名，加密的姓名|false|-
└─idNum|string|身份证号码，加密的身份证号码|false|-
└─idMobile|string|电话|false|-
└─idType|string|证件类型|false|-
└─namePy|string|姓名全拼，BCryptPasswordEncoder密码")|false|-
└─sname|string|姓名缩写，外部输入填写的姓名|false|-
└─nameEn|string|姓名英文|false|-
└─searchCode|string|查询码，名称的拼音首字母|false|-
└─sex|string|性别GB_XBDM|false|-
└─birthday|string|出生日期|false|-
└─postCode|string|家庭邮政编码|false|-
└─address|string|地址|false|-
└─nativePlace|string|籍贯GB_XZQHDM_SHENG|false|-
└─familyAddress|string|家庭地址|false|-
└─homeTel|string|住宅电话|false|-
└─qqNo|string|即时通讯QQ号码|false|-
└─weixinId|string|微信用户名|false|-
└─weiboId|string|微博用户名|false|-
└─spareMobile|string|备用手机，紧急手机|false|-
└─isMobileConfirm|boolean|手机号码是否验证0否1是|false|-
└─emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|false|-
└─keywords|string|关键字|false|-
└─intro|string|个人介绍|false|-
└─comefrom|string|来自|false|-
└─imagePath|string|用户图像图标|false|-
└─userSignature|string|用户签名|false|-
└─ipRange|string|登录IP地址(";"分隔）|false|-
└─macCode|string|允许登录MAC地址(";"分隔）|false|-
└─resume|string|简历，网格平台使用，人所属的网格多个，分隔|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─spare3|string|备用3|false|-
└─spare4|string|备用4|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuserext/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:08",
    "lastTime": "2025-10-20 18:26:08",
    "id": "172",
    "nickname": "renna.dibbert",
    "idName": "merle.larkin",
    "idNum": "wnppgr",
    "idMobile": "(415) 540-6962",
    "idType": "50a7dd",
    "namePy": "wb0ipk",
    "sname": "merle.larkin",
    "nameEn": "65pr2b",
    "searchCode": "81486",
    "sex": "77jjhj",
    "birthday": "2025-10-20 18:26:08",
    "postCode": "81486",
    "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "nativePlace": "nd4uho",
    "familyAddress": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "homeTel": "jv1knd",
    "qqNo": "amt0xi",
    "weixinId": "172",
    "weiboId": "172",
    "spareMobile": "(415) 540-6962",
    "isMobileConfirm": true,
    "emergencePhone": "1-203-302-2484",
    "keywords": "wvtulx",
    "intro": "atp6i7",
    "comefrom": "2frhnq",
    "imagePath": "01ehfb",
    "userSignature": "v64zj0",
    "ipRange": "8uqphw",
    "macCode": "81486",
    "resume": "fjrdra",
    "spare1": "khmrcv",
    "spare2": "qbid44",
    "spare3": "4l1xfv",
    "spare4": "mij68y"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "i6ocsg",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseUserExt Operation. 删除基础用户扩展信息数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/third/baseuserext/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** BaseUserExt Operation. 删除基础用户扩展信息数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|用户ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuserext/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "n6pzxj",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 基础用户读写控制类
### Get BaseUser list. 获取基础用户列表或分页, 返回BaseUser对象.
**URL:** https://linlan.net/eframe_backend/api/third/baseuser/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get BaseUser list. 获取基础用户列表或分页, 返回BaseUser对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
xzqhId|int64|行政区划编号，用户来源地|false|-
source|int32|创建来源类型|false|-
createType|int32|创建方式0导入1录入2授权|false|-
username|string|用户名，城市APP市民云的用户名|false|-
mobile|string|手机号码|false|-
email|string|电子邮箱|false|-
srcCode|int32|当前来源0缺省1:WEB或PC,2APP21:AndroidAPP,22:IOSAPP,3WAP,4MINI|false|-
registerTime|string|注册时间|false|-
lastAppId|string|最后登录的应用ID|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-
spare1|string|备用1，第三方的平台的用户名，如随申办统一身份体系的用户名|false|-
spare2|string|备用2，第三方用户ID，OpenId|false|-
key|string|关键字|false|-
bindOrganId|string|绑定机构ID|false|-
bindOrganType|string|绑定机构类型|false|-
isBindFrontUser|string|绑定站点用户|false|-
createTime|string|关键字|false|-
searchCode|string|搜索编码|false|-
workUserId|string|用户编号|false|-
ids|array|id集合|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuser/list.do?mobile=(415) 540-6962&xzqhId=705&ids=nvvm4d&ids=nvvm4d&spare1=651vsl&lastAppId=172&orderBy=62&q=zrfigw&delFlag=5&email=vivian.streich@hotmail.com&isBindFrontUser=ukdo02&key=yd79rc&registerTime=2025-10-20 18:26:07&description=jwlbmd&source=765&workUserId=172&searchCode=81486&limit=10&createType=322&spare2=h1m0uk&bindOrganId=172&startTime=2025-10-20 18:20:52&bindOrganType=5165qi&createTime=2025-10-20 18:20:52&endTime=2025-10-20 18:20:52&page=1&srcCode=752&username=merle.larkin
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|用户ID|-
└─xzqhId|int64|行政区划编号，用户来源地|-
└─source|string|创建来源类型|-
└─createType|int32|创建方式0导入1录入2授权|-
└─username|string|用户名，城市APP市民云的用户名|-
└─mobile|string|手机号码|-
└─email|string|电子邮箱|-
└─password|string|密码|-
└─salt|string|混淆字符|-
└─srcCode|int32|当前来源0缺省1:WEB或PC,2APP21:AndroidAPP,22:IOSAPP,3WAP,4MINI|-
└─registerTime|string|注册时间|-
└─registerIp|string|注册IP|-
└─currentLoginTime|string|当前登录时间|-
└─currentLoginIp|string|当前登录IP|-
└─lastAppId|string|最后登录的应用ID|-
└─lastLoginTime|string|最后登录时间|-
└─lastLoginIp|string|最后登录IP|-
└─lastLogoutTime|string|最后一次退出时间|-
└─loginCount|int32|登录次数|-
└─resetKey|string|重置密码KEY|-
└─resetPwd|string|重置密码VALUE|-
└─lastResetTime|string|上次修改密码时间，最后一次修改密码时间|-
└─errorTime|string|出错时间|-
└─errorCount|int32|出错数量|-
└─errorIp|string|出错IP|-
└─lockTime|string|锁定时间|-
└─activation|boolean|是否激活0否1是|-
└─activationCode|string|激活代码|-
└─priority|int32|排序|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─deleteTime|string|删除时间|-
└─description|string|描述|-
└─spare1|string|备用1，第三方的平台的用户名，如随申办统一身份体系的用户名，微信UNIONID|-
└─spare2|string|备用2，第三方用户ID，OpenId|-
└─newPassword|string|新密码|-
└─baseUserExt|object|全局用户扩展类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nickname|string|用户昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idName|string|真实姓名，加密的姓名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idNum|string|身份证号码，加密的身份证号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMobile|string|电话|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idType|string|证件类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─namePy|string|姓名全拼，BCryptPasswordEncoder密码")|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|姓名缩写，外部输入填写的姓名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|姓名英文|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|查询码，名称的拼音首字母|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sex|string|性别GB_XBDM|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthday|string|出生日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postCode|string|家庭邮政编码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─address|string|地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nativePlace|string|籍贯GB_XZQHDM_SHENG|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─familyAddress|string|家庭地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─homeTel|string|住宅电话|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─qqNo|string|即时通讯QQ号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─weixinId|string|微信用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─weiboId|string|微博用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spareMobile|string|备用手机，紧急手机|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isMobileConfirm|boolean|手机号码是否验证0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─keywords|string|关键字|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─intro|string|个人介绍|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comefrom|string|来自|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|用户图像图标|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userSignature|string|用户签名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ipRange|string|登录IP地址(";"分隔）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─macCode|string|允许登录MAC地址(";"分隔）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─resume|string|简历，网格平台使用，人所属的网格多个，分隔|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare3|string|备用3|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare4|string|备用4|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:07",
      "lastTime": "2025-10-20 18:26:07",
      "id": "172",
      "xzqhId": 48,
      "source": "ps6l02",
      "createType": 356,
      "username": "merle.larkin",
      "mobile": "(415) 540-6962",
      "email": "vivian.streich@hotmail.com",
      "password": "dwh0os",
      "salt": "cxo3dq",
      "srcCode": 864,
      "registerTime": "2025-10-20 18:26:07",
      "registerIp": "137.119.212.174",
      "currentLoginTime": "2025-10-20 18:26:07",
      "currentLoginIp": "137.119.212.174",
      "lastAppId": "172",
      "lastLoginTime": "2025-10-20 18:26:07",
      "lastLoginIp": "137.119.212.174",
      "lastLogoutTime": "2025-10-20 18:26:07",
      "loginCount": 191,
      "resetKey": "q6jjzo",
      "resetPwd": "yw7ea7",
      "lastResetTime": "2025-10-20 18:26:07",
      "errorTime": "2025-10-20 18:26:07",
      "errorCount": 32,
      "errorIp": "137.119.212.174",
      "lockTime": "2025-10-20 18:26:07",
      "activation": true,
      "activationCode": "81486",
      "priority": 401,
      "delFlag": 5,
      "deleteTime": "2025-10-20 18:26:07",
      "description": "598p3t",
      "spare1": "x4mzek",
      "spare2": "uu95py",
      "newPassword": "18wsbe",
      "baseUserExt": {
        "creatorId": "172",
        "createTime": "2025-10-20 18:26:08",
        "lastTime": "2025-10-20 18:26:08",
        "id": "172",
        "nickname": "renna.dibbert",
        "idName": "merle.larkin",
        "idNum": "dpdpn3",
        "idMobile": "(415) 540-6962",
        "idType": "pdvg9k",
        "namePy": "9ob9ve",
        "sname": "merle.larkin",
        "nameEn": "gs634z",
        "searchCode": "81486",
        "sex": "ojxtla",
        "birthday": "2025-10-20 18:26:08",
        "postCode": "81486",
        "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
        "nativePlace": "ffqyos",
        "familyAddress": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
        "homeTel": "fzsjhw",
        "qqNo": "589mu8",
        "weixinId": "172",
        "weiboId": "172",
        "spareMobile": "(415) 540-6962",
        "isMobileConfirm": true,
        "emergencePhone": "1-203-302-2484",
        "keywords": "snq2hb",
        "intro": "kyo7u2",
        "comefrom": "pga4xg",
        "imagePath": "9mk4v5",
        "userSignature": "1d8hqx",
        "ipRange": "nw9asa",
        "macCode": "81486",
        "resume": "57vkdn",
        "spare1": "b88q1s",
        "spare2": "lecdt3",
        "spare3": "3srcyb",
        "spare4": "0mp1q1"
      }
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get BaseUser by id. 主键获取基础用户详细信息.
**URL:** https://linlan.net/eframe_backend/api/third/baseuser/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get BaseUser by id. 主键获取基础用户详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|用户ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuser/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|用户ID|-
└─xzqhId|int64|行政区划编号，用户来源地|-
└─source|string|创建来源类型|-
└─createType|int32|创建方式0导入1录入2授权|-
└─username|string|用户名，城市APP市民云的用户名|-
└─mobile|string|手机号码|-
└─email|string|电子邮箱|-
└─password|string|密码|-
└─salt|string|混淆字符|-
└─srcCode|int32|当前来源0缺省1:WEB或PC,2APP21:AndroidAPP,22:IOSAPP,3WAP,4MINI|-
└─registerTime|string|注册时间|-
└─registerIp|string|注册IP|-
└─currentLoginTime|string|当前登录时间|-
└─currentLoginIp|string|当前登录IP|-
└─lastAppId|string|最后登录的应用ID|-
└─lastLoginTime|string|最后登录时间|-
└─lastLoginIp|string|最后登录IP|-
└─lastLogoutTime|string|最后一次退出时间|-
└─loginCount|int32|登录次数|-
└─resetKey|string|重置密码KEY|-
└─resetPwd|string|重置密码VALUE|-
└─lastResetTime|string|上次修改密码时间，最后一次修改密码时间|-
└─errorTime|string|出错时间|-
└─errorCount|int32|出错数量|-
└─errorIp|string|出错IP|-
└─lockTime|string|锁定时间|-
└─activation|boolean|是否激活0否1是|-
└─activationCode|string|激活代码|-
└─priority|int32|排序|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─deleteTime|string|删除时间|-
└─description|string|描述|-
└─spare1|string|备用1，第三方的平台的用户名，如随申办统一身份体系的用户名，微信UNIONID|-
└─spare2|string|备用2，第三方用户ID，OpenId|-
└─newPassword|string|新密码|-
└─baseUserExt|object|全局用户扩展类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nickname|string|用户昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idName|string|真实姓名，加密的姓名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idNum|string|身份证号码，加密的身份证号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMobile|string|电话|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idType|string|证件类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─namePy|string|姓名全拼，BCryptPasswordEncoder密码")|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|姓名缩写，外部输入填写的姓名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|姓名英文|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|查询码，名称的拼音首字母|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sex|string|性别GB_XBDM|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthday|string|出生日期|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postCode|string|家庭邮政编码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─address|string|地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nativePlace|string|籍贯GB_XZQHDM_SHENG|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─familyAddress|string|家庭地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─homeTel|string|住宅电话|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─qqNo|string|即时通讯QQ号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─weixinId|string|微信用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─weiboId|string|微博用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spareMobile|string|备用手机，紧急手机|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isMobileConfirm|boolean|手机号码是否验证0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─keywords|string|关键字|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─intro|string|个人介绍|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comefrom|string|来自|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|用户图像图标|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userSignature|string|用户签名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ipRange|string|登录IP地址(";"分隔）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─macCode|string|允许登录MAC地址(";"分隔）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─resume|string|简历，网格平台使用，人所属的网格多个，分隔|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare3|string|备用3|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare4|string|备用4|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:08",
    "lastTime": "2025-10-20 18:26:08",
    "id": "172",
    "xzqhId": 600,
    "source": "0jzl2p",
    "createType": 854,
    "username": "merle.larkin",
    "mobile": "(415) 540-6962",
    "email": "vivian.streich@hotmail.com",
    "password": "27l2pe",
    "salt": "wf491o",
    "srcCode": 511,
    "registerTime": "2025-10-20 18:26:08",
    "registerIp": "137.119.212.174",
    "currentLoginTime": "2025-10-20 18:26:08",
    "currentLoginIp": "137.119.212.174",
    "lastAppId": "172",
    "lastLoginTime": "2025-10-20 18:26:08",
    "lastLoginIp": "137.119.212.174",
    "lastLogoutTime": "2025-10-20 18:26:08",
    "loginCount": 797,
    "resetKey": "6jo409",
    "resetPwd": "f6so9x",
    "lastResetTime": "2025-10-20 18:26:08",
    "errorTime": "2025-10-20 18:26:08",
    "errorCount": 442,
    "errorIp": "137.119.212.174",
    "lockTime": "2025-10-20 18:26:08",
    "activation": true,
    "activationCode": "81486",
    "priority": 298,
    "delFlag": 5,
    "deleteTime": "2025-10-20 18:26:08",
    "description": "vx0cep",
    "spare1": "vm606f",
    "spare2": "m1zkuk",
    "newPassword": "uhaq10",
    "baseUserExt": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:08",
      "lastTime": "2025-10-20 18:26:08",
      "id": "172",
      "nickname": "renna.dibbert",
      "idName": "merle.larkin",
      "idNum": "y6jbgx",
      "idMobile": "(415) 540-6962",
      "idType": "wscqzx",
      "namePy": "rktoio",
      "sname": "merle.larkin",
      "nameEn": "lqjr68",
      "searchCode": "81486",
      "sex": "cctzcw",
      "birthday": "2025-10-20 18:26:08",
      "postCode": "81486",
      "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
      "nativePlace": "0j6ntj",
      "familyAddress": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
      "homeTel": "zi7d4i",
      "qqNo": "892pqd",
      "weixinId": "172",
      "weiboId": "172",
      "spareMobile": "(415) 540-6962",
      "isMobileConfirm": true,
      "emergencePhone": "1-203-302-2484",
      "keywords": "f2v3e8",
      "intro": "13ne8t",
      "comefrom": "c1pz43",
      "imagePath": "vrnsgr",
      "userSignature": "bkpn27",
      "ipRange": "jcoxf8",
      "macCode": "81486",
      "resume": "4vhpf8",
      "spare1": "ubtp3b",
      "spare2": "smit7t",
      "spare3": "o3xioy",
      "spare4": "feoq4a"
    }
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseUser Operation. 新增基础用户数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/third/baseuser/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/json; charset=utf-8

**Description:** BaseUser Operation. 新增基础用户数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|用户ID|false|-
└─xzqhId|int64|行政区划编号，用户来源地|false|-
└─source|string|创建来源类型|false|-
└─createType|int32|创建方式0导入1录入2授权|false|-
└─username|string|用户名，城市APP市民云的用户名|false|-
└─mobile|string|手机号码|false|-
└─email|string|电子邮箱|false|-
└─password|string|密码|false|-
└─salt|string|混淆字符|false|-
└─srcCode|int32|当前来源0缺省1:WEB或PC,2APP21:AndroidAPP,22:IOSAPP,3WAP,4MINI|false|-
└─registerTime|string|注册时间|false|-
└─registerIp|string|注册IP|false|-
└─currentLoginTime|string|当前登录时间|false|-
└─currentLoginIp|string|当前登录IP|false|-
└─lastAppId|string|最后登录的应用ID|false|-
└─lastLoginTime|string|最后登录时间|false|-
└─lastLoginIp|string|最后登录IP|false|-
└─lastLogoutTime|string|最后一次退出时间|false|-
└─loginCount|int32|登录次数|false|-
└─resetKey|string|重置密码KEY|false|-
└─resetPwd|string|重置密码VALUE|false|-
└─lastResetTime|string|上次修改密码时间，最后一次修改密码时间|false|-
└─errorTime|string|出错时间|false|-
└─errorCount|int32|出错数量|false|-
└─errorIp|string|出错IP|false|-
└─lockTime|string|锁定时间|false|-
└─activation|boolean|是否激活0否1是|false|-
└─activationCode|string|激活代码|false|-
└─priority|int32|排序|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─deleteTime|string|删除时间|false|-
└─description|string|描述|false|-
└─spare1|string|备用1，第三方的平台的用户名，如随申办统一身份体系的用户名，微信UNIONID|false|-
└─spare2|string|备用2，第三方用户ID，OpenId|false|-
└─newPassword|string|新密码|false|-
└─baseUserExt|object|全局用户扩展类|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|用户ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nickname|string|用户昵称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idName|string|真实姓名，加密的姓名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idNum|string|身份证号码，加密的身份证号码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMobile|string|电话|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idType|string|证件类型|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─namePy|string|姓名全拼，BCryptPasswordEncoder密码")|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|姓名缩写，外部输入填写的姓名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|姓名英文|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|查询码，名称的拼音首字母|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sex|string|性别GB_XBDM|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthday|string|出生日期|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postCode|string|家庭邮政编码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─address|string|地址|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nativePlace|string|籍贯GB_XZQHDM_SHENG|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─familyAddress|string|家庭地址|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─homeTel|string|住宅电话|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─qqNo|string|即时通讯QQ号码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─weixinId|string|微信用户名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─weiboId|string|微博用户名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spareMobile|string|备用手机，紧急手机|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isMobileConfirm|boolean|手机号码是否验证0否1是|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─keywords|string|关键字|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─intro|string|个人介绍|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comefrom|string|来自|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|用户图像图标|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userSignature|string|用户签名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ipRange|string|登录IP地址(";"分隔）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─macCode|string|允许登录MAC地址(";"分隔）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─resume|string|简历，网格平台使用，人所属的网格多个，分隔|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare3|string|备用3|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare4|string|备用4|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuser/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:08",
    "lastTime": "2025-10-20 18:26:08",
    "id": "172",
    "xzqhId": 70,
    "source": "y85hla",
    "createType": 66,
    "username": "merle.larkin",
    "mobile": "(415) 540-6962",
    "email": "vivian.streich@hotmail.com",
    "password": "xc2i5b",
    "salt": "yqo6in",
    "srcCode": 677,
    "registerTime": "2025-10-20 18:26:08",
    "registerIp": "137.119.212.174",
    "currentLoginTime": "2025-10-20 18:26:08",
    "currentLoginIp": "137.119.212.174",
    "lastAppId": "172",
    "lastLoginTime": "2025-10-20 18:26:08",
    "lastLoginIp": "137.119.212.174",
    "lastLogoutTime": "2025-10-20 18:26:08",
    "loginCount": 696,
    "resetKey": "aupdk0",
    "resetPwd": "5k7ptm",
    "lastResetTime": "2025-10-20 18:26:08",
    "errorTime": "2025-10-20 18:26:08",
    "errorCount": 662,
    "errorIp": "137.119.212.174",
    "lockTime": "2025-10-20 18:26:08",
    "activation": true,
    "activationCode": "81486",
    "priority": 286,
    "delFlag": 5,
    "deleteTime": "2025-10-20 18:26:08",
    "description": "5tjwxh",
    "spare1": "u4glel",
    "spare2": "89bo3u",
    "newPassword": "nj8dno",
    "baseUserExt": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:08",
      "lastTime": "2025-10-20 18:26:08",
      "id": "172",
      "nickname": "renna.dibbert",
      "idName": "merle.larkin",
      "idNum": "myq959",
      "idMobile": "(415) 540-6962",
      "idType": "bojwu7",
      "namePy": "f125ao",
      "sname": "merle.larkin",
      "nameEn": "q3uwe1",
      "searchCode": "81486",
      "sex": "gm1wx6",
      "birthday": "2025-10-20 18:26:08",
      "postCode": "81486",
      "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
      "nativePlace": "t6h2wq",
      "familyAddress": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
      "homeTel": "tf6a06",
      "qqNo": "w0197k",
      "weixinId": "172",
      "weiboId": "172",
      "spareMobile": "(415) 540-6962",
      "isMobileConfirm": true,
      "emergencePhone": "1-203-302-2484",
      "keywords": "ba90h8",
      "intro": "u5hjvy",
      "comefrom": "89b0ys",
      "imagePath": "m94a9m",
      "userSignature": "2oojb8",
      "ipRange": "2y3lwd",
      "macCode": "81486",
      "resume": "65ppep",
      "spare1": "ysn5bi",
      "spare2": "rw2cbh",
      "spare3": "g4rwu9",
      "spare4": "qa5af7"
    }
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "g85rkb",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseUser Operation. 修改基础用户数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/third/baseuser/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/json; charset=utf-8

**Description:** BaseUser Operation. 修改基础用户数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|用户ID|false|-
└─xzqhId|int64|行政区划编号，用户来源地|false|-
└─source|string|创建来源类型|false|-
└─createType|int32|创建方式0导入1录入2授权|false|-
└─username|string|用户名，城市APP市民云的用户名|false|-
└─mobile|string|手机号码|false|-
└─email|string|电子邮箱|false|-
└─password|string|密码|false|-
└─salt|string|混淆字符|false|-
└─srcCode|int32|当前来源0缺省1:WEB或PC,2APP21:AndroidAPP,22:IOSAPP,3WAP,4MINI|false|-
└─registerTime|string|注册时间|false|-
└─registerIp|string|注册IP|false|-
└─currentLoginTime|string|当前登录时间|false|-
└─currentLoginIp|string|当前登录IP|false|-
└─lastAppId|string|最后登录的应用ID|false|-
└─lastLoginTime|string|最后登录时间|false|-
└─lastLoginIp|string|最后登录IP|false|-
└─lastLogoutTime|string|最后一次退出时间|false|-
└─loginCount|int32|登录次数|false|-
└─resetKey|string|重置密码KEY|false|-
└─resetPwd|string|重置密码VALUE|false|-
└─lastResetTime|string|上次修改密码时间，最后一次修改密码时间|false|-
└─errorTime|string|出错时间|false|-
└─errorCount|int32|出错数量|false|-
└─errorIp|string|出错IP|false|-
└─lockTime|string|锁定时间|false|-
└─activation|boolean|是否激活0否1是|false|-
└─activationCode|string|激活代码|false|-
└─priority|int32|排序|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─deleteTime|string|删除时间|false|-
└─description|string|描述|false|-
└─spare1|string|备用1，第三方的平台的用户名，如随申办统一身份体系的用户名，微信UNIONID|false|-
└─spare2|string|备用2，第三方用户ID，OpenId|false|-
└─newPassword|string|新密码|false|-
└─baseUserExt|object|全局用户扩展类|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|用户ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nickname|string|用户昵称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idName|string|真实姓名，加密的姓名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idNum|string|身份证号码，加密的身份证号码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idMobile|string|电话|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idType|string|证件类型|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─namePy|string|姓名全拼，BCryptPasswordEncoder密码")|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|姓名缩写，外部输入填写的姓名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|姓名英文|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|查询码，名称的拼音首字母|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sex|string|性别GB_XBDM|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─birthday|string|出生日期|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postCode|string|家庭邮政编码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─address|string|地址|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nativePlace|string|籍贯GB_XZQHDM_SHENG|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─familyAddress|string|家庭地址|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─homeTel|string|住宅电话|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─qqNo|string|即时通讯QQ号码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─weixinId|string|微信用户名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─weiboId|string|微博用户名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spareMobile|string|备用手机，紧急手机|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isMobileConfirm|boolean|手机号码是否验证0否1是|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─keywords|string|关键字|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─intro|string|个人介绍|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comefrom|string|来自|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|用户图像图标|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userSignature|string|用户签名|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ipRange|string|登录IP地址(";"分隔）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─macCode|string|允许登录MAC地址(";"分隔）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─resume|string|简历，网格平台使用，人所属的网格多个，分隔|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare3|string|备用3|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare4|string|备用4|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuser/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:08",
    "lastTime": "2025-10-20 18:26:08",
    "id": "172",
    "xzqhId": 549,
    "source": "g7pi0v",
    "createType": 191,
    "username": "merle.larkin",
    "mobile": "(415) 540-6962",
    "email": "vivian.streich@hotmail.com",
    "password": "2s9536",
    "salt": "p767a0",
    "srcCode": 511,
    "registerTime": "2025-10-20 18:26:08",
    "registerIp": "137.119.212.174",
    "currentLoginTime": "2025-10-20 18:26:08",
    "currentLoginIp": "137.119.212.174",
    "lastAppId": "172",
    "lastLoginTime": "2025-10-20 18:26:08",
    "lastLoginIp": "137.119.212.174",
    "lastLogoutTime": "2025-10-20 18:26:08",
    "loginCount": 592,
    "resetKey": "h7gpnp",
    "resetPwd": "hee53w",
    "lastResetTime": "2025-10-20 18:26:08",
    "errorTime": "2025-10-20 18:26:08",
    "errorCount": 186,
    "errorIp": "137.119.212.174",
    "lockTime": "2025-10-20 18:26:08",
    "activation": true,
    "activationCode": "81486",
    "priority": 640,
    "delFlag": 5,
    "deleteTime": "2025-10-20 18:26:08",
    "description": "b75c01",
    "spare1": "ag1sfj",
    "spare2": "5k9qfa",
    "newPassword": "g1ov5p",
    "baseUserExt": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:08",
      "lastTime": "2025-10-20 18:26:08",
      "id": "172",
      "nickname": "renna.dibbert",
      "idName": "merle.larkin",
      "idNum": "bzsdr7",
      "idMobile": "(415) 540-6962",
      "idType": "vh0u2e",
      "namePy": "8z6qgw",
      "sname": "merle.larkin",
      "nameEn": "tvgm77",
      "searchCode": "81486",
      "sex": "fdx8ks",
      "birthday": "2025-10-20 18:26:08",
      "postCode": "81486",
      "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
      "nativePlace": "0v7v47",
      "familyAddress": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
      "homeTel": "hlmy08",
      "qqNo": "bjx50o",
      "weixinId": "172",
      "weiboId": "172",
      "spareMobile": "(415) 540-6962",
      "isMobileConfirm": true,
      "emergencePhone": "1-203-302-2484",
      "keywords": "n0kk95",
      "intro": "t6g1vw",
      "comefrom": "8c6vth",
      "imagePath": "voaju3",
      "userSignature": "jbjsor",
      "ipRange": "7eu2fh",
      "macCode": "81486",
      "resume": "gbdiy0",
      "spare1": "q63i4w",
      "spare2": "2ncml1",
      "spare3": "jqde3s",
      "spare4": "pq1kx4"
    }
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "psfpej",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseUser Operation. 删除基础用户数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/third/baseuser/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** BaseUser Operation. 删除基础用户数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|用户ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuser/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "uv3u0l",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 平台公共消息读写控制类
### Get PublicNotice list. 获取平台公共消息列表或分页, 返回PublicNotice对象.
**URL:** https://linlan.net/eframe_backend/api/system/notice/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get PublicNotice list. 获取平台公共消息列表或分页, 返回PublicNotice对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|int64|信息ID|false|-
appId|string|应用ID|false|-
organId|string|机构ID|false|-
bizType|string|业务类型1通知公告11促销21模块业务|false|-
type|int32|类型，1通知2公告|false|-
title|string|信息标题|false|-
content|string|信息内容|false|-
msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
foreignId|string|信息外键，如CONTENT_ID或短彩信网关信息ID|false|-
imagePath|string|图片路径|false|-
iconStyle|string|图标样式|false|-
recvMemberId|string|信息接收会员ID|false|-
recvGroupId|string|信息接收会员组ID|false|-
recvOrganId|string|信息接收部门ID|false|-
recvTargetid|string|接收对象ID或手机号码列表|false|-
status|int32|信息状态(0未启用1正常2关闭)|false|-
creatorId|string|创建管理用户ID|false|-
updatorId|string|维护管理用户ID|false|-
updateTime|string|修改时间|false|-
description|string|描述|false|-
readStatus|string|阅读状态 （查询关联表）|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list.do?creatorId=172&bizType=79jb9i&title=mj8jeg&iconStyle=2mex50&startTime=2025-10-20 18:20:52&recvTargetid=172&description=9n6fp0&foreignId=172&q=nc90ph&limit=10&appId=172&page=1&endTime=2025-10-20 18:20:52&organId=172&recvMemberId=172&id=854&type=925&readStatus=rf64xb&imagePath=lulumt&orderBy=205&status=961&recvOrganId=172&msgUrl=www.ben-grant.info&updateTime=2025-10-20 18:26:08&recvGroupId=172&updatorId=172&content=nywa47
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|信息ID|-
└─appId|string|应用ID|-
└─organId|string|机构ID|-
└─bizType|string|业务类型1通知公告11促销21模块业务|-
└─type|int32|类型，1通知2公告|-
└─title|string|信息标题|-
└─content|string|信息内容|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|-
└─foreignId|string|信息外键，如CONTENT_ID或短彩信网关信息ID|-
└─imagePath|string|图片路径|-
└─iconStyle|string|图标样式|-
└─recvMemberId|string|信息接收会员ID|-
└─recvGroupId|string|信息接收会员组ID|-
└─recvOrganId|string|信息接收部门ID|-
└─recvTargetid|string|接收对象ID或手机号码列表|-
└─status|int32|信息状态(0未启用1正常2关闭)|-
└─updatorId|string|维护管理用户ID|-
└─updateTime|string|修改时间|-
└─description|string|描述|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:08",
      "lastTime": "2025-10-20 18:26:08",
      "id": 611,
      "appId": "172",
      "organId": "172",
      "bizType": "9wlne0",
      "type": 408,
      "title": "h7vgeg",
      "content": "8vpcva",
      "msgUrl": "www.ben-grant.info",
      "foreignId": "172",
      "imagePath": "e40huh",
      "iconStyle": "l5zwti",
      "recvMemberId": "172",
      "recvGroupId": "172",
      "recvOrganId": "172",
      "recvTargetid": "172",
      "status": 355,
      "updatorId": "172",
      "updateTime": "2025-10-20 18:26:08",
      "description": "b8uvlu"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get PublicNotice list. 获取所有信息列表分页
**URL:** https://linlan.net/eframe_backend/api/system/notice/list/myself.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get PublicNotice list. 获取所有信息列表分页

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|int64|信息ID|false|-
appId|string|应用ID|false|-
organId|string|机构ID|false|-
bizType|string|业务类型1通知公告11促销21模块业务|false|-
type|int32|类型，1通知2公告|false|-
title|string|信息标题|false|-
content|string|信息内容|false|-
msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
foreignId|string|信息外键，如CONTENT_ID或短彩信网关信息ID|false|-
imagePath|string|图片路径|false|-
iconStyle|string|图标样式|false|-
recvMemberId|string|信息接收会员ID|false|-
recvGroupId|string|信息接收会员组ID|false|-
recvOrganId|string|信息接收部门ID|false|-
recvTargetid|string|接收对象ID或手机号码列表|false|-
status|int32|信息状态(0未启用1正常2关闭)|false|-
creatorId|string|创建管理用户ID|false|-
updatorId|string|维护管理用户ID|false|-
updateTime|string|修改时间|false|-
description|string|描述|false|-
readStatus|string|阅读状态 （查询关联表）|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list/myself.do?imagePath=snqwu2&readStatus=u9csqv&foreignId=172&updateTime=2025-10-20 18:26:08&description=driaut&appId=172&endTime=2025-10-20 18:20:52&limit=10&recvTargetid=172&organId=172&startTime=2025-10-20 18:20:52&recvMemberId=172&content=xbrkd5&updatorId=172&msgUrl=www.ben-grant.info&iconStyle=6mfg61&type=970&status=627&title=d8mnn9&orderBy=565&id=87&bizType=vd1be3&recvGroupId=172&page=1&q=ogva7l&recvOrganId=172&creatorId=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|信息ID|-
└─appId|string|应用ID|-
└─organId|string|机构ID|-
└─bizType|string|业务类型1通知公告11促销21模块业务|-
└─type|int32|类型，1通知2公告|-
└─title|string|信息标题|-
└─content|string|信息内容|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|-
└─foreignId|string|信息外键，如CONTENT_ID或短彩信网关信息ID|-
└─imagePath|string|图片路径|-
└─iconStyle|string|图标样式|-
└─recvMemberId|string|信息接收会员ID|-
└─recvGroupId|string|信息接收会员组ID|-
└─recvOrganId|string|信息接收部门ID|-
└─recvTargetid|string|接收对象ID或手机号码列表|-
└─status|int32|信息状态(0未启用1正常2关闭)|-
└─updatorId|string|维护管理用户ID|-
└─updateTime|string|修改时间|-
└─description|string|描述|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:08",
      "lastTime": "2025-10-20 18:26:08",
      "id": 478,
      "appId": "172",
      "organId": "172",
      "bizType": "bijdq9",
      "type": 684,
      "title": "pb2w1s",
      "content": "9js9uy",
      "msgUrl": "www.ben-grant.info",
      "foreignId": "172",
      "imagePath": "k6j6y7",
      "iconStyle": "xnzma2",
      "recvMemberId": "172",
      "recvGroupId": "172",
      "recvOrganId": "172",
      "recvTargetid": "172",
      "status": 668,
      "updatorId": "172",
      "updateTime": "2025-10-20 18:26:08",
      "description": "r1ss0t"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicNotice Operation. PublicNotice数据操作逻辑，导出操作.
**URL:** https://linlan.net/eframe_backend/api/system/notice/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicNotice Operation. PublicNotice数据操作逻辑，导出操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|int64|信息ID|false|-
appId|string|应用ID|false|-
organId|string|机构ID|false|-
bizType|string|业务类型1通知公告11促销21模块业务|false|-
type|int32|类型，1通知2公告|false|-
title|string|信息标题|false|-
content|string|信息内容|false|-
msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
foreignId|string|信息外键，如CONTENT_ID或短彩信网关信息ID|false|-
imagePath|string|图片路径|false|-
iconStyle|string|图标样式|false|-
recvMemberId|string|信息接收会员ID|false|-
recvGroupId|string|信息接收会员组ID|false|-
recvOrganId|string|信息接收部门ID|false|-
recvTargetid|string|接收对象ID或手机号码列表|false|-
status|int32|信息状态(0未启用1正常2关闭)|false|-
creatorId|string|创建管理用户ID|false|-
updatorId|string|维护管理用户ID|false|-
updateTime|string|修改时间|false|-
description|string|描述|false|-
readStatus|string|阅读状态 （查询关联表）|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/export.do --data 'description=kxpxrn&msgUrl=www.ben-grant.info&foreignId=172&creatorId=172&imagePath=lqhvbg&q=qqbvb0&status=6&organId=172&readStatus=vpvo39&page=1&startTime=2025-10-20 18:20:52&updateTime=2025-10-20 18:26:08&orderBy=579&recvTargetid=172&bizType=bh2rf7&type=752&title=96lq46&endTime=2025-10-20 18:20:52&iconStyle=fqtdtu&id=153&updatorId=172&recvMemberId=172&content=57bo2z&appId=172&recvGroupId=172&recvOrganId=172&limit=10'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "fmvde7",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get PublicNotice by id. 主键获取平台公共消息详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/notice/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get PublicNotice by id. 主键获取平台公共消息详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|信息ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|信息ID|-
└─appId|string|应用ID|-
└─organId|string|机构ID|-
└─bizType|string|业务类型1通知公告11促销21模块业务|-
└─type|int32|类型，1通知2公告|-
└─title|string|信息标题|-
└─content|string|信息内容|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|-
└─foreignId|string|信息外键，如CONTENT_ID或短彩信网关信息ID|-
└─imagePath|string|图片路径|-
└─iconStyle|string|图标样式|-
└─recvMemberId|string|信息接收会员ID|-
└─recvGroupId|string|信息接收会员组ID|-
└─recvOrganId|string|信息接收部门ID|-
└─recvTargetid|string|接收对象ID或手机号码列表|-
└─status|int32|信息状态(0未启用1正常2关闭)|-
└─updatorId|string|维护管理用户ID|-
└─updateTime|string|修改时间|-
└─description|string|描述|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:08",
    "lastTime": "2025-10-20 18:26:08",
    "id": 689,
    "appId": "172",
    "organId": "172",
    "bizType": "yhfumy",
    "type": 743,
    "title": "xud2sd",
    "content": "p82eri",
    "msgUrl": "www.ben-grant.info",
    "foreignId": "172",
    "imagePath": "ixpyo1",
    "iconStyle": "pfljdh",
    "recvMemberId": "172",
    "recvGroupId": "172",
    "recvOrganId": "172",
    "recvTargetid": "172",
    "status": 437,
    "updatorId": "172",
    "updateTime": "2025-10-20 18:26:08",
    "description": "k261a7"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicNotice Operation. 新增平台公共消息数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/notice/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/json; charset=utf-8

**Description:** PublicNotice Operation. 新增平台公共消息数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|信息ID|false|-
└─appId|string|应用ID|false|-
└─organId|string|机构ID|false|-
└─bizType|string|业务类型1通知公告11促销21模块业务|false|-
└─type|int32|类型，1通知2公告|false|-
└─title|string|信息标题|false|-
└─content|string|信息内容|false|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
└─foreignId|string|信息外键，如CONTENT_ID或短彩信网关信息ID|false|-
└─imagePath|string|图片路径|false|-
└─iconStyle|string|图标样式|false|-
└─recvMemberId|string|信息接收会员ID|false|-
└─recvGroupId|string|信息接收会员组ID|false|-
└─recvOrganId|string|信息接收部门ID|false|-
└─recvTargetid|string|接收对象ID或手机号码列表|false|-
└─status|int32|信息状态(0未启用1正常2关闭)|false|-
└─updatorId|string|维护管理用户ID|false|-
└─updateTime|string|修改时间|false|-
└─description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:09",
    "lastTime": "2025-10-20 18:26:09",
    "id": 684,
    "appId": "172",
    "organId": "172",
    "bizType": "8tx2vj",
    "type": 603,
    "title": "60dffo",
    "content": "yjd9fb",
    "msgUrl": "www.ben-grant.info",
    "foreignId": "172",
    "imagePath": "qm0uw2",
    "iconStyle": "t363bq",
    "recvMemberId": "172",
    "recvGroupId": "172",
    "recvOrganId": "172",
    "recvTargetid": "172",
    "status": 354,
    "updatorId": "172",
    "updateTime": "2025-10-20 18:26:09",
    "description": "7j9qa5"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "chn60x",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicNotice Operation. 修改平台公共消息数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/notice/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/json; charset=utf-8

**Description:** PublicNotice Operation. 修改平台公共消息数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|信息ID|false|-
└─appId|string|应用ID|false|-
└─organId|string|机构ID|false|-
└─bizType|string|业务类型1通知公告11促销21模块业务|false|-
└─type|int32|类型，1通知2公告|false|-
└─title|string|信息标题|false|-
└─content|string|信息内容|false|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
└─foreignId|string|信息外键，如CONTENT_ID或短彩信网关信息ID|false|-
└─imagePath|string|图片路径|false|-
└─iconStyle|string|图标样式|false|-
└─recvMemberId|string|信息接收会员ID|false|-
└─recvGroupId|string|信息接收会员组ID|false|-
└─recvOrganId|string|信息接收部门ID|false|-
└─recvTargetid|string|接收对象ID或手机号码列表|false|-
└─status|int32|信息状态(0未启用1正常2关闭)|false|-
└─updatorId|string|维护管理用户ID|false|-
└─updateTime|string|修改时间|false|-
└─description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:09",
    "lastTime": "2025-10-20 18:26:09",
    "id": 830,
    "appId": "172",
    "organId": "172",
    "bizType": "uz9sak",
    "type": 113,
    "title": "reyqyb",
    "content": "brifil",
    "msgUrl": "www.ben-grant.info",
    "foreignId": "172",
    "imagePath": "f1o5ut",
    "iconStyle": "2xms3e",
    "recvMemberId": "172",
    "recvGroupId": "172",
    "recvOrganId": "172",
    "recvTargetid": "172",
    "status": 174,
    "updatorId": "172",
    "updateTime": "2025-10-20 18:26:09",
    "description": "bq7dv6"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "5j2zxx",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicNotice Operation. 删除平台公共消息数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/notice/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicNotice Operation. 删除平台公共消息数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|信息ID:null;1;1,2,3,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "umue8d",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicNotice Operation. 将当前账户的未读消息全部设置为已读.
**URL:** https://linlan.net/eframe_backend/api/system/notice/read/all.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicNotice Operation. 将当前账户的未读消息全部设置为已读.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/read/all.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "8cxhky",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicNotice Operation. 将当前账户的未读消息全部设置为已读.
**URL:** https://linlan.net/eframe_backend/api/system/notice/read/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicNotice Operation. 将当前账户的未读消息全部设置为已读.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|  主键Ids,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/read/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "honykp",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicNotice Operation. 将指定的消息设置为未读状态.
**URL:** https://linlan.net/eframe_backend/api/system/notice/unRead/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicNotice Operation. 将指定的消息设置为未读状态.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|主键ID:null;1;1,2,3,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/unRead/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "6w38t1",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicNotice Operation. . 获取获取未读消息数量
**URL:** https://linlan.net/eframe_backend/api/system/notice/num.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicNotice Operation. . 获取获取未读消息数量

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/num.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "mapKey1": "k0uz5g",
    "mapKey2": "vpze6f"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 平台账号信息读写控制类
### Get CoreAccount list. 获取平台账号信息列表或分页, 返回CoreAccount对象.
**URL:** https://linlan.net/eframe_backend/api/system/plat/account/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get CoreAccount list. 获取平台账号信息列表或分页, 返回CoreAccount对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|string|对接账户ID，外部系统分配的主键|false|-
organId|string|系统机构ID|false|-
appId|string|应用ID|false|-
organName|string|系统机构名称，没有ORGAN_ID时使用|false|-
inoutMode|int32|对接模式0内部接入1内部接出11外部接入20双向40市民云对接类短信平台|false|-
name|string|对接系统或账户名称|false|-
cname|string|对接系统名称中文|false|-
type|int32|对接系统类型1平台应用2APP应用3外部接口|false|-
clientId|string|对接系统CLIENTID，或CORPID|false|-
clientSecret|string|客户密钥|false|-
aesKey|string|AES加解密密钥，备用|false|-
aesIvKey|string|AES iv key，备用|false|-
serverIp|string|对接服务器IP地址或域名|false|-
serverType|string|对接服务器类型，授权类型|false|-
serverUrl|string|默认接口URL，存放CODE_URL，短信网关配置|false|-
serverConf1|string|服务器配置扩展1，MODE为11时，访问IP地址白名单，,分隔；MODE为40时，|false|-
serverConf2|string|服务器配置扩展2，MODE为40时，消息发送方式001,111,100,010等，第一位为发送站内信，第二位为短信，第三位为彩信|false|-
serverConf3|string|服务器配置扩展3，MODE为1时平台类型，如果共用SMY体系，此时填写smy，多个市民云体系的APP可以用一套模式接入；MODE为40时，短信模板|false|-
currCount|int32|当前调用次数|false|-
confLimit|int32|每日限制调用次数(0无限制)|false|-
isAdmin|boolean|是否默认管理后台API账户，是否开启前后端加密，如果开启则使用公钥私钥|false|-
isSingle|boolean|是否限制单设备同时登陆|false|-
isDisabled|boolean|是否禁用0否1是|false|-
status|int32|对接系统状态0不可用1可用2过期|false|-
description|string|对接系统描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/list.do?currCount=973&description=mk5e3p&q=xj91pr&aesIvKey=agkkd4&startTime=2025-10-20 18:20:52&serverConf3=97qujg&limit=10&isAdmin=true&page=1&type=542&organId=172&name=merle.larkin&isSingle=true&id=172&isDisabled=true&serverType=52pas9&spare2=sz291n&aesKey=sn9v9v&serverConf2=ek6oq9&serverConf1=0gqaex&spare1=okw3xd&endTime=2025-10-20 18:20:52&serverIp=137.119.212.174&appId=172&clientId=172&clientSecret=mzpecv&organName=merle.larkin&serverUrl=www.ben-grant.info&cname=merle.larkin&inoutMode=313&orderBy=945&status=58&confLimit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|对接账户ID，外部系统分配的主键|-
└─organId|string|系统机构ID|-
└─appId|string|应用ID|-
└─organName|string|系统机构名称，没有ORGAN_ID时使用|-
└─inoutMode|int32|对接模式0内部接入1内部接出11外部接入20双向40市民云对接类短信平台|-
└─name|string|对接系统或账户名称，开放平台认证平台名称|-
└─cname|string|对接系统名称中文|-
└─type|int32|对接系统类型1平台应用2APP应用3外部接口|-
└─clientId|string|对接系统CLIENTID，或CORPID|-
└─clientSecret|string|客户密钥|-
└─aesKey|string|AES加解密密钥，备用|-
└─aesIvKey|string|AES iv key，备用|-
└─serverIp|string|对接服务器IP地址或域名|-
└─serverType|string|对接服务器类型，授权类型，开放平台认证平台类型|-
└─serverUrl|string|默认接口URL，存放CODE_URL，短信网关配置|-
└─serverConf1|string|服务器配置扩展1，MODE为11时，访问IP地址白名单，,分隔；MODE为40时，|-
└─serverConf2|string|服务器配置扩展2，MODE为40时，消息发送方式001,111,100,010等，第一位为发送站内信，第二位为短信，第三位为彩信|-
└─serverConf3|string|服务器配置扩展3，MODE为1时平台类型，如果共用SMY体系，此时填写smy，多个市民云体系的APP可以用一套模式接入；MODE为40时，短信模板|-
└─currCount|int32|当前调用次数|-
└─confLimit|int32|每日限制调用次数(0无限制)|-
└─isAdmin|boolean|是否默认管理后台API账户，是否开启前后端加密，如果开启则使用公钥私钥|-
└─isSingle|boolean|是否限制单设备同时登陆|-
└─isDisabled|boolean|是否禁用0否1是|-
└─status|int32|对接系统状态0不可用1可用2过期|-
└─description|string|对接系统描述|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
└─inOrganName|string|内部系统名称|-
└─userName|string|用户名称|-
└─appName|string|应用名称|-
└─inoutModeName|string|对接模式名字|-
└─typeName|string|平台类型名字|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:05",
      "lastTime": "2025-10-20 18:26:05",
      "id": "172",
      "organId": "172",
      "appId": "172",
      "organName": "merle.larkin",
      "inoutMode": 5,
      "name": "merle.larkin",
      "cname": "merle.larkin",
      "type": 250,
      "clientId": "172",
      "clientSecret": "0hngib",
      "aesKey": "t94ozb",
      "aesIvKey": "siuxh2",
      "serverIp": "137.119.212.174",
      "serverType": "8k8w00",
      "serverUrl": "www.ben-grant.info",
      "serverConf1": "5pkow5",
      "serverConf2": "55ehor",
      "serverConf3": "lry4hq",
      "currCount": 964,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 327,
      "description": "nl6iok",
      "spare1": "7qx6fl",
      "spare2": "p6qz5p",
      "inOrganName": "merle.larkin",
      "userName": "merle.larkin",
      "appName": "merle.larkin",
      "inoutModeName": "merle.larkin",
      "typeName": "merle.larkin"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 平台账户生成密钥对
**URL:** https://linlan.net/eframe_backend/api/system/plat/account/getClientSecret.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 平台账户生成密钥对

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
clientId|string| 客户ID|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/getClientSecret.do?clientId=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|对接账户ID，外部系统分配的主键|-
└─organId|string|系统机构ID|-
└─appId|string|应用ID|-
└─organName|string|系统机构名称，没有ORGAN_ID时使用|-
└─inoutMode|int32|对接模式0内部接入1内部接出11外部接入20双向40市民云对接类短信平台|-
└─name|string|对接系统或账户名称，开放平台认证平台名称|-
└─cname|string|对接系统名称中文|-
└─type|int32|对接系统类型1平台应用2APP应用3外部接口|-
└─clientId|string|对接系统CLIENTID，或CORPID|-
└─clientSecret|string|客户密钥|-
└─aesKey|string|AES加解密密钥，备用|-
└─aesIvKey|string|AES iv key，备用|-
└─serverIp|string|对接服务器IP地址或域名|-
└─serverType|string|对接服务器类型，授权类型，开放平台认证平台类型|-
└─serverUrl|string|默认接口URL，存放CODE_URL，短信网关配置|-
└─serverConf1|string|服务器配置扩展1，MODE为11时，访问IP地址白名单，,分隔；MODE为40时，|-
└─serverConf2|string|服务器配置扩展2，MODE为40时，消息发送方式001,111,100,010等，第一位为发送站内信，第二位为短信，第三位为彩信|-
└─serverConf3|string|服务器配置扩展3，MODE为1时平台类型，如果共用SMY体系，此时填写smy，多个市民云体系的APP可以用一套模式接入；MODE为40时，短信模板|-
└─currCount|int32|当前调用次数|-
└─confLimit|int32|每日限制调用次数(0无限制)|-
└─isAdmin|boolean|是否默认管理后台API账户，是否开启前后端加密，如果开启则使用公钥私钥|-
└─isSingle|boolean|是否限制单设备同时登陆|-
└─isDisabled|boolean|是否禁用0否1是|-
└─status|int32|对接系统状态0不可用1可用2过期|-
└─description|string|对接系统描述|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
└─inOrganName|string|内部系统名称|-
└─userName|string|用户名称|-
└─appName|string|应用名称|-
└─inoutModeName|string|对接模式名字|-
└─typeName|string|平台类型名字|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:05",
      "lastTime": "2025-10-20 18:26:05",
      "id": "172",
      "organId": "172",
      "appId": "172",
      "organName": "merle.larkin",
      "inoutMode": 990,
      "name": "merle.larkin",
      "cname": "merle.larkin",
      "type": 607,
      "clientId": "172",
      "clientSecret": "8fhxyl",
      "aesKey": "8o3jox",
      "aesIvKey": "aoq3p7",
      "serverIp": "137.119.212.174",
      "serverType": "6re4xd",
      "serverUrl": "www.ben-grant.info",
      "serverConf1": "z2f7mu",
      "serverConf2": "eug3i1",
      "serverConf3": "7qljo2",
      "currCount": 965,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 511,
      "description": "nh2xw6",
      "spare1": "nyuyl1",
      "spare2": "2lnmbk",
      "inOrganName": "merle.larkin",
      "userName": "merle.larkin",
      "appName": "merle.larkin",
      "inoutModeName": "merle.larkin",
      "typeName": "merle.larkin"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 生成平台密钥对
**URL:** https://linlan.net/eframe_backend/api/system/plat/account/getKeyParity.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 生成平台密钥对

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|   账号ID|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/getKeyParity.do?id=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|对接账户ID，外部系统分配的主键|-
└─organId|string|系统机构ID|-
└─appId|string|应用ID|-
└─organName|string|系统机构名称，没有ORGAN_ID时使用|-
└─inoutMode|int32|对接模式0内部接入1内部接出11外部接入20双向40市民云对接类短信平台|-
└─name|string|对接系统或账户名称，开放平台认证平台名称|-
└─cname|string|对接系统名称中文|-
└─type|int32|对接系统类型1平台应用2APP应用3外部接口|-
└─clientId|string|对接系统CLIENTID，或CORPID|-
└─clientSecret|string|客户密钥|-
└─aesKey|string|AES加解密密钥，备用|-
└─aesIvKey|string|AES iv key，备用|-
└─serverIp|string|对接服务器IP地址或域名|-
└─serverType|string|对接服务器类型，授权类型，开放平台认证平台类型|-
└─serverUrl|string|默认接口URL，存放CODE_URL，短信网关配置|-
└─serverConf1|string|服务器配置扩展1，MODE为11时，访问IP地址白名单，,分隔；MODE为40时，|-
└─serverConf2|string|服务器配置扩展2，MODE为40时，消息发送方式001,111,100,010等，第一位为发送站内信，第二位为短信，第三位为彩信|-
└─serverConf3|string|服务器配置扩展3，MODE为1时平台类型，如果共用SMY体系，此时填写smy，多个市民云体系的APP可以用一套模式接入；MODE为40时，短信模板|-
└─currCount|int32|当前调用次数|-
└─confLimit|int32|每日限制调用次数(0无限制)|-
└─isAdmin|boolean|是否默认管理后台API账户，是否开启前后端加密，如果开启则使用公钥私钥|-
└─isSingle|boolean|是否限制单设备同时登陆|-
└─isDisabled|boolean|是否禁用0否1是|-
└─status|int32|对接系统状态0不可用1可用2过期|-
└─description|string|对接系统描述|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
└─inOrganName|string|内部系统名称|-
└─userName|string|用户名称|-
└─appName|string|应用名称|-
└─inoutModeName|string|对接模式名字|-
└─typeName|string|平台类型名字|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:05",
      "lastTime": "2025-10-20 18:26:05",
      "id": "172",
      "organId": "172",
      "appId": "172",
      "organName": "merle.larkin",
      "inoutMode": 291,
      "name": "merle.larkin",
      "cname": "merle.larkin",
      "type": 627,
      "clientId": "172",
      "clientSecret": "0wogva",
      "aesKey": "s384yd",
      "aesIvKey": "k3cpj4",
      "serverIp": "137.119.212.174",
      "serverType": "0mxcip",
      "serverUrl": "www.ben-grant.info",
      "serverConf1": "4noehv",
      "serverConf2": "lq0h9o",
      "serverConf3": "jx7o4j",
      "currCount": 639,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 615,
      "description": "ax2ctx",
      "spare1": "4qa5d2",
      "spare2": "n2b5lp",
      "inOrganName": "merle.larkin",
      "userName": "merle.larkin",
      "appName": "merle.larkin",
      "inoutModeName": "merle.larkin",
      "typeName": "merle.larkin"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get CoreAccount by id. 主键获取平台账号信息详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/account/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get CoreAccount by id. 主键获取平台账号信息详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|信息ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|对接账户ID，外部系统分配的主键|-
└─organId|string|系统机构ID|-
└─appId|string|应用ID|-
└─organName|string|系统机构名称，没有ORGAN_ID时使用|-
└─inoutMode|int32|对接模式0内部接入1内部接出11外部接入20双向40市民云对接类短信平台|-
└─name|string|对接系统或账户名称，开放平台认证平台名称|-
└─cname|string|对接系统名称中文|-
└─type|int32|对接系统类型1平台应用2APP应用3外部接口|-
└─clientId|string|对接系统CLIENTID，或CORPID|-
└─clientSecret|string|客户密钥|-
└─aesKey|string|AES加解密密钥，备用|-
└─aesIvKey|string|AES iv key，备用|-
└─serverIp|string|对接服务器IP地址或域名|-
└─serverType|string|对接服务器类型，授权类型，开放平台认证平台类型|-
└─serverUrl|string|默认接口URL，存放CODE_URL，短信网关配置|-
└─serverConf1|string|服务器配置扩展1，MODE为11时，访问IP地址白名单，,分隔；MODE为40时，|-
└─serverConf2|string|服务器配置扩展2，MODE为40时，消息发送方式001,111,100,010等，第一位为发送站内信，第二位为短信，第三位为彩信|-
└─serverConf3|string|服务器配置扩展3，MODE为1时平台类型，如果共用SMY体系，此时填写smy，多个市民云体系的APP可以用一套模式接入；MODE为40时，短信模板|-
└─currCount|int32|当前调用次数|-
└─confLimit|int32|每日限制调用次数(0无限制)|-
└─isAdmin|boolean|是否默认管理后台API账户，是否开启前后端加密，如果开启则使用公钥私钥|-
└─isSingle|boolean|是否限制单设备同时登陆|-
└─isDisabled|boolean|是否禁用0否1是|-
└─status|int32|对接系统状态0不可用1可用2过期|-
└─description|string|对接系统描述|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{"success":true,"code":"0","msg":"正常","data":Error restful return.,"requestId":"172","timestamp":"2025-10-20 18:20:52"}
```

### CoreAccount Operation. 新增平台账号信息数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/account/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** CoreAccount Operation. 新增平台账号信息数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/save.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "m4l9go",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreAccount Operation. 修改平台账号信息数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/account/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** CoreAccount Operation. 修改平台账号信息数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/update.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "xdaqwm",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreAccount Operation. 删除平台账号信息数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/account/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** CoreAccount Operation. 删除平台账号信息数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|信息ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3segf5",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 平台首页入口
### 访问首页，提示语
**URL:** https://linlan.net/eframe_backend/.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 访问首页，提示语

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "9jabaa",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 工作台应用支撑统计
**URL:** https://linlan.net/eframe_backend/api/admin/index/application.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 工作台应用支撑统计

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/application.do?page=1&limit=10&orderBy=145&q=71h4fq&startTime=2025-10-20 18:20:52&endTime=2025-10-20 18:20:52
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─organNum|string|机构数|-
└─deptNum|string|部门数|-
└─peopleNum|string|人员数|-
└─roleNum|string|角色数|-
└─dicTypeNum|string|数据字典分类数|-
└─appNum|string|应用数|-
└─fileNum|string|资源存储数|-
└─paramNum|string|参数数|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "organNum": "50dm8l",
      "deptNum": "lurmoi",
      "peopleNum": "p5ghs2",
      "roleNum": "uyugtd",
      "dicTypeNum": "f0w8i6",
      "appNum": "j0izx3",
      "fileNum": "8wqkc8",
      "paramNum": "smmlgz"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 工作台要素支撑统计
**URL:** https://linlan.net/eframe_backend/api/admin/index/element.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 工作台要素支撑统计

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/element.do?startTime=2025-10-20 18:20:52&endTime=2025-10-20 18:20:52&q=9fc4gf&page=1&orderBy=999&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─objectNum|string|对象数|-
└─modelNum|string|模型数|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "objectNum": "xc310m",
      "modelNum": "ao89yp"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 工作台管理支撑统计
**URL:** https://linlan.net/eframe_backend/api/admin/index/manage.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 工作台管理支撑统计

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/manage.do?q=5p6jqp&endTime=2025-10-20 18:20:52&startTime=2025-10-20 18:20:52&orderBy=494&limit=10&page=1
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─siteNum|string|站点数|-
└─accountNum|string|平台账户数|-
└─serviceOrganNum|string|服务商数|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "siteNum": "j0lkqn",
      "accountNum": "45mx52",
      "serviceOrganNum": "rr5vs0"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 应用管理读写控制类
### 获取应用下拉列表
**URL:** https://linlan.net/eframe_backend/api/system/app/selectList.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取应用下拉列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
ftpId|string|资源存储ID|false|-
domainId|string|域平台编号|false|-
organId|string|单位编码，所属单位，管理单位|false|-
xzqhId|int64|应用适用顶级行政区划ID|false|-
sertypeId|string|应用服务类型ID|false|-
name|string|应用名称|false|-
path|string|应用访问路径|false|-
appType|string|应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选|false|-
isSite|boolean|是否站点，如果是站点，则SITE内存在记录|false|-
isDisabled|boolean|是否禁用0否1是|false|-
isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|false|-
status|int32|状态0异常关闭1正常2升级3锁定|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-
existKey|string|关键字查询，以前的保留，以后用q|false|-
mode|int32|模式|false|-
ids|array|No comments found.|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/selectList.do?name=merle.larkin&isDisabled=true&description=nwg17m&existKey=tca3l9&ftpId=172&q=wk39e3&endTime=2025-10-20 18:20:52&ids=9tgl9y&ids=9tgl9y&limit=10&mode=679&appType=4gawjs&status=110&page=1&domainId=172&sertypeId=172&delFlag=5&isMobileApp=true&xzqhId=456&orderBy=122&startTime=2025-10-20 18:20:52&path=t02zau&organId=172&isSite=true
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|应用ID|-
└─ftpId|string|文件上传配置ID|-
└─domainId|string|域平台编号|-
└─organId|string|单位编码，所属单位，管理单位|-
└─xzqhId|int64|应用适用顶级行政区划ID|-
└─sertypeId|string|应用服务类型ID|-
└─name|string|应用名称|-
└─path|string|应用访问路径|-
└─appType|string|应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选|-
└─isSite|boolean|是否站点，如果是站点，则SITE内存在记录|-
└─isDisabled|boolean|是否禁用0否1是|-
└─isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|-
└─status|int32|状态0异常关闭1正常2升级3锁定|-
└─priority|int32|排序|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─deleteTime|string|删除时间|-
└─description|string|描述|-
└─spare1|string|备用1，LOGO图标|-
└─spare2|string|备用2|-
└─xzqhName|string|行政区划名称|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:02",
      "lastTime": "2025-10-20 18:26:02",
      "id": "172",
      "ftpId": "172",
      "domainId": "172",
      "organId": "172",
      "xzqhId": 57,
      "sertypeId": "172",
      "name": "merle.larkin",
      "path": "o5vpnm",
      "appType": "h3yxwv",
      "isSite": true,
      "isDisabled": true,
      "isMobileApp": true,
      "status": 535,
      "priority": 885,
      "delFlag": 5,
      "deleteTime": "2025-10-20 18:26:02",
      "description": "xmcfzd",
      "spare1": "8llbhh",
      "spare2": "v2kxqr",
      "xzqhName": "merle.larkin"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取应用列表
**URL:** https://linlan.net/eframe_backend/api/system/app/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取应用列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
ftpId|string|资源存储ID|false|-
domainId|string|域平台编号|false|-
organId|string|单位编码，所属单位，管理单位|false|-
xzqhId|int64|应用适用顶级行政区划ID|false|-
sertypeId|string|应用服务类型ID|false|-
name|string|应用名称|false|-
path|string|应用访问路径|false|-
appType|string|应用类型，B/S，C/S|false|-
isSite|boolean|是否站点，如果是站点，则SITE内存在记录|false|-
isDisabled|boolean|是否禁用0否1是|false|-
isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|false|-
status|int32|状态0异常关闭1正常2升级3锁定|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-
existKey|string|关键字查询，以前的保留，以后用q|false|-
mode|int32|模式|false|-
ids|array|No comments found.|false|-
idArr|string|id字符串|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/list.do?appType=4x5nqw&idArr=zldcpp&isSite=true&mode=391&isDisabled=true&startTime=2025-10-20 18:20:52&organId=172&domainId=172&limit=10&page=1&existKey=10wbvq&name=merle.larkin&orderBy=892&ftpId=172&delFlag=5&ids=hchm8r&ids=hchm8r&path=7maqge&q=4klvwe&description=nt14oe&sertypeId=172&isMobileApp=true&status=343&endTime=2025-10-20 18:20:52&xzqhId=112
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ftpId|string|文件上传配置ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domainId|string|域平台编号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|单位编码，所属单位，管理单位|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─xzqhId|int64|应用适用顶级行政区划ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sertypeId|string|应用服务类型ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|应用名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|应用访问路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appType|string|应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSite|boolean|是否站点，如果是站点，则SITE内存在记录|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0异常关闭1正常2升级3锁定|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deleteTime|string|删除时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1，LOGO图标|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─xzqhName|string|行政区划名称|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 5,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:26:02",
        "lastTime": "2025-10-20 18:26:02",
        "id": "172",
        "ftpId": "172",
        "domainId": "172",
        "organId": "172",
        "xzqhId": 738,
        "sertypeId": "172",
        "name": "merle.larkin",
        "path": "l36pf5",
        "appType": "x4ptvp",
        "isSite": true,
        "isDisabled": true,
        "isMobileApp": true,
        "status": 85,
        "priority": 379,
        "delFlag": 5,
        "deleteTime": "2025-10-20 18:26:02",
        "description": "u5ubgv",
        "spare1": "1jj7fz",
        "spare2": "bbdfge",
        "xzqhName": "merle.larkin"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 应用列表导出
**URL:** https://linlan.net/eframe_backend/api/system/app/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 应用列表导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
ftpId|string|资源存储ID|false|-
domainId|string|域平台编号|false|-
organId|string|单位编码，所属单位，管理单位|false|-
xzqhId|int64|应用适用顶级行政区划ID|false|-
sertypeId|string|应用服务类型ID|false|-
name|string|应用名称|false|-
path|string|应用访问路径|false|-
appType|string|应用类型，B/S，C/S|false|-
isSite|boolean|是否站点，如果是站点，则SITE内存在记录|false|-
isDisabled|boolean|是否禁用0否1是|false|-
isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|false|-
status|int32|状态0异常关闭1正常2升级3锁定|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-
existKey|string|关键字查询，以前的保留，以后用q|false|-
mode|int32|模式|false|-
ids|array|No comments found.|false|-
idArr|string|id字符串|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/export.do --data 'startTime=2025-10-20 18:20:52&q=2sip52&idArr=hcn4t9&mode=387&xzqhId=58&organId=172&orderBy=672&page=1&isDisabled=true&limit=10&endTime=2025-10-20 18:20:52&isMobileApp=true&status=451&ftpId=172&domainId=172&path=9zeswt&existKey=6azfd8&description=qyjv4f&appType=wc8xil&ids=y2wrgi&ids=y2wrgi&name=merle.larkin&sertypeId=172&isSite=true&delFlag=5'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "lpa9x9",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据参数编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/system/app/{appId}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据参数编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
appId|string| 参数ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/172.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|应用ID|-
└─ftpId|string|文件上传配置ID|-
└─domainId|string|域平台编号|-
└─organId|string|单位编码，所属单位，管理单位|-
└─xzqhId|int64|应用适用顶级行政区划ID|-
└─sertypeId|string|应用服务类型ID|-
└─name|string|应用名称|-
└─path|string|应用访问路径|-
└─appType|string|应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选|-
└─isSite|boolean|是否站点，如果是站点，则SITE内存在记录|-
└─isDisabled|boolean|是否禁用0否1是|-
└─isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|-
└─status|int32|状态0异常关闭1正常2升级3锁定|-
└─priority|int32|排序|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─deleteTime|string|删除时间|-
└─description|string|描述|-
└─spare1|string|备用1，LOGO图标|-
└─spare2|string|备用2|-
└─xzqhName|string|行政区划名称|-
└─ftpName|string|全局文件上传服务器名称|-
└─sertypeName|string|服务类型名称|-
└─domainName|string|域平台名称|-
└─organName|string|机构名称|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:02",
    "lastTime": "2025-10-20 18:26:02",
    "id": "172",
    "ftpId": "172",
    "domainId": "172",
    "organId": "172",
    "xzqhId": 618,
    "sertypeId": "172",
    "name": "merle.larkin",
    "path": "eyd3xs",
    "appType": "l5u96g",
    "isSite": true,
    "isDisabled": true,
    "isMobileApp": true,
    "status": 425,
    "priority": 657,
    "delFlag": 5,
    "deleteTime": "2025-10-20 18:26:02",
    "description": "ldo324",
    "spare1": "n47owg",
    "spare2": "0kvjae",
    "xzqhName": "merle.larkin",
    "ftpName": "merle.larkin",
    "sertypeName": "merle.larkin",
    "domainName": "merle.larkin",
    "organName": "merle.larkin"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增应用配置
**URL:** https://linlan.net/eframe_backend/api/system/app/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/json; charset=utf-8

**Description:** 新增应用配置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─id|string|应用ID|false|-
└─ftpId|string|文件上传配置ID|false|-
└─ftpName|string|资源仓库名称|false|-
└─domainId|string|域平台编号|false|-
└─domainName|string|域平台名称|false|-
└─organId|string|单位编码，所属单位，管理单位|false|-
└─organName|string|机构名称|false|-
└─xzqhId|int64|应用适用顶级行政区划ID|false|-
└─xzqhName|string|应用适用顶级行政区划名称|false|-
└─sertypeId|string|应用服务类型ID|false|-
└─sertypeName|string|服务类型名称|false|-
└─name|string|应用名称|false|-
└─path|string|应用访问路径|false|-
└─appType|string|应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选|false|-
└─isSite|boolean|是否站点，如果是站点，则SITE内存在记录|false|-
└─isOpen|boolean|是否启用0否1是|false|-
└─isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|false|-
└─status|int32|状态0异常关闭1正常2升级3锁定|false|-
└─statusName|string|状态，0异常关闭1正常2升级|false|-
└─priority|int32|排序|false|-
└─createTime|string|创建时间|false|-
└─description|string|描述|false|-
└─spare1|string|备用1，LOGO图标|false|-
└─statusMap|object|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/save.do --data '{
  "data": {
    "id": "172",
    "ftpId": "172",
    "ftpName": "merle.larkin",
    "domainId": "172",
    "domainName": "merle.larkin",
    "organId": "172",
    "organName": "merle.larkin",
    "xzqhId": 830,
    "xzqhName": "merle.larkin",
    "sertypeId": "172",
    "sertypeName": "merle.larkin",
    "name": "merle.larkin",
    "path": "sggo7a",
    "appType": "34plp3",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 61,
    "statusName": "merle.larkin",
    "priority": 112,
    "createTime": "2025-10-20 18:26:02",
    "description": "vvi26d",
    "spare1": "7en5ji",
    "statusMap": {
      "mapKey": "xvw2mv"
    }
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "gb0bp8",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改应用配置
**URL:** https://linlan.net/eframe_backend/api/system/app/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/json; charset=utf-8

**Description:** 修改应用配置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─id|string|应用ID|false|-
└─ftpId|string|文件上传配置ID|false|-
└─ftpName|string|资源仓库名称|false|-
└─domainId|string|域平台编号|false|-
└─domainName|string|域平台名称|false|-
└─organId|string|单位编码，所属单位，管理单位|false|-
└─organName|string|机构名称|false|-
└─xzqhId|int64|应用适用顶级行政区划ID|false|-
└─xzqhName|string|应用适用顶级行政区划名称|false|-
└─sertypeId|string|应用服务类型ID|false|-
└─sertypeName|string|服务类型名称|false|-
└─name|string|应用名称|false|-
└─path|string|应用访问路径|false|-
└─appType|string|应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选|false|-
└─isSite|boolean|是否站点，如果是站点，则SITE内存在记录|false|-
└─isOpen|boolean|是否启用0否1是|false|-
└─isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|false|-
└─status|int32|状态0异常关闭1正常2升级3锁定|false|-
└─statusName|string|状态，0异常关闭1正常2升级|false|-
└─priority|int32|排序|false|-
└─createTime|string|创建时间|false|-
└─description|string|描述|false|-
└─spare1|string|备用1，LOGO图标|false|-
└─statusMap|object|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/update.do --data '{
  "data": {
    "id": "172",
    "ftpId": "172",
    "ftpName": "merle.larkin",
    "domainId": "172",
    "domainName": "merle.larkin",
    "organId": "172",
    "organName": "merle.larkin",
    "xzqhId": 944,
    "xzqhName": "merle.larkin",
    "sertypeId": "172",
    "sertypeName": "merle.larkin",
    "name": "merle.larkin",
    "path": "yqbxy0",
    "appType": "9tdsm2",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 324,
    "statusName": "merle.larkin",
    "priority": 304,
    "createTime": "2025-10-20 18:26:02",
    "description": "6grh2f",
    "spare1": "m0usod",
    "statusMap": {
      "mapKey": "8z6lyt"
    }
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "syirib",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除应用配置
**URL:** https://linlan.net/eframe_backend/api/system/app/delete/{appIds}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除应用配置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
appIds|array| 应用Ids,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "o7inva",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 应用初始化
**URL:** https://linlan.net/eframe_backend/api/system/app/init/{id}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/json; charset=utf-8

**Description:** 应用初始化

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string| 应用ID|true|-

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─id|string|应用ID，导入和导出的APPID|false|-
└─menuJsons|object|菜单JSON对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─size|int32|No comments found.|false|-
└─initJson|object|初始化JSON对象|false|-
└─username|string|初始化用户名|false|-
└─password|string|初始化密码|false|-
└─initPath|string|导入的文件路径|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/init/172.do --data '{
  "data": {
    "id": "172",
    "menuJsons": {
      "size": 10
    },
    "initJson": {},
    "username": "merle.larkin",
    "password": "q22izs",
    "initPath": "i77abu"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "waring": "You may have used non-display generics."
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 刷新参数缓存
**URL:** https://linlan.net/eframe_backend/api/system/app/refreshCache.do

**Type:** DELETE

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 刷新参数缓存

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/refreshCache.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "jqpq5c",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 顶级行政区划下拉框
**URL:** https://linlan.net/eframe_backend/api/system/app/xzqh/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 顶级行政区划下拉框

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
parentId|int64|行政区划父节点|false|-
countryId|string|国家或地区编号|false|-
areatypeId|string|地域级别ID|false|-
lft|int32|树左边|false|-
rgt|int32|树右边|false|-
code|string|行政区划代码|false|-
name|string|行政区划名称|false|-
nameTotal|string|行政区划完整名称|false|-
sname|string|行政区划简洁名称|false|-
nameEn|string|名称英文|false|-
searchCode|string|快速码|false|-
isDisplay|boolean|是否显示(1显示0不显示)|false|-
hasContent|boolean|是否有内容(1有内容，编号单位等)|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-
parentIds|array|父节点集合|false|-
areatypeIds|array|父节点集合|false|-
likeQuery|string|父节点集合|false|-
deleteTime|string|删除时间|false|-
ids|array|id集合|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/xzqh/list.do?description=hgbs5d&parentId=275&nameEn=pxx88h&parentIds=vptanw&parentIds=vptanw&lft=969&deleteTime=2025-10-20 18:20:52&endTime=2025-10-20 18:20:52&areatypeId=172&orderBy=521&rgt=69&delFlag=5&page=1&ids=5v321r&ids=5v321r&likeQuery=2i6ean&isDisplay=true&sname=merle.larkin&areatypeIds=b4iidv&areatypeIds=b4iidv&q=7zww6c&startTime=2025-10-20 18:20:52&limit=10&countryId=172&searchCode=81486&code=81486&name=merle.larkin&nameTotal=l0g996&hasContent=true
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|行政区划编号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|行政区划父节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─countryId|string|国家或地区编号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areatypeId|string|地域级别ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lft|int32|树左边|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─rgt|int32|树右边|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|行政区划代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|行政区划名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameTotal|string|行政区划完整名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|行政区划简洁名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nameEn|string|名称英文|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|快速码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisplay|boolean|是否显示(1显示0不显示)|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─hasContent|boolean|是否有内容(1有内容，编号单位等)|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deleteTime|string|删除时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─countryName|string|全局国家或地区类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentName|string|全局行政区划父类名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areatypeName|string|行政区划子节点列表集|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 66,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:26:03",
        "lastTime": "2025-10-20 18:26:03",
        "id": 393,
        "parentId": 988,
        "countryId": "172",
        "areatypeId": "172",
        "lft": 273,
        "rgt": 572,
        "code": "81486",
        "name": "merle.larkin",
        "nameTotal": "4zss2h",
        "sname": "merle.larkin",
        "nameEn": "ngh7md",
        "searchCode": "81486",
        "isDisplay": true,
        "hasContent": true,
        "priority": 179,
        "delFlag": 5,
        "deleteTime": "2025-10-20 18:26:03",
        "description": "4mt87w",
        "countryName": "merle.larkin",
        "parentName": "merle.larkin",
        "areatypeName": "merle.larkin"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 管理单位下拉框
**URL:** https://linlan.net/eframe_backend/api/system/app/organ/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 管理单位下拉框

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
xzqhId|int64|单位所在地行政区划ID，区县级|false|-
orgtypeId|string|机构类型|false|-
name|string|名称|false|-
source|int32|创建来源类型0后台，1前台|false|-
unionCode|string|统一信用代码|false|-
organCode|string|组织机构代码，地域类机构的地域ID|false|-
organName|string|组织机构名称|false|-
createType|int32|创建方式0导入1录入2授权，1为唯一标记，2可能为重复的数据|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-
spare1|string|备用1，地域类机构的地域CODE，本地编码|false|-
spare2|string|备用2，地域类机构外部ID|false|-
key|string|关键字|false|-
ids|array|id集合|false|-
isOrganWork|string|是否工作机构|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/organ/list.do?spare2=y50yo6&spare1=jpbb4z&organName=merle.larkin&page=1&limit=10&name=merle.larkin&organCode=81486&startTime=2025-10-20 18:20:52&orderBy=539&xzqhId=864&unionCode=81486&key=55epwl&delFlag=5&description=iqh23d&ids=vqzexo&ids=vqzexo&source=476&endTime=2025-10-20 18:20:52&isOrganWork=ikuh48&createType=303&q=di0w3w&orgtypeId=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cmsKey|string|规格类型ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cmsValue|string|站点ID|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 424,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:26:03",
        "lastTime": "2025-10-20 18:26:03",
        "cmsKey": "dbg5ca",
        "cmsValue": "ag8syl"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 数据字典信息读写
### 获取数据字典信息列表
**URL:** https://linlan.net/eframe_backend/api/system/dictionary/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取数据字典信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
cddId|int64|字典编码|false|-
dictSort|int64|字典排序|false|-
name|string|字典名称|false|-
dictLabel|string|字典标签|false|-
cddValue|string|字典键值|false|-
typeCode|string|字典类型|false|-
cssClass|string|样式属性（其他样式扩展）|false|-
listClass|string|表格字典样式|false|-
isDefault|string|是否默认（Y是 N否）|false|-
status|string|状态（0未生效 1正常）|false|-
remark|string|备注|false|-
key|string|关键字|false|-
searchCode|string|快速码|false|-
parentId|int64|父节点ID|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/list.do?cddValue=qkaard&orderBy=982&listClass=y5qby3&status=zh2qn2&dictLabel=egairw&parentId=107&endTime=2025-10-20 18:20:52&cddId=785&typeCode=81486&dictSort=386&cssClass=p9fk8e&remark=g226gh&isDefault=6xqgy9&name=merle.larkin&page=1&startTime=2025-10-20 18:20:52&searchCode=81486&limit=10&q=hy4pxd&key=isotuk
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cddId|int64|字典编码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeCode|string|字典排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|字典标签|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|字典键值|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|字典类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cddValue|string|字典值|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|快速码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remark|string|备注|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dictLabel|string|备注|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeCodeName|string|类型名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentName|string|父节点名称|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 807,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cddId": 509,
        "typeCode": "81486",
        "parentId": 551,
        "name": "merle.larkin",
        "sname": "merle.larkin",
        "cddValue": "0o0bur",
        "searchCode": "81486",
        "priority": 519,
        "createTime": "2025-10-20 18:26:06",
        "remark": "tt0nxe",
        "dictLabel": "uubcqh",
        "typeCodeName": "merle.larkin",
        "parentName": "merle.larkin"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 数据字典导出
**URL:** https://linlan.net/eframe_backend/api/system/dictionary/export.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 数据字典导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
cddId|int64|字典编码|false|-
dictSort|int64|字典排序|false|-
name|string|字典名称|false|-
dictLabel|string|字典标签|false|-
cddValue|string|字典键值|false|-
typeCode|string|字典类型|false|-
cssClass|string|样式属性（其他样式扩展）|false|-
listClass|string|表格字典样式|false|-
isDefault|string|是否默认（Y是 N否）|false|-
status|string|状态（0未生效 1正常）|false|-
remark|string|备注|false|-
key|string|关键字|false|-
searchCode|string|快速码|false|-
parentId|int64|父节点ID|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/export.do --data 'q=uvzshq&dictLabel=ceyeha&cddValue=782vi3&orderBy=396&limit=10&isDefault=pj6f9g&listClass=n7aqm1&parentId=666&cddId=662&page=1&remark=jsu342&dictSort=917&key=7e84bn&searchCode=81486&startTime=2025-10-20 18:20:52&typeCode=81486&endTime=2025-10-20 18:20:52&name=merle.larkin&cssClass=znsurs&status=8om0gi'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "cylshd",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 查询字典数据详细
**URL:** https://linlan.net/eframe_backend/api/system/dictionary/{dictId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询字典数据详细

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
dictId|int64|   字典ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/352.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─cddId|int64|字典编码|-
└─typeCode|string|字典排序|-
└─parentId|int64|字典标签|-
└─name|string|字典键值|-
└─sname|string|字典类型|-
└─cddValue|string|字典值|-
└─searchCode|string|快速码|-
└─priority|int32|排序码|-
└─createTime|string|创建时间|-
└─remark|string|备注|-
└─dictLabel|string|备注|-
└─typeCodeName|string|类型名称|-
└─parentName|string|父节点名称|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "cddId": 987,
    "typeCode": "81486",
    "parentId": 745,
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "cddValue": "rjwed0",
    "searchCode": "81486",
    "priority": 342,
    "createTime": "2025-10-20 18:26:06",
    "remark": "gfofb0",
    "dictLabel": "zm98xw",
    "typeCodeName": "merle.larkin",
    "parentName": "merle.larkin"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据字典类型查询字典数据信息
**URL:** https://linlan.net/eframe_backend/api/system/dictionary/type/{dictType}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据字典类型查询字典数据信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
dictType|string| 字典分类|true|-

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
typeCode|string|字典类型代码|false|-
parentId|string|字典父节点编号，简单的字典使用|false|-
zparentId|string|父节点ID|false|-
roletypeId|string|角色分类ID|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/type/x1gydn.do?zparentId=172&roletypeId=172&typeCode=81486&parentId=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "waring": "You may have used non-display generics."
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增字典
**URL:** https://linlan.net/eframe_backend/api/system/dictionary/save.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增字典

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─cddId|int64|字典编码|false|-
└─typeCode|string|字典排序|false|-
└─parentId|int64|字典标签|false|-
└─name|string|字典键值|false|-
└─sname|string|字典类型|false|-
└─cddValue|string|字典值|false|-
└─searchCode|string|快速码|false|-
└─priority|int32|排序码|false|-
└─createTime|string|创建时间|false|-
└─remark|string|备注|false|-
└─dictLabel|string|备注|false|-
└─typeCodeName|string|类型名称|false|-
└─parentName|string|父节点名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/save.do --data '{
  "data": {
    "cddId": 204,
    "typeCode": "81486",
    "parentId": 566,
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "cddValue": "n7imsg",
    "searchCode": "81486",
    "priority": 169,
    "createTime": "2025-10-20 18:26:06",
    "remark": "j9m9vl",
    "dictLabel": "bpwdz2",
    "typeCodeName": "merle.larkin",
    "parentName": "merle.larkin"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "n5j52j",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改保存字典
**URL:** https://linlan.net/eframe_backend/api/system/dictionary/update.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改保存字典

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─cddId|int64|字典编码|false|-
└─typeCode|string|字典排序|false|-
└─parentId|int64|字典标签|false|-
└─name|string|字典键值|false|-
└─sname|string|字典类型|false|-
└─cddValue|string|字典值|false|-
└─searchCode|string|快速码|false|-
└─priority|int32|排序码|false|-
└─createTime|string|创建时间|false|-
└─remark|string|备注|false|-
└─dictLabel|string|备注|false|-
└─typeCodeName|string|类型名称|false|-
└─parentName|string|父节点名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/update.do --data '{
  "data": {
    "cddId": 329,
    "typeCode": "81486",
    "parentId": 913,
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "cddValue": "yozulx",
    "searchCode": "81486",
    "priority": 158,
    "createTime": "2025-10-20 18:26:06",
    "remark": "h51nx3",
    "dictLabel": "i6uwna",
    "typeCodeName": "merle.larkin",
    "parentName": "merle.larkin"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "qt3zvv",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除字典
**URL:** https://linlan.net/eframe_backend/api/system/dictionary/delete/{dictIds}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除字典

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
dictIds|array|  字典Ids,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ccv6sg",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 通用字典树获取接口
**URL:** https://linlan.net/eframe_backend/api/system/comm/tree.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 通用字典树获取接口

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
type|string|树类型：参见 TreeTypeEnum|false|-
wlType|string|机构类型|false|-
subType|string|树子类型|false|-
parentId|string|父id, 空的时候查根节点   TYPE:ID|false|-
refresh|string|刷新缓存：Y 是，N 否,<br>缓存刷新时间，10分钟。|false|-
positionType|string|岗位层级类型|false|-
groupId|string|会员组ID,返回岗位是否绑定|false|-
roleId|string|角色ID|false|-
roletypeId|string|角色类型ID|false|-
positionId|string|岗位ID|false|-
roleTypeId|string|角色类型id，注意大小写|false|-
refType|string|标签类型过滤|false|-
organwId|string|如果传入parentId为空，则通过organwId查自身所属机构节点|false|-
metaId|string|用于资源目录管理的字段|false|-
appId|string|应用ID|false|-
status|string|状态|false|-
key|string|名字|false|-
gnType|string|功能类型|false|-
showButton|string|是否显示button，默认不显示|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/comm/tree.do?gnType=ks7scb&positionType=krx9oi&groupId=172&refresh=7ul6cb&parentId=172&status=ap0sxa&endTime=2025-10-20 18:20:52&startTime=2025-10-20 18:20:52&type=7on81r&subType=s22mck&refType=lq3gq2&roletypeId=172&showButton=66v8pg&limit=10&appId=172&wlType=uwhezh&orderBy=990&organwId=172&key=fzqdk7&roleTypeId=172&q=dujl2o&positionId=172&metaId=172&page=1&roleId=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─id|string|id|-
└─label|string|名称|-
└─shortName|string|简称|-
└─organId|string|机构id|-
└─areaId|int64|行政区划id|-
└─searchCode|string|全路径|-
└─childNum|int32|子类数量|-
└─checked|boolean|是否选中|-
└─entity|int32|是否实体，1 是，0 否|-
└─show|boolean|是否显示|-
└─showIcon|boolean|是否显示图标|-
└─parentId|string|父id|-
└─children|array|子对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "id": "172",
      "label": "zlk7w2",
      "shortName": "merle.larkin",
      "organId": "172",
      "areaId": 863,
      "searchCode": "81486",
      "childNum": 341,
      "checked": true,
      "entity": 425,
      "show": true,
      "showIcon": true,
      "parentId": "172",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 字典树获取
**URL:** https://linlan.net/eframe_backend/api/system/dictionary/tree.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 字典树获取

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
typeCode|string|字典类型代码|false|-
parentId|int64|字典父节点编号，简单的字典使用|false|-
isAllChild|string|是否所有|false|-
name|string|字典名称|false|-
sname|string|字典名称简称，英文，多语种名称|false|-
cddValue|string|字典值|false|-
cddLevel|string|字典级别, tree时有效|false|-
searchCode|string|快速码|false|-
dispFlag|string|显示标记，用|分隔，第1位全部第2位重点第3位特殊分类；如1|1|0|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-
key|string|关键字,以后用q|false|-
existKey|string|存在key|false|-
typeMode|string|typeMode|false|-
ids|array|id集合|false|-
typeCodes|array|字典类型代码|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/tree.do?startTime=2025-10-20 18:20:52&typeMode=bhmc4g&page=1&existKey=v76318&key=yk5vdj&orderBy=182&delFlag=5&typeCodes=yglg04&typeCodes=yglg04&searchCode=81486&ids=raaj39&ids=raaj39&cddLevel=7k3c1v&cddValue=micac0&typeCode=81486&isAllChild=qmhc0h&description=qbzy6h&parentId=542&limit=10&name=merle.larkin&dispFlag=ejt3xl&endTime=2025-10-20 18:20:52&q=o79pel&sname=merle.larkin
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|字典编号|-
└─typeCode|string|字典类型代码|-
└─parentId|int64|字典父节点编号，简单的字典使用|-
└─name|string|字典名称|-
└─sname|string|字典名称简称，英文，多语种名称|-
└─cddValue|string|字典值|-
└─cddLevel|string|字典级别, tree时有效|-
└─searchCode|string|快速码|-
└─dispFlag|string|显示标记，用|分隔，第1位全部第2位重点第3位特殊分类；如1|1|0|-
└─priority|int32|排序码|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─deleteTime|string|删除时间|-
└─description|string|描述|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
└─children|array|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:07",
      "lastTime": "2025-10-20 18:26:07",
      "id": 33,
      "typeCode": "81486",
      "parentId": 885,
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "cddValue": "fvmou5",
      "cddLevel": "n6nf1m",
      "searchCode": "81486",
      "dispFlag": "dad6fo",
      "priority": 82,
      "delFlag": 5,
      "deleteTime": "2025-10-20 18:26:07",
      "description": "opjkqi",
      "spare1": "9p8afo",
      "spare2": "5ca81b",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 数据字典类型信息读写
### 获取字典类型列表
**URL:** https://linlan.net/eframe_backend/api/system/dictype/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取字典类型列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
typeId|string|字典主键|false|-
name|string|字典名称|false|-
typeMode|int32|字典类型模式0平面1树形|false|-
typeClass|string|字典类型|false|-
status|string|状态（0未生效 1正常）|false|-
remark|string|备注|false|-
key|string|关键字|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/list.do?typeClass=a6odk4&name=merle.larkin&q=9f6agm&orderBy=296&page=1&key=l64jfz&typeMode=236&limit=10&status=jnfpli&endTime=2025-10-20 18:20:52&startTime=2025-10-20 18:20:52&typeId=172&remark=cr3c1j
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeId|string|字典主键|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|字典名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeClass|string|类型分类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeRef|string|字典引用名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeMode|int32|字典类型模式 0平面1树形|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|快速码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态（0未生效 1正常）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 239,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "typeId": "172",
        "name": "merle.larkin",
        "typeClass": "3g1g4s",
        "typeRef": "eudhc2",
        "typeMode": 981,
        "searchCode": "81486",
        "priority": 255,
        "createTime": "2025-10-20 18:26:07",
        "status": 531,
        "remark": "qdnp6y"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 字典类型导出
**URL:** https://linlan.net/eframe_backend/api/system/dictype/export.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 字典类型导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
typeId|string|字典主键|false|-
name|string|字典名称|false|-
typeMode|int32|字典类型模式0平面1树形|false|-
typeClass|string|字典类型|false|-
status|string|状态（0未生效 1正常）|false|-
remark|string|备注|false|-
key|string|关键字|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/export.do --data 'limit=10&orderBy=147&startTime=2025-10-20 18:20:52&page=1&typeClass=00qp6y&q=kjo21o&typeId=172&name=merle.larkin&status=i0wd4b&remark=9d2bge&endTime=2025-10-20 18:20:52&typeMode=368&key=ialtb5'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "x9aizn",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 查询字典类型详细
**URL:** https://linlan.net/eframe_backend/api/system/dictype/{dictId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询字典类型详细

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
dictId|string|   字典分类ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/172.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─typeId|string|字典主键|-
└─name|string|字典名称|-
└─typeClass|string|类型分类|-
└─typeRef|string|字典引用名称|-
└─typeMode|int32|字典类型模式 0平面1树形|-
└─searchCode|string|快速码|-
└─priority|int32|排序码|-
└─createTime|string|创建时间|-
└─status|int32|状态（0未生效 1正常）|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "typeId": "172",
    "name": "merle.larkin",
    "typeClass": "vste6k",
    "typeRef": "e3909u",
    "typeMode": 192,
    "searchCode": "81486",
    "priority": 502,
    "createTime": "2025-10-20 18:26:07",
    "status": 44,
    "remark": "90hu61"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增字典类型
**URL:** https://linlan.net/eframe_backend/api/system/dictype/save.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增字典类型

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─typeId|string|字典主键|false|-
└─name|string|字典名称|false|-
└─typeClass|string|类型分类|false|-
└─typeRef|string|字典引用名称|false|-
└─typeMode|int32|字典类型模式 0平面1树形|false|-
└─searchCode|string|快速码|false|-
└─priority|int32|排序码|false|-
└─createTime|string|创建时间|false|-
└─status|int32|状态（0未生效 1正常）|false|-
└─remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/save.do --data '{
  "data": {
    "typeId": "172",
    "name": "merle.larkin",
    "typeClass": "165o99",
    "typeRef": "5s67v0",
    "typeMode": 277,
    "searchCode": "81486",
    "priority": 625,
    "createTime": "2025-10-20 18:26:07",
    "status": 4,
    "remark": "217oi9"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "p0m5w8",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改字典类型
**URL:** https://linlan.net/eframe_backend/api/system/dictype/update.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改字典类型

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─typeId|string|字典主键|false|-
└─name|string|字典名称|false|-
└─typeClass|string|类型分类|false|-
└─typeRef|string|字典引用名称|false|-
└─typeMode|int32|字典类型模式 0平面1树形|false|-
└─searchCode|string|快速码|false|-
└─priority|int32|排序码|false|-
└─createTime|string|创建时间|false|-
└─status|int32|状态（0未生效 1正常）|false|-
└─remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/update.do --data '{
  "data": {
    "typeId": "172",
    "name": "merle.larkin",
    "typeClass": "k5utc4",
    "typeRef": "6tpbx5",
    "typeMode": 527,
    "searchCode": "81486",
    "priority": 569,
    "createTime": "2025-10-20 18:26:07",
    "status": 479,
    "remark": "6oano6"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "66sg60",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除字典类型
**URL:** https://linlan.net/eframe_backend/api/system/dictype/delete/{dictIds}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除字典类型

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
dictIds|array|   字典分类Ids,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "xs8ze5",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 刷新字典类型缓存
**URL:** https://linlan.net/eframe_backend/api/system/dictype/refreshCache.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 刷新字典类型缓存

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/refreshCache.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "6c2t3d",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取字典选择框列表
**URL:** https://linlan.net/eframe_backend/api/system/dictype/option/select.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取字典选择框列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/option/select.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─typeId|string|字典主键|-
└─name|string|字典名称|-
└─typeClass|string|类型分类|-
└─typeRef|string|字典引用名称|-
└─typeMode|int32|字典类型模式 0平面1树形|-
└─searchCode|string|快速码|-
└─priority|int32|排序码|-
└─createTime|string|创建时间|-
└─status|int32|状态（0未生效 1正常）|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "typeId": "172",
      "name": "merle.larkin",
      "typeClass": "ypk8cb",
      "typeRef": "jh7tgj",
      "typeMode": 72,
      "searchCode": "81486",
      "priority": 0,
      "createTime": "2025-10-20 18:26:07",
      "status": 867,
      "remark": "obiu2p"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 服务器监控
### 获取服务器基本信息
**URL:** https://linlan.net/eframe_backend/api/monitor/server.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取服务器基本信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/server.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─cpu|object|CPU相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cpuNum|int32|核心数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─total|double|CPU总的使用率|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sys|double|CPU系统使用率|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─used|double|CPU用户使用率|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─wait|double|CPU当前等待率|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─free|double|CPU当前空闲率|-
└─mem|object|內存相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─total|double|内存总量|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─used|double|已用内存|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─free|double|剩余内存|-
└─jvm|object|JVM相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─total|double|当前JVM占用的内存总数(M)|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─max|double|JVM最大可用内存总数(M)|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─free|double|JVM空闲内存(M)|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─version|string|JDK版本|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─home|string|JDK路径|-
└─sys|object|服务器相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─computerName|string|服务器名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─computerIp|string|服务器Ip|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userDir|string|项目路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─osName|string|操作系统|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─osArch|string|系统架构|-
└─sysFiles|array|磁盘相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dirName|string|盘符路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sysTypeName|string|盘符类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─typeName|string|文件类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─total|string|总大小|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─free|string|剩余大小|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─used|string|已经使用量|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─usage|double|资源的使用率|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "cpu": {
      "cpuNum": 468,
      "total": 8.37,
      "sys": 1.61,
      "used": 8.42,
      "wait": 85.10,
      "free": 85.90
    },
    "mem": {
      "total": 96.69,
      "used": 99.70,
      "free": 5.87
    },
    "jvm": {
      "total": 72.81,
      "max": 40.75,
      "free": 44.81,
      "version": "0.38",
      "home": "r226yl"
    },
    "sys": {
      "computerName": "merle.larkin",
      "computerIp": "137.119.212.174",
      "userDir": "5fk6bt",
      "osName": "merle.larkin",
      "osArch": "7r5fx0"
    },
    "sysFiles": [
      {
        "dirName": "merle.larkin",
        "sysTypeName": "merle.larkin",
        "typeName": "merle.larkin",
        "total": "1l6his",
        "free": "j8ln8d",
        "used": "f1bn5p",
        "usage": 98.21
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 权限分类读写控制类
### Get CoreRighttype list. 获取权限分类列表或分页, 返回CoreRighttype对象.
**URL:** https://linlan.net/eframe_backend/api/system/righttype/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-12-16 10:58:56

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get CoreRighttype list. 获取权限分类列表或分页, 返回CoreRighttype对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
name|string|类型名称|false|-
sname|string|类型简称,英文|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/list.do?page=1&q=1z1ebq&description=ks3o9h&limit=10&sname=merle.larkin&delFlag=5&orderBy=781&endTime=2025-10-20 18:20:52&startTime=2025-10-20 18:20:52&name=merle.larkin
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|资源类型ID|-
└─name|string|类型名称|-
└─sname|string|类型简称,英文|-
└─priority|int32|重点优先级|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|描述|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:04",
      "lastTime": "2025-10-20 18:26:04",
      "id": "172",
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "priority": 544,
      "delFlag": 5,
      "description": "80wvpp"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreRighttype Operation. CoreRighttype数据操作逻辑，导出操作.
**URL:** https://linlan.net/eframe_backend/api/system/righttype/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 10:58:56

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** CoreRighttype Operation. CoreRighttype数据操作逻辑，导出操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
name|string|类型名称|false|-
sname|string|类型简称,英文|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/export.do --data 'endTime=2025-10-20 18:20:52&description=xmaj4i&orderBy=815&delFlag=5&page=1&name=merle.larkin&sname=merle.larkin&limit=10&startTime=2025-10-20 18:20:52&q=jd204t'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "pzbr1k",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get CoreRighttype by id. 主键获取权限分类详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/righttype/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-12-16 10:58:56

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get CoreRighttype by id. 主键获取权限分类详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|资源类型ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|资源类型ID|-
└─name|string|类型名称|-
└─sname|string|类型简称,英文|-
└─priority|int32|重点优先级|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|描述|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:04",
    "lastTime": "2025-10-20 18:26:04",
    "id": "172",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "priority": 57,
    "delFlag": 5,
    "description": "nhecri"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreRighttype Operation. 新增权限分类数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/righttype/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 10:58:56

**Content-Type:** application/json; charset=utf-8

**Description:** CoreRighttype Operation. 新增权限分类数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|资源类型ID|false|-
└─name|string|类型名称|false|-
└─sname|string|类型简称,英文|false|-
└─priority|int32|重点优先级|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:04",
    "lastTime": "2025-10-20 18:26:04",
    "id": "172",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "priority": 326,
    "delFlag": 5,
    "description": "xere9k"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "sppnag",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreRighttype Operation. 修改权限分类数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/righttype/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 10:58:56

**Content-Type:** application/json; charset=utf-8

**Description:** CoreRighttype Operation. 修改权限分类数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|资源类型ID|false|-
└─name|string|类型名称|false|-
└─sname|string|类型简称,英文|false|-
└─priority|int32|重点优先级|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:04",
    "lastTime": "2025-10-20 18:26:04",
    "id": "172",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "priority": 965,
    "delFlag": 5,
    "description": "dtfwxu"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "tvymnx",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreRighttype Operation. 删除权限分类数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/righttype/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 10:58:56

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** CoreRighttype Operation. 删除权限分类数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|资源类型ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "r14dl6",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 模板信息配置读写控制类
### Get PublicTemplateInfo list. 获取模板信息配置列表或分页, 返回PublicTemplateInfo对象.
**URL:** https://linlan.net/eframe_backend/api/system/template/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-15 13:52:44

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get PublicTemplateInfo list. 获取模板信息配置列表或分页, 返回PublicTemplateInfo对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|string|模板ID|false|-
appId|string|应用ID|false|-
organId|string|机构ID|false|-
providerId|string|提供商ID，平台ID|false|-
providerName|string|提供商名称，平台名称|false|-
foreignId|string|外键ID|false|-
type|string|模板类型，邮件模板，短信模板|false|-
subType|string|模板子类型|false|-
name|string|模板名称，标题名称|false|-
signature|string|签名，发送人名称|false|-
content|string|内容JSON，发布版本的JSON配置|false|-
status|int32|状态0未生效1正常2受限3锁定|false|-
creatorId|string|创建者ID|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/template/list.do?subType=xffvho&description=i2hakc&providerId=172&creatorId=172&providerName=merle.larkin&limit=10&type=xzcm7q&endTime=2025-10-20 18:20:52&content=akihfz&delFlag=5&startTime=2025-10-20 18:20:52&spare2=8ra33g&spare1=lrpfwj&name=merle.larkin&appId=172&orderBy=364&q=vsy2wb&page=1&signature=swhoje&organId=172&foreignId=172&status=778&id=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|模板ID|-
└─appId|string|应用ID|-
└─organId|string|机构ID|-
└─providerId|string|提供商ID，平台ID|-
└─providerName|string|提供商名称，平台名称|-
└─foreignId|string|外键ID|-
└─type|string|模板类型，邮件模板，短信模板|-
└─subType|string|模板子类型|-
└─name|string|模板名称，标题名称|-
└─signature|string|签名，发送人名称|-
└─content|string|内容JSON，发布版本的JSON配置|-
└─priority|int32|排序号|-
└─status|int32|状态0未生效1正常2受限3锁定|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:10",
      "lastTime": "2025-10-20 18:26:10",
      "id": "172",
      "appId": "172",
      "organId": "172",
      "providerId": "172",
      "providerName": "merle.larkin",
      "foreignId": "172",
      "type": "q9t9a6",
      "subType": "wiwfkt",
      "name": "merle.larkin",
      "signature": "j2dam2",
      "content": "ofmga4",
      "priority": 166,
      "status": 859,
      "delFlag": 5,
      "description": "jzc3sj",
      "spare1": "m19fum",
      "spare2": "1x9sr4"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get PublicTemplateInfo by id. 主键获取模板信息配置详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/template/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-15 13:52:44

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get PublicTemplateInfo by id. 主键获取模板信息配置详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|模板ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/template/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|模板ID|-
└─appId|string|应用ID|-
└─organId|string|机构ID|-
└─providerId|string|提供商ID，平台ID|-
└─providerName|string|提供商名称，平台名称|-
└─foreignId|string|外键ID|-
└─type|string|模板类型，邮件模板，短信模板|-
└─subType|string|模板子类型|-
└─name|string|模板名称，标题名称|-
└─signature|string|签名，发送人名称|-
└─content|string|内容JSON，发布版本的JSON配置|-
└─priority|int32|排序号|-
└─status|int32|状态0未生效1正常2受限3锁定|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:10",
    "lastTime": "2025-10-20 18:26:10",
    "id": "172",
    "appId": "172",
    "organId": "172",
    "providerId": "172",
    "providerName": "merle.larkin",
    "foreignId": "172",
    "type": "midpp1",
    "subType": "bzslnq",
    "name": "merle.larkin",
    "signature": "h3tfzb",
    "content": "1ol9sy",
    "priority": 602,
    "status": 450,
    "delFlag": 5,
    "description": "odzmp1",
    "spare1": "58ctai",
    "spare2": "6xzjo4"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicTemplateInfo Operation. 新增模板信息配置数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/template/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-15 13:52:44

**Content-Type:** application/json; charset=utf-8

**Description:** PublicTemplateInfo Operation. 新增模板信息配置数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|模板ID|false|-
└─appId|string|应用ID|false|-
└─organId|string|机构ID|false|-
└─providerId|string|提供商ID，平台ID|false|-
└─providerName|string|提供商名称，平台名称|false|-
└─foreignId|string|外键ID|false|-
└─type|string|模板类型，邮件模板，短信模板|false|-
└─subType|string|模板子类型|false|-
└─name|string|模板名称，标题名称|false|-
└─signature|string|签名，发送人名称|false|-
└─content|string|内容JSON，发布版本的JSON配置|false|-
└─priority|int32|排序号|false|-
└─status|int32|状态0未生效1正常2受限3锁定|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/template/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:10",
    "lastTime": "2025-10-20 18:26:10",
    "id": "172",
    "appId": "172",
    "organId": "172",
    "providerId": "172",
    "providerName": "merle.larkin",
    "foreignId": "172",
    "type": "isemit",
    "subType": "5t6mep",
    "name": "merle.larkin",
    "signature": "93udue",
    "content": "lofslk",
    "priority": 148,
    "status": 104,
    "delFlag": 5,
    "description": "r4ele3",
    "spare1": "nmxajj",
    "spare2": "5ntgnl"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "t6w55l",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicTemplateInfo Operation. 修改模板信息配置数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/template/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-15 13:52:44

**Content-Type:** application/json; charset=utf-8

**Description:** PublicTemplateInfo Operation. 修改模板信息配置数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|模板ID|false|-
└─appId|string|应用ID|false|-
└─organId|string|机构ID|false|-
└─providerId|string|提供商ID，平台ID|false|-
└─providerName|string|提供商名称，平台名称|false|-
└─foreignId|string|外键ID|false|-
└─type|string|模板类型，邮件模板，短信模板|false|-
└─subType|string|模板子类型|false|-
└─name|string|模板名称，标题名称|false|-
└─signature|string|签名，发送人名称|false|-
└─content|string|内容JSON，发布版本的JSON配置|false|-
└─priority|int32|排序号|false|-
└─status|int32|状态0未生效1正常2受限3锁定|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/template/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:10",
    "lastTime": "2025-10-20 18:26:10",
    "id": "172",
    "appId": "172",
    "organId": "172",
    "providerId": "172",
    "providerName": "merle.larkin",
    "foreignId": "172",
    "type": "9si6oz",
    "subType": "wl2gp3",
    "name": "merle.larkin",
    "signature": "dhej14",
    "content": "mwsyiq",
    "priority": 926,
    "status": 42,
    "delFlag": 5,
    "description": "1k8457",
    "spare1": "g43mb7",
    "spare2": "smblc0"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ntpgxd",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicTemplateInfo Operation. 删除模板信息配置数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/template/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-15 13:52:44

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicTemplateInfo Operation. 删除模板信息配置数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|模板ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/template/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "nj645v",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 消息阅读读写控制类
### Get PublicUnionMessage list. 获取消息阅读列表或分页, 返回PublicUnionMessage对象.
**URL:** https://linlan.net/eframe_backend/api/system/message/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get PublicUnionMessage list. 获取消息阅读列表或分页, 返回PublicUnionMessage对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|string|记录ID|false|-
appId|string|应用ID|false|-
foreignId|string|站点门户ID|false|-
type|string|类型|false|-
bizType|string|业务类型|false|-
msgCreateTime|string|统一消息创建时间|false|-
msgId|int64|信息ID|false|-
msgType|int32|消息类型|false|-
msgTitle|string|信息标题|false|-
msgAbstract|string|统一消息摘要|false|-
msgAccountId|string|统一消息应用账户ID|false|-
msgAccountName|string|统一消息应用系统或账户名称|false|-
msgModuleId|string|统一消息应用应用ID|false|-
msgModuleName|string|统一消息应用应用名称|false|-
msgUserId|string|统一消息应用用户ID|false|-
msgUserName|string|统一消息应用用户名称|false|-
msgOrganId|string|统一消息应用机构ID|false|-
msgOrganName|string|统一消息应用机构名称|false|-
msgUrl|string|统一信息链接，链接平台内地址，可点击访问|false|-
msgLabels|string|统一消息业务标签|false|-
msgContent|string|统一消息信息内容|false|-
status|string|状态，0待阅读，10已阅读|false|-
opUserId|string|操作人ID|false|-
opTime|string|操作时间|false|-
opOrganId|string|操作单位ID|false|-
opOrganName|string|操作单位名称|false|-
creatorId|string|创建人ID，不使用外键|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/list.do?limit=10&opOrganId=172&appId=172&description=dyxpmd&msgAccountName=merle.larkin&creatorId=172&msgModuleName=merle.larkin&id=172&msgCreateTime=2025-10-20 18:26:09&msgContent=aukmfj&msgUserId=172&opUserId=172&startTime=2025-10-20 18:20:52&opOrganName=merle.larkin&q=dseudf&msgTitle=7xo2vy&msgUserName=merle.larkin&msgUrl=www.ben-grant.info&foreignId=172&msgAccountId=172&msgOrganName=merle.larkin&spare1=6egk3p&msgId=174&spare2=jc6h1q&msgType=32&msgOrganId=172&msgModuleId=172&page=1&endTime=2025-10-20 18:20:52&bizType=2ctb8k&msgLabels=1ae0ea&type=vwtvrv&orderBy=954&status=72ivwr&opTime=2025-10-20 18:26:09&msgAbstract=2l1i3j
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|记录ID|-
└─appId|string|应用ID|-
└─foreignId|string|站点门户ID|-
└─type|string|类型|-
└─bizType|string|业务类型|-
└─msgCreateTime|string|统一消息创建时间|-
└─msgId|int64|信息ID|-
└─msgType|int32|消息类型|-
└─msgTitle|string|信息标题|-
└─msgAbstract|string|统一消息摘要|-
└─msgAccountId|string|统一消息应用账户ID|-
└─msgAccountName|string|统一消息应用系统或账户名称|-
└─msgModuleId|string|统一消息应用应用ID|-
└─msgModuleName|string|统一消息应用应用名称|-
└─msgUserId|string|统一消息应用用户ID|-
└─msgUserName|string|统一消息应用用户名称|-
└─msgOrganId|string|统一消息应用机构ID|-
└─msgOrganName|string|统一消息应用机构名称|-
└─msgUrl|string|统一信息链接，链接平台内地址，可点击访问|-
└─msgLabels|string|统一消息业务标签|-
└─msgContent|string|统一消息信息内容|-
└─status|string|状态，0待阅读，10已阅读|-
└─opUserId|string|操作人ID|-
└─opTime|string|操作时间|-
└─opOrganId|string|操作单位ID|-
└─opOrganName|string|操作单位名称|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:09",
      "lastTime": "2025-10-20 18:26:09",
      "id": "172",
      "appId": "172",
      "foreignId": "172",
      "type": "ky2jz1",
      "bizType": "77ky20",
      "msgCreateTime": "2025-10-20 18:26:09",
      "msgId": 796,
      "msgType": 65,
      "msgTitle": "xdgs41",
      "msgAbstract": "jv7cnp",
      "msgAccountId": "172",
      "msgAccountName": "merle.larkin",
      "msgModuleId": "172",
      "msgModuleName": "merle.larkin",
      "msgUserId": "172",
      "msgUserName": "merle.larkin",
      "msgOrganId": "172",
      "msgOrganName": "merle.larkin",
      "msgUrl": "www.ben-grant.info",
      "msgLabels": "dazhv9",
      "msgContent": "doyqe0",
      "status": "3t7li0",
      "opUserId": "172",
      "opTime": "2025-10-20 18:26:09",
      "opOrganId": "172",
      "opOrganName": "merle.larkin",
      "description": "4mv7nw",
      "spare1": "5hx7cu",
      "spare2": "95l92v"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicUnionMessage Operation. PublicUnionMessage数据操作逻辑，导出操作.
**URL:** https://linlan.net/eframe_backend/api/system/message/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicUnionMessage Operation. PublicUnionMessage数据操作逻辑，导出操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|string|记录ID|false|-
appId|string|应用ID|false|-
foreignId|string|站点门户ID|false|-
type|string|类型|false|-
bizType|string|业务类型|false|-
msgCreateTime|string|统一消息创建时间|false|-
msgId|int64|信息ID|false|-
msgType|int32|消息类型|false|-
msgTitle|string|信息标题|false|-
msgAbstract|string|统一消息摘要|false|-
msgAccountId|string|统一消息应用账户ID|false|-
msgAccountName|string|统一消息应用系统或账户名称|false|-
msgModuleId|string|统一消息应用应用ID|false|-
msgModuleName|string|统一消息应用应用名称|false|-
msgUserId|string|统一消息应用用户ID|false|-
msgUserName|string|统一消息应用用户名称|false|-
msgOrganId|string|统一消息应用机构ID|false|-
msgOrganName|string|统一消息应用机构名称|false|-
msgUrl|string|统一信息链接，链接平台内地址，可点击访问|false|-
msgLabels|string|统一消息业务标签|false|-
msgContent|string|统一消息信息内容|false|-
status|string|状态，0待阅读，10已阅读|false|-
opUserId|string|操作人ID|false|-
opTime|string|操作时间|false|-
opOrganId|string|操作单位ID|false|-
opOrganName|string|操作单位名称|false|-
creatorId|string|创建人ID，不使用外键|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/export.do --data 'msgType=171&description=nnsyg8&msgUserId=172&msgAbstract=m0vf0c&opUserId=172&foreignId=172&msgUrl=www.ben-grant.info&limit=10&q=zc8o5t&msgCreateTime=2025-10-20 18:26:09&msgUserName=merle.larkin&msgModuleName=merle.larkin&msgLabels=9hv7ia&opTime=2025-10-20 18:26:09&spare1=duvb4y&msgModuleId=172&status=ltdsz4&spare2=j9c936&msgId=455&page=1&msgAccountName=merle.larkin&type=o0pj50&bizType=59pgxe&creatorId=172&msgOrganId=172&orderBy=522&startTime=2025-10-20 18:20:52&id=172&msgTitle=j7u1a8&msgAccountId=172&opOrganName=merle.larkin&appId=172&msgOrganName=merle.larkin&msgContent=jqvyuc&opOrganId=172&endTime=2025-10-20 18:20:52'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "0moj41",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get PublicUnionMessage by id. 主键获取消息阅读详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/message/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get PublicUnionMessage by id. 主键获取消息阅读详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|主键ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|记录ID|-
└─appId|string|应用ID|-
└─foreignId|string|站点门户ID|-
└─type|string|类型|-
└─bizType|string|业务类型|-
└─msgCreateTime|string|统一消息创建时间|-
└─msgId|int64|信息ID|-
└─msgType|int32|消息类型|-
└─msgTitle|string|信息标题|-
└─msgAbstract|string|统一消息摘要|-
└─msgAccountId|string|统一消息应用账户ID|-
└─msgAccountName|string|统一消息应用系统或账户名称|-
└─msgModuleId|string|统一消息应用应用ID|-
└─msgModuleName|string|统一消息应用应用名称|-
└─msgUserId|string|统一消息应用用户ID|-
└─msgUserName|string|统一消息应用用户名称|-
└─msgOrganId|string|统一消息应用机构ID|-
└─msgOrganName|string|统一消息应用机构名称|-
└─msgUrl|string|统一信息链接，链接平台内地址，可点击访问|-
└─msgLabels|string|统一消息业务标签|-
└─msgContent|string|统一消息信息内容|-
└─status|string|状态，0待阅读，10已阅读|-
└─opUserId|string|操作人ID|-
└─opTime|string|操作时间|-
└─opOrganId|string|操作单位ID|-
└─opOrganName|string|操作单位名称|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:09",
    "lastTime": "2025-10-20 18:26:09",
    "id": "172",
    "appId": "172",
    "foreignId": "172",
    "type": "0slaku",
    "bizType": "ihanlw",
    "msgCreateTime": "2025-10-20 18:26:09",
    "msgId": 277,
    "msgType": 876,
    "msgTitle": "ife7wc",
    "msgAbstract": "cbyw83",
    "msgAccountId": "172",
    "msgAccountName": "merle.larkin",
    "msgModuleId": "172",
    "msgModuleName": "merle.larkin",
    "msgUserId": "172",
    "msgUserName": "merle.larkin",
    "msgOrganId": "172",
    "msgOrganName": "merle.larkin",
    "msgUrl": "www.ben-grant.info",
    "msgLabels": "q2lpf5",
    "msgContent": "ouygdl",
    "status": "90ppbx",
    "opUserId": "172",
    "opTime": "2025-10-20 18:26:09",
    "opOrganId": "172",
    "opOrganName": "merle.larkin",
    "description": "wbpp1f",
    "spare1": "6um27j",
    "spare2": "3ly340"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicUnionMessage Operation. 新增消息阅读数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/message/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/json; charset=utf-8

**Description:** PublicUnionMessage Operation. 新增消息阅读数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|记录ID|false|-
└─appId|string|应用ID|false|-
└─foreignId|string|站点门户ID|false|-
└─type|string|类型|false|-
└─bizType|string|业务类型|false|-
└─msgCreateTime|string|统一消息创建时间|false|-
└─msgId|int64|信息ID|false|-
└─msgType|int32|消息类型|false|-
└─msgTitle|string|信息标题|false|-
└─msgAbstract|string|统一消息摘要|false|-
└─msgAccountId|string|统一消息应用账户ID|false|-
└─msgAccountName|string|统一消息应用系统或账户名称|false|-
└─msgModuleId|string|统一消息应用应用ID|false|-
└─msgModuleName|string|统一消息应用应用名称|false|-
└─msgUserId|string|统一消息应用用户ID|false|-
└─msgUserName|string|统一消息应用用户名称|false|-
└─msgOrganId|string|统一消息应用机构ID|false|-
└─msgOrganName|string|统一消息应用机构名称|false|-
└─msgUrl|string|统一信息链接，链接平台内地址，可点击访问|false|-
└─msgLabels|string|统一消息业务标签|false|-
└─msgContent|string|统一消息信息内容|false|-
└─status|string|状态，0待阅读，10已阅读|false|-
└─opUserId|string|操作人ID|false|-
└─opTime|string|操作时间|false|-
└─opOrganId|string|操作单位ID|false|-
└─opOrganName|string|操作单位名称|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:09",
    "lastTime": "2025-10-20 18:26:09",
    "id": "172",
    "appId": "172",
    "foreignId": "172",
    "type": "3vwie7",
    "bizType": "hsso98",
    "msgCreateTime": "2025-10-20 18:26:09",
    "msgId": 822,
    "msgType": 21,
    "msgTitle": "ak9ai0",
    "msgAbstract": "avv3jy",
    "msgAccountId": "172",
    "msgAccountName": "merle.larkin",
    "msgModuleId": "172",
    "msgModuleName": "merle.larkin",
    "msgUserId": "172",
    "msgUserName": "merle.larkin",
    "msgOrganId": "172",
    "msgOrganName": "merle.larkin",
    "msgUrl": "www.ben-grant.info",
    "msgLabels": "v0yy1q",
    "msgContent": "94ttw5",
    "status": "d0ct8k",
    "opUserId": "172",
    "opTime": "2025-10-20 18:26:09",
    "opOrganId": "172",
    "opOrganName": "merle.larkin",
    "description": "tc7tth",
    "spare1": "og9qqp",
    "spare2": "1c4chs"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "xeo6kh",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicUnionMessage Operation. 修改消息阅读数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/message/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/json; charset=utf-8

**Description:** PublicUnionMessage Operation. 修改消息阅读数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|记录ID|false|-
└─appId|string|应用ID|false|-
└─foreignId|string|站点门户ID|false|-
└─type|string|类型|false|-
└─bizType|string|业务类型|false|-
└─msgCreateTime|string|统一消息创建时间|false|-
└─msgId|int64|信息ID|false|-
└─msgType|int32|消息类型|false|-
└─msgTitle|string|信息标题|false|-
└─msgAbstract|string|统一消息摘要|false|-
└─msgAccountId|string|统一消息应用账户ID|false|-
└─msgAccountName|string|统一消息应用系统或账户名称|false|-
└─msgModuleId|string|统一消息应用应用ID|false|-
└─msgModuleName|string|统一消息应用应用名称|false|-
└─msgUserId|string|统一消息应用用户ID|false|-
└─msgUserName|string|统一消息应用用户名称|false|-
└─msgOrganId|string|统一消息应用机构ID|false|-
└─msgOrganName|string|统一消息应用机构名称|false|-
└─msgUrl|string|统一信息链接，链接平台内地址，可点击访问|false|-
└─msgLabels|string|统一消息业务标签|false|-
└─msgContent|string|统一消息信息内容|false|-
└─status|string|状态，0待阅读，10已阅读|false|-
└─opUserId|string|操作人ID|false|-
└─opTime|string|操作时间|false|-
└─opOrganId|string|操作单位ID|false|-
└─opOrganName|string|操作单位名称|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:09",
    "lastTime": "2025-10-20 18:26:09",
    "id": "172",
    "appId": "172",
    "foreignId": "172",
    "type": "m609fc",
    "bizType": "s5o86g",
    "msgCreateTime": "2025-10-20 18:26:09",
    "msgId": 488,
    "msgType": 317,
    "msgTitle": "iqoego",
    "msgAbstract": "9q131u",
    "msgAccountId": "172",
    "msgAccountName": "merle.larkin",
    "msgModuleId": "172",
    "msgModuleName": "merle.larkin",
    "msgUserId": "172",
    "msgUserName": "merle.larkin",
    "msgOrganId": "172",
    "msgOrganName": "merle.larkin",
    "msgUrl": "www.ben-grant.info",
    "msgLabels": "tefq0c",
    "msgContent": "737y43",
    "status": "y953bh",
    "opUserId": "172",
    "opTime": "2025-10-20 18:26:09",
    "opOrganId": "172",
    "opOrganName": "merle.larkin",
    "description": "q82vsr",
    "spare1": "c1dtz7",
    "spare2": "hok1ks"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "fbp8gk",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicUnionMessage Operation. 删除消息阅读数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/message/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicUnionMessage Operation. 删除消息阅读数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|主键ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "j1o7mn",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicUnionMessage Operation. 删除消息阅读数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/message/read/{ids}/{status}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicUnionMessage Operation. 删除消息阅读数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|主键ID:null;1;1,2,3,[array of string]|true|
status|string|消息状态|true|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/read/t1jvi5.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "03qnzu",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 用户权限预置
### 用户权限预置列表
**URL:** https://linlan.net/eframe_backend/api/admin/preset/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 用户权限预置列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
type|string|类型 RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345|false|-
status|int32|状态：0未初始化 1 已初始化， 2.初始化失败|false|-
appId|string|应用Id|false|-
roleTypeId|string|角色类型，R31 WEB，R32移动<br>对应字段：SYNC_MODE|false|-
groupId|int64|组id|false|-
positionId|string|岗位id|false|-
organId|string|机构id|false|-
areaId|int64|区域id|false|-
batchId|string|批次id|false|-
keyWords|string|关键字|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/list.do?batchId=172&keyWords=ukhukw&orderBy=940&startTime=2025-10-20 18:20:52&page=1&appId=172&status=789&groupId=812&positionId=172&endTime=2025-10-20 18:20:52&q=bagx4k&type=ioqu3u&roleTypeId=172&limit=10&organId=172&areaId=986
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|预置信息ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|所属应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─saveSource|string|来源，RGYZ人工预置，PLTJ批量添加|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unitName|string|服务处所，单位名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|姓名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─idNum|string|身份证号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─duty|string|人员职务|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─telephone|string|办公电话|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mobile|string|手机号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─extInfo1|string|备用信息1，可保存岗位名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─extInfo2|string|备用信息2，可保存所属网格等信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─extInfo3|string|备用信息3|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─needInitUser|boolean|是否同步初始化人员，0否1是，是则人员会加入BASE_USER|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userId|string|机构用户人员ID，关联BASE_USER，初始化之后更新|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─needInitOrgan|boolean|是否同步初始化机构，0否1是，是则人员会加入BASE_ORGAN|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID，关联BASE_ORGAN，初始化之后更新|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|类型，RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignUrl|string|外部URL，如SJKB的URL，人才预约的URL|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bizType|int32|业务类型，1具体单位2具体地域3具体权限组4综合权限9多个同类信息，12单位和地域，13单位和权限组，19多个单位，23地域和权限组，29多个地域，39多个权限|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bizOrganId|string|业务机构ID，人员绑定机构，绑定的ORGAN_ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bizAreaId|int64|业务权限ID，当前查询范围|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bizGroupId|int64|业务会员组ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bizPower|string|业务综合权限，备用字段|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bizMultiInfo|string|多个信息时，Ids,隔开|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─needSetOrgan|boolean|是否需要绑定企业，0否1是，是则人员会配置IDENTITY的ORGAN_ID信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─needSetArea|boolean|是否需要绑定地域，0否1是，是则人员会配置IDENTITY的POWER_AREA_ID信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─needSetGroup|boolean|是否需要绑定会员组，0否1是，是则人员会配置会员组，并设置IDENTITY内的GROUP_ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─needSetPower|boolean|是否需要绑定综合权限，0否1是，是则人员会配置IDENTITY的其他综合权限等信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─opUserId|string|操作人ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─opOrganId|string|操作单位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─opTime|string|操作时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─opInfo|string|操作说明|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未初始化1初始化配置成功2初始化配置不成功|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dataBatch|string|数据批次号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dataVersion|int32|数据版本，流水号，向上增加|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─updateTime|string|数据更新时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─syncMode|string|同步类型，I插入，U更新，D删除，DM人工删除，UM人工更新|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─syncTime|string|同步更新时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─groupName|string|角色组名称，角色名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─positionName|string|岗名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bizPowerName|string|业务范围名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─subdistrictName|string|业务范围,街镇名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─communityName|string|业务范围,居委名称|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 29,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:26:00",
        "lastTime": "2025-10-20 18:26:00",
        "id": 111,
        "appId": "172",
        "saveSource": "gzs2d8",
        "unitName": "merle.larkin",
        "name": "merle.larkin",
        "idNum": "08fhct",
        "duty": "51otuh",
        "telephone": "1-203-302-2484",
        "mobile": "(415) 540-6962",
        "extInfo1": "8wxt2q",
        "extInfo2": "3nv27f",
        "extInfo3": "6hlu5k",
        "needInitUser": true,
        "userId": "172",
        "needInitOrgan": true,
        "organId": "172",
        "type": "9xe4v2",
        "foreignUrl": "www.ben-grant.info",
        "bizType": 263,
        "bizOrganId": "172",
        "bizAreaId": 461,
        "bizGroupId": 172,
        "bizPower": "xtjacw",
        "bizMultiInfo": "9v594g",
        "needSetOrgan": true,
        "needSetArea": true,
        "needSetGroup": true,
        "needSetPower": true,
        "opUserId": "172",
        "opOrganId": "172",
        "opTime": "2025-10-20 18:26:00",
        "opInfo": "t10cmm",
        "priority": 300,
        "status": 890,
        "delFlag": 5,
        "dataBatch": "35wqoy",
        "dataVersion": 149,
        "updateTime": "2025-10-20 18:26:00",
        "syncMode": "mxep30",
        "syncTime": "2025-10-20 18:26:00",
        "description": "lqtn26",
        "groupName": "merle.larkin",
        "positionName": "merle.larkin",
        "bizPowerName": "merle.larkin",
        "subdistrictName": "merle.larkin",
        "communityName": "merle.larkin"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据用户权限预置导出
**URL:** https://linlan.net/eframe_backend/api/admin/preset/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据用户权限预置导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
type|string|类型 RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345|false|-
status|int32|状态：0未初始化 1 已初始化， 2.初始化失败|false|-
appId|string|应用Id|false|-
roleTypeId|string|角色类型，R31 WEB，R32移动<br>对应字段：SYNC_MODE|false|-
groupId|int64|组id|false|-
positionId|string|岗位id|false|-
organId|string|机构id|false|-
areaId|int64|区域id|false|-
batchId|string|批次id|false|-
keyWords|string|关键字|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/export.do --data 'startTime=2025-10-20 18:20:52&batchId=172&roleTypeId=172&status=810&endTime=2025-10-20 18:20:52&page=1&orderBy=468&areaId=105&q=tmzb6q&groupId=851&type=0zu6nv&organId=172&limit=10&keyWords=c658q0&appId=172&positionId=172'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "q24xrx",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据用户权限预置获取详细信息
**URL:** https://linlan.net/eframe_backend/api/admin/preset/{configId}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据用户权限预置获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
configId|int64| 配置ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/914.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|预置信息ID|-
└─appId|string|所属应用ID|-
└─saveSource|string|来源，RGYZ人工预置，PLTJ批量添加|-
└─unitName|string|服务处所，单位名称|-
└─name|string|姓名|-
└─idNum|string|身份证号|-
└─duty|string|人员职务|-
└─telephone|string|办公电话|-
└─mobile|string|手机号码|-
└─extInfo1|string|备用信息1，可保存岗位名称|-
└─extInfo2|string|备用信息2，可保存所属网格等信息|-
└─extInfo3|string|备用信息3|-
└─needInitUser|boolean|是否同步初始化人员，0否1是，是则人员会加入BASE_USER|-
└─userId|string|机构用户人员ID，关联BASE_USER，初始化之后更新|-
└─needInitOrgan|boolean|是否同步初始化机构，0否1是，是则人员会加入BASE_ORGAN|-
└─organId|string|机构ID，关联BASE_ORGAN，初始化之后更新|-
└─type|string|类型，RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345|-
└─foreignUrl|string|外部URL，如SJKB的URL，人才预约的URL|-
└─bizType|int32|业务类型，1具体单位2具体地域3具体权限组4综合权限9多个同类信息，12单位和地域，13单位和权限组，19多个单位，23地域和权限组，29多个地域，39多个权限|-
└─bizOrganId|string|业务机构ID，人员绑定机构，绑定的ORGAN_ID|-
└─bizAreaId|int64|业务权限ID，当前查询范围|-
└─bizGroupId|int64|业务会员组ID|-
└─bizPower|string|业务综合权限，备用字段|-
└─bizMultiInfo|string|多个信息时，Ids,隔开|-
└─needSetOrgan|boolean|是否需要绑定企业，0否1是，是则人员会配置IDENTITY的ORGAN_ID信息|-
└─needSetArea|boolean|是否需要绑定地域，0否1是，是则人员会配置IDENTITY的POWER_AREA_ID信息|-
└─needSetGroup|boolean|是否需要绑定会员组，0否1是，是则人员会配置会员组，并设置IDENTITY内的GROUP_ID|-
└─needSetPower|boolean|是否需要绑定综合权限，0否1是，是则人员会配置IDENTITY的其他综合权限等信息|-
└─opUserId|string|操作人ID|-
└─opOrganId|string|操作单位ID|-
└─opTime|string|操作时间|-
└─opInfo|string|操作说明|-
└─priority|int32|排序码|-
└─status|int32|状态0未初始化1初始化配置成功2初始化配置不成功|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─dataBatch|string|数据批次号|-
└─dataVersion|int32|数据版本，流水号，向上增加|-
└─updateTime|string|数据更新时间|-
└─syncMode|string|同步类型，I插入，U更新，D删除，DM人工删除，UM人工更新|-
└─syncTime|string|同步更新时间|-
└─description|string|描述|-
└─groupName|string|角色组名称，角色名称|-
└─positionName|string|岗名称|-
└─bizPowerName|string|业务范围名称|-
└─subdistrictName|string|业务范围,街镇名称|-
└─communityName|string|业务范围,居委名称|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:00",
    "lastTime": "2025-10-20 18:26:00",
    "id": 317,
    "appId": "172",
    "saveSource": "m15pp8",
    "unitName": "merle.larkin",
    "name": "merle.larkin",
    "idNum": "dr0r6x",
    "duty": "3sawg4",
    "telephone": "1-203-302-2484",
    "mobile": "(415) 540-6962",
    "extInfo1": "yvnjt8",
    "extInfo2": "8y4mza",
    "extInfo3": "y4105s",
    "needInitUser": true,
    "userId": "172",
    "needInitOrgan": true,
    "organId": "172",
    "type": "37wvwe",
    "foreignUrl": "www.ben-grant.info",
    "bizType": 626,
    "bizOrganId": "172",
    "bizAreaId": 335,
    "bizGroupId": 191,
    "bizPower": "7i5wla",
    "bizMultiInfo": "rr7mia",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "172",
    "opOrganId": "172",
    "opTime": "2025-10-20 18:26:00",
    "opInfo": "abijyl",
    "priority": 668,
    "status": 501,
    "delFlag": 5,
    "dataBatch": "kjmaq5",
    "dataVersion": 234,
    "updateTime": "2025-10-20 18:26:00",
    "syncMode": "1sqq4n",
    "syncTime": "2025-10-20 18:26:00",
    "description": "q5ax80",
    "groupName": "merle.larkin",
    "positionName": "merle.larkin",
    "bizPowerName": "merle.larkin",
    "subdistrictName": "merle.larkin",
    "communityName": "merle.larkin"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增户权限预置
**URL:** https://linlan.net/eframe_backend/api/admin/preset/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 新增户权限预置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|预置信息ID|false|-
└─appId|string|所属应用ID|false|-
└─saveSource|string|来源，RGYZ人工预置，PLTJ批量添加|false|-
└─unitName|string|服务处所，单位名称|false|-
└─name|string|姓名|false|-
└─idNum|string|身份证号|false|-
└─duty|string|人员职务|false|-
└─telephone|string|办公电话|false|-
└─mobile|string|手机号码|false|-
└─extInfo1|string|备用信息1，可保存岗位名称|false|-
└─extInfo2|string|备用信息2，可保存所属网格等信息|false|-
└─extInfo3|string|备用信息3|false|-
└─needInitUser|boolean|是否同步初始化人员，0否1是，是则人员会加入BASE_USER|false|-
└─userId|string|机构用户人员ID，关联BASE_USER，初始化之后更新|false|-
└─needInitOrgan|boolean|是否同步初始化机构，0否1是，是则人员会加入BASE_ORGAN|false|-
└─organId|string|机构ID，关联BASE_ORGAN，初始化之后更新|false|-
└─type|string|类型，RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345|false|-
└─foreignUrl|string|外部URL，如SJKB的URL，人才预约的URL|false|-
└─bizType|int32|业务类型，1具体单位2具体地域3具体权限组4综合权限9多个同类信息，12单位和地域，13单位和权限组，19多个单位，23地域和权限组，29多个地域，39多个权限|false|-
└─bizOrganId|string|业务机构ID，人员绑定机构，绑定的ORGAN_ID|false|-
└─bizAreaId|int64|业务权限ID，当前查询范围|false|-
└─bizGroupId|int64|业务会员组ID|false|-
└─bizPower|string|业务综合权限，备用字段|false|-
└─bizMultiInfo|string|多个信息时，Ids,隔开|false|-
└─needSetOrgan|boolean|是否需要绑定企业，0否1是，是则人员会配置IDENTITY的ORGAN_ID信息|false|-
└─needSetArea|boolean|是否需要绑定地域，0否1是，是则人员会配置IDENTITY的POWER_AREA_ID信息|false|-
└─needSetGroup|boolean|是否需要绑定会员组，0否1是，是则人员会配置会员组，并设置IDENTITY内的GROUP_ID|false|-
└─needSetPower|boolean|是否需要绑定综合权限，0否1是，是则人员会配置IDENTITY的其他综合权限等信息|false|-
└─opUserId|string|操作人ID|false|-
└─opOrganId|string|操作单位ID|false|-
└─opTime|string|操作时间|false|-
└─opInfo|string|操作说明|false|-
└─priority|int32|排序码|false|-
└─status|int32|状态0未初始化1初始化配置成功2初始化配置不成功|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─dataBatch|string|数据批次号|false|-
└─dataVersion|int32|数据版本，流水号，向上增加|false|-
└─updateTime|string|数据更新时间|false|-
└─syncMode|string|同步类型，I插入，U更新，D删除，DM人工删除，UM人工更新|false|-
└─syncTime|string|同步更新时间|false|-
└─description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:00",
    "lastTime": "2025-10-20 18:26:00",
    "id": 540,
    "appId": "172",
    "saveSource": "kga1tp",
    "unitName": "merle.larkin",
    "name": "merle.larkin",
    "idNum": "nkaezs",
    "duty": "1nzsgw",
    "telephone": "1-203-302-2484",
    "mobile": "(415) 540-6962",
    "extInfo1": "lxsb0l",
    "extInfo2": "14utbk",
    "extInfo3": "nl2zcv",
    "needInitUser": true,
    "userId": "172",
    "needInitOrgan": true,
    "organId": "172",
    "type": "ivq1rr",
    "foreignUrl": "www.ben-grant.info",
    "bizType": 476,
    "bizOrganId": "172",
    "bizAreaId": 986,
    "bizGroupId": 989,
    "bizPower": "u26axm",
    "bizMultiInfo": "7prwox",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "172",
    "opOrganId": "172",
    "opTime": "2025-10-20 18:26:00",
    "opInfo": "qhjv82",
    "priority": 913,
    "status": 171,
    "delFlag": 5,
    "dataBatch": "yrfhew",
    "dataVersion": 702,
    "updateTime": "2025-10-20 18:26:00",
    "syncMode": "psacot",
    "syncTime": "2025-10-20 18:26:00",
    "description": "997rhb"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "0yesbr",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改户权限预置
**URL:** https://linlan.net/eframe_backend/api/admin/preset/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 修改户权限预置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|预置信息ID|false|-
└─appId|string|所属应用ID|false|-
└─saveSource|string|来源，RGYZ人工预置，PLTJ批量添加|false|-
└─unitName|string|服务处所，单位名称|false|-
└─name|string|姓名|false|-
└─idNum|string|身份证号|false|-
└─duty|string|人员职务|false|-
└─telephone|string|办公电话|false|-
└─mobile|string|手机号码|false|-
└─extInfo1|string|备用信息1，可保存岗位名称|false|-
└─extInfo2|string|备用信息2，可保存所属网格等信息|false|-
└─extInfo3|string|备用信息3|false|-
└─needInitUser|boolean|是否同步初始化人员，0否1是，是则人员会加入BASE_USER|false|-
└─userId|string|机构用户人员ID，关联BASE_USER，初始化之后更新|false|-
└─needInitOrgan|boolean|是否同步初始化机构，0否1是，是则人员会加入BASE_ORGAN|false|-
└─organId|string|机构ID，关联BASE_ORGAN，初始化之后更新|false|-
└─type|string|类型，RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345|false|-
└─foreignUrl|string|外部URL，如SJKB的URL，人才预约的URL|false|-
└─bizType|int32|业务类型，1具体单位2具体地域3具体权限组4综合权限9多个同类信息，12单位和地域，13单位和权限组，19多个单位，23地域和权限组，29多个地域，39多个权限|false|-
└─bizOrganId|string|业务机构ID，人员绑定机构，绑定的ORGAN_ID|false|-
└─bizAreaId|int64|业务权限ID，当前查询范围|false|-
└─bizGroupId|int64|业务会员组ID|false|-
└─bizPower|string|业务综合权限，备用字段|false|-
└─bizMultiInfo|string|多个信息时，Ids,隔开|false|-
└─needSetOrgan|boolean|是否需要绑定企业，0否1是，是则人员会配置IDENTITY的ORGAN_ID信息|false|-
└─needSetArea|boolean|是否需要绑定地域，0否1是，是则人员会配置IDENTITY的POWER_AREA_ID信息|false|-
└─needSetGroup|boolean|是否需要绑定会员组，0否1是，是则人员会配置会员组，并设置IDENTITY内的GROUP_ID|false|-
└─needSetPower|boolean|是否需要绑定综合权限，0否1是，是则人员会配置IDENTITY的其他综合权限等信息|false|-
└─opUserId|string|操作人ID|false|-
└─opOrganId|string|操作单位ID|false|-
└─opTime|string|操作时间|false|-
└─opInfo|string|操作说明|false|-
└─priority|int32|排序码|false|-
└─status|int32|状态0未初始化1初始化配置成功2初始化配置不成功|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─dataBatch|string|数据批次号|false|-
└─dataVersion|int32|数据版本，流水号，向上增加|false|-
└─updateTime|string|数据更新时间|false|-
└─syncMode|string|同步类型，I插入，U更新，D删除，DM人工删除，UM人工更新|false|-
└─syncTime|string|同步更新时间|false|-
└─description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:00",
    "lastTime": "2025-10-20 18:26:00",
    "id": 618,
    "appId": "172",
    "saveSource": "qgexw3",
    "unitName": "merle.larkin",
    "name": "merle.larkin",
    "idNum": "gc3d9k",
    "duty": "xyqxnh",
    "telephone": "1-203-302-2484",
    "mobile": "(415) 540-6962",
    "extInfo1": "cyjn7k",
    "extInfo2": "ah66q1",
    "extInfo3": "5u9ibo",
    "needInitUser": true,
    "userId": "172",
    "needInitOrgan": true,
    "organId": "172",
    "type": "j6kfi2",
    "foreignUrl": "www.ben-grant.info",
    "bizType": 281,
    "bizOrganId": "172",
    "bizAreaId": 550,
    "bizGroupId": 491,
    "bizPower": "pmzap3",
    "bizMultiInfo": "2lu1df",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "172",
    "opOrganId": "172",
    "opTime": "2025-10-20 18:26:00",
    "opInfo": "047s92",
    "priority": 544,
    "status": 403,
    "delFlag": 5,
    "dataBatch": "ew2tm5",
    "dataVersion": 311,
    "updateTime": "2025-10-20 18:26:00",
    "syncMode": "jxqod6",
    "syncTime": "2025-10-20 18:26:00",
    "description": "86x172"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "tu4hb8",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除户权限预置
**URL:** https://linlan.net/eframe_backend/api/admin/preset/delete/{configIds}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除户权限预置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
configIds|array| 配置IDs,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "rujenz",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 刷新户权限预置缓存
**URL:** https://linlan.net/eframe_backend/api/admin/preset/refreshCache.do

**Type:** DELETE

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 刷新户权限预置缓存

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/refreshCache.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "frz69q",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 用户注册验证
### 系统用户注册
**URL:** https://linlan.net/eframe_backend/register.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 系统用户注册

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─username|string|用户名|false|-
└─password|string|用户密码|false|-
└─code|string|验证码|false|-
└─uuid|string|唯一标识|false|-
└─appId|string|所在应用ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/register.do --data '{
  "data": {
    "username": "merle.larkin",
    "password": "47ydx1",
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad",
    "appId": "172"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "dd83w7",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 管理员登录日志查询读取控制类
### 获取管理员登录日志列表
**URL:** https://linlan.net/eframe_backend/api/monitor/loginlog/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-07 20:45:06

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取管理员登录日志列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
infoId|int64|ID|false|-
username|string|用户账号|false|-
status|string|登录状态 0成功 1失败|false|-
ipaddr|string|登录IP地址|false|-
loginTime|string|访问时间|false|-
browser|string|浏览器类型|false|-
os|string|操作系统|false|-
msg|string|提示消息|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/list.do?infoId=591&username=merle.larkin&q=evtjoz&orderBy=434&limit=10&endTime=2025-10-20 18:20:52&loginTime=2025-10-20 18:26:02&ipaddr=25b81w&status=s2t834&msg=z46ur8&browser=z2ykft&os=hqus8s&page=1&startTime=2025-10-20 18:20:52
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─infoId|int64|ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户账号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|string|登录状态 0成功 1失败|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ipaddr|string|登录IP地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginLocation|string|登录地点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─browser|string|浏览器类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─os|string|操作系统|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─msg|string|提示消息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginTime|string|访问时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 80,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "infoId": 536,
        "username": "merle.larkin",
        "status": "p7giel",
        "ipaddr": "l2u0w3",
        "loginLocation": "hbz086",
        "browser": "h18tkz",
        "os": "l1nbqb",
        "msg": "5kuamn",
        "loginTime": "2025-10-20 18:26:02",
        "remark": "6wsy1k"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取管理员登录日志列表
**URL:** https://linlan.net/eframe_backend/api/monitor/loginlog/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-07 20:45:06

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取管理员登录日志列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
infoId|int64|ID|false|-
username|string|用户账号|false|-
status|string|登录状态 0成功 1失败|false|-
ipaddr|string|登录IP地址|false|-
loginTime|string|访问时间|false|-
browser|string|浏览器类型|false|-
os|string|操作系统|false|-
msg|string|提示消息|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/export.do --data 'startTime=2025-10-20 18:20:52&limit=10&infoId=252&status=zqxmwn&browser=684nal&username=merle.larkin&orderBy=11&msg=9ya476&q=c2x8ss&endTime=2025-10-20 18:20:52&loginTime=2025-10-20 18:26:02&os=f6cgrn&page=1&ipaddr=kzidmz'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "lrn9en",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除管理员登录日志
**URL:** https://linlan.net/eframe_backend/api/monitor/loginlog/{infoIds}.do

**Type:** DELETE

**Author:** Linlan
CreateTime 2024-10-07 20:45:06

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除管理员登录日志

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
infoIds|array| 信息Ids,[array of int64]|true|

**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "uc74go",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 清理管理员登录日志
**URL:** https://linlan.net/eframe_backend/api/monitor/loginlog/clean.do

**Type:** DELETE

**Author:** Linlan
CreateTime 2024-10-07 20:45:06

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 清理管理员登录日志

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/clean.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "4bqup9",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 账户解锁
**URL:** https://linlan.net/eframe_backend/api/monitor/loginlog/unlock/{username}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-07 20:45:06

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 账户解锁

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
username|string| 用户名|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/unlock/merle.larkin.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "l40al8",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 管理用户增删改操作控制类
### AdminUser Operation. AdminUser数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/admin/user/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** AdminUser Operation. AdminUser数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|用户LID|false|-
└─userId|string|用户UUID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─name|string|人员姓名|false|-
└─username|string|用户账号|false|-
└─nickName|string|用户昵称|false|-
└─email|string|用户邮箱|false|-
└─mobile|string|手机号码|false|-
└─imagePath|string|用户头像|false|-
└─password|string|密码|false|-
└─isSuperAdmin|boolean|是否超级管理员|false|-
└─isAuditAdmin|boolean|是否审计只读管理员|false|-
└─isSelfAdmin|boolean|是否只管理自己的数据|false|-
└─status|int32|帐号状态（0未生效 1正常）|false|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
└─lastLoginIp|string|最后登录IP|false|-
└─lastLoginTime|string|最后登录时间|false|-
└─description|string|备注,办公地址|false|-
└─dept|object|部门对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|false|-
└─roles|array|角色对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|false|-
└─roleIds|array|角色组|false|-
└─positionIds|array|岗位组|false|-
└─roleId|int64|角色ID|false|-
└─userRoleList|array|角色集合|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|false|-
└─code|string|验证码|false|-
└─uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:56",
    "lastTime": "2025-10-20 18:25:56",
    "id": 709,
    "userId": "172",
    "deptId": 31,
    "deptName": "merle.larkin",
    "organId": "172",
    "organName": "merle.larkin",
    "name": "merle.larkin",
    "username": "merle.larkin",
    "nickName": "renna.dibbert",
    "email": "vivian.streich@hotmail.com",
    "mobile": "(415) 540-6962",
    "imagePath": "iwox4b",
    "password": "n3cg42",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 981,
    "delFlag": 5,
    "lastLoginIp": "137.119.212.174",
    "lastLoginTime": "2025-10-20 18:25:56",
    "description": "3xdw2t",
    "dept": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:56",
      "lastTime": "2025-10-20 18:25:56",
      "id": 755,
      "organId": "172",
      "parentId": 475,
      "appId": "172",
      "depttypeId": 878,
      "foreignId": "172",
      "createType": 97,
      "type": "4736sb",
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "areaCode": "81486",
      "organLeader": "6gnjjm",
      "leaderId": "172",
      "leaderMobile": "(415) 540-6962",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "81486",
      "imagePath": "rt8v3a",
      "priority": 755,
      "status": 975,
      "delFlag": 5,
      "description": "l2epoc",
      "spare1": "uuhlqu",
      "spare2": "l72gtp",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:56",
        "lastTime": "2025-10-20 18:25:56",
        "id": 992,
        "roletypeId": "172",
        "appId": "172",
        "name": "merle.larkin",
        "code": "81486",
        "priority": 332,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 509,
        "description": "myq3y8",
        "areaType": "hq0y12"
      }
    ],
    "roleIds": [
      100
    ],
    "positionIds": [
      "54afr3"
    ],
    "roleId": 371,
    "userRoleList": [
      {
        "id": 26,
        "deptId": 328,
        "deptName": "merle.larkin",
        "organId": "172",
        "organName": "merle.larkin",
        "roleId": 937,
        "roleName": "merle.larkin",
        "adminId": 309
      }
    ],
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ycinlt",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### AdminUser Operation. AdminUser数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/admin/user/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** AdminUser Operation. AdminUser数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|用户LID|false|-
└─userId|string|用户UUID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─name|string|人员姓名|false|-
└─username|string|用户账号|false|-
└─nickName|string|用户昵称|false|-
└─email|string|用户邮箱|false|-
└─mobile|string|手机号码|false|-
└─imagePath|string|用户头像|false|-
└─password|string|密码|false|-
└─isSuperAdmin|boolean|是否超级管理员|false|-
└─isAuditAdmin|boolean|是否审计只读管理员|false|-
└─isSelfAdmin|boolean|是否只管理自己的数据|false|-
└─status|int32|帐号状态（0未生效 1正常）|false|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
└─lastLoginIp|string|最后登录IP|false|-
└─lastLoginTime|string|最后登录时间|false|-
└─description|string|备注,办公地址|false|-
└─dept|object|部门对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|false|-
└─roles|array|角色对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|false|-
└─roleIds|array|角色组|false|-
└─positionIds|array|岗位组|false|-
└─roleId|int64|角色ID|false|-
└─userRoleList|array|角色集合|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|false|-
└─code|string|验证码|false|-
└─uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:56",
    "lastTime": "2025-10-20 18:25:56",
    "id": 580,
    "userId": "172",
    "deptId": 412,
    "deptName": "merle.larkin",
    "organId": "172",
    "organName": "merle.larkin",
    "name": "merle.larkin",
    "username": "merle.larkin",
    "nickName": "renna.dibbert",
    "email": "vivian.streich@hotmail.com",
    "mobile": "(415) 540-6962",
    "imagePath": "p1o4nt",
    "password": "3ds2bj",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 519,
    "delFlag": 5,
    "lastLoginIp": "137.119.212.174",
    "lastLoginTime": "2025-10-20 18:25:56",
    "description": "nhgpdv",
    "dept": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:56",
      "lastTime": "2025-10-20 18:25:56",
      "id": 317,
      "organId": "172",
      "parentId": 987,
      "appId": "172",
      "depttypeId": 203,
      "foreignId": "172",
      "createType": 744,
      "type": "dwgah7",
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "areaCode": "81486",
      "organLeader": "69cyel",
      "leaderId": "172",
      "leaderMobile": "(415) 540-6962",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "81486",
      "imagePath": "5hhxd1",
      "priority": 320,
      "status": 91,
      "delFlag": 5,
      "description": "b3rxwv",
      "spare1": "fxtbwa",
      "spare2": "emnf0t",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:56",
        "lastTime": "2025-10-20 18:25:56",
        "id": 145,
        "roletypeId": "172",
        "appId": "172",
        "name": "merle.larkin",
        "code": "81486",
        "priority": 580,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 968,
        "description": "ljqabc",
        "areaType": "jvqesm"
      }
    ],
    "roleIds": [
      179
    ],
    "positionIds": [
      "umedzp"
    ],
    "roleId": 667,
    "userRoleList": [
      {
        "id": 343,
        "deptId": 437,
        "deptName": "merle.larkin",
        "organId": "172",
        "organName": "merle.larkin",
        "roleId": 470,
        "roleName": "merle.larkin",
        "adminId": 204
      }
    ],
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "sifm7a",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 停用启用用户
**URL:** https://linlan.net/eframe_backend/api/admin/user/disable/{id}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 停用启用用户

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|企业管理用户ID|false|-
└─userId|string|系统管理用户ID|false|-
└─organId|string|机构ID|false|-
└─deptId|int64|单位ID|false|-
└─createType|int32|创建方式0导入1录入2授权|false|-
└─name|string|显示名称，可设置为用户名、手机号、昵称、真名|false|-
└─username|string|用户名|false|-
└─mobile|string|手机号码|false|-
└─email|string|电子邮箱|false|-
└─password|string|密码|false|-
└─salt|string|混淆字符|false|-
└─imagePath|string|头像|false|-
└─adminType|string|管理类型：ADMIN管理员，DEMO演示用户|false|-
└─isSuperAdmin|boolean|是否超级管理员|false|-
└─isAuditAdmin|boolean|是否审计只读管理员|false|-
└─isSelfAdmin|boolean|是否只管理自己的数据|false|-
└─adminRange|string|管理的范围配置JSON，APP_ID或者SITE_ID的数组，或者单个APP_ID|false|-
└─adminPerms|string|管理权限JSON|false|-
└─lastAppId|string|最后登录的应用ID|false|-
└─lastLoginTime|string|最后登录时间|false|-
└─lastLoginIp|string|最后登录IP|false|-
└─loginCount|int32|登录次数|false|-
└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─roleIds|array|角色组|false|-
└─positionIds|array|岗位组|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/disable/{id}.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:56",
    "lastTime": "2025-10-20 18:25:56",
    "id": 722,
    "userId": "172",
    "organId": "172",
    "deptId": 289,
    "createType": 442,
    "name": "merle.larkin",
    "username": "merle.larkin",
    "mobile": "(415) 540-6962",
    "email": "vivian.streich@hotmail.com",
    "password": "tb1r27",
    "salt": "dcyx5h",
    "imagePath": "ij6kvn",
    "adminType": "9u9mn0",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "adminRange": "2aqyuu",
    "adminPerms": "ixlx49",
    "lastAppId": "172",
    "lastLoginTime": "2025-10-20 18:25:56",
    "lastLoginIp": "137.119.212.174",
    "loginCount": 864,
    "status": 876,
    "delFlag": 5,
    "spare1": "m0f6de",
    "spare2": "235qam",
    "roleIds": [
      204
    ],
    "positionIds": [
      "uxdoc7"
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "2hmrx2",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 重置密码
**URL:** https://linlan.net/eframe_backend/api/admin/user/resetpassword/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 重置密码

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array| 管理员Ids,[array of int64]|true|

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|用户LID|false|-
└─userId|string|用户UUID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─name|string|人员姓名|false|-
└─username|string|用户账号|false|-
└─nickName|string|用户昵称|false|-
└─email|string|用户邮箱|false|-
└─mobile|string|手机号码|false|-
└─imagePath|string|用户头像|false|-
└─password|string|密码|false|-
└─isSuperAdmin|boolean|是否超级管理员|false|-
└─isAuditAdmin|boolean|是否审计只读管理员|false|-
└─isSelfAdmin|boolean|是否只管理自己的数据|false|-
└─status|int32|帐号状态（0未生效 1正常）|false|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
└─lastLoginIp|string|最后登录IP|false|-
└─lastLoginTime|string|最后登录时间|false|-
└─description|string|备注,办公地址|false|-
└─dept|object|部门对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|false|-
└─roles|array|角色对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|false|-
└─roleIds|array|角色组|false|-
└─positionIds|array|岗位组|false|-
└─roleId|int64|角色ID|false|-
└─userRoleList|array|角色集合|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|false|-
└─code|string|验证码|false|-
└─uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/resetpassword/.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:56",
    "lastTime": "2025-10-20 18:25:56",
    "id": 178,
    "userId": "172",
    "deptId": 511,
    "deptName": "merle.larkin",
    "organId": "172",
    "organName": "merle.larkin",
    "name": "merle.larkin",
    "username": "merle.larkin",
    "nickName": "renna.dibbert",
    "email": "vivian.streich@hotmail.com",
    "mobile": "(415) 540-6962",
    "imagePath": "e9dw24",
    "password": "uru8em",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 832,
    "delFlag": 5,
    "lastLoginIp": "137.119.212.174",
    "lastLoginTime": "2025-10-20 18:25:56",
    "description": "d8zgds",
    "dept": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:56",
      "lastTime": "2025-10-20 18:25:56",
      "id": 846,
      "organId": "172",
      "parentId": 584,
      "appId": "172",
      "depttypeId": 813,
      "foreignId": "172",
      "createType": 938,
      "type": "6xc0lc",
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "areaCode": "81486",
      "organLeader": "x2cj4w",
      "leaderId": "172",
      "leaderMobile": "(415) 540-6962",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "81486",
      "imagePath": "h58ju9",
      "priority": 218,
      "status": 596,
      "delFlag": 5,
      "description": "jihkkn",
      "spare1": "vzgr5q",
      "spare2": "wo5q10",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:56",
        "lastTime": "2025-10-20 18:25:56",
        "id": 801,
        "roletypeId": "172",
        "appId": "172",
        "name": "merle.larkin",
        "code": "81486",
        "priority": 31,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 698,
        "description": "13f8xm",
        "areaType": "qs6a24"
      }
    ],
    "roleIds": [
      173
    ],
    "positionIds": [
      "7vxx5c"
    ],
    "roleId": 934,
    "userRoleList": [
      {
        "id": 396,
        "deptId": 194,
        "deptName": "merle.larkin",
        "organId": "172",
        "organName": "merle.larkin",
        "roleId": 270,
        "roleName": "merle.larkin",
        "adminId": 144
      }
    ],
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "dvss2a",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除用户
**URL:** https://linlan.net/eframe_backend/api/admin/user/delete/{adminIds}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除用户

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
adminIds|array| 管理员Ids,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "4kvh6f",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 用户数据导出
**URL:** https://linlan.net/eframe_backend/api/admin/user/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 用户数据导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
adminId|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
organId|string|机构ID|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
status|string|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 1代表删除）|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/export.do --data 'startTime=2025-10-20 18:20:52&mobile=(415) 540-6962&q=42d78v&orderBy=974&page=1&userId=172&organId=172&email=vivian.streich@hotmail.com&deptId=118&nickName=renna.dibbert&username=merle.larkin&endTime=2025-10-20 18:20:52&adminId=46&status=ado2nr&delFlag=5&limit=10'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "0creh2",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 用户数据导入
**URL:** https://linlan.net/eframe_backend/api/admin/user/importData.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** multipart/form-data

**Description:** 用户数据导入

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
file|file| 文件|true|-
updateSupport|boolean|    是否支持更新|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: multipart/form-data' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/importData.do --data 'updateSupport=true'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "1f2v32",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 用户导入模板下载
**URL:** https://linlan.net/eframe_backend/api/admin/user/importTemplate.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 用户导入模板下载

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/importTemplate.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "5r1gdg",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 重置密码
**URL:** https://linlan.net/eframe_backend/api/admin/user/resetPwd.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 重置密码

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|用户LID|false|-
└─userId|string|用户UUID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─name|string|人员姓名|false|-
└─username|string|用户账号|false|-
└─nickName|string|用户昵称|false|-
└─email|string|用户邮箱|false|-
└─mobile|string|手机号码|false|-
└─imagePath|string|用户头像|false|-
└─password|string|密码|false|-
└─isSuperAdmin|boolean|是否超级管理员|false|-
└─isAuditAdmin|boolean|是否审计只读管理员|false|-
└─isSelfAdmin|boolean|是否只管理自己的数据|false|-
└─status|int32|帐号状态（0未生效 1正常）|false|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
└─lastLoginIp|string|最后登录IP|false|-
└─lastLoginTime|string|最后登录时间|false|-
└─description|string|备注,办公地址|false|-
└─dept|object|部门对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|false|-
└─roles|array|角色对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|false|-
└─roleIds|array|角色组|false|-
└─positionIds|array|岗位组|false|-
└─roleId|int64|角色ID|false|-
└─userRoleList|array|角色集合|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|false|-
└─code|string|验证码|false|-
└─uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/resetPwd.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:57",
    "lastTime": "2025-10-20 18:25:57",
    "id": 373,
    "userId": "172",
    "deptId": 307,
    "deptName": "merle.larkin",
    "organId": "172",
    "organName": "merle.larkin",
    "name": "merle.larkin",
    "username": "merle.larkin",
    "nickName": "renna.dibbert",
    "email": "vivian.streich@hotmail.com",
    "mobile": "(415) 540-6962",
    "imagePath": "nh9yz7",
    "password": "mciyp0",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 83,
    "delFlag": 5,
    "lastLoginIp": "137.119.212.174",
    "lastLoginTime": "2025-10-20 18:25:57",
    "description": "n62rlr",
    "dept": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:57",
      "lastTime": "2025-10-20 18:25:57",
      "id": 566,
      "organId": "172",
      "parentId": 401,
      "appId": "172",
      "depttypeId": 354,
      "foreignId": "172",
      "createType": 970,
      "type": "3h2f0v",
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "areaCode": "81486",
      "organLeader": "ow66n4",
      "leaderId": "172",
      "leaderMobile": "(415) 540-6962",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "81486",
      "imagePath": "524tt6",
      "priority": 185,
      "status": 592,
      "delFlag": 5,
      "description": "1urh6b",
      "spare1": "jz89k8",
      "spare2": "rhk0cg",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:57",
        "lastTime": "2025-10-20 18:25:57",
        "id": 275,
        "roletypeId": "172",
        "appId": "172",
        "name": "merle.larkin",
        "code": "81486",
        "priority": 136,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 773,
        "description": "lir1bu",
        "areaType": "bisi55"
      }
    ],
    "roleIds": [
      356
    ],
    "positionIds": [
      "d80a46"
    ],
    "roleId": 741,
    "userRoleList": [
      {
        "id": 401,
        "deptId": 615,
        "deptName": "merle.larkin",
        "organId": "172",
        "organName": "merle.larkin",
        "roleId": 618,
        "roleName": "merle.larkin",
        "adminId": 852
      }
    ],
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "6bt2vs",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 用户状态修改
**URL:** https://linlan.net/eframe_backend/api/admin/user/changeStatus.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 用户状态修改

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|用户LID|false|-
└─userId|string|用户UUID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─name|string|人员姓名|false|-
└─username|string|用户账号|false|-
└─nickName|string|用户昵称|false|-
└─email|string|用户邮箱|false|-
└─mobile|string|手机号码|false|-
└─imagePath|string|用户头像|false|-
└─password|string|密码|false|-
└─isSuperAdmin|boolean|是否超级管理员|false|-
└─isAuditAdmin|boolean|是否审计只读管理员|false|-
└─isSelfAdmin|boolean|是否只管理自己的数据|false|-
└─status|int32|帐号状态（0未生效 1正常）|false|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
└─lastLoginIp|string|最后登录IP|false|-
└─lastLoginTime|string|最后登录时间|false|-
└─description|string|备注,办公地址|false|-
└─dept|object|部门对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|false|-
└─roles|array|角色对象|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|false|-
└─roleIds|array|角色组|false|-
└─positionIds|array|岗位组|false|-
└─roleId|int64|角色ID|false|-
└─userRoleList|array|角色集合|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|false|-
└─code|string|验证码|false|-
└─uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/changeStatus.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:57",
    "lastTime": "2025-10-20 18:25:57",
    "id": 592,
    "userId": "172",
    "deptId": 549,
    "deptName": "merle.larkin",
    "organId": "172",
    "organName": "merle.larkin",
    "name": "merle.larkin",
    "username": "merle.larkin",
    "nickName": "renna.dibbert",
    "email": "vivian.streich@hotmail.com",
    "mobile": "(415) 540-6962",
    "imagePath": "b9a1qb",
    "password": "j1urzi",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 864,
    "delFlag": 5,
    "lastLoginIp": "137.119.212.174",
    "lastLoginTime": "2025-10-20 18:25:57",
    "description": "ri4yq7",
    "dept": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:57",
      "lastTime": "2025-10-20 18:25:57",
      "id": 520,
      "organId": "172",
      "parentId": 195,
      "appId": "172",
      "depttypeId": 453,
      "foreignId": "172",
      "createType": 153,
      "type": "lug5uq",
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "areaCode": "81486",
      "organLeader": "ug3kk7",
      "leaderId": "172",
      "leaderMobile": "(415) 540-6962",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "81486",
      "imagePath": "eneyrh",
      "priority": 315,
      "status": 209,
      "delFlag": 5,
      "description": "u14kuj",
      "spare1": "xdwx7i",
      "spare2": "7y0i4j",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:57",
        "lastTime": "2025-10-20 18:25:57",
        "id": 282,
        "roletypeId": "172",
        "appId": "172",
        "name": "merle.larkin",
        "code": "81486",
        "priority": 253,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 268,
        "description": "tpipu0",
        "areaType": "8x61in"
      }
    ],
    "roleIds": [
      731
    ],
    "positionIds": [
      "yqcvsy"
    ],
    "roleId": 891,
    "userRoleList": [
      {
        "id": 609,
        "deptId": 782,
        "deptName": "merle.larkin",
        "organId": "172",
        "organName": "merle.larkin",
        "roleId": 797,
        "roleName": "merle.larkin",
        "adminId": 56
      }
    ],
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "g4w2nq",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据用户编号获取授权角色
**URL:** https://linlan.net/eframe_backend/api/admin/user/authRole/{adminId}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据用户编号获取授权角色

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
adminId|int64|    管理员ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole/112.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "4pjvym",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 用户授权角色
**URL:** https://linlan.net/eframe_backend/api/admin/user/authRole.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 用户授权角色

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
adminId|int64|    管理员ID|false|-
roleIds|array|    角色Ids,[array of int64]|false|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole.do --data 'roleIds=fbos1z&roleIds=fbos1z&adminId=892'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "duvbne",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 管理用户查询读取控制类
### 获取用户列表
**URL:** https://linlan.net/eframe_backend/api/admin/user/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取用户列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
adminId|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
organId|string|机构ID|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
status|string|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 1代表删除）|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/list.do?endTime=2025-10-20 18:20:52&page=1&organId=172&nickName=renna.dibbert&adminId=630&email=vivian.streich@hotmail.com&limit=10&startTime=2025-10-20 18:20:52&userId=172&status=4qnpti&username=merle.larkin&orderBy=608&mobile=(415) 540-6962&delFlag=5&deptId=885&q=9wih8t
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|用户LID|-
└─userId|string|用户UUID|-
└─deptId|int64|部门ID|-
└─deptName|string|部门名称|-
└─organId|string|机构ID|-
└─organName|string|机构名称|-
└─name|string|人员姓名|-
└─username|string|用户账号|-
└─nickName|string|用户昵称|-
└─email|string|用户邮箱|-
└─mobile|string|手机号码|-
└─imagePath|string|用户头像|-
└─password|string|密码|-
└─isSuperAdmin|boolean|是否超级管理员|-
└─isAuditAdmin|boolean|是否审计只读管理员|-
└─isSelfAdmin|boolean|是否只管理自己的数据|-
└─status|int32|帐号状态（0未生效 1正常）|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|-
└─lastLoginIp|string|最后登录IP|-
└─lastLoginTime|string|最后登录时间|-
└─description|string|备注,办公地址|-
└─dept|object|部门对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|-
└─roles|array|角色对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|-
└─roleIds|array|角色组|-
└─positionIds|array|岗位组|-
└─roleId|int64|角色ID|-
└─userRoleList|array|角色集合|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|-
└─code|string|验证码|-
└─uuid|string|uuid标识|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:56",
      "lastTime": "2025-10-20 18:25:56",
      "id": 53,
      "userId": "172",
      "deptId": 0,
      "deptName": "merle.larkin",
      "organId": "172",
      "organName": "merle.larkin",
      "name": "merle.larkin",
      "username": "merle.larkin",
      "nickName": "renna.dibbert",
      "email": "vivian.streich@hotmail.com",
      "mobile": "(415) 540-6962",
      "imagePath": "7bvlb9",
      "password": "fgrire",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 987,
      "delFlag": 5,
      "lastLoginIp": "137.119.212.174",
      "lastLoginTime": "2025-10-20 18:25:56",
      "description": "4zdjaf",
      "dept": {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:56",
        "lastTime": "2025-10-20 18:25:56",
        "id": 748,
        "organId": "172",
        "parentId": 129,
        "appId": "172",
        "depttypeId": 517,
        "foreignId": "172",
        "createType": 819,
        "type": "vmadkp",
        "name": "merle.larkin",
        "sname": "merle.larkin",
        "areaCode": "81486",
        "organLeader": "5rsnzm",
        "leaderId": "172",
        "leaderMobile": "(415) 540-6962",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "81486",
        "imagePath": "p33hye",
        "priority": 807,
        "status": 264,
        "delFlag": 5,
        "description": "mb74jz",
        "spare1": "laogiv",
        "spare2": "8e99jw",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "172",
          "createTime": "2025-10-20 18:25:56",
          "lastTime": "2025-10-20 18:25:56",
          "id": 935,
          "roletypeId": "172",
          "appId": "172",
          "name": "merle.larkin",
          "code": "81486",
          "priority": 866,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 705,
          "description": "i505bo",
          "areaType": "rqexlq"
        }
      ],
      "roleIds": [
        36
      ],
      "positionIds": [
        "0r4yaz"
      ],
      "roleId": 105,
      "userRoleList": [
        {
          "id": 418,
          "deptId": 36,
          "deptName": "merle.larkin",
          "organId": "172",
          "organName": "merle.larkin",
          "roleId": 344,
          "roleName": "merle.larkin",
          "adminId": 294
        }
      ],
      "code": "81486",
      "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据用户编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/admin/[user/{adminId}].do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据用户编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
adminId|int64| 管理员ID|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/[user/467].do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─user|object|当前用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户LID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userId|string|用户UUID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|人员姓名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户账号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nickName|string|用户昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─email|string|用户邮箱|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mobile|string|手机号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|用户头像|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─password|string|密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuperAdmin|boolean|是否超级管理员|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isAuditAdmin|boolean|是否审计只读管理员|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSelfAdmin|boolean|是否只管理自己的数据|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|帐号状态（0未生效 1正常）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|删除标志（0代表存在 2代表删除）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastLoginIp|string|最后登录IP|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastLoginTime|string|最后登录时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|备注,办公地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dept|object|部门对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roles|array|角色对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleIds|array|角色组|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─positionIds|array|岗位组|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userRoleList|array|角色集合|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|验证码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─uuid|string|uuid标识|-
└─roles|array|角色列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleKey|string|角色权限|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleSort|int32|角色排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|角色状态（0未生效 1正常）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─flag|boolean|用户是否存在此角色标识 默认不存在|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─menuIds|array|菜单组|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptIds|array|部门组（数据权限）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permissions|array|角色菜单权限|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remark|string|备注|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentName|string|父角色名字|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appName|string|全局应用信息类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|系统角色分类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeName|string|系统角色分类|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|是否拥有所有权限|-
└─roleList|array|角色列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|-
└─positions|array|岗位列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postId|string|岗位序号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postCode|string|岗位编码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postName|string|岗位名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postSort|int32|岗位排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态（0未生效1正常2受限3锁定4删除）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建者|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|更新时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|删除标记（0正常 1删除）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remark|string|备注|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ids|array|角色id集合|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─positionId|string|岗位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─flag|boolean|用户是否存在此岗位标识 默认不存在|-
└─roleIds|array|角色Ids|-
└─positionIds|array|岗位Ids|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "user": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:56",
      "lastTime": "2025-10-20 18:25:56",
      "id": 685,
      "userId": "172",
      "deptId": 804,
      "deptName": "merle.larkin",
      "organId": "172",
      "organName": "merle.larkin",
      "name": "merle.larkin",
      "username": "merle.larkin",
      "nickName": "renna.dibbert",
      "email": "vivian.streich@hotmail.com",
      "mobile": "(415) 540-6962",
      "imagePath": "h7fqnd",
      "password": "6zve0q",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 254,
      "delFlag": 5,
      "lastLoginIp": "137.119.212.174",
      "lastLoginTime": "2025-10-20 18:25:56",
      "description": "ms1366",
      "dept": {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:56",
        "lastTime": "2025-10-20 18:25:56",
        "id": 504,
        "organId": "172",
        "parentId": 316,
        "appId": "172",
        "depttypeId": 126,
        "foreignId": "172",
        "createType": 769,
        "type": "q08eab",
        "name": "merle.larkin",
        "sname": "merle.larkin",
        "areaCode": "81486",
        "organLeader": "tkxhfi",
        "leaderId": "172",
        "leaderMobile": "(415) 540-6962",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "81486",
        "imagePath": "x7vp1z",
        "priority": 556,
        "status": 793,
        "delFlag": 5,
        "description": "migvho",
        "spare1": "3tjt4q",
        "spare2": "q85gdi",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "172",
          "createTime": "2025-10-20 18:25:56",
          "lastTime": "2025-10-20 18:25:56",
          "id": 796,
          "roletypeId": "172",
          "appId": "172",
          "name": "merle.larkin",
          "code": "81486",
          "priority": 841,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 830,
          "description": "gzrili",
          "areaType": "piwb1x"
        }
      ],
      "roleIds": [
        225
      ],
      "positionIds": [
        "vayyna"
      ],
      "roleId": 956,
      "userRoleList": [
        {
          "id": 621,
          "deptId": 588,
          "deptName": "merle.larkin",
          "organId": "172",
          "organName": "merle.larkin",
          "roleId": 966,
          "roleName": "merle.larkin",
          "adminId": 841
        }
      ],
      "code": "81486",
      "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
    },
    "roles": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:56",
        "lastTime": "2025-10-20 18:25:56",
        "roleId": 37,
        "roleName": "merle.larkin",
        "roleKey": "udvx9a",
        "roleSort": 871,
        "menuCheckStrictly": true,
        "deptCheckStrictly": true,
        "status": 300,
        "flag": true,
        "menuIds": [
          165
        ],
        "deptIds": [
          418
        ],
        "permissions": [
          "v5xen5"
        ],
        "remark": "w4uykz",
        "parentName": "merle.larkin",
        "appName": "merle.larkin",
        "roletypeId": "172",
        "roletypeName": "merle.larkin",
        "priority": 490,
        "isSuper": true
      }
    ],
    "roleList": [
      {
        "id": 111,
        "roleId": 159,
        "adminId": 10,
        "deptId": 203,
        "deptName": "merle.larkin",
        "organId": "172",
        "organName": "merle.larkin",
        "roleName": "merle.larkin"
      }
    ],
    "positions": [
      {
        "postId": "172",
        "postCode": "81486",
        "postName": "merle.larkin",
        "postSort": 631,
        "status": 113,
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:56",
        "lastTime": "2025-10-20 18:25:56",
        "delFlag": 5,
        "remark": "qt7efm",
        "ids": [
          "tgrlzs"
        ],
        "positionId": "172",
        "flag": true
      }
    ],
    "roleIds": [
      175
    ],
    "positionIds": [
      557
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取用户部门树列表
**URL:** https://linlan.net/eframe_backend/api/admin/user/deptTree.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取用户部门树列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
deptId|int64|单位ID|false|-
organId|string|系统机构ID|false|-
parentId|int64|父节点|false|-
appId|string|应用ID|false|-
depttypeId|int64|部门分类ID|false|-
foreignId|string|外部业务ID|false|-
createType|int32|创建方式0导入1录入2授权|false|-
type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
name|string|名称，多级累加名称|false|-
sname|string|名称简称，本单位显示名称|false|-
areaCode|string|地域编码，所在城市|false|-
organLeader|string|领导名称|false|-
leaderId|string|负责人ID，用户接收相关信息|false|-
leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
isLeaf|boolean|是否叶子节点|false|-
isDisabled|boolean|是否禁用0否1是|false|-
searchCode|string|多级累加路径|false|-
imagePath|string|图片路径|false|-
status|int32|状态0未生效1正常2受限3锁定4删除|false|-
creatorId|string|创建用户ID|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/deptTree.do?orderBy=848&areaCode=81486&startTime=2025-10-20 18:20:52&createType=563&sname=merle.larkin&leaderMobile=(415) 540-6962&organId=172&leaderId=172&depttypeId=640&spare2=vh9b3q&foreignId=172&status=386&appId=172&page=1&isOrganLevel=true&isVirtual=true&limit=10&name=merle.larkin&searchCode=81486&delFlag=5&description=8kbpis&q=dck15o&type=big50m&isLeaf=true&spare1=6ifxqg&creatorId=172&imagePath=vkrhnf&deptId=462&parentId=696&isDisabled=true&endTime=2025-10-20 18:20:52&organLeader=wmaimr
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─id|int64|节点ID|-
└─label|string|节点名称|-
└─children|array|子节点|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "id": 840,
      "label": "hf2j2u",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 系统岗位信息操作处理
### 获取岗位列表
**URL:** https://linlan.net/eframe_backend/api/admin/position/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取岗位列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
ids|array|岗位id数组|false|-
parentId|string|父岗位ID|false|-
postypeId|string|岗位分类ID|false|-
roletypeId|string|角色分类ID|false|-
name|string|岗位名称|false|-
sname|string|岗位简称，别名|false|-
code|string|UAS岗位id|false|-
oname|string|岗位别名|false|-
posFunction|string|工作分工，二维码申请页面模板|false|-
posRank|int32|级别|false|-
posType|string|岗位类型|false|-
status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定4删除|false|-
isPub|boolean|是否公开0否1是|false|-
mobilePhone|string|岗位移动手机|false|-
officePhone|string|岗位办公电话|false|-
delFlag|int32|删除标志0正常1已删除2应用内受限3回收站|false|-
description|string|描述，岗位职责|false|-
positionId|string|岗位ID|false|-
groupId|string|分组Id|false|-
id|string|编号id|false|-
roleTypeId|string|角色类型编号|false|-
createTime|string|创建时间|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/list.do?startTime=2025-10-20 18:20:52&orderBy=645&groupId=172&parentId=172&roletypeId=172&posFunction=bubpve&description=9fjq49&createTime=2025-10-20 18:20:52&delFlag=5&name=merle.larkin&status=626&limit=10&mobilePhone=1-203-302-2484&endTime=2025-10-20 18:20:52&posRank=60&code=81486&ids=7k54lp&ids=7k54lp&posType=tz7ls6&postypeId=172&roleTypeId=172&page=1&isPub=true&q=r4uesa&positionId=172&id=172&sname=merle.larkin&officePhone=1-203-302-2484&oname=merle.larkin
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postId|string|岗位序号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postCode|string|岗位编码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postName|string|岗位名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─postSort|int32|岗位排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态（0未生效1正常2受限3锁定4删除）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建者|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|更新时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|删除标记（0正常 1删除）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remark|string|备注|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ids|array|角色id集合|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─positionId|string|岗位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─flag|boolean|用户是否存在此岗位标识 默认不存在|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 136,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "postId": "172",
        "postCode": "81486",
        "postName": "merle.larkin",
        "postSort": 84,
        "status": 108,
        "creatorId": "172",
        "createTime": "2025-10-20 18:26:00",
        "lastTime": "2025-10-20 18:26:00",
        "delFlag": 5,
        "remark": "d7x45e",
        "ids": [
          "p0phw5"
        ],
        "positionId": "172",
        "flag": true
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 岗位列表导出
**URL:** https://linlan.net/eframe_backend/api/admin/position/export.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 岗位列表导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
postCode|string|岗位编码|false|-
postName|string|岗位名称|false|-
status|int32|状态（0未生效1正常2受限3锁定4删除）|false|-
delFlag|int32|删除标记（0正常 1删除）|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/export.do --data 'postName=merle.larkin&startTime=2025-10-20 18:20:52&q=8q3pdi&orderBy=415&page=1&limit=10&delFlag=5&endTime=2025-10-20 18:20:52&postCode=81486&status=604'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "hw96ex",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据岗位编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/admin/position/{postId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据岗位编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
postId|string| 岗位Id|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/172.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|岗位ID|-
└─parentId|string|父岗位ID|-
└─postypeId|string|岗位分类ID|-
└─roletypeId|string|角色分类ID|-
└─userId|string|系统管理用户ID|-
└─name|string|岗位名称|-
└─sname|string|岗位简称，别名|-
└─code|string|UAS岗位id|-
└─oname|string|岗位别名|-
└─posFunction|string|工作分工，二维码申请页面模板|-
└─posRank|int32|级别|-
└─posType|string|岗位类型|-
└─editorType|string|编制类型|-
└─isEditorCreate|boolean|是否编委创建|-
└─status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定4删除|-
└─isPub|boolean|是否公开0否1是|-
└─isAgent|boolean|是否代理岗位0否1是|-
└─isLeader|boolean|是否为部门领导0否1是|-
└─leaderId|string|部门领导用户ID|-
└─manageDeptids|string|分管内设机构|-
└─isBigContact|boolean|是否大通讯录|-
└─isSmallContact|boolean|是否小通讯录|-
└─mobilePhone|string|岗位移动手机|-
└─officePhone|string|岗位办公电话|-
└─buildingId|string|建筑楼栋号|-
└─roomNo|string|房间号|-
└─extQmType|string|微信签名类型|-
└─extQmTypePhoto|string|微信签名类型图片|-
└─extPosName|string|微信岗位|-
└─extOrganName|string|微信单位|-
└─priority|int32|排序|-
└─priorityInOrgan|int32|机构内排序|-
└─priorityInDomain|int32|应用域内排序|-
└─updaterId|string|修改人|-
└─updateTime|string|修改时间|-
└─delFlag|int32|删除标志0正常1已删除2应用内受限3回收站|-
└─description|string|描述，岗位职责|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:00",
    "lastTime": "2025-10-20 18:26:00",
    "id": "172",
    "parentId": "172",
    "postypeId": "172",
    "roletypeId": "172",
    "userId": "172",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "code": "81486",
    "oname": "merle.larkin",
    "posFunction": "lw8krg",
    "posRank": 337,
    "posType": "do4gyj",
    "editorType": "2dhc8l",
    "isEditorCreate": true,
    "status": 869,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "172",
    "manageDeptids": "imo476",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "1-203-302-2484",
    "officePhone": "1-203-302-2484",
    "buildingId": "172",
    "roomNo": "7ktr2n",
    "extQmType": "i5ju24",
    "extQmTypePhoto": "ry2c1r",
    "extPosName": "merle.larkin",
    "extOrganName": "merle.larkin",
    "priority": 55,
    "priorityInOrgan": 552,
    "priorityInDomain": 661,
    "updaterId": "172",
    "updateTime": "2025-10-20 18:26:00",
    "delFlag": 5,
    "description": "92a67v",
    "remark": "hu655y"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增岗位
**URL:** https://linlan.net/eframe_backend/api/admin/position/save.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增岗位

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|岗位ID|false|-
└─parentId|string|父岗位ID|false|-
└─postypeId|string|岗位分类ID|false|-
└─roletypeId|string|角色分类ID|false|-
└─userId|string|系统管理用户ID|false|-
└─name|string|岗位名称|false|-
└─sname|string|岗位简称，别名|false|-
└─code|string|UAS岗位id|false|-
└─oname|string|岗位别名|false|-
└─posFunction|string|工作分工，二维码申请页面模板|false|-
└─posRank|int32|级别|false|-
└─posType|string|岗位类型|false|-
└─editorType|string|编制类型|false|-
└─isEditorCreate|boolean|是否编委创建|false|-
└─status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定4删除|false|-
└─isPub|boolean|是否公开0否1是|false|-
└─isAgent|boolean|是否代理岗位0否1是|false|-
└─isLeader|boolean|是否为部门领导0否1是|false|-
└─leaderId|string|部门领导用户ID|false|-
└─manageDeptids|string|分管内设机构|false|-
└─isBigContact|boolean|是否大通讯录|false|-
└─isSmallContact|boolean|是否小通讯录|false|-
└─mobilePhone|string|岗位移动手机|false|-
└─officePhone|string|岗位办公电话|false|-
└─buildingId|string|建筑楼栋号|false|-
└─roomNo|string|房间号|false|-
└─extQmType|string|微信签名类型|false|-
└─extQmTypePhoto|string|微信签名类型图片|false|-
└─extPosName|string|微信岗位|false|-
└─extOrganName|string|微信单位|false|-
└─priority|int32|排序|false|-
└─priorityInOrgan|int32|机构内排序|false|-
└─priorityInDomain|int32|应用域内排序|false|-
└─updaterId|string|修改人|false|-
└─updateTime|string|修改时间|false|-
└─delFlag|int32|删除标志0正常1已删除2应用内受限3回收站|false|-
└─description|string|描述，岗位职责|false|-
└─remark|string|备注|false|-
└─parentName|string|父岗位名称|false|-
└─roletypeName|string|角色分类名称|false|-
└─postypeName|string|角色分类名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:01",
    "lastTime": "2025-10-20 18:26:01",
    "id": "172",
    "parentId": "172",
    "postypeId": "172",
    "roletypeId": "172",
    "userId": "172",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "code": "81486",
    "oname": "merle.larkin",
    "posFunction": "n8wjvu",
    "posRank": 830,
    "posType": "e6718v",
    "editorType": "pfp631",
    "isEditorCreate": true,
    "status": 970,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "172",
    "manageDeptids": "5whxz4",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "1-203-302-2484",
    "officePhone": "1-203-302-2484",
    "buildingId": "172",
    "roomNo": "bfkf16",
    "extQmType": "rnqn3l",
    "extQmTypePhoto": "pd8tl1",
    "extPosName": "merle.larkin",
    "extOrganName": "merle.larkin",
    "priority": 729,
    "priorityInOrgan": 665,
    "priorityInDomain": 609,
    "updaterId": "172",
    "updateTime": "2025-10-20 18:26:01",
    "delFlag": 5,
    "description": "aqm0mn",
    "remark": "jq4zje",
    "parentName": "merle.larkin",
    "roletypeName": "merle.larkin",
    "postypeName": "merle.larkin"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "0ugjai",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改岗位
**URL:** https://linlan.net/eframe_backend/api/admin/position/update.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改岗位

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|岗位ID|false|-
└─parentId|string|父岗位ID|false|-
└─postypeId|string|岗位分类ID|false|-
└─roletypeId|string|角色分类ID|false|-
└─userId|string|系统管理用户ID|false|-
└─name|string|岗位名称|false|-
└─sname|string|岗位简称，别名|false|-
└─code|string|UAS岗位id|false|-
└─oname|string|岗位别名|false|-
└─posFunction|string|工作分工，二维码申请页面模板|false|-
└─posRank|int32|级别|false|-
└─posType|string|岗位类型|false|-
└─editorType|string|编制类型|false|-
└─isEditorCreate|boolean|是否编委创建|false|-
└─status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定4删除|false|-
└─isPub|boolean|是否公开0否1是|false|-
└─isAgent|boolean|是否代理岗位0否1是|false|-
└─isLeader|boolean|是否为部门领导0否1是|false|-
└─leaderId|string|部门领导用户ID|false|-
└─manageDeptids|string|分管内设机构|false|-
└─isBigContact|boolean|是否大通讯录|false|-
└─isSmallContact|boolean|是否小通讯录|false|-
└─mobilePhone|string|岗位移动手机|false|-
└─officePhone|string|岗位办公电话|false|-
└─buildingId|string|建筑楼栋号|false|-
└─roomNo|string|房间号|false|-
└─extQmType|string|微信签名类型|false|-
└─extQmTypePhoto|string|微信签名类型图片|false|-
└─extPosName|string|微信岗位|false|-
└─extOrganName|string|微信单位|false|-
└─priority|int32|排序|false|-
└─priorityInOrgan|int32|机构内排序|false|-
└─priorityInDomain|int32|应用域内排序|false|-
└─updaterId|string|修改人|false|-
└─updateTime|string|修改时间|false|-
└─delFlag|int32|删除标志0正常1已删除2应用内受限3回收站|false|-
└─description|string|描述，岗位职责|false|-
└─remark|string|备注|false|-
└─parentName|string|父岗位名称|false|-
└─roletypeName|string|角色分类名称|false|-
└─postypeName|string|角色分类名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:01",
    "lastTime": "2025-10-20 18:26:01",
    "id": "172",
    "parentId": "172",
    "postypeId": "172",
    "roletypeId": "172",
    "userId": "172",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "code": "81486",
    "oname": "merle.larkin",
    "posFunction": "7zb4sb",
    "posRank": 556,
    "posType": "5oaeau",
    "editorType": "g7g9sr",
    "isEditorCreate": true,
    "status": 702,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "172",
    "manageDeptids": "v7te1f",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "1-203-302-2484",
    "officePhone": "1-203-302-2484",
    "buildingId": "172",
    "roomNo": "ps413i",
    "extQmType": "vou411",
    "extQmTypePhoto": "o76k4i",
    "extPosName": "merle.larkin",
    "extOrganName": "merle.larkin",
    "priority": 12,
    "priorityInOrgan": 799,
    "priorityInDomain": 737,
    "updaterId": "172",
    "updateTime": "2025-10-20 18:26:01",
    "delFlag": 5,
    "description": "f6gf5c",
    "remark": "6y1xcc",
    "parentName": "merle.larkin",
    "roletypeName": "merle.larkin",
    "postypeName": "merle.larkin"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "79z2at",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除岗位
**URL:** https://linlan.net/eframe_backend/api/admin/position/{positionIds}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除岗位

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
positionIds|array| 岗位Ids,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "vu571a",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 绑定角色
**URL:** https://linlan.net/eframe_backend/api/admin/position/bind/{positionId}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 绑定角色

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─postId|string|岗位序号|false|-
└─postCode|string|岗位编码|false|-
└─postName|string|岗位名称|false|-
└─postSort|int32|岗位排序|false|-
└─status|int32|状态（0未生效1正常2受限3锁定4删除）|false|-
└─creatorId|string|创建者|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|更新时间|false|-
└─delFlag|int32|删除标记（0正常 1删除）|false|-
└─remark|string|备注|false|-
└─ids|array|角色id集合|false|-
└─positionId|string|岗位ID|false|-
└─flag|boolean|用户是否存在此岗位标识 默认不存在|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/bind/{positionId}.do --data '{
  "data": {
    "postId": "172",
    "postCode": "81486",
    "postName": "merle.larkin",
    "postSort": 100,
    "status": 443,
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:01",
    "lastTime": "2025-10-20 18:26:01",
    "delFlag": 5,
    "remark": "698iua",
    "ids": [
      "786068"
    ],
    "positionId": "172",
    "flag": true
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "w6dz4g",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 解绑角色
**URL:** https://linlan.net/eframe_backend/api/admin/position/unbind/{positionId}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 解绑角色

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─id|int64|用户角色ID|false|-
└─roleId|int64|角色ID|false|-
└─positionId|string|岗位ID|false|-
└─status|int32|审核状态0未审核1审核通过2冻结3例外|false|-
└─beginTime|string|开始时间|false|-
└─endTime|string|结束时间|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/unbind/{positionId}.do --data '{
  "data": {
    "id": 985,
    "roleId": 732,
    "positionId": "172",
    "status": 201,
    "beginTime": "2025-10-20",
    "endTime": "2025-10-20"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "wwy24p",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取岗位选择框列表
**URL:** https://linlan.net/eframe_backend/api/admin/position/option/select.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取岗位选择框列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/option/select.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─postId|string|岗位序号|-
└─postCode|string|岗位编码|-
└─postName|string|岗位名称|-
└─postSort|int32|岗位排序|-
└─status|int32|状态（0未生效1正常2受限3锁定4删除）|-
└─creatorId|string|创建者|-
└─createTime|string|创建时间|-
└─lastTime|string|更新时间|-
└─delFlag|int32|删除标记（0正常 1删除）|-
└─remark|string|备注|-
└─ids|array|角色id集合|-
└─positionId|string|岗位ID|-
└─flag|boolean|用户是否存在此岗位标识 默认不存在|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "postId": "172",
      "postCode": "81486",
      "postName": "merle.larkin",
      "postSort": 528,
      "status": 568,
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:01",
      "lastTime": "2025-10-20 18:26:01",
      "delFlag": 5,
      "remark": "ukcsmj",
      "ids": [
        "x9rcgr"
      ],
      "positionId": "172",
      "flag": true
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 系统操作日志记录
### 查看全部日志列表
**URL:** https://linlan.net/eframe_backend/api/monitor/commlog/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查看全部日志列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
appId|string|应用ID|false|-
userId|string|系统管理用户ID|false|-
username|string|用户名|false|-
category|int32|日志类型|false|-
operation|string|操作|false|-
method|string|方法|false|-
srcCode|int32|当前登录来源|false|-
createTime|string|创建时间|false|-
ip|string|来访IP地址|false|-
time|int64|执行时长|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/list.do?time=1760955652792&startTime=2025-10-20 18:20:52&category=859&createTime=2025-10-20 18:26:01&orderBy=837&q=tslazr&appId=172&operation=ciunt0&ip=137.119.212.174&endTime=2025-10-20 18:20:52&page=1&method=4ge9f7&srcCode=196&username=merle.larkin&limit=10&userId=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─operId|int64|日志主键|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─title|string|操作模块|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─businessType|int32|业务类型（0其它 1新增 2修改 3删除）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─businessTypeName|string|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─businessTypes|array|业务类型数组|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─method|string|请求方法|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestMethod|string|请求方式|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─operatorType|int32|操作类别（0其它 1后台用户 2手机端用户）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─operName|string|操作人员|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─operUrl|string|请求url|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─operIp|string|操作地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─operLocation|string|操作地点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─operParam|string|请求参数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jsonResult|string|返回参数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|操作状态（0正常 1异常）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─errorMsg|string|错误消息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─operTime|string|操作时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─costTime|int64|消耗时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 27,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "operId": 936,
        "title": "ty0z2y",
        "businessType": 268,
        "businessTypeName": "merle.larkin",
        "businessTypes": [
          265
        ],
        "method": "9d6yus",
        "requestMethod": "d8g7mv",
        "operatorType": 652,
        "operName": "merle.larkin",
        "deptName": "merle.larkin",
        "operUrl": "www.ben-grant.info",
        "operIp": "137.119.212.174",
        "operLocation": "z6rya1",
        "operParam": "yktild",
        "jsonResult": "1guot9",
        "status": 212,
        "errorMsg": "ocrfgo",
        "operTime": "2025-10-20 18:26:01",
        "costTime": 1760955652792,
        "remark": "r3dv99"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 操作日志导出
**URL:** https://linlan.net/eframe_backend/api/monitor/commlog/export.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 操作日志导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
operId|int64|日志主键|false|-
title|string|操作模块|false|-
businessType|int32|业务类型（0其它 1新增 2修改 3删除）|false|-
operatorType|int32|操作类别（0其它 1后台用户 2手机端用户）|false|-
operName|string|操作人员|false|-
deptName|string|部门名称|false|-
operIp|string|操作地址|false|-
status|int32|操作状态（0正常 1异常）|false|-
operTime|string|操作时间|false|-
remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/export.do --data 'operTime=2025-10-20 18:26:01&operatorType=390&operName=merle.larkin&deptName=merle.larkin&q=rh4465&endTime=2025-10-20 18:20:52&status=836&startTime=2025-10-20 18:20:52&operId=946&limit=10&businessType=75&remark=3k3dg7&orderBy=531&title=dgmn6d&page=1&operIp=137.119.212.174'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "uhjgfc",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 操作日志清理
**URL:** https://linlan.net/eframe_backend/api/monitor/commlog/{ids}.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 操作日志清理

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array| 主键Ids,[array of int64]|true|

**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "6nbhbe",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 系统机构表读写控制类
### Get CoreOrgan list. 获取系统机构表列表或分页, 返回CoreOrgan对象.
**URL:** https://linlan.net/eframe_backend/api/system/organ/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-21 15:35:19

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get CoreOrgan list. 获取系统机构表列表或分页, 返回CoreOrgan对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
organName|string|机构名称|false|-
delFlag|int32|状态|false|-
organId|string|机构id|false|-
wlType|string|机构类型|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/list.do?orderBy=644&q=ht7txn&endTime=2025-10-20 18:20:52&limit=10&startTime=2025-10-20 18:20:52&page=1&organName=merle.larkin&wlType=twgtvs&delFlag=5&organId=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─ids|array|机构ids|-
└─organId|string|机构id|-
└─organName|string|机构名称|-
└─organSName|string|简称|-
└─organCode|string|地域id|-
└─address|string|父类Id|-
└─wlType|string|类型|-
└─wlTypeName|string|类型中文|-
└─priority|int32|排序|-
└─delFlag|int32|状态: 1 删除，0有效|-
└─createTime|string|创建时间|-
└─lastTime|string|最近修改时间|-
└─contactName|string|联系人名称|-
└─contactEmail|string|联系人电子邮箱|-
└─contactMobile|string|联系人手机|-
└─description|string|公司简介|-
└─tel|string|单位电话|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "ids": [
        "1l1ysh"
      ],
      "organId": "172",
      "organName": "merle.larkin",
      "organSName": "merle.larkin",
      "organCode": "81486",
      "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
      "wlType": "onnegi",
      "wlTypeName": "merle.larkin",
      "priority": 821,
      "delFlag": 5,
      "createTime": "2025-10-20 18:26:04",
      "lastTime": "2025-10-20 18:26:04",
      "contactName": "merle.larkin",
      "contactEmail": "vivian.streich@hotmail.com",
      "contactMobile": "(415) 540-6962",
      "description": "tjnwmc",
      "tel": "pi96ns"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get CoreOrgan by id. 主键获取系统机构表详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/organ/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-21 15:35:19

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get CoreOrgan by id. 主键获取系统机构表详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|机构ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─ids|array|机构ids|-
└─organId|string|机构id|-
└─organName|string|机构名称|-
└─organSName|string|简称|-
└─organCode|string|地域id|-
└─address|string|父类Id|-
└─wlType|string|类型|-
└─wlTypeName|string|类型中文|-
└─priority|int32|排序|-
└─delFlag|int32|状态: 1 删除，0有效|-
└─createTime|string|创建时间|-
└─lastTime|string|最近修改时间|-
└─contactName|string|联系人名称|-
└─contactEmail|string|联系人电子邮箱|-
└─contactMobile|string|联系人手机|-
└─description|string|公司简介|-
└─tel|string|单位电话|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "ids": [
      "mqlazd"
    ],
    "organId": "172",
    "organName": "merle.larkin",
    "organSName": "merle.larkin",
    "organCode": "81486",
    "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "wlType": "js11pi",
    "wlTypeName": "merle.larkin",
    "priority": 452,
    "delFlag": 5,
    "createTime": "2025-10-20 18:26:04",
    "lastTime": "2025-10-20 18:26:04",
    "contactName": "merle.larkin",
    "contactEmail": "vivian.streich@hotmail.com",
    "contactMobile": "(415) 540-6962",
    "description": "cgyaei",
    "tel": "iz8rxs"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreOrgan Operation. 新增系统机构表数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/organ/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-21 15:35:19

**Content-Type:** application/json; charset=utf-8

**Description:** CoreOrgan Operation. 新增系统机构表数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─ids|array|机构ids|false|-
└─organId|string|机构id|false|-
└─organName|string|机构名称|false|-
└─organSName|string|简称|false|-
└─organCode|string|地域id|false|-
└─address|string|父类Id|false|-
└─wlType|string|类型|false|-
└─wlTypeName|string|类型中文|false|-
└─priority|int32|排序|false|-
└─delFlag|int32|状态: 1 删除，0有效|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最近修改时间|false|-
└─contactName|string|联系人名称|false|-
└─contactEmail|string|联系人电子邮箱|false|-
└─contactMobile|string|联系人手机|false|-
└─description|string|公司简介|false|-
└─tel|string|单位电话|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/save.do --data '{
  "data": {
    "ids": [
      "skhohc"
    ],
    "organId": "172",
    "organName": "merle.larkin",
    "organSName": "merle.larkin",
    "organCode": "81486",
    "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "wlType": "qg79q7",
    "wlTypeName": "merle.larkin",
    "priority": 719,
    "delFlag": 5,
    "createTime": "2025-10-20 18:26:04",
    "lastTime": "2025-10-20 18:26:04",
    "contactName": "merle.larkin",
    "contactEmail": "vivian.streich@hotmail.com",
    "contactMobile": "(415) 540-6962",
    "description": "yvu8jp",
    "tel": "lfra0c"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "9gtbrc",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreOrgan Operation. 修改系统机构表数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/organ/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-21 15:35:19

**Content-Type:** application/json; charset=utf-8

**Description:** CoreOrgan Operation. 修改系统机构表数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─ids|array|机构ids|false|-
└─organId|string|机构id|false|-
└─organName|string|机构名称|false|-
└─organSName|string|简称|false|-
└─organCode|string|地域id|false|-
└─address|string|父类Id|false|-
└─wlType|string|类型|false|-
└─wlTypeName|string|类型中文|false|-
└─priority|int32|排序|false|-
└─delFlag|int32|状态: 1 删除，0有效|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最近修改时间|false|-
└─contactName|string|联系人名称|false|-
└─contactEmail|string|联系人电子邮箱|false|-
└─contactMobile|string|联系人手机|false|-
└─description|string|公司简介|false|-
└─tel|string|单位电话|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/update.do --data '{
  "data": {
    "ids": [
      "w7rklt"
    ],
    "organId": "172",
    "organName": "merle.larkin",
    "organSName": "merle.larkin",
    "organCode": "81486",
    "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "wlType": "v192rj",
    "wlTypeName": "merle.larkin",
    "priority": 361,
    "delFlag": 5,
    "createTime": "2025-10-20 18:26:04",
    "lastTime": "2025-10-20 18:26:04",
    "contactName": "merle.larkin",
    "contactEmail": "vivian.streich@hotmail.com",
    "contactMobile": "(415) 540-6962",
    "description": "j2awln",
    "tel": "p3vhwh"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "s1o47s",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreOrgan Operation. 删除系统机构表数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/organ/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-21 15:35:19

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** CoreOrgan Operation. 删除系统机构表数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|机构ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "rd92zu",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreOrgan Operation. 系统机构表数据操作逻辑，根据操作类型，执行停用启用操作.
**URL:** https://linlan.net/eframe_backend/api/system/organ/disable/{id}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-21 15:35:19

**Content-Type:** application/json; charset=utf-8

**Description:** CoreOrgan Operation. 系统机构表数据操作逻辑，根据操作类型，执行停用启用操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─ids|array|机构ids|false|-
└─organId|string|机构id|false|-
└─organName|string|机构名称|false|-
└─organSName|string|简称|false|-
└─organCode|string|地域id|false|-
└─address|string|父类Id|false|-
└─wlType|string|类型|false|-
└─wlTypeName|string|类型中文|false|-
└─priority|int32|排序|false|-
└─delFlag|int32|状态: 1 删除，0有效|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最近修改时间|false|-
└─contactName|string|联系人名称|false|-
└─contactEmail|string|联系人电子邮箱|false|-
└─contactMobile|string|联系人手机|false|-
└─description|string|公司简介|false|-
└─tel|string|单位电话|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/disable/{id}.do --data '{
  "data": {
    "ids": [
      "b11v9z"
    ],
    "organId": "172",
    "organName": "merle.larkin",
    "organSName": "merle.larkin",
    "organCode": "81486",
    "address": "Apt. 410 14910 Erdman Heights， West Caroll， WI 86927",
    "wlType": "s0iydj",
    "wlTypeName": "merle.larkin",
    "priority": 686,
    "delFlag": 5,
    "createTime": "2025-10-20 18:26:04",
    "lastTime": "2025-10-20 18:26:04",
    "contactName": "merle.larkin",
    "contactEmail": "vivian.streich@hotmail.com",
    "contactMobile": "(415) 540-6962",
    "description": "8ymlys",
    "tel": "qd72d9"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "rj14dl",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 系统机构部门增删改操作控制类
### 新增部门
**URL:** https://linlan.net/eframe_backend/api/admin/dept/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 新增部门

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|单位ID|false|-
└─organId|string|系统机构ID|false|-
└─parentId|int64|父节点|false|-
└─appId|string|应用ID|false|-
└─depttypeId|int64|部门分类ID|false|-
└─foreignId|string|外部业务ID|false|-
└─createType|int32|创建方式0导入1录入2授权|false|-
└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
└─name|string|名称，多级累加名称|false|-
└─sname|string|名称简称，本单位显示名称|false|-
└─areaCode|string|地域编码，所在城市|false|-
└─organLeader|string|领导名称|false|-
└─leaderId|string|负责人ID，用户接收相关信息|false|-
└─leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
└─isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
└─isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
└─isLeaf|boolean|是否叶子节点|false|-
└─isDisabled|boolean|是否禁用0否1是|false|-
└─searchCode|string|多级累加路径|false|-
└─imagePath|string|图片路径|false|-
└─priority|int32|排序|false|-
└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
└─delFlag|int32|是否删除1已删除0正常|false|-
└─description|string|描述|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─children|array|子部门|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:55",
    "lastTime": "2025-10-20 18:25:55",
    "id": 75,
    "organId": "172",
    "parentId": 808,
    "appId": "172",
    "depttypeId": 28,
    "foreignId": "172",
    "createType": 380,
    "type": "1su5hv",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "areaCode": "81486",
    "organLeader": "9rrli1",
    "leaderId": "172",
    "leaderMobile": "(415) 540-6962",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "81486",
    "imagePath": "5xkxrm",
    "priority": 366,
    "status": 620,
    "delFlag": 5,
    "description": "3xhxdh",
    "spare1": "rhh9ec",
    "spare2": "3laotv",
    "children": [
      {
        "$ref": ".."
      }
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "8jlre2",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改部门
**URL:** https://linlan.net/eframe_backend/api/admin/dept/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 修改部门

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|单位ID|false|-
└─organId|string|系统机构ID|false|-
└─parentId|int64|父节点|false|-
└─appId|string|应用ID|false|-
└─depttypeId|int64|部门分类ID|false|-
└─foreignId|string|外部业务ID|false|-
└─createType|int32|创建方式0导入1录入2授权|false|-
└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
└─name|string|名称，多级累加名称|false|-
└─sname|string|名称简称，本单位显示名称|false|-
└─areaCode|string|地域编码，所在城市|false|-
└─organLeader|string|领导名称|false|-
└─leaderId|string|负责人ID，用户接收相关信息|false|-
└─leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
└─isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
└─isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
└─isLeaf|boolean|是否叶子节点|false|-
└─isDisabled|boolean|是否禁用0否1是|false|-
└─searchCode|string|多级累加路径|false|-
└─imagePath|string|图片路径|false|-
└─priority|int32|排序|false|-
└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
└─delFlag|int32|是否删除1已删除0正常|false|-
└─description|string|描述|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─children|array|子部门|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:55",
    "lastTime": "2025-10-20 18:25:55",
    "id": 174,
    "organId": "172",
    "parentId": 297,
    "appId": "172",
    "depttypeId": 351,
    "foreignId": "172",
    "createType": 5,
    "type": "l14k0d",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "areaCode": "81486",
    "organLeader": "gpmg6d",
    "leaderId": "172",
    "leaderMobile": "(415) 540-6962",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "81486",
    "imagePath": "cp6ov2",
    "priority": 395,
    "status": 651,
    "delFlag": 5,
    "description": "hfuljl",
    "spare1": "2ro69f",
    "spare2": "lfji67",
    "children": [
      {
        "$ref": ".."
      }
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "hp942h",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除部门
**URL:** https://linlan.net/eframe_backend/api/admin/dept/delete/{deptIds}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除部门

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
deptIds|array| 部门Ids,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "q5hyot",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 停用启用部门
**URL:** https://linlan.net/eframe_backend/api/admin/dept/disable/{id}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 停用启用部门

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|单位ID|false|-
└─organId|string|系统机构ID|false|-
└─parentId|int64|父节点|false|-
└─appId|string|应用ID|false|-
└─depttypeId|int64|部门分类ID|false|-
└─foreignId|string|外部业务ID|false|-
└─createType|int32|创建方式0导入1录入2授权|false|-
└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
└─name|string|名称，多级累加名称|false|-
└─sname|string|名称简称，本单位显示名称|false|-
└─areaCode|string|地域编码，所在城市|false|-
└─organLeader|string|领导名称|false|-
└─leaderId|string|负责人ID，用户接收相关信息|false|-
└─leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
└─isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
└─isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
└─isLeaf|boolean|是否叶子节点|false|-
└─isDisabled|boolean|是否禁用0否1是|false|-
└─searchCode|string|多级累加路径|false|-
└─imagePath|string|图片路径|false|-
└─priority|int32|排序|false|-
└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
└─delFlag|int32|是否删除1已删除0正常|false|-
└─description|string|描述|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─children|array|子部门|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/disable/{id}.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:55",
    "lastTime": "2025-10-20 18:25:55",
    "id": 814,
    "organId": "172",
    "parentId": 734,
    "appId": "172",
    "depttypeId": 257,
    "foreignId": "172",
    "createType": 249,
    "type": "mx5wjb",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "areaCode": "81486",
    "organLeader": "n3mt8j",
    "leaderId": "172",
    "leaderMobile": "(415) 540-6962",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "81486",
    "imagePath": "zqsbrg",
    "priority": 880,
    "status": 196,
    "delFlag": 5,
    "description": "4lkcfh",
    "spare1": "2gnc4k",
    "spare2": "j6ov1l",
    "children": [
      {
        "$ref": ".."
      }
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "yxux0z",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 系统机构部门查询读取控制类
### 获取部门列表
**URL:** https://linlan.net/eframe_backend/api/admin/dept/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取部门列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
deptId|int64|单位ID|false|-
organId|string|系统机构ID|false|-
parentId|int64|父节点|false|-
appId|string|应用ID|false|-
depttypeId|int64|部门分类ID|false|-
foreignId|string|外部业务ID|false|-
createType|int32|创建方式0导入1录入2授权|false|-
type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
name|string|名称，多级累加名称|false|-
sname|string|名称简称，本单位显示名称|false|-
areaCode|string|地域编码，所在城市|false|-
organLeader|string|领导名称|false|-
leaderId|string|负责人ID，用户接收相关信息|false|-
leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
isLeaf|boolean|是否叶子节点|false|-
isDisabled|boolean|是否禁用0否1是|false|-
searchCode|string|多级累加路径|false|-
imagePath|string|图片路径|false|-
status|int32|状态0未生效1正常2受限3锁定4删除|false|-
creatorId|string|创建用户ID|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list.do?delFlag=5&creatorId=172&createType=823&appId=172&description=ujdkpg&q=z2ezv1&orderBy=936&leaderId=172&status=279&depttypeId=455&isDisabled=true&areaCode=81486&parentId=40&page=1&organId=172&sname=merle.larkin&imagePath=gzpyul&leaderMobile=(415) 540-6962&organLeader=olgt3i&isVirtual=true&limit=10&spare2=jlhgq7&name=merle.larkin&type=2mkjav&isLeaf=true&searchCode=81486&deptId=648&startTime=2025-10-20 18:20:52&foreignId=172&spare1=ypjx9y&isOrganLevel=true&endTime=2025-10-20 18:20:52
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─size|int32|No comments found.|-
└─stackTrace|string|No comments found.|-
└─pageNum|int32|No comments found.|-
└─pageSize|int32|No comments found.|-
└─startRow|int64|No comments found.|-
└─endRow|int64|No comments found.|-
└─total|int64|No comments found.|-
└─pages|int32|No comments found.|-
└─count|boolean|No comments found.|-
└─reasonable|boolean|No comments found.|-
└─pageSizeZero|boolean|No comments found.|-
└─countColumn|string|No comments found.|-
└─orderBy|string|No comments found.|-
└─orderByOnly|boolean|No comments found.|-
└─boundSqlInterceptor|object|No comments found.|-
└─dialectClass|string|No comments found.|-
└─keepOrderBy|boolean|No comments found.|-
└─keepSubSelectOrderBy|boolean|No comments found.|-
└─asyncCount|boolean|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "size": 10,
    "stackTrace": "5f9deb",
    "pageNum": 766,
    "pageSize": 10,
    "startRow": 675,
    "endRow": 712,
    "total": 206,
    "pages": 480,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "hrpiwx",
    "orderBy": "ybphym",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "kgny1m",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取部门分页
**URL:** https://linlan.net/eframe_backend/api/admin/dept/page.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取部门分页

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
deptId|int64|单位ID|false|-
organId|string|系统机构ID|false|-
parentId|int64|父节点|false|-
appId|string|应用ID|false|-
depttypeId|int64|部门分类ID|false|-
foreignId|string|外部业务ID|false|-
createType|int32|创建方式0导入1录入2授权|false|-
type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
name|string|名称，多级累加名称|false|-
sname|string|名称简称，本单位显示名称|false|-
areaCode|string|地域编码，所在城市|false|-
organLeader|string|领导名称|false|-
leaderId|string|负责人ID，用户接收相关信息|false|-
leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
isLeaf|boolean|是否叶子节点|false|-
isDisabled|boolean|是否禁用0否1是|false|-
searchCode|string|多级累加路径|false|-
imagePath|string|图片路径|false|-
status|int32|状态0未生效1正常2受限3锁定4删除|false|-
creatorId|string|创建用户ID|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/page.do?parentId=611&leaderId=172&page=1&appId=172&name=merle.larkin&foreignId=172&delFlag=5&type=bht8e5&organId=172&deptId=949&areaCode=81486&sname=merle.larkin&searchCode=81486&q=83rlqn&depttypeId=436&isOrganLevel=true&leaderMobile=(415) 540-6962&isVirtual=true&imagePath=1n4q7j&createType=600&organLeader=ksrvrw&isLeaf=true&isDisabled=true&orderBy=774&status=532&spare2=rr3xbf&spare1=zqg0jw&limit=10&creatorId=172&description=iuwpst&startTime=2025-10-20 18:20:52&endTime=2025-10-20 18:20:52
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─size|int32|No comments found.|-
└─stackTrace|string|No comments found.|-
└─pageNum|int32|No comments found.|-
└─pageSize|int32|No comments found.|-
└─startRow|int64|No comments found.|-
└─endRow|int64|No comments found.|-
└─total|int64|No comments found.|-
└─pages|int32|No comments found.|-
└─count|boolean|No comments found.|-
└─reasonable|boolean|No comments found.|-
└─pageSizeZero|boolean|No comments found.|-
└─countColumn|string|No comments found.|-
└─orderBy|string|No comments found.|-
└─orderByOnly|boolean|No comments found.|-
└─boundSqlInterceptor|object|No comments found.|-
└─dialectClass|string|No comments found.|-
└─keepOrderBy|boolean|No comments found.|-
└─keepSubSelectOrderBy|boolean|No comments found.|-
└─asyncCount|boolean|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "size": 10,
    "stackTrace": "gpaa7z",
    "pageNum": 793,
    "pageSize": 10,
    "startRow": 621,
    "endRow": 734,
    "total": 583,
    "pages": 240,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "1hatnt",
    "orderBy": "vk40h2",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "c1eu1y",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 查询部门列表（排除节点）
**URL:** https://linlan.net/eframe_backend/api/admin/dept/list/exclude/{deptId}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询部门列表（排除节点）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
deptId|int64| 部门ID|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list/exclude/301.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─id|int64|单位ID|-
└─organId|string|系统机构ID|-
└─organName|string|系统机构名称|-
└─parentId|int64|父节点|-
└─appId|string|应用ID|-
└─depttypeId|int64|部门分类ID|-
└─foreignId|string|外部业务ID|-
└─createType|int32|创建方式0导入1录入2授权|-
└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|-
└─name|string|名称|-
└─sname|string|名称简称，本单位显示名称|-
└─areaCode|string|地域编码，所在城市|-
└─organLeader|string|领导名称|-
└─leaderId|string|负责人ID，用户接收相关信息|-
└─leaderMobile|string|负责人手机号码，用户接收相关信息|-
└─isOrganLevel|boolean|是否机构本级1是0否默认1|-
└─isVirtual|boolean|是否虚拟节点1是0不是默认0|-
└─isLeaf|boolean|是否叶子节点|-
└─isDisabled|boolean|是否禁用0否1是|-
└─searchCode|string|多级累加路径|-
└─imagePath|string|图片路径|-
└─priority|int32|排序|-
└─status|int32|状态0未生效1正常2受限3锁定4删除|-
└─creatorId|string|创建用户ID|-
└─createTime|string|创建时间|-
└─lastTime|string|修改时间|-
└─delFlag|int32|是否删除1已删除0正常|-
└─description|string|描述|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
└─parentName|string|父节点名称|-
└─childNum|string|字节点数量|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "id": 382,
      "organId": "172",
      "organName": "merle.larkin",
      "parentId": 982,
      "appId": "172",
      "depttypeId": 837,
      "foreignId": "172",
      "createType": 481,
      "type": "7fucmi",
      "name": "merle.larkin",
      "sname": "merle.larkin",
      "areaCode": "81486",
      "organLeader": "6mp6go",
      "leaderId": "172",
      "leaderMobile": "(415) 540-6962",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "81486",
      "imagePath": "5vz2we",
      "priority": 589,
      "status": 652,
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:55",
      "lastTime": "2025-10-20 18:25:55",
      "delFlag": 5,
      "description": "qorwfr",
      "spare1": "0bcotz",
      "spare2": "47t4oy",
      "parentName": "merle.larkin",
      "childNum": "gpr9pv"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据部门编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/admin/dept/{deptId}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据部门编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
deptId|int64| 部门ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/503.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─id|int64|单位ID|-
└─organId|string|系统机构ID|-
└─organName|string|系统机构名称|-
└─parentId|int64|父节点|-
└─appId|string|应用ID|-
└─depttypeId|int64|部门分类ID|-
└─foreignId|string|外部业务ID|-
└─createType|int32|创建方式0导入1录入2授权|-
└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|-
└─name|string|名称|-
└─sname|string|名称简称，本单位显示名称|-
└─areaCode|string|地域编码，所在城市|-
└─organLeader|string|领导名称|-
└─leaderId|string|负责人ID，用户接收相关信息|-
└─leaderMobile|string|负责人手机号码，用户接收相关信息|-
└─isOrganLevel|boolean|是否机构本级1是0否默认1|-
└─isVirtual|boolean|是否虚拟节点1是0不是默认0|-
└─isLeaf|boolean|是否叶子节点|-
└─isDisabled|boolean|是否禁用0否1是|-
└─searchCode|string|多级累加路径|-
└─imagePath|string|图片路径|-
└─priority|int32|排序|-
└─status|int32|状态0未生效1正常2受限3锁定4删除|-
└─creatorId|string|创建用户ID|-
└─createTime|string|创建时间|-
└─lastTime|string|修改时间|-
└─delFlag|int32|是否删除1已删除0正常|-
└─description|string|描述|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
└─parentName|string|父节点名称|-
└─childNum|string|字节点数量|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "id": 463,
    "organId": "172",
    "organName": "merle.larkin",
    "parentId": 278,
    "appId": "172",
    "depttypeId": 273,
    "foreignId": "172",
    "createType": 724,
    "type": "ukl0nm",
    "name": "merle.larkin",
    "sname": "merle.larkin",
    "areaCode": "81486",
    "organLeader": "6gg32i",
    "leaderId": "172",
    "leaderMobile": "(415) 540-6962",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "81486",
    "imagePath": "3t9t9h",
    "priority": 130,
    "status": 210,
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:55",
    "lastTime": "2025-10-20 18:25:55",
    "delFlag": 5,
    "description": "dfxdq9",
    "spare1": "lej5ps",
    "spare2": "zlqzuh",
    "parentName": "merle.larkin",
    "childNum": "z1xce2"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取部门树
**URL:** https://linlan.net/eframe_backend/api/admin/dept/tree.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取部门树

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
deptId|int64|单位ID|false|-
organId|string|系统机构ID|false|-
parentId|int64|父节点|false|-
appId|string|应用ID|false|-
depttypeId|int64|部门分类ID|false|-
foreignId|string|外部业务ID|false|-
createType|int32|创建方式0导入1录入2授权|false|-
type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|false|-
name|string|名称，多级累加名称|false|-
sname|string|名称简称，本单位显示名称|false|-
areaCode|string|地域编码，所在城市|false|-
organLeader|string|领导名称|false|-
leaderId|string|负责人ID，用户接收相关信息|false|-
leaderMobile|string|负责人手机号码，用户接收相关信息|false|-
isOrganLevel|boolean|是否机构本级1是0否默认1|false|-
isVirtual|boolean|是否虚拟节点1是0不是默认0|false|-
isLeaf|boolean|是否叶子节点|false|-
isDisabled|boolean|是否禁用0否1是|false|-
searchCode|string|多级累加路径|false|-
imagePath|string|图片路径|false|-
status|int32|状态0未生效1正常2受限3锁定4删除|false|-
creatorId|string|创建用户ID|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/tree.do?startTime=2025-10-20 18:20:52&spare2=75lzm6&page=1&parentId=162&isVirtual=true&name=merle.larkin&orderBy=822&leaderMobile=(415) 540-6962&limit=10&isLeaf=true&description=zbwtuz&foreignId=172&isDisabled=true&q=34y81v&createType=967&leaderId=172&isOrganLevel=true&spare1=tvxas9&searchCode=81486&sname=merle.larkin&type=33fjki&depttypeId=963&endTime=2025-10-20 18:20:52&organId=172&areaCode=81486&status=408&deptId=32&appId=172&delFlag=5&creatorId=172&imagePath=e679kw&organLeader=leiv1r
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─title|string|节点标题|-
└─id|string|节点唯一索引，用于对指定节点进行各类操作|-
└─parentId|string|父节点ID|-
└─extId|string|拓展id|-
└─href|string|点击节点弹出新窗口对应的 url。需开启 isJump 参数|-
└─spread|boolean|节点是否初始展开，默认 false|-
└─checked|boolean|节点是否初始为选中状态（如果开启复选框的话），默认 false|-
└─disabled|boolean|节点是否为禁用状态。默认 false|-
└─children|array|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "title": "smc21u",
      "id": "172",
      "parentId": "172",
      "extId": "172",
      "href": "4nbbzm",
      "spread": true,
      "checked": true,
      "disabled": true,
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 系统登录验证
### 登录方法
**URL:** https://linlan.net/eframe_backend/login.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 登录方法

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─username|string|用户名|false|-
└─password|string|用户密码|false|-
└─code|string|验证码|false|-
└─uuid|string|唯一标识|false|-
└─appId|string|所在应用ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login.do --data '{
  "data": {
    "username": "merle.larkin",
    "password": "7u4tak",
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad",
    "appId": "172"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─userId|string|用户ID|-
└─token|string|令牌TOKEN|-
└─updateTime|string|更新时间|-
└─expireTime|string|过期时间|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "userId": "172",
    "token": "bfja9g",
    "updateTime": "2025-10-20 18:25:57",
    "expireTime": "2025-10-20 18:25:57"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取应用用户信息，作用于Work端登录之后进行用户基本信息获取
**URL:** https://linlan.net/eframe_backend/appUserInfo.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取应用用户信息，作用于Work端登录之后进行用户基本信息获取

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/appUserInfo.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─user|object|当前用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户LID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userId|string|用户UUID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|人员姓名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户账号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nickName|string|用户昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─email|string|用户邮箱|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mobile|string|手机号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|用户头像|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─password|string|密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuperAdmin|boolean|是否超级管理员|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isAuditAdmin|boolean|是否审计只读管理员|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSelfAdmin|boolean|是否只管理自己的数据|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|帐号状态（0未生效 1正常）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|删除标志（0代表存在 2代表删除）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastLoginIp|string|最后登录IP|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastLoginTime|string|最后登录时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|备注,办公地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dept|object|部门对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roles|array|角色对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleIds|array|角色组|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─positionIds|array|岗位组|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userRoleList|array|角色集合|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|验证码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─uuid|string|uuid标识|-
└─roles|array|角色集合|-
└─permissions|array|权限集合|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "user": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:57",
      "lastTime": "2025-10-20 18:25:57",
      "id": 461,
      "userId": "172",
      "deptId": 312,
      "deptName": "merle.larkin",
      "organId": "172",
      "organName": "merle.larkin",
      "name": "merle.larkin",
      "username": "merle.larkin",
      "nickName": "renna.dibbert",
      "email": "vivian.streich@hotmail.com",
      "mobile": "(415) 540-6962",
      "imagePath": "gi2spd",
      "password": "1bpzcs",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 602,
      "delFlag": 5,
      "lastLoginIp": "137.119.212.174",
      "lastLoginTime": "2025-10-20 18:25:57",
      "description": "zgerj1",
      "dept": {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:57",
        "lastTime": "2025-10-20 18:25:57",
        "id": 561,
        "organId": "172",
        "parentId": 663,
        "appId": "172",
        "depttypeId": 854,
        "foreignId": "172",
        "createType": 367,
        "type": "cw3quo",
        "name": "merle.larkin",
        "sname": "merle.larkin",
        "areaCode": "81486",
        "organLeader": "tphdle",
        "leaderId": "172",
        "leaderMobile": "(415) 540-6962",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "81486",
        "imagePath": "nuaier",
        "priority": 906,
        "status": 372,
        "delFlag": 5,
        "description": "szwmc7",
        "spare1": "r59ko8",
        "spare2": "v7unqw",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "172",
          "createTime": "2025-10-20 18:25:57",
          "lastTime": "2025-10-20 18:25:57",
          "id": 816,
          "roletypeId": "172",
          "appId": "172",
          "name": "merle.larkin",
          "code": "81486",
          "priority": 653,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 829,
          "description": "xj7rp3",
          "areaType": "6mppc5"
        }
      ],
      "roleIds": [
        399
      ],
      "positionIds": [
        "xtkswx"
      ],
      "roleId": 449,
      "userRoleList": [
        {
          "id": 401,
          "deptId": 881,
          "deptName": "merle.larkin",
          "organId": "172",
          "organName": "merle.larkin",
          "roleId": 270,
          "roleName": "merle.larkin",
          "adminId": 279
        }
      ],
      "code": "81486",
      "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
    },
    "roles": [
      "ln5idl"
    ],
    "permissions": [
      "8i8kff"
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取应用首页信息，包括菜单含路由信息
**URL:** https://linlan.net/eframe_backend/appIndexInfo.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取应用首页信息，包括菜单含路由信息

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/appIndexInfo.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─accountId|string|当前端ID|-
└─areaId|int64|当前地域ID|-
└─groupId|int64|当前角色或分组ID|-
└─positionId|string|当前岗位ID|-
└─tplSolution|string|当前页面模板方案|-
└─menuList|array|用户菜单信息列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|功能菜单ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父功能菜单ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|功能名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─ename|string|功能名称英文|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|功能类型,0CATAGORY目录1MENU菜单2BUTTON按钮|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─perms|string|权限字符串|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─menuLevel|int32|菜单层次|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─urlType|string|调用入口类型    // urlType 为 5时，当前组能看到的栏目ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─url|string|功能地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─menuSeq|string|菜单组件|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─icon|string|菜单图标|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─css|string|菜单样式 目前是判断是否为新菜单，css名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|新增 菜单 描述字段|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─todoTotalApi|string|新增 菜单获取待办数量api配置|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "accountId": "172",
    "areaId": 154,
    "groupId": 449,
    "positionId": "172",
    "tplSolution": "r9r4hp",
    "menuList": [
      {
        "id": 849,
        "parentId": 515,
        "name": "merle.larkin",
        "ename": "merle.larkin",
        "type": "75qzhv",
        "perms": "f24vx1",
        "menuLevel": 337,
        "urlType": "hxif5n",
        "url": "www.ben-grant.info",
        "menuSeq": "w0v7e7",
        "icon": "jdto25",
        "imagePath": "x57bki",
        "css": "0w9p0i",
        "description": "1aehoj",
        "todoTotalApi": "12gpk6"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 内部应用，第三方应用登录方法，返回字段少的平台用户对象
**URL:** https://linlan.net/eframe_backend/platLogin.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 内部应用，第三方应用登录方法，返回字段少的平台用户对象

**Request-example:**
```
curl -X POST -k -i https://linlan.net/eframe_backend/platLogin.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─id|string|平台ACCOUNT_ID|-
└─isAdmin|boolean|是否加解密|-
└─isEncryt|boolean|敏感信息是否加密|-
└─publicKey|string|平台公钥信息|-
└─aesKey|string|平台公钥信息|-
└─clientId|string|平台clientId|-
└─serverUrl|string|平台图片域名前缀|-
└─serverConf1|string|平台回调地址|-
└─appConf|object|平台配置基本对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─siteId|int64|PublicSiteConf.SITE_ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|APPID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─topXzqhId|string|BASE_APP内的XZQH_ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appConfJson|object|PublicSiteConf.CONF_KEY :PublicSiteConf.CONF_VALUE|-
└─isWork|boolean|通过CORE_ACCOUNT内的TYPE为1，则isWork为true，workConfig返回信息|-
└─workConfig|object|workInit，通过请求的url路径，匹配MANAGE_SITE内的PATH，输出site对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─layout|string|默认缺省|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─siteInfo|object|站点基本对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|站点ID，场景ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID，如PA-STAGE|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域代码，如310100|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|站点路径，访问的前台路径，URL地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|站点名称，场景名称，如公众门户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|站点简称，场景简称，如公众门户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─layout|string|站点门户布局|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─logoUrl|string|站点logo图片路径URL|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cdnUrl|string|站点的资源统一cdn路径URL|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "id": "172",
    "isAdmin": true,
    "isEncryt": true,
    "publicKey": "yyg8wy",
    "aesKey": "4ktk65",
    "clientId": "172",
    "serverUrl": "www.ben-grant.info",
    "serverConf1": "9g4oxa",
    "appConf": {
      "siteId": 601,
      "appId": "172",
      "topXzqhId": "172",
      "appConfJson": {
        "mapKey": "5y38qv"
      }
    },
    "isWork": true,
    "workConfig": {
      "layout": "hi0ti0",
      "siteInfo": {
        "id": 858,
        "appId": "172",
        "areaCode": "81486",
        "path": "np57oh",
        "name": "merle.larkin",
        "sname": "merle.larkin",
        "layout": "ys76mf",
        "logoUrl": "www.ben-grant.info",
        "cdnUrl": "www.ben-grant.info"
      }
    }
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 第三方服务商登录方法
**URL:** https://linlan.net/eframe_backend/third/ecorgan/login.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 第三方服务商登录方法

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─username|string|用户名|false|-
└─password|string|用户密码|false|-
└─code|string|验证码|false|-
└─uuid|string|唯一标识|false|-
└─appId|string|所在应用ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/third/ecorgan/login.do --data '{
  "data": {
    "username": "merle.larkin",
    "password": "frvxlj",
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad",
    "appId": "172"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─userId|string|用户ID|-
└─token|string|令牌TOKEN|-
└─updateTime|string|更新时间|-
└─expireTime|string|过期时间|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "userId": "172",
    "token": "zsy0ov",
    "updateTime": "2025-10-20 18:25:58",
    "expireTime": "2025-10-20 18:25:58"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 校验验证码
**URL:** https://linlan.net/eframe_backend/captcha/verify.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 校验验证码

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
code|string|验证码|false|-
uuid|string|登录sessionId|false|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/captcha/verify.do?uuid=9bbea0fa-1409-4914-9b7e-342924ed57ad&code=81486
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "4y5edo",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 系统缓存监控
### 获取缓存信息列表
**URL:** https://linlan.net/eframe_backend/api/monitor/cache.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取缓存信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─any object|object|any object.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "mapKey": {
      "waring": "You may use java.util.Object for Map value; doc-generate can't be handle."
    }
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 通过名称前缀获取缓存信息列表
**URL:** https://linlan.net/eframe_backend/api/monitor/cache/getNames.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 通过名称前缀获取缓存信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getNames.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─cacheName|string|缓存名称|-
└─cacheKey|string|缓存键名|-
└─cacheValue|string|缓存内容|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "cacheName": "merle.larkin",
      "cacheKey": "kxvgxf",
      "cacheValue": "698pi8",
      "remark": "ku5igi"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 通过名称获取缓存信息列表
**URL:** https://linlan.net/eframe_backend/api/monitor/cache/getKeys/{cacheName}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 通过名称获取缓存信息列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
cacheName|string|    缓存名称|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getKeys/merle.larkin.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {}
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 通过名称获取缓存详情
**URL:** https://linlan.net/eframe_backend/api/monitor/cache/getValue/{cacheName}/{cacheKey}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 通过名称获取缓存详情

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
cacheName|string|    缓存名称|true|-
cacheKey|string|    缓存Key名称|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getValue/merle.larkin/erzz2z.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─cacheName|string|缓存名称|-
└─cacheKey|string|缓存键名|-
└─cacheValue|string|缓存内容|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "cacheName": "merle.larkin",
    "cacheKey": "q49y0k",
    "cacheValue": "i41r39",
    "remark": "x79mra"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 通过名称前缀清理缓存
**URL:** https://linlan.net/eframe_backend/api/monitor/cache/clearCacheName/{cacheName}.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 通过名称前缀清理缓存

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
cacheName|string|    缓存名称前缀|true|-

**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheName/merle.larkin.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "vhup1n",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 通过名称清理缓存
**URL:** https://linlan.net/eframe_backend/api/monitor/cache/clearCacheKey/{cacheKey}.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 通过名称清理缓存

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
cacheKey|string|    缓存Key名称|true|-

**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheKey/s7dh7k.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "18vbt3",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 清理全部缓存
**URL:** https://linlan.net/eframe_backend/api/monitor/cache/clearCacheAll.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 清理全部缓存

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheAll.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "x9klo0",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 系统菜单信息读写
### 获取菜单列表
**URL:** https://linlan.net/eframe_backend/api/admin/menu/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取菜单列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
menuId|int64|菜单ID|false|-
menuName|string|菜单名称|false|-
parentId|int64|父菜单ID|false|-
currAppId|string|当前appId|false|-
menuType|string|类型（M目录 C菜单 F按钮）|false|-
visible|string|显示状态（0隐藏 1显示）|false|-
status|string|菜单状态（0未生效 1正常）|false|-
delFlag|string|状态0正常1停用2已删除|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/list.do?visible=ewitfn&startTime=2025-10-20 18:20:52&menuId=388&q=uoh5s5&menuType=zi73rh&endTime=2025-10-20 18:20:52&delFlag=w34i1a&limit=10&parentId=354&orderBy=183&page=1&currAppId=172&status=qzph7x&menuName=merle.larkin
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─menuId|int64|菜单ID|-
└─menuName|string|菜单名称|-
└─type|string|功能类型|-
└─typeName|string|功能类型|-
└─parentName|string|父菜单名称|-
└─parentId|int64|父菜单ID|-
└─priority|int32|显示顺序|-
└─path|string|简短名称ENAME|-
└─component|string|组件路径URL|-
└─query|string|路由参数JS_EVENT|-
└─routeName|string|路由地址|-
└─isFrame|string|是否为外链（0是 1否）|-
└─isCache|string|是否缓存（0缓存 1不缓存）|-
└─menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|-
└─menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|-
└─visible|string|显示状态（0隐藏 1显示）|-
└─status|string|菜单禁用（0正常 1禁用）|-
└─perms|string|权限字符串|-
└─icon|string|菜单图标|-
└─imagePath|string|菜单图片|-
└─creatorId|string|创建者|-
└─createTime|string|创建时间|-
└─lastTime|string|更新时间|-
└─children|array|子菜单|-
└─childNum|int32|子菜单数量|-
└─description|string|备注|-
└─listJson|string|页面列表JSON|-
└─delFlag|int32|状态0正常1停用2已删除|-
└─permsList|array|权限数组|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsName|string|权限名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsStr|string|权限字符串|-
└─buttonMenuList|array|子菜单按钮|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|主键|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|string|父节点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "menuId": 46,
      "menuName": "merle.larkin",
      "type": "i8trsg",
      "typeName": "merle.larkin",
      "parentName": "merle.larkin",
      "parentId": 844,
      "priority": 628,
      "path": "u6gnm3",
      "component": "gcj2l0",
      "query": "5p2dvz",
      "routeName": "merle.larkin",
      "isFrame": "23f8fh",
      "isCache": "6dvwu3",
      "menuType": "90y3hb",
      "menuTypeName": "merle.larkin",
      "visible": "evkb1f",
      "status": "bhomxv",
      "perms": "46kmvz",
      "icon": "1nn0x1",
      "imagePath": "4nqyhb",
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:58",
      "lastTime": "2025-10-20 18:25:58",
      "children": [
        {
          "$ref": ".."
        }
      ],
      "childNum": 200,
      "description": "jjp2my",
      "listJson": "9aelz9",
      "delFlag": 5,
      "permsList": [
        {
          "permsName": "merle.larkin",
          "permsStr": "m1otfp"
        }
      ],
      "buttonMenuList": [
        {
          "id": "172",
          "parentId": "172",
          "code": "81486",
          "name": "merle.larkin"
        }
      ]
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取菜单分页
**URL:** https://linlan.net/eframe_backend/api/admin/menu/page.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取菜单分页

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
menuId|int64|菜单ID|false|-
menuName|string|菜单名称|false|-
parentId|int64|父菜单ID|false|-
currAppId|string|当前appId|false|-
menuType|string|类型（M目录 C菜单 F按钮）|false|-
visible|string|显示状态（0隐藏 1显示）|false|-
status|string|菜单状态（0未生效 1正常）|false|-
delFlag|string|状态0正常1停用2已删除|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/page.do?menuId=735&menuType=ooou1t&status=rf770u&menuName=merle.larkin&visible=m0b0ab&startTime=2025-10-20 18:20:52&q=xzgf1u&endTime=2025-10-20 18:20:52&delFlag=n5l9ey&page=1&parentId=485&currAppId=172&orderBy=164&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─size|int32|No comments found.|-
└─stackTrace|string|No comments found.|-
└─pageNum|int32|No comments found.|-
└─pageSize|int32|No comments found.|-
└─startRow|int64|No comments found.|-
└─endRow|int64|No comments found.|-
└─total|int64|No comments found.|-
└─pages|int32|No comments found.|-
└─count|boolean|No comments found.|-
└─reasonable|boolean|No comments found.|-
└─pageSizeZero|boolean|No comments found.|-
└─countColumn|string|No comments found.|-
└─orderBy|string|No comments found.|-
└─orderByOnly|boolean|No comments found.|-
└─boundSqlInterceptor|object|No comments found.|-
└─dialectClass|string|No comments found.|-
└─keepOrderBy|boolean|No comments found.|-
└─keepSubSelectOrderBy|boolean|No comments found.|-
└─asyncCount|boolean|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "size": 10,
    "stackTrace": "8cbqgv",
    "pageNum": 385,
    "pageSize": 10,
    "startRow": 596,
    "endRow": 481,
    "total": 496,
    "pages": 180,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "pmp4d8",
    "orderBy": "jb6cly",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "a1mrdy",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据菜单编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/admin/menu/{menuId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据菜单编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
menuId|int64| 菜单ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/690.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─menuId|int64|菜单ID|-
└─menuName|string|菜单名称|-
└─type|string|功能类型|-
└─typeName|string|功能类型|-
└─parentName|string|父菜单名称|-
└─parentId|int64|父菜单ID|-
└─priority|int32|显示顺序|-
└─path|string|简短名称ENAME|-
└─component|string|组件路径URL|-
└─query|string|路由参数JS_EVENT|-
└─routeName|string|路由地址|-
└─isFrame|string|是否为外链（0是 1否）|-
└─isCache|string|是否缓存（0缓存 1不缓存）|-
└─menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|-
└─menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|-
└─visible|string|显示状态（0隐藏 1显示）|-
└─status|string|菜单禁用（0正常 1禁用）|-
└─perms|string|权限字符串|-
└─icon|string|菜单图标|-
└─imagePath|string|菜单图片|-
└─creatorId|string|创建者|-
└─createTime|string|创建时间|-
└─lastTime|string|更新时间|-
└─children|array|子菜单|-
└─childNum|int32|子菜单数量|-
└─description|string|备注|-
└─listJson|string|页面列表JSON|-
└─delFlag|int32|状态0正常1停用2已删除|-
└─permsList|array|权限数组|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsName|string|权限名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsStr|string|权限字符串|-
└─buttonMenuList|array|子菜单按钮|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|主键|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|string|父节点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "menuId": 357,
    "menuName": "merle.larkin",
    "type": "kh412f",
    "typeName": "merle.larkin",
    "parentName": "merle.larkin",
    "parentId": 979,
    "priority": 255,
    "path": "yon0sy",
    "component": "2pc1ln",
    "query": "7pnliq",
    "routeName": "merle.larkin",
    "isFrame": "khsu2j",
    "isCache": "tqchcv",
    "menuType": "yhpc3i",
    "menuTypeName": "merle.larkin",
    "visible": "eo4khp",
    "status": "ec4gck",
    "perms": "sl3d6s",
    "icon": "7hfqz4",
    "imagePath": "0akj8z",
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:58",
    "lastTime": "2025-10-20 18:25:58",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 568,
    "description": "82mtne",
    "listJson": "ujdvwo",
    "delFlag": 5,
    "permsList": [
      {
        "permsName": "merle.larkin",
        "permsStr": "7v2ni8"
      }
    ],
    "buttonMenuList": [
      {
        "id": "172",
        "parentId": "172",
        "code": "81486",
        "name": "merle.larkin"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取菜单下拉树列表
**URL:** https://linlan.net/eframe_backend/api/admin/menu/treeselect.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取菜单下拉树列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
menuId|int64|菜单ID|false|-
menuName|string|菜单名称|false|-
parentId|int64|父菜单ID|false|-
currAppId|string|当前appId|false|-
menuType|string|类型（M目录 C菜单 F按钮）|false|-
visible|string|显示状态（0隐藏 1显示）|false|-
status|string|菜单状态（0未生效 1正常）|false|-
delFlag|string|状态0正常1停用2已删除|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeselect.do?status=qwgk06&visible=zaiydf&startTime=2025-10-20 18:20:52&currAppId=172&orderBy=518&page=1&endTime=2025-10-20 18:20:52&q=qylztw&limit=10&menuName=merle.larkin&delFlag=qy9vy6&menuId=378&menuType=5j0fwq&parentId=870
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─checkedKeys|array|选中菜单列表|-
└─menus|array|下拉树结构列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|节点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─label|string|节点名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子节点|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "checkedKeys": [
      646
    ],
    "menus": [
      {
        "id": 641,
        "label": "9azss9",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取菜单下拉初始树列表
**URL:** https://linlan.net/eframe_backend/api/admin/menu/treeInit.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取菜单下拉初始树列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
parentId|int64|父功能菜单ID|false|-
appId|string|应用ID|false|-
name|string|功能名称|false|-
isProtect|boolean|是否系统菜单，0否（会员或前端菜单）1是（系统菜单）|false|-
type|string|功能类型,关联BASE_RIGHTTYPE，ADMIN,WORK,APP,SCREEN,MEMBER,AUDIT|false|-
code|string|功能编号|false|-
menuLevel|int32|菜单层次|false|-
subCount|int32|子节点数|false|-
urlType|string|调用入口类型，如CATAGORY,MENU,BUTTON,OUTLINK,CHANNEL,COMPOS,SCENES,RECOMMEND,FOLLOW|false|-
url|string|功能地址，前台URL路由地址|false|-
icon|string|功能图标，样式序号，图标或按钮路径|false|-
popPosition|int32|弹出位置|false|-
imagePath|string|图片路径|false|-
shortCut|string|快捷键|false|-
isDisplay|boolean|是否显示0否1是|false|-
isDisabled|boolean|是否禁用0否1是|false|-
isCheck|boolean|是否验证权限0为无需验证，1为需要验证|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
createTime|string|创建时间|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
isMenuAll|string|是否全部菜单|false|-
offset|int32|菜单位置|false|-
parentNull|string|父节点为空|false|-
parentRoot|string|根节点|false|-
typeNoButton|string|类型为Button|false|-
appIds|array|应用ID集合|false|-
menuIds|array|菜单ID集合|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeInit.do?parentRoot=edkzcj&appIds=mmob6t&appIds=mmob6t&subCount=22&icon=0kkbh7&parentId=163&startTime=2025-10-20 18:20:52&createTime=2025-10-20 18:20:52&typeNoButton=hzyc03&imagePath=vis2tu&page=1&urlType=14vdz3&description=d3vqeo&menuLevel=791&spare1=z308mr&parentNull=pxxaei&isDisabled=true&isCheck=true&appId=172&limit=10&code=81486&isDisplay=true&shortCut=h7yvcl&isMenuAll=yhdbc3&isProtect=true&delFlag=5&q=r1n6yr&popPosition=187&type=cd255x&url=www.ben-grant.info&orderBy=939&endTime=2025-10-20 18:20:52&menuIds=n563j8&menuIds=n563j8&spare2=jq6kox&offset=1&name=merle.larkin
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─title|string|节点标题|-
└─id|string|节点唯一索引，用于对指定节点进行各类操作|-
└─parentId|string|父节点ID|-
└─extId|string|拓展id|-
└─href|string|点击节点弹出新窗口对应的 url。需开启 isJump 参数|-
└─spread|boolean|节点是否初始展开，默认 false|-
└─checked|boolean|节点是否初始为选中状态（如果开启复选框的话），默认 false|-
└─disabled|boolean|节点是否为禁用状态。默认 false|-
└─children|array|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "title": "ji8o4g",
      "id": "172",
      "parentId": "172",
      "extId": "172",
      "href": "ymvbrp",
      "spread": true,
      "checked": true,
      "disabled": true,
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 加载对应角色菜单列表树
**URL:** https://linlan.net/eframe_backend/api/admin/menu/roleMenuTreeselect/{roleId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 加载对应角色菜单列表树

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
roleId|int64| 角色ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/roleMenuTreeselect/243.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─checkedKeys|array|选中菜单列表|-
└─menus|array|下拉树结构列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|节点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─label|string|节点名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子节点|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "checkedKeys": [
      956
    ],
    "menus": [
      {
        "id": 682,
        "label": "65rsr5",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增单个菜单
**URL:** https://linlan.net/eframe_backend/api/admin/menu/save/single.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增单个菜单

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─menuId|int64|菜单ID|false|-
└─menuName|string|菜单名称|false|-
└─type|string|功能类型|false|-
└─typeName|string|功能类型|false|-
└─parentName|string|父菜单名称|false|-
└─parentId|int64|父菜单ID|false|-
└─priority|int32|显示顺序|false|-
└─path|string|简短名称ENAME|false|-
└─component|string|组件路径URL|false|-
└─query|string|路由参数JS_EVENT|false|-
└─routeName|string|路由地址|false|-
└─isFrame|string|是否为外链（0是 1否）|false|-
└─isCache|string|是否缓存（0缓存 1不缓存）|false|-
└─menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
└─menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
└─visible|string|显示状态（0隐藏 1显示）|false|-
└─status|string|菜单禁用（0正常 1禁用）|false|-
└─perms|string|权限字符串|false|-
└─icon|string|菜单图标|false|-
└─imagePath|string|菜单图片|false|-
└─creatorId|string|创建者|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|更新时间|false|-
└─children|array|子菜单|false|-
└─childNum|int32|子菜单数量|false|-
└─description|string|备注|false|-
└─listJson|string|页面列表JSON|false|-
└─delFlag|int32|状态0正常1停用2已删除|false|-
└─permsList|array|权限数组|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsName|string|权限名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsStr|string|权限字符串|false|-
└─buttonMenuList|array|子菜单按钮|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|主键|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|string|父节点ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/save/single.do --data '{
  "data": {
    "menuId": 776,
    "menuName": "merle.larkin",
    "type": "gbytnq",
    "typeName": "merle.larkin",
    "parentName": "merle.larkin",
    "parentId": 921,
    "priority": 319,
    "path": "0ogao8",
    "component": "mkrcm3",
    "query": "0mkxtb",
    "routeName": "merle.larkin",
    "isFrame": "p6n09e",
    "isCache": "0ovddp",
    "menuType": "w1gejm",
    "menuTypeName": "merle.larkin",
    "visible": "tem6t4",
    "status": "2pjeka",
    "perms": "5l9s6z",
    "icon": "gygkb6",
    "imagePath": "mrcmp9",
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:58",
    "lastTime": "2025-10-20 18:25:58",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 555,
    "description": "rc0ges",
    "listJson": "d5h1sq",
    "delFlag": 5,
    "permsList": [
      {
        "permsName": "merle.larkin",
        "permsStr": "38pyym"
      }
    ],
    "buttonMenuList": [
      {
        "id": "172",
        "parentId": "172",
        "code": "81486",
        "name": "merle.larkin"
      }
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "z0xkfz",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改菜单
**URL:** https://linlan.net/eframe_backend/api/admin/menu/update/single.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改菜单

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─menuId|int64|菜单ID|false|-
└─menuName|string|菜单名称|false|-
└─type|string|功能类型|false|-
└─typeName|string|功能类型|false|-
└─parentName|string|父菜单名称|false|-
└─parentId|int64|父菜单ID|false|-
└─priority|int32|显示顺序|false|-
└─path|string|简短名称ENAME|false|-
└─component|string|组件路径URL|false|-
└─query|string|路由参数JS_EVENT|false|-
└─routeName|string|路由地址|false|-
└─isFrame|string|是否为外链（0是 1否）|false|-
└─isCache|string|是否缓存（0缓存 1不缓存）|false|-
└─menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
└─menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
└─visible|string|显示状态（0隐藏 1显示）|false|-
└─status|string|菜单禁用（0正常 1禁用）|false|-
└─perms|string|权限字符串|false|-
└─icon|string|菜单图标|false|-
└─imagePath|string|菜单图片|false|-
└─creatorId|string|创建者|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|更新时间|false|-
└─children|array|子菜单|false|-
└─childNum|int32|子菜单数量|false|-
└─description|string|备注|false|-
└─listJson|string|页面列表JSON|false|-
└─delFlag|int32|状态0正常1停用2已删除|false|-
└─permsList|array|权限数组|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsName|string|权限名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsStr|string|权限字符串|false|-
└─buttonMenuList|array|子菜单按钮|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|主键|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|string|父节点ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/update/single.do --data '{
  "data": {
    "menuId": 464,
    "menuName": "merle.larkin",
    "type": "9ubv48",
    "typeName": "merle.larkin",
    "parentName": "merle.larkin",
    "parentId": 543,
    "priority": 482,
    "path": "74pz4x",
    "component": "y0v2rg",
    "query": "bgjacb",
    "routeName": "merle.larkin",
    "isFrame": "kw08rk",
    "isCache": "creomm",
    "menuType": "s2yfbw",
    "menuTypeName": "merle.larkin",
    "visible": "ukjwhd",
    "status": "nrsggm",
    "perms": "szag4p",
    "icon": "ofg7sn",
    "imagePath": "a00x59",
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:58",
    "lastTime": "2025-10-20 18:25:58",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 470,
    "description": "c0wmfv",
    "listJson": "fg2xrk",
    "delFlag": 5,
    "permsList": [
      {
        "permsName": "merle.larkin",
        "permsStr": "7wm9su"
      }
    ],
    "buttonMenuList": [
      {
        "id": "172",
        "parentId": "172",
        "code": "81486",
        "name": "merle.larkin"
      }
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "vek6fy",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增菜单及默认按钮
**URL:** https://linlan.net/eframe_backend/api/admin/menu/save.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增菜单及默认按钮

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─menuId|int64|菜单ID|false|-
└─menuName|string|菜单名称|false|-
└─type|string|功能类型|false|-
└─typeName|string|功能类型|false|-
└─parentName|string|父菜单名称|false|-
└─parentId|int64|父菜单ID|false|-
└─priority|int32|显示顺序|false|-
└─path|string|简短名称ENAME|false|-
└─component|string|组件路径URL|false|-
└─query|string|路由参数JS_EVENT|false|-
└─routeName|string|路由地址|false|-
└─isFrame|string|是否为外链（0是 1否）|false|-
└─isCache|string|是否缓存（0缓存 1不缓存）|false|-
└─menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
└─menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
└─visible|string|显示状态（0隐藏 1显示）|false|-
└─status|string|菜单禁用（0正常 1禁用）|false|-
└─perms|string|权限字符串|false|-
└─icon|string|菜单图标|false|-
└─imagePath|string|菜单图片|false|-
└─creatorId|string|创建者|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|更新时间|false|-
└─children|array|子菜单|false|-
└─childNum|int32|子菜单数量|false|-
└─description|string|备注|false|-
└─listJson|string|页面列表JSON|false|-
└─delFlag|int32|状态0正常1停用2已删除|false|-
└─permsList|array|权限数组|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsName|string|权限名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsStr|string|权限字符串|false|-
└─buttonMenuList|array|子菜单按钮|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|主键|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|string|父节点ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/save.do --data '{
  "data": {
    "menuId": 790,
    "menuName": "merle.larkin",
    "type": "uer3s0",
    "typeName": "merle.larkin",
    "parentName": "merle.larkin",
    "parentId": 60,
    "priority": 866,
    "path": "vipgzx",
    "component": "lsa41r",
    "query": "kw8hft",
    "routeName": "merle.larkin",
    "isFrame": "la4qzq",
    "isCache": "l9v726",
    "menuType": "cm8s1c",
    "menuTypeName": "merle.larkin",
    "visible": "d5youn",
    "status": "02brjy",
    "perms": "d33ae1",
    "icon": "3up236",
    "imagePath": "4lvf8w",
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:58",
    "lastTime": "2025-10-20 18:25:58",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 676,
    "description": "kkx953",
    "listJson": "uphkzp",
    "delFlag": 5,
    "permsList": [
      {
        "permsName": "merle.larkin",
        "permsStr": "ofe7fb"
      }
    ],
    "buttonMenuList": [
      {
        "id": "172",
        "parentId": "172",
        "code": "81486",
        "name": "merle.larkin"
      }
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "bm2d72",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改菜单及默认按钮
**URL:** https://linlan.net/eframe_backend/api/admin/menu/update.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改菜单及默认按钮

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─menuId|int64|菜单ID|false|-
└─menuName|string|菜单名称|false|-
└─type|string|功能类型|false|-
└─typeName|string|功能类型|false|-
└─parentName|string|父菜单名称|false|-
└─parentId|int64|父菜单ID|false|-
└─priority|int32|显示顺序|false|-
└─path|string|简短名称ENAME|false|-
└─component|string|组件路径URL|false|-
└─query|string|路由参数JS_EVENT|false|-
└─routeName|string|路由地址|false|-
└─isFrame|string|是否为外链（0是 1否）|false|-
└─isCache|string|是否缓存（0缓存 1不缓存）|false|-
└─menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
└─menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
└─visible|string|显示状态（0隐藏 1显示）|false|-
└─status|string|菜单禁用（0正常 1禁用）|false|-
└─perms|string|权限字符串|false|-
└─icon|string|菜单图标|false|-
└─imagePath|string|菜单图片|false|-
└─creatorId|string|创建者|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|更新时间|false|-
└─children|array|子菜单|false|-
└─childNum|int32|子菜单数量|false|-
└─description|string|备注|false|-
└─listJson|string|页面列表JSON|false|-
└─delFlag|int32|状态0正常1停用2已删除|false|-
└─permsList|array|权限数组|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsName|string|权限名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─permsStr|string|权限字符串|false|-
└─buttonMenuList|array|子菜单按钮|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|string|主键|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|string|父节点ID|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|代码|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/update.do --data '{
  "data": {
    "menuId": 480,
    "menuName": "merle.larkin",
    "type": "mh374a",
    "typeName": "merle.larkin",
    "parentName": "merle.larkin",
    "parentId": 864,
    "priority": 665,
    "path": "6z94c7",
    "component": "3q1ucf",
    "query": "jmgsv1",
    "routeName": "merle.larkin",
    "isFrame": "3pjgee",
    "isCache": "io75c3",
    "menuType": "h77meq",
    "menuTypeName": "merle.larkin",
    "visible": "eaul1u",
    "status": "xsaya4",
    "perms": "3exvci",
    "icon": "jdkiv6",
    "imagePath": "4n30cl",
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:58",
    "lastTime": "2025-10-20 18:25:58",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 615,
    "description": "tjwyqa",
    "listJson": "aen47i",
    "delFlag": 5,
    "permsList": [
      {
        "permsName": "merle.larkin",
        "permsStr": "ixras5"
      }
    ],
    "buttonMenuList": [
      {
        "id": "172",
        "parentId": "172",
        "code": "81486",
        "name": "merle.larkin"
      }
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "35m940",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除菜单
**URL:** https://linlan.net/eframe_backend/api/admin/menu/delete/{menuIds}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除菜单

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
menuIds|array| 菜单Ids,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "f29rxo",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 停用启用菜单
**URL:** https://linlan.net/eframe_backend/api/admin/menu/disable/{id}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 停用启用菜单

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|功能菜单ID|false|-
└─parentId|int64|父功能菜单ID|false|-
└─appId|string|应用ID|false|-
└─name|string|功能名称|false|-
└─ename|string|功能名称简称，英文，其他语种名称|false|-
└─sname|string|简短名称|false|-
└─isProtect|boolean|是否系统菜单，0否（会员或前端菜单）1是（系统菜单）|false|-
└─type|string|功能类型,关联BASE_RIGHTTYPE，ADMIN,WORK,APP,SCREEN,MEMBER,AUDIT|false|-
└─userId|string|系统管理用户ID|false|-
└─code|string|功能编号|false|-
└─menuLevel|int32|菜单层次|false|-
└─subCount|int32|子节点数|false|-
└─perms|string|功能模型，多个用逗号分隔，如：admin:user:list|false|-
└─urlType|string|调用入口类型，如CATAGORY,MENU,BUTTON,OUTLINK,CHANNEL,COMPOS,SCENES,RECOMMEND,FOLLOW|false|-
└─url|string|功能地址，前台URL路由地址|false|-
└─icon|string|功能图标，样式序号，图标或按钮路径|false|-
└─popPosition|int32|弹出位置|false|-
└─imagePath|string|图片路径|false|-
└─css|string|CSS页面样式|false|-
└─jsEvent|string|JS事件|false|-
└─menuSeq|string|菜单序列,菜单关联的外键ID，如栏目ID，组件ID，三方功能ID|false|-
└─shortCut|string|快捷键|false|-
└─isLeaf|boolean|是否叶子节点0为非叶子节点，1为叶子节点|false|-
└─isDisplay|boolean|是否显示0否1是|false|-
└─isDisabled|boolean|是否禁用0否1是|false|-
└─isCheck|boolean|是否验证权限0为无需验证，1为需要验证|false|-
└─priority|int32|重点优先级|false|-
└─delFlag|int32|是否删除1已删除0正常|false|-
└─deleteTime|string|删除时间|false|-
└─description|string|描述|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─open|boolean|ztree属性|false|-
└─list|array|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/disable/{id}.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:59",
    "lastTime": "2025-10-20 18:25:59",
    "id": 84,
    "parentId": 113,
    "appId": "172",
    "name": "merle.larkin",
    "ename": "merle.larkin",
    "sname": "merle.larkin",
    "isProtect": true,
    "type": "0758pl",
    "userId": "172",
    "code": "81486",
    "menuLevel": 518,
    "subCount": 741,
    "perms": "89p9u7",
    "urlType": "m2fv33",
    "url": "www.ben-grant.info",
    "icon": "vfsu6z",
    "popPosition": 464,
    "imagePath": "v8lzou",
    "css": "nffgqu",
    "jsEvent": "s0es2z",
    "menuSeq": "ijjwf0",
    "shortCut": "73kdnc",
    "isLeaf": true,
    "isDisplay": true,
    "isDisabled": true,
    "isCheck": true,
    "priority": 814,
    "delFlag": 5,
    "deleteTime": "2025-10-20 18:25:59",
    "description": "fa8vo9",
    "spare1": "vskx5g",
    "spare2": "ft0xbo",
    "open": true,
    "list": [
      {
        "object": "any object"
      }
    ]
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ap6fx1",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 系统角色信息读写
### 获取角色列表
**URL:** https://linlan.net/eframe_backend/api/admin/role/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取角色列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
roleId|int64|角色ID|false|-
roleName|string|角色名称|false|-
roleKey|string|角色权限|false|-
status|int32|角色状态（0未生效 1正常）|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/list.do?orderBy=500&roleName=merle.larkin&roleId=531&roleKey=3mi6bc&endTime=2025-10-20 18:20:52&startTime=2025-10-20 18:20:52&status=583&page=1&q=y48eib&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─roleId|int64|角色ID|-
└─roleName|string|角色名称|-
└─roleKey|string|角色权限|-
└─roleSort|int32|角色排序|-
└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|-
└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|-
└─status|int32|角色状态（0未生效 1正常）|-
└─flag|boolean|用户是否存在此角色标识 默认不存在|-
└─menuIds|array|菜单组|-
└─deptIds|array|部门组（数据权限）|-
└─permissions|array|角色菜单权限|-
└─remark|string|备注|-
└─parentName|string|父角色名字|-
└─appName|string|全局应用信息类|-
└─roletypeId|string|系统角色分类|-
└─roletypeName|string|系统角色分类|-
└─priority|int32|排序码|-
└─isSuper|boolean|是否拥有所有权限|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:59",
      "lastTime": "2025-10-20 18:25:59",
      "roleId": 953,
      "roleName": "merle.larkin",
      "roleKey": "qvfbu5",
      "roleSort": 518,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 961,
      "flag": true,
      "menuIds": [
        655
      ],
      "deptIds": [
        514
      ],
      "permissions": [
        "fdx6wg"
      ],
      "remark": "lu2e8b",
      "parentName": "merle.larkin",
      "appName": "merle.larkin",
      "roletypeId": "172",
      "roletypeName": "merle.larkin",
      "priority": 505,
      "isSuper": true
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 角色信息导出
**URL:** https://linlan.net/eframe_backend/api/admin/role/export.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 角色信息导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
roleId|int64|角色ID|false|-
roleName|string|角色名称|false|-
roleKey|string|角色权限|false|-
status|int32|角色状态（0未生效 1正常）|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/export.do --data 'roleName=merle.larkin&endTime=2025-10-20 18:20:52&page=1&startTime=2025-10-20 18:20:52&limit=10&roleId=362&roleKey=60vyu7&orderBy=47&status=185&q=30gyvm'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "o1dcof",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据角色编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/admin/role/{roleId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据角色编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
roleId|int64| 角色ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/172.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─roleId|int64|角色ID|-
└─roleName|string|角色名称|-
└─roleKey|string|角色权限|-
└─roleSort|int32|角色排序|-
└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|-
└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|-
└─status|int32|角色状态（0未生效 1正常）|-
└─flag|boolean|用户是否存在此角色标识 默认不存在|-
└─menuIds|array|菜单组|-
└─deptIds|array|部门组（数据权限）|-
└─permissions|array|角色菜单权限|-
└─remark|string|备注|-
└─parentName|string|父角色名字|-
└─appName|string|全局应用信息类|-
└─roletypeId|string|系统角色分类|-
└─roletypeName|string|系统角色分类|-
└─priority|int32|排序码|-
└─isSuper|boolean|是否拥有所有权限|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:59",
    "lastTime": "2025-10-20 18:25:59",
    "roleId": 609,
    "roleName": "merle.larkin",
    "roleKey": "zv4t19",
    "roleSort": 72,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 306,
    "flag": true,
    "menuIds": [
      746
    ],
    "deptIds": [
      601
    ],
    "permissions": [
      "4kvsze"
    ],
    "remark": "si8wdx",
    "parentName": "merle.larkin",
    "appName": "merle.larkin",
    "roletypeId": "172",
    "roletypeName": "merle.larkin",
    "priority": 981,
    "isSuper": true
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增角色
**URL:** https://linlan.net/eframe_backend/api/admin/role/save.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增角色

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─roleKey|string|角色权限|false|-
└─roleSort|int32|角色排序|false|-
└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
└─status|int32|角色状态（0未生效 1正常）|false|-
└─flag|boolean|用户是否存在此角色标识 默认不存在|false|-
└─menuIds|array|菜单组|false|-
└─deptIds|array|部门组（数据权限）|false|-
└─permissions|array|角色菜单权限|false|-
└─remark|string|备注|false|-
└─parentName|string|父角色名字|false|-
└─appName|string|全局应用信息类|false|-
└─roletypeId|string|系统角色分类|false|-
└─roletypeName|string|系统角色分类|false|-
└─priority|int32|排序码|false|-
└─isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:59",
    "lastTime": "2025-10-20 18:25:59",
    "roleId": 353,
    "roleName": "merle.larkin",
    "roleKey": "zqzpun",
    "roleSort": 332,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 273,
    "flag": true,
    "menuIds": [
      775
    ],
    "deptIds": [
      913
    ],
    "permissions": [
      "5rsqpc"
    ],
    "remark": "9a5cqi",
    "parentName": "merle.larkin",
    "appName": "merle.larkin",
    "roletypeId": "172",
    "roletypeName": "merle.larkin",
    "priority": 237,
    "isSuper": true
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "urgogt",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改保存角色
**URL:** https://linlan.net/eframe_backend/api/admin/role/update.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改保存角色

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─roleKey|string|角色权限|false|-
└─roleSort|int32|角色排序|false|-
└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
└─status|int32|角色状态（0未生效 1正常）|false|-
└─flag|boolean|用户是否存在此角色标识 默认不存在|false|-
└─menuIds|array|菜单组|false|-
└─deptIds|array|部门组（数据权限）|false|-
└─permissions|array|角色菜单权限|false|-
└─remark|string|备注|false|-
└─parentName|string|父角色名字|false|-
└─appName|string|全局应用信息类|false|-
└─roletypeId|string|系统角色分类|false|-
└─roletypeName|string|系统角色分类|false|-
└─priority|int32|排序码|false|-
└─isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:59",
    "lastTime": "2025-10-20 18:25:59",
    "roleId": 222,
    "roleName": "merle.larkin",
    "roleKey": "hgj8ju",
    "roleSort": 876,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 15,
    "flag": true,
    "menuIds": [
      611
    ],
    "deptIds": [
      403
    ],
    "permissions": [
      "9z3t4g"
    ],
    "remark": "yaqhz7",
    "parentName": "merle.larkin",
    "appName": "merle.larkin",
    "roletypeId": "172",
    "roletypeName": "merle.larkin",
    "priority": 614,
    "isSuper": true
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "13ar7r",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增角色及绑定菜单部门
**URL:** https://linlan.net/eframe_backend/api/admin/role/save/all.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增角色及绑定菜单部门

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─roleKey|string|角色权限|false|-
└─roleSort|int32|角色排序|false|-
└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
└─status|int32|角色状态（0未生效 1正常）|false|-
└─flag|boolean|用户是否存在此角色标识 默认不存在|false|-
└─menuIds|array|菜单组|false|-
└─deptIds|array|部门组（数据权限）|false|-
└─permissions|array|角色菜单权限|false|-
└─remark|string|备注|false|-
└─parentName|string|父角色名字|false|-
└─appName|string|全局应用信息类|false|-
└─roletypeId|string|系统角色分类|false|-
└─roletypeName|string|系统角色分类|false|-
└─priority|int32|排序码|false|-
└─isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/save/all.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:59",
    "lastTime": "2025-10-20 18:25:59",
    "roleId": 802,
    "roleName": "merle.larkin",
    "roleKey": "sumdvv",
    "roleSort": 742,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 223,
    "flag": true,
    "menuIds": [
      694
    ],
    "deptIds": [
      838
    ],
    "permissions": [
      "s1ywk8"
    ],
    "remark": "0o2oam",
    "parentName": "merle.larkin",
    "appName": "merle.larkin",
    "roletypeId": "172",
    "roletypeName": "merle.larkin",
    "priority": 212,
    "isSuper": true
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "to4e4y",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改保存角色及绑定菜单部门
**URL:** https://linlan.net/eframe_backend/api/admin/role/update/all.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改保存角色及绑定菜单部门

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─roleKey|string|角色权限|false|-
└─roleSort|int32|角色排序|false|-
└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
└─status|int32|角色状态（0未生效 1正常）|false|-
└─flag|boolean|用户是否存在此角色标识 默认不存在|false|-
└─menuIds|array|菜单组|false|-
└─deptIds|array|部门组（数据权限）|false|-
└─permissions|array|角色菜单权限|false|-
└─remark|string|备注|false|-
└─parentName|string|父角色名字|false|-
└─appName|string|全局应用信息类|false|-
└─roletypeId|string|系统角色分类|false|-
└─roletypeName|string|系统角色分类|false|-
└─priority|int32|排序码|false|-
└─isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/update/all.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:59",
    "lastTime": "2025-10-20 18:25:59",
    "roleId": 544,
    "roleName": "merle.larkin",
    "roleKey": "2bsqs0",
    "roleSort": 601,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 734,
    "flag": true,
    "menuIds": [
      805
    ],
    "deptIds": [
      35
    ],
    "permissions": [
      "f65ipn"
    ],
    "remark": "nq1m1w",
    "parentName": "merle.larkin",
    "appName": "merle.larkin",
    "roletypeId": "172",
    "roletypeName": "merle.larkin",
    "priority": 166,
    "isSuper": true
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "hln0vn",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除角色
**URL:** https://linlan.net/eframe_backend/api/admin/role/delete/{roleIds}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除角色

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
roleIds|array| 角色Ids,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "p1q2zq",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 停用启用角色
**URL:** https://linlan.net/eframe_backend/api/admin/role/disable/{roleId}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 停用启用角色

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|角色ID|false|-
└─roletypeId|string|角色分类ID|false|-
└─appId|string|应用ID|false|-
└─name|string|角色自定义名称|false|-
└─code|string|角色自定义代码|false|-
└─priority|int32|重点优先级|false|-
└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|false|-
└─isSuper|boolean|拥有所有权限|false|-
└─isPublic|boolean|是否公共角色|false|-
└─status|int32|状态0未生效1正常2受限3锁定4删除|false|-
└─description|string|角色描述|false|-
└─areaType|string|地域类型|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/disable/{roleId}.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:59",
    "lastTime": "2025-10-20 18:25:59",
    "id": 555,
    "roletypeId": "172",
    "appId": "172",
    "name": "merle.larkin",
    "code": "81486",
    "priority": 824,
    "isRegular": true,
    "isSuper": true,
    "isPublic": true,
    "status": 756,
    "description": "vsnoj0",
    "areaType": "us98xc"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ef2ai3",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 角色绑定菜单
**URL:** https://linlan.net/eframe_backend/api/admin/role/bindMenu/{roleId}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 角色绑定菜单

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─roleKey|string|角色权限|false|-
└─roleSort|int32|角色排序|false|-
└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
└─status|int32|角色状态（0未生效 1正常）|false|-
└─flag|boolean|用户是否存在此角色标识 默认不存在|false|-
└─menuIds|array|菜单组|false|-
└─deptIds|array|部门组（数据权限）|false|-
└─permissions|array|角色菜单权限|false|-
└─remark|string|备注|false|-
└─parentName|string|父角色名字|false|-
└─appName|string|全局应用信息类|false|-
└─roletypeId|string|系统角色分类|false|-
└─roletypeName|string|系统角色分类|false|-
└─priority|int32|排序码|false|-
└─isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/bindMenu/{roleId}.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:59",
    "lastTime": "2025-10-20 18:25:59",
    "roleId": 390,
    "roleName": "merle.larkin",
    "roleKey": "py5p1f",
    "roleSort": 241,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 385,
    "flag": true,
    "menuIds": [
      847
    ],
    "deptIds": [
      608
    ],
    "permissions": [
      "tv6mu1"
    ],
    "remark": "uo33l7",
    "parentName": "merle.larkin",
    "appName": "merle.larkin",
    "roletypeId": "172",
    "roletypeName": "merle.larkin",
    "priority": 36,
    "isSuper": true
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "wev9zc",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 角色绑定部门
**URL:** https://linlan.net/eframe_backend/api/admin/role/bindDept/{roleId}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 角色绑定部门

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─roleKey|string|角色权限|false|-
└─roleSort|int32|角色排序|false|-
└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
└─status|int32|角色状态（0未生效 1正常）|false|-
└─flag|boolean|用户是否存在此角色标识 默认不存在|false|-
└─menuIds|array|菜单组|false|-
└─deptIds|array|部门组（数据权限）|false|-
└─permissions|array|角色菜单权限|false|-
└─remark|string|备注|false|-
└─parentName|string|父角色名字|false|-
└─appName|string|全局应用信息类|false|-
└─roletypeId|string|系统角色分类|false|-
└─roletypeName|string|系统角色分类|false|-
└─priority|int32|排序码|false|-
└─isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/bindDept/{roleId}.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:59",
    "lastTime": "2025-10-20 18:25:59",
    "roleId": 308,
    "roleName": "merle.larkin",
    "roleKey": "4yki1k",
    "roleSort": 633,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 420,
    "flag": true,
    "menuIds": [
      580
    ],
    "deptIds": [
      233
    ],
    "permissions": [
      "37r7uu"
    ],
    "remark": "xeqbdq",
    "parentName": "merle.larkin",
    "appName": "merle.larkin",
    "roletypeId": "172",
    "roletypeName": "merle.larkin",
    "priority": 596,
    "isSuper": true
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "03yf6w",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取角色选择框列表
**URL:** https://linlan.net/eframe_backend/api/admin/role/option/select.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取角色选择框列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/option/select.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─roleId|int64|角色ID|-
└─roleName|string|角色名称|-
└─roleKey|string|角色权限|-
└─roleSort|int32|角色排序|-
└─menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|-
└─deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|-
└─status|int32|角色状态（0未生效 1正常）|-
└─flag|boolean|用户是否存在此角色标识 默认不存在|-
└─menuIds|array|菜单组|-
└─deptIds|array|部门组（数据权限）|-
└─permissions|array|角色菜单权限|-
└─remark|string|备注|-
└─parentName|string|父角色名字|-
└─appName|string|全局应用信息类|-
└─roletypeId|string|系统角色分类|-
└─roletypeName|string|系统角色分类|-
└─priority|int32|排序码|-
└─isSuper|boolean|是否拥有所有权限|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:59",
      "lastTime": "2025-10-20 18:25:59",
      "roleId": 945,
      "roleName": "merle.larkin",
      "roleKey": "bnq6ry",
      "roleSort": 644,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 606,
      "flag": true,
      "menuIds": [
        22
      ],
      "deptIds": [
        165
      ],
      "permissions": [
        "jccxwa"
      ],
      "remark": "lq1cyn",
      "parentName": "merle.larkin",
      "appName": "merle.larkin",
      "roletypeId": "172",
      "roletypeName": "merle.larkin",
      "priority": 677,
      "isSuper": true
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 查询已分配用户角色列表
**URL:** https://linlan.net/eframe_backend/api/admin/role/authUser/allocatedList.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询已分配用户角色列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
adminId|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
organId|string|机构ID|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
status|string|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 1代表删除）|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/allocatedList.do?deptId=441&endTime=2025-10-20 18:20:52&adminId=458&nickName=renna.dibbert&orderBy=161&startTime=2025-10-20 18:20:52&q=49omlc&status=hs73vi&organId=172&userId=172&username=merle.larkin&limit=10&delFlag=5&mobile=(415) 540-6962&email=vivian.streich@hotmail.com&page=1
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|用户LID|-
└─userId|string|用户UUID|-
└─deptId|int64|部门ID|-
└─deptName|string|部门名称|-
└─organId|string|机构ID|-
└─organName|string|机构名称|-
└─name|string|人员姓名|-
└─username|string|用户账号|-
└─nickName|string|用户昵称|-
└─email|string|用户邮箱|-
└─mobile|string|手机号码|-
└─imagePath|string|用户头像|-
└─password|string|密码|-
└─isSuperAdmin|boolean|是否超级管理员|-
└─isAuditAdmin|boolean|是否审计只读管理员|-
└─isSelfAdmin|boolean|是否只管理自己的数据|-
└─status|int32|帐号状态（0未生效 1正常）|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|-
└─lastLoginIp|string|最后登录IP|-
└─lastLoginTime|string|最后登录时间|-
└─description|string|备注,办公地址|-
└─dept|object|部门对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|-
└─roles|array|角色对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|-
└─roleIds|array|角色组|-
└─positionIds|array|岗位组|-
└─roleId|int64|角色ID|-
└─userRoleList|array|角色集合|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|-
└─code|string|验证码|-
└─uuid|string|uuid标识|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:59",
      "lastTime": "2025-10-20 18:25:59",
      "id": 366,
      "userId": "172",
      "deptId": 658,
      "deptName": "merle.larkin",
      "organId": "172",
      "organName": "merle.larkin",
      "name": "merle.larkin",
      "username": "merle.larkin",
      "nickName": "renna.dibbert",
      "email": "vivian.streich@hotmail.com",
      "mobile": "(415) 540-6962",
      "imagePath": "um4l9x",
      "password": "0r0p15",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 418,
      "delFlag": 5,
      "lastLoginIp": "137.119.212.174",
      "lastLoginTime": "2025-10-20 18:25:59",
      "description": "l2rmlx",
      "dept": {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:59",
        "lastTime": "2025-10-20 18:25:59",
        "id": 996,
        "organId": "172",
        "parentId": 0,
        "appId": "172",
        "depttypeId": 465,
        "foreignId": "172",
        "createType": 221,
        "type": "ioevz0",
        "name": "merle.larkin",
        "sname": "merle.larkin",
        "areaCode": "81486",
        "organLeader": "2dvff9",
        "leaderId": "172",
        "leaderMobile": "(415) 540-6962",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "81486",
        "imagePath": "74bj5t",
        "priority": 946,
        "status": 426,
        "delFlag": 5,
        "description": "vnq3i7",
        "spare1": "7hayki",
        "spare2": "qu8ws0",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "172",
          "createTime": "2025-10-20 18:25:59",
          "lastTime": "2025-10-20 18:25:59",
          "id": 743,
          "roletypeId": "172",
          "appId": "172",
          "name": "merle.larkin",
          "code": "81486",
          "priority": 713,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 581,
          "description": "7es5th",
          "areaType": "wg0pk9"
        }
      ],
      "roleIds": [
        818
      ],
      "positionIds": [
        "0jplgf"
      ],
      "roleId": 605,
      "userRoleList": [
        {
          "id": 292,
          "deptId": 578,
          "deptName": "merle.larkin",
          "organId": "172",
          "organName": "merle.larkin",
          "roleId": 183,
          "roleName": "merle.larkin",
          "adminId": 952
        }
      ],
      "code": "81486",
      "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 查询未分配用户角色列表
**URL:** https://linlan.net/eframe_backend/api/admin/role/authUser/unallocatedList.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询未分配用户角色列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
adminId|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
organId|string|机构ID|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
status|string|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 1代表删除）|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/unallocatedList.do?limit=10&deptId=6&mobile=(415) 540-6962&email=vivian.streich@hotmail.com&delFlag=5&endTime=2025-10-20 18:20:52&orderBy=71&page=1&startTime=2025-10-20 18:20:52&userId=172&username=merle.larkin&adminId=728&q=bvekqm&nickName=renna.dibbert&status=j0m4hz&organId=172
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|用户LID|-
└─userId|string|用户UUID|-
└─deptId|int64|部门ID|-
└─deptName|string|部门名称|-
└─organId|string|机构ID|-
└─organName|string|机构名称|-
└─name|string|人员姓名|-
└─username|string|用户账号|-
└─nickName|string|用户昵称|-
└─email|string|用户邮箱|-
└─mobile|string|手机号码|-
└─imagePath|string|用户头像|-
└─password|string|密码|-
└─isSuperAdmin|boolean|是否超级管理员|-
└─isAuditAdmin|boolean|是否审计只读管理员|-
└─isSelfAdmin|boolean|是否只管理自己的数据|-
└─status|int32|帐号状态（0未生效 1正常）|-
└─delFlag|int32|删除标志（0代表存在 2代表删除）|-
└─lastLoginIp|string|最后登录IP|-
└─lastLoginTime|string|最后登录时间|-
└─description|string|备注,办公地址|-
└─dept|object|部门对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|单位ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|系统机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parentId|int64|父节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─depttypeId|int64|部门分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外部业务ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createType|int32|创建方式0导入1录入2授权|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，BENJI本级，NEISHE内设机构，FENZI分子机构|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|名称，多级累加名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sname|string|名称简称，本单位显示名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaCode|string|地域编码，所在城市|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organLeader|string|领导名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderId|string|负责人ID，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─leaderMobile|string|负责人手机号码，用户接收相关信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isOrganLevel|boolean|是否机构本级1是0否默认1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isVirtual|boolean|是否虚拟节点1是0不是默认0|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isLeaf|boolean|是否叶子节点|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isDisabled|boolean|是否禁用0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─searchCode|string|多级累加路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|图片路径|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|是否删除1已删除0正常|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子部门|-
└─roles|array|角色对象|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roletypeId|string|角色分类ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|角色自定义名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─code|string|角色自定义代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|重点优先级|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuper|boolean|拥有所有权限|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPublic|boolean|是否公共角色|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定4删除|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|角色描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─areaType|string|地域类型|-
└─roleIds|array|角色组|-
└─positionIds|array|岗位组|-
└─roleId|int64|角色ID|-
└─userRoleList|array|角色集合|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptName|string|部门名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organName|string|机构名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleId|int64|角色ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─roleName|string|角色名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|公共管理用户ID|-
└─code|string|验证码|-
└─uuid|string|uuid标识|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:59",
      "lastTime": "2025-10-20 18:25:59",
      "id": 726,
      "userId": "172",
      "deptId": 750,
      "deptName": "merle.larkin",
      "organId": "172",
      "organName": "merle.larkin",
      "name": "merle.larkin",
      "username": "merle.larkin",
      "nickName": "renna.dibbert",
      "email": "vivian.streich@hotmail.com",
      "mobile": "(415) 540-6962",
      "imagePath": "7hulz6",
      "password": "ya4646",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 952,
      "delFlag": 5,
      "lastLoginIp": "137.119.212.174",
      "lastLoginTime": "2025-10-20 18:25:59",
      "description": "ltj4mt",
      "dept": {
        "creatorId": "172",
        "createTime": "2025-10-20 18:25:59",
        "lastTime": "2025-10-20 18:25:59",
        "id": 421,
        "organId": "172",
        "parentId": 106,
        "appId": "172",
        "depttypeId": 637,
        "foreignId": "172",
        "createType": 316,
        "type": "dav7k0",
        "name": "merle.larkin",
        "sname": "merle.larkin",
        "areaCode": "81486",
        "organLeader": "4drq8i",
        "leaderId": "172",
        "leaderMobile": "(415) 540-6962",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "81486",
        "imagePath": "7vnjy0",
        "priority": 9,
        "status": 654,
        "delFlag": 5,
        "description": "8sogbq",
        "spare1": "ovm3ed",
        "spare2": "ngz7vs",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "172",
          "createTime": "2025-10-20 18:25:59",
          "lastTime": "2025-10-20 18:25:59",
          "id": 272,
          "roletypeId": "172",
          "appId": "172",
          "name": "merle.larkin",
          "code": "81486",
          "priority": 19,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 376,
          "description": "i53f7m",
          "areaType": "tvrjn1"
        }
      ],
      "roleIds": [
        909
      ],
      "positionIds": [
        "7xjat8"
      ],
      "roleId": 782,
      "userRoleList": [
        {
          "id": 262,
          "deptId": 356,
          "deptName": "merle.larkin",
          "organId": "172",
          "organName": "merle.larkin",
          "roleId": 100,
          "roleName": "merle.larkin",
          "adminId": 159
        }
      ],
      "code": "81486",
      "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 取消授权用户
**URL:** https://linlan.net/eframe_backend/api/admin/role/authUser/cancel.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 取消授权用户

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─id|int64|用户角色ID|false|-
└─roleId|int64|角色ID|false|-
└─adminId|int64|公共管理用户ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/cancel.do --data '{
  "data": {
    "id": 328,
    "roleId": 0,
    "adminId": 614
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "nd1ksk",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 批量取消授权用户
**URL:** https://linlan.net/eframe_backend/api/admin/role/authUser/cancelAll.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 批量取消授权用户

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
roleId|int64| 角色ID|false|-
adminIds|array| 管理员Ids,[array of int64]|false|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/cancelAll.do --data 'roleId=838&adminIds=cz0lyo&adminIds=cz0lyo'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "g73k6m",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 批量选择用户授权
**URL:** https://linlan.net/eframe_backend/api/admin/role/authUser/selectAll.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 批量选择用户授权

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
roleId|int64| 角色ID|false|-
adminIds|array| 管理员Ids,[array of int64]|false|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/selectAll.do --data 'roleId=590&adminIds=l8b2b2&adminIds=l8b2b2'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "10b0a2",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取对应角色部门树列表
**URL:** https://linlan.net/eframe_backend/api/admin/role/deptTree/{roleId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取对应角色部门树列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
roleId|int64| 角色ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/deptTree/481.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─checkedKeys|array|选中菜单列表|-
└─depts|array|下拉树结构列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|节点ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─label|string|节点名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─children|array|子节点|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "checkedKeys": [
      305
    ],
    "depts": [
      {
        "id": 549,
        "label": "2poloe",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 统一待办读写控制类
### Get PublicUnionTodo list. 获取统一待办列表或分页, 返回PublicUnionTodo对象.
**URL:** https://linlan.net/eframe_backend/api/system/todo/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get PublicUnionTodo list. 获取统一待办列表或分页, 返回PublicUnionTodo对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|string|记录ID|false|-
appId|string|应用ID|false|-
foreignId|string|站点门户ID|false|-
type|string|类型，外部则为OUT|false|-
bizType|string|业务类型|false|-
todoCreateTime|string|待办创建时间|false|-
todoId|string|单据编号|false|-
todoType|string|单据类型|false|-
todoName|string|单据主题|false|-
todoAbstract|string|单据摘要|false|-
todoAccountId|string|待办应用账户ID|false|-
todoAccountName|string|待办应用系统或账户名称|false|-
todoModuleId|string|待办应用应用ID|false|-
todoModuleName|string|待办应用应用名称|false|-
todoUserId|string|待办应用用户ID|false|-
todoUserName|string|待办应用用户名称|false|-
todoOrganId|string|待办应用机构ID|false|-
todoOrganName|string|待办应用机构名称|false|-
todoProcessName|string|待办流程节点名称|false|-
todoProcessStatus|string|待办流程节点状态码|false|-
todoProcessInfo|string|待办流程节点信息|false|-
todoCurrInfo|string|待办业务当前信息|false|-
todoNextInfo|string|待办业务下一步信息|false|-
todoUrl|string|待办业务URL|false|-
todoLabels|string|单据业务标签|false|-
todoContent|string|单据其他信息|false|-
status|string|状态，0待办，1在办，10已办，20办结|false|-
opUserId|string|操作人ID|false|-
opTime|string|操作时间|false|-
opOrganId|string|操作单位ID|false|-
opOrganName|string|操作单位名称|false|-
creatorId|string|创建人ID，不使用外键|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/list.do?todoCurrInfo=3568f2&todoId=172&q=dyhp6w&todoProcessName=merle.larkin&todoOrganId=172&page=1&todoLabels=9vda3c&spare1=k1qpxa&todoType=bppnsx&creatorId=172&todoUserId=172&status=a667lb&todoAccountId=172&todoModuleId=172&todoAccountName=merle.larkin&opTime=2025-10-20 18:26:10&bizType=diucl5&foreignId=172&opOrganId=172&orderBy=561&todoUserName=merle.larkin&startTime=2025-10-20 18:20:52&todoProcessInfo=gxn55o&opOrganName=merle.larkin&todoOrganName=merle.larkin&id=172&todoProcessStatus=gqmqy6&spare2=jnxr7w&todoModuleName=merle.larkin&limit=10&endTime=2025-10-20 18:20:52&todoCreateTime=2025-10-20 18:26:10&todoUrl=www.ben-grant.info&opUserId=172&type=29huh6&todoName=merle.larkin&description=4vhd62&appId=172&todoNextInfo=x7788k&todoContent=hgpu4r&todoAbstract=scynp0
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|记录ID|-
└─appId|string|应用ID|-
└─foreignId|string|站点门户ID|-
└─type|string|类型，外部则为OUT|-
└─bizType|string|业务类型|-
└─todoCreateTime|string|待办创建时间|-
└─todoId|string|单据编号|-
└─todoType|string|单据类型|-
└─todoName|string|单据主题|-
└─todoAbstract|string|单据摘要|-
└─todoAccountId|string|待办应用账户ID|-
└─todoAccountName|string|待办应用系统或账户名称|-
└─todoModuleId|string|待办应用应用ID|-
└─todoModuleName|string|待办应用应用名称|-
└─todoUserId|string|待办应用用户ID|-
└─todoUserName|string|待办应用用户名称|-
└─todoOrganId|string|待办应用机构ID|-
└─todoOrganName|string|待办应用机构名称|-
└─todoProcessName|string|待办流程节点名称|-
└─todoProcessStatus|string|待办流程节点状态码|-
└─todoProcessInfo|string|待办流程节点信息|-
└─todoCurrInfo|string|待办业务当前信息|-
└─todoNextInfo|string|待办业务下一步信息|-
└─todoUrl|string|待办业务URL|-
└─todoLabels|string|单据业务标签|-
└─todoContent|string|单据其他信息|-
└─status|string|状态，0待办，1在办，10已办，20办结|-
└─opUserId|string|操作人ID|-
└─opTime|string|操作时间|-
└─opOrganId|string|操作单位ID|-
└─opOrganName|string|操作单位名称|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:10",
      "lastTime": "2025-10-20 18:26:10",
      "id": "172",
      "appId": "172",
      "foreignId": "172",
      "type": "0umv3v",
      "bizType": "nl2ljr",
      "todoCreateTime": "2025-10-20 18:26:10",
      "todoId": "172",
      "todoType": "jcb46p",
      "todoName": "merle.larkin",
      "todoAbstract": "4n76as",
      "todoAccountId": "172",
      "todoAccountName": "merle.larkin",
      "todoModuleId": "172",
      "todoModuleName": "merle.larkin",
      "todoUserId": "172",
      "todoUserName": "merle.larkin",
      "todoOrganId": "172",
      "todoOrganName": "merle.larkin",
      "todoProcessName": "merle.larkin",
      "todoProcessStatus": "yeda3d",
      "todoProcessInfo": "rxqg2l",
      "todoCurrInfo": "7m63kw",
      "todoNextInfo": "iwr7mn",
      "todoUrl": "www.ben-grant.info",
      "todoLabels": "3vhvg3",
      "todoContent": "ibbwub",
      "status": "kv1on0",
      "opUserId": "172",
      "opTime": "2025-10-20 18:26:10",
      "opOrganId": "172",
      "opOrganName": "merle.larkin",
      "description": "pvup08",
      "spare1": "5s2ubl",
      "spare2": "vz9wf1"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicUnionTodo Operation. PublicUnionTodo数据操作逻辑，导出操作.
**URL:** https://linlan.net/eframe_backend/api/system/todo/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicUnionTodo Operation. PublicUnionTodo数据操作逻辑，导出操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|string|记录ID|false|-
appId|string|应用ID|false|-
foreignId|string|站点门户ID|false|-
type|string|类型，外部则为OUT|false|-
bizType|string|业务类型|false|-
todoCreateTime|string|待办创建时间|false|-
todoId|string|单据编号|false|-
todoType|string|单据类型|false|-
todoName|string|单据主题|false|-
todoAbstract|string|单据摘要|false|-
todoAccountId|string|待办应用账户ID|false|-
todoAccountName|string|待办应用系统或账户名称|false|-
todoModuleId|string|待办应用应用ID|false|-
todoModuleName|string|待办应用应用名称|false|-
todoUserId|string|待办应用用户ID|false|-
todoUserName|string|待办应用用户名称|false|-
todoOrganId|string|待办应用机构ID|false|-
todoOrganName|string|待办应用机构名称|false|-
todoProcessName|string|待办流程节点名称|false|-
todoProcessStatus|string|待办流程节点状态码|false|-
todoProcessInfo|string|待办流程节点信息|false|-
todoCurrInfo|string|待办业务当前信息|false|-
todoNextInfo|string|待办业务下一步信息|false|-
todoUrl|string|待办业务URL|false|-
todoLabels|string|单据业务标签|false|-
todoContent|string|单据其他信息|false|-
status|string|状态，0待办，1在办，10已办，20办结|false|-
opUserId|string|操作人ID|false|-
opTime|string|操作时间|false|-
opOrganId|string|操作单位ID|false|-
opOrganName|string|操作单位名称|false|-
creatorId|string|创建人ID，不使用外键|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/export.do --data 'todoName=merle.larkin&id=172&todoNextInfo=u8nzju&todoType=o503zl&opOrganId=172&todoAccountId=172&creatorId=172&todoProcessName=merle.larkin&spare1=p0iz5a&type=7zv4hb&foreignId=172&todoId=172&todoCurrInfo=p5t7zq&appId=172&todoLabels=052d0k&todoUserName=merle.larkin&todoOrganId=172&todoProcessInfo=2b635v&todoContent=2qlvg8&todoOrganName=merle.larkin&todoCreateTime=2025-10-20 18:26:10&orderBy=717&limit=10&todoUserId=172&todoUrl=www.ben-grant.info&opOrganName=merle.larkin&todoModuleName=merle.larkin&opUserId=172&startTime=2025-10-20 18:20:52&todoAbstract=6peyzm&todoAccountName=merle.larkin&spare2=7kcd3q&page=1&todoProcessStatus=uhfw7p&status=h1hhu4&q=g8rhcm&todoModuleId=172&description=7feo5q&bizType=qvhjfv&opTime=2025-10-20 18:26:10&endTime=2025-10-20 18:20:52'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3fwdgp",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get PublicUnionTodo by id. 主键获取统一待办详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/todo/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get PublicUnionTodo by id. 主键获取统一待办详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|主键ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|记录ID|-
└─appId|string|应用ID|-
└─foreignId|string|站点门户ID|-
└─type|string|类型，外部则为OUT|-
└─bizType|string|业务类型|-
└─todoCreateTime|string|待办创建时间|-
└─todoId|string|单据编号|-
└─todoType|string|单据类型|-
└─todoName|string|单据主题|-
└─todoAbstract|string|单据摘要|-
└─todoAccountId|string|待办应用账户ID|-
└─todoAccountName|string|待办应用系统或账户名称|-
└─todoModuleId|string|待办应用应用ID|-
└─todoModuleName|string|待办应用应用名称|-
└─todoUserId|string|待办应用用户ID|-
└─todoUserName|string|待办应用用户名称|-
└─todoOrganId|string|待办应用机构ID|-
└─todoOrganName|string|待办应用机构名称|-
└─todoProcessName|string|待办流程节点名称|-
└─todoProcessStatus|string|待办流程节点状态码|-
└─todoProcessInfo|string|待办流程节点信息|-
└─todoCurrInfo|string|待办业务当前信息|-
└─todoNextInfo|string|待办业务下一步信息|-
└─todoUrl|string|待办业务URL|-
└─todoLabels|string|单据业务标签|-
└─todoContent|string|单据其他信息|-
└─status|string|状态，0待办，1在办，10已办，20办结|-
└─opUserId|string|操作人ID|-
└─opTime|string|操作时间|-
└─opOrganId|string|操作单位ID|-
└─opOrganName|string|操作单位名称|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:10",
    "lastTime": "2025-10-20 18:26:10",
    "id": "172",
    "appId": "172",
    "foreignId": "172",
    "type": "hrppjv",
    "bizType": "538qu9",
    "todoCreateTime": "2025-10-20 18:26:10",
    "todoId": "172",
    "todoType": "zh1kj6",
    "todoName": "merle.larkin",
    "todoAbstract": "22y5e8",
    "todoAccountId": "172",
    "todoAccountName": "merle.larkin",
    "todoModuleId": "172",
    "todoModuleName": "merle.larkin",
    "todoUserId": "172",
    "todoUserName": "merle.larkin",
    "todoOrganId": "172",
    "todoOrganName": "merle.larkin",
    "todoProcessName": "merle.larkin",
    "todoProcessStatus": "d2j9rn",
    "todoProcessInfo": "v896vt",
    "todoCurrInfo": "8dnh7g",
    "todoNextInfo": "zp0r0u",
    "todoUrl": "www.ben-grant.info",
    "todoLabels": "4woa3e",
    "todoContent": "kqmlxo",
    "status": "dbzstl",
    "opUserId": "172",
    "opTime": "2025-10-20 18:26:10",
    "opOrganId": "172",
    "opOrganName": "merle.larkin",
    "description": "a4i739",
    "spare1": "7piw7v",
    "spare2": "mi87e8"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicUnionTodo Operation. 新增统一待办数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/todo/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/json; charset=utf-8

**Description:** PublicUnionTodo Operation. 新增统一待办数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|记录ID|false|-
└─appId|string|应用ID|false|-
└─foreignId|string|站点门户ID|false|-
└─type|string|类型，外部则为OUT|false|-
└─bizType|string|业务类型|false|-
└─todoCreateTime|string|待办创建时间|false|-
└─todoId|string|单据编号|false|-
└─todoType|string|单据类型|false|-
└─todoName|string|单据主题|false|-
└─todoAbstract|string|单据摘要|false|-
└─todoAccountId|string|待办应用账户ID|false|-
└─todoAccountName|string|待办应用系统或账户名称|false|-
└─todoModuleId|string|待办应用应用ID|false|-
└─todoModuleName|string|待办应用应用名称|false|-
└─todoUserId|string|待办应用用户ID|false|-
└─todoUserName|string|待办应用用户名称|false|-
└─todoOrganId|string|待办应用机构ID|false|-
└─todoOrganName|string|待办应用机构名称|false|-
└─todoProcessName|string|待办流程节点名称|false|-
└─todoProcessStatus|string|待办流程节点状态码|false|-
└─todoProcessInfo|string|待办流程节点信息|false|-
└─todoCurrInfo|string|待办业务当前信息|false|-
└─todoNextInfo|string|待办业务下一步信息|false|-
└─todoUrl|string|待办业务URL|false|-
└─todoLabels|string|单据业务标签|false|-
└─todoContent|string|单据其他信息|false|-
└─status|string|状态，0待办，1在办，10已办，20办结|false|-
└─opUserId|string|操作人ID|false|-
└─opTime|string|操作时间|false|-
└─opOrganId|string|操作单位ID|false|-
└─opOrganName|string|操作单位名称|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:10",
    "lastTime": "2025-10-20 18:26:10",
    "id": "172",
    "appId": "172",
    "foreignId": "172",
    "type": "ycpq9b",
    "bizType": "ey8edf",
    "todoCreateTime": "2025-10-20 18:26:10",
    "todoId": "172",
    "todoType": "upi0e3",
    "todoName": "merle.larkin",
    "todoAbstract": "28kh5p",
    "todoAccountId": "172",
    "todoAccountName": "merle.larkin",
    "todoModuleId": "172",
    "todoModuleName": "merle.larkin",
    "todoUserId": "172",
    "todoUserName": "merle.larkin",
    "todoOrganId": "172",
    "todoOrganName": "merle.larkin",
    "todoProcessName": "merle.larkin",
    "todoProcessStatus": "ysahtg",
    "todoProcessInfo": "mn6qoq",
    "todoCurrInfo": "gwwhco",
    "todoNextInfo": "rxo8nz",
    "todoUrl": "www.ben-grant.info",
    "todoLabels": "im55kt",
    "todoContent": "7a66ln",
    "status": "4onqyf",
    "opUserId": "172",
    "opTime": "2025-10-20 18:26:10",
    "opOrganId": "172",
    "opOrganName": "merle.larkin",
    "description": "k1eonb",
    "spare1": "o03nmy",
    "spare2": "rqbjno"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "g0ut5e",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicUnionTodo Operation. 修改统一待办数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/todo/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/json; charset=utf-8

**Description:** PublicUnionTodo Operation. 修改统一待办数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|记录ID|false|-
└─appId|string|应用ID|false|-
└─foreignId|string|站点门户ID|false|-
└─type|string|类型，外部则为OUT|false|-
└─bizType|string|业务类型|false|-
└─todoCreateTime|string|待办创建时间|false|-
└─todoId|string|单据编号|false|-
└─todoType|string|单据类型|false|-
└─todoName|string|单据主题|false|-
└─todoAbstract|string|单据摘要|false|-
└─todoAccountId|string|待办应用账户ID|false|-
└─todoAccountName|string|待办应用系统或账户名称|false|-
└─todoModuleId|string|待办应用应用ID|false|-
└─todoModuleName|string|待办应用应用名称|false|-
└─todoUserId|string|待办应用用户ID|false|-
└─todoUserName|string|待办应用用户名称|false|-
└─todoOrganId|string|待办应用机构ID|false|-
└─todoOrganName|string|待办应用机构名称|false|-
└─todoProcessName|string|待办流程节点名称|false|-
└─todoProcessStatus|string|待办流程节点状态码|false|-
└─todoProcessInfo|string|待办流程节点信息|false|-
└─todoCurrInfo|string|待办业务当前信息|false|-
└─todoNextInfo|string|待办业务下一步信息|false|-
└─todoUrl|string|待办业务URL|false|-
└─todoLabels|string|单据业务标签|false|-
└─todoContent|string|单据其他信息|false|-
└─status|string|状态，0待办，1在办，10已办，20办结|false|-
└─opUserId|string|操作人ID|false|-
└─opTime|string|操作时间|false|-
└─opOrganId|string|操作单位ID|false|-
└─opOrganName|string|操作单位名称|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:10",
    "lastTime": "2025-10-20 18:26:10",
    "id": "172",
    "appId": "172",
    "foreignId": "172",
    "type": "rq3fg8",
    "bizType": "83xx7i",
    "todoCreateTime": "2025-10-20 18:26:10",
    "todoId": "172",
    "todoType": "ffgbcl",
    "todoName": "merle.larkin",
    "todoAbstract": "k8im0d",
    "todoAccountId": "172",
    "todoAccountName": "merle.larkin",
    "todoModuleId": "172",
    "todoModuleName": "merle.larkin",
    "todoUserId": "172",
    "todoUserName": "merle.larkin",
    "todoOrganId": "172",
    "todoOrganName": "merle.larkin",
    "todoProcessName": "merle.larkin",
    "todoProcessStatus": "o9ew21",
    "todoProcessInfo": "3huy3f",
    "todoCurrInfo": "drfq9p",
    "todoNextInfo": "sia5xt",
    "todoUrl": "www.ben-grant.info",
    "todoLabels": "cqjkys",
    "todoContent": "rq95eb",
    "status": "0tsh4h",
    "opUserId": "172",
    "opTime": "2025-10-20 18:26:10",
    "opOrganId": "172",
    "opOrganName": "merle.larkin",
    "description": "2lhkdg",
    "spare1": "svpwlf",
    "spare2": "gvceg8"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "s9of1e",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### PublicUnionTodo Operation. 删除统一待办数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/todo/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-11-19 14:58:52

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** PublicUnionTodo Operation. 删除统一待办数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|主键ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "jmbd4g",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 行政区划管理读写控制类
### Get BaseXzqh list. 获取行政区划管理列表或分页, 返回BaseXzqh对象.
**URL:** https://linlan.net/eframe_backend/api/system/xzqh/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-12-16 16:04:14

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get BaseXzqh list. 获取行政区划管理列表或分页, 返回BaseXzqh对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
parentId|int64|行政区划父节点|false|-
countryId|string|国家或地区编号|false|-
areatypeId|string|地域级别ID|false|-
lft|int32|树左边|false|-
rgt|int32|树右边|false|-
code|string|行政区划代码|false|-
name|string|行政区划名称|false|-
nameTotal|string|行政区划完整名称|false|-
sname|string|行政区划简洁名称|false|-
nameEn|string|名称英文|false|-
searchCode|string|快速码|false|-
isDisplay|boolean|是否显示(1显示0不显示)|false|-
hasContent|boolean|是否有内容(1有内容，编号单位等)|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-
parentIds|array|父节点集合|false|-
areatypeIds|array|父节点集合|false|-
likeQuery|string|父节点集合|false|-
deleteTime|string|删除时间|false|-
ids|array|id集合|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/list.do?limit=10&code=81486&rgt=483&startTime=2025-10-20 18:20:52&likeQuery=7vs2yx&countryId=172&hasContent=true&areatypeId=172&nameTotal=zq0s1a&page=1&endTime=2025-10-20 18:20:52&nameEn=vktshn&parentIds=34i048&parentIds=34i048&description=vbemcg&deleteTime=2025-10-20 18:20:52&q=snzwkq&ids=dmn1n8&ids=dmn1n8&searchCode=81486&lft=529&delFlag=5&orderBy=960&sname=merle.larkin&isDisplay=true&name=merle.larkin&parentId=81&areatypeIds=8ugecz&areatypeIds=8ugecz
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|行政区划编号|-
└─parentId|int64|行政区划父节点|-
└─countryId|string|国家或地区编号|-
└─areatypeId|string|地域级别ID|-
└─lft|int32|树左边|-
└─rgt|int32|树右边|-
└─code|string|行政区划代码|-
└─name|string|行政区划名称|-
└─nameTotal|string|行政区划完整名称|-
└─sname|string|行政区划简洁名称|-
└─nameEn|string|名称英文|-
└─searchCode|string|快速码|-
└─isDisplay|boolean|是否显示(1显示0不显示)|-
└─hasContent|boolean|是否有内容(1有内容，编号单位等)|-
└─priority|int32|排序|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─deleteTime|string|删除时间|-
└─description|string|描述|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:03",
      "lastTime": "2025-10-20 18:26:03",
      "id": 606,
      "parentId": 325,
      "countryId": "172",
      "areatypeId": "172",
      "lft": 218,
      "rgt": 729,
      "code": "81486",
      "name": "merle.larkin",
      "nameTotal": "4t27rt",
      "sname": "merle.larkin",
      "nameEn": "58vdi4",
      "searchCode": "81486",
      "isDisplay": true,
      "hasContent": true,
      "priority": 561,
      "delFlag": 5,
      "deleteTime": "2025-10-20 18:26:03",
      "description": "90iudb"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseXzqh Operation. BaseXzqh数据操作逻辑，导出操作.
**URL:** https://linlan.net/eframe_backend/api/system/xzqh/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 16:04:14

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** BaseXzqh Operation. BaseXzqh数据操作逻辑，导出操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
parentId|int64|行政区划父节点|false|-
countryId|string|国家或地区编号|false|-
areatypeId|string|地域级别ID|false|-
lft|int32|树左边|false|-
rgt|int32|树右边|false|-
code|string|行政区划代码|false|-
name|string|行政区划名称|false|-
nameTotal|string|行政区划完整名称|false|-
sname|string|行政区划简洁名称|false|-
nameEn|string|名称英文|false|-
searchCode|string|快速码|false|-
isDisplay|boolean|是否显示(1显示0不显示)|false|-
hasContent|boolean|是否有内容(1有内容，编号单位等)|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-
parentIds|array|父节点集合|false|-
areatypeIds|array|父节点集合|false|-
likeQuery|string|父节点集合|false|-
deleteTime|string|删除时间|false|-
ids|array|id集合|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/export.do --data 'isDisplay=true&limit=10&q=7yrcn4&delFlag=5&orderBy=857&areatypeId=172&description=mecpas&name=merle.larkin&parentIds=34xn4n&parentIds=34xn4n&areatypeIds=m53ul4&areatypeIds=m53ul4&parentId=542&hasContent=true&deleteTime=2025-10-20 18:20:52&nameTotal=sf4uj1&page=1&lft=278&rgt=371&code=81486&sname=merle.larkin&ids=kab7zu&ids=kab7zu&searchCode=81486&countryId=172&likeQuery=o8tzwb&nameEn=5031f6&startTime=2025-10-20 18:20:52&endTime=2025-10-20 18:20:52'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "f40zyd",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get BaseXzqh by id. 主键获取行政区划管理详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/xzqh/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-12-16 16:04:14

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get BaseXzqh by id. 主键获取行政区划管理详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|行政区划编号|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|行政区划编号|-
└─parentId|int64|行政区划父节点|-
└─countryId|string|国家或地区编号|-
└─areatypeId|string|地域级别ID|-
└─lft|int32|树左边|-
└─rgt|int32|树右边|-
└─code|string|行政区划代码|-
└─name|string|行政区划名称|-
└─nameTotal|string|行政区划完整名称|-
└─sname|string|行政区划简洁名称|-
└─nameEn|string|名称英文|-
└─searchCode|string|快速码|-
└─isDisplay|boolean|是否显示(1显示0不显示)|-
└─hasContent|boolean|是否有内容(1有内容，编号单位等)|-
└─priority|int32|排序|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─deleteTime|string|删除时间|-
└─description|string|描述|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:03",
    "lastTime": "2025-10-20 18:26:03",
    "id": 578,
    "parentId": 393,
    "countryId": "172",
    "areatypeId": "172",
    "lft": 850,
    "rgt": 814,
    "code": "81486",
    "name": "merle.larkin",
    "nameTotal": "ic7h0z",
    "sname": "merle.larkin",
    "nameEn": "2k171h",
    "searchCode": "81486",
    "isDisplay": true,
    "hasContent": true,
    "priority": 393,
    "delFlag": 5,
    "deleteTime": "2025-10-20 18:26:03",
    "description": "aty2b1"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseXzqh Operation. 新增行政区划管理数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/xzqh/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 16:04:14

**Content-Type:** application/json; charset=utf-8

**Description:** BaseXzqh Operation. 新增行政区划管理数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|行政区划编号|false|-
└─parentId|int64|行政区划父节点|false|-
└─countryId|string|国家或地区编号|false|-
└─areatypeId|string|地域级别ID|false|-
└─lft|int32|树左边|false|-
└─rgt|int32|树右边|false|-
└─code|string|行政区划代码|false|-
└─name|string|行政区划名称|false|-
└─nameTotal|string|行政区划完整名称|false|-
└─sname|string|行政区划简洁名称|false|-
└─nameEn|string|名称英文|false|-
└─searchCode|string|快速码|false|-
└─isDisplay|boolean|是否显示(1显示0不显示)|false|-
└─hasContent|boolean|是否有内容(1有内容，编号单位等)|false|-
└─priority|int32|排序|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─deleteTime|string|删除时间|false|-
└─description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:03",
    "lastTime": "2025-10-20 18:26:03",
    "id": 364,
    "parentId": 398,
    "countryId": "172",
    "areatypeId": "172",
    "lft": 287,
    "rgt": 672,
    "code": "81486",
    "name": "merle.larkin",
    "nameTotal": "zs88y0",
    "sname": "merle.larkin",
    "nameEn": "yfh6cr",
    "searchCode": "81486",
    "isDisplay": true,
    "hasContent": true,
    "priority": 556,
    "delFlag": 5,
    "deleteTime": "2025-10-20 18:26:03",
    "description": "eo4h3i"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "d3xsvv",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseXzqh Operation. 修改行政区划管理数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/xzqh/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 16:04:14

**Content-Type:** application/json; charset=utf-8

**Description:** BaseXzqh Operation. 修改行政区划管理数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|行政区划编号|false|-
└─parentId|int64|行政区划父节点|false|-
└─countryId|string|国家或地区编号|false|-
└─areatypeId|string|地域级别ID|false|-
└─lft|int32|树左边|false|-
└─rgt|int32|树右边|false|-
└─code|string|行政区划代码|false|-
└─name|string|行政区划名称|false|-
└─nameTotal|string|行政区划完整名称|false|-
└─sname|string|行政区划简洁名称|false|-
└─nameEn|string|名称英文|false|-
└─searchCode|string|快速码|false|-
└─isDisplay|boolean|是否显示(1显示0不显示)|false|-
└─hasContent|boolean|是否有内容(1有内容，编号单位等)|false|-
└─priority|int32|排序|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─deleteTime|string|删除时间|false|-
└─description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:03",
    "lastTime": "2025-10-20 18:26:03",
    "id": 233,
    "parentId": 68,
    "countryId": "172",
    "areatypeId": "172",
    "lft": 45,
    "rgt": 91,
    "code": "81486",
    "name": "merle.larkin",
    "nameTotal": "jcawbf",
    "sname": "merle.larkin",
    "nameEn": "7ahdqb",
    "searchCode": "81486",
    "isDisplay": true,
    "hasContent": true,
    "priority": 512,
    "delFlag": 5,
    "deleteTime": "2025-10-20 18:26:03",
    "description": "yrtu2j"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "no1hny",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### BaseXzqh Operation. 删除行政区划管理数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/xzqh/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 16:04:14

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** BaseXzqh Operation. 删除行政区划管理数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|行政区划编号:null;1;1,2,3,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "4rgaq8",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 角色分类读写控制类
### Get CoreRoletype list. 获取角色分类列表或分页, 返回CoreRoletype对象.
**URL:** https://linlan.net/eframe_backend/api/system/roletype/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-12-16 10:47:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get CoreRoletype list. 获取角色分类列表或分页, 返回CoreRoletype对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
name|string|角色名称|false|-
type|string|角色类型0全局角色1系统管理角色2应用会员角色|false|-
code|string|角色编码，角色代码|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|角色描述|false|-
existKey|string|existKey|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/list.do?delFlag=5&orderBy=805&name=merle.larkin&code=81486&startTime=2025-10-20 18:20:52&description=zuijw5&existKey=ttqxtz&q=im6u3f&page=1&limit=10&type=1luhfx&endTime=2025-10-20 18:20:52
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|角色分类ID|-
└─name|string|角色名称|-
└─type|string|角色类型0全局角色1系统管理角色2应用会员角色|-
└─code|string|角色编码，角色代码|-
└─priority|int32|重点优先级|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|角色描述|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:05",
      "lastTime": "2025-10-20 18:26:05",
      "id": "172",
      "name": "merle.larkin",
      "type": "evh2g2",
      "code": "81486",
      "priority": 124,
      "delFlag": 5,
      "description": "dcfdpi"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreRoletype Operation. CoreRoletype数据操作逻辑，导出操作.
**URL:** https://linlan.net/eframe_backend/api/system/roletype/export.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 10:47:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** CoreRoletype Operation. CoreRoletype数据操作逻辑，导出操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
name|string|角色名称|false|-
type|string|角色类型0全局角色1系统管理角色2应用会员角色|false|-
code|string|角色编码，角色代码|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|角色描述|false|-
existKey|string|existKey|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/export.do --data 'type=tcp6u1&startTime=2025-10-20 18:20:52&code=81486&endTime=2025-10-20 18:20:52&orderBy=322&existKey=9zubgz&q=mspimc&delFlag=5&name=merle.larkin&limit=10&description=8auh5y&page=1'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3ecifh",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get CoreRoletype by id. 主键获取角色分类详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/roletype/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-12-16 10:47:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get CoreRoletype by id. 主键获取角色分类详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|角色分类ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|角色分类ID|-
└─name|string|角色名称|-
└─type|string|角色类型0全局角色1系统管理角色2应用会员角色|-
└─code|string|角色编码，角色代码|-
└─priority|int32|重点优先级|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|角色描述|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:05",
    "lastTime": "2025-10-20 18:26:05",
    "id": "172",
    "name": "merle.larkin",
    "type": "u6qxx4",
    "code": "81486",
    "priority": 371,
    "delFlag": 5,
    "description": "u13tly"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreRoletype Operation. 新增角色分类数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/roletype/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 10:47:36

**Content-Type:** application/json; charset=utf-8

**Description:** CoreRoletype Operation. 新增角色分类数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|角色分类ID|false|-
└─name|string|角色名称|false|-
└─type|string|角色类型0全局角色1系统管理角色2应用会员角色|false|-
└─code|string|角色编码，角色代码|false|-
└─priority|int32|重点优先级|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|角色描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:05",
    "lastTime": "2025-10-20 18:26:05",
    "id": "172",
    "name": "merle.larkin",
    "type": "4upvcg",
    "code": "81486",
    "priority": 861,
    "delFlag": 5,
    "description": "ylrqgx"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3v1ya5",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreRoletype Operation. 修改角色分类数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/roletype/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 10:47:36

**Content-Type:** application/json; charset=utf-8

**Description:** CoreRoletype Operation. 修改角色分类数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|角色分类ID|false|-
└─name|string|角色名称|false|-
└─type|string|角色类型0全局角色1系统管理角色2应用会员角色|false|-
└─code|string|角色编码，角色代码|false|-
└─priority|int32|重点优先级|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|角色描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:05",
    "lastTime": "2025-10-20 18:26:05",
    "id": "172",
    "name": "merle.larkin",
    "type": "hmb51q",
    "code": "81486",
    "priority": 986,
    "delFlag": 5,
    "description": "8smvr8"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "793ri0",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### CoreRoletype Operation. 删除角色分类数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/roletype/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-12-16 10:47:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** CoreRoletype Operation. 删除角色分类数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|角色分类ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "d1k2e3",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 键值配置信息操作处理
### 获取键值配置列表
**URL:** https://linlan.net/eframe_backend/api/system/parts/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取键值配置列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
cfgKey|string|配置项名称|false|-
cfgValue|string|配置项值|false|-
ids|array|数组|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/list.do?endTime=2025-10-20 18:20:52&page=1&cfgKey=eh6pd2&startTime=2025-10-20 18:20:52&ids=4yvc98&ids=4yvc98&limit=10&q=7f93d5&orderBy=814&cfgValue=8aj99h
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─totalCount|int32|总记录数 the total count|-
└─pageSize|int32|每页记录数 the page size|-
└─totalPage|int32|总页数 the total page|-
└─currPage|int32|当前页数 the current page|-
└─list|array|列表数据 the list|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cfgKey|string|配置项名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cfgValue|string|配置项值|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "totalCount": 964,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cfgKey": "zlysnm",
        "cfgValue": "8d3h9a"
      }
    ]
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 键值配置导出
**URL:** https://linlan.net/eframe_backend/api/system/parts/export.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 键值配置导出

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
cfgKey|string|配置项名称|false|-
cfgValue|string|配置项值|false|-
ids|array|数组|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/export.do --data 'startTime=2025-10-20 18:20:52&limit=10&orderBy=301&q=3kycht&cfgValue=disjza&cfgKey=hyzjmk&endTime=2025-10-20 18:20:52&page=1&ids=m8betg&ids=m8betg'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3duhme",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据参数编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/system/parts/{cfgKey}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据参数编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
cfgKey|string|   配置KEY|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/23dzh1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─cfgKey|string|配置项名称|-
└─cfgValue|string|配置项值|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "cfgKey": "f34w4j",
    "cfgValue": "a26kk1"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增参数配置
**URL:** https://linlan.net/eframe_backend/api/system/parts/save.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增参数配置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─cfgKey|string|配置项名称|false|-
└─cfgValue|string|配置项值|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/save.do --data '{
  "data": {
    "cfgKey": "k3y2l7",
    "cfgValue": "562wge"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "avmcf9",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改参数配置
**URL:** https://linlan.net/eframe_backend/api/system/parts/update.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改参数配置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─cfgKey|string|配置项名称|false|-
└─cfgValue|string|配置项值|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/update.do --data '{
  "data": {
    "cfgKey": "lzyfxf",
    "cfgValue": "ktcalz"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "zre70g",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除参数配置
**URL:** https://linlan.net/eframe_backend/api/system/parts/delete/{cfgKeys}.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除参数配置

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
cfgKeys|array| 配置Keys,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "q6g0wl",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 刷新参数缓存
**URL:** https://linlan.net/eframe_backend/api/system/config/refreshCache.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 刷新参数缓存

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/config/refreshCache.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "kf07su",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 验证码读取操作处理
### 获取验证码
**URL:** https://linlan.net/eframe_backend/api/open/captcha/get.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取验证码

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/api/open/captcha/get.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─captchaEnabled|boolean|是否开启|-
└─uuid|string|UUID|-
└─img|string|图片验证码|-
└─code|string|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "captchaEnabled": true,
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad",
    "img": "g2u1ej",
    "code": "81486"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取消息验证码
**URL:** https://linlan.net/eframe_backend/api/open/message/captcha/get.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取消息验证码

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/api/open/message/captcha/get.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─captchaEnabled|boolean|是否开启|-
└─uuid|string|UUID|-
└─img|string|图片验证码|-
└─code|string|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "captchaEnabled": true,
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad",
    "img": "nw3l6i",
    "code": "81486"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

# 平台扩展接口API
## 代码生成操作处理
### 查询代码生成列表
**URL:** https://linlan.net/eframe_backend/api/tool/gen/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询代码生成列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
tableId|int64|编号|false|-
tableName|string|表名称|true|-
tableComment|string|表描述|true|-
subTableName|string|关联父表的表名|false|-
subTableFkName|string|本表关联父表的外键名|false|-
className|string|实体类名称(首字母大写)|true|-
tplCategory|string|使用的模板（crud单表操作 tree树表操作 sub主子表操作）|false|-
tplWebType|string|前端类型（element-ui模版 element-plus模版）|false|-
packageName|string|生成包路径|true|-
moduleName|string|生成模块名|true|-
businessName|string|生成业务名|true|-
functionName|string|生成功能名|true|-
functionAuthor|string|生成作者|true|-
formColNum|int32|表单布局，单列 双列 三列|false|-
genType|string|生成代码方式（0zip压缩包 1自定义路径）|false|-
genPath|string|生成路径（不填默认项目路径）|false|-
pkColumn|object|主键信息|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─columnId|int64|编号|false|-
└─tableId|int64|归属表编号|false|-
└─columnName|string|列名称|false|-
└─columnComment|string|列描述|false|-
└─columnType|string|列类型|false|-
└─javaType|string|JAVA类型|false|-
└─javaField|string|JAVA字段名|true|-
└─isPk|string|是否主键（1是）|false|-
└─isIncrement|string|是否自增（1是）|false|-
└─isRequired|string|是否必填（1是）|false|-
└─isInsert|string|是否为插入字段（1是）|false|-
└─isEdit|string|是否编辑字段（1是）|false|-
└─isList|string|是否列表字段（1是）|false|-
└─isQuery|string|是否查询字段（1是）|false|-
└─queryType|string|查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围）|false|-
└─htmlType|string|显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件）|false|-
└─dictType|string|字典类型|false|-
└─priority|int32|排序|false|-
columns|array|表列信息|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─columnId|int64|编号|false|-
└─tableId|int64|归属表编号|false|-
└─columnName|string|列名称|false|-
└─columnComment|string|列描述|false|-
└─columnType|string|列类型|false|-
└─javaType|string|JAVA类型|false|-
└─javaField|string|JAVA字段名|true|-
└─isPk|string|是否主键（1是）|false|-
└─isIncrement|string|是否自增（1是）|false|-
└─isRequired|string|是否必填（1是）|false|-
└─isInsert|string|是否为插入字段（1是）|false|-
└─isEdit|string|是否编辑字段（1是）|false|-
└─isList|string|是否列表字段（1是）|false|-
└─isQuery|string|是否查询字段（1是）|false|-
└─queryType|string|查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围）|false|-
└─htmlType|string|显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件）|false|-
└─dictType|string|字典类型|false|-
└─priority|int32|排序|false|-
optionLists|string|其它生成选项|false|-
treeCode|string|树编码字段|false|-
treeParentCode|string|树父编码字段|false|-
treeName|string|树名称字段|false|-
parentMenuId|int64|上级菜单ID字段|false|-
parentMenuName|string|上级菜单名称字段|false|-
Description|string|备注|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
params|map|请求参数|false|-
└─any object|object|any object.|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/list.do?businessName=merle.larkin&pkColumn.createTime=2025-10-20 18:26:11&subTable.columns[0].isEdit=6ngzlj&subTable.columns[0].priority=726&columns[0].isQuery=fdx4wp&parentMenuName=merle.larkin&subTable.optionLists=zwywgs&subTable.subTable.subTableFkName=merle.larkin&pkColumn.javaField=ohm2rc&subTable.columns[0].htmlType=oros42&subTable.subTable.Description=7m1zze&subTable.tplWebType=ejncfb&subTable.treeName=merle.larkin&columns[0].columnName=merle.larkin&columns[0].isIncrement=l5ccr4&subTable.subTable.lastTime=2025-10-20 18:26:11&pkColumn.tableId=580&subTable.subTable.parentMenuName=merle.larkin&pkColumn.columnType=lfryix&subTable.subTable.functionAuthor=Glendora Flatley&subTable.createTime=2025-10-20 18:26:11&subTable.subTable.className=merle.larkin&subTable.subTable.packageName=merle.larkin&limit=10&Description=wddj7c&subTable.pkColumn.queryType=29g9xo&pkColumn.columnName=merle.larkin&optionLists=l2l41o&parentMenuId=348&subTable.subTable.limit=10&pkColumn.isRequired=aetjwe&subTable.pkColumn.columnType=q8mwpb&subTable.columns[0].javaType=4zoce1&subTable.pkColumn.priority=127&columns[0].htmlType=kjzoti&subTable.genPath=j92bmv&pkColumn.lastTime=2025-10-20 18:26:11&pkColumn.isIncrement=8yv2lm&subTable.tableComment=phuy29&subTable.pkColumn.htmlType=4d8v3o&subTable.pkColumn.isRequired=1590nk&creatorId=172&subTable.tableName=merle.larkin&subTable.subTable.functionName=merle.larkin&subTable.pkColumn.isIncrement=umbcdn&subTable.creatorId=172&subTable.subTable.optionLists=4jfrt2&subTable.columns[0].isInsert=e02512&subTable.subTable.tableId=906&columns[0].isRequired=dn5etb&subTable.pkColumn.creatorId=172&columns[0].columnComment=0ti83b&subTable.columns[0].columnId=309&subTable.pkColumn.lastTime=2025-10-20 18:26:11&pkColumn.isInsert=x2cyv4&columns[0].queryType=ojbk6b&subTable.genType=sswle6&subTable.subTable.genType=glq3wg&subTable.pkColumn.isEdit=w5neoa&subTable.columns[0].columnType=4marg0&subTable.columns[0].tableId=300&pkColumn.queryType=yzwxe2&subTable.subTable.moduleName=merle.larkin&subTable.columns[0].lastTime=2025-10-20 18:26:11&subTable.subTable.formColNum=526&subTable.columns[0].isList=hfei53&subTable.pkColumn.javaField=hc3h1u&columns[0].creatorId=172&columns[0].tableId=391&subTable.className=merle.larkin&columns[0].isInsert=ka2b1l&columns[0].dictType=i2o65f&genType=41em9v&tplCategory=5g0x3i&tableName=merle.larkin&subTableFkName=merle.larkin&subTable.pkColumn.tableId=648&className=merle.larkin&subTable.subTable.treeCode=81486&subTable.pkColumn.isList=b4ymx2&subTable.subTable.createTime=2025-10-20 18:26:11&pkColumn.priority=298&subTable.subTable.treeName=merle.larkin&subTable.subTable.creatorId=172&formColNum=949&subTable.subTable.subTableName=merle.larkin&subTable.columns[0].javaField=fw3ag0&columns[0].lastTime=2025-10-20 18:26:11&columns[0].isEdit=1fqsa9&subTable.columns[0].isQuery=ffdohm&treeCode=81486&treeParentCode=81486&subTable.pkColumn.columnComment=p14uax&subTable.subTableFkName=merle.larkin&pkColumn.isPk=i9yf43&subTable.subTable.tableName=merle.larkin&subTable.columns[0].isRequired=hrn1xr&treeName=merle.larkin&subTable.pkColumn.columnName=merle.larkin&pkColumn.isQuery=qeudll&subTable.limit=10&columns[0].javaType=8q5ikz&subTable.subTable.page=1&columns[0].javaField=y9sjmy&subTable.functionName=merle.larkin&subTable.Description=zrvumx&subTable.columns[0].dictType=jvrmoc&subTable.parentMenuName=merle.larkin&subTable.pkColumn.dictType=oapf38&subTable.columns[0].columnName=merle.larkin&subTable.functionAuthor=Glendora Flatley&subTable.columns[0].queryType=d87n2l&packageName=merle.larkin&subTable.parentMenuId=259&subTable.tplCategory=ken4et&subTable.subTable.parentMenuId=463&subTable.pkColumn.createTime=2025-10-20 18:26:11&columns[0].columnId=31&pkColumn.javaType=r8vhc9&functionAuthor=Glendora Flatley&subTable.subTable.businessName=merle.larkin&moduleName=merle.larkin&subTable.subTableName=merle.larkin&tplWebType=kcdgz0&subTable.columns[0].createTime=2025-10-20 18:26:11&subTable.columns[0].columnComment=dxlp39&columns[0].priority=416&tableId=504&page=1&subTable.subTable.treeParentCode=81486&subTable.lastTime=2025-10-20 18:26:11&pkColumn.htmlType=zcz1e9&columns[0].isList=uoy3fd&subTable.columns[0].creatorId=172&subTable.packageName=merle.larkin&columns[0].columnType=c56xrz&pkColumn.columnId=695&subTable.businessName=merle.larkin&pkColumn.isEdit=nu4cgu&subTable.pkColumn.isQuery=6qls34&functionName=merle.larkin&pkColumn.columnComment=5vi1fd&subTable.tableId=142&subTable.pkColumn.isPk=is6jdv&subTable.subTable.tplCategory=2z086t&subTable.subTable.tplWebType=3z5jtr&pkColumn.creatorId=172&tableComment=5e1gg9&subTable.treeParentCode=81486&subTable.page=1&subTable.subTable.genPath=1uo9sn&columns[0].createTime=2025-10-20 18:26:11&lastTime=2025-10-20 18:26:11&subTable.subTable.tableComment=izcciu&pkColumn.isList=rbc483&subTable.columns[0].isPk=hnmg29&genPath=t2hr4r&pkColumn.dictType=4pnx7k&subTable.columns[0].isIncrement=i78idn&columns[0].isPk=hvyxdf&subTable.moduleName=merle.larkin&subTable.treeCode=81486&subTable.pkColumn.columnId=383&subTable.pkColumn.javaType=zu4dj2&subTable.pkColumn.isInsert=aujh2n&subTableName=merle.larkin&subTable.formColNum=719&createTime=2025-10-20 18:26:11
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─tableId|int64|编号|-
└─tableName|string|表名称|-
└─tableComment|string|表描述|-
└─subTableName|string|关联父表的表名|-
└─subTableFkName|string|本表关联父表的外键名|-
└─className|string|实体类名称(首字母大写)|-
└─tplCategory|string|使用的模板（crud单表操作 tree树表操作 sub主子表操作）|-
└─tplWebType|string|前端类型（element-ui模版 element-plus模版）|-
└─packageName|string|生成包路径|-
└─moduleName|string|生成模块名|-
└─businessName|string|生成业务名|-
└─functionName|string|生成功能名|-
└─functionAuthor|string|生成作者|-
└─formColNum|int32|表单布局，单列 双列 三列|-
└─genType|string|生成代码方式（0zip压缩包 1自定义路径）|-
└─genPath|string|生成路径（不填默认项目路径）|-
└─pkColumn|object|主键信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnId|int64|编号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tableId|int64|归属表编号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnName|string|列名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnComment|string|列描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnType|string|列类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─javaType|string|JAVA类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─javaField|string|JAVA字段名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPk|string|是否主键（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isIncrement|string|是否自增（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRequired|string|是否必填（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isInsert|string|是否为插入字段（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isEdit|string|是否编辑字段（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isList|string|是否列表字段（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isQuery|string|是否查询字段（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─queryType|string|查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─htmlType|string|显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dictType|string|字典类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
└─columns|array|表列信息|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnId|int64|编号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tableId|int64|归属表编号|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnName|string|列名称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnComment|string|列描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnType|string|列类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─javaType|string|JAVA类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─javaField|string|JAVA字段名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPk|string|是否主键（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isIncrement|string|是否自增（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRequired|string|是否必填（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isInsert|string|是否为插入字段（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isEdit|string|是否编辑字段（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isList|string|是否列表字段（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isQuery|string|是否查询字段（1是）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─queryType|string|查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─htmlType|string|显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件）|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dictType|string|字典类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
└─optionLists|string|其它生成选项|-
└─treeCode|string|树编码字段|-
└─treeParentCode|string|树父编码字段|-
└─treeName|string|树名称字段|-
└─parentMenuId|int64|上级菜单ID字段|-
└─parentMenuName|string|上级菜单名称字段|-
└─Description|string|备注|-
└─page|int32|分页信息：默认第1页|-
└─limit|int32|分页每页条数，默认10条|-
└─params|map|请求参数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:11",
      "lastTime": "2025-10-20 18:26:11",
      "tableId": 865,
      "tableName": "merle.larkin",
      "tableComment": "nbxc2i",
      "subTableName": "merle.larkin",
      "subTableFkName": "merle.larkin",
      "className": "merle.larkin",
      "tplCategory": "0otyxz",
      "tplWebType": "ndlhb1",
      "packageName": "merle.larkin",
      "moduleName": "merle.larkin",
      "businessName": "merle.larkin",
      "functionName": "merle.larkin",
      "functionAuthor": "Glendora Flatley",
      "formColNum": 382,
      "genType": "f99ll0",
      "genPath": "k5zll7",
      "pkColumn": {
        "creatorId": "172",
        "createTime": "2025-10-20 18:26:11",
        "lastTime": "2025-10-20 18:26:11",
        "columnId": 953,
        "tableId": 142,
        "columnName": "merle.larkin",
        "columnComment": "x19fvj",
        "columnType": "xg6oag",
        "javaType": "yroyde",
        "javaField": "topju2",
        "isPk": "6xpiqq",
        "isIncrement": "75972x",
        "isRequired": "3sgqhi",
        "isInsert": "ve7rqh",
        "isEdit": "t6uyh0",
        "isList": "zehneb",
        "isQuery": "vxnoq1",
        "queryType": "wg5ago",
        "htmlType": "e96fvm",
        "dictType": "uh8ymf",
        "priority": 220
      },
      "subTable": {
        "$ref": "..."
      },
      "columns": [
        {
          "creatorId": "172",
          "createTime": "2025-10-20 18:26:11",
          "lastTime": "2025-10-20 18:26:11",
          "columnId": 699,
          "tableId": 769,
          "columnName": "merle.larkin",
          "columnComment": "fhnbce",
          "columnType": "hvqc16",
          "javaType": "8k2d6x",
          "javaField": "zfpyjk",
          "isPk": "mf49ke",
          "isIncrement": "dma1sc",
          "isRequired": "pq0wiw",
          "isInsert": "cahqr3",
          "isEdit": "3jxpe8",
          "isList": "rc7t2i",
          "isQuery": "7u4gvq",
          "queryType": "wlfzhl",
          "htmlType": "26f28m",
          "dictType": "6r0gjx",
          "priority": 395
        }
      ],
      "optionLists": "lpbtb9",
      "treeCode": "81486",
      "treeParentCode": "81486",
      "treeName": "merle.larkin",
      "parentMenuId": 148,
      "parentMenuName": "merle.larkin",
      "Description": "iizmhg",
      "page": 1,
      "limit": 10,
      "params": {
        "mapKey": {}
      }
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 查询某个表的全部字段
**URL:** https://linlan.net/eframe_backend/api/tool/gen/{tableId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询某个表的全部字段

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tableId|int64|表对象ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/407.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─any object|object|any object.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "mapKey": {
      "waring": "You may use java.util.Object for Map value; doc-generate can't be handle."
    }
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 查询数据库分页
**URL:** https://linlan.net/eframe_backend/api/tool/gen/db/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询数据库分页

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
tableId|int64|编号|false|-
tableName|string|表名称|true|-
tableComment|string|表描述|true|-
subTableName|string|关联父表的表名|false|-
subTableFkName|string|本表关联父表的外键名|false|-
className|string|实体类名称(首字母大写)|true|-
tplCategory|string|使用的模板（crud单表操作 tree树表操作 sub主子表操作）|false|-
tplWebType|string|前端类型（element-ui模版 element-plus模版）|false|-
packageName|string|生成包路径|true|-
moduleName|string|生成模块名|true|-
businessName|string|生成业务名|true|-
functionName|string|生成功能名|true|-
functionAuthor|string|生成作者|true|-
formColNum|int32|表单布局，单列 双列 三列|false|-
genType|string|生成代码方式（0zip压缩包 1自定义路径）|false|-
genPath|string|生成路径（不填默认项目路径）|false|-
pkColumn|object|主键信息|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─columnId|int64|编号|false|-
└─tableId|int64|归属表编号|false|-
└─columnName|string|列名称|false|-
└─columnComment|string|列描述|false|-
└─columnType|string|列类型|false|-
└─javaType|string|JAVA类型|false|-
└─javaField|string|JAVA字段名|true|-
└─isPk|string|是否主键（1是）|false|-
└─isIncrement|string|是否自增（1是）|false|-
└─isRequired|string|是否必填（1是）|false|-
└─isInsert|string|是否为插入字段（1是）|false|-
└─isEdit|string|是否编辑字段（1是）|false|-
└─isList|string|是否列表字段（1是）|false|-
└─isQuery|string|是否查询字段（1是）|false|-
└─queryType|string|查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围）|false|-
└─htmlType|string|显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件）|false|-
└─dictType|string|字典类型|false|-
└─priority|int32|排序|false|-
columns|array|表列信息|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─columnId|int64|编号|false|-
└─tableId|int64|归属表编号|false|-
└─columnName|string|列名称|false|-
└─columnComment|string|列描述|false|-
└─columnType|string|列类型|false|-
└─javaType|string|JAVA类型|false|-
└─javaField|string|JAVA字段名|true|-
└─isPk|string|是否主键（1是）|false|-
└─isIncrement|string|是否自增（1是）|false|-
└─isRequired|string|是否必填（1是）|false|-
└─isInsert|string|是否为插入字段（1是）|false|-
└─isEdit|string|是否编辑字段（1是）|false|-
└─isList|string|是否列表字段（1是）|false|-
└─isQuery|string|是否查询字段（1是）|false|-
└─queryType|string|查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围）|false|-
└─htmlType|string|显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件）|false|-
└─dictType|string|字典类型|false|-
└─priority|int32|排序|false|-
optionLists|string|其它生成选项|false|-
treeCode|string|树编码字段|false|-
treeParentCode|string|树父编码字段|false|-
treeName|string|树名称字段|false|-
parentMenuId|int64|上级菜单ID字段|false|-
parentMenuName|string|上级菜单名称字段|false|-
Description|string|备注|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
params|map|请求参数|false|-
└─any object|object|any object.|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/db/list.do?genPath=p7yu8n&subTable.formColNum=583&subTable.columns[0].priority=257&subTable.subTable.tplWebType=ag9k02&subTable.pkColumn.columnName=merle.larkin&subTable.subTable.treeParentCode=81486&subTable.genType=wq0cgk&subTable.columns[0].isIncrement=9iztac&subTable.columns[0].htmlType=smwc3k&subTable.page=1&columns[0].isPk=rhy0mf&columns[0].isIncrement=zw0b8v&columns[0].dictType=yhtnbo&subTable.columns[0].isEdit=g5fgol&subTable.subTable.moduleName=merle.larkin&subTable.subTable.functionAuthor=Glendora Flatley&subTable.columns[0].javaField=738t2p&pkColumn.createTime=2025-10-20 18:26:11&tplCategory=1zltsy&subTable.pkColumn.priority=985&columns[0].priority=715&Description=km2vt3&subTable.pkColumn.isQuery=4isq95&subTable.subTable.tableId=310&subTable.subTable.businessName=merle.larkin&subTable.tableName=merle.larkin&subTable.columns[0].columnId=792&subTable.columns[0].dictType=4atw38&subTable.pkColumn.columnId=623&columns[0].columnType=9eid5w&pkColumn.isInsert=mpv9fk&columns[0].isQuery=bdttwm&parentMenuName=merle.larkin&pkColumn.columnId=292&subTable.subTable.subTableName=merle.larkin&subTable.columns[0].isRequired=768eg3&pkColumn.priority=978&subTable.moduleName=merle.larkin&subTable.tplWebType=ocjse2&subTable.pkColumn.isRequired=f47ma8&pkColumn.tableId=13&pkColumn.isQuery=uz1z7o&pkColumn.creatorId=172&subTable.pkColumn.tableId=197&subTable.subTable.formColNum=309&subTable.tableComment=tb19rp&columns[0].isEdit=nb3elh&subTable.columns[0].queryType=i8tfjk&createTime=2025-10-20 18:26:11&className=merle.larkin&subTable.subTable.creatorId=172&moduleName=merle.larkin&subTable.pkColumn.isList=z8kpab&subTable.treeName=merle.larkin&pkColumn.isIncrement=u1pr80&subTable.columns[0].tableId=370&treeName=merle.larkin&columns[0].isInsert=zr42tr&genType=26b3di&subTable.pkColumn.isPk=i9pvfl&subTable.subTable.tplCategory=r5d6gk&columns[0].htmlType=xnqrjy&parentMenuId=780&subTable.subTable.className=merle.larkin&subTable.pkColumn.isIncrement=ma1jib&limit=10&pkColumn.javaType=9vkhgh&subTable.createTime=2025-10-20 18:26:11&subTable.businessName=merle.larkin&subTable.columns[0].isInsert=ojirzi&subTable.parentMenuName=merle.larkin&subTable.subTable.subTableFkName=merle.larkin&columns[0].columnComment=cidtp9&columns[0].isRequired=vlewvd&subTable.columns[0].creatorId=172&subTable.columns[0].columnName=merle.larkin&subTable.subTable.createTime=2025-10-20 18:26:11&subTable.subTable.tableComment=3mg9ym&subTable.functionName=merle.larkin&subTable.genPath=3951a3&formColNum=850&pkColumn.isRequired=309i5i&subTable.subTable.lastTime=2025-10-20 18:26:11&columns[0].columnId=803&columns[0].isList=mjvacv&subTable.treeCode=81486&tableComment=u71k4d&subTable.columns[0].lastTime=2025-10-20 18:26:11&subTable.pkColumn.createTime=2025-10-20 18:26:11&businessName=merle.larkin&subTable.columns[0].isList=mqwcxn&subTable.pkColumn.lastTime=2025-10-20 18:26:11&subTable.pkColumn.javaField=wgk7x6&subTable.functionAuthor=Glendora Flatley&packageName=merle.larkin&subTable.creatorId=172&subTable.pkColumn.creatorId=172&subTable.columns[0].javaType=uoze2z&subTable.subTable.parentMenuId=76&pkColumn.columnComment=luzdga&subTable.pkColumn.javaType=xbju61&subTable.columns[0].columnComment=i19q1z&pkColumn.dictType=mypvlv&subTable.columns[0].isQuery=cjykw1&subTable.columns[0].columnType=o1axsa&columns[0].lastTime=2025-10-20 18:26:11&subTable.subTable.treeName=merle.larkin&subTable.packageName=merle.larkin&subTable.pkColumn.columnComment=8eyde9&subTableFkName=merle.larkin&subTable.subTable.optionLists=74371r&subTable.className=merle.larkin&functionName=merle.larkin&functionAuthor=Glendora Flatley&pkColumn.isPk=3zfb19&subTable.pkColumn.columnType=cn2pl1&subTable.pkColumn.isInsert=16o4ip&subTable.tplCategory=e89yzl&columns[0].javaField=lbnzja&lastTime=2025-10-20 18:26:11&subTable.subTable.Description=mywff4&subTable.subTable.tableName=merle.larkin&columns[0].queryType=uxhlbo&pkColumn.queryType=47fm8j&pkColumn.htmlType=4hptno&pkColumn.columnType=5j1h3f&subTable.pkColumn.isEdit=85gyqz&subTable.subTable.page=1&page=1&columns[0].javaType=ww273s&subTable.optionLists=01hcxj&treeParentCode=81486&creatorId=172&columns[0].creatorId=172&tableId=273&subTable.subTable.genPath=bccowt&subTable.limit=10&treeCode=81486&columns[0].createTime=2025-10-20 18:26:11&subTable.lastTime=2025-10-20 18:26:11&pkColumn.columnName=merle.larkin&pkColumn.isEdit=0jnguk&pkColumn.lastTime=2025-10-20 18:26:11&subTable.Description=levkls&subTable.tableId=545&subTable.columns[0].createTime=2025-10-20 18:26:11&subTable.subTableName=merle.larkin&subTable.pkColumn.dictType=pbf3y7&pkColumn.javaField=7vjiqg&subTable.parentMenuId=696&columns[0].tableId=275&subTable.pkColumn.htmlType=mi1v3h&subTable.subTable.packageName=merle.larkin&tplWebType=monlgb&subTable.subTable.genType=1dwk3w&subTable.subTable.parentMenuName=merle.larkin&subTable.subTable.limit=10&subTable.treeParentCode=81486&columns[0].columnName=merle.larkin&optionLists=164nf1&subTable.subTable.functionName=merle.larkin&subTable.subTable.treeCode=81486&tableName=merle.larkin&pkColumn.isList=baifrw&subTable.pkColumn.queryType=o8squb&subTableName=merle.larkin&subTable.columns[0].isPk=4q9dax&subTable.subTableFkName=merle.larkin
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─size|int32|No comments found.|-
└─stackTrace|string|No comments found.|-
└─pageNum|int32|No comments found.|-
└─pageSize|int32|No comments found.|-
└─startRow|int64|No comments found.|-
└─endRow|int64|No comments found.|-
└─total|int64|No comments found.|-
└─pages|int32|No comments found.|-
└─count|boolean|No comments found.|-
└─reasonable|boolean|No comments found.|-
└─pageSizeZero|boolean|No comments found.|-
└─countColumn|string|No comments found.|-
└─orderBy|string|No comments found.|-
└─orderByOnly|boolean|No comments found.|-
└─boundSqlInterceptor|object|No comments found.|-
└─dialectClass|string|No comments found.|-
└─keepOrderBy|boolean|No comments found.|-
└─keepSubSelectOrderBy|boolean|No comments found.|-
└─asyncCount|boolean|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "size": 10,
    "stackTrace": "8lix4m",
    "pageNum": 810,
    "pageSize": 10,
    "startRow": 458,
    "endRow": 139,
    "total": 220,
    "pages": 658,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "397phv",
    "orderBy": "q5rtjm",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "bu6uue",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 查询数据表字段列表
**URL:** https://linlan.net/eframe_backend/api/tool/gen/column/{tableId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询数据表字段列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tableId|int64|表对象ID|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/column/{tableId}.do?tableId=446
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─columnId|int64|编号|-
└─tableId|int64|归属表编号|-
└─columnName|string|列名称|-
└─columnComment|string|列描述|-
└─columnType|string|列类型|-
└─javaType|string|JAVA类型|-
└─javaField|string|JAVA字段名|-
└─isPk|string|是否主键（1是）|-
└─isIncrement|string|是否自增（1是）|-
└─isRequired|string|是否必填（1是）|-
└─isInsert|string|是否为插入字段（1是）|-
└─isEdit|string|是否编辑字段（1是）|-
└─isList|string|是否列表字段（1是）|-
└─isQuery|string|是否查询字段（1是）|-
└─queryType|string|查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围）|-
└─htmlType|string|显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件）|-
└─dictType|string|字典类型|-
└─priority|int32|排序|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:11",
      "lastTime": "2025-10-20 18:26:11",
      "columnId": 406,
      "tableId": 69,
      "columnName": "merle.larkin",
      "columnComment": "j48gu4",
      "columnType": "txeima",
      "javaType": "190rwb",
      "javaField": "ske92j",
      "isPk": "f9evsa",
      "isIncrement": "u8mxiy",
      "isRequired": "yz33jo",
      "isInsert": "sqsmc6",
      "isEdit": "himpdh",
      "isList": "jab3lx",
      "isQuery": "xr4ynv",
      "queryType": "djpeoo",
      "htmlType": "rj4ius",
      "dictType": "v4r1gn",
      "priority": 187
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 导入表结构（保存）
**URL:** https://linlan.net/eframe_backend/api/tool/gen/importTable.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 导入表结构（保存）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tables|string|表名称前缀|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/importTable.do --data 'tables=fl2a6a'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "8xeu3p",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 创建表结构（保存）
**URL:** https://linlan.net/eframe_backend/api/tool/gen/createTable.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 创建表结构（保存）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
sql|string|  SQL脚本|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/createTable.do --data 'sql=kqgty4'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "qq2w2o",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改保存代码生成业务
**URL:** https://linlan.net/eframe_backend/api/tool/gen.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改保存代码生成业务

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─tableId|int64|编号|false|-
└─tableName|string|表名称|true|-
└─tableComment|string|表描述|true|-
└─subTableName|string|关联父表的表名|false|-
└─subTableFkName|string|本表关联父表的外键名|false|-
└─className|string|实体类名称(首字母大写)|true|-
└─tplCategory|string|使用的模板（crud单表操作 tree树表操作 sub主子表操作）|false|-
└─tplWebType|string|前端类型（element-ui模版 element-plus模版）|false|-
└─packageName|string|生成包路径|true|-
└─moduleName|string|生成模块名|true|-
└─businessName|string|生成业务名|true|-
└─functionName|string|生成功能名|true|-
└─functionAuthor|string|生成作者|true|-
└─formColNum|int32|表单布局，单列 双列 三列|false|-
└─genType|string|生成代码方式（0zip压缩包 1自定义路径）|false|-
└─genPath|string|生成路径（不填默认项目路径）|false|-
└─pkColumn|object|主键信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnId|int64|编号|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tableId|int64|归属表编号|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnName|string|列名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnComment|string|列描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnType|string|列类型|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─javaType|string|JAVA类型|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─javaField|string|JAVA字段名|true|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPk|string|是否主键（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isIncrement|string|是否自增（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRequired|string|是否必填（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isInsert|string|是否为插入字段（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isEdit|string|是否编辑字段（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isList|string|是否列表字段（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isQuery|string|是否查询字段（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─queryType|string|查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─htmlType|string|显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dictType|string|字典类型|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|false|-
└─columns|array|表列信息|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─creatorId|string|创建人id|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastTime|string|最后修改时间|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnId|int64|编号|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─tableId|int64|归属表编号|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnName|string|列名称|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnComment|string|列描述|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─columnType|string|列类型|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─javaType|string|JAVA类型|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─javaField|string|JAVA字段名|true|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isPk|string|是否主键（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isIncrement|string|是否自增（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isRequired|string|是否必填（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isInsert|string|是否为插入字段（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isEdit|string|是否编辑字段（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isList|string|是否列表字段（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isQuery|string|是否查询字段（1是）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─queryType|string|查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─htmlType|string|显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件）|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dictType|string|字典类型|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|false|-
└─optionLists|string|其它生成选项|false|-
└─treeCode|string|树编码字段|false|-
└─treeParentCode|string|树父编码字段|false|-
└─treeName|string|树名称字段|false|-
└─parentMenuId|int64|上级菜单ID字段|false|-
└─parentMenuName|string|上级菜单名称字段|false|-
└─Description|string|备注|false|-
└─page|int32|分页信息：默认第1页|false|-
└─limit|int32|分页每页条数，默认10条|false|-
└─params|map|请求参数|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:26:11",
    "lastTime": "2025-10-20 18:26:11",
    "tableId": 53,
    "tableName": "merle.larkin",
    "tableComment": "f8p6oj",
    "subTableName": "merle.larkin",
    "subTableFkName": "merle.larkin",
    "className": "merle.larkin",
    "tplCategory": "ffzssv",
    "tplWebType": "edbozp",
    "packageName": "merle.larkin",
    "moduleName": "merle.larkin",
    "businessName": "merle.larkin",
    "functionName": "merle.larkin",
    "functionAuthor": "Glendora Flatley",
    "formColNum": 206,
    "genType": "drzhr1",
    "genPath": "9gff0f",
    "pkColumn": {
      "creatorId": "172",
      "createTime": "2025-10-20 18:26:11",
      "lastTime": "2025-10-20 18:26:11",
      "columnId": 526,
      "tableId": 754,
      "columnName": "merle.larkin",
      "columnComment": "fnq2hg",
      "columnType": "8ipskh",
      "javaType": "vz1usm",
      "javaField": "6vdbyj",
      "isPk": "8ss98u",
      "isIncrement": "da3qo5",
      "isRequired": "7ams35",
      "isInsert": "c7t8zd",
      "isEdit": "dezjrh",
      "isList": "cxarp8",
      "isQuery": "18myj8",
      "queryType": "9dcdtj",
      "htmlType": "afd460",
      "dictType": "witdhh",
      "priority": 97
    },
    "subTable": {
      "$ref": "..."
    },
    "columns": [
      {
        "creatorId": "172",
        "createTime": "2025-10-20 18:26:11",
        "lastTime": "2025-10-20 18:26:11",
        "columnId": 532,
        "tableId": 239,
        "columnName": "merle.larkin",
        "columnComment": "rfq9rv",
        "columnType": "pri4fl",
        "javaType": "fbsmov",
        "javaField": "7o7jdb",
        "isPk": "vnl8kv",
        "isIncrement": "hu1wky",
        "isRequired": "j8f1c9",
        "isInsert": "7gry0o",
        "isEdit": "49g4k5",
        "isList": "cs644w",
        "isQuery": "6pfqyp",
        "queryType": "tlb7oy",
        "htmlType": "aaix0r",
        "dictType": "56x5qj",
        "priority": 123
      }
    ],
    "optionLists": "qpzln1",
    "treeCode": "81486",
    "treeParentCode": "81486",
    "treeName": "merle.larkin",
    "parentMenuId": 78,
    "parentMenuName": "merle.larkin",
    "Description": "fzkws1",
    "page": 1,
    "limit": 10,
    "params": {
      "mapKey": {}
    }
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "akqx33",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除代码生成
**URL:** https://linlan.net/eframe_backend/api/tool/gen/{tableIds}.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除代码生成

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tableIds|array| 表名Ids,[array of int64]|true|

**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "b7ga45",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 预览代码
**URL:** https://linlan.net/eframe_backend/api/tool/gen/preview/{tableId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 预览代码

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tableId|int64|表对象ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/preview/894.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "mapKey1": "vqeeum",
    "mapKey2": "y20r6d"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 生成代码（下载方式）
**URL:** https://linlan.net/eframe_backend/api/tool/gen/download/{tableName}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 生成代码（下载方式）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tableName|string|表名称|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/download/merle.larkin.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "sz4b4f",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 生成代码（自定义路径）
**URL:** https://linlan.net/eframe_backend/api/tool/gen/genCode/{tableName}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 生成代码（自定义路径）

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tableName|string|表名称|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/genCode/merle.larkin.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "6wrcvj",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 同步数据库
**URL:** https://linlan.net/eframe_backend/api/tool/gen/synchDb/{tableName}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 同步数据库

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tableName|string|表名称|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/synchDb/merle.larkin.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "x19i8d",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 批量生成代码
**URL:** https://linlan.net/eframe_backend/api/tool/gen/batchGenCode.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 批量生成代码

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
tables|string|   表名称前缀|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/batchGenCode.do?tables=bng9j3
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "lrmn4z",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 会员用户令牌读写控制类
### Get ThirdMemberToken list. 获取会员用户令牌列表或分页, 返回ThirdMemberToken对象.
**URL:** https://linlan.net/eframe_backend/api/third/token/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get ThirdMemberToken list. 获取会员用户令牌列表或分页, 返回ThirdMemberToken对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|int64|主键ID|false|-
token|string|令牌TOKEN|false|-
foreignId|string|前台应用或站点ID|false|-
username|string|用户名|false|-
loginIp|string|登录IP|false|-
updateTime|string|更新时间|false|-
expireTime|string|过期时间|false|-
description|string|备注|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/token/list.do?q=dleqvk&foreignId=172&id=127&expireTime=2025-10-20 18:25:53&endTime=2025-10-20 18:20:52&limit=10&description=nqvs3q&page=1&orderBy=502&startTime=2025-10-20 18:20:52&username=merle.larkin&updateTime=2025-10-20 18:25:53&loginIp=137.119.212.174&token=9kt1ga
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|主键ID|-
└─userId|string|用户ID|-
└─token|string|令牌TOKEN|-
└─foreignId|string|前台应用或站点ID|-
└─username|string|用户名|-
└─loginIp|string|登录IP|-
└─updateTime|string|更新时间|-
└─expireTime|string|过期时间|-
└─description|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:53",
      "lastTime": "2025-10-20 18:25:53",
      "id": 806,
      "userId": "172",
      "token": "40yaac",
      "foreignId": "172",
      "username": "merle.larkin",
      "loginIp": "137.119.212.174",
      "updateTime": "2025-10-20 18:25:53",
      "expireTime": "2025-10-20 18:25:53",
      "description": "wx78no"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### ThirdMemberToken Operation. 删除会员用户令牌数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/third/token/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** ThirdMemberToken Operation. 删除会员用户令牌数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|主键ID:null;1;1,2,3,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/token/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "lv1n2i",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 短信发送记录读写控制类
### Get SmsSendRecord list. 获取短信发送记录列表或分页, 返回SmsSendRecord对象.
**URL:** https://linlan.net/eframe_backend/api/store/smssendrecord/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-15 14:07:47

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get SmsSendRecord list. 获取短信发送记录列表或分页, 返回SmsSendRecord对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|int64|主键ID|false|-
appId|string|应用ID|false|-
providerId|string|短信提供商ID，平台ID|false|-
providerName|string|短信提供商名称，平台名称|false|-
foreignId|string|外键ID|false|-
receiverMobile|string|接收人手机号|false|-
receiverName|string|接收人|false|-
bizType|string|消息类型|false|-
bizSubtype|string|信息子类型|false|-
content|string|信息内容|false|-
msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
status|string|信息状态|false|-
sendTime|string|发送时间|false|-
sendStatus|string|发送状态(0草稿1已发)|false|-
returnTime|string|返回时间|false|-
returnInfo|string|返回结果|false|-
creatorId|string|创建者ID|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/smssendrecord/list.do?q=5nv2ay&receiverMobile=(415) 540-6962&bizType=vzb3fy&creatorId=172&id=967&sendTime=2025-10-20&endTime=2025-10-20 18:20:52&orderBy=539&receiverName=merle.larkin&providerId=172&spare2=kgt2fv&delFlag=5&providerName=merle.larkin&content=gke713&limit=10&returnTime=2025-10-20 18:25:52&foreignId=172&appId=172&returnInfo=modptn&description=c83t4o&spare1=l1ubdh&page=1&startTime=2025-10-20 18:20:52&msgUrl=www.ben-grant.info&status=o7m5n9&bizSubtype=ggo9zi&sendStatus=t27d1n
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|主键ID|-
└─appId|string|应用ID|-
└─providerId|string|短信提供商ID，平台ID|-
└─providerName|string|短信提供商名称，平台名称|-
└─foreignId|string|外键ID|-
└─receiverMobile|string|接收人手机号|-
└─receiverName|string|接收人|-
└─bizType|string|消息类型|-
└─bizSubtype|string|信息子类型|-
└─content|string|信息内容|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|-
└─status|string|信息状态|-
└─sendTime|string|发送时间|-
└─sendStatus|string|发送状态(0草稿1已发)|-
└─returnTime|string|返回时间|-
└─returnInfo|string|返回结果|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:52",
      "lastTime": "2025-10-20 18:25:52",
      "id": 438,
      "appId": "172",
      "providerId": "172",
      "providerName": "merle.larkin",
      "foreignId": "172",
      "receiverMobile": "(415) 540-6962",
      "receiverName": "merle.larkin",
      "bizType": "wzp7px",
      "bizSubtype": "5yfnyn",
      "content": "4uqbi3",
      "msgUrl": "www.ben-grant.info",
      "status": "vv0t4z",
      "sendTime": "2025-10-20",
      "sendStatus": "m2g6sv",
      "returnTime": "2025-10-20 18:25:52",
      "returnInfo": "covbtf",
      "delFlag": 5,
      "description": "67kh0f",
      "spare1": "0vm6qu",
      "spare2": "isucvy"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get SmsSendRecord by id. 主键获取短信发送记录详细信息.
**URL:** https://linlan.net/eframe_backend/api/store/smssendrecord/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-15 14:07:47

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get SmsSendRecord by id. 主键获取短信发送记录详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|主键ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/smssendrecord/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|主键ID|-
└─appId|string|应用ID|-
└─providerId|string|短信提供商ID，平台ID|-
└─providerName|string|短信提供商名称，平台名称|-
└─foreignId|string|外键ID|-
└─receiverMobile|string|接收人手机号|-
└─receiverName|string|接收人|-
└─bizType|string|消息类型|-
└─bizSubtype|string|信息子类型|-
└─content|string|信息内容|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|-
└─status|string|信息状态|-
└─sendTime|string|发送时间|-
└─sendStatus|string|发送状态(0草稿1已发)|-
└─returnTime|string|返回时间|-
└─returnInfo|string|返回结果|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:52",
    "lastTime": "2025-10-20 18:25:52",
    "id": 553,
    "appId": "172",
    "providerId": "172",
    "providerName": "merle.larkin",
    "foreignId": "172",
    "receiverMobile": "(415) 540-6962",
    "receiverName": "merle.larkin",
    "bizType": "jbyejq",
    "bizSubtype": "e113zk",
    "content": "kisp8h",
    "msgUrl": "www.ben-grant.info",
    "status": "i2gs7y",
    "sendTime": "2025-10-20",
    "sendStatus": "7dv2h2",
    "returnTime": "2025-10-20 18:25:52",
    "returnInfo": "u4zo6w",
    "delFlag": 5,
    "description": "t1bfpq",
    "spare1": "8x6j0s",
    "spare2": "y3bvkl"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### SmsSendRecord Operation. 新增短信发送记录数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/store/smssendrecord/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-15 14:07:47

**Content-Type:** application/json; charset=utf-8

**Description:** SmsSendRecord Operation. 新增短信发送记录数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|主键ID|false|-
└─appId|string|应用ID|false|-
└─providerId|string|短信提供商ID，平台ID|false|-
└─providerName|string|短信提供商名称，平台名称|false|-
└─foreignId|string|外键ID|false|-
└─receiverMobile|string|接收人手机号|false|-
└─receiverName|string|接收人|false|-
└─bizType|string|消息类型|false|-
└─bizSubtype|string|信息子类型|false|-
└─content|string|信息内容|false|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
└─status|string|信息状态|false|-
└─sendTime|string|发送时间|false|-
└─sendStatus|string|发送状态(0草稿1已发)|false|-
└─returnTime|string|返回时间|false|-
└─returnInfo|string|返回结果|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/smssendrecord/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:52",
    "lastTime": "2025-10-20 18:25:52",
    "id": 888,
    "appId": "172",
    "providerId": "172",
    "providerName": "merle.larkin",
    "foreignId": "172",
    "receiverMobile": "(415) 540-6962",
    "receiverName": "merle.larkin",
    "bizType": "h3881m",
    "bizSubtype": "mbxltg",
    "content": "c8d7li",
    "msgUrl": "www.ben-grant.info",
    "status": "8sxp2g",
    "sendTime": "2025-10-20",
    "sendStatus": "oqaa37",
    "returnTime": "2025-10-20 18:25:52",
    "returnInfo": "3wc59w",
    "delFlag": 5,
    "description": "pu06ao",
    "spare1": "84k8zm",
    "spare2": "rnsp4b"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "s7chbl",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### SmsSendRecord Operation. 修改短信发送记录数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/store/smssendrecord/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-15 14:07:47

**Content-Type:** application/json; charset=utf-8

**Description:** SmsSendRecord Operation. 修改短信发送记录数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|主键ID|false|-
└─appId|string|应用ID|false|-
└─providerId|string|短信提供商ID，平台ID|false|-
└─providerName|string|短信提供商名称，平台名称|false|-
└─foreignId|string|外键ID|false|-
└─receiverMobile|string|接收人手机号|false|-
└─receiverName|string|接收人|false|-
└─bizType|string|消息类型|false|-
└─bizSubtype|string|信息子类型|false|-
└─content|string|信息内容|false|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
└─status|string|信息状态|false|-
└─sendTime|string|发送时间|false|-
└─sendStatus|string|发送状态(0草稿1已发)|false|-
└─returnTime|string|返回时间|false|-
└─returnInfo|string|返回结果|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/smssendrecord/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:52",
    "lastTime": "2025-10-20 18:25:52",
    "id": 953,
    "appId": "172",
    "providerId": "172",
    "providerName": "merle.larkin",
    "foreignId": "172",
    "receiverMobile": "(415) 540-6962",
    "receiverName": "merle.larkin",
    "bizType": "1a2lbq",
    "bizSubtype": "uemetf",
    "content": "wfqxfx",
    "msgUrl": "www.ben-grant.info",
    "status": "ms3ssv",
    "sendTime": "2025-10-20",
    "sendStatus": "rg5tin",
    "returnTime": "2025-10-20 18:25:52",
    "returnInfo": "bxvvzj",
    "delFlag": 5,
    "description": "ev2gq7",
    "spare1": "1gfs5f",
    "spare2": "hl25zd"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "fkqcxv",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### SmsSendRecord Operation. 删除短信发送记录数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/store/smssendrecord/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-15 14:07:47

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** SmsSendRecord Operation. 删除短信发送记录数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|主键ID:null;1;1,2,3,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/smssendrecord/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "89y2lu",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 短信邮箱登录验证
### 短信邮箱登录方法
**URL:** https://linlan.net/eframe_backend/login/sms.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 短信邮箱登录方法

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─mobile|string|手机号码|false|-
└─code|string|验证码|false|-
└─uuid|string|唯一标识|false|-
└─appId|string|所在应用ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/sms.do --data '{
  "data": {
    "mobile": "(415) 540-6962",
    "code": "81486",
    "uuid": "9bbea0fa-1409-4914-9b7e-342924ed57ad",
    "appId": "172"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─userId|string|用户ID|-
└─token|string|令牌TOKEN|-
└─updateTime|string|更新时间|-
└─expireTime|string|过期时间|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "userId": "172",
    "token": "6zngnj",
    "updateTime": "2025-10-20 18:25:53",
    "expireTime": "2025-10-20 18:25:53"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 登录发送短信验证码
**URL:** https://linlan.net/eframe_backend/login/otp/send.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 登录发送短信验证码

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
mobile|string|手机号码|false|-

**Request-example:**
```
curl -X POST -k -i https://linlan.net/eframe_backend/login/otp/send.do --data 'mobile=(415) 540-6962'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "1x9n86",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 第三方用户读写控制类
### Get ThirdMember list. 获取第三方用户列表或分页, 返回ThirdMember对象.
**URL:** https://linlan.net/eframe_backend/api/third/member/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get ThirdMember list. 获取第三方用户列表或分页, 返回ThirdMember对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|int64|主键ID|false|-
organId|string|机构ID|false|-
foreignId|string|外键ID，人口库ID|false|-
accountId|string|身份提供商ID|false|-
serverType|string|开放平台认证平台类型|false|-
unionId|string|三方全局D|false|-
openId|string|开放平台ID|false|-
email|string|邮箱|false|-
areaCode|string|手机号对应的国家号|false|-
mobile|string|电话号码|false|-
nickName|string|昵称|false|-
avatarUrl|string|头像|false|-
additionInfo|string|附加信息|false|-
creatorId|string|创建人ID|false|-
delFlag|int32|删除标记，0未删除1已删除|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/member/list.do?creatorId=172&spare1=jntzs9&spare2=7xdt0w&delFlag=5&additionInfo=d02jrr&unionId=172&email=vivian.streich@hotmail.com&page=1&accountId=172&serverType=pk83en&limit=10&avatarUrl=www.ben-grant.info&areaCode=81486&mobile=(415) 540-6962&nickName=renna.dibbert&id=660&description=eby0cg&organId=172&foreignId=172&endTime=2025-10-20 18:20:52&startTime=2025-10-20 18:20:52&openId=172&q=5q0l26&orderBy=529
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|主键ID|-
└─userId|string|用户ID|-
└─organId|string|机构ID|-
└─foreignId|string|外键ID，人口库ID|-
└─accountId|string|身份提供商ID|-
└─serverType|string|开放平台认证平台类型|-
└─unionId|string|三方全局D|-
└─openId|string|开放平台ID|-
└─email|string|邮箱|-
└─areaCode|string|手机号对应的国家号|-
└─mobile|string|电话号码|-
└─nickName|string|昵称|-
└─avatarUrl|string|头像|-
└─additionInfo|string|附加信息|-
└─delFlag|int32|删除标记，0未删除1已删除|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:53",
      "lastTime": "2025-10-20 18:25:53",
      "id": 916,
      "userId": "172",
      "organId": "172",
      "foreignId": "172",
      "accountId": "172",
      "serverType": "4dyp0o",
      "unionId": "172",
      "openId": "172",
      "email": "vivian.streich@hotmail.com",
      "areaCode": "81486",
      "mobile": "(415) 540-6962",
      "nickName": "renna.dibbert",
      "avatarUrl": "www.ben-grant.info",
      "additionInfo": "ymubnd",
      "delFlag": 5,
      "description": "wn0o0z",
      "spare1": "pojlv4",
      "spare2": "z2ypil"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get ThirdMember by id. 主键获取第三方用户详细信息.
**URL:** https://linlan.net/eframe_backend/api/third/member/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get ThirdMember by id. 主键获取第三方用户详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|主键ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/member/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|主键ID|-
└─userId|string|用户ID|-
└─organId|string|机构ID|-
└─foreignId|string|外键ID，人口库ID|-
└─accountId|string|身份提供商ID|-
└─serverType|string|开放平台认证平台类型|-
└─unionId|string|三方全局D|-
└─openId|string|开放平台ID|-
└─email|string|邮箱|-
└─areaCode|string|手机号对应的国家号|-
└─mobile|string|电话号码|-
└─nickName|string|昵称|-
└─avatarUrl|string|头像|-
└─additionInfo|string|附加信息|-
└─delFlag|int32|删除标记，0未删除1已删除|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:53",
    "lastTime": "2025-10-20 18:25:53",
    "id": 399,
    "userId": "172",
    "organId": "172",
    "foreignId": "172",
    "accountId": "172",
    "serverType": "8c2am7",
    "unionId": "172",
    "openId": "172",
    "email": "vivian.streich@hotmail.com",
    "areaCode": "81486",
    "mobile": "(415) 540-6962",
    "nickName": "renna.dibbert",
    "avatarUrl": "www.ben-grant.info",
    "additionInfo": "ts5es0",
    "delFlag": 5,
    "description": "zjf0uz",
    "spare1": "lbd03c",
    "spare2": "mnbcqj"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### ThirdMember Operation. 新增第三方用户数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/third/member/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/json; charset=utf-8

**Description:** ThirdMember Operation. 新增第三方用户数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|主键ID|false|-
└─userId|string|用户ID|false|-
└─organId|string|机构ID|false|-
└─foreignId|string|外键ID，人口库ID|false|-
└─accountId|string|身份提供商ID|false|-
└─serverType|string|开放平台认证平台类型|false|-
└─unionId|string|三方全局D|false|-
└─openId|string|开放平台ID|false|-
└─email|string|邮箱|false|-
└─areaCode|string|手机号对应的国家号|false|-
└─mobile|string|电话号码|false|-
└─nickName|string|昵称|false|-
└─avatarUrl|string|头像|false|-
└─additionInfo|string|附加信息|false|-
└─delFlag|int32|删除标记，0未删除1已删除|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/member/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:53",
    "lastTime": "2025-10-20 18:25:53",
    "id": 689,
    "userId": "172",
    "organId": "172",
    "foreignId": "172",
    "accountId": "172",
    "serverType": "a679cn",
    "unionId": "172",
    "openId": "172",
    "email": "vivian.streich@hotmail.com",
    "areaCode": "81486",
    "mobile": "(415) 540-6962",
    "nickName": "renna.dibbert",
    "avatarUrl": "www.ben-grant.info",
    "additionInfo": "2fc9kk",
    "delFlag": 5,
    "description": "ifizr9",
    "spare1": "lmwvvm",
    "spare2": "cpd39r"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "gw19sh",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### ThirdMember Operation. 修改第三方用户数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/third/member/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/json; charset=utf-8

**Description:** ThirdMember Operation. 修改第三方用户数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|主键ID|false|-
└─userId|string|用户ID|false|-
└─organId|string|机构ID|false|-
└─foreignId|string|外键ID，人口库ID|false|-
└─accountId|string|身份提供商ID|false|-
└─serverType|string|开放平台认证平台类型|false|-
└─unionId|string|三方全局D|false|-
└─openId|string|开放平台ID|false|-
└─email|string|邮箱|false|-
└─areaCode|string|手机号对应的国家号|false|-
└─mobile|string|电话号码|false|-
└─nickName|string|昵称|false|-
└─avatarUrl|string|头像|false|-
└─additionInfo|string|附加信息|false|-
└─delFlag|int32|删除标记，0未删除1已删除|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/member/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:53",
    "lastTime": "2025-10-20 18:25:53",
    "id": 470,
    "userId": "172",
    "organId": "172",
    "foreignId": "172",
    "accountId": "172",
    "serverType": "uso9lb",
    "unionId": "172",
    "openId": "172",
    "email": "vivian.streich@hotmail.com",
    "areaCode": "81486",
    "mobile": "(415) 540-6962",
    "nickName": "renna.dibbert",
    "avatarUrl": "www.ben-grant.info",
    "additionInfo": "87on7d",
    "delFlag": 5,
    "description": "4743bq",
    "spare1": "q7408o",
    "spare2": "2nr4wc"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "c3skqk",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### ThirdMember Operation. 删除第三方用户数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/third/member/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** ThirdMember Operation. 删除第三方用户数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|主键ID:null;1;1,2,3,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/member/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3tnmfv",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 第三方用户身份提供商绑定读写控制类
### Get ThirdMemberBind list. 获取用户身份提供商绑定列表或分页, 返回ThirdMemberBind对象.
**URL:** https://linlan.net/eframe_backend/api/third/memberbind/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get ThirdMemberBind list. 获取用户身份提供商绑定列表或分页, 返回ThirdMemberBind对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|string|主键ID|false|-
memberId|int64|会员ID|false|-
username|string|系统用户名，手机号|false|-
accountId|string|身份提供商ID|false|-
accountKey|string|第三方账号KEY，市民云、微信等的UnionId或OpenId|false|-
bindTime|string|绑定时间|false|-
additionInfo|string|附加信息|false|-
creatorId|string|创建人ID|false|-
delFlag|int32|删除标记，0未删除1已删除|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/list.do?creatorId=172&limit=10&id=172&orderBy=573&username=merle.larkin&accountKey=rfdmjx&memberId=816&bindTime=2025-10-20 18:25:53&page=1&delFlag=5&description=9zsxd2&endTime=2025-10-20 18:20:52&accountId=172&additionInfo=63ylb2&spare2=1bnb62&spare1=1il6p0&q=ymv8rb&startTime=2025-10-20 18:20:52
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|主键ID|-
└─memberId|int64|会员ID|-
└─userId|string|用户ID|-
└─username|string|系统用户名，手机号|-
└─accountId|string|身份提供商ID|-
└─accountKey|string|第三方账号KEY，市民云、微信等的UnionId或OpenId|-
└─bindTime|string|绑定时间|-
└─additionInfo|string|附加信息|-
└─delFlag|int32|删除标记，0未删除1已删除|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:53",
      "lastTime": "2025-10-20 18:25:53",
      "id": "172",
      "memberId": 872,
      "userId": "172",
      "username": "merle.larkin",
      "accountId": "172",
      "accountKey": "6vo95p",
      "bindTime": "2025-10-20 18:25:53",
      "additionInfo": "9gaa21",
      "delFlag": 5,
      "description": "ng5x07",
      "spare1": "f1yngy",
      "spare2": "yz4j5s"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get ThirdMemberBind by id. 主键获取用户身份提供商绑定详细信息.
**URL:** https://linlan.net/eframe_backend/api/third/memberbind/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get ThirdMemberBind by id. 主键获取用户身份提供商绑定详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|string|主键ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|string|主键ID|-
└─memberId|int64|会员ID|-
└─userId|string|用户ID|-
└─username|string|系统用户名，手机号|-
└─accountId|string|身份提供商ID|-
└─accountKey|string|第三方账号KEY，市民云、微信等的UnionId或OpenId|-
└─bindTime|string|绑定时间|-
└─additionInfo|string|附加信息|-
└─delFlag|int32|删除标记，0未删除1已删除|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:53",
    "lastTime": "2025-10-20 18:25:53",
    "id": "172",
    "memberId": 336,
    "userId": "172",
    "username": "merle.larkin",
    "accountId": "172",
    "accountKey": "t01gfa",
    "bindTime": "2025-10-20 18:25:53",
    "additionInfo": "bkp677",
    "delFlag": 5,
    "description": "ly6rmt",
    "spare1": "d1jk3k",
    "spare2": "w5inow"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### ThirdMemberBind Operation. 新增用户身份提供商绑定数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/third/memberbind/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/json; charset=utf-8

**Description:** ThirdMemberBind Operation. 新增用户身份提供商绑定数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|主键ID|false|-
└─memberId|int64|会员ID|false|-
└─userId|string|用户ID|false|-
└─username|string|系统用户名，手机号|false|-
└─accountId|string|身份提供商ID|false|-
└─accountKey|string|第三方账号KEY，市民云、微信等的UnionId或OpenId|false|-
└─bindTime|string|绑定时间|false|-
└─additionInfo|string|附加信息|false|-
└─delFlag|int32|删除标记，0未删除1已删除|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:53",
    "lastTime": "2025-10-20 18:25:53",
    "id": "172",
    "memberId": 480,
    "userId": "172",
    "username": "merle.larkin",
    "accountId": "172",
    "accountKey": "q6xx8w",
    "bindTime": "2025-10-20 18:25:53",
    "additionInfo": "c5h9bu",
    "delFlag": 5,
    "description": "a602le",
    "spare1": "hwcuih",
    "spare2": "uv5ocg"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "v372n4",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### ThirdMemberBind Operation. 修改用户身份提供商绑定数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/third/memberbind/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/json; charset=utf-8

**Description:** ThirdMemberBind Operation. 修改用户身份提供商绑定数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|string|主键ID|false|-
└─memberId|int64|会员ID|false|-
└─userId|string|用户ID|false|-
└─username|string|系统用户名，手机号|false|-
└─accountId|string|身份提供商ID|false|-
└─accountKey|string|第三方账号KEY，市民云、微信等的UnionId或OpenId|false|-
└─bindTime|string|绑定时间|false|-
└─additionInfo|string|附加信息|false|-
└─delFlag|int32|删除标记，0未删除1已删除|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:53",
    "lastTime": "2025-10-20 18:25:53",
    "id": "172",
    "memberId": 678,
    "userId": "172",
    "username": "merle.larkin",
    "accountId": "172",
    "accountKey": "rbykbr",
    "bindTime": "2025-10-20 18:25:53",
    "additionInfo": "4ug1rp",
    "delFlag": 5,
    "description": "gxooi2",
    "spare1": "0swuvu",
    "spare2": "y83lmp"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3r39w2",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除用户身份提供商绑定数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/third/memberbind/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除用户身份提供商绑定数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|主键ID:null;1;1,2,3,[array of string]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "cjk8zd",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 第三方社交平台登录验证
### 社交平台登录方法
**URL:** https://linlan.net/eframe_backend/login/social.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 社交平台登录方法

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─serverType|string|开放平台类型|false|-
└─code|string|开放平台Code|false|-
└─state|string|state|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/social.do --data '{
  "data": {
    "serverType": "ei7oc4",
    "code": "81486",
    "state": "hg1jic"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─userId|string|用户ID|-
└─token|string|令牌TOKEN|-
└─updateTime|string|更新时间|-
└─expireTime|string|过期时间|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "userId": "172",
    "token": "y7qjyo",
    "updateTime": "2025-10-20 18:25:54",
    "expireTime": "2025-10-20 18:25:54"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据类型，获取授权请求
**URL:** https://linlan.net/eframe_backend/login/social/render/{source}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据类型，获取授权请求

**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
source|string|来源类型，alipay|true|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/render/其他.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "su6l0g",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据类型，获取授权请求
**URL:** https://linlan.net/eframe_backend/login/social/callback/{source}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据类型，获取授权请求

**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
source|string|来源类型，alipay|true|-

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
code|string|No comments found.|false|-
auth_code|string|No comments found.|false|-
state|string|No comments found.|false|-
authorization_code|string|No comments found.|false|-
oauth_token|string|No comments found.|false|-
oauth_verifier|string|No comments found.|false|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/callback/其他.do?oauth_token=jezs6x&code=81486&oauth_verifier=0xe6t7&auth_code=81486&authorization_code=81486&state=cqmrp1
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─view|object|No comments found.|-
└─model|object|No comments found.|-
└─status|enum|null<br/>CONTINUE<br/>SWITCHING_PROTOCOLS<br/>PROCESSING<br/>CHECKPOINT<br/>OK<br/>CREATED<br/>ACCEPTED<br/>NON_AUTHORITATIVE_INFORMATION<br/>NO_CONTENT<br/>RESET_CONTENT<br/>PARTIAL_CONTENT<br/>MULTI_STATUS<br/>ALREADY_REPORTED<br/>IM_USED<br/>MULTIPLE_CHOICES<br/>MOVED_PERMANENTLY<br/>FOUND<br/>MOVED_TEMPORARILY<br/>SEE_OTHER<br/>NOT_MODIFIED<br/>USE_PROXY<br/>TEMPORARY_REDIRECT<br/>PERMANENT_REDIRECT<br/>BAD_REQUEST<br/>UNAUTHORIZED<br/>PAYMENT_REQUIRED<br/>FORBIDDEN<br/>NOT_FOUND<br/>METHOD_NOT_ALLOWED<br/>NOT_ACCEPTABLE<br/>PROXY_AUTHENTICATION_REQUIRED<br/>REQUEST_TIMEOUT<br/>CONFLICT<br/>GONE<br/>LENGTH_REQUIRED<br/>PRECONDITION_FAILED<br/>PAYLOAD_TOO_LARGE<br/>REQUEST_ENTITY_TOO_LARGE<br/>URI_TOO_LONG<br/>REQUEST_URI_TOO_LONG<br/>UNSUPPORTED_MEDIA_TYPE<br/>REQUESTED_RANGE_NOT_SATISFIABLE<br/>EXPECTATION_FAILED<br/>I_AM_A_TEAPOT<br/>INSUFFICIENT_SPACE_ON_RESOURCE<br/>METHOD_FAILURE<br/>DESTINATION_LOCKED<br/>UNPROCESSABLE_ENTITY<br/>LOCKED<br/>FAILED_DEPENDENCY<br/>TOO_EARLY<br/>UPGRADE_REQUIRED<br/>PRECONDITION_REQUIRED<br/>TOO_MANY_REQUESTS<br/>REQUEST_HEADER_FIELDS_TOO_LARGE<br/>UNAVAILABLE_FOR_LEGAL_REASONS<br/>INTERNAL_SERVER_ERROR<br/>NOT_IMPLEMENTED<br/>BAD_GATEWAY<br/>SERVICE_UNAVAILABLE<br/>GATEWAY_TIMEOUT<br/>HTTP_VERSION_NOT_SUPPORTED<br/>VARIANT_ALSO_NEGOTIATES<br/>INSUFFICIENT_STORAGE<br/>LOOP_DETECTED<br/>BANDWIDTH_LIMIT_EXCEEDED<br/>NOT_EXTENDED<br/>NETWORK_AUTHENTICATION_REQUIRED<br/>|-
└─cleared|boolean|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{"success":true,"code":"0","msg":"正常","data":Forward or redirect to a page view.,"requestId":"172","timestamp":"2025-10-20 18:20:52"}
```

### 第三方社交平台账号绑定
**URL:** https://linlan.net/eframe_backend/login/member/bind.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 第三方社交平台账号绑定

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─platformType|string|开放平台类型|false|-
└─code|string|开放平台Code|false|-
└─state|string|state|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/member/bind.do --data '{
  "data": {
    "platformType": "2u6q5q",
    "code": "81486",
    "state": "hl7iw3"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "rk2xuv",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 第三方社交平台账号解绑
**URL:** https://linlan.net/eframe_backend/login/member/bind/{platformType}.do

**Type:** PUT

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 第三方社交平台账号解绑

**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
platformType|string|   平台类型|true|-

**Request-example:**
```
curl -X PUT -k -i https://linlan.net/eframe_backend/login/member/bind/jhbvq8.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "1gd50l",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 调度任务信息操作处理
### 查询定时任务列表
**URL:** https://linlan.net/eframe_backend/api/monitor/job/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询定时任务列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
jobId|int64|任务ID|false|-
jobName|string|任务名称|false|-
jobGroup|string|任务组名|false|-
invokeTarget|string|调用目标字符串|false|-
cronExpression|string|cron执行表达式|false|-
misfirePolicy|string|cron计划策略|false|-
concurrent|string|是否并发执行（0允许 1禁止）|false|-
status|int32|任务状态（0正常 1暂停）|false|-
remark|string|备注|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/list.do?jobId=693&jobGroup=4nf0ey&concurrent=upvpwk&invokeTarget=uyv0b1&status=432&remark=5d4s5c&misfirePolicy=6r814u&jobName=merle.larkin&cronExpression=h60r0f
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─jobId|string|任务ID|-
└─jobName|string|任务名称|-
└─jobGroup|string|任务组名|-
└─invokeTarget|string|调用目标字符串|-
└─cronExpression|string|cron执行表达式|-
└─misfirePolicy|string|cron计划策略|-
└─concurrent|string|是否并发执行（0允许 1禁止）|-
└─status|int32|任务状态（0正常 1暂停）|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "jobId": "172",
      "jobName": "merle.larkin",
      "jobGroup": "k4wqwk",
      "invokeTarget": "jtqog4",
      "cronExpression": "q32uga",
      "misfirePolicy": "qj53pv",
      "concurrent": "pr4d7y",
      "status": 366,
      "remark": "4ou2c4"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 导出定时任务列表
**URL:** https://linlan.net/eframe_backend/api/monitor/job/export.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 导出定时任务列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
jobId|int64|任务ID|false|-
jobName|string|任务名称|false|-
jobGroup|string|任务组名|false|-
invokeTarget|string|调用目标字符串|false|-
cronExpression|string|cron执行表达式|false|-
misfirePolicy|string|cron计划策略|false|-
concurrent|string|是否并发执行（0允许 1禁止）|false|-
status|int32|任务状态（0正常 1暂停）|false|-
remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/export.do --data 'jobId=656&cronExpression=hw5l3a&jobName=merle.larkin&misfirePolicy=et5jlx&jobGroup=f6kewi&remark=kkca0k&status=105&invokeTarget=4n89l2&concurrent=yjteri'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "5526k7",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 获取定时任务详细信息
**URL:** https://linlan.net/eframe_backend/api/monitor/job/{jobId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取定时任务详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
jobId|string|    任务ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/172.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─jobId|string|任务ID|-
└─jobName|string|任务名称|-
└─jobGroup|string|任务组名|-
└─invokeTarget|string|调用目标字符串|-
└─cronExpression|string|cron执行表达式|-
└─misfirePolicy|string|cron计划策略|-
└─concurrent|string|是否并发执行（0允许 1禁止）|-
└─status|int32|任务状态（0正常 1暂停）|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "jobId": "172",
    "jobName": "merle.larkin",
    "jobGroup": "95bnwy",
    "invokeTarget": "cxaxza",
    "cronExpression": "r09y3b",
    "misfirePolicy": "16rb6y",
    "concurrent": "gbqnxy",
    "status": 936,
    "remark": "a7o2mm"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 新增定时任务
**URL:** https://linlan.net/eframe_backend/api/monitor/job/save.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 新增定时任务

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─jobId|string|任务ID|false|-
└─jobName|string|任务名称|false|-
└─jobGroup|string|任务组名|false|-
└─invokeTarget|string|调用目标字符串|false|-
└─cronExpression|string|cron执行表达式|false|-
└─misfirePolicy|string|cron计划策略|false|-
└─concurrent|string|是否并发执行（0允许 1禁止）|false|-
└─status|int32|任务状态（0正常 1暂停）|false|-
└─remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/save.do --data '{
  "data": {
    "jobId": "172",
    "jobName": "merle.larkin",
    "jobGroup": "h7re02",
    "invokeTarget": "04wiee",
    "cronExpression": "e10kuz",
    "misfirePolicy": "fmxjsp",
    "concurrent": "00rd1p",
    "status": 128,
    "remark": "r7baes"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "048xd3",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 修改定时任务
**URL:** https://linlan.net/eframe_backend/api/monitor/job/update.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 修改定时任务

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─jobId|string|任务ID|false|-
└─jobName|string|任务名称|false|-
└─jobGroup|string|任务组名|false|-
└─invokeTarget|string|调用目标字符串|false|-
└─cronExpression|string|cron执行表达式|false|-
└─misfirePolicy|string|cron计划策略|false|-
└─concurrent|string|是否并发执行（0允许 1禁止）|false|-
└─status|int32|任务状态（0正常 1暂停）|false|-
└─remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/update.do --data '{
  "data": {
    "jobId": "172",
    "jobName": "merle.larkin",
    "jobGroup": "4nprv9",
    "invokeTarget": "3rla3m",
    "cronExpression": "yv53tz",
    "misfirePolicy": "qp5qt0",
    "concurrent": "moepsi",
    "status": 795,
    "remark": "k98m0q"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "er16hf",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 定时任务状态修改
**URL:** https://linlan.net/eframe_backend/api/monitor/job/changeStatus.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 定时任务状态修改

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─jobId|string|任务ID|false|-
└─jobName|string|任务名称|false|-
└─jobGroup|string|任务组名|false|-
└─invokeTarget|string|调用目标字符串|false|-
└─cronExpression|string|cron执行表达式|false|-
└─misfirePolicy|string|cron计划策略|false|-
└─concurrent|string|是否并发执行（0允许 1禁止）|false|-
└─status|int32|任务状态（0正常 1暂停）|false|-
└─remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/changeStatus.do --data '{
  "data": {
    "jobId": "172",
    "jobName": "merle.larkin",
    "jobGroup": "i9pz40",
    "invokeTarget": "6safn6",
    "cronExpression": "wcqjbu",
    "misfirePolicy": "9f4sm4",
    "concurrent": "hh3dkv",
    "status": 280,
    "remark": "mctvkb"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "nlfj2b",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 定时任务立即执行一次
**URL:** https://linlan.net/eframe_backend/api/monitor/job/run.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 定时任务立即执行一次

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─jobId|string|任务ID|false|-
└─jobName|string|任务名称|false|-
└─jobGroup|string|任务组名|false|-
└─invokeTarget|string|调用目标字符串|false|-
└─cronExpression|string|cron执行表达式|false|-
└─misfirePolicy|string|cron计划策略|false|-
└─concurrent|string|是否并发执行（0允许 1禁止）|false|-
└─status|int32|任务状态（0正常 1暂停）|false|-
└─remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/run.do --data '{
  "data": {
    "jobId": "172",
    "jobName": "merle.larkin",
    "jobGroup": "g7dvn1",
    "invokeTarget": "f7g8mk",
    "cronExpression": "1gsyb3",
    "misfirePolicy": "qykpok",
    "concurrent": "8fd98y",
    "status": 158,
    "remark": "uewp95"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "isu9nr",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除定时任务
**URL:** https://linlan.net/eframe_backend/api/monitor/job/{jobIds}.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除定时任务

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
jobIds|array|   任务Ids,[array of string]|true|

**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "hd997s",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 调度日志操作处理
### 查询定时任务调度日志列表
**URL:** https://linlan.net/eframe_backend/api/monitor/joblog/list.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查询定时任务调度日志列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
jobLogId|int64|ID|false|-
jobId|string|No comments found.|false|-
jobName|string|任务名称|false|-
jobGroup|string|任务组名|false|-
invokeTarget|string|调用目标字符串|false|-
jobMessage|string|日志信息|false|-
status|int32|执行状态（0正常 1失败）|false|-
exceptionInfo|string|异常信息|false|-
startTime|string|开始时间|false|-
stopTime|string|停止时间|false|-
remark|string|备注|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/list.do?exceptionInfo=wq0la3&startTime=2025-10-20 18:25:54&jobGroup=wca06p&invokeTarget=ft13e8&createTime=2025-10-20 18:25:54&remark=3f80kn&status=928&stopTime=2025-10-20 18:25:54&lastTime=2025-10-20 18:25:54&jobId=172&creatorId=172&jobLogId=509&jobName=merle.larkin&jobMessage=success
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─jobLogId|string|ID|-
└─jobId|string|No comments found.|-
└─jobMessage|string|日志信息|-
└─status|int32|执行状态（0正常 1失败）|-
└─exceptionInfo|string|异常信息|-
└─startTime|string|开始时间|-
└─stopTime|string|停止时间|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:54",
      "lastTime": "2025-10-20 18:25:54",
      "jobLogId": "172",
      "jobId": "172",
      "jobMessage": "success",
      "status": 419,
      "exceptionInfo": "qa174n",
      "startTime": "2025-10-20 18:25:54",
      "stopTime": "2025-10-20 18:25:54",
      "remark": "ciax7k"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 导出定时任务调度日志列表
**URL:** https://linlan.net/eframe_backend/api/monitor/joblog/export.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 导出定时任务调度日志列表

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
jobLogId|int64|ID|false|-
jobId|string|No comments found.|false|-
jobName|string|任务名称|false|-
jobGroup|string|任务组名|false|-
invokeTarget|string|调用目标字符串|false|-
jobMessage|string|日志信息|false|-
status|int32|执行状态（0正常 1失败）|false|-
exceptionInfo|string|异常信息|false|-
startTime|string|开始时间|false|-
stopTime|string|停止时间|false|-
remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/export.do --data 'jobGroup=dpbl11&lastTime=2025-10-20 18:25:54&jobName=merle.larkin&jobId=172&createTime=2025-10-20 18:25:54&stopTime=2025-10-20 18:25:54&status=236&startTime=2025-10-20 18:25:54&invokeTarget=ez4aaw&jobLogId=945&exceptionInfo=wxkr28&jobMessage=success&remark=uzcmgq&creatorId=172'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "pp3q3z",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 根据调度编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/monitor/joblog/{jobLogId}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据调度编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
jobLogId|string|    任务日志ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/172.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─jobLogId|string|ID|-
└─jobId|string|No comments found.|-
└─jobMessage|string|日志信息|-
└─status|int32|执行状态（0正常 1失败）|-
└─exceptionInfo|string|异常信息|-
└─startTime|string|开始时间|-
└─stopTime|string|停止时间|-
└─remark|string|备注|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:54",
    "lastTime": "2025-10-20 18:25:54",
    "jobLogId": "172",
    "jobId": "172",
    "jobMessage": "success",
    "status": 275,
    "exceptionInfo": "fy5huz",
    "startTime": "2025-10-20 18:25:54",
    "stopTime": "2025-10-20 18:25:54",
    "remark": "jargfy"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### 删除定时任务调度日志
**URL:** https://linlan.net/eframe_backend/api/monitor/joblog/{jobLogIds}.do

**Type:** DELETE

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 删除定时任务调度日志

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
jobLogIds|array|    任务日志Ids,[array of string]|true|

**Request-example:**
```
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "mplz6k",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 邮件发送记录读写控制类
### Get MailSendRecord list. 获取邮件发送记录列表或分页, 返回MailSendRecord对象.
**URL:** https://linlan.net/eframe_backend/api/store/mailsendrecord/list.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-15 14:09:40

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get MailSendRecord list. 获取邮件发送记录列表或分页, 返回MailSendRecord对象.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
id|int64|主键ID|false|-
appId|string|应用ID|false|-
providerId|string|邮件提供商ID，平台ID|false|-
providerName|string|邮件提供商名称，平台名称|false|-
foreignId|string|外键ID|false|-
senderName|string|发送信息者名称，后台用户则管理员，会员则会员名称，企业会员则号名称|false|-
receiverEmail|string|接收人ID，邮箱地址|false|-
receiverName|string|接收人|false|-
bizType|string|业务类型|false|-
title|string|信息标题，主题|false|-
content|string|信息内容|false|-
msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
status|string|信息状态|false|-
sendTime|string|发送时间|false|-
sendStatus|string|发送状态(0草稿1已发)|false|-
readTime|string|阅读时间|false|-
readStatus|string|信息状态(0未读1已读2全组已读)|false|-
creatorId|string|创建者ID|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/mailsendrecord/list.do?content=vbyf2s&spare1=qgiqsr&sendTime=2025-10-20&endTime=2025-10-20 18:20:52&page=1&readTime=2025-10-20 18:25:52&startTime=2025-10-20 18:20:52&receiverEmail=vivian.streich@hotmail.com&providerName=merle.larkin&receiverName=merle.larkin&providerId=172&title=3f0vha&spare2=bcaczj&q=os0u8n&foreignId=172&sendStatus=ir004v&orderBy=662&appId=172&id=947&msgUrl=www.ben-grant.info&status=4la440&description=gdv61j&readStatus=8ijml6&creatorId=172&limit=10&senderName=merle.larkin&delFlag=5&bizType=s0tnsi
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|主键ID|-
└─appId|string|应用ID|-
└─providerId|string|邮件提供商ID，平台ID|-
└─providerName|string|邮件提供商名称，平台名称|-
└─foreignId|string|外键ID|-
└─senderName|string|发送信息者名称，后台用户则管理员，会员则会员名称，企业会员则号名称|-
└─receiverEmail|string|接收人ID，邮箱地址|-
└─receiverName|string|接收人|-
└─bizType|string|业务类型|-
└─title|string|信息标题，主题|-
└─content|string|信息内容|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|-
└─status|string|信息状态|-
└─sendTime|string|发送时间|-
└─sendStatus|string|发送状态(0草稿1已发)|-
└─readTime|string|阅读时间|-
└─readStatus|string|信息状态(0未读1已读2全组已读)|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "172",
      "createTime": "2025-10-20 18:25:52",
      "lastTime": "2025-10-20 18:25:52",
      "id": 185,
      "appId": "172",
      "providerId": "172",
      "providerName": "merle.larkin",
      "foreignId": "172",
      "senderName": "merle.larkin",
      "receiverEmail": "vivian.streich@hotmail.com",
      "receiverName": "merle.larkin",
      "bizType": "uw7zvj",
      "title": "re59vp",
      "content": "daxlb3",
      "msgUrl": "www.ben-grant.info",
      "status": "76593c",
      "sendTime": "2025-10-20",
      "sendStatus": "0gop7b",
      "readTime": "2025-10-20 18:25:52",
      "readStatus": "fsp8mn",
      "delFlag": 5,
      "description": "qrljxs",
      "spare1": "7dofcs",
      "spare2": "lslo1g"
    }
  ],
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### Get MailSendRecord by id. 主键获取邮件发送记录详细信息.
**URL:** https://linlan.net/eframe_backend/api/store/mailsendrecord/{id}.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-15 14:09:40

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** Get MailSendRecord by id. 主键获取邮件发送记录详细信息.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|主键ID|true|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/mailsendrecord/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─creatorId|string|创建人id|-
└─createTime|string|创建时间|-
└─lastTime|string|最后修改时间|-
└─id|int64|主键ID|-
└─appId|string|应用ID|-
└─providerId|string|邮件提供商ID，平台ID|-
└─providerName|string|邮件提供商名称，平台名称|-
└─foreignId|string|外键ID|-
└─senderName|string|发送信息者名称，后台用户则管理员，会员则会员名称，企业会员则号名称|-
└─receiverEmail|string|接收人ID，邮箱地址|-
└─receiverName|string|接收人|-
└─bizType|string|业务类型|-
└─title|string|信息标题，主题|-
└─content|string|信息内容|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|-
└─status|string|信息状态|-
└─sendTime|string|发送时间|-
└─sendStatus|string|发送状态(0草稿1已发)|-
└─readTime|string|阅读时间|-
└─readStatus|string|信息状态(0未读1已读2全组已读)|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─description|string|备注|-
└─spare1|string|备用1|-
└─spare2|string|备用2|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:52",
    "lastTime": "2025-10-20 18:25:52",
    "id": 605,
    "appId": "172",
    "providerId": "172",
    "providerName": "merle.larkin",
    "foreignId": "172",
    "senderName": "merle.larkin",
    "receiverEmail": "vivian.streich@hotmail.com",
    "receiverName": "merle.larkin",
    "bizType": "vdt1yb",
    "title": "o5o18l",
    "content": "s4kmat",
    "msgUrl": "www.ben-grant.info",
    "status": "503d53",
    "sendTime": "2025-10-20",
    "sendStatus": "02lpia",
    "readTime": "2025-10-20 18:25:52",
    "readStatus": "fpi6ua",
    "delFlag": 5,
    "description": "yoskak",
    "spare1": "upq5y0",
    "spare2": "lgutns"
  },
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### MailSendRecord Operation. 新增邮件发送记录数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/store/mailsendrecord/save.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-15 14:09:40

**Content-Type:** application/json; charset=utf-8

**Description:** MailSendRecord Operation. 新增邮件发送记录数据操作逻辑，根据操作类型，执行新增操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|主键ID|false|-
└─appId|string|应用ID|false|-
└─providerId|string|邮件提供商ID，平台ID|false|-
└─providerName|string|邮件提供商名称，平台名称|false|-
└─foreignId|string|外键ID|false|-
└─senderName|string|发送信息者名称，后台用户则管理员，会员则会员名称，企业会员则号名称|false|-
└─receiverEmail|string|接收人ID，邮箱地址|false|-
└─receiverName|string|接收人|false|-
└─bizType|string|业务类型|false|-
└─title|string|信息标题，主题|false|-
└─content|string|信息内容|false|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
└─status|string|信息状态|false|-
└─sendTime|string|发送时间|false|-
└─sendStatus|string|发送状态(0草稿1已发)|false|-
└─readTime|string|阅读时间|false|-
└─readStatus|string|信息状态(0未读1已读2全组已读)|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/mailsendrecord/save.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:52",
    "lastTime": "2025-10-20 18:25:52",
    "id": 167,
    "appId": "172",
    "providerId": "172",
    "providerName": "merle.larkin",
    "foreignId": "172",
    "senderName": "merle.larkin",
    "receiverEmail": "vivian.streich@hotmail.com",
    "receiverName": "merle.larkin",
    "bizType": "ehibbe",
    "title": "9k9c49",
    "content": "jippbw",
    "msgUrl": "www.ben-grant.info",
    "status": "bk9xxf",
    "sendTime": "2025-10-20",
    "sendStatus": "mvi1zt",
    "readTime": "2025-10-20 18:25:52",
    "readStatus": "o4m5em",
    "delFlag": 5,
    "description": "a2ihu3",
    "spare1": "bmsiwh",
    "spare2": "858f37"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "sralah",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### MailSendRecord Operation. 修改邮件发送记录数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/store/mailsendrecord/update.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-15 14:09:40

**Content-Type:** application/json; charset=utf-8

**Description:** MailSendRecord Operation. 修改邮件发送记录数据操作逻辑，根据操作类型，执行修改操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-
└─creatorId|string|创建人id|false|-
└─createTime|string|创建时间|false|-
└─lastTime|string|最后修改时间|false|-
└─id|int64|主键ID|false|-
└─appId|string|应用ID|false|-
└─providerId|string|邮件提供商ID，平台ID|false|-
└─providerName|string|邮件提供商名称，平台名称|false|-
└─foreignId|string|外键ID|false|-
└─senderName|string|发送信息者名称，后台用户则管理员，会员则会员名称，企业会员则号名称|false|-
└─receiverEmail|string|接收人ID，邮箱地址|false|-
└─receiverName|string|接收人|false|-
└─bizType|string|业务类型|false|-
└─title|string|信息标题，主题|false|-
└─content|string|信息内容|false|-
└─msgUrl|string|信息链接，链接平台内地址，可点击访问|false|-
└─status|string|信息状态|false|-
└─sendTime|string|发送时间|false|-
└─sendStatus|string|发送状态(0草稿1已发)|false|-
└─readTime|string|阅读时间|false|-
└─readStatus|string|信息状态(0未读1已读2全组已读)|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─description|string|备注|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/mailsendrecord/update.do --data '{
  "data": {
    "creatorId": "172",
    "createTime": "2025-10-20 18:25:52",
    "lastTime": "2025-10-20 18:25:52",
    "id": 972,
    "appId": "172",
    "providerId": "172",
    "providerName": "merle.larkin",
    "foreignId": "172",
    "senderName": "merle.larkin",
    "receiverEmail": "vivian.streich@hotmail.com",
    "receiverName": "merle.larkin",
    "bizType": "kppe50",
    "title": "zyqrh6",
    "content": "j6bdm9",
    "msgUrl": "www.ben-grant.info",
    "status": "hc44nz",
    "sendTime": "2025-10-20",
    "sendStatus": "cechxr",
    "readTime": "2025-10-20 18:25:52",
    "readStatus": "qdv0kb",
    "delFlag": 5,
    "description": "qug6rs",
    "spare1": "68kzph",
    "spare2": "jfoqza"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "jdwjsy",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

### MailSendRecord Operation. 删除邮件发送记录数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/store/mailsendrecord/delete/{ids}.do

**Type:** POST

**Author:** Linlan
CreateTime 2025-10-15 14:09:40

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** MailSendRecord Operation. 删除邮件发送记录数据操作逻辑，根据操作类型，执行删除操作.

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
ids|array|主键ID:null;1;1,2,3,[array of int64]|true|

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/mailsendrecord/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3ljoav",
  "requestId": "172",
  "timestamp": "2025-10-20 18:20:52"
}
```

## 错误码列表
Error code |Description
---|---
200|Success[正常]
201|None[未查询到数据]
400|Bad Request[请求错误]
401|Unauthorized[TOKEN失效，请重新登录]
403|Forbidden[页面禁止访问]
404|Not Found[页面未找到]
415|Unsupported Media Type[数据类型不支持]
500|Internal Server Error[未知错误]
501|Not Login[用户未登录]
502|Bad Gateway[网关错误]
503|Service Unavailable[服务不可用]
700|Token Error[TOKEN信息错误]
701|Input Error Code[信息传入有误(code)]
702|Input Error Source[信息传入有误(source)]
703|Account Not Exist[对接平台账户不存在]
704|Channel Not Exist[该栏目版面不存在]
711|Parameter Error[传递参数信息错误]
712|Network Error[网络异常，请联系系统管理员]
721|Third Info Error[第三方数据信息验证失败]
731|IP Whitelist Error[白名单校验失败]
741|Info Send Fail[消息推送失败]
1001|Error User Info[用户数据信息验证失败]
1002|Error User SSO[SSO用户数据信息验证失败]
1003|Error User APP[APP用户数据信息验证失败]
1004|Error User APP Step1[APP用户在调取第三方接口时失败]
1005|Error User APP Step2[APP用户数据调取第三方接口成功但是返回的数据不正确]
1006|Error User Out[外部用户数据信息验证失败]
1011|Error User Key[用户关键信息错误]
1012|Error User Password[用户密码信息错误]
1013|Error User Real Name[需要实名认证绑定]
1014|Error User Need Login[请用户重新登录]
1015|Error User Need Face[需要人脸识别二次认证]
1016|Error User Identity[认证失败，请重新认证]
1017|Error User Face[人脸识别信息与系统不一致]
1018|Error User Need Reg[用户信息未注册，请注册]
1019|Error Params Mate[传参不匹配]
1020|Error Return Many[查询出多条数据]
1021|Error Number Format[数字格式转换异常]
1022|Error Data Duplicate[数据重复]
1023|Error Data Format[数据格式错误]
1024|Error Data[数据错误]
1101|Error Address Invalid[无效访问地址]
1102|Error With Upload[上传出现错误，请联系管理员]
1103|Error With Input填写信息错误，请检查]
1104|Error With Password[密码必须为大小写字母,数字,特殊字符中的至少3种且8位-20位之内]
1201|Error With Enterprise Info[企业关键信息错误]
1202|Error With Not Initial[关键信息未初始化]
1301|Error Template Info[模板信息错误]

## 数据字典
### 目录树结构字典

Code |Type|Description
---|---|---
ROLE|string|角色树
MENU|string|菜单树
ALL_POSITION|string|全部岗位树
POSITION|string|岗位树
SINGLE_POSITION|string|单表岗位树
ALL_MENU|string|全部菜单树
ALL_DEPT|string|全部部门树
BASE_XZQH|string|行政区划树
COM_DIC_ECOINDUSTRY|string|所属行业树
CORE_DEPTTYPE|string|条线部门树
CORE_ORGTYPE|string|机构分类树
