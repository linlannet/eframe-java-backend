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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─any object|object|any object.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "mapKey": {
      "waring": "You may use java.util.Object for Map value; doc-generate can't be handle."
    }
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

# 一体化平台接口API
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/list.do?resclassId=95&startTime=2026-03-09 00:08:33&refId=95&key=m7vy3e&q=631p7z&limit=10&orderBy=698&fileSize=975&fileIsvalid=true&appId=95&page=1&refType=n3w8w5&fileExtension=oyw3uq&endTime=2026-03-09 00:08:33&fileName=julian.ortiz
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 659,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "id": "95",
        "resclassId": "95",
        "fileName": "julian.ortiz",
        "fileIsvalid": true,
        "createTime": "2026-03-09 00:09:53",
        "fileExtension": "twxsja",
        "ids": [
          "saxa4l"
        ]
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/export.do --data 'writer.formatter.lastException.detailMessage=success&q=8v79k7&characterEncoding=v36t6u&fileName=julian.ortiz&appId=95&writer.writeBuffer=3&writer.writeBuffer=3&writer.psOut.closed=true&writer.psOut.autoFlush=true&refType=sri6iw&page=1&writer.psOut.closing=true&startTime=2026-03-09 00:08:33&committed=true&fileExtension=kdc3mq&key=lxinpg&writer.psOut.formatter.zero=9&writer.psOut.textOut.nextChar=280&writer.psOut.trouble=true&orderBy=135&writer.formatter.zero=s&status=108&contentType=zay4kg&writer.trouble=true&endTime=2026-03-09 00:08:33&writer.psOut.textOut.nChars=165&limit=10&bufferSize=10&resclassId=95&fileIsvalid=true&writer.autoFlush=true&refId=95&fileSize=220'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "01kx96",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/info.do?id=95
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "id": "95",
    "resclassId": "95",
    "fileName": "julian.ortiz",
    "fileIsvalid": true,
    "createTime": "2026-03-09 00:09:53",
    "fileExtension": "pbkzdw",
    "ids": [
      "9l7y6q"
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
id|string|文件路径|false|-
resclassId|string|资源种类ID|false|-
fileName|string|文件名称|false|-
fileIsvalid|boolean|是否有效|false|-
createTime|string|创建时间|false|-
fileExtension|string|创建时间|false|-
ids|array|数组|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/save.do --data '{
  "id": "95",
  "resclassId": "95",
  "fileName": "julian.ortiz",
  "fileIsvalid": true,
  "createTime": "2026-03-09 00:09:53",
  "fileExtension": "krg4zk",
  "ids": [
    "ahxy33"
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "rxhsme",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
id|string|文件路径|false|-
resclassId|string|资源种类ID|false|-
fileName|string|文件名称|false|-
fileIsvalid|boolean|是否有效|false|-
createTime|string|创建时间|false|-
fileExtension|string|创建时间|false|-
ids|array|数组|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/update.do --data '{
  "id": "95",
  "resclassId": "95",
  "fileName": "julian.ortiz",
  "fileIsvalid": true,
  "createTime": "2026-03-09 00:09:54",
  "fileExtension": "qm3te8",
  "ids": [
    "s4xsvf"
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "c9suu4",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
id|string|文件路径|false|-
resclassId|string|资源种类ID|false|-
fileName|string|文件名称|false|-
fileIsvalid|boolean|是否有效|false|-
createTime|string|创建时间|false|-
fileExtension|string|创建时间|false|-
ids|array|数组|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/delete.do --data '{
  "id": "95",
  "resclassId": "95",
  "fileName": "julian.ortiz",
  "fileIsvalid": true,
  "createTime": "2026-03-09 00:09:54",
  "fileExtension": "i50qqi",
  "ids": [
    "4qtqf6"
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "1c2i7s",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "02lyai",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
method|string|No comments found.|false|-
userPrincipal|object|No comments found.|false|-
└─name|string|No comments found.|false|-
session|object|No comments found.|false|-
└─id|string|No comments found.|false|-
└─creationTime|int64|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─lastAccessedTime|int64|No comments found.|false|-
└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
└─new|boolean|No comments found.|false|-
└─maxInactiveInterval|int32|No comments found.|false|-
headerNames|object|No comments found.|false|-
trailerFields|map|No comments found.|false|-
└─any object|object|any object.|false|-
requestURI|string|No comments found.|false|-
pathTranslated|string|No comments found.|false|-
remoteUser|string|No comments found.|false|-
requestURL|object|No comments found.|false|-
└─empty|boolean|No comments found.|false|-
└─value|array|No comments found.|false|-
└─coder|int8|No comments found.|false|-
└─count|int32|No comments found.|false|-
authType|string|No comments found.|false|-
queryString|string|No comments found.|false|-
servletPath|string|No comments found.|false|-
contextPath|string|No comments found.|false|-
pathInfo|string|No comments found.|false|-
parts|array|No comments found.|false|-
requestedSessionIdValid|boolean|No comments found.|false|-
httpServletMapping|object|No comments found.|false|-
└─pattern|string|No comments found.|false|-
└─mappingMatch|enum|null<br/>CONTEXT_ROOT<br/>DEFAULT<br/>EXACT<br/>EXTENSION<br/>PATH<br/>|false|-
└─servletName|string|No comments found.|false|-
└─matchValue|string|No comments found.|false|-
requestedSessionIdFromCookie|boolean|No comments found.|false|-
trailerFieldsReady|boolean|No comments found.|false|-
requestedSessionIdFromURL|boolean|No comments found.|false|-
requestedSessionId|string|No comments found.|false|-
cookies|array|No comments found.|false|-
└─name|string|No comments found.|false|-
└─value|string|No comments found.|false|-
└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
scheme|string|No comments found.|false|-
inputStream|object|No comments found.|false|-
protocol|string|No comments found.|false|-
locale|object|No comments found.|false|-
contentLength|int32|No comments found.|false|-
contentLengthLong|int64|No comments found.|false|-
contentType|string|No comments found.|false|-
localName|string|No comments found.|false|-
attributeNames|object|No comments found.|false|-
parameterMap|map|No comments found.|false|-
└─any object|object|any object.|false|-
reader|object|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─skipBuffer|array|No comments found.|false|-
└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
└─cb|array|No comments found.|false|-
└─nChars|int32|No comments found.|false|-
└─nextChar|int32|No comments found.|false|-
└─markedChar|int32|No comments found.|false|-
└─readAheadLimit|int32|No comments found.|false|-
└─skipLF|boolean|No comments found.|false|-
└─markedSkipLF|boolean|No comments found.|false|-
parameterNames|object|No comments found.|false|-
requestId|string|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
serverName|string|No comments found.|false|-
locales|object|No comments found.|false|-
dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
servletContext|object|No comments found.|false|-
└─classLoader|object|No comments found.|false|-
└─majorVersion|int32|No comments found.|false|-
└─minorVersion|int32|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─effectiveMajorVersion|int32|No comments found.|false|-
└─effectiveMinorVersion|int32|No comments found.|false|-
└─initParameterNames|object|No comments found.|false|-
└─servletContextName|string|No comments found.|false|-
└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
└─defaultSessionTrackingModes|array|No comments found.|false|-
└─responseCharacterEncoding|string|No comments found.|false|-
└─virtualServerName|string|No comments found.|false|-
└─effectiveSessionTrackingModes|array|No comments found.|false|-
└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─requestCharacterEncoding|string|No comments found.|false|-
└─contextPath|string|No comments found.|false|-
└─sessionTimeout|int32|No comments found.|false|-
└─serverInfo|string|No comments found.|false|-
asyncSupported|boolean|No comments found.|false|-
asyncStarted|boolean|No comments found.|false|-
localAddr|string|No comments found.|false|-
remoteHost|string|No comments found.|false|-
remoteAddr|string|No comments found.|false|-
serverPort|int32|No comments found.|false|-
asyncContext|object|No comments found.|false|-
└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─scheme|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─inputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLength|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLengthLong|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterMap|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─reader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─readAheadLimit|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedSkipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locales|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncSupported|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncStarted|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteHost|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─timeout|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletConnection|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolConnectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─connectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolRequestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remotePort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─timeout|int64|No comments found.|false|-
└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─outputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writer|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─committed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bufferSize|int32|No comments found.|false|-
servletConnection|object|No comments found.|false|-
└─protocol|string|No comments found.|false|-
└─protocolConnectionId|string|No comments found.|false|-
└─connectionId|string|No comments found.|false|-
└─secure|boolean|No comments found.|false|-
protocolRequestId|string|No comments found.|false|-
remotePort|int32|No comments found.|false|-
localPort|int32|No comments found.|false|-
secure|boolean|No comments found.|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download.do?httpServletMapping.matchValue=54pf3c&requestURL.value=10&requestURL.value=10&asyncContext.request.servletContext.serverInfo=5ohnvu&asyncContext.request.servletContext.requestCharacterEncoding=gl79zq&reader.markedChar=191&servletContext.sessionCookieConfig.path=g2zih4&asyncContext.request.servletConnection.connectionId=95&asyncContext.request.remotePort=315&writer.psOut.formatter.zero=d&asyncContext.request.servletContext.effectiveMinorVersion=265&writer.writeBuffer=z&writer.writeBuffer=z&protocol=8388bd&asyncContext.request.scheme=ft2ml3&asyncContext.request.asyncStarted=true&servletContext.virtualServerName=julian.ortiz&requestedSessionIdFromURL=true&asyncContext.request.reader.nChars=141&asyncContext.request.servletContext.minorVersion=225&writer.formatter.zero=a&contentLengthLong=776&cookies.=imqxax&cookies.=imqxax&servletContext.sessionCookieConfig.secure=true&asyncContext.request.reader.skipLF=true&session.servletContext.requestCharacterEncoding=brinrx&asyncContext.request.localName=julian.ortiz&writer.psOut.textOut.nextChar=889&session.servletContext.sessionCookieConfig.name=julian.ortiz&httpServletMapping.pattern=sbh2ex&requestId=95&session.lastAccessedTime=1772986113769&remoteHost=27oek1&asyncContext.request.servletContext.majorVersion=605&asyncContext.request.servletContext.virtualServerName=julian.ortiz&asyncContext.request.servletContext.contextPath=bpl79d&reader.skipLF=true&asyncContext.request.secure=true&asyncContext.response.bufferSize=10&asyncContext.request.servletConnection.secure=true&writer.psOut.trouble=true&servletContext.sessionCookieConfig.httpOnly=true&remotePort=428&asyncContext.request.servletContext.sessionTimeout=96&asyncContext.request.asyncContext.timeout=144&session.servletContext.sessionCookieConfig.domain=hirthe.com&reader.nextChar=858&asyncContext.request.requestId=95&asyncContext.request.serverName=julian.ortiz&contentType=odm7fu&session.servletContext.sessionCookieConfig.secure=true&asyncContext.timeout=667&asyncContext.request.protocolRequestId=95&reader.readAheadLimit=10&requestURI=irs8wu&contextPath=0pjo8e&asyncContext.request.protocol=nlpmwy&delete=true&servletContext.contextPath=n02sqk&session.servletContext.contextPath=7l53bk&serverPort=46&servletContext.servletContextName=julian.ortiz&bufferSize=10&servletContext.serverInfo=fh7olh&asyncContext.request.servletConnection.protocolConnectionId=95&session.servletContext.sessionCookieConfig.httpOnly=true&localPort=791&writer.trouble=true&asyncSupported=true&session.servletContext.minorVersion=28&asyncContext.request.contentType=z6wcv5&remoteUser=arzbhl&servletContext.requestCharacterEncoding=7j4636&httpServletMapping.mappingMatch=CONTEXT_ROOT&asyncContext.response.characterEncoding=pkzpvk&session.servletContext.sessionTimeout=575&servletContext.sessionCookieConfig.name=julian.ortiz&servletConnection.protocolConnectionId=95&servletConnection.secure=true&remoteAddr=bol3pm&scheme=2n1j8x&session.servletContext.servletContextName=julian.ortiz&servletContext.sessionCookieConfig.domain=hirthe.com&httpServletMapping.servletName=julian.ortiz&session.servletContext.majorVersion=72&asyncContext.request.asyncSupported=true&asyncContext.request.remoteHost=a4bv22&asyncContext.request.servletContext.responseCharacterEncoding=ilfvjh&servletContext.minorVersion=609&session.servletContext.responseCharacterEncoding=04u2nm&session.creationTime=1772986113769&asyncContext.request.reader.nextChar=871&requestURL.coder=73&requestURL.count=57&characterEncoding=yeftgh&writer.psOut.textOut.nChars=989&reader.nChars=317&asyncContext.request.characterEncoding=k33662&asyncContext.request.localPort=593&servletConnection.connectionId=95&requestedSessionId=95&secure=true&servletPath=8xxroj&session.new=true&reader.cb=h&reader.cb=h&servletContext.responseCharacterEncoding=6zrket&servletContext.effectiveMajorVersion=865&asyncContext.request.contentLength=151&servletContext.sessionCookieConfig.maxAge=14&asyncContext.request.remoteAddr=dlly9g&session.servletContext.sessionCookieConfig.path=sw5a23&session.servletContext.serverInfo=2krm1e&localName=julian.ortiz&asyncContext.response.writer.autoFlush=true&session.servletContext.virtualServerName=julian.ortiz&writer.psOut.autoFlush=true&asyncContext.request.dispatcherType=FORWARD&pathInfo=z71o4r&requestURL.empty=true&writer.psOut.closing=true&session.servletContext.sessionCookieConfig.maxAge=14&asyncContext.request.serverPort=522&asyncContext.request.servletConnection.protocol=jcc9wj&pathTranslated=mu0fq7&servletContext.majorVersion=214&reader.skipBuffer=1&reader.skipBuffer=1&writer.psOut.closed=true&reader.markedSkipLF=true&trailerFieldsReady=true&servletConnection.protocol=rpw9fu&servletContext.sessionCookieConfig.comment=hw2sj8&asyncContext.request.reader.readAheadLimit=10&userPrincipal.name=julian.ortiz&session.servletContext.effectiveMajorVersion=393&status=816&asyncContext.response.writer.trouble=true&asyncContext.response.committed=true&session.servletContext.sessionCookieConfig.comment=w4zmt7&asyncContext.request.contentLengthLong=835&queryString=11jc7o&asyncContext.request.reader.markedSkipLF=true&session.maxInactiveInterval=82&writer.formatter.lastException.detailMessage=success&asyncContext.request.localAddr=2s37ik&session.id=95&protocolRequestId=95&asyncContext.request.servletContext.effectiveMajorVersion=15&asyncStarted=true&authType=til1p5&contentLength=887&session.servletContext.effectiveMinorVersion=920&serverName=julian.ortiz&localAddr=r61ndm&asyncContext.request.reader.markedChar=793&asyncContext.response.contentType=il13xr&fileName=julian.ortiz&servletContext.effectiveMinorVersion=629&committed=true&dispatcherType=FORWARD&method=7caoem&requestedSessionIdFromCookie=true&writer.autoFlush=true&requestedSessionIdValid=true&asyncContext.request.servletContext.servletContextName=julian.ortiz&servletContext.sessionTimeout=767
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "g9w1q1",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
method|string|No comments found.|false|-
userPrincipal|object|No comments found.|false|-
└─name|string|No comments found.|false|-
session|object|No comments found.|false|-
└─id|string|No comments found.|false|-
└─creationTime|int64|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─lastAccessedTime|int64|No comments found.|false|-
└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
└─new|boolean|No comments found.|false|-
└─maxInactiveInterval|int32|No comments found.|false|-
headerNames|object|No comments found.|false|-
trailerFields|map|No comments found.|false|-
└─any object|object|any object.|false|-
requestURI|string|No comments found.|false|-
pathTranslated|string|No comments found.|false|-
remoteUser|string|No comments found.|false|-
requestURL|object|No comments found.|false|-
└─empty|boolean|No comments found.|false|-
└─value|array|No comments found.|false|-
└─coder|int8|No comments found.|false|-
└─count|int32|No comments found.|false|-
authType|string|No comments found.|false|-
queryString|string|No comments found.|false|-
servletPath|string|No comments found.|false|-
contextPath|string|No comments found.|false|-
pathInfo|string|No comments found.|false|-
parts|array|No comments found.|false|-
requestedSessionIdValid|boolean|No comments found.|false|-
httpServletMapping|object|No comments found.|false|-
└─pattern|string|No comments found.|false|-
└─mappingMatch|enum|null<br/>CONTEXT_ROOT<br/>DEFAULT<br/>EXACT<br/>EXTENSION<br/>PATH<br/>|false|-
└─servletName|string|No comments found.|false|-
└─matchValue|string|No comments found.|false|-
requestedSessionIdFromCookie|boolean|No comments found.|false|-
trailerFieldsReady|boolean|No comments found.|false|-
requestedSessionIdFromURL|boolean|No comments found.|false|-
requestedSessionId|string|No comments found.|false|-
cookies|array|No comments found.|false|-
└─name|string|No comments found.|false|-
└─value|string|No comments found.|false|-
└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
scheme|string|No comments found.|false|-
inputStream|object|No comments found.|false|-
protocol|string|No comments found.|false|-
locale|object|No comments found.|false|-
contentLength|int32|No comments found.|false|-
contentLengthLong|int64|No comments found.|false|-
contentType|string|No comments found.|false|-
localName|string|No comments found.|false|-
attributeNames|object|No comments found.|false|-
parameterMap|map|No comments found.|false|-
└─any object|object|any object.|false|-
reader|object|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─skipBuffer|array|No comments found.|false|-
└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
└─cb|array|No comments found.|false|-
└─nChars|int32|No comments found.|false|-
└─nextChar|int32|No comments found.|false|-
└─markedChar|int32|No comments found.|false|-
└─readAheadLimit|int32|No comments found.|false|-
└─skipLF|boolean|No comments found.|false|-
└─markedSkipLF|boolean|No comments found.|false|-
parameterNames|object|No comments found.|false|-
requestId|string|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
serverName|string|No comments found.|false|-
locales|object|No comments found.|false|-
dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
servletContext|object|No comments found.|false|-
└─classLoader|object|No comments found.|false|-
└─majorVersion|int32|No comments found.|false|-
└─minorVersion|int32|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─effectiveMajorVersion|int32|No comments found.|false|-
└─effectiveMinorVersion|int32|No comments found.|false|-
└─initParameterNames|object|No comments found.|false|-
└─servletContextName|string|No comments found.|false|-
└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
└─defaultSessionTrackingModes|array|No comments found.|false|-
└─responseCharacterEncoding|string|No comments found.|false|-
└─virtualServerName|string|No comments found.|false|-
└─effectiveSessionTrackingModes|array|No comments found.|false|-
└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─requestCharacterEncoding|string|No comments found.|false|-
└─contextPath|string|No comments found.|false|-
└─sessionTimeout|int32|No comments found.|false|-
└─serverInfo|string|No comments found.|false|-
asyncSupported|boolean|No comments found.|false|-
asyncStarted|boolean|No comments found.|false|-
localAddr|string|No comments found.|false|-
remoteHost|string|No comments found.|false|-
remoteAddr|string|No comments found.|false|-
serverPort|int32|No comments found.|false|-
asyncContext|object|No comments found.|false|-
└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─scheme|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─inputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLength|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLengthLong|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterMap|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─reader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─readAheadLimit|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedSkipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locales|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncSupported|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncStarted|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteHost|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─timeout|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletConnection|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolConnectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─connectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolRequestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remotePort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─timeout|int64|No comments found.|false|-
└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─outputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writer|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─committed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bufferSize|int32|No comments found.|false|-
servletConnection|object|No comments found.|false|-
└─protocol|string|No comments found.|false|-
└─protocolConnectionId|string|No comments found.|false|-
└─connectionId|string|No comments found.|false|-
└─secure|boolean|No comments found.|false|-
protocolRequestId|string|No comments found.|false|-
remotePort|int32|No comments found.|false|-
localPort|int32|No comments found.|false|-
secure|boolean|No comments found.|false|-
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/upload.do --data 'session.servletContext.sessionTimeout=877&session.maxInactiveInterval=860&session.servletContext.contextPath=36c54k&httpServletMapping.mappingMatch=CONTEXT_ROOT&requestId=95&dispatcherType=FORWARD&requestURL.empty=true&reader.readAheadLimit=10&servletContext.contextPath=y105ss&contentType=i412wf&writer.writeBuffer=w&writer.writeBuffer=w&asyncContext.response.characterEncoding=puad0a&writer.psOut.formatter.zero=8&asyncContext.request.remotePort=542&httpServletMapping.pattern=vzzeoj&asyncContext.request.contentLengthLong=630&requestURL.coder=43&contextPath=hhxevc&asyncContext.request.servletContext.majorVersion=869&asyncContext.request.servletContext.serverInfo=blprk7&servletContext.sessionCookieConfig.secure=true&serverName=julian.ortiz&asyncContext.request.serverPort=898&session.servletContext.servletContextName=julian.ortiz&asyncContext.request.servletContext.servletContextName=julian.ortiz&remoteUser=7sy8y2&asyncContext.response.bufferSize=10&session.id=95&asyncContext.request.servletContext.contextPath=951ab5&asyncContext.request.contentLength=464&asyncContext.request.servletConnection.connectionId=95&asyncContext.request.localPort=516&servletContext.sessionCookieConfig.maxAge=14&asyncContext.request.servletContext.requestCharacterEncoding=1ra5aa&bufferSize=10&asyncContext.response.contentType=cjrs3s&asyncContext.request.reader.markedSkipLF=true&servletContext.servletContextName=julian.ortiz&writer.formatter.zero=j&session.servletContext.sessionCookieConfig.comment=4001mg&asyncContext.request.servletContext.responseCharacterEncoding=d9qqv9&method=ijn2ay&asyncContext.request.dispatcherType=FORWARD&servletConnection.protocol=ep7gsl&servletConnection.secure=true&contentType=jstrfh&asyncContext.request.remoteAddr=rlpxuh&writer.psOut.closed=true&characterEncoding=sqll6h&session.new=true&servletContext.virtualServerName=julian.ortiz&asyncContext.request.protocol=9293ka&asyncContext.request.contentType=10h6dg&asyncContext.request.servletContext.virtualServerName=julian.ortiz&session.servletContext.serverInfo=j7e2q2&servletContext.serverInfo=gy5tz3&asyncContext.request.asyncStarted=true&asyncContext.request.servletConnection.protocolConnectionId=95&requestedSessionIdValid=true&asyncContext.response.writer.trouble=true&session.servletContext.sessionCookieConfig.path=h12bab&asyncContext.request.remoteHost=4dpxlj&reader.skipBuffer=j&reader.skipBuffer=j&localName=julian.ortiz&asyncContext.request.protocolRequestId=95&servletContext.responseCharacterEncoding=txjym9&queryString=5wson1&remoteAddr=1k114b&servletConnection.connectionId=95&session.servletContext.minorVersion=974&writer.trouble=true&session.creationTime=1772986113769&localAddr=ckpor4&writer.formatter.lastException.detailMessage=success&session.servletContext.requestCharacterEncoding=7243k8&requestedSessionId=95&servletContext.sessionCookieConfig.httpOnly=true&asyncContext.response.writer.autoFlush=true&scheme=e7u4oq&session.servletContext.sessionCookieConfig.secure=true&userPrincipal.name=julian.ortiz&servletContext.effectiveMinorVersion=262&asyncContext.request.reader.nextChar=548&asyncSupported=true&writer.psOut.closing=true&asyncContext.request.serverName=julian.ortiz&session.servletContext.effectiveMinorVersion=772&httpServletMapping.servletName=julian.ortiz&asyncContext.request.servletContext.effectiveMajorVersion=32&trailerFieldsReady=true&reader.skipLF=true&committed=true&writer.psOut.textOut.nChars=344&session.servletContext.sessionCookieConfig.name=julian.ortiz&servletContext.sessionCookieConfig.comment=7qeyvz&servletContext.requestCharacterEncoding=cimtvc&protocol=kyjuwl&contentLength=963&cookies.=julian.ortiz&cookies.=julian.ortiz&reader.cb=j&reader.cb=j&servletConnection.protocolConnectionId=95&protocolRequestId=95&reader.nChars=993&writer.psOut.autoFlush=true&session.servletContext.effectiveMajorVersion=618&requestURI=euh8zd&asyncContext.request.characterEncoding=mjfgs8&session.servletContext.sessionCookieConfig.maxAge=14&asyncContext.request.servletContext.effectiveMinorVersion=972&asyncContext.request.reader.nChars=251&writer.psOut.trouble=true&requestedSessionIdFromCookie=true&asyncContext.request.reader.readAheadLimit=10&servletContext.majorVersion=268&asyncContext.request.servletConnection.protocol=pkb2j8&serverPort=168&servletContext.sessionCookieConfig.path=3pqdkn&session.servletContext.virtualServerName=julian.ortiz&servletContext.sessionTimeout=991&remotePort=79&reader.markedSkipLF=true&asyncContext.request.scheme=h15rr3&requestURL.count=622&asyncContext.request.localAddr=i4m4wx&authType=fl5mrm&asyncContext.request.secure=true&requestURL.value=88&requestURL.value=88&servletContext.sessionCookieConfig.domain=hirthe.com&servletContext.minorVersion=511&writer.psOut.textOut.nextChar=481&requestedSessionIdFromURL=true&asyncContext.request.servletContext.minorVersion=795&session.servletContext.responseCharacterEncoding=2r78y6&characterEncoding=sltp40&session.lastAccessedTime=1772986113769&pathInfo=noxf3n&reader.markedChar=496&httpServletMapping.matchValue=h14xlr&asyncContext.request.reader.markedChar=23&session.servletContext.majorVersion=779&asyncContext.request.servletContext.sessionTimeout=223&asyncContext.response.committed=true&secure=true&contentLengthLong=797&session.servletContext.sessionCookieConfig.domain=hirthe.com&asyncContext.request.asyncContext.timeout=370&pathTranslated=kahqn4&status=872&cookies.=cuo1st&cookies.=cuo1st&servletPath=v1ir8a&asyncContext.request.requestId=95&reader.nextChar=368&servletContext.sessionCookieConfig.name=julian.ortiz&asyncContext.request.asyncSupported=true&asyncContext.request.servletConnection.secure=true&session.servletContext.sessionCookieConfig.httpOnly=true&remoteHost=apwh0b&asyncContext.request.localName=julian.ortiz&asyncContext.request.reader.skipLF=true&asyncStarted=true&servletContext.effectiveMajorVersion=356&asyncContext.timeout=984&writer.autoFlush=true&localPort=619'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "originFilename": "julian.ortiz",
    "filename": "julian.ortiz",
    "fileType": "x4vr4u",
    "fileUrl": "www.kandace-stamm.org",
    "fileHttpUrl": "www.kandace-stamm.org",
    "statusCode": "58719"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
method|string|No comments found.|false|-
userPrincipal|object|No comments found.|false|-
└─name|string|No comments found.|false|-
session|object|No comments found.|false|-
└─id|string|No comments found.|false|-
└─creationTime|int64|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─lastAccessedTime|int64|No comments found.|false|-
└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
└─new|boolean|No comments found.|false|-
└─maxInactiveInterval|int32|No comments found.|false|-
headerNames|object|No comments found.|false|-
trailerFields|map|No comments found.|false|-
└─any object|object|any object.|false|-
requestURI|string|No comments found.|false|-
pathTranslated|string|No comments found.|false|-
remoteUser|string|No comments found.|false|-
requestURL|object|No comments found.|false|-
└─empty|boolean|No comments found.|false|-
└─value|array|No comments found.|false|-
└─coder|int8|No comments found.|false|-
└─count|int32|No comments found.|false|-
authType|string|No comments found.|false|-
queryString|string|No comments found.|false|-
servletPath|string|No comments found.|false|-
contextPath|string|No comments found.|false|-
pathInfo|string|No comments found.|false|-
parts|array|No comments found.|false|-
requestedSessionIdValid|boolean|No comments found.|false|-
httpServletMapping|object|No comments found.|false|-
└─pattern|string|No comments found.|false|-
└─mappingMatch|enum|null<br/>CONTEXT_ROOT<br/>DEFAULT<br/>EXACT<br/>EXTENSION<br/>PATH<br/>|false|-
└─servletName|string|No comments found.|false|-
└─matchValue|string|No comments found.|false|-
requestedSessionIdFromCookie|boolean|No comments found.|false|-
trailerFieldsReady|boolean|No comments found.|false|-
requestedSessionIdFromURL|boolean|No comments found.|false|-
requestedSessionId|string|No comments found.|false|-
cookies|array|No comments found.|false|-
└─name|string|No comments found.|false|-
└─value|string|No comments found.|false|-
└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
scheme|string|No comments found.|false|-
inputStream|object|No comments found.|false|-
protocol|string|No comments found.|false|-
locale|object|No comments found.|false|-
contentLength|int32|No comments found.|false|-
contentLengthLong|int64|No comments found.|false|-
contentType|string|No comments found.|false|-
localName|string|No comments found.|false|-
attributeNames|object|No comments found.|false|-
parameterMap|map|No comments found.|false|-
└─any object|object|any object.|false|-
reader|object|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─skipBuffer|array|No comments found.|false|-
└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
└─cb|array|No comments found.|false|-
└─nChars|int32|No comments found.|false|-
└─nextChar|int32|No comments found.|false|-
└─markedChar|int32|No comments found.|false|-
└─readAheadLimit|int32|No comments found.|false|-
└─skipLF|boolean|No comments found.|false|-
└─markedSkipLF|boolean|No comments found.|false|-
parameterNames|object|No comments found.|false|-
requestId|string|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
serverName|string|No comments found.|false|-
locales|object|No comments found.|false|-
dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
servletContext|object|No comments found.|false|-
└─classLoader|object|No comments found.|false|-
└─majorVersion|int32|No comments found.|false|-
└─minorVersion|int32|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─effectiveMajorVersion|int32|No comments found.|false|-
└─effectiveMinorVersion|int32|No comments found.|false|-
└─initParameterNames|object|No comments found.|false|-
└─servletContextName|string|No comments found.|false|-
└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
└─defaultSessionTrackingModes|array|No comments found.|false|-
└─responseCharacterEncoding|string|No comments found.|false|-
└─virtualServerName|string|No comments found.|false|-
└─effectiveSessionTrackingModes|array|No comments found.|false|-
└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─requestCharacterEncoding|string|No comments found.|false|-
└─contextPath|string|No comments found.|false|-
└─sessionTimeout|int32|No comments found.|false|-
└─serverInfo|string|No comments found.|false|-
asyncSupported|boolean|No comments found.|false|-
asyncStarted|boolean|No comments found.|false|-
localAddr|string|No comments found.|false|-
remoteHost|string|No comments found.|false|-
remoteAddr|string|No comments found.|false|-
serverPort|int32|No comments found.|false|-
asyncContext|object|No comments found.|false|-
└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─scheme|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─inputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLength|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLengthLong|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterMap|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─reader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─readAheadLimit|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedSkipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locales|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncSupported|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncStarted|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteHost|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─timeout|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletConnection|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolConnectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─connectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolRequestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remotePort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─timeout|int64|No comments found.|false|-
└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─outputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writer|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─committed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bufferSize|int32|No comments found.|false|-
servletConnection|object|No comments found.|false|-
└─protocol|string|No comments found.|false|-
└─protocolConnectionId|string|No comments found.|false|-
└─connectionId|string|No comments found.|false|-
└─secure|boolean|No comments found.|false|-
protocolRequestId|string|No comments found.|false|-
remotePort|int32|No comments found.|false|-
localPort|int32|No comments found.|false|-
secure|boolean|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: multipart/form-data' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/uploads.do --data 'session.servletContext.contextPath=l19dwu&servletPath=1ksuq7&asyncSupported=true&asyncContext.request.reader.readAheadLimit=10&asyncContext.request.requestId=95&httpServletMapping.servletName=julian.ortiz&localAddr=5hdkvt&asyncContext.request.servletContext.majorVersion=826&asyncContext.request.servletContext.requestCharacterEncoding=i0nlu1&requestedSessionIdFromCookie=true&asyncContext.response.writer.trouble=true&session.servletContext.effectiveMinorVersion=893&localPort=449&asyncContext.request.protocol=vqvtug&requestURL.count=937&asyncContext.request.asyncStarted=true&servletContext.majorVersion=845&servletContext.requestCharacterEncoding=16ocxa&asyncContext.request.reader.markedSkipLF=true&session.servletContext.sessionTimeout=587&reader.nextChar=311&session.servletContext.effectiveMajorVersion=504&pathInfo=z0onwo&servletContext.effectiveMinorVersion=835&requestedSessionId=95&trailerFieldsReady=true&servletConnection.protocol=znswq5&secure=true&session.creationTime=1772986113769&reader.nChars=28&asyncContext.request.contentType=8qxmkb&asyncContext.response.bufferSize=10&dispatcherType=FORWARD&asyncContext.response.writer.autoFlush=true&asyncContext.response.contentType=8nngn7&method=ttji7h&contextPath=97t03p&cookies.=julian.ortiz&cookies.=julian.ortiz&authType=gd1x6s&asyncContext.request.asyncContext.timeout=81&reader.markedSkipLF=true&queryString=qnnvsy&httpServletMapping.matchValue=u9zygs&servletContext.sessionCookieConfig.path=5j3aui&asyncStarted=true&asyncContext.request.contentLength=442&servletContext.sessionTimeout=373&asyncContext.request.remotePort=103&asyncContext.request.localPort=329&servletConnection.secure=true&session.servletContext.requestCharacterEncoding=ivc3a0&asyncContext.request.servletContext.contextPath=7hi7mc&servletConnection.protocolConnectionId=95&asyncContext.request.secure=true&requestedSessionIdValid=true&servletContext.responseCharacterEncoding=fczgg3&contentLength=147&servletConnection.connectionId=95&protocolRequestId=95&session.lastAccessedTime=1772986113769&remoteHost=fqo9ck&requestURL.value=39&requestURL.value=39&servletContext.sessionCookieConfig.secure=true&session.id=95&session.servletContext.virtualServerName=julian.ortiz&session.servletContext.sessionCookieConfig.maxAge=14&session.new=true&asyncContext.request.dispatcherType=FORWARD&asyncContext.request.servletContext.servletContextName=julian.ortiz&protocol=qtrne7&asyncContext.request.servletConnection.protocolConnectionId=95&asyncContext.timeout=969&session.servletContext.majorVersion=992&session.servletContext.minorVersion=908&session.servletContext.sessionCookieConfig.path=t0dbh6&reader.skipBuffer=3&reader.skipBuffer=3&servletContext.effectiveMajorVersion=726&session.servletContext.sessionCookieConfig.secure=true&contentLengthLong=371&session.servletContext.sessionCookieConfig.httpOnly=true&characterEncoding=vpa5a0&servletContext.minorVersion=497&httpServletMapping.pattern=44g2v3&servletContext.sessionCookieConfig.comment=w8a4t4&servletContext.serverInfo=nld2bd&asyncContext.request.localAddr=g0rlbn&asyncContext.request.remoteAddr=wg0kk7&reader.markedChar=811&asyncContext.request.scheme=87o8ls&servletContext.contextPath=cx4mqe&asyncContext.request.servletConnection.secure=true&asyncContext.response.characterEncoding=0g1il7&userPrincipal.name=julian.ortiz&remoteUser=m9z80y&httpServletMapping.mappingMatch=CONTEXT_ROOT&session.servletContext.serverInfo=61y841&asyncContext.request.reader.nextChar=709&localName=julian.ortiz&asyncContext.request.reader.skipLF=true&asyncContext.request.servletContext.responseCharacterEncoding=ubjq3p&servletContext.sessionCookieConfig.maxAge=14&asyncContext.request.servletContext.serverInfo=lz5in4&session.maxInactiveInterval=498&contentType=g1k6ov&asyncContext.request.reader.markedChar=925&servletContext.sessionCookieConfig.name=julian.ortiz&requestURL.coder=111&asyncContext.request.characterEncoding=fw5ttf&serverName=julian.ortiz&serverPort=30&requestURI=8ybl75&asyncContext.request.contentLengthLong=581&servletContext.servletContextName=julian.ortiz&asyncContext.response.committed=true&asyncContext.request.serverName=julian.ortiz&cookies.=tnf0we&cookies.=tnf0we&reader.skipLF=true&requestURL.empty=true&requestedSessionIdFromURL=true&servletContext.virtualServerName=julian.ortiz&pathTranslated=ksg44p&session.servletContext.sessionCookieConfig.comment=fjhdw9&asyncContext.request.servletContext.minorVersion=166&asyncContext.request.remoteHost=m3mq0x&asyncContext.request.servletContext.virtualServerName=julian.ortiz&asyncContext.request.serverPort=270&asyncContext.request.servletContext.sessionTimeout=92&asyncContext.request.servletConnection.connectionId=95&session.servletContext.responseCharacterEncoding=s12yo4&asyncContext.request.asyncSupported=true&remoteAddr=ykawf4&scheme=abtx5c&asyncContext.request.servletContext.effectiveMinorVersion=598&asyncContext.request.localName=julian.ortiz&reader.readAheadLimit=10&asyncContext.request.servletConnection.protocol=5julu4&session.servletContext.sessionCookieConfig.name=julian.ortiz&servletContext.sessionCookieConfig.httpOnly=true&asyncContext.request.reader.nChars=734&session.servletContext.sessionCookieConfig.domain=hirthe.com&reader.cb=9&reader.cb=9&servletContext.sessionCookieConfig.domain=hirthe.com&asyncContext.request.servletContext.effectiveMajorVersion=671&asyncContext.request.protocolRequestId=95&remotePort=613&requestId=95&session.servletContext.servletContextName=julian.ortiz'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "originFilename": "julian.ortiz",
      "filename": "julian.ortiz",
      "fileType": "4oof7d",
      "fileUrl": "www.kandace-stamm.org",
      "fileHttpUrl": "www.kandace-stamm.org",
      "statusCode": "58719"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
method|string|No comments found.|false|-
userPrincipal|object|No comments found.|false|-
└─name|string|No comments found.|false|-
session|object|No comments found.|false|-
└─id|string|No comments found.|false|-
└─creationTime|int64|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─lastAccessedTime|int64|No comments found.|false|-
└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
└─new|boolean|No comments found.|false|-
└─maxInactiveInterval|int32|No comments found.|false|-
headerNames|object|No comments found.|false|-
trailerFields|map|No comments found.|false|-
└─any object|object|any object.|false|-
requestURI|string|No comments found.|false|-
pathTranslated|string|No comments found.|false|-
remoteUser|string|No comments found.|false|-
requestURL|object|No comments found.|false|-
└─empty|boolean|No comments found.|false|-
└─value|array|No comments found.|false|-
└─coder|int8|No comments found.|false|-
└─count|int32|No comments found.|false|-
authType|string|No comments found.|false|-
queryString|string|No comments found.|false|-
servletPath|string|No comments found.|false|-
contextPath|string|No comments found.|false|-
pathInfo|string|No comments found.|false|-
parts|array|No comments found.|false|-
requestedSessionIdValid|boolean|No comments found.|false|-
httpServletMapping|object|No comments found.|false|-
└─pattern|string|No comments found.|false|-
└─mappingMatch|enum|null<br/>CONTEXT_ROOT<br/>DEFAULT<br/>EXACT<br/>EXTENSION<br/>PATH<br/>|false|-
└─servletName|string|No comments found.|false|-
└─matchValue|string|No comments found.|false|-
requestedSessionIdFromCookie|boolean|No comments found.|false|-
trailerFieldsReady|boolean|No comments found.|false|-
requestedSessionIdFromURL|boolean|No comments found.|false|-
requestedSessionId|string|No comments found.|false|-
cookies|array|No comments found.|false|-
└─name|string|No comments found.|false|-
└─value|string|No comments found.|false|-
└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
scheme|string|No comments found.|false|-
inputStream|object|No comments found.|false|-
protocol|string|No comments found.|false|-
locale|object|No comments found.|false|-
contentLength|int32|No comments found.|false|-
contentLengthLong|int64|No comments found.|false|-
contentType|string|No comments found.|false|-
localName|string|No comments found.|false|-
attributeNames|object|No comments found.|false|-
parameterMap|map|No comments found.|false|-
└─any object|object|any object.|false|-
reader|object|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─skipBuffer|array|No comments found.|false|-
└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
└─cb|array|No comments found.|false|-
└─nChars|int32|No comments found.|false|-
└─nextChar|int32|No comments found.|false|-
└─markedChar|int32|No comments found.|false|-
└─readAheadLimit|int32|No comments found.|false|-
└─skipLF|boolean|No comments found.|false|-
└─markedSkipLF|boolean|No comments found.|false|-
parameterNames|object|No comments found.|false|-
requestId|string|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
serverName|string|No comments found.|false|-
locales|object|No comments found.|false|-
dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
servletContext|object|No comments found.|false|-
└─classLoader|object|No comments found.|false|-
└─majorVersion|int32|No comments found.|false|-
└─minorVersion|int32|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─effectiveMajorVersion|int32|No comments found.|false|-
└─effectiveMinorVersion|int32|No comments found.|false|-
└─initParameterNames|object|No comments found.|false|-
└─servletContextName|string|No comments found.|false|-
└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
└─defaultSessionTrackingModes|array|No comments found.|false|-
└─responseCharacterEncoding|string|No comments found.|false|-
└─virtualServerName|string|No comments found.|false|-
└─effectiveSessionTrackingModes|array|No comments found.|false|-
└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─requestCharacterEncoding|string|No comments found.|false|-
└─contextPath|string|No comments found.|false|-
└─sessionTimeout|int32|No comments found.|false|-
└─serverInfo|string|No comments found.|false|-
asyncSupported|boolean|No comments found.|false|-
asyncStarted|boolean|No comments found.|false|-
localAddr|string|No comments found.|false|-
remoteHost|string|No comments found.|false|-
remoteAddr|string|No comments found.|false|-
serverPort|int32|No comments found.|false|-
asyncContext|object|No comments found.|false|-
└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─scheme|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─inputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLength|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLengthLong|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterMap|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─reader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─readAheadLimit|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedSkipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locales|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncSupported|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncStarted|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteHost|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─timeout|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletConnection|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolConnectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─connectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolRequestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remotePort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─timeout|int64|No comments found.|false|-
└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─outputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writer|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─committed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bufferSize|int32|No comments found.|false|-
servletConnection|object|No comments found.|false|-
└─protocol|string|No comments found.|false|-
└─protocolConnectionId|string|No comments found.|false|-
└─connectionId|string|No comments found.|false|-
└─secure|boolean|No comments found.|false|-
protocolRequestId|string|No comments found.|false|-
remotePort|int32|No comments found.|false|-
localPort|int32|No comments found.|false|-
secure|boolean|No comments found.|false|-
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download/resource.do?asyncContext.request.contentType=1ir0ys&asyncContext.response.committed=true&writer.writeBuffer=x&writer.writeBuffer=x&localName=julian.ortiz&servletContext.requestCharacterEncoding=wvfzp4&writer.psOut.textOut.nChars=220&asyncContext.request.servletContext.effectiveMinorVersion=317&asyncContext.request.serverPort=556&bufferSize=10&asyncContext.request.reader.markedChar=88&contentLength=529&asyncContext.response.writer.autoFlush=true&asyncContext.request.asyncStarted=true&httpServletMapping.pattern=olrdsn&asyncContext.response.characterEncoding=jinv59&requestURL.value=48&requestURL.value=48&writer.psOut.autoFlush=true&session.servletContext.serverInfo=we1k54&session.id=95&asyncContext.request.reader.markedSkipLF=true&requestURL.empty=true&asyncContext.request.contentLengthLong=212&requestURL.coder=4&secure=true&servletContext.serverInfo=p14a8p&servletContext.sessionCookieConfig.path=9stt5j&requestURL.count=421&writer.trouble=true&servletContext.sessionCookieConfig.name=julian.ortiz&httpServletMapping.servletName=julian.ortiz&trailerFieldsReady=true&remoteHost=g1ncdm&session.servletContext.sessionCookieConfig.comment=pmsgiy&reader.nextChar=761&dispatcherType=FORWARD&protocol=eqczqk&asyncContext.request.servletContext.responseCharacterEncoding=ywdv4v&reader.nChars=111&asyncContext.request.servletContext.requestCharacterEncoding=8kzgwc&asyncContext.request.remoteHost=t1ou38&pathInfo=hvx9nk&localPort=268&localAddr=pqxrha&asyncContext.response.contentType=mmbej7&writer.psOut.closing=true&asyncContext.request.localName=julian.ortiz&asyncContext.request.protocolRequestId=95&authType=edll0e&servletContext.servletContextName=julian.ortiz&asyncContext.request.servletConnection.connectionId=95&session.lastAccessedTime=1772986113769&characterEncoding=kf4zr8&session.servletContext.sessionTimeout=172&asyncContext.request.requestId=95&requestedSessionIdFromCookie=true&scheme=p99sl8&asyncContext.request.reader.readAheadLimit=10&asyncContext.request.asyncSupported=true&session.servletContext.responseCharacterEncoding=lggy9x&writer.autoFlush=true&requestedSessionId=95&servletContext.effectiveMajorVersion=611&session.servletContext.virtualServerName=julian.ortiz&asyncContext.response.writer.trouble=true&session.servletContext.sessionCookieConfig.httpOnly=true&httpServletMapping.matchValue=erhxln&reader.markedSkipLF=true&asyncContext.request.servletContext.majorVersion=121&writer.psOut.closed=true&session.servletContext.effectiveMajorVersion=75&asyncContext.request.remotePort=291&writer.formatter.lastException.detailMessage=success&method=gol9yx&contentLengthLong=153&servletConnection.protocol=fo3203&asyncContext.request.localPort=786&pathTranslated=ds7nmu&requestedSessionIdValid=true&asyncContext.request.servletContext.virtualServerName=julian.ortiz&asyncContext.request.servletContext.serverInfo=uvj8z2&session.servletContext.sessionCookieConfig.path=ps7vnz&servletContext.sessionTimeout=789&servletContext.effectiveMinorVersion=617&writer.psOut.trouble=true&writer.psOut.formatter.zero=f&contentType=1mf6ek&servletContext.sessionCookieConfig.secure=true&asyncContext.response.bufferSize=10&asyncSupported=true&asyncContext.request.remoteAddr=2rlqei&session.creationTime=1772986113769&session.servletContext.servletContextName=julian.ortiz&servletConnection.connectionId=95&servletContext.majorVersion=419&remoteUser=ti27wp&asyncContext.request.reader.skipLF=true&cookies.=julian.ortiz&cookies.=julian.ortiz&asyncStarted=true&servletConnection.secure=true&asyncContext.request.servletConnection.protocolConnectionId=95&servletContext.sessionCookieConfig.comment=soq68o&asyncContext.request.servletConnection.secure=true&servletContext.sessionCookieConfig.maxAge=14&session.servletContext.minorVersion=886&asyncContext.request.scheme=xflx8y&queryString=6na7dw&writer.psOut.textOut.nextChar=530&serverPort=67&reader.skipBuffer=s&reader.skipBuffer=s&asyncContext.request.servletContext.effectiveMajorVersion=882&committed=true&serverName=julian.ortiz&resource=kvtq3s&session.servletContext.sessionCookieConfig.domain=hirthe.com&session.servletContext.contextPath=fi8d9m&asyncContext.request.servletContext.sessionTimeout=8&asyncContext.request.serverName=julian.ortiz&asyncContext.request.reader.nChars=530&session.servletContext.sessionCookieConfig.name=julian.ortiz&requestId=95&servletContext.sessionCookieConfig.domain=hirthe.com&asyncContext.timeout=246&requestURI=dyshp9&reader.readAheadLimit=10&session.servletContext.effectiveMinorVersion=214&servletContext.responseCharacterEncoding=i8ajn6&reader.markedChar=887&asyncContext.request.contentLength=470&servletPath=4anjim&requestedSessionIdFromURL=true&asyncContext.request.reader.nextChar=397&asyncContext.request.protocol=e1094o&session.new=true&servletContext.minorVersion=608&reader.cb=v&reader.cb=v&servletContext.contextPath=mgnlob&asyncContext.request.servletContext.contextPath=0v0tci&session.servletContext.majorVersion=979&httpServletMapping.mappingMatch=CONTEXT_ROOT&session.servletContext.requestCharacterEncoding=ouz2x1&asyncContext.request.characterEncoding=0rkd6f&session.servletContext.sessionCookieConfig.maxAge=14&session.servletContext.sessionCookieConfig.secure=true&remotePort=657&contextPath=l3cwr7&asyncContext.request.servletContext.servletContextName=julian.ortiz&remoteAddr=skd766&asyncContext.request.localAddr=d3dqno&asyncContext.request.asyncContext.timeout=695&status=27&protocolRequestId=95&servletConnection.protocolConnectionId=95&asyncContext.request.dispatcherType=FORWARD&asyncContext.request.secure=true&writer.formatter.zero=x&userPrincipal.name=julian.ortiz&session.maxInactiveInterval=978&reader.skipLF=true&asyncContext.request.servletContext.minorVersion=398&servletContext.sessionCookieConfig.httpOnly=true&servletContext.virtualServerName=julian.ortiz&asyncContext.request.servletConnection.protocol=01d3wq
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "cdrk9l",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/list.do?page=1&configKey=wo8iaf&orderBy=169&startTime=2026-03-09 00:08:33&limit=10&configValue=x9rbeu&q=u8m352&endTime=2026-03-09 00:08:33&isDisabled=true&remark=jgqw04
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 388,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "configId": "95",
        "configKey": "muhfyb",
        "configValue": "p3h8b3",
        "isDisabled": true,
        "remark": "rwg1u5"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/export.do --data 'bufferSize=10&contentType=pfwt66&status=119&writer.writeBuffer=8&writer.writeBuffer=8&writer.formatter.lastException.detailMessage=success&writer.psOut.textOut.nChars=750&writer.psOut.autoFlush=true&writer.psOut.formatter.zero=w&endTime=2026-03-09 00:08:33&writer.formatter.zero=c&characterEncoding=17ihbo&isDisabled=true&writer.psOut.closing=true&committed=true&writer.psOut.closed=true&writer.psOut.textOut.nextChar=218&remark=uh48vb&limit=10&configKey=nd3ree&configValue=m1qd2z&page=1&orderBy=254&writer.psOut.trouble=true&q=wl494d&writer.autoFlush=true&writer.trouble=true&startTime=2026-03-09 00:08:33'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "iq5ail",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/95.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "configId": "95",
    "configKey": "rnccwc",
    "configValue": "2np79l",
    "isDisabled": true,
    "remark": "gec2k8"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/configKey/9l7bxm.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "configId": "95",
    "configKey": "lac4yi",
    "configValue": "x34t4h",
    "isDisabled": true,
    "remark": "1ep56z"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
configId|string|参数主键|false|-
configKey|string|参数键名|false|-
configValue|string|参数键值|false|-
isDisabled|boolean|状态|false|-
remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/save.do --data '{
  "configId": "95",
  "configKey": "lbirv8",
  "configValue": "tgamjf",
  "isDisabled": true,
  "remark": "5yxczb"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "o5tavj",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
configId|string|参数主键|false|-
configKey|string|参数键名|false|-
configValue|string|参数键值|false|-
isDisabled|boolean|状态|false|-
remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/update.do --data '{
  "configId": "95",
  "configKey": "xeujwh",
  "configValue": "iavnqw",
  "isDisabled": true,
  "remark": "twfs1q"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "0hu3kh",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "t7e4fc",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "1a1xmz",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/list.do?ipaddr=7h5aiw&username=julian.ortiz
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "tokenId": "95",
      "deptName": "julian.ortiz",
      "username": "julian.ortiz",
      "ipaddr": "a78llx",
      "loginLocation": "yn2fse",
      "browser": "cl1568",
      "os": "b254la",
      "loginTime": 1772986113769
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/95.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "vswq65",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuserext/list.do?endTime=2026-03-09 00:08:33&searchCode=58719&idType=8smv65&nickname=shane.roberts&sex=zh76ft&isMobileConfirm=true&page=1&ids=7qa2w1&ids=7qa2w1&familyAddress=Suite 395 2647 Romaguera Court， North Dewey， NE 11167&nativePlace=vuqk0x&weixinId=95&orderBy=317&postCode=58719&spare3=lbzyr4&keywords=jq0ano&spare2=iturxc&spareMobile=1-508-337-4557&spare4=p1f8jk&spare1=63u0ja&name=julian.ortiz&namePy=a3xths&intro=p1jdq4&limit=10&sname=julian.ortiz&birthday=2026-03-09 00:09:53&homeTel=le2elm&startTime=2026-03-09 00:08:33&comefrom=4jfv02&idMobile=1-508-337-4557&qqNo=jr46xm&emergencePhone=(947) 505-4582&idNum=9hkqi1&q=b9argd&nameEn=96ebkj&address=Suite 395 2647 Romaguera Court， North Dewey， NE 11167
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
└─isMobileConfirm|boolean|手机号码是否验证0否1是，是否实名认证|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:53",
      "lastTime": "2026-03-09 00:09:53",
      "id": "95",
      "nickname": "shane.roberts",
      "idName": "julian.ortiz",
      "idNum": "t2lib9",
      "idMobile": "1-508-337-4557",
      "idType": "2hwj3f",
      "namePy": "geaaw4",
      "sname": "julian.ortiz",
      "nameEn": "eumpmg",
      "searchCode": "58719",
      "sex": "x1yn0t",
      "birthday": "2026-03-09 00:09:53",
      "postCode": "58719",
      "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
      "nativePlace": "3lewmo",
      "familyAddress": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
      "homeTel": "9jexwj",
      "qqNo": "qb9rza",
      "weixinId": "95",
      "weiboId": "95",
      "spareMobile": "1-508-337-4557",
      "isMobileConfirm": true,
      "emergencePhone": "(947) 505-4582",
      "keywords": "wsfah8",
      "intro": "0y6wr5",
      "comefrom": "ivsji5",
      "imagePath": "7bjdua",
      "userSignature": "n9zsxo",
      "ipRange": "5fgtmn",
      "macCode": "58719",
      "resume": "8dyahf",
      "spare1": "c9cwvk",
      "spare2": "kbx029",
      "spare3": "g2qj95",
      "spare4": "j428wj"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
└─isMobileConfirm|boolean|手机号码是否验证0否1是，是否实名认证|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:53",
    "lastTime": "2026-03-09 00:09:53",
    "id": "95",
    "nickname": "shane.roberts",
    "idName": "julian.ortiz",
    "idNum": "ws0zir",
    "idMobile": "1-508-337-4557",
    "idType": "mpimu1",
    "namePy": "zqt86p",
    "sname": "julian.ortiz",
    "nameEn": "rf2eu1",
    "searchCode": "58719",
    "sex": "aw09si",
    "birthday": "2026-03-09 00:09:53",
    "postCode": "58719",
    "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
    "nativePlace": "t1gjfh",
    "familyAddress": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
    "homeTel": "2id8tm",
    "qqNo": "7y398y",
    "weixinId": "95",
    "weiboId": "95",
    "spareMobile": "1-508-337-4557",
    "isMobileConfirm": true,
    "emergencePhone": "(947) 505-4582",
    "keywords": "ajyz9y",
    "intro": "vnx8kr",
    "comefrom": "gxnewk",
    "imagePath": "20254q",
    "userSignature": "hdppx9",
    "ipRange": "59owud",
    "macCode": "58719",
    "resume": "rhphwm",
    "spare1": "gotsfn",
    "spare2": "t7tinx",
    "spare3": "zqvmnx",
    "spare4": "tj7nte"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|用户ID|false|-
nickname|string|用户昵称|false|-
idName|string|真实姓名，加密的姓名|false|-
idNum|string|身份证号码，加密的身份证号码|false|-
idMobile|string|电话|false|-
idType|string|证件类型|false|-
namePy|string|姓名全拼，BCryptPasswordEncoder密码")|false|-
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
qqNo|string|即时通讯QQ号码|false|-
weixinId|string|微信用户名|false|-
weiboId|string|微博用户名|false|-
spareMobile|string|备用手机，紧急手机|false|-
isMobileConfirm|boolean|手机号码是否验证0否1是，是否实名认证|false|-
emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|false|-
keywords|string|关键字|false|-
intro|string|个人介绍|false|-
comefrom|string|来自|false|-
imagePath|string|用户图像图标|false|-
userSignature|string|用户签名|false|-
ipRange|string|登录IP地址(";"分隔）|false|-
macCode|string|允许登录MAC地址(";"分隔）|false|-
resume|string|简历，网格平台使用，人所属的网格多个，分隔|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
spare3|string|备用3|false|-
spare4|string|备用4|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuserext/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:53",
  "lastTime": "2026-03-09 00:09:53",
  "id": "95",
  "nickname": "shane.roberts",
  "idName": "julian.ortiz",
  "idNum": "shjzds",
  "idMobile": "1-508-337-4557",
  "idType": "mjs252",
  "namePy": "xqxnzl",
  "sname": "julian.ortiz",
  "nameEn": "c3r6qs",
  "searchCode": "58719",
  "sex": "wc6x35",
  "birthday": "2026-03-09 00:09:53",
  "postCode": "58719",
  "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "nativePlace": "v7nmqo",
  "familyAddress": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "homeTel": "2h74yr",
  "qqNo": "7i6ej7",
  "weixinId": "95",
  "weiboId": "95",
  "spareMobile": "1-508-337-4557",
  "isMobileConfirm": true,
  "emergencePhone": "(947) 505-4582",
  "keywords": "9q861w",
  "intro": "0aibqt",
  "comefrom": "mprdgv",
  "imagePath": "zrl9s9",
  "userSignature": "rtpk3y",
  "ipRange": "r2fkpt",
  "macCode": "58719",
  "resume": "bn9mci",
  "spare1": "0iqjb3",
  "spare2": "kth249",
  "spare3": "85kl8w",
  "spare4": "buvadu"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "4p60bh",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|用户ID|false|-
nickname|string|用户昵称|false|-
idName|string|真实姓名，加密的姓名|false|-
idNum|string|身份证号码，加密的身份证号码|false|-
idMobile|string|电话|false|-
idType|string|证件类型|false|-
namePy|string|姓名全拼，BCryptPasswordEncoder密码")|false|-
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
qqNo|string|即时通讯QQ号码|false|-
weixinId|string|微信用户名|false|-
weiboId|string|微博用户名|false|-
spareMobile|string|备用手机，紧急手机|false|-
isMobileConfirm|boolean|手机号码是否验证0否1是，是否实名认证|false|-
emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|false|-
keywords|string|关键字|false|-
intro|string|个人介绍|false|-
comefrom|string|来自|false|-
imagePath|string|用户图像图标|false|-
userSignature|string|用户签名|false|-
ipRange|string|登录IP地址(";"分隔）|false|-
macCode|string|允许登录MAC地址(";"分隔）|false|-
resume|string|简历，网格平台使用，人所属的网格多个，分隔|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
spare3|string|备用3|false|-
spare4|string|备用4|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuserext/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:53",
  "lastTime": "2026-03-09 00:09:53",
  "id": "95",
  "nickname": "shane.roberts",
  "idName": "julian.ortiz",
  "idNum": "7ehr69",
  "idMobile": "1-508-337-4557",
  "idType": "6tv9yp",
  "namePy": "le1579",
  "sname": "julian.ortiz",
  "nameEn": "x8edg2",
  "searchCode": "58719",
  "sex": "2e0vjh",
  "birthday": "2026-03-09 00:09:53",
  "postCode": "58719",
  "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "nativePlace": "8t2w5q",
  "familyAddress": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "homeTel": "s9qbvq",
  "qqNo": "u87f52",
  "weixinId": "95",
  "weiboId": "95",
  "spareMobile": "1-508-337-4557",
  "isMobileConfirm": true,
  "emergencePhone": "(947) 505-4582",
  "keywords": "pnm7ka",
  "intro": "wic4jy",
  "comefrom": "4kzpog",
  "imagePath": "cqgogb",
  "userSignature": "w6et00",
  "ipRange": "7ek9s1",
  "macCode": "58719",
  "resume": "afg20f",
  "spare1": "w5209x",
  "spare2": "01eqd9",
  "spare3": "r8gcdv",
  "spare4": "fkgk3v"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "6700kp",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "diroew",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

## 基础用户读写控制类
### Get BaseUser list. 获取基础用户列表或分页, 返回BaseUser对象.
**URL:** https://linlan.net/eframe_backend/api/system/baseuser/list.do

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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuser/list.do?searchCode=58719&xzqhId=300&key=idz5g1&createType=103&lastAppId=95&endTime=2026-03-09 00:08:33&createTime=2026-03-09 00:08:33&bindOrganType=o8l9lq&isBindFrontUser=kpjg1t&description=pouuhr&workUserId=95&source=826&page=1&spare2=2evk3x&startTime=2026-03-09 00:08:33&limit=10&email=columbus.ankunding@gmail.com&q=9oiwa3&registerTime=2026-03-09 00:09:55&orderBy=863&srcCode=733&username=julian.ortiz&delFlag=9&bindOrganId=95&ids=hk5zq6&ids=hk5zq6&spare1=cl1tav&mobile=1-508-337-4557
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
└─activation|boolean|是否激活0否1是，是否需要更改密码0否1是|-
└─activationCode|string|激活代码|-
└─priority|int32|排序|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─deleteTime|string|删除时间|-
└─description|string|描述|-
└─spare1|string|备用1，第三方用户ID，UnionId|-
└─spare2|string|备用2，第三方用户ID，OpenId|-
└─newPassword|string|新密码|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:55",
      "lastTime": "2026-03-09 00:09:55",
      "id": "95",
      "xzqhId": 196,
      "source": "6lv82k",
      "createType": 472,
      "username": "julian.ortiz",
      "mobile": "1-508-337-4557",
      "email": "columbus.ankunding@gmail.com",
      "password": "99g7ab",
      "salt": "4wwrzx",
      "srcCode": 892,
      "registerTime": "2026-03-09 00:09:55",
      "registerIp": "207.227.60.208",
      "currentLoginTime": "2026-03-09 00:09:55",
      "currentLoginIp": "207.227.60.208",
      "lastAppId": "95",
      "lastLoginTime": "2026-03-09 00:09:55",
      "lastLoginIp": "207.227.60.208",
      "lastLogoutTime": "2026-03-09 00:09:55",
      "loginCount": 948,
      "resetKey": "g2snpm",
      "resetPwd": "pinpwk",
      "lastResetTime": "2026-03-09 00:09:55",
      "errorTime": "2026-03-09 00:09:55",
      "errorCount": 776,
      "errorIp": "207.227.60.208",
      "lockTime": "2026-03-09 00:09:55",
      "activation": true,
      "activationCode": "58719",
      "priority": 798,
      "delFlag": 9,
      "deleteTime": "2026-03-09 00:09:55",
      "description": "3frhs4",
      "spare1": "k7ttcf",
      "spare2": "auw0rb",
      "newPassword": "mihk0t"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### Get BaseUser by id. 主键获取基础用户详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/baseuser/{id}.do

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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuser/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
└─activation|boolean|是否激活0否1是，是否需要更改密码0否1是|-
└─activationCode|string|激活代码|-
└─priority|int32|排序|-
└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
└─deleteTime|string|删除时间|-
└─description|string|描述|-
└─spare1|string|备用1，第三方用户ID，UnionId|-
└─spare2|string|备用2，第三方用户ID，OpenId|-
└─newPassword|string|新密码|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:55",
    "lastTime": "2026-03-09 00:09:55",
    "id": "95",
    "xzqhId": 639,
    "source": "jrbbxp",
    "createType": 986,
    "username": "julian.ortiz",
    "mobile": "1-508-337-4557",
    "email": "columbus.ankunding@gmail.com",
    "password": "nasts5",
    "salt": "t63hee",
    "srcCode": 336,
    "registerTime": "2026-03-09 00:09:55",
    "registerIp": "207.227.60.208",
    "currentLoginTime": "2026-03-09 00:09:55",
    "currentLoginIp": "207.227.60.208",
    "lastAppId": "95",
    "lastLoginTime": "2026-03-09 00:09:55",
    "lastLoginIp": "207.227.60.208",
    "lastLogoutTime": "2026-03-09 00:09:55",
    "loginCount": 583,
    "resetKey": "w58mbi",
    "resetPwd": "nw1toa",
    "lastResetTime": "2026-03-09 00:09:55",
    "errorTime": "2026-03-09 00:09:55",
    "errorCount": 363,
    "errorIp": "207.227.60.208",
    "lockTime": "2026-03-09 00:09:55",
    "activation": true,
    "activationCode": "58719",
    "priority": 108,
    "delFlag": 9,
    "deleteTime": "2026-03-09 00:09:55",
    "description": "9ege5l",
    "spare1": "wkq3pt",
    "spare2": "58p9eo",
    "newPassword": "wb31rb"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### BaseUser Operation. 新增基础用户数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/baseuser/save.do

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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|用户ID|false|-
xzqhId|int64|行政区划编号，用户来源地|false|-
source|string|创建来源类型|false|-
createType|int32|创建方式0导入1录入2授权|false|-
username|string|用户名，城市APP市民云的用户名|false|-
mobile|string|手机号码|false|-
email|string|电子邮箱|false|-
password|string|密码|false|-
salt|string|混淆字符|false|-
srcCode|int32|当前来源0缺省1:WEB或PC,2APP21:AndroidAPP,22:IOSAPP,3WAP,4MINI|false|-
registerTime|string|注册时间|false|-
registerIp|string|注册IP|false|-
currentLoginTime|string|当前登录时间|false|-
currentLoginIp|string|当前登录IP|false|-
lastAppId|string|最后登录的应用ID|false|-
lastLoginTime|string|最后登录时间|false|-
lastLoginIp|string|最后登录IP|false|-
lastLogoutTime|string|最后一次退出时间|false|-
loginCount|int32|登录次数|false|-
resetKey|string|重置密码KEY|false|-
resetPwd|string|重置密码VALUE|false|-
lastResetTime|string|上次修改密码时间，最后一次修改密码时间|false|-
errorTime|string|出错时间|false|-
errorCount|int32|出错数量|false|-
errorIp|string|出错IP|false|-
lockTime|string|锁定时间|false|-
activation|boolean|是否激活0否1是，是否需要更改密码0否1是|false|-
activationCode|string|激活代码|false|-
priority|int32|排序|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
deleteTime|string|删除时间|false|-
description|string|描述|false|-
spare1|string|备用1，第三方用户ID，UnionId|false|-
spare2|string|备用2，第三方用户ID，OpenId|false|-
newPassword|string|新密码|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuser/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:55",
  "lastTime": "2026-03-09 00:09:55",
  "id": "95",
  "xzqhId": 170,
  "source": "fomp3j",
  "createType": 705,
  "username": "julian.ortiz",
  "mobile": "1-508-337-4557",
  "email": "columbus.ankunding@gmail.com",
  "password": "0isi5b",
  "salt": "fujgqu",
  "srcCode": 483,
  "registerTime": "2026-03-09 00:09:55",
  "registerIp": "207.227.60.208",
  "currentLoginTime": "2026-03-09 00:09:55",
  "currentLoginIp": "207.227.60.208",
  "lastAppId": "95",
  "lastLoginTime": "2026-03-09 00:09:55",
  "lastLoginIp": "207.227.60.208",
  "lastLogoutTime": "2026-03-09 00:09:55",
  "loginCount": 669,
  "resetKey": "mc9y45",
  "resetPwd": "k0b0x2",
  "lastResetTime": "2026-03-09 00:09:55",
  "errorTime": "2026-03-09 00:09:55",
  "errorCount": 145,
  "errorIp": "207.227.60.208",
  "lockTime": "2026-03-09 00:09:55",
  "activation": true,
  "activationCode": "58719",
  "priority": 55,
  "delFlag": 9,
  "deleteTime": "2026-03-09 00:09:55",
  "description": "j61zxx",
  "spare1": "pillqp",
  "spare2": "xk80qs",
  "newPassword": "4ts81m"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "7sp3an",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### BaseUser Operation. 修改基础用户数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/baseuser/update.do

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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|用户ID|false|-
xzqhId|int64|行政区划编号，用户来源地|false|-
source|string|创建来源类型|false|-
createType|int32|创建方式0导入1录入2授权|false|-
username|string|用户名，城市APP市民云的用户名|false|-
mobile|string|手机号码|false|-
email|string|电子邮箱|false|-
password|string|密码|false|-
salt|string|混淆字符|false|-
srcCode|int32|当前来源0缺省1:WEB或PC,2APP21:AndroidAPP,22:IOSAPP,3WAP,4MINI|false|-
registerTime|string|注册时间|false|-
registerIp|string|注册IP|false|-
currentLoginTime|string|当前登录时间|false|-
currentLoginIp|string|当前登录IP|false|-
lastAppId|string|最后登录的应用ID|false|-
lastLoginTime|string|最后登录时间|false|-
lastLoginIp|string|最后登录IP|false|-
lastLogoutTime|string|最后一次退出时间|false|-
loginCount|int32|登录次数|false|-
resetKey|string|重置密码KEY|false|-
resetPwd|string|重置密码VALUE|false|-
lastResetTime|string|上次修改密码时间，最后一次修改密码时间|false|-
errorTime|string|出错时间|false|-
errorCount|int32|出错数量|false|-
errorIp|string|出错IP|false|-
lockTime|string|锁定时间|false|-
activation|boolean|是否激活0否1是，是否需要更改密码0否1是|false|-
activationCode|string|激活代码|false|-
priority|int32|排序|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
deleteTime|string|删除时间|false|-
description|string|描述|false|-
spare1|string|备用1，第三方用户ID，UnionId|false|-
spare2|string|备用2，第三方用户ID，OpenId|false|-
newPassword|string|新密码|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuser/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:55",
  "lastTime": "2026-03-09 00:09:55",
  "id": "95",
  "xzqhId": 713,
  "source": "ozm0yg",
  "createType": 582,
  "username": "julian.ortiz",
  "mobile": "1-508-337-4557",
  "email": "columbus.ankunding@gmail.com",
  "password": "mlcmgu",
  "salt": "1hy3ei",
  "srcCode": 89,
  "registerTime": "2026-03-09 00:09:55",
  "registerIp": "207.227.60.208",
  "currentLoginTime": "2026-03-09 00:09:55",
  "currentLoginIp": "207.227.60.208",
  "lastAppId": "95",
  "lastLoginTime": "2026-03-09 00:09:55",
  "lastLoginIp": "207.227.60.208",
  "lastLogoutTime": "2026-03-09 00:09:55",
  "loginCount": 593,
  "resetKey": "ribbj4",
  "resetPwd": "je7sv5",
  "lastResetTime": "2026-03-09 00:09:55",
  "errorTime": "2026-03-09 00:09:55",
  "errorCount": 922,
  "errorIp": "207.227.60.208",
  "lockTime": "2026-03-09 00:09:55",
  "activation": true,
  "activationCode": "58719",
  "priority": 79,
  "delFlag": 9,
  "deleteTime": "2026-03-09 00:09:55",
  "description": "ilsz5c",
  "spare1": "p9qq3d",
  "spare2": "fo5qcq",
  "newPassword": "s1efgh"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "3j6a61",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### BaseUser Operation. 删除基础用户数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/baseuser/delete/{ids}.do

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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuser/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "tmwixq",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### Get BaseUserExt list. 获取基础用户扩展信息列表或分页, 返回BaseUserExt对象.
**URL:** https://linlan.net/eframe_backend/api/system/baseuserext/list.do

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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuserext/list.do?idMobile=1-508-337-4557&searchCode=58719&spare3=94h85t&page=1&spare1=upy32s&intro=bvgzkm&sex=5yxq3l&postCode=58719&comefrom=e44ebd&qqNo=z91tit&sname=julian.ortiz&spareMobile=1-508-337-4557&spare4=cfn7gy&idType=xrrzqs&endTime=2026-03-09 00:08:33&nameEn=dgvmve&weixinId=95&familyAddress=Suite 395 2647 Romaguera Court， North Dewey， NE 11167&startTime=2026-03-09 00:08:33&isMobileConfirm=true&address=Suite 395 2647 Romaguera Court， North Dewey， NE 11167&nickname=shane.roberts&homeTel=smnmda&q=3rzr6e&namePy=kdatzh&birthday=2026-03-09 00:09:55&nativePlace=7hfm3l&limit=10&emergencePhone=(947) 505-4582&spare2=2t0dk6&idNum=pie8nq&keywords=kyl40c&name=julian.ortiz&orderBy=408&ids=wj1ktp&ids=wj1ktp
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
└─isMobileConfirm|boolean|手机号码是否验证0否1是，是否实名认证|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:55",
      "lastTime": "2026-03-09 00:09:55",
      "id": "95",
      "nickname": "shane.roberts",
      "idName": "julian.ortiz",
      "idNum": "likl0l",
      "idMobile": "1-508-337-4557",
      "idType": "vp7q7d",
      "namePy": "6adgh1",
      "sname": "julian.ortiz",
      "nameEn": "quyonp",
      "searchCode": "58719",
      "sex": "1mkcw3",
      "birthday": "2026-03-09 00:09:55",
      "postCode": "58719",
      "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
      "nativePlace": "6bghg9",
      "familyAddress": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
      "homeTel": "3bdvur",
      "qqNo": "3mvr7l",
      "weixinId": "95",
      "weiboId": "95",
      "spareMobile": "1-508-337-4557",
      "isMobileConfirm": true,
      "emergencePhone": "(947) 505-4582",
      "keywords": "bj9tt3",
      "intro": "x2n9kb",
      "comefrom": "fv9t7v",
      "imagePath": "ro9r44",
      "userSignature": "p4cso2",
      "ipRange": "vxz72t",
      "macCode": "58719",
      "resume": "y9pj7u",
      "spare1": "ro8jn4",
      "spare2": "k5rva0",
      "spare3": "fy75q1",
      "spare4": "mk1wnr"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### Get BaseUserExt by id. 主键获取基础用户扩展信息详细信息.
**URL:** https://linlan.net/eframe_backend/api/system/baseuserext/{id}.do

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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuserext/1.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
└─isMobileConfirm|boolean|手机号码是否验证0否1是，是否实名认证|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:55",
    "lastTime": "2026-03-09 00:09:55",
    "id": "95",
    "nickname": "shane.roberts",
    "idName": "julian.ortiz",
    "idNum": "8zr7r6",
    "idMobile": "1-508-337-4557",
    "idType": "5xlvzw",
    "namePy": "oiy8h7",
    "sname": "julian.ortiz",
    "nameEn": "69j7sk",
    "searchCode": "58719",
    "sex": "whlh5s",
    "birthday": "2026-03-09 00:09:55",
    "postCode": "58719",
    "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
    "nativePlace": "bok6qp",
    "familyAddress": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
    "homeTel": "xuwmak",
    "qqNo": "z4k54l",
    "weixinId": "95",
    "weiboId": "95",
    "spareMobile": "1-508-337-4557",
    "isMobileConfirm": true,
    "emergencePhone": "(947) 505-4582",
    "keywords": "oeesfd",
    "intro": "84zmgk",
    "comefrom": "e91cka",
    "imagePath": "gstz7u",
    "userSignature": "8uv60l",
    "ipRange": "s2uf30",
    "macCode": "58719",
    "resume": "4t8gx2",
    "spare1": "duxi8u",
    "spare2": "dhts0c",
    "spare3": "of8hai",
    "spare4": "4falem"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### BaseUserExt Operation. 新增基础用户扩展信息数据操作逻辑，根据操作类型，执行新增操作.
**URL:** https://linlan.net/eframe_backend/api/system/baseuserext/save.do

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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|用户ID|false|-
nickname|string|用户昵称|false|-
idName|string|真实姓名，加密的姓名|false|-
idNum|string|身份证号码，加密的身份证号码|false|-
idMobile|string|电话|false|-
idType|string|证件类型|false|-
namePy|string|姓名全拼，BCryptPasswordEncoder密码")|false|-
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
qqNo|string|即时通讯QQ号码|false|-
weixinId|string|微信用户名|false|-
weiboId|string|微博用户名|false|-
spareMobile|string|备用手机，紧急手机|false|-
isMobileConfirm|boolean|手机号码是否验证0否1是，是否实名认证|false|-
emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|false|-
keywords|string|关键字|false|-
intro|string|个人介绍|false|-
comefrom|string|来自|false|-
imagePath|string|用户图像图标|false|-
userSignature|string|用户签名|false|-
ipRange|string|登录IP地址(";"分隔）|false|-
macCode|string|允许登录MAC地址(";"分隔）|false|-
resume|string|简历，网格平台使用，人所属的网格多个，分隔|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
spare3|string|备用3|false|-
spare4|string|备用4|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuserext/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:55",
  "lastTime": "2026-03-09 00:09:55",
  "id": "95",
  "nickname": "shane.roberts",
  "idName": "julian.ortiz",
  "idNum": "i2kmub",
  "idMobile": "1-508-337-4557",
  "idType": "hxd5c4",
  "namePy": "aj8w71",
  "sname": "julian.ortiz",
  "nameEn": "tuu5km",
  "searchCode": "58719",
  "sex": "kkz24z",
  "birthday": "2026-03-09 00:09:55",
  "postCode": "58719",
  "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "nativePlace": "y3q6qo",
  "familyAddress": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "homeTel": "qe2g5s",
  "qqNo": "gyvt2o",
  "weixinId": "95",
  "weiboId": "95",
  "spareMobile": "1-508-337-4557",
  "isMobileConfirm": true,
  "emergencePhone": "(947) 505-4582",
  "keywords": "iplgq8",
  "intro": "zkmzdy",
  "comefrom": "8uwz5y",
  "imagePath": "al0yg6",
  "userSignature": "hnsheh",
  "ipRange": "epu6bt",
  "macCode": "58719",
  "resume": "ym2w91",
  "spare1": "tg44j3",
  "spare2": "v6el3j",
  "spare3": "l9h4pc",
  "spare4": "4itn36"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "1cc4lz",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### BaseUserExt Operation. 修改基础用户扩展信息数据操作逻辑，根据操作类型，执行修改操作.
**URL:** https://linlan.net/eframe_backend/api/system/baseuserext/update.do

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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|用户ID|false|-
nickname|string|用户昵称|false|-
idName|string|真实姓名，加密的姓名|false|-
idNum|string|身份证号码，加密的身份证号码|false|-
idMobile|string|电话|false|-
idType|string|证件类型|false|-
namePy|string|姓名全拼，BCryptPasswordEncoder密码")|false|-
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
qqNo|string|即时通讯QQ号码|false|-
weixinId|string|微信用户名|false|-
weiboId|string|微博用户名|false|-
spareMobile|string|备用手机，紧急手机|false|-
isMobileConfirm|boolean|手机号码是否验证0否1是，是否实名认证|false|-
emergencePhone|string|紧急电话，外部输入填写的身份证号码，外部导入或临时处理的身份证号码|false|-
keywords|string|关键字|false|-
intro|string|个人介绍|false|-
comefrom|string|来自|false|-
imagePath|string|用户图像图标|false|-
userSignature|string|用户签名|false|-
ipRange|string|登录IP地址(";"分隔）|false|-
macCode|string|允许登录MAC地址(";"分隔）|false|-
resume|string|简历，网格平台使用，人所属的网格多个，分隔|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
spare3|string|备用3|false|-
spare4|string|备用4|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuserext/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:55",
  "lastTime": "2026-03-09 00:09:55",
  "id": "95",
  "nickname": "shane.roberts",
  "idName": "julian.ortiz",
  "idNum": "od0l9b",
  "idMobile": "1-508-337-4557",
  "idType": "n4ybx2",
  "namePy": "74smbi",
  "sname": "julian.ortiz",
  "nameEn": "nhijud",
  "searchCode": "58719",
  "sex": "zlhpov",
  "birthday": "2026-03-09 00:09:55",
  "postCode": "58719",
  "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "nativePlace": "98m8w7",
  "familyAddress": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "homeTel": "mpa9ih",
  "qqNo": "geyd4j",
  "weixinId": "95",
  "weiboId": "95",
  "spareMobile": "1-508-337-4557",
  "isMobileConfirm": true,
  "emergencePhone": "(947) 505-4582",
  "keywords": "zu7q5r",
  "intro": "jmd82r",
  "comefrom": "2js8a3",
  "imagePath": "lxpn63",
  "userSignature": "df6vdm",
  "ipRange": "uwrmj9",
  "macCode": "58719",
  "resume": "idg3ts",
  "spare1": "2nazot",
  "spare2": "74kmz2",
  "spare3": "9cnyf8",
  "spare4": "bws3b1"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "4v2gpw",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### BaseUserExt Operation. 删除基础用户扩展信息数据操作逻辑，根据操作类型，执行删除操作.
**URL:** https://linlan.net/eframe_backend/api/system/baseuserext/delete/{ids}.do

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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/baseuserext/delete/.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "9rs6gc",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list.do?recvGroupId=95&updateTime=2026-03-09 00:09:48&imagePath=l8bqj7&description=wpbsns&status=543&readStatus=h63ej9&updatorId=95&q=lfg8n3&creatorId=95&appId=95&bizType=eqtupz&organId=95&limit=10&startTime=2026-03-09 00:08:33&recvOrganId=95&id=145&msgUrl=www.kandace-stamm.org&iconStyle=39ud99&recvTargetid=95&page=1&content=stsq92&foreignId=95&endTime=2026-03-09 00:08:33&type=447&recvMemberId=95&orderBy=10&title=hzrn3y
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:48",
      "lastTime": "2026-03-09 00:09:48",
      "id": 272,
      "appId": "95",
      "organId": "95",
      "bizType": "ip4rj9",
      "type": 805,
      "title": "06mj2p",
      "content": "a4c9vv",
      "msgUrl": "www.kandace-stamm.org",
      "foreignId": "95",
      "imagePath": "qk8z8c",
      "iconStyle": "orlx8x",
      "recvMemberId": "95",
      "recvGroupId": "95",
      "recvOrganId": "95",
      "recvTargetid": "95",
      "status": 843,
      "updatorId": "95",
      "updateTime": "2026-03-09 00:09:48",
      "description": "mxv894"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list/myself.do?updatorId=95&id=357&startTime=2026-03-09 00:08:33&status=710&organId=95&recvTargetid=95&readStatus=y9dht7&appId=95&type=33&updateTime=2026-03-09 00:09:48&q=g2yc2r&page=1&recvOrganId=95&content=kj0y0y&description=j2rgs3&limit=10&recvGroupId=95&endTime=2026-03-09 00:08:33&orderBy=912&msgUrl=www.kandace-stamm.org&bizType=vzgsbi&imagePath=0kpzio&recvMemberId=95&foreignId=95&title=9qpdal&creatorId=95&iconStyle=sgifr2
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:48",
      "lastTime": "2026-03-09 00:09:48",
      "id": 114,
      "appId": "95",
      "organId": "95",
      "bizType": "22ctj4",
      "type": 453,
      "title": "a1py0c",
      "content": "jlswpp",
      "msgUrl": "www.kandace-stamm.org",
      "foreignId": "95",
      "imagePath": "4ocs4n",
      "iconStyle": "14ldnu",
      "recvMemberId": "95",
      "recvGroupId": "95",
      "recvOrganId": "95",
      "recvTargetid": "95",
      "status": 910,
      "updatorId": "95",
      "updateTime": "2026-03-09 00:09:48",
      "description": "g3ri44"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/export.do --data 'writer.psOut.closed=true&endTime=2026-03-09 00:08:33&recvOrganId=95&updatorId=95&msgUrl=www.kandace-stamm.org&readStatus=23gkjo&writer.writeBuffer=z&writer.writeBuffer=z&committed=true&orderBy=727&iconStyle=bsw9mn&recvMemberId=95&characterEncoding=dgeqbv&writer.psOut.autoFlush=true&writer.psOut.closing=true&writer.formatter.lastException.detailMessage=success&bizType=a0uwkd&appId=95&writer.psOut.textOut.nChars=544&recvTargetid=95&writer.psOut.trouble=true&status=859&limit=10&writer.trouble=true&title=rzlyuq&bufferSize=10&organId=95&contentType=2b02jp&writer.formatter.zero=p&page=1&startTime=2026-03-09 00:08:33&creatorId=95&content=ndrsuc&imagePath=t0dnrh&writer.psOut.formatter.zero=r&updateTime=2026-03-09 00:09:48&type=796&recvGroupId=95&status=339&description=flp4v1&writer.psOut.textOut.nextChar=356&writer.autoFlush=true&foreignId=95&q=fqigad&id=916'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "gh7n0u",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:48",
    "lastTime": "2026-03-09 00:09:48",
    "id": 494,
    "appId": "95",
    "organId": "95",
    "bizType": "urrw98",
    "type": 813,
    "title": "d700io",
    "content": "jhn1pc",
    "msgUrl": "www.kandace-stamm.org",
    "foreignId": "95",
    "imagePath": "vf3b4b",
    "iconStyle": "sbix0h",
    "recvMemberId": "95",
    "recvGroupId": "95",
    "recvOrganId": "95",
    "recvTargetid": "95",
    "status": 483,
    "updatorId": "95",
    "updateTime": "2026-03-09 00:09:48",
    "description": "jwpji3"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
updatorId|string|维护管理用户ID|false|-
updateTime|string|修改时间|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:48",
  "lastTime": "2026-03-09 00:09:48",
  "id": 605,
  "appId": "95",
  "organId": "95",
  "bizType": "m09w34",
  "type": 309,
  "title": "x36gye",
  "content": "axsl0e",
  "msgUrl": "www.kandace-stamm.org",
  "foreignId": "95",
  "imagePath": "odzn08",
  "iconStyle": "vvrxw9",
  "recvMemberId": "95",
  "recvGroupId": "95",
  "recvOrganId": "95",
  "recvTargetid": "95",
  "status": 500,
  "updatorId": "95",
  "updateTime": "2026-03-09 00:09:48",
  "description": "qasgf1"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "9qbofc",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
updatorId|string|维护管理用户ID|false|-
updateTime|string|修改时间|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:48",
  "lastTime": "2026-03-09 00:09:48",
  "id": 382,
  "appId": "95",
  "organId": "95",
  "bizType": "uzy0a9",
  "type": 870,
  "title": "ghkgmk",
  "content": "ascp6l",
  "msgUrl": "www.kandace-stamm.org",
  "foreignId": "95",
  "imagePath": "qzs8w1",
  "iconStyle": "cdjezm",
  "recvMemberId": "95",
  "recvGroupId": "95",
  "recvOrganId": "95",
  "recvTargetid": "95",
  "status": 978,
  "updatorId": "95",
  "updateTime": "2026-03-09 00:09:48",
  "description": "pm3v0g"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ndiun2",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ylx156",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "9uowcm",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "swu99k",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "f7h8km",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "mapKey1": "sii30u",
    "mapKey2": "r8zbcp"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

## 平台账号信息读写控制类
### Get CoreAccount list. 获取平台账号信息列表或分页, 返回CoreAccount对象.
**URL:** https://linlan.net/eframe_backend/api/system/account/list.do

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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/list.do?name=julian.ortiz&spare1=8l75s5&page=1&limit=10&aesKey=mgpjw6&cname=julian.ortiz&aesIvKey=dl5kjt&serverConf1=dla4ol&isDisabled=true&confLimit=10&startTime=2026-03-09 00:08:33&appId=95&endTime=2026-03-09 00:08:33&clientId=95&type=551&currCount=868&orderBy=521&serverType=a6sk29&organId=95&status=196&organName=julian.ortiz&q=gjkn8m&spare2=l07tmj&serverConf2=xm2zia&serverUrl=www.kandace-stamm.org&isAdmin=true&serverIp=207.227.60.208&clientSecret=5ishkw&serverConf3=ugnkj3&id=95&isSingle=true&description=01z3dz&inoutMode=955
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:54",
      "lastTime": "2026-03-09 00:09:54",
      "id": "95",
      "organId": "95",
      "appId": "95",
      "organName": "julian.ortiz",
      "inoutMode": 484,
      "name": "julian.ortiz",
      "cname": "julian.ortiz",
      "type": 105,
      "clientId": "95",
      "clientSecret": "kzewpl",
      "aesKey": "ftiavm",
      "aesIvKey": "gxdknd",
      "serverIp": "207.227.60.208",
      "serverType": "tnvrvz",
      "serverUrl": "www.kandace-stamm.org",
      "serverConf1": "qzgo8v",
      "serverConf2": "u88jui",
      "serverConf3": "i8lg7o",
      "currCount": 446,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 696,
      "description": "626mfj",
      "spare1": "ld6wv4",
      "spare2": "cgzp23",
      "inOrganName": "julian.ortiz",
      "userName": "julian.ortiz",
      "appName": "julian.ortiz",
      "inoutModeName": "julian.ortiz",
      "typeName": "julian.ortiz"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 平台账户生成密钥对
**URL:** https://linlan.net/eframe_backend/api/system/account/getClientSecret.do

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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/getClientSecret.do?clientId=95
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:54",
      "lastTime": "2026-03-09 00:09:54",
      "id": "95",
      "organId": "95",
      "appId": "95",
      "organName": "julian.ortiz",
      "inoutMode": 267,
      "name": "julian.ortiz",
      "cname": "julian.ortiz",
      "type": 149,
      "clientId": "95",
      "clientSecret": "qcvsmz",
      "aesKey": "f2v8xq",
      "aesIvKey": "ptsagz",
      "serverIp": "207.227.60.208",
      "serverType": "bmd58o",
      "serverUrl": "www.kandace-stamm.org",
      "serverConf1": "oc7ee8",
      "serverConf2": "ucglqf",
      "serverConf3": "noe6s1",
      "currCount": 837,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 625,
      "description": "sqzi0r",
      "spare1": "ovmum9",
      "spare2": "npxwya",
      "inOrganName": "julian.ortiz",
      "userName": "julian.ortiz",
      "appName": "julian.ortiz",
      "inoutModeName": "julian.ortiz",
      "typeName": "julian.ortiz"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 生成平台密钥对
**URL:** https://linlan.net/eframe_backend/api/system/account/getKeyParity.do

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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/getKeyParity.do?id=95
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:54",
      "lastTime": "2026-03-09 00:09:54",
      "id": "95",
      "organId": "95",
      "appId": "95",
      "organName": "julian.ortiz",
      "inoutMode": 399,
      "name": "julian.ortiz",
      "cname": "julian.ortiz",
      "type": 207,
      "clientId": "95",
      "clientSecret": "t2jtqr",
      "aesKey": "pls17r",
      "aesIvKey": "z5phtg",
      "serverIp": "207.227.60.208",
      "serverType": "xgd3b8",
      "serverUrl": "www.kandace-stamm.org",
      "serverConf1": "ppdc5s",
      "serverConf2": "525uhs",
      "serverConf3": "5vlyvk",
      "currCount": 925,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 354,
      "description": "xgox63",
      "spare1": "bqc7dh",
      "spare2": "df8x3c",
      "inOrganName": "julian.ortiz",
      "userName": "julian.ortiz",
      "appName": "julian.ortiz",
      "inoutModeName": "julian.ortiz",
      "typeName": "julian.ortiz"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
{"success":true,"code":0,"msg":"正常","data":Error restful return.,"requestId":"95","timestamp":"2026-03-09 00:08:33"}
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "2tff4t",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ydyp5v",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "1zkyoe",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 获取社交授权平台账号列表
**URL:** https://linlan.net/eframe_backend/api/system/account/authlist.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-11-19 14:58:36

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取社交授权平台账号列表

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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/authlist.do?serverConf2=fycqiu&limit=10&serverConf3=ao5u09&startTime=2026-03-09 00:08:33&serverType=n8qds6&currCount=9&isSingle=true&type=570&serverConf1=vabta7&inoutMode=934&cname=julian.ortiz&spare2=q3fimf&status=874&clientSecret=55vfbw&isDisabled=true&name=julian.ortiz&orderBy=990&q=hyf06e&endTime=2026-03-09 00:08:33&aesIvKey=hqdong&appId=95&isAdmin=true&serverIp=207.227.60.208&spare1=b7e5wg&serverUrl=www.kandace-stamm.org&page=1&clientId=95&aesKey=1v1su1&description=hjlhic&id=95&confLimit=10&organName=julian.ortiz&organId=95
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:54",
      "lastTime": "2026-03-09 00:09:54",
      "id": "95",
      "organId": "95",
      "appId": "95",
      "organName": "julian.ortiz",
      "inoutMode": 66,
      "name": "julian.ortiz",
      "cname": "julian.ortiz",
      "type": 949,
      "clientId": "95",
      "clientSecret": "wrb7rm",
      "aesKey": "47pqtn",
      "aesIvKey": "ndqsjy",
      "serverIp": "207.227.60.208",
      "serverType": "aobirw",
      "serverUrl": "www.kandace-stamm.org",
      "serverConf1": "z0akjo",
      "serverConf2": "oas50r",
      "serverConf3": "0pu712",
      "currCount": 850,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 910,
      "description": "j2p22v",
      "spare1": "zrqx42",
      "spare2": "vx0qxw",
      "inOrganName": "julian.ortiz",
      "userName": "julian.ortiz",
      "appName": "julian.ortiz",
      "inoutModeName": "julian.ortiz",
      "typeName": "julian.ortiz"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "y3iheu",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/application.do?startTime=2026-03-09 00:08:33&limit=10&page=1&q=ficz9f&orderBy=926&endTime=2026-03-09 00:08:33
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "organNum": "7qce40",
      "deptNum": "7iaifh",
      "peopleNum": "pqjvik",
      "roleNum": "3q8bly",
      "dicTypeNum": "ml9mo5",
      "appNum": "9u4bhg",
      "fileNum": "g7qq1k",
      "paramNum": "ayyg1q"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/element.do?orderBy=332&q=zxozr0&startTime=2026-03-09 00:08:33&endTime=2026-03-09 00:08:33&page=1&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "objectNum": "l1a09a",
      "modelNum": "u2l6qy"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/manage.do?startTime=2026-03-09 00:08:33&limit=10&orderBy=347&endTime=2026-03-09 00:08:33&q=jp1zlu&page=1
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|array|返回数据对象|-
└─appNum|string|应用数|-
└─accountNum|string|平台账户数|-
└─serviceOrganNum|string|服务商数|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "appNum": "5dq2qu",
      "accountNum": "vuncbk",
      "serviceOrganNum": "7iqc16"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/selectList.do?path=dju1nv&startTime=2026-03-09 00:08:33&endTime=2026-03-09 00:08:33&page=1&orderBy=630&mode=769&isDisabled=true&status=423&domainId=95&organId=95&limit=10&ftpId=95&q=3zitfg&isSite=true&delFlag=9&appType=h4rssz&existKey=9bztfp&description=li324c&ids=q5hpy3&ids=q5hpy3&name=julian.ortiz&sertypeId=95&isMobileApp=true&xzqhId=549
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:50",
      "lastTime": "2026-03-09 00:09:50",
      "id": "95",
      "ftpId": "95",
      "domainId": "95",
      "organId": "95",
      "xzqhId": 118,
      "sertypeId": "95",
      "name": "julian.ortiz",
      "path": "zs8n2w",
      "appType": "bhxd36",
      "isSite": true,
      "isDisabled": true,
      "isMobileApp": true,
      "status": 912,
      "priority": 815,
      "delFlag": 9,
      "deleteTime": "2026-03-09 00:09:50",
      "description": "1ifo7b",
      "spare1": "ye72s4",
      "spare2": "mndk6n",
      "xzqhName": "julian.ortiz"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/list.do?startTime=2026-03-09 00:08:33&sertypeId=95&delFlag=9&q=lz7752&limit=10&mode=959&name=julian.ortiz&xzqhId=369&isSite=true&appType=yagy83&existKey=6lq64a&endTime=2026-03-09 00:08:33&orderBy=262&page=1&organId=95&ftpId=95&path=jxm955&isDisabled=true&description=x85bzd&domainId=95&isMobileApp=true&status=309&ids=39vrm1&ids=39vrm1&idArr=d1yt87
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 5,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:51",
        "lastTime": "2026-03-09 00:09:51",
        "id": "95",
        "ftpId": "95",
        "domainId": "95",
        "organId": "95",
        "xzqhId": 523,
        "sertypeId": "95",
        "name": "julian.ortiz",
        "path": "2cqi6r",
        "appType": "el4qqc",
        "isSite": true,
        "isDisabled": true,
        "isMobileApp": true,
        "status": 78,
        "priority": 183,
        "delFlag": 9,
        "deleteTime": "2026-03-09 00:09:51",
        "description": "6eyaw9",
        "spare1": "uryf61",
        "spare2": "ol28wq",
        "xzqhName": "julian.ortiz"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/export.do --data 'committed=true&page=1&status=352&writer.writeBuffer=a&writer.writeBuffer=a&writer.formatter.lastException.detailMessage=success&q=iddao7&domainId=95&sertypeId=95&isDisabled=true&writer.trouble=true&writer.psOut.autoFlush=true&name=julian.ortiz&organId=95&isSite=true&ids=mmljcn&ids=mmljcn&writer.psOut.formatter.zero=x&idArr=wgt2z5&writer.psOut.closing=true&endTime=2026-03-09 00:08:33&writer.psOut.trouble=true&status=956&writer.autoFlush=true&existKey=jp22af&limit=10&bufferSize=10&writer.psOut.textOut.nextChar=454&ftpId=95&characterEncoding=qf7aly&writer.psOut.closed=true&path=k5a169&description=kwjk8d&orderBy=628&appType=skedmu&xzqhId=782&writer.psOut.textOut.nChars=964&delFlag=9&contentType=rj09l4&writer.formatter.zero=m&startTime=2026-03-09 00:08:33&isMobileApp=true&mode=377'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "3r0qbh",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/95.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:51",
    "lastTime": "2026-03-09 00:09:51",
    "id": "95",
    "ftpId": "95",
    "domainId": "95",
    "organId": "95",
    "xzqhId": 948,
    "sertypeId": "95",
    "name": "julian.ortiz",
    "path": "hkqh5a",
    "appType": "off7zi",
    "isSite": true,
    "isDisabled": true,
    "isMobileApp": true,
    "status": 612,
    "priority": 65,
    "delFlag": 9,
    "deleteTime": "2026-03-09 00:09:51",
    "description": "ewdxur",
    "spare1": "u8h3mq",
    "spare2": "16t8yd",
    "xzqhName": "julian.ortiz",
    "ftpName": "julian.ortiz",
    "sertypeName": "julian.ortiz",
    "domainName": "julian.ortiz",
    "organName": "julian.ortiz"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
id|string|应用ID|false|-
ftpId|string|文件上传配置ID|false|-
ftpName|string|资源仓库名称|false|-
domainId|string|域平台编号|false|-
domainName|string|域平台名称|false|-
organId|string|单位编码，所属单位，管理单位|false|-
organName|string|机构名称|false|-
xzqhId|int64|应用适用顶级行政区划ID|false|-
xzqhName|string|应用适用顶级行政区划名称|false|-
sertypeId|string|应用服务类型ID|false|-
name|string|应用名称|false|-
path|string|应用访问路径|false|-
appType|string|应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选|false|-
isSite|boolean|是否站点，如果是站点，则SITE内存在记录|false|-
isOpen|boolean|是否启用0否1是|false|-
isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|false|-
status|int32|状态0异常关闭1正常2升级3锁定|false|-
statusName|string|状态，0异常关闭1正常2升级|false|-
priority|int32|排序|false|-
createTime|string|创建时间|false|-
description|string|描述|false|-
spare1|string|备用1，LOGO图标|false|-
statusMap|object|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/save.do --data '{
  "id": "95",
  "ftpId": "95",
  "ftpName": "julian.ortiz",
  "domainId": "95",
  "domainName": "julian.ortiz",
  "organId": "95",
  "organName": "julian.ortiz",
  "xzqhId": 912,
  "xzqhName": "julian.ortiz",
  "sertypeId": "95",
  "name": "julian.ortiz",
  "path": "mb2lzx",
  "appType": "6f5rz3",
  "isSite": true,
  "isOpen": true,
  "isMobileApp": true,
  "status": 658,
  "statusName": "julian.ortiz",
  "priority": 845,
  "createTime": "2026-03-09 00:09:51",
  "description": "i81e7t",
  "spare1": "7jtbit",
  "statusMap": {
    "mapKey": "p63i8g"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "iot8oz",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
id|string|应用ID|false|-
ftpId|string|文件上传配置ID|false|-
ftpName|string|资源仓库名称|false|-
domainId|string|域平台编号|false|-
domainName|string|域平台名称|false|-
organId|string|单位编码，所属单位，管理单位|false|-
organName|string|机构名称|false|-
xzqhId|int64|应用适用顶级行政区划ID|false|-
xzqhName|string|应用适用顶级行政区划名称|false|-
sertypeId|string|应用服务类型ID|false|-
name|string|应用名称|false|-
path|string|应用访问路径|false|-
appType|string|应用类型，QUANBU全部领域，WORK工作端，H5移动端，SCREEN大屏端；B/S，C/S，独立应用，可多选|false|-
isSite|boolean|是否站点，如果是站点，则SITE内存在记录|false|-
isOpen|boolean|是否启用0否1是|false|-
isMobileApp|boolean|是否为复杂权限应用0否（一般应用APP应用）1是|false|-
status|int32|状态0异常关闭1正常2升级3锁定|false|-
statusName|string|状态，0异常关闭1正常2升级|false|-
priority|int32|排序|false|-
createTime|string|创建时间|false|-
description|string|描述|false|-
spare1|string|备用1，LOGO图标|false|-
statusMap|object|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/update.do --data '{
  "id": "95",
  "ftpId": "95",
  "ftpName": "julian.ortiz",
  "domainId": "95",
  "domainName": "julian.ortiz",
  "organId": "95",
  "organName": "julian.ortiz",
  "xzqhId": 651,
  "xzqhName": "julian.ortiz",
  "sertypeId": "95",
  "name": "julian.ortiz",
  "path": "0kalp1",
  "appType": "dvbu8w",
  "isSite": true,
  "isOpen": true,
  "isMobileApp": true,
  "status": 716,
  "statusName": "julian.ortiz",
  "priority": 908,
  "createTime": "2026-03-09 00:09:51",
  "description": "vh42rj",
  "spare1": "046nrs",
  "statusMap": {
    "mapKey": "g2caz1"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "4igj4u",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "valg63",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
id|string|应用ID，导入和导出的APPID|false|-
menuJsons|object|菜单JSON对象|false|-
└─size|int32|No comments found.|false|-
initJson|object|初始化JSON对象|false|-
username|string|初始化用户名|false|-
password|string|初始化密码|false|-
initPath|string|导入的文件路径|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/init/95.do --data '{
  "id": "95",
  "menuJsons": {
    "size": 10
  },
  "initJson": {},
  "username": "julian.ortiz",
  "password": "insetd",
  "initPath": "7zz4t2"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "waring": "You may have used non-display generics."
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "iy5qpv",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/xzqh/list.do?code=58719&searchCode=58719&rgt=419&deleteTime=2026-03-09 00:08:33&startTime=2026-03-09 00:08:33&limit=10&page=1&sname=julian.ortiz&isDisplay=true&areatypeIds=9v7m7d&areatypeIds=9v7m7d&orderBy=735&nameTotal=jawpfg&delFlag=9&lft=828&likeQuery=037tj2&nameEn=q1tg2h&countryId=95&ids=6evvha&ids=6evvha&areatypeId=95&description=m6i3u9&q=69h36y&name=julian.ortiz&parentId=648&endTime=2026-03-09 00:08:33&hasContent=true&parentIds=ln0lc6&parentIds=ln0lc6
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 653,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:51",
        "lastTime": "2026-03-09 00:09:51",
        "id": 898,
        "parentId": 180,
        "countryId": "95",
        "areatypeId": "95",
        "lft": 195,
        "rgt": 950,
        "code": "58719",
        "name": "julian.ortiz",
        "nameTotal": "2tz019",
        "sname": "julian.ortiz",
        "nameEn": "d9ws1q",
        "searchCode": "58719",
        "isDisplay": true,
        "hasContent": true,
        "priority": 41,
        "delFlag": 9,
        "deleteTime": "2026-03-09 00:09:51",
        "description": "n6cwc1",
        "countryName": "julian.ortiz",
        "parentName": "julian.ortiz",
        "areatypeName": "julian.ortiz"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/organ/list.do?description=vic56c&createType=943&ids=as2z08&ids=as2z08&key=4prqyp&orderBy=781&limit=10&isOrganWork=o2sy6f&orgtypeId=95&source=314&organCode=58719&xzqhId=824&name=julian.ortiz&spare1=kpeeo6&endTime=2026-03-09 00:08:33&page=1&delFlag=9&organName=julian.ortiz&spare2=24yaeq&unionCode=58719&q=ntjpgr&startTime=2026-03-09 00:08:33
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 647,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:51",
        "lastTime": "2026-03-09 00:09:51",
        "cmsKey": "anv8yf",
        "cmsValue": "3l16th"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/list.do?page=1&dictLabel=473ktl&cssClass=xxbb0j&endTime=2026-03-09 00:08:33&isDefault=wcdy5w&orderBy=336&remark=aymjww&searchCode=58719&limit=10&cddValue=7icj2g&startTime=2026-03-09 00:08:33&name=julian.ortiz&key=0cgbdi&typeCode=58719&cddId=610&q=5mwge0&listClass=37fv9f&dictSort=808&status=zcgr4q&parentId=304
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 377,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cddId": 797,
        "typeCode": "58719",
        "parentId": 787,
        "name": "julian.ortiz",
        "sname": "julian.ortiz",
        "cddValue": "nzfuxe",
        "searchCode": "58719",
        "priority": 160,
        "createTime": "2026-03-09 00:09:52",
        "remark": "qh95yo",
        "dictLabel": "69sdq7",
        "typeCodeName": "julian.ortiz",
        "parentName": "julian.ortiz"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/export.do --data 'writer.psOut.textOut.nChars=516&writer.psOut.trouble=true&limit=10&cddId=288&bufferSize=10&typeCode=58719&characterEncoding=a3f6hb&writer.formatter.lastException.detailMessage=success&startTime=2026-03-09 00:08:33&page=1&writer.formatter.zero=1&writer.psOut.autoFlush=true&listClass=p59ygz&status=tz2y74&dictSort=790&orderBy=191&dictLabel=br4md2&writer.psOut.closed=true&writer.psOut.formatter.zero=8&q=i47df6&isDefault=ds2qpy&endTime=2026-03-09 00:08:33&parentId=242&remark=7khfoq&writer.psOut.closing=true&name=julian.ortiz&writer.writeBuffer=3&writer.writeBuffer=3&cddValue=uq3589&writer.trouble=true&committed=true&writer.autoFlush=true&status=12&writer.psOut.textOut.nextChar=594&searchCode=58719&cssClass=0bybtr&key=9uvswa&contentType=fxdljn'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "p69a0c",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/7.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "cddId": 282,
    "typeCode": "58719",
    "parentId": 207,
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "cddValue": "7il38w",
    "searchCode": "58719",
    "priority": 387,
    "createTime": "2026-03-09 00:09:52",
    "remark": "5rq6j7",
    "dictLabel": "my0r66",
    "typeCodeName": "julian.ortiz",
    "parentName": "julian.ortiz"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/type/t67lzt.do?zparentId=95&roletypeId=95&typeCode=58719&parentId=95
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "waring": "You may have used non-display generics."
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
cddId|int64|字典编码|false|-
typeCode|string|字典排序|false|-
parentId|int64|字典标签|false|-
name|string|字典键值|false|-
sname|string|字典类型|false|-
cddValue|string|字典值|false|-
searchCode|string|快速码|false|-
priority|int32|排序码|false|-
createTime|string|创建时间|false|-
remark|string|备注|false|-
dictLabel|string|备注|false|-
typeCodeName|string|类型名称|false|-
parentName|string|父节点名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/save.do --data '{
  "cddId": 394,
  "typeCode": "58719",
  "parentId": 496,
  "name": "julian.ortiz",
  "sname": "julian.ortiz",
  "cddValue": "9a7jbc",
  "searchCode": "58719",
  "priority": 850,
  "createTime": "2026-03-09 00:09:52",
  "remark": "ymscax",
  "dictLabel": "2yovx8",
  "typeCodeName": "julian.ortiz",
  "parentName": "julian.ortiz"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "5tp79y",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
cddId|int64|字典编码|false|-
typeCode|string|字典排序|false|-
parentId|int64|字典标签|false|-
name|string|字典键值|false|-
sname|string|字典类型|false|-
cddValue|string|字典值|false|-
searchCode|string|快速码|false|-
priority|int32|排序码|false|-
createTime|string|创建时间|false|-
remark|string|备注|false|-
dictLabel|string|备注|false|-
typeCodeName|string|类型名称|false|-
parentName|string|父节点名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/update.do --data '{
  "cddId": 671,
  "typeCode": "58719",
  "parentId": 133,
  "name": "julian.ortiz",
  "sname": "julian.ortiz",
  "cddValue": "z415oz",
  "searchCode": "58719",
  "priority": 20,
  "createTime": "2026-03-09 00:09:52",
  "remark": "f4qsat",
  "dictLabel": "s3hs0h",
  "typeCodeName": "julian.ortiz",
  "parentName": "julian.ortiz"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "b6bfkv",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ldgagy",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
refType|string|标签类型过滤|false|-
organId|string|如果传入parentId为空，则通过organId查自身所属机构节点|false|-
metaId|string|用于资源目录管理的字段|false|-
appId|string|应用ID|false|-
status|string|状态|false|-
key|string|名字|false|-
gnType|string|功能类型|false|-
showButton|string|是否显示button，默认不显示|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/comm/tree.do?metaId=95&gnType=tq0gnq&limit=10&status=z0o767&refresh=yx1sa5&roleId=95&appId=95&startTime=2026-03-09 00:08:33&positionId=95&organId=95&parentId=95&page=1&roletypeId=95&showButton=i6tejj&type=z4s2lu&positionType=657vpu&orderBy=382&subType=emh284&refType=o1rza8&wlType=had8bh&endTime=2026-03-09 00:08:33&groupId=95&q=n8mho2&key=61iicd
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "id": "95",
      "label": "puvqif",
      "shortName": "julian.ortiz",
      "organId": "95",
      "areaId": 143,
      "searchCode": "58719",
      "childNum": 130,
      "checked": true,
      "entity": 822,
      "show": true,
      "showIcon": true,
      "parentId": "95",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/tree.do?existKey=u097ut&sname=julian.ortiz&page=1&cddValue=8kz8p7&endTime=2026-03-09 00:08:33&dispFlag=e5e8cn&parentId=619&description=j9a7sf&typeMode=4hqjzo&key=wjl2ab&searchCode=58719&delFlag=9&limit=10&isAllChild=d4feah&typeCodes=xxb5i8&typeCodes=xxb5i8&orderBy=153&ids=ocjdsr&ids=ocjdsr&cddLevel=729w00&q=w2n4hh&startTime=2026-03-09 00:08:33&typeCode=58719&name=julian.ortiz
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:53",
      "lastTime": "2026-03-09 00:09:53",
      "id": 108,
      "typeCode": "58719",
      "parentId": 814,
      "name": "julian.ortiz",
      "sname": "julian.ortiz",
      "cddValue": "wiy1sl",
      "cddLevel": "5njlk8",
      "searchCode": "58719",
      "dispFlag": "zkh6uv",
      "priority": 2,
      "delFlag": 9,
      "deleteTime": "2026-03-09 00:09:53",
      "description": "e8dej6",
      "spare1": "16nlt4",
      "spare2": "3yzi84",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/list.do?endTime=2026-03-09 00:08:33&limit=10&startTime=2026-03-09 00:08:33&status=x98fo8&name=julian.ortiz&orderBy=570&remark=oe0kxz&typeClass=tsw0l8&key=5xskfc&page=1&typeId=95&typeMode=226&q=daennk
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 512,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "typeId": "95",
        "name": "julian.ortiz",
        "typeClass": "wbelbb",
        "typeRef": "zp28au",
        "typeMode": 345,
        "searchCode": "58719",
        "priority": 481,
        "createTime": "2026-03-09 00:09:52",
        "status": 429,
        "remark": "qrj0jt"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/export.do --data 'typeMode=727&typeClass=j1o76w&writer.psOut.closed=true&typeId=95&writer.formatter.zero=2&name=julian.ortiz&characterEncoding=ydsm4p&writer.psOut.textOut.nextChar=529&status=3iws81&key=tf1gkm&bufferSize=10&writer.psOut.closing=true&writer.psOut.trouble=true&writer.psOut.formatter.zero=t&committed=true&q=qxgw0c&orderBy=375&endTime=2026-03-09 00:08:33&page=1&limit=10&writer.autoFlush=true&writer.psOut.textOut.nChars=607&writer.formatter.lastException.detailMessage=success&startTime=2026-03-09 00:08:33&remark=6xh51v&contentType=31oiqn&writer.trouble=true&writer.psOut.autoFlush=true&status=262&writer.writeBuffer=z&writer.writeBuffer=z'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "pb8bzo",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/95.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "typeId": "95",
    "name": "julian.ortiz",
    "typeClass": "hb4f25",
    "typeRef": "b5cehy",
    "typeMode": 607,
    "searchCode": "58719",
    "priority": 743,
    "createTime": "2026-03-09 00:09:52",
    "status": 404,
    "remark": "8r976m"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
typeId|string|字典主键|false|-
name|string|字典名称|false|-
typeClass|string|类型分类|false|-
typeRef|string|字典引用名称|false|-
typeMode|int32|字典类型模式 0平面1树形|false|-
searchCode|string|快速码|false|-
priority|int32|排序码|false|-
createTime|string|创建时间|false|-
status|int32|状态（0未生效 1正常）|false|-
remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/save.do --data '{
  "typeId": "95",
  "name": "julian.ortiz",
  "typeClass": "nbpc12",
  "typeRef": "bgf8r2",
  "typeMode": 335,
  "searchCode": "58719",
  "priority": 605,
  "createTime": "2026-03-09 00:09:52",
  "status": 666,
  "remark": "ilibra"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "x34lie",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
typeId|string|字典主键|false|-
name|string|字典名称|false|-
typeClass|string|类型分类|false|-
typeRef|string|字典引用名称|false|-
typeMode|int32|字典类型模式 0平面1树形|false|-
searchCode|string|快速码|false|-
priority|int32|排序码|false|-
createTime|string|创建时间|false|-
status|int32|状态（0未生效 1正常）|false|-
remark|string|备注|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/update.do --data '{
  "typeId": "95",
  "name": "julian.ortiz",
  "typeClass": "5god2z",
  "typeRef": "dpdcxp",
  "typeMode": 63,
  "searchCode": "58719",
  "priority": 758,
  "createTime": "2026-03-09 00:09:52",
  "status": 97,
  "remark": "ozpwmx"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "8sqiov",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "n5gf66",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "8f1w1j",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "typeId": "95",
      "name": "julian.ortiz",
      "typeClass": "mz3ynz",
      "typeRef": "kq7km4",
      "typeMode": 461,
      "searchCode": "58719",
      "priority": 932,
      "createTime": "2026-03-09 00:09:52",
      "status": 13,
      "remark": "pkohi1"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "cpu": {
      "cpuNum": 771,
      "total": 86.94,
      "sys": 42.86,
      "used": 19.13,
      "wait": 91.35,
      "free": 87.83
    },
    "mem": {
      "total": 0.07,
      "used": 47.44,
      "free": 68.30
    },
    "jvm": {
      "total": 45.24,
      "max": 28.87,
      "free": 65.46,
      "version": "0.77",
      "home": "5hwkhy"
    },
    "sys": {
      "computerName": "julian.ortiz",
      "computerIp": "207.227.60.208",
      "userDir": "6o6ir8",
      "osName": "julian.ortiz",
      "osArch": "sgphnw"
    },
    "sysFiles": [
      {
        "dirName": "julian.ortiz",
        "sysTypeName": "julian.ortiz",
        "typeName": "julian.ortiz",
        "total": "lslxh9",
        "free": "3xlm50",
        "used": "oie9tc",
        "usage": 88.25
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/list.do?description=gu3wpn&endTime=2026-03-09 00:08:33&sname=julian.ortiz&q=mt2ek3&limit=10&name=julian.ortiz&orderBy=838&startTime=2026-03-09 00:08:33&page=1&delFlag=9
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:55",
      "lastTime": "2026-03-09 00:09:55",
      "id": "95",
      "name": "julian.ortiz",
      "sname": "julian.ortiz",
      "priority": 409,
      "delFlag": 9,
      "description": "swiydp"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/export.do --data 'writer.trouble=true&writer.psOut.autoFlush=true&writer.psOut.closing=true&writer.formatter.zero=f&orderBy=164&page=1&sname=julian.ortiz&writer.writeBuffer=i&writer.writeBuffer=i&description=jb6nfp&writer.formatter.lastException.detailMessage=success&committed=true&contentType=ea3cg6&writer.psOut.trouble=true&limit=10&writer.psOut.closed=true&writer.autoFlush=true&writer.psOut.textOut.nextChar=506&delFlag=9&q=lxpxr6&status=143&bufferSize=10&name=julian.ortiz&characterEncoding=011v6j&writer.psOut.formatter.zero=8&startTime=2026-03-09 00:08:33&writer.psOut.textOut.nChars=99&endTime=2026-03-09 00:08:33'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "vqobhl",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:55",
    "lastTime": "2026-03-09 00:09:55",
    "id": "95",
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "priority": 169,
    "delFlag": 9,
    "description": "1d26yr"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|资源类型ID|false|-
name|string|类型名称|false|-
sname|string|类型简称,英文|false|-
priority|int32|重点优先级|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:55",
  "lastTime": "2026-03-09 00:09:55",
  "id": "95",
  "name": "julian.ortiz",
  "sname": "julian.ortiz",
  "priority": 738,
  "delFlag": 9,
  "description": "l8x1ql"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "6bsyhr",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|资源类型ID|false|-
name|string|类型名称|false|-
sname|string|类型简称,英文|false|-
priority|int32|重点优先级|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:55",
  "lastTime": "2026-03-09 00:09:55",
  "id": "95",
  "name": "julian.ortiz",
  "sname": "julian.ortiz",
  "priority": 8,
  "delFlag": 9,
  "description": "dhgklc"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ow74rz",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "h3cjt4",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/template/list.do?spare2=g63chw&foreignId=95&description=lhuslw&delFlag=9&providerName=julian.ortiz&creatorId=95&startTime=2026-03-09 00:08:33&appId=95&organId=95&orderBy=377&q=7bn7i4&id=95&content=jqfubw&signature=6gsoee&subType=6rsipw&limit=10&name=julian.ortiz&type=okzifc&providerId=95&status=816&spare1=ht78tu&endTime=2026-03-09 00:08:33&page=1
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:48",
      "lastTime": "2026-03-09 00:09:48",
      "id": "95",
      "appId": "95",
      "organId": "95",
      "providerId": "95",
      "providerName": "julian.ortiz",
      "foreignId": "95",
      "type": "e01v0b",
      "subType": "si68hh",
      "name": "julian.ortiz",
      "signature": "g6euy0",
      "content": "hfiyc1",
      "priority": 619,
      "status": 407,
      "delFlag": 9,
      "description": "8il1sh",
      "spare1": "cpa09f",
      "spare2": "g6sdx3"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:48",
    "lastTime": "2026-03-09 00:09:48",
    "id": "95",
    "appId": "95",
    "organId": "95",
    "providerId": "95",
    "providerName": "julian.ortiz",
    "foreignId": "95",
    "type": "5hhilx",
    "subType": "ptcua3",
    "name": "julian.ortiz",
    "signature": "cfy7wy",
    "content": "fgrls2",
    "priority": 623,
    "status": 149,
    "delFlag": 9,
    "description": "49ard4",
    "spare1": "8g5e1x",
    "spare2": "8ims94"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
priority|int32|排序号|false|-
status|int32|状态0未生效1正常2受限3锁定|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/template/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:49",
  "lastTime": "2026-03-09 00:09:49",
  "id": "95",
  "appId": "95",
  "organId": "95",
  "providerId": "95",
  "providerName": "julian.ortiz",
  "foreignId": "95",
  "type": "old865",
  "subType": "gd1md2",
  "name": "julian.ortiz",
  "signature": "0xfzhi",
  "content": "nljc8d",
  "priority": 182,
  "status": 163,
  "delFlag": 9,
  "description": "mca3tz",
  "spare1": "y2zkh2",
  "spare2": "yom6k5"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "n9l8pm",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
priority|int32|排序号|false|-
status|int32|状态0未生效1正常2受限3锁定|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/template/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:49",
  "lastTime": "2026-03-09 00:09:49",
  "id": "95",
  "appId": "95",
  "organId": "95",
  "providerId": "95",
  "providerName": "julian.ortiz",
  "foreignId": "95",
  "type": "aacm8l",
  "subType": "btzn8x",
  "name": "julian.ortiz",
  "signature": "xy7rxx",
  "content": "wdljhf",
  "priority": 961,
  "status": 481,
  "delFlag": 9,
  "description": "fcdrcz",
  "spare1": "zah52u",
  "spare2": "9u8qap"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "xkxwfa",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "37yis4",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/list.do?opTime=2026-03-09 00:09:49&opUserId=95&opOrganId=95&q=0squ9a&msgAccountId=95&orderBy=623&endTime=2026-03-09 00:08:33&foreignId=95&appId=95&spare1=tdtn9v&msgContent=y7bvj9&msgOrganName=julian.ortiz&msgAbstract=o1ggqm&status=uesmhu&opOrganName=julian.ortiz&msgAccountName=julian.ortiz&type=jacjh3&msgModuleName=julian.ortiz&id=95&page=1&msgTitle=sjgo1j&bizType=sqj9of&msgModuleId=95&msgLabels=190zda&msgId=264&startTime=2026-03-09 00:08:33&msgOrganId=95&msgUrl=www.kandace-stamm.org&limit=10&description=n5e92d&msgUserName=julian.ortiz&spare2=faj4gw&msgType=596&creatorId=95&msgCreateTime=2026-03-09 00:09:49&msgUserId=95
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:49",
      "lastTime": "2026-03-09 00:09:49",
      "id": "95",
      "appId": "95",
      "foreignId": "95",
      "type": "bjxy5m",
      "bizType": "2nejy6",
      "msgCreateTime": "2026-03-09 00:09:49",
      "msgId": 753,
      "msgType": 515,
      "msgTitle": "tor6zr",
      "msgAbstract": "vj3u59",
      "msgAccountId": "95",
      "msgAccountName": "julian.ortiz",
      "msgModuleId": "95",
      "msgModuleName": "julian.ortiz",
      "msgUserId": "95",
      "msgUserName": "julian.ortiz",
      "msgOrganId": "95",
      "msgOrganName": "julian.ortiz",
      "msgUrl": "www.kandace-stamm.org",
      "msgLabels": "z27zwl",
      "msgContent": "i7v41e",
      "status": "4dk8sq",
      "opUserId": "95",
      "opTime": "2026-03-09 00:09:49",
      "opOrganId": "95",
      "opOrganName": "julian.ortiz",
      "description": "dtv425",
      "spare1": "0o5r5o",
      "spare2": "e9qnbl"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/export.do --data 'msgModuleId=95&opTime=2026-03-09 00:09:49&msgTitle=b7bher&characterEncoding=75vgvs&page=1&msgModuleName=julian.ortiz&writer.psOut.closing=true&writer.psOut.textOut.nextChar=939&opUserId=95&creatorId=95&msgCreateTime=2026-03-09 00:09:49&committed=true&orderBy=31&msgContent=t07idj&msgAccountId=95&description=o0hhh0&writer.psOut.formatter.zero=1&msgAccountName=julian.ortiz&opOrganId=95&msgOrganId=95&writer.trouble=true&writer.psOut.closed=true&opOrganName=julian.ortiz&writer.psOut.autoFlush=true&msgLabels=5yojre&writer.writeBuffer=t&writer.writeBuffer=t&writer.psOut.textOut.nChars=197&id=95&msgUserId=95&appId=95&bizType=q903jm&msgUrl=www.kandace-stamm.org&writer.formatter.lastException.detailMessage=success&status=wem5sg&type=70wyk0&bufferSize=10&status=829&spare1=gt79gl&endTime=2026-03-09 00:08:33&q=mi24ez&contentType=4u50rd&msgOrganName=julian.ortiz&msgType=651&limit=10&msgId=252&spare2=cv1s9e&startTime=2026-03-09 00:08:33&writer.formatter.zero=4&foreignId=95&msgAbstract=kur8us&writer.psOut.trouble=true&writer.autoFlush=true&msgUserName=julian.ortiz'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "0x1ash",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:49",
    "lastTime": "2026-03-09 00:09:49",
    "id": "95",
    "appId": "95",
    "foreignId": "95",
    "type": "mt65mn",
    "bizType": "vmbxi5",
    "msgCreateTime": "2026-03-09 00:09:49",
    "msgId": 943,
    "msgType": 52,
    "msgTitle": "h3134r",
    "msgAbstract": "pzcr9k",
    "msgAccountId": "95",
    "msgAccountName": "julian.ortiz",
    "msgModuleId": "95",
    "msgModuleName": "julian.ortiz",
    "msgUserId": "95",
    "msgUserName": "julian.ortiz",
    "msgOrganId": "95",
    "msgOrganName": "julian.ortiz",
    "msgUrl": "www.kandace-stamm.org",
    "msgLabels": "zw9wfs",
    "msgContent": "hv5w5y",
    "status": "2z72ga",
    "opUserId": "95",
    "opTime": "2026-03-09 00:09:49",
    "opOrganId": "95",
    "opOrganName": "julian.ortiz",
    "description": "qf2yzn",
    "spare1": "q8bn9f",
    "spare2": "pd6dsd"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:49",
  "lastTime": "2026-03-09 00:09:49",
  "id": "95",
  "appId": "95",
  "foreignId": "95",
  "type": "qb12re",
  "bizType": "3vfwfz",
  "msgCreateTime": "2026-03-09 00:09:49",
  "msgId": 151,
  "msgType": 375,
  "msgTitle": "k642uy",
  "msgAbstract": "q7ym7x",
  "msgAccountId": "95",
  "msgAccountName": "julian.ortiz",
  "msgModuleId": "95",
  "msgModuleName": "julian.ortiz",
  "msgUserId": "95",
  "msgUserName": "julian.ortiz",
  "msgOrganId": "95",
  "msgOrganName": "julian.ortiz",
  "msgUrl": "www.kandace-stamm.org",
  "msgLabels": "rzu1xh",
  "msgContent": "iw0kbi",
  "status": "hgs4sk",
  "opUserId": "95",
  "opTime": "2026-03-09 00:09:49",
  "opOrganId": "95",
  "opOrganName": "julian.ortiz",
  "description": "tqsk7q",
  "spare1": "knjgg1",
  "spare2": "0fld8t"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "4nvali",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:49",
  "lastTime": "2026-03-09 00:09:49",
  "id": "95",
  "appId": "95",
  "foreignId": "95",
  "type": "i1w55g",
  "bizType": "j8ki7b",
  "msgCreateTime": "2026-03-09 00:09:49",
  "msgId": 503,
  "msgType": 574,
  "msgTitle": "jli2r5",
  "msgAbstract": "9qty56",
  "msgAccountId": "95",
  "msgAccountName": "julian.ortiz",
  "msgModuleId": "95",
  "msgModuleName": "julian.ortiz",
  "msgUserId": "95",
  "msgUserName": "julian.ortiz",
  "msgOrganId": "95",
  "msgOrganName": "julian.ortiz",
  "msgUrl": "www.kandace-stamm.org",
  "msgLabels": "tdpq88",
  "msgContent": "f3rbtv",
  "status": "cicctt",
  "opUserId": "95",
  "opTime": "2026-03-09 00:09:49",
  "opOrganId": "95",
  "opOrganName": "julian.ortiz",
  "description": "cwetlb",
  "spare1": "f0bpz8",
  "spare2": "asntqv"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "7khl4d",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "pnhlck",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/read/raiv8q.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "xs6rw0",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
syncMode|string|角色类型，R31 WEB，R32移动<br>对应字段：SYNC_MODE|false|-
groupId|int64|组id|false|-
positionId|string|岗位id|false|-
organId|string|机构id|false|-
areaId|int64|区域id|false|-
batchId|string|批次id|false|-
keyWords|string|关键字|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/list.do?endTime=2026-03-09 00:08:33&status=144&keyWords=yfjjjq&startTime=2026-03-09 00:08:33&type=vr3cwp&positionId=95&areaId=428&page=1&limit=10&batchId=95&groupId=607&orderBy=691&q=82ft1i&syncMode=b90zhb&organId=95&appId=95
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 134,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:48",
        "lastTime": "2026-03-09 00:09:48",
        "id": 99,
        "appId": "95",
        "saveSource": "by4xyr",
        "unitName": "julian.ortiz",
        "name": "julian.ortiz",
        "idNum": "f16pcq",
        "duty": "60jxn2",
        "telephone": "(947) 505-4582",
        "mobile": "1-508-337-4557",
        "extInfo1": "ob147o",
        "extInfo2": "4ghw1v",
        "extInfo3": "l3kaqz",
        "needInitUser": true,
        "userId": "95",
        "needInitOrgan": true,
        "organId": "95",
        "type": "dzepsa",
        "foreignUrl": "www.kandace-stamm.org",
        "bizType": 822,
        "bizOrganId": "95",
        "bizAreaId": 902,
        "bizGroupId": 13,
        "bizPower": "x4xjyn",
        "bizMultiInfo": "423al3",
        "needSetOrgan": true,
        "needSetArea": true,
        "needSetGroup": true,
        "needSetPower": true,
        "opUserId": "95",
        "opOrganId": "95",
        "opTime": "2026-03-09 00:09:48",
        "opInfo": "8iot66",
        "priority": 769,
        "status": 196,
        "delFlag": 9,
        "dataBatch": "37ttzd",
        "dataVersion": 417,
        "updateTime": "2026-03-09 00:09:48",
        "syncMode": "f6t3mk",
        "syncTime": "2026-03-09 00:09:48",
        "description": "i1w6nk",
        "groupName": "julian.ortiz",
        "positionName": "julian.ortiz",
        "bizPowerName": "julian.ortiz",
        "subdistrictName": "julian.ortiz",
        "communityName": "julian.ortiz"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
q|string|关键字：查询输入条件q，可匹配name、title、keywords等文本信息|false|-
orderBy|int32|排序，默认主键倒序|false|-
startTime|string|开始时间|false|-
endTime|string|结束时间|false|-
page|int32|分页信息：默认第1页|false|-
limit|int32|分页每页条数，默认10条|false|-
type|string|类型 RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345|false|-
status|int32|状态：0未初始化 1 已初始化， 2.初始化失败|false|-
appId|string|应用Id|false|-
syncMode|string|角色类型，R31 WEB，R32移动<br>对应字段：SYNC_MODE|false|-
groupId|int64|组id|false|-
positionId|string|岗位id|false|-
organId|string|机构id|false|-
areaId|int64|区域id|false|-
batchId|string|批次id|false|-
keyWords|string|关键字|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/export.do --data 'appId=95&writer.psOut.autoFlush=true&writer.psOut.closed=true&q=wd3qwz&writer.psOut.trouble=true&syncMode=wp3cxb&writer.writeBuffer=w&writer.writeBuffer=w&groupId=633&contentType=l3qquh&committed=true&writer.psOut.textOut.nChars=328&type=j5fxgi&writer.autoFlush=true&status=46&writer.trouble=true&characterEncoding=9nrgws&bufferSize=10&writer.psOut.formatter.zero=o&writer.psOut.textOut.nextChar=399&status=801&writer.formatter.zero=i&writer.psOut.closing=true&positionId=95&keyWords=odts7t&orderBy=166&organId=95&writer.formatter.lastException.detailMessage=success&areaId=2&batchId=95&startTime=2026-03-09 00:08:33&page=1&limit=10&endTime=2026-03-09 00:08:33'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "g00jdo",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/454.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:48",
    "lastTime": "2026-03-09 00:09:48",
    "id": 130,
    "appId": "95",
    "saveSource": "1ji034",
    "unitName": "julian.ortiz",
    "name": "julian.ortiz",
    "idNum": "hs0mlv",
    "duty": "wchq1q",
    "telephone": "(947) 505-4582",
    "mobile": "1-508-337-4557",
    "extInfo1": "0yxpri",
    "extInfo2": "fmzwk2",
    "extInfo3": "kvqilg",
    "needInitUser": true,
    "userId": "95",
    "needInitOrgan": true,
    "organId": "95",
    "type": "2xhp43",
    "foreignUrl": "www.kandace-stamm.org",
    "bizType": 793,
    "bizOrganId": "95",
    "bizAreaId": 296,
    "bizGroupId": 341,
    "bizPower": "lab4gb",
    "bizMultiInfo": "73qb06",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "95",
    "opOrganId": "95",
    "opTime": "2026-03-09 00:09:48",
    "opInfo": "pyjjaa",
    "priority": 665,
    "status": 538,
    "delFlag": 9,
    "dataBatch": "4im63a",
    "dataVersion": 762,
    "updateTime": "2026-03-09 00:09:48",
    "syncMode": "aso1f5",
    "syncTime": "2026-03-09 00:09:48",
    "description": "1e27ik",
    "groupName": "julian.ortiz",
    "positionName": "julian.ortiz",
    "bizPowerName": "julian.ortiz",
    "subdistrictName": "julian.ortiz",
    "communityName": "julian.ortiz"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|预置信息ID|false|-
appId|string|所属应用ID|false|-
saveSource|string|来源，RGYZ人工预置，PLTJ批量添加|false|-
unitName|string|服务处所，单位名称|false|-
name|string|姓名|false|-
idNum|string|身份证号|false|-
duty|string|人员职务|false|-
telephone|string|办公电话|false|-
mobile|string|手机号码|false|-
extInfo1|string|备用信息1，可保存岗位名称|false|-
extInfo2|string|备用信息2，可保存所属网格等信息|false|-
extInfo3|string|备用信息3|false|-
needInitUser|boolean|是否同步初始化人员，0否1是，是则人员会加入BASE_USER|false|-
userId|string|机构用户人员ID，关联BASE_USER，初始化之后更新|false|-
needInitOrgan|boolean|是否同步初始化机构，0否1是，是则人员会加入BASE_ORGAN|false|-
organId|string|机构ID，关联BASE_ORGAN，初始化之后更新|false|-
type|string|类型，RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345|false|-
foreignUrl|string|外部URL，如SJKB的URL，人才预约的URL|false|-
bizType|int32|业务类型，1具体单位2具体地域3具体权限组4综合权限9多个同类信息，12单位和地域，13单位和权限组，19多个单位，23地域和权限组，29多个地域，39多个权限|false|-
bizOrganId|string|业务机构ID，人员绑定机构，绑定的ORGAN_ID|false|-
bizAreaId|int64|业务权限ID，当前查询范围|false|-
bizGroupId|int64|业务会员组ID|false|-
bizPower|string|业务综合权限，备用字段|false|-
bizMultiInfo|string|多个信息时，Ids,隔开|false|-
needSetOrgan|boolean|是否需要绑定企业，0否1是，是则人员会配置IDENTITY的ORGAN_ID信息|false|-
needSetArea|boolean|是否需要绑定地域，0否1是，是则人员会配置IDENTITY的POWER_AREA_ID信息|false|-
needSetGroup|boolean|是否需要绑定会员组，0否1是，是则人员会配置会员组，并设置IDENTITY内的GROUP_ID|false|-
needSetPower|boolean|是否需要绑定综合权限，0否1是，是则人员会配置IDENTITY的其他综合权限等信息|false|-
opUserId|string|操作人ID|false|-
opOrganId|string|操作单位ID|false|-
opTime|string|操作时间|false|-
opInfo|string|操作说明|false|-
priority|int32|排序码|false|-
status|int32|状态0未初始化1初始化配置成功2初始化配置不成功|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
dataBatch|string|数据批次号|false|-
dataVersion|int32|数据版本，流水号，向上增加|false|-
updateTime|string|数据更新时间|false|-
syncMode|string|同步类型，I插入，U更新，D删除，DM人工删除，UM人工更新|false|-
syncTime|string|同步更新时间|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:48",
  "lastTime": "2026-03-09 00:09:48",
  "id": 467,
  "appId": "95",
  "saveSource": "q9k20k",
  "unitName": "julian.ortiz",
  "name": "julian.ortiz",
  "idNum": "71cq9x",
  "duty": "mgiuyv",
  "telephone": "(947) 505-4582",
  "mobile": "1-508-337-4557",
  "extInfo1": "d261cv",
  "extInfo2": "k7chvq",
  "extInfo3": "wil9c2",
  "needInitUser": true,
  "userId": "95",
  "needInitOrgan": true,
  "organId": "95",
  "type": "jx5xd4",
  "foreignUrl": "www.kandace-stamm.org",
  "bizType": 673,
  "bizOrganId": "95",
  "bizAreaId": 806,
  "bizGroupId": 998,
  "bizPower": "h4na8k",
  "bizMultiInfo": "ayiz7x",
  "needSetOrgan": true,
  "needSetArea": true,
  "needSetGroup": true,
  "needSetPower": true,
  "opUserId": "95",
  "opOrganId": "95",
  "opTime": "2026-03-09 00:09:48",
  "opInfo": "jjptsd",
  "priority": 429,
  "status": 806,
  "delFlag": 9,
  "dataBatch": "pvzwrg",
  "dataVersion": 685,
  "updateTime": "2026-03-09 00:09:48",
  "syncMode": "vodpyg",
  "syncTime": "2026-03-09 00:09:48",
  "description": "xjpok9"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "cgxqib",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|预置信息ID|false|-
appId|string|所属应用ID|false|-
saveSource|string|来源，RGYZ人工预置，PLTJ批量添加|false|-
unitName|string|服务处所，单位名称|false|-
name|string|姓名|false|-
idNum|string|身份证号|false|-
duty|string|人员职务|false|-
telephone|string|办公电话|false|-
mobile|string|手机号码|false|-
extInfo1|string|备用信息1，可保存岗位名称|false|-
extInfo2|string|备用信息2，可保存所属网格等信息|false|-
extInfo3|string|备用信息3|false|-
needInitUser|boolean|是否同步初始化人员，0否1是，是则人员会加入BASE_USER|false|-
userId|string|机构用户人员ID，关联BASE_USER，初始化之后更新|false|-
needInitOrgan|boolean|是否同步初始化机构，0否1是，是则人员会加入BASE_ORGAN|false|-
organId|string|机构ID，关联BASE_ORGAN，初始化之后更新|false|-
type|string|类型，RCYY人才预约，SJKB数据看板，SJPZ事件配置，SQ12345诉求12345|false|-
foreignUrl|string|外部URL，如SJKB的URL，人才预约的URL|false|-
bizType|int32|业务类型，1具体单位2具体地域3具体权限组4综合权限9多个同类信息，12单位和地域，13单位和权限组，19多个单位，23地域和权限组，29多个地域，39多个权限|false|-
bizOrganId|string|业务机构ID，人员绑定机构，绑定的ORGAN_ID|false|-
bizAreaId|int64|业务权限ID，当前查询范围|false|-
bizGroupId|int64|业务会员组ID|false|-
bizPower|string|业务综合权限，备用字段|false|-
bizMultiInfo|string|多个信息时，Ids,隔开|false|-
needSetOrgan|boolean|是否需要绑定企业，0否1是，是则人员会配置IDENTITY的ORGAN_ID信息|false|-
needSetArea|boolean|是否需要绑定地域，0否1是，是则人员会配置IDENTITY的POWER_AREA_ID信息|false|-
needSetGroup|boolean|是否需要绑定会员组，0否1是，是则人员会配置会员组，并设置IDENTITY内的GROUP_ID|false|-
needSetPower|boolean|是否需要绑定综合权限，0否1是，是则人员会配置IDENTITY的其他综合权限等信息|false|-
opUserId|string|操作人ID|false|-
opOrganId|string|操作单位ID|false|-
opTime|string|操作时间|false|-
opInfo|string|操作说明|false|-
priority|int32|排序码|false|-
status|int32|状态0未初始化1初始化配置成功2初始化配置不成功|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
dataBatch|string|数据批次号|false|-
dataVersion|int32|数据版本，流水号，向上增加|false|-
updateTime|string|数据更新时间|false|-
syncMode|string|同步类型，I插入，U更新，D删除，DM人工删除，UM人工更新|false|-
syncTime|string|同步更新时间|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:48",
  "lastTime": "2026-03-09 00:09:48",
  "id": 944,
  "appId": "95",
  "saveSource": "47fy7b",
  "unitName": "julian.ortiz",
  "name": "julian.ortiz",
  "idNum": "fb9c97",
  "duty": "q430ym",
  "telephone": "(947) 505-4582",
  "mobile": "1-508-337-4557",
  "extInfo1": "suingt",
  "extInfo2": "xoebx1",
  "extInfo3": "lktpcq",
  "needInitUser": true,
  "userId": "95",
  "needInitOrgan": true,
  "organId": "95",
  "type": "4zbcw5",
  "foreignUrl": "www.kandace-stamm.org",
  "bizType": 220,
  "bizOrganId": "95",
  "bizAreaId": 241,
  "bizGroupId": 812,
  "bizPower": "slhi02",
  "bizMultiInfo": "6rdsg7",
  "needSetOrgan": true,
  "needSetArea": true,
  "needSetGroup": true,
  "needSetPower": true,
  "opUserId": "95",
  "opOrganId": "95",
  "opTime": "2026-03-09 00:09:48",
  "opInfo": "fpuqyv",
  "priority": 343,
  "status": 191,
  "delFlag": 9,
  "dataBatch": "7sozcb",
  "dataVersion": 124,
  "updateTime": "2026-03-09 00:09:48",
  "syncMode": "on8ypq",
  "syncTime": "2026-03-09 00:09:48",
  "description": "v3r6iy"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "yasnpt",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "hu8k4n",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "59rzan",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
username|string|用户名|false|-
password|string|用户密码|false|-
code|string|验证码|false|-
uuid|string|唯一标识|false|-
appId|string|所在应用ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/register.do --data '{
  "username": "julian.ortiz",
  "password": "zyturx",
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba",
  "appId": "95"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "4hirme",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/list.do?ipaddr=hnrevg&startTime=2026-03-09 00:08:33&orderBy=227&endTime=2026-03-09 00:08:33&loginTime=2026-03-09 00:09:49&q=j1eeg5&status=2un296&msg=c6f5vq&os=xhck0q&page=1&browser=tqzsh0&username=julian.ortiz&limit=10&infoId=17
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 449,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "infoId": 930,
        "username": "julian.ortiz",
        "status": "g0uzw6",
        "ipaddr": "y57iem",
        "loginLocation": "kg8vjf",
        "browser": "xu3g6a",
        "os": "qdsidp",
        "msg": "ct3u1r",
        "loginTime": "2026-03-09 00:09:50",
        "remark": "nj67ms"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/export.do --data 'msg=h4mrc1&contentType=gm2lis&browser=34uyz4&status=rgzqht&writer.psOut.trouble=true&startTime=2026-03-09 00:08:33&ipaddr=kv1x4y&page=1&writer.psOut.closing=true&limit=10&os=6fn6v3&username=julian.ortiz&writer.psOut.textOut.nextChar=912&writer.psOut.autoFlush=true&endTime=2026-03-09 00:08:33&writer.formatter.lastException.detailMessage=success&writer.formatter.zero=l&bufferSize=10&loginTime=2026-03-09 00:09:50&status=729&writer.psOut.formatter.zero=f&writer.autoFlush=true&writer.trouble=true&writer.writeBuffer=8&writer.writeBuffer=8&infoId=381&orderBy=964&writer.psOut.closed=true&q=u6mpwm&writer.psOut.textOut.nChars=863&committed=true&characterEncoding=d6umcs'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "1y3o37",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "q6q9dl",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "srjieu",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/unlock/julian.ortiz.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "owqzsv",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/list.do?q=264meh&page=1&adminId=379&startTime=2026-03-09 00:08:33&userId=95&username=julian.ortiz&limit=10&organId=95&nickName=shane.roberts&endTime=2026-03-09 00:08:33&delFlag=9&email=columbus.ankunding@gmail.com&mobile=1-508-337-4557&status=vqaofk&deptId=756&orderBy=253
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:44",
      "lastTime": "2026-03-09 00:09:44",
      "id": 879,
      "userId": "95",
      "deptId": 785,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "name": "julian.ortiz",
      "username": "julian.ortiz",
      "nickName": "shane.roberts",
      "email": "columbus.ankunding@gmail.com",
      "mobile": "1-508-337-4557",
      "imagePath": "fzdm7g",
      "password": "2ae2sf",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 564,
      "delFlag": 9,
      "lastLoginIp": "207.227.60.208",
      "lastLoginTime": "2026-03-09 00:09:44",
      "description": "awfukh",
      "dept": {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:44",
        "lastTime": "2026-03-09 00:09:44",
        "id": 112,
        "organId": "95",
        "parentId": 895,
        "appId": "95",
        "depttypeId": 582,
        "foreignId": "95",
        "createType": 251,
        "type": "q2ab4z",
        "name": "julian.ortiz",
        "sname": "julian.ortiz",
        "areaCode": "58719",
        "organLeader": "lwys78",
        "leaderId": "95",
        "leaderMobile": "1-508-337-4557",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "58719",
        "imagePath": "i5wz9c",
        "priority": 903,
        "status": 444,
        "delFlag": 9,
        "description": "uyap24",
        "spare1": "smje1v",
        "spare2": "dj90tl",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "95",
          "createTime": "2026-03-09 00:09:44",
          "lastTime": "2026-03-09 00:09:44",
          "id": 767,
          "roletypeId": "95",
          "appId": "95",
          "name": "julian.ortiz",
          "code": "58719",
          "priority": 535,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 584,
          "description": "ozc6i6",
          "areaType": "0l7mp6"
        }
      ],
      "roleIds": [
        556
      ],
      "positionIds": [
        "8ank7h"
      ],
      "roleId": 545,
      "userRoleList": [
        {
          "id": 917,
          "deptId": 75,
          "deptName": "julian.ortiz",
          "organId": "95",
          "organName": "julian.ortiz",
          "roleId": 816,
          "roleName": "julian.ortiz",
          "adminId": 393
        }
      ],
      "code": "58719",
      "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/[user/939].do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "user": {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:44",
      "lastTime": "2026-03-09 00:09:44",
      "id": 285,
      "userId": "95",
      "deptId": 892,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "name": "julian.ortiz",
      "username": "julian.ortiz",
      "nickName": "shane.roberts",
      "email": "columbus.ankunding@gmail.com",
      "mobile": "1-508-337-4557",
      "imagePath": "82dtpq",
      "password": "muxepc",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 216,
      "delFlag": 9,
      "lastLoginIp": "207.227.60.208",
      "lastLoginTime": "2026-03-09 00:09:44",
      "description": "lza8q0",
      "dept": {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:44",
        "lastTime": "2026-03-09 00:09:44",
        "id": 93,
        "organId": "95",
        "parentId": 5,
        "appId": "95",
        "depttypeId": 472,
        "foreignId": "95",
        "createType": 202,
        "type": "2sf8gu",
        "name": "julian.ortiz",
        "sname": "julian.ortiz",
        "areaCode": "58719",
        "organLeader": "vsc280",
        "leaderId": "95",
        "leaderMobile": "1-508-337-4557",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "58719",
        "imagePath": "tytsde",
        "priority": 626,
        "status": 555,
        "delFlag": 9,
        "description": "2tnyld",
        "spare1": "krq8au",
        "spare2": "yvi0qf",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "95",
          "createTime": "2026-03-09 00:09:44",
          "lastTime": "2026-03-09 00:09:44",
          "id": 765,
          "roletypeId": "95",
          "appId": "95",
          "name": "julian.ortiz",
          "code": "58719",
          "priority": 904,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 116,
          "description": "2zlykq",
          "areaType": "4coia9"
        }
      ],
      "roleIds": [
        137
      ],
      "positionIds": [
        "sg6zt0"
      ],
      "roleId": 79,
      "userRoleList": [
        {
          "id": 614,
          "deptId": 267,
          "deptName": "julian.ortiz",
          "organId": "95",
          "organName": "julian.ortiz",
          "roleId": 774,
          "roleName": "julian.ortiz",
          "adminId": 648
        }
      ],
      "code": "58719",
      "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
    },
    "roles": [
      {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:44",
        "lastTime": "2026-03-09 00:09:44",
        "roleId": 862,
        "roleName": "julian.ortiz",
        "roleKey": "y6kh3d",
        "roleSort": 334,
        "menuCheckStrictly": true,
        "deptCheckStrictly": true,
        "status": 984,
        "flag": true,
        "menuIds": [
          34
        ],
        "deptIds": [
          960
        ],
        "permissions": [
          "grlwtd"
        ],
        "remark": "lab6g0",
        "parentName": "julian.ortiz",
        "appName": "julian.ortiz",
        "roletypeId": "95",
        "roletypeName": "julian.ortiz",
        "priority": 704,
        "isSuper": true
      }
    ],
    "roleList": [
      {
        "id": 575,
        "roleId": 0,
        "adminId": 267,
        "deptId": 116,
        "deptName": "julian.ortiz",
        "organId": "95",
        "organName": "julian.ortiz",
        "roleName": "julian.ortiz"
      }
    ],
    "positions": [
      {
        "postId": "95",
        "postCode": "58719",
        "postName": "julian.ortiz",
        "postSort": 5,
        "status": 459,
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:44",
        "lastTime": "2026-03-09 00:09:44",
        "delFlag": 9,
        "remark": "45m3pe",
        "ids": [
          "rk42gu"
        ],
        "positionId": "95",
        "flag": true
      }
    ],
    "roleIds": [
      299
    ],
    "positionIds": [
      "6rimba"
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/deptTree.do?page=1&description=aogw59&spare1=tnyro2&appId=95&isDisabled=true&name=julian.ortiz&searchCode=58719&imagePath=4yjwg8&status=684&delFlag=9&endTime=2026-03-09 00:08:33&sname=julian.ortiz&areaCode=58719&foreignId=95&organLeader=uha8uf&isVirtual=true&organId=95&orderBy=579&isOrganLevel=true&leaderId=95&depttypeId=117&q=o5603u&createType=419&creatorId=95&isLeaf=true&spare2=p34aa4&startTime=2026-03-09 00:08:33&leaderMobile=1-508-337-4557&parentId=380&type=uuy4bv&limit=10&deptId=452
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "id": 854,
      "label": "oo103t",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
deptName|string|部门名称|false|-
organId|string|机构ID|false|-
organName|string|机构名称|false|-
name|string|人员姓名|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
imagePath|string|用户头像|false|-
password|string|密码|false|-
isSuperAdmin|boolean|是否超级管理员|false|-
isAuditAdmin|boolean|是否审计只读管理员|false|-
isSelfAdmin|boolean|是否只管理自己的数据|false|-
status|int32|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
lastLoginIp|string|最后登录IP|false|-
lastLoginTime|string|最后登录时间|false|-
description|string|备注,办公地址|false|-
dept|object|部门对象|false|-
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
roles|array|角色对象|false|-
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
roleIds|array|角色组|false|-
positionIds|array|岗位组|false|-
roleId|int64|角色ID|false|-
userRoleList|array|角色集合|false|-
└─id|int64|用户角色ID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─adminId|int64|公共管理用户ID|false|-
code|string|验证码|false|-
uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:44",
  "lastTime": "2026-03-09 00:09:44",
  "id": 24,
  "userId": "95",
  "deptId": 175,
  "deptName": "julian.ortiz",
  "organId": "95",
  "organName": "julian.ortiz",
  "name": "julian.ortiz",
  "username": "julian.ortiz",
  "nickName": "shane.roberts",
  "email": "columbus.ankunding@gmail.com",
  "mobile": "1-508-337-4557",
  "imagePath": "1du25a",
  "password": "6kmtmq",
  "isSuperAdmin": true,
  "isAuditAdmin": true,
  "isSelfAdmin": true,
  "status": 10,
  "delFlag": 9,
  "lastLoginIp": "207.227.60.208",
  "lastLoginTime": "2026-03-09 00:09:44",
  "description": "9fzi7c",
  "dept": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:44",
    "lastTime": "2026-03-09 00:09:44",
    "id": 722,
    "organId": "95",
    "parentId": 348,
    "appId": "95",
    "depttypeId": 191,
    "foreignId": "95",
    "createType": 757,
    "type": "88wqb4",
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "areaCode": "58719",
    "organLeader": "secyo9",
    "leaderId": "95",
    "leaderMobile": "1-508-337-4557",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "58719",
    "imagePath": "9600kh",
    "priority": 414,
    "status": 979,
    "delFlag": 9,
    "description": "m8p78v",
    "spare1": "3i7q9r",
    "spare2": "f77uo5",
    "children": [
      {
        "$ref": ".."
      }
    ]
  },
  "roles": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:44",
      "lastTime": "2026-03-09 00:09:44",
      "id": 992,
      "roletypeId": "95",
      "appId": "95",
      "name": "julian.ortiz",
      "code": "58719",
      "priority": 766,
      "isRegular": true,
      "isSuper": true,
      "isPublic": true,
      "status": 362,
      "description": "quk5yu",
      "areaType": "0uxek9"
    }
  ],
  "roleIds": [
    904
  ],
  "positionIds": [
    "l393jn"
  ],
  "roleId": 820,
  "userRoleList": [
    {
      "id": 936,
      "deptId": 523,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "roleId": 114,
      "roleName": "julian.ortiz",
      "adminId": 927
    }
  ],
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "61n6jo",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
deptName|string|部门名称|false|-
organId|string|机构ID|false|-
organName|string|机构名称|false|-
name|string|人员姓名|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
imagePath|string|用户头像|false|-
password|string|密码|false|-
isSuperAdmin|boolean|是否超级管理员|false|-
isAuditAdmin|boolean|是否审计只读管理员|false|-
isSelfAdmin|boolean|是否只管理自己的数据|false|-
status|int32|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
lastLoginIp|string|最后登录IP|false|-
lastLoginTime|string|最后登录时间|false|-
description|string|备注,办公地址|false|-
dept|object|部门对象|false|-
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
roles|array|角色对象|false|-
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
roleIds|array|角色组|false|-
positionIds|array|岗位组|false|-
roleId|int64|角色ID|false|-
userRoleList|array|角色集合|false|-
└─id|int64|用户角色ID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─adminId|int64|公共管理用户ID|false|-
code|string|验证码|false|-
uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:44",
  "lastTime": "2026-03-09 00:09:44",
  "id": 127,
  "userId": "95",
  "deptId": 995,
  "deptName": "julian.ortiz",
  "organId": "95",
  "organName": "julian.ortiz",
  "name": "julian.ortiz",
  "username": "julian.ortiz",
  "nickName": "shane.roberts",
  "email": "columbus.ankunding@gmail.com",
  "mobile": "1-508-337-4557",
  "imagePath": "o5h63m",
  "password": "ir573x",
  "isSuperAdmin": true,
  "isAuditAdmin": true,
  "isSelfAdmin": true,
  "status": 250,
  "delFlag": 9,
  "lastLoginIp": "207.227.60.208",
  "lastLoginTime": "2026-03-09 00:09:44",
  "description": "25b31a",
  "dept": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:44",
    "lastTime": "2026-03-09 00:09:44",
    "id": 944,
    "organId": "95",
    "parentId": 429,
    "appId": "95",
    "depttypeId": 134,
    "foreignId": "95",
    "createType": 697,
    "type": "k9xxw1",
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "areaCode": "58719",
    "organLeader": "sim35k",
    "leaderId": "95",
    "leaderMobile": "1-508-337-4557",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "58719",
    "imagePath": "f1mjfk",
    "priority": 952,
    "status": 259,
    "delFlag": 9,
    "description": "zxsojf",
    "spare1": "ab0ytd",
    "spare2": "8fafeh",
    "children": [
      {
        "$ref": ".."
      }
    ]
  },
  "roles": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:44",
      "lastTime": "2026-03-09 00:09:44",
      "id": 961,
      "roletypeId": "95",
      "appId": "95",
      "name": "julian.ortiz",
      "code": "58719",
      "priority": 603,
      "isRegular": true,
      "isSuper": true,
      "isPublic": true,
      "status": 412,
      "description": "3kdnu2",
      "areaType": "vzea90"
    }
  ],
  "roleIds": [
    16
  ],
  "positionIds": [
    "j74kpc"
  ],
  "roleId": 329,
  "userRoleList": [
    {
      "id": 92,
      "deptId": 423,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "roleId": 662,
      "roleName": "julian.ortiz",
      "adminId": 311
    }
  ],
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ckrmde",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|企业管理用户ID|false|-
userId|string|系统管理用户ID|false|-
organId|string|机构ID|false|-
deptId|int64|单位ID|false|-
createType|int32|创建方式0导入1录入2授权|false|-
name|string|显示名称，可设置为用户名、手机号、昵称、真名|false|-
username|string|用户名|false|-
mobile|string|手机号码|false|-
email|string|电子邮箱|false|-
password|string|密码|false|-
salt|string|混淆字符|false|-
imagePath|string|头像|false|-
adminType|string|管理类型：ADMIN管理员，DEMO演示用户|false|-
isSuperAdmin|boolean|是否超级管理员|false|-
isAuditAdmin|boolean|是否审计只读管理员|false|-
isSelfAdmin|boolean|是否只管理自己的数据|false|-
adminRange|string|管理的范围配置JSON，APP_ID或者SITE_ID的数组，或者单个APP_ID|false|-
adminPerms|string|管理权限JSON|false|-
lastAppId|string|最后登录的应用ID|false|-
lastLoginTime|string|最后登录时间|false|-
lastLoginIp|string|最后登录IP|false|-
loginCount|int32|登录次数|false|-
status|int32|状态0未生效1正常2受限3锁定4删除|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
roleIds|array|角色组|false|-
positionIds|array|岗位组|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/disable/{id}.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:44",
  "lastTime": "2026-03-09 00:09:44",
  "id": 106,
  "userId": "95",
  "organId": "95",
  "deptId": 242,
  "createType": 654,
  "name": "julian.ortiz",
  "username": "julian.ortiz",
  "mobile": "1-508-337-4557",
  "email": "columbus.ankunding@gmail.com",
  "password": "a7hkqi",
  "salt": "pegyc0",
  "imagePath": "8jjcbt",
  "adminType": "hs4edg",
  "isSuperAdmin": true,
  "isAuditAdmin": true,
  "isSelfAdmin": true,
  "adminRange": "6qnvcb",
  "adminPerms": "2b6t41",
  "lastAppId": "95",
  "lastLoginTime": "2026-03-09 00:09:44",
  "lastLoginIp": "207.227.60.208",
  "loginCount": 698,
  "status": 544,
  "delFlag": 9,
  "spare1": "6eersl",
  "spare2": "anhez4",
  "roleIds": [
    290
  ],
  "positionIds": [
    "qvlxpw"
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "i7wyyh",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
deptName|string|部门名称|false|-
organId|string|机构ID|false|-
organName|string|机构名称|false|-
name|string|人员姓名|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
imagePath|string|用户头像|false|-
password|string|密码|false|-
isSuperAdmin|boolean|是否超级管理员|false|-
isAuditAdmin|boolean|是否审计只读管理员|false|-
isSelfAdmin|boolean|是否只管理自己的数据|false|-
status|int32|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
lastLoginIp|string|最后登录IP|false|-
lastLoginTime|string|最后登录时间|false|-
description|string|备注,办公地址|false|-
dept|object|部门对象|false|-
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
roles|array|角色对象|false|-
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
roleIds|array|角色组|false|-
positionIds|array|岗位组|false|-
roleId|int64|角色ID|false|-
userRoleList|array|角色集合|false|-
└─id|int64|用户角色ID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─adminId|int64|公共管理用户ID|false|-
code|string|验证码|false|-
uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/resetpassword/.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:44",
  "lastTime": "2026-03-09 00:09:44",
  "id": 51,
  "userId": "95",
  "deptId": 529,
  "deptName": "julian.ortiz",
  "organId": "95",
  "organName": "julian.ortiz",
  "name": "julian.ortiz",
  "username": "julian.ortiz",
  "nickName": "shane.roberts",
  "email": "columbus.ankunding@gmail.com",
  "mobile": "1-508-337-4557",
  "imagePath": "05g1pc",
  "password": "jniu7d",
  "isSuperAdmin": true,
  "isAuditAdmin": true,
  "isSelfAdmin": true,
  "status": 470,
  "delFlag": 9,
  "lastLoginIp": "207.227.60.208",
  "lastLoginTime": "2026-03-09 00:09:44",
  "description": "yyb9tu",
  "dept": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:44",
    "lastTime": "2026-03-09 00:09:44",
    "id": 262,
    "organId": "95",
    "parentId": 981,
    "appId": "95",
    "depttypeId": 23,
    "foreignId": "95",
    "createType": 690,
    "type": "wbw00w",
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "areaCode": "58719",
    "organLeader": "u6dyx1",
    "leaderId": "95",
    "leaderMobile": "1-508-337-4557",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "58719",
    "imagePath": "f76wd4",
    "priority": 162,
    "status": 603,
    "delFlag": 9,
    "description": "gvfu4a",
    "spare1": "z7iwsv",
    "spare2": "jcwrli",
    "children": [
      {
        "$ref": ".."
      }
    ]
  },
  "roles": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:44",
      "lastTime": "2026-03-09 00:09:44",
      "id": 637,
      "roletypeId": "95",
      "appId": "95",
      "name": "julian.ortiz",
      "code": "58719",
      "priority": 75,
      "isRegular": true,
      "isSuper": true,
      "isPublic": true,
      "status": 631,
      "description": "enf6kb",
      "areaType": "eapemn"
    }
  ],
  "roleIds": [
    859
  ],
  "positionIds": [
    "e0gq17"
  ],
  "roleId": 599,
  "userRoleList": [
    {
      "id": 280,
      "deptId": 103,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "roleId": 888,
      "roleName": "julian.ortiz",
      "adminId": 927
    }
  ],
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "y8amz7",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "dyv7fz",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/export.do --data 'writer.psOut.autoFlush=true&mobile=1-508-337-4557&q=vck3i6&adminId=359&status=947&organId=95&page=1&writer.psOut.textOut.nextChar=781&writer.formatter.zero=a&writer.psOut.trouble=true&writer.formatter.lastException.detailMessage=success&writer.psOut.textOut.nChars=774&deptId=949&bufferSize=10&writer.psOut.closing=true&delFlag=9&writer.psOut.formatter.zero=c&contentType=9ci88i&writer.psOut.closed=true&nickName=shane.roberts&writer.writeBuffer=t&writer.writeBuffer=t&writer.autoFlush=true&limit=10&endTime=2026-03-09 00:08:33&startTime=2026-03-09 00:08:33&email=columbus.ankunding@gmail.com&userId=95&orderBy=953&writer.trouble=true&characterEncoding=wqgwic&username=julian.ortiz&status=7y3x8y&committed=true'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "vedcr4",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "kc53z7",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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


**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/importTemplate.do --data 'writer.psOut.textOut.nChars=859&writer.psOut.autoFlush=true&writer.formatter.lastException.detailMessage=success&status=370&writer.trouble=true&characterEncoding=1l313a&bufferSize=10&writer.psOut.trouble=true&writer.psOut.formatter.zero=1&writer.autoFlush=true&writer.writeBuffer=8&writer.writeBuffer=8&writer.formatter.zero=b&writer.psOut.textOut.nextChar=911&writer.psOut.closing=true&committed=true&writer.psOut.closed=true&contentType=u5cagq'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "bnheic",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
deptName|string|部门名称|false|-
organId|string|机构ID|false|-
organName|string|机构名称|false|-
name|string|人员姓名|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
imagePath|string|用户头像|false|-
password|string|密码|false|-
isSuperAdmin|boolean|是否超级管理员|false|-
isAuditAdmin|boolean|是否审计只读管理员|false|-
isSelfAdmin|boolean|是否只管理自己的数据|false|-
status|int32|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
lastLoginIp|string|最后登录IP|false|-
lastLoginTime|string|最后登录时间|false|-
description|string|备注,办公地址|false|-
dept|object|部门对象|false|-
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
roles|array|角色对象|false|-
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
roleIds|array|角色组|false|-
positionIds|array|岗位组|false|-
roleId|int64|角色ID|false|-
userRoleList|array|角色集合|false|-
└─id|int64|用户角色ID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─adminId|int64|公共管理用户ID|false|-
code|string|验证码|false|-
uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/resetPwd.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:44",
  "lastTime": "2026-03-09 00:09:44",
  "id": 577,
  "userId": "95",
  "deptId": 950,
  "deptName": "julian.ortiz",
  "organId": "95",
  "organName": "julian.ortiz",
  "name": "julian.ortiz",
  "username": "julian.ortiz",
  "nickName": "shane.roberts",
  "email": "columbus.ankunding@gmail.com",
  "mobile": "1-508-337-4557",
  "imagePath": "q16k9f",
  "password": "nwq9o6",
  "isSuperAdmin": true,
  "isAuditAdmin": true,
  "isSelfAdmin": true,
  "status": 527,
  "delFlag": 9,
  "lastLoginIp": "207.227.60.208",
  "lastLoginTime": "2026-03-09 00:09:44",
  "description": "okzng7",
  "dept": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:44",
    "lastTime": "2026-03-09 00:09:44",
    "id": 782,
    "organId": "95",
    "parentId": 304,
    "appId": "95",
    "depttypeId": 222,
    "foreignId": "95",
    "createType": 541,
    "type": "4gtx9c",
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "areaCode": "58719",
    "organLeader": "4rj5dv",
    "leaderId": "95",
    "leaderMobile": "1-508-337-4557",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "58719",
    "imagePath": "ct94j0",
    "priority": 502,
    "status": 386,
    "delFlag": 9,
    "description": "gnsv8z",
    "spare1": "aruu2a",
    "spare2": "ls2kar",
    "children": [
      {
        "$ref": ".."
      }
    ]
  },
  "roles": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:44",
      "lastTime": "2026-03-09 00:09:44",
      "id": 6,
      "roletypeId": "95",
      "appId": "95",
      "name": "julian.ortiz",
      "code": "58719",
      "priority": 979,
      "isRegular": true,
      "isSuper": true,
      "isPublic": true,
      "status": 696,
      "description": "b6rair",
      "areaType": "57cw6g"
    }
  ],
  "roleIds": [
    411
  ],
  "positionIds": [
    "h13sp2"
  ],
  "roleId": 890,
  "userRoleList": [
    {
      "id": 694,
      "deptId": 492,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "roleId": 315,
      "roleName": "julian.ortiz",
      "adminId": 599
    }
  ],
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ujakw3",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
deptName|string|部门名称|false|-
organId|string|机构ID|false|-
organName|string|机构名称|false|-
name|string|人员姓名|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
imagePath|string|用户头像|false|-
password|string|密码|false|-
isSuperAdmin|boolean|是否超级管理员|false|-
isAuditAdmin|boolean|是否审计只读管理员|false|-
isSelfAdmin|boolean|是否只管理自己的数据|false|-
status|int32|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
lastLoginIp|string|最后登录IP|false|-
lastLoginTime|string|最后登录时间|false|-
description|string|备注,办公地址|false|-
dept|object|部门对象|false|-
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
roles|array|角色对象|false|-
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
roleIds|array|角色组|false|-
positionIds|array|岗位组|false|-
roleId|int64|角色ID|false|-
userRoleList|array|角色集合|false|-
└─id|int64|用户角色ID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─adminId|int64|公共管理用户ID|false|-
code|string|验证码|false|-
uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/changeStatus.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:44",
  "lastTime": "2026-03-09 00:09:44",
  "id": 646,
  "userId": "95",
  "deptId": 57,
  "deptName": "julian.ortiz",
  "organId": "95",
  "organName": "julian.ortiz",
  "name": "julian.ortiz",
  "username": "julian.ortiz",
  "nickName": "shane.roberts",
  "email": "columbus.ankunding@gmail.com",
  "mobile": "1-508-337-4557",
  "imagePath": "285y2z",
  "password": "ehbm8s",
  "isSuperAdmin": true,
  "isAuditAdmin": true,
  "isSelfAdmin": true,
  "status": 894,
  "delFlag": 9,
  "lastLoginIp": "207.227.60.208",
  "lastLoginTime": "2026-03-09 00:09:44",
  "description": "60agtp",
  "dept": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:44",
    "lastTime": "2026-03-09 00:09:44",
    "id": 209,
    "organId": "95",
    "parentId": 254,
    "appId": "95",
    "depttypeId": 892,
    "foreignId": "95",
    "createType": 313,
    "type": "rc495y",
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "areaCode": "58719",
    "organLeader": "5e713k",
    "leaderId": "95",
    "leaderMobile": "1-508-337-4557",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "58719",
    "imagePath": "hzvmd7",
    "priority": 125,
    "status": 423,
    "delFlag": 9,
    "description": "1vtewx",
    "spare1": "724g6u",
    "spare2": "eijut9",
    "children": [
      {
        "$ref": ".."
      }
    ]
  },
  "roles": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:44",
      "lastTime": "2026-03-09 00:09:44",
      "id": 107,
      "roletypeId": "95",
      "appId": "95",
      "name": "julian.ortiz",
      "code": "58719",
      "priority": 88,
      "isRegular": true,
      "isSuper": true,
      "isPublic": true,
      "status": 950,
      "description": "b0h5q4",
      "areaType": "un758x"
    }
  ],
  "roleIds": [
    577
  ],
  "positionIds": [
    "ntycvj"
  ],
  "roleId": 723,
  "userRoleList": [
    {
      "id": 225,
      "deptId": 839,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "roleId": 710,
      "roleName": "julian.ortiz",
      "adminId": 535
    }
  ],
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "jklrw7",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole/760.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "pbgf7m",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole.do --data 'adminId=541&roleIds=xu86ns&roleIds=xu86ns'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "hy1vab",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 个人资料信息
**URL:** https://linlan.net/eframe_backend/api/admin/user/profile.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─user|object|当前用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─password|string|密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─authorities|array|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userId|string|用户UUID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userLid|int64|用户LID|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "user": {
      "username": "julian.ortiz",
      "password": "tqcotv",
      "authorities": [
        {
          "object": "any object"
        }
      ],
      "userId": "95",
      "userLid": 375,
      "appId": "95",
      "deptId": 735,
      "organId": "95",
      "token": "jwa43n",
      "viewName": "julian.ortiz",
      "needChangePassword": true,
      "email": "columbus.ankunding@gmail.com",
      "mobile": "1-508-337-4557",
      "imagePath": "1mf6b4",
      "loginCount": 121,
      "loginIp": "207.227.60.208",
      "lastUpdatePasswordTime": "2026-03-09 00:09:44",
      "lastTime": "2026-03-09 00:09:44",
      "foreignId": "95",
      "expireTime": "2026-03-09 00:09:44",
      "loginTime": "2026-03-09 00:09:44",
      "userType": "c59zmu",
      "isSuperAdmin": true,
      "loginBrowse": "rn2422",
      "loginOs": "wpl62i",
      "perms": [
        "l5ays5"
      ]
    },
    "roleGroup": "6tvqvo",
    "positionGroup": "1dn6kx"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 个人信息
**URL:** https://linlan.net/eframe_backend/api/admin/user/info.do

**Type:** GET

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:45",
    "lastTime": "2026-03-09 00:09:45",
    "id": 418,
    "userId": "95",
    "deptId": 443,
    "deptName": "julian.ortiz",
    "organId": "95",
    "organName": "julian.ortiz",
    "name": "julian.ortiz",
    "username": "julian.ortiz",
    "nickName": "shane.roberts",
    "email": "columbus.ankunding@gmail.com",
    "mobile": "1-508-337-4557",
    "imagePath": "e5u1uv",
    "password": "vq1n0z",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 976,
    "delFlag": 9,
    "lastLoginIp": "207.227.60.208",
    "lastLoginTime": "2026-03-09 00:09:45",
    "description": "wteuqb",
    "dept": {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:45",
      "lastTime": "2026-03-09 00:09:45",
      "id": 249,
      "organId": "95",
      "parentId": 526,
      "appId": "95",
      "depttypeId": 397,
      "foreignId": "95",
      "createType": 20,
      "type": "cqrqt5",
      "name": "julian.ortiz",
      "sname": "julian.ortiz",
      "areaCode": "58719",
      "organLeader": "whxp6p",
      "leaderId": "95",
      "leaderMobile": "1-508-337-4557",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "58719",
      "imagePath": "zr2sr0",
      "priority": 29,
      "status": 552,
      "delFlag": 9,
      "description": "hv22x0",
      "spare1": "nmmeh8",
      "spare2": "dijmh5",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:45",
        "lastTime": "2026-03-09 00:09:45",
        "id": 588,
        "roletypeId": "95",
        "appId": "95",
        "name": "julian.ortiz",
        "code": "58719",
        "priority": 649,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 905,
        "description": "zz7k2h",
        "areaType": "60no48"
      }
    ],
    "roleIds": [
      414
    ],
    "positionIds": [
      "pedfml"
    ],
    "roleId": 460,
    "userRoleList": [
      {
        "id": 505,
        "deptId": 404,
        "deptName": "julian.ortiz",
        "organId": "95",
        "organName": "julian.ortiz",
        "roleId": 997,
        "roleName": "julian.ortiz",
        "adminId": 61
      }
    ],
    "code": "58719",
    "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 修改用户个人信息
**URL:** https://linlan.net/eframe_backend/api/admin/user/profile.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 修改用户个人信息

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|用户LID|false|-
userId|string|用户UUID|false|-
deptId|int64|部门ID|false|-
deptName|string|部门名称|false|-
organId|string|机构ID|false|-
organName|string|机构名称|false|-
name|string|人员姓名|false|-
username|string|用户账号|false|-
nickName|string|用户昵称|false|-
email|string|用户邮箱|false|-
mobile|string|手机号码|false|-
imagePath|string|用户头像|false|-
password|string|密码|false|-
isSuperAdmin|boolean|是否超级管理员|false|-
isAuditAdmin|boolean|是否审计只读管理员|false|-
isSelfAdmin|boolean|是否只管理自己的数据|false|-
status|int32|帐号状态（0未生效 1正常）|false|-
delFlag|int32|删除标志（0代表存在 2代表删除）|false|-
lastLoginIp|string|最后登录IP|false|-
lastLoginTime|string|最后登录时间|false|-
description|string|备注,办公地址|false|-
dept|object|部门对象|false|-
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
roles|array|角色对象|false|-
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
roleIds|array|角色组|false|-
positionIds|array|岗位组|false|-
roleId|int64|角色ID|false|-
userRoleList|array|角色集合|false|-
└─id|int64|用户角色ID|false|-
└─deptId|int64|部门ID|false|-
└─deptName|string|部门名称|false|-
└─organId|string|机构ID|false|-
└─organName|string|机构名称|false|-
└─roleId|int64|角色ID|false|-
└─roleName|string|角色名称|false|-
└─adminId|int64|公共管理用户ID|false|-
code|string|验证码|false|-
uuid|string|uuid标识|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/profile.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:45",
  "lastTime": "2026-03-09 00:09:45",
  "id": 586,
  "userId": "95",
  "deptId": 28,
  "deptName": "julian.ortiz",
  "organId": "95",
  "organName": "julian.ortiz",
  "name": "julian.ortiz",
  "username": "julian.ortiz",
  "nickName": "shane.roberts",
  "email": "columbus.ankunding@gmail.com",
  "mobile": "1-508-337-4557",
  "imagePath": "taewxi",
  "password": "82mg4i",
  "isSuperAdmin": true,
  "isAuditAdmin": true,
  "isSelfAdmin": true,
  "status": 382,
  "delFlag": 9,
  "lastLoginIp": "207.227.60.208",
  "lastLoginTime": "2026-03-09 00:09:45",
  "description": "op0jif",
  "dept": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:45",
    "lastTime": "2026-03-09 00:09:45",
    "id": 886,
    "organId": "95",
    "parentId": 555,
    "appId": "95",
    "depttypeId": 453,
    "foreignId": "95",
    "createType": 33,
    "type": "izhw6r",
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "areaCode": "58719",
    "organLeader": "k3oro3",
    "leaderId": "95",
    "leaderMobile": "1-508-337-4557",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "58719",
    "imagePath": "ltfi9u",
    "priority": 481,
    "status": 423,
    "delFlag": 9,
    "description": "dgxzp8",
    "spare1": "hemqyy",
    "spare2": "w5fmnn",
    "children": [
      {
        "$ref": ".."
      }
    ]
  },
  "roles": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:45",
      "lastTime": "2026-03-09 00:09:45",
      "id": 597,
      "roletypeId": "95",
      "appId": "95",
      "name": "julian.ortiz",
      "code": "58719",
      "priority": 682,
      "isRegular": true,
      "isSuper": true,
      "isPublic": true,
      "status": 767,
      "description": "52xd3d",
      "areaType": "bkg014"
    }
  ],
  "roleIds": [
    171
  ],
  "positionIds": [
    "o564e4"
  ],
  "roleId": 686,
  "userRoleList": [
    {
      "id": 501,
      "deptId": 745,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "roleId": 712,
      "roleName": "julian.ortiz",
      "adminId": 395
    }
  ],
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": true,
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 个人修改密码
**URL:** https://linlan.net/eframe_backend/api/admin/user/updatePwd.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

**Content-Type:** application/json; charset=utf-8

**Description:** 个人修改密码

**Request-headers:**

Header | Type|Description|Required|Since
---|---|---|---|----
token|string|令牌|true|-


**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
oldPassword|string|旧密码|false|-
newPassword|string|新密码|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/updatePwd.do --data '{
  "oldPassword": "317k43",
  "newPassword": "5l06j8"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "waring": "You may have used non-display generics."
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 用户头像上传
**URL:** https://linlan.net/eframe_backend/api/admin/user/imagePath.do

**Type:** POST

**Author:** Linlan
CreateTime 2024-10-02 23:27:08

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
method|string|No comments found.|false|-
userPrincipal|object|No comments found.|false|-
└─name|string|No comments found.|false|-
session|object|No comments found.|false|-
└─id|string|No comments found.|false|-
└─creationTime|int64|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─lastAccessedTime|int64|No comments found.|false|-
└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
└─new|boolean|No comments found.|false|-
└─maxInactiveInterval|int32|No comments found.|false|-
headerNames|object|No comments found.|false|-
trailerFields|map|No comments found.|false|-
└─any object|object|any object.|false|-
requestURI|string|No comments found.|false|-
pathTranslated|string|No comments found.|false|-
remoteUser|string|No comments found.|false|-
requestURL|object|No comments found.|false|-
└─empty|boolean|No comments found.|false|-
└─value|array|No comments found.|false|-
└─coder|int8|No comments found.|false|-
└─count|int32|No comments found.|false|-
authType|string|No comments found.|false|-
queryString|string|No comments found.|false|-
servletPath|string|No comments found.|false|-
contextPath|string|No comments found.|false|-
pathInfo|string|No comments found.|false|-
parts|array|No comments found.|false|-
requestedSessionIdValid|boolean|No comments found.|false|-
httpServletMapping|object|No comments found.|false|-
└─pattern|string|No comments found.|false|-
└─mappingMatch|enum|null<br/>CONTEXT_ROOT<br/>DEFAULT<br/>EXACT<br/>EXTENSION<br/>PATH<br/>|false|-
└─servletName|string|No comments found.|false|-
└─matchValue|string|No comments found.|false|-
requestedSessionIdFromCookie|boolean|No comments found.|false|-
trailerFieldsReady|boolean|No comments found.|false|-
requestedSessionIdFromURL|boolean|No comments found.|false|-
requestedSessionId|string|No comments found.|false|-
cookies|array|No comments found.|false|-
└─name|string|No comments found.|false|-
└─value|string|No comments found.|false|-
└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
scheme|string|No comments found.|false|-
inputStream|object|No comments found.|false|-
protocol|string|No comments found.|false|-
locale|object|No comments found.|false|-
contentLength|int32|No comments found.|false|-
contentLengthLong|int64|No comments found.|false|-
contentType|string|No comments found.|false|-
localName|string|No comments found.|false|-
attributeNames|object|No comments found.|false|-
parameterMap|map|No comments found.|false|-
└─any object|object|any object.|false|-
reader|object|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─skipBuffer|array|No comments found.|false|-
└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
└─cb|array|No comments found.|false|-
└─nChars|int32|No comments found.|false|-
└─nextChar|int32|No comments found.|false|-
└─markedChar|int32|No comments found.|false|-
└─readAheadLimit|int32|No comments found.|false|-
└─skipLF|boolean|No comments found.|false|-
└─markedSkipLF|boolean|No comments found.|false|-
parameterNames|object|No comments found.|false|-
requestId|string|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
serverName|string|No comments found.|false|-
locales|object|No comments found.|false|-
dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
servletContext|object|No comments found.|false|-
└─classLoader|object|No comments found.|false|-
└─majorVersion|int32|No comments found.|false|-
└─minorVersion|int32|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─effectiveMajorVersion|int32|No comments found.|false|-
└─effectiveMinorVersion|int32|No comments found.|false|-
└─initParameterNames|object|No comments found.|false|-
└─servletContextName|string|No comments found.|false|-
└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
└─defaultSessionTrackingModes|array|No comments found.|false|-
└─responseCharacterEncoding|string|No comments found.|false|-
└─virtualServerName|string|No comments found.|false|-
└─effectiveSessionTrackingModes|array|No comments found.|false|-
└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─requestCharacterEncoding|string|No comments found.|false|-
└─contextPath|string|No comments found.|false|-
└─sessionTimeout|int32|No comments found.|false|-
└─serverInfo|string|No comments found.|false|-
asyncSupported|boolean|No comments found.|false|-
asyncStarted|boolean|No comments found.|false|-
localAddr|string|No comments found.|false|-
remoteHost|string|No comments found.|false|-
remoteAddr|string|No comments found.|false|-
serverPort|int32|No comments found.|false|-
asyncContext|object|No comments found.|false|-
└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─scheme|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─inputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLength|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLengthLong|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterMap|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─reader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─readAheadLimit|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedSkipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locales|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncSupported|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncStarted|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteHost|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─timeout|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletConnection|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolConnectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─connectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolRequestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remotePort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─timeout|int64|No comments found.|false|-
└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─outputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writer|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─committed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bufferSize|int32|No comments found.|false|-
servletConnection|object|No comments found.|false|-
└─protocol|string|No comments found.|false|-
└─protocolConnectionId|string|No comments found.|false|-
└─connectionId|string|No comments found.|false|-
└─secure|boolean|No comments found.|false|-
protocolRequestId|string|No comments found.|false|-
remotePort|int32|No comments found.|false|-
localPort|int32|No comments found.|false|-
secure|boolean|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: multipart/form-data' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/imagePath.do --data 'authType=um0arq&localPort=315&asyncContext.request.reader.skipLF=true&session.new=true&reader.markedSkipLF=true&asyncContext.request.reader.markedChar=760&servletConnection.secure=true&httpServletMapping.servletName=julian.ortiz&servletConnection.protocol=paq3lj&asyncContext.request.reader.readAheadLimit=10&servletContext.sessionCookieConfig.path=djjdg3&servletContext.servletContextName=julian.ortiz&servletConnection.connectionId=95&requestURL.count=80&asyncContext.request.protocolRequestId=95&localName=julian.ortiz&servletContext.effectiveMinorVersion=133&session.servletContext.sessionTimeout=177&session.servletContext.serverInfo=fmhu2o&asyncContext.request.servletContext.sessionTimeout=341&session.id=95&session.servletContext.effectiveMajorVersion=995&contextPath=7q4nh1&httpServletMapping.pattern=lhqe4o&session.servletContext.sessionCookieConfig.path=30o9yb&reader.nextChar=984&servletContext.sessionCookieConfig.secure=true&asyncContext.request.localName=julian.ortiz&asyncContext.request.servletContext.virtualServerName=julian.ortiz&asyncContext.request.asyncStarted=true&requestId=95&asyncContext.request.servletContext.servletContextName=julian.ortiz&session.servletContext.contextPath=o4yag4&session.creationTime=1772986113769&secure=true&asyncSupported=true&session.servletContext.virtualServerName=julian.ortiz&requestedSessionIdValid=true&serverPort=920&requestURL.coder=93&reader.skipLF=true&httpServletMapping.matchValue=9u8r0c&servletContext.minorVersion=680&servletContext.sessionCookieConfig.httpOnly=true&reader.nChars=844&asyncContext.request.servletContext.responseCharacterEncoding=ngpg63&session.servletContext.sessionCookieConfig.domain=hirthe.com&session.servletContext.sessionCookieConfig.maxAge=14&asyncContext.request.servletContext.serverInfo=t6f04d&userPrincipal.name=julian.ortiz&asyncContext.request.servletContext.requestCharacterEncoding=vrx22r&scheme=16s4c3&asyncContext.request.contentLengthLong=906&remotePort=340&servletContext.serverInfo=ojousd&asyncContext.response.bufferSize=10&remoteUser=h8jq0v&asyncContext.request.remoteHost=o9tef1&asyncContext.request.reader.nChars=212&requestedSessionId=95&servletContext.majorVersion=727&reader.markedChar=855&servletContext.effectiveMajorVersion=17&session.servletContext.majorVersion=518&contentLengthLong=599&asyncContext.request.requestId=95&servletContext.sessionCookieConfig.comment=acszew&session.servletContext.sessionCookieConfig.secure=true&asyncContext.request.contentLength=901&asyncContext.request.reader.nextChar=490&reader.readAheadLimit=10&session.servletContext.requestCharacterEncoding=tt0r6d&trailerFieldsReady=true&asyncContext.response.characterEncoding=zwsqlj&session.servletContext.sessionCookieConfig.comment=sys6im&session.servletContext.servletContextName=julian.ortiz&asyncContext.request.remoteAddr=01g0yj&cookies.=mkssrp&cookies.=mkssrp&servletContext.sessionCookieConfig.domain=hirthe.com&asyncContext.request.scheme=4798te&asyncContext.request.servletConnection.secure=true&servletContext.contextPath=uajhdt&remoteAddr=9l6vpr&asyncContext.request.asyncSupported=true&asyncContext.request.servletConnection.connectionId=95&servletPath=1jkof2&session.lastAccessedTime=1772986113769&servletContext.virtualServerName=julian.ortiz&asyncContext.request.asyncContext.timeout=386&characterEncoding=d14qvr&session.servletContext.sessionCookieConfig.httpOnly=true&remoteHost=td9ua9&servletConnection.protocolConnectionId=95&servletContext.sessionTimeout=425&servletContext.sessionCookieConfig.maxAge=14&session.servletContext.responseCharacterEncoding=b87dwd&session.maxInactiveInterval=504&protocol=eltrgv&asyncContext.request.remotePort=135&asyncContext.request.characterEncoding=5lebd9&asyncContext.request.serverName=julian.ortiz&asyncContext.request.secure=true&session.servletContext.effectiveMinorVersion=61&requestURI=83viv8&asyncContext.timeout=125&servletContext.requestCharacterEncoding=4sbk49&asyncContext.request.servletContext.minorVersion=786&asyncContext.request.protocol=r2stx8&servletContext.sessionCookieConfig.name=julian.ortiz&asyncContext.request.contentType=yhhm5u&asyncContext.request.dispatcherType=FORWARD&session.servletContext.sessionCookieConfig.name=julian.ortiz&asyncContext.response.writer.autoFlush=true&pathInfo=6erqde&dispatcherType=FORWARD&method=arnvbf&asyncContext.request.reader.markedSkipLF=true&requestedSessionIdFromCookie=true&asyncContext.request.servletContext.effectiveMinorVersion=749&asyncContext.request.serverPort=293&asyncContext.response.committed=true&serverName=julian.ortiz&asyncContext.request.servletContext.effectiveMajorVersion=925&asyncContext.request.servletContext.contextPath=lnkeke&reader.cb=v&reader.cb=v&queryString=m3wrve&asyncStarted=true&asyncContext.request.localPort=88&reader.skipBuffer=o&reader.skipBuffer=o&contentLength=313&asyncContext.request.localAddr=lk6ysh&cookies.=julian.ortiz&cookies.=julian.ortiz&localAddr=gn867j&contentType=5t6scv&session.servletContext.minorVersion=954&servletContext.responseCharacterEncoding=0mte76&asyncContext.response.contentType=eklsfe&httpServletMapping.mappingMatch=CONTEXT_ROOT&requestURL.empty=true&protocolRequestId=95&asyncContext.request.servletConnection.protocol=ovnafz&requestURL.value=104&requestURL.value=104&pathTranslated=9f6rde&asyncContext.response.writer.trouble=true&asyncContext.request.servletContext.majorVersion=137&requestedSessionIdFromURL=true&asyncContext.request.servletConnection.protocolConnectionId=95'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─imageUrl|string|角色组|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "imageUrl": "www.kandace-stamm.org"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
createTime|string|创建时间|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/list.do?status=999&endTime=2026-03-09 00:08:33&q=uglh3a&sname=julian.ortiz&orderBy=791&id=95&posType=5y01dy&posFunction=awl3e9&oname=julian.ortiz&description=967fdm&roletypeId=95&officePhone=(947) 505-4582&delFlag=9&name=julian.ortiz&ids=pk84ct&ids=pk84ct&startTime=2026-03-09 00:08:33&page=1&createTime=2026-03-09 00:08:33&postypeId=95&posRank=705&code=58719&isPub=true&mobilePhone=(947) 505-4582&groupId=95&positionId=95&limit=10&parentId=95
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 155,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "postId": "95",
        "postCode": "58719",
        "postName": "julian.ortiz",
        "postSort": 349,
        "status": 957,
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:46",
        "lastTime": "2026-03-09 00:09:46",
        "delFlag": 9,
        "remark": "zrc69a",
        "ids": [
          "xugnku"
        ],
        "positionId": "95",
        "flag": true
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/export.do --data 'writer.psOut.closing=true&writer.trouble=true&writer.formatter.lastException.detailMessage=success&q=nbmkhk&bufferSize=10&writer.formatter.zero=d&page=1&delFlag=9&status=690&postCode=58719&writer.psOut.textOut.nextChar=749&writer.psOut.textOut.nChars=117&committed=true&startTime=2026-03-09 00:08:33&writer.psOut.closed=true&writer.psOut.trouble=true&characterEncoding=sftv6w&limit=10&writer.psOut.formatter.zero=i&writer.writeBuffer=5&writer.writeBuffer=5&endTime=2026-03-09 00:08:33&writer.autoFlush=true&writer.psOut.autoFlush=true&orderBy=359&status=358&contentType=cp84my&postName=julian.ortiz'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "r1hgem",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/95.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:47",
    "lastTime": "2026-03-09 00:09:47",
    "id": "95",
    "parentId": "95",
    "postypeId": "95",
    "roletypeId": "95",
    "userId": "95",
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "code": "58719",
    "oname": "julian.ortiz",
    "posFunction": "qp8w4a",
    "posRank": 731,
    "posType": "g2n6h8",
    "editorType": "daw7pq",
    "isEditorCreate": true,
    "status": 945,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "95",
    "manageDeptids": "hc63ik",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "(947) 505-4582",
    "officePhone": "(947) 505-4582",
    "buildingId": "95",
    "roomNo": "sd2599",
    "extQmType": "9w7lb6",
    "extQmTypePhoto": "7bacwc",
    "extPosName": "julian.ortiz",
    "extOrganName": "julian.ortiz",
    "priority": 367,
    "priorityInOrgan": 833,
    "priorityInDomain": 13,
    "updaterId": "95",
    "updateTime": "2026-03-09 00:09:47",
    "delFlag": 9,
    "description": "8pvbuf",
    "remark": "e2sdux"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|岗位ID|false|-
parentId|string|父岗位ID|false|-
postypeId|string|岗位分类ID|false|-
roletypeId|string|角色分类ID|false|-
userId|string|系统管理用户ID|false|-
name|string|岗位名称|false|-
sname|string|岗位简称，别名|false|-
code|string|UAS岗位id|false|-
oname|string|岗位别名|false|-
posFunction|string|工作分工，二维码申请页面模板|false|-
posRank|int32|级别|false|-
posType|string|岗位类型|false|-
editorType|string|编制类型|false|-
isEditorCreate|boolean|是否编委创建|false|-
status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定4删除|false|-
isPub|boolean|是否公开0否1是|false|-
isAgent|boolean|是否代理岗位0否1是|false|-
isLeader|boolean|是否为部门领导0否1是|false|-
leaderId|string|部门领导用户ID|false|-
manageDeptids|string|分管内设机构|false|-
isBigContact|boolean|是否大通讯录|false|-
isSmallContact|boolean|是否小通讯录|false|-
mobilePhone|string|岗位移动手机|false|-
officePhone|string|岗位办公电话|false|-
buildingId|string|建筑楼栋号|false|-
roomNo|string|房间号|false|-
extQmType|string|微信签名类型|false|-
extQmTypePhoto|string|微信签名类型图片|false|-
extPosName|string|微信岗位|false|-
extOrganName|string|微信单位|false|-
priority|int32|排序|false|-
priorityInOrgan|int32|机构内排序|false|-
priorityInDomain|int32|应用域内排序|false|-
updaterId|string|修改人|false|-
updateTime|string|修改时间|false|-
delFlag|int32|删除标志0正常1已删除2应用内受限3回收站|false|-
description|string|描述，岗位职责|false|-
remark|string|备注|false|-
parentName|string|父岗位名称|false|-
roletypeName|string|角色分类名称|false|-
postypeName|string|角色分类名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "id": "95",
  "parentId": "95",
  "postypeId": "95",
  "roletypeId": "95",
  "userId": "95",
  "name": "julian.ortiz",
  "sname": "julian.ortiz",
  "code": "58719",
  "oname": "julian.ortiz",
  "posFunction": "88dv0p",
  "posRank": 959,
  "posType": "6e8s8y",
  "editorType": "yfcgel",
  "isEditorCreate": true,
  "status": 856,
  "isPub": true,
  "isAgent": true,
  "isLeader": true,
  "leaderId": "95",
  "manageDeptids": "3wc8sx",
  "isBigContact": true,
  "isSmallContact": true,
  "mobilePhone": "(947) 505-4582",
  "officePhone": "(947) 505-4582",
  "buildingId": "95",
  "roomNo": "8uultp",
  "extQmType": "pyzs50",
  "extQmTypePhoto": "hz5nqi",
  "extPosName": "julian.ortiz",
  "extOrganName": "julian.ortiz",
  "priority": 71,
  "priorityInOrgan": 132,
  "priorityInDomain": 479,
  "updaterId": "95",
  "updateTime": "2026-03-09 00:09:47",
  "delFlag": 9,
  "description": "e2ne35",
  "remark": "o7ssnh",
  "parentName": "julian.ortiz",
  "roletypeName": "julian.ortiz",
  "postypeName": "julian.ortiz"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "a5xqbn",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|岗位ID|false|-
parentId|string|父岗位ID|false|-
postypeId|string|岗位分类ID|false|-
roletypeId|string|角色分类ID|false|-
userId|string|系统管理用户ID|false|-
name|string|岗位名称|false|-
sname|string|岗位简称，别名|false|-
code|string|UAS岗位id|false|-
oname|string|岗位别名|false|-
posFunction|string|工作分工，二维码申请页面模板|false|-
posRank|int32|级别|false|-
posType|string|岗位类型|false|-
editorType|string|编制类型|false|-
isEditorCreate|boolean|是否编委创建|false|-
status|int32|岗位性质0未生效1启用，STATUS，状态0未生效1正常2受限3锁定4删除|false|-
isPub|boolean|是否公开0否1是|false|-
isAgent|boolean|是否代理岗位0否1是|false|-
isLeader|boolean|是否为部门领导0否1是|false|-
leaderId|string|部门领导用户ID|false|-
manageDeptids|string|分管内设机构|false|-
isBigContact|boolean|是否大通讯录|false|-
isSmallContact|boolean|是否小通讯录|false|-
mobilePhone|string|岗位移动手机|false|-
officePhone|string|岗位办公电话|false|-
buildingId|string|建筑楼栋号|false|-
roomNo|string|房间号|false|-
extQmType|string|微信签名类型|false|-
extQmTypePhoto|string|微信签名类型图片|false|-
extPosName|string|微信岗位|false|-
extOrganName|string|微信单位|false|-
priority|int32|排序|false|-
priorityInOrgan|int32|机构内排序|false|-
priorityInDomain|int32|应用域内排序|false|-
updaterId|string|修改人|false|-
updateTime|string|修改时间|false|-
delFlag|int32|删除标志0正常1已删除2应用内受限3回收站|false|-
description|string|描述，岗位职责|false|-
remark|string|备注|false|-
parentName|string|父岗位名称|false|-
roletypeName|string|角色分类名称|false|-
postypeName|string|角色分类名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "id": "95",
  "parentId": "95",
  "postypeId": "95",
  "roletypeId": "95",
  "userId": "95",
  "name": "julian.ortiz",
  "sname": "julian.ortiz",
  "code": "58719",
  "oname": "julian.ortiz",
  "posFunction": "vw98nc",
  "posRank": 97,
  "posType": "rscwt5",
  "editorType": "e1932q",
  "isEditorCreate": true,
  "status": 720,
  "isPub": true,
  "isAgent": true,
  "isLeader": true,
  "leaderId": "95",
  "manageDeptids": "27zngo",
  "isBigContact": true,
  "isSmallContact": true,
  "mobilePhone": "(947) 505-4582",
  "officePhone": "(947) 505-4582",
  "buildingId": "95",
  "roomNo": "49xh6q",
  "extQmType": "9v9bq7",
  "extQmTypePhoto": "lte016",
  "extPosName": "julian.ortiz",
  "extOrganName": "julian.ortiz",
  "priority": 351,
  "priorityInOrgan": 526,
  "priorityInDomain": 947,
  "updaterId": "95",
  "updateTime": "2026-03-09 00:09:47",
  "delFlag": 9,
  "description": "ojqbs0",
  "remark": "9p5p4a",
  "parentName": "julian.ortiz",
  "roletypeName": "julian.ortiz",
  "postypeName": "julian.ortiz"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "sz9zrv",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "7zr15d",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
postId|string|岗位序号|false|-
postCode|string|岗位编码|false|-
postName|string|岗位名称|false|-
postSort|int32|岗位排序|false|-
status|int32|状态（0未生效1正常2受限3锁定4删除）|false|-
creatorId|string|创建者|false|-
createTime|string|创建时间|false|-
lastTime|string|更新时间|false|-
delFlag|int32|删除标记（0正常 1删除）|false|-
remark|string|备注|false|-
ids|array|角色id集合|false|-
positionId|string|岗位ID|false|-
flag|boolean|用户是否存在此岗位标识 默认不存在|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/bind/{positionId}.do --data '{
  "postId": "95",
  "postCode": "58719",
  "postName": "julian.ortiz",
  "postSort": 43,
  "status": 894,
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "delFlag": 9,
  "remark": "nzq6oj",
  "ids": [
    "fv41zb"
  ],
  "positionId": "95",
  "flag": true
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "pp60wj",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
id|int64|用户角色ID|false|-
roleId|int64|角色ID|false|-
positionId|string|岗位ID|false|-
status|int32|审核状态0未审核1审核通过2冻结3例外|false|-
beginTime|string|开始时间|false|-
endTime|string|结束时间|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/unbind/{positionId}.do --data '{
  "id": 56,
  "roleId": 201,
  "positionId": "95",
  "status": 222,
  "beginTime": "2026-03-09",
  "endTime": "2026-03-09"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "tuhjby",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "postId": "95",
      "postCode": "58719",
      "postName": "julian.ortiz",
      "postSort": 252,
      "status": 30,
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:47",
      "lastTime": "2026-03-09 00:09:47",
      "delFlag": 9,
      "remark": "obam1t",
      "ids": [
        "d8rzo9"
      ],
      "positionId": "95",
      "flag": true
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/list.do?username=julian.ortiz&endTime=2026-03-09 00:08:33&q=nduml5&srcCode=897&startTime=2026-03-09 00:08:33&page=1&category=600&limit=10&userId=95&orderBy=345&operation=0d39cy&method=os0y05&ip=207.227.60.208&time=1772986113769&appId=95&createTime=2026-03-09 00:09:50
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 66,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "operId": 214,
        "title": "ldnsxl",
        "businessType": 186,
        "businessTypeName": "julian.ortiz",
        "businessTypes": [
          930
        ],
        "method": "sreawe",
        "requestMethod": "07eq80",
        "operatorType": 958,
        "operName": "julian.ortiz",
        "deptName": "julian.ortiz",
        "operUrl": "www.kandace-stamm.org",
        "operIp": "207.227.60.208",
        "operLocation": "ftvt1x",
        "operParam": "qc38jh",
        "jsonResult": "eo2j22",
        "status": 838,
        "errorMsg": "9kr6sn",
        "operTime": "2026-03-09 00:09:50",
        "costTime": 1772986113769,
        "remark": "citlca"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/export.do --data 'limit=10&writer.formatter.lastException.detailMessage=success&title=iejqmo&businessType=284&writer.psOut.closing=true&writer.psOut.closed=true&operIp=207.227.60.208&writer.trouble=true&startTime=2026-03-09 00:08:33&operTime=2026-03-09 00:09:50&endTime=2026-03-09 00:08:33&writer.psOut.trouble=true&writer.psOut.textOut.nChars=261&deptName=julian.ortiz&operId=856&operName=julian.ortiz&characterEncoding=547qhf&writer.psOut.autoFlush=true&remark=gyytz8&bufferSize=10&orderBy=158&contentType=z0fpkh&page=1&writer.psOut.formatter.zero=6&operatorType=235&writer.autoFlush=true&q=wy5lkf&writer.writeBuffer=q&writer.writeBuffer=q&writer.formatter.zero=v&status=420&committed=true&writer.psOut.textOut.nextChar=44&status=362'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "7zf8aw",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ryhksj",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/list.do?delFlag=9&q=wimbjl&organName=julian.ortiz&orderBy=158&endTime=2026-03-09 00:08:33&wlType=uvbo99&organId=95&page=1&limit=10&startTime=2026-03-09 00:08:33
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "ids": [
        "pfjn7c"
      ],
      "organId": "95",
      "organName": "julian.ortiz",
      "organSName": "julian.ortiz",
      "organCode": "58719",
      "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
      "wlType": "x81b2i",
      "wlTypeName": "julian.ortiz",
      "priority": 572,
      "delFlag": 9,
      "createTime": "2026-03-09 00:09:54",
      "lastTime": "2026-03-09 00:09:54",
      "contactName": "julian.ortiz",
      "contactEmail": "columbus.ankunding@gmail.com",
      "contactMobile": "1-508-337-4557",
      "description": "vmsdwy",
      "tel": "bc7u96"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "ids": [
      "bszy20"
    ],
    "organId": "95",
    "organName": "julian.ortiz",
    "organSName": "julian.ortiz",
    "organCode": "58719",
    "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
    "wlType": "stimkz",
    "wlTypeName": "julian.ortiz",
    "priority": 528,
    "delFlag": 9,
    "createTime": "2026-03-09 00:09:54",
    "lastTime": "2026-03-09 00:09:54",
    "contactName": "julian.ortiz",
    "contactEmail": "columbus.ankunding@gmail.com",
    "contactMobile": "1-508-337-4557",
    "description": "f7mae8",
    "tel": "osxj10"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
ids|array|机构ids|false|-
organId|string|机构id|false|-
organName|string|机构名称|false|-
organSName|string|简称|false|-
organCode|string|地域id|false|-
address|string|父类Id|false|-
wlType|string|类型|false|-
wlTypeName|string|类型中文|false|-
priority|int32|排序|false|-
delFlag|int32|状态: 1 删除，0有效|false|-
createTime|string|创建时间|false|-
lastTime|string|最近修改时间|false|-
contactName|string|联系人名称|false|-
contactEmail|string|联系人电子邮箱|false|-
contactMobile|string|联系人手机|false|-
description|string|公司简介|false|-
tel|string|单位电话|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/save.do --data '{
  "ids": [
    "qqde1q"
  ],
  "organId": "95",
  "organName": "julian.ortiz",
  "organSName": "julian.ortiz",
  "organCode": "58719",
  "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "wlType": "2eaulr",
  "wlTypeName": "julian.ortiz",
  "priority": 585,
  "delFlag": 9,
  "createTime": "2026-03-09 00:09:54",
  "lastTime": "2026-03-09 00:09:54",
  "contactName": "julian.ortiz",
  "contactEmail": "columbus.ankunding@gmail.com",
  "contactMobile": "1-508-337-4557",
  "description": "3os51v",
  "tel": "329nim"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "anv9eo",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
ids|array|机构ids|false|-
organId|string|机构id|false|-
organName|string|机构名称|false|-
organSName|string|简称|false|-
organCode|string|地域id|false|-
address|string|父类Id|false|-
wlType|string|类型|false|-
wlTypeName|string|类型中文|false|-
priority|int32|排序|false|-
delFlag|int32|状态: 1 删除，0有效|false|-
createTime|string|创建时间|false|-
lastTime|string|最近修改时间|false|-
contactName|string|联系人名称|false|-
contactEmail|string|联系人电子邮箱|false|-
contactMobile|string|联系人手机|false|-
description|string|公司简介|false|-
tel|string|单位电话|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/update.do --data '{
  "ids": [
    "0k9r8x"
  ],
  "organId": "95",
  "organName": "julian.ortiz",
  "organSName": "julian.ortiz",
  "organCode": "58719",
  "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "wlType": "ntzbkp",
  "wlTypeName": "julian.ortiz",
  "priority": 914,
  "delFlag": 9,
  "createTime": "2026-03-09 00:09:54",
  "lastTime": "2026-03-09 00:09:54",
  "contactName": "julian.ortiz",
  "contactEmail": "columbus.ankunding@gmail.com",
  "contactMobile": "1-508-337-4557",
  "description": "jyxngs",
  "tel": "59hghc"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "4h4e23",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "u2v1ry",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
ids|array|机构ids|false|-
organId|string|机构id|false|-
organName|string|机构名称|false|-
organSName|string|简称|false|-
organCode|string|地域id|false|-
address|string|父类Id|false|-
wlType|string|类型|false|-
wlTypeName|string|类型中文|false|-
priority|int32|排序|false|-
delFlag|int32|状态: 1 删除，0有效|false|-
createTime|string|创建时间|false|-
lastTime|string|最近修改时间|false|-
contactName|string|联系人名称|false|-
contactEmail|string|联系人电子邮箱|false|-
contactMobile|string|联系人手机|false|-
description|string|公司简介|false|-
tel|string|单位电话|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/disable/{id}.do --data '{
  "ids": [
    "dmhvmo"
  ],
  "organId": "95",
  "organName": "julian.ortiz",
  "organSName": "julian.ortiz",
  "organCode": "58719",
  "address": "Suite 395 2647 Romaguera Court， North Dewey， NE 11167",
  "wlType": "8agq9b",
  "wlTypeName": "julian.ortiz",
  "priority": 30,
  "delFlag": 9,
  "createTime": "2026-03-09 00:09:55",
  "lastTime": "2026-03-09 00:09:55",
  "contactName": "julian.ortiz",
  "contactEmail": "columbus.ankunding@gmail.com",
  "contactMobile": "1-508-337-4557",
  "description": "kxt9uy",
  "tel": "fz5dmq"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "y5hxjl",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

## 系统机构部门读写控制类
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list.do?areaCode=58719&name=julian.ortiz&sname=julian.ortiz&deptId=21&endTime=2026-03-09 00:08:33&creatorId=95&foreignId=95&spare1=mmu9gr&startTime=2026-03-09 00:08:33&organId=95&isOrganLevel=true&createType=496&description=7gv42r&isVirtual=true&imagePath=oq43sp&appId=95&isLeaf=true&type=moihdi&delFlag=9&limit=10&depttypeId=84&isDisabled=true&leaderId=95&status=12&q=8csxwz&page=1&spare2=46fat9&organLeader=gj66lx&parentId=997&searchCode=58719&leaderMobile=1-508-337-4557&orderBy=350
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─size|int32|No comments found.|-
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
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "size": 10,
    "pageNum": 900,
    "pageSize": 10,
    "startRow": 181,
    "endRow": 861,
    "total": 142,
    "pages": 448,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "o0prdd",
    "orderBy": "kxlgjf",
    "orderByOnly": true,
    "boundSqlInterceptor": {}
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/page.do?organId=95&isOrganLevel=true&deptId=740&sname=julian.ortiz&isVirtual=true&foreignId=95&leaderId=95&q=m8b7s7&searchCode=58719&areaCode=58719&leaderMobile=1-508-337-4557&type=dqktwq&spare2=8ve4df&createType=764&name=julian.ortiz&imagePath=8lgfs4&parentId=763&organLeader=jgvrcm&startTime=2026-03-09 00:08:33&page=1&isDisabled=true&status=419&depttypeId=692&isLeaf=true&creatorId=95&limit=10&delFlag=9&description=ytrtki&appId=95&orderBy=450&endTime=2026-03-09 00:08:33&spare1=m1z24e
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─size|int32|No comments found.|-
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
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "size": 10,
    "pageNum": 966,
    "pageSize": 10,
    "startRow": 223,
    "endRow": 435,
    "total": 379,
    "pages": 481,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "kbo0ui",
    "orderBy": "56oqg3",
    "orderByOnly": true,
    "boundSqlInterceptor": {}
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list/exclude/229.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "id": 308,
      "organId": "95",
      "organName": "julian.ortiz",
      "parentId": 5,
      "appId": "95",
      "depttypeId": 780,
      "foreignId": "95",
      "createType": 54,
      "type": "z206rx",
      "name": "julian.ortiz",
      "sname": "julian.ortiz",
      "areaCode": "58719",
      "organLeader": "q3cg75",
      "leaderId": "95",
      "leaderMobile": "1-508-337-4557",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "58719",
      "imagePath": "1qwn06",
      "priority": 527,
      "status": 808,
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:43",
      "lastTime": "2026-03-09 00:09:43",
      "delFlag": 9,
      "description": "7cqx89",
      "spare1": "lqrdhm",
      "spare2": "uak98m",
      "parentName": "julian.ortiz",
      "childNum": "23jv63"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/259.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "id": 894,
    "organId": "95",
    "organName": "julian.ortiz",
    "parentId": 96,
    "appId": "95",
    "depttypeId": 416,
    "foreignId": "95",
    "createType": 59,
    "type": "z0k2kb",
    "name": "julian.ortiz",
    "sname": "julian.ortiz",
    "areaCode": "58719",
    "organLeader": "rsltkj",
    "leaderId": "95",
    "leaderMobile": "1-508-337-4557",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "58719",
    "imagePath": "gnf4aw",
    "priority": 44,
    "status": 761,
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:43",
    "lastTime": "2026-03-09 00:09:43",
    "delFlag": 9,
    "description": "ysixga",
    "spare1": "azauaf",
    "spare2": "pzj91s",
    "parentName": "julian.ortiz",
    "childNum": "vp23tj"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/tree.do?creatorId=95&page=1&type=14ju6n&sname=julian.ortiz&isOrganLevel=true&isVirtual=true&name=julian.ortiz&parentId=924&status=257&spare1=lnhq0d&appId=95&delFlag=9&isLeaf=true&depttypeId=333&areaCode=58719&isDisabled=true&searchCode=58719&imagePath=f9r0sz&q=z8x4st&limit=10&endTime=2026-03-09 00:08:33&foreignId=95&leaderId=95&organId=95&orderBy=328&createType=670&leaderMobile=1-508-337-4557&spare2=444uwl&deptId=857&organLeader=phcytl&description=qvyuki&startTime=2026-03-09 00:08:33
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "title": "ldhowm",
      "id": "95",
      "parentId": "95",
      "extId": "95",
      "href": "y1z9cm",
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
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|单位ID|false|-
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
priority|int32|排序|false|-
status|int32|状态0未生效1正常2受限3锁定4删除|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
children|array|子部门|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:43",
  "lastTime": "2026-03-09 00:09:43",
  "id": 873,
  "organId": "95",
  "parentId": 25,
  "appId": "95",
  "depttypeId": 13,
  "foreignId": "95",
  "createType": 848,
  "type": "57mn14",
  "name": "julian.ortiz",
  "sname": "julian.ortiz",
  "areaCode": "58719",
  "organLeader": "enkvyu",
  "leaderId": "95",
  "leaderMobile": "1-508-337-4557",
  "isOrganLevel": true,
  "isVirtual": true,
  "isLeaf": true,
  "isDisabled": true,
  "searchCode": "58719",
  "imagePath": "iznzmg",
  "priority": 302,
  "status": 771,
  "delFlag": 9,
  "description": "udjg63",
  "spare1": "gt8yar",
  "spare2": "6ucupc",
  "children": [
    {
      "$ref": ".."
    }
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "gxe5cj",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|单位ID|false|-
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
priority|int32|排序|false|-
status|int32|状态0未生效1正常2受限3锁定4删除|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
children|array|子部门|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:43",
  "lastTime": "2026-03-09 00:09:43",
  "id": 980,
  "organId": "95",
  "parentId": 42,
  "appId": "95",
  "depttypeId": 511,
  "foreignId": "95",
  "createType": 121,
  "type": "pukq65",
  "name": "julian.ortiz",
  "sname": "julian.ortiz",
  "areaCode": "58719",
  "organLeader": "2q4wl6",
  "leaderId": "95",
  "leaderMobile": "1-508-337-4557",
  "isOrganLevel": true,
  "isVirtual": true,
  "isLeaf": true,
  "isDisabled": true,
  "searchCode": "58719",
  "imagePath": "0qcsj9",
  "priority": 6,
  "status": 439,
  "delFlag": 9,
  "description": "2ry7yf",
  "spare1": "85cpdf",
  "spare2": "hi7cw7",
  "children": [
    {
      "$ref": ".."
    }
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "8og1nn",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "somhs0",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|单位ID|false|-
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
priority|int32|排序|false|-
status|int32|状态0未生效1正常2受限3锁定4删除|false|-
delFlag|int32|是否删除1已删除0正常|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
children|array|子部门|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/disable/{id}.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:43",
  "lastTime": "2026-03-09 00:09:43",
  "id": 464,
  "organId": "95",
  "parentId": 142,
  "appId": "95",
  "depttypeId": 54,
  "foreignId": "95",
  "createType": 933,
  "type": "kdcy4z",
  "name": "julian.ortiz",
  "sname": "julian.ortiz",
  "areaCode": "58719",
  "organLeader": "crg8t2",
  "leaderId": "95",
  "leaderMobile": "1-508-337-4557",
  "isOrganLevel": true,
  "isVirtual": true,
  "isLeaf": true,
  "isDisabled": true,
  "searchCode": "58719",
  "imagePath": "kb6rol",
  "priority": 753,
  "status": 810,
  "delFlag": 9,
  "description": "edufub",
  "spare1": "n2cr2n",
  "spare2": "06azla",
  "children": [
    {
      "$ref": ".."
    }
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "xxpccs",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
username|string|用户名|false|-
password|string|用户密码|false|-
code|string|验证码|false|-
uuid|string|唯一标识|false|-
appId|string|所在应用ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login.do --data '{
  "username": "julian.ortiz",
  "password": "ikkfim",
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba",
  "appId": "95"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─userId|string|用户ID|-
└─token|string|令牌TOKEN|-
└─updateTime|string|更新时间|-
└─expireTime|string|过期时间|-
└─mobileConfirm|boolean|是否有手机号码|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "userId": "95",
    "token": "67nr8m",
    "updateTime": "2026-03-09 00:09:45",
    "expireTime": "2026-03-09 00:09:45",
    "mobileConfirm": true
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "user": {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:45",
      "lastTime": "2026-03-09 00:09:45",
      "id": 284,
      "userId": "95",
      "deptId": 128,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "name": "julian.ortiz",
      "username": "julian.ortiz",
      "nickName": "shane.roberts",
      "email": "columbus.ankunding@gmail.com",
      "mobile": "1-508-337-4557",
      "imagePath": "3hee78",
      "password": "p8mymd",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 999,
      "delFlag": 9,
      "lastLoginIp": "207.227.60.208",
      "lastLoginTime": "2026-03-09 00:09:45",
      "description": "h4bh1v",
      "dept": {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:45",
        "lastTime": "2026-03-09 00:09:45",
        "id": 846,
        "organId": "95",
        "parentId": 617,
        "appId": "95",
        "depttypeId": 945,
        "foreignId": "95",
        "createType": 823,
        "type": "phnaqj",
        "name": "julian.ortiz",
        "sname": "julian.ortiz",
        "areaCode": "58719",
        "organLeader": "mjajhp",
        "leaderId": "95",
        "leaderMobile": "1-508-337-4557",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "58719",
        "imagePath": "gy1qsx",
        "priority": 394,
        "status": 912,
        "delFlag": 9,
        "description": "bxmf9b",
        "spare1": "x1lnbq",
        "spare2": "s4p7oa",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "95",
          "createTime": "2026-03-09 00:09:45",
          "lastTime": "2026-03-09 00:09:45",
          "id": 32,
          "roletypeId": "95",
          "appId": "95",
          "name": "julian.ortiz",
          "code": "58719",
          "priority": 960,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 583,
          "description": "ci8t59",
          "areaType": "wraglu"
        }
      ],
      "roleIds": [
        971
      ],
      "positionIds": [
        "6ikhce"
      ],
      "roleId": 553,
      "userRoleList": [
        {
          "id": 908,
          "deptId": 225,
          "deptName": "julian.ortiz",
          "organId": "95",
          "organName": "julian.ortiz",
          "roleId": 497,
          "roleName": "julian.ortiz",
          "adminId": 715
        }
      ],
      "code": "58719",
      "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
    },
    "roles": [
      "4o34cm"
    ],
    "permissions": [
      "tlbk6s"
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "accountId": "95",
    "areaId": 972,
    "groupId": 67,
    "positionId": "95",
    "tplSolution": "7leiyy",
    "menuList": [
      {
        "id": 449,
        "parentId": 371,
        "name": "julian.ortiz",
        "ename": "julian.ortiz",
        "type": "26ctbv",
        "perms": "qn5qwx",
        "menuLevel": 899,
        "urlType": "0d094u",
        "url": "www.kandace-stamm.org",
        "menuSeq": "7xkp73",
        "icon": "b5bulk",
        "imagePath": "lcda0l",
        "css": "0w6k4q",
        "description": "xddhlk",
        "todoTotalApi": "4x16aj"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 内部应用，第三方应用登录方法，返回字段少的平台用户对象
**URL:** https://linlan.net/eframe_backend/platLogin.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 内部应用，第三方应用登录方法，返回字段少的平台用户对象

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
method|string|No comments found.|false|-
userPrincipal|object|No comments found.|false|-
└─name|string|No comments found.|false|-
session|object|No comments found.|false|-
└─id|string|No comments found.|false|-
└─creationTime|int64|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─lastAccessedTime|int64|No comments found.|false|-
└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
└─new|boolean|No comments found.|false|-
└─maxInactiveInterval|int32|No comments found.|false|-
headerNames|object|No comments found.|false|-
trailerFields|map|No comments found.|false|-
└─any object|object|any object.|false|-
requestURI|string|No comments found.|false|-
pathTranslated|string|No comments found.|false|-
remoteUser|string|No comments found.|false|-
requestURL|object|No comments found.|false|-
└─empty|boolean|No comments found.|false|-
└─value|array|No comments found.|false|-
└─coder|int8|No comments found.|false|-
└─count|int32|No comments found.|false|-
authType|string|No comments found.|false|-
queryString|string|No comments found.|false|-
servletPath|string|No comments found.|false|-
contextPath|string|No comments found.|false|-
pathInfo|string|No comments found.|false|-
parts|array|No comments found.|false|-
requestedSessionIdValid|boolean|No comments found.|false|-
httpServletMapping|object|No comments found.|false|-
└─pattern|string|No comments found.|false|-
└─mappingMatch|enum|null<br/>CONTEXT_ROOT<br/>DEFAULT<br/>EXACT<br/>EXTENSION<br/>PATH<br/>|false|-
└─servletName|string|No comments found.|false|-
└─matchValue|string|No comments found.|false|-
requestedSessionIdFromCookie|boolean|No comments found.|false|-
trailerFieldsReady|boolean|No comments found.|false|-
requestedSessionIdFromURL|boolean|No comments found.|false|-
requestedSessionId|string|No comments found.|false|-
cookies|array|No comments found.|false|-
└─name|string|No comments found.|false|-
└─value|string|No comments found.|false|-
└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
scheme|string|No comments found.|false|-
inputStream|object|No comments found.|false|-
protocol|string|No comments found.|false|-
locale|object|No comments found.|false|-
contentLength|int32|No comments found.|false|-
contentLengthLong|int64|No comments found.|false|-
contentType|string|No comments found.|false|-
localName|string|No comments found.|false|-
attributeNames|object|No comments found.|false|-
parameterMap|map|No comments found.|false|-
└─any object|object|any object.|false|-
reader|object|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─skipBuffer|array|No comments found.|false|-
└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
└─cb|array|No comments found.|false|-
└─nChars|int32|No comments found.|false|-
└─nextChar|int32|No comments found.|false|-
└─markedChar|int32|No comments found.|false|-
└─readAheadLimit|int32|No comments found.|false|-
└─skipLF|boolean|No comments found.|false|-
└─markedSkipLF|boolean|No comments found.|false|-
parameterNames|object|No comments found.|false|-
requestId|string|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
serverName|string|No comments found.|false|-
locales|object|No comments found.|false|-
dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
servletContext|object|No comments found.|false|-
└─classLoader|object|No comments found.|false|-
└─majorVersion|int32|No comments found.|false|-
└─minorVersion|int32|No comments found.|false|-
└─attributeNames|object|No comments found.|false|-
└─effectiveMajorVersion|int32|No comments found.|false|-
└─effectiveMinorVersion|int32|No comments found.|false|-
└─initParameterNames|object|No comments found.|false|-
└─servletContextName|string|No comments found.|false|-
└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspPropertyGroups|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─taglibs|array|No comments found.|false|-
└─defaultSessionTrackingModes|array|No comments found.|false|-
└─responseCharacterEncoding|string|No comments found.|false|-
└─virtualServerName|string|No comments found.|false|-
└─effectiveSessionTrackingModes|array|No comments found.|false|-
└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─name|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─path|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributes|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─comment|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─domain|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─maxAge|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─httpOnly|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─requestCharacterEncoding|string|No comments found.|false|-
└─contextPath|string|No comments found.|false|-
└─sessionTimeout|int32|No comments found.|false|-
└─serverInfo|string|No comments found.|false|-
asyncSupported|boolean|No comments found.|false|-
asyncStarted|boolean|No comments found.|false|-
localAddr|string|No comments found.|false|-
remoteHost|string|No comments found.|false|-
remoteAddr|string|No comments found.|false|-
serverPort|int32|No comments found.|false|-
asyncContext|object|No comments found.|false|-
└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─scheme|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─inputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLength|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentLengthLong|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterMap|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─reader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─in|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─readAheadLimit|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─skipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─markedSkipLF|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─parameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locales|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─dispatcherType|enum|null<br/>FORWARD<br/>INCLUDE<br/>REQUEST<br/>ASYNC<br/>ERROR<br/>|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─classLoader|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─majorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─minorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─attributeNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMajorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveMinorVersion|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─initParameterNames|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletContextName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─filterRegistrations|map|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─any object|object|any object.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─jspConfigDescriptor|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─defaultSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─responseCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─virtualServerName|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─effectiveSessionTrackingModes|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionCookieConfig|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─requestCharacterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contextPath|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─sessionTimeout|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverInfo|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncSupported|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncStarted|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteHost|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remoteAddr|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─serverPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─asyncContext|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─request|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─timeout|int64|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─servletConnection|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocol|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolConnectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─connectionId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─protocolRequestId|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─remotePort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─localPort|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─secure|boolean|No comments found.|false|-
└─timeout|int64|No comments found.|false|-
└─response|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─locale|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─contentType|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─outputStream|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writer|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─characterEncoding|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─committed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─bufferSize|int32|No comments found.|false|-
servletConnection|object|No comments found.|false|-
└─protocol|string|No comments found.|false|-
└─protocolConnectionId|string|No comments found.|false|-
└─connectionId|string|No comments found.|false|-
└─secure|boolean|No comments found.|false|-
protocolRequestId|string|No comments found.|false|-
remotePort|int32|No comments found.|false|-
localPort|int32|No comments found.|false|-
secure|boolean|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -i https://linlan.net/eframe_backend/platLogin.do --data 'asyncContext.request.dispatcherType=FORWARD&requestURL.count=931&asyncContext.request.servletConnection.secure=true&asyncSupported=true&session.servletContext.sessionCookieConfig.httpOnly=true&httpServletMapping.mappingMatch=CONTEXT_ROOT&session.servletContext.effectiveMajorVersion=408&method=mhr1q0&servletContext.requestCharacterEncoding=2xzzsq&localPort=637&session.servletContext.sessionCookieConfig.name=julian.ortiz&asyncContext.timeout=376&asyncContext.request.requestId=95&servletContext.sessionCookieConfig.name=julian.ortiz&asyncContext.request.servletContext.requestCharacterEncoding=nxoeiu&characterEncoding=omc855&asyncContext.request.reader.markedChar=896&cookies.=vv13j0&cookies.=vv13j0&session.servletContext.servletContextName=julian.ortiz&cookies.=julian.ortiz&cookies.=julian.ortiz&session.servletContext.sessionCookieConfig.path=uf3ijg&servletContext.virtualServerName=julian.ortiz&asyncContext.request.localName=julian.ortiz&asyncContext.response.characterEncoding=bsa8z2&reader.skipBuffer=j&reader.skipBuffer=j&queryString=1coi6d&contextPath=6i8qi9&servletContext.sessionCookieConfig.path=vqyhzd&asyncContext.request.servletContext.serverInfo=3azuf9&servletContext.sessionCookieConfig.httpOnly=true&servletContext.sessionCookieConfig.comment=o12bzu&requestURL.coder=9&servletContext.sessionTimeout=548&pathInfo=0obr7l&remoteAddr=cc7w1q&asyncContext.request.servletContext.minorVersion=469&asyncContext.request.secure=true&requestId=95&asyncContext.response.writer.autoFlush=true&asyncContext.request.contentType=gy4u54&servletConnection.protocolConnectionId=95&servletConnection.secure=true&protocolRequestId=95&reader.readAheadLimit=10&serverName=julian.ortiz&reader.skipLF=true&asyncContext.response.contentType=mbexgk&asyncContext.request.characterEncoding=6p71q7&session.servletContext.serverInfo=merc3q&asyncContext.request.reader.nextChar=428&servletContext.sessionCookieConfig.maxAge=14&servletContext.serverInfo=f0zmi1&requestedSessionIdValid=true&servletContext.majorVersion=281&asyncContext.request.servletContext.majorVersion=933&asyncContext.request.servletContext.virtualServerName=julian.ortiz&session.servletContext.sessionCookieConfig.domain=hirthe.com&pathTranslated=nhx984&requestURL.empty=true&servletContext.sessionCookieConfig.domain=hirthe.com&asyncContext.request.remotePort=550&asyncContext.request.contentLength=762&asyncContext.request.localAddr=b79du4&session.creationTime=1772986113769&secure=true&serverPort=718&asyncContext.request.remoteAddr=rnat6m&asyncContext.request.protocol=8654d4&asyncContext.response.bufferSize=10&session.lastAccessedTime=1772986113769&session.maxInactiveInterval=100&asyncContext.request.servletConnection.protocol=ohuy8z&session.servletContext.contextPath=ggzxkh&contentType=el76hf&servletContext.responseCharacterEncoding=03d3wg&session.servletContext.sessionCookieConfig.comment=k7c84d&asyncContext.request.localPort=207&asyncContext.request.servletContext.servletContextName=julian.ortiz&reader.nChars=166&asyncContext.request.asyncSupported=true&requestURL.value=36&requestURL.value=36&servletPath=8eiipe&asyncContext.request.contentLengthLong=506&asyncContext.request.reader.markedSkipLF=true&userPrincipal.name=julian.ortiz&asyncStarted=true&asyncContext.request.remoteHost=4xp5pf&asyncContext.request.servletContext.effectiveMajorVersion=121&asyncContext.request.asyncContext.timeout=855&session.servletContext.sessionCookieConfig.maxAge=14&session.servletContext.minorVersion=374&protocol=3dt7j4&session.id=95&requestURI=y7ufis&authType=t7dtev&session.servletContext.sessionCookieConfig.secure=true&servletContext.effectiveMajorVersion=754&servletContext.servletContextName=julian.ortiz&session.servletContext.sessionTimeout=500&asyncContext.request.reader.nChars=559&scheme=n1tb8r&session.servletContext.requestCharacterEncoding=sycf00&asyncContext.request.asyncStarted=true&asyncContext.request.protocolRequestId=95&reader.nextChar=415&httpServletMapping.pattern=zxwsjx&reader.markedSkipLF=true&dispatcherType=FORWARD&servletContext.effectiveMinorVersion=957&httpServletMapping.servletName=julian.ortiz&requestedSessionIdFromCookie=true&asyncContext.request.servletContext.sessionTimeout=718&reader.markedChar=300&httpServletMapping.matchValue=1ggp5g&localAddr=tz0cag&servletContext.minorVersion=73&asyncContext.request.reader.skipLF=true&asyncContext.request.servletContext.effectiveMinorVersion=926&asyncContext.request.serverName=julian.ortiz&asyncContext.request.servletContext.responseCharacterEncoding=4jixeh&servletConnection.protocol=u8l7pe&servletContext.contextPath=o3oijw&remoteHost=lfqnu1&asyncContext.request.servletConnection.connectionId=95&asyncContext.response.writer.trouble=true&asyncContext.request.servletContext.contextPath=l5w5p5&asyncContext.request.reader.readAheadLimit=10&session.servletContext.responseCharacterEncoding=meg3lo&asyncContext.request.servletConnection.protocolConnectionId=95&session.servletContext.effectiveMinorVersion=57&session.servletContext.virtualServerName=julian.ortiz&trailerFieldsReady=true&asyncContext.request.scheme=2n5hx3&requestedSessionId=95&requestedSessionIdFromURL=true&contentLength=761&session.servletContext.majorVersion=237&reader.cb=9&reader.cb=9&asyncContext.request.serverPort=628&asyncContext.response.committed=true&remotePort=674&remoteUser=72q37u&localName=julian.ortiz&session.new=true&servletContext.sessionCookieConfig.secure=true&servletConnection.connectionId=95&contentLengthLong=874'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "id": "95",
    "isAdmin": true,
    "isEncryt": true,
    "publicKey": "ub8o6b",
    "aesKey": "h836j2",
    "clientId": "95",
    "serverUrl": "www.kandace-stamm.org",
    "serverConf1": "lqqfrl",
    "appConf": {
      "siteId": 985,
      "appId": "95",
      "topXzqhId": "95",
      "appConfJson": {
        "mapKey": "182uxn"
      }
    },
    "isWork": true,
    "workConfig": {
      "layout": "jqw6hw",
      "siteInfo": {
        "id": 699,
        "appId": "95",
        "areaCode": "58719",
        "path": "rjc1w1",
        "name": "julian.ortiz",
        "sname": "julian.ortiz",
        "layout": "w5t97p",
        "logoUrl": "www.kandace-stamm.org",
        "cdnUrl": "www.kandace-stamm.org"
      }
    }
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
username|string|用户名|false|-
password|string|用户密码|false|-
code|string|验证码|false|-
uuid|string|唯一标识|false|-
appId|string|所在应用ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/third/ecorgan/login.do --data '{
  "username": "julian.ortiz",
  "password": "o1vz7g",
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba",
  "appId": "95"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─userId|string|用户ID|-
└─token|string|令牌TOKEN|-
└─updateTime|string|更新时间|-
└─expireTime|string|过期时间|-
└─mobileConfirm|boolean|是否有手机号码|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "userId": "95",
    "token": "e5fqf8",
    "updateTime": "2026-03-09 00:09:46",
    "expireTime": "2026-03-09 00:09:46",
    "mobileConfirm": true
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -i https://linlan.net/eframe_backend/captcha/verify.do?uuid=4ec13ebe-addd-4cd2-92d1-aec9105972ba&code=58719
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "rknzpf",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─any object|object|any object.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "mapKey": {
      "waring": "You may use java.util.Object for Map value; doc-generate can't be handle."
    }
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "cacheName": "julian.ortiz",
      "cacheKey": "emzweq",
      "cacheValue": "uh1of4",
      "remark": "dov34m"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getKeys/julian.ortiz.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": [
    {}
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getValue/julian.ortiz/j5h6lb.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "cacheName": "julian.ortiz",
    "cacheKey": "fyto77",
    "cacheValue": "b8bcp0",
    "remark": "vk4kdj"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheName/julian.ortiz.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "bxop8m",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheKey/g1o1bv.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "r3l4lf",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "7e5drn",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/list.do?orderBy=471&startTime=2026-03-09 00:08:33&menuName=julian.ortiz&visible=1yqfux&limit=10&menuId=484&delFlag=bw9vx6&endTime=2026-03-09 00:08:33&parentId=666&page=1&status=h0lxhk&currAppId=95&q=9kp98k&menuType=b4uosc
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "menuId": 910,
      "menuName": "julian.ortiz",
      "type": "qd4dtl",
      "typeName": "julian.ortiz",
      "parentName": "julian.ortiz",
      "parentId": 403,
      "priority": 475,
      "path": "yzeogs",
      "component": "5oekbm",
      "query": "9s6xll",
      "routeName": "julian.ortiz",
      "isFrame": "ag2yq4",
      "isCache": "eq25o8",
      "menuType": "oenofl",
      "menuTypeName": "julian.ortiz",
      "visible": "uf06go",
      "status": "oflho8",
      "perms": "45pg3b",
      "icon": "rs199u",
      "imagePath": "u8d3yv",
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:46",
      "lastTime": "2026-03-09 00:09:46",
      "children": [
        {
          "$ref": ".."
        }
      ],
      "childNum": 320,
      "description": "bgscth",
      "listJson": "2ttmda",
      "delFlag": 9,
      "permsList": [
        {
          "permsName": "julian.ortiz",
          "permsStr": "t3ccg2"
        }
      ],
      "buttonMenuList": [
        {
          "id": "95",
          "parentId": "95",
          "code": "58719",
          "name": "julian.ortiz"
        }
      ]
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/page.do?endTime=2026-03-09 00:08:33&menuName=julian.ortiz&currAppId=95&delFlag=lfkbpq&parentId=338&status=gmxw4o&visible=efz77a&q=fmgs0s&menuType=s8yna5&orderBy=826&startTime=2026-03-09 00:08:33&page=1&limit=10&menuId=794
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─size|int32|No comments found.|-
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
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "size": 10,
    "pageNum": 276,
    "pageSize": 10,
    "startRow": 23,
    "endRow": 777,
    "total": 822,
    "pages": 223,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "ylwjca",
    "orderBy": "tckhl4",
    "orderByOnly": true,
    "boundSqlInterceptor": {}
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/597.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "menuId": 7,
    "menuName": "julian.ortiz",
    "type": "8ki0ir",
    "typeName": "julian.ortiz",
    "parentName": "julian.ortiz",
    "parentId": 223,
    "priority": 382,
    "path": "14h36d",
    "component": "r6t9sh",
    "query": "94em7n",
    "routeName": "julian.ortiz",
    "isFrame": "nn1kj2",
    "isCache": "6zuhok",
    "menuType": "z3pk7p",
    "menuTypeName": "julian.ortiz",
    "visible": "uj5wtd",
    "status": "e8riib",
    "perms": "kp7cg0",
    "icon": "id6l80",
    "imagePath": "i8phs4",
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:46",
    "lastTime": "2026-03-09 00:09:46",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 671,
    "description": "r4q5mm",
    "listJson": "a1ko9k",
    "delFlag": 9,
    "permsList": [
      {
        "permsName": "julian.ortiz",
        "permsStr": "068s2e"
      }
    ],
    "buttonMenuList": [
      {
        "id": "95",
        "parentId": "95",
        "code": "58719",
        "name": "julian.ortiz"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeselect.do?endTime=2026-03-09 00:08:33&menuType=iwiiag&status=x076px&startTime=2026-03-09 00:08:33&menuId=912&limit=10&visible=3ff6y1&delFlag=p5ph6g&parentId=408&orderBy=43&currAppId=95&page=1&q=81dgo7&menuName=julian.ortiz
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "checkedKeys": [
      982
    ],
    "menus": [
      {
        "id": 317,
        "label": "khf624",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeInit.do?popPosition=995&orderBy=301&description=mvcwqr&isMenuAll=ahdloh&spare1=vii0cw&q=idgd3j&page=1&code=58719&parentId=604&subCount=782&parentRoot=cdbxqn&imagePath=ibwaau&menuIds=gxjcgl&menuIds=gxjcgl&isProtect=true&offset=1&startTime=2026-03-09 00:08:33&parentNull=gceafp&isDisplay=true&typeNoButton=8alkx1&appId=95&limit=10&endTime=2026-03-09 00:08:33&isCheck=true&name=julian.ortiz&urlType=25iktp&type=23jp3h&appIds=syf9b6&appIds=syf9b6&icon=jamqzy&shortCut=wumqio&createTime=2026-03-09 00:08:33&isDisabled=true&url=www.kandace-stamm.org&delFlag=9&menuLevel=319&spare2=6fa75y
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "title": "rprpar",
      "id": "95",
      "parentId": "95",
      "extId": "95",
      "href": "k5h3ag",
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
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/roleMenuTreeselect/831.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "checkedKeys": [
      698
    ],
    "menus": [
      {
        "id": 178,
        "label": "90jrk9",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
menuId|int64|菜单ID|false|-
menuName|string|菜单名称|false|-
type|string|功能类型|false|-
typeName|string|功能类型|false|-
parentName|string|父菜单名称|false|-
parentId|int64|父菜单ID|false|-
priority|int32|显示顺序|false|-
path|string|简短名称ENAME|false|-
component|string|组件路径URL|false|-
query|string|路由参数JS_EVENT|false|-
routeName|string|路由地址|false|-
isFrame|string|是否为外链（0是 1否）|false|-
isCache|string|是否缓存（0缓存 1不缓存）|false|-
menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
visible|string|显示状态（0隐藏 1显示）|false|-
status|string|菜单禁用（0正常 1禁用）|false|-
perms|string|权限字符串|false|-
icon|string|菜单图标|false|-
imagePath|string|菜单图片|false|-
creatorId|string|创建者|false|-
createTime|string|创建时间|false|-
lastTime|string|更新时间|false|-
children|array|子菜单|false|-
childNum|int32|子菜单数量|false|-
description|string|备注|false|-
listJson|string|页面列表JSON|false|-
delFlag|int32|状态0正常1停用2已删除|false|-
permsList|array|权限数组|false|-
└─permsName|string|权限名称|false|-
└─permsStr|string|权限字符串|false|-
buttonMenuList|array|子菜单按钮|false|-
└─id|string|主键|false|-
└─parentId|string|父节点ID|false|-
└─code|string|代码|false|-
└─name|string|名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/save/single.do --data '{
  "menuId": 761,
  "menuName": "julian.ortiz",
  "type": "h9fkh4",
  "typeName": "julian.ortiz",
  "parentName": "julian.ortiz",
  "parentId": 738,
  "priority": 977,
  "path": "uh3h96",
  "component": "ltf0js",
  "query": "2mnb2s",
  "routeName": "julian.ortiz",
  "isFrame": "u0sdx3",
  "isCache": "tb9cc6",
  "menuType": "57l4i4",
  "menuTypeName": "julian.ortiz",
  "visible": "xkbp31",
  "status": "wp6mqi",
  "perms": "ugxzt8",
  "icon": "o5qjuk",
  "imagePath": "0o6a12",
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:46",
  "lastTime": "2026-03-09 00:09:46",
  "children": [
    {
      "$ref": ".."
    }
  ],
  "childNum": 352,
  "description": "won2d9",
  "listJson": "1jkcwj",
  "delFlag": 9,
  "permsList": [
    {
      "permsName": "julian.ortiz",
      "permsStr": "q0l3le"
    }
  ],
  "buttonMenuList": [
    {
      "id": "95",
      "parentId": "95",
      "code": "58719",
      "name": "julian.ortiz"
    }
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "mv00vb",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
menuId|int64|菜单ID|false|-
menuName|string|菜单名称|false|-
type|string|功能类型|false|-
typeName|string|功能类型|false|-
parentName|string|父菜单名称|false|-
parentId|int64|父菜单ID|false|-
priority|int32|显示顺序|false|-
path|string|简短名称ENAME|false|-
component|string|组件路径URL|false|-
query|string|路由参数JS_EVENT|false|-
routeName|string|路由地址|false|-
isFrame|string|是否为外链（0是 1否）|false|-
isCache|string|是否缓存（0缓存 1不缓存）|false|-
menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
visible|string|显示状态（0隐藏 1显示）|false|-
status|string|菜单禁用（0正常 1禁用）|false|-
perms|string|权限字符串|false|-
icon|string|菜单图标|false|-
imagePath|string|菜单图片|false|-
creatorId|string|创建者|false|-
createTime|string|创建时间|false|-
lastTime|string|更新时间|false|-
children|array|子菜单|false|-
childNum|int32|子菜单数量|false|-
description|string|备注|false|-
listJson|string|页面列表JSON|false|-
delFlag|int32|状态0正常1停用2已删除|false|-
permsList|array|权限数组|false|-
└─permsName|string|权限名称|false|-
└─permsStr|string|权限字符串|false|-
buttonMenuList|array|子菜单按钮|false|-
└─id|string|主键|false|-
└─parentId|string|父节点ID|false|-
└─code|string|代码|false|-
└─name|string|名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/update/single.do --data '{
  "menuId": 605,
  "menuName": "julian.ortiz",
  "type": "2efxwu",
  "typeName": "julian.ortiz",
  "parentName": "julian.ortiz",
  "parentId": 950,
  "priority": 183,
  "path": "7wb8cl",
  "component": "orlehh",
  "query": "nkt11i",
  "routeName": "julian.ortiz",
  "isFrame": "p6qdlv",
  "isCache": "j6lhy3",
  "menuType": "eovk1t",
  "menuTypeName": "julian.ortiz",
  "visible": "mxjrm2",
  "status": "rupskl",
  "perms": "c2y0zn",
  "icon": "k16qg4",
  "imagePath": "yqoiz9",
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:46",
  "lastTime": "2026-03-09 00:09:46",
  "children": [
    {
      "$ref": ".."
    }
  ],
  "childNum": 524,
  "description": "unonjw",
  "listJson": "4wf0n1",
  "delFlag": 9,
  "permsList": [
    {
      "permsName": "julian.ortiz",
      "permsStr": "e2u3gs"
    }
  ],
  "buttonMenuList": [
    {
      "id": "95",
      "parentId": "95",
      "code": "58719",
      "name": "julian.ortiz"
    }
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "oe5ubl",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
menuId|int64|菜单ID|false|-
menuName|string|菜单名称|false|-
type|string|功能类型|false|-
typeName|string|功能类型|false|-
parentName|string|父菜单名称|false|-
parentId|int64|父菜单ID|false|-
priority|int32|显示顺序|false|-
path|string|简短名称ENAME|false|-
component|string|组件路径URL|false|-
query|string|路由参数JS_EVENT|false|-
routeName|string|路由地址|false|-
isFrame|string|是否为外链（0是 1否）|false|-
isCache|string|是否缓存（0缓存 1不缓存）|false|-
menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
visible|string|显示状态（0隐藏 1显示）|false|-
status|string|菜单禁用（0正常 1禁用）|false|-
perms|string|权限字符串|false|-
icon|string|菜单图标|false|-
imagePath|string|菜单图片|false|-
creatorId|string|创建者|false|-
createTime|string|创建时间|false|-
lastTime|string|更新时间|false|-
children|array|子菜单|false|-
childNum|int32|子菜单数量|false|-
description|string|备注|false|-
listJson|string|页面列表JSON|false|-
delFlag|int32|状态0正常1停用2已删除|false|-
permsList|array|权限数组|false|-
└─permsName|string|权限名称|false|-
└─permsStr|string|权限字符串|false|-
buttonMenuList|array|子菜单按钮|false|-
└─id|string|主键|false|-
└─parentId|string|父节点ID|false|-
└─code|string|代码|false|-
└─name|string|名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/save.do --data '{
  "menuId": 401,
  "menuName": "julian.ortiz",
  "type": "5t7phg",
  "typeName": "julian.ortiz",
  "parentName": "julian.ortiz",
  "parentId": 433,
  "priority": 136,
  "path": "2b7vmy",
  "component": "pf48wx",
  "query": "m7wemc",
  "routeName": "julian.ortiz",
  "isFrame": "6g6fku",
  "isCache": "gwadu3",
  "menuType": "klj04e",
  "menuTypeName": "julian.ortiz",
  "visible": "xr8um2",
  "status": "9om9j2",
  "perms": "zedscv",
  "icon": "lq4lh0",
  "imagePath": "jjl1qg",
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:46",
  "lastTime": "2026-03-09 00:09:46",
  "children": [
    {
      "$ref": ".."
    }
  ],
  "childNum": 999,
  "description": "xoes31",
  "listJson": "sz8vjb",
  "delFlag": 9,
  "permsList": [
    {
      "permsName": "julian.ortiz",
      "permsStr": "61x2e8"
    }
  ],
  "buttonMenuList": [
    {
      "id": "95",
      "parentId": "95",
      "code": "58719",
      "name": "julian.ortiz"
    }
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "h3yt8j",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
menuId|int64|菜单ID|false|-
menuName|string|菜单名称|false|-
type|string|功能类型|false|-
typeName|string|功能类型|false|-
parentName|string|父菜单名称|false|-
parentId|int64|父菜单ID|false|-
priority|int32|显示顺序|false|-
path|string|简短名称ENAME|false|-
component|string|组件路径URL|false|-
query|string|路由参数JS_EVENT|false|-
routeName|string|路由地址|false|-
isFrame|string|是否为外链（0是 1否）|false|-
isCache|string|是否缓存（0缓存 1不缓存）|false|-
menuType|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
menuTypeName|string|菜单类型URL_TYPE（M目录 C菜单 F按钮）|false|-
visible|string|显示状态（0隐藏 1显示）|false|-
status|string|菜单禁用（0正常 1禁用）|false|-
perms|string|权限字符串|false|-
icon|string|菜单图标|false|-
imagePath|string|菜单图片|false|-
creatorId|string|创建者|false|-
createTime|string|创建时间|false|-
lastTime|string|更新时间|false|-
children|array|子菜单|false|-
childNum|int32|子菜单数量|false|-
description|string|备注|false|-
listJson|string|页面列表JSON|false|-
delFlag|int32|状态0正常1停用2已删除|false|-
permsList|array|权限数组|false|-
└─permsName|string|权限名称|false|-
└─permsStr|string|权限字符串|false|-
buttonMenuList|array|子菜单按钮|false|-
└─id|string|主键|false|-
└─parentId|string|父节点ID|false|-
└─code|string|代码|false|-
└─name|string|名称|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/update.do --data '{
  "menuId": 669,
  "menuName": "julian.ortiz",
  "type": "3aderc",
  "typeName": "julian.ortiz",
  "parentName": "julian.ortiz",
  "parentId": 116,
  "priority": 535,
  "path": "5c25s4",
  "component": "5a4of3",
  "query": "48akg8",
  "routeName": "julian.ortiz",
  "isFrame": "3a38s8",
  "isCache": "jvx166",
  "menuType": "xzvv0k",
  "menuTypeName": "julian.ortiz",
  "visible": "u9go97",
  "status": "gxac9u",
  "perms": "y98sz6",
  "icon": "9oilwb",
  "imagePath": "b1dsqr",
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:46",
  "lastTime": "2026-03-09 00:09:46",
  "children": [
    {
      "$ref": ".."
    }
  ],
  "childNum": 180,
  "description": "y0uduv",
  "listJson": "8b8vac",
  "delFlag": 9,
  "permsList": [
    {
      "permsName": "julian.ortiz",
      "permsStr": "zyhg0f"
    }
  ],
  "buttonMenuList": [
    {
      "id": "95",
      "parentId": "95",
      "code": "58719",
      "name": "julian.ortiz"
    }
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "hgchlk",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "qs4czq",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|功能菜单ID|false|-
parentId|int64|父功能菜单ID|false|-
appId|string|应用ID|false|-
name|string|功能名称|false|-
ename|string|功能名称简称，英文，其他语种名称|false|-
sname|string|简短名称|false|-
isProtect|boolean|是否系统菜单，0否（会员或前端菜单）1是（系统菜单）|false|-
type|string|功能类型,关联BASE_RIGHTTYPE，ADMIN,WORK,APP,SCREEN,MEMBER,AUDIT|false|-
userId|string|系统管理用户ID|false|-
code|string|功能编号|false|-
menuLevel|int32|菜单层次|false|-
subCount|int32|子节点数|false|-
perms|string|功能模型，多个用逗号分隔，如：admin:user:list|false|-
urlType|string|调用入口类型，如CATAGORY,MENU,BUTTON,OUTLINK,CHANNEL,COMPOS,SCENES,RECOMMEND,FOLLOW|false|-
url|string|功能地址，前台URL路由地址|false|-
icon|string|功能图标，样式序号，图标或按钮路径|false|-
popPosition|int32|弹出位置|false|-
imagePath|string|图片路径|false|-
css|string|CSS页面样式|false|-
jsEvent|string|JS事件|false|-
menuSeq|string|菜单序列,菜单关联的外键ID，如栏目ID，组件ID，三方功能ID|false|-
shortCut|string|快捷键|false|-
isLeaf|boolean|是否叶子节点0为非叶子节点，1为叶子节点|false|-
isDisplay|boolean|是否显示0否1是|false|-
isDisabled|boolean|是否禁用0否1是|false|-
isCheck|boolean|是否验证权限0为无需验证，1为需要验证|false|-
priority|int32|重点优先级|false|-
delFlag|int32|是否删除1已删除0正常|false|-
deleteTime|string|删除时间|false|-
description|string|描述|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-
open|boolean|ztree属性|false|-
list|array|No comments found.|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/disable/{id}.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:46",
  "lastTime": "2026-03-09 00:09:46",
  "id": 300,
  "parentId": 273,
  "appId": "95",
  "name": "julian.ortiz",
  "ename": "julian.ortiz",
  "sname": "julian.ortiz",
  "isProtect": true,
  "type": "v9zf0c",
  "userId": "95",
  "code": "58719",
  "menuLevel": 176,
  "subCount": 500,
  "perms": "y02q56",
  "urlType": "bg9j73",
  "url": "www.kandace-stamm.org",
  "icon": "jfoujk",
  "popPosition": 45,
  "imagePath": "awrgfm",
  "css": "er3ztx",
  "jsEvent": "waf7jw",
  "menuSeq": "t5twyr",
  "shortCut": "7vjza1",
  "isLeaf": true,
  "isDisplay": true,
  "isDisabled": true,
  "isCheck": true,
  "priority": 111,
  "delFlag": 9,
  "deleteTime": "2026-03-09 00:09:46",
  "description": "6kblk7",
  "spare1": "24jjwg",
  "spare2": "c4boq6",
  "open": true,
  "list": [
    {
      "object": "any object"
    }
  ]
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "5j6yya",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/list.do?roleKey=bhr3gd&status=703&orderBy=108&roleId=637&startTime=2026-03-09 00:08:33&limit=10&roleName=julian.ortiz&q=b1mch3&endTime=2026-03-09 00:08:33&page=1
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:47",
      "lastTime": "2026-03-09 00:09:47",
      "roleId": 422,
      "roleName": "julian.ortiz",
      "roleKey": "mxcqdh",
      "roleSort": 147,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 545,
      "flag": true,
      "menuIds": [
        165
      ],
      "deptIds": [
        541
      ],
      "permissions": [
        "7n6u09"
      ],
      "remark": "efvkqg",
      "parentName": "julian.ortiz",
      "appName": "julian.ortiz",
      "roletypeId": "95",
      "roletypeName": "julian.ortiz",
      "priority": 448,
      "isSuper": true
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/export.do --data 'orderBy=927&bufferSize=10&writer.autoFlush=true&roleName=julian.ortiz&writer.psOut.closed=true&q=sxbhx7&writer.psOut.trouble=true&writer.psOut.textOut.nChars=598&writer.psOut.autoFlush=true&roleId=823&committed=true&writer.formatter.lastException.detailMessage=success&writer.psOut.closing=true&page=1&characterEncoding=od3d70&writer.psOut.textOut.nextChar=25&status=472&roleKey=l4gqb2&status=775&endTime=2026-03-09 00:08:33&writer.writeBuffer=m&writer.writeBuffer=m&writer.psOut.formatter.zero=i&writer.trouble=true&contentType=rdsfna&startTime=2026-03-09 00:08:33&limit=10&writer.formatter.zero=9'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "dwdl6o",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/936.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:47",
    "lastTime": "2026-03-09 00:09:47",
    "roleId": 471,
    "roleName": "julian.ortiz",
    "roleKey": "63aerz",
    "roleSort": 924,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 718,
    "flag": true,
    "menuIds": [
      196
    ],
    "deptIds": [
      868
    ],
    "permissions": [
      "u3rosz"
    ],
    "remark": "gu7958",
    "parentName": "julian.ortiz",
    "appName": "julian.ortiz",
    "roletypeId": "95",
    "roletypeName": "julian.ortiz",
    "priority": 168,
    "isSuper": true
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
roleId|int64|角色ID|false|-
roleName|string|角色名称|false|-
roleKey|string|角色权限|false|-
roleSort|int32|角色排序|false|-
menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
status|int32|角色状态（0未生效 1正常）|false|-
flag|boolean|用户是否存在此角色标识 默认不存在|false|-
menuIds|array|菜单组|false|-
deptIds|array|部门组（数据权限）|false|-
permissions|array|角色菜单权限|false|-
remark|string|备注|false|-
parentName|string|父角色名字|false|-
appName|string|全局应用信息类|false|-
roletypeId|string|系统角色分类|false|-
roletypeName|string|系统角色分类|false|-
priority|int32|排序码|false|-
isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "roleId": 217,
  "roleName": "julian.ortiz",
  "roleKey": "54jzwi",
  "roleSort": 713,
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": 962,
  "flag": true,
  "menuIds": [
    56
  ],
  "deptIds": [
    861
  ],
  "permissions": [
    "96atlv"
  ],
  "remark": "aqbdqj",
  "parentName": "julian.ortiz",
  "appName": "julian.ortiz",
  "roletypeId": "95",
  "roletypeName": "julian.ortiz",
  "priority": 969,
  "isSuper": true
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "c6c462",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
roleId|int64|角色ID|false|-
roleName|string|角色名称|false|-
roleKey|string|角色权限|false|-
roleSort|int32|角色排序|false|-
menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
status|int32|角色状态（0未生效 1正常）|false|-
flag|boolean|用户是否存在此角色标识 默认不存在|false|-
menuIds|array|菜单组|false|-
deptIds|array|部门组（数据权限）|false|-
permissions|array|角色菜单权限|false|-
remark|string|备注|false|-
parentName|string|父角色名字|false|-
appName|string|全局应用信息类|false|-
roletypeId|string|系统角色分类|false|-
roletypeName|string|系统角色分类|false|-
priority|int32|排序码|false|-
isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "roleId": 758,
  "roleName": "julian.ortiz",
  "roleKey": "6ycwnc",
  "roleSort": 937,
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": 395,
  "flag": true,
  "menuIds": [
    103
  ],
  "deptIds": [
    76
  ],
  "permissions": [
    "3qb1jm"
  ],
  "remark": "6k6hxd",
  "parentName": "julian.ortiz",
  "appName": "julian.ortiz",
  "roletypeId": "95",
  "roletypeName": "julian.ortiz",
  "priority": 717,
  "isSuper": true
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "txtpru",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
roleId|int64|角色ID|false|-
roleName|string|角色名称|false|-
roleKey|string|角色权限|false|-
roleSort|int32|角色排序|false|-
menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
status|int32|角色状态（0未生效 1正常）|false|-
flag|boolean|用户是否存在此角色标识 默认不存在|false|-
menuIds|array|菜单组|false|-
deptIds|array|部门组（数据权限）|false|-
permissions|array|角色菜单权限|false|-
remark|string|备注|false|-
parentName|string|父角色名字|false|-
appName|string|全局应用信息类|false|-
roletypeId|string|系统角色分类|false|-
roletypeName|string|系统角色分类|false|-
priority|int32|排序码|false|-
isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/save/all.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "roleId": 400,
  "roleName": "julian.ortiz",
  "roleKey": "00it5x",
  "roleSort": 519,
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": 330,
  "flag": true,
  "menuIds": [
    38
  ],
  "deptIds": [
    38
  ],
  "permissions": [
    "guoxwn"
  ],
  "remark": "hdp4di",
  "parentName": "julian.ortiz",
  "appName": "julian.ortiz",
  "roletypeId": "95",
  "roletypeName": "julian.ortiz",
  "priority": 303,
  "isSuper": true
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "l1bvww",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
roleId|int64|角色ID|false|-
roleName|string|角色名称|false|-
roleKey|string|角色权限|false|-
roleSort|int32|角色排序|false|-
menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
status|int32|角色状态（0未生效 1正常）|false|-
flag|boolean|用户是否存在此角色标识 默认不存在|false|-
menuIds|array|菜单组|false|-
deptIds|array|部门组（数据权限）|false|-
permissions|array|角色菜单权限|false|-
remark|string|备注|false|-
parentName|string|父角色名字|false|-
appName|string|全局应用信息类|false|-
roletypeId|string|系统角色分类|false|-
roletypeName|string|系统角色分类|false|-
priority|int32|排序码|false|-
isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/update/all.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "roleId": 705,
  "roleName": "julian.ortiz",
  "roleKey": "p4j3e0",
  "roleSort": 850,
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": 732,
  "flag": true,
  "menuIds": [
    811
  ],
  "deptIds": [
    793
  ],
  "permissions": [
    "1d80me"
  ],
  "remark": "gmod91",
  "parentName": "julian.ortiz",
  "appName": "julian.ortiz",
  "roletypeId": "95",
  "roletypeName": "julian.ortiz",
  "priority": 296,
  "isSuper": true
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "9a7u7l",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "cafvsp",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|角色ID|false|-
roletypeId|string|角色分类ID|false|-
appId|string|应用ID|false|-
name|string|角色自定义名称|false|-
code|string|角色自定义代码|false|-
priority|int32|重点优先级|false|-
isRegular|boolean|是否固定权限1表示固定角色0表示自定义角色|false|-
isSuper|boolean|拥有所有权限|false|-
isPublic|boolean|是否公共角色|false|-
status|int32|状态0未生效1正常2受限3锁定4删除|false|-
description|string|角色描述|false|-
areaType|string|地域类型|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/disable/{roleId}.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "id": 444,
  "roletypeId": "95",
  "appId": "95",
  "name": "julian.ortiz",
  "code": "58719",
  "priority": 888,
  "isRegular": true,
  "isSuper": true,
  "isPublic": true,
  "status": 965,
  "description": "otuesy",
  "areaType": "2y25pl"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ak3rhm",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
roleId|int64|角色ID|false|-
roleName|string|角色名称|false|-
roleKey|string|角色权限|false|-
roleSort|int32|角色排序|false|-
menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
status|int32|角色状态（0未生效 1正常）|false|-
flag|boolean|用户是否存在此角色标识 默认不存在|false|-
menuIds|array|菜单组|false|-
deptIds|array|部门组（数据权限）|false|-
permissions|array|角色菜单权限|false|-
remark|string|备注|false|-
parentName|string|父角色名字|false|-
appName|string|全局应用信息类|false|-
roletypeId|string|系统角色分类|false|-
roletypeName|string|系统角色分类|false|-
priority|int32|排序码|false|-
isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/bindMenu/{roleId}.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "roleId": 369,
  "roleName": "julian.ortiz",
  "roleKey": "pzjwof",
  "roleSort": 443,
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": 438,
  "flag": true,
  "menuIds": [
    720
  ],
  "deptIds": [
    31
  ],
  "permissions": [
    "0giolj"
  ],
  "remark": "5npouz",
  "parentName": "julian.ortiz",
  "appName": "julian.ortiz",
  "roletypeId": "95",
  "roletypeName": "julian.ortiz",
  "priority": 922,
  "isSuper": true
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "85sp8e",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
roleId|int64|角色ID|false|-
roleName|string|角色名称|false|-
roleKey|string|角色权限|false|-
roleSort|int32|角色排序|false|-
menuCheckStrictly|boolean|菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）|false|-
deptCheckStrictly|boolean|部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）|false|-
status|int32|角色状态（0未生效 1正常）|false|-
flag|boolean|用户是否存在此角色标识 默认不存在|false|-
menuIds|array|菜单组|false|-
deptIds|array|部门组（数据权限）|false|-
permissions|array|角色菜单权限|false|-
remark|string|备注|false|-
parentName|string|父角色名字|false|-
appName|string|全局应用信息类|false|-
roletypeId|string|系统角色分类|false|-
roletypeName|string|系统角色分类|false|-
priority|int32|排序码|false|-
isSuper|boolean|是否拥有所有权限|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/bindDept/{roleId}.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:47",
  "lastTime": "2026-03-09 00:09:47",
  "roleId": 634,
  "roleName": "julian.ortiz",
  "roleKey": "wv0vrz",
  "roleSort": 396,
  "menuCheckStrictly": true,
  "deptCheckStrictly": true,
  "status": 911,
  "flag": true,
  "menuIds": [
    656
  ],
  "deptIds": [
    966
  ],
  "permissions": [
    "jqzh5j"
  ],
  "remark": "p8ldit",
  "parentName": "julian.ortiz",
  "appName": "julian.ortiz",
  "roletypeId": "95",
  "roletypeName": "julian.ortiz",
  "priority": 540,
  "isSuper": true
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "rbnc3k",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:47",
      "lastTime": "2026-03-09 00:09:47",
      "roleId": 149,
      "roleName": "julian.ortiz",
      "roleKey": "7cvb8r",
      "roleSort": 966,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 55,
      "flag": true,
      "menuIds": [
        162
      ],
      "deptIds": [
        948
      ],
      "permissions": [
        "nuoc79"
      ],
      "remark": "ld70ei",
      "parentName": "julian.ortiz",
      "appName": "julian.ortiz",
      "roletypeId": "95",
      "roletypeName": "julian.ortiz",
      "priority": 256,
      "isSuper": true
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/allocatedList.do?username=julian.ortiz&adminId=532&email=columbus.ankunding@gmail.com&mobile=1-508-337-4557&endTime=2026-03-09 00:08:33&delFlag=9&q=ctl1aw&page=1&deptId=628&userId=95&limit=10&status=08csg0&organId=95&startTime=2026-03-09 00:08:33&nickName=shane.roberts&orderBy=477
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:47",
      "lastTime": "2026-03-09 00:09:47",
      "id": 43,
      "userId": "95",
      "deptId": 731,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "name": "julian.ortiz",
      "username": "julian.ortiz",
      "nickName": "shane.roberts",
      "email": "columbus.ankunding@gmail.com",
      "mobile": "1-508-337-4557",
      "imagePath": "zc8n9s",
      "password": "sdisle",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 211,
      "delFlag": 9,
      "lastLoginIp": "207.227.60.208",
      "lastLoginTime": "2026-03-09 00:09:47",
      "description": "lcxs2o",
      "dept": {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:47",
        "lastTime": "2026-03-09 00:09:47",
        "id": 938,
        "organId": "95",
        "parentId": 691,
        "appId": "95",
        "depttypeId": 519,
        "foreignId": "95",
        "createType": 722,
        "type": "pmur9p",
        "name": "julian.ortiz",
        "sname": "julian.ortiz",
        "areaCode": "58719",
        "organLeader": "2reva6",
        "leaderId": "95",
        "leaderMobile": "1-508-337-4557",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "58719",
        "imagePath": "tz7fn2",
        "priority": 264,
        "status": 464,
        "delFlag": 9,
        "description": "ysoboe",
        "spare1": "gd54if",
        "spare2": "2bst0h",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "95",
          "createTime": "2026-03-09 00:09:47",
          "lastTime": "2026-03-09 00:09:47",
          "id": 262,
          "roletypeId": "95",
          "appId": "95",
          "name": "julian.ortiz",
          "code": "58719",
          "priority": 743,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 523,
          "description": "k9o1wn",
          "areaType": "kx4mjd"
        }
      ],
      "roleIds": [
        95
      ],
      "positionIds": [
        "72fg51"
      ],
      "roleId": 796,
      "userRoleList": [
        {
          "id": 59,
          "deptId": 449,
          "deptName": "julian.ortiz",
          "organId": "95",
          "organName": "julian.ortiz",
          "roleId": 465,
          "roleName": "julian.ortiz",
          "adminId": 387
        }
      ],
      "code": "58719",
      "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/unallocatedList.do?startTime=2026-03-09 00:08:33&limit=10&nickName=shane.roberts&mobile=1-508-337-4557&organId=95&email=columbus.ankunding@gmail.com&adminId=990&q=i89z54&username=julian.ortiz&deptId=513&orderBy=431&userId=95&endTime=2026-03-09 00:08:33&status=vj4h4j&delFlag=9&page=1
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:47",
      "lastTime": "2026-03-09 00:09:47",
      "id": 942,
      "userId": "95",
      "deptId": 998,
      "deptName": "julian.ortiz",
      "organId": "95",
      "organName": "julian.ortiz",
      "name": "julian.ortiz",
      "username": "julian.ortiz",
      "nickName": "shane.roberts",
      "email": "columbus.ankunding@gmail.com",
      "mobile": "1-508-337-4557",
      "imagePath": "brphj4",
      "password": "e7146w",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 212,
      "delFlag": 9,
      "lastLoginIp": "207.227.60.208",
      "lastLoginTime": "2026-03-09 00:09:47",
      "description": "tbrtcm",
      "dept": {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:47",
        "lastTime": "2026-03-09 00:09:47",
        "id": 462,
        "organId": "95",
        "parentId": 41,
        "appId": "95",
        "depttypeId": 149,
        "foreignId": "95",
        "createType": 138,
        "type": "e40edt",
        "name": "julian.ortiz",
        "sname": "julian.ortiz",
        "areaCode": "58719",
        "organLeader": "k63geh",
        "leaderId": "95",
        "leaderMobile": "1-508-337-4557",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "58719",
        "imagePath": "gc74r2",
        "priority": 263,
        "status": 925,
        "delFlag": 9,
        "description": "1xc137",
        "spare1": "x4skro",
        "spare2": "vcwrzx",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "95",
          "createTime": "2026-03-09 00:09:47",
          "lastTime": "2026-03-09 00:09:47",
          "id": 466,
          "roletypeId": "95",
          "appId": "95",
          "name": "julian.ortiz",
          "code": "58719",
          "priority": 86,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 998,
          "description": "rihqxw",
          "areaType": "cu9twq"
        }
      ],
      "roleIds": [
        674
      ],
      "positionIds": [
        "iqyo52"
      ],
      "roleId": 731,
      "userRoleList": [
        {
          "id": 912,
          "deptId": 592,
          "deptName": "julian.ortiz",
          "organId": "95",
          "organName": "julian.ortiz",
          "roleId": 631,
          "roleName": "julian.ortiz",
          "adminId": 839
        }
      ],
      "code": "58719",
      "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
id|int64|用户角色ID|false|-
roleId|int64|角色ID|false|-
adminId|int64|公共管理用户ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/cancel.do --data '{
  "id": 900,
  "roleId": 690,
  "adminId": 877
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ygbch2",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/cancelAll.do --data 'roleId=87&adminIds=0uujxj&adminIds=0uujxj'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "dcgarl",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/selectAll.do --data 'roleId=619&adminIds=bp26f2&adminIds=bp26f2'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "257jjq",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/deptTree/654.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "checkedKeys": [
      638
    ],
    "depts": [
      {
        "id": 669,
        "label": "4teufk",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/list.do?todoAbstract=mdosyn&opOrganName=julian.ortiz&page=1&todoLabels=ir5asb&opUserId=95&endTime=2026-03-09 00:08:33&status=hmq2o9&foreignId=95&todoAccountName=julian.ortiz&todoProcessName=julian.ortiz&spare2=ucc7mu&startTime=2026-03-09 00:08:33&todoUserId=95&appId=95&todoName=julian.ortiz&id=95&todoContent=iwk47m&todoOrganId=95&todoAccountId=95&bizType=wp7xbq&q=qysi3m&todoModuleId=95&todoCurrInfo=v1tu7e&description=l8fe5n&limit=10&todoId=95&todoOrganName=julian.ortiz&todoProcessStatus=fp1bax&todoUserName=julian.ortiz&todoCreateTime=2026-03-09 00:09:49&opTime=2026-03-09 00:09:49&todoModuleName=julian.ortiz&todoType=b6crim&todoNextInfo=nu2ziq&todoUrl=www.kandace-stamm.org&type=u1rp7v&spare1=bf2wjs&creatorId=95&orderBy=6&todoProcessInfo=ua9f0u&opOrganId=95
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:49",
      "lastTime": "2026-03-09 00:09:49",
      "id": "95",
      "appId": "95",
      "foreignId": "95",
      "type": "wwkzo7",
      "bizType": "8sejdd",
      "todoCreateTime": "2026-03-09 00:09:49",
      "todoId": "95",
      "todoType": "q4mm35",
      "todoName": "julian.ortiz",
      "todoAbstract": "ote853",
      "todoAccountId": "95",
      "todoAccountName": "julian.ortiz",
      "todoModuleId": "95",
      "todoModuleName": "julian.ortiz",
      "todoUserId": "95",
      "todoUserName": "julian.ortiz",
      "todoOrganId": "95",
      "todoOrganName": "julian.ortiz",
      "todoProcessName": "julian.ortiz",
      "todoProcessStatus": "jxw4cn",
      "todoProcessInfo": "qxxi48",
      "todoCurrInfo": "rhuzw8",
      "todoNextInfo": "on9i9g",
      "todoUrl": "www.kandace-stamm.org",
      "todoLabels": "0oo2de",
      "todoContent": "p6n853",
      "status": "3xuoys",
      "opUserId": "95",
      "opTime": "2026-03-09 00:09:49",
      "opOrganId": "95",
      "opOrganName": "julian.ortiz",
      "description": "565npg",
      "spare1": "f15nql",
      "spare2": "adahsu"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/export.do --data 'writer.autoFlush=true&endTime=2026-03-09 00:08:33&todoContent=w28gsa&todoCurrInfo=4mmuc3&status=587&writer.psOut.textOut.nextChar=509&opOrganId=95&writer.trouble=true&bizType=46hzt8&todoAbstract=e0ccmz&todoModuleName=julian.ortiz&page=1&todoUserName=julian.ortiz&writer.psOut.formatter.zero=s&todoOrganId=95&id=95&bufferSize=10&todoUrl=www.kandace-stamm.org&todoNextInfo=gooasl&spare1=z2vynm&todoCreateTime=2026-03-09 00:09:49&writer.writeBuffer=c&writer.writeBuffer=c&todoType=tf0158&writer.psOut.textOut.nChars=692&status=lxp6sp&opTime=2026-03-09 00:09:49&todoModuleId=95&writer.formatter.lastException.detailMessage=success&limit=10&opOrganName=julian.ortiz&todoId=95&orderBy=134&appId=95&spare2=sty190&writer.psOut.closing=true&opUserId=95&todoAccountName=julian.ortiz&committed=true&q=gd93vs&writer.psOut.trouble=true&description=74tqce&writer.psOut.closed=true&contentType=x7y9zm&foreignId=95&writer.formatter.zero=h&todoUserId=95&creatorId=95&todoProcessName=julian.ortiz&todoProcessInfo=p8mgyc&todoOrganName=julian.ortiz&type=oro95q&startTime=2026-03-09 00:08:33&todoLabels=7qp5xc&writer.psOut.autoFlush=true&characterEncoding=20ol1d&todoName=julian.ortiz&todoAccountId=95&todoProcessStatus=190lr8'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "i27ex9",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:49",
    "lastTime": "2026-03-09 00:09:49",
    "id": "95",
    "appId": "95",
    "foreignId": "95",
    "type": "2s0635",
    "bizType": "od6156",
    "todoCreateTime": "2026-03-09 00:09:49",
    "todoId": "95",
    "todoType": "xral01",
    "todoName": "julian.ortiz",
    "todoAbstract": "gieodc",
    "todoAccountId": "95",
    "todoAccountName": "julian.ortiz",
    "todoModuleId": "95",
    "todoModuleName": "julian.ortiz",
    "todoUserId": "95",
    "todoUserName": "julian.ortiz",
    "todoOrganId": "95",
    "todoOrganName": "julian.ortiz",
    "todoProcessName": "julian.ortiz",
    "todoProcessStatus": "p4spox",
    "todoProcessInfo": "sq1yxb",
    "todoCurrInfo": "j1bm3c",
    "todoNextInfo": "pfj0ab",
    "todoUrl": "www.kandace-stamm.org",
    "todoLabels": "okcek5",
    "todoContent": "msw40f",
    "status": "801b1n",
    "opUserId": "95",
    "opTime": "2026-03-09 00:09:49",
    "opOrganId": "95",
    "opOrganName": "julian.ortiz",
    "description": "5m80bz",
    "spare1": "ts6efz",
    "spare2": "zrzop5"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:49",
  "lastTime": "2026-03-09 00:09:49",
  "id": "95",
  "appId": "95",
  "foreignId": "95",
  "type": "064udh",
  "bizType": "mi8var",
  "todoCreateTime": "2026-03-09 00:09:49",
  "todoId": "95",
  "todoType": "yhb30y",
  "todoName": "julian.ortiz",
  "todoAbstract": "0j78fh",
  "todoAccountId": "95",
  "todoAccountName": "julian.ortiz",
  "todoModuleId": "95",
  "todoModuleName": "julian.ortiz",
  "todoUserId": "95",
  "todoUserName": "julian.ortiz",
  "todoOrganId": "95",
  "todoOrganName": "julian.ortiz",
  "todoProcessName": "julian.ortiz",
  "todoProcessStatus": "95eatr",
  "todoProcessInfo": "f4lvlh",
  "todoCurrInfo": "9m9h1e",
  "todoNextInfo": "nprgdx",
  "todoUrl": "www.kandace-stamm.org",
  "todoLabels": "zprr4m",
  "todoContent": "xa8ltf",
  "status": "stpneq",
  "opUserId": "95",
  "opTime": "2026-03-09 00:09:49",
  "opOrganId": "95",
  "opOrganName": "julian.ortiz",
  "description": "hwwigd",
  "spare1": "uwhnp0",
  "spare2": "4y3ja5"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "bzme3y",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:49",
  "lastTime": "2026-03-09 00:09:49",
  "id": "95",
  "appId": "95",
  "foreignId": "95",
  "type": "5zuqhs",
  "bizType": "mc09lr",
  "todoCreateTime": "2026-03-09 00:09:49",
  "todoId": "95",
  "todoType": "0647ym",
  "todoName": "julian.ortiz",
  "todoAbstract": "a4i9gt",
  "todoAccountId": "95",
  "todoAccountName": "julian.ortiz",
  "todoModuleId": "95",
  "todoModuleName": "julian.ortiz",
  "todoUserId": "95",
  "todoUserName": "julian.ortiz",
  "todoOrganId": "95",
  "todoOrganName": "julian.ortiz",
  "todoProcessName": "julian.ortiz",
  "todoProcessStatus": "1abxei",
  "todoProcessInfo": "5cik9h",
  "todoCurrInfo": "hwn2ey",
  "todoNextInfo": "ryzopn",
  "todoUrl": "www.kandace-stamm.org",
  "todoLabels": "zlufp5",
  "todoContent": "nwmehh",
  "status": "atclc1",
  "opUserId": "95",
  "opTime": "2026-03-09 00:09:49",
  "opOrganId": "95",
  "opOrganName": "julian.ortiz",
  "description": "4rh2tj",
  "spare1": "3muzfd",
  "spare2": "q3kzpc"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "y6xo0c",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "7iw8kh",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/list.do?deleteTime=2026-03-09 00:08:33&areatypeId=95&startTime=2026-03-09 00:08:33&likeQuery=i87ztl&page=1&searchCode=58719&endTime=2026-03-09 00:08:33&countryId=95&limit=10&rgt=927&nameEn=cty5sv&lft=874&code=58719&parentIds=ma33sr&parentIds=ma33sr&nameTotal=eflrey&sname=julian.ortiz&name=julian.ortiz&orderBy=406&ids=4rzjxh&ids=4rzjxh&parentId=608&isDisplay=true&hasContent=true&description=g19w0c&delFlag=9&areatypeIds=qlh5ju&areatypeIds=qlh5ju&q=bxrpsw
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:53",
      "lastTime": "2026-03-09 00:09:53",
      "id": 139,
      "parentId": 428,
      "countryId": "95",
      "areatypeId": "95",
      "lft": 733,
      "rgt": 601,
      "code": "58719",
      "name": "julian.ortiz",
      "nameTotal": "kv9k6i",
      "sname": "julian.ortiz",
      "nameEn": "z9bix1",
      "searchCode": "58719",
      "isDisplay": true,
      "hasContent": true,
      "priority": 408,
      "delFlag": 9,
      "deleteTime": "2026-03-09 00:09:53",
      "description": "zgz2mi"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/export.do --data 'bufferSize=10&rgt=708&areatypeIds=xvytsr&areatypeIds=xvytsr&writer.autoFlush=true&areatypeId=95&parentIds=scutou&parentIds=scutou&writer.psOut.autoFlush=true&writer.formatter.zero=j&writer.psOut.closed=true&writer.formatter.lastException.detailMessage=success&characterEncoding=1iui8g&writer.psOut.textOut.nChars=748&startTime=2026-03-09 00:08:33&description=tnrp8z&parentId=54&contentType=mnifb2&writer.psOut.closing=true&likeQuery=gzfnjm&committed=true&orderBy=543&status=560&limit=10&isDisplay=true&lft=87&writer.writeBuffer=f&writer.writeBuffer=f&page=1&deleteTime=2026-03-09 00:08:33&ids=n01r5d&ids=n01r5d&writer.trouble=true&writer.psOut.textOut.nextChar=37&writer.psOut.trouble=true&endTime=2026-03-09 00:08:33&countryId=95&nameTotal=gjrxau&q=0qdynj&code=58719&nameEn=wzylsa&delFlag=9&searchCode=58719&hasContent=true&name=julian.ortiz&writer.psOut.formatter.zero=t&sname=julian.ortiz'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "nwl31a",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:53",
    "lastTime": "2026-03-09 00:09:53",
    "id": 991,
    "parentId": 815,
    "countryId": "95",
    "areatypeId": "95",
    "lft": 311,
    "rgt": 26,
    "code": "58719",
    "name": "julian.ortiz",
    "nameTotal": "opmvtp",
    "sname": "julian.ortiz",
    "nameEn": "j3gdsj",
    "searchCode": "58719",
    "isDisplay": true,
    "hasContent": true,
    "priority": 241,
    "delFlag": 9,
    "deleteTime": "2026-03-09 00:09:53",
    "description": "6darv8"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|行政区划编号|false|-
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
priority|int32|排序|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
deleteTime|string|删除时间|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:53",
  "lastTime": "2026-03-09 00:09:53",
  "id": 495,
  "parentId": 825,
  "countryId": "95",
  "areatypeId": "95",
  "lft": 651,
  "rgt": 118,
  "code": "58719",
  "name": "julian.ortiz",
  "nameTotal": "1w9486",
  "sname": "julian.ortiz",
  "nameEn": "4eeddk",
  "searchCode": "58719",
  "isDisplay": true,
  "hasContent": true,
  "priority": 24,
  "delFlag": 9,
  "deleteTime": "2026-03-09 00:09:53",
  "description": "og9j9w"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "5gmi4g",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|行政区划编号|false|-
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
priority|int32|排序|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
deleteTime|string|删除时间|false|-
description|string|描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:53",
  "lastTime": "2026-03-09 00:09:53",
  "id": 664,
  "parentId": 687,
  "countryId": "95",
  "areatypeId": "95",
  "lft": 835,
  "rgt": 487,
  "code": "58719",
  "name": "julian.ortiz",
  "nameTotal": "e12saf",
  "sname": "julian.ortiz",
  "nameEn": "9ltf4m",
  "searchCode": "58719",
  "isDisplay": true,
  "hasContent": true,
  "priority": 345,
  "delFlag": 9,
  "deleteTime": "2026-03-09 00:09:53",
  "description": "j5bxhl"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "a04f96",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "mf7s49",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/list.do?limit=10&description=yj9go7&existKey=7ce8a5&delFlag=9&startTime=2026-03-09 00:08:33&page=1&q=rjig1u&orderBy=965&type=7qwvj4&code=58719&name=julian.ortiz&endTime=2026-03-09 00:08:33
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:55",
      "lastTime": "2026-03-09 00:09:55",
      "id": "95",
      "name": "julian.ortiz",
      "type": "v2vjha",
      "code": "58719",
      "priority": 313,
      "delFlag": 9,
      "description": "yuplf8"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/export.do --data 'writer.psOut.closed=true&writer.psOut.trouble=true&contentType=vyni42&writer.formatter.zero=n&writer.psOut.autoFlush=true&code=58719&characterEncoding=wnb3k3&name=julian.ortiz&writer.autoFlush=true&writer.trouble=true&q=mwofse&committed=true&writer.psOut.closing=true&description=o9upec&limit=10&writer.psOut.textOut.nextChar=294&orderBy=377&writer.psOut.textOut.nChars=559&startTime=2026-03-09 00:08:33&delFlag=9&writer.formatter.lastException.detailMessage=success&status=283&endTime=2026-03-09 00:08:33&page=1&type=o8ki1i&writer.psOut.formatter.zero=l&bufferSize=10&existKey=8q8xh3&writer.writeBuffer=0&writer.writeBuffer=0'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "ak95ul",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:55",
    "lastTime": "2026-03-09 00:09:55",
    "id": "95",
    "name": "julian.ortiz",
    "type": "8j5bp2",
    "code": "58719",
    "priority": 87,
    "delFlag": 9,
    "description": "v9nli7"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|角色分类ID|false|-
name|string|角色名称|false|-
type|string|角色类型0全局角色1系统管理角色2应用会员角色|false|-
code|string|角色编码，角色代码|false|-
priority|int32|重点优先级|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|角色描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:55",
  "lastTime": "2026-03-09 00:09:55",
  "id": "95",
  "name": "julian.ortiz",
  "type": "hsd52b",
  "code": "58719",
  "priority": 898,
  "delFlag": 9,
  "description": "282k70"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "5dvo0f",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|角色分类ID|false|-
name|string|角色名称|false|-
type|string|角色类型0全局角色1系统管理角色2应用会员角色|false|-
code|string|角色编码，角色代码|false|-
priority|int32|重点优先级|false|-
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|角色描述|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:55",
  "lastTime": "2026-03-09 00:09:55",
  "id": "95",
  "name": "julian.ortiz",
  "type": "v1gzv6",
  "code": "58719",
  "priority": 773,
  "delFlag": 9,
  "description": "thssb7"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "yfqnn9",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "4144qr",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/list.do?cfgKey=9ube3q&q=1d67j1&limit=10&startTime=2026-03-09 00:08:33&endTime=2026-03-09 00:08:33&page=1&cfgValue=py16l6&orderBy=987&ids=6wjxml&ids=6wjxml
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "totalCount": 437,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cfgKey": "k3uhlq",
        "cfgValue": "mbzn0m"
      }
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/export.do --data 'writer.psOut.formatter.zero=w&cfgKey=7j1ywe&startTime=2026-03-09 00:08:33&q=7hlh5f&committed=true&writer.writeBuffer=4&writer.writeBuffer=4&orderBy=496&status=378&page=1&writer.formatter.lastException.detailMessage=success&cfgValue=wa0fuv&writer.psOut.textOut.nextChar=252&characterEncoding=ckyd78&contentType=ag55yq&writer.psOut.autoFlush=true&writer.psOut.textOut.nChars=642&writer.psOut.closed=true&writer.psOut.trouble=true&writer.autoFlush=true&bufferSize=10&ids=vt3z8j&ids=vt3z8j&writer.trouble=true&writer.formatter.zero=g&writer.psOut.closing=true&limit=10&endTime=2026-03-09 00:08:33'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "88g5ud",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/yhhacg.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "cfgKey": "czdsfn",
    "cfgValue": "j1crbi"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
cfgKey|string|配置项名称|false|-
cfgValue|string|配置项值|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/save.do --data '{
  "cfgKey": "1lrdr0",
  "cfgValue": "7i69ab"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "9l9504",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
cfgKey|string|配置项名称|false|-
cfgValue|string|配置项值|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/update.do --data '{
  "cfgKey": "8x11nv",
  "cfgValue": "5j6hud"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "s837ml",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "38twua",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "7mgdg6",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "captchaEnabled": true,
    "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba",
    "img": "sij93u",
    "code": "58719"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "captchaEnabled": true,
    "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba",
    "img": "0pibf9",
    "code": "58719"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/list.do?columns[0].isQuery=33jkas&tableComment=fxie7u&pkColumn.isInsert=lgwofy&columns[0].columnName=julian.ortiz&creatorId=95&columns[0].isRequired=wxm1hs&subTable.createTime=2026-03-09 00:09:56&limit=10&subTable.subTable.creatorId=95&columns[0].dictType=ph4qwq&subTable.tableName=julian.ortiz&subTable.pkColumn.isIncrement=1i4vzl&subTable.subTableFkName=julian.ortiz&subTable.pkColumn.javaField=sd99b2&subTable.page=1&subTable.pkColumn.lastTime=2026-03-09 00:09:56&subTable.subTable.subTableName=julian.ortiz&subTable.subTable.createTime=2026-03-09 00:09:56&subTable.subTable.lastTime=2026-03-09 00:09:56&subTable.pkColumn.creatorId=95&subTable.tableComment=or7i18&subTable.functionAuthor=Antonetta Watsica&subTable.subTable.parentMenuName=julian.ortiz&pkColumn.isRequired=jwhc4c&columns[0].columnComment=khb2pm&columns[0].isIncrement=f17f4p&subTable.columns[0].javaType=bq3zv2&lastTime=2026-03-09 00:09:56&subTable.columns[0].dictType=va7bon&subTable.columns[0].isIncrement=fiqw40&pkColumn.isIncrement=5vg06f&subTable.tableId=875&tableId=281&subTable.treeCode=58719&functionAuthor=Antonetta Watsica&pkColumn.columnType=vx5595&columns[0].lastTime=2026-03-09 00:09:56&functionName=julian.ortiz&subTable.className=julian.ortiz&subTable.genPath=46b7j3&subTable.subTable.subTableFkName=julian.ortiz&subTable.subTable.genPath=qq1tcd&columns[0].columnType=219b03&subTable.pkColumn.columnType=yo3l1a&subTable.columns[0].tableId=409&subTable.subTable.tableComment=rbaubx&subTable.subTable.formColNum=302&pkColumn.isQuery=6xlvrs&subTable.lastTime=2026-03-09 00:09:56&subTable.columns[0].isPk=6utlzt&subTable.columns[0].isEdit=9pyiyl&subTable.subTable.treeName=julian.ortiz&columns[0].javaField=1cyxit&subTable.pkColumn.isList=ehueti&moduleName=julian.ortiz&subTable.formColNum=352&subTable.columns[0].isInsert=koc2qe&columns[0].isList=geyd7l&pkColumn.columnName=julian.ortiz&pkColumn.columnComment=hzon6p&columns[0].queryType=9jbymm&columns[0].priority=246&optionLists=csipon&subTable.subTable.functionName=julian.ortiz&subTable.subTable.moduleName=julian.ortiz&subTable.subTable.page=1&treeParentCode=58719&pkColumn.lastTime=2026-03-09 00:09:56&treeName=julian.ortiz&pkColumn.creatorId=95&subTable.subTable.packageName=julian.ortiz&subTable.subTable.tplWebType=hy2iks&subTable.tplCategory=juatch&subTable.genType=5rpva6&subTable.pkColumn.isRequired=vbmvfo&subTable.subTable.businessName=julian.ortiz&subTable.limit=10&subTable.treeName=julian.ortiz&columns[0].isInsert=vs5mmf&pkColumn.tableId=251&subTable.pkColumn.columnId=474&subTable.subTable.functionAuthor=Antonetta Watsica&columns[0].isEdit=ua0okj&subTable.columns[0].isQuery=frqrum&subTableFkName=julian.ortiz&pkColumn.isEdit=qt9ith&pkColumn.createTime=2026-03-09 00:09:56&subTable.moduleName=julian.ortiz&subTable.businessName=julian.ortiz&subTable.pkColumn.isQuery=141rxc&subTable.pkColumn.htmlType=ef3ftu&Description=kni7bw&subTable.pkColumn.isInsert=6ltcpn&subTable.creatorId=95&subTable.subTableName=julian.ortiz&subTable.Description=tb5jkc&subTable.pkColumn.dictType=i7ll35&columns[0].creatorId=95&genType=uvqn52&pkColumn.queryType=mhe2qi&subTable.optionLists=q1i0rr&page=1&subTable.columns[0].columnComment=9zm2x7&subTable.columns[0].isRequired=4b5n4s&subTable.pkColumn.tableId=911&pkColumn.isPk=802zds&pkColumn.priority=228&subTable.subTable.tableId=750&subTable.tplWebType=ije54o&pkColumn.columnId=108&subTable.subTable.optionLists=udo3n4&subTable.pkColumn.columnName=julian.ortiz&formColNum=324&subTable.pkColumn.queryType=vshulj&subTable.subTable.Description=svtsct&businessName=julian.ortiz&subTable.subTable.limit=10&subTable.columns[0].creatorId=95&subTable.columns[0].htmlType=44yjse&columns[0].createTime=2026-03-09 00:09:56&pkColumn.javaField=xu47au&className=julian.ortiz&subTable.subTable.className=julian.ortiz&subTable.subTable.treeParentCode=58719&subTable.columns[0].lastTime=2026-03-09 00:09:56&subTable.columns[0].priority=320&tplCategory=4q2my5&subTable.pkColumn.priority=646&treeCode=58719&subTable.pkColumn.columnComment=5gfnep&subTable.columns[0].javaField=0fku65&createTime=2026-03-09 00:09:56&pkColumn.dictType=x697bg&packageName=julian.ortiz&pkColumn.htmlType=z4qtg2&subTable.pkColumn.javaType=wkh1ua&subTable.subTable.tplCategory=scc3ks&subTable.columns[0].columnName=julian.ortiz&columns[0].columnId=96&pkColumn.javaType=m7k98w&subTable.pkColumn.isEdit=smvvq9&subTable.columns[0].isList=io41b5&subTable.parentMenuId=563&subTable.packageName=julian.ortiz&subTable.parentMenuName=julian.ortiz&parentMenuId=578&parentMenuName=julian.ortiz&genPath=p4jkhn&subTable.subTable.parentMenuId=352&subTable.columns[0].columnId=776&subTable.subTable.genType=lktoxf&subTable.subTable.treeCode=58719&pkColumn.isList=jssngx&subTable.columns[0].createTime=2026-03-09 00:09:56&columns[0].isPk=ht2dc7&subTable.columns[0].queryType=1svfer&subTableName=julian.ortiz&tableName=julian.ortiz&columns[0].javaType=mn88xr&columns[0].tableId=34&subTable.pkColumn.createTime=2026-03-09 00:09:56&subTable.treeParentCode=58719&subTable.subTable.tableName=julian.ortiz&subTable.functionName=julian.ortiz&subTable.columns[0].columnType=caelly&subTable.pkColumn.isPk=rrdn40&tplWebType=dfbna7&columns[0].htmlType=ltf98s
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:56",
      "lastTime": "2026-03-09 00:09:56",
      "tableId": 436,
      "tableName": "julian.ortiz",
      "tableComment": "j2b4yq",
      "subTableName": "julian.ortiz",
      "subTableFkName": "julian.ortiz",
      "className": "julian.ortiz",
      "tplCategory": "iku4p1",
      "tplWebType": "31ns5m",
      "packageName": "julian.ortiz",
      "moduleName": "julian.ortiz",
      "businessName": "julian.ortiz",
      "functionName": "julian.ortiz",
      "functionAuthor": "Antonetta Watsica",
      "formColNum": 989,
      "genType": "w5zkzz",
      "genPath": "emx1vw",
      "pkColumn": {
        "creatorId": "95",
        "createTime": "2026-03-09 00:09:56",
        "lastTime": "2026-03-09 00:09:56",
        "columnId": 253,
        "tableId": 23,
        "columnName": "julian.ortiz",
        "columnComment": "c7jwqt",
        "columnType": "ubpwu9",
        "javaType": "9xfbdw",
        "javaField": "a88yq4",
        "isPk": "j6736v",
        "isIncrement": "cgzbos",
        "isRequired": "tda6y3",
        "isInsert": "vs1asv",
        "isEdit": "j4smlg",
        "isList": "k5ya71",
        "isQuery": "g2m76r",
        "queryType": "9q7pum",
        "htmlType": "1gmvpk",
        "dictType": "3b82bo",
        "priority": 190
      },
      "subTable": {
        "$ref": "..."
      },
      "columns": [
        {
          "creatorId": "95",
          "createTime": "2026-03-09 00:09:56",
          "lastTime": "2026-03-09 00:09:56",
          "columnId": 519,
          "tableId": 14,
          "columnName": "julian.ortiz",
          "columnComment": "uu9wd7",
          "columnType": "5zwtof",
          "javaType": "cczo9u",
          "javaField": "qmsgd1",
          "isPk": "y3uvdg",
          "isIncrement": "kk7k8v",
          "isRequired": "0o09mx",
          "isInsert": "wddb1f",
          "isEdit": "1oi1v0",
          "isList": "v0w48f",
          "isQuery": "9ci38i",
          "queryType": "hgkj2v",
          "htmlType": "ttidvu",
          "dictType": "4rgb70",
          "priority": 3
        }
      ],
      "optionLists": "z26xgx",
      "treeCode": "58719",
      "treeParentCode": "58719",
      "treeName": "julian.ortiz",
      "parentMenuId": 590,
      "parentMenuName": "julian.ortiz",
      "Description": "yyvehs",
      "page": 1,
      "limit": 10,
      "params": {
        "mapKey": {}
      }
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/656.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─any object|object|any object.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "mapKey": {
      "waring": "You may use java.util.Object for Map value; doc-generate can't be handle."
    }
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/db/list.do?page=1&subTable.businessName=julian.ortiz&limit=10&subTable.pkColumn.lastTime=2026-03-09 00:09:56&subTable.creatorId=95&moduleName=julian.ortiz&subTable.subTable.createTime=2026-03-09 00:09:56&subTable.pkColumn.columnType=ingwol&columns[0].javaType=6xs71r&subTable.subTable.parentMenuName=julian.ortiz&subTable.pkColumn.columnComment=dkde3w&functionAuthor=Antonetta Watsica&pkColumn.htmlType=y4sa4k&pkColumn.columnId=853&subTable.functionName=julian.ortiz&pkColumn.queryType=l3abju&subTable.pkColumn.tableId=814&subTable.columns[0].lastTime=2026-03-09 00:09:56&pkColumn.isInsert=tlvoyh&subTable.genPath=mzfxs1&subTable.columns[0].columnType=xgtm1c&subTable.parentMenuName=julian.ortiz&treeCode=58719&subTable.subTableName=julian.ortiz&columns[0].isQuery=figchv&parentMenuId=604&formColNum=984&subTable.subTable.functionName=julian.ortiz&subTable.columns[0].isRequired=euyviw&columns[0].isRequired=zrl73g&pkColumn.createTime=2026-03-09 00:09:56&pkColumn.isRequired=teggry&tableComment=o8nb3s&tplWebType=dx89tk&optionLists=dbsnn4&columns[0].priority=436&subTable.pkColumn.isQuery=dd67gp&subTable.pkColumn.isInsert=z89lhv&columns[0].queryType=x471ab&subTable.subTable.page=1&subTable.subTable.treeParentCode=58719&pkColumn.javaType=nnjmth&genType=yk08ti&subTable.columns[0].isQuery=hffhjf&className=julian.ortiz&pkColumn.isPk=2pgant&subTable.subTable.subTableName=julian.ortiz&pkColumn.isList=kva6tu&columns[0].tableId=576&pkColumn.lastTime=2026-03-09 00:09:56&subTable.pkColumn.javaType=n89vfe&subTable.subTable.genPath=2d6mxf&subTable.optionLists=5991ry&subTable.pkColumn.creatorId=95&pkColumn.javaField=s5wqz7&subTable.subTable.treeName=julian.ortiz&subTable.treeCode=58719&subTable.columns[0].isEdit=7v328j&columns[0].creatorId=95&subTable.columns[0].isInsert=aetlhd&functionName=julian.ortiz&businessName=julian.ortiz&pkColumn.columnType=p6t25x&subTable.moduleName=julian.ortiz&subTable.subTable.lastTime=2026-03-09 00:09:56&subTable.subTable.moduleName=julian.ortiz&subTable.parentMenuId=652&subTable.functionAuthor=Antonetta Watsica&subTable.subTable.tableName=julian.ortiz&subTable.pkColumn.isIncrement=90zesh&subTable.pkColumn.isEdit=eimyuu&subTable.subTable.className=julian.ortiz&subTableName=julian.ortiz&subTable.createTime=2026-03-09 00:09:56&tplCategory=e24qcg&pkColumn.tableId=440&subTable.columns[0].isPk=fe5oo9&subTable.columns[0].htmlType=jefsdy&columns[0].javaField=7e9b4f&subTable.pkColumn.columnId=510&subTable.page=1&columns[0].isList=e2gner&tableName=julian.ortiz&parentMenuName=julian.ortiz&lastTime=2026-03-09 00:09:56&subTable.pkColumn.priority=104&columns[0].columnComment=f3b6jk&subTable.subTable.subTableFkName=julian.ortiz&subTable.columns[0].columnName=julian.ortiz&columns[0].columnName=julian.ortiz&genPath=a9o5er&subTable.pkColumn.isRequired=jxs9vk&subTable.subTable.genType=zkks85&subTable.columns[0].dictType=fnud3q&pkColumn.columnComment=n0wiwh&subTable.treeName=julian.ortiz&columns[0].isInsert=nk7lsi&tableId=760&subTable.subTable.limit=10&columns[0].htmlType=0qijh7&pkColumn.isQuery=3ry5i7&subTable.subTable.businessName=julian.ortiz&subTable.columns[0].queryType=5kx2wz&pkColumn.isEdit=eq6na6&pkColumn.creatorId=95&subTable.columns[0].columnId=43&subTable.subTable.formColNum=312&subTable.packageName=julian.ortiz&subTable.columns[0].priority=128&createTime=2026-03-09 00:09:56&subTable.pkColumn.dictType=n49llo&subTable.subTable.tplWebType=8391w2&subTable.subTable.functionAuthor=Antonetta Watsica&subTable.subTable.tplCategory=kmlnr9&subTable.tplWebType=4pbmz8&subTable.columns[0].tableId=463&subTable.columns[0].isIncrement=2htqvd&subTable.columns[0].javaField=uvnskn&columns[0].columnId=465&treeParentCode=58719&subTable.columns[0].createTime=2026-03-09 00:09:56&subTable.columns[0].creatorId=95&columns[0].createTime=2026-03-09 00:09:56&columns[0].isPk=ogas4b&subTable.Description=55nmoc&pkColumn.dictType=iojxrq&subTable.columns[0].isList=hojeyo&subTable.tableComment=3tnlv1&subTable.formColNum=579&subTable.pkColumn.queryType=iifimi&pkColumn.isIncrement=v04dsl&subTable.pkColumn.htmlType=c13tnr&subTable.pkColumn.isPk=k88irm&subTable.tableId=403&pkColumn.priority=917&subTable.pkColumn.createTime=2026-03-09 00:09:56&subTable.pkColumn.javaField=gqat8k&subTable.subTable.optionLists=iy2nix&columns[0].columnType=yvmiuk&columns[0].isIncrement=9fsqye&subTable.subTableFkName=julian.ortiz&subTable.lastTime=2026-03-09 00:09:56&subTable.subTable.creatorId=95&subTable.subTable.packageName=julian.ortiz&subTable.treeParentCode=58719&subTable.pkColumn.columnName=julian.ortiz&subTable.subTable.treeCode=58719&subTable.genType=zu4i1s&treeName=julian.ortiz&subTable.limit=10&columns[0].isEdit=e8ojrd&subTable.columns[0].javaType=tidati&packageName=julian.ortiz&pkColumn.columnName=julian.ortiz&Description=wsik9h&creatorId=95&subTable.subTable.parentMenuId=896&subTable.subTable.Description=4lciol&subTable.tableName=julian.ortiz&columns[0].lastTime=2026-03-09 00:09:56&subTable.className=julian.ortiz&subTable.subTable.tableComment=djtblt&subTable.subTable.tableId=113&subTable.tplCategory=mwxprh&subTable.columns[0].columnComment=d8eam8&subTable.pkColumn.isList=2xkjnc&columns[0].dictType=l249zc&subTableFkName=julian.ortiz
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─size|int32|No comments found.|-
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
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "size": 10,
    "pageNum": 352,
    "pageSize": 10,
    "startRow": 916,
    "endRow": 782,
    "total": 277,
    "pages": 392,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "1j3idk",
    "orderBy": "j4yvd8",
    "orderByOnly": true,
    "boundSqlInterceptor": {}
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/column/{tableId}.do?tableId=356
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:56",
      "lastTime": "2026-03-09 00:09:56",
      "columnId": 548,
      "tableId": 182,
      "columnName": "julian.ortiz",
      "columnComment": "pmclkp",
      "columnType": "opyjvj",
      "javaType": "7umayh",
      "javaField": "6ha4y7",
      "isPk": "6ep60d",
      "isIncrement": "bjz7mr",
      "isRequired": "xbe4wq",
      "isInsert": "92lc1p",
      "isEdit": "7ikh6r",
      "isList": "b9ok49",
      "isQuery": "m11fci",
      "queryType": "2a22ai",
      "htmlType": "uwn3r4",
      "dictType": "o09oj8",
      "priority": 962
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/importTable.do --data 'tables=17w6uu'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "0a61zk",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/createTable.do --data 'sql=36tarj'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "3h3ibt",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:56",
  "lastTime": "2026-03-09 00:09:56",
  "tableId": 304,
  "tableName": "julian.ortiz",
  "tableComment": "xux138",
  "subTableName": "julian.ortiz",
  "subTableFkName": "julian.ortiz",
  "className": "julian.ortiz",
  "tplCategory": "yr81qh",
  "tplWebType": "ed3glj",
  "packageName": "julian.ortiz",
  "moduleName": "julian.ortiz",
  "businessName": "julian.ortiz",
  "functionName": "julian.ortiz",
  "functionAuthor": "Antonetta Watsica",
  "formColNum": 986,
  "genType": "da0smh",
  "genPath": "t87vtn",
  "pkColumn": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:56",
    "lastTime": "2026-03-09 00:09:56",
    "columnId": 140,
    "tableId": 311,
    "columnName": "julian.ortiz",
    "columnComment": "dok1dj",
    "columnType": "ue0dl7",
    "javaType": "lyudi5",
    "javaField": "x6lzh3",
    "isPk": "quurjp",
    "isIncrement": "z6ghbs",
    "isRequired": "06ficv",
    "isInsert": "97j1gk",
    "isEdit": "af0evb",
    "isList": "le994n",
    "isQuery": "35u5qs",
    "queryType": "u910ic",
    "htmlType": "k1ah9z",
    "dictType": "17whsy",
    "priority": 91
  },
  "subTable": {
    "$ref": "..."
  },
  "columns": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:56",
      "lastTime": "2026-03-09 00:09:56",
      "columnId": 983,
      "tableId": 351,
      "columnName": "julian.ortiz",
      "columnComment": "lsyllg",
      "columnType": "oik9e1",
      "javaType": "ooqrpe",
      "javaField": "6femyp",
      "isPk": "5rwqpq",
      "isIncrement": "7x05h8",
      "isRequired": "fm0odu",
      "isInsert": "fbhqes",
      "isEdit": "cn3m2u",
      "isList": "1hisb6",
      "isQuery": "gsza8g",
      "queryType": "5fppm3",
      "htmlType": "bw6u0p",
      "dictType": "dadufi",
      "priority": 927
    }
  ],
  "optionLists": "x84m3b",
  "treeCode": "58719",
  "treeParentCode": "58719",
  "treeName": "julian.ortiz",
  "parentMenuId": 66,
  "parentMenuName": "julian.ortiz",
  "Description": "nazrv7",
  "page": 1,
  "limit": 10,
  "params": {
    "mapKey": {}
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "1fswbk",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "n6cv82",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/preview/366.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "mapKey1": "hd7in3",
    "mapKey2": "u7deul"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/download/julian.ortiz.do?bufferSize=10&writer.psOut.textOut.nChars=352&committed=true&writer.trouble=true&writer.formatter.zero=2&writer.autoFlush=true&writer.formatter.lastException.detailMessage=success&writer.psOut.closed=true&status=143&writer.writeBuffer=t&writer.writeBuffer=t&writer.psOut.formatter.zero=g&writer.psOut.closing=true&writer.psOut.textOut.nextChar=505&contentType=yk65ta&writer.psOut.trouble=true&writer.psOut.autoFlush=true&characterEncoding=9tibai
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "8h9i77",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/genCode/julian.ortiz.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "mzuzzg",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/synchDb/julian.ortiz.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "hqo0fq",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
tables|string|   表名称前缀|false|-

**Request-example:**
```
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/batchGenCode.do?characterEncoding=njr17t&tables=q9p9jb&writer.trouble=true&writer.formatter.lastException.detailMessage=success&writer.psOut.closed=true&writer.psOut.trouble=true&bufferSize=10&writer.autoFlush=true&writer.formatter.zero=n&status=12&writer.writeBuffer=1&writer.writeBuffer=1&writer.psOut.textOut.nChars=72&writer.psOut.autoFlush=true&committed=true&writer.psOut.textOut.nextChar=677&contentType=ft57x4&writer.psOut.closing=true&writer.psOut.formatter.zero=7
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "b7ycmp",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/token/list.do?expireTime=2026-03-09 00:09:42&updateTime=2026-03-09 00:09:42&foreignId=95&startTime=2026-03-09 00:08:33&loginIp=207.227.60.208&q=ynxr5x&description=7xhq35&page=1&token=s9nsr4&orderBy=501&endTime=2026-03-09 00:08:33&username=julian.ortiz&limit=10&id=349
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:42",
      "lastTime": "2026-03-09 00:09:42",
      "id": 176,
      "userId": "95",
      "token": "uguh72",
      "foreignId": "95",
      "username": "julian.ortiz",
      "loginIp": "207.227.60.208",
      "updateTime": "2026-03-09 00:09:42",
      "expireTime": "2026-03-09 00:09:42",
      "description": "ylftmd"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "evj1m8",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/smssendrecord/list.do?description=8xc6k4&page=1&msgUrl=www.kandace-stamm.org&returnInfo=76svp3&bizSubtype=jh5nas&delFlag=9&limit=10&spare2=651avy&foreignId=95&creatorId=95&q=8sd7g5&providerId=95&status=0c5crf&orderBy=125&providerName=julian.ortiz&sendTime=2026-03-09&startTime=2026-03-09 00:08:33&bizType=fjuu98&returnTime=2026-03-09 00:09:40&sendStatus=z23xyb&spare1=58avz2&appId=95&receiverName=julian.ortiz&content=6hd8lg&endTime=2026-03-09 00:08:33&id=892&receiverMobile=1-508-337-4557
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:41",
      "lastTime": "2026-03-09 00:09:41",
      "id": 924,
      "appId": "95",
      "providerId": "95",
      "providerName": "julian.ortiz",
      "foreignId": "95",
      "receiverMobile": "1-508-337-4557",
      "receiverName": "julian.ortiz",
      "bizType": "ubsbwz",
      "bizSubtype": "ffiw2t",
      "content": "91o8tn",
      "msgUrl": "www.kandace-stamm.org",
      "status": "9vw17h",
      "sendTime": "2026-03-09",
      "sendStatus": "c0xqov",
      "returnTime": "2026-03-09 00:09:41",
      "returnInfo": "5ad02t",
      "delFlag": 9,
      "description": "sehrhg",
      "spare1": "1zm6hn",
      "spare2": "5ug69d"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:41",
    "lastTime": "2026-03-09 00:09:41",
    "id": 659,
    "appId": "95",
    "providerId": "95",
    "providerName": "julian.ortiz",
    "foreignId": "95",
    "receiverMobile": "1-508-337-4557",
    "receiverName": "julian.ortiz",
    "bizType": "2i7k2f",
    "bizSubtype": "n6izhn",
    "content": "vxru4q",
    "msgUrl": "www.kandace-stamm.org",
    "status": "srswvb",
    "sendTime": "2026-03-09",
    "sendStatus": "pvlnfa",
    "returnTime": "2026-03-09 00:09:41",
    "returnInfo": "40fzkk",
    "delFlag": 9,
    "description": "i8mmuf",
    "spare1": "v81n6q",
    "spare2": "9p74oh"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/smssendrecord/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:41",
  "lastTime": "2026-03-09 00:09:41",
  "id": 761,
  "appId": "95",
  "providerId": "95",
  "providerName": "julian.ortiz",
  "foreignId": "95",
  "receiverMobile": "1-508-337-4557",
  "receiverName": "julian.ortiz",
  "bizType": "v9175q",
  "bizSubtype": "4s0t43",
  "content": "uqbqq2",
  "msgUrl": "www.kandace-stamm.org",
  "status": "3ry6y5",
  "sendTime": "2026-03-09",
  "sendStatus": "dzlcz9",
  "returnTime": "2026-03-09 00:09:41",
  "returnInfo": "lzazoj",
  "delFlag": 9,
  "description": "1wmh04",
  "spare1": "ox2g7j",
  "spare2": "35pked"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "wkiizf",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/smssendrecord/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:41",
  "lastTime": "2026-03-09 00:09:41",
  "id": 723,
  "appId": "95",
  "providerId": "95",
  "providerName": "julian.ortiz",
  "foreignId": "95",
  "receiverMobile": "1-508-337-4557",
  "receiverName": "julian.ortiz",
  "bizType": "koxamv",
  "bizSubtype": "q12sog",
  "content": "9errog",
  "msgUrl": "www.kandace-stamm.org",
  "status": "r7z3yr",
  "sendTime": "2026-03-09",
  "sendStatus": "yvv3aj",
  "returnTime": "2026-03-09 00:09:41",
  "returnInfo": "2ill74",
  "delFlag": 9,
  "description": "1sxkgh",
  "spare1": "gx2puv",
  "spare2": "nk85kr"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "kw2oz5",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "5he1j2",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
mobile|string|手机号码|false|-
code|string|验证码|false|-
uuid|string|唯一标识|false|-
appId|string|所在应用ID|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/sms.do --data '{
  "mobile": "1-508-337-4557",
  "code": "58719",
  "uuid": "4ec13ebe-addd-4cd2-92d1-aec9105972ba",
  "appId": "95"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─userId|string|用户ID|-
└─token|string|令牌TOKEN|-
└─updateTime|string|更新时间|-
└─expireTime|string|过期时间|-
└─mobileConfirm|boolean|是否有手机号码|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "userId": "95",
    "token": "n25j4s",
    "updateTime": "2026-03-09 00:09:40",
    "expireTime": "2026-03-09 00:09:40",
    "mobileConfirm": true
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X POST -k -i https://linlan.net/eframe_backend/login/otp/send.do --data 'mobile=1-508-337-4557'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "qojind",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 发送邮件
**URL:** https://linlan.net/eframe_backend/login/mail/send.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 发送邮件

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
id|int64|主键ID|false|-
platform|int32|平台|false|-
mailFormat|string|邮件格式|false|-
mailFrom|string|发件人邮箱|false|-
formAlias|string|发件人昵称|false|-
mailTos|string|接收人邮箱|false|-
receiversName|string|收件人列表|false|-
templateName|string|模板名|false|-
tagName|string|标签名|false|-
subject|string|邮件主题|false|-
content|string|邮件正文|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/mail/send.do --data '{
  "id": 109,
  "platform": 243,
  "mailFormat": "jhyg82",
  "mailFrom": "diraaf",
  "formAlias": "y4guwo",
  "mailTos": "wx6ncf",
  "receiversName": "julian.ortiz",
  "templateName": "julian.ortiz",
  "tagName": "julian.ortiz",
  "subject": "wyyznc",
  "content": "blq0mz"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "wt6zp3",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 邮箱账号注册
**URL:** https://linlan.net/eframe_backend/login/mail/register.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 邮箱账号注册

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
email|string|邮箱|true|-
code|string|验证码|true|-
password|string|密码|true|-
nickname|string|昵称|true|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/mail/register.do --data '{
  "email": "columbus.ankunding@gmail.com",
  "code": "58719",
  "password": "t8zewf",
  "nickname": "shane.roberts"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": true,
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 根据邮箱修改密码
**URL:** https://linlan.net/eframe_backend/login/mail/email/forgot.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 根据邮箱修改密码

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
email|string|邮箱|true|-
code|string|验证码|true|-
password|string|密码|true|-
nickname|string|昵称|true|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/mail/email/forgot.do --data '{
  "email": "columbus.ankunding@gmail.com",
  "code": "58719",
  "password": "uno4ny",
  "nickname": "shane.roberts"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": true,
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/member/list.do?limit=10&serverType=6ioulz&email=columbus.ankunding@gmail.com&foreignId=95&q=6lu5n0&spare1=pyinn1&organId=95&accountId=95&endTime=2026-03-09 00:08:33&delFlag=9&nickName=shane.roberts&mobile=1-508-337-4557&unionId=95&description=mznheh&additionInfo=wwmue2&creatorId=95&startTime=2026-03-09 00:08:33&id=125&openId=95&orderBy=994&areaCode=58719&page=1&spare2=7ok8pb&avatarUrl=www.kandace-stamm.org
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
└─accountType|string|开放平台认证平台类型|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:42",
      "lastTime": "2026-03-09 00:09:42",
      "id": 109,
      "userId": "95",
      "organId": "95",
      "foreignId": "95",
      "accountId": "95",
      "accountType": "sccml6",
      "unionId": "95",
      "openId": "95",
      "email": "columbus.ankunding@gmail.com",
      "areaCode": "58719",
      "mobile": "1-508-337-4557",
      "nickName": "shane.roberts",
      "avatarUrl": "www.kandace-stamm.org",
      "additionInfo": "qmmz6q",
      "delFlag": 9,
      "description": "3gpoyp",
      "spare1": "ohpkxw",
      "spare2": "cb31gv"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
└─accountType|string|开放平台认证平台类型|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:42",
    "lastTime": "2026-03-09 00:09:42",
    "id": 976,
    "userId": "95",
    "organId": "95",
    "foreignId": "95",
    "accountId": "95",
    "accountType": "btsze4",
    "unionId": "95",
    "openId": "95",
    "email": "columbus.ankunding@gmail.com",
    "areaCode": "58719",
    "mobile": "1-508-337-4557",
    "nickName": "shane.roberts",
    "avatarUrl": "www.kandace-stamm.org",
    "additionInfo": "soa3wr",
    "delFlag": 9,
    "description": "bj9ik6",
    "spare1": "m761we",
    "spare2": "xdf7wd"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|主键ID|false|-
userId|string|用户ID|false|-
organId|string|机构ID|false|-
foreignId|string|外键ID，人口库ID|false|-
accountId|string|身份提供商ID|false|-
accountType|string|开放平台认证平台类型|false|-
unionId|string|三方全局D|false|-
openId|string|开放平台ID|false|-
email|string|邮箱|false|-
areaCode|string|手机号对应的国家号|false|-
mobile|string|电话号码|false|-
nickName|string|昵称|false|-
avatarUrl|string|头像|false|-
additionInfo|string|附加信息|false|-
delFlag|int32|删除标记，0未删除1已删除|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/member/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:42",
  "lastTime": "2026-03-09 00:09:42",
  "id": 393,
  "userId": "95",
  "organId": "95",
  "foreignId": "95",
  "accountId": "95",
  "accountType": "t1k56d",
  "unionId": "95",
  "openId": "95",
  "email": "columbus.ankunding@gmail.com",
  "areaCode": "58719",
  "mobile": "1-508-337-4557",
  "nickName": "shane.roberts",
  "avatarUrl": "www.kandace-stamm.org",
  "additionInfo": "fvi4aw",
  "delFlag": 9,
  "description": "390csn",
  "spare1": "j1a7li",
  "spare2": "vccs4a"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "505hlk",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|int64|主键ID|false|-
userId|string|用户ID|false|-
organId|string|机构ID|false|-
foreignId|string|外键ID，人口库ID|false|-
accountId|string|身份提供商ID|false|-
accountType|string|开放平台认证平台类型|false|-
unionId|string|三方全局D|false|-
openId|string|开放平台ID|false|-
email|string|邮箱|false|-
areaCode|string|手机号对应的国家号|false|-
mobile|string|电话号码|false|-
nickName|string|昵称|false|-
avatarUrl|string|头像|false|-
additionInfo|string|附加信息|false|-
delFlag|int32|删除标记，0未删除1已删除|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/member/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:42",
  "lastTime": "2026-03-09 00:09:42",
  "id": 256,
  "userId": "95",
  "organId": "95",
  "foreignId": "95",
  "accountId": "95",
  "accountType": "mmq088",
  "unionId": "95",
  "openId": "95",
  "email": "columbus.ankunding@gmail.com",
  "areaCode": "58719",
  "mobile": "1-508-337-4557",
  "nickName": "shane.roberts",
  "avatarUrl": "www.kandace-stamm.org",
  "additionInfo": "qc85ch",
  "delFlag": 9,
  "description": "1kzcz1",
  "spare1": "dlyykz",
  "spare2": "j99sa1"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "aj15b5",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "kxofg0",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
userId|string|用户ID|false|-
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/list.do?bindTime=2026-03-09 00:09:41&endTime=2026-03-09 00:08:33&accountId=95&delFlag=9&description=tqh9y1&page=1&userId=95&startTime=2026-03-09 00:08:33&limit=10&id=95&accountKey=v2sjvz&creatorId=95&spare1=9dvk9o&orderBy=248&memberId=612&additionInfo=oey1rd&q=vh2818&spare2=yyzbe3&username=julian.ortiz
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
└─openType|string|第三方平台|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:42",
      "lastTime": "2026-03-09 00:09:42",
      "id": "95",
      "memberId": 99,
      "userId": "95",
      "username": "julian.ortiz",
      "accountId": "95",
      "accountKey": "la6rkf",
      "bindTime": "2026-03-09 00:09:42",
      "additionInfo": "tkjq7p",
      "delFlag": 9,
      "description": "jnl38i",
      "spare1": "x2m1gn",
      "spare2": "j5j7lo",
      "openType": "2n1nwz"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:42",
    "lastTime": "2026-03-09 00:09:42",
    "id": "95",
    "memberId": 408,
    "userId": "95",
    "username": "julian.ortiz",
    "accountId": "95",
    "accountKey": "ivjgzi",
    "bindTime": "2026-03-09 00:09:42",
    "additionInfo": "xmjxgw",
    "delFlag": 9,
    "description": "msxln2",
    "spare1": "hhhsur",
    "spare2": "ce8jv4"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|主键ID|false|-
memberId|int64|会员ID|false|-
userId|string|用户ID|false|-
username|string|系统用户名，手机号|false|-
accountId|string|身份提供商ID|false|-
accountKey|string|第三方账号KEY，市民云、微信等的UnionId或OpenId|false|-
bindTime|string|绑定时间|false|-
additionInfo|string|附加信息|false|-
delFlag|int32|删除标记，0未删除1已删除|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:42",
  "lastTime": "2026-03-09 00:09:42",
  "id": "95",
  "memberId": 937,
  "userId": "95",
  "username": "julian.ortiz",
  "accountId": "95",
  "accountKey": "1tke8p",
  "bindTime": "2026-03-09 00:09:42",
  "additionInfo": "wtifae",
  "delFlag": 9,
  "description": "26xd20",
  "spare1": "zo5dfi",
  "spare2": "hgbesx"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "tobmel",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
id|string|主键ID|false|-
memberId|int64|会员ID|false|-
userId|string|用户ID|false|-
username|string|系统用户名，手机号|false|-
accountId|string|身份提供商ID|false|-
accountKey|string|第三方账号KEY，市民云、微信等的UnionId或OpenId|false|-
bindTime|string|绑定时间|false|-
additionInfo|string|附加信息|false|-
delFlag|int32|删除标记，0未删除1已删除|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:42",
  "lastTime": "2026-03-09 00:09:42",
  "id": "95",
  "memberId": 111,
  "userId": "95",
  "username": "julian.ortiz",
  "accountId": "95",
  "accountKey": "6th7iy",
  "bindTime": "2026-03-09 00:09:42",
  "additionInfo": "5cgvgf",
  "delFlag": 9,
  "description": "da4ca4",
  "spare1": "ve5u63",
  "spare2": "ze3n5o"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "v4z32s",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "m5z5oe",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 获取我的绑定列表或分页, 返回ThirdMemberBind对象.
**URL:** https://linlan.net/eframe_backend/api/third/memberbind/mylist.do

**Type:** GET

**Author:** Linlan
CreateTime 2025-10-13 16:58:20

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取我的绑定列表或分页, 返回ThirdMemberBind对象.

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
userId|string|用户ID|false|-
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/mylist.do?spare1=iu3kh6&page=1&username=julian.ortiz&accountKey=298yv6&userId=95&delFlag=9&orderBy=332&q=ajb1kf&bindTime=2026-03-09 00:09:42&endTime=2026-03-09 00:08:33&memberId=776&accountId=95&id=95&additionInfo=ug4y6l&description=gs50yi&creatorId=95&startTime=2026-03-09 00:08:33&spare2=gv69tt&limit=10
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
└─openType|string|第三方平台|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:42",
      "lastTime": "2026-03-09 00:09:42",
      "id": "95",
      "memberId": 680,
      "userId": "95",
      "username": "julian.ortiz",
      "accountId": "95",
      "accountKey": "mf9jcg",
      "bindTime": "2026-03-09 00:09:42",
      "additionInfo": "k1a1rg",
      "delFlag": 9,
      "description": "1o0co9",
      "spare1": "6mcfo1",
      "spare2": "p0qneb",
      "openType": "dr2o1d"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

## 第三方社交平台登录验证管理体系管理用户登录，覆盖系统管理员、各个角色岗位管理人员，执行第一步、第二步、第三步，无需进行人员信息添加，只需验证人员信息（暂时不考虑）会员体系管理用户登录，覆盖服务商工作人员、各类分组WEB端人员，执行第一步、第二步、第三步，无需进行人员信息添加，只需验证人员信息会员体系门户用户，覆盖网站一般用户、大屏一般用户、移动端一般用户，执行第一步、第二步、第四步、第三步，需要提前执行第四步，完成人员绑定
### 根据类型，获取授权请求，第一步
**URL:** https://linlan.net/eframe_backend/login/social/render/{source}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据类型，获取授权请求，第一步

**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
source|string|来源类型，dingtalk|true|-

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/render/其他.do?writer.writeBuffer=x&writer.writeBuffer=x&writer.formatter.lastException.detailMessage=success&contentType=mvf974&writer.psOut.autoFlush=true&characterEncoding=nbt4k1&committed=true&bufferSize=10&writer.formatter.zero=n&writer.autoFlush=true&writer.psOut.closing=true&writer.psOut.formatter.zero=e&writer.psOut.closed=true&writer.psOut.trouble=true&writer.trouble=true&writer.psOut.textOut.nextChar=51&status=70&writer.psOut.textOut.nChars=250
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "zmconl",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 根据类型，获取授权请求，第二步
**URL:** https://linlan.net/eframe_backend/login/social/callback/{source}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据类型，获取授权请求，第二步

**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
source|string|来源类型，dingtalk|true|-

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
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/callback/其他.do?state=x249v0&authorization_code=58719&oauth_token=kawd80&oauth_verifier=lfj2qn&auth_code=58719&code=58719
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─view|object|No comments found.|-
└─model|object|No comments found.|-
└─status|object|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─error|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─1xxInformational|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─3xxRedirection|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─5xxServerError|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─4xxClientError|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─2xxSuccessful|boolean|No comments found.|-
└─cleared|boolean|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{"success":true,"code":0,"msg":"正常","data":Forward or redirect to a page view.,"requestId":"95","timestamp":"2026-03-09 00:08:33"}
```

### 社交平台登录方法，第三步
**URL:** https://linlan.net/eframe_backend/login/social.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 社交平台登录方法，第三步

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
platformType|string|开放平台类型|false|-
code|string|开放平台Code|false|-
state|string|state|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/social.do --data '{
  "platformType": "kfduif",
  "code": "58719",
  "state": "6xrik3"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─userId|string|用户ID|-
└─token|string|令牌TOKEN|-
└─updateTime|string|更新时间|-
└─expireTime|string|过期时间|-
└─mobileConfirm|boolean|是否有手机号码|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "userId": "95",
    "token": "3sd3in",
    "updateTime": "2026-03-09 00:09:41",
    "expireTime": "2026-03-09 00:09:41",
    "mobileConfirm": true
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 第三方社交平台账号绑定，第四步
**URL:** https://linlan.net/eframe_backend/login/social/bind.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 第三方社交平台账号绑定，第四步

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
platformType|string|开放平台类型|false|-
code|string|开放平台Code|false|-
state|string|状态信息|false|-
bindFrom|string|绑定来自，关联BindFromEnum, admin_work:管理WEB端;web:门户前台;h5:移动端前台;web_work:门户工作;h5_work:移动端工作;other:其他|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/social/bind.do --data '{
  "platformType": "wtd4hg",
  "code": "58719",
  "state": "kt8i9j",
  "bindFrom": "o240lf"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "7g2n8o",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 第三方社交平台账号解绑
**URL:** https://linlan.net/eframe_backend/login/social/unBind.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 第三方社交平台账号解绑

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
platformType|string|开放平台类型|false|-
code|string|开放平台Code|false|-
state|string|状态信息|false|-
bindFrom|string|绑定来自，关联BindFromEnum, admin_work:管理WEB端;web:门户前台;h5:移动端前台;web_work:门户工作;h5_work:移动端工作;other:其他|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/social/unBind.do --data '{
  "platformType": "io8522",
  "code": "58719",
  "state": "1qgxff",
  "bindFrom": "rzj74d"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "jxhlm2",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 根据来源类型，回收授权信息
**URL:** https://linlan.net/eframe_backend/login/social/revoke/{source}/{uuid}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据来源类型，回收授权信息

**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
source|string|来源类型，dingtalk|true|-
uuid|string|第三方用户ID|true|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/revoke/其他/4ec13ebe-addd-4cd2-92d1-aec9105972ba.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "waring": "You may have used non-display generics."
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 根据来源类型，刷新access_token信息
**URL:** https://linlan.net/eframe_backend/login/social/refresh/{source}/{uuid}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 根据来源类型，刷新access_token信息

**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
source|string|来源类型，dingtalk|true|-
uuid|string|第三方用户ID|true|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/refresh/其他/4ec13ebe-addd-4cd2-92d1-aec9105972ba.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─any object|object|any object.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {},
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 查看当前第三方授权用户列表
**URL:** https://linlan.net/eframe_backend/login/social/getAuthUsers.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 查看当前第三方授权用户列表

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/getAuthUsers.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─view|object|No comments found.|-
└─model|object|No comments found.|-
└─status|object|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─error|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─1xxInformational|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─3xxRedirection|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─5xxServerError|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─4xxClientError|boolean|No comments found.|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─2xxSuccessful|boolean|No comments found.|-
└─cleared|boolean|No comments found.|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{"success":true,"code":0,"msg":"正常","data":Forward or redirect to a page view.,"requestId":"95","timestamp":"2026-03-09 00:08:33"}
```

### 获取通用用户信息
**URL:** https://linlan.net/eframe_backend/login/social/userInfo.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取通用用户信息

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
source|string|   用户来源|true|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/userInfo.do?source=un8c55
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─user|object|当前用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userId|string|用户UUID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─xzqhId|int64|行政区划编号，用户来源地|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─source|string|创建来源类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户名，城市APP市民云的用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mobile|string|手机号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─email|string|电子邮箱|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─password|string|密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外键ID，人口库ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─accountId|string|身份提供商ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─accountType|string|开放平台认证平台类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unionId|string|三方全局D|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─openId|string|开放平台ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nickName|string|昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─avatarUrl|string|头像|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─registerTime|string|注册时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastLoginTime|string|最后登录时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastLoginIp|string|最后登录IP|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginCount|int32|登录次数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lockTime|string|锁定时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─activation|boolean|是否激活0否1是，是否需要更改密码0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─activationCode|string|激活代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1，第三方的平台的用户名，如随申办统一身份体系的用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2，第三方用户ID，OpenId|-
└─roles|array|角色集合|-
└─permissions|array|权限集合|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "user": {
      "id": 117,
      "userId": "95",
      "xzqhId": 170,
      "source": "u6vifd",
      "username": "julian.ortiz",
      "mobile": "1-508-337-4557",
      "email": "columbus.ankunding@gmail.com",
      "password": "fy5my0",
      "organId": "95",
      "foreignId": "95",
      "accountId": "95",
      "accountType": "6fxbhw",
      "unionId": "95",
      "openId": "95",
      "nickName": "shane.roberts",
      "avatarUrl": "www.kandace-stamm.org",
      "registerTime": "2026-03-09 00:09:41",
      "lastLoginTime": "2026-03-09 00:09:41",
      "lastLoginIp": "207.227.60.208",
      "loginCount": 505,
      "lockTime": "2026-03-09 00:09:41",
      "activation": true,
      "activationCode": "58719",
      "priority": 863,
      "createTime": "2026-03-09 00:09:41",
      "delFlag": 9,
      "description": "q3gld5",
      "spare1": "ucvlrw",
      "spare2": "v8ngnt"
    },
    "roles": [
      893
    ],
    "permissions": [
      "ky7snm"
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

### 获取工作用户信息，包含用户权限菜单和角色
**URL:** https://linlan.net/eframe_backend/login/social/workUserInfo.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取工作用户信息，包含用户权限菜单和角色

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
source|string|   用户来源|true|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/workUserInfo.do?source=mnnfk0
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─user|object|当前用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─id|int64|用户ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─userId|string|用户UUID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─xzqhId|int64|行政区划编号，用户来源地|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─source|string|创建来源类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户名，城市APP市民云的用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─mobile|string|手机号码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─email|string|电子邮箱|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─password|string|密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─organId|string|机构ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─foreignId|string|外键ID，人口库ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─accountId|string|身份提供商ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─accountType|string|开放平台认证平台类型|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─unionId|string|三方全局D|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─openId|string|开放平台ID|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nickName|string|昵称|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─avatarUrl|string|头像|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─registerTime|string|注册时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastLoginTime|string|最后登录时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastLoginIp|string|最后登录IP|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─loginCount|int32|登录次数|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lockTime|string|锁定时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─activation|boolean|是否激活0否1是，是否需要更改密码0否1是|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─activationCode|string|激活代码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─priority|int32|排序|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─createTime|string|创建时间|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─description|string|描述|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare1|string|备用1，第三方的平台的用户名，如随申办统一身份体系的用户名|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─spare2|string|备用2，第三方用户ID，OpenId|-
└─roles|array|角色集合|-
└─permissions|array|权限集合|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": {
    "user": {
      "id": 928,
      "userId": "95",
      "xzqhId": 358,
      "source": "jd6j5j",
      "username": "julian.ortiz",
      "mobile": "1-508-337-4557",
      "email": "columbus.ankunding@gmail.com",
      "password": "30z1cb",
      "organId": "95",
      "foreignId": "95",
      "accountId": "95",
      "accountType": "t67t9n",
      "unionId": "95",
      "openId": "95",
      "nickName": "shane.roberts",
      "avatarUrl": "www.kandace-stamm.org",
      "registerTime": "2026-03-09 00:09:41",
      "lastLoginTime": "2026-03-09 00:09:41",
      "lastLoginIp": "207.227.60.208",
      "loginCount": 330,
      "lockTime": "2026-03-09 00:09:41",
      "activation": true,
      "activationCode": "58719",
      "priority": 429,
      "createTime": "2026-03-09 00:09:41",
      "delFlag": 9,
      "description": "k42ix0",
      "spare1": "yzt1j6",
      "spare2": "zgzlkh"
    },
    "roles": [
      259
    ],
    "permissions": [
      "37g8af"
    ]
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/list.do?status=992&invokeTarget=vm69v2&jobGroup=egj9x5&cronExpression=5xkeb6&misfirePolicy=69erpa&concurrent=lmi1mt&jobName=julian.ortiz&remark=v3x1yh&jobId=15
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "jobId": "95",
      "jobName": "julian.ortiz",
      "jobGroup": "nxvi39",
      "invokeTarget": "7g4xqh",
      "cronExpression": "w5ijxn",
      "misfirePolicy": "ss2gzv",
      "concurrent": "qx7pso",
      "status": 246,
      "remark": "f367iy"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/export.do --data 'status=487&misfirePolicy=97j611&concurrent=gyfyos&writer.psOut.closing=true&jobName=julian.ortiz&characterEncoding=oppwrd&writer.psOut.textOut.nChars=537&invokeTarget=dz6m82&committed=true&writer.formatter.lastException.detailMessage=success&writer.autoFlush=true&jobId=648&writer.psOut.autoFlush=true&writer.psOut.trouble=true&bufferSize=10&writer.trouble=true&jobGroup=noyxao&status=457&writer.writeBuffer=9&writer.writeBuffer=9&writer.formatter.zero=i&contentType=82ndy5&writer.psOut.closed=true&cronExpression=u6tw28&remark=5rwc8i&writer.psOut.textOut.nextChar=181&writer.psOut.formatter.zero=m'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "zlw6sl",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/95.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "jobId": "95",
    "jobName": "julian.ortiz",
    "jobGroup": "gdaqic",
    "invokeTarget": "4s0jbf",
    "cronExpression": "wt54ql",
    "misfirePolicy": "b0jtey",
    "concurrent": "hpfdka",
    "status": 263,
    "remark": "dxw8c8"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
jobId|string|任务ID|false|-
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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/save.do --data '{
  "jobId": "95",
  "jobName": "julian.ortiz",
  "jobGroup": "wa1vga",
  "invokeTarget": "aad46d",
  "cronExpression": "zhkgal",
  "misfirePolicy": "qgb9ng",
  "concurrent": "vqsuab",
  "status": 824,
  "remark": "569nde"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "2jdof5",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
jobId|string|任务ID|false|-
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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/update.do --data '{
  "jobId": "95",
  "jobName": "julian.ortiz",
  "jobGroup": "6408xs",
  "invokeTarget": "befo8j",
  "cronExpression": "bq41mp",
  "misfirePolicy": "6mbdlk",
  "concurrent": "38ite7",
  "status": 72,
  "remark": "0odklr"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "vfbvjl",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
jobId|string|任务ID|false|-
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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/changeStatus.do --data '{
  "jobId": "95",
  "jobName": "julian.ortiz",
  "jobGroup": "jj81dx",
  "invokeTarget": "qqo6wm",
  "cronExpression": "pxlz3e",
  "misfirePolicy": "rv32ac",
  "concurrent": "rwfrel",
  "status": 425,
  "remark": "552x68"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "3urft2",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
jobId|string|任务ID|false|-
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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/run.do --data '{
  "jobId": "95",
  "jobName": "julian.ortiz",
  "jobGroup": "923fck",
  "invokeTarget": "7odzos",
  "cronExpression": "3p41c8",
  "misfirePolicy": "zn0ebz",
  "concurrent": "jejfsh",
  "status": 46,
  "remark": "cfzzt6"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "afgxql",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "xyqgur",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/list.do?status=274&exceptionInfo=ec1mql&startTime=2026-03-09 00:09:42&jobLogId=833&remark=dep3bt&jobGroup=gqtrqu&jobId=95&jobMessage=success&creatorId=95&lastTime=2026-03-09 00:09:42&createTime=2026-03-09 00:09:42&jobName=julian.ortiz&stopTime=2026-03-09 00:09:42&invokeTarget=wii42e
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:42",
      "lastTime": "2026-03-09 00:09:42",
      "jobLogId": "95",
      "jobId": "95",
      "jobMessage": "success",
      "status": 721,
      "exceptionInfo": "fp88rt",
      "startTime": "2026-03-09 00:09:42",
      "stopTime": "2026-03-09 00:09:42",
      "remark": "gmczne"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
status|int32|No comments found.|false|-
headerNames|array|No comments found.|false|-
trailerFields|object|No comments found.|false|-
locale|object|No comments found.|false|-
contentType|string|No comments found.|false|-
outputStream|object|No comments found.|false|-
writer|object|No comments found.|false|-
└─writeBuffer|array|No comments found.|false|-
└─lock|object|No comments found.|false|-
└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
└─autoFlush|boolean|No comments found.|false|-
└─trouble|boolean|No comments found.|false|-
└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─detailMessage|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cause|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─stackTrace|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─suppressedExceptions|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
└─psOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closed|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closeLock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─autoFlush|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─trouble|boolean|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─formatter|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─a|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─l|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lastException|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─zero|string|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─textOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─out|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─cb|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nChars|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─nextChar|int32|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─charOut|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─writeBuffer|array|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─lock|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─se|object|No comments found.|false|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─closing|boolean|No comments found.|false|-
characterEncoding|string|No comments found.|false|-
committed|boolean|No comments found.|false|-
bufferSize|int32|No comments found.|false|-
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/export.do --data 'writer.writeBuffer=6&writer.writeBuffer=6&jobId=95&writer.psOut.trouble=true&characterEncoding=is8gdz&jobGroup=modc8g&startTime=2026-03-09 00:09:42&invokeTarget=njpxuy&status=728&contentType=94xqmg&writer.psOut.formatter.zero=5&lastTime=2026-03-09 00:09:42&writer.autoFlush=true&committed=true&writer.psOut.textOut.nChars=539&writer.psOut.textOut.nextChar=187&writer.formatter.zero=w&writer.formatter.lastException.detailMessage=success&exceptionInfo=8fpmns&stopTime=2026-03-09 00:09:42&writer.psOut.closing=true&jobName=julian.ortiz&status=399&creatorId=95&writer.trouble=true&writer.psOut.closed=true&jobLogId=902&remark=4grvbc&bufferSize=10&jobMessage=success&createTime=2026-03-09 00:09:42&writer.psOut.autoFlush=true'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "fv544b",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/95.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:42",
    "lastTime": "2026-03-09 00:09:42",
    "jobLogId": "95",
    "jobId": "95",
    "jobMessage": "success",
    "status": 875,
    "exceptionInfo": "53nu76",
    "startTime": "2026-03-09 00:09:42",
    "stopTime": "2026-03-09 00:09:42",
    "remark": "j66x7i"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "mqloi2",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/mailsendrecord/list.do?receiverEmail=columbus.ankunding@gmail.com&creatorId=95&delFlag=9&content=o97ddm&status=kbezf5&id=89&bizType=t7an2x&sendTime=2026-03-09&spare1=y5rpc6&foreignId=95&readTime=2026-03-09 00:09:40&providerId=95&providerName=julian.ortiz&title=z96oy3&endTime=2026-03-09 00:08:33&senderName=julian.ortiz&description=iwug0y&page=1&msgUrl=www.kandace-stamm.org&spare2=wela11&sendStatus=pkk15p&limit=10&orderBy=825&readStatus=jj479c&appId=95&startTime=2026-03-09 00:08:33&receiverName=julian.ortiz&q=sm83ub
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": [
    {
      "creatorId": "95",
      "createTime": "2026-03-09 00:09:40",
      "lastTime": "2026-03-09 00:09:40",
      "id": 703,
      "appId": "95",
      "providerId": "95",
      "providerName": "julian.ortiz",
      "foreignId": "95",
      "senderName": "julian.ortiz",
      "receiverEmail": "columbus.ankunding@gmail.com",
      "receiverName": "julian.ortiz",
      "bizType": "exvom0",
      "title": "4ex7nn",
      "content": "lolhzn",
      "msgUrl": "www.kandace-stamm.org",
      "status": "82210n",
      "sendTime": "2026-03-09",
      "sendStatus": "aoofkv",
      "readTime": "2026-03-09 00:09:40",
      "readStatus": "iihq6w",
      "delFlag": 9,
      "description": "9chapp",
      "spare1": "fa03yc",
      "spare2": "jo6yk9"
    }
  ],
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
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
  "code": 0,
  "msg": "正常",
  "data": {
    "creatorId": "95",
    "createTime": "2026-03-09 00:09:40",
    "lastTime": "2026-03-09 00:09:40",
    "id": 465,
    "appId": "95",
    "providerId": "95",
    "providerName": "julian.ortiz",
    "foreignId": "95",
    "senderName": "julian.ortiz",
    "receiverEmail": "columbus.ankunding@gmail.com",
    "receiverName": "julian.ortiz",
    "bizType": "1gw97z",
    "title": "qii2l3",
    "content": "821qci",
    "msgUrl": "www.kandace-stamm.org",
    "status": "n0ttmr",
    "sendTime": "2026-03-09",
    "sendStatus": "bc9ldx",
    "readTime": "2026-03-09 00:09:40",
    "readStatus": "s9ssj5",
    "delFlag": 9,
    "description": "b6dmkx",
    "spare1": "j1ntf6",
    "spare2": "vt4b95"
  },
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/mailsendrecord/save.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:40",
  "lastTime": "2026-03-09 00:09:40",
  "id": 900,
  "appId": "95",
  "providerId": "95",
  "providerName": "julian.ortiz",
  "foreignId": "95",
  "senderName": "julian.ortiz",
  "receiverEmail": "columbus.ankunding@gmail.com",
  "receiverName": "julian.ortiz",
  "bizType": "qgytzw",
  "title": "39m0yr",
  "content": "nobi8z",
  "msgUrl": "www.kandace-stamm.org",
  "status": "qx6sfl",
  "sendTime": "2026-03-09",
  "sendStatus": "2xh9id",
  "readTime": "2026-03-09 00:09:40",
  "readStatus": "f2br3q",
  "delFlag": 9,
  "description": "69b5sn",
  "spare1": "w2h0d0",
  "spare2": "xg1oa4"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "azzv25",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
creatorId|string|创建人id|false|-
createTime|string|创建时间|false|-
lastTime|string|最后修改时间|false|-
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
delFlag|int32|删除标记0正常1已删除2应用内受限3回收站|false|-
description|string|备注|false|-
spare1|string|备用1|false|-
spare2|string|备用2|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/mailsendrecord/update.do --data '{
  "creatorId": "95",
  "createTime": "2026-03-09 00:09:40",
  "lastTime": "2026-03-09 00:09:40",
  "id": 256,
  "appId": "95",
  "providerId": "95",
  "providerName": "julian.ortiz",
  "foreignId": "95",
  "senderName": "julian.ortiz",
  "receiverEmail": "columbus.ankunding@gmail.com",
  "receiverName": "julian.ortiz",
  "bizType": "gt5aao",
  "title": "n8fom8",
  "content": "zic8n3",
  "msgUrl": "www.kandace-stamm.org",
  "status": "3mb7ax",
  "sendTime": "2026-03-09",
  "sendStatus": "5rq264",
  "readTime": "2026-03-09 00:09:40",
  "readStatus": "natizh",
  "delFlag": 9,
  "description": "8x5640",
  "spare1": "g6lkn3",
  "spare2": "arl6be"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "fcdvm1",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
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
code|int32|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": 0,
  "msg": "正常",
  "data": "s51noo",
  "requestId": "95",
  "timestamp": "2026-03-09 00:08:33"
}
```

## 错误码列表
Error code |Description
---|---
3100700|Token Error[TOKEN信息错误]
3100701|Input Error Code[信息传入有误(code)]
3100702|Input Error Source[信息传入有误(source)]
3100703|Account Not Exist[对接平台账户不存在]
3100704|Channel Not Exist[该栏目版面不存在]
3100705|Parameter Error[传递参数信息错误]
3100706|Network Error[网络异常，请联系系统管理员]
3100721|Third Info Error[第三方数据信息验证失败]
3100731|IP Whitelist Error[白名单校验失败]
3100741|Info Send Fail[消息推送失败]
3101001|Error User Info[用户数据信息验证失败]
3101002|Error User SSO[SSO用户数据信息验证失败]
3101003|Error User APP[APP用户数据信息验证失败]
3101004|Error User APP Step1[APP用户在调取第三方接口时失败]
3101005|Error User APP Step2[APP用户数据调取第三方接口成功但是返回的数据不正确]
3101006|Error User Out[外部用户数据信息验证失败]
3101011|Error User Key[用户关键信息错误]
3101012|Error User Password[用户密码信息错误]
3101013|Error User Real Name[需要实名认证绑定]
3101014|Error User Need Login[请用户重新登录]
3101015|Error User Need Face[需要人脸识别二次认证]
3101016|Error User Identity[认证失败，请重新认证]
3101017|Error User Face[人脸识别信息与系统不一致]
3101018|Error User Need Reg[用户信息未注册，请注册]
3101019|Error Params Mate[传参不匹配]
3101020|Error Return Many[查询出多条数据]
3101021|Error Number Format[数字格式转换异常]
3101022|Error Data Duplicate[数据重复]
3101023|Error Data Format[数据格式错误]
3101024|Error Data[数据错误]
3101101|Error Address Invalid[无效访问地址]
3101102|Error With Upload[上传出现错误，请联系管理员]
3101103|Error With Input填写信息错误，请检查]
3101104|Error With Password[密码必须为大小写字母,数字,特殊字符中的至少3种且8位-20位之内]
3101201|Error With Enterprise Info[企业关键信息错误]
3101202|Error With Not Initial[关键信息未初始化]
3101301|Error Template Info[模板信息错误]

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
