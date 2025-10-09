# ent-frame
Version |  Update Time  | Status | Author |  Description
---|---|---|---|---
1.0|2025-08-24 10:30|update|Linlan|desc



# default
# 平台通用接口API
## Filename:ApiStatusMonitorController.javaDesc:平台当前应用的版本，用于验证进程服务是否正常
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
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

# 一体化平台接口API
## AdminDept控制域:系统机构部门增删改操作控制类
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
└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
└─status|int32|状态0未生效1正常2受限3锁定|false|-
└─delFlag|int32|是否删除1已删除0正常|false|-
└─description|string|描述|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─children|array|子部门|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/save.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:44",
    "lastTime": "2025-09-22 22:45:44",
    "id": 314,
    "organId": "119",
    "parentId": 537,
    "appId": "119",
    "depttypeId": 997,
    "foreignId": "119",
    "createType": 526,
    "type": "vvs7qg",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "areaCode": "95555",
    "organLeader": "cg33k9",
    "leaderId": "119",
    "leaderMobile": "724.248.1428",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "95555",
    "imagePath": "hsojbv",
    "priority": 138,
    "status": 869,
    "delFlag": 2,
    "description": "c7etov",
    "spare1": "sxr9b0",
    "spare2": "yryd3c",
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
  "data": "tmc9tt",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
└─status|int32|状态0未生效1正常2受限3锁定|false|-
└─delFlag|int32|是否删除1已删除0正常|false|-
└─description|string|描述|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─children|array|子部门|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/update.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:44",
    "lastTime": "2025-09-22 22:45:44",
    "id": 820,
    "organId": "119",
    "parentId": 103,
    "appId": "119",
    "depttypeId": 335,
    "foreignId": "119",
    "createType": 299,
    "type": "3wefbs",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "areaCode": "95555",
    "organLeader": "nvtzxm",
    "leaderId": "119",
    "leaderMobile": "724.248.1428",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "95555",
    "imagePath": "tpvxrb",
    "priority": 118,
    "status": 387,
    "delFlag": 2,
    "description": "sygp0h",
    "spare1": "a5nbem",
    "spare2": "ilb6hw",
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
  "data": "d27ev4",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "8frvrd",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
└─status|int32|状态0未生效1正常2受限3锁定|false|-
└─delFlag|int32|是否删除1已删除0正常|false|-
└─description|string|描述|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─children|array|子部门|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/disable/{id}.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:44",
    "lastTime": "2025-09-22 22:45:44",
    "id": 300,
    "organId": "119",
    "parentId": 511,
    "appId": "119",
    "depttypeId": 442,
    "foreignId": "119",
    "createType": 742,
    "type": "mxtkb3",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "areaCode": "95555",
    "organLeader": "ilau9p",
    "leaderId": "119",
    "leaderMobile": "724.248.1428",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "95555",
    "imagePath": "b33dwn",
    "priority": 211,
    "status": 510,
    "delFlag": 2,
    "description": "49z1cu",
    "spare1": "saaj9c",
    "spare2": "ul39q8",
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
  "data": "wp4ntj",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## AdminDept控制域:系统机构部门查询读取控制类
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
type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
status|int32|状态0未生效1正常2受限3锁定|false|-
creatorId|string|创建用户ID|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list.do?isOrganLevel=true&spare2=s4jyt4&startTime=2025-09-22 22:44:42&deptId=762&status=36&leaderMobile=724.248.1428&isDisabled=true&sname=pauline.robel&searchCode=95555&spare1=1qq5ku&description=z74okn&foreignId=119&isLeaf=true&leaderId=119&parentId=209&depttypeId=95&appId=119&name=pauline.robel&delFlag=2&orderBy=687&page=1&imagePath=194xsr&creatorId=119&organLeader=mzcu4o&type=jv93uy&limit=10&isVirtual=true&q=pjtz5i&areaCode=95555&createType=881&organId=119&endTime=2025-09-22 22:44:42
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
    "stackTrace": "wlcl28",
    "pageNum": 288,
    "pageSize": 10,
    "startRow": 886,
    "endRow": 831,
    "total": 253,
    "pages": 583,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "qav0o7",
    "orderBy": "xdcy72",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "vcamq1",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
status|int32|状态0未生效1正常2受限3锁定|false|-
creatorId|string|创建用户ID|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/page.do?depttypeId=246&type=xuwyww&creatorId=119&isVirtual=true&deptId=737&description=6eqfsw&startTime=2025-09-22 22:44:42&imagePath=oa4hvr&delFlag=2&parentId=380&name=pauline.robel&leaderMobile=724.248.1428&organLeader=bhpxzy&endTime=2025-09-22 22:44:42&foreignId=119&createType=774&leaderId=119&appId=119&spare2=cgxyhs&searchCode=95555&limit=10&isOrganLevel=true&isLeaf=true&sname=pauline.robel&page=1&status=815&isDisabled=true&spare1=s6vdos&q=zzvkaq&orderBy=72&areaCode=95555&organId=119
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
    "stackTrace": "lv377m",
    "pageNum": 257,
    "pageSize": 10,
    "startRow": 701,
    "endRow": 969,
    "total": 339,
    "pages": 32,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "48y5sg",
    "orderBy": "yxbps7",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "dcsmyv",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list/exclude/333.do
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
└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|-
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
└─status|int32|状态0未生效1正常2受限3锁定|-
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
      "id": 587,
      "organId": "119",
      "organName": "pauline.robel",
      "parentId": 54,
      "appId": "119",
      "depttypeId": 528,
      "foreignId": "119",
      "createType": 878,
      "type": "ckdcfs",
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "areaCode": "95555",
      "organLeader": "3nzqrb",
      "leaderId": "119",
      "leaderMobile": "724.248.1428",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "95555",
      "imagePath": "ksworp",
      "priority": 989,
      "status": 985,
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:44",
      "lastTime": "2025-09-22 22:45:44",
      "delFlag": 2,
      "description": "a36t5r",
      "spare1": "pyhasr",
      "spare2": "dsf3yv",
      "parentName": "pauline.robel",
      "childNum": "e4wt8b"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/899.do
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
└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|-
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
└─status|int32|状态0未生效1正常2受限3锁定|-
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
    "id": 130,
    "organId": "119",
    "organName": "pauline.robel",
    "parentId": 829,
    "appId": "119",
    "depttypeId": 48,
    "foreignId": "119",
    "createType": 981,
    "type": "i2bh3n",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "areaCode": "95555",
    "organLeader": "cxeazt",
    "leaderId": "119",
    "leaderMobile": "724.248.1428",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "95555",
    "imagePath": "awzoi1",
    "priority": 354,
    "status": 559,
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:44",
    "lastTime": "2025-09-22 22:45:44",
    "delFlag": 2,
    "description": "vu0czt",
    "spare1": "f6b04e",
    "spare2": "gz8bzf",
    "parentName": "pauline.robel",
    "childNum": "45b9d0"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
status|int32|状态0未生效1正常2受限3锁定|false|-
creatorId|string|创建用户ID|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/tree.do?parentId=188&foreignId=119&leaderMobile=724.248.1428&delFlag=2&isLeaf=true&sname=pauline.robel&limit=10&createType=787&areaCode=95555&spare2=jhie4h&description=b3wwab&depttypeId=468&page=1&creatorId=119&endTime=2025-09-22 22:44:42&q=8jjx0l&startTime=2025-09-22 22:44:42&organId=119&type=ab1lrv&deptId=940&isDisabled=true&organLeader=upuig2&isOrganLevel=true&leaderId=119&status=829&name=pauline.robel&appId=119&isVirtual=true&imagePath=o719ps&orderBy=98&searchCode=95555&spare1=7axc15
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
      "title": "sboxsj",
      "id": "119",
      "parentId": "119",
      "extId": "119",
      "href": "83f80s",
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
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## AdminLoginLog控制域:管理员登录日志查询读取控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/list.do?q=90sxky&infoId=210&page=1&limit=10&startTime=2025-09-22 22:44:42&orderBy=34&endTime=2025-09-22 22:44:42&browser=sl0598&msg=0buv29&os=79389b&status=d7kkaz&ipaddr=uy39no&loginTime=2025-09-22 22:45:51&username=pauline.robel
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
    "totalCount": 828,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "infoId": 964,
        "username": "pauline.robel",
        "status": "dyojw7",
        "ipaddr": "gtd9te",
        "loginLocation": "b0bdv1",
        "browser": "0xwgkm",
        "os": "8lqs9v",
        "msg": "058f26",
        "loginTime": "2025-09-22 22:45:51",
        "remark": "sbqaj7"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/export.do --data 'q=1819mo&infoId=360&limit=10&browser=fafna4&loginTime=2025-09-22 22:45:51&orderBy=803&status=vyfltg&startTime=2025-09-22 22:44:42&msg=zz6n2o&endTime=2025-09-22 22:44:42&ipaddr=gms28y&username=pauline.robel&os=7ic2uw&page=1'
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
  "data": "4afm61",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "rqdv42",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "ibiv9q",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/unlock/pauline.robel.do
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
  "data": "zjforj",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## AdminUser控制域:管理用户增删改操作控制类
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:45",
    "lastTime": "2025-09-22 22:45:45",
    "id": 57,
    "userId": "119",
    "deptId": 597,
    "deptName": "pauline.robel",
    "organId": "119",
    "organName": "pauline.robel",
    "name": "pauline.robel",
    "username": "pauline.robel",
    "nickName": "heriberto.bahringer",
    "email": "leonard.grady@yahoo.com",
    "mobile": "724.248.1428",
    "imagePath": "hy6r2g",
    "password": "8s8o0m",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 508,
    "delFlag": 2,
    "lastLoginIp": "112.28.203.208",
    "lastLoginTime": "2025-09-22 22:45:45",
    "description": "hj4gxs",
    "dept": {
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:45",
      "lastTime": "2025-09-22 22:45:45",
      "id": 911,
      "organId": "119",
      "parentId": 256,
      "appId": "119",
      "depttypeId": 578,
      "foreignId": "119",
      "createType": 195,
      "type": "lgjne4",
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "areaCode": "95555",
      "organLeader": "gf69b0",
      "leaderId": "119",
      "leaderMobile": "724.248.1428",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "95555",
      "imagePath": "to6xx7",
      "priority": 803,
      "status": 374,
      "delFlag": 2,
      "description": "axwprd",
      "spare1": "ytnz0w",
      "spare2": "glzps0",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:45",
        "lastTime": "2025-09-22 22:45:45",
        "id": 913,
        "roletypeId": "119",
        "appId": "119",
        "name": "pauline.robel",
        "code": "95555",
        "priority": 223,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 960,
        "description": "tdv937",
        "areaType": "z4znic"
      }
    ],
    "roleIds": [
      5
    ],
    "positionIds": [
      "3y61lc"
    ],
    "roleId": 866,
    "userRoleList": [
      {
        "id": 5,
        "deptId": 266,
        "deptName": "pauline.robel",
        "organId": "119",
        "organName": "pauline.robel",
        "roleId": 984,
        "roleName": "pauline.robel",
        "adminId": 567
      }
    ],
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
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
  "data": "qpti7s",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:45",
    "lastTime": "2025-09-22 22:45:45",
    "id": 812,
    "userId": "119",
    "deptId": 260,
    "deptName": "pauline.robel",
    "organId": "119",
    "organName": "pauline.robel",
    "name": "pauline.robel",
    "username": "pauline.robel",
    "nickName": "heriberto.bahringer",
    "email": "leonard.grady@yahoo.com",
    "mobile": "724.248.1428",
    "imagePath": "5pxr3j",
    "password": "un9oef",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 229,
    "delFlag": 2,
    "lastLoginIp": "112.28.203.208",
    "lastLoginTime": "2025-09-22 22:45:45",
    "description": "61e63z",
    "dept": {
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:45",
      "lastTime": "2025-09-22 22:45:45",
      "id": 861,
      "organId": "119",
      "parentId": 892,
      "appId": "119",
      "depttypeId": 954,
      "foreignId": "119",
      "createType": 754,
      "type": "m9iyji",
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "areaCode": "95555",
      "organLeader": "zs7zph",
      "leaderId": "119",
      "leaderMobile": "724.248.1428",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "95555",
      "imagePath": "z4jktz",
      "priority": 283,
      "status": 74,
      "delFlag": 2,
      "description": "ugtha6",
      "spare1": "4mi980",
      "spare2": "7d5cks",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:45",
        "lastTime": "2025-09-22 22:45:45",
        "id": 881,
        "roletypeId": "119",
        "appId": "119",
        "name": "pauline.robel",
        "code": "95555",
        "priority": 919,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 404,
        "description": "7t72po",
        "areaType": "0l27on"
      }
    ],
    "roleIds": [
      326
    ],
    "positionIds": [
      "z4d48n"
    ],
    "roleId": 554,
    "userRoleList": [
      {
        "id": 333,
        "deptId": 325,
        "deptName": "pauline.robel",
        "organId": "119",
        "organName": "pauline.robel",
        "roleId": 280,
        "roleName": "pauline.robel",
        "adminId": 786
      }
    ],
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
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
  "data": "drnele",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─status|int32|状态0未生效1正常2受限3锁定|false|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
└─spare1|string|备用1|false|-
└─spare2|string|备用2|false|-
└─roleIds|array|角色组|false|-
└─positionIds|array|岗位组|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/disable/{id}.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:45",
    "lastTime": "2025-09-22 22:45:45",
    "id": 370,
    "userId": "119",
    "organId": "119",
    "deptId": 706,
    "createType": 678,
    "name": "pauline.robel",
    "username": "pauline.robel",
    "mobile": "724.248.1428",
    "email": "leonard.grady@yahoo.com",
    "password": "gm86wc",
    "salt": "6m3llz",
    "imagePath": "qlkuf5",
    "adminType": "yl0uye",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "adminRange": "cf7bgj",
    "adminPerms": "illndg",
    "lastAppId": "119",
    "lastLoginTime": "2025-09-22 22:45:45",
    "lastLoginIp": "112.28.203.208",
    "loginCount": 652,
    "status": 332,
    "delFlag": 2,
    "spare1": "7pp8pj",
    "spare2": "vwa0qv",
    "roleIds": [
      580
    ],
    "positionIds": [
      "vyxauz"
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
  "data": "pws0dh",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:45",
    "lastTime": "2025-09-22 22:45:45",
    "id": 548,
    "userId": "119",
    "deptId": 331,
    "deptName": "pauline.robel",
    "organId": "119",
    "organName": "pauline.robel",
    "name": "pauline.robel",
    "username": "pauline.robel",
    "nickName": "heriberto.bahringer",
    "email": "leonard.grady@yahoo.com",
    "mobile": "724.248.1428",
    "imagePath": "kmka6u",
    "password": "gns0jh",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 521,
    "delFlag": 2,
    "lastLoginIp": "112.28.203.208",
    "lastLoginTime": "2025-09-22 22:45:45",
    "description": "n3sa5c",
    "dept": {
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:45",
      "lastTime": "2025-09-22 22:45:45",
      "id": 890,
      "organId": "119",
      "parentId": 710,
      "appId": "119",
      "depttypeId": 713,
      "foreignId": "119",
      "createType": 201,
      "type": "wdpdc2",
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "areaCode": "95555",
      "organLeader": "qbn4ak",
      "leaderId": "119",
      "leaderMobile": "724.248.1428",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "95555",
      "imagePath": "znptzc",
      "priority": 196,
      "status": 680,
      "delFlag": 2,
      "description": "xyon9t",
      "spare1": "5xthcn",
      "spare2": "x9llql",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:45",
        "lastTime": "2025-09-22 22:45:45",
        "id": 179,
        "roletypeId": "119",
        "appId": "119",
        "name": "pauline.robel",
        "code": "95555",
        "priority": 789,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 562,
        "description": "fq8qye",
        "areaType": "hf8glf"
      }
    ],
    "roleIds": [
      944
    ],
    "positionIds": [
      "5c7ems"
    ],
    "roleId": 836,
    "userRoleList": [
      {
        "id": 635,
        "deptId": 432,
        "deptName": "pauline.robel",
        "organId": "119",
        "organName": "pauline.robel",
        "roleId": 202,
        "roleName": "pauline.robel",
        "adminId": 199
      }
    ],
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
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
  "data": "q8qyzi",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "8rwyec",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/export.do --data 'orderBy=363&page=1&limit=10&status=9kbirc&endTime=2025-09-22 22:44:42&delFlag=2&email=leonard.grady@yahoo.com&nickName=heriberto.bahringer&organId=119&q=hd5gsq&mobile=724.248.1428&userId=119&username=pauline.robel&startTime=2025-09-22 22:44:42&adminId=6&deptId=775'
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
  "data": "gpqy5g",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "7a0785",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "c0k0ec",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 重置密码
**URL:** https://linlan.net/eframe_backend/api/admin/user/resetPwd.do

**Type:** PUT

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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
curl -X PUT -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/resetPwd.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:46",
    "lastTime": "2025-09-22 22:45:46",
    "id": 248,
    "userId": "119",
    "deptId": 674,
    "deptName": "pauline.robel",
    "organId": "119",
    "organName": "pauline.robel",
    "name": "pauline.robel",
    "username": "pauline.robel",
    "nickName": "heriberto.bahringer",
    "email": "leonard.grady@yahoo.com",
    "mobile": "724.248.1428",
    "imagePath": "47sg89",
    "password": "3ca4ae",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 791,
    "delFlag": 2,
    "lastLoginIp": "112.28.203.208",
    "lastLoginTime": "2025-09-22 22:45:46",
    "description": "f4axcf",
    "dept": {
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:46",
      "lastTime": "2025-09-22 22:45:46",
      "id": 16,
      "organId": "119",
      "parentId": 825,
      "appId": "119",
      "depttypeId": 611,
      "foreignId": "119",
      "createType": 838,
      "type": "ylaf2g",
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "areaCode": "95555",
      "organLeader": "nktfyw",
      "leaderId": "119",
      "leaderMobile": "724.248.1428",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "95555",
      "imagePath": "mrlies",
      "priority": 668,
      "status": 219,
      "delFlag": 2,
      "description": "2nj2qc",
      "spare1": "dkrwk0",
      "spare2": "eka47x",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:46",
        "lastTime": "2025-09-22 22:45:46",
        "id": 767,
        "roletypeId": "119",
        "appId": "119",
        "name": "pauline.robel",
        "code": "95555",
        "priority": 30,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 935,
        "description": "bjn3o5",
        "areaType": "8chwhc"
      }
    ],
    "roleIds": [
      66
    ],
    "positionIds": [
      "8d0yqe"
    ],
    "roleId": 215,
    "userRoleList": [
      {
        "id": 876,
        "deptId": 544,
        "deptName": "pauline.robel",
        "organId": "119",
        "organName": "pauline.robel",
        "roleId": 868,
        "roleName": "pauline.robel",
        "adminId": 782
      }
    ],
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
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
  "data": "7qcadv",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 用户状态修改
**URL:** https://linlan.net/eframe_backend/api/admin/user/changeStatus.do

**Type:** PUT

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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
curl -X PUT -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/changeStatus.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:46",
    "lastTime": "2025-09-22 22:45:46",
    "id": 27,
    "userId": "119",
    "deptId": 395,
    "deptName": "pauline.robel",
    "organId": "119",
    "organName": "pauline.robel",
    "name": "pauline.robel",
    "username": "pauline.robel",
    "nickName": "heriberto.bahringer",
    "email": "leonard.grady@yahoo.com",
    "mobile": "724.248.1428",
    "imagePath": "0x9jdu",
    "password": "nfgiud",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 322,
    "delFlag": 2,
    "lastLoginIp": "112.28.203.208",
    "lastLoginTime": "2025-09-22 22:45:46",
    "description": "odgokc",
    "dept": {
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:46",
      "lastTime": "2025-09-22 22:45:46",
      "id": 725,
      "organId": "119",
      "parentId": 21,
      "appId": "119",
      "depttypeId": 599,
      "foreignId": "119",
      "createType": 749,
      "type": "j7xrog",
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "areaCode": "95555",
      "organLeader": "ng6nsf",
      "leaderId": "119",
      "leaderMobile": "724.248.1428",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "95555",
      "imagePath": "al89gb",
      "priority": 33,
      "status": 62,
      "delFlag": 2,
      "description": "0rn4ed",
      "spare1": "3fcfiz",
      "spare2": "6zgltc",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:46",
        "lastTime": "2025-09-22 22:45:46",
        "id": 604,
        "roletypeId": "119",
        "appId": "119",
        "name": "pauline.robel",
        "code": "95555",
        "priority": 342,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 743,
        "description": "023us5",
        "areaType": "wyhk24"
      }
    ],
    "roleIds": [
      822
    ],
    "positionIds": [
      "yahx02"
    ],
    "roleId": 493,
    "userRoleList": [
      {
        "id": 680,
        "deptId": 482,
        "deptName": "pauline.robel",
        "organId": "119",
        "organName": "pauline.robel",
        "roleId": 321,
        "roleName": "pauline.robel",
        "adminId": 650
      }
    ],
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
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
  "data": "lg12ra",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole/135.do
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
  "data": "gavp49",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 用户授权角色
**URL:** https://linlan.net/eframe_backend/api/admin/user/authRole.do

**Type:** PUT

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
curl -X PUT -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole.do --data 'adminId=908&roleIds=zq1rrj&roleIds=zq1rrj'
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
  "data": "2x598o",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## AdminUser控制域:管理用户查询读取控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/list.do?q=mkgznt&userId=119&orderBy=438&startTime=2025-09-22 22:44:42&endTime=2025-09-22 22:44:42&adminId=398&organId=119&page=1&email=leonard.grady@yahoo.com&mobile=724.248.1428&username=pauline.robel&status=r20j90&delFlag=2&deptId=488&nickName=heriberto.bahringer&limit=10
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:45",
      "lastTime": "2025-09-22 22:45:45",
      "id": 71,
      "userId": "119",
      "deptId": 210,
      "deptName": "pauline.robel",
      "organId": "119",
      "organName": "pauline.robel",
      "name": "pauline.robel",
      "username": "pauline.robel",
      "nickName": "heriberto.bahringer",
      "email": "leonard.grady@yahoo.com",
      "mobile": "724.248.1428",
      "imagePath": "8n3vqj",
      "password": "njc65x",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 592,
      "delFlag": 2,
      "lastLoginIp": "112.28.203.208",
      "lastLoginTime": "2025-09-22 22:45:45",
      "description": "6c10kp",
      "dept": {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:45",
        "lastTime": "2025-09-22 22:45:45",
        "id": 885,
        "organId": "119",
        "parentId": 836,
        "appId": "119",
        "depttypeId": 11,
        "foreignId": "119",
        "createType": 2,
        "type": "wt818x",
        "name": "pauline.robel",
        "sname": "pauline.robel",
        "areaCode": "95555",
        "organLeader": "pfgc6c",
        "leaderId": "119",
        "leaderMobile": "724.248.1428",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "95555",
        "imagePath": "se38b7",
        "priority": 467,
        "status": 0,
        "delFlag": 2,
        "description": "on31hd",
        "spare1": "h17gu4",
        "spare2": "ozuwtr",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "119",
          "createTime": "2025-09-22 22:45:45",
          "lastTime": "2025-09-22 22:45:45",
          "id": 344,
          "roletypeId": "119",
          "appId": "119",
          "name": "pauline.robel",
          "code": "95555",
          "priority": 999,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 690,
          "description": "uq7jn0",
          "areaType": "msxivs"
        }
      ],
      "roleIds": [
        577
      ],
      "positionIds": [
        "s972t9"
      ],
      "roleId": 211,
      "userRoleList": [
        {
          "id": 284,
          "deptId": 366,
          "deptName": "pauline.robel",
          "organId": "119",
          "organName": "pauline.robel",
          "roleId": 788,
          "roleName": "pauline.robel",
          "adminId": 549
        }
      ],
      "code": "95555",
      "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 根据用户编号获取详细信息
**URL:** https://linlan.net/eframe_backend/api/admin/user/;	https:/linlan.net/eframe_backend/api/admin/user/{adminId}.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据用户编号获取详细信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态（0未生效1正常2受限3锁定）|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:45",
      "lastTime": "2025-09-22 22:45:45",
      "id": 624,
      "userId": "119",
      "deptId": 870,
      "deptName": "pauline.robel",
      "organId": "119",
      "organName": "pauline.robel",
      "name": "pauline.robel",
      "username": "pauline.robel",
      "nickName": "heriberto.bahringer",
      "email": "leonard.grady@yahoo.com",
      "mobile": "724.248.1428",
      "imagePath": "oju64o",
      "password": "l6z255",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 275,
      "delFlag": 2,
      "lastLoginIp": "112.28.203.208",
      "lastLoginTime": "2025-09-22 22:45:45",
      "description": "37eqqx",
      "dept": {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:45",
        "lastTime": "2025-09-22 22:45:45",
        "id": 569,
        "organId": "119",
        "parentId": 562,
        "appId": "119",
        "depttypeId": 0,
        "foreignId": "119",
        "createType": 535,
        "type": "lib4ah",
        "name": "pauline.robel",
        "sname": "pauline.robel",
        "areaCode": "95555",
        "organLeader": "ny6bqe",
        "leaderId": "119",
        "leaderMobile": "724.248.1428",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "95555",
        "imagePath": "ono2rg",
        "priority": 623,
        "status": 794,
        "delFlag": 2,
        "description": "hqv5bb",
        "spare1": "7zz76y",
        "spare2": "r6u7bb",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "119",
          "createTime": "2025-09-22 22:45:45",
          "lastTime": "2025-09-22 22:45:45",
          "id": 844,
          "roletypeId": "119",
          "appId": "119",
          "name": "pauline.robel",
          "code": "95555",
          "priority": 613,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 917,
          "description": "mqcucc",
          "areaType": "rvzpff"
        }
      ],
      "roleIds": [
        735
      ],
      "positionIds": [
        "lvwa3p"
      ],
      "roleId": 812,
      "userRoleList": [
        {
          "id": 284,
          "deptId": 757,
          "deptName": "pauline.robel",
          "organId": "119",
          "organName": "pauline.robel",
          "roleId": 537,
          "roleName": "pauline.robel",
          "adminId": 377
        }
      ],
      "code": "95555",
      "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
    },
    "roles": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:45",
        "lastTime": "2025-09-22 22:45:45",
        "roleId": 483,
        "roleName": "pauline.robel",
        "roleKey": "xiodru",
        "roleSort": 64,
        "menuCheckStrictly": true,
        "deptCheckStrictly": true,
        "status": 492,
        "flag": true,
        "menuIds": [
          317
        ],
        "deptIds": [
          373
        ],
        "permissions": [
          "besqo8"
        ],
        "remark": "0p0znc",
        "parentName": "pauline.robel",
        "appName": "pauline.robel",
        "roletypeId": "119",
        "roletypeName": "pauline.robel",
        "priority": 545,
        "isSuper": true
      }
    ],
    "roleList": [
      {
        "id": 725,
        "roleId": 496,
        "adminId": 661,
        "deptId": 954,
        "deptName": "pauline.robel",
        "organId": "119",
        "organName": "pauline.robel",
        "roleName": "pauline.robel"
      }
    ],
    "positions": [
      {
        "postId": "119",
        "postCode": "95555",
        "postName": "pauline.robel",
        "postSort": 98,
        "status": 277,
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:45",
        "lastTime": "2025-09-22 22:45:45",
        "delFlag": 2,
        "remark": "tx8cvx",
        "ids": [
          "8nvh7i"
        ],
        "positionId": "119",
        "flag": true
      }
    ],
    "roleIds": [
      215
    ],
    "positionIds": [
      922
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
status|int32|状态0未生效1正常2受限3锁定|false|-
creatorId|string|创建用户ID|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/deptTree.do?description=zeeu31&spare1=4m4pz3&delFlag=2&startTime=2025-09-22 22:44:42&page=1&type=wk1z5m&sname=pauline.robel&deptId=62&createType=505&isLeaf=true&areaCode=95555&name=pauline.robel&endTime=2025-09-22 22:44:42&orderBy=869&searchCode=95555&appId=119&depttypeId=428&leaderMobile=724.248.1428&isDisabled=true&imagePath=qqd1vy&q=d311ow&leaderId=119&organLeader=i8mo9f&parentId=288&status=191&isVirtual=true&spare2=wp9ihk&foreignId=119&creatorId=119&limit=10&isOrganLevel=true&organId=119
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
      "id": 393,
      "label": "vgurma",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## App控制域:应用管理读写控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/selectList.do?isSite=true&status=99&delFlag=2&orderBy=235&limit=10&q=u769y4&domainId=119&sertypeId=119&description=85v3t2&endTime=2025-09-22 22:44:42&existKey=fgr6f7&xzqhId=30&ftpId=119&isDisabled=true&path=vmubb7&appType=32sl1r&mode=154&organId=119&isMobileApp=true&page=1&name=pauline.robel&startTime=2025-09-22 22:44:42&ids=j2fqok&ids=j2fqok
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:51",
      "lastTime": "2025-09-22 22:45:51",
      "id": "119",
      "ftpId": "119",
      "domainId": "119",
      "organId": "119",
      "xzqhId": 698,
      "sertypeId": "119",
      "name": "pauline.robel",
      "path": "w1rone",
      "appType": "r0jimd",
      "isSite": true,
      "isDisabled": true,
      "isMobileApp": true,
      "status": 36,
      "priority": 953,
      "delFlag": 2,
      "deleteTime": "2025-09-22 22:45:51",
      "description": "m83p9k",
      "spare1": "mdfzgp",
      "spare2": "pek96u",
      "xzqhName": "pauline.robel"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/list.do?name=pauline.robel&isSite=true&domainId=119&isMobileApp=true&organId=119&status=122&ftpId=119&path=xjpl01&startTime=2025-09-22 22:44:42&xzqhId=965&idArr=4e2iov&sertypeId=119&delFlag=2&orderBy=552&ids=a36h6b&ids=a36h6b&isDisabled=true&limit=10&page=1&q=5ufdap&endTime=2025-09-22 22:44:42&appType=sd2jb9&existKey=rb2ubp&mode=820&description=lgnu12
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
    "totalCount": 17,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:51",
        "lastTime": "2025-09-22 22:45:51",
        "id": "119",
        "ftpId": "119",
        "domainId": "119",
        "organId": "119",
        "xzqhId": 637,
        "sertypeId": "119",
        "name": "pauline.robel",
        "path": "4xnmy0",
        "appType": "7ddkbl",
        "isSite": true,
        "isDisabled": true,
        "isMobileApp": true,
        "status": 648,
        "priority": 379,
        "delFlag": 2,
        "deleteTime": "2025-09-22 22:45:51",
        "description": "4efpd5",
        "spare1": "qlvs1g",
        "spare2": "2qsz9o",
        "xzqhName": "pauline.robel"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/export.do --data 'ftpId=119&isSite=true&appType=s36hxj&delFlag=2&q=c1bgez&organId=119&xzqhId=76&orderBy=385&endTime=2025-09-22 22:44:42&isDisabled=true&status=492&name=pauline.robel&page=1&isMobileApp=true&sertypeId=119&limit=10&path=ahswd7&description=q0jhlg&existKey=1y4emj&ids=4mej6p&ids=4mej6p&idArr=gtkj5l&startTime=2025-09-22 22:44:42&mode=770&domainId=119'
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
  "data": "wcczt2",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/119.do
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:52",
    "lastTime": "2025-09-22 22:45:52",
    "id": "119",
    "ftpId": "119",
    "domainId": "119",
    "organId": "119",
    "xzqhId": 775,
    "sertypeId": "119",
    "name": "pauline.robel",
    "path": "pndaw7",
    "appType": "z7jgjh",
    "isSite": true,
    "isDisabled": true,
    "isMobileApp": true,
    "status": 563,
    "priority": 964,
    "delFlag": 2,
    "deleteTime": "2025-09-22 22:45:52",
    "description": "k8c167",
    "spare1": "lw9zs4",
    "spare2": "fr9wsz",
    "xzqhName": "pauline.robel",
    "ftpName": "pauline.robel",
    "sertypeName": "pauline.robel",
    "domainName": "pauline.robel",
    "organName": "pauline.robel"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "id": "119",
    "ftpId": "119",
    "ftpName": "pauline.robel",
    "domainId": "119",
    "domainName": "pauline.robel",
    "organId": "119",
    "organName": "pauline.robel",
    "xzqhId": 975,
    "xzqhName": "pauline.robel",
    "sertypeId": "119",
    "sertypeName": "pauline.robel",
    "name": "pauline.robel",
    "path": "euv67b",
    "appType": "rjsl4k",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 108,
    "statusName": "pauline.robel",
    "priority": 628,
    "createTime": "2025-09-22 22:45:52",
    "description": "2kdsvb",
    "spare1": "m5x8uc",
    "statusMap": {
      "mapKey": "3pqr3s"
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
  "data": "l7l0nk",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "id": "119",
    "ftpId": "119",
    "ftpName": "pauline.robel",
    "domainId": "119",
    "domainName": "pauline.robel",
    "organId": "119",
    "organName": "pauline.robel",
    "xzqhId": 566,
    "xzqhName": "pauline.robel",
    "sertypeId": "119",
    "sertypeName": "pauline.robel",
    "name": "pauline.robel",
    "path": "cfarrq",
    "appType": "v5pd3m",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 59,
    "statusName": "pauline.robel",
    "priority": 441,
    "createTime": "2025-09-22 22:45:52",
    "description": "1vtp1a",
    "spare1": "ay2k6z",
    "statusMap": {
      "mapKey": "0c8qw2"
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
  "data": "noi5a6",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "egnyzy",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/init/119.do --data '{
  "data": {
    "id": "119",
    "menuJsons": {
      "size": 10
    },
    "initJson": {},
    "username": "pauline.robel",
    "password": "rjhbru",
    "initPath": "8jtoln"
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
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "vzf27d",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/xzqh/list.do?q=ymkfka&name=pauline.robel&parentId=96&hasContent=true&code=95555&countryId=119&sname=pauline.robel&ids=qyvy4h&ids=qyvy4h&isDisplay=true&likeQuery=k5k5zz&delFlag=2&description=il6nf2&rgt=673&limit=10&parentIds=8ymu63&parentIds=8ymu63&page=1&nameTotal=s6rt77&areatypeIds=ujd8oc&areatypeIds=ujd8oc&endTime=2025-09-22 22:44:42&searchCode=95555&areatypeId=119&deleteTime=2025-09-22 22:44:42&lft=302&nameEn=alld0y&orderBy=488&startTime=2025-09-22 22:44:42
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
    "totalCount": 394,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:52",
        "lastTime": "2025-09-22 22:45:52",
        "id": 394,
        "parentId": 517,
        "countryId": "119",
        "areatypeId": "119",
        "lft": 310,
        "rgt": 912,
        "code": "95555",
        "name": "pauline.robel",
        "nameTotal": "e7lfco",
        "sname": "pauline.robel",
        "nameEn": "hwd54n",
        "searchCode": "95555",
        "isDisplay": true,
        "hasContent": true,
        "priority": 597,
        "delFlag": 2,
        "deleteTime": "2025-09-22 22:45:52",
        "description": "iq459q",
        "countryName": "pauline.robel",
        "parentName": "pauline.robel",
        "areatypeName": "pauline.robel"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/organ/list.do?createType=691&spare1=wh7m1z&startTime=2025-09-22 22:44:42&xzqhId=919&organCode=95555&ids=z1if4h&ids=z1if4h&source=581&delFlag=2&unionCode=95555&page=1&description=1cmysn&spare2=boq8ll&organName=pauline.robel&key=ptnbx9&isOrganWork=9eioh2&orderBy=306&name=pauline.robel&q=f5v25x&endTime=2025-09-22 22:44:42&limit=10&orgtypeId=119
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
    "totalCount": 815,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:52",
        "lastTime": "2025-09-22 22:45:52",
        "cmsKey": "ojfzvp",
        "cmsValue": "xjtvrl"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## BaseXzqh控制域:行政区划管理读写控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/list.do?description=km926z&sname=pauline.robel&endTime=2025-09-22 22:44:42&hasContent=true&lft=235&areatypeIds=pmllfj&areatypeIds=pmllfj&orderBy=224&nameTotal=13s8dt&limit=10&rgt=787&nameEn=ceigoq&searchCode=95555&page=1&countryId=119&parentId=224&code=95555&name=pauline.robel&likeQuery=n55j78&startTime=2025-09-22 22:44:42&q=t2upeg&isDisplay=true&deleteTime=2025-09-22 22:44:42&ids=mpx8b1&ids=mpx8b1&areatypeId=119&delFlag=2&parentIds=no38bu&parentIds=no38bu
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:52",
      "lastTime": "2025-09-22 22:45:52",
      "id": 283,
      "parentId": 732,
      "countryId": "119",
      "areatypeId": "119",
      "lft": 870,
      "rgt": 744,
      "code": "95555",
      "name": "pauline.robel",
      "nameTotal": "6b9r84",
      "sname": "pauline.robel",
      "nameEn": "riq9gj",
      "searchCode": "95555",
      "isDisplay": true,
      "hasContent": true,
      "priority": 29,
      "delFlag": 2,
      "deleteTime": "2025-09-22 22:45:52",
      "description": "qbg1vr"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/export.do --data 'delFlag=2&page=1&parentIds=rhapu9&parentIds=rhapu9&name=pauline.robel&code=95555&nameEn=kiwdlb&startTime=2025-09-22 22:44:42&areatypeIds=5ut4x4&areatypeIds=5ut4x4&q=wlammy&hasContent=true&lft=9&deleteTime=2025-09-22 22:44:42&description=i5n5xn&isDisplay=true&searchCode=95555&likeQuery=t9qicj&orderBy=420&areatypeId=119&nameTotal=xbo5hf&countryId=119&endTime=2025-09-22 22:44:42&parentId=423&ids=k0a6lr&ids=k0a6lr&sname=pauline.robel&rgt=468&limit=10'
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
  "data": "tlnehl",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:52",
    "lastTime": "2025-09-22 22:45:52",
    "id": 897,
    "parentId": 683,
    "countryId": "119",
    "areatypeId": "119",
    "lft": 551,
    "rgt": 731,
    "code": "95555",
    "name": "pauline.robel",
    "nameTotal": "217wkj",
    "sname": "pauline.robel",
    "nameEn": "g8by48",
    "searchCode": "95555",
    "isDisplay": true,
    "hasContent": true,
    "priority": 113,
    "delFlag": 2,
    "deleteTime": "2025-09-22 22:45:52",
    "description": "o1lym6"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:52",
    "lastTime": "2025-09-22 22:45:52",
    "id": 920,
    "parentId": 743,
    "countryId": "119",
    "areatypeId": "119",
    "lft": 266,
    "rgt": 245,
    "code": "95555",
    "name": "pauline.robel",
    "nameTotal": "1hsgv2",
    "sname": "pauline.robel",
    "nameEn": "wlssge",
    "searchCode": "95555",
    "isDisplay": true,
    "hasContent": true,
    "priority": 984,
    "delFlag": 2,
    "deleteTime": "2025-09-22 22:45:52",
    "description": "5p24rt"
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
  "data": "s7soxb",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:53",
    "lastTime": "2025-09-22 22:45:53",
    "id": 597,
    "parentId": 201,
    "countryId": "119",
    "areatypeId": "119",
    "lft": 383,
    "rgt": 136,
    "code": "95555",
    "name": "pauline.robel",
    "nameTotal": "eyfrha",
    "sname": "pauline.robel",
    "nameEn": "gz4zsz",
    "searchCode": "95555",
    "isDisplay": true,
    "hasContent": true,
    "priority": 332,
    "delFlag": 2,
    "deleteTime": "2025-09-22 22:45:53",
    "description": "vj4pjg"
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
  "data": "01ayom",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "15qbhr",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## CoreAccount控制域:平台账号信息读写控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/list.do?serverConf3=77fdsk&currCount=384&status=907&organId=119&aesKey=dzrbyx&q=1bud6h&isAdmin=true&description=yjtnr7&serverConf1=ihye1i&spare1=y5br1q&endTime=2025-09-22 22:44:42&cname=pauline.robel&isDisabled=true&clientId=119&isSingle=true&clientSecret=k29ml9&spare2=3a9j9s&page=1&aesIvKey=yk8c1z&serverType=jxbynt&inoutMode=305&name=pauline.robel&serverConf2=3udnvy&organName=pauline.robel&confLimit=10&startTime=2025-09-22 22:44:42&limit=10&id=119&type=412&appId=119&orderBy=884&serverUrl=www.chanda-skiles.net&serverIp=112.28.203.208
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
└─name|string|对接系统或账户名称|-
└─cname|string|对接系统名称中文|-
└─type|int32|对接系统类型1平台应用2APP应用3外部接口|-
└─clientId|string|对接系统CLIENTID，或CORPID|-
└─clientSecret|string|客户密钥|-
└─aesKey|string|AES加解密密钥，备用|-
└─aesIvKey|string|AES iv key，备用|-
└─serverIp|string|对接服务器IP地址或域名|-
└─serverType|string|对接服务器类型，授权类型|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:54",
      "lastTime": "2025-09-22 22:45:54",
      "id": "119",
      "organId": "119",
      "appId": "119",
      "organName": "pauline.robel",
      "inoutMode": 272,
      "name": "pauline.robel",
      "cname": "pauline.robel",
      "type": 347,
      "clientId": "119",
      "clientSecret": "2hhlio",
      "aesKey": "n2th4j",
      "aesIvKey": "dyaih3",
      "serverIp": "112.28.203.208",
      "serverType": "dg619p",
      "serverUrl": "www.chanda-skiles.net",
      "serverConf1": "ahtdvs",
      "serverConf2": "mq6o16",
      "serverConf3": "46m2ew",
      "currCount": 300,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 703,
      "description": "0voqp1",
      "spare1": "wx0kok",
      "spare2": "239bw3",
      "inOrganName": "pauline.robel",
      "userName": "pauline.robel",
      "appName": "pauline.robel",
      "inoutModeName": "pauline.robel",
      "typeName": "pauline.robel"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/getClientSecret.do?clientId=119
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
└─name|string|对接系统或账户名称|-
└─cname|string|对接系统名称中文|-
└─type|int32|对接系统类型1平台应用2APP应用3外部接口|-
└─clientId|string|对接系统CLIENTID，或CORPID|-
└─clientSecret|string|客户密钥|-
└─aesKey|string|AES加解密密钥，备用|-
└─aesIvKey|string|AES iv key，备用|-
└─serverIp|string|对接服务器IP地址或域名|-
└─serverType|string|对接服务器类型，授权类型|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:54",
      "lastTime": "2025-09-22 22:45:54",
      "id": "119",
      "organId": "119",
      "appId": "119",
      "organName": "pauline.robel",
      "inoutMode": 979,
      "name": "pauline.robel",
      "cname": "pauline.robel",
      "type": 599,
      "clientId": "119",
      "clientSecret": "9oo6lt",
      "aesKey": "6zgtxg",
      "aesIvKey": "4janc6",
      "serverIp": "112.28.203.208",
      "serverType": "nsw3b8",
      "serverUrl": "www.chanda-skiles.net",
      "serverConf1": "36dd03",
      "serverConf2": "pl6exk",
      "serverConf3": "n2j1of",
      "currCount": 467,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 72,
      "description": "s013u7",
      "spare1": "m109mj",
      "spare2": "ahyukt",
      "inOrganName": "pauline.robel",
      "userName": "pauline.robel",
      "appName": "pauline.robel",
      "inoutModeName": "pauline.robel",
      "typeName": "pauline.robel"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/getKeyParity.do?id=119
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
└─name|string|对接系统或账户名称|-
└─cname|string|对接系统名称中文|-
└─type|int32|对接系统类型1平台应用2APP应用3外部接口|-
└─clientId|string|对接系统CLIENTID，或CORPID|-
└─clientSecret|string|客户密钥|-
└─aesKey|string|AES加解密密钥，备用|-
└─aesIvKey|string|AES iv key，备用|-
└─serverIp|string|对接服务器IP地址或域名|-
└─serverType|string|对接服务器类型，授权类型|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:54",
      "lastTime": "2025-09-22 22:45:54",
      "id": "119",
      "organId": "119",
      "appId": "119",
      "organName": "pauline.robel",
      "inoutMode": 757,
      "name": "pauline.robel",
      "cname": "pauline.robel",
      "type": 932,
      "clientId": "119",
      "clientSecret": "pdhk4u",
      "aesKey": "pe81a7",
      "aesIvKey": "3v1olo",
      "serverIp": "112.28.203.208",
      "serverType": "bajue1",
      "serverUrl": "www.chanda-skiles.net",
      "serverConf1": "cz9qel",
      "serverConf2": "y8s0wp",
      "serverConf3": "rrurxv",
      "currCount": 628,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 321,
      "description": "ebimyx",
      "spare1": "9zrfbe",
      "spare2": "anvj8x",
      "inOrganName": "pauline.robel",
      "userName": "pauline.robel",
      "appName": "pauline.robel",
      "inoutModeName": "pauline.robel",
      "typeName": "pauline.robel"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─name|string|对接系统或账户名称|-
└─cname|string|对接系统名称中文|-
└─type|int32|对接系统类型1平台应用2APP应用3外部接口|-
└─clientId|string|对接系统CLIENTID，或CORPID|-
└─clientSecret|string|客户密钥|-
└─aesKey|string|AES加解密密钥，备用|-
└─aesIvKey|string|AES iv key，备用|-
└─serverIp|string|对接服务器IP地址或域名|-
└─serverType|string|对接服务器类型，授权类型|-
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
{"success":true,"code":"0","msg":"正常","data":Error restful return.,"requestId":"119","timestamp":"2025-09-22 22:44:42"}
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
  "data": "03e76e",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "gar061",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "5sz20i",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## CoreOrgan控制域:系统机构表读写控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/list.do?limit=10&orderBy=958&organName=pauline.robel&startTime=2025-09-22 22:44:42&q=rhu2qc&page=1&endTime=2025-09-22 22:44:42&wlType=099mo9&organId=119&delFlag=2
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
        "dxtn9b"
      ],
      "organId": "119",
      "organName": "pauline.robel",
      "organSName": "pauline.robel",
      "organCode": "95555",
      "address": "417 Tajuana Harbors， Larryton， FL 55527",
      "wlType": "vwki6u",
      "wlTypeName": "pauline.robel",
      "priority": 827,
      "delFlag": 2,
      "createTime": "2025-09-22 22:45:53",
      "lastTime": "2025-09-22 22:45:53",
      "contactName": "pauline.robel",
      "contactEmail": "leonard.grady@yahoo.com",
      "contactMobile": "724.248.1428",
      "description": "vtnz10",
      "tel": "k24105"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
      "75dqix"
    ],
    "organId": "119",
    "organName": "pauline.robel",
    "organSName": "pauline.robel",
    "organCode": "95555",
    "address": "417 Tajuana Harbors， Larryton， FL 55527",
    "wlType": "rwm80j",
    "wlTypeName": "pauline.robel",
    "priority": 459,
    "delFlag": 2,
    "createTime": "2025-09-22 22:45:53",
    "lastTime": "2025-09-22 22:45:53",
    "contactName": "pauline.robel",
    "contactEmail": "leonard.grady@yahoo.com",
    "contactMobile": "724.248.1428",
    "description": "o18q9m",
    "tel": "uk29dr"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
      "1knukw"
    ],
    "organId": "119",
    "organName": "pauline.robel",
    "organSName": "pauline.robel",
    "organCode": "95555",
    "address": "417 Tajuana Harbors， Larryton， FL 55527",
    "wlType": "5f2xzt",
    "wlTypeName": "pauline.robel",
    "priority": 476,
    "delFlag": 2,
    "createTime": "2025-09-22 22:45:53",
    "lastTime": "2025-09-22 22:45:53",
    "contactName": "pauline.robel",
    "contactEmail": "leonard.grady@yahoo.com",
    "contactMobile": "724.248.1428",
    "description": "bgjh6x",
    "tel": "2ozr0t"
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
  "data": "nzfiwy",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
      "ujhm9l"
    ],
    "organId": "119",
    "organName": "pauline.robel",
    "organSName": "pauline.robel",
    "organCode": "95555",
    "address": "417 Tajuana Harbors， Larryton， FL 55527",
    "wlType": "rq94dv",
    "wlTypeName": "pauline.robel",
    "priority": 643,
    "delFlag": 2,
    "createTime": "2025-09-22 22:45:53",
    "lastTime": "2025-09-22 22:45:53",
    "contactName": "pauline.robel",
    "contactEmail": "leonard.grady@yahoo.com",
    "contactMobile": "724.248.1428",
    "description": "jttc59",
    "tel": "wg5xrd"
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
  "data": "v0cz9i",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "4o3wk9",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
      "cstt4u"
    ],
    "organId": "119",
    "organName": "pauline.robel",
    "organSName": "pauline.robel",
    "organCode": "95555",
    "address": "417 Tajuana Harbors， Larryton， FL 55527",
    "wlType": "fck4us",
    "wlTypeName": "pauline.robel",
    "priority": 337,
    "delFlag": 2,
    "createTime": "2025-09-22 22:45:53",
    "lastTime": "2025-09-22 22:45:53",
    "contactName": "pauline.robel",
    "contactEmail": "leonard.grady@yahoo.com",
    "contactMobile": "724.248.1428",
    "description": "bsh8ui",
    "tel": "x6he9z"
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
  "data": "0fzalw",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## CoreRighttype控制域:权限分类读写控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/list.do?q=bmzs4b&startTime=2025-09-22 22:44:42&endTime=2025-09-22 22:44:42&page=1&orderBy=824&delFlag=2&name=pauline.robel&limit=10&sname=pauline.robel&description=yeca1r
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:54",
      "lastTime": "2025-09-22 22:45:54",
      "id": "119",
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "priority": 867,
      "delFlag": 2,
      "description": "4yud8x"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/export.do --data 'startTime=2025-09-22 22:44:42&name=pauline.robel&page=1&delFlag=2&orderBy=647&endTime=2025-09-22 22:44:42&limit=10&description=pur85p&sname=pauline.robel&q=cdf5rf'
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
  "data": "o70fnb",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:54",
    "lastTime": "2025-09-22 22:45:54",
    "id": "119",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "priority": 686,
    "delFlag": 2,
    "description": "2wji7z"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:54",
    "lastTime": "2025-09-22 22:45:54",
    "id": "119",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "priority": 749,
    "delFlag": 2,
    "description": "yfcq94"
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
  "data": "jtzban",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:54",
    "lastTime": "2025-09-22 22:45:54",
    "id": "119",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "priority": 363,
    "delFlag": 2,
    "description": "vptujl"
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
  "data": "irz6fi",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "n7gkk7",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## CoreRoletype控制域:角色分类读写控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/list.do?endTime=2025-09-22 22:44:42&delFlag=2&description=wazf47&code=95555&existKey=d1mzx2&startTime=2025-09-22 22:44:42&orderBy=956&page=1&q=3njpt9&name=pauline.robel&limit=10&type=0g1yt7
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:54",
      "lastTime": "2025-09-22 22:45:54",
      "id": "119",
      "name": "pauline.robel",
      "type": "parhxg",
      "code": "95555",
      "priority": 527,
      "delFlag": 2,
      "description": "4m0xti"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/export.do --data 'orderBy=307&description=ww1ya7&name=pauline.robel&q=ffoeuv&existKey=26ydrd&type=9ilo7t&code=95555&startTime=2025-09-22 22:44:42&delFlag=2&endTime=2025-09-22 22:44:42&page=1&limit=10'
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
  "data": "rlhwbe",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:54",
    "lastTime": "2025-09-22 22:45:54",
    "id": "119",
    "name": "pauline.robel",
    "type": "6qw3s8",
    "code": "95555",
    "priority": 241,
    "delFlag": 2,
    "description": "3ku75w"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:54",
    "lastTime": "2025-09-22 22:45:54",
    "id": "119",
    "name": "pauline.robel",
    "type": "ls0f67",
    "code": "95555",
    "priority": 710,
    "delFlag": 2,
    "description": "akyiur"
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
  "data": "zgaiq6",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:54",
    "lastTime": "2025-09-22 22:45:54",
    "id": "119",
    "name": "pauline.robel",
    "type": "kf8cr5",
    "code": "95555",
    "priority": 600,
    "delFlag": 2,
    "description": "gnj1wq"
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
  "data": "rn8num",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "bphw8x",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## File控制域:公共文件管理读写控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/list.do?q=dyho47&limit=10&refId=119&endTime=2025-09-22 22:44:42&fileSize=968&resclassId=119&fileExtension=zjl183&orderBy=642&appId=119&fileIsvalid=true&fileName=pauline.robel&page=1&key=pzlkvw&startTime=2025-09-22 22:44:42&refType=cfhpfz
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
    "totalCount": 759,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "id": "119",
        "resclassId": "119",
        "fileName": "pauline.robel",
        "fileIsvalid": true,
        "createTime": "2025-09-22 22:45:53",
        "fileExtension": "bnhh3z",
        "ids": [
          "fpuvfg"
        ]
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/export.do --data 'refId=119&resclassId=119&fileName=pauline.robel&appId=119&limit=10&endTime=2025-09-22 22:44:42&page=1&fileIsvalid=true&fileExtension=s1fk0k&q=uaznay&orderBy=893&key=ezu68i&startTime=2025-09-22 22:44:42&fileSize=293&refType=av15ma'
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
  "data": "kq3mfu",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/info.do?id=119
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
    "id": "119",
    "resclassId": "119",
    "fileName": "pauline.robel",
    "fileIsvalid": true,
    "createTime": "2025-09-22 22:45:53",
    "fileExtension": "ekfb1c",
    "ids": [
      "m44pds"
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "id": "119",
    "resclassId": "119",
    "fileName": "pauline.robel",
    "fileIsvalid": true,
    "createTime": "2025-09-22 22:45:53",
    "fileExtension": "j6pcyv",
    "ids": [
      "yk29qr"
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
  "data": "o3tmjy",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "id": "119",
    "resclassId": "119",
    "fileName": "pauline.robel",
    "fileIsvalid": true,
    "createTime": "2025-09-22 22:45:53",
    "fileExtension": "2vewrx",
    "ids": [
      "ebdqvo"
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
  "data": "d0umkt",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "id": "119",
    "resclassId": "119",
    "fileName": "pauline.robel",
    "fileIsvalid": true,
    "createTime": "2025-09-22 22:45:53",
    "fileExtension": "7fsjbz",
    "ids": [
      "bzs2hm"
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
  "data": "iueq9y",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "4g2rhy",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download.do?delete=true&fileName=pauline.robel
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
  "data": "07av4y",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "originFilename": "pauline.robel",
    "filename": "pauline.robel",
    "fileType": "rs6p3z",
    "fileUrl": "www.chanda-skiles.net",
    "fileHttpUrl": "www.chanda-skiles.net",
    "statusCode": "95555"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
      "originFilename": "pauline.robel",
      "filename": "pauline.robel",
      "fileType": "ukm6q1",
      "fileUrl": "www.chanda-skiles.net",
      "fileHttpUrl": "www.chanda-skiles.net",
      "statusCode": "95555"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download/resource.do?resource=rppcd0
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
  "data": "xfo2lz",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## PowerPreset控制域: 用户权限预置
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/list.do?status=816&groupId=205&limit=10&keyWords=d61yzk&batchId=119&type=6p82oh&roleTypeId=119&endTime=2025-09-22 22:44:42&appId=119&areaId=50&positionId=119&page=1&startTime=2025-09-22 22:44:42&orderBy=433&q=ldson6&organId=119
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
    "totalCount": 258,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:49",
        "lastTime": "2025-09-22 22:45:49",
        "id": 605,
        "appId": "119",
        "saveSource": "u6vq43",
        "unitName": "pauline.robel",
        "name": "pauline.robel",
        "idNum": "zc8qlc",
        "duty": "3nycyz",
        "telephone": "484.704.3631",
        "mobile": "724.248.1428",
        "extInfo1": "4bncer",
        "extInfo2": "iy88zx",
        "extInfo3": "dl9i8r",
        "needInitUser": true,
        "userId": "119",
        "needInitOrgan": true,
        "organId": "119",
        "type": "wljkgl",
        "foreignUrl": "www.chanda-skiles.net",
        "bizType": 992,
        "bizOrganId": "119",
        "bizAreaId": 912,
        "bizGroupId": 329,
        "bizPower": "4xfh1d",
        "bizMultiInfo": "1g80uq",
        "needSetOrgan": true,
        "needSetArea": true,
        "needSetGroup": true,
        "needSetPower": true,
        "opUserId": "119",
        "opOrganId": "119",
        "opTime": "2025-09-22 22:45:49",
        "opInfo": "hxmbme",
        "priority": 54,
        "status": 706,
        "delFlag": 2,
        "dataBatch": "vq4uor",
        "dataVersion": 357,
        "updateTime": "2025-09-22 22:45:49",
        "syncMode": "di86gi",
        "syncTime": "2025-09-22 22:45:49",
        "description": "p5y3wm",
        "groupName": "pauline.robel",
        "positionName": "pauline.robel",
        "bizPowerName": "pauline.robel",
        "subdistrictName": "pauline.robel",
        "communityName": "pauline.robel"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/export.do --data 'appId=119&startTime=2025-09-22 22:44:42&positionId=119&endTime=2025-09-22 22:44:42&page=1&status=188&groupId=331&batchId=119&q=auxt8l&areaId=191&limit=10&roleTypeId=119&orderBy=480&type=fc9oa8&organId=119&keyWords=3gwxdu'
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
  "data": "ofy3sy",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/805.do
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:49",
    "lastTime": "2025-09-22 22:45:49",
    "id": 956,
    "appId": "119",
    "saveSource": "r3zz11",
    "unitName": "pauline.robel",
    "name": "pauline.robel",
    "idNum": "i81sll",
    "duty": "gyyqhd",
    "telephone": "484.704.3631",
    "mobile": "724.248.1428",
    "extInfo1": "ojdi35",
    "extInfo2": "prnti7",
    "extInfo3": "gst5qy",
    "needInitUser": true,
    "userId": "119",
    "needInitOrgan": true,
    "organId": "119",
    "type": "pxn52a",
    "foreignUrl": "www.chanda-skiles.net",
    "bizType": 332,
    "bizOrganId": "119",
    "bizAreaId": 764,
    "bizGroupId": 874,
    "bizPower": "bkqh1p",
    "bizMultiInfo": "e0lmxj",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "119",
    "opOrganId": "119",
    "opTime": "2025-09-22 22:45:49",
    "opInfo": "klvcqe",
    "priority": 702,
    "status": 474,
    "delFlag": 2,
    "dataBatch": "lqftrd",
    "dataVersion": 207,
    "updateTime": "2025-09-22 22:45:49",
    "syncMode": "6ni693",
    "syncTime": "2025-09-22 22:45:49",
    "description": "md46y5",
    "groupName": "pauline.robel",
    "positionName": "pauline.robel",
    "bizPowerName": "pauline.robel",
    "subdistrictName": "pauline.robel",
    "communityName": "pauline.robel"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:49",
    "lastTime": "2025-09-22 22:45:49",
    "id": 172,
    "appId": "119",
    "saveSource": "osfcfb",
    "unitName": "pauline.robel",
    "name": "pauline.robel",
    "idNum": "d15x9u",
    "duty": "8u4a4j",
    "telephone": "484.704.3631",
    "mobile": "724.248.1428",
    "extInfo1": "5nclgm",
    "extInfo2": "aesuqv",
    "extInfo3": "79ljxa",
    "needInitUser": true,
    "userId": "119",
    "needInitOrgan": true,
    "organId": "119",
    "type": "l4hqtw",
    "foreignUrl": "www.chanda-skiles.net",
    "bizType": 45,
    "bizOrganId": "119",
    "bizAreaId": 588,
    "bizGroupId": 634,
    "bizPower": "fpji8l",
    "bizMultiInfo": "rm6b5w",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "119",
    "opOrganId": "119",
    "opTime": "2025-09-22 22:45:49",
    "opInfo": "d936ub",
    "priority": 508,
    "status": 381,
    "delFlag": 2,
    "dataBatch": "8hhg5s",
    "dataVersion": 489,
    "updateTime": "2025-09-22 22:45:49",
    "syncMode": "ft9pah",
    "syncTime": "2025-09-22 22:45:49",
    "description": "55ox6v"
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
  "data": "7k348u",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:49",
    "lastTime": "2025-09-22 22:45:49",
    "id": 398,
    "appId": "119",
    "saveSource": "12mw4b",
    "unitName": "pauline.robel",
    "name": "pauline.robel",
    "idNum": "eweb5t",
    "duty": "6tkll6",
    "telephone": "484.704.3631",
    "mobile": "724.248.1428",
    "extInfo1": "a601wv",
    "extInfo2": "h3anx7",
    "extInfo3": "c5fivt",
    "needInitUser": true,
    "userId": "119",
    "needInitOrgan": true,
    "organId": "119",
    "type": "730xaj",
    "foreignUrl": "www.chanda-skiles.net",
    "bizType": 597,
    "bizOrganId": "119",
    "bizAreaId": 542,
    "bizGroupId": 183,
    "bizPower": "ruoh7x",
    "bizMultiInfo": "68kqwf",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "119",
    "opOrganId": "119",
    "opTime": "2025-09-22 22:45:49",
    "opInfo": "hpri0y",
    "priority": 393,
    "status": 36,
    "delFlag": 2,
    "dataBatch": "oclmu2",
    "dataVersion": 166,
    "updateTime": "2025-09-22 22:45:49",
    "syncMode": "nxt3pr",
    "syncTime": "2025-09-22 22:45:49",
    "description": "hm779c"
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
  "data": "rzfsr3",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "1lvccf",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "kuwb49",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## PublicNotice控制域:平台公共消息读写控制类
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
siteId|int64|站点ID|false|-
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list.do?limit=10&updatorId=119&endTime=2025-09-22 22:44:42&recvMemberId=119&imagePath=ahjlv4&recvTargetid=119&bizType=alcpzb&type=646&msgUrl=www.chanda-skiles.net&content=daejvv&recvOrganId=119&updateTime=2025-09-22 22:45:57&description=cnqgdl&readStatus=f0qubp&id=989&page=1&startTime=2025-09-22 22:44:42&recvGroupId=119&q=2wcwa8&iconStyle=v8tzx7&status=69&siteId=129&creatorId=119&orderBy=510&organId=119&title=sve18c&foreignId=119
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
└─siteId|int64|站点ID|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:57",
      "lastTime": "2025-09-22 22:45:57",
      "id": 636,
      "siteId": 820,
      "organId": "119",
      "bizType": "o16yzf",
      "type": 546,
      "title": "mgu2mp",
      "content": "b8eikb",
      "msgUrl": "www.chanda-skiles.net",
      "foreignId": "119",
      "imagePath": "0todpp",
      "iconStyle": "zutuzg",
      "recvMemberId": "119",
      "recvGroupId": "119",
      "recvOrganId": "119",
      "recvTargetid": "119",
      "status": 516,
      "updatorId": "119",
      "updateTime": "2025-09-22 22:45:57",
      "description": "sl344g"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
siteId|int64|站点ID|false|-
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list/myself.do?foreignId=119&organId=119&recvOrganId=119&creatorId=119&id=935&updateTime=2025-09-22 22:45:57&content=gnx7np&updatorId=119&orderBy=385&page=1&description=epby4e&siteId=110&limit=10&q=81zmjr&endTime=2025-09-22 22:44:42&msgUrl=www.chanda-skiles.net&iconStyle=qr07jx&type=917&bizType=hxa74z&recvGroupId=119&recvTargetid=119&title=pt60jv&imagePath=p8m6bz&status=211&startTime=2025-09-22 22:44:42&recvMemberId=119&readStatus=4bumnd
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
└─siteId|int64|站点ID|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:57",
      "lastTime": "2025-09-22 22:45:57",
      "id": 886,
      "siteId": 294,
      "organId": "119",
      "bizType": "ttq1z6",
      "type": 226,
      "title": "1hf5k3",
      "content": "isj8lb",
      "msgUrl": "www.chanda-skiles.net",
      "foreignId": "119",
      "imagePath": "hzj73t",
      "iconStyle": "wf9l7x",
      "recvMemberId": "119",
      "recvGroupId": "119",
      "recvOrganId": "119",
      "recvTargetid": "119",
      "status": 258,
      "updatorId": "119",
      "updateTime": "2025-09-22 22:45:57",
      "description": "cakqmj"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
siteId|int64|站点ID|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/export.do --data 'organId=119&creatorId=119&orderBy=494&title=oeijau&iconStyle=5db3nk&startTime=2025-09-22 22:44:42&msgUrl=www.chanda-skiles.net&recvOrganId=119&recvMemberId=119&q=tndnpv&limit=10&updateTime=2025-09-22 22:45:58&status=123&updatorId=119&endTime=2025-09-22 22:44:42&foreignId=119&description=7y3gbs&recvTargetid=119&id=170&page=1&type=849&siteId=791&bizType=ugr9tw&recvGroupId=119&content=2tihmf&imagePath=o7vwvr&readStatus=a8w97q'
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
  "data": "x7neib",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─siteId|int64|站点ID|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:58",
    "lastTime": "2025-09-22 22:45:58",
    "id": 86,
    "siteId": 719,
    "organId": "119",
    "bizType": "jmgwmo",
    "type": 893,
    "title": "tvvk5t",
    "content": "n6ryet",
    "msgUrl": "www.chanda-skiles.net",
    "foreignId": "119",
    "imagePath": "qpcnyu",
    "iconStyle": "elqgrg",
    "recvMemberId": "119",
    "recvGroupId": "119",
    "recvOrganId": "119",
    "recvTargetid": "119",
    "status": 831,
    "updatorId": "119",
    "updateTime": "2025-09-22 22:45:58",
    "description": "fj170c"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─siteId|int64|站点ID|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:58",
    "lastTime": "2025-09-22 22:45:58",
    "id": 593,
    "siteId": 850,
    "organId": "119",
    "bizType": "s07vju",
    "type": 239,
    "title": "41wbd9",
    "content": "b4it5w",
    "msgUrl": "www.chanda-skiles.net",
    "foreignId": "119",
    "imagePath": "udcwi9",
    "iconStyle": "tzga1z",
    "recvMemberId": "119",
    "recvGroupId": "119",
    "recvOrganId": "119",
    "recvTargetid": "119",
    "status": 771,
    "updatorId": "119",
    "updateTime": "2025-09-22 22:45:58",
    "description": "ejzvok"
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
  "data": "nsmtxk",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─siteId|int64|站点ID|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:58",
    "lastTime": "2025-09-22 22:45:58",
    "id": 558,
    "siteId": 267,
    "organId": "119",
    "bizType": "50ap0w",
    "type": 558,
    "title": "dq6x1t",
    "content": "jqwxu8",
    "msgUrl": "www.chanda-skiles.net",
    "foreignId": "119",
    "imagePath": "kmzk7p",
    "iconStyle": "xsa0qi",
    "recvMemberId": "119",
    "recvGroupId": "119",
    "recvOrganId": "119",
    "recvTargetid": "119",
    "status": 577,
    "updatorId": "119",
    "updateTime": "2025-09-22 22:45:58",
    "description": "f9g4s5"
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
  "data": "8gzk6z",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "4j48ri",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "zxuo4a",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "z18clz",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "jhxx3s",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "mapKey1": "dme6dm",
    "mapKey2": "nyaiop"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## PublicUnionMessage控制域:消息阅读读写控制类
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
siteId|int64|站点ID|false|-
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/list.do?msgCreateTime=2025-09-22 22:45:59&spare2=a3ca86&status=kw2369&msgTitle=ow10cn&limit=10&opOrganId=119&creatorId=119&type=6bck2b&description=c4eysr&msgOrganName=pauline.robel&bizType=cd4f3u&orderBy=508&msgAbstract=ediprf&msgType=927&msgUrl=www.chanda-skiles.net&q=r6dq6v&spare1=ck0xs1&startTime=2025-09-22 22:44:42&foreignId=119&endTime=2025-09-22 22:44:42&msgModuleId=119&msgAccountId=119&msgContent=vf3ulw&opOrganName=pauline.robel&opUserId=119&siteId=82&msgModuleName=pauline.robel&id=119&opTime=2025-09-22 22:45:59&msgUserName=pauline.robel&msgId=307&msgUserId=119&page=1&msgOrganId=119&msgLabels=un0zou&msgAccountName=pauline.robel
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
└─siteId|int64|站点ID|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:59",
      "lastTime": "2025-09-22 22:45:59",
      "id": "119",
      "siteId": 528,
      "foreignId": "119",
      "type": "4rlno7",
      "bizType": "kuc1pe",
      "msgCreateTime": "2025-09-22 22:45:59",
      "msgId": 945,
      "msgType": 680,
      "msgTitle": "q7ft98",
      "msgAbstract": "d9ausv",
      "msgAccountId": "119",
      "msgAccountName": "pauline.robel",
      "msgModuleId": "119",
      "msgModuleName": "pauline.robel",
      "msgUserId": "119",
      "msgUserName": "pauline.robel",
      "msgOrganId": "119",
      "msgOrganName": "pauline.robel",
      "msgUrl": "www.chanda-skiles.net",
      "msgLabels": "pr0qfr",
      "msgContent": "ltu0dh",
      "status": "fxadd3",
      "opUserId": "119",
      "opTime": "2025-09-22 22:45:59",
      "opOrganId": "119",
      "opOrganName": "pauline.robel",
      "description": "lk83zn",
      "spare1": "juaygq",
      "spare2": "9xm2ec"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
siteId|int64|站点ID|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/export.do --data 'q=7aovhb&id=119&msgLabels=7kgi7y&opTime=2025-09-22 22:45:59&msgContent=pwm8al&foreignId=119&description=xgyrg9&msgUserId=119&opOrganId=119&bizType=4wwwwj&spare2=wn3y8m&startTime=2025-09-22 22:44:42&siteId=687&msgTitle=vc4a6j&msgCreateTime=2025-09-22 22:45:59&msgAccountName=pauline.robel&orderBy=411&msgModuleName=pauline.robel&msgAbstract=e8k7ui&msgUserName=pauline.robel&msgAccountId=119&msgOrganId=119&msgOrganName=pauline.robel&creatorId=119&opOrganName=pauline.robel&msgModuleId=119&msgUrl=www.chanda-skiles.net&msgType=526&status=na440k&opUserId=119&endTime=2025-09-22 22:44:42&page=1&spare1=qu1l2f&msgId=406&type=01fojd&limit=10'
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
  "data": "6s6gof",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─siteId|int64|站点ID|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:59",
    "lastTime": "2025-09-22 22:45:59",
    "id": "119",
    "siteId": 993,
    "foreignId": "119",
    "type": "oecb24",
    "bizType": "2nc9b4",
    "msgCreateTime": "2025-09-22 22:45:59",
    "msgId": 746,
    "msgType": 46,
    "msgTitle": "8lzgwr",
    "msgAbstract": "cb9bo6",
    "msgAccountId": "119",
    "msgAccountName": "pauline.robel",
    "msgModuleId": "119",
    "msgModuleName": "pauline.robel",
    "msgUserId": "119",
    "msgUserName": "pauline.robel",
    "msgOrganId": "119",
    "msgOrganName": "pauline.robel",
    "msgUrl": "www.chanda-skiles.net",
    "msgLabels": "beoxrw",
    "msgContent": "6ch8rl",
    "status": "wwm180",
    "opUserId": "119",
    "opTime": "2025-09-22 22:45:59",
    "opOrganId": "119",
    "opOrganName": "pauline.robel",
    "description": "2zme68",
    "spare1": "ydueuu",
    "spare2": "fi220g"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─siteId|int64|站点ID|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:59",
    "lastTime": "2025-09-22 22:45:59",
    "id": "119",
    "siteId": 942,
    "foreignId": "119",
    "type": "rosaiu",
    "bizType": "eb3ho7",
    "msgCreateTime": "2025-09-22 22:45:59",
    "msgId": 24,
    "msgType": 412,
    "msgTitle": "jqprbn",
    "msgAbstract": "ia20js",
    "msgAccountId": "119",
    "msgAccountName": "pauline.robel",
    "msgModuleId": "119",
    "msgModuleName": "pauline.robel",
    "msgUserId": "119",
    "msgUserName": "pauline.robel",
    "msgOrganId": "119",
    "msgOrganName": "pauline.robel",
    "msgUrl": "www.chanda-skiles.net",
    "msgLabels": "prv05k",
    "msgContent": "yhcexb",
    "status": "e8krbo",
    "opUserId": "119",
    "opTime": "2025-09-22 22:45:59",
    "opOrganId": "119",
    "opOrganName": "pauline.robel",
    "description": "l9sma3",
    "spare1": "j4rgrn",
    "spare2": "la2yvp"
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
  "data": "l3lhl0",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─siteId|int64|站点ID|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:59",
    "lastTime": "2025-09-22 22:45:59",
    "id": "119",
    "siteId": 991,
    "foreignId": "119",
    "type": "xyv7km",
    "bizType": "av0rf7",
    "msgCreateTime": "2025-09-22 22:45:59",
    "msgId": 868,
    "msgType": 604,
    "msgTitle": "a9ntiv",
    "msgAbstract": "o4ynx3",
    "msgAccountId": "119",
    "msgAccountName": "pauline.robel",
    "msgModuleId": "119",
    "msgModuleName": "pauline.robel",
    "msgUserId": "119",
    "msgUserName": "pauline.robel",
    "msgOrganId": "119",
    "msgOrganName": "pauline.robel",
    "msgUrl": "www.chanda-skiles.net",
    "msgLabels": "3pewpk",
    "msgContent": "2taia3",
    "status": "1r3y0l",
    "opUserId": "119",
    "opTime": "2025-09-22 22:45:59",
    "opOrganId": "119",
    "opOrganName": "pauline.robel",
    "description": "0xr7yq",
    "spare1": "aztr53",
    "spare2": "c4a0i5"
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
  "data": "k1xs47",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "iatdb2",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/read/o8yy38.do
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
  "data": "qmmyqd",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## PublicUnionTodo控制域:统一待办读写控制类
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
siteId|int64|站点ID|false|-
foreignId|string|站点门户ID|false|-
type|string|类型，内部则关联GLOBAL_SERTYPE，外部则为OUT|false|-
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/list.do?endTime=2025-09-22 22:44:42&todoProcessName=pauline.robel&todoUserId=119&todoProcessInfo=8dzhy2&todoCreateTime=2025-09-22 22:46:00&todoName=pauline.robel&todoAccountId=119&limit=10&todoAbstract=59pmqn&type=wntrl6&todoUserName=pauline.robel&bizType=45xggw&opUserId=119&foreignId=119&status=14iydj&spare2=sf9nnx&creatorId=119&orderBy=63&page=1&todoOrganName=pauline.robel&startTime=2025-09-22 22:44:42&todoId=119&todoUrl=www.chanda-skiles.net&spare1=lipw6o&siteId=117&todoCurrInfo=xbq9jz&todoProcessStatus=dkc93a&todoAccountName=pauline.robel&todoNextInfo=pdu0d0&opOrganId=119&opOrganName=pauline.robel&description=d5csxm&todoOrganId=119&todoModuleName=pauline.robel&todoModuleId=119&todoContent=rzt0h7&todoLabels=62qvo7&todoType=xdvrj3&q=42xbm6&opTime=2025-09-22 22:46:00&id=119
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
└─siteId|int64|站点ID|-
└─foreignId|string|站点门户ID|-
└─type|string|类型，内部则关联GLOBAL_SERTYPE，外部则为OUT|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:46:00",
      "lastTime": "2025-09-22 22:46:00",
      "id": "119",
      "siteId": 224,
      "foreignId": "119",
      "type": "poyn73",
      "bizType": "n91oxs",
      "todoCreateTime": "2025-09-22 22:46:00",
      "todoId": "119",
      "todoType": "gwdwpt",
      "todoName": "pauline.robel",
      "todoAbstract": "4l86x4",
      "todoAccountId": "119",
      "todoAccountName": "pauline.robel",
      "todoModuleId": "119",
      "todoModuleName": "pauline.robel",
      "todoUserId": "119",
      "todoUserName": "pauline.robel",
      "todoOrganId": "119",
      "todoOrganName": "pauline.robel",
      "todoProcessName": "pauline.robel",
      "todoProcessStatus": "otxacs",
      "todoProcessInfo": "8nqoej",
      "todoCurrInfo": "dpffyu",
      "todoNextInfo": "agn4gl",
      "todoUrl": "www.chanda-skiles.net",
      "todoLabels": "3rxazl",
      "todoContent": "8oj8rx",
      "status": "1frlml",
      "opUserId": "119",
      "opTime": "2025-09-22 22:46:00",
      "opOrganId": "119",
      "opOrganName": "pauline.robel",
      "description": "9bqtvq",
      "spare1": "r2urbn",
      "spare2": "k674f9"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
siteId|int64|站点ID|false|-
foreignId|string|站点门户ID|false|-
type|string|类型，内部则关联GLOBAL_SERTYPE，外部则为OUT|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/export.do --data 'todoModuleName=pauline.robel&todoCurrInfo=uvrvge&todoOrganName=pauline.robel&todoOrganId=119&q=5na02s&todoAccountName=pauline.robel&todoLabels=tdzd7q&opTime=2025-09-22 22:46:00&startTime=2025-09-22 22:44:42&type=m0ym5z&todoType=sz5qbs&id=119&todoProcessInfo=btptc8&orderBy=869&endTime=2025-09-22 22:44:42&spare2=3f60rp&todoAccountId=119&todoUrl=www.chanda-skiles.net&todoModuleId=119&foreignId=119&todoAbstract=okv5gt&todoUserName=pauline.robel&todoProcessName=pauline.robel&creatorId=119&limit=10&description=qspfnh&spare1=bp2kfi&bizType=08qd0x&todoNextInfo=lfmcdf&todoContent=4bim2i&opUserId=119&todoId=119&todoUserId=119&page=1&siteId=547&status=ve8t0v&opOrganId=119&todoProcessStatus=md1x4j&opOrganName=pauline.robel&todoName=pauline.robel&todoCreateTime=2025-09-22 22:46:00'
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
  "data": "tkogdi",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─siteId|int64|站点ID|-
└─foreignId|string|站点门户ID|-
└─type|string|类型，内部则关联GLOBAL_SERTYPE，外部则为OUT|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:46:00",
    "lastTime": "2025-09-22 22:46:00",
    "id": "119",
    "siteId": 870,
    "foreignId": "119",
    "type": "k35zct",
    "bizType": "p3vpug",
    "todoCreateTime": "2025-09-22 22:46:00",
    "todoId": "119",
    "todoType": "l6dzes",
    "todoName": "pauline.robel",
    "todoAbstract": "rt2j22",
    "todoAccountId": "119",
    "todoAccountName": "pauline.robel",
    "todoModuleId": "119",
    "todoModuleName": "pauline.robel",
    "todoUserId": "119",
    "todoUserName": "pauline.robel",
    "todoOrganId": "119",
    "todoOrganName": "pauline.robel",
    "todoProcessName": "pauline.robel",
    "todoProcessStatus": "hjgsle",
    "todoProcessInfo": "aip9is",
    "todoCurrInfo": "mr3m1r",
    "todoNextInfo": "ydssze",
    "todoUrl": "www.chanda-skiles.net",
    "todoLabels": "0uerdx",
    "todoContent": "gfkrei",
    "status": "lbslst",
    "opUserId": "119",
    "opTime": "2025-09-22 22:46:00",
    "opOrganId": "119",
    "opOrganName": "pauline.robel",
    "description": "gc3wqz",
    "spare1": "26dons",
    "spare2": "vrq8pi"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─siteId|int64|站点ID|false|-
└─foreignId|string|站点门户ID|false|-
└─type|string|类型，内部则关联GLOBAL_SERTYPE，外部则为OUT|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:46:00",
    "lastTime": "2025-09-22 22:46:00",
    "id": "119",
    "siteId": 854,
    "foreignId": "119",
    "type": "dbz69z",
    "bizType": "rowrkf",
    "todoCreateTime": "2025-09-22 22:46:00",
    "todoId": "119",
    "todoType": "azgsuy",
    "todoName": "pauline.robel",
    "todoAbstract": "dd9j9k",
    "todoAccountId": "119",
    "todoAccountName": "pauline.robel",
    "todoModuleId": "119",
    "todoModuleName": "pauline.robel",
    "todoUserId": "119",
    "todoUserName": "pauline.robel",
    "todoOrganId": "119",
    "todoOrganName": "pauline.robel",
    "todoProcessName": "pauline.robel",
    "todoProcessStatus": "3l3pdo",
    "todoProcessInfo": "kkx8s9",
    "todoCurrInfo": "ne0g8d",
    "todoNextInfo": "phdimo",
    "todoUrl": "www.chanda-skiles.net",
    "todoLabels": "l0yfwe",
    "todoContent": "pgp5b2",
    "status": "0dwpt8",
    "opUserId": "119",
    "opTime": "2025-09-22 22:46:00",
    "opOrganId": "119",
    "opOrganName": "pauline.robel",
    "description": "7u8i0m",
    "spare1": "efwmgd",
    "spare2": "lvo6b0"
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
  "data": "rwhb3j",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─siteId|int64|站点ID|false|-
└─foreignId|string|站点门户ID|false|-
└─type|string|类型，内部则关联GLOBAL_SERTYPE，外部则为OUT|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:46:00",
    "lastTime": "2025-09-22 22:46:00",
    "id": "119",
    "siteId": 502,
    "foreignId": "119",
    "type": "uvcy5p",
    "bizType": "tgpsr6",
    "todoCreateTime": "2025-09-22 22:46:00",
    "todoId": "119",
    "todoType": "fqib2y",
    "todoName": "pauline.robel",
    "todoAbstract": "r4dj09",
    "todoAccountId": "119",
    "todoAccountName": "pauline.robel",
    "todoModuleId": "119",
    "todoModuleName": "pauline.robel",
    "todoUserId": "119",
    "todoUserName": "pauline.robel",
    "todoOrganId": "119",
    "todoOrganName": "pauline.robel",
    "todoProcessName": "pauline.robel",
    "todoProcessStatus": "aia6t8",
    "todoProcessInfo": "sqbe82",
    "todoCurrInfo": "yco4b1",
    "todoNextInfo": "t0x52x",
    "todoUrl": "www.chanda-skiles.net",
    "todoLabels": "js4h0f",
    "todoContent": "zitu4l",
    "status": "bl5cz1",
    "opUserId": "119",
    "opTime": "2025-09-22 22:46:00",
    "opOrganId": "119",
    "opOrganName": "pauline.robel",
    "description": "3coa3u",
    "spare1": "5694wp",
    "spare2": "x1jdb9"
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
  "data": "yz82kz",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "97wbf7",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 个人信息 业务处理
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─password|string|密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─authorities|array|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─adminId|int64|用户LID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userId|string|用户UUID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─appId|string|所属应用ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─deptId|int64|部门ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|用户机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─token|string|登录令牌|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─imagePath|string|头像地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─isSuperAdmin|boolean|是否超级管理员|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginIp|string|登录的IP地址|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginTime|int64|登录时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginBrowse|string|登录的浏览器|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginOs|string|登录的OS|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─expireTime|int64|过期时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─perms|array|权限列表|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userType|string|管理类型：ADMIN管理员，DEMO演示用户|-
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
      "username": "pauline.robel",
      "password": "lujek5",
      "authorities": [
        {
          "object": "any object"
        }
      ],
      "adminId": 46,
      "userId": "119",
      "appId": "119",
      "deptId": 409,
      "organId": "119",
      "token": "kugmnn",
      "imagePath": "v84l95",
      "isSuperAdmin": true,
      "loginIp": "112.28.203.208",
      "loginTime": 1758552282472,
      "loginBrowse": "8rd6rl",
      "loginOs": "sp6uf6",
      "expireTime": 1758552282472,
      "perms": [
        "u8nz7w"
      ],
      "userType": "x1a8dq"
    },
    "roleGroup": "hmg1o0",
    "positionGroup": "3l5cdz"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:46",
    "lastTime": "2025-09-22 22:45:46",
    "id": 168,
    "userId": "119",
    "deptId": 373,
    "deptName": "pauline.robel",
    "organId": "119",
    "organName": "pauline.robel",
    "name": "pauline.robel",
    "username": "pauline.robel",
    "nickName": "heriberto.bahringer",
    "email": "leonard.grady@yahoo.com",
    "mobile": "724.248.1428",
    "imagePath": "v9wimz",
    "password": "oz1e3r",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 87,
    "delFlag": 2,
    "lastLoginIp": "112.28.203.208",
    "lastLoginTime": "2025-09-22 22:45:46",
    "description": "9herrp",
    "dept": {
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:46",
      "lastTime": "2025-09-22 22:45:46",
      "id": 682,
      "organId": "119",
      "parentId": 416,
      "appId": "119",
      "depttypeId": 268,
      "foreignId": "119",
      "createType": 946,
      "type": "ekqzbk",
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "areaCode": "95555",
      "organLeader": "9qzvw9",
      "leaderId": "119",
      "leaderMobile": "724.248.1428",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "95555",
      "imagePath": "3w32bi",
      "priority": 900,
      "status": 948,
      "delFlag": 2,
      "description": "gdgaxo",
      "spare1": "6apm9c",
      "spare2": "owsuk7",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:46",
        "lastTime": "2025-09-22 22:45:46",
        "id": 447,
        "roletypeId": "119",
        "appId": "119",
        "name": "pauline.robel",
        "code": "95555",
        "priority": 315,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 632,
        "description": "zv36fb",
        "areaType": "l4mb69"
      }
    ],
    "roleIds": [
      117
    ],
    "positionIds": [
      "b8mpnp"
    ],
    "roleId": 206,
    "userRoleList": [
      {
        "id": 87,
        "deptId": 840,
        "deptName": "pauline.robel",
        "organId": "119",
        "organName": "pauline.robel",
        "roleId": 793,
        "roleName": "pauline.robel",
        "adminId": 199
      }
    ],
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:46",
    "lastTime": "2025-09-22 22:45:46",
    "id": 970,
    "userId": "119",
    "deptId": 553,
    "deptName": "pauline.robel",
    "organId": "119",
    "organName": "pauline.robel",
    "name": "pauline.robel",
    "username": "pauline.robel",
    "nickName": "heriberto.bahringer",
    "email": "leonard.grady@yahoo.com",
    "mobile": "724.248.1428",
    "imagePath": "rwmosi",
    "password": "i70kky",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 576,
    "delFlag": 2,
    "lastLoginIp": "112.28.203.208",
    "lastLoginTime": "2025-09-22 22:45:46",
    "description": "q83tv9",
    "dept": {
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:46",
      "lastTime": "2025-09-22 22:45:46",
      "id": 237,
      "organId": "119",
      "parentId": 867,
      "appId": "119",
      "depttypeId": 604,
      "foreignId": "119",
      "createType": 925,
      "type": "tgh0ns",
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "areaCode": "95555",
      "organLeader": "idtx8c",
      "leaderId": "119",
      "leaderMobile": "724.248.1428",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "95555",
      "imagePath": "5xxi0s",
      "priority": 624,
      "status": 115,
      "delFlag": 2,
      "description": "8e3fpc",
      "spare1": "liha2h",
      "spare2": "4sp958",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:46",
        "lastTime": "2025-09-22 22:45:46",
        "id": 365,
        "roletypeId": "119",
        "appId": "119",
        "name": "pauline.robel",
        "code": "95555",
        "priority": 632,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 107,
        "description": "4ale6s",
        "areaType": "mvd0vz"
      }
    ],
    "roleIds": [
      562
    ],
    "positionIds": [
      "t7n5k9"
    ],
    "roleId": 932,
    "userRoleList": [
      {
        "id": 800,
        "deptId": 823,
        "deptName": "pauline.robel",
        "organId": "119",
        "organName": "pauline.robel",
        "roleId": 735,
        "roleName": "pauline.robel",
        "adminId": 558
      }
    ],
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
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
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "oldPassword": "tn3ps9",
    "newPassword": "oeugl2"
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
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "imageUrl": "www.chanda-skiles.net"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 参数配置 信息操作处理
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/list.do?orderBy=50&endTime=2025-09-22 22:44:42&page=1&limit=10&configValue=jjlngd&configKey=v2mtnw&remark=71rdj5&q=rjex96&isDisabled=true&startTime=2025-09-22 22:44:42
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
    "totalCount": 842,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "configId": "119",
        "configKey": "43tjr5",
        "configValue": "odblal",
        "isDisabled": true,
        "remark": "9y3sfb"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/export.do --data 'page=1&configKey=mhu8zn&startTime=2025-09-22 22:44:42&configValue=ddz0lk&limit=10&q=o4s8d5&isDisabled=true&remark=6zycfv&orderBy=901&endTime=2025-09-22 22:44:42'
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
  "data": "jq6gul",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/119.do
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
    "configId": "119",
    "configKey": "ws45fh",
    "configValue": "3dybeb",
    "isDisabled": true,
    "remark": "q8blp7"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/configKey/8962c8.do
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
    "configId": "119",
    "configKey": "q2kts5",
    "configValue": "kc8rus",
    "isDisabled": true,
    "remark": "h7j4wb"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "configId": "119",
    "configKey": "iypnu7",
    "configValue": "tlma05",
    "isDisabled": true,
    "remark": "y8hp3y"
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
  "data": "4wc76y",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "configId": "119",
    "configKey": "uotmqy",
    "configValue": "6fizok",
    "isDisabled": true,
    "remark": "13ur8j"
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
  "data": "aolj4f",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "ieypir",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "vf7j8w",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/list.do?username=pauline.robel&ipaddr=gc7lr7
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
      "tokenId": "119",
      "deptName": "pauline.robel",
      "username": "pauline.robel",
      "ipaddr": "gy578q",
      "loginLocation": "x5bagv",
      "browser": "tgirid",
      "os": "b8jsry",
      "loginTime": 1758552282472
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/119.do
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
  "data": "iglkwc",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 字典类型信息
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/list.do?remark=ncjppv&endTime=2025-09-22 22:44:42&page=1&typeMode=224&q=lwmykw&typeId=119&typeClass=liytrm&key=ipan2m&startTime=2025-09-22 22:44:42&limit=10&status=tqaoc2&orderBy=418&name=pauline.robel
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
    "totalCount": 246,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "typeId": "119",
        "name": "pauline.robel",
        "typeClass": "k8bjh0",
        "typeRef": "twsuxd",
        "typeMode": 946,
        "searchCode": "95555",
        "priority": 838,
        "createTime": "2025-09-22 22:45:56",
        "status": 567,
        "remark": "yqt10g"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/export.do --data 'endTime=2025-09-22 22:44:42&startTime=2025-09-22 22:44:42&orderBy=43&page=1&q=tjvoc7&remark=7e5hau&name=pauline.robel&typeId=119&typeMode=261&typeClass=hqsg9l&status=5wrl99&limit=10&key=4p8nrs'
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
  "data": "80ccvt",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/119.do
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
    "typeId": "119",
    "name": "pauline.robel",
    "typeClass": "0e3rqq",
    "typeRef": "izllk3",
    "typeMode": 307,
    "searchCode": "95555",
    "priority": 574,
    "createTime": "2025-09-22 22:45:56",
    "status": 718,
    "remark": "gjh6iy"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "typeId": "119",
    "name": "pauline.robel",
    "typeClass": "vf073o",
    "typeRef": "t88mtx",
    "typeMode": 275,
    "searchCode": "95555",
    "priority": 772,
    "createTime": "2025-09-22 22:45:57",
    "status": 835,
    "remark": "rlzve9"
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
  "data": "5ga6wv",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "typeId": "119",
    "name": "pauline.robel",
    "typeClass": "0my11s",
    "typeRef": "oxozht",
    "typeMode": 193,
    "searchCode": "95555",
    "priority": 289,
    "createTime": "2025-09-22 22:45:57",
    "status": 863,
    "remark": "cvebzk"
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
  "data": "ieb58o",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "d3v98w",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "cf9k5z",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
      "typeId": "119",
      "name": "pauline.robel",
      "typeClass": "s19qff",
      "typeRef": "o0d2rt",
      "typeMode": 748,
      "searchCode": "95555",
      "priority": 732,
      "createTime": "2025-09-22 22:45:57",
      "status": 250,
      "remark": "rjoeqx"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 岗位信息操作处理
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
status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定|false|-
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/list.do?posType=p7ezyd&q=8hxbfv&name=pauline.robel&officePhone=484.704.3631&description=c98dek&id=119&status=749&parentId=119&sname=pauline.robel&positionId=119&startTime=2025-09-22 22:44:42&limit=10&posFunction=b8psoo&orderBy=724&roletypeId=119&postypeId=119&endTime=2025-09-22 22:44:42&posRank=612&mobilePhone=484.704.3631&page=1&oname=pauline.robel&isPub=true&code=95555&delFlag=2&createTime=2025-09-22 22:44:42&ids=p7ep0e&ids=p7ep0e&groupId=119&roleTypeId=119
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态（0未生效1正常2受限3锁定）|-
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
    "totalCount": 428,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "postId": "119",
        "postCode": "95555",
        "postName": "pauline.robel",
        "postSort": 208,
        "status": 838,
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:50",
        "lastTime": "2025-09-22 22:45:50",
        "delFlag": 2,
        "remark": "usr482",
        "ids": [
          "1wjxwm"
        ],
        "positionId": "119",
        "flag": true
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
status|int32|状态（0未生效1正常2受限3锁定）|false|-
delFlag|int32|删除标记（0正常 1删除）|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/export.do --data 'limit=10&q=hbru1g&postCode=95555&endTime=2025-09-22 22:44:42&orderBy=234&startTime=2025-09-22 22:44:42&status=114&postName=pauline.robel&delFlag=2&page=1'
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
  "data": "j0y40g",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/119.do
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
└─status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:50",
    "lastTime": "2025-09-22 22:45:50",
    "id": "119",
    "parentId": "119",
    "postypeId": "119",
    "roletypeId": "119",
    "userId": "119",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "code": "95555",
    "oname": "pauline.robel",
    "posFunction": "jostcf",
    "posRank": 158,
    "posType": "07fy7d",
    "editorType": "bq4vx3",
    "isEditorCreate": true,
    "status": 339,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "119",
    "manageDeptids": "nj3nb0",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "484.704.3631",
    "officePhone": "484.704.3631",
    "buildingId": "119",
    "roomNo": "79oos0",
    "extQmType": "d0807s",
    "extQmTypePhoto": "hp9bpx",
    "extPosName": "pauline.robel",
    "extOrganName": "pauline.robel",
    "priority": 189,
    "priorityInOrgan": 179,
    "priorityInDomain": 314,
    "updaterId": "119",
    "updateTime": "2025-09-22 22:45:50",
    "delFlag": 2,
    "description": "pr92so",
    "remark": "2lr50r"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:50",
    "lastTime": "2025-09-22 22:45:50",
    "id": "119",
    "parentId": "119",
    "postypeId": "119",
    "roletypeId": "119",
    "userId": "119",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "code": "95555",
    "oname": "pauline.robel",
    "posFunction": "5p7c4w",
    "posRank": 334,
    "posType": "twarim",
    "editorType": "nbixxu",
    "isEditorCreate": true,
    "status": 483,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "119",
    "manageDeptids": "2qawr7",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "484.704.3631",
    "officePhone": "484.704.3631",
    "buildingId": "119",
    "roomNo": "stjv7u",
    "extQmType": "h99m2f",
    "extQmTypePhoto": "56ao8f",
    "extPosName": "pauline.robel",
    "extOrganName": "pauline.robel",
    "priority": 477,
    "priorityInOrgan": 851,
    "priorityInDomain": 948,
    "updaterId": "119",
    "updateTime": "2025-09-22 22:45:50",
    "delFlag": 2,
    "description": "c9vpgt",
    "remark": "8lk190",
    "parentName": "pauline.robel",
    "roletypeName": "pauline.robel",
    "postypeName": "pauline.robel"
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
  "data": "r6f0xb",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定|false|-
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:50",
    "lastTime": "2025-09-22 22:45:50",
    "id": "119",
    "parentId": "119",
    "postypeId": "119",
    "roletypeId": "119",
    "userId": "119",
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "code": "95555",
    "oname": "pauline.robel",
    "posFunction": "gi6vaf",
    "posRank": 807,
    "posType": "sth1zr",
    "editorType": "vq4l5a",
    "isEditorCreate": true,
    "status": 661,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "119",
    "manageDeptids": "8pykvo",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "484.704.3631",
    "officePhone": "484.704.3631",
    "buildingId": "119",
    "roomNo": "h8kjf2",
    "extQmType": "nsft7l",
    "extQmTypePhoto": "gc45l3",
    "extPosName": "pauline.robel",
    "extOrganName": "pauline.robel",
    "priority": 419,
    "priorityInOrgan": 441,
    "priorityInDomain": 937,
    "updaterId": "119",
    "updateTime": "2025-09-22 22:45:50",
    "delFlag": 2,
    "description": "cun017",
    "remark": "ntt4vv",
    "parentName": "pauline.robel",
    "roletypeName": "pauline.robel",
    "postypeName": "pauline.robel"
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
  "data": "tc5dc7",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "yxnaq5",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─status|int32|状态（0未生效1正常2受限3锁定）|false|-
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
    "postId": "119",
    "postCode": "95555",
    "postName": "pauline.robel",
    "postSort": 273,
    "status": 578,
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:50",
    "lastTime": "2025-09-22 22:45:50",
    "delFlag": 2,
    "remark": "50dqly",
    "ids": [
      "6116fm"
    ],
    "positionId": "119",
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
  "data": "flrgn6",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "id": 686,
    "roleId": 201,
    "positionId": "119",
    "status": 592,
    "beginTime": "2025-09-22",
    "endTime": "2025-09-22"
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
  "data": "i242bi",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─status|int32|状态（0未生效1正常2受限3锁定）|-
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
      "postId": "119",
      "postCode": "95555",
      "postName": "pauline.robel",
      "postSort": 939,
      "status": 816,
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:50",
      "lastTime": "2025-09-22 22:45:50",
      "delFlag": 2,
      "remark": "9pbtve",
      "ids": [
        "jkajfx"
      ],
      "positionId": "119",
      "flag": true
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 操作日志记录
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/list.do?method=9shgp3&username=pauline.robel&srcCode=701&limit=10&startTime=2025-09-22 22:44:42&createTime=2025-09-22 22:45:51&page=1&category=873&orderBy=565&q=xnn23b&userId=119&endTime=2025-09-22 22:44:42&appId=119&operation=glgahv&time=1758552282472&ip=112.28.203.208
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
    "totalCount": 949,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "operId": 382,
        "title": "5fe2ub",
        "businessType": 514,
        "businessTypeName": "pauline.robel",
        "businessTypes": [
          49
        ],
        "method": "ehvvm6",
        "requestMethod": "nfkxl2",
        "operatorType": 976,
        "operName": "pauline.robel",
        "deptName": "pauline.robel",
        "operUrl": "www.chanda-skiles.net",
        "operIp": "112.28.203.208",
        "operLocation": "3gn3mr",
        "operParam": "dl465w",
        "jsonResult": "5r9vv1",
        "status": 164,
        "errorMsg": "hr8d14",
        "operTime": "2025-09-22 22:45:51",
        "costTime": 1758552282472,
        "remark": "j8r68o"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/export.do --data 'title=68vm9f&deptName=pauline.robel&remark=edr0v4&page=1&startTime=2025-09-22 22:44:42&operId=592&operTime=2025-09-22 22:45:51&businessType=39&operIp=112.28.203.208&orderBy=769&operName=pauline.robel&q=r57k6h&limit=10&status=921&operatorType=16&endTime=2025-09-22 22:44:42'
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
  "data": "uq5w3k",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "cgv9ql",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 数据字典信息
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/list.do?cddValue=8woorm&isDefault=l2fuu7&cssClass=pj2779&q=r8xuxf&page=1&startTime=2025-09-22 22:44:42&orderBy=874&typeCode=95555&endTime=2025-09-22 22:44:42&status=pgf1j6&remark=7fycub&dictLabel=tqwuvk&searchCode=95555&limit=10&parentId=688&key=b3tgz3&cddId=811&dictSort=15&listClass=sbrvap&name=pauline.robel
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
    "totalCount": 242,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cddId": 683,
        "typeCode": "95555",
        "parentId": 31,
        "name": "pauline.robel",
        "sname": "pauline.robel",
        "cddValue": "3csbfa",
        "searchCode": "95555",
        "priority": 775,
        "createTime": "2025-09-22 22:45:55",
        "remark": "kkzkp0",
        "dictLabel": "op7vf3",
        "typeCodeName": "pauline.robel",
        "parentName": "pauline.robel"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/export.do --data 'remark=mwdpdt&orderBy=199&endTime=2025-09-22 22:44:42&cssClass=o53p5o&isDefault=9vrq4l&dictLabel=8x9t1e&name=pauline.robel&searchCode=95555&status=tltakz&limit=10&cddId=740&q=0k0xtd&dictSort=698&cddValue=th5bae&listClass=3yjixn&parentId=307&page=1&startTime=2025-09-22 22:44:42&key=s6g6l9&typeCode=95555'
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
  "data": "0296e6",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/490.do
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
    "cddId": 355,
    "typeCode": "95555",
    "parentId": 648,
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "cddValue": "nv8sbd",
    "searchCode": "95555",
    "priority": 399,
    "createTime": "2025-09-22 22:45:55",
    "remark": "jsvexj",
    "dictLabel": "fd95xq",
    "typeCodeName": "pauline.robel",
    "parentName": "pauline.robel"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/type/4wrj2n.do?roletypeId=119&typeCode=95555&parentId=119&zparentId=119
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
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "cddId": 860,
    "typeCode": "95555",
    "parentId": 632,
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "cddValue": "spumgd",
    "searchCode": "95555",
    "priority": 692,
    "createTime": "2025-09-22 22:45:56",
    "remark": "vjmfte",
    "dictLabel": "k7ofwp",
    "typeCodeName": "pauline.robel",
    "parentName": "pauline.robel"
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
  "data": "hxmwrh",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "cddId": 961,
    "typeCode": "95555",
    "parentId": 491,
    "name": "pauline.robel",
    "sname": "pauline.robel",
    "cddValue": "dcqus2",
    "searchCode": "95555",
    "priority": 329,
    "createTime": "2025-09-22 22:45:56",
    "remark": "r27lm7",
    "dictLabel": "sxvqeq",
    "typeCodeName": "pauline.robel",
    "parentName": "pauline.robel"
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
  "data": "b91bez",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "z0gxzb",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/comm/tree.do?status=u3oha8&gnType=84smzm&positionType=su9e76&refresh=ts38yi&q=q42kfi&organwId=119&roletypeId=119&subType=4cbrio&metaId=119&page=1&type=u9svty&orderBy=573&limit=10&showButton=xgjoxg&wlType=izxct2&startTime=2025-09-22 22:44:42&groupId=119&roleTypeId=119&endTime=2025-09-22 22:44:42&refType=cg6uff&appId=119&key=593c9a&positionId=119&parentId=119&roleId=119
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
      "id": "119",
      "label": "87ju48",
      "shortName": "pauline.robel",
      "organId": "119",
      "areaId": 214,
      "searchCode": "95555",
      "childNum": 587,
      "checked": true,
      "entity": 389,
      "show": true,
      "showIcon": true,
      "parentId": "119",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/tree.do?cddLevel=d7y9tx&startTime=2025-09-22 22:44:42&orderBy=539&isAllChild=rerdqy&key=2zahn8&ids=ijm142&ids=ijm142&parentId=171&limit=10&existKey=6vlnj3&searchCode=95555&dispFlag=8otb3t&q=bxrskj&sname=pauline.robel&endTime=2025-09-22 22:44:42&cddValue=1sil1x&typeMode=krpb3k&delFlag=2&page=1&name=pauline.robel&typeCode=95555&typeCodes=aceyrr&typeCodes=aceyrr&description=2ihraa
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:56",
      "lastTime": "2025-09-22 22:45:56",
      "id": 958,
      "typeCode": "95555",
      "parentId": 246,
      "name": "pauline.robel",
      "sname": "pauline.robel",
      "cddValue": "9p9qn9",
      "cddLevel": "lcpke4",
      "searchCode": "95555",
      "dispFlag": "mq3lfg",
      "priority": 267,
      "delFlag": 2,
      "deleteTime": "2025-09-22 22:45:56",
      "description": "4a7g6j",
      "spare1": "rqz4gu",
      "spare2": "md1v8s",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
      "cpuNum": 611,
      "total": 24.39,
      "sys": 68.83,
      "used": 35.36,
      "wait": 0.76,
      "free": 29.08
    },
    "mem": {
      "total": 98.42,
      "used": 73.61,
      "free": 21.46
    },
    "jvm": {
      "total": 77.13,
      "max": 96.58,
      "free": 13.80,
      "version": "4.7.2",
      "home": "8g6ada"
    },
    "sys": {
      "computerName": "pauline.robel",
      "computerIp": "112.28.203.208",
      "userDir": "apahj2",
      "osName": "pauline.robel",
      "osArch": "rdtnpr"
    },
    "sysFiles": [
      {
        "dirName": "pauline.robel",
        "sysTypeName": "pauline.robel",
        "typeName": "pauline.robel",
        "total": "yi0a8i",
        "free": "b477az",
        "used": "josata",
        "usage": 15.92
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 注册验证
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
    "username": "pauline.robel",
    "password": "sy63ht",
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7",
    "appId": "119"
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
  "data": "dasfjz",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 登录验证
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
    "username": "pauline.robel",
    "password": "2xz5vx",
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7",
    "appId": "119"
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
└─adminId|int64|用户LID|-
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
    "adminId": 461,
    "token": "e9wwht",
    "updateTime": "2025-09-22 22:45:46",
    "expireTime": "2025-09-22 22:45:46"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:46",
      "lastTime": "2025-09-22 22:45:46",
      "id": 298,
      "userId": "119",
      "deptId": 231,
      "deptName": "pauline.robel",
      "organId": "119",
      "organName": "pauline.robel",
      "name": "pauline.robel",
      "username": "pauline.robel",
      "nickName": "heriberto.bahringer",
      "email": "leonard.grady@yahoo.com",
      "mobile": "724.248.1428",
      "imagePath": "bg52eu",
      "password": "rpok5k",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 10,
      "delFlag": 2,
      "lastLoginIp": "112.28.203.208",
      "lastLoginTime": "2025-09-22 22:45:46",
      "description": "o4kei3",
      "dept": {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:46",
        "lastTime": "2025-09-22 22:45:46",
        "id": 455,
        "organId": "119",
        "parentId": 704,
        "appId": "119",
        "depttypeId": 105,
        "foreignId": "119",
        "createType": 384,
        "type": "8a5ccj",
        "name": "pauline.robel",
        "sname": "pauline.robel",
        "areaCode": "95555",
        "organLeader": "6kvxqy",
        "leaderId": "119",
        "leaderMobile": "724.248.1428",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "95555",
        "imagePath": "flaw28",
        "priority": 785,
        "status": 425,
        "delFlag": 2,
        "description": "mrch2a",
        "spare1": "m8twic",
        "spare2": "odo3gz",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "119",
          "createTime": "2025-09-22 22:45:46",
          "lastTime": "2025-09-22 22:45:46",
          "id": 493,
          "roletypeId": "119",
          "appId": "119",
          "name": "pauline.robel",
          "code": "95555",
          "priority": 308,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 952,
          "description": "scyp5p",
          "areaType": "smkj9l"
        }
      ],
      "roleIds": [
        786
      ],
      "positionIds": [
        "01vdju"
      ],
      "roleId": 230,
      "userRoleList": [
        {
          "id": 441,
          "deptId": 387,
          "deptName": "pauline.robel",
          "organId": "119",
          "organName": "pauline.robel",
          "roleId": 554,
          "roleName": "pauline.robel",
          "adminId": 291
        }
      ],
      "code": "95555",
      "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
    },
    "roles": [
      "lm4ojx"
    ],
    "permissions": [
      "ab55b2"
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "accountId": "119",
    "areaId": 903,
    "groupId": 326,
    "positionId": "119",
    "tplSolution": "pysd4y",
    "menuList": [
      {
        "id": 282,
        "parentId": 398,
        "name": "pauline.robel",
        "ename": "pauline.robel",
        "type": "2llrq9",
        "perms": "24fbkg",
        "menuLevel": 932,
        "urlType": "803d9j",
        "url": "www.chanda-skiles.net",
        "menuSeq": "6cnyr9",
        "icon": "hyi0hc",
        "imagePath": "adlvu5",
        "css": "6c1akr",
        "description": "54208u",
        "todoTotalApi": "uwyvg3"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─isWork|boolean|通过MEMBER_ACCOUNT内的TYPE为1，则isWork为true，workConfig返回信息|-
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
    "id": "119",
    "isAdmin": true,
    "isEncryt": true,
    "publicKey": "k4i817",
    "aesKey": "kly0nb",
    "clientId": "119",
    "serverUrl": "www.chanda-skiles.net",
    "serverConf1": "mjtxk3",
    "appConf": {
      "siteId": 907,
      "appId": "119",
      "topXzqhId": "119",
      "appConfJson": {
        "mapKey": "nbbziw"
      }
    },
    "isWork": true,
    "workConfig": {
      "layout": "4k5yci",
      "siteInfo": {
        "id": 769,
        "appId": "119",
        "areaCode": "95555",
        "path": "xl4tor",
        "name": "pauline.robel",
        "sname": "pauline.robel",
        "layout": "2dgcck",
        "logoUrl": "www.chanda-skiles.net",
        "cdnUrl": "www.chanda-skiles.net"
      }
    }
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 登录方法
**URL:** https://linlan.net/eframe_backend/thirdOrgan/login.do

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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/thirdOrgan/login.do --data '{
  "data": {
    "username": "pauline.robel",
    "password": "05qnx3",
    "code": "95555",
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7",
    "appId": "119"
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
└─adminId|int64|用户LID|-
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
    "adminId": 911,
    "token": "1edpg2",
    "updateTime": "2025-09-22 22:45:47",
    "expireTime": "2025-09-22 22:45:47"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -i https://linlan.net/eframe_backend/captcha/verify.do?code=95555&uuid=00cac69a-9477-4125-93fb-90055b7977a7
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
  "data": "o9heg8",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 缓存监控
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
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
      "cacheName": "pauline.robel",
      "cacheKey": "8xt2wi",
      "cacheValue": "9ir9fk",
      "remark": "mm2cw1"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getKeys/pauline.robel.do
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
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getValue/pauline.robel/c233kp.do
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
    "cacheName": "pauline.robel",
    "cacheKey": "0wprhh",
    "cacheValue": "o6g9bo",
    "remark": "u6uxun"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheName/pauline.robel.do
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
  "data": "ovlwr1",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheKey/abc1a5.do
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
  "data": "cgze9n",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "t03okn",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 菜单信息
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/list.do?parentId=810&menuType=6vo9gr&endTime=2025-09-22 22:44:42&q=2ftblc&menuName=pauline.robel&status=yuqnkp&orderBy=50&currAppId=119&limit=10&visible=xtzu1t&menuId=795&page=1&startTime=2025-09-22 22:44:42&delFlag=gbp40d
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
      "menuId": 641,
      "menuName": "pauline.robel",
      "type": "mxfxbe",
      "typeName": "pauline.robel",
      "parentName": "pauline.robel",
      "parentId": 193,
      "priority": 540,
      "path": "p6adrc",
      "component": "mnfcdx",
      "query": "nrs67y",
      "routeName": "pauline.robel",
      "isFrame": "lrvsxb",
      "isCache": "46yvrl",
      "menuType": "77mbvh",
      "menuTypeName": "pauline.robel",
      "visible": "ojq3yr",
      "status": "84rcix",
      "perms": "sdabc3",
      "icon": "kk794w",
      "imagePath": "8sgddo",
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:47",
      "lastTime": "2025-09-22 22:45:47",
      "children": [
        {
          "$ref": ".."
        }
      ],
      "childNum": 670,
      "description": "j3z5qy",
      "listJson": "bgmq66",
      "delFlag": 2,
      "permsList": [
        {
          "permsName": "pauline.robel",
          "permsStr": "xy0xj5"
        }
      ],
      "buttonMenuList": [
        {
          "id": "119",
          "parentId": "119",
          "code": "95555",
          "name": "pauline.robel"
        }
      ]
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/page.do?menuType=37o3bf&currAppId=119&orderBy=365&menuName=pauline.robel&visible=mi7n3l&page=1&endTime=2025-09-22 22:44:42&limit=10&parentId=665&q=m30sjl&menuId=793&delFlag=t4o3mb&status=7s8t9d&startTime=2025-09-22 22:44:42
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
    "stackTrace": "e6sdu3",
    "pageNum": 995,
    "pageSize": 10,
    "startRow": 647,
    "endRow": 473,
    "total": 199,
    "pages": 722,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "1xd6ey",
    "orderBy": "2vr5nx",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "nh0dp8",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/137.do
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
    "menuId": 875,
    "menuName": "pauline.robel",
    "type": "bgcqj4",
    "typeName": "pauline.robel",
    "parentName": "pauline.robel",
    "parentId": 323,
    "priority": 332,
    "path": "575c6l",
    "component": "55uamm",
    "query": "robajb",
    "routeName": "pauline.robel",
    "isFrame": "c3ozpc",
    "isCache": "mjc9fk",
    "menuType": "mz70wq",
    "menuTypeName": "pauline.robel",
    "visible": "m2bt74",
    "status": "viotof",
    "perms": "3tw1sy",
    "icon": "kf5o2v",
    "imagePath": "t1kxys",
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:47",
    "lastTime": "2025-09-22 22:45:47",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 669,
    "description": "tkd08m",
    "listJson": "uvz78u",
    "delFlag": 2,
    "permsList": [
      {
        "permsName": "pauline.robel",
        "permsStr": "c2w51x"
      }
    ],
    "buttonMenuList": [
      {
        "id": "119",
        "parentId": "119",
        "code": "95555",
        "name": "pauline.robel"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeselect.do?status=bvwct6&q=kwjqqz&parentId=792&orderBy=514&page=1&menuType=2ujgwo&visible=hdn3bj&startTime=2025-09-22 22:44:42&menuId=221&limit=10&delFlag=fkneer&endTime=2025-09-22 22:44:42&currAppId=119&menuName=pauline.robel
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
      485
    ],
    "menus": [
      {
        "id": 358,
        "label": "yhuf21",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeInit.do?startTime=2025-09-22 22:44:42&icon=ma8xr5&offset=1&url=www.chanda-skiles.net&parentNull=8564ns&menuLevel=406&spare1=hdj2w7&menuIds=hswgky&menuIds=hswgky&parentRoot=blhunc&createTime=2025-09-22 22:44:42&code=95555&orderBy=309&page=1&endTime=2025-09-22 22:44:42&imagePath=ikapmn&isCheck=true&popPosition=831&isDisabled=true&appIds=qgf9vf&appIds=qgf9vf&subCount=525&name=pauline.robel&isMenuAll=dau2or&parentId=472&shortCut=nrw390&q=a88fu2&description=da5bkm&typeNoButton=oz8o6h&spare2=icjug4&delFlag=2&isProtect=true&isDisplay=true&limit=10&appId=119&urlType=rtwnb0&type=fjmyld
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
      "title": "ae0aln",
      "id": "119",
      "parentId": "119",
      "extId": "119",
      "href": "m0ai3t",
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
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/roleMenuTreeselect/792.do
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
      568
    ],
    "menus": [
      {
        "id": 925,
        "label": "io78az",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 新增单个菜单
**URL:** https://linlan.net/eframe_backend/api/admin/menu.do

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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu.do --data '{
  "data": {
    "menuId": 637,
    "menuName": "pauline.robel",
    "type": "g7iv2f",
    "typeName": "pauline.robel",
    "parentName": "pauline.robel",
    "parentId": 868,
    "priority": 467,
    "path": "gx92r1",
    "component": "j6nqaf",
    "query": "70esg8",
    "routeName": "pauline.robel",
    "isFrame": "os57w5",
    "isCache": "zkgkt2",
    "menuType": "27oqu7",
    "menuTypeName": "pauline.robel",
    "visible": "9zdj54",
    "status": "69u3qc",
    "perms": "fsgwel",
    "icon": "vjadsg",
    "imagePath": "kasyj0",
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:47",
    "lastTime": "2025-09-22 22:45:47",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 260,
    "description": "2ztvap",
    "listJson": "gjwler",
    "delFlag": 2,
    "permsList": [
      {
        "permsName": "pauline.robel",
        "permsStr": "zw48w6"
      }
    ],
    "buttonMenuList": [
      {
        "id": "119",
        "parentId": "119",
        "code": "95555",
        "name": "pauline.robel"
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
  "data": "i6ytda",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 修改菜单
**URL:** https://linlan.net/eframe_backend/api/admin/menu.do

**Type:** PUT

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
curl -X PUT -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu.do --data '{
  "data": {
    "menuId": 641,
    "menuName": "pauline.robel",
    "type": "p5poot",
    "typeName": "pauline.robel",
    "parentName": "pauline.robel",
    "parentId": 980,
    "priority": 769,
    "path": "ildjao",
    "component": "izn9ja",
    "query": "oggm78",
    "routeName": "pauline.robel",
    "isFrame": "a0vum5",
    "isCache": "6ob32v",
    "menuType": "o6gyxi",
    "menuTypeName": "pauline.robel",
    "visible": "jupbfz",
    "status": "gga6r1",
    "perms": "hw94gl",
    "icon": "q8rzgp",
    "imagePath": "4t1rqe",
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:47",
    "lastTime": "2025-09-22 22:45:47",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 777,
    "description": "1pkfed",
    "listJson": "tu46d3",
    "delFlag": 2,
    "permsList": [
      {
        "permsName": "pauline.robel",
        "permsStr": "ddglzg"
      }
    ],
    "buttonMenuList": [
      {
        "id": "119",
        "parentId": "119",
        "code": "95555",
        "name": "pauline.robel"
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
  "data": "jemh1x",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "menuId": 593,
    "menuName": "pauline.robel",
    "type": "0wp0rf",
    "typeName": "pauline.robel",
    "parentName": "pauline.robel",
    "parentId": 739,
    "priority": 924,
    "path": "tz7pd3",
    "component": "p2a08o",
    "query": "5d978l",
    "routeName": "pauline.robel",
    "isFrame": "shwywk",
    "isCache": "tdfwi7",
    "menuType": "x6675j",
    "menuTypeName": "pauline.robel",
    "visible": "r1gszf",
    "status": "xu4vu2",
    "perms": "xe62iw",
    "icon": "hfbc4k",
    "imagePath": "i7lkh2",
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:47",
    "lastTime": "2025-09-22 22:45:47",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 177,
    "description": "l7149i",
    "listJson": "fk227u",
    "delFlag": 2,
    "permsList": [
      {
        "permsName": "pauline.robel",
        "permsStr": "dnou6p"
      }
    ],
    "buttonMenuList": [
      {
        "id": "119",
        "parentId": "119",
        "code": "95555",
        "name": "pauline.robel"
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
  "data": "xnwqpu",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "menuId": 723,
    "menuName": "pauline.robel",
    "type": "e602zp",
    "typeName": "pauline.robel",
    "parentName": "pauline.robel",
    "parentId": 795,
    "priority": 69,
    "path": "8o67p7",
    "component": "d0s0qc",
    "query": "vbnfi9",
    "routeName": "pauline.robel",
    "isFrame": "1o93ro",
    "isCache": "szqytr",
    "menuType": "wi4wil",
    "menuTypeName": "pauline.robel",
    "visible": "y3hf3e",
    "status": "s0lp07",
    "perms": "fbm98m",
    "icon": "xzxnh8",
    "imagePath": "dzcp2f",
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:47",
    "lastTime": "2025-09-22 22:45:47",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 654,
    "description": "iqh26i",
    "listJson": "tlckc8",
    "delFlag": 2,
    "permsList": [
      {
        "permsName": "pauline.robel",
        "permsStr": "ugkqej"
      }
    ],
    "buttonMenuList": [
      {
        "id": "119",
        "parentId": "119",
        "code": "95555",
        "name": "pauline.robel"
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
  "data": "6j9pgv",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "4tc27x",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:48",
    "lastTime": "2025-09-22 22:45:48",
    "id": 948,
    "parentId": 983,
    "appId": "119",
    "name": "pauline.robel",
    "ename": "pauline.robel",
    "sname": "pauline.robel",
    "isProtect": true,
    "type": "vmxycb",
    "userId": "119",
    "code": "95555",
    "menuLevel": 964,
    "subCount": 29,
    "perms": "o58r71",
    "urlType": "r6wg2t",
    "url": "www.chanda-skiles.net",
    "icon": "0tu50e",
    "popPosition": 908,
    "imagePath": "ob4k01",
    "css": "0gon6d",
    "jsEvent": "2x48yq",
    "menuSeq": "oqqc3e",
    "shortCut": "bbgbek",
    "isLeaf": true,
    "isDisplay": true,
    "isDisabled": true,
    "isCheck": true,
    "priority": 683,
    "delFlag": 2,
    "deleteTime": "2025-09-22 22:45:48",
    "description": "7luw8d",
    "spare1": "ppijbo",
    "spare2": "s6874j",
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
  "data": "m3eqcc",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 角色信息
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/list.do?q=m2jbhk&roleId=817&status=854&endTime=2025-09-22 22:44:42&roleName=pauline.robel&roleKey=afmn9o&orderBy=370&page=1&startTime=2025-09-22 22:44:42&limit=10
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:48",
      "lastTime": "2025-09-22 22:45:48",
      "roleId": 634,
      "roleName": "pauline.robel",
      "roleKey": "wbioax",
      "roleSort": 842,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 116,
      "flag": true,
      "menuIds": [
        824
      ],
      "deptIds": [
        388
      ],
      "permissions": [
        "zavq33"
      ],
      "remark": "taop50",
      "parentName": "pauline.robel",
      "appName": "pauline.robel",
      "roletypeId": "119",
      "roletypeName": "pauline.robel",
      "priority": 546,
      "isSuper": true
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/export.do --data 'roleId=829&roleKey=ypckpj&status=628&q=oz046t&roleName=pauline.robel&limit=10&page=1&endTime=2025-09-22 22:44:42&orderBy=608&startTime=2025-09-22 22:44:42'
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
  "data": "fki5or",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/42.do
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:48",
    "lastTime": "2025-09-22 22:45:48",
    "roleId": 855,
    "roleName": "pauline.robel",
    "roleKey": "z38sws",
    "roleSort": 928,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 685,
    "flag": true,
    "menuIds": [
      370
    ],
    "deptIds": [
      553
    ],
    "permissions": [
      "b8zs8v"
    ],
    "remark": "m8ytcg",
    "parentName": "pauline.robel",
    "appName": "pauline.robel",
    "roletypeId": "119",
    "roletypeName": "pauline.robel",
    "priority": 116,
    "isSuper": true
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 新增角色
**URL:** https://linlan.net/eframe_backend/api/admin/role.do

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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:48",
    "lastTime": "2025-09-22 22:45:48",
    "roleId": 158,
    "roleName": "pauline.robel",
    "roleKey": "ijlibr",
    "roleSort": 169,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 478,
    "flag": true,
    "menuIds": [
      738
    ],
    "deptIds": [
      320
    ],
    "permissions": [
      "ca4jb4"
    ],
    "remark": "k77kn0",
    "parentName": "pauline.robel",
    "appName": "pauline.robel",
    "roletypeId": "119",
    "roletypeName": "pauline.robel",
    "priority": 304,
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
  "data": "drucmv",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 修改保存角色
**URL:** https://linlan.net/eframe_backend/api/admin/role.do

**Type:** PUT

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
curl -X PUT -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:48",
    "lastTime": "2025-09-22 22:45:48",
    "roleId": 307,
    "roleName": "pauline.robel",
    "roleKey": "bp4r4g",
    "roleSort": 340,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 3,
    "flag": true,
    "menuIds": [
      269
    ],
    "deptIds": [
      509
    ],
    "permissions": [
      "8mq8fj"
    ],
    "remark": "vh9byj",
    "parentName": "pauline.robel",
    "appName": "pauline.robel",
    "roletypeId": "119",
    "roletypeName": "pauline.robel",
    "priority": 395,
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
  "data": "3q7op5",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 新增角色及绑定菜单部门
**URL:** https://linlan.net/eframe_backend/api/admin/role/save.do

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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/save.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:48",
    "lastTime": "2025-09-22 22:45:48",
    "roleId": 223,
    "roleName": "pauline.robel",
    "roleKey": "lbwaxe",
    "roleSort": 643,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 167,
    "flag": true,
    "menuIds": [
      671
    ],
    "deptIds": [
      465
    ],
    "permissions": [
      "e4za5u"
    ],
    "remark": "fqo33g",
    "parentName": "pauline.robel",
    "appName": "pauline.robel",
    "roletypeId": "119",
    "roletypeName": "pauline.robel",
    "priority": 571,
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
  "data": "ai3h4f",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 修改保存角色及绑定菜单部门
**URL:** https://linlan.net/eframe_backend/api/admin/role/update.do

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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/update.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:48",
    "lastTime": "2025-09-22 22:45:48",
    "roleId": 707,
    "roleName": "pauline.robel",
    "roleKey": "acrbme",
    "roleSort": 541,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 333,
    "flag": true,
    "menuIds": [
      860
    ],
    "deptIds": [
      827
    ],
    "permissions": [
      "uh9tub"
    ],
    "remark": "zljhjq",
    "parentName": "pauline.robel",
    "appName": "pauline.robel",
    "roletypeId": "119",
    "roletypeName": "pauline.robel",
    "priority": 518,
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
  "data": "15dtb1",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "ja0qfp",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
└─status|int32|状态0未生效1正常2受限3锁定|false|-
└─description|string|角色描述|false|-
└─areaType|string|地域类型|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/disable/{roleId}.do --data '{
  "data": {
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:48",
    "lastTime": "2025-09-22 22:45:48",
    "id": 496,
    "roletypeId": "119",
    "appId": "119",
    "name": "pauline.robel",
    "code": "95555",
    "priority": 914,
    "isRegular": true,
    "isSuper": true,
    "isPublic": true,
    "status": 631,
    "description": "261bgg",
    "areaType": "1ws4hu"
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
  "data": "bf3w76",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:48",
    "lastTime": "2025-09-22 22:45:48",
    "roleId": 213,
    "roleName": "pauline.robel",
    "roleKey": "6ezw9w",
    "roleSort": 203,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 699,
    "flag": true,
    "menuIds": [
      326
    ],
    "deptIds": [
      151
    ],
    "permissions": [
      "tqn46m"
    ],
    "remark": "by0hk9",
    "parentName": "pauline.robel",
    "appName": "pauline.robel",
    "roletypeId": "119",
    "roletypeName": "pauline.robel",
    "priority": 28,
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
  "data": "klim86",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "creatorId": "119",
    "createTime": "2025-09-22 22:45:48",
    "lastTime": "2025-09-22 22:45:48",
    "roleId": 853,
    "roleName": "pauline.robel",
    "roleKey": "idxdr8",
    "roleSort": 78,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 590,
    "flag": true,
    "menuIds": [
      939
    ],
    "deptIds": [
      104
    ],
    "permissions": [
      "r8qxbu"
    ],
    "remark": "2z9toa",
    "parentName": "pauline.robel",
    "appName": "pauline.robel",
    "roletypeId": "119",
    "roletypeName": "pauline.robel",
    "priority": 383,
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
  "data": "pqs0lk",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:48",
      "lastTime": "2025-09-22 22:45:48",
      "roleId": 868,
      "roleName": "pauline.robel",
      "roleKey": "duxblv",
      "roleSort": 760,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 723,
      "flag": true,
      "menuIds": [
        764
      ],
      "deptIds": [
        325
      ],
      "permissions": [
        "phd2tq"
      ],
      "remark": "23870u",
      "parentName": "pauline.robel",
      "appName": "pauline.robel",
      "roletypeId": "119",
      "roletypeName": "pauline.robel",
      "priority": 268,
      "isSuper": true
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/allocatedList.do?nickName=heriberto.bahringer&q=hc6m9w&adminId=546&delFlag=2&startTime=2025-09-22 22:44:42&username=pauline.robel&organId=119&orderBy=102&page=1&limit=10&email=leonard.grady@yahoo.com&mobile=724.248.1428&endTime=2025-09-22 22:44:42&userId=119&deptId=149&status=ujk71a
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:49",
      "lastTime": "2025-09-22 22:45:49",
      "id": 682,
      "userId": "119",
      "deptId": 340,
      "deptName": "pauline.robel",
      "organId": "119",
      "organName": "pauline.robel",
      "name": "pauline.robel",
      "username": "pauline.robel",
      "nickName": "heriberto.bahringer",
      "email": "leonard.grady@yahoo.com",
      "mobile": "724.248.1428",
      "imagePath": "ua9a3k",
      "password": "8t99f1",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 237,
      "delFlag": 2,
      "lastLoginIp": "112.28.203.208",
      "lastLoginTime": "2025-09-22 22:45:49",
      "description": "8k388b",
      "dept": {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:49",
        "lastTime": "2025-09-22 22:45:49",
        "id": 210,
        "organId": "119",
        "parentId": 641,
        "appId": "119",
        "depttypeId": 252,
        "foreignId": "119",
        "createType": 444,
        "type": "6ugkgz",
        "name": "pauline.robel",
        "sname": "pauline.robel",
        "areaCode": "95555",
        "organLeader": "dcss3x",
        "leaderId": "119",
        "leaderMobile": "724.248.1428",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "95555",
        "imagePath": "wm8skd",
        "priority": 132,
        "status": 806,
        "delFlag": 2,
        "description": "xe5hod",
        "spare1": "wzihbq",
        "spare2": "xj3cdc",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "119",
          "createTime": "2025-09-22 22:45:49",
          "lastTime": "2025-09-22 22:45:49",
          "id": 995,
          "roletypeId": "119",
          "appId": "119",
          "name": "pauline.robel",
          "code": "95555",
          "priority": 377,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 495,
          "description": "oaa108",
          "areaType": "sr3po6"
        }
      ],
      "roleIds": [
        531
      ],
      "positionIds": [
        "greg2f"
      ],
      "roleId": 613,
      "userRoleList": [
        {
          "id": 443,
          "deptId": 981,
          "deptName": "pauline.robel",
          "organId": "119",
          "organName": "pauline.robel",
          "roleId": 730,
          "roleName": "pauline.robel",
          "adminId": 256
        }
      ],
      "code": "95555",
      "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/unallocatedList.do?limit=10&deptId=142&nickName=heriberto.bahringer&orderBy=281&username=pauline.robel&q=x0xkrp&organId=119&delFlag=2&email=leonard.grady@yahoo.com&page=1&status=rd32z7&userId=119&endTime=2025-09-22 22:44:42&adminId=965&mobile=724.248.1428&startTime=2025-09-22 22:44:42
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─type|string|部门类型，NEISHE内设机构，FENZI分子机构|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─status|int32|状态0未生效1正常2受限3锁定|-
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
      "creatorId": "119",
      "createTime": "2025-09-22 22:45:49",
      "lastTime": "2025-09-22 22:45:49",
      "id": 341,
      "userId": "119",
      "deptId": 588,
      "deptName": "pauline.robel",
      "organId": "119",
      "organName": "pauline.robel",
      "name": "pauline.robel",
      "username": "pauline.robel",
      "nickName": "heriberto.bahringer",
      "email": "leonard.grady@yahoo.com",
      "mobile": "724.248.1428",
      "imagePath": "ey0izm",
      "password": "tyghyg",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 615,
      "delFlag": 2,
      "lastLoginIp": "112.28.203.208",
      "lastLoginTime": "2025-09-22 22:45:49",
      "description": "s6cnip",
      "dept": {
        "creatorId": "119",
        "createTime": "2025-09-22 22:45:49",
        "lastTime": "2025-09-22 22:45:49",
        "id": 191,
        "organId": "119",
        "parentId": 502,
        "appId": "119",
        "depttypeId": 431,
        "foreignId": "119",
        "createType": 692,
        "type": "htuggy",
        "name": "pauline.robel",
        "sname": "pauline.robel",
        "areaCode": "95555",
        "organLeader": "tjmjzq",
        "leaderId": "119",
        "leaderMobile": "724.248.1428",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "95555",
        "imagePath": "jrln99",
        "priority": 237,
        "status": 185,
        "delFlag": 2,
        "description": "qm2uf5",
        "spare1": "waw36g",
        "spare2": "9si8nk",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "119",
          "createTime": "2025-09-22 22:45:49",
          "lastTime": "2025-09-22 22:45:49",
          "id": 197,
          "roletypeId": "119",
          "appId": "119",
          "name": "pauline.robel",
          "code": "95555",
          "priority": 357,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 879,
          "description": "bvga6x",
          "areaType": "bser0e"
        }
      ],
      "roleIds": [
        202
      ],
      "positionIds": [
        "ufjcpi"
      ],
      "roleId": 938,
      "userRoleList": [
        {
          "id": 710,
          "deptId": 139,
          "deptName": "pauline.robel",
          "organId": "119",
          "organName": "pauline.robel",
          "roleId": 228,
          "roleName": "pauline.robel",
          "adminId": 290
        }
      ],
      "code": "95555",
      "uuid": "00cac69a-9477-4125-93fb-90055b7977a7"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 取消授权用户
**URL:** https://linlan.net/eframe_backend/api/admin/role/authUser/cancel.do

**Type:** PUT

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
curl -X PUT -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/cancel.do --data '{
  "data": {
    "id": 122,
    "roleId": 223,
    "adminId": 549
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
  "data": "src20a",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 批量取消授权用户
**URL:** https://linlan.net/eframe_backend/api/admin/role/authUser/cancelAll.do

**Type:** PUT

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
curl -X PUT -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/cancelAll.do --data 'roleId=278&adminIds=xexcy0&adminIds=xexcy0'
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
  "data": "rpf3r3",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

### 批量选择用户授权
**URL:** https://linlan.net/eframe_backend/api/admin/role/authUser/selectAll.do

**Type:** PUT

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
curl -X PUT -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/selectAll.do --data 'adminIds=xd4b1p&adminIds=xd4b1p&roleId=663'
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
  "data": "hinifc",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/deptTree/5.do
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
      31
    ],
    "depts": [
      {
        "id": 661,
        "label": "jns2v7",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 键值配置 信息操作处理
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/list.do?ids=yqt1ma&ids=yqt1ma&cfgValue=rdho1m&orderBy=919&startTime=2025-09-22 22:44:42&endTime=2025-09-22 22:44:42&cfgKey=nb55uz&q=236lem&page=1&limit=10
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
    "totalCount": 138,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cfgKey": "15wx99",
        "cfgValue": "y6hvaz"
      }
    ]
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/export.do --data 'cfgValue=x3nrv2&startTime=2025-09-22 22:44:42&cfgKey=0nntgx&page=1&endTime=2025-09-22 22:44:42&limit=10&ids=i7dkjb&ids=i7dkjb&q=eg4azt&orderBy=485'
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
  "data": "a3136b",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/nbqv56.do
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
    "cfgKey": "2akhvf",
    "cfgValue": "4c7ovc"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "cfgKey": "3ddl4b",
    "cfgValue": "ugc2ql"
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
  "data": "l5zs6n",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "cfgKey": "ce3p06",
    "cfgValue": "qsyde1"
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
  "data": "ndqfsp",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "n32270",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
  "data": "t9uv6c",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
}
```

## 首页入口
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
  "data": "3r98hy",
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/application.do?limit=10&startTime=2025-09-22 22:44:42&endTime=2025-09-22 22:44:42&orderBy=884&q=afmgld&page=1
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
      "organNum": "46ic4p",
      "deptNum": "d2xjht",
      "peopleNum": "i7ra88",
      "roleNum": "w0e0u4",
      "dicTypeNum": "5td25s",
      "appNum": "rogrow",
      "fileNum": "dig7ar",
      "paramNum": "v4j86c"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/element.do?endTime=2025-09-22 22:44:42&startTime=2025-09-22 22:44:42&q=yz688s&page=1&orderBy=658&limit=10
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
      "objectNum": "nqszro",
      "modelNum": "qqele4"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/manage.do?page=1&q=k3aceu&orderBy=770&limit=10&endTime=2025-09-22 22:44:42&startTime=2025-09-22 22:44:42
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
      "siteNum": "cj2vdc",
      "accountNum": "7466e6",
      "serviceOrganNum": "32nvfc"
    }
  ],
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7",
    "img": "xwuw7s",
    "code": "95555"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
    "uuid": "00cac69a-9477-4125-93fb-90055b7977a7",
    "img": "4ml6lh",
    "code": "95555"
  },
  "requestId": "119",
  "timestamp": "2025-09-22 22:44:42"
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
