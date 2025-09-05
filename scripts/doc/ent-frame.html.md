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
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:49",
    "lastTime": "2025-09-05 15:45:49",
    "id": 809,
    "organId": "12",
    "parentId": 834,
    "appId": "12",
    "depttypeId": 313,
    "foreignId": "12",
    "createType": 306,
    "type": "hhp401",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "areaCode": "17639",
    "organLeader": "jzkc8a",
    "leaderId": "12",
    "leaderMobile": "(682) 505-7451",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "17639",
    "imagePath": "ln8blx",
    "priority": 671,
    "status": 851,
    "delFlag": 3,
    "description": "ivmcbz",
    "spare1": "9otkmq",
    "spare2": "6x5vyf",
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
  "data": "ov2skz",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:49",
    "lastTime": "2025-09-05 15:45:49",
    "id": 326,
    "organId": "12",
    "parentId": 833,
    "appId": "12",
    "depttypeId": 356,
    "foreignId": "12",
    "createType": 401,
    "type": "17wpab",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "areaCode": "17639",
    "organLeader": "5869gv",
    "leaderId": "12",
    "leaderMobile": "(682) 505-7451",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "17639",
    "imagePath": "vu044s",
    "priority": 599,
    "status": 372,
    "delFlag": 3,
    "description": "j9qf9o",
    "spare1": "wdz7m1",
    "spare2": "gze89w",
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
  "data": "0s4wr7",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "qxy7tc",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:49",
    "lastTime": "2025-09-05 15:45:49",
    "id": 228,
    "organId": "12",
    "parentId": 629,
    "appId": "12",
    "depttypeId": 107,
    "foreignId": "12",
    "createType": 379,
    "type": "vsudj9",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "areaCode": "17639",
    "organLeader": "ame3m9",
    "leaderId": "12",
    "leaderMobile": "(682) 505-7451",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "17639",
    "imagePath": "j127qj",
    "priority": 845,
    "status": 915,
    "delFlag": 3,
    "description": "f513jt",
    "spare1": "d78cnh",
    "spare2": "su5gvk",
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
  "data": "xk0k8h",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list.do?createType=501&organLeader=raaxny&leaderId=12&searchCode=17639&organId=12&depttypeId=79&isVirtual=true&delFlag=3&isDisabled=true&deptId=949&name=deloris.schneider&endTime=2025-09-05 15:44:42&sname=deloris.schneider&isOrganLevel=true&q=ok26sc&foreignId=12&spare1=wur63f&limit=10&startTime=2025-09-05 15:44:42&imagePath=aninyr&leaderMobile=(682) 505-7451&description=d5e7pu&status=559&creatorId=12&page=1&parentId=824&appId=12&isLeaf=true&areaCode=17639&orderBy=862&type=udq8gy&spare2=cqmvof
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
    "stackTrace": "gdgeyh",
    "pageNum": 683,
    "pageSize": 10,
    "startRow": 289,
    "endRow": 77,
    "total": 775,
    "pages": 325,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "j084p4",
    "orderBy": "64w3ln",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "h5vpem",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/page.do?parentId=363&isLeaf=true&delFlag=3&foreignId=12&depttypeId=774&areaCode=17639&organLeader=m7972p&sname=deloris.schneider&creatorId=12&spare2=39h74x&endTime=2025-09-05 15:44:42&appId=12&leaderMobile=(682) 505-7451&searchCode=17639&description=8nf34o&spare1=ahxpws&deptId=290&type=r9lunj&organId=12&limit=10&leaderId=12&q=h7uyz9&orderBy=906&isVirtual=true&page=1&startTime=2025-09-05 15:44:42&createType=481&isOrganLevel=true&isDisabled=true&imagePath=md269g&status=708&name=deloris.schneider
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
    "stackTrace": "6ldwbt",
    "pageNum": 627,
    "pageSize": 10,
    "startRow": 94,
    "endRow": 20,
    "total": 259,
    "pages": 966,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "guc1cr",
    "orderBy": "riq52b",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "fcwq9p",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list/exclude/466.do
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
      "id": 922,
      "organId": "12",
      "organName": "deloris.schneider",
      "parentId": 878,
      "appId": "12",
      "depttypeId": 501,
      "foreignId": "12",
      "createType": 84,
      "type": "uejz82",
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "areaCode": "17639",
      "organLeader": "cpq7y8",
      "leaderId": "12",
      "leaderMobile": "(682) 505-7451",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "17639",
      "imagePath": "dzi64x",
      "priority": 415,
      "status": 777,
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:49",
      "lastTime": "2025-09-05 15:45:49",
      "delFlag": 3,
      "description": "b74mcm",
      "spare1": "yx34io",
      "spare2": "3i5bnw",
      "parentName": "deloris.schneider",
      "childNum": "02sjnv"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/426.do
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
    "id": 373,
    "organId": "12",
    "organName": "deloris.schneider",
    "parentId": 215,
    "appId": "12",
    "depttypeId": 844,
    "foreignId": "12",
    "createType": 81,
    "type": "c7cfo3",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "areaCode": "17639",
    "organLeader": "uc6hhh",
    "leaderId": "12",
    "leaderMobile": "(682) 505-7451",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "17639",
    "imagePath": "ndbh71",
    "priority": 328,
    "status": 804,
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:49",
    "lastTime": "2025-09-05 15:45:49",
    "delFlag": 3,
    "description": "lie0zl",
    "spare1": "wocwfe",
    "spare2": "6bgfod",
    "parentName": "deloris.schneider",
    "childNum": "6380lo"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/tree.do?imagePath=w9p6bh&page=1&orderBy=787&isOrganLevel=true&appId=12&parentId=817&searchCode=17639&depttypeId=133&sname=deloris.schneider&limit=10&areaCode=17639&organId=12&deptId=139&status=815&spare1=79vmwd&creatorId=12&organLeader=wuyu2e&q=7vnflp&name=deloris.schneider&leaderId=12&leaderMobile=(682) 505-7451&isVirtual=true&isLeaf=true&createType=475&isDisabled=true&delFlag=3&type=w4lq3p&description=1kkz8q&spare2=ctfnt2&endTime=2025-09-05 15:44:42&startTime=2025-09-05 15:44:42&foreignId=12
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
      "title": "8yipll",
      "id": "12",
      "parentId": "12",
      "extId": "12",
      "href": "f13nbn",
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
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/list.do?msg=m5jf5o&ipaddr=lwhgwe&limit=10&infoId=150&page=1&status=wvxtg7&browser=o0pmji&username=deloris.schneider&os=qqlhb5&loginTime=2025-09-05 15:45:54&q=1z3ojx&endTime=2025-09-05 15:44:42&startTime=2025-09-05 15:44:42&orderBy=772
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
    "totalCount": 585,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "infoId": 132,
        "username": "deloris.schneider",
        "status": "120cc4",
        "ipaddr": "rbyweg",
        "loginLocation": "u50hvw",
        "browser": "olhdxt",
        "os": "1wcw50",
        "msg": "ic7a4k",
        "loginTime": "2025-09-05 15:45:54",
        "remark": "gbhrpr"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/export.do --data 'ipaddr=x6q4lj&username=deloris.schneider&browser=urch5m&msg=ix7i8o&startTime=2025-09-05 15:44:42&page=1&limit=10&endTime=2025-09-05 15:44:42&orderBy=980&infoId=132&status=al8bwh&loginTime=2025-09-05 15:45:54&q=mprvbr&os=po6uve'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "u274cd",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "vyktej",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "q1ogkq",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/unlock/deloris.schneider.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "wdpokp",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:50",
    "lastTime": "2025-09-05 15:45:50",
    "id": 152,
    "userId": "12",
    "deptId": 119,
    "deptName": "deloris.schneider",
    "organId": "12",
    "organName": "deloris.schneider",
    "name": "deloris.schneider",
    "username": "deloris.schneider",
    "nickName": "lon.nicolas",
    "email": "ralph.kerluke@hotmail.com",
    "mobile": "(682) 505-7451",
    "imagePath": "ucjo75",
    "password": "gkkc5h",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 718,
    "delFlag": 3,
    "lastLoginIp": "188.87.89.33",
    "lastLoginTime": "2025-09-05 15:45:50",
    "description": "fs6nfv",
    "dept": {
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:50",
      "lastTime": "2025-09-05 15:45:50",
      "id": 349,
      "organId": "12",
      "parentId": 442,
      "appId": "12",
      "depttypeId": 310,
      "foreignId": "12",
      "createType": 988,
      "type": "sy3irq",
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "areaCode": "17639",
      "organLeader": "n9unga",
      "leaderId": "12",
      "leaderMobile": "(682) 505-7451",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "17639",
      "imagePath": "vl9mw4",
      "priority": 858,
      "status": 319,
      "delFlag": 3,
      "description": "vtonbr",
      "spare1": "i2uo6k",
      "spare2": "7f9vcm",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:50",
        "lastTime": "2025-09-05 15:45:50",
        "id": 794,
        "roletypeId": "12",
        "appId": "12",
        "name": "deloris.schneider",
        "code": "17639",
        "priority": 871,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 855,
        "description": "kw0q4c",
        "areaType": "icua94"
      }
    ],
    "roleIds": [
      702
    ],
    "positionIds": [
      "uihipm"
    ],
    "roleId": 402,
    "userRoleList": [
      {
        "id": 25,
        "deptId": 530,
        "deptName": "deloris.schneider",
        "organId": "12",
        "organName": "deloris.schneider",
        "roleId": 630,
        "roleName": "deloris.schneider",
        "adminId": 635
      }
    ],
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
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
  "data": "3ue2fk",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:50",
    "lastTime": "2025-09-05 15:45:50",
    "id": 73,
    "userId": "12",
    "deptId": 155,
    "deptName": "deloris.schneider",
    "organId": "12",
    "organName": "deloris.schneider",
    "name": "deloris.schneider",
    "username": "deloris.schneider",
    "nickName": "lon.nicolas",
    "email": "ralph.kerluke@hotmail.com",
    "mobile": "(682) 505-7451",
    "imagePath": "29w45k",
    "password": "us637t",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 356,
    "delFlag": 3,
    "lastLoginIp": "188.87.89.33",
    "lastLoginTime": "2025-09-05 15:45:50",
    "description": "6cit0g",
    "dept": {
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:50",
      "lastTime": "2025-09-05 15:45:50",
      "id": 767,
      "organId": "12",
      "parentId": 247,
      "appId": "12",
      "depttypeId": 314,
      "foreignId": "12",
      "createType": 781,
      "type": "nvr586",
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "areaCode": "17639",
      "organLeader": "wxvi4w",
      "leaderId": "12",
      "leaderMobile": "(682) 505-7451",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "17639",
      "imagePath": "3pbjok",
      "priority": 811,
      "status": 72,
      "delFlag": 3,
      "description": "9hyros",
      "spare1": "fn945s",
      "spare2": "cc1xxj",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:50",
        "lastTime": "2025-09-05 15:45:50",
        "id": 169,
        "roletypeId": "12",
        "appId": "12",
        "name": "deloris.schneider",
        "code": "17639",
        "priority": 860,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 16,
        "description": "557wk4",
        "areaType": "g0c14p"
      }
    ],
    "roleIds": [
      665
    ],
    "positionIds": [
      "1gih3f"
    ],
    "roleId": 627,
    "userRoleList": [
      {
        "id": 665,
        "deptId": 237,
        "deptName": "deloris.schneider",
        "organId": "12",
        "organName": "deloris.schneider",
        "roleId": 245,
        "roleName": "deloris.schneider",
        "adminId": 694
      }
    ],
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
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
  "data": "z04s51",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:50",
    "lastTime": "2025-09-05 15:45:50",
    "id": 995,
    "userId": "12",
    "organId": "12",
    "deptId": 609,
    "createType": 83,
    "name": "deloris.schneider",
    "username": "deloris.schneider",
    "mobile": "(682) 505-7451",
    "email": "ralph.kerluke@hotmail.com",
    "password": "4l3m4d",
    "salt": "2b3xox",
    "imagePath": "p621r3",
    "adminType": "a80ihn",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "adminRange": "d82m1v",
    "adminPerms": "ipilj2",
    "lastAppId": "12",
    "lastLoginTime": "2025-09-05 15:45:50",
    "lastLoginIp": "188.87.89.33",
    "loginCount": 881,
    "status": 231,
    "delFlag": 3,
    "spare1": "36ryx4",
    "spare2": "r4lfkn",
    "roleIds": [
      263
    ],
    "positionIds": [
      "5w2odb"
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
  "data": "7zdumo",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:50",
    "lastTime": "2025-09-05 15:45:50",
    "id": 503,
    "userId": "12",
    "deptId": 783,
    "deptName": "deloris.schneider",
    "organId": "12",
    "organName": "deloris.schneider",
    "name": "deloris.schneider",
    "username": "deloris.schneider",
    "nickName": "lon.nicolas",
    "email": "ralph.kerluke@hotmail.com",
    "mobile": "(682) 505-7451",
    "imagePath": "apm1cy",
    "password": "jlpgob",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 547,
    "delFlag": 3,
    "lastLoginIp": "188.87.89.33",
    "lastLoginTime": "2025-09-05 15:45:50",
    "description": "buci4z",
    "dept": {
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:50",
      "lastTime": "2025-09-05 15:45:50",
      "id": 53,
      "organId": "12",
      "parentId": 936,
      "appId": "12",
      "depttypeId": 77,
      "foreignId": "12",
      "createType": 172,
      "type": "t1y5po",
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "areaCode": "17639",
      "organLeader": "lvukcm",
      "leaderId": "12",
      "leaderMobile": "(682) 505-7451",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "17639",
      "imagePath": "w1o1o7",
      "priority": 744,
      "status": 298,
      "delFlag": 3,
      "description": "t6p54y",
      "spare1": "zfr1bi",
      "spare2": "6ha1ao",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:50",
        "lastTime": "2025-09-05 15:45:50",
        "id": 707,
        "roletypeId": "12",
        "appId": "12",
        "name": "deloris.schneider",
        "code": "17639",
        "priority": 366,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 805,
        "description": "vbuifg",
        "areaType": "856e1z"
      }
    ],
    "roleIds": [
      587
    ],
    "positionIds": [
      "n1jxw5"
    ],
    "roleId": 278,
    "userRoleList": [
      {
        "id": 214,
        "deptId": 211,
        "deptName": "deloris.schneider",
        "organId": "12",
        "organName": "deloris.schneider",
        "roleId": 298,
        "roleName": "deloris.schneider",
        "adminId": 948
      }
    ],
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
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
  "data": "l5vj36",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "gb1bcn",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/export.do --data 'endTime=2025-09-05 15:44:42&deptId=538&organId=12&limit=10&q=8v4mxa&delFlag=3&page=1&status=x7lk7g&email=ralph.kerluke@hotmail.com&mobile=(682) 505-7451&startTime=2025-09-05 15:44:42&nickName=lon.nicolas&username=deloris.schneider&adminId=927&orderBy=102&userId=12'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ue5ywo",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "cxvcf1",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "t5sf69",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:50",
    "lastTime": "2025-09-05 15:45:50",
    "id": 405,
    "userId": "12",
    "deptId": 346,
    "deptName": "deloris.schneider",
    "organId": "12",
    "organName": "deloris.schneider",
    "name": "deloris.schneider",
    "username": "deloris.schneider",
    "nickName": "lon.nicolas",
    "email": "ralph.kerluke@hotmail.com",
    "mobile": "(682) 505-7451",
    "imagePath": "ev4loq",
    "password": "55a0kz",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 455,
    "delFlag": 3,
    "lastLoginIp": "188.87.89.33",
    "lastLoginTime": "2025-09-05 15:45:50",
    "description": "hg9pnp",
    "dept": {
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:50",
      "lastTime": "2025-09-05 15:45:50",
      "id": 533,
      "organId": "12",
      "parentId": 462,
      "appId": "12",
      "depttypeId": 203,
      "foreignId": "12",
      "createType": 467,
      "type": "476hvz",
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "areaCode": "17639",
      "organLeader": "zi0pus",
      "leaderId": "12",
      "leaderMobile": "(682) 505-7451",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "17639",
      "imagePath": "dzo1wx",
      "priority": 372,
      "status": 145,
      "delFlag": 3,
      "description": "6coqwq",
      "spare1": "h9mgrl",
      "spare2": "eqy9wj",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:50",
        "lastTime": "2025-09-05 15:45:50",
        "id": 107,
        "roletypeId": "12",
        "appId": "12",
        "name": "deloris.schneider",
        "code": "17639",
        "priority": 251,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 406,
        "description": "tnh0og",
        "areaType": "d9o9r5"
      }
    ],
    "roleIds": [
      96
    ],
    "positionIds": [
      "yv34r7"
    ],
    "roleId": 384,
    "userRoleList": [
      {
        "id": 386,
        "deptId": 72,
        "deptName": "deloris.schneider",
        "organId": "12",
        "organName": "deloris.schneider",
        "roleId": 613,
        "roleName": "deloris.schneider",
        "adminId": 165
      }
    ],
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
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
  "data": "oixwpn",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:50",
    "lastTime": "2025-09-05 15:45:50",
    "id": 856,
    "userId": "12",
    "deptId": 526,
    "deptName": "deloris.schneider",
    "organId": "12",
    "organName": "deloris.schneider",
    "name": "deloris.schneider",
    "username": "deloris.schneider",
    "nickName": "lon.nicolas",
    "email": "ralph.kerluke@hotmail.com",
    "mobile": "(682) 505-7451",
    "imagePath": "03xith",
    "password": "jryamf",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 384,
    "delFlag": 3,
    "lastLoginIp": "188.87.89.33",
    "lastLoginTime": "2025-09-05 15:45:50",
    "description": "s1lky7",
    "dept": {
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:50",
      "lastTime": "2025-09-05 15:45:50",
      "id": 247,
      "organId": "12",
      "parentId": 532,
      "appId": "12",
      "depttypeId": 281,
      "foreignId": "12",
      "createType": 794,
      "type": "tl7vnz",
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "areaCode": "17639",
      "organLeader": "hu0i1w",
      "leaderId": "12",
      "leaderMobile": "(682) 505-7451",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "17639",
      "imagePath": "j296b3",
      "priority": 198,
      "status": 896,
      "delFlag": 3,
      "description": "klnhw9",
      "spare1": "osvtxq",
      "spare2": "dv1r4q",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:50",
        "lastTime": "2025-09-05 15:45:50",
        "id": 276,
        "roletypeId": "12",
        "appId": "12",
        "name": "deloris.schneider",
        "code": "17639",
        "priority": 198,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 941,
        "description": "rbwl8a",
        "areaType": "kdv7om"
      }
    ],
    "roleIds": [
      356
    ],
    "positionIds": [
      "nuyiff"
    ],
    "roleId": 45,
    "userRoleList": [
      {
        "id": 340,
        "deptId": 723,
        "deptName": "deloris.schneider",
        "organId": "12",
        "organName": "deloris.schneider",
        "roleId": 954,
        "roleName": "deloris.schneider",
        "adminId": 683
      }
    ],
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
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
  "data": "8k9dzl",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole/785.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "0duefw",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X PUT -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole.do --data 'roleIds=8boqci&roleIds=8boqci&adminId=820'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "yb5k4r",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/list.do?email=ralph.kerluke@hotmail.com&page=1&organId=12&nickName=lon.nicolas&adminId=997&delFlag=3&limit=10&userId=12&q=p8u7n0&mobile=(682) 505-7451&endTime=2025-09-05 15:44:42&status=oq8l70&deptId=88&username=deloris.schneider&startTime=2025-09-05 15:44:42&orderBy=495
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:49",
      "lastTime": "2025-09-05 15:45:49",
      "id": 110,
      "userId": "12",
      "deptId": 457,
      "deptName": "deloris.schneider",
      "organId": "12",
      "organName": "deloris.schneider",
      "name": "deloris.schneider",
      "username": "deloris.schneider",
      "nickName": "lon.nicolas",
      "email": "ralph.kerluke@hotmail.com",
      "mobile": "(682) 505-7451",
      "imagePath": "uuuojm",
      "password": "20rvgy",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 332,
      "delFlag": 3,
      "lastLoginIp": "188.87.89.33",
      "lastLoginTime": "2025-09-05 15:45:49",
      "description": "qc6yxn",
      "dept": {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:49",
        "lastTime": "2025-09-05 15:45:49",
        "id": 606,
        "organId": "12",
        "parentId": 361,
        "appId": "12",
        "depttypeId": 208,
        "foreignId": "12",
        "createType": 328,
        "type": "ixanhq",
        "name": "deloris.schneider",
        "sname": "deloris.schneider",
        "areaCode": "17639",
        "organLeader": "ercewo",
        "leaderId": "12",
        "leaderMobile": "(682) 505-7451",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "17639",
        "imagePath": "1nzbb5",
        "priority": 890,
        "status": 423,
        "delFlag": 3,
        "description": "6g1oar",
        "spare1": "kx96t6",
        "spare2": "nrpyd5",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "12",
          "createTime": "2025-09-05 15:45:49",
          "lastTime": "2025-09-05 15:45:49",
          "id": 669,
          "roletypeId": "12",
          "appId": "12",
          "name": "deloris.schneider",
          "code": "17639",
          "priority": 434,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 722,
          "description": "p5xk28",
          "areaType": "qck53k"
        }
      ],
      "roleIds": [
        392
      ],
      "positionIds": [
        "cfxy3k"
      ],
      "roleId": 5,
      "userRoleList": [
        {
          "id": 907,
          "deptId": 603,
          "deptName": "deloris.schneider",
          "organId": "12",
          "organName": "deloris.schneider",
          "roleId": 252,
          "roleName": "deloris.schneider",
          "adminId": 243
        }
      ],
      "code": "17639",
      "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:49",
      "lastTime": "2025-09-05 15:45:49",
      "id": 75,
      "userId": "12",
      "deptId": 246,
      "deptName": "deloris.schneider",
      "organId": "12",
      "organName": "deloris.schneider",
      "name": "deloris.schneider",
      "username": "deloris.schneider",
      "nickName": "lon.nicolas",
      "email": "ralph.kerluke@hotmail.com",
      "mobile": "(682) 505-7451",
      "imagePath": "m2pjfr",
      "password": "1ow6w1",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 661,
      "delFlag": 3,
      "lastLoginIp": "188.87.89.33",
      "lastLoginTime": "2025-09-05 15:45:49",
      "description": "v3h2g6",
      "dept": {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:49",
        "lastTime": "2025-09-05 15:45:49",
        "id": 0,
        "organId": "12",
        "parentId": 972,
        "appId": "12",
        "depttypeId": 988,
        "foreignId": "12",
        "createType": 408,
        "type": "52qct6",
        "name": "deloris.schneider",
        "sname": "deloris.schneider",
        "areaCode": "17639",
        "organLeader": "7bu6cd",
        "leaderId": "12",
        "leaderMobile": "(682) 505-7451",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "17639",
        "imagePath": "7v17jk",
        "priority": 282,
        "status": 686,
        "delFlag": 3,
        "description": "9zqhaf",
        "spare1": "0e8uou",
        "spare2": "lj0obd",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "12",
          "createTime": "2025-09-05 15:45:49",
          "lastTime": "2025-09-05 15:45:49",
          "id": 134,
          "roletypeId": "12",
          "appId": "12",
          "name": "deloris.schneider",
          "code": "17639",
          "priority": 929,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 829,
          "description": "k3bwmo",
          "areaType": "aerwzd"
        }
      ],
      "roleIds": [
        524
      ],
      "positionIds": [
        "ugs780"
      ],
      "roleId": 96,
      "userRoleList": [
        {
          "id": 587,
          "deptId": 127,
          "deptName": "deloris.schneider",
          "organId": "12",
          "organName": "deloris.schneider",
          "roleId": 901,
          "roleName": "deloris.schneider",
          "adminId": 427
        }
      ],
      "code": "17639",
      "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
    },
    "roles": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:49",
        "lastTime": "2025-09-05 15:45:49",
        "roleId": 375,
        "roleName": "deloris.schneider",
        "roleKey": "onxhg1",
        "roleSort": 322,
        "menuCheckStrictly": true,
        "deptCheckStrictly": true,
        "status": 194,
        "flag": true,
        "menuIds": [
          899
        ],
        "deptIds": [
          323
        ],
        "permissions": [
          "4z8n3x"
        ],
        "remark": "zmw40v",
        "parentName": "deloris.schneider",
        "appName": "deloris.schneider",
        "roletypeId": "12",
        "roletypeName": "deloris.schneider",
        "priority": 39,
        "isSuper": true
      }
    ],
    "roleList": [
      {
        "id": 281,
        "roleId": 686,
        "adminId": 1,
        "deptId": 223,
        "deptName": "deloris.schneider",
        "organId": "12",
        "organName": "deloris.schneider",
        "roleName": "deloris.schneider"
      }
    ],
    "positions": [
      {
        "postId": "12",
        "postCode": "17639",
        "postName": "deloris.schneider",
        "postSort": 407,
        "status": 178,
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:50",
        "lastTime": "2025-09-05 15:45:50",
        "delFlag": 3,
        "remark": "qrjc46",
        "ids": [
          "3tulxd"
        ],
        "positionId": "12",
        "flag": true
      }
    ],
    "roleIds": [
      288
    ],
    "positionIds": [
      541
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/deptTree.do?type=gp4zcs&areaCode=17639&createType=380&endTime=2025-09-05 15:44:42&sname=deloris.schneider&leaderMobile=(682) 505-7451&q=j0x2nu&status=670&organLeader=9olpde&parentId=74&isOrganLevel=true&creatorId=12&organId=12&depttypeId=880&leaderId=12&imagePath=q85l4k&startTime=2025-09-05 15:44:42&isLeaf=true&orderBy=511&searchCode=17639&isDisabled=true&foreignId=12&spare2=dkb5f4&name=deloris.schneider&appId=12&deptId=0&isVirtual=true&page=1&delFlag=3&spare1=8umfeb&limit=10&description=oionzc
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
      "id": 233,
      "label": "c84rk4",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/selectList.do?path=r26eno&organId=12&orderBy=714&sertypeId=12&isDisabled=true&appType=o8j25w&description=54m18h&domainId=12&status=899&name=deloris.schneider&isSite=true&isMobileApp=true&ids=34vvy5&ids=34vvy5&endTime=2025-09-05 15:44:42&limit=10&ftpId=12&delFlag=3&mode=941&xzqhId=238&q=zb177d&page=1&existKey=a2o4y3&startTime=2025-09-05 15:44:42
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:55",
      "lastTime": "2025-09-05 15:45:55",
      "id": "12",
      "ftpId": "12",
      "domainId": "12",
      "organId": "12",
      "xzqhId": 838,
      "sertypeId": "12",
      "name": "deloris.schneider",
      "path": "h8fp56",
      "appType": "ytrvc7",
      "isSite": true,
      "isDisabled": true,
      "isMobileApp": true,
      "status": 316,
      "priority": 632,
      "delFlag": 3,
      "deleteTime": "2025-09-05 15:45:55",
      "description": "10z7pp",
      "spare1": "qvmo0j",
      "spare2": "00yk4p",
      "xzqhName": "deloris.schneider"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/list.do?isSite=true&domainId=12&name=deloris.schneider&isDisabled=true&orderBy=299&limit=10&startTime=2025-09-05 15:44:42&ftpId=12&organId=12&status=334&delFlag=3&xzqhId=600&ids=k8yjyx&ids=k8yjyx&q=pfpij7&isMobileApp=true&idArr=wt10kv&endTime=2025-09-05 15:44:42&appType=dblmu8&page=1&sertypeId=12&path=t3nwa0&description=3mks9s&mode=666&existKey=f8f362
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
    "totalCount": 97,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:55",
        "lastTime": "2025-09-05 15:45:55",
        "id": "12",
        "ftpId": "12",
        "domainId": "12",
        "organId": "12",
        "xzqhId": 554,
        "sertypeId": "12",
        "name": "deloris.schneider",
        "path": "ecogkg",
        "appType": "3bgdvo",
        "isSite": true,
        "isDisabled": true,
        "isMobileApp": true,
        "status": 246,
        "priority": 147,
        "delFlag": 3,
        "deleteTime": "2025-09-05 15:45:55",
        "description": "2mfm55",
        "spare1": "pjt3vx",
        "spare2": "8saim2",
        "xzqhName": "deloris.schneider"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/export.do --data 'sertypeId=12&endTime=2025-09-05 15:44:42&limit=10&name=deloris.schneider&path=zaoub8&isSite=true&startTime=2025-09-05 15:44:42&mode=588&idArr=wnjpng&ftpId=12&domainId=12&isDisabled=true&page=1&description=atevrl&existKey=0iabaw&ids=qj09qf&ids=qj09qf&q=pa1pwn&orderBy=296&organId=12&isMobileApp=true&xzqhId=357&appType=h17jts&delFlag=3&status=396'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "5liovd",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/12.do
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:55",
    "lastTime": "2025-09-05 15:45:55",
    "id": "12",
    "ftpId": "12",
    "domainId": "12",
    "organId": "12",
    "xzqhId": 491,
    "sertypeId": "12",
    "name": "deloris.schneider",
    "path": "1dsat5",
    "appType": "8lmgkr",
    "isSite": true,
    "isDisabled": true,
    "isMobileApp": true,
    "status": 345,
    "priority": 176,
    "delFlag": 3,
    "deleteTime": "2025-09-05 15:45:55",
    "description": "aq7kno",
    "spare1": "s3hpt0",
    "spare2": "ub9v15",
    "xzqhName": "deloris.schneider",
    "ftpName": "deloris.schneider",
    "sertypeName": "deloris.schneider",
    "domainName": "deloris.schneider",
    "organName": "deloris.schneider"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "id": "12",
    "ftpId": "12",
    "ftpName": "deloris.schneider",
    "domainId": "12",
    "domainName": "deloris.schneider",
    "organId": "12",
    "organName": "deloris.schneider",
    "xzqhId": 424,
    "xzqhName": "deloris.schneider",
    "sertypeId": "12",
    "sertypeName": "deloris.schneider",
    "name": "deloris.schneider",
    "path": "hzcnac",
    "appType": "ggbe33",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 478,
    "statusName": "deloris.schneider",
    "priority": 168,
    "createTime": "2025-09-05 15:45:55",
    "description": "egddf3",
    "spare1": "6q9b9m",
    "statusMap": {
      "mapKey": "b8jsre"
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
  "data": "imyuh9",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "id": "12",
    "ftpId": "12",
    "ftpName": "deloris.schneider",
    "domainId": "12",
    "domainName": "deloris.schneider",
    "organId": "12",
    "organName": "deloris.schneider",
    "xzqhId": 865,
    "xzqhName": "deloris.schneider",
    "sertypeId": "12",
    "sertypeName": "deloris.schneider",
    "name": "deloris.schneider",
    "path": "06n0g0",
    "appType": "296u0q",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 729,
    "statusName": "deloris.schneider",
    "priority": 969,
    "createTime": "2025-09-05 15:45:55",
    "description": "x5u8o7",
    "spare1": "jy076v",
    "statusMap": {
      "mapKey": "9suz5h"
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
  "data": "e82rto",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "cuo65j",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/init/12.do --data '{
  "data": {
    "id": "12",
    "menuJsons": {
      "size": 10
    },
    "initJson": {},
    "username": "deloris.schneider",
    "password": "e47g6c",
    "initPath": "wbb554"
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
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "zmyuj2",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/xzqh/list.do?q=8e9k2v&nameEn=hw3wtv&areatypeId=12&nameTotal=kyj7e0&parentIds=ku8o0h&parentIds=ku8o0h&limit=10&likeQuery=ggg02o&deleteTime=2025-09-05 15:44:42&page=1&parentId=324&ids=1vx0a5&ids=1vx0a5&isDisplay=true&orderBy=160&lft=830&searchCode=17639&delFlag=3&hasContent=true&name=deloris.schneider&countryId=12&sname=deloris.schneider&code=17639&endTime=2025-09-05 15:44:42&rgt=528&startTime=2025-09-05 15:44:42&description=v0d8ac&areatypeIds=e9omsk&areatypeIds=e9omsk
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
    "totalCount": 472,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:56",
        "lastTime": "2025-09-05 15:45:56",
        "id": 566,
        "parentId": 255,
        "countryId": "12",
        "areatypeId": "12",
        "lft": 265,
        "rgt": 45,
        "code": "17639",
        "name": "deloris.schneider",
        "nameTotal": "0cvgm3",
        "sname": "deloris.schneider",
        "nameEn": "qcgleo",
        "searchCode": "17639",
        "isDisplay": true,
        "hasContent": true,
        "priority": 369,
        "delFlag": 3,
        "deleteTime": "2025-09-05 15:45:56",
        "description": "2jc0z8",
        "countryName": "deloris.schneider",
        "parentName": "deloris.schneider",
        "areatypeName": "deloris.schneider"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/organ/list.do?organName=deloris.schneider&endTime=2025-09-05 15:44:42&unionCode=17639&key=yyv5o6&startTime=2025-09-05 15:44:42&createType=282&isOrganWork=35epj3&spare1=jivi20&ids=ld90qv&ids=ld90qv&source=941&description=swyhj0&organCode=17639&q=hsz0pc&delFlag=3&orderBy=558&xzqhId=876&page=1&limit=10&orgtypeId=12&name=deloris.schneider&spare2=kss16b
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
    "totalCount": 345,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:56",
        "lastTime": "2025-09-05 15:45:56",
        "cmsKey": "tm1gmq",
        "cmsValue": "g10rfs"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/list.do?rgt=658&code=17639&endTime=2025-09-05 15:44:42&countryId=12&parentIds=9vvp4f&parentIds=9vvp4f&areatypeId=12&page=1&searchCode=17639&likeQuery=m2maid&q=29do0d&areatypeIds=2r37n3&areatypeIds=2r37n3&deleteTime=2025-09-05 15:44:42&sname=deloris.schneider&description=n8gqhk&orderBy=861&limit=10&nameTotal=nvza4m&ids=r6x7v8&ids=r6x7v8&startTime=2025-09-05 15:44:42&nameEn=gdjd0j&hasContent=true&isDisplay=true&parentId=658&name=deloris.schneider&delFlag=3&lft=277
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:56",
      "lastTime": "2025-09-05 15:45:56",
      "id": 566,
      "parentId": 950,
      "countryId": "12",
      "areatypeId": "12",
      "lft": 543,
      "rgt": 103,
      "code": "17639",
      "name": "deloris.schneider",
      "nameTotal": "ai49mu",
      "sname": "deloris.schneider",
      "nameEn": "0roo1h",
      "searchCode": "17639",
      "isDisplay": true,
      "hasContent": true,
      "priority": 505,
      "delFlag": 3,
      "deleteTime": "2025-09-05 15:45:56",
      "description": "x9vjkb"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/export.do --data 'startTime=2025-09-05 15:44:42&q=l2f919&sname=deloris.schneider&nameEn=wpsgc2&rgt=93&hasContent=true&ids=tdo3ot&ids=tdo3ot&endTime=2025-09-05 15:44:42&areatypeId=12&limit=10&nameTotal=8wszct&page=1&deleteTime=2025-09-05 15:44:42&parentIds=f8t1d8&parentIds=f8t1d8&description=gv6dpt&searchCode=17639&isDisplay=true&likeQuery=08j69w&countryId=12&lft=48&areatypeIds=nmm6jm&areatypeIds=nmm6jm&name=deloris.schneider&orderBy=891&parentId=627&delFlag=3&code=17639'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "9i3o07",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:56",
    "lastTime": "2025-09-05 15:45:56",
    "id": 354,
    "parentId": 873,
    "countryId": "12",
    "areatypeId": "12",
    "lft": 365,
    "rgt": 448,
    "code": "17639",
    "name": "deloris.schneider",
    "nameTotal": "pit1ua",
    "sname": "deloris.schneider",
    "nameEn": "q1tdd1",
    "searchCode": "17639",
    "isDisplay": true,
    "hasContent": true,
    "priority": 112,
    "delFlag": 3,
    "deleteTime": "2025-09-05 15:45:56",
    "description": "2ycbf3"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:56",
    "lastTime": "2025-09-05 15:45:56",
    "id": 760,
    "parentId": 625,
    "countryId": "12",
    "areatypeId": "12",
    "lft": 543,
    "rgt": 488,
    "code": "17639",
    "name": "deloris.schneider",
    "nameTotal": "3shuke",
    "sname": "deloris.schneider",
    "nameEn": "rm4q7k",
    "searchCode": "17639",
    "isDisplay": true,
    "hasContent": true,
    "priority": 356,
    "delFlag": 3,
    "deleteTime": "2025-09-05 15:45:56",
    "description": "5pwvdp"
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
  "data": "x4qye4",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:56",
    "lastTime": "2025-09-05 15:45:56",
    "id": 275,
    "parentId": 37,
    "countryId": "12",
    "areatypeId": "12",
    "lft": 437,
    "rgt": 550,
    "code": "17639",
    "name": "deloris.schneider",
    "nameTotal": "bson08",
    "sname": "deloris.schneider",
    "nameEn": "shask5",
    "searchCode": "17639",
    "isDisplay": true,
    "hasContent": true,
    "priority": 674,
    "delFlag": 3,
    "deleteTime": "2025-09-05 15:45:56",
    "description": "8zwnmj"
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
  "data": "un4wkn",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "uuf9lz",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/list.do?isDisabled=true&startTime=2025-09-05 15:44:42&confLimit=10&aesIvKey=yknnee&inoutMode=584&appId=12&serverType=917r6r&isAdmin=true&endTime=2025-09-05 15:44:42&spare2=tb2i0z&serverUrl=www.lynn-stehr.co&clientId=12&cname=deloris.schneider&organName=deloris.schneider&q=685m68&limit=10&serverConf3=hexst4&status=968&serverConf1=erpw94&page=1&currCount=888&organId=12&aesKey=olt1nc&id=12&orderBy=140&type=971&name=deloris.schneider&description=k2rfwi&spare1=1tddbg&serverIp=188.87.89.33&serverConf2=672yja&clientSecret=92qbhd&isSingle=true
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:59",
      "lastTime": "2025-09-05 15:45:59",
      "id": "12",
      "organId": "12",
      "appId": "12",
      "organName": "deloris.schneider",
      "inoutMode": 941,
      "name": "deloris.schneider",
      "cname": "deloris.schneider",
      "type": 868,
      "clientId": "12",
      "clientSecret": "pp2mzm",
      "aesKey": "183u4z",
      "aesIvKey": "vhss76",
      "serverIp": "188.87.89.33",
      "serverType": "cl7dch",
      "serverUrl": "www.lynn-stehr.co",
      "serverConf1": "ffz8ci",
      "serverConf2": "j8rlbs",
      "serverConf3": "t5p661",
      "currCount": 31,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 454,
      "description": "f43gog",
      "spare1": "x4nxd1",
      "spare2": "nlf3c7",
      "inOrganName": "deloris.schneider",
      "userName": "deloris.schneider",
      "appName": "deloris.schneider",
      "inoutModeName": "deloris.schneider",
      "typeName": "deloris.schneider"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/getClientSecret.do?clientId=12
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:59",
      "lastTime": "2025-09-05 15:45:59",
      "id": "12",
      "organId": "12",
      "appId": "12",
      "organName": "deloris.schneider",
      "inoutMode": 933,
      "name": "deloris.schneider",
      "cname": "deloris.schneider",
      "type": 217,
      "clientId": "12",
      "clientSecret": "kx09gz",
      "aesKey": "29d92s",
      "aesIvKey": "9uy608",
      "serverIp": "188.87.89.33",
      "serverType": "0uxbpc",
      "serverUrl": "www.lynn-stehr.co",
      "serverConf1": "vuh1ju",
      "serverConf2": "gl9b44",
      "serverConf3": "t2afxh",
      "currCount": 563,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 90,
      "description": "ovy1mk",
      "spare1": "2xz0xc",
      "spare2": "e07s45",
      "inOrganName": "deloris.schneider",
      "userName": "deloris.schneider",
      "appName": "deloris.schneider",
      "inoutModeName": "deloris.schneider",
      "typeName": "deloris.schneider"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/plat/account/getKeyParity.do?id=12
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:59",
      "lastTime": "2025-09-05 15:45:59",
      "id": "12",
      "organId": "12",
      "appId": "12",
      "organName": "deloris.schneider",
      "inoutMode": 773,
      "name": "deloris.schneider",
      "cname": "deloris.schneider",
      "type": 673,
      "clientId": "12",
      "clientSecret": "g6s7jv",
      "aesKey": "4fonev",
      "aesIvKey": "0ttng2",
      "serverIp": "188.87.89.33",
      "serverType": "ws9el4",
      "serverUrl": "www.lynn-stehr.co",
      "serverConf1": "up3thd",
      "serverConf2": "y5zjpb",
      "serverConf3": "jzyqnl",
      "currCount": 670,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 229,
      "description": "45268l",
      "spare1": "w6dz5i",
      "spare2": "bdwvnh",
      "inOrganName": "deloris.schneider",
      "userName": "deloris.schneider",
      "appName": "deloris.schneider",
      "inoutModeName": "deloris.schneider",
      "typeName": "deloris.schneider"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
{"success":true,"code":"0","msg":"正常","data":Error restful return.,"requestId":"12","timestamp":"2025-09-05 15:44:42"}
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
  "data": "2py17g",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "b2izyk",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "xurlux",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/list.do?orderBy=816&wlType=n25y04&organId=12&organName=deloris.schneider&endTime=2025-09-05 15:44:42&startTime=2025-09-05 15:44:42&delFlag=3&q=ybo56d&limit=10&page=1
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
        "sc5whw"
      ],
      "organId": "12",
      "organName": "deloris.schneider",
      "organSName": "deloris.schneider",
      "organCode": "17639",
      "address": "57393 Madeleine Manor， Lake Dottie， MN 33706",
      "wlType": "shs90b",
      "wlTypeName": "deloris.schneider",
      "priority": 685,
      "delFlag": 3,
      "createTime": "2025-09-05 15:45:57",
      "lastTime": "2025-09-05 15:45:57",
      "contactName": "deloris.schneider",
      "contactEmail": "ralph.kerluke@hotmail.com",
      "contactMobile": "(682) 505-7451",
      "description": "zf8xrn",
      "tel": "cp2ifp"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "i845k0"
    ],
    "organId": "12",
    "organName": "deloris.schneider",
    "organSName": "deloris.schneider",
    "organCode": "17639",
    "address": "57393 Madeleine Manor， Lake Dottie， MN 33706",
    "wlType": "vgze5b",
    "wlTypeName": "deloris.schneider",
    "priority": 178,
    "delFlag": 3,
    "createTime": "2025-09-05 15:45:57",
    "lastTime": "2025-09-05 15:45:57",
    "contactName": "deloris.schneider",
    "contactEmail": "ralph.kerluke@hotmail.com",
    "contactMobile": "(682) 505-7451",
    "description": "bcx76u",
    "tel": "nm72zc"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "otdylg"
    ],
    "organId": "12",
    "organName": "deloris.schneider",
    "organSName": "deloris.schneider",
    "organCode": "17639",
    "address": "57393 Madeleine Manor， Lake Dottie， MN 33706",
    "wlType": "935hmo",
    "wlTypeName": "deloris.schneider",
    "priority": 555,
    "delFlag": 3,
    "createTime": "2025-09-05 15:45:57",
    "lastTime": "2025-09-05 15:45:57",
    "contactName": "deloris.schneider",
    "contactEmail": "ralph.kerluke@hotmail.com",
    "contactMobile": "(682) 505-7451",
    "description": "0qck76",
    "tel": "2tmfye"
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
  "data": "fi0g99",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "zpa11g"
    ],
    "organId": "12",
    "organName": "deloris.schneider",
    "organSName": "deloris.schneider",
    "organCode": "17639",
    "address": "57393 Madeleine Manor， Lake Dottie， MN 33706",
    "wlType": "bxf243",
    "wlTypeName": "deloris.schneider",
    "priority": 597,
    "delFlag": 3,
    "createTime": "2025-09-05 15:45:57",
    "lastTime": "2025-09-05 15:45:57",
    "contactName": "deloris.schneider",
    "contactEmail": "ralph.kerluke@hotmail.com",
    "contactMobile": "(682) 505-7451",
    "description": "6uy2q2",
    "tel": "qopu7z"
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
  "data": "qfpgny",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "g0gi9s",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "i7rycx"
    ],
    "organId": "12",
    "organName": "deloris.schneider",
    "organSName": "deloris.schneider",
    "organCode": "17639",
    "address": "57393 Madeleine Manor， Lake Dottie， MN 33706",
    "wlType": "tsf2fb",
    "wlTypeName": "deloris.schneider",
    "priority": 285,
    "delFlag": 3,
    "createTime": "2025-09-05 15:45:57",
    "lastTime": "2025-09-05 15:45:57",
    "contactName": "deloris.schneider",
    "contactEmail": "ralph.kerluke@hotmail.com",
    "contactMobile": "(682) 505-7451",
    "description": "gq04r0",
    "tel": "ht5t6s"
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
  "data": "wj7xzn",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/list.do?page=1&orderBy=47&name=deloris.schneider&delFlag=3&startTime=2025-09-05 15:44:42&limit=10&q=1zeoua&endTime=2025-09-05 15:44:42&description=qwqbb2&sname=deloris.schneider
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:57",
      "lastTime": "2025-09-05 15:45:57",
      "id": "12",
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "priority": 487,
      "delFlag": 3,
      "description": "8ustxd"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/export.do --data 'limit=10&name=deloris.schneider&delFlag=3&page=1&endTime=2025-09-05 15:44:42&startTime=2025-09-05 15:44:42&orderBy=27&description=shyp0y&q=zx85m9&sname=deloris.schneider'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "jmt5zo",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:57",
    "lastTime": "2025-09-05 15:45:57",
    "id": "12",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "priority": 787,
    "delFlag": 3,
    "description": "avkgxt"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:57",
    "lastTime": "2025-09-05 15:45:57",
    "id": "12",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "priority": 166,
    "delFlag": 3,
    "description": "fgr38s"
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
  "data": "mh90uv",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:57",
    "lastTime": "2025-09-05 15:45:57",
    "id": "12",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "priority": 135,
    "delFlag": 3,
    "description": "jqerzh"
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
  "data": "1vvhxh",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "1fqwng",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/list.do?orderBy=182&existKey=ki96pb&page=1&q=5m6f0g&delFlag=3&name=deloris.schneider&limit=10&code=17639&description=1pnqyx&type=zny9hh&endTime=2025-09-05 15:44:42&startTime=2025-09-05 15:44:42
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:57",
      "lastTime": "2025-09-05 15:45:57",
      "id": "12",
      "name": "deloris.schneider",
      "type": "kf5r5t",
      "code": "17639",
      "priority": 102,
      "delFlag": 3,
      "description": "eo01by"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/export.do --data 'q=svwr8h&type=nnbp2n&name=deloris.schneider&orderBy=333&code=17639&delFlag=3&startTime=2025-09-05 15:44:42&endTime=2025-09-05 15:44:42&existKey=oqn9c9&limit=10&description=k188t7&page=1'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "u6kukc",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:57",
    "lastTime": "2025-09-05 15:45:57",
    "id": "12",
    "name": "deloris.schneider",
    "type": "x3a9yv",
    "code": "17639",
    "priority": 985,
    "delFlag": 3,
    "description": "wwfc0l"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:57",
    "lastTime": "2025-09-05 15:45:57",
    "id": "12",
    "name": "deloris.schneider",
    "type": "7jciwg",
    "code": "17639",
    "priority": 661,
    "delFlag": 3,
    "description": "wpjxie"
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
  "data": "h7fanv",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:58",
    "lastTime": "2025-09-05 15:45:58",
    "id": "12",
    "name": "deloris.schneider",
    "type": "lacn6t",
    "code": "17639",
    "priority": 284,
    "delFlag": 3,
    "description": "joo79v"
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
  "data": "lj7qqp",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "dws6jy",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/list.do?refId=12&limit=10&orderBy=133&startTime=2025-09-05 15:44:42&fileIsvalid=true&refType=gli30y&key=5si1cf&endTime=2025-09-05 15:44:42&page=1&resclassId=12&fileSize=817&fileExtension=lno14t&fileName=deloris.schneider&q=4tr569&appId=12
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
    "totalCount": 78,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "id": "12",
        "resclassId": "12",
        "fileName": "deloris.schneider",
        "fileIsvalid": true,
        "createTime": "2025-09-05 15:45:56",
        "fileExtension": "k7uui7",
        "ids": [
          "fpfwky"
        ]
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/export.do --data 'resclassId=12&appId=12&fileSize=573&fileExtension=url8vf&key=6wplpq&startTime=2025-09-05 15:44:42&fileName=deloris.schneider&orderBy=531&limit=10&refId=12&endTime=2025-09-05 15:44:42&q=0m75t7&page=1&fileIsvalid=true&refType=0vo018'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "h2bb57",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/info.do?id=12
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
    "id": "12",
    "resclassId": "12",
    "fileName": "deloris.schneider",
    "fileIsvalid": true,
    "createTime": "2025-09-05 15:45:56",
    "fileExtension": "1nnzqs",
    "ids": [
      "kagbj7"
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "id": "12",
    "resclassId": "12",
    "fileName": "deloris.schneider",
    "fileIsvalid": true,
    "createTime": "2025-09-05 15:45:56",
    "fileExtension": "uadjkg",
    "ids": [
      "vzil3h"
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
  "data": "oegy09",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "id": "12",
    "resclassId": "12",
    "fileName": "deloris.schneider",
    "fileIsvalid": true,
    "createTime": "2025-09-05 15:45:56",
    "fileExtension": "cjyk5s",
    "ids": [
      "agkpmt"
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
  "data": "c0rvfn",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "id": "12",
    "resclassId": "12",
    "fileName": "deloris.schneider",
    "fileIsvalid": true,
    "createTime": "2025-09-05 15:45:56",
    "fileExtension": "jdhy8b",
    "ids": [
      "pg9k60"
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
  "data": "uudvg2",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "kfxtl6",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download.do?fileName=deloris.schneider&delete=true
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3u36jx",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "originFilename": "deloris.schneider",
    "filename": "deloris.schneider",
    "fileType": "s9tfvh",
    "fileUrl": "www.lynn-stehr.co",
    "fileHttpUrl": "www.lynn-stehr.co",
    "statusCode": "17639"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "originFilename": "deloris.schneider",
      "filename": "deloris.schneider",
      "fileType": "m0kdem",
      "fileUrl": "www.lynn-stehr.co",
      "fileHttpUrl": "www.lynn-stehr.co",
      "statusCode": "17639"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download/resource.do?resource=d7f144
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "8vmm0q",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/list.do?keyWords=c61g60&limit=10&type=wtb6b0&endTime=2025-09-05 15:44:42&startTime=2025-09-05 15:44:42&status=810&page=1&appId=12&q=n82ef3&organId=12&orderBy=651&positionId=12&roleTypeId=12&areaId=547&batchId=12&groupId=4
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
    "totalCount": 75,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:53",
        "lastTime": "2025-09-05 15:45:53",
        "id": 622,
        "appId": "12",
        "saveSource": "ds9byz",
        "unitName": "deloris.schneider",
        "name": "deloris.schneider",
        "idNum": "59j8ag",
        "duty": "qn2jn3",
        "telephone": "(947) 586-4732",
        "mobile": "(682) 505-7451",
        "extInfo1": "bt1noj",
        "extInfo2": "tw2nnc",
        "extInfo3": "bvmizr",
        "needInitUser": true,
        "userId": "12",
        "needInitOrgan": true,
        "organId": "12",
        "type": "murrak",
        "foreignUrl": "www.lynn-stehr.co",
        "bizType": 325,
        "bizOrganId": "12",
        "bizAreaId": 951,
        "bizGroupId": 602,
        "bizPower": "ldbenw",
        "bizMultiInfo": "c3vo12",
        "needSetOrgan": true,
        "needSetArea": true,
        "needSetGroup": true,
        "needSetPower": true,
        "opUserId": "12",
        "opOrganId": "12",
        "opTime": "2025-09-05 15:45:53",
        "opInfo": "sb0nl8",
        "priority": 771,
        "status": 693,
        "delFlag": 3,
        "dataBatch": "vsuffm",
        "dataVersion": 851,
        "updateTime": "2025-09-05 15:45:53",
        "syncMode": "ypxv4n",
        "syncTime": "2025-09-05 15:45:53",
        "description": "xoirq7",
        "groupName": "deloris.schneider",
        "positionName": "deloris.schneider",
        "bizPowerName": "deloris.schneider",
        "subdistrictName": "deloris.schneider",
        "communityName": "deloris.schneider"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/export.do --data 'endTime=2025-09-05 15:44:42&keyWords=9soma6&batchId=12&areaId=811&appId=12&startTime=2025-09-05 15:44:42&type=fny1hh&roleTypeId=12&q=gj1vjd&groupId=394&status=211&orderBy=754&page=1&positionId=12&limit=10&organId=12'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "lia8hy",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/144.do
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:53",
    "lastTime": "2025-09-05 15:45:53",
    "id": 598,
    "appId": "12",
    "saveSource": "1w1rks",
    "unitName": "deloris.schneider",
    "name": "deloris.schneider",
    "idNum": "c4uz18",
    "duty": "wvdrgv",
    "telephone": "(947) 586-4732",
    "mobile": "(682) 505-7451",
    "extInfo1": "pst3ob",
    "extInfo2": "i28qp6",
    "extInfo3": "wbo18s",
    "needInitUser": true,
    "userId": "12",
    "needInitOrgan": true,
    "organId": "12",
    "type": "09p6rv",
    "foreignUrl": "www.lynn-stehr.co",
    "bizType": 525,
    "bizOrganId": "12",
    "bizAreaId": 646,
    "bizGroupId": 862,
    "bizPower": "h1kdwx",
    "bizMultiInfo": "g9gt6k",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "12",
    "opOrganId": "12",
    "opTime": "2025-09-05 15:45:53",
    "opInfo": "fee09r",
    "priority": 856,
    "status": 816,
    "delFlag": 3,
    "dataBatch": "batq8j",
    "dataVersion": 135,
    "updateTime": "2025-09-05 15:45:53",
    "syncMode": "fl2mvm",
    "syncTime": "2025-09-05 15:45:53",
    "description": "wfssyr",
    "groupName": "deloris.schneider",
    "positionName": "deloris.schneider",
    "bizPowerName": "deloris.schneider",
    "subdistrictName": "deloris.schneider",
    "communityName": "deloris.schneider"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:53",
    "lastTime": "2025-09-05 15:45:53",
    "id": 533,
    "appId": "12",
    "saveSource": "0ysdcn",
    "unitName": "deloris.schneider",
    "name": "deloris.schneider",
    "idNum": "w0upo4",
    "duty": "ve8hlb",
    "telephone": "(947) 586-4732",
    "mobile": "(682) 505-7451",
    "extInfo1": "xtc0f6",
    "extInfo2": "209qtr",
    "extInfo3": "su6qxg",
    "needInitUser": true,
    "userId": "12",
    "needInitOrgan": true,
    "organId": "12",
    "type": "fwic6v",
    "foreignUrl": "www.lynn-stehr.co",
    "bizType": 506,
    "bizOrganId": "12",
    "bizAreaId": 144,
    "bizGroupId": 480,
    "bizPower": "zmd8a6",
    "bizMultiInfo": "46tle4",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "12",
    "opOrganId": "12",
    "opTime": "2025-09-05 15:45:53",
    "opInfo": "f9woo3",
    "priority": 914,
    "status": 197,
    "delFlag": 3,
    "dataBatch": "xctivl",
    "dataVersion": 696,
    "updateTime": "2025-09-05 15:45:53",
    "syncMode": "0pyvu4",
    "syncTime": "2025-09-05 15:45:53",
    "description": "fb9hvk"
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
  "data": "rbe5jj",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:53",
    "lastTime": "2025-09-05 15:45:53",
    "id": 517,
    "appId": "12",
    "saveSource": "sj1w9s",
    "unitName": "deloris.schneider",
    "name": "deloris.schneider",
    "idNum": "5seeda",
    "duty": "husxej",
    "telephone": "(947) 586-4732",
    "mobile": "(682) 505-7451",
    "extInfo1": "y7h25h",
    "extInfo2": "bopy9x",
    "extInfo3": "td9o8z",
    "needInitUser": true,
    "userId": "12",
    "needInitOrgan": true,
    "organId": "12",
    "type": "1jzdj3",
    "foreignUrl": "www.lynn-stehr.co",
    "bizType": 322,
    "bizOrganId": "12",
    "bizAreaId": 676,
    "bizGroupId": 301,
    "bizPower": "l35j45",
    "bizMultiInfo": "34b68j",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "12",
    "opOrganId": "12",
    "opTime": "2025-09-05 15:45:53",
    "opInfo": "yhdvl8",
    "priority": 979,
    "status": 657,
    "delFlag": 3,
    "dataBatch": "tuotow",
    "dataVersion": 712,
    "updateTime": "2025-09-05 15:45:53",
    "syncMode": "wozl3k",
    "syncTime": "2025-09-05 15:45:53",
    "description": "vb2yuu"
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
  "data": "c0d7ux",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "kf9uac",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "l6mykl",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list.do?creatorId=12&endTime=2025-09-05 15:44:42&readStatus=xzzme3&imagePath=hehhne&msgUrl=www.lynn-stehr.co&recvMemberId=12&limit=10&orderBy=68&type=912&recvTargetid=12&content=twmzvy&siteId=916&organId=12&status=509&description=qtswpk&recvOrganId=12&q=ei0xk8&updatorId=12&iconStyle=yfcwno&title=5dmxao&startTime=2025-09-05 15:44:42&updateTime=2025-09-05 15:46:04&recvGroupId=12&foreignId=12&page=1&bizType=78v8z0&id=513
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:46:04",
      "lastTime": "2025-09-05 15:46:04",
      "id": 772,
      "siteId": 850,
      "organId": "12",
      "bizType": "52043v",
      "type": 922,
      "title": "7ql0x0",
      "content": "e0om3h",
      "msgUrl": "www.lynn-stehr.co",
      "foreignId": "12",
      "imagePath": "40t9wt",
      "iconStyle": "d9jn18",
      "recvMemberId": "12",
      "recvGroupId": "12",
      "recvOrganId": "12",
      "recvTargetid": "12",
      "status": 315,
      "updatorId": "12",
      "updateTime": "2025-09-05 15:46:04",
      "description": "1udl3m"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list/myself.do?recvOrganId=12&recvTargetid=12&iconStyle=8sy6k2&imagePath=avstbp&endTime=2025-09-05 15:44:42&recvGroupId=12&bizType=ewr8ss&creatorId=12&readStatus=cue9s2&page=1&limit=10&title=4yhsve&startTime=2025-09-05 15:44:42&content=f6gt31&msgUrl=www.lynn-stehr.co&id=94&q=jrlkz1&foreignId=12&organId=12&orderBy=141&updatorId=12&updateTime=2025-09-05 15:46:04&recvMemberId=12&status=471&description=hocd5u&siteId=628&type=403
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:46:04",
      "lastTime": "2025-09-05 15:46:04",
      "id": 811,
      "siteId": 292,
      "organId": "12",
      "bizType": "e7jsua",
      "type": 733,
      "title": "b6e78b",
      "content": "cp12em",
      "msgUrl": "www.lynn-stehr.co",
      "foreignId": "12",
      "imagePath": "mrawy7",
      "iconStyle": "rugqns",
      "recvMemberId": "12",
      "recvGroupId": "12",
      "recvOrganId": "12",
      "recvTargetid": "12",
      "status": 409,
      "updatorId": "12",
      "updateTime": "2025-09-05 15:46:04",
      "description": "2anwnu"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/export.do --data 'id=18&foreignId=12&recvGroupId=12&recvMemberId=12&msgUrl=www.lynn-stehr.co&creatorId=12&organId=12&title=l3xc6b&endTime=2025-09-05 15:44:42&bizType=0it3ib&readStatus=hufi20&type=97&startTime=2025-09-05 15:44:42&siteId=429&updatorId=12&orderBy=478&recvTargetid=12&page=1&imagePath=2zw3kl&description=sxasnr&q=4sbog7&iconStyle=cqtupf&recvOrganId=12&status=601&limit=10&content=osrq1q&updateTime=2025-09-05 15:46:04'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "azlohc",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:46:04",
    "lastTime": "2025-09-05 15:46:04",
    "id": 232,
    "siteId": 866,
    "organId": "12",
    "bizType": "z37sol",
    "type": 229,
    "title": "tujpb2",
    "content": "xyihzh",
    "msgUrl": "www.lynn-stehr.co",
    "foreignId": "12",
    "imagePath": "05lk41",
    "iconStyle": "7prnxg",
    "recvMemberId": "12",
    "recvGroupId": "12",
    "recvOrganId": "12",
    "recvTargetid": "12",
    "status": 484,
    "updatorId": "12",
    "updateTime": "2025-09-05 15:46:04",
    "description": "dxcw4t"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:46:04",
    "lastTime": "2025-09-05 15:46:04",
    "id": 453,
    "siteId": 524,
    "organId": "12",
    "bizType": "9v9os4",
    "type": 525,
    "title": "lux7on",
    "content": "apd5vy",
    "msgUrl": "www.lynn-stehr.co",
    "foreignId": "12",
    "imagePath": "s1hdfg",
    "iconStyle": "xn58n1",
    "recvMemberId": "12",
    "recvGroupId": "12",
    "recvOrganId": "12",
    "recvTargetid": "12",
    "status": 712,
    "updatorId": "12",
    "updateTime": "2025-09-05 15:46:04",
    "description": "dpmg9t"
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
  "data": "0gdq3h",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:46:04",
    "lastTime": "2025-09-05 15:46:04",
    "id": 293,
    "siteId": 678,
    "organId": "12",
    "bizType": "us10i2",
    "type": 534,
    "title": "35xr0p",
    "content": "dznku0",
    "msgUrl": "www.lynn-stehr.co",
    "foreignId": "12",
    "imagePath": "i6h0ru",
    "iconStyle": "68j6o3",
    "recvMemberId": "12",
    "recvGroupId": "12",
    "recvOrganId": "12",
    "recvTargetid": "12",
    "status": 333,
    "updatorId": "12",
    "updateTime": "2025-09-05 15:46:04",
    "description": "uqufbz"
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
  "data": "610fn1",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "1s6gti",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "9nbazc",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "2t1bfj",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "m8wp9u",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "mapKey1": "kt13o2",
    "mapKey2": "19rmq4"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/list.do?msgContent=ghqaft&spare1=3sdlv5&spare2=a6zjxc&msgOrganName=deloris.schneider&msgTitle=twk1fc&msgUserId=12&q=cm6tek&msgId=560&msgLabels=uhelkn&status=pwx584&foreignId=12&description=78vcbu&opOrganName=deloris.schneider&opUserId=12&msgAbstract=3r4ymf&opOrganId=12&id=12&msgUserName=deloris.schneider&msgAccountId=12&limit=10&creatorId=12&type=zh4d4d&msgAccountName=deloris.schneider&msgOrganId=12&msgUrl=www.lynn-stehr.co&page=1&msgModuleName=deloris.schneider&msgCreateTime=2025-09-05 15:46:05&opTime=2025-09-05 15:46:05&startTime=2025-09-05 15:44:42&siteId=137&msgType=384&msgModuleId=12&bizType=7yy7o6&orderBy=871&endTime=2025-09-05 15:44:42
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:46:05",
      "lastTime": "2025-09-05 15:46:05",
      "id": "12",
      "siteId": 477,
      "foreignId": "12",
      "type": "0jlbew",
      "bizType": "u223ov",
      "msgCreateTime": "2025-09-05 15:46:05",
      "msgId": 222,
      "msgType": 302,
      "msgTitle": "8znewf",
      "msgAbstract": "jiy9q1",
      "msgAccountId": "12",
      "msgAccountName": "deloris.schneider",
      "msgModuleId": "12",
      "msgModuleName": "deloris.schneider",
      "msgUserId": "12",
      "msgUserName": "deloris.schneider",
      "msgOrganId": "12",
      "msgOrganName": "deloris.schneider",
      "msgUrl": "www.lynn-stehr.co",
      "msgLabels": "ktfkvn",
      "msgContent": "j6og4j",
      "status": "37s98r",
      "opUserId": "12",
      "opTime": "2025-09-05 15:46:05",
      "opOrganId": "12",
      "opOrganName": "deloris.schneider",
      "description": "wxd7cb",
      "spare1": "c5mamf",
      "spare2": "mzhkkh"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/export.do --data 'creatorId=12&msgAccountName=deloris.schneider&msgTitle=9x2bcz&msgType=664&msgOrganId=12&spare1=3kfw0m&id=12&msgId=299&spare2=bzvath&opUserId=12&msgAccountId=12&orderBy=752&msgUserId=12&q=8o9hul&opTime=2025-09-05 15:46:05&msgCreateTime=2025-09-05 15:46:05&foreignId=12&msgModuleId=12&msgContent=dc71ja&page=1&msgAbstract=ywursa&opOrganId=12&msgUrl=www.lynn-stehr.co&msgModuleName=deloris.schneider&limit=10&msgUserName=deloris.schneider&endTime=2025-09-05 15:44:42&msgOrganName=deloris.schneider&description=5pqtar&status=pnpboe&opOrganName=deloris.schneider&siteId=321&bizType=em07g2&msgLabels=4qtb0e&type=wfv7z4&startTime=2025-09-05 15:44:42'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "t5ycrw",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:46:05",
    "lastTime": "2025-09-05 15:46:05",
    "id": "12",
    "siteId": 31,
    "foreignId": "12",
    "type": "9c8dj3",
    "bizType": "nhltmj",
    "msgCreateTime": "2025-09-05 15:46:05",
    "msgId": 974,
    "msgType": 818,
    "msgTitle": "ivu3jj",
    "msgAbstract": "ajzrnm",
    "msgAccountId": "12",
    "msgAccountName": "deloris.schneider",
    "msgModuleId": "12",
    "msgModuleName": "deloris.schneider",
    "msgUserId": "12",
    "msgUserName": "deloris.schneider",
    "msgOrganId": "12",
    "msgOrganName": "deloris.schneider",
    "msgUrl": "www.lynn-stehr.co",
    "msgLabels": "i2gp2d",
    "msgContent": "ukfrau",
    "status": "gzbvc2",
    "opUserId": "12",
    "opTime": "2025-09-05 15:46:05",
    "opOrganId": "12",
    "opOrganName": "deloris.schneider",
    "description": "nfgpuf",
    "spare1": "yn42uf",
    "spare2": "lihejj"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:46:05",
    "lastTime": "2025-09-05 15:46:05",
    "id": "12",
    "siteId": 651,
    "foreignId": "12",
    "type": "fuxvot",
    "bizType": "jli819",
    "msgCreateTime": "2025-09-05 15:46:05",
    "msgId": 928,
    "msgType": 768,
    "msgTitle": "84e55o",
    "msgAbstract": "412h0f",
    "msgAccountId": "12",
    "msgAccountName": "deloris.schneider",
    "msgModuleId": "12",
    "msgModuleName": "deloris.schneider",
    "msgUserId": "12",
    "msgUserName": "deloris.schneider",
    "msgOrganId": "12",
    "msgOrganName": "deloris.schneider",
    "msgUrl": "www.lynn-stehr.co",
    "msgLabels": "r6gn7l",
    "msgContent": "ss37mp",
    "status": "xh7hhv",
    "opUserId": "12",
    "opTime": "2025-09-05 15:46:05",
    "opOrganId": "12",
    "opOrganName": "deloris.schneider",
    "description": "8kxj8i",
    "spare1": "c3vu6x",
    "spare2": "xvebt7"
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
  "data": "zrk0hl",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:46:05",
    "lastTime": "2025-09-05 15:46:05",
    "id": "12",
    "siteId": 39,
    "foreignId": "12",
    "type": "p1mnzq",
    "bizType": "nmbpnd",
    "msgCreateTime": "2025-09-05 15:46:05",
    "msgId": 408,
    "msgType": 606,
    "msgTitle": "lgvgtx",
    "msgAbstract": "gdjqn7",
    "msgAccountId": "12",
    "msgAccountName": "deloris.schneider",
    "msgModuleId": "12",
    "msgModuleName": "deloris.schneider",
    "msgUserId": "12",
    "msgUserName": "deloris.schneider",
    "msgOrganId": "12",
    "msgOrganName": "deloris.schneider",
    "msgUrl": "www.lynn-stehr.co",
    "msgLabels": "j0k0k5",
    "msgContent": "aj2mju",
    "status": "ppig7z",
    "opUserId": "12",
    "opTime": "2025-09-05 15:46:05",
    "opOrganId": "12",
    "opOrganName": "deloris.schneider",
    "description": "4d67zm",
    "spare1": "058djt",
    "spare2": "zqm8xa"
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
  "data": "9jh51k",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "wqi0ex",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/read/soe0p0.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "g6skfx",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/list.do?foreignId=12&todoProcessStatus=w0n3ek&spare2=oor89w&endTime=2025-09-05 15:44:42&todoLabels=nzgujl&todoName=deloris.schneider&startTime=2025-09-05 15:44:42&todoType=o83ui6&opTime=2025-09-05 15:46:06&id=12&spare1=eqa7v8&todoAccountId=12&todoUserId=12&status=90pde0&todoProcessName=deloris.schneider&bizType=6tpaae&siteId=905&opOrganName=deloris.schneider&creatorId=12&todoAccountName=deloris.schneider&todoModuleId=12&todoOrganName=deloris.schneider&todoCurrInfo=j2pqc4&page=1&type=7xyozc&todoModuleName=deloris.schneider&todoNextInfo=a0v0g2&opOrganId=12&description=r92wn7&todoProcessInfo=biq1lr&orderBy=188&todoId=12&todoOrganId=12&q=cyii5j&todoCreateTime=2025-09-05 15:46:06&todoAbstract=oqn3zh&todoUrl=www.lynn-stehr.co&limit=10&todoUserName=deloris.schneider&opUserId=12&todoContent=5j4fnn
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:46:06",
      "lastTime": "2025-09-05 15:46:06",
      "id": "12",
      "siteId": 230,
      "foreignId": "12",
      "type": "2fesji",
      "bizType": "9kfohi",
      "todoCreateTime": "2025-09-05 15:46:06",
      "todoId": "12",
      "todoType": "khcj3n",
      "todoName": "deloris.schneider",
      "todoAbstract": "cf7y6f",
      "todoAccountId": "12",
      "todoAccountName": "deloris.schneider",
      "todoModuleId": "12",
      "todoModuleName": "deloris.schneider",
      "todoUserId": "12",
      "todoUserName": "deloris.schneider",
      "todoOrganId": "12",
      "todoOrganName": "deloris.schneider",
      "todoProcessName": "deloris.schneider",
      "todoProcessStatus": "w13rbb",
      "todoProcessInfo": "c4o7mr",
      "todoCurrInfo": "0g9xey",
      "todoNextInfo": "9mmaxz",
      "todoUrl": "www.lynn-stehr.co",
      "todoLabels": "cs9o34",
      "todoContent": "hbiqdk",
      "status": "df8ull",
      "opUserId": "12",
      "opTime": "2025-09-05 15:46:06",
      "opOrganId": "12",
      "opOrganName": "deloris.schneider",
      "description": "gnlvgk",
      "spare1": "wn4wlt",
      "spare2": "acm1ej"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/export.do --data 'id=12&todoCurrInfo=go40x1&todoAccountName=deloris.schneider&todoNextInfo=prk6ny&todoId=12&todoType=0e9cx4&todoContent=28srvh&todoUserId=12&todoModuleName=deloris.schneider&orderBy=614&status=buykx4&foreignId=12&opTime=2025-09-05 15:46:06&opOrganId=12&spare1=9ffr2v&q=hvd4dy&todoProcessInfo=21z0cu&todoUrl=www.lynn-stehr.co&todoModuleId=12&todoCreateTime=2025-09-05 15:46:06&todoUserName=deloris.schneider&startTime=2025-09-05 15:44:42&page=1&opOrganName=deloris.schneider&todoAbstract=wx2whn&todoProcessName=deloris.schneider&endTime=2025-09-05 15:44:42&type=z9q00u&todoAccountId=12&limit=10&todoOrganId=12&todoProcessStatus=226ryw&bizType=qodooc&creatorId=12&description=mk5glr&todoLabels=nr0v7c&todoName=deloris.schneider&spare2=xbechr&siteId=317&opUserId=12&todoOrganName=deloris.schneider'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "7onvbv",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:46:06",
    "lastTime": "2025-09-05 15:46:06",
    "id": "12",
    "siteId": 651,
    "foreignId": "12",
    "type": "7sqilh",
    "bizType": "x2q9q4",
    "todoCreateTime": "2025-09-05 15:46:06",
    "todoId": "12",
    "todoType": "ya46p7",
    "todoName": "deloris.schneider",
    "todoAbstract": "5mnmc5",
    "todoAccountId": "12",
    "todoAccountName": "deloris.schneider",
    "todoModuleId": "12",
    "todoModuleName": "deloris.schneider",
    "todoUserId": "12",
    "todoUserName": "deloris.schneider",
    "todoOrganId": "12",
    "todoOrganName": "deloris.schneider",
    "todoProcessName": "deloris.schneider",
    "todoProcessStatus": "77qu8r",
    "todoProcessInfo": "n7le9i",
    "todoCurrInfo": "1h0f3n",
    "todoNextInfo": "vuljod",
    "todoUrl": "www.lynn-stehr.co",
    "todoLabels": "x3zpmw",
    "todoContent": "n6frlg",
    "status": "5o3ggu",
    "opUserId": "12",
    "opTime": "2025-09-05 15:46:06",
    "opOrganId": "12",
    "opOrganName": "deloris.schneider",
    "description": "e4kz54",
    "spare1": "v612aq",
    "spare2": "h1dxry"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:46:06",
    "lastTime": "2025-09-05 15:46:06",
    "id": "12",
    "siteId": 919,
    "foreignId": "12",
    "type": "1nigh8",
    "bizType": "j09p63",
    "todoCreateTime": "2025-09-05 15:46:06",
    "todoId": "12",
    "todoType": "ab4n6j",
    "todoName": "deloris.schneider",
    "todoAbstract": "lramig",
    "todoAccountId": "12",
    "todoAccountName": "deloris.schneider",
    "todoModuleId": "12",
    "todoModuleName": "deloris.schneider",
    "todoUserId": "12",
    "todoUserName": "deloris.schneider",
    "todoOrganId": "12",
    "todoOrganName": "deloris.schneider",
    "todoProcessName": "deloris.schneider",
    "todoProcessStatus": "n14e4k",
    "todoProcessInfo": "v3tcb2",
    "todoCurrInfo": "6pryw3",
    "todoNextInfo": "gatx0l",
    "todoUrl": "www.lynn-stehr.co",
    "todoLabels": "2z1qxt",
    "todoContent": "ky5xbz",
    "status": "si813w",
    "opUserId": "12",
    "opTime": "2025-09-05 15:46:06",
    "opOrganId": "12",
    "opOrganName": "deloris.schneider",
    "description": "7ptkwd",
    "spare1": "ibhunj",
    "spare2": "j1f7pl"
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
  "data": "0405tk",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:46:06",
    "lastTime": "2025-09-05 15:46:06",
    "id": "12",
    "siteId": 64,
    "foreignId": "12",
    "type": "lmgd75",
    "bizType": "s3rte1",
    "todoCreateTime": "2025-09-05 15:46:06",
    "todoId": "12",
    "todoType": "7f7eq9",
    "todoName": "deloris.schneider",
    "todoAbstract": "6aj21s",
    "todoAccountId": "12",
    "todoAccountName": "deloris.schneider",
    "todoModuleId": "12",
    "todoModuleName": "deloris.schneider",
    "todoUserId": "12",
    "todoUserName": "deloris.schneider",
    "todoOrganId": "12",
    "todoOrganName": "deloris.schneider",
    "todoProcessName": "deloris.schneider",
    "todoProcessStatus": "xfaxln",
    "todoProcessInfo": "vhcgqw",
    "todoCurrInfo": "k5siyp",
    "todoNextInfo": "mgy5kb",
    "todoUrl": "www.lynn-stehr.co",
    "todoLabels": "uvej0j",
    "todoContent": "sxgmay",
    "status": "brtc2m",
    "opUserId": "12",
    "opTime": "2025-09-05 15:46:06",
    "opOrganId": "12",
    "opOrganName": "deloris.schneider",
    "description": "2kmt0y",
    "spare1": "hd0wv1",
    "spare2": "myo5mn"
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
  "data": "nn9urg",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "zxsnbd",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "password": "nacjb3",
      "username": "deloris.schneider",
      "authorities": [
        {
          "object": "any object"
        }
      ],
      "adminId": 711,
      "userId": "12",
      "appId": "12",
      "deptId": 686,
      "organId": "12",
      "token": "cfzje0",
      "imagePath": "aihx2n",
      "isSuperAdmin": true,
      "loginIp": "188.87.89.33",
      "loginTime": 1757058282703,
      "loginBrowse": "77uv5x",
      "loginOs": "6tawwo",
      "expireTime": 1757058282703,
      "perms": [
        "gxpwbl"
      ]
    },
    "roleGroup": "yc44hk",
    "positionGroup": "zp33nq"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:50",
    "lastTime": "2025-09-05 15:45:50",
    "id": 472,
    "userId": "12",
    "deptId": 290,
    "deptName": "deloris.schneider",
    "organId": "12",
    "organName": "deloris.schneider",
    "name": "deloris.schneider",
    "username": "deloris.schneider",
    "nickName": "lon.nicolas",
    "email": "ralph.kerluke@hotmail.com",
    "mobile": "(682) 505-7451",
    "imagePath": "1hx8ha",
    "password": "0epkmi",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 519,
    "delFlag": 3,
    "lastLoginIp": "188.87.89.33",
    "lastLoginTime": "2025-09-05 15:45:50",
    "description": "c4tspo",
    "dept": {
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:50",
      "lastTime": "2025-09-05 15:45:50",
      "id": 972,
      "organId": "12",
      "parentId": 783,
      "appId": "12",
      "depttypeId": 582,
      "foreignId": "12",
      "createType": 969,
      "type": "habu0a",
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "areaCode": "17639",
      "organLeader": "76qobu",
      "leaderId": "12",
      "leaderMobile": "(682) 505-7451",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "17639",
      "imagePath": "oum6e6",
      "priority": 527,
      "status": 503,
      "delFlag": 3,
      "description": "cmbdjb",
      "spare1": "9oduaf",
      "spare2": "ka8pab",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:50",
        "lastTime": "2025-09-05 15:45:50",
        "id": 620,
        "roletypeId": "12",
        "appId": "12",
        "name": "deloris.schneider",
        "code": "17639",
        "priority": 979,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 987,
        "description": "cfm15v",
        "areaType": "99nk2v"
      }
    ],
    "roleIds": [
      298
    ],
    "positionIds": [
      "r4xo9d"
    ],
    "roleId": 771,
    "userRoleList": [
      {
        "id": 269,
        "deptId": 901,
        "deptName": "deloris.schneider",
        "organId": "12",
        "organName": "deloris.schneider",
        "roleId": 31,
        "roleName": "deloris.schneider",
        "adminId": 110
      }
    ],
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:50",
    "lastTime": "2025-09-05 15:45:50",
    "id": 352,
    "userId": "12",
    "deptId": 909,
    "deptName": "deloris.schneider",
    "organId": "12",
    "organName": "deloris.schneider",
    "name": "deloris.schneider",
    "username": "deloris.schneider",
    "nickName": "lon.nicolas",
    "email": "ralph.kerluke@hotmail.com",
    "mobile": "(682) 505-7451",
    "imagePath": "6hpnv6",
    "password": "tfzs98",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 900,
    "delFlag": 3,
    "lastLoginIp": "188.87.89.33",
    "lastLoginTime": "2025-09-05 15:45:50",
    "description": "kdwqq9",
    "dept": {
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:50",
      "lastTime": "2025-09-05 15:45:50",
      "id": 354,
      "organId": "12",
      "parentId": 705,
      "appId": "12",
      "depttypeId": 218,
      "foreignId": "12",
      "createType": 192,
      "type": "4vej5t",
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "areaCode": "17639",
      "organLeader": "fkmrbv",
      "leaderId": "12",
      "leaderMobile": "(682) 505-7451",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "17639",
      "imagePath": "474rdm",
      "priority": 314,
      "status": 20,
      "delFlag": 3,
      "description": "sgbs89",
      "spare1": "9qj9ft",
      "spare2": "5857y5",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:50",
        "lastTime": "2025-09-05 15:45:50",
        "id": 263,
        "roletypeId": "12",
        "appId": "12",
        "name": "deloris.schneider",
        "code": "17639",
        "priority": 503,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 802,
        "description": "wcgmzt",
        "areaType": "hjq4nf"
      }
    ],
    "roleIds": [
      462
    ],
    "positionIds": [
      "kvhemw"
    ],
    "roleId": 907,
    "userRoleList": [
      {
        "id": 132,
        "deptId": 688,
        "deptName": "deloris.schneider",
        "organId": "12",
        "organName": "deloris.schneider",
        "roleId": 333,
        "roleName": "deloris.schneider",
        "adminId": 591
      }
    ],
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
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
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "oldPassword": "llpcow",
    "newPassword": "okgf91"
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
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "imageUrl": "www.lynn-stehr.co"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/list.do?endTime=2025-09-05 15:44:42&isDisabled=true&limit=10&configValue=8t1e31&q=jolaai&configKey=52i6tr&startTime=2025-09-05 15:44:42&remark=efnlu1&page=1&orderBy=587
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
    "totalCount": 497,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "configId": "12",
        "configKey": "hhsw3f",
        "configValue": "8zttit",
        "isDisabled": true,
        "remark": "umfk8u"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/export.do --data 'configValue=8l2tzd&remark=rew8d0&q=179yw7&orderBy=827&configKey=o35bf0&limit=10&endTime=2025-09-05 15:44:42&isDisabled=true&startTime=2025-09-05 15:44:42&page=1'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "sr6wya",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/12.do
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
    "configId": "12",
    "configKey": "dqpemz",
    "configValue": "qifw3v",
    "isDisabled": true,
    "remark": "g7ez7j"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/configKey/gszuyz.do
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
    "configId": "12",
    "configKey": "umqgu4",
    "configValue": "qr9x7j",
    "isDisabled": true,
    "remark": "u9m0a1"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "configId": "12",
    "configKey": "hg97mz",
    "configValue": "w22kb9",
    "isDisabled": true,
    "remark": "zrgh8m"
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
  "data": "xcek3g",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "configId": "12",
    "configKey": "5jei9g",
    "configValue": "v1i82u",
    "isDisabled": true,
    "remark": "ycm7j0"
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
  "data": "sc5n9z",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "3a98c0",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "hmusj7",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/list.do?ipaddr=hti50w&username=deloris.schneider
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
      "tokenId": "12",
      "deptName": "deloris.schneider",
      "username": "deloris.schneider",
      "ipaddr": "p9s9q6",
      "loginLocation": "gnd7zr",
      "browser": "kw6e6r",
      "os": "oig3bb",
      "loginTime": 1757058282703
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/12.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ke70ot",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/list.do?typeMode=989&name=deloris.schneider&page=1&endTime=2025-09-05 15:44:42&key=y5yssg&orderBy=387&status=080spl&remark=6oy19i&limit=10&typeClass=azlnyy&startTime=2025-09-05 15:44:42&q=3r0m1t&typeId=12
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
    "totalCount": 554,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "typeId": "12",
        "name": "deloris.schneider",
        "typeClass": "1y8dot",
        "typeRef": "aaleg1",
        "typeMode": 953,
        "searchCode": "17639",
        "priority": 702,
        "createTime": "2025-09-05 15:46:03",
        "status": 506,
        "remark": "t911fj"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/export.do --data 'typeMode=647&status=18pqf4&typeClass=dhw6fb&page=1&q=f3muwt&limit=10&name=deloris.schneider&key=8lkyxh&orderBy=0&remark=tbrypm&startTime=2025-09-05 15:44:42&endTime=2025-09-05 15:44:42&typeId=12'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "c5yqnc",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/12.do
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
    "typeId": "12",
    "name": "deloris.schneider",
    "typeClass": "w8k5r0",
    "typeRef": "ye2wkj",
    "typeMode": 774,
    "searchCode": "17639",
    "priority": 212,
    "createTime": "2025-09-05 15:46:03",
    "status": 200,
    "remark": "hinb60"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "typeId": "12",
    "name": "deloris.schneider",
    "typeClass": "siviqk",
    "typeRef": "e67j5s",
    "typeMode": 573,
    "searchCode": "17639",
    "priority": 299,
    "createTime": "2025-09-05 15:46:03",
    "status": 675,
    "remark": "2ajo9r"
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
  "data": "t8no6l",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "typeId": "12",
    "name": "deloris.schneider",
    "typeClass": "madhza",
    "typeRef": "2zuwmd",
    "typeMode": 348,
    "searchCode": "17639",
    "priority": 909,
    "createTime": "2025-09-05 15:46:03",
    "status": 294,
    "remark": "oa7e6p"
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
  "data": "jgaxrh",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "cyhusn",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "6nkfgk",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "typeId": "12",
      "name": "deloris.schneider",
      "typeClass": "60cx76",
      "typeRef": "z0s7t4",
      "typeMode": 523,
      "searchCode": "17639",
      "priority": 423,
      "createTime": "2025-09-05 15:46:03",
      "status": 94,
      "remark": "pppr1l"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/list.do?page=1&postypeId=12&roleTypeId=12&posFunction=wsfp5t&endTime=2025-09-05 15:44:42&createTime=2025-09-05 15:44:42&isPub=true&name=deloris.schneider&mobilePhone=(947) 586-4732&officePhone=(947) 586-4732&status=17&oname=deloris.schneider&posRank=636&q=d1rhke&posType=6o1lvz&id=12&orderBy=285&ids=73h2kf&ids=73h2kf&parentId=12&sname=deloris.schneider&delFlag=3&code=17639&roletypeId=12&description=ic41vv&startTime=2025-09-05 15:44:42&positionId=12&limit=10&groupId=12
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
    "totalCount": 808,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "postId": "12",
        "postCode": "17639",
        "postName": "deloris.schneider",
        "postSort": 755,
        "status": 178,
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:53",
        "lastTime": "2025-09-05 15:45:53",
        "delFlag": 3,
        "remark": "zup2s5",
        "ids": [
          "oh7k29"
        ],
        "positionId": "12",
        "flag": true
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/export.do --data 'postCode=17639&status=187&delFlag=3&orderBy=500&q=aouqfe&endTime=2025-09-05 15:44:42&limit=10&page=1&postName=deloris.schneider&startTime=2025-09-05 15:44:42'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "b2pbdd",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/12.do
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:53",
    "lastTime": "2025-09-05 15:45:53",
    "id": "12",
    "parentId": "12",
    "postypeId": "12",
    "roletypeId": "12",
    "userId": "12",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "code": "17639",
    "oname": "deloris.schneider",
    "posFunction": "7l5dl7",
    "posRank": 429,
    "posType": "pa8tn5",
    "editorType": "amfy99",
    "isEditorCreate": true,
    "status": 931,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "12",
    "manageDeptids": "gfa3gh",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "(947) 586-4732",
    "officePhone": "(947) 586-4732",
    "buildingId": "12",
    "roomNo": "dsma1r",
    "extQmType": "eifr15",
    "extQmTypePhoto": "ohfo5g",
    "extPosName": "deloris.schneider",
    "extOrganName": "deloris.schneider",
    "priority": 665,
    "priorityInOrgan": 95,
    "priorityInDomain": 253,
    "updaterId": "12",
    "updateTime": "2025-09-05 15:45:53",
    "delFlag": 3,
    "description": "aa2rvc",
    "remark": "bw70xn"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:53",
    "lastTime": "2025-09-05 15:45:53",
    "id": "12",
    "parentId": "12",
    "postypeId": "12",
    "roletypeId": "12",
    "userId": "12",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "code": "17639",
    "oname": "deloris.schneider",
    "posFunction": "42gj0u",
    "posRank": 375,
    "posType": "3ykzvw",
    "editorType": "na0yg5",
    "isEditorCreate": true,
    "status": 869,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "12",
    "manageDeptids": "ion1ni",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "(947) 586-4732",
    "officePhone": "(947) 586-4732",
    "buildingId": "12",
    "roomNo": "dbi5wi",
    "extQmType": "33i4lt",
    "extQmTypePhoto": "gdsnq6",
    "extPosName": "deloris.schneider",
    "extOrganName": "deloris.schneider",
    "priority": 65,
    "priorityInOrgan": 446,
    "priorityInDomain": 735,
    "updaterId": "12",
    "updateTime": "2025-09-05 15:45:53",
    "delFlag": 3,
    "description": "so5vf0",
    "remark": "zu1hzk",
    "parentName": "deloris.schneider",
    "roletypeName": "deloris.schneider",
    "postypeName": "deloris.schneider"
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
  "data": "sg98dj",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:53",
    "lastTime": "2025-09-05 15:45:53",
    "id": "12",
    "parentId": "12",
    "postypeId": "12",
    "roletypeId": "12",
    "userId": "12",
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "code": "17639",
    "oname": "deloris.schneider",
    "posFunction": "9levnp",
    "posRank": 17,
    "posType": "q07ist",
    "editorType": "e8y9tt",
    "isEditorCreate": true,
    "status": 768,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "12",
    "manageDeptids": "tdu3jx",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "(947) 586-4732",
    "officePhone": "(947) 586-4732",
    "buildingId": "12",
    "roomNo": "6ko4s1",
    "extQmType": "78ossa",
    "extQmTypePhoto": "dr3fqn",
    "extPosName": "deloris.schneider",
    "extOrganName": "deloris.schneider",
    "priority": 829,
    "priorityInOrgan": 24,
    "priorityInDomain": 911,
    "updaterId": "12",
    "updateTime": "2025-09-05 15:45:53",
    "delFlag": 3,
    "description": "nqff3h",
    "remark": "sc8mv7",
    "parentName": "deloris.schneider",
    "roletypeName": "deloris.schneider",
    "postypeName": "deloris.schneider"
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
  "data": "iwnm1b",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "h187cs",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "postId": "12",
    "postCode": "17639",
    "postName": "deloris.schneider",
    "postSort": 656,
    "status": 632,
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:53",
    "lastTime": "2025-09-05 15:45:53",
    "delFlag": 3,
    "remark": "5gg5x6",
    "ids": [
      "jjal5q"
    ],
    "positionId": "12",
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
  "data": "5sm695",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "id": 222,
    "roleId": 797,
    "positionId": "12",
    "status": 915,
    "beginTime": "2025-09-05",
    "endTime": "2025-09-05"
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
  "data": "e3zqit",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "postId": "12",
      "postCode": "17639",
      "postName": "deloris.schneider",
      "postSort": 383,
      "status": 23,
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:54",
      "lastTime": "2025-09-05 15:45:54",
      "delFlag": 3,
      "remark": "dn5day",
      "ids": [
        "5i2ldl"
      ],
      "positionId": "12",
      "flag": true
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/list.do?srcCode=444&userId=12&username=deloris.schneider&createTime=2025-09-05 15:45:54&startTime=2025-09-05 15:44:42&orderBy=345&limit=10&appId=12&method=v0epmy&operation=3wozg4&q=d51a4a&time=1757058282703&endTime=2025-09-05 15:44:42&ip=188.87.89.33&page=1&category=760
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
    "totalCount": 290,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "operId": 126,
        "title": "pbw72b",
        "businessType": 215,
        "businessTypeName": "deloris.schneider",
        "businessTypes": [
          942
        ],
        "method": "cnj71f",
        "requestMethod": "yztum4",
        "operatorType": 99,
        "operName": "deloris.schneider",
        "deptName": "deloris.schneider",
        "operUrl": "www.lynn-stehr.co",
        "operIp": "188.87.89.33",
        "operLocation": "nppdgg",
        "operParam": "il2f6k",
        "jsonResult": "t0aihf",
        "status": 327,
        "errorMsg": "4rn1ep",
        "operTime": "2025-09-05 15:45:54",
        "costTime": 1757058282703,
        "remark": "dd912x"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/export.do --data 'title=e29qon&operIp=188.87.89.33&remark=9carct&limit=10&operId=666&operName=deloris.schneider&startTime=2025-09-05 15:44:42&deptName=deloris.schneider&orderBy=684&endTime=2025-09-05 15:44:42&businessType=33&operatorType=876&operTime=2025-09-05 15:45:54&status=499&q=roo71h&page=1'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "9fn5ci",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "5y7cch",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/list.do?page=1&dictSort=454&typeCode=17639&remark=37dh5i&orderBy=986&key=12kiej&startTime=2025-09-05 15:44:42&name=deloris.schneider&status=wz8kt2&parentId=907&dictLabel=57hn4n&cddValue=uzncyd&isDefault=304mto&endTime=2025-09-05 15:44:42&listClass=am5rz3&limit=10&cssClass=c5pmf1&searchCode=17639&cddId=705&q=8s3f5s
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
    "totalCount": 499,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cddId": 687,
        "typeCode": "17639",
        "parentId": 419,
        "name": "deloris.schneider",
        "sname": "deloris.schneider",
        "cddValue": "i816qj",
        "searchCode": "17639",
        "priority": 285,
        "createTime": "2025-09-05 15:46:02",
        "remark": "6vl22n",
        "dictLabel": "1su3nh",
        "typeCodeName": "deloris.schneider",
        "parentName": "deloris.schneider"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/export.do --data 'isDefault=gwa6s5&remark=c6w9cb&limit=10&typeCode=17639&status=kxjhv6&name=deloris.schneider&dictSort=194&q=lk69dj&page=1&listClass=9f0x4d&parentId=439&cddValue=yaig3b&orderBy=84&startTime=2025-09-05 15:44:42&cssClass=l5ktvk&searchCode=17639&cddId=795&key=a6s95f&endTime=2025-09-05 15:44:42&dictLabel=oveay0'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "jqr78k",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/558.do
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
    "cddId": 230,
    "typeCode": "17639",
    "parentId": 948,
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "cddValue": "ofbq4z",
    "searchCode": "17639",
    "priority": 89,
    "createTime": "2025-09-05 15:46:02",
    "remark": "4r85oz",
    "dictLabel": "1u9cvq",
    "typeCodeName": "deloris.schneider",
    "parentName": "deloris.schneider"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/type/7y0l7y.do?roletypeId=12&parentId=12&zparentId=12&typeCode=17639
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "cddId": 681,
    "typeCode": "17639",
    "parentId": 412,
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "cddValue": "uvmxmh",
    "searchCode": "17639",
    "priority": 145,
    "createTime": "2025-09-05 15:46:02",
    "remark": "7gwas8",
    "dictLabel": "b305hy",
    "typeCodeName": "deloris.schneider",
    "parentName": "deloris.schneider"
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
  "data": "ty72t2",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "cddId": 685,
    "typeCode": "17639",
    "parentId": 921,
    "name": "deloris.schneider",
    "sname": "deloris.schneider",
    "cddValue": "tzb0lb",
    "searchCode": "17639",
    "priority": 784,
    "createTime": "2025-09-05 15:46:02",
    "remark": "ikhnz3",
    "dictLabel": "631imi",
    "typeCodeName": "deloris.schneider",
    "parentName": "deloris.schneider"
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
  "data": "np7o76",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "ogmqja",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/comm/tree.do?status=4pp8at&startTime=2025-09-05 15:44:42&roletypeId=12&appId=12&groupId=12&roleId=12&gnType=971y9g&q=22rams&endTime=2025-09-05 15:44:42&refresh=4jwu3m&parentId=12&key=oel2e8&subType=2x2dk0&organwId=12&positionType=vh9aul&metaId=12&orderBy=96&type=de59zo&positionId=12&limit=10&wlType=cn82iu&refType=ehppkw&roleTypeId=12&page=1&showButton=fmvuh4
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
      "id": "12",
      "label": "54mokf",
      "shortName": "deloris.schneider",
      "organId": "12",
      "areaId": 663,
      "searchCode": "17639",
      "childNum": 316,
      "checked": true,
      "entity": 617,
      "show": true,
      "showIcon": true,
      "parentId": "12",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/tree.do?startTime=2025-09-05 15:44:42&cddValue=mjthew&endTime=2025-09-05 15:44:42&name=deloris.schneider&q=9giqrb&isAllChild=ko8mfy&delFlag=3&existKey=490h1w&cddLevel=ug21yd&sname=deloris.schneider&key=vh953c&description=tcuuvs&parentId=106&orderBy=463&typeMode=ksezwz&searchCode=17639&page=1&dispFlag=vcu0bl&limit=10&typeCode=17639&typeCodes=9axs63&typeCodes=9axs63&ids=qco1z4&ids=qco1z4
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:46:03",
      "lastTime": "2025-09-05 15:46:03",
      "id": 992,
      "typeCode": "17639",
      "parentId": 819,
      "name": "deloris.schneider",
      "sname": "deloris.schneider",
      "cddValue": "rvvne9",
      "cddLevel": "irlmc6",
      "searchCode": "17639",
      "dispFlag": "a9qyct",
      "priority": 676,
      "delFlag": 3,
      "deleteTime": "2025-09-05 15:46:03",
      "description": "7lu9xu",
      "spare1": "y4i1w1",
      "spare2": "4o82v2",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "cpuNum": 495,
      "total": 83.08,
      "sys": 76.20,
      "used": 1.36,
      "wait": 39.11,
      "free": 86.20
    },
    "mem": {
      "total": 25.87,
      "used": 56.89,
      "free": 48.57
    },
    "jvm": {
      "total": 80.81,
      "max": 32.44,
      "free": 13.54,
      "version": "3.90",
      "home": "2ki92m"
    },
    "sys": {
      "computerName": "deloris.schneider",
      "computerIp": "188.87.89.33",
      "userDir": "l2za33",
      "osName": "deloris.schneider",
      "osArch": "w2lq23"
    },
    "sysFiles": [
      {
        "dirName": "deloris.schneider",
        "sysTypeName": "deloris.schneider",
        "typeName": "deloris.schneider",
        "total": "85nizl",
        "free": "g8svqg",
        "used": "41oxxj",
        "usage": 4.06
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "username": "deloris.schneider",
    "password": "nqjrh3",
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47",
    "appId": "12"
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
  "data": "q7txvf",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "username": "deloris.schneider",
    "password": "4j0lf7",
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47",
    "appId": "12"
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
    "adminId": 573,
    "token": "vd41pq",
    "updateTime": "2025-09-05 15:45:51",
    "expireTime": "2025-09-05 15:45:51"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:51",
      "lastTime": "2025-09-05 15:45:51",
      "id": 481,
      "userId": "12",
      "deptId": 528,
      "deptName": "deloris.schneider",
      "organId": "12",
      "organName": "deloris.schneider",
      "name": "deloris.schneider",
      "username": "deloris.schneider",
      "nickName": "lon.nicolas",
      "email": "ralph.kerluke@hotmail.com",
      "mobile": "(682) 505-7451",
      "imagePath": "4ykyoc",
      "password": "uu81dx",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 280,
      "delFlag": 3,
      "lastLoginIp": "188.87.89.33",
      "lastLoginTime": "2025-09-05 15:45:51",
      "description": "0ot5x7",
      "dept": {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:51",
        "lastTime": "2025-09-05 15:45:51",
        "id": 711,
        "organId": "12",
        "parentId": 361,
        "appId": "12",
        "depttypeId": 635,
        "foreignId": "12",
        "createType": 565,
        "type": "wy1wcd",
        "name": "deloris.schneider",
        "sname": "deloris.schneider",
        "areaCode": "17639",
        "organLeader": "yrj44n",
        "leaderId": "12",
        "leaderMobile": "(682) 505-7451",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "17639",
        "imagePath": "ek7qsl",
        "priority": 678,
        "status": 924,
        "delFlag": 3,
        "description": "evpbpo",
        "spare1": "hhgbjq",
        "spare2": "sqxgmq",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "12",
          "createTime": "2025-09-05 15:45:51",
          "lastTime": "2025-09-05 15:45:51",
          "id": 602,
          "roletypeId": "12",
          "appId": "12",
          "name": "deloris.schneider",
          "code": "17639",
          "priority": 783,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 598,
          "description": "djc05m",
          "areaType": "1eo6zh"
        }
      ],
      "roleIds": [
        835
      ],
      "positionIds": [
        "up2tt7"
      ],
      "roleId": 15,
      "userRoleList": [
        {
          "id": 341,
          "deptId": 189,
          "deptName": "deloris.schneider",
          "organId": "12",
          "organName": "deloris.schneider",
          "roleId": 203,
          "roleName": "deloris.schneider",
          "adminId": 671
        }
      ],
      "code": "17639",
      "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
    },
    "roles": [
      "hxyj7i"
    ],
    "permissions": [
      "w3bs0v"
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "accountId": "12",
    "areaId": 111,
    "groupId": 678,
    "positionId": "12",
    "tplSolution": "d5nlup",
    "menuList": [
      {
        "id": 622,
        "parentId": 445,
        "name": "deloris.schneider",
        "ename": "deloris.schneider",
        "type": "gt63wn",
        "perms": "5ybvyq",
        "menuLevel": 586,
        "urlType": "fm5gcu",
        "url": "www.lynn-stehr.co",
        "menuSeq": "87qvti",
        "icon": "7lr58q",
        "imagePath": "np4p9m",
        "css": "hcpcmj",
        "description": "subqry",
        "todoTotalApi": "dri61i"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "id": "12",
    "isAdmin": true,
    "isEncryt": true,
    "publicKey": "9dujmb",
    "aesKey": "8m3zsy",
    "clientId": "12",
    "serverUrl": "www.lynn-stehr.co",
    "serverConf1": "x9ajp5",
    "appConf": {
      "siteId": 243,
      "appId": "12",
      "topXzqhId": "12",
      "appConfJson": {
        "mapKey": "g2zjbl"
      }
    },
    "isWork": true,
    "workConfig": {
      "layout": "bw1qfp",
      "siteInfo": {
        "id": 482,
        "appId": "12",
        "areaCode": "17639",
        "path": "kzutor",
        "name": "deloris.schneider",
        "sname": "deloris.schneider",
        "layout": "fwir83",
        "logoUrl": "www.lynn-stehr.co",
        "cdnUrl": "www.lynn-stehr.co"
      }
    }
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "username": "deloris.schneider",
    "password": "gz95ky",
    "code": "17639",
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47",
    "appId": "12"
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
    "adminId": 798,
    "token": "la4kaq",
    "updateTime": "2025-09-05 15:45:51",
    "expireTime": "2025-09-05 15:45:51"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -i https://linlan.net/eframe_backend/captcha/verify.do?uuid=d0e3bf3f-0921-41cf-a446-2ab6e687fc47&code=17639
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "89vpdk",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "cacheName": "deloris.schneider",
      "cacheKey": "r56nxe",
      "cacheValue": "yutbg6",
      "remark": "5agetb"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getKeys/deloris.schneider.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getValue/deloris.schneider/ro1wci.do
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
    "cacheName": "deloris.schneider",
    "cacheKey": "saki84",
    "cacheValue": "hdz36s",
    "remark": "bb1nn1"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheName/deloris.schneider.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "37tl1f",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheKey/1pb7f4.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "qc4ytk",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "mxqq4d",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/list.do?page=1&menuId=292&currAppId=12&endTime=2025-09-05 15:44:42&menuName=deloris.schneider&visible=g7isgc&parentId=22&status=5by4kh&startTime=2025-09-05 15:44:42&menuType=4q2kgo&limit=10&delFlag=e4vahe&orderBy=628&q=8461un
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
      "menuId": 170,
      "menuName": "deloris.schneider",
      "type": "m1n7gy",
      "typeName": "deloris.schneider",
      "parentName": "deloris.schneider",
      "parentId": 706,
      "priority": 609,
      "path": "we19bn",
      "component": "50q4fj",
      "query": "bvdpyt",
      "routeName": "deloris.schneider",
      "isFrame": "e8jlue",
      "isCache": "oh79g6",
      "menuType": "0hmu61",
      "menuTypeName": "deloris.schneider",
      "visible": "zl36m5",
      "status": "uo9san",
      "perms": "i5ntiy",
      "icon": "br7xet",
      "imagePath": "0cw8kj",
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:51",
      "lastTime": "2025-09-05 15:45:51",
      "children": [
        {
          "$ref": ".."
        }
      ],
      "childNum": 962,
      "description": "rsa2mz",
      "listJson": "k3oy41",
      "delFlag": 3,
      "permsList": [
        {
          "permsName": "deloris.schneider",
          "permsStr": "k5bqq3"
        }
      ],
      "buttonMenuList": [
        {
          "id": "12",
          "parentId": "12",
          "code": "17639",
          "name": "deloris.schneider"
        }
      ]
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/page.do?delFlag=mkzyjp&orderBy=426&menuId=752&menuType=fy12oy&q=lzybuu&startTime=2025-09-05 15:44:42&limit=10&visible=c60e8a&status=01wmlr&page=1&menuName=deloris.schneider&parentId=10&currAppId=12&endTime=2025-09-05 15:44:42
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
    "stackTrace": "sz0htb",
    "pageNum": 849,
    "pageSize": 10,
    "startRow": 131,
    "endRow": 848,
    "total": 999,
    "pages": 988,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "lrcj1n",
    "orderBy": "5p8rts",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "744k6i",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/115.do
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
    "menuId": 435,
    "menuName": "deloris.schneider",
    "type": "stsn5z",
    "typeName": "deloris.schneider",
    "parentName": "deloris.schneider",
    "parentId": 549,
    "priority": 313,
    "path": "v0ma5m",
    "component": "odhh8l",
    "query": "o9wc6p",
    "routeName": "deloris.schneider",
    "isFrame": "nbwbmo",
    "isCache": "ax8zpt",
    "menuType": "6umze5",
    "menuTypeName": "deloris.schneider",
    "visible": "lb7gk4",
    "status": "idgg9y",
    "perms": "muao1s",
    "icon": "09b5xo",
    "imagePath": "eevote",
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:51",
    "lastTime": "2025-09-05 15:45:51",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 806,
    "description": "ajcdoh",
    "listJson": "azzboe",
    "delFlag": 3,
    "permsList": [
      {
        "permsName": "deloris.schneider",
        "permsStr": "d1e4is"
      }
    ],
    "buttonMenuList": [
      {
        "id": "12",
        "parentId": "12",
        "code": "17639",
        "name": "deloris.schneider"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeselect.do?menuName=deloris.schneider&page=1&status=h6r41g&parentId=316&orderBy=572&delFlag=71zhiv&menuId=179&currAppId=12&limit=10&visible=g170wz&startTime=2025-09-05 15:44:42&q=jfe7ra&endTime=2025-09-05 15:44:42&menuType=8lbfl0
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
      538
    ],
    "menus": [
      {
        "id": 998,
        "label": "db3rg2",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeInit.do?isProtect=true&parentNull=u5425f&parentId=421&appId=12&endTime=2025-09-05 15:44:42&imagePath=hnb37p&typeNoButton=ecorju&name=deloris.schneider&q=82l0o8&isDisabled=true&page=1&url=www.lynn-stehr.co&offset=1&startTime=2025-09-05 15:44:42&type=41sp24&menuLevel=763&subCount=122&icon=lv62i3&shortCut=f0akbr&isDisplay=true&description=5y00ty&urlType=3e0pln&appIds=53pbvo&appIds=53pbvo&menuIds=k792lk&menuIds=k792lk&parentRoot=7ot2vy&orderBy=3&spare1=g6c21u&popPosition=859&isMenuAll=bm7w6u&createTime=2025-09-05 15:44:42&limit=10&spare2=fl2j3o&isCheck=true&code=17639&delFlag=3
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
      "title": "816me0",
      "id": "12",
      "parentId": "12",
      "extId": "12",
      "href": "ippmoa",
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
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/roleMenuTreeselect/607.do
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
      245
    ],
    "menus": [
      {
        "id": 372,
        "label": "op4sgn",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "menuId": 22,
    "menuName": "deloris.schneider",
    "type": "cluia5",
    "typeName": "deloris.schneider",
    "parentName": "deloris.schneider",
    "parentId": 517,
    "priority": 400,
    "path": "mojn8k",
    "component": "zr7ypp",
    "query": "rizz8i",
    "routeName": "deloris.schneider",
    "isFrame": "awmmk4",
    "isCache": "ys2tdr",
    "menuType": "onxeue",
    "menuTypeName": "deloris.schneider",
    "visible": "ojkfa9",
    "status": "clbboj",
    "perms": "96w88j",
    "icon": "9qj7oz",
    "imagePath": "rl2yk2",
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:51",
    "lastTime": "2025-09-05 15:45:51",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 162,
    "description": "f87kr5",
    "listJson": "umnfah",
    "delFlag": 3,
    "permsList": [
      {
        "permsName": "deloris.schneider",
        "permsStr": "in3iy3"
      }
    ],
    "buttonMenuList": [
      {
        "id": "12",
        "parentId": "12",
        "code": "17639",
        "name": "deloris.schneider"
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
  "data": "poarre",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "menuId": 501,
    "menuName": "deloris.schneider",
    "type": "52hzw3",
    "typeName": "deloris.schneider",
    "parentName": "deloris.schneider",
    "parentId": 140,
    "priority": 191,
    "path": "qkaef6",
    "component": "fesu25",
    "query": "gnujwb",
    "routeName": "deloris.schneider",
    "isFrame": "viege5",
    "isCache": "f32uav",
    "menuType": "ss5v40",
    "menuTypeName": "deloris.schneider",
    "visible": "a3nenl",
    "status": "y1buhr",
    "perms": "1r92zx",
    "icon": "rtcdd7",
    "imagePath": "vd83st",
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 124,
    "description": "zi5fj7",
    "listJson": "hqbr7k",
    "delFlag": 3,
    "permsList": [
      {
        "permsName": "deloris.schneider",
        "permsStr": "h3k7if"
      }
    ],
    "buttonMenuList": [
      {
        "id": "12",
        "parentId": "12",
        "code": "17639",
        "name": "deloris.schneider"
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
  "data": "4w7k4v",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "menuId": 910,
    "menuName": "deloris.schneider",
    "type": "xglefn",
    "typeName": "deloris.schneider",
    "parentName": "deloris.schneider",
    "parentId": 690,
    "priority": 4,
    "path": "paoa1x",
    "component": "xfv476",
    "query": "r6dgeq",
    "routeName": "deloris.schneider",
    "isFrame": "4muts3",
    "isCache": "lk62lb",
    "menuType": "uvef69",
    "menuTypeName": "deloris.schneider",
    "visible": "154ekl",
    "status": "w5v2xd",
    "perms": "xnpalb",
    "icon": "5kc64c",
    "imagePath": "od5pwd",
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 125,
    "description": "srfg7b",
    "listJson": "buil7u",
    "delFlag": 3,
    "permsList": [
      {
        "permsName": "deloris.schneider",
        "permsStr": "o7ecnv"
      }
    ],
    "buttonMenuList": [
      {
        "id": "12",
        "parentId": "12",
        "code": "17639",
        "name": "deloris.schneider"
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
  "data": "3wt3e3",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "menuId": 138,
    "menuName": "deloris.schneider",
    "type": "akpuhr",
    "typeName": "deloris.schneider",
    "parentName": "deloris.schneider",
    "parentId": 934,
    "priority": 523,
    "path": "74oees",
    "component": "7e2scm",
    "query": "iycrmb",
    "routeName": "deloris.schneider",
    "isFrame": "3kb4pa",
    "isCache": "unkau0",
    "menuType": "0v89lj",
    "menuTypeName": "deloris.schneider",
    "visible": "lgmonw",
    "status": "vyibuf",
    "perms": "e6co92",
    "icon": "idaf7c",
    "imagePath": "5wcvvk",
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 465,
    "description": "urknbv",
    "listJson": "l87tsr",
    "delFlag": 3,
    "permsList": [
      {
        "permsName": "deloris.schneider",
        "permsStr": "zx50hg"
      }
    ],
    "buttonMenuList": [
      {
        "id": "12",
        "parentId": "12",
        "code": "17639",
        "name": "deloris.schneider"
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
  "data": "gqvyfc",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "6mjwge",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "id": 178,
    "parentId": 80,
    "appId": "12",
    "name": "deloris.schneider",
    "ename": "deloris.schneider",
    "sname": "deloris.schneider",
    "isProtect": true,
    "type": "bs0v82",
    "userId": "12",
    "code": "17639",
    "menuLevel": 166,
    "subCount": 565,
    "perms": "i1qtj4",
    "urlType": "9tlh8p",
    "url": "www.lynn-stehr.co",
    "icon": "9mkalz",
    "popPosition": 637,
    "imagePath": "m8uzcv",
    "css": "h9dtk3",
    "jsEvent": "u0fiff",
    "menuSeq": "5y234s",
    "shortCut": "5yj9vk",
    "isLeaf": true,
    "isDisplay": true,
    "isDisabled": true,
    "isCheck": true,
    "priority": 928,
    "delFlag": 3,
    "deleteTime": "2025-09-05 15:45:52",
    "description": "1pdsze",
    "spare1": "lcpwem",
    "spare2": "kavo0b",
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
  "data": "c0arr9",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/list.do?roleName=deloris.schneider&roleKey=0c4061&roleId=492&limit=10&q=t47e27&endTime=2025-09-05 15:44:42&page=1&orderBy=5&startTime=2025-09-05 15:44:42&status=853
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:52",
      "lastTime": "2025-09-05 15:45:52",
      "roleId": 418,
      "roleName": "deloris.schneider",
      "roleKey": "8w2ewh",
      "roleSort": 299,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 744,
      "flag": true,
      "menuIds": [
        867
      ],
      "deptIds": [
        504
      ],
      "permissions": [
        "wr4ynq"
      ],
      "remark": "9i13l8",
      "parentName": "deloris.schneider",
      "appName": "deloris.schneider",
      "roletypeId": "12",
      "roletypeName": "deloris.schneider",
      "priority": 998,
      "isSuper": true
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/export.do --data 'limit=10&roleName=deloris.schneider&startTime=2025-09-05 15:44:42&status=790&endTime=2025-09-05 15:44:42&q=hqiead&orderBy=227&page=1&roleKey=43f3sl&roleId=283'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "wh1wu9",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/515.do
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "roleId": 637,
    "roleName": "deloris.schneider",
    "roleKey": "t9xqtl",
    "roleSort": 473,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 575,
    "flag": true,
    "menuIds": [
      585
    ],
    "deptIds": [
      494
    ],
    "permissions": [
      "boqurs"
    ],
    "remark": "ku9tdx",
    "parentName": "deloris.schneider",
    "appName": "deloris.schneider",
    "roletypeId": "12",
    "roletypeName": "deloris.schneider",
    "priority": 145,
    "isSuper": true
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "roleId": 37,
    "roleName": "deloris.schneider",
    "roleKey": "bzpcdm",
    "roleSort": 398,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 510,
    "flag": true,
    "menuIds": [
      515
    ],
    "deptIds": [
      790
    ],
    "permissions": [
      "l5097s"
    ],
    "remark": "hi18ab",
    "parentName": "deloris.schneider",
    "appName": "deloris.schneider",
    "roletypeId": "12",
    "roletypeName": "deloris.schneider",
    "priority": 565,
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
  "data": "vh92we",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "roleId": 772,
    "roleName": "deloris.schneider",
    "roleKey": "pupauk",
    "roleSort": 829,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 974,
    "flag": true,
    "menuIds": [
      412
    ],
    "deptIds": [
      724
    ],
    "permissions": [
      "90g228"
    ],
    "remark": "9xgzjr",
    "parentName": "deloris.schneider",
    "appName": "deloris.schneider",
    "roletypeId": "12",
    "roletypeName": "deloris.schneider",
    "priority": 290,
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
  "data": "bjbfqj",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "roleId": 941,
    "roleName": "deloris.schneider",
    "roleKey": "7cfmec",
    "roleSort": 676,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 512,
    "flag": true,
    "menuIds": [
      684
    ],
    "deptIds": [
      426
    ],
    "permissions": [
      "7oeox3"
    ],
    "remark": "wdv73w",
    "parentName": "deloris.schneider",
    "appName": "deloris.schneider",
    "roletypeId": "12",
    "roletypeName": "deloris.schneider",
    "priority": 269,
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
  "data": "55tti0",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "roleId": 823,
    "roleName": "deloris.schneider",
    "roleKey": "cb1arq",
    "roleSort": 844,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 859,
    "flag": true,
    "menuIds": [
      566
    ],
    "deptIds": [
      414
    ],
    "permissions": [
      "zhx3ui"
    ],
    "remark": "sec4ia",
    "parentName": "deloris.schneider",
    "appName": "deloris.schneider",
    "roletypeId": "12",
    "roletypeName": "deloris.schneider",
    "priority": 469,
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
  "data": "kk580c",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "f79r4x",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "id": 790,
    "roletypeId": "12",
    "appId": "12",
    "name": "deloris.schneider",
    "code": "17639",
    "priority": 749,
    "isRegular": true,
    "isSuper": true,
    "isPublic": true,
    "status": 77,
    "description": "np4agu",
    "areaType": "7ahimb"
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
  "data": "tv24m8",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "roleId": 669,
    "roleName": "deloris.schneider",
    "roleKey": "peswf4",
    "roleSort": 786,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 822,
    "flag": true,
    "menuIds": [
      439
    ],
    "deptIds": [
      827
    ],
    "permissions": [
      "es2o01"
    ],
    "remark": "8vei8v",
    "parentName": "deloris.schneider",
    "appName": "deloris.schneider",
    "roletypeId": "12",
    "roletypeName": "deloris.schneider",
    "priority": 952,
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
  "data": "geiiw5",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "creatorId": "12",
    "createTime": "2025-09-05 15:45:52",
    "lastTime": "2025-09-05 15:45:52",
    "roleId": 264,
    "roleName": "deloris.schneider",
    "roleKey": "uu6rfd",
    "roleSort": 275,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 246,
    "flag": true,
    "menuIds": [
      397
    ],
    "deptIds": [
      397
    ],
    "permissions": [
      "c847hf"
    ],
    "remark": "3lr275",
    "parentName": "deloris.schneider",
    "appName": "deloris.schneider",
    "roletypeId": "12",
    "roletypeName": "deloris.schneider",
    "priority": 699,
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
  "data": "7xool5",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:52",
      "lastTime": "2025-09-05 15:45:52",
      "roleId": 540,
      "roleName": "deloris.schneider",
      "roleKey": "1q1p4i",
      "roleSort": 282,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 70,
      "flag": true,
      "menuIds": [
        877
      ],
      "deptIds": [
        473
      ],
      "permissions": [
        "dbo24l"
      ],
      "remark": "05l8np",
      "parentName": "deloris.schneider",
      "appName": "deloris.schneider",
      "roletypeId": "12",
      "roletypeName": "deloris.schneider",
      "priority": 396,
      "isSuper": true
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/allocatedList.do?orderBy=165&status=pkdart&page=1&nickName=lon.nicolas&adminId=779&userId=12&endTime=2025-09-05 15:44:42&delFlag=3&email=ralph.kerluke@hotmail.com&startTime=2025-09-05 15:44:42&organId=12&username=deloris.schneider&deptId=808&limit=10&mobile=(682) 505-7451&q=5lykxb
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:52",
      "lastTime": "2025-09-05 15:45:52",
      "id": 299,
      "userId": "12",
      "deptId": 226,
      "deptName": "deloris.schneider",
      "organId": "12",
      "organName": "deloris.schneider",
      "name": "deloris.schneider",
      "username": "deloris.schneider",
      "nickName": "lon.nicolas",
      "email": "ralph.kerluke@hotmail.com",
      "mobile": "(682) 505-7451",
      "imagePath": "miavh0",
      "password": "lfbtp6",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 362,
      "delFlag": 3,
      "lastLoginIp": "188.87.89.33",
      "lastLoginTime": "2025-09-05 15:45:52",
      "description": "bps1o7",
      "dept": {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:52",
        "lastTime": "2025-09-05 15:45:52",
        "id": 900,
        "organId": "12",
        "parentId": 556,
        "appId": "12",
        "depttypeId": 900,
        "foreignId": "12",
        "createType": 242,
        "type": "x3jg22",
        "name": "deloris.schneider",
        "sname": "deloris.schneider",
        "areaCode": "17639",
        "organLeader": "3yrsya",
        "leaderId": "12",
        "leaderMobile": "(682) 505-7451",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "17639",
        "imagePath": "livgiq",
        "priority": 169,
        "status": 473,
        "delFlag": 3,
        "description": "2bvyi5",
        "spare1": "sutrlt",
        "spare2": "avpr88",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "12",
          "createTime": "2025-09-05 15:45:52",
          "lastTime": "2025-09-05 15:45:52",
          "id": 806,
          "roletypeId": "12",
          "appId": "12",
          "name": "deloris.schneider",
          "code": "17639",
          "priority": 530,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 606,
          "description": "0zu6gn",
          "areaType": "cnldkv"
        }
      ],
      "roleIds": [
        123
      ],
      "positionIds": [
        "xycjqf"
      ],
      "roleId": 903,
      "userRoleList": [
        {
          "id": 237,
          "deptId": 13,
          "deptName": "deloris.schneider",
          "organId": "12",
          "organName": "deloris.schneider",
          "roleId": 912,
          "roleName": "deloris.schneider",
          "adminId": 375
        }
      ],
      "code": "17639",
      "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/unallocatedList.do?userId=12&status=0krem0&deptId=687&username=deloris.schneider&orderBy=221&adminId=984&organId=12&email=ralph.kerluke@hotmail.com&q=dxasea&limit=10&endTime=2025-09-05 15:44:42&page=1&startTime=2025-09-05 15:44:42&mobile=(682) 505-7451&nickName=lon.nicolas&delFlag=3
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
      "creatorId": "12",
      "createTime": "2025-09-05 15:45:52",
      "lastTime": "2025-09-05 15:45:52",
      "id": 940,
      "userId": "12",
      "deptId": 830,
      "deptName": "deloris.schneider",
      "organId": "12",
      "organName": "deloris.schneider",
      "name": "deloris.schneider",
      "username": "deloris.schneider",
      "nickName": "lon.nicolas",
      "email": "ralph.kerluke@hotmail.com",
      "mobile": "(682) 505-7451",
      "imagePath": "m37m5z",
      "password": "9j55wm",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 132,
      "delFlag": 3,
      "lastLoginIp": "188.87.89.33",
      "lastLoginTime": "2025-09-05 15:45:52",
      "description": "5b2wx4",
      "dept": {
        "creatorId": "12",
        "createTime": "2025-09-05 15:45:52",
        "lastTime": "2025-09-05 15:45:52",
        "id": 914,
        "organId": "12",
        "parentId": 268,
        "appId": "12",
        "depttypeId": 398,
        "foreignId": "12",
        "createType": 310,
        "type": "gc68fo",
        "name": "deloris.schneider",
        "sname": "deloris.schneider",
        "areaCode": "17639",
        "organLeader": "p33kaw",
        "leaderId": "12",
        "leaderMobile": "(682) 505-7451",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "17639",
        "imagePath": "zuv0za",
        "priority": 464,
        "status": 466,
        "delFlag": 3,
        "description": "e9m6ff",
        "spare1": "tqpy7d",
        "spare2": "dqa22y",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "12",
          "createTime": "2025-09-05 15:45:52",
          "lastTime": "2025-09-05 15:45:52",
          "id": 813,
          "roletypeId": "12",
          "appId": "12",
          "name": "deloris.schneider",
          "code": "17639",
          "priority": 818,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 598,
          "description": "p1k2id",
          "areaType": "rxyy6m"
        }
      ],
      "roleIds": [
        769
      ],
      "positionIds": [
        "ranfz3"
      ],
      "roleId": 142,
      "userRoleList": [
        {
          "id": 629,
          "deptId": 847,
          "deptName": "deloris.schneider",
          "organId": "12",
          "organName": "deloris.schneider",
          "roleId": 142,
          "roleName": "deloris.schneider",
          "adminId": 295
        }
      ],
      "code": "17639",
      "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "id": 322,
    "roleId": 142,
    "adminId": 585
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
  "data": "pu7dmi",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X PUT -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/cancelAll.do --data 'adminIds=ai2uhc&adminIds=ai2uhc&roleId=952'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "odi9lf",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X PUT -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/selectAll.do --data 'adminIds=20f4y1&adminIds=20f4y1&roleId=651'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "l213it",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/deptTree/356.do
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
      558
    ],
    "depts": [
      {
        "id": 41,
        "label": "5qbuuw",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/list.do?cfgKey=0mqrpc&q=qdzq87&endTime=2025-09-05 15:44:42&startTime=2025-09-05 15:44:42&orderBy=847&ids=1g8xsx&ids=1g8xsx&limit=10&page=1&cfgValue=s5aedv
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
    "totalCount": 261,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cfgKey": "svj1ps",
        "cfgValue": "b3tmty"
      }
    ]
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/export.do --data 'limit=10&orderBy=172&q=vc73ec&cfgKey=8p7dux&ids=2fq5fr&ids=2fq5fr&endTime=2025-09-05 15:44:42&startTime=2025-09-05 15:44:42&page=1&cfgValue=lph4pv'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "t6gzhc",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/1sl50h.do
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
    "cfgKey": "roiki9",
    "cfgValue": "kgb6y0"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "cfgKey": "9oqy06",
    "cfgValue": "vrfcdj"
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
  "data": "m5cuju",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "cfgKey": "ymrsb5",
    "cfgValue": "s3197l"
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
  "data": "79nuyt",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "xv3658",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "6sckyk",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
  "data": "xbblv0",
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/application.do?orderBy=506&q=c3npfr&limit=10&endTime=2025-09-05 15:44:42&page=1&startTime=2025-09-05 15:44:42
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
      "organNum": "un1fma",
      "deptNum": "48pjfq",
      "peopleNum": "v4cle3",
      "roleNum": "mvih6k",
      "dicTypeNum": "1ctsw9",
      "appNum": "lod8gk",
      "fileNum": "79sa81",
      "paramNum": "9be6pz"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/element.do?startTime=2025-09-05 15:44:42&q=oqwhpu&page=1&endTime=2025-09-05 15:44:42&limit=10&orderBy=951
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
      "objectNum": "pp7z5v",
      "modelNum": "9c405a"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/manage.do?limit=10&orderBy=835&endTime=2025-09-05 15:44:42&startTime=2025-09-05 15:44:42&page=1&q=avv8ys
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
      "siteNum": "q40oqy",
      "accountNum": "mbtp7c",
      "serviceOrganNum": "h1guf2"
    }
  ],
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47",
    "img": "uk8ud3",
    "code": "17639"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
    "uuid": "d0e3bf3f-0921-41cf-a446-2ab6e687fc47",
    "img": "jca5ot",
    "code": "17639"
  },
  "requestId": "12",
  "timestamp": "2025-09-05 15:44:42"
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
