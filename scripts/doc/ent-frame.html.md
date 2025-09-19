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
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:24",
    "lastTime": "2025-09-19 17:32:24",
    "id": 840,
    "organId": "118",
    "parentId": 712,
    "appId": "118",
    "depttypeId": 31,
    "foreignId": "118",
    "createType": 834,
    "type": "4ojtg8",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "areaCode": "9574",
    "organLeader": "jewta1",
    "leaderId": "118",
    "leaderMobile": "828.254.1097",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "9574",
    "imagePath": "7sqq33",
    "priority": 675,
    "status": 418,
    "delFlag": 0,
    "description": "v1betg",
    "spare1": "izpbdb",
    "spare2": "9jxwpq",
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
  "data": "z9xzqu",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:24",
    "lastTime": "2025-09-19 17:32:24",
    "id": 349,
    "organId": "118",
    "parentId": 299,
    "appId": "118",
    "depttypeId": 878,
    "foreignId": "118",
    "createType": 148,
    "type": "kjtc6m",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "areaCode": "9574",
    "organLeader": "5b1c5u",
    "leaderId": "118",
    "leaderMobile": "828.254.1097",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "9574",
    "imagePath": "rrnu06",
    "priority": 780,
    "status": 417,
    "delFlag": 0,
    "description": "prxl0h",
    "spare1": "yoy1zx",
    "spare2": "u5z62u",
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
  "data": "0x7kve",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "asamlx",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:24",
    "lastTime": "2025-09-19 17:32:24",
    "id": 820,
    "organId": "118",
    "parentId": 951,
    "appId": "118",
    "depttypeId": 452,
    "foreignId": "118",
    "createType": 962,
    "type": "dhb464",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "areaCode": "9574",
    "organLeader": "ahoxde",
    "leaderId": "118",
    "leaderMobile": "828.254.1097",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "9574",
    "imagePath": "mhii40",
    "priority": 543,
    "status": 958,
    "delFlag": 0,
    "description": "a12bko",
    "spare1": "xn3ihy",
    "spare2": "o7727z",
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
  "data": "l8ou3h",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list.do?depttypeId=708&status=429&isOrganLevel=true&imagePath=smdq3y&limit=10&delFlag=0&endTime=2025-09-19 17:31:32&leaderId=118&searchCode=9574&sname=cleopatra.thompson&leaderMobile=828.254.1097&parentId=825&foreignId=118&type=mbc65x&organLeader=x29g67&description=ctyxhl&name=cleopatra.thompson&creatorId=118&organId=118&spare2=h8o47z&isLeaf=true&isDisabled=true&areaCode=9574&spare1=7bsec2&createType=66&deptId=4&isVirtual=true&orderBy=550&q=r2irg7&appId=118&page=1&startTime=2025-09-19 17:31:32
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
    "stackTrace": "uent5a",
    "pageNum": 576,
    "pageSize": 10,
    "startRow": 938,
    "endRow": 710,
    "total": 175,
    "pages": 660,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "0iamlr",
    "orderBy": "fbac1g",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "ivk628",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/page.do?spare1=bb77ae&endTime=2025-09-19 17:31:32&appId=118&searchCode=9574&imagePath=t6oibr&sname=cleopatra.thompson&parentId=353&foreignId=118&leaderId=118&startTime=2025-09-19 17:31:32&createType=444&isVirtual=true&page=1&depttypeId=514&name=cleopatra.thompson&deptId=714&isOrganLevel=true&type=vgp598&delFlag=0&isLeaf=true&organLeader=dgom3z&organId=118&q=kmcvx9&description=t2tbvw&orderBy=582&isDisabled=true&spare2=cwi0dw&leaderMobile=828.254.1097&limit=10&status=989&areaCode=9574&creatorId=118
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
    "stackTrace": "zd8oc8",
    "pageNum": 227,
    "pageSize": 10,
    "startRow": 307,
    "endRow": 848,
    "total": 909,
    "pages": 416,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "6fc6bk",
    "orderBy": "o3s4li",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "pclw5l",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list/exclude/564.do
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
      "id": 408,
      "organId": "118",
      "organName": "cleopatra.thompson",
      "parentId": 595,
      "appId": "118",
      "depttypeId": 829,
      "foreignId": "118",
      "createType": 4,
      "type": "u84jq9",
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "areaCode": "9574",
      "organLeader": "gsft09",
      "leaderId": "118",
      "leaderMobile": "828.254.1097",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "9574",
      "imagePath": "looez5",
      "priority": 165,
      "status": 68,
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:24",
      "lastTime": "2025-09-19 17:32:24",
      "delFlag": 0,
      "description": "5w5l4j",
      "spare1": "h35ejv",
      "spare2": "ololgc",
      "parentName": "cleopatra.thompson",
      "childNum": "plggvu"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/86.do
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
    "id": 371,
    "organId": "118",
    "organName": "cleopatra.thompson",
    "parentId": 585,
    "appId": "118",
    "depttypeId": 937,
    "foreignId": "118",
    "createType": 676,
    "type": "qpfr0y",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "areaCode": "9574",
    "organLeader": "fytlsu",
    "leaderId": "118",
    "leaderMobile": "828.254.1097",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "9574",
    "imagePath": "fw7gsh",
    "priority": 618,
    "status": 170,
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:24",
    "lastTime": "2025-09-19 17:32:24",
    "delFlag": 0,
    "description": "kai1wf",
    "spare1": "ejwuh0",
    "spare2": "ijkw5q",
    "parentName": "cleopatra.thompson",
    "childNum": "32z3uy"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/tree.do?isLeaf=true&searchCode=9574&organId=118&limit=10&imagePath=m9o5u8&creatorId=118&orderBy=888&page=1&organLeader=jadxkd&isOrganLevel=true&depttypeId=280&areaCode=9574&startTime=2025-09-19 17:31:32&foreignId=118&parentId=698&name=cleopatra.thompson&createType=956&isDisabled=true&appId=118&description=9zfsgu&spare2=uz0p2k&sname=cleopatra.thompson&leaderId=118&leaderMobile=828.254.1097&q=8tm2sa&endTime=2025-09-19 17:31:32&status=977&spare1=xja260&delFlag=0&isVirtual=true&type=2rmiqz&deptId=203
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
      "title": "0e02xd",
      "id": "118",
      "parentId": "118",
      "extId": "118",
      "href": "zopnh7",
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
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/list.do?ipaddr=c9epby&browser=5mxx7b&page=1&infoId=788&status=8zaanf&endTime=2025-09-19 17:31:32&startTime=2025-09-19 17:31:32&limit=10&os=tyd3t2&q=vkxqls&msg=1en6zf&orderBy=758&username=cleopatra.thompson&loginTime=2025-09-19 17:32:30
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
    "totalCount": 590,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "infoId": 984,
        "username": "cleopatra.thompson",
        "status": "4y2lve",
        "ipaddr": "kh8yga",
        "loginLocation": "yauzjk",
        "browser": "j9fz80",
        "os": "k7lukm",
        "msg": "ev5m4j",
        "loginTime": "2025-09-19 17:32:30",
        "remark": "p5bv6e"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/export.do --data 'loginTime=2025-09-19 17:32:30&os=wgpbpf&orderBy=526&username=cleopatra.thompson&infoId=440&endTime=2025-09-19 17:31:32&status=k1069k&page=1&q=cdixkg&limit=10&ipaddr=nji9yj&browser=9ih9vr&msg=yojh6w&startTime=2025-09-19 17:31:32'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "0cgm3f",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "kbc73q",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "32fdwn",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/unlock/cleopatra.thompson.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ilwoqi",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:25",
    "lastTime": "2025-09-19 17:32:25",
    "id": 285,
    "userId": "118",
    "deptId": 997,
    "deptName": "cleopatra.thompson",
    "organId": "118",
    "organName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "username": "cleopatra.thompson",
    "nickName": "maribeth.rutherford",
    "email": "sheree.stanton@gmail.com",
    "mobile": "828.254.1097",
    "imagePath": "hc7nje",
    "password": "a9ml93",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 581,
    "delFlag": 0,
    "lastLoginIp": "142.83.169.77",
    "lastLoginTime": "2025-09-19 17:32:25",
    "description": "143hf9",
    "dept": {
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:25",
      "lastTime": "2025-09-19 17:32:25",
      "id": 412,
      "organId": "118",
      "parentId": 921,
      "appId": "118",
      "depttypeId": 176,
      "foreignId": "118",
      "createType": 531,
      "type": "ly1onx",
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "areaCode": "9574",
      "organLeader": "c27alf",
      "leaderId": "118",
      "leaderMobile": "828.254.1097",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "9574",
      "imagePath": "pqsrto",
      "priority": 278,
      "status": 155,
      "delFlag": 0,
      "description": "7flvzt",
      "spare1": "jpelr0",
      "spare2": "yp9asx",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:25",
        "lastTime": "2025-09-19 17:32:25",
        "id": 9,
        "roletypeId": "118",
        "appId": "118",
        "name": "cleopatra.thompson",
        "code": "9574",
        "priority": 628,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 865,
        "description": "cyhcom",
        "areaType": "s59fan"
      }
    ],
    "roleIds": [
      646
    ],
    "positionIds": [
      "vzth4b"
    ],
    "roleId": 720,
    "userRoleList": [
      {
        "id": 774,
        "deptId": 809,
        "deptName": "cleopatra.thompson",
        "organId": "118",
        "organName": "cleopatra.thompson",
        "roleId": 766,
        "roleName": "cleopatra.thompson",
        "adminId": 117
      }
    ],
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
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
  "data": "tjbcva",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:25",
    "lastTime": "2025-09-19 17:32:25",
    "id": 228,
    "userId": "118",
    "deptId": 605,
    "deptName": "cleopatra.thompson",
    "organId": "118",
    "organName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "username": "cleopatra.thompson",
    "nickName": "maribeth.rutherford",
    "email": "sheree.stanton@gmail.com",
    "mobile": "828.254.1097",
    "imagePath": "klxint",
    "password": "2ivh87",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 478,
    "delFlag": 0,
    "lastLoginIp": "142.83.169.77",
    "lastLoginTime": "2025-09-19 17:32:25",
    "description": "9n8l4e",
    "dept": {
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:25",
      "lastTime": "2025-09-19 17:32:25",
      "id": 546,
      "organId": "118",
      "parentId": 405,
      "appId": "118",
      "depttypeId": 791,
      "foreignId": "118",
      "createType": 207,
      "type": "n3gq7z",
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "areaCode": "9574",
      "organLeader": "swm9s0",
      "leaderId": "118",
      "leaderMobile": "828.254.1097",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "9574",
      "imagePath": "vra0kq",
      "priority": 94,
      "status": 283,
      "delFlag": 0,
      "description": "mydp88",
      "spare1": "kpjhkm",
      "spare2": "j7pjkx",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:25",
        "lastTime": "2025-09-19 17:32:25",
        "id": 114,
        "roletypeId": "118",
        "appId": "118",
        "name": "cleopatra.thompson",
        "code": "9574",
        "priority": 389,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 726,
        "description": "iq9svd",
        "areaType": "c2c7iq"
      }
    ],
    "roleIds": [
      71
    ],
    "positionIds": [
      "h5li1i"
    ],
    "roleId": 5,
    "userRoleList": [
      {
        "id": 954,
        "deptId": 511,
        "deptName": "cleopatra.thompson",
        "organId": "118",
        "organName": "cleopatra.thompson",
        "roleId": 580,
        "roleName": "cleopatra.thompson",
        "adminId": 0
      }
    ],
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
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
  "data": "6xtq6l",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:25",
    "lastTime": "2025-09-19 17:32:25",
    "id": 903,
    "userId": "118",
    "organId": "118",
    "deptId": 913,
    "createType": 737,
    "name": "cleopatra.thompson",
    "username": "cleopatra.thompson",
    "mobile": "828.254.1097",
    "email": "sheree.stanton@gmail.com",
    "password": "wncoln",
    "salt": "l3n5xs",
    "imagePath": "405hc9",
    "adminType": "dpjb74",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "adminRange": "350qbm",
    "adminPerms": "fxqrt5",
    "lastAppId": "118",
    "lastLoginTime": "2025-09-19 17:32:25",
    "lastLoginIp": "142.83.169.77",
    "loginCount": 898,
    "status": 424,
    "delFlag": 0,
    "spare1": "yrs6ee",
    "spare2": "u80uox",
    "roleIds": [
      290
    ],
    "positionIds": [
      "0wbxkd"
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
  "data": "rg8lre",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:25",
    "lastTime": "2025-09-19 17:32:25",
    "id": 200,
    "userId": "118",
    "deptId": 259,
    "deptName": "cleopatra.thompson",
    "organId": "118",
    "organName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "username": "cleopatra.thompson",
    "nickName": "maribeth.rutherford",
    "email": "sheree.stanton@gmail.com",
    "mobile": "828.254.1097",
    "imagePath": "t7v98c",
    "password": "asusvm",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 588,
    "delFlag": 0,
    "lastLoginIp": "142.83.169.77",
    "lastLoginTime": "2025-09-19 17:32:25",
    "description": "semrbr",
    "dept": {
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:25",
      "lastTime": "2025-09-19 17:32:25",
      "id": 26,
      "organId": "118",
      "parentId": 148,
      "appId": "118",
      "depttypeId": 482,
      "foreignId": "118",
      "createType": 298,
      "type": "z9ls6z",
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "areaCode": "9574",
      "organLeader": "19s0zo",
      "leaderId": "118",
      "leaderMobile": "828.254.1097",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "9574",
      "imagePath": "i9zlf1",
      "priority": 245,
      "status": 232,
      "delFlag": 0,
      "description": "mff8rh",
      "spare1": "tooy09",
      "spare2": "in8353",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:25",
        "lastTime": "2025-09-19 17:32:25",
        "id": 166,
        "roletypeId": "118",
        "appId": "118",
        "name": "cleopatra.thompson",
        "code": "9574",
        "priority": 580,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 779,
        "description": "101bsy",
        "areaType": "lgnf2o"
      }
    ],
    "roleIds": [
      382
    ],
    "positionIds": [
      "uc36ug"
    ],
    "roleId": 440,
    "userRoleList": [
      {
        "id": 596,
        "deptId": 884,
        "deptName": "cleopatra.thompson",
        "organId": "118",
        "organName": "cleopatra.thompson",
        "roleId": 724,
        "roleName": "cleopatra.thompson",
        "adminId": 768
      }
    ],
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
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
  "data": "zmomgr",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "eszb7f",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/export.do --data 'status=cjhw15&mobile=828.254.1097&q=xax7r3&limit=10&username=cleopatra.thompson&deptId=319&nickName=maribeth.rutherford&adminId=721&page=1&delFlag=0&startTime=2025-09-19 17:31:32&organId=118&userId=118&email=sheree.stanton@gmail.com&orderBy=753&endTime=2025-09-19 17:31:32'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "oihwfu",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "8yinho",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "j6fq78",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:25",
    "lastTime": "2025-09-19 17:32:25",
    "id": 106,
    "userId": "118",
    "deptId": 953,
    "deptName": "cleopatra.thompson",
    "organId": "118",
    "organName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "username": "cleopatra.thompson",
    "nickName": "maribeth.rutherford",
    "email": "sheree.stanton@gmail.com",
    "mobile": "828.254.1097",
    "imagePath": "1geztn",
    "password": "f1e7sf",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 92,
    "delFlag": 0,
    "lastLoginIp": "142.83.169.77",
    "lastLoginTime": "2025-09-19 17:32:25",
    "description": "ttis5b",
    "dept": {
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:25",
      "lastTime": "2025-09-19 17:32:25",
      "id": 645,
      "organId": "118",
      "parentId": 845,
      "appId": "118",
      "depttypeId": 980,
      "foreignId": "118",
      "createType": 759,
      "type": "ucepf3",
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "areaCode": "9574",
      "organLeader": "pg3wdd",
      "leaderId": "118",
      "leaderMobile": "828.254.1097",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "9574",
      "imagePath": "qmj0r5",
      "priority": 614,
      "status": 279,
      "delFlag": 0,
      "description": "buzdwz",
      "spare1": "fh2q4b",
      "spare2": "5u8ef2",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:25",
        "lastTime": "2025-09-19 17:32:25",
        "id": 602,
        "roletypeId": "118",
        "appId": "118",
        "name": "cleopatra.thompson",
        "code": "9574",
        "priority": 923,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 938,
        "description": "btckox",
        "areaType": "mg9zth"
      }
    ],
    "roleIds": [
      665
    ],
    "positionIds": [
      "4kiz3i"
    ],
    "roleId": 263,
    "userRoleList": [
      {
        "id": 921,
        "deptId": 366,
        "deptName": "cleopatra.thompson",
        "organId": "118",
        "organName": "cleopatra.thompson",
        "roleId": 853,
        "roleName": "cleopatra.thompson",
        "adminId": 143
      }
    ],
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
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
  "data": "qohm0f",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:26",
    "lastTime": "2025-09-19 17:32:26",
    "id": 425,
    "userId": "118",
    "deptId": 665,
    "deptName": "cleopatra.thompson",
    "organId": "118",
    "organName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "username": "cleopatra.thompson",
    "nickName": "maribeth.rutherford",
    "email": "sheree.stanton@gmail.com",
    "mobile": "828.254.1097",
    "imagePath": "di5mat",
    "password": "3boepy",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 664,
    "delFlag": 0,
    "lastLoginIp": "142.83.169.77",
    "lastLoginTime": "2025-09-19 17:32:26",
    "description": "jl1i9f",
    "dept": {
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:26",
      "lastTime": "2025-09-19 17:32:26",
      "id": 213,
      "organId": "118",
      "parentId": 391,
      "appId": "118",
      "depttypeId": 740,
      "foreignId": "118",
      "createType": 611,
      "type": "wwqq4j",
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "areaCode": "9574",
      "organLeader": "g3h95y",
      "leaderId": "118",
      "leaderMobile": "828.254.1097",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "9574",
      "imagePath": "zfhy2e",
      "priority": 657,
      "status": 773,
      "delFlag": 0,
      "description": "2wgzwf",
      "spare1": "sjl2v2",
      "spare2": "ktrrtg",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:26",
        "lastTime": "2025-09-19 17:32:26",
        "id": 81,
        "roletypeId": "118",
        "appId": "118",
        "name": "cleopatra.thompson",
        "code": "9574",
        "priority": 715,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 319,
        "description": "buva9i",
        "areaType": "yf3a4y"
      }
    ],
    "roleIds": [
      447
    ],
    "positionIds": [
      "rr2o2z"
    ],
    "roleId": 237,
    "userRoleList": [
      {
        "id": 465,
        "deptId": 767,
        "deptName": "cleopatra.thompson",
        "organId": "118",
        "organName": "cleopatra.thompson",
        "roleId": 631,
        "roleName": "cleopatra.thompson",
        "adminId": 602
      }
    ],
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
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
  "data": "m6k6ac",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole/322.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "o4v7iv",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X PUT -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole.do --data 'roleIds=19pkmr&roleIds=19pkmr&adminId=117'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "gifqgs",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/list.do?userId=118&endTime=2025-09-19 17:31:32&adminId=420&orderBy=937&mobile=828.254.1097&startTime=2025-09-19 17:31:32&page=1&email=sheree.stanton@gmail.com&nickName=maribeth.rutherford&q=1hjgye&delFlag=0&organId=118&status=uuuarb&limit=10&username=cleopatra.thompson&deptId=489
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:25",
      "lastTime": "2025-09-19 17:32:25",
      "id": 2,
      "userId": "118",
      "deptId": 73,
      "deptName": "cleopatra.thompson",
      "organId": "118",
      "organName": "cleopatra.thompson",
      "name": "cleopatra.thompson",
      "username": "cleopatra.thompson",
      "nickName": "maribeth.rutherford",
      "email": "sheree.stanton@gmail.com",
      "mobile": "828.254.1097",
      "imagePath": "t9y9mi",
      "password": "diy391",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 846,
      "delFlag": 0,
      "lastLoginIp": "142.83.169.77",
      "lastLoginTime": "2025-09-19 17:32:25",
      "description": "3d3mz5",
      "dept": {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:25",
        "lastTime": "2025-09-19 17:32:25",
        "id": 453,
        "organId": "118",
        "parentId": 302,
        "appId": "118",
        "depttypeId": 596,
        "foreignId": "118",
        "createType": 18,
        "type": "2swde7",
        "name": "cleopatra.thompson",
        "sname": "cleopatra.thompson",
        "areaCode": "9574",
        "organLeader": "jk5ohp",
        "leaderId": "118",
        "leaderMobile": "828.254.1097",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "9574",
        "imagePath": "6kqe3u",
        "priority": 265,
        "status": 261,
        "delFlag": 0,
        "description": "idtk7t",
        "spare1": "wexbji",
        "spare2": "x2db07",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "118",
          "createTime": "2025-09-19 17:32:25",
          "lastTime": "2025-09-19 17:32:25",
          "id": 908,
          "roletypeId": "118",
          "appId": "118",
          "name": "cleopatra.thompson",
          "code": "9574",
          "priority": 525,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 266,
          "description": "8oyp1a",
          "areaType": "767ijk"
        }
      ],
      "roleIds": [
        637
      ],
      "positionIds": [
        "cjczqy"
      ],
      "roleId": 534,
      "userRoleList": [
        {
          "id": 830,
          "deptId": 757,
          "deptName": "cleopatra.thompson",
          "organId": "118",
          "organName": "cleopatra.thompson",
          "roleId": 568,
          "roleName": "cleopatra.thompson",
          "adminId": 384
        }
      ],
      "code": "9574",
      "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:25",
      "lastTime": "2025-09-19 17:32:25",
      "id": 474,
      "userId": "118",
      "deptId": 851,
      "deptName": "cleopatra.thompson",
      "organId": "118",
      "organName": "cleopatra.thompson",
      "name": "cleopatra.thompson",
      "username": "cleopatra.thompson",
      "nickName": "maribeth.rutherford",
      "email": "sheree.stanton@gmail.com",
      "mobile": "828.254.1097",
      "imagePath": "tunjbl",
      "password": "ihyl5l",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 498,
      "delFlag": 0,
      "lastLoginIp": "142.83.169.77",
      "lastLoginTime": "2025-09-19 17:32:25",
      "description": "9b12c2",
      "dept": {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:25",
        "lastTime": "2025-09-19 17:32:25",
        "id": 85,
        "organId": "118",
        "parentId": 202,
        "appId": "118",
        "depttypeId": 101,
        "foreignId": "118",
        "createType": 985,
        "type": "9x331x",
        "name": "cleopatra.thompson",
        "sname": "cleopatra.thompson",
        "areaCode": "9574",
        "organLeader": "u9ymzs",
        "leaderId": "118",
        "leaderMobile": "828.254.1097",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "9574",
        "imagePath": "sv7xne",
        "priority": 385,
        "status": 375,
        "delFlag": 0,
        "description": "3i8lk9",
        "spare1": "7g5bnb",
        "spare2": "fe8l6j",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "118",
          "createTime": "2025-09-19 17:32:25",
          "lastTime": "2025-09-19 17:32:25",
          "id": 356,
          "roletypeId": "118",
          "appId": "118",
          "name": "cleopatra.thompson",
          "code": "9574",
          "priority": 271,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 285,
          "description": "7zg9bq",
          "areaType": "kuehed"
        }
      ],
      "roleIds": [
        278
      ],
      "positionIds": [
        "mtism0"
      ],
      "roleId": 747,
      "userRoleList": [
        {
          "id": 866,
          "deptId": 192,
          "deptName": "cleopatra.thompson",
          "organId": "118",
          "organName": "cleopatra.thompson",
          "roleId": 920,
          "roleName": "cleopatra.thompson",
          "adminId": 455
        }
      ],
      "code": "9574",
      "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
    },
    "roles": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:25",
        "lastTime": "2025-09-19 17:32:25",
        "roleId": 35,
        "roleName": "cleopatra.thompson",
        "roleKey": "o6ifud",
        "roleSort": 128,
        "menuCheckStrictly": true,
        "deptCheckStrictly": true,
        "status": 636,
        "flag": true,
        "menuIds": [
          412
        ],
        "deptIds": [
          250
        ],
        "permissions": [
          "tiz3vd"
        ],
        "remark": "r8fze2",
        "parentName": "cleopatra.thompson",
        "appName": "cleopatra.thompson",
        "roletypeId": "118",
        "roletypeName": "cleopatra.thompson",
        "priority": 453,
        "isSuper": true
      }
    ],
    "roleList": [
      {
        "id": 451,
        "roleId": 108,
        "adminId": 756,
        "deptId": 221,
        "deptName": "cleopatra.thompson",
        "organId": "118",
        "organName": "cleopatra.thompson",
        "roleName": "cleopatra.thompson"
      }
    ],
    "positions": [
      {
        "postId": "118",
        "postCode": "9574",
        "postName": "cleopatra.thompson",
        "postSort": 612,
        "status": 592,
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:25",
        "lastTime": "2025-09-19 17:32:25",
        "delFlag": 0,
        "remark": "7jiye4",
        "ids": [
          "h4924t"
        ],
        "positionId": "118",
        "flag": true
      }
    ],
    "roleIds": [
      875
    ],
    "positionIds": [
      223
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/deptTree.do?isOrganLevel=true&areaCode=9574&organId=118&depttypeId=265&status=81&page=1&name=cleopatra.thompson&imagePath=2b2445&parentId=585&description=1m322d&createType=87&leaderMobile=828.254.1097&spare2=yvpkkx&appId=118&sname=cleopatra.thompson&isLeaf=true&leaderId=118&spare1=rwofis&endTime=2025-09-19 17:31:32&orderBy=777&creatorId=118&isVirtual=true&q=mot47z&deptId=485&delFlag=0&isDisabled=true&limit=10&startTime=2025-09-19 17:31:32&foreignId=118&type=engpx2&organLeader=dvs62x&searchCode=9574
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
      "id": 373,
      "label": "ky1qce",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/selectList.do?appType=0jtc6q&existKey=afn0ij&ftpId=118&isMobileApp=true&status=770&page=1&path=u5wsg8&limit=10&isDisabled=true&ids=pyouo4&ids=pyouo4&xzqhId=314&description=nd9885&endTime=2025-09-19 17:31:32&orderBy=602&delFlag=0&organId=118&sertypeId=118&domainId=118&startTime=2025-09-19 17:31:32&mode=725&name=cleopatra.thompson&isSite=true&q=r9p0t3
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:30",
      "lastTime": "2025-09-19 17:32:30",
      "id": "118",
      "ftpId": "118",
      "domainId": "118",
      "organId": "118",
      "xzqhId": 155,
      "sertypeId": "118",
      "name": "cleopatra.thompson",
      "path": "ahab6j",
      "appType": "6w8sae",
      "isSite": true,
      "isDisabled": true,
      "isMobileApp": true,
      "status": 416,
      "priority": 885,
      "delFlag": 0,
      "deleteTime": "2025-09-19 17:32:30",
      "description": "0lfze3",
      "spare1": "lw1rr0",
      "spare2": "m8mhbv",
      "xzqhName": "cleopatra.thompson"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/list.do?ftpId=118&delFlag=0&mode=116&description=x5zoef&ids=vuveko&ids=vuveko&startTime=2025-09-19 17:31:32&isSite=true&limit=10&xzqhId=570&page=1&sertypeId=118&organId=118&isMobileApp=true&orderBy=813&endTime=2025-09-19 17:31:32&domainId=118&path=f3amki&status=971&existKey=hqt8l0&q=iqtbei&appType=56mm13&idArr=6vmbdy&name=cleopatra.thompson&isDisabled=true
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
    "totalCount": 30,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:30",
        "lastTime": "2025-09-19 17:32:30",
        "id": "118",
        "ftpId": "118",
        "domainId": "118",
        "organId": "118",
        "xzqhId": 180,
        "sertypeId": "118",
        "name": "cleopatra.thompson",
        "path": "99dz15",
        "appType": "hhi7xy",
        "isSite": true,
        "isDisabled": true,
        "isMobileApp": true,
        "status": 974,
        "priority": 275,
        "delFlag": 0,
        "deleteTime": "2025-09-19 17:32:30",
        "description": "4t0u5g",
        "spare1": "azafyk",
        "spare2": "pg45sl",
        "xzqhName": "cleopatra.thompson"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/export.do --data 'idArr=mx9car&isDisabled=true&description=lszkxh&sertypeId=118&ftpId=118&xzqhId=707&path=ptuoln&isMobileApp=true&endTime=2025-09-19 17:31:32&organId=118&existKey=p46q3z&delFlag=0&appType=qb5nhf&status=954&isSite=true&mode=990&page=1&startTime=2025-09-19 17:31:32&ids=30prkw&ids=30prkw&domainId=118&q=li7dy3&limit=10&name=cleopatra.thompson&orderBy=15'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "uuj591",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/118.do
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:30",
    "lastTime": "2025-09-19 17:32:30",
    "id": "118",
    "ftpId": "118",
    "domainId": "118",
    "organId": "118",
    "xzqhId": 523,
    "sertypeId": "118",
    "name": "cleopatra.thompson",
    "path": "ff5hhj",
    "appType": "3wnspm",
    "isSite": true,
    "isDisabled": true,
    "isMobileApp": true,
    "status": 980,
    "priority": 412,
    "delFlag": 0,
    "deleteTime": "2025-09-19 17:32:30",
    "description": "r352rg",
    "spare1": "kd7a1d",
    "spare2": "npn0e1",
    "xzqhName": "cleopatra.thompson",
    "ftpName": "cleopatra.thompson",
    "sertypeName": "cleopatra.thompson",
    "domainName": "cleopatra.thompson",
    "organName": "cleopatra.thompson"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "id": "118",
    "ftpId": "118",
    "ftpName": "cleopatra.thompson",
    "domainId": "118",
    "domainName": "cleopatra.thompson",
    "organId": "118",
    "organName": "cleopatra.thompson",
    "xzqhId": 469,
    "xzqhName": "cleopatra.thompson",
    "sertypeId": "118",
    "sertypeName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "path": "xegsdi",
    "appType": "t4z94l",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 409,
    "statusName": "cleopatra.thompson",
    "priority": 569,
    "createTime": "2025-09-19 17:32:30",
    "description": "4xay0q",
    "spare1": "uqonz7",
    "statusMap": {
      "mapKey": "5dd8w2"
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
  "data": "ba61zc",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "id": "118",
    "ftpId": "118",
    "ftpName": "cleopatra.thompson",
    "domainId": "118",
    "domainName": "cleopatra.thompson",
    "organId": "118",
    "organName": "cleopatra.thompson",
    "xzqhId": 693,
    "xzqhName": "cleopatra.thompson",
    "sertypeId": "118",
    "sertypeName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "path": "i2soyt",
    "appType": "r47ss8",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 804,
    "statusName": "cleopatra.thompson",
    "priority": 483,
    "createTime": "2025-09-19 17:32:30",
    "description": "serfoo",
    "spare1": "e6upok",
    "statusMap": {
      "mapKey": "72ha4o"
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
  "data": "qnbyzp",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "pflfzz",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/init/118.do --data '{
  "data": {
    "id": "118",
    "menuJsons": {
      "size": 10
    },
    "initJson": {},
    "username": "cleopatra.thompson",
    "password": "lnnimy",
    "initPath": "bnyc4v"
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
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "e7s7w1",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/xzqh/list.do?areatypeId=118&page=1&limit=10&code=9574&likeQuery=2anct2&orderBy=10&endTime=2025-09-19 17:31:32&hasContent=true&isDisplay=true&delFlag=0&deleteTime=2025-09-19 17:31:32&q=tcddge&nameTotal=1dibnu&sname=cleopatra.thompson&nameEn=4i6lsh&lft=51&searchCode=9574&areatypeIds=6bcf8o&areatypeIds=6bcf8o&ids=wtd6vm&ids=wtd6vm&startTime=2025-09-19 17:31:32&name=cleopatra.thompson&description=r6q3d7&rgt=373&parentIds=83k0jt&parentIds=83k0jt&countryId=118&parentId=213
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
    "totalCount": 641,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:31",
        "lastTime": "2025-09-19 17:32:31",
        "id": 121,
        "parentId": 326,
        "countryId": "118",
        "areatypeId": "118",
        "lft": 843,
        "rgt": 386,
        "code": "9574",
        "name": "cleopatra.thompson",
        "nameTotal": "wbdo88",
        "sname": "cleopatra.thompson",
        "nameEn": "8lyvdq",
        "searchCode": "9574",
        "isDisplay": true,
        "hasContent": true,
        "priority": 493,
        "delFlag": 0,
        "deleteTime": "2025-09-19 17:32:31",
        "description": "9byzu0",
        "countryName": "cleopatra.thompson",
        "parentName": "cleopatra.thompson",
        "areatypeName": "cleopatra.thompson"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/organ/list.do?orderBy=826&xzqhId=250&startTime=2025-09-19 17:31:32&orgtypeId=118&unionCode=9574&ids=sqighp&ids=sqighp&name=cleopatra.thompson&organName=cleopatra.thompson&page=1&isOrganWork=wxvkk9&limit=10&source=183&organCode=9574&createType=502&spare1=ytifjp&q=0xh5wl&endTime=2025-09-19 17:31:32&spare2=t83rh0&key=taae0o&description=7stclb&delFlag=0
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
    "totalCount": 732,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:31",
        "lastTime": "2025-09-19 17:32:31",
        "cmsKey": "tu771q",
        "cmsValue": "nbqiby"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/list.do?ids=0ei7f0&ids=0ei7f0&nameTotal=m8voq1&startTime=2025-09-19 17:31:32&parentIds=wy7ayy&parentIds=wy7ayy&limit=10&name=cleopatra.thompson&q=ykcxqt&parentId=305&orderBy=948&hasContent=true&countryId=118&areatypeId=118&endTime=2025-09-19 17:31:32&isDisplay=true&description=0eksgw&deleteTime=2025-09-19 17:31:32&page=1&nameEn=zsvqdg&searchCode=9574&areatypeIds=czc68b&areatypeIds=czc68b&likeQuery=4hnrae&delFlag=0&sname=cleopatra.thompson&lft=179&code=9574&rgt=136
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:31",
      "lastTime": "2025-09-19 17:32:31",
      "id": 913,
      "parentId": 975,
      "countryId": "118",
      "areatypeId": "118",
      "lft": 142,
      "rgt": 815,
      "code": "9574",
      "name": "cleopatra.thompson",
      "nameTotal": "ujfrax",
      "sname": "cleopatra.thompson",
      "nameEn": "k725el",
      "searchCode": "9574",
      "isDisplay": true,
      "hasContent": true,
      "priority": 658,
      "delFlag": 0,
      "deleteTime": "2025-09-19 17:32:31",
      "description": "j3qmi3"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/export.do --data 'nameTotal=fqjcst&parentId=944&searchCode=9574&lft=58&rgt=760&delFlag=0&parentIds=0rv6no&parentIds=0rv6no&name=cleopatra.thompson&description=oaz3fs&page=1&nameEn=v95mo4&q=gntb7v&orderBy=489&startTime=2025-09-19 17:31:32&limit=10&countryId=118&isDisplay=true&endTime=2025-09-19 17:31:32&sname=cleopatra.thompson&areatypeIds=3cphf7&areatypeIds=3cphf7&areatypeId=118&likeQuery=3fc69n&hasContent=true&ids=fl1mdg&ids=fl1mdg&code=9574&deleteTime=2025-09-19 17:31:32'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "64o11c",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:31",
    "lastTime": "2025-09-19 17:32:31",
    "id": 813,
    "parentId": 869,
    "countryId": "118",
    "areatypeId": "118",
    "lft": 664,
    "rgt": 393,
    "code": "9574",
    "name": "cleopatra.thompson",
    "nameTotal": "26sr8p",
    "sname": "cleopatra.thompson",
    "nameEn": "h9cx0z",
    "searchCode": "9574",
    "isDisplay": true,
    "hasContent": true,
    "priority": 656,
    "delFlag": 0,
    "deleteTime": "2025-09-19 17:32:31",
    "description": "gykc0f"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:31",
    "lastTime": "2025-09-19 17:32:31",
    "id": 108,
    "parentId": 7,
    "countryId": "118",
    "areatypeId": "118",
    "lft": 930,
    "rgt": 363,
    "code": "9574",
    "name": "cleopatra.thompson",
    "nameTotal": "vske8g",
    "sname": "cleopatra.thompson",
    "nameEn": "noo2cw",
    "searchCode": "9574",
    "isDisplay": true,
    "hasContent": true,
    "priority": 538,
    "delFlag": 0,
    "deleteTime": "2025-09-19 17:32:31",
    "description": "akulxg"
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
  "data": "pry2r4",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:31",
    "lastTime": "2025-09-19 17:32:31",
    "id": 683,
    "parentId": 513,
    "countryId": "118",
    "areatypeId": "118",
    "lft": 524,
    "rgt": 351,
    "code": "9574",
    "name": "cleopatra.thompson",
    "nameTotal": "uqte16",
    "sname": "cleopatra.thompson",
    "nameEn": "7dx2q7",
    "searchCode": "9574",
    "isDisplay": true,
    "hasContent": true,
    "priority": 438,
    "delFlag": 0,
    "deleteTime": "2025-09-19 17:32:31",
    "description": "6u4qlz"
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
  "data": "jeo39g",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "vnfyrp",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/list.do?serverUrl=www.lezlie-kreiger.net&type=718&serverConf3=mhevhq&organName=cleopatra.thompson&serverIp=142.83.169.77&orderBy=17&startTime=2025-09-19 17:31:32&isSingle=true&clientId=118&q=vkqr3v&isAdmin=true&aesKey=qnuq3h&serverConf2=f3m89e&organId=118&serverType=3bunay&isDisabled=true&description=mi9c2b&spare2=etegz0&inoutMode=913&clientSecret=2j5pdu&cname=cleopatra.thompson&serverConf1=dyl8h4&status=991&name=cleopatra.thompson&aesIvKey=qoszas&endTime=2025-09-19 17:31:32&id=118&confLimit=10&page=1&limit=10&appId=118&spare1=y37j58&currCount=876
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:33",
      "lastTime": "2025-09-19 17:32:33",
      "id": "118",
      "organId": "118",
      "appId": "118",
      "organName": "cleopatra.thompson",
      "inoutMode": 947,
      "name": "cleopatra.thompson",
      "cname": "cleopatra.thompson",
      "type": 958,
      "clientId": "118",
      "clientSecret": "x4kp2y",
      "aesKey": "xrmvgh",
      "aesIvKey": "0h6vlh",
      "serverIp": "142.83.169.77",
      "serverType": "q4n8oe",
      "serverUrl": "www.lezlie-kreiger.net",
      "serverConf1": "q9cxp7",
      "serverConf2": "rxvp2i",
      "serverConf3": "o9sey7",
      "currCount": 591,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 528,
      "description": "w9sril",
      "spare1": "lo72is",
      "spare2": "gohdmk",
      "inOrganName": "cleopatra.thompson",
      "userName": "cleopatra.thompson",
      "appName": "cleopatra.thompson",
      "inoutModeName": "cleopatra.thompson",
      "typeName": "cleopatra.thompson"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/getClientSecret.do?clientId=118
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:33",
      "lastTime": "2025-09-19 17:32:33",
      "id": "118",
      "organId": "118",
      "appId": "118",
      "organName": "cleopatra.thompson",
      "inoutMode": 759,
      "name": "cleopatra.thompson",
      "cname": "cleopatra.thompson",
      "type": 546,
      "clientId": "118",
      "clientSecret": "e7gn7j",
      "aesKey": "zg5myo",
      "aesIvKey": "2arizh",
      "serverIp": "142.83.169.77",
      "serverType": "fnhzrd",
      "serverUrl": "www.lezlie-kreiger.net",
      "serverConf1": "atwn6e",
      "serverConf2": "0w0g9r",
      "serverConf3": "ws5mfc",
      "currCount": 397,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 92,
      "description": "y54605",
      "spare1": "kdnbub",
      "spare2": "eal981",
      "inOrganName": "cleopatra.thompson",
      "userName": "cleopatra.thompson",
      "appName": "cleopatra.thompson",
      "inoutModeName": "cleopatra.thompson",
      "typeName": "cleopatra.thompson"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/getKeyParity.do?id=118
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:33",
      "lastTime": "2025-09-19 17:32:33",
      "id": "118",
      "organId": "118",
      "appId": "118",
      "organName": "cleopatra.thompson",
      "inoutMode": 23,
      "name": "cleopatra.thompson",
      "cname": "cleopatra.thompson",
      "type": 976,
      "clientId": "118",
      "clientSecret": "9obxyr",
      "aesKey": "wc5loo",
      "aesIvKey": "u256kj",
      "serverIp": "142.83.169.77",
      "serverType": "cmwysm",
      "serverUrl": "www.lezlie-kreiger.net",
      "serverConf1": "grjapr",
      "serverConf2": "zvojkp",
      "serverConf3": "yh8gph",
      "currCount": 722,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 272,
      "description": "rfvmob",
      "spare1": "60s7sx",
      "spare2": "ilac57",
      "inOrganName": "cleopatra.thompson",
      "userName": "cleopatra.thompson",
      "appName": "cleopatra.thompson",
      "inoutModeName": "cleopatra.thompson",
      "typeName": "cleopatra.thompson"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
{"success":true,"code":"0","msg":"正常","data":Error restful return.,"requestId":"118","timestamp":"2025-09-19 17:31:32"}
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
  "data": "qt79qj",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "iwnuk0",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "fgbus1",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/list.do?organId=118&limit=10&endTime=2025-09-19 17:31:32&q=lyubwh&startTime=2025-09-19 17:31:32&page=1&organName=cleopatra.thompson&delFlag=0&orderBy=786&wlType=ijodit
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
        "4cj1jh"
      ],
      "organId": "118",
      "organName": "cleopatra.thompson",
      "organSName": "cleopatra.thompson",
      "organCode": "9574",
      "address": "Apt. 241 1389 Wiegand Camp， Jesusamouth， MN 26066-3844",
      "wlType": "hcscwf",
      "wlTypeName": "cleopatra.thompson",
      "priority": 605,
      "delFlag": 0,
      "createTime": "2025-09-19 17:32:32",
      "lastTime": "2025-09-19 17:32:32",
      "contactName": "cleopatra.thompson",
      "contactEmail": "sheree.stanton@gmail.com",
      "contactMobile": "828.254.1097",
      "description": "lutf79",
      "tel": "kap2pb"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "p51zhz"
    ],
    "organId": "118",
    "organName": "cleopatra.thompson",
    "organSName": "cleopatra.thompson",
    "organCode": "9574",
    "address": "Apt. 241 1389 Wiegand Camp， Jesusamouth， MN 26066-3844",
    "wlType": "w0sj8i",
    "wlTypeName": "cleopatra.thompson",
    "priority": 437,
    "delFlag": 0,
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "contactName": "cleopatra.thompson",
    "contactEmail": "sheree.stanton@gmail.com",
    "contactMobile": "828.254.1097",
    "description": "nh7d49",
    "tel": "gkfqmc"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "a9h824"
    ],
    "organId": "118",
    "organName": "cleopatra.thompson",
    "organSName": "cleopatra.thompson",
    "organCode": "9574",
    "address": "Apt. 241 1389 Wiegand Camp， Jesusamouth， MN 26066-3844",
    "wlType": "gjzik7",
    "wlTypeName": "cleopatra.thompson",
    "priority": 246,
    "delFlag": 0,
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "contactName": "cleopatra.thompson",
    "contactEmail": "sheree.stanton@gmail.com",
    "contactMobile": "828.254.1097",
    "description": "zjfwj7",
    "tel": "l6nv47"
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
  "data": "kxcz1g",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "7d8q89"
    ],
    "organId": "118",
    "organName": "cleopatra.thompson",
    "organSName": "cleopatra.thompson",
    "organCode": "9574",
    "address": "Apt. 241 1389 Wiegand Camp， Jesusamouth， MN 26066-3844",
    "wlType": "8ihp0v",
    "wlTypeName": "cleopatra.thompson",
    "priority": 220,
    "delFlag": 0,
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "contactName": "cleopatra.thompson",
    "contactEmail": "sheree.stanton@gmail.com",
    "contactMobile": "828.254.1097",
    "description": "iyxo0b",
    "tel": "ma8gei"
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
  "data": "3a2oie",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "vqkprh",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "gflt7d"
    ],
    "organId": "118",
    "organName": "cleopatra.thompson",
    "organSName": "cleopatra.thompson",
    "organCode": "9574",
    "address": "Apt. 241 1389 Wiegand Camp， Jesusamouth， MN 26066-3844",
    "wlType": "92ntno",
    "wlTypeName": "cleopatra.thompson",
    "priority": 246,
    "delFlag": 0,
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "contactName": "cleopatra.thompson",
    "contactEmail": "sheree.stanton@gmail.com",
    "contactMobile": "828.254.1097",
    "description": "3b67n1",
    "tel": "h0m9th"
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
  "data": "ldkm9q",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/list.do?description=u5ncqb&limit=10&sname=cleopatra.thompson&startTime=2025-09-19 17:31:32&delFlag=0&q=cuwpt3&endTime=2025-09-19 17:31:32&orderBy=78&page=1&name=cleopatra.thompson
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:32",
      "lastTime": "2025-09-19 17:32:32",
      "id": "118",
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "priority": 163,
      "delFlag": 0,
      "description": "e8ptlr"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/export.do --data 'orderBy=396&page=1&limit=10&sname=cleopatra.thompson&delFlag=0&endTime=2025-09-19 17:31:32&name=cleopatra.thompson&description=9nrflh&startTime=2025-09-19 17:31:32&q=cl8tik'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "cbh6e4",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "id": "118",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "priority": 834,
    "delFlag": 0,
    "description": "y59ko0"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "id": "118",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "priority": 970,
    "delFlag": 0,
    "description": "k3hx78"
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
  "data": "7ayws0",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "id": "118",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "priority": 863,
    "delFlag": 0,
    "description": "t5ik9o"
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
  "data": "uqgdds",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "3nzvth",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/list.do?description=p970ju&code=9574&page=1&type=n6re9l&q=kql258&orderBy=340&startTime=2025-09-19 17:31:32&endTime=2025-09-19 17:31:32&limit=10&existKey=98exx1&delFlag=0&name=cleopatra.thompson
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:32",
      "lastTime": "2025-09-19 17:32:32",
      "id": "118",
      "name": "cleopatra.thompson",
      "type": "tga8ci",
      "code": "9574",
      "priority": 157,
      "delFlag": 0,
      "description": "dygld0"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/export.do --data 'code=9574&orderBy=972&existKey=u9f76z&startTime=2025-09-19 17:31:32&endTime=2025-09-19 17:31:32&type=or2nsw&q=nsk2mm&delFlag=0&limit=10&name=cleopatra.thompson&description=rq94xd&page=1'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "bwqzxo",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "id": "118",
    "name": "cleopatra.thompson",
    "type": "0fhnr1",
    "code": "9574",
    "priority": 746,
    "delFlag": 0,
    "description": "qdbki8"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "id": "118",
    "name": "cleopatra.thompson",
    "type": "vpux8x",
    "code": "9574",
    "priority": 217,
    "delFlag": 0,
    "description": "ty14p5"
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
  "data": "ehb2wa",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:32",
    "lastTime": "2025-09-19 17:32:32",
    "id": "118",
    "name": "cleopatra.thompson",
    "type": "9jia3x",
    "code": "9574",
    "priority": 4,
    "delFlag": 0,
    "description": "o93xmb"
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
  "data": "1lf5p2",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "i9tl8n",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/list.do?endTime=2025-09-19 17:31:32&appId=118&fileSize=783&resclassId=118&refType=8pq35y&orderBy=488&refId=118&q=gqhs35&limit=10&key=hhj73j&fileName=cleopatra.thompson&fileExtension=zya4el&startTime=2025-09-19 17:31:32&page=1&fileIsvalid=true
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
    "totalCount": 592,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "id": "118",
        "resclassId": "118",
        "fileName": "cleopatra.thompson",
        "fileIsvalid": true,
        "createTime": "2025-09-19 17:32:31",
        "fileExtension": "vq9s6g",
        "ids": [
          "mgrag9"
        ]
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/export.do --data 'startTime=2025-09-19 17:31:32&page=1&resclassId=118&q=jy9ujo&fileSize=676&fileExtension=1bzxxd&endTime=2025-09-19 17:31:32&refId=118&limit=10&refType=ccmpz6&fileName=cleopatra.thompson&appId=118&fileIsvalid=true&key=45fgxu&orderBy=934'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "9rx1by",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/info.do?id=118
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
    "id": "118",
    "resclassId": "118",
    "fileName": "cleopatra.thompson",
    "fileIsvalid": true,
    "createTime": "2025-09-19 17:32:31",
    "fileExtension": "ix864i",
    "ids": [
      "fksv2v"
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "id": "118",
    "resclassId": "118",
    "fileName": "cleopatra.thompson",
    "fileIsvalid": true,
    "createTime": "2025-09-19 17:32:31",
    "fileExtension": "hlugef",
    "ids": [
      "zdfrtm"
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
  "data": "3kx4tz",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "id": "118",
    "resclassId": "118",
    "fileName": "cleopatra.thompson",
    "fileIsvalid": true,
    "createTime": "2025-09-19 17:32:31",
    "fileExtension": "cefnjp",
    "ids": [
      "50leg1"
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
  "data": "lxsdsy",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "id": "118",
    "resclassId": "118",
    "fileName": "cleopatra.thompson",
    "fileIsvalid": true,
    "createTime": "2025-09-19 17:32:31",
    "fileExtension": "wci0so",
    "ids": [
      "8eu9w7"
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
  "data": "8shoab",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "fmxc8t",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download.do?delete=true&fileName=cleopatra.thompson
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "hhkf8l",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "originFilename": "cleopatra.thompson",
    "filename": "cleopatra.thompson",
    "fileType": "ufyj3h",
    "fileUrl": "www.lezlie-kreiger.net",
    "fileHttpUrl": "www.lezlie-kreiger.net",
    "statusCode": "9574"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "originFilename": "cleopatra.thompson",
      "filename": "cleopatra.thompson",
      "fileType": "7tdnkt",
      "fileUrl": "www.lezlie-kreiger.net",
      "fileHttpUrl": "www.lezlie-kreiger.net",
      "statusCode": "9574"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download/resource.do?resource=qxmpji
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "f1kau1",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/list.do?organId=118&startTime=2025-09-19 17:31:32&type=42rfxp&status=882&appId=118&areaId=970&batchId=118&orderBy=432&groupId=467&endTime=2025-09-19 17:31:32&limit=10&page=1&positionId=118&roleTypeId=118&q=l139zi&keyWords=hejw0s
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
    "totalCount": 575,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:28",
        "lastTime": "2025-09-19 17:32:28",
        "id": 3,
        "appId": "118",
        "saveSource": "1jn6cq",
        "unitName": "cleopatra.thompson",
        "name": "cleopatra.thompson",
        "idNum": "o8oay6",
        "duty": "218oir",
        "telephone": "(716) 567-3660",
        "mobile": "828.254.1097",
        "extInfo1": "3ahzo9",
        "extInfo2": "4kbp9t",
        "extInfo3": "ij7fe6",
        "needInitUser": true,
        "userId": "118",
        "needInitOrgan": true,
        "organId": "118",
        "type": "cxbhny",
        "foreignUrl": "www.lezlie-kreiger.net",
        "bizType": 722,
        "bizOrganId": "118",
        "bizAreaId": 626,
        "bizGroupId": 610,
        "bizPower": "khxn0t",
        "bizMultiInfo": "e4z4o2",
        "needSetOrgan": true,
        "needSetArea": true,
        "needSetGroup": true,
        "needSetPower": true,
        "opUserId": "118",
        "opOrganId": "118",
        "opTime": "2025-09-19 17:32:28",
        "opInfo": "wxavvl",
        "priority": 139,
        "status": 526,
        "delFlag": 0,
        "dataBatch": "ej4nb9",
        "dataVersion": 162,
        "updateTime": "2025-09-19 17:32:28",
        "syncMode": "5rpaeq",
        "syncTime": "2025-09-19 17:32:28",
        "description": "y4wzie",
        "groupName": "cleopatra.thompson",
        "positionName": "cleopatra.thompson",
        "bizPowerName": "cleopatra.thompson",
        "subdistrictName": "cleopatra.thompson",
        "communityName": "cleopatra.thompson"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/export.do --data 'q=o8qktl&status=135&page=1&organId=118&roleTypeId=118&positionId=118&appId=118&orderBy=81&endTime=2025-09-19 17:31:32&groupId=61&areaId=374&keyWords=bb79vt&limit=10&batchId=118&type=5k76ek&startTime=2025-09-19 17:31:32'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "nvyfh4",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/882.do
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:28",
    "lastTime": "2025-09-19 17:32:28",
    "id": 572,
    "appId": "118",
    "saveSource": "g7l0j3",
    "unitName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "idNum": "grugvi",
    "duty": "joo1y5",
    "telephone": "(716) 567-3660",
    "mobile": "828.254.1097",
    "extInfo1": "95bdn8",
    "extInfo2": "3drrhn",
    "extInfo3": "nk4mwp",
    "needInitUser": true,
    "userId": "118",
    "needInitOrgan": true,
    "organId": "118",
    "type": "042r7i",
    "foreignUrl": "www.lezlie-kreiger.net",
    "bizType": 256,
    "bizOrganId": "118",
    "bizAreaId": 302,
    "bizGroupId": 79,
    "bizPower": "go8j91",
    "bizMultiInfo": "42omak",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "118",
    "opOrganId": "118",
    "opTime": "2025-09-19 17:32:28",
    "opInfo": "p1hx1y",
    "priority": 130,
    "status": 349,
    "delFlag": 0,
    "dataBatch": "8isqxv",
    "dataVersion": 725,
    "updateTime": "2025-09-19 17:32:28",
    "syncMode": "451bia",
    "syncTime": "2025-09-19 17:32:28",
    "description": "3w6nbx",
    "groupName": "cleopatra.thompson",
    "positionName": "cleopatra.thompson",
    "bizPowerName": "cleopatra.thompson",
    "subdistrictName": "cleopatra.thompson",
    "communityName": "cleopatra.thompson"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:28",
    "lastTime": "2025-09-19 17:32:28",
    "id": 542,
    "appId": "118",
    "saveSource": "n6xi9s",
    "unitName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "idNum": "bq3vrg",
    "duty": "ygirat",
    "telephone": "(716) 567-3660",
    "mobile": "828.254.1097",
    "extInfo1": "v5ymz0",
    "extInfo2": "vpfatd",
    "extInfo3": "bmkosk",
    "needInitUser": true,
    "userId": "118",
    "needInitOrgan": true,
    "organId": "118",
    "type": "kyk0iy",
    "foreignUrl": "www.lezlie-kreiger.net",
    "bizType": 571,
    "bizOrganId": "118",
    "bizAreaId": 772,
    "bizGroupId": 545,
    "bizPower": "giyz8v",
    "bizMultiInfo": "0wnu33",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "118",
    "opOrganId": "118",
    "opTime": "2025-09-19 17:32:28",
    "opInfo": "b8zdee",
    "priority": 954,
    "status": 941,
    "delFlag": 0,
    "dataBatch": "gyu2iq",
    "dataVersion": 582,
    "updateTime": "2025-09-19 17:32:28",
    "syncMode": "0gcgr6",
    "syncTime": "2025-09-19 17:32:28",
    "description": "9h5se0"
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
  "data": "f0bf8n",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:28",
    "lastTime": "2025-09-19 17:32:28",
    "id": 971,
    "appId": "118",
    "saveSource": "erl5gu",
    "unitName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "idNum": "v65v2v",
    "duty": "i9zhdq",
    "telephone": "(716) 567-3660",
    "mobile": "828.254.1097",
    "extInfo1": "rgp2oa",
    "extInfo2": "p3d6w9",
    "extInfo3": "a7llyy",
    "needInitUser": true,
    "userId": "118",
    "needInitOrgan": true,
    "organId": "118",
    "type": "807mx6",
    "foreignUrl": "www.lezlie-kreiger.net",
    "bizType": 193,
    "bizOrganId": "118",
    "bizAreaId": 301,
    "bizGroupId": 659,
    "bizPower": "cqdhrh",
    "bizMultiInfo": "cmn696",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "118",
    "opOrganId": "118",
    "opTime": "2025-09-19 17:32:28",
    "opInfo": "0r04lb",
    "priority": 728,
    "status": 561,
    "delFlag": 0,
    "dataBatch": "641780",
    "dataVersion": 868,
    "updateTime": "2025-09-19 17:32:28",
    "syncMode": "ldbnce",
    "syncTime": "2025-09-19 17:32:28",
    "description": "brdu2z"
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
  "data": "luvy64",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "z5iqhf",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "32lb8v",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list.do?id=22&content=ugnq7u&orderBy=780&updatorId=118&updateTime=2025-09-19 17:32:34&title=8cgog7&status=197&siteId=120&recvMemberId=118&description=n7apnj&endTime=2025-09-19 17:31:32&recvOrganId=118&readStatus=7vtbjx&startTime=2025-09-19 17:31:32&page=1&bizType=rzbjmw&msgUrl=www.lezlie-kreiger.net&recvTargetid=118&recvGroupId=118&type=905&iconStyle=o6dqel&creatorId=118&foreignId=118&q=vwcktr&limit=10&imagePath=1b03vz&organId=118
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:34",
      "lastTime": "2025-09-19 17:32:34",
      "id": 500,
      "siteId": 300,
      "organId": "118",
      "bizType": "ll1on2",
      "type": 68,
      "title": "fe8ttg",
      "content": "i7ae8r",
      "msgUrl": "www.lezlie-kreiger.net",
      "foreignId": "118",
      "imagePath": "zgm9ah",
      "iconStyle": "ef4t7u",
      "recvMemberId": "118",
      "recvGroupId": "118",
      "recvOrganId": "118",
      "recvTargetid": "118",
      "status": 170,
      "updatorId": "118",
      "updateTime": "2025-09-19 17:32:34",
      "description": "2fnq2c"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list/myself.do?iconStyle=fb3q1w&bizType=t8nazq&page=1&description=geerva&status=983&msgUrl=www.lezlie-kreiger.net&recvTargetid=118&content=wv8y61&foreignId=118&creatorId=118&readStatus=yzd5ff&imagePath=n1bfzn&title=ujmwdd&orderBy=940&startTime=2025-09-19 17:31:32&recvMemberId=118&type=689&organId=118&updateTime=2025-09-19 17:32:35&recvOrganId=118&limit=10&updatorId=118&q=wrbgia&siteId=534&recvGroupId=118&id=724&endTime=2025-09-19 17:31:32
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:35",
      "lastTime": "2025-09-19 17:32:35",
      "id": 566,
      "siteId": 993,
      "organId": "118",
      "bizType": "u9fzsi",
      "type": 202,
      "title": "frab4h",
      "content": "nmo980",
      "msgUrl": "www.lezlie-kreiger.net",
      "foreignId": "118",
      "imagePath": "22oiif",
      "iconStyle": "2bm4aw",
      "recvMemberId": "118",
      "recvGroupId": "118",
      "recvOrganId": "118",
      "recvTargetid": "118",
      "status": 407,
      "updatorId": "118",
      "updateTime": "2025-09-19 17:32:35",
      "description": "q00fev"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/export.do --data 'msgUrl=www.lezlie-kreiger.net&page=1&q=pzj7je&foreignId=118&type=367&status=580&organId=118&iconStyle=ezijyc&creatorId=118&readStatus=2qnb3x&bizType=w5j6xl&recvGroupId=118&updatorId=118&updateTime=2025-09-19 17:32:35&orderBy=230&imagePath=x379id&recvMemberId=118&endTime=2025-09-19 17:31:32&startTime=2025-09-19 17:31:32&recvTargetid=118&recvOrganId=118&limit=10&content=cok510&siteId=110&id=220&title=mzg6qq&description=w9t2gu'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "qci3n8",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:35",
    "lastTime": "2025-09-19 17:32:35",
    "id": 409,
    "siteId": 439,
    "organId": "118",
    "bizType": "g89io9",
    "type": 739,
    "title": "j9qfqm",
    "content": "ckzypl",
    "msgUrl": "www.lezlie-kreiger.net",
    "foreignId": "118",
    "imagePath": "e9myqj",
    "iconStyle": "6x3v69",
    "recvMemberId": "118",
    "recvGroupId": "118",
    "recvOrganId": "118",
    "recvTargetid": "118",
    "status": 843,
    "updatorId": "118",
    "updateTime": "2025-09-19 17:32:35",
    "description": "izzia6"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:35",
    "lastTime": "2025-09-19 17:32:35",
    "id": 167,
    "siteId": 701,
    "organId": "118",
    "bizType": "u545q3",
    "type": 261,
    "title": "7m2i6n",
    "content": "irixmz",
    "msgUrl": "www.lezlie-kreiger.net",
    "foreignId": "118",
    "imagePath": "gzeay5",
    "iconStyle": "ot8ui0",
    "recvMemberId": "118",
    "recvGroupId": "118",
    "recvOrganId": "118",
    "recvTargetid": "118",
    "status": 277,
    "updatorId": "118",
    "updateTime": "2025-09-19 17:32:35",
    "description": "2xe90w"
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
  "data": "87ijvt",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:35",
    "lastTime": "2025-09-19 17:32:35",
    "id": 239,
    "siteId": 670,
    "organId": "118",
    "bizType": "lqdsbt",
    "type": 668,
    "title": "ala22m",
    "content": "5oh0xl",
    "msgUrl": "www.lezlie-kreiger.net",
    "foreignId": "118",
    "imagePath": "i9s41j",
    "iconStyle": "b5faxv",
    "recvMemberId": "118",
    "recvGroupId": "118",
    "recvOrganId": "118",
    "recvTargetid": "118",
    "status": 277,
    "updatorId": "118",
    "updateTime": "2025-09-19 17:32:35",
    "description": "av7x05"
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
  "data": "dm0obt",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "ar4592",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "zky59g",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "hatikt",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "6cwehi",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "mapKey1": "liq4r9",
    "mapKey2": "4jna44"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/list.do?msgOrganName=cleopatra.thompson&msgContent=3mznbl&msgTitle=7z1043&orderBy=795&q=1gusot&opUserId=118&msgModuleId=118&msgAbstract=kwaox5&msgOrganId=118&limit=10&msgId=832&msgLabels=54xhlz&id=118&page=1&msgUserId=118&msgUrl=www.lezlie-kreiger.net&msgUserName=cleopatra.thompson&opTime=2025-09-19 17:32:35&msgModuleName=cleopatra.thompson&opOrganName=cleopatra.thompson&creatorId=118&spare2=fc5ozy&msgAccountId=118&siteId=311&type=vf1n8h&msgType=694&msgAccountName=cleopatra.thompson&foreignId=118&status=04af3v&description=jui1q6&opOrganId=118&bizType=pxrnky&spare1=11p73u&msgCreateTime=2025-09-19 17:32:35&endTime=2025-09-19 17:31:32&startTime=2025-09-19 17:31:32
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:35",
      "lastTime": "2025-09-19 17:32:35",
      "id": "118",
      "siteId": 922,
      "foreignId": "118",
      "type": "b4fkpq",
      "bizType": "mrzryj",
      "msgCreateTime": "2025-09-19 17:32:35",
      "msgId": 741,
      "msgType": 536,
      "msgTitle": "2yank7",
      "msgAbstract": "arrhpp",
      "msgAccountId": "118",
      "msgAccountName": "cleopatra.thompson",
      "msgModuleId": "118",
      "msgModuleName": "cleopatra.thompson",
      "msgUserId": "118",
      "msgUserName": "cleopatra.thompson",
      "msgOrganId": "118",
      "msgOrganName": "cleopatra.thompson",
      "msgUrl": "www.lezlie-kreiger.net",
      "msgLabels": "xemff6",
      "msgContent": "gusmxw",
      "status": "ngond9",
      "opUserId": "118",
      "opTime": "2025-09-19 17:32:35",
      "opOrganId": "118",
      "opOrganName": "cleopatra.thompson",
      "description": "s9iqdf",
      "spare1": "986zvn",
      "spare2": "8q5e6i"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/export.do --data 'description=uybjja&bizType=dbue53&msgAccountName=cleopatra.thompson&id=118&type=0plvi7&startTime=2025-09-19 17:31:32&page=1&msgModuleId=118&msgUserId=118&limit=10&msgId=361&msgType=339&msgAccountId=118&msgUserName=cleopatra.thompson&msgOrganId=118&msgUrl=www.lezlie-kreiger.net&msgContent=9zx8tm&msgTitle=oyc9fz&endTime=2025-09-19 17:31:32&msgModuleName=cleopatra.thompson&q=y2oqbn&foreignId=118&opTime=2025-09-19 17:32:35&msgOrganName=cleopatra.thompson&opUserId=118&opOrganId=118&status=hwppgh&creatorId=118&msgLabels=meyi2i&siteId=131&orderBy=370&spare2=10o7av&msgCreateTime=2025-09-19 17:32:35&msgAbstract=2w90dm&spare1=r7kio2&opOrganName=cleopatra.thompson'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "7l54y8",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:35",
    "lastTime": "2025-09-19 17:32:35",
    "id": "118",
    "siteId": 612,
    "foreignId": "118",
    "type": "djn83t",
    "bizType": "hstmyp",
    "msgCreateTime": "2025-09-19 17:32:35",
    "msgId": 926,
    "msgType": 649,
    "msgTitle": "1bd4d0",
    "msgAbstract": "wwns7p",
    "msgAccountId": "118",
    "msgAccountName": "cleopatra.thompson",
    "msgModuleId": "118",
    "msgModuleName": "cleopatra.thompson",
    "msgUserId": "118",
    "msgUserName": "cleopatra.thompson",
    "msgOrganId": "118",
    "msgOrganName": "cleopatra.thompson",
    "msgUrl": "www.lezlie-kreiger.net",
    "msgLabels": "ko4uzm",
    "msgContent": "1d04lz",
    "status": "qi4kzy",
    "opUserId": "118",
    "opTime": "2025-09-19 17:32:35",
    "opOrganId": "118",
    "opOrganName": "cleopatra.thompson",
    "description": "fkhzuz",
    "spare1": "i9ziis",
    "spare2": "n2awtb"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:35",
    "lastTime": "2025-09-19 17:32:35",
    "id": "118",
    "siteId": 772,
    "foreignId": "118",
    "type": "p7zm2d",
    "bizType": "rc4rri",
    "msgCreateTime": "2025-09-19 17:32:35",
    "msgId": 526,
    "msgType": 628,
    "msgTitle": "2jpsnd",
    "msgAbstract": "v5a3hw",
    "msgAccountId": "118",
    "msgAccountName": "cleopatra.thompson",
    "msgModuleId": "118",
    "msgModuleName": "cleopatra.thompson",
    "msgUserId": "118",
    "msgUserName": "cleopatra.thompson",
    "msgOrganId": "118",
    "msgOrganName": "cleopatra.thompson",
    "msgUrl": "www.lezlie-kreiger.net",
    "msgLabels": "x099b8",
    "msgContent": "v7wn5e",
    "status": "nzavb1",
    "opUserId": "118",
    "opTime": "2025-09-19 17:32:35",
    "opOrganId": "118",
    "opOrganName": "cleopatra.thompson",
    "description": "t54tll",
    "spare1": "zvniia",
    "spare2": "4mvfig"
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
  "data": "clzsqg",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:35",
    "lastTime": "2025-09-19 17:32:35",
    "id": "118",
    "siteId": 657,
    "foreignId": "118",
    "type": "jccbe1",
    "bizType": "oyiumo",
    "msgCreateTime": "2025-09-19 17:32:35",
    "msgId": 293,
    "msgType": 514,
    "msgTitle": "pwz43v",
    "msgAbstract": "hqtjt8",
    "msgAccountId": "118",
    "msgAccountName": "cleopatra.thompson",
    "msgModuleId": "118",
    "msgModuleName": "cleopatra.thompson",
    "msgUserId": "118",
    "msgUserName": "cleopatra.thompson",
    "msgOrganId": "118",
    "msgOrganName": "cleopatra.thompson",
    "msgUrl": "www.lezlie-kreiger.net",
    "msgLabels": "4hfuvc",
    "msgContent": "20lt8b",
    "status": "qo0iud",
    "opUserId": "118",
    "opTime": "2025-09-19 17:32:35",
    "opOrganId": "118",
    "opOrganName": "cleopatra.thompson",
    "description": "bj2kz9",
    "spare1": "sei5hs",
    "spare2": "w6ufc7"
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
  "data": "h4eo31",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "i1cc3d",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/read/2wx2le.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "c6c680",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/list.do?todoLabels=x3uywh&q=ekea3n&todoProcessInfo=frxprf&todoNextInfo=6wb8gz&opUserId=118&opOrganId=118&todoId=118&description=8ohz18&siteId=600&todoCurrInfo=puhtyn&spare2=xnl5ov&foreignId=118&todoContent=9esp9k&creatorId=118&todoCreateTime=2025-09-19 17:32:36&todoModuleName=cleopatra.thompson&todoUrl=www.lezlie-kreiger.net&todoName=cleopatra.thompson&todoOrganName=cleopatra.thompson&opOrganName=cleopatra.thompson&todoAccountName=cleopatra.thompson&startTime=2025-09-19 17:31:32&id=118&page=1&todoType=t7pchx&todoUserId=118&todoProcessName=cleopatra.thompson&todoModuleId=118&orderBy=885&endTime=2025-09-19 17:31:32&opTime=2025-09-19 17:32:36&todoAccountId=118&limit=10&todoUserName=cleopatra.thompson&todoOrganId=118&spare1=zjqs7z&bizType=46fh7f&todoAbstract=mp68bk&status=98xys0&type=yyutdr&todoProcessStatus=ljslvl
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:36",
      "lastTime": "2025-09-19 17:32:36",
      "id": "118",
      "siteId": 238,
      "foreignId": "118",
      "type": "iygn3t",
      "bizType": "98cpdu",
      "todoCreateTime": "2025-09-19 17:32:36",
      "todoId": "118",
      "todoType": "hu2un7",
      "todoName": "cleopatra.thompson",
      "todoAbstract": "g170d3",
      "todoAccountId": "118",
      "todoAccountName": "cleopatra.thompson",
      "todoModuleId": "118",
      "todoModuleName": "cleopatra.thompson",
      "todoUserId": "118",
      "todoUserName": "cleopatra.thompson",
      "todoOrganId": "118",
      "todoOrganName": "cleopatra.thompson",
      "todoProcessName": "cleopatra.thompson",
      "todoProcessStatus": "qd0xuo",
      "todoProcessInfo": "8mh2ki",
      "todoCurrInfo": "inzw25",
      "todoNextInfo": "iutsjj",
      "todoUrl": "www.lezlie-kreiger.net",
      "todoLabels": "n09162",
      "todoContent": "u48okw",
      "status": "bdbr5l",
      "opUserId": "118",
      "opTime": "2025-09-19 17:32:36",
      "opOrganId": "118",
      "opOrganName": "cleopatra.thompson",
      "description": "qj3f6f",
      "spare1": "adc4k4",
      "spare2": "u4hmck"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/export.do --data 'todoOrganId=118&todoUrl=www.lezlie-kreiger.net&orderBy=272&id=118&foreignId=118&todoContent=6e4njd&opTime=2025-09-19 17:32:36&limit=10&todoProcessStatus=h5yotu&spare2=lx8tgq&todoUserName=cleopatra.thompson&todoProcessInfo=f4dh9b&type=s2n08q&q=jl1ayf&todoCurrInfo=9pbx25&todoAbstract=i3ku0o&todoLabels=cb4wap&opOrganId=118&todoAccountId=118&todoCreateTime=2025-09-19 17:32:36&todoName=cleopatra.thompson&todoProcessName=cleopatra.thompson&bizType=q1s3zu&endTime=2025-09-19 17:31:32&todoAccountName=cleopatra.thompson&todoId=118&todoModuleId=118&siteId=366&opOrganName=cleopatra.thompson&creatorId=118&status=cufshe&description=ouqjbd&page=1&startTime=2025-09-19 17:31:32&todoModuleName=cleopatra.thompson&todoUserId=118&opUserId=118&spare1=jvtsg6&todoType=x4q18x&todoOrganName=cleopatra.thompson&todoNextInfo=xl04pb'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "7k3103",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:36",
    "lastTime": "2025-09-19 17:32:36",
    "id": "118",
    "siteId": 120,
    "foreignId": "118",
    "type": "hfongb",
    "bizType": "9lx0zc",
    "todoCreateTime": "2025-09-19 17:32:36",
    "todoId": "118",
    "todoType": "6zf9ri",
    "todoName": "cleopatra.thompson",
    "todoAbstract": "u7eapc",
    "todoAccountId": "118",
    "todoAccountName": "cleopatra.thompson",
    "todoModuleId": "118",
    "todoModuleName": "cleopatra.thompson",
    "todoUserId": "118",
    "todoUserName": "cleopatra.thompson",
    "todoOrganId": "118",
    "todoOrganName": "cleopatra.thompson",
    "todoProcessName": "cleopatra.thompson",
    "todoProcessStatus": "8r0o7v",
    "todoProcessInfo": "y5l7se",
    "todoCurrInfo": "9n0uh5",
    "todoNextInfo": "2yve1n",
    "todoUrl": "www.lezlie-kreiger.net",
    "todoLabels": "mpvnih",
    "todoContent": "medqdw",
    "status": "snwuxz",
    "opUserId": "118",
    "opTime": "2025-09-19 17:32:36",
    "opOrganId": "118",
    "opOrganName": "cleopatra.thompson",
    "description": "cnmaay",
    "spare1": "vjh2y4",
    "spare2": "kxky2e"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:36",
    "lastTime": "2025-09-19 17:32:36",
    "id": "118",
    "siteId": 876,
    "foreignId": "118",
    "type": "x97a80",
    "bizType": "zb8jo5",
    "todoCreateTime": "2025-09-19 17:32:36",
    "todoId": "118",
    "todoType": "xbwd10",
    "todoName": "cleopatra.thompson",
    "todoAbstract": "gxrze5",
    "todoAccountId": "118",
    "todoAccountName": "cleopatra.thompson",
    "todoModuleId": "118",
    "todoModuleName": "cleopatra.thompson",
    "todoUserId": "118",
    "todoUserName": "cleopatra.thompson",
    "todoOrganId": "118",
    "todoOrganName": "cleopatra.thompson",
    "todoProcessName": "cleopatra.thompson",
    "todoProcessStatus": "f64jka",
    "todoProcessInfo": "ow9mes",
    "todoCurrInfo": "tkvrtg",
    "todoNextInfo": "468d7a",
    "todoUrl": "www.lezlie-kreiger.net",
    "todoLabels": "zwyloo",
    "todoContent": "856jeh",
    "status": "qg3gbu",
    "opUserId": "118",
    "opTime": "2025-09-19 17:32:36",
    "opOrganId": "118",
    "opOrganName": "cleopatra.thompson",
    "description": "t2nuos",
    "spare1": "vilnmk",
    "spare2": "cn7da2"
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
  "data": "byw9vv",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:36",
    "lastTime": "2025-09-19 17:32:36",
    "id": "118",
    "siteId": 525,
    "foreignId": "118",
    "type": "gcr1yz",
    "bizType": "oqtcun",
    "todoCreateTime": "2025-09-19 17:32:36",
    "todoId": "118",
    "todoType": "a6cg6w",
    "todoName": "cleopatra.thompson",
    "todoAbstract": "zocrsk",
    "todoAccountId": "118",
    "todoAccountName": "cleopatra.thompson",
    "todoModuleId": "118",
    "todoModuleName": "cleopatra.thompson",
    "todoUserId": "118",
    "todoUserName": "cleopatra.thompson",
    "todoOrganId": "118",
    "todoOrganName": "cleopatra.thompson",
    "todoProcessName": "cleopatra.thompson",
    "todoProcessStatus": "lbat8e",
    "todoProcessInfo": "vp5tht",
    "todoCurrInfo": "8phuli",
    "todoNextInfo": "k8ec70",
    "todoUrl": "www.lezlie-kreiger.net",
    "todoLabels": "t31zu1",
    "todoContent": "b650jp",
    "status": "7d2cjb",
    "opUserId": "118",
    "opTime": "2025-09-19 17:32:36",
    "opOrganId": "118",
    "opOrganName": "cleopatra.thompson",
    "description": "t8ldfx",
    "spare1": "5nqshm",
    "spare2": "bxmyo7"
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
  "data": "6vbat3",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "vflu11",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─password|string|密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户名|-
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
      "password": "g4gmag",
      "username": "cleopatra.thompson",
      "authorities": [
        {
          "object": "any object"
        }
      ],
      "adminId": 165,
      "userId": "118",
      "appId": "118",
      "deptId": 152,
      "organId": "118",
      "token": "x7ffr5",
      "imagePath": "kxzlt0",
      "isSuperAdmin": true,
      "loginIp": "142.83.169.77",
      "loginTime": 1758274292622,
      "loginBrowse": "3b1k9m",
      "loginOs": "06asix",
      "expireTime": 1758274292622,
      "perms": [
        "1lhydx"
      ],
      "userType": "ls8jpv"
    },
    "roleGroup": "bjl03y",
    "positionGroup": "va6d8c"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:26",
    "lastTime": "2025-09-19 17:32:26",
    "id": 839,
    "userId": "118",
    "deptId": 706,
    "deptName": "cleopatra.thompson",
    "organId": "118",
    "organName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "username": "cleopatra.thompson",
    "nickName": "maribeth.rutherford",
    "email": "sheree.stanton@gmail.com",
    "mobile": "828.254.1097",
    "imagePath": "2rhxfw",
    "password": "h8jxgs",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 220,
    "delFlag": 0,
    "lastLoginIp": "142.83.169.77",
    "lastLoginTime": "2025-09-19 17:32:26",
    "description": "goy5yi",
    "dept": {
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:26",
      "lastTime": "2025-09-19 17:32:26",
      "id": 632,
      "organId": "118",
      "parentId": 935,
      "appId": "118",
      "depttypeId": 868,
      "foreignId": "118",
      "createType": 358,
      "type": "zj4pom",
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "areaCode": "9574",
      "organLeader": "iho7dv",
      "leaderId": "118",
      "leaderMobile": "828.254.1097",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "9574",
      "imagePath": "52nmxh",
      "priority": 611,
      "status": 330,
      "delFlag": 0,
      "description": "ey4g1i",
      "spare1": "2o6xnj",
      "spare2": "66iwds",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:26",
        "lastTime": "2025-09-19 17:32:26",
        "id": 808,
        "roletypeId": "118",
        "appId": "118",
        "name": "cleopatra.thompson",
        "code": "9574",
        "priority": 144,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 924,
        "description": "z1t6gc",
        "areaType": "uifh0y"
      }
    ],
    "roleIds": [
      865
    ],
    "positionIds": [
      "2rntzu"
    ],
    "roleId": 934,
    "userRoleList": [
      {
        "id": 789,
        "deptId": 370,
        "deptName": "cleopatra.thompson",
        "organId": "118",
        "organName": "cleopatra.thompson",
        "roleId": 496,
        "roleName": "cleopatra.thompson",
        "adminId": 132
      }
    ],
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:26",
    "lastTime": "2025-09-19 17:32:26",
    "id": 193,
    "userId": "118",
    "deptId": 530,
    "deptName": "cleopatra.thompson",
    "organId": "118",
    "organName": "cleopatra.thompson",
    "name": "cleopatra.thompson",
    "username": "cleopatra.thompson",
    "nickName": "maribeth.rutherford",
    "email": "sheree.stanton@gmail.com",
    "mobile": "828.254.1097",
    "imagePath": "0bk2q8",
    "password": "51iu6p",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 697,
    "delFlag": 0,
    "lastLoginIp": "142.83.169.77",
    "lastLoginTime": "2025-09-19 17:32:26",
    "description": "6w0i16",
    "dept": {
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:26",
      "lastTime": "2025-09-19 17:32:26",
      "id": 914,
      "organId": "118",
      "parentId": 471,
      "appId": "118",
      "depttypeId": 413,
      "foreignId": "118",
      "createType": 253,
      "type": "4s9ye0",
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "areaCode": "9574",
      "organLeader": "wwm6ff",
      "leaderId": "118",
      "leaderMobile": "828.254.1097",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "9574",
      "imagePath": "qi30z5",
      "priority": 508,
      "status": 55,
      "delFlag": 0,
      "description": "b9d9uf",
      "spare1": "jgcovv",
      "spare2": "0thrjy",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:26",
        "lastTime": "2025-09-19 17:32:26",
        "id": 336,
        "roletypeId": "118",
        "appId": "118",
        "name": "cleopatra.thompson",
        "code": "9574",
        "priority": 437,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 65,
        "description": "7bxc9h",
        "areaType": "ymyj69"
      }
    ],
    "roleIds": [
      382
    ],
    "positionIds": [
      "bax9mq"
    ],
    "roleId": 138,
    "userRoleList": [
      {
        "id": 998,
        "deptId": 661,
        "deptName": "cleopatra.thompson",
        "organId": "118",
        "organName": "cleopatra.thompson",
        "roleId": 633,
        "roleName": "cleopatra.thompson",
        "adminId": 432
      }
    ],
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
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
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "oldPassword": "2tahud",
    "newPassword": "3zz4lc"
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
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "imageUrl": "www.lezlie-kreiger.net"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/list.do?startTime=2025-09-19 17:31:32&remark=zy8rw0&orderBy=370&configKey=dfwly8&isDisabled=true&page=1&configValue=nyjk70&q=b4w9wb&endTime=2025-09-19 17:31:32&limit=10
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
    "totalCount": 896,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "configId": "118",
        "configKey": "c2i0y6",
        "configValue": "jz4ikv",
        "isDisabled": true,
        "remark": "4ppjvg"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/export.do --data 'remark=bss7vo&configValue=ftq0h8&isDisabled=true&page=1&startTime=2025-09-19 17:31:32&endTime=2025-09-19 17:31:32&q=k1f24u&configKey=iv1yuj&orderBy=345&limit=10'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "k5854w",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/118.do
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
    "configId": "118",
    "configKey": "pnu98m",
    "configValue": "vya4mf",
    "isDisabled": true,
    "remark": "yujirb"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/configKey/ok4zn0.do
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
    "configId": "118",
    "configKey": "ek9vxk",
    "configValue": "i63nws",
    "isDisabled": true,
    "remark": "6o3exc"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "configId": "118",
    "configKey": "mng2fv",
    "configValue": "ru5nfm",
    "isDisabled": true,
    "remark": "2tfy52"
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
  "data": "0weg4h",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "configId": "118",
    "configKey": "y4q3qu",
    "configValue": "dviyrg",
    "isDisabled": true,
    "remark": "g7zxvo"
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
  "data": "ekvye6",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "9748da",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "qfp78m",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/list.do?username=cleopatra.thompson&ipaddr=r235j4
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
      "tokenId": "118",
      "deptName": "cleopatra.thompson",
      "username": "cleopatra.thompson",
      "ipaddr": "1cw8ow",
      "loginLocation": "x2eq0h",
      "browser": "91dw6w",
      "os": "2zdzy1",
      "loginTime": 1758274292622
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/118.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "60zldr",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/list.do?q=3t2d7i&remark=xa823l&key=vo74ya&typeMode=40&startTime=2025-09-19 17:31:32&orderBy=576&name=cleopatra.thompson&page=1&typeClass=hiwbn9&status=bi296i&limit=10&endTime=2025-09-19 17:31:32&typeId=118
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
    "totalCount": 234,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "typeId": "118",
        "name": "cleopatra.thompson",
        "typeClass": "rsdx39",
        "typeRef": "a77vkf",
        "typeMode": 152,
        "searchCode": "9574",
        "priority": 828,
        "createTime": "2025-09-19 17:32:34",
        "status": 850,
        "remark": "484373"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/export.do --data 'q=cwhsel&typeMode=383&remark=xrn4we&startTime=2025-09-19 17:31:32&orderBy=752&key=xuf0zt&typeId=118&page=1&limit=10&status=fm852z&name=cleopatra.thompson&typeClass=02fbdy&endTime=2025-09-19 17:31:32'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "c5gqdo",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/118.do
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
    "typeId": "118",
    "name": "cleopatra.thompson",
    "typeClass": "nqfy4n",
    "typeRef": "jozgts",
    "typeMode": 516,
    "searchCode": "9574",
    "priority": 843,
    "createTime": "2025-09-19 17:32:34",
    "status": 550,
    "remark": "zsf14f"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "typeId": "118",
    "name": "cleopatra.thompson",
    "typeClass": "jbn1vw",
    "typeRef": "nbd58g",
    "typeMode": 673,
    "searchCode": "9574",
    "priority": 801,
    "createTime": "2025-09-19 17:32:34",
    "status": 680,
    "remark": "3ib75e"
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
  "data": "c8g9rr",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "typeId": "118",
    "name": "cleopatra.thompson",
    "typeClass": "o9agy9",
    "typeRef": "g1vml8",
    "typeMode": 53,
    "searchCode": "9574",
    "priority": 70,
    "createTime": "2025-09-19 17:32:34",
    "status": 665,
    "remark": "tz3q2h"
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
  "data": "vle73h",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "9d3tvu",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "u7opbv",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "typeId": "118",
      "name": "cleopatra.thompson",
      "typeClass": "lgj053",
      "typeRef": "ggc24v",
      "typeMode": 547,
      "searchCode": "9574",
      "priority": 527,
      "createTime": "2025-09-19 17:32:34",
      "status": 750,
      "remark": "8kzawm"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/list.do?name=cleopatra.thompson&postypeId=118&roletypeId=118&oname=cleopatra.thompson&positionId=118&officePhone=(716) 567-3660&orderBy=313&limit=10&parentId=118&isPub=true&sname=cleopatra.thompson&mobilePhone=(716) 567-3660&createTime=2025-09-19 17:31:32&posRank=489&status=8&posType=n4xidd&page=1&startTime=2025-09-19 17:31:32&id=118&code=9574&posFunction=0tm2zj&roleTypeId=118&groupId=118&endTime=2025-09-19 17:31:32&ids=znmn8u&ids=znmn8u&delFlag=0&description=hf9jsw&q=cznz1v
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
    "totalCount": 356,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "postId": "118",
        "postCode": "9574",
        "postName": "cleopatra.thompson",
        "postSort": 95,
        "status": 860,
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:29",
        "lastTime": "2025-09-19 17:32:29",
        "delFlag": 0,
        "remark": "e5hb06",
        "ids": [
          "pi7bkb"
        ],
        "positionId": "118",
        "flag": true
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/export.do --data 'postCode=9574&q=jzm4e2&postName=cleopatra.thompson&status=820&delFlag=0&startTime=2025-09-19 17:31:32&orderBy=196&page=1&limit=10&endTime=2025-09-19 17:31:32'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "jy8a76",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/118.do
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:29",
    "lastTime": "2025-09-19 17:32:29",
    "id": "118",
    "parentId": "118",
    "postypeId": "118",
    "roletypeId": "118",
    "userId": "118",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "code": "9574",
    "oname": "cleopatra.thompson",
    "posFunction": "8jw8dz",
    "posRank": 566,
    "posType": "314kuk",
    "editorType": "hndtb1",
    "isEditorCreate": true,
    "status": 997,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "118",
    "manageDeptids": "c9e68w",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "(716) 567-3660",
    "officePhone": "(716) 567-3660",
    "buildingId": "118",
    "roomNo": "npaj8z",
    "extQmType": "ew18m3",
    "extQmTypePhoto": "soxd50",
    "extPosName": "cleopatra.thompson",
    "extOrganName": "cleopatra.thompson",
    "priority": 14,
    "priorityInOrgan": 947,
    "priorityInDomain": 788,
    "updaterId": "118",
    "updateTime": "2025-09-19 17:32:29",
    "delFlag": 0,
    "description": "2sfs5l",
    "remark": "eexo41"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:29",
    "lastTime": "2025-09-19 17:32:29",
    "id": "118",
    "parentId": "118",
    "postypeId": "118",
    "roletypeId": "118",
    "userId": "118",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "code": "9574",
    "oname": "cleopatra.thompson",
    "posFunction": "srj4nc",
    "posRank": 633,
    "posType": "hau2a4",
    "editorType": "o4u902",
    "isEditorCreate": true,
    "status": 35,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "118",
    "manageDeptids": "pao5a1",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "(716) 567-3660",
    "officePhone": "(716) 567-3660",
    "buildingId": "118",
    "roomNo": "y4hxwc",
    "extQmType": "yt5cdn",
    "extQmTypePhoto": "ppdr4y",
    "extPosName": "cleopatra.thompson",
    "extOrganName": "cleopatra.thompson",
    "priority": 974,
    "priorityInOrgan": 639,
    "priorityInDomain": 265,
    "updaterId": "118",
    "updateTime": "2025-09-19 17:32:29",
    "delFlag": 0,
    "description": "c68l1v",
    "remark": "f7v0ed",
    "parentName": "cleopatra.thompson",
    "roletypeName": "cleopatra.thompson",
    "postypeName": "cleopatra.thompson"
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
  "data": "a79kwy",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:29",
    "lastTime": "2025-09-19 17:32:29",
    "id": "118",
    "parentId": "118",
    "postypeId": "118",
    "roletypeId": "118",
    "userId": "118",
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "code": "9574",
    "oname": "cleopatra.thompson",
    "posFunction": "599dm9",
    "posRank": 383,
    "posType": "afikm6",
    "editorType": "vb7b4c",
    "isEditorCreate": true,
    "status": 743,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "118",
    "manageDeptids": "70vc0c",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "(716) 567-3660",
    "officePhone": "(716) 567-3660",
    "buildingId": "118",
    "roomNo": "9bgact",
    "extQmType": "2eylcu",
    "extQmTypePhoto": "l1n5n3",
    "extPosName": "cleopatra.thompson",
    "extOrganName": "cleopatra.thompson",
    "priority": 647,
    "priorityInOrgan": 832,
    "priorityInDomain": 131,
    "updaterId": "118",
    "updateTime": "2025-09-19 17:32:29",
    "delFlag": 0,
    "description": "phwtji",
    "remark": "o2r9d1",
    "parentName": "cleopatra.thompson",
    "roletypeName": "cleopatra.thompson",
    "postypeName": "cleopatra.thompson"
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
  "data": "uwrluc",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "yq8e5w",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "postId": "118",
    "postCode": "9574",
    "postName": "cleopatra.thompson",
    "postSort": 170,
    "status": 840,
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:29",
    "lastTime": "2025-09-19 17:32:29",
    "delFlag": 0,
    "remark": "1ixvow",
    "ids": [
      "kp658j"
    ],
    "positionId": "118",
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
  "data": "hb95c0",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "id": 563,
    "roleId": 676,
    "positionId": "118",
    "status": 422,
    "beginTime": "2025-09-19",
    "endTime": "2025-09-19"
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
  "data": "7udll3",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "postId": "118",
      "postCode": "9574",
      "postName": "cleopatra.thompson",
      "postSort": 994,
      "status": 84,
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:29",
      "lastTime": "2025-09-19 17:32:29",
      "delFlag": 0,
      "remark": "tntz7i",
      "ids": [
        "q733ws"
      ],
      "positionId": "118",
      "flag": true
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/list.do?appId=118&operation=xrm8q3&endTime=2025-09-19 17:31:32&category=345&method=281u5z&createTime=2025-09-19 17:32:29&startTime=2025-09-19 17:31:32&ip=142.83.169.77&page=1&limit=10&userId=118&time=1758274292622&srcCode=775&username=cleopatra.thompson&q=xmvvbh&orderBy=888
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
    "totalCount": 881,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "operId": 344,
        "title": "j1i732",
        "businessType": 262,
        "businessTypeName": "cleopatra.thompson",
        "businessTypes": [
          176
        ],
        "method": "cqwtf2",
        "requestMethod": "22esrq",
        "operatorType": 142,
        "operName": "cleopatra.thompson",
        "deptName": "cleopatra.thompson",
        "operUrl": "www.lezlie-kreiger.net",
        "operIp": "142.83.169.77",
        "operLocation": "s2q714",
        "operParam": "19bepf",
        "jsonResult": "7th3uf",
        "status": 636,
        "errorMsg": "m8rpk3",
        "operTime": "2025-09-19 17:32:29",
        "costTime": 1758274292622,
        "remark": "d3ds6q"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/export.do --data 'orderBy=558&deptName=cleopatra.thompson&operatorType=517&endTime=2025-09-19 17:31:32&operId=937&page=1&operName=cleopatra.thompson&operIp=142.83.169.77&operTime=2025-09-19 17:32:29&startTime=2025-09-19 17:31:32&businessType=197&title=03phov&remark=eutkw2&status=387&q=ehar4q&limit=10'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "y1doi0",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "vqp14d",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/list.do?endTime=2025-09-19 17:31:32&status=e2wvmh&q=r2daov&dictSort=110&typeCode=9574&remark=bsybdk&searchCode=9574&parentId=890&cssClass=l8ztf7&orderBy=789&isDefault=hh2d8i&dictLabel=47x797&cddId=728&cddValue=cym6cn&limit=10&page=1&listClass=u22i26&key=63a43z&name=cleopatra.thompson&startTime=2025-09-19 17:31:32
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
    "totalCount": 332,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cddId": 916,
        "typeCode": "9574",
        "parentId": 772,
        "name": "cleopatra.thompson",
        "sname": "cleopatra.thompson",
        "cddValue": "m6b0by",
        "searchCode": "9574",
        "priority": 564,
        "createTime": "2025-09-19 17:32:33",
        "remark": "l368ph",
        "dictLabel": "hr9awr",
        "typeCodeName": "cleopatra.thompson",
        "parentName": "cleopatra.thompson"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/export.do --data 'q=46f130&cssClass=slxkvw&status=vgyyf6&limit=10&dictSort=486&orderBy=249&remark=3cpf42&key=7fjkqq&searchCode=9574&endTime=2025-09-19 17:31:32&isDefault=mb3z3z&typeCode=9574&name=cleopatra.thompson&parentId=822&startTime=2025-09-19 17:31:32&dictLabel=bnk4q8&listClass=xxhi72&cddId=462&page=1&cddValue=e2zozd'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "fnkvcn",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/290.do
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
    "cddId": 270,
    "typeCode": "9574",
    "parentId": 977,
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "cddValue": "wpfo0x",
    "searchCode": "9574",
    "priority": 863,
    "createTime": "2025-09-19 17:32:34",
    "remark": "gztchv",
    "dictLabel": "ospqc6",
    "typeCodeName": "cleopatra.thompson",
    "parentName": "cleopatra.thompson"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/type/zulbuu.do?roletypeId=118&typeCode=9574&parentId=118&zparentId=118
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "cddId": 23,
    "typeCode": "9574",
    "parentId": 276,
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "cddValue": "uigffz",
    "searchCode": "9574",
    "priority": 36,
    "createTime": "2025-09-19 17:32:34",
    "remark": "yzlfvp",
    "dictLabel": "dr30in",
    "typeCodeName": "cleopatra.thompson",
    "parentName": "cleopatra.thompson"
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
  "data": "danzx5",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "cddId": 137,
    "typeCode": "9574",
    "parentId": 122,
    "name": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "cddValue": "cyf25k",
    "searchCode": "9574",
    "priority": 568,
    "createTime": "2025-09-19 17:32:34",
    "remark": "0jiyrr",
    "dictLabel": "6fbf24",
    "typeCodeName": "cleopatra.thompson",
    "parentName": "cleopatra.thompson"
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
  "data": "6i4k1u",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "tlakgr",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/comm/tree.do?startTime=2025-09-19 17:31:32&positionType=66rms3&showButton=a3nyty&groupId=118&roleTypeId=118&wlType=zpe32b&refType=h7xa7o&orderBy=663&parentId=118&appId=118&gnType=o6q6ln&q=yrms24&type=pvdbzy&organwId=118&metaId=118&page=1&key=k18w9u&limit=10&roleId=118&roletypeId=118&endTime=2025-09-19 17:31:32&refresh=x89y18&status=0k1s1e&subType=9793gi&positionId=118
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
      "id": "118",
      "label": "0b5dag",
      "shortName": "cleopatra.thompson",
      "organId": "118",
      "areaId": 899,
      "searchCode": "9574",
      "childNum": 790,
      "checked": true,
      "entity": 657,
      "show": true,
      "showIcon": true,
      "parentId": "118",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/tree.do?typeCodes=b5je12&typeCodes=b5je12&ids=824gvg&ids=824gvg&orderBy=624&key=1wyzrf&cddLevel=ix8xfi&q=88o4yc&description=svesme&sname=cleopatra.thompson&typeMode=cmr2mb&delFlag=0&dispFlag=ch4y8m&limit=10&startTime=2025-09-19 17:31:32&endTime=2025-09-19 17:31:32&typeCode=9574&name=cleopatra.thompson&existKey=yfe5pv&parentId=964&cddValue=y98s24&page=1&searchCode=9574&isAllChild=uhzaxq
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:34",
      "lastTime": "2025-09-19 17:32:34",
      "id": 623,
      "typeCode": "9574",
      "parentId": 994,
      "name": "cleopatra.thompson",
      "sname": "cleopatra.thompson",
      "cddValue": "cvxrnw",
      "cddLevel": "2p93gb",
      "searchCode": "9574",
      "dispFlag": "76lj8b",
      "priority": 586,
      "delFlag": 0,
      "deleteTime": "2025-09-19 17:32:34",
      "description": "blxyqv",
      "spare1": "yalkfe",
      "spare2": "clnsa9",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "cpuNum": 767,
      "total": 91.24,
      "sys": 21.03,
      "used": 27.82,
      "wait": 76.69,
      "free": 76.08
    },
    "mem": {
      "total": 75.77,
      "used": 66.08,
      "free": 71.74
    },
    "jvm": {
      "total": 34.80,
      "max": 70.36,
      "free": 52.77,
      "version": "6.0.1",
      "home": "g50oo0"
    },
    "sys": {
      "computerName": "cleopatra.thompson",
      "computerIp": "142.83.169.77",
      "userDir": "pb84u4",
      "osName": "cleopatra.thompson",
      "osArch": "o5k8rj"
    },
    "sysFiles": [
      {
        "dirName": "cleopatra.thompson",
        "sysTypeName": "cleopatra.thompson",
        "typeName": "cleopatra.thompson",
        "total": "61lkzj",
        "free": "rvmh4f",
        "used": "7uo3f8",
        "usage": 23.53
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "username": "cleopatra.thompson",
    "password": "iq8nt3",
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d",
    "appId": "118"
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
  "data": "pgebl3",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "username": "cleopatra.thompson",
    "password": "zp2pag",
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d",
    "appId": "118"
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
    "adminId": 424,
    "token": "8s3tdd",
    "updateTime": "2025-09-19 17:32:26",
    "expireTime": "2025-09-19 17:32:26"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:26",
      "lastTime": "2025-09-19 17:32:26",
      "id": 272,
      "userId": "118",
      "deptId": 171,
      "deptName": "cleopatra.thompson",
      "organId": "118",
      "organName": "cleopatra.thompson",
      "name": "cleopatra.thompson",
      "username": "cleopatra.thompson",
      "nickName": "maribeth.rutherford",
      "email": "sheree.stanton@gmail.com",
      "mobile": "828.254.1097",
      "imagePath": "0opiib",
      "password": "t0m99f",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 80,
      "delFlag": 0,
      "lastLoginIp": "142.83.169.77",
      "lastLoginTime": "2025-09-19 17:32:26",
      "description": "x52q61",
      "dept": {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:26",
        "lastTime": "2025-09-19 17:32:26",
        "id": 543,
        "organId": "118",
        "parentId": 214,
        "appId": "118",
        "depttypeId": 486,
        "foreignId": "118",
        "createType": 776,
        "type": "pwupn8",
        "name": "cleopatra.thompson",
        "sname": "cleopatra.thompson",
        "areaCode": "9574",
        "organLeader": "ow956g",
        "leaderId": "118",
        "leaderMobile": "828.254.1097",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "9574",
        "imagePath": "at1phe",
        "priority": 894,
        "status": 923,
        "delFlag": 0,
        "description": "i1535k",
        "spare1": "3sgmse",
        "spare2": "bxwhv6",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "118",
          "createTime": "2025-09-19 17:32:26",
          "lastTime": "2025-09-19 17:32:26",
          "id": 173,
          "roletypeId": "118",
          "appId": "118",
          "name": "cleopatra.thompson",
          "code": "9574",
          "priority": 141,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 886,
          "description": "1g80wr",
          "areaType": "xypfyk"
        }
      ],
      "roleIds": [
        798
      ],
      "positionIds": [
        "hoyooq"
      ],
      "roleId": 704,
      "userRoleList": [
        {
          "id": 557,
          "deptId": 440,
          "deptName": "cleopatra.thompson",
          "organId": "118",
          "organName": "cleopatra.thompson",
          "roleId": 2,
          "roleName": "cleopatra.thompson",
          "adminId": 146
        }
      ],
      "code": "9574",
      "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
    },
    "roles": [
      "c35jst"
    ],
    "permissions": [
      "ynxxgk"
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "accountId": "118",
    "areaId": 13,
    "groupId": 690,
    "positionId": "118",
    "tplSolution": "0z6gax",
    "menuList": [
      {
        "id": 878,
        "parentId": 680,
        "name": "cleopatra.thompson",
        "ename": "cleopatra.thompson",
        "type": "g8dgcw",
        "perms": "57aml3",
        "menuLevel": 643,
        "urlType": "t09c0z",
        "url": "www.lezlie-kreiger.net",
        "menuSeq": "wkyxxr",
        "icon": "1amssr",
        "imagePath": "mz0tj3",
        "css": "tvu9es",
        "description": "cw2ezu",
        "todoTotalApi": "nqjq50"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "id": "118",
    "isAdmin": true,
    "isEncryt": true,
    "publicKey": "5obac4",
    "aesKey": "i20i2i",
    "clientId": "118",
    "serverUrl": "www.lezlie-kreiger.net",
    "serverConf1": "hx9nxq",
    "appConf": {
      "siteId": 283,
      "appId": "118",
      "topXzqhId": "118",
      "appConfJson": {
        "mapKey": "1kx73a"
      }
    },
    "isWork": true,
    "workConfig": {
      "layout": "e9286o",
      "siteInfo": {
        "id": 608,
        "appId": "118",
        "areaCode": "9574",
        "path": "o3vzft",
        "name": "cleopatra.thompson",
        "sname": "cleopatra.thompson",
        "layout": "opqstb",
        "logoUrl": "www.lezlie-kreiger.net",
        "cdnUrl": "www.lezlie-kreiger.net"
      }
    }
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "username": "cleopatra.thompson",
    "password": "pjlboo",
    "code": "9574",
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d",
    "appId": "118"
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
    "adminId": 614,
    "token": "ly7tee",
    "updateTime": "2025-09-19 17:32:26",
    "expireTime": "2025-09-19 17:32:26"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -i https://linlan.net/eframe_backend/captcha/verify.do?uuid=d082834c-f9da-4015-b3e4-8437c1e9c18d&code=9574
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "cr15rw",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "cacheName": "cleopatra.thompson",
      "cacheKey": "pngzer",
      "cacheValue": "ehcz13",
      "remark": "yji3np"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getKeys/cleopatra.thompson.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getValue/cleopatra.thompson/iz8mll.do
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
    "cacheName": "cleopatra.thompson",
    "cacheKey": "1sp3oj",
    "cacheValue": "6yhlm6",
    "remark": "on422z"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheName/cleopatra.thompson.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "6dktbx",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheKey/0znc41.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "vn9kvu",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "dfp65x",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/list.do?parentId=716&q=tkgm9z&currAppId=118&orderBy=320&startTime=2025-09-19 17:31:32&status=hv1don&limit=10&menuId=665&visible=ku7w6l&page=1&delFlag=yr9noq&endTime=2025-09-19 17:31:32&menuType=jno8xj&menuName=cleopatra.thompson
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
      "menuId": 353,
      "menuName": "cleopatra.thompson",
      "type": "qwiucm",
      "typeName": "cleopatra.thompson",
      "parentName": "cleopatra.thompson",
      "parentId": 155,
      "priority": 407,
      "path": "65fzwz",
      "component": "cupca6",
      "query": "c00h49",
      "routeName": "cleopatra.thompson",
      "isFrame": "4rtf9f",
      "isCache": "klrivy",
      "menuType": "467kp8",
      "menuTypeName": "cleopatra.thompson",
      "visible": "7cwluv",
      "status": "pfqk44",
      "perms": "000rcw",
      "icon": "6q4uyk",
      "imagePath": "xvzd38",
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:27",
      "lastTime": "2025-09-19 17:32:27",
      "children": [
        {
          "$ref": ".."
        }
      ],
      "childNum": 536,
      "description": "kzg4hj",
      "listJson": "704xhl",
      "delFlag": 0,
      "permsList": [
        {
          "permsName": "cleopatra.thompson",
          "permsStr": "ipq60x"
        }
      ],
      "buttonMenuList": [
        {
          "id": "118",
          "parentId": "118",
          "code": "9574",
          "name": "cleopatra.thompson"
        }
      ]
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/page.do?visible=ck6ihm&status=d03gp1&delFlag=9p7ezv&menuName=cleopatra.thompson&page=1&parentId=719&orderBy=776&menuType=wsmjeb&endTime=2025-09-19 17:31:32&q=4ybd59&startTime=2025-09-19 17:31:32&limit=10&currAppId=118&menuId=503
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
    "stackTrace": "055k08",
    "pageNum": 217,
    "pageSize": 10,
    "startRow": 3,
    "endRow": 229,
    "total": 329,
    "pages": 97,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "l7312p",
    "orderBy": "1k8fwn",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "gf4xjr",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/844.do
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
    "menuId": 526,
    "menuName": "cleopatra.thompson",
    "type": "qfhls2",
    "typeName": "cleopatra.thompson",
    "parentName": "cleopatra.thompson",
    "parentId": 865,
    "priority": 869,
    "path": "xxiy9x",
    "component": "ind39a",
    "query": "rq167c",
    "routeName": "cleopatra.thompson",
    "isFrame": "4qqrfw",
    "isCache": "1zct2r",
    "menuType": "6apt04",
    "menuTypeName": "cleopatra.thompson",
    "visible": "6si45d",
    "status": "4esy00",
    "perms": "1saymz",
    "icon": "0yu8o2",
    "imagePath": "iiedmy",
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:27",
    "lastTime": "2025-09-19 17:32:27",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 504,
    "description": "3ni4wg",
    "listJson": "ioxxi5",
    "delFlag": 0,
    "permsList": [
      {
        "permsName": "cleopatra.thompson",
        "permsStr": "wg3qa8"
      }
    ],
    "buttonMenuList": [
      {
        "id": "118",
        "parentId": "118",
        "code": "9574",
        "name": "cleopatra.thompson"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeselect.do?page=1&menuName=cleopatra.thompson&delFlag=ksbqsq&visible=p8py1j&orderBy=731&currAppId=118&startTime=2025-09-19 17:31:32&menuType=n5hgpo&q=vvjbpm&menuId=875&status=dq4c7l&limit=10&endTime=2025-09-19 17:31:32&parentId=321
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
      501
    ],
    "menus": [
      {
        "id": 598,
        "label": "qgwok6",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeInit.do?appIds=s9gl00&appIds=s9gl00&isCheck=true&parentNull=8exymm&startTime=2025-09-19 17:31:32&icon=abc1c8&imagePath=57fp0n&createTime=2025-09-19 17:31:32&description=r5fgsd&subCount=231&endTime=2025-09-19 17:31:32&page=1&isProtect=true&isDisplay=true&delFlag=0&appId=118&urlType=gkiclv&type=gl058i&typeNoButton=phyz8p&spare2=bqm86x&limit=10&offset=1&q=sjh03o&parentRoot=3e37jt&menuIds=cm21tw&menuIds=cm21tw&shortCut=4je39k&isDisabled=true&spare1=4akico&orderBy=826&parentId=347&popPosition=644&menuLevel=664&name=cleopatra.thompson&code=9574&url=www.lezlie-kreiger.net&isMenuAll=roem1e
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
      "title": "5haq7h",
      "id": "118",
      "parentId": "118",
      "extId": "118",
      "href": "6iyy28",
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
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/roleMenuTreeselect/187.do
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
      501
    ],
    "menus": [
      {
        "id": 517,
        "label": "o0egng",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "menuId": 309,
    "menuName": "cleopatra.thompson",
    "type": "a5o1wg",
    "typeName": "cleopatra.thompson",
    "parentName": "cleopatra.thompson",
    "parentId": 955,
    "priority": 521,
    "path": "69d7kb",
    "component": "gt55ni",
    "query": "nudrxg",
    "routeName": "cleopatra.thompson",
    "isFrame": "oeluam",
    "isCache": "2adunb",
    "menuType": "acew1s",
    "menuTypeName": "cleopatra.thompson",
    "visible": "1cvjjf",
    "status": "iv1iik",
    "perms": "rytytl",
    "icon": "8e7yer",
    "imagePath": "ws7v4n",
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:27",
    "lastTime": "2025-09-19 17:32:27",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 463,
    "description": "nlz3sw",
    "listJson": "py2yo0",
    "delFlag": 0,
    "permsList": [
      {
        "permsName": "cleopatra.thompson",
        "permsStr": "mtd9xu"
      }
    ],
    "buttonMenuList": [
      {
        "id": "118",
        "parentId": "118",
        "code": "9574",
        "name": "cleopatra.thompson"
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
  "data": "t6sotv",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "menuId": 480,
    "menuName": "cleopatra.thompson",
    "type": "dlet13",
    "typeName": "cleopatra.thompson",
    "parentName": "cleopatra.thompson",
    "parentId": 544,
    "priority": 874,
    "path": "3ps4kg",
    "component": "u14riv",
    "query": "rgm6yx",
    "routeName": "cleopatra.thompson",
    "isFrame": "6pw30r",
    "isCache": "rxudn0",
    "menuType": "4b1q5h",
    "menuTypeName": "cleopatra.thompson",
    "visible": "cmk2r7",
    "status": "wio401",
    "perms": "m0lrfi",
    "icon": "iyld3j",
    "imagePath": "vb360g",
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:27",
    "lastTime": "2025-09-19 17:32:27",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 642,
    "description": "1be0cu",
    "listJson": "7hfwzm",
    "delFlag": 0,
    "permsList": [
      {
        "permsName": "cleopatra.thompson",
        "permsStr": "5vlxi3"
      }
    ],
    "buttonMenuList": [
      {
        "id": "118",
        "parentId": "118",
        "code": "9574",
        "name": "cleopatra.thompson"
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
  "data": "55zogb",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "menuId": 604,
    "menuName": "cleopatra.thompson",
    "type": "tt1n24",
    "typeName": "cleopatra.thompson",
    "parentName": "cleopatra.thompson",
    "parentId": 642,
    "priority": 160,
    "path": "xnsl2a",
    "component": "lyu0re",
    "query": "6eopy7",
    "routeName": "cleopatra.thompson",
    "isFrame": "k45njf",
    "isCache": "56oq0c",
    "menuType": "kbqg3n",
    "menuTypeName": "cleopatra.thompson",
    "visible": "ruyfq6",
    "status": "9ljzg0",
    "perms": "mopwly",
    "icon": "qc87en",
    "imagePath": "1vqx6a",
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:27",
    "lastTime": "2025-09-19 17:32:27",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 26,
    "description": "3wect9",
    "listJson": "bn5i4t",
    "delFlag": 0,
    "permsList": [
      {
        "permsName": "cleopatra.thompson",
        "permsStr": "uzcoqv"
      }
    ],
    "buttonMenuList": [
      {
        "id": "118",
        "parentId": "118",
        "code": "9574",
        "name": "cleopatra.thompson"
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
  "data": "6twioy",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "menuId": 177,
    "menuName": "cleopatra.thompson",
    "type": "eruley",
    "typeName": "cleopatra.thompson",
    "parentName": "cleopatra.thompson",
    "parentId": 999,
    "priority": 104,
    "path": "pvs81y",
    "component": "6bph9c",
    "query": "wkhvly",
    "routeName": "cleopatra.thompson",
    "isFrame": "o4xtuo",
    "isCache": "46mijv",
    "menuType": "rcc590",
    "menuTypeName": "cleopatra.thompson",
    "visible": "92s62w",
    "status": "84okfq",
    "perms": "rfkts7",
    "icon": "lqm9ch",
    "imagePath": "0n8p75",
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:27",
    "lastTime": "2025-09-19 17:32:27",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 816,
    "description": "lxm68w",
    "listJson": "93cv9r",
    "delFlag": 0,
    "permsList": [
      {
        "permsName": "cleopatra.thompson",
        "permsStr": "8zz6l7"
      }
    ],
    "buttonMenuList": [
      {
        "id": "118",
        "parentId": "118",
        "code": "9574",
        "name": "cleopatra.thompson"
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
  "data": "kduw6q",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "wpjqnc",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:27",
    "lastTime": "2025-09-19 17:32:27",
    "id": 782,
    "parentId": 655,
    "appId": "118",
    "name": "cleopatra.thompson",
    "ename": "cleopatra.thompson",
    "sname": "cleopatra.thompson",
    "isProtect": true,
    "type": "0t77yw",
    "userId": "118",
    "code": "9574",
    "menuLevel": 207,
    "subCount": 340,
    "perms": "elikvi",
    "urlType": "t802fv",
    "url": "www.lezlie-kreiger.net",
    "icon": "0frdqx",
    "popPosition": 611,
    "imagePath": "st69i5",
    "css": "ih59pn",
    "jsEvent": "gq7g4u",
    "menuSeq": "5tornp",
    "shortCut": "3q6p5v",
    "isLeaf": true,
    "isDisplay": true,
    "isDisabled": true,
    "isCheck": true,
    "priority": 421,
    "delFlag": 0,
    "deleteTime": "2025-09-19 17:32:27",
    "description": "cpghmu",
    "spare1": "a03g8j",
    "spare2": "i2q1cj",
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
  "data": "8nzfuv",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/list.do?page=1&roleName=cleopatra.thompson&roleKey=93nzam&status=388&orderBy=183&roleId=890&endTime=2025-09-19 17:31:32&startTime=2025-09-19 17:31:32&limit=10&q=xyx6h6
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:27",
      "lastTime": "2025-09-19 17:32:27",
      "roleId": 408,
      "roleName": "cleopatra.thompson",
      "roleKey": "j0x5pd",
      "roleSort": 418,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 660,
      "flag": true,
      "menuIds": [
        776
      ],
      "deptIds": [
        572
      ],
      "permissions": [
        "1jg518"
      ],
      "remark": "3z9mf4",
      "parentName": "cleopatra.thompson",
      "appName": "cleopatra.thompson",
      "roletypeId": "118",
      "roletypeName": "cleopatra.thompson",
      "priority": 856,
      "isSuper": true
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/export.do --data 'roleName=cleopatra.thompson&roleId=85&status=91&q=8zargd&startTime=2025-09-19 17:31:32&limit=10&page=1&orderBy=512&roleKey=z9m2n6&endTime=2025-09-19 17:31:32'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "8tafkc",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/726.do
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:27",
    "lastTime": "2025-09-19 17:32:27",
    "roleId": 924,
    "roleName": "cleopatra.thompson",
    "roleKey": "1q92p1",
    "roleSort": 965,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 449,
    "flag": true,
    "menuIds": [
      701
    ],
    "deptIds": [
      718
    ],
    "permissions": [
      "0qc10v"
    ],
    "remark": "6nju6z",
    "parentName": "cleopatra.thompson",
    "appName": "cleopatra.thompson",
    "roletypeId": "118",
    "roletypeName": "cleopatra.thompson",
    "priority": 180,
    "isSuper": true
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:27",
    "lastTime": "2025-09-19 17:32:27",
    "roleId": 841,
    "roleName": "cleopatra.thompson",
    "roleKey": "807bvm",
    "roleSort": 821,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 446,
    "flag": true,
    "menuIds": [
      562
    ],
    "deptIds": [
      150
    ],
    "permissions": [
      "hq2wqp"
    ],
    "remark": "mi1ul4",
    "parentName": "cleopatra.thompson",
    "appName": "cleopatra.thompson",
    "roletypeId": "118",
    "roletypeName": "cleopatra.thompson",
    "priority": 762,
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
  "data": "b9l46w",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:27",
    "lastTime": "2025-09-19 17:32:27",
    "roleId": 511,
    "roleName": "cleopatra.thompson",
    "roleKey": "61lpdh",
    "roleSort": 25,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 905,
    "flag": true,
    "menuIds": [
      145
    ],
    "deptIds": [
      797
    ],
    "permissions": [
      "3dcesq"
    ],
    "remark": "rnnnth",
    "parentName": "cleopatra.thompson",
    "appName": "cleopatra.thompson",
    "roletypeId": "118",
    "roletypeName": "cleopatra.thompson",
    "priority": 391,
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
  "data": "4fd6q0",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:28",
    "lastTime": "2025-09-19 17:32:28",
    "roleId": 76,
    "roleName": "cleopatra.thompson",
    "roleKey": "jwbuos",
    "roleSort": 67,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 75,
    "flag": true,
    "menuIds": [
      105
    ],
    "deptIds": [
      69
    ],
    "permissions": [
      "o44yui"
    ],
    "remark": "401zg3",
    "parentName": "cleopatra.thompson",
    "appName": "cleopatra.thompson",
    "roletypeId": "118",
    "roletypeName": "cleopatra.thompson",
    "priority": 914,
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
  "data": "3jirb3",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:28",
    "lastTime": "2025-09-19 17:32:28",
    "roleId": 685,
    "roleName": "cleopatra.thompson",
    "roleKey": "clzd1s",
    "roleSort": 246,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 482,
    "flag": true,
    "menuIds": [
      379
    ],
    "deptIds": [
      541
    ],
    "permissions": [
      "jhp972"
    ],
    "remark": "s141ic",
    "parentName": "cleopatra.thompson",
    "appName": "cleopatra.thompson",
    "roletypeId": "118",
    "roletypeName": "cleopatra.thompson",
    "priority": 859,
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
  "data": "kzqv5c",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "8ccznd",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:28",
    "lastTime": "2025-09-19 17:32:28",
    "id": 756,
    "roletypeId": "118",
    "appId": "118",
    "name": "cleopatra.thompson",
    "code": "9574",
    "priority": 954,
    "isRegular": true,
    "isSuper": true,
    "isPublic": true,
    "status": 379,
    "description": "el486i",
    "areaType": "ez3h4j"
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
  "data": "z9343a",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:28",
    "lastTime": "2025-09-19 17:32:28",
    "roleId": 712,
    "roleName": "cleopatra.thompson",
    "roleKey": "iou3b8",
    "roleSort": 222,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 536,
    "flag": true,
    "menuIds": [
      383
    ],
    "deptIds": [
      258
    ],
    "permissions": [
      "o222rd"
    ],
    "remark": "oxq80b",
    "parentName": "cleopatra.thompson",
    "appName": "cleopatra.thompson",
    "roletypeId": "118",
    "roletypeName": "cleopatra.thompson",
    "priority": 101,
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
  "data": "xs3cmz",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "creatorId": "118",
    "createTime": "2025-09-19 17:32:28",
    "lastTime": "2025-09-19 17:32:28",
    "roleId": 180,
    "roleName": "cleopatra.thompson",
    "roleKey": "qzyqda",
    "roleSort": 835,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 316,
    "flag": true,
    "menuIds": [
      115
    ],
    "deptIds": [
      740
    ],
    "permissions": [
      "ir87nm"
    ],
    "remark": "2ez5ve",
    "parentName": "cleopatra.thompson",
    "appName": "cleopatra.thompson",
    "roletypeId": "118",
    "roletypeName": "cleopatra.thompson",
    "priority": 729,
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
  "data": "brnu32",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:28",
      "lastTime": "2025-09-19 17:32:28",
      "roleId": 381,
      "roleName": "cleopatra.thompson",
      "roleKey": "klgciv",
      "roleSort": 152,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 117,
      "flag": true,
      "menuIds": [
        889
      ],
      "deptIds": [
        799
      ],
      "permissions": [
        "9icvbe"
      ],
      "remark": "gt1bpv",
      "parentName": "cleopatra.thompson",
      "appName": "cleopatra.thompson",
      "roletypeId": "118",
      "roletypeName": "cleopatra.thompson",
      "priority": 606,
      "isSuper": true
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/allocatedList.do?organId=118&deptId=790&endTime=2025-09-19 17:31:32&userId=118&adminId=627&q=hzg7or&startTime=2025-09-19 17:31:32&nickName=maribeth.rutherford&status=vgrr62&limit=10&email=sheree.stanton@gmail.com&username=cleopatra.thompson&page=1&mobile=828.254.1097&orderBy=189&delFlag=0
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:28",
      "lastTime": "2025-09-19 17:32:28",
      "id": 589,
      "userId": "118",
      "deptId": 173,
      "deptName": "cleopatra.thompson",
      "organId": "118",
      "organName": "cleopatra.thompson",
      "name": "cleopatra.thompson",
      "username": "cleopatra.thompson",
      "nickName": "maribeth.rutherford",
      "email": "sheree.stanton@gmail.com",
      "mobile": "828.254.1097",
      "imagePath": "o88x9z",
      "password": "o6vozw",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 362,
      "delFlag": 0,
      "lastLoginIp": "142.83.169.77",
      "lastLoginTime": "2025-09-19 17:32:28",
      "description": "iomw7a",
      "dept": {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:28",
        "lastTime": "2025-09-19 17:32:28",
        "id": 776,
        "organId": "118",
        "parentId": 398,
        "appId": "118",
        "depttypeId": 234,
        "foreignId": "118",
        "createType": 713,
        "type": "pfy3rg",
        "name": "cleopatra.thompson",
        "sname": "cleopatra.thompson",
        "areaCode": "9574",
        "organLeader": "04vovh",
        "leaderId": "118",
        "leaderMobile": "828.254.1097",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "9574",
        "imagePath": "ijk6jm",
        "priority": 964,
        "status": 785,
        "delFlag": 0,
        "description": "0w01ot",
        "spare1": "bmg9xc",
        "spare2": "w65ini",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "118",
          "createTime": "2025-09-19 17:32:28",
          "lastTime": "2025-09-19 17:32:28",
          "id": 121,
          "roletypeId": "118",
          "appId": "118",
          "name": "cleopatra.thompson",
          "code": "9574",
          "priority": 564,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 370,
          "description": "n5rl83",
          "areaType": "365oh6"
        }
      ],
      "roleIds": [
        42
      ],
      "positionIds": [
        "6ip48x"
      ],
      "roleId": 335,
      "userRoleList": [
        {
          "id": 341,
          "deptId": 258,
          "deptName": "cleopatra.thompson",
          "organId": "118",
          "organName": "cleopatra.thompson",
          "roleId": 911,
          "roleName": "cleopatra.thompson",
          "adminId": 698
        }
      ],
      "code": "9574",
      "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/unallocatedList.do?email=sheree.stanton@gmail.com&username=cleopatra.thompson&mobile=828.254.1097&nickName=maribeth.rutherford&orderBy=892&startTime=2025-09-19 17:31:32&endTime=2025-09-19 17:31:32&limit=10&adminId=488&userId=118&q=6f72ue&organId=118&status=vj4fob&delFlag=0&page=1&deptId=538
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
      "creatorId": "118",
      "createTime": "2025-09-19 17:32:28",
      "lastTime": "2025-09-19 17:32:28",
      "id": 936,
      "userId": "118",
      "deptId": 949,
      "deptName": "cleopatra.thompson",
      "organId": "118",
      "organName": "cleopatra.thompson",
      "name": "cleopatra.thompson",
      "username": "cleopatra.thompson",
      "nickName": "maribeth.rutherford",
      "email": "sheree.stanton@gmail.com",
      "mobile": "828.254.1097",
      "imagePath": "g33wee",
      "password": "a638b5",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 927,
      "delFlag": 0,
      "lastLoginIp": "142.83.169.77",
      "lastLoginTime": "2025-09-19 17:32:28",
      "description": "y8bs3a",
      "dept": {
        "creatorId": "118",
        "createTime": "2025-09-19 17:32:28",
        "lastTime": "2025-09-19 17:32:28",
        "id": 701,
        "organId": "118",
        "parentId": 946,
        "appId": "118",
        "depttypeId": 571,
        "foreignId": "118",
        "createType": 354,
        "type": "uatntk",
        "name": "cleopatra.thompson",
        "sname": "cleopatra.thompson",
        "areaCode": "9574",
        "organLeader": "syxx44",
        "leaderId": "118",
        "leaderMobile": "828.254.1097",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "9574",
        "imagePath": "1o00u0",
        "priority": 518,
        "status": 824,
        "delFlag": 0,
        "description": "www2gw",
        "spare1": "75aog0",
        "spare2": "irimwu",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "118",
          "createTime": "2025-09-19 17:32:28",
          "lastTime": "2025-09-19 17:32:28",
          "id": 208,
          "roletypeId": "118",
          "appId": "118",
          "name": "cleopatra.thompson",
          "code": "9574",
          "priority": 525,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 771,
          "description": "b1bx3g",
          "areaType": "t7qc88"
        }
      ],
      "roleIds": [
        92
      ],
      "positionIds": [
        "ms05ya"
      ],
      "roleId": 180,
      "userRoleList": [
        {
          "id": 338,
          "deptId": 520,
          "deptName": "cleopatra.thompson",
          "organId": "118",
          "organName": "cleopatra.thompson",
          "roleId": 828,
          "roleName": "cleopatra.thompson",
          "adminId": 373
        }
      ],
      "code": "9574",
      "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "id": 434,
    "roleId": 474,
    "adminId": 456
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
  "data": "ma9tee",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X PUT -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/cancelAll.do --data 'roleId=987&adminIds=cnuzfl&adminIds=cnuzfl'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ditfi7",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X PUT -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/selectAll.do --data 'adminIds=b3davr&adminIds=b3davr&roleId=64'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "xayeng",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/deptTree/24.do
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
      954
    ],
    "depts": [
      {
        "id": 758,
        "label": "3mkhr1",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/list.do?endTime=2025-09-19 17:31:32&page=1&limit=10&cfgValue=rxasi2&ids=yn9x8z&ids=yn9x8z&q=10t4e2&startTime=2025-09-19 17:31:32&cfgKey=y9ccan&orderBy=106
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
    "totalCount": 726,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cfgKey": "g4howi",
        "cfgValue": "z5w14s"
      }
    ]
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/export.do --data 'endTime=2025-09-19 17:31:32&cfgValue=g6k860&startTime=2025-09-19 17:31:32&q=3628jm&orderBy=623&limit=10&cfgKey=3qfd04&ids=zo2jou&ids=zo2jou&page=1'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "7kly4c",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/gebepm.do
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
    "cfgKey": "zekihd",
    "cfgValue": "1wyj4y"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "cfgKey": "8hyaul",
    "cfgValue": "9yo4or"
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
  "data": "2elimr",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "cfgKey": "75u2fa",
    "cfgValue": "24on5m"
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
  "data": "avno0x",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "ldr6qd",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "qaf471",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
  "data": "pjp9hq",
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/application.do?q=ltjs20&limit=10&orderBy=336&page=1&endTime=2025-09-19 17:31:32&startTime=2025-09-19 17:31:32
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
      "organNum": "7644lx",
      "deptNum": "xie4nq",
      "peopleNum": "tzczpe",
      "roleNum": "ree2zm",
      "dicTypeNum": "tcmx7a",
      "appNum": "j97kf3",
      "fileNum": "gbe77a",
      "paramNum": "aajh4u"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/element.do?endTime=2025-09-19 17:31:32&orderBy=359&startTime=2025-09-19 17:31:32&limit=10&page=1&q=igfbgt
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
      "objectNum": "zdoyng",
      "modelNum": "kk2syi"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/manage.do?page=1&orderBy=545&endTime=2025-09-19 17:31:32&limit=10&q=ttuyxi&startTime=2025-09-19 17:31:32
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
      "siteNum": "zj6s66",
      "accountNum": "xaoxsw",
      "serviceOrganNum": "of04fk"
    }
  ],
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d",
    "img": "4otnic",
    "code": "9574"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
    "uuid": "d082834c-f9da-4015-b3e4-8437c1e9c18d",
    "img": "655bsg",
    "code": "9574"
  },
  "requestId": "118",
  "timestamp": "2025-09-19 17:31:32"
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
