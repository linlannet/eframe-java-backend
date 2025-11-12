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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/list.do?refType=by6ckb&fileExtension=r0va4j&fileName=chung.hoeger&endTime=2025-11-12 15:24:04&appId=104&fileSize=713&fileIsvalid=true&refId=104&startTime=2025-11-12 15:24:04&q=vyqjhe&resclassId=104&key=wgx8b2&limit=10&orderBy=370&page=1
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
    "totalCount": 266,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "id": "104",
        "resclassId": "104",
        "fileName": "chung.hoeger",
        "fileIsvalid": true,
        "createTime": "2025-11-12 15:29:33",
        "fileExtension": "1kauc0",
        "ids": [
          "zaqifw"
        ]
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/export.do --data 'fileName=chung.hoeger&limit=10&refType=xz4p42&page=1&fileSize=294&orderBy=227&appId=104&q=s19hd9&endTime=2025-11-12 15:24:04&startTime=2025-11-12 15:24:04&fileIsvalid=true&fileExtension=0cn0li&resclassId=104&refId=104&key=2zki2e'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "yneiyz",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/info.do?id=104
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
    "id": "104",
    "resclassId": "104",
    "fileName": "chung.hoeger",
    "fileIsvalid": true,
    "createTime": "2025-11-12 15:29:33",
    "fileExtension": "i6b8ze",
    "ids": [
      "wvnyve"
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "id": "104",
    "resclassId": "104",
    "fileName": "chung.hoeger",
    "fileIsvalid": true,
    "createTime": "2025-11-12 15:29:33",
    "fileExtension": "7stbhs",
    "ids": [
      "3dzidb"
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
  "data": "tyvhfb",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "id": "104",
    "resclassId": "104",
    "fileName": "chung.hoeger",
    "fileIsvalid": true,
    "createTime": "2025-11-12 15:29:33",
    "fileExtension": "eo25px",
    "ids": [
      "orvtv5"
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
  "data": "g3xfmz",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "id": "104",
    "resclassId": "104",
    "fileName": "chung.hoeger",
    "fileIsvalid": true,
    "createTime": "2025-11-12 15:29:33",
    "fileExtension": "qne97d",
    "ids": [
      "ggy8ms"
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
  "data": "isbq2v",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "guyoom",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download.do?fileName=chung.hoeger&delete=true
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "nyfq8p",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "originFilename": "chung.hoeger",
    "filename": "chung.hoeger",
    "fileType": "gdzxf0",
    "fileUrl": "www.winston-nienow.name",
    "fileHttpUrl": "www.winston-nienow.name",
    "statusCode": "74128"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "originFilename": "chung.hoeger",
      "filename": "chung.hoeger",
      "fileType": "5k1i2x",
      "fileUrl": "www.winston-nienow.name",
      "fileHttpUrl": "www.winston-nienow.name",
      "statusCode": "74128"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/file/download/resource.do?resource=0od57b
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "lav3ib",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/list.do?startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&remark=2yf1h4&configKey=wxojjq&configValue=eu1q0n&orderBy=756&limit=10&page=1&isDisabled=true&q=dwzh9t
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
    "totalCount": 863,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "configId": "104",
        "configKey": "rtkfcl",
        "configValue": "77rtv9",
        "isDisabled": true,
        "remark": "bv5zcf"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/export.do --data 'startTime=2025-11-12 15:24:04&configValue=cs4o18&limit=10&configKey=sjbtfw&page=1&remark=0p3qsf&endTime=2025-11-12 15:24:04&isDisabled=true&q=foeie2&orderBy=254'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "sauixm",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/104.do
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
    "configId": "104",
    "configKey": "p2dq9g",
    "configValue": "0ermol",
    "isDisabled": true,
    "remark": "rq5hp6"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/configwhole/configKey/16odd9.do
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
    "configId": "104",
    "configKey": "f8bh46",
    "configValue": "rngtvv",
    "isDisabled": true,
    "remark": "7b0uom"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "configId": "104",
    "configKey": "1tv7qx",
    "configValue": "nsrsk9",
    "isDisabled": true,
    "remark": "vjrpuh"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "89kka3",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "configId": "104",
    "configKey": "i9m3ka",
    "configValue": "r8tbxw",
    "isDisabled": true,
    "remark": "kujod7"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "neq99u",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "quszci",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "copq9x",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/list.do?ipaddr=wtc095&username=chung.hoeger
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
      "tokenId": "104",
      "deptName": "chung.hoeger",
      "username": "chung.hoeger",
      "ipaddr": "6e6bnl",
      "loginLocation": "opzvj7",
      "browser": "98b6rp",
      "os": "y7d9xs",
      "loginTime": 1762932244859
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/online/104.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "tzgksb",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuserext/list.do?weixinId=104&idNum=1mmxdy&isMobileConfirm=true&qqNo=dq20c5&page=1&familyAddress=1138 Eboni Meadows， West Aricaside， WY 91270&postCode=74128&limit=10&namePy=x474tv&homeTel=t3sqbo&emergencePhone=1-641-218-8251&birthday=2025-11-12 15:29:37&spare2=cx3tgz&idType=519nk7&sex=7a90ig&intro=w106c2&orderBy=537&endTime=2025-11-12 15:24:04&spare4=1ujv1p&sname=chung.hoeger&spare1=495kcv&keywords=ys4okf&comefrom=p1gaow&startTime=2025-11-12 15:24:04&nickname=deon.watsica&nameEn=dqk0dx&q=f4st9t&searchCode=74128&spare3=kw3ak7&name=chung.hoeger&nativePlace=gdyc1f&spareMobile=(567) 281-2291&ids=98aopz&ids=98aopz&idMobile=(567) 281-2291&address=1138 Eboni Meadows， West Aricaside， WY 91270
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:37",
      "lastTime": "2025-11-12 15:29:37",
      "id": "104",
      "nickname": "deon.watsica",
      "idName": "chung.hoeger",
      "idNum": "203itm",
      "idMobile": "(567) 281-2291",
      "idType": "a8m42k",
      "namePy": "99jztx",
      "sname": "chung.hoeger",
      "nameEn": "i15sa2",
      "searchCode": "74128",
      "sex": "asku7t",
      "birthday": "2025-11-12 15:29:37",
      "postCode": "74128",
      "address": "1138 Eboni Meadows， West Aricaside， WY 91270",
      "nativePlace": "zqaibb",
      "familyAddress": "1138 Eboni Meadows， West Aricaside， WY 91270",
      "homeTel": "bstswe",
      "qqNo": "on3sz1",
      "weixinId": "104",
      "weiboId": "104",
      "spareMobile": "(567) 281-2291",
      "isMobileConfirm": true,
      "emergencePhone": "1-641-218-8251",
      "keywords": "fonvac",
      "intro": "8igs5g",
      "comefrom": "ovtxjl",
      "imagePath": "1f924d",
      "userSignature": "bt97bq",
      "ipRange": "k9978f",
      "macCode": "74128",
      "resume": "uzlcb3",
      "spare1": "77jtvm",
      "spare2": "b0ejwi",
      "spare3": "jeiel4",
      "spare4": "ndjtyk"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:37",
    "lastTime": "2025-11-12 15:29:37",
    "id": "104",
    "nickname": "deon.watsica",
    "idName": "chung.hoeger",
    "idNum": "tbhw0h",
    "idMobile": "(567) 281-2291",
    "idType": "g4zdit",
    "namePy": "16jeml",
    "sname": "chung.hoeger",
    "nameEn": "wk9b6f",
    "searchCode": "74128",
    "sex": "c9u8i3",
    "birthday": "2025-11-12 15:29:37",
    "postCode": "74128",
    "address": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "nativePlace": "3pck3h",
    "familyAddress": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "homeTel": "x40u3s",
    "qqNo": "6q06xz",
    "weixinId": "104",
    "weiboId": "104",
    "spareMobile": "(567) 281-2291",
    "isMobileConfirm": true,
    "emergencePhone": "1-641-218-8251",
    "keywords": "95uebk",
    "intro": "f5rk5i",
    "comefrom": "0qxvp5",
    "imagePath": "b5c4rm",
    "userSignature": "b8lq2h",
    "ipRange": "lrdtk4",
    "macCode": "74128",
    "resume": "ctugtv",
    "spare1": "pkel67",
    "spare2": "pwsv1m",
    "spare3": "mk36il",
    "spare4": "e5tzbr"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:37",
    "lastTime": "2025-11-12 15:29:37",
    "id": "104",
    "nickname": "deon.watsica",
    "idName": "chung.hoeger",
    "idNum": "itr1ap",
    "idMobile": "(567) 281-2291",
    "idType": "bq3y4y",
    "namePy": "uqv19k",
    "sname": "chung.hoeger",
    "nameEn": "kbgpgw",
    "searchCode": "74128",
    "sex": "sh1ckm",
    "birthday": "2025-11-12 15:29:37",
    "postCode": "74128",
    "address": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "nativePlace": "d1k5xm",
    "familyAddress": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "homeTel": "bxloog",
    "qqNo": "ajp6lz",
    "weixinId": "104",
    "weiboId": "104",
    "spareMobile": "(567) 281-2291",
    "isMobileConfirm": true,
    "emergencePhone": "1-641-218-8251",
    "keywords": "x1k518",
    "intro": "ihqou4",
    "comefrom": "twcun5",
    "imagePath": "yeoqza",
    "userSignature": "0rr65s",
    "ipRange": "v59hnh",
    "macCode": "74128",
    "resume": "ntu9wz",
    "spare1": "8adfrj",
    "spare2": "s61idw",
    "spare3": "msenz8",
    "spare4": "vcbd00"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "kyb65q",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:37",
    "lastTime": "2025-11-12 15:29:37",
    "id": "104",
    "nickname": "deon.watsica",
    "idName": "chung.hoeger",
    "idNum": "py5fhk",
    "idMobile": "(567) 281-2291",
    "idType": "28bglx",
    "namePy": "aoovpp",
    "sname": "chung.hoeger",
    "nameEn": "ih1rqu",
    "searchCode": "74128",
    "sex": "ewgu3c",
    "birthday": "2025-11-12 15:29:37",
    "postCode": "74128",
    "address": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "nativePlace": "gfatgi",
    "familyAddress": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "homeTel": "08khdo",
    "qqNo": "9w13jw",
    "weixinId": "104",
    "weiboId": "104",
    "spareMobile": "(567) 281-2291",
    "isMobileConfirm": true,
    "emergencePhone": "1-641-218-8251",
    "keywords": "shw8wb",
    "intro": "jiwpmq",
    "comefrom": "jkcyv3",
    "imagePath": "6ymull",
    "userSignature": "80h1ci",
    "ipRange": "2jc1k2",
    "macCode": "74128",
    "resume": "251apt",
    "spare1": "26h6qz",
    "spare2": "gnpsi8",
    "spare3": "ci0nb6",
    "spare4": "d986a6"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "t9237r",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "xt68lk",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuser/list.do?createType=490&limit=10&delFlag=9&bindOrganType=jw7vvo&bindOrganId=104&xzqhId=772&spare2=hwl7ae&key=47t6qp&startTime=2025-11-12 15:24:04&email=antone.stark@hotmail.com&searchCode=74128&orderBy=416&workUserId=104&spare1=5p8ebt&page=1&source=808&ids=09ja5p&ids=09ja5p&createTime=2025-11-12 15:24:04&isBindFrontUser=att2th&lastAppId=104&mobile=(567) 281-2291&username=chung.hoeger&endTime=2025-11-12 15:24:04&q=9vs2fg&srcCode=907&registerTime=2025-11-12 15:29:37&description=5onibh
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
└─spare1|string|备用1，头像|-
└─spare2|string|备用2，第三方用户ID，OpenId|-
└─newPassword|string|新密码|-
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:37",
      "lastTime": "2025-11-12 15:29:37",
      "id": "104",
      "xzqhId": 446,
      "source": "tya32v",
      "createType": 296,
      "username": "chung.hoeger",
      "mobile": "(567) 281-2291",
      "email": "antone.stark@hotmail.com",
      "password": "84ng2y",
      "salt": "xuuf3i",
      "srcCode": 862,
      "registerTime": "2025-11-12 15:29:37",
      "registerIp": "239.116.167.16",
      "currentLoginTime": "2025-11-12 15:29:37",
      "currentLoginIp": "239.116.167.16",
      "lastAppId": "104",
      "lastLoginTime": "2025-11-12 15:29:37",
      "lastLoginIp": "239.116.167.16",
      "lastLogoutTime": "2025-11-12 15:29:37",
      "loginCount": 291,
      "resetKey": "htbkgc",
      "resetPwd": "vpuexi",
      "lastResetTime": "2025-11-12 15:29:37",
      "errorTime": "2025-11-12 15:29:37",
      "errorCount": 294,
      "errorIp": "239.116.167.16",
      "lockTime": "2025-11-12 15:29:37",
      "activation": true,
      "activationCode": "74128",
      "priority": 260,
      "delFlag": 9,
      "deleteTime": "2025-11-12 15:29:37",
      "description": "u8kr0s",
      "spare1": "8aj0jb",
      "spare2": "jhvd3e",
      "newPassword": "d2rdiy"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
└─spare1|string|备用1，头像|-
└─spare2|string|备用2，第三方用户ID，OpenId|-
└─newPassword|string|新密码|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:37",
    "lastTime": "2025-11-12 15:29:37",
    "id": "104",
    "xzqhId": 575,
    "source": "c147d1",
    "createType": 694,
    "username": "chung.hoeger",
    "mobile": "(567) 281-2291",
    "email": "antone.stark@hotmail.com",
    "password": "k3mav7",
    "salt": "gsonip",
    "srcCode": 181,
    "registerTime": "2025-11-12 15:29:37",
    "registerIp": "239.116.167.16",
    "currentLoginTime": "2025-11-12 15:29:37",
    "currentLoginIp": "239.116.167.16",
    "lastAppId": "104",
    "lastLoginTime": "2025-11-12 15:29:37",
    "lastLoginIp": "239.116.167.16",
    "lastLogoutTime": "2025-11-12 15:29:37",
    "loginCount": 296,
    "resetKey": "7vbg12",
    "resetPwd": "eujkfv",
    "lastResetTime": "2025-11-12 15:29:37",
    "errorTime": "2025-11-12 15:29:37",
    "errorCount": 681,
    "errorIp": "239.116.167.16",
    "lockTime": "2025-11-12 15:29:37",
    "activation": true,
    "activationCode": "74128",
    "priority": 724,
    "delFlag": 9,
    "deleteTime": "2025-11-12 15:29:37",
    "description": "cuwx15",
    "spare1": "kfnfs9",
    "spare2": "rdh42i",
    "newPassword": "l73lnw"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
└─spare1|string|备用1，头像|false|-
└─spare2|string|备用2，第三方用户ID，OpenId|false|-
└─newPassword|string|新密码|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuser/save.do --data '{
  "data": {
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:37",
    "lastTime": "2025-11-12 15:29:37",
    "id": "104",
    "xzqhId": 730,
    "source": "oa1j9l",
    "createType": 310,
    "username": "chung.hoeger",
    "mobile": "(567) 281-2291",
    "email": "antone.stark@hotmail.com",
    "password": "heg3kk",
    "salt": "mhmugj",
    "srcCode": 289,
    "registerTime": "2025-11-12 15:29:37",
    "registerIp": "239.116.167.16",
    "currentLoginTime": "2025-11-12 15:29:37",
    "currentLoginIp": "239.116.167.16",
    "lastAppId": "104",
    "lastLoginTime": "2025-11-12 15:29:37",
    "lastLoginIp": "239.116.167.16",
    "lastLogoutTime": "2025-11-12 15:29:37",
    "loginCount": 94,
    "resetKey": "0n5mi1",
    "resetPwd": "wzh84p",
    "lastResetTime": "2025-11-12 15:29:37",
    "errorTime": "2025-11-12 15:29:37",
    "errorCount": 997,
    "errorIp": "239.116.167.16",
    "lockTime": "2025-11-12 15:29:37",
    "activation": true,
    "activationCode": "74128",
    "priority": 107,
    "delFlag": 9,
    "deleteTime": "2025-11-12 15:29:37",
    "description": "qkx0o2",
    "spare1": "uospvx",
    "spare2": "zpttje",
    "newPassword": "r7rlip"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "8ydpbm",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
└─spare1|string|备用1，头像|false|-
└─spare2|string|备用2，第三方用户ID，OpenId|false|-
└─newPassword|string|新密码|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/baseuser/update.do --data '{
  "data": {
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:37",
    "lastTime": "2025-11-12 15:29:37",
    "id": "104",
    "xzqhId": 233,
    "source": "9ucuuc",
    "createType": 829,
    "username": "chung.hoeger",
    "mobile": "(567) 281-2291",
    "email": "antone.stark@hotmail.com",
    "password": "33bfqy",
    "salt": "3cuj60",
    "srcCode": 838,
    "registerTime": "2025-11-12 15:29:37",
    "registerIp": "239.116.167.16",
    "currentLoginTime": "2025-11-12 15:29:37",
    "currentLoginIp": "239.116.167.16",
    "lastAppId": "104",
    "lastLoginTime": "2025-11-12 15:29:37",
    "lastLoginIp": "239.116.167.16",
    "lastLogoutTime": "2025-11-12 15:29:37",
    "loginCount": 908,
    "resetKey": "4ix2xk",
    "resetPwd": "3xeqht",
    "lastResetTime": "2025-11-12 15:29:37",
    "errorTime": "2025-11-12 15:29:37",
    "errorCount": 758,
    "errorIp": "239.116.167.16",
    "lockTime": "2025-11-12 15:29:37",
    "activation": true,
    "activationCode": "74128",
    "priority": 156,
    "delFlag": 9,
    "deleteTime": "2025-11-12 15:29:37",
    "description": "cd67rs",
    "spare1": "60dqjt",
    "spare2": "fwuigz",
    "newPassword": "fdme0y"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "nwl6sx",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "n11b7s",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list.do?status=892&creatorId=104&q=qm1hk7&organId=104&updatorId=104&appId=104&msgUrl=www.winston-nienow.name&title=b4pbp3&recvTargetid=104&recvGroupId=104&recvOrganId=104&readStatus=sh80bi&iconStyle=4moi8a&description=7t6uzf&page=1&startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&limit=10&orderBy=103&updateTime=2025-11-12 15:29:38&content=o9gacf&type=329&foreignId=104&bizType=166i6g&imagePath=3whxjr&id=589&recvMemberId=104
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:38",
      "lastTime": "2025-11-12 15:29:38",
      "id": 754,
      "appId": "104",
      "organId": "104",
      "bizType": "ynan21",
      "type": 910,
      "title": "5d9l04",
      "content": "wwtql6",
      "msgUrl": "www.winston-nienow.name",
      "foreignId": "104",
      "imagePath": "4a7f70",
      "iconStyle": "7niti3",
      "recvMemberId": "104",
      "recvGroupId": "104",
      "recvOrganId": "104",
      "recvTargetid": "104",
      "status": 293,
      "updatorId": "104",
      "updateTime": "2025-11-12 15:29:38",
      "description": "ax11n6"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/list/myself.do?page=1&description=qnbhun&updatorId=104&startTime=2025-11-12 15:24:04&orderBy=556&recvTargetid=104&bizType=w9h1ho&limit=10&updateTime=2025-11-12 15:29:38&recvMemberId=104&title=7fqkep&status=646&readStatus=r3io1y&foreignId=104&imagePath=tv1y51&q=riqgqd&iconStyle=c7g7hy&content=03apkz&id=198&appId=104&type=385&creatorId=104&recvOrganId=104&msgUrl=www.winston-nienow.name&recvGroupId=104&endTime=2025-11-12 15:24:04&organId=104
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:38",
      "lastTime": "2025-11-12 15:29:38",
      "id": 570,
      "appId": "104",
      "organId": "104",
      "bizType": "m923ne",
      "type": 826,
      "title": "te3kn7",
      "content": "tirsm6",
      "msgUrl": "www.winston-nienow.name",
      "foreignId": "104",
      "imagePath": "vum70r",
      "iconStyle": "1zz0k5",
      "recvMemberId": "104",
      "recvGroupId": "104",
      "recvOrganId": "104",
      "recvTargetid": "104",
      "status": 589,
      "updatorId": "104",
      "updateTime": "2025-11-12 15:29:38",
      "description": "j8dikq"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/notice/export.do --data 'orderBy=643&recvOrganId=104&endTime=2025-11-12 15:24:04&content=3ipoot&recvMemberId=104&recvGroupId=104&imagePath=523yqt&iconStyle=s691ly&creatorId=104&limit=10&updateTime=2025-11-12 15:29:38&q=txe42l&startTime=2025-11-12 15:24:04&status=691&type=216&recvTargetid=104&updatorId=104&readStatus=egjvni&appId=104&page=1&description=tjgr6q&id=801&foreignId=104&organId=104&bizType=yli1gm&title=zn3fv8&msgUrl=www.winston-nienow.name'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ed4w80",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:38",
    "lastTime": "2025-11-12 15:29:38",
    "id": 257,
    "appId": "104",
    "organId": "104",
    "bizType": "m1wo8p",
    "type": 87,
    "title": "7fa2jd",
    "content": "n2ljmn",
    "msgUrl": "www.winston-nienow.name",
    "foreignId": "104",
    "imagePath": "7asmh6",
    "iconStyle": "gon7na",
    "recvMemberId": "104",
    "recvGroupId": "104",
    "recvOrganId": "104",
    "recvTargetid": "104",
    "status": 678,
    "updatorId": "104",
    "updateTime": "2025-11-12 15:29:38",
    "description": "w4o3qt"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:38",
    "lastTime": "2025-11-12 15:29:38",
    "id": 177,
    "appId": "104",
    "organId": "104",
    "bizType": "vw5ie0",
    "type": 439,
    "title": "q8uptp",
    "content": "j98ryv",
    "msgUrl": "www.winston-nienow.name",
    "foreignId": "104",
    "imagePath": "lecp08",
    "iconStyle": "vhkoyu",
    "recvMemberId": "104",
    "recvGroupId": "104",
    "recvOrganId": "104",
    "recvTargetid": "104",
    "status": 812,
    "updatorId": "104",
    "updateTime": "2025-11-12 15:29:38",
    "description": "ewlnhz"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "wjh8aj",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:38",
    "lastTime": "2025-11-12 15:29:38",
    "id": 867,
    "appId": "104",
    "organId": "104",
    "bizType": "mrz1t3",
    "type": 859,
    "title": "nj9esn",
    "content": "5jti7x",
    "msgUrl": "www.winston-nienow.name",
    "foreignId": "104",
    "imagePath": "g5nwoy",
    "iconStyle": "9sfmb1",
    "recvMemberId": "104",
    "recvGroupId": "104",
    "recvOrganId": "104",
    "recvTargetid": "104",
    "status": 821,
    "updatorId": "104",
    "updateTime": "2025-11-12 15:29:38",
    "description": "axqo0y"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "oxz9i1",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "zxi54s",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "lajsl8",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "n2qyhv",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "3r6qu1",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "mapKey1": "ln7m7i",
    "mapKey2": "kdtn2a"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/list.do?isDisabled=true&spare2=0hfgke&appId=104&aesIvKey=ap4qtn&orderBy=905&clientSecret=ewsclu&serverConf3=vmv7qd&organId=104&type=147&inoutMode=890&spare1=rbegt3&serverUrl=www.winston-nienow.name&q=bewvj8&organName=chung.hoeger&isSingle=true&confLimit=10&page=1&endTime=2025-11-12 15:24:04&cname=chung.hoeger&id=104&serverConf2=fsgyhp&currCount=154&status=222&aesKey=0o2tyh&description=bjiwnx&clientId=104&limit=10&serverIp=239.116.167.16&name=chung.hoeger&startTime=2025-11-12 15:24:04&serverConf1=aelrjl&isAdmin=true&serverType=2roi2e
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:35",
      "lastTime": "2025-11-12 15:29:35",
      "id": "104",
      "organId": "104",
      "appId": "104",
      "organName": "chung.hoeger",
      "inoutMode": 667,
      "name": "chung.hoeger",
      "cname": "chung.hoeger",
      "type": 160,
      "clientId": "104",
      "clientSecret": "3ojzvr",
      "aesKey": "l5lf0a",
      "aesIvKey": "e3d4vb",
      "serverIp": "239.116.167.16",
      "serverType": "ssxx07",
      "serverUrl": "www.winston-nienow.name",
      "serverConf1": "jclllp",
      "serverConf2": "2nkwzc",
      "serverConf3": "odcdv0",
      "currCount": 467,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 13,
      "description": "0uqms6",
      "spare1": "mkq0fa",
      "spare2": "qdk3vg",
      "inOrganName": "chung.hoeger",
      "userName": "chung.hoeger",
      "appName": "chung.hoeger",
      "inoutModeName": "chung.hoeger",
      "typeName": "chung.hoeger"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/getClientSecret.do?clientId=104
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:35",
      "lastTime": "2025-11-12 15:29:35",
      "id": "104",
      "organId": "104",
      "appId": "104",
      "organName": "chung.hoeger",
      "inoutMode": 17,
      "name": "chung.hoeger",
      "cname": "chung.hoeger",
      "type": 741,
      "clientId": "104",
      "clientSecret": "eyl7l0",
      "aesKey": "ok7lur",
      "aesIvKey": "u7yh8s",
      "serverIp": "239.116.167.16",
      "serverType": "6pakik",
      "serverUrl": "www.winston-nienow.name",
      "serverConf1": "yyijxv",
      "serverConf2": "at874m",
      "serverConf3": "j3srmf",
      "currCount": 509,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 741,
      "description": "6upsys",
      "spare1": "0wj1af",
      "spare2": "eboej6",
      "inOrganName": "chung.hoeger",
      "userName": "chung.hoeger",
      "appName": "chung.hoeger",
      "inoutModeName": "chung.hoeger",
      "typeName": "chung.hoeger"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/getKeyParity.do?id=104
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:35",
      "lastTime": "2025-11-12 15:29:35",
      "id": "104",
      "organId": "104",
      "appId": "104",
      "organName": "chung.hoeger",
      "inoutMode": 584,
      "name": "chung.hoeger",
      "cname": "chung.hoeger",
      "type": 650,
      "clientId": "104",
      "clientSecret": "jo9wte",
      "aesKey": "mlo0po",
      "aesIvKey": "o15pse",
      "serverIp": "239.116.167.16",
      "serverType": "t0plfp",
      "serverUrl": "www.winston-nienow.name",
      "serverConf1": "pjcz0q",
      "serverConf2": "yu9ngf",
      "serverConf3": "2sar12",
      "currCount": 624,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 979,
      "description": "fpmo6w",
      "spare1": "pectuu",
      "spare2": "0velg0",
      "inOrganName": "chung.hoeger",
      "userName": "chung.hoeger",
      "appName": "chung.hoeger",
      "inoutModeName": "chung.hoeger",
      "typeName": "chung.hoeger"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
{"success":true,"code":"0","msg":"正常","data":Error restful return.,"requestId":"104","timestamp":"2025-11-12 15:24:04"}
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
  "data": "dlhiki",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "ymb5os",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "z075cf",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/account/authlist.do?endTime=2025-11-12 15:24:04&page=1&cname=chung.hoeger&aesKey=fbufnb&isAdmin=true&serverType=36at3n&description=ek8s42&limit=10&status=144&serverConf3=cam51a&serverIp=239.116.167.16&spare1=nvnwon&clientId=104&q=7hh7ui&aesIvKey=1v16qy&serverConf1=bm3sn7&startTime=2025-11-12 15:24:04&inoutMode=22&name=chung.hoeger&spare2=xatdx0&organId=104&id=104&orderBy=796&serverConf2=29c8oh&organName=chung.hoeger&type=893&appId=104&confLimit=10&isSingle=true&serverUrl=www.winston-nienow.name&currCount=766&clientSecret=gx8f71&isDisabled=true
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:35",
      "lastTime": "2025-11-12 15:29:35",
      "id": "104",
      "organId": "104",
      "appId": "104",
      "organName": "chung.hoeger",
      "inoutMode": 953,
      "name": "chung.hoeger",
      "cname": "chung.hoeger",
      "type": 363,
      "clientId": "104",
      "clientSecret": "xtbngu",
      "aesKey": "6vjumw",
      "aesIvKey": "gvs0e8",
      "serverIp": "239.116.167.16",
      "serverType": "bocsgf",
      "serverUrl": "www.winston-nienow.name",
      "serverConf1": "p21861",
      "serverConf2": "vuj3jo",
      "serverConf3": "zroau3",
      "currCount": 257,
      "confLimit": 10,
      "isAdmin": true,
      "isSingle": true,
      "isDisabled": true,
      "status": 661,
      "description": "pchb8x",
      "spare1": "6t5nrz",
      "spare2": "qlp29e",
      "inOrganName": "chung.hoeger",
      "userName": "chung.hoeger",
      "appName": "chung.hoeger",
      "inoutModeName": "chung.hoeger",
      "typeName": "chung.hoeger"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "j85kz4",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/application.do?q=a22f23&page=1&startTime=2025-11-12 15:24:04&orderBy=919&limit=10&endTime=2025-11-12 15:24:04
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
      "organNum": "jas9pb",
      "deptNum": "139rzc",
      "peopleNum": "6xh2o2",
      "roleNum": "svnnmp",
      "dicTypeNum": "tg6ssu",
      "appNum": "qscjvb",
      "fileNum": "vrhbi7",
      "paramNum": "b1gmbl"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/element.do?orderBy=243&q=87pkbo&limit=10&endTime=2025-11-12 15:24:04&startTime=2025-11-12 15:24:04&page=1
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
      "objectNum": "k039vn",
      "modelNum": "fznf2v"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/index/manage.do?q=rkuhat&page=1&startTime=2025-11-12 15:24:04&limit=10&orderBy=191&endTime=2025-11-12 15:24:04
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
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
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "appNum": "67cy8q",
      "accountNum": "xrw6ds",
      "serviceOrganNum": "nd3qxv"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/selectList.do?organId=104&orderBy=660&existKey=5s7kgs&startTime=2025-11-12 15:24:04&q=9dmho9&isMobileApp=true&status=577&xzqhId=171&ftpId=104&description=ox38dg&domainId=104&appType=mkg4lb&isSite=true&ids=tswm2b&ids=tswm2b&sertypeId=104&mode=559&endTime=2025-11-12 15:24:04&page=1&name=chung.hoeger&limit=10&path=nhjncc&delFlag=9&isDisabled=true
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:32",
      "lastTime": "2025-11-12 15:29:32",
      "id": "104",
      "ftpId": "104",
      "domainId": "104",
      "organId": "104",
      "xzqhId": 68,
      "sertypeId": "104",
      "name": "chung.hoeger",
      "path": "mkhgry",
      "appType": "uv030j",
      "isSite": true,
      "isDisabled": true,
      "isMobileApp": true,
      "status": 427,
      "priority": 955,
      "delFlag": 9,
      "deleteTime": "2025-11-12 15:29:32",
      "description": "0t9aw5",
      "spare1": "yjx3rq",
      "spare2": "b5d4f1",
      "xzqhName": "chung.hoeger"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/list.do?limit=10&mode=71&name=chung.hoeger&endTime=2025-11-12 15:24:04&appType=708as6&orderBy=417&xzqhId=651&ids=bod28v&ids=bod28v&isMobileApp=true&idArr=xnutfd&page=1&domainId=104&isSite=true&description=23n6ap&delFlag=9&q=4araf7&status=509&startTime=2025-11-12 15:24:04&existKey=f7465b&path=db5832&isDisabled=true&sertypeId=104&ftpId=104&organId=104
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
    "totalCount": 786,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:32",
        "lastTime": "2025-11-12 15:29:32",
        "id": "104",
        "ftpId": "104",
        "domainId": "104",
        "organId": "104",
        "xzqhId": 434,
        "sertypeId": "104",
        "name": "chung.hoeger",
        "path": "wothpi",
        "appType": "7313t8",
        "isSite": true,
        "isDisabled": true,
        "isMobileApp": true,
        "status": 807,
        "priority": 789,
        "delFlag": 9,
        "deleteTime": "2025-11-12 15:29:32",
        "description": "14rz07",
        "spare1": "661haa",
        "spare2": "808ebs",
        "xzqhName": "chung.hoeger"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/export.do --data 'status=818&existKey=0wzzvs&ids=rnapvb&ids=rnapvb&limit=10&delFlag=9&appType=x295c6&organId=104&description=g5txu8&q=4c9tdx&idArr=y6ty29&page=1&path=p8xm14&sertypeId=104&domainId=104&isDisabled=true&endTime=2025-11-12 15:24:04&isMobileApp=true&startTime=2025-11-12 15:24:04&mode=432&orderBy=411&isSite=true&ftpId=104&name=chung.hoeger&xzqhId=345'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "9qjpgq",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/104.do
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:32",
    "lastTime": "2025-11-12 15:29:32",
    "id": "104",
    "ftpId": "104",
    "domainId": "104",
    "organId": "104",
    "xzqhId": 904,
    "sertypeId": "104",
    "name": "chung.hoeger",
    "path": "df8nh2",
    "appType": "r3x43o",
    "isSite": true,
    "isDisabled": true,
    "isMobileApp": true,
    "status": 507,
    "priority": 764,
    "delFlag": 9,
    "deleteTime": "2025-11-12 15:29:32",
    "description": "y6v1bj",
    "spare1": "rjqnx2",
    "spare2": "gpjmpy",
    "xzqhName": "chung.hoeger",
    "ftpName": "chung.hoeger",
    "sertypeName": "chung.hoeger",
    "domainName": "chung.hoeger",
    "organName": "chung.hoeger"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "id": "104",
    "ftpId": "104",
    "ftpName": "chung.hoeger",
    "domainId": "104",
    "domainName": "chung.hoeger",
    "organId": "104",
    "organName": "chung.hoeger",
    "xzqhId": 378,
    "xzqhName": "chung.hoeger",
    "sertypeId": "104",
    "name": "chung.hoeger",
    "path": "ig607o",
    "appType": "yac0w5",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 483,
    "statusName": "chung.hoeger",
    "priority": 805,
    "createTime": "2025-11-12 15:29:32",
    "description": "9k1dni",
    "spare1": "44jrug",
    "statusMap": {
      "mapKey": "xmi32k"
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
  "data": "8vklku",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "id": "104",
    "ftpId": "104",
    "ftpName": "chung.hoeger",
    "domainId": "104",
    "domainName": "chung.hoeger",
    "organId": "104",
    "organName": "chung.hoeger",
    "xzqhId": 779,
    "xzqhName": "chung.hoeger",
    "sertypeId": "104",
    "name": "chung.hoeger",
    "path": "xm568h",
    "appType": "zqbud6",
    "isSite": true,
    "isOpen": true,
    "isMobileApp": true,
    "status": 738,
    "statusName": "chung.hoeger",
    "priority": 764,
    "createTime": "2025-11-12 15:29:32",
    "description": "4wp8e5",
    "spare1": "yrfkq6",
    "statusMap": {
      "mapKey": "t8f1ro"
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
  "data": "sl0s5b",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "wqznhd",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/init/104.do --data '{
  "data": {
    "id": "104",
    "menuJsons": {
      "size": 10
    },
    "initJson": {},
    "username": "chung.hoeger",
    "password": "9zbvch",
    "initPath": "90lel5"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "no1gdj",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/xzqh/list.do?limit=10&delFlag=9&page=1&sname=chung.hoeger&code=74128&nameEn=uhmgue&description=3p4y2z&countryId=104&parentId=424&name=chung.hoeger&q=6ubaza&areatypeIds=d1k7sv&areatypeIds=d1k7sv&rgt=357&lft=167&startTime=2025-11-12 15:24:04&orderBy=28&nameTotal=xxk4si&deleteTime=2025-11-12 15:24:04&hasContent=true&areatypeId=104&isDisplay=true&endTime=2025-11-12 15:24:04&parentIds=ky25fe&parentIds=ky25fe&likeQuery=okxplb&searchCode=74128&ids=eihg8w&ids=eihg8w
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
    "totalCount": 783,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:32",
        "lastTime": "2025-11-12 15:29:32",
        "id": 387,
        "parentId": 568,
        "countryId": "104",
        "areatypeId": "104",
        "lft": 517,
        "rgt": 818,
        "code": "74128",
        "name": "chung.hoeger",
        "nameTotal": "wdhnr5",
        "sname": "chung.hoeger",
        "nameEn": "757mtz",
        "searchCode": "74128",
        "isDisplay": true,
        "hasContent": true,
        "priority": 953,
        "delFlag": 9,
        "deleteTime": "2025-11-12 15:29:32",
        "description": "8qxfp3",
        "countryName": "chung.hoeger",
        "parentName": "chung.hoeger",
        "areatypeName": "chung.hoeger"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/app/organ/list.do?organCode=74128&spare2=n2073m&orgtypeId=104&source=588&ids=dyct45&ids=dyct45&description=u3fxg6&xzqhId=252&startTime=2025-11-12 15:24:04&orderBy=321&limit=10&page=1&spare1=apqqd5&key=0oaze2&isOrganWork=nx35zk&organName=chung.hoeger&createType=175&delFlag=9&name=chung.hoeger&unionCode=74128&q=704ibw&endTime=2025-11-12 15:24:04
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
    "totalCount": 147,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:33",
        "lastTime": "2025-11-12 15:29:33",
        "cmsKey": "w5cl7r",
        "cmsValue": "lwf30r"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/list.do?parentId=222&dictLabel=6i8kb1&cddValue=ptqhgb&q=bsvu95&listClass=i5cxt0&typeCode=74128&searchCode=74128&orderBy=215&page=1&endTime=2025-11-12 15:24:04&cddId=50&cssClass=g2tx9v&startTime=2025-11-12 15:24:04&status=5qyp1p&key=0hw0up&limit=10&name=chung.hoeger&isDefault=bbxngc&dictSort=323&remark=fkmwmw
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
    "totalCount": 520,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cddId": 535,
        "typeCode": "74128",
        "parentId": 915,
        "name": "chung.hoeger",
        "sname": "chung.hoeger",
        "cddValue": "ffz777",
        "searchCode": "74128",
        "priority": 3,
        "createTime": "2025-11-12 15:29:36",
        "remark": "tqeco8",
        "dictLabel": "be0lwv",
        "typeCodeName": "chung.hoeger",
        "parentName": "chung.hoeger"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/export.do --data 'q=rr0x6k&cddId=357&cddValue=1c83sc&orderBy=863&endTime=2025-11-12 15:24:04&typeCode=74128&startTime=2025-11-12 15:24:04&status=oalncc&name=chung.hoeger&page=1&dictLabel=zhz198&listClass=oavgvo&isDefault=lo92a3&key=86u6d2&searchCode=74128&dictSort=894&cssClass=msni4h&limit=10&remark=7sv28r&parentId=176'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "4fakqs",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/816.do
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
    "cddId": 174,
    "typeCode": "74128",
    "parentId": 173,
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "cddValue": "u2l2ev",
    "searchCode": "74128",
    "priority": 890,
    "createTime": "2025-11-12 15:29:36",
    "remark": "ctlhjl",
    "dictLabel": "1tl0f3",
    "typeCodeName": "chung.hoeger",
    "parentName": "chung.hoeger"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/type/llz3jz.do?zparentId=104&typeCode=74128&parentId=104&roletypeId=104
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "cddId": 136,
    "typeCode": "74128",
    "parentId": 752,
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "cddValue": "pi4upg",
    "searchCode": "74128",
    "priority": 460,
    "createTime": "2025-11-12 15:29:36",
    "remark": "ghcs2o",
    "dictLabel": "5p94pr",
    "typeCodeName": "chung.hoeger",
    "parentName": "chung.hoeger"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "z75o7v",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "cddId": 470,
    "typeCode": "74128",
    "parentId": 9,
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "cddValue": "xoh7i6",
    "searchCode": "74128",
    "priority": 392,
    "createTime": "2025-11-12 15:29:36",
    "remark": "y9yufq",
    "dictLabel": "37dde2",
    "typeCodeName": "chung.hoeger",
    "parentName": "chung.hoeger"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "y36mqk",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "3387q6",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/comm/tree.do?organId=104&status=xit2i1&roletypeId=104&endTime=2025-11-12 15:24:04&wlType=08sie3&subType=p5ogyz&page=1&startTime=2025-11-12 15:24:04&refType=zigbs5&orderBy=226&roleId=104&appId=104&refresh=cogo08&q=ehxmp9&positionId=104&showButton=zlkvdc&parentId=104&positionType=cdaon9&key=tkqm6s&limit=10&gnType=4pd8oi&groupId=104&metaId=104&type=etzc4i
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
      "id": "104",
      "label": "fskz66",
      "shortName": "chung.hoeger",
      "organId": "104",
      "areaId": 107,
      "searchCode": "74128",
      "childNum": 818,
      "checked": true,
      "entity": 18,
      "show": true,
      "showIcon": true,
      "parentId": "104",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictionary/tree.do?typeCodes=er2wiu&typeCodes=er2wiu&cddValue=a2encw&name=chung.hoeger&sname=chung.hoeger&ids=li8ubw&ids=li8ubw&startTime=2025-11-12 15:24:04&dispFlag=gqwnhk&typeCode=74128&cddLevel=7zokl5&q=yzn9ux&searchCode=74128&page=1&isAllChild=wulfqu&delFlag=9&description=f5loxo&existKey=kivms4&orderBy=379&typeMode=9yna6l&key=dnausj&limit=10&endTime=2025-11-12 15:24:04&parentId=253
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:36",
      "lastTime": "2025-11-12 15:29:36",
      "id": 240,
      "typeCode": "74128",
      "parentId": 990,
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "cddValue": "rgssdp",
      "cddLevel": "q5esrt",
      "searchCode": "74128",
      "dispFlag": "m7pxo0",
      "priority": 408,
      "delFlag": 9,
      "deleteTime": "2025-11-12 15:29:36",
      "description": "pfzw0w",
      "spare1": "y3ox13",
      "spare2": "5k0cn2",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/list.do?endTime=2025-11-12 15:24:04&name=chung.hoeger&typeClass=awbha0&limit=10&page=1&typeId=104&orderBy=501&status=xequ47&typeMode=324&q=qu6aju&remark=clmoek&key=hu7np7&startTime=2025-11-12 15:24:04
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
    "totalCount": 178,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "typeId": "104",
        "name": "chung.hoeger",
        "typeClass": "1pp122",
        "typeRef": "hogos1",
        "typeMode": 890,
        "searchCode": "74128",
        "priority": 955,
        "createTime": "2025-11-12 15:29:36",
        "status": 611,
        "remark": "joalev"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/export.do --data 'page=1&remark=mm8c7p&limit=10&typeId=104&orderBy=377&name=chung.hoeger&typeClass=31uxpf&status=hqyuf9&key=bvzekn&startTime=2025-11-12 15:24:04&typeMode=689&endTime=2025-11-12 15:24:04&q=vcfwus'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "enjjmn",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/dictype/104.do
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
    "typeId": "104",
    "name": "chung.hoeger",
    "typeClass": "1i62ms",
    "typeRef": "9t8xv0",
    "typeMode": 815,
    "searchCode": "74128",
    "priority": 673,
    "createTime": "2025-11-12 15:29:36",
    "status": 939,
    "remark": "bibp10"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "typeId": "104",
    "name": "chung.hoeger",
    "typeClass": "xwk30n",
    "typeRef": "8qx63h",
    "typeMode": 380,
    "searchCode": "74128",
    "priority": 219,
    "createTime": "2025-11-12 15:29:36",
    "status": 970,
    "remark": "exphfo"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "fojnxz",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "typeId": "104",
    "name": "chung.hoeger",
    "typeClass": "zrhvs4",
    "typeRef": "3wu174",
    "typeMode": 36,
    "searchCode": "74128",
    "priority": 475,
    "createTime": "2025-11-12 15:29:36",
    "status": 654,
    "remark": "m7780d"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "s0mf9w",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "iw85uj",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "yqcbsn",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "typeId": "104",
      "name": "chung.hoeger",
      "typeClass": "uwc7sv",
      "typeRef": "8kmcnf",
      "typeMode": 297,
      "searchCode": "74128",
      "priority": 652,
      "createTime": "2025-11-12 15:29:37",
      "status": 717,
      "remark": "0yauo4"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "cpuNum": 441,
      "total": 87.85,
      "sys": 19.17,
      "used": 45.97,
      "wait": 53.83,
      "free": 38.10
    },
    "mem": {
      "total": 38.56,
      "used": 62.41,
      "free": 92.37
    },
    "jvm": {
      "total": 87.37,
      "max": 65.15,
      "free": 16.59,
      "version": "0.46",
      "home": "wsttjd"
    },
    "sys": {
      "computerName": "chung.hoeger",
      "computerIp": "239.116.167.16",
      "userDir": "izcnkd",
      "osName": "chung.hoeger",
      "osArch": "6cguwe"
    },
    "sysFiles": [
      {
        "dirName": "chung.hoeger",
        "sysTypeName": "chung.hoeger",
        "typeName": "chung.hoeger",
        "total": "0qzw31",
        "free": "mur71d",
        "used": "u7na1j",
        "usage": 90.03
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/list.do?sname=chung.hoeger&description=76keaz&orderBy=167&page=1&startTime=2025-11-12 15:24:04&limit=10&name=chung.hoeger&delFlag=9&q=uer6u0&endTime=2025-11-12 15:24:04
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:34",
      "lastTime": "2025-11-12 15:29:34",
      "id": "104",
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "priority": 369,
      "delFlag": 9,
      "description": "tqr0un"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/righttype/export.do --data 'delFlag=9&startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&page=1&q=7hzj8k&limit=10&orderBy=810&description=4namok&sname=chung.hoeger&name=chung.hoeger'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "nallms",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:34",
    "lastTime": "2025-11-12 15:29:34",
    "id": "104",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "priority": 200,
    "delFlag": 9,
    "description": "gkueie"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:34",
    "lastTime": "2025-11-12 15:29:34",
    "id": "104",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "priority": 439,
    "delFlag": 9,
    "description": "6rm6bq"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "xwvvzt",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:34",
    "lastTime": "2025-11-12 15:29:34",
    "id": "104",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "priority": 189,
    "delFlag": 9,
    "description": "ycubj1"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "6lq1jy",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "ojs25g",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/template/list.do?id=104&subType=ksgphc&spare1=9keon4&signature=pa1xza&status=542&organId=104&q=9tsfp6&startTime=2025-11-12 15:24:04&appId=104&providerName=chung.hoeger&spare2=m8ss3s&orderBy=65&delFlag=9&creatorId=104&limit=10&content=cf8585&page=1&foreignId=104&name=chung.hoeger&endTime=2025-11-12 15:24:04&providerId=104&type=zidt3a&description=3liku5
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:39",
      "lastTime": "2025-11-12 15:29:39",
      "id": "104",
      "appId": "104",
      "organId": "104",
      "providerId": "104",
      "providerName": "chung.hoeger",
      "foreignId": "104",
      "type": "mgb0dp",
      "subType": "lktxiy",
      "name": "chung.hoeger",
      "signature": "ki8xnf",
      "content": "2grnx9",
      "priority": 292,
      "status": 439,
      "delFlag": 9,
      "description": "6bq9zi",
      "spare1": "6ngpde",
      "spare2": "4b6zym"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:39",
    "lastTime": "2025-11-12 15:29:39",
    "id": "104",
    "appId": "104",
    "organId": "104",
    "providerId": "104",
    "providerName": "chung.hoeger",
    "foreignId": "104",
    "type": "0h253o",
    "subType": "np2a6f",
    "name": "chung.hoeger",
    "signature": "8whp24",
    "content": "2wesl5",
    "priority": 703,
    "status": 85,
    "delFlag": 9,
    "description": "cfpv0t",
    "spare1": "pw2ng7",
    "spare2": "lt9r0s"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:39",
    "lastTime": "2025-11-12 15:29:39",
    "id": "104",
    "appId": "104",
    "organId": "104",
    "providerId": "104",
    "providerName": "chung.hoeger",
    "foreignId": "104",
    "type": "nzaogj",
    "subType": "us32rc",
    "name": "chung.hoeger",
    "signature": "rbuu1j",
    "content": "d0ag5g",
    "priority": 219,
    "status": 601,
    "delFlag": 9,
    "description": "6u49ak",
    "spare1": "hdm4qs",
    "spare2": "kmey5h"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "6mp6tg",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:40",
    "lastTime": "2025-11-12 15:29:40",
    "id": "104",
    "appId": "104",
    "organId": "104",
    "providerId": "104",
    "providerName": "chung.hoeger",
    "foreignId": "104",
    "type": "jk0yqy",
    "subType": "vngey3",
    "name": "chung.hoeger",
    "signature": "3uizu6",
    "content": "m0r0l4",
    "priority": 989,
    "status": 906,
    "delFlag": 9,
    "description": "uq059a",
    "spare1": "i3affv",
    "spare2": "2xwkm7"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "cg5hch",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "rl3ak7",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/list.do?spare1=5v8eoi&spare2=1gaop9&creatorId=104&limit=10&msgId=194&msgModuleName=chung.hoeger&opUserId=104&appId=104&opTime=2025-11-12 15:29:38&msgCreateTime=2025-11-12 15:29:38&msgType=519&msgAbstract=356yps&msgAccountId=104&type=g9dxqe&id=104&endTime=2025-11-12 15:24:04&status=8nmwlt&msgOrganName=chung.hoeger&msgTitle=9ctm9b&msgUserName=chung.hoeger&foreignId=104&msgModuleId=104&msgOrganId=104&msgAccountName=chung.hoeger&msgContent=tfq8l0&bizType=smlysz&q=s0frtk&msgUrl=www.winston-nienow.name&opOrganId=104&page=1&description=mg7v9k&msgLabels=iyoow2&opOrganName=chung.hoeger&startTime=2025-11-12 15:24:04&orderBy=661&msgUserId=104
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:38",
      "lastTime": "2025-11-12 15:29:38",
      "id": "104",
      "appId": "104",
      "foreignId": "104",
      "type": "du6h12",
      "bizType": "eycnaw",
      "msgCreateTime": "2025-11-12 15:29:38",
      "msgId": 265,
      "msgType": 402,
      "msgTitle": "k00hdk",
      "msgAbstract": "tf6f3v",
      "msgAccountId": "104",
      "msgAccountName": "chung.hoeger",
      "msgModuleId": "104",
      "msgModuleName": "chung.hoeger",
      "msgUserId": "104",
      "msgUserName": "chung.hoeger",
      "msgOrganId": "104",
      "msgOrganName": "chung.hoeger",
      "msgUrl": "www.winston-nienow.name",
      "msgLabels": "nljhhz",
      "msgContent": "au4lf7",
      "status": "x0r73r",
      "opUserId": "104",
      "opTime": "2025-11-12 15:29:38",
      "opOrganId": "104",
      "opOrganName": "chung.hoeger",
      "description": "1rhp04",
      "spare1": "py4t50",
      "spare2": "xcmwg0"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/export.do --data 'msgModuleName=chung.hoeger&msgType=662&status=roygsi&opUserId=104&spare2=935nx4&msgContent=6hq2tx&msgOrganId=104&opOrganName=chung.hoeger&msgAccountName=chung.hoeger&msgAbstract=ezuy8i&limit=10&q=8684h8&msgId=934&id=104&orderBy=144&msgAccountId=104&opTime=2025-11-12 15:29:38&appId=104&msgUserId=104&startTime=2025-11-12 15:24:04&foreignId=104&msgTitle=2k9ksx&page=1&msgUserName=chung.hoeger&endTime=2025-11-12 15:24:04&type=ne66a8&msgModuleId=104&msgUrl=www.winston-nienow.name&spare1=aho5ut&creatorId=104&opOrganId=104&bizType=sq0j7m&msgLabels=1j616h&msgCreateTime=2025-11-12 15:29:38&msgOrganName=chung.hoeger&description=83pzzh'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "wpw269",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:38",
    "lastTime": "2025-11-12 15:29:38",
    "id": "104",
    "appId": "104",
    "foreignId": "104",
    "type": "xbwqo3",
    "bizType": "dvv2tn",
    "msgCreateTime": "2025-11-12 15:29:38",
    "msgId": 473,
    "msgType": 737,
    "msgTitle": "8jweng",
    "msgAbstract": "yf7468",
    "msgAccountId": "104",
    "msgAccountName": "chung.hoeger",
    "msgModuleId": "104",
    "msgModuleName": "chung.hoeger",
    "msgUserId": "104",
    "msgUserName": "chung.hoeger",
    "msgOrganId": "104",
    "msgOrganName": "chung.hoeger",
    "msgUrl": "www.winston-nienow.name",
    "msgLabels": "25hz8t",
    "msgContent": "c3hjdm",
    "status": "9cedi9",
    "opUserId": "104",
    "opTime": "2025-11-12 15:29:38",
    "opOrganId": "104",
    "opOrganName": "chung.hoeger",
    "description": "m425qc",
    "spare1": "0vqbc0",
    "spare2": "207npc"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:39",
    "lastTime": "2025-11-12 15:29:39",
    "id": "104",
    "appId": "104",
    "foreignId": "104",
    "type": "jriy1o",
    "bizType": "p3ato5",
    "msgCreateTime": "2025-11-12 15:29:39",
    "msgId": 258,
    "msgType": 260,
    "msgTitle": "eqcdfh",
    "msgAbstract": "ajgvfb",
    "msgAccountId": "104",
    "msgAccountName": "chung.hoeger",
    "msgModuleId": "104",
    "msgModuleName": "chung.hoeger",
    "msgUserId": "104",
    "msgUserName": "chung.hoeger",
    "msgOrganId": "104",
    "msgOrganName": "chung.hoeger",
    "msgUrl": "www.winston-nienow.name",
    "msgLabels": "khei5n",
    "msgContent": "epmlug",
    "status": "3jyjfa",
    "opUserId": "104",
    "opTime": "2025-11-12 15:29:39",
    "opOrganId": "104",
    "opOrganName": "chung.hoeger",
    "description": "izbytq",
    "spare1": "jzkoeh",
    "spare2": "v7nctm"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "it9421",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:39",
    "lastTime": "2025-11-12 15:29:39",
    "id": "104",
    "appId": "104",
    "foreignId": "104",
    "type": "mh6cg0",
    "bizType": "inorrz",
    "msgCreateTime": "2025-11-12 15:29:39",
    "msgId": 9,
    "msgType": 540,
    "msgTitle": "iu1ue7",
    "msgAbstract": "cbq4x8",
    "msgAccountId": "104",
    "msgAccountName": "chung.hoeger",
    "msgModuleId": "104",
    "msgModuleName": "chung.hoeger",
    "msgUserId": "104",
    "msgUserName": "chung.hoeger",
    "msgOrganId": "104",
    "msgOrganName": "chung.hoeger",
    "msgUrl": "www.winston-nienow.name",
    "msgLabels": "4fnowo",
    "msgContent": "p4tbnv",
    "status": "47hlra",
    "opUserId": "104",
    "opTime": "2025-11-12 15:29:39",
    "opOrganId": "104",
    "opOrganName": "chung.hoeger",
    "description": "qxh07u",
    "spare1": "5fwdtx",
    "spare2": "qqce88"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "i1hp6w",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "g36at1",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/message/read/lc1scm.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "4bqh8u",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/list.do?q=cvdzkk&areaId=17&limit=10&type=v7i0yh&syncMode=go5c08&positionId=104&startTime=2025-11-12 15:24:04&groupId=489&batchId=104&orderBy=879&endTime=2025-11-12 15:24:04&status=396&organId=104&keyWords=6cci41&page=1&appId=104
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
    "totalCount": 585,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:29",
        "lastTime": "2025-11-12 15:29:29",
        "id": 549,
        "appId": "104",
        "saveSource": "yproad",
        "unitName": "chung.hoeger",
        "name": "chung.hoeger",
        "idNum": "89noe9",
        "duty": "ymjz3p",
        "telephone": "1-641-218-8251",
        "mobile": "(567) 281-2291",
        "extInfo1": "967vv4",
        "extInfo2": "njw67u",
        "extInfo3": "nqaubw",
        "needInitUser": true,
        "userId": "104",
        "needInitOrgan": true,
        "organId": "104",
        "type": "x1v1zg",
        "foreignUrl": "www.winston-nienow.name",
        "bizType": 341,
        "bizOrganId": "104",
        "bizAreaId": 137,
        "bizGroupId": 643,
        "bizPower": "rzjzqn",
        "bizMultiInfo": "p0zspu",
        "needSetOrgan": true,
        "needSetArea": true,
        "needSetGroup": true,
        "needSetPower": true,
        "opUserId": "104",
        "opOrganId": "104",
        "opTime": "2025-11-12 15:29:29",
        "opInfo": "zx7qzz",
        "priority": 6,
        "status": 385,
        "delFlag": 9,
        "dataBatch": "7dlhif",
        "dataVersion": 347,
        "updateTime": "2025-11-12 15:29:29",
        "syncMode": "mpa6ta",
        "syncTime": "2025-11-12 15:29:29",
        "description": "c9rtuz",
        "groupName": "chung.hoeger",
        "positionName": "chung.hoeger",
        "bizPowerName": "chung.hoeger",
        "subdistrictName": "chung.hoeger",
        "communityName": "chung.hoeger"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
syncMode|string|角色类型，R31 WEB，R32移动<br>对应字段：SYNC_MODE|false|-
groupId|int64|组id|false|-
positionId|string|岗位id|false|-
organId|string|机构id|false|-
areaId|int64|区域id|false|-
batchId|string|批次id|false|-
keyWords|string|关键字|false|-

**Request-example:**
```
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/export.do --data 'page=1&appId=104&batchId=104&type=zfcecv&areaId=384&orderBy=221&positionId=104&status=17&q=8bvplt&groupId=73&syncMode=th3myk&startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&limit=10&organId=104&keyWords=jbjeev'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "jmsk1c",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/preset/74.do
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:30",
    "lastTime": "2025-11-12 15:29:30",
    "id": 913,
    "appId": "104",
    "saveSource": "1h9etg",
    "unitName": "chung.hoeger",
    "name": "chung.hoeger",
    "idNum": "hwc5nd",
    "duty": "liydue",
    "telephone": "1-641-218-8251",
    "mobile": "(567) 281-2291",
    "extInfo1": "dlvvbq",
    "extInfo2": "m5qeqf",
    "extInfo3": "19qkyy",
    "needInitUser": true,
    "userId": "104",
    "needInitOrgan": true,
    "organId": "104",
    "type": "alr86u",
    "foreignUrl": "www.winston-nienow.name",
    "bizType": 294,
    "bizOrganId": "104",
    "bizAreaId": 974,
    "bizGroupId": 786,
    "bizPower": "yvswrd",
    "bizMultiInfo": "gjno9c",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "104",
    "opOrganId": "104",
    "opTime": "2025-11-12 15:29:30",
    "opInfo": "if80tl",
    "priority": 292,
    "status": 460,
    "delFlag": 9,
    "dataBatch": "pi3alc",
    "dataVersion": 905,
    "updateTime": "2025-11-12 15:29:30",
    "syncMode": "ys6xu7",
    "syncTime": "2025-11-12 15:29:30",
    "description": "crm7ib",
    "groupName": "chung.hoeger",
    "positionName": "chung.hoeger",
    "bizPowerName": "chung.hoeger",
    "subdistrictName": "chung.hoeger",
    "communityName": "chung.hoeger"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:30",
    "lastTime": "2025-11-12 15:29:30",
    "id": 989,
    "appId": "104",
    "saveSource": "cn7a35",
    "unitName": "chung.hoeger",
    "name": "chung.hoeger",
    "idNum": "jrrkeg",
    "duty": "pgn60d",
    "telephone": "1-641-218-8251",
    "mobile": "(567) 281-2291",
    "extInfo1": "zj5jaq",
    "extInfo2": "ai4l6g",
    "extInfo3": "5s2u4v",
    "needInitUser": true,
    "userId": "104",
    "needInitOrgan": true,
    "organId": "104",
    "type": "65ot6z",
    "foreignUrl": "www.winston-nienow.name",
    "bizType": 6,
    "bizOrganId": "104",
    "bizAreaId": 491,
    "bizGroupId": 717,
    "bizPower": "l9eai9",
    "bizMultiInfo": "wkxzv5",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "104",
    "opOrganId": "104",
    "opTime": "2025-11-12 15:29:30",
    "opInfo": "fbmfcl",
    "priority": 639,
    "status": 128,
    "delFlag": 9,
    "dataBatch": "wqn6f2",
    "dataVersion": 689,
    "updateTime": "2025-11-12 15:29:30",
    "syncMode": "ti7vcy",
    "syncTime": "2025-11-12 15:29:30",
    "description": "jsoi3t"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "9egqns",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:30",
    "lastTime": "2025-11-12 15:29:30",
    "id": 893,
    "appId": "104",
    "saveSource": "fxxfdk",
    "unitName": "chung.hoeger",
    "name": "chung.hoeger",
    "idNum": "ur811q",
    "duty": "6o81m7",
    "telephone": "1-641-218-8251",
    "mobile": "(567) 281-2291",
    "extInfo1": "hrftdy",
    "extInfo2": "9tzj6s",
    "extInfo3": "k9e56n",
    "needInitUser": true,
    "userId": "104",
    "needInitOrgan": true,
    "organId": "104",
    "type": "xmb4zp",
    "foreignUrl": "www.winston-nienow.name",
    "bizType": 43,
    "bizOrganId": "104",
    "bizAreaId": 69,
    "bizGroupId": 412,
    "bizPower": "7w9361",
    "bizMultiInfo": "ubprys",
    "needSetOrgan": true,
    "needSetArea": true,
    "needSetGroup": true,
    "needSetPower": true,
    "opUserId": "104",
    "opOrganId": "104",
    "opTime": "2025-11-12 15:29:30",
    "opInfo": "cokx98",
    "priority": 174,
    "status": 496,
    "delFlag": 9,
    "dataBatch": "2pra3j",
    "dataVersion": 833,
    "updateTime": "2025-11-12 15:29:30",
    "syncMode": "rggno8",
    "syncTime": "2025-11-12 15:29:30",
    "description": "q4vk4l"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "1qiksk",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "syepwe",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "vw8og6",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "username": "chung.hoeger",
    "password": "j8skrd",
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8",
    "appId": "104"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "vp09aw",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/list.do?orderBy=797&msg=50hyez&ipaddr=esr11g&startTime=2025-11-12 15:24:04&browser=2v954m&q=dwzc71&page=1&os=v4j58t&infoId=71&endTime=2025-11-12 15:24:04&limit=10&status=oq6f6r&username=chung.hoeger&loginTime=2025-11-12 15:29:31
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
    "totalCount": 529,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "infoId": 869,
        "username": "chung.hoeger",
        "status": "mu02o5",
        "ipaddr": "f9a36e",
        "loginLocation": "ega78t",
        "browser": "tuzsm2",
        "os": "c1oo4n",
        "msg": "mvjj4i",
        "loginTime": "2025-11-12 15:29:31",
        "remark": "2onlyx"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/export.do --data 'endTime=2025-11-12 15:24:04&orderBy=416&loginTime=2025-11-12 15:29:31&os=lkf5ej&startTime=2025-11-12 15:24:04&username=chung.hoeger&browser=cxmotw&q=qvjups&page=1&limit=10&infoId=972&status=4jqoj7&ipaddr=npoz1z&msg=iuq4nc'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ow22dr",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "by9zuv",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "0tubpi",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/loginlog/unlock/chung.hoeger.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "l4j0lc",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/list.do?nickName=deon.watsica&limit=10&endTime=2025-11-12 15:24:04&deptId=237&delFlag=9&organId=104&orderBy=622&adminId=489&startTime=2025-11-12 15:24:04&email=antone.stark@hotmail.com&username=chung.hoeger&page=1&status=4b34eq&userId=104&mobile=(567) 281-2291&q=ghmxjm
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:25",
      "lastTime": "2025-11-12 15:29:25",
      "id": 895,
      "userId": "104",
      "deptId": 737,
      "deptName": "chung.hoeger",
      "organId": "104",
      "organName": "chung.hoeger",
      "name": "chung.hoeger",
      "username": "chung.hoeger",
      "nickName": "deon.watsica",
      "email": "antone.stark@hotmail.com",
      "mobile": "(567) 281-2291",
      "imagePath": "enoq2w",
      "password": "rhf3o5",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 22,
      "delFlag": 9,
      "lastLoginIp": "239.116.167.16",
      "lastLoginTime": "2025-11-12 15:29:25",
      "description": "ieveyp",
      "dept": {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:25",
        "lastTime": "2025-11-12 15:29:25",
        "id": 4,
        "organId": "104",
        "parentId": 643,
        "appId": "104",
        "depttypeId": 422,
        "foreignId": "104",
        "createType": 436,
        "type": "gfgygd",
        "name": "chung.hoeger",
        "sname": "chung.hoeger",
        "areaCode": "74128",
        "organLeader": "p9ldnx",
        "leaderId": "104",
        "leaderMobile": "(567) 281-2291",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "74128",
        "imagePath": "hrr53n",
        "priority": 130,
        "status": 973,
        "delFlag": 9,
        "description": "axfiat",
        "spare1": "4npmwy",
        "spare2": "iukyrn",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "104",
          "createTime": "2025-11-12 15:29:25",
          "lastTime": "2025-11-12 15:29:25",
          "id": 390,
          "roletypeId": "104",
          "appId": "104",
          "name": "chung.hoeger",
          "code": "74128",
          "priority": 779,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 64,
          "description": "htt2ws",
          "areaType": "13trok"
        }
      ],
      "roleIds": [
        328
      ],
      "positionIds": [
        "0smzq2"
      ],
      "roleId": 991,
      "userRoleList": [
        {
          "id": 667,
          "deptId": 42,
          "deptName": "chung.hoeger",
          "organId": "104",
          "organName": "chung.hoeger",
          "roleId": 17,
          "roleName": "chung.hoeger",
          "adminId": 628
        }
      ],
      "code": "74128",
      "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/[user/288].do
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:26",
      "lastTime": "2025-11-12 15:29:26",
      "id": 805,
      "userId": "104",
      "deptId": 921,
      "deptName": "chung.hoeger",
      "organId": "104",
      "organName": "chung.hoeger",
      "name": "chung.hoeger",
      "username": "chung.hoeger",
      "nickName": "deon.watsica",
      "email": "antone.stark@hotmail.com",
      "mobile": "(567) 281-2291",
      "imagePath": "rc065w",
      "password": "w34k5a",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 433,
      "delFlag": 9,
      "lastLoginIp": "239.116.167.16",
      "lastLoginTime": "2025-11-12 15:29:26",
      "description": "3l5tm1",
      "dept": {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:26",
        "lastTime": "2025-11-12 15:29:26",
        "id": 892,
        "organId": "104",
        "parentId": 382,
        "appId": "104",
        "depttypeId": 68,
        "foreignId": "104",
        "createType": 440,
        "type": "nty494",
        "name": "chung.hoeger",
        "sname": "chung.hoeger",
        "areaCode": "74128",
        "organLeader": "j39lly",
        "leaderId": "104",
        "leaderMobile": "(567) 281-2291",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "74128",
        "imagePath": "otaevf",
        "priority": 136,
        "status": 285,
        "delFlag": 9,
        "description": "hient4",
        "spare1": "infhvw",
        "spare2": "62e3sh",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "104",
          "createTime": "2025-11-12 15:29:26",
          "lastTime": "2025-11-12 15:29:26",
          "id": 577,
          "roletypeId": "104",
          "appId": "104",
          "name": "chung.hoeger",
          "code": "74128",
          "priority": 106,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 661,
          "description": "55m5of",
          "areaType": "j3h98u"
        }
      ],
      "roleIds": [
        324
      ],
      "positionIds": [
        "90rfl2"
      ],
      "roleId": 227,
      "userRoleList": [
        {
          "id": 629,
          "deptId": 731,
          "deptName": "chung.hoeger",
          "organId": "104",
          "organName": "chung.hoeger",
          "roleId": 115,
          "roleName": "chung.hoeger",
          "adminId": 78
        }
      ],
      "code": "74128",
      "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
    },
    "roles": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:26",
        "lastTime": "2025-11-12 15:29:26",
        "roleId": 197,
        "roleName": "chung.hoeger",
        "roleKey": "5ztsla",
        "roleSort": 463,
        "menuCheckStrictly": true,
        "deptCheckStrictly": true,
        "status": 698,
        "flag": true,
        "menuIds": [
          280
        ],
        "deptIds": [
          374
        ],
        "permissions": [
          "w27rk3"
        ],
        "remark": "s8rdfg",
        "parentName": "chung.hoeger",
        "appName": "chung.hoeger",
        "roletypeId": "104",
        "roletypeName": "chung.hoeger",
        "priority": 940,
        "isSuper": true
      }
    ],
    "roleList": [
      {
        "id": 220,
        "roleId": 534,
        "adminId": 286,
        "deptId": 64,
        "deptName": "chung.hoeger",
        "organId": "104",
        "organName": "chung.hoeger",
        "roleName": "chung.hoeger"
      }
    ],
    "positions": [
      {
        "postId": "104",
        "postCode": "74128",
        "postName": "chung.hoeger",
        "postSort": 224,
        "status": 665,
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:26",
        "lastTime": "2025-11-12 15:29:26",
        "delFlag": 9,
        "remark": "n1jeku",
        "ids": [
          "9wqnpy"
        ],
        "positionId": "104",
        "flag": true
      }
    ],
    "roleIds": [
      297
    ],
    "positionIds": [
      "l81ka9"
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/deptTree.do?imagePath=ror2i6&description=dnf2sw&spare2=sz6jsd&isLeaf=true&searchCode=74128&parentId=661&startTime=2025-11-12 15:24:04&appId=104&limit=10&name=chung.hoeger&isOrganLevel=true&orderBy=801&page=1&creatorId=104&sname=chung.hoeger&areaCode=74128&organId=104&status=792&deptId=625&organLeader=xpow39&q=5rq281&isDisabled=true&leaderMobile=(567) 281-2291&delFlag=9&type=l26aj9&leaderId=104&spare1=im7icq&depttypeId=208&createType=737&isVirtual=true&endTime=2025-11-12 15:24:04&foreignId=104
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
      "id": 627,
      "label": "3druue",
      "children": [
        {
          "$ref": ".."
        }
      ]
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:26",
    "lastTime": "2025-11-12 15:29:26",
    "id": 940,
    "userId": "104",
    "deptId": 307,
    "deptName": "chung.hoeger",
    "organId": "104",
    "organName": "chung.hoeger",
    "name": "chung.hoeger",
    "username": "chung.hoeger",
    "nickName": "deon.watsica",
    "email": "antone.stark@hotmail.com",
    "mobile": "(567) 281-2291",
    "imagePath": "knq3q9",
    "password": "k9m0ho",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 155,
    "delFlag": 9,
    "lastLoginIp": "239.116.167.16",
    "lastLoginTime": "2025-11-12 15:29:26",
    "description": "lsego7",
    "dept": {
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:26",
      "lastTime": "2025-11-12 15:29:26",
      "id": 547,
      "organId": "104",
      "parentId": 240,
      "appId": "104",
      "depttypeId": 917,
      "foreignId": "104",
      "createType": 482,
      "type": "an4vkc",
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "areaCode": "74128",
      "organLeader": "qbwy22",
      "leaderId": "104",
      "leaderMobile": "(567) 281-2291",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "74128",
      "imagePath": "mnly4w",
      "priority": 141,
      "status": 726,
      "delFlag": 9,
      "description": "r0ef4a",
      "spare1": "tp8ow3",
      "spare2": "zgpa0w",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:26",
        "lastTime": "2025-11-12 15:29:26",
        "id": 436,
        "roletypeId": "104",
        "appId": "104",
        "name": "chung.hoeger",
        "code": "74128",
        "priority": 353,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 544,
        "description": "9xn4z5",
        "areaType": "vlhbl2"
      }
    ],
    "roleIds": [
      118
    ],
    "positionIds": [
      "pkinr6"
    ],
    "roleId": 407,
    "userRoleList": [
      {
        "id": 933,
        "deptId": 934,
        "deptName": "chung.hoeger",
        "organId": "104",
        "organName": "chung.hoeger",
        "roleId": 617,
        "roleName": "chung.hoeger",
        "adminId": 548
      }
    ],
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "hxcc54",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:26",
    "lastTime": "2025-11-12 15:29:26",
    "id": 799,
    "userId": "104",
    "deptId": 372,
    "deptName": "chung.hoeger",
    "organId": "104",
    "organName": "chung.hoeger",
    "name": "chung.hoeger",
    "username": "chung.hoeger",
    "nickName": "deon.watsica",
    "email": "antone.stark@hotmail.com",
    "mobile": "(567) 281-2291",
    "imagePath": "hliu0u",
    "password": "58tgcc",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 784,
    "delFlag": 9,
    "lastLoginIp": "239.116.167.16",
    "lastLoginTime": "2025-11-12 15:29:26",
    "description": "ba7eqi",
    "dept": {
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:26",
      "lastTime": "2025-11-12 15:29:26",
      "id": 911,
      "organId": "104",
      "parentId": 327,
      "appId": "104",
      "depttypeId": 123,
      "foreignId": "104",
      "createType": 323,
      "type": "obw5rd",
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "areaCode": "74128",
      "organLeader": "qppn64",
      "leaderId": "104",
      "leaderMobile": "(567) 281-2291",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "74128",
      "imagePath": "k1m9vp",
      "priority": 616,
      "status": 911,
      "delFlag": 9,
      "description": "8jcgif",
      "spare1": "xafh5n",
      "spare2": "6zjdp8",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:26",
        "lastTime": "2025-11-12 15:29:26",
        "id": 755,
        "roletypeId": "104",
        "appId": "104",
        "name": "chung.hoeger",
        "code": "74128",
        "priority": 307,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 560,
        "description": "0wns7v",
        "areaType": "ed5i5y"
      }
    ],
    "roleIds": [
      414
    ],
    "positionIds": [
      "qnbqn5"
    ],
    "roleId": 884,
    "userRoleList": [
      {
        "id": 395,
        "deptId": 857,
        "deptName": "chung.hoeger",
        "organId": "104",
        "organName": "chung.hoeger",
        "roleId": 757,
        "roleName": "chung.hoeger",
        "adminId": 397
      }
    ],
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "a7pvea",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:26",
    "lastTime": "2025-11-12 15:29:26",
    "id": 662,
    "userId": "104",
    "organId": "104",
    "deptId": 416,
    "createType": 194,
    "name": "chung.hoeger",
    "username": "chung.hoeger",
    "mobile": "(567) 281-2291",
    "email": "antone.stark@hotmail.com",
    "password": "088ve6",
    "salt": "pw7gz3",
    "imagePath": "0ui4px",
    "adminType": "gxq73w",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "adminRange": "bvzsjs",
    "adminPerms": "nz62ch",
    "lastAppId": "104",
    "lastLoginTime": "2025-11-12 15:29:26",
    "lastLoginIp": "239.116.167.16",
    "loginCount": 204,
    "status": 59,
    "delFlag": 9,
    "spare1": "ttceb3",
    "spare2": "tkpa7o",
    "roleIds": [
      623
    ],
    "positionIds": [
      "7nyl6o"
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
  "data": "ll79hs",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:26",
    "lastTime": "2025-11-12 15:29:26",
    "id": 884,
    "userId": "104",
    "deptId": 9,
    "deptName": "chung.hoeger",
    "organId": "104",
    "organName": "chung.hoeger",
    "name": "chung.hoeger",
    "username": "chung.hoeger",
    "nickName": "deon.watsica",
    "email": "antone.stark@hotmail.com",
    "mobile": "(567) 281-2291",
    "imagePath": "e9sfka",
    "password": "xim9yg",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 973,
    "delFlag": 9,
    "lastLoginIp": "239.116.167.16",
    "lastLoginTime": "2025-11-12 15:29:26",
    "description": "10yejm",
    "dept": {
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:26",
      "lastTime": "2025-11-12 15:29:26",
      "id": 933,
      "organId": "104",
      "parentId": 525,
      "appId": "104",
      "depttypeId": 894,
      "foreignId": "104",
      "createType": 852,
      "type": "5d2gs6",
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "areaCode": "74128",
      "organLeader": "ypdr6a",
      "leaderId": "104",
      "leaderMobile": "(567) 281-2291",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "74128",
      "imagePath": "f2oe56",
      "priority": 649,
      "status": 514,
      "delFlag": 9,
      "description": "8qnymp",
      "spare1": "vky6vp",
      "spare2": "bci5jt",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:26",
        "lastTime": "2025-11-12 15:29:26",
        "id": 472,
        "roletypeId": "104",
        "appId": "104",
        "name": "chung.hoeger",
        "code": "74128",
        "priority": 14,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 82,
        "description": "9xyamw",
        "areaType": "c46sqp"
      }
    ],
    "roleIds": [
      712
    ],
    "positionIds": [
      "obzyer"
    ],
    "roleId": 500,
    "userRoleList": [
      {
        "id": 219,
        "deptId": 592,
        "deptName": "chung.hoeger",
        "organId": "104",
        "organName": "chung.hoeger",
        "roleId": 645,
        "roleName": "chung.hoeger",
        "adminId": 718
      }
    ],
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "mnyyck",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "5ghhoh",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/export.do --data 'adminId=883&organId=104&delFlag=9&q=wk1h6g&endTime=2025-11-12 15:24:04&orderBy=568&deptId=92&userId=104&nickName=deon.watsica&status=erqqx0&startTime=2025-11-12 15:24:04&mobile=(567) 281-2291&limit=10&email=antone.stark@hotmail.com&page=1&username=chung.hoeger'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "83pl65",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "ov9qvh",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "whkgyr",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:26",
    "lastTime": "2025-11-12 15:29:26",
    "id": 454,
    "userId": "104",
    "deptId": 979,
    "deptName": "chung.hoeger",
    "organId": "104",
    "organName": "chung.hoeger",
    "name": "chung.hoeger",
    "username": "chung.hoeger",
    "nickName": "deon.watsica",
    "email": "antone.stark@hotmail.com",
    "mobile": "(567) 281-2291",
    "imagePath": "ttnjtg",
    "password": "lhip5z",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 692,
    "delFlag": 9,
    "lastLoginIp": "239.116.167.16",
    "lastLoginTime": "2025-11-12 15:29:26",
    "description": "85yfkw",
    "dept": {
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:26",
      "lastTime": "2025-11-12 15:29:26",
      "id": 214,
      "organId": "104",
      "parentId": 128,
      "appId": "104",
      "depttypeId": 959,
      "foreignId": "104",
      "createType": 641,
      "type": "ye9qeh",
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "areaCode": "74128",
      "organLeader": "we6ucq",
      "leaderId": "104",
      "leaderMobile": "(567) 281-2291",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "74128",
      "imagePath": "q4c77m",
      "priority": 499,
      "status": 48,
      "delFlag": 9,
      "description": "4wgshb",
      "spare1": "rsftu1",
      "spare2": "usaqc9",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:26",
        "lastTime": "2025-11-12 15:29:26",
        "id": 386,
        "roletypeId": "104",
        "appId": "104",
        "name": "chung.hoeger",
        "code": "74128",
        "priority": 99,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 385,
        "description": "5pcm8v",
        "areaType": "j2a8im"
      }
    ],
    "roleIds": [
      345
    ],
    "positionIds": [
      "uyymid"
    ],
    "roleId": 759,
    "userRoleList": [
      {
        "id": 389,
        "deptId": 845,
        "deptName": "chung.hoeger",
        "organId": "104",
        "organName": "chung.hoeger",
        "roleId": 805,
        "roleName": "chung.hoeger",
        "adminId": 35
      }
    ],
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "fder97",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:26",
    "lastTime": "2025-11-12 15:29:26",
    "id": 470,
    "userId": "104",
    "deptId": 509,
    "deptName": "chung.hoeger",
    "organId": "104",
    "organName": "chung.hoeger",
    "name": "chung.hoeger",
    "username": "chung.hoeger",
    "nickName": "deon.watsica",
    "email": "antone.stark@hotmail.com",
    "mobile": "(567) 281-2291",
    "imagePath": "q2n072",
    "password": "ybwg01",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 98,
    "delFlag": 9,
    "lastLoginIp": "239.116.167.16",
    "lastLoginTime": "2025-11-12 15:29:26",
    "description": "3q0m4u",
    "dept": {
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:26",
      "lastTime": "2025-11-12 15:29:26",
      "id": 494,
      "organId": "104",
      "parentId": 565,
      "appId": "104",
      "depttypeId": 120,
      "foreignId": "104",
      "createType": 540,
      "type": "vxfmpe",
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "areaCode": "74128",
      "organLeader": "tsubkn",
      "leaderId": "104",
      "leaderMobile": "(567) 281-2291",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "74128",
      "imagePath": "ojobhw",
      "priority": 817,
      "status": 271,
      "delFlag": 9,
      "description": "yww3be",
      "spare1": "vy4rnk",
      "spare2": "3oyk0f",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:26",
        "lastTime": "2025-11-12 15:29:26",
        "id": 694,
        "roletypeId": "104",
        "appId": "104",
        "name": "chung.hoeger",
        "code": "74128",
        "priority": 849,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 672,
        "description": "6twgtl",
        "areaType": "gxezhs"
      }
    ],
    "roleIds": [
      933
    ],
    "positionIds": [
      "tsdcwe"
    ],
    "roleId": 787,
    "userRoleList": [
      {
        "id": 953,
        "deptId": 630,
        "deptName": "chung.hoeger",
        "organId": "104",
        "organName": "chung.hoeger",
        "roleId": 830,
        "roleName": "chung.hoeger",
        "adminId": 323
      }
    ],
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "nfa7xk",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole/617.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "0uxn2j",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/authRole.do --data 'adminId=853&roleIds=1g2joo&roleIds=1g2joo'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "gj4xc6",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
└─user|object|当前用户|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─password|string|密码|-
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─username|string|用户名|-
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
  "code": "0",
  "msg": "正常",
  "data": {
    "user": {
      "password": "dmkbvp",
      "username": "chung.hoeger",
      "authorities": [
        {
          "object": "any object"
        }
      ],
      "userId": "104",
      "userLid": 400,
      "appId": "104",
      "deptId": 349,
      "organId": "104",
      "token": "ieware",
      "viewName": "chung.hoeger",
      "needChangePassword": true,
      "email": "antone.stark@hotmail.com",
      "mobile": "(567) 281-2291",
      "imagePath": "7lb6bd",
      "loginCount": 290,
      "loginIp": "239.116.167.16",
      "lastUpdatePasswordTime": "2025-11-12 15:29:27",
      "lastTime": "2025-11-12 15:29:27",
      "foreignId": "104",
      "expireTime": "2025-11-12 15:29:27",
      "loginTime": "2025-11-12 15:29:27",
      "userType": "58cv4l",
      "isSuperAdmin": true,
      "loginBrowse": "sim8vz",
      "loginOs": "7kktjd",
      "perms": [
        "yndr25"
      ]
    },
    "roleGroup": "ee1fh0",
    "positionGroup": "d508dv"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:27",
    "lastTime": "2025-11-12 15:29:27",
    "id": 319,
    "userId": "104",
    "deptId": 486,
    "deptName": "chung.hoeger",
    "organId": "104",
    "organName": "chung.hoeger",
    "name": "chung.hoeger",
    "username": "chung.hoeger",
    "nickName": "deon.watsica",
    "email": "antone.stark@hotmail.com",
    "mobile": "(567) 281-2291",
    "imagePath": "qe6xl0",
    "password": "3ed7c4",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 371,
    "delFlag": 9,
    "lastLoginIp": "239.116.167.16",
    "lastLoginTime": "2025-11-12 15:29:27",
    "description": "ng948a",
    "dept": {
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:27",
      "lastTime": "2025-11-12 15:29:27",
      "id": 542,
      "organId": "104",
      "parentId": 370,
      "appId": "104",
      "depttypeId": 449,
      "foreignId": "104",
      "createType": 848,
      "type": "pj94s0",
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "areaCode": "74128",
      "organLeader": "v96hjc",
      "leaderId": "104",
      "leaderMobile": "(567) 281-2291",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "74128",
      "imagePath": "fypltr",
      "priority": 268,
      "status": 654,
      "delFlag": 9,
      "description": "59prs1",
      "spare1": "v9onpu",
      "spare2": "t5yw5x",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:27",
        "lastTime": "2025-11-12 15:29:27",
        "id": 702,
        "roletypeId": "104",
        "appId": "104",
        "name": "chung.hoeger",
        "code": "74128",
        "priority": 929,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 421,
        "description": "312ow9",
        "areaType": "mr1x9v"
      }
    ],
    "roleIds": [
      866
    ],
    "positionIds": [
      "sgcakh"
    ],
    "roleId": 280,
    "userRoleList": [
      {
        "id": 867,
        "deptId": 868,
        "deptName": "chung.hoeger",
        "organId": "104",
        "organName": "chung.hoeger",
        "roleId": 863,
        "roleName": "chung.hoeger",
        "adminId": 236
      }
    ],
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:27",
    "lastTime": "2025-11-12 15:29:27",
    "id": 199,
    "userId": "104",
    "deptId": 536,
    "deptName": "chung.hoeger",
    "organId": "104",
    "organName": "chung.hoeger",
    "name": "chung.hoeger",
    "username": "chung.hoeger",
    "nickName": "deon.watsica",
    "email": "antone.stark@hotmail.com",
    "mobile": "(567) 281-2291",
    "imagePath": "2c6vnq",
    "password": "bbjd9g",
    "isSuperAdmin": true,
    "isAuditAdmin": true,
    "isSelfAdmin": true,
    "status": 490,
    "delFlag": 9,
    "lastLoginIp": "239.116.167.16",
    "lastLoginTime": "2025-11-12 15:29:27",
    "description": "xfkuoz",
    "dept": {
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:27",
      "lastTime": "2025-11-12 15:29:27",
      "id": 786,
      "organId": "104",
      "parentId": 842,
      "appId": "104",
      "depttypeId": 52,
      "foreignId": "104",
      "createType": 784,
      "type": "xyk5jz",
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "areaCode": "74128",
      "organLeader": "14d4d3",
      "leaderId": "104",
      "leaderMobile": "(567) 281-2291",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "74128",
      "imagePath": "6ubcia",
      "priority": 876,
      "status": 887,
      "delFlag": 9,
      "description": "485v4v",
      "spare1": "38yyzy",
      "spare2": "5mdonc",
      "children": [
        {
          "$ref": ".."
        }
      ]
    },
    "roles": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:27",
        "lastTime": "2025-11-12 15:29:27",
        "id": 907,
        "roletypeId": "104",
        "appId": "104",
        "name": "chung.hoeger",
        "code": "74128",
        "priority": 460,
        "isRegular": true,
        "isSuper": true,
        "isPublic": true,
        "status": 152,
        "description": "vppohd",
        "areaType": "oc3o30"
      }
    ],
    "roleIds": [
      785
    ],
    "positionIds": [
      "avk1tf"
    ],
    "roleId": 615,
    "userRoleList": [
      {
        "id": 892,
        "deptId": 424,
        "deptName": "chung.hoeger",
        "organId": "104",
        "organName": "chung.hoeger",
        "roleId": 853,
        "roleName": "chung.hoeger",
        "adminId": 821
      }
    ],
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
data|object|请求数据对象，放入RequestBody内|false|-
└─oldPassword|string|旧密码|false|-
└─newPassword|string|新密码|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/user/updatePwd.do --data '{
  "data": {
    "oldPassword": "nkrs0k",
    "newPassword": "rbioj7"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "imageUrl": "www.winston-nienow.name"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/list.do?posRank=523&id=104&positionId=104&posFunction=j8qieu&page=1&mobilePhone=1-641-218-8251&delFlag=9&startTime=2025-11-12 15:24:04&ids=7tnxrg&ids=7tnxrg&oname=chung.hoeger&orderBy=674&status=12&description=31esli&createTime=2025-11-12 15:24:04&roletypeId=104&postypeId=104&endTime=2025-11-12 15:24:04&name=chung.hoeger&sname=chung.hoeger&q=t0m0or&parentId=104&groupId=104&isPub=true&posType=zhi259&officePhone=1-641-218-8251&code=74128&limit=10
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
    "totalCount": 383,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "postId": "104",
        "postCode": "74128",
        "postName": "chung.hoeger",
        "postSort": 760,
        "status": 495,
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:30",
        "lastTime": "2025-11-12 15:29:30",
        "delFlag": 9,
        "remark": "5z8ihg",
        "ids": [
          "35ndfp"
        ],
        "positionId": "104",
        "flag": true
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/export.do --data 'postCode=74128&page=1&postName=chung.hoeger&orderBy=108&startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&limit=10&q=sdhrrs&status=862&delFlag=9'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "j4dcmc",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/position/104.do
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:30",
    "lastTime": "2025-11-12 15:29:30",
    "id": "104",
    "parentId": "104",
    "postypeId": "104",
    "roletypeId": "104",
    "userId": "104",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "code": "74128",
    "oname": "chung.hoeger",
    "posFunction": "tmd65m",
    "posRank": 920,
    "posType": "dxqdsc",
    "editorType": "31pyas",
    "isEditorCreate": true,
    "status": 153,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "104",
    "manageDeptids": "nobq5s",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "1-641-218-8251",
    "officePhone": "1-641-218-8251",
    "buildingId": "104",
    "roomNo": "6eg8nk",
    "extQmType": "f63081",
    "extQmTypePhoto": "0yerbc",
    "extPosName": "chung.hoeger",
    "extOrganName": "chung.hoeger",
    "priority": 757,
    "priorityInOrgan": 865,
    "priorityInDomain": 627,
    "updaterId": "104",
    "updateTime": "2025-11-12 15:29:30",
    "delFlag": 9,
    "description": "lsiao5",
    "remark": "v1glvr"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:30",
    "lastTime": "2025-11-12 15:29:30",
    "id": "104",
    "parentId": "104",
    "postypeId": "104",
    "roletypeId": "104",
    "userId": "104",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "code": "74128",
    "oname": "chung.hoeger",
    "posFunction": "iz8xl5",
    "posRank": 744,
    "posType": "1xywuc",
    "editorType": "yv0n9u",
    "isEditorCreate": true,
    "status": 898,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "104",
    "manageDeptids": "z9payo",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "1-641-218-8251",
    "officePhone": "1-641-218-8251",
    "buildingId": "104",
    "roomNo": "npd63v",
    "extQmType": "1kfh6j",
    "extQmTypePhoto": "uzgsd0",
    "extPosName": "chung.hoeger",
    "extOrganName": "chung.hoeger",
    "priority": 263,
    "priorityInOrgan": 849,
    "priorityInDomain": 647,
    "updaterId": "104",
    "updateTime": "2025-11-12 15:29:30",
    "delFlag": 9,
    "description": "kpl3nq",
    "remark": "u03zlc",
    "parentName": "chung.hoeger",
    "roletypeName": "chung.hoeger",
    "postypeName": "chung.hoeger"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "akjp5u",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:30",
    "lastTime": "2025-11-12 15:29:30",
    "id": "104",
    "parentId": "104",
    "postypeId": "104",
    "roletypeId": "104",
    "userId": "104",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "code": "74128",
    "oname": "chung.hoeger",
    "posFunction": "j96682",
    "posRank": 188,
    "posType": "5f590z",
    "editorType": "wa7h31",
    "isEditorCreate": true,
    "status": 996,
    "isPub": true,
    "isAgent": true,
    "isLeader": true,
    "leaderId": "104",
    "manageDeptids": "km81c4",
    "isBigContact": true,
    "isSmallContact": true,
    "mobilePhone": "1-641-218-8251",
    "officePhone": "1-641-218-8251",
    "buildingId": "104",
    "roomNo": "l36kjl",
    "extQmType": "r5dou9",
    "extQmTypePhoto": "82grgf",
    "extPosName": "chung.hoeger",
    "extOrganName": "chung.hoeger",
    "priority": 245,
    "priorityInOrgan": 335,
    "priorityInDomain": 453,
    "updaterId": "104",
    "updateTime": "2025-11-12 15:29:30",
    "delFlag": 9,
    "description": "1rpq1e",
    "remark": "4lpa29",
    "parentName": "chung.hoeger",
    "roletypeName": "chung.hoeger",
    "postypeName": "chung.hoeger"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "jlsovz",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "6d7zw8",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "postId": "104",
    "postCode": "74128",
    "postName": "chung.hoeger",
    "postSort": 229,
    "status": 370,
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:30",
    "lastTime": "2025-11-12 15:29:30",
    "delFlag": 9,
    "remark": "i4ruvy",
    "ids": [
      "mjoen2"
    ],
    "positionId": "104",
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
  "data": "623vv0",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "id": 598,
    "roleId": 161,
    "positionId": "104",
    "status": 147,
    "beginTime": "2025-11-12",
    "endTime": "2025-11-12"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "otm578",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "postId": "104",
      "postCode": "74128",
      "postName": "chung.hoeger",
      "postSort": 149,
      "status": 463,
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:30",
      "lastTime": "2025-11-12 15:29:30",
      "delFlag": 9,
      "remark": "mu2pp7",
      "ids": [
        "da3djc"
      ],
      "positionId": "104",
      "flag": true
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/list.do?endTime=2025-11-12 15:24:04&startTime=2025-11-12 15:24:04&limit=10&time=1762932244859&srcCode=734&appId=104&operation=fgg76y&userId=104&username=chung.hoeger&method=9ort6d&page=1&createTime=2025-11-12 15:29:31&ip=239.116.167.16&q=pnp35l&category=602&orderBy=595
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
    "totalCount": 905,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "operId": 116,
        "title": "is1pr3",
        "businessType": 767,
        "businessTypeName": "chung.hoeger",
        "businessTypes": [
          288
        ],
        "method": "lhdlfy",
        "requestMethod": "jnjfod",
        "operatorType": 705,
        "operName": "chung.hoeger",
        "deptName": "chung.hoeger",
        "operUrl": "www.winston-nienow.name",
        "operIp": "239.116.167.16",
        "operLocation": "zlhhrg",
        "operParam": "79otyd",
        "jsonResult": "8x4arw",
        "status": 255,
        "errorMsg": "1arzev",
        "operTime": "2025-11-12 15:29:31",
        "costTime": 1762932244859,
        "remark": "12g6z7"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/commlog/export.do --data 'operatorType=521&title=7tuhey&deptName=chung.hoeger&orderBy=399&status=289&endTime=2025-11-12 15:24:04&operName=chung.hoeger&remark=sv3qmx&startTime=2025-11-12 15:24:04&businessType=8&page=1&limit=10&operId=757&operTime=2025-11-12 15:29:31&q=ijrqcd&operIp=239.116.167.16'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "hw1y8r",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "z9qhrn",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/organ/list.do?startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&page=1&organName=chung.hoeger&delFlag=9&organId=104&limit=10&wlType=tn868o&orderBy=4&q=8btrgr
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
        "ipwmpn"
      ],
      "organId": "104",
      "organName": "chung.hoeger",
      "organSName": "chung.hoeger",
      "organCode": "74128",
      "address": "1138 Eboni Meadows， West Aricaside， WY 91270",
      "wlType": "ggurc3",
      "wlTypeName": "chung.hoeger",
      "priority": 753,
      "delFlag": 9,
      "createTime": "2025-11-12 15:29:33",
      "lastTime": "2025-11-12 15:29:33",
      "contactName": "chung.hoeger",
      "contactEmail": "antone.stark@hotmail.com",
      "contactMobile": "(567) 281-2291",
      "description": "9wcybw",
      "tel": "cxsq86"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "f7r4aw"
    ],
    "organId": "104",
    "organName": "chung.hoeger",
    "organSName": "chung.hoeger",
    "organCode": "74128",
    "address": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "wlType": "knjq3e",
    "wlTypeName": "chung.hoeger",
    "priority": 636,
    "delFlag": 9,
    "createTime": "2025-11-12 15:29:33",
    "lastTime": "2025-11-12 15:29:33",
    "contactName": "chung.hoeger",
    "contactEmail": "antone.stark@hotmail.com",
    "contactMobile": "(567) 281-2291",
    "description": "l9is2o",
    "tel": "poch1c"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "3150b3"
    ],
    "organId": "104",
    "organName": "chung.hoeger",
    "organSName": "chung.hoeger",
    "organCode": "74128",
    "address": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "wlType": "rk58zk",
    "wlTypeName": "chung.hoeger",
    "priority": 594,
    "delFlag": 9,
    "createTime": "2025-11-12 15:29:34",
    "lastTime": "2025-11-12 15:29:34",
    "contactName": "chung.hoeger",
    "contactEmail": "antone.stark@hotmail.com",
    "contactMobile": "(567) 281-2291",
    "description": "viqgy5",
    "tel": "rydfpq"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "072z9n",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "v87qa7"
    ],
    "organId": "104",
    "organName": "chung.hoeger",
    "organSName": "chung.hoeger",
    "organCode": "74128",
    "address": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "wlType": "6eoinn",
    "wlTypeName": "chung.hoeger",
    "priority": 863,
    "delFlag": 9,
    "createTime": "2025-11-12 15:29:34",
    "lastTime": "2025-11-12 15:29:34",
    "contactName": "chung.hoeger",
    "contactEmail": "antone.stark@hotmail.com",
    "contactMobile": "(567) 281-2291",
    "description": "gzvora",
    "tel": "2bg32g"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "qgs51x",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "qkwxap",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "4yd29v"
    ],
    "organId": "104",
    "organName": "chung.hoeger",
    "organSName": "chung.hoeger",
    "organCode": "74128",
    "address": "1138 Eboni Meadows， West Aricaside， WY 91270",
    "wlType": "dmk97e",
    "wlTypeName": "chung.hoeger",
    "priority": 477,
    "delFlag": 9,
    "createTime": "2025-11-12 15:29:34",
    "lastTime": "2025-11-12 15:29:34",
    "contactName": "chung.hoeger",
    "contactEmail": "antone.stark@hotmail.com",
    "contactMobile": "(567) 281-2291",
    "description": "zkd90l",
    "tel": "u29cqw"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "2plo2y",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list.do?limit=10&isLeaf=true&name=chung.hoeger&imagePath=nqh5je&isVirtual=true&page=1&organId=104&leaderMobile=(567) 281-2291&creatorId=104&areaCode=74128&sname=chung.hoeger&searchCode=74128&leaderId=104&parentId=615&status=90&endTime=2025-11-12 15:24:04&depttypeId=604&foreignId=104&isDisabled=true&spare2=g8rmla&startTime=2025-11-12 15:24:04&spare1=imvdd5&createType=570&type=1aq2cw&deptId=303&delFlag=9&orderBy=279&description=15ngsd&q=hwhsfq&appId=104&isOrganLevel=true&organLeader=cepzt4
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
    "stackTrace": "8yszgw",
    "pageNum": 503,
    "pageSize": 10,
    "startRow": 692,
    "endRow": 900,
    "total": 191,
    "pages": 404,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "c4raj6",
    "orderBy": "we4fj5",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "0919t1",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/page.do?foreignId=104&appId=104&q=59t6t3&parentId=785&isLeaf=true&imagePath=cm5n1y&endTime=2025-11-12 15:24:04&searchCode=74128&type=eyj1g7&page=1&isOrganLevel=true&description=l0z7xb&areaCode=74128&leaderMobile=(567) 281-2291&status=773&creatorId=104&spare1=f4x5ow&depttypeId=157&spare2=sn3tcw&organId=104&deptId=267&organLeader=85yy8d&delFlag=9&orderBy=817&createType=965&limit=10&leaderId=104&isVirtual=true&sname=chung.hoeger&name=chung.hoeger&startTime=2025-11-12 15:24:04&isDisabled=true
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
    "stackTrace": "yinr5h",
    "pageNum": 581,
    "pageSize": 10,
    "startRow": 152,
    "endRow": 118,
    "total": 893,
    "pages": 648,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "gsdpf6",
    "orderBy": "66hhbd",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "hj5hfl",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/list/exclude/957.do
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
      "id": 880,
      "organId": "104",
      "organName": "chung.hoeger",
      "parentId": 145,
      "appId": "104",
      "depttypeId": 746,
      "foreignId": "104",
      "createType": 964,
      "type": "z2a8fo",
      "name": "chung.hoeger",
      "sname": "chung.hoeger",
      "areaCode": "74128",
      "organLeader": "9e8j7v",
      "leaderId": "104",
      "leaderMobile": "(567) 281-2291",
      "isOrganLevel": true,
      "isVirtual": true,
      "isLeaf": true,
      "isDisabled": true,
      "searchCode": "74128",
      "imagePath": "2pcyvv",
      "priority": 603,
      "status": 80,
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:25",
      "lastTime": "2025-11-12 15:29:25",
      "delFlag": 9,
      "description": "zwf7s9",
      "spare1": "rhkdlk",
      "spare2": "3zd5h4",
      "parentName": "chung.hoeger",
      "childNum": "69wr4c"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/717.do
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
    "id": 352,
    "organId": "104",
    "organName": "chung.hoeger",
    "parentId": 499,
    "appId": "104",
    "depttypeId": 937,
    "foreignId": "104",
    "createType": 239,
    "type": "qm8j8l",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "areaCode": "74128",
    "organLeader": "6mosiq",
    "leaderId": "104",
    "leaderMobile": "(567) 281-2291",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "74128",
    "imagePath": "zgelz6",
    "priority": 158,
    "status": 349,
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:25",
    "lastTime": "2025-11-12 15:29:25",
    "delFlag": 9,
    "description": "10eqf1",
    "spare1": "0cxeux",
    "spare2": "7hksl0",
    "parentName": "chung.hoeger",
    "childNum": "t5vyed"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/dept/tree.do?searchCode=74128&orderBy=582&leaderId=104&limit=10&areaCode=74128&name=chung.hoeger&type=832yao&foreignId=104&status=657&parentId=287&createType=883&sname=chung.hoeger&imagePath=04jy28&isDisabled=true&spare1=e4kuzl&isLeaf=true&delFlag=9&endTime=2025-11-12 15:24:04&isVirtual=true&page=1&startTime=2025-11-12 15:24:04&appId=104&depttypeId=106&isOrganLevel=true&creatorId=104&q=43z9c5&organLeader=74ika1&leaderMobile=(567) 281-2291&description=wsp0u2&spare2=d37jzo&deptId=447&organId=104
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
      "title": "8ia86v",
      "id": "104",
      "parentId": "104",
      "extId": "104",
      "href": "bv4dfy",
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:25",
    "lastTime": "2025-11-12 15:29:25",
    "id": 178,
    "organId": "104",
    "parentId": 999,
    "appId": "104",
    "depttypeId": 153,
    "foreignId": "104",
    "createType": 219,
    "type": "mxb3yd",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "areaCode": "74128",
    "organLeader": "wnuy08",
    "leaderId": "104",
    "leaderMobile": "(567) 281-2291",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "74128",
    "imagePath": "5mkwka",
    "priority": 38,
    "status": 900,
    "delFlag": 9,
    "description": "z5a6ct",
    "spare1": "bmcz0u",
    "spare2": "en6867",
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
  "data": "3ktiea",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:25",
    "lastTime": "2025-11-12 15:29:25",
    "id": 306,
    "organId": "104",
    "parentId": 928,
    "appId": "104",
    "depttypeId": 376,
    "foreignId": "104",
    "createType": 438,
    "type": "uium1c",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "areaCode": "74128",
    "organLeader": "qdpcsa",
    "leaderId": "104",
    "leaderMobile": "(567) 281-2291",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "74128",
    "imagePath": "pgtjsl",
    "priority": 728,
    "status": 390,
    "delFlag": 9,
    "description": "4018tx",
    "spare1": "0zku89",
    "spare2": "agna8e",
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
  "data": "l6c7po",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "2t7lze",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:25",
    "lastTime": "2025-11-12 15:29:25",
    "id": 220,
    "organId": "104",
    "parentId": 950,
    "appId": "104",
    "depttypeId": 437,
    "foreignId": "104",
    "createType": 587,
    "type": "dexcxh",
    "name": "chung.hoeger",
    "sname": "chung.hoeger",
    "areaCode": "74128",
    "organLeader": "niq7lr",
    "leaderId": "104",
    "leaderMobile": "(567) 281-2291",
    "isOrganLevel": true,
    "isVirtual": true,
    "isLeaf": true,
    "isDisabled": true,
    "searchCode": "74128",
    "imagePath": "jnq91z",
    "priority": 50,
    "status": 394,
    "delFlag": 9,
    "description": "nai7xf",
    "spare1": "il3uey",
    "spare2": "ioqoiv",
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
  "data": "mca5u6",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "username": "chung.hoeger",
    "password": "2ru4th",
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8",
    "appId": "104"
  }
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
    "userId": "104",
    "token": "yfwnpl",
    "updateTime": "2025-11-12 15:29:27",
    "expireTime": "2025-11-12 15:29:27"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:27",
      "lastTime": "2025-11-12 15:29:27",
      "id": 998,
      "userId": "104",
      "deptId": 704,
      "deptName": "chung.hoeger",
      "organId": "104",
      "organName": "chung.hoeger",
      "name": "chung.hoeger",
      "username": "chung.hoeger",
      "nickName": "deon.watsica",
      "email": "antone.stark@hotmail.com",
      "mobile": "(567) 281-2291",
      "imagePath": "3qrzfu",
      "password": "73vrqi",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 448,
      "delFlag": 9,
      "lastLoginIp": "239.116.167.16",
      "lastLoginTime": "2025-11-12 15:29:27",
      "description": "ghm1q4",
      "dept": {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:27",
        "lastTime": "2025-11-12 15:29:27",
        "id": 825,
        "organId": "104",
        "parentId": 781,
        "appId": "104",
        "depttypeId": 336,
        "foreignId": "104",
        "createType": 492,
        "type": "wnbb0a",
        "name": "chung.hoeger",
        "sname": "chung.hoeger",
        "areaCode": "74128",
        "organLeader": "3rw1uv",
        "leaderId": "104",
        "leaderMobile": "(567) 281-2291",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "74128",
        "imagePath": "6z8eiz",
        "priority": 115,
        "status": 288,
        "delFlag": 9,
        "description": "hm7rrc",
        "spare1": "vurl0f",
        "spare2": "33xkuv",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "104",
          "createTime": "2025-11-12 15:29:27",
          "lastTime": "2025-11-12 15:29:27",
          "id": 609,
          "roletypeId": "104",
          "appId": "104",
          "name": "chung.hoeger",
          "code": "74128",
          "priority": 262,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 547,
          "description": "m48ldf",
          "areaType": "1ils9q"
        }
      ],
      "roleIds": [
        903
      ],
      "positionIds": [
        "xoyxen"
      ],
      "roleId": 96,
      "userRoleList": [
        {
          "id": 607,
          "deptId": 840,
          "deptName": "chung.hoeger",
          "organId": "104",
          "organName": "chung.hoeger",
          "roleId": 302,
          "roleName": "chung.hoeger",
          "adminId": 759
        }
      ],
      "code": "74128",
      "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
    },
    "roles": [
      "rvcne8"
    ],
    "permissions": [
      "mbwya4"
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "accountId": "104",
    "areaId": 392,
    "groupId": 372,
    "positionId": "104",
    "tplSolution": "lpf6bx",
    "menuList": [
      {
        "id": 289,
        "parentId": 555,
        "name": "chung.hoeger",
        "ename": "chung.hoeger",
        "type": "j5welf",
        "perms": "f8sl18",
        "menuLevel": 783,
        "urlType": "1m8exu",
        "url": "www.winston-nienow.name",
        "menuSeq": "67jj95",
        "icon": "hsfrvz",
        "imagePath": "isy1g7",
        "css": "eorgn8",
        "description": "vbyndp",
        "todoTotalApi": "vqgn38"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "id": "104",
    "isAdmin": true,
    "isEncryt": true,
    "publicKey": "t09bdv",
    "aesKey": "yqgxq5",
    "clientId": "104",
    "serverUrl": "www.winston-nienow.name",
    "serverConf1": "s2p1td",
    "appConf": {
      "siteId": 477,
      "appId": "104",
      "topXzqhId": "104",
      "appConfJson": {
        "mapKey": "p9xs4d"
      }
    },
    "isWork": true,
    "workConfig": {
      "layout": "acpfox",
      "siteInfo": {
        "id": 274,
        "appId": "104",
        "areaCode": "74128",
        "path": "r4oky2",
        "name": "chung.hoeger",
        "sname": "chung.hoeger",
        "layout": "c65vzw",
        "logoUrl": "www.winston-nienow.name",
        "cdnUrl": "www.winston-nienow.name"
      }
    }
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "username": "chung.hoeger",
    "password": "n06xhu",
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8",
    "appId": "104"
  }
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
    "userId": "104",
    "token": "8tpvw5",
    "updateTime": "2025-11-12 15:29:28",
    "expireTime": "2025-11-12 15:29:28"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -i https://linlan.net/eframe_backend/captcha/verify.do?code=74128&uuid=751dd19a-c431-414c-be28-4d0be16947d8
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "lqx9e9",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "cacheName": "chung.hoeger",
      "cacheKey": "84j1jo",
      "cacheValue": "m8018s",
      "remark": "8egh77"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getKeys/chung.hoeger.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/getValue/chung.hoeger/vpykx8.do
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
    "cacheName": "chung.hoeger",
    "cacheKey": "dausxh",
    "cacheValue": "azxdkj",
    "remark": "86zu4j"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheName/chung.hoeger.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ikglsi",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X DELETE -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/cache/clearCacheKey/6g4prr.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "g152k5",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "gax5pc",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/list.do?limit=10&menuType=a5jybf&menuName=chung.hoeger&status=h5eqi4&currAppId=104&menuId=400&parentId=184&orderBy=806&startTime=2025-11-12 15:24:04&visible=xy4ncm&delFlag=cf62i4&page=1&endTime=2025-11-12 15:24:04&q=l8vn5q
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
      "menuId": 190,
      "menuName": "chung.hoeger",
      "type": "3vm0fu",
      "typeName": "chung.hoeger",
      "parentName": "chung.hoeger",
      "parentId": 452,
      "priority": 491,
      "path": "1v7uhq",
      "component": "ssi874",
      "query": "8ej3wi",
      "routeName": "chung.hoeger",
      "isFrame": "rddjkb",
      "isCache": "vzps99",
      "menuType": "ekjxis",
      "menuTypeName": "chung.hoeger",
      "visible": "jvmeu7",
      "status": "rwckfg",
      "perms": "lsdfe8",
      "icon": "49cmz2",
      "imagePath": "sbu5g3",
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:28",
      "lastTime": "2025-11-12 15:29:28",
      "children": [
        {
          "$ref": ".."
        }
      ],
      "childNum": 614,
      "description": "5e4psz",
      "listJson": "brs3je",
      "delFlag": 9,
      "permsList": [
        {
          "permsName": "chung.hoeger",
          "permsStr": "yvk5rn"
        }
      ],
      "buttonMenuList": [
        {
          "id": "104",
          "parentId": "104",
          "code": "74128",
          "name": "chung.hoeger"
        }
      ]
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/page.do?currAppId=104&q=9phphm&status=rnrryb&menuId=582&visible=al7xc2&delFlag=t9m4ro&orderBy=509&startTime=2025-11-12 15:24:04&limit=10&menuName=chung.hoeger&endTime=2025-11-12 15:24:04&menuType=hkhmsf&page=1&parentId=805
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
    "stackTrace": "cdg67r",
    "pageNum": 1,
    "pageSize": 10,
    "startRow": 332,
    "endRow": 857,
    "total": 304,
    "pages": 398,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "cdf9yh",
    "orderBy": "tq3c2m",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "kv7sjv",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/768.do
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
    "menuId": 643,
    "menuName": "chung.hoeger",
    "type": "lf985q",
    "typeName": "chung.hoeger",
    "parentName": "chung.hoeger",
    "parentId": 522,
    "priority": 617,
    "path": "7dm8om",
    "component": "e0dssk",
    "query": "gup8dk",
    "routeName": "chung.hoeger",
    "isFrame": "wpigxb",
    "isCache": "ya6zi0",
    "menuType": "ehz046",
    "menuTypeName": "chung.hoeger",
    "visible": "48w05l",
    "status": "tjku3i",
    "perms": "rz4zbc",
    "icon": "ugo3jt",
    "imagePath": "zqygd0",
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:28",
    "lastTime": "2025-11-12 15:29:28",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 952,
    "description": "4p0hj9",
    "listJson": "bvfuvx",
    "delFlag": 9,
    "permsList": [
      {
        "permsName": "chung.hoeger",
        "permsStr": "7yk1n3"
      }
    ],
    "buttonMenuList": [
      {
        "id": "104",
        "parentId": "104",
        "code": "74128",
        "name": "chung.hoeger"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeselect.do?menuName=chung.hoeger&parentId=374&limit=10&page=1&currAppId=104&status=harnuw&menuType=o4i5mh&menuId=297&startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&orderBy=901&visible=vd46n0&q=059wb6&delFlag=vqa42o
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
      148
    ],
    "menus": [
      {
        "id": 643,
        "label": "ulreoc",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/treeInit.do?appIds=ocgp1c&appIds=ocgp1c&isDisabled=true&createTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&type=vyfd36&spare2=0q8pn8&spare1=8qtp77&url=www.winston-nienow.name&page=1&menuLevel=768&startTime=2025-11-12 15:24:04&popPosition=412&delFlag=9&limit=10&orderBy=605&isDisplay=true&isCheck=true&parentNull=ezda3f&typeNoButton=wkdb0i&name=chung.hoeger&subCount=200&shortCut=ce1pgt&description=erl6th&offset=1&q=4ttyr6&code=74128&isMenuAll=3110ot&urlType=gn98ys&appId=104&isProtect=true&icon=g7f143&parentId=954&menuIds=kxiopw&menuIds=kxiopw&parentRoot=rhbvph&imagePath=ypbiwz
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
      "title": "6ggjt2",
      "id": "104",
      "parentId": "104",
      "extId": "104",
      "href": "jyq4av",
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/menu/roleMenuTreeselect/249.do
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
      33
    ],
    "menus": [
      {
        "id": 706,
        "label": "jzfdxi",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "menuId": 767,
    "menuName": "chung.hoeger",
    "type": "86hpw4",
    "typeName": "chung.hoeger",
    "parentName": "chung.hoeger",
    "parentId": 145,
    "priority": 211,
    "path": "qew96n",
    "component": "5euhx4",
    "query": "fz1ybk",
    "routeName": "chung.hoeger",
    "isFrame": "cbzw7o",
    "isCache": "djddhq",
    "menuType": "rlcfnd",
    "menuTypeName": "chung.hoeger",
    "visible": "6pq3fs",
    "status": "441nwg",
    "perms": "sb1nel",
    "icon": "pbmdxl",
    "imagePath": "kea18x",
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:28",
    "lastTime": "2025-11-12 15:29:28",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 845,
    "description": "b1ef2t",
    "listJson": "6yernc",
    "delFlag": 9,
    "permsList": [
      {
        "permsName": "chung.hoeger",
        "permsStr": "h8aqma"
      }
    ],
    "buttonMenuList": [
      {
        "id": "104",
        "parentId": "104",
        "code": "74128",
        "name": "chung.hoeger"
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
  "data": "267ovp",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "menuId": 643,
    "menuName": "chung.hoeger",
    "type": "c9ao7l",
    "typeName": "chung.hoeger",
    "parentName": "chung.hoeger",
    "parentId": 884,
    "priority": 540,
    "path": "kopmre",
    "component": "1c0wuo",
    "query": "pxe4kq",
    "routeName": "chung.hoeger",
    "isFrame": "r41715",
    "isCache": "5qhkov",
    "menuType": "ymh173",
    "menuTypeName": "chung.hoeger",
    "visible": "onl2z4",
    "status": "34it8a",
    "perms": "miq3pg",
    "icon": "dv4l2d",
    "imagePath": "tim30d",
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:28",
    "lastTime": "2025-11-12 15:29:28",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 621,
    "description": "n6ovoa",
    "listJson": "z43p24",
    "delFlag": 9,
    "permsList": [
      {
        "permsName": "chung.hoeger",
        "permsStr": "wsb197"
      }
    ],
    "buttonMenuList": [
      {
        "id": "104",
        "parentId": "104",
        "code": "74128",
        "name": "chung.hoeger"
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
  "data": "zed7mu",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "menuId": 392,
    "menuName": "chung.hoeger",
    "type": "3s01y4",
    "typeName": "chung.hoeger",
    "parentName": "chung.hoeger",
    "parentId": 160,
    "priority": 819,
    "path": "emmwvu",
    "component": "2xdy4q",
    "query": "2rnagv",
    "routeName": "chung.hoeger",
    "isFrame": "j563fc",
    "isCache": "tokgrf",
    "menuType": "8dgdwf",
    "menuTypeName": "chung.hoeger",
    "visible": "ipj57h",
    "status": "xepttc",
    "perms": "uyw59a",
    "icon": "60a2v6",
    "imagePath": "xt2bm9",
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:28",
    "lastTime": "2025-11-12 15:29:28",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 844,
    "description": "2m9a2e",
    "listJson": "kvyb0m",
    "delFlag": 9,
    "permsList": [
      {
        "permsName": "chung.hoeger",
        "permsStr": "7h3jrw"
      }
    ],
    "buttonMenuList": [
      {
        "id": "104",
        "parentId": "104",
        "code": "74128",
        "name": "chung.hoeger"
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
  "data": "2ojqkz",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "menuId": 245,
    "menuName": "chung.hoeger",
    "type": "modulh",
    "typeName": "chung.hoeger",
    "parentName": "chung.hoeger",
    "parentId": 624,
    "priority": 815,
    "path": "zg01ax",
    "component": "m38wvv",
    "query": "gzgbbr",
    "routeName": "chung.hoeger",
    "isFrame": "gcal2b",
    "isCache": "focduz",
    "menuType": "jdbggr",
    "menuTypeName": "chung.hoeger",
    "visible": "xp2mhc",
    "status": "pspq32",
    "perms": "00hjo1",
    "icon": "n2s4h4",
    "imagePath": "w6q4ui",
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:28",
    "lastTime": "2025-11-12 15:29:28",
    "children": [
      {
        "$ref": ".."
      }
    ],
    "childNum": 314,
    "description": "hb1wu7",
    "listJson": "tsp92m",
    "delFlag": 9,
    "permsList": [
      {
        "permsName": "chung.hoeger",
        "permsStr": "7crdlr"
      }
    ],
    "buttonMenuList": [
      {
        "id": "104",
        "parentId": "104",
        "code": "74128",
        "name": "chung.hoeger"
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
  "data": "dsmafe",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "yxgkad",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:29",
    "lastTime": "2025-11-12 15:29:29",
    "id": 944,
    "parentId": 921,
    "appId": "104",
    "name": "chung.hoeger",
    "ename": "chung.hoeger",
    "sname": "chung.hoeger",
    "isProtect": true,
    "type": "7yfurj",
    "userId": "104",
    "code": "74128",
    "menuLevel": 423,
    "subCount": 793,
    "perms": "awynqk",
    "urlType": "hiiyy4",
    "url": "www.winston-nienow.name",
    "icon": "zmw7ud",
    "popPosition": 926,
    "imagePath": "ky5t94",
    "css": "o7hd28",
    "jsEvent": "cr4er4",
    "menuSeq": "oks4k5",
    "shortCut": "naubrv",
    "isLeaf": true,
    "isDisplay": true,
    "isDisabled": true,
    "isCheck": true,
    "priority": 867,
    "delFlag": 9,
    "deleteTime": "2025-11-12 15:29:29",
    "description": "jg8rh7",
    "spare1": "eikxfi",
    "spare2": "q264b8",
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
  "data": "p0widc",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/list.do?startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&q=phi1kg&page=1&roleKey=61wnxp&limit=10&roleName=chung.hoeger&orderBy=558&roleId=175&status=253
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:29",
      "lastTime": "2025-11-12 15:29:29",
      "roleId": 45,
      "roleName": "chung.hoeger",
      "roleKey": "1jxs1e",
      "roleSort": 657,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 295,
      "flag": true,
      "menuIds": [
        820
      ],
      "deptIds": [
        324
      ],
      "permissions": [
        "mvv42j"
      ],
      "remark": "8zbob0",
      "parentName": "chung.hoeger",
      "appName": "chung.hoeger",
      "roletypeId": "104",
      "roletypeName": "chung.hoeger",
      "priority": 567,
      "isSuper": true
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/export.do --data 'roleId=68&roleName=chung.hoeger&startTime=2025-11-12 15:24:04&status=528&orderBy=804&endTime=2025-11-12 15:24:04&limit=10&page=1&q=ywbg5e&roleKey=rrzils'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "2ku1iz",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/40.do
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:29",
    "lastTime": "2025-11-12 15:29:29",
    "roleId": 385,
    "roleName": "chung.hoeger",
    "roleKey": "6km0vm",
    "roleSort": 821,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 69,
    "flag": true,
    "menuIds": [
      271
    ],
    "deptIds": [
      904
    ],
    "permissions": [
      "eunusx"
    ],
    "remark": "tlckh9",
    "parentName": "chung.hoeger",
    "appName": "chung.hoeger",
    "roletypeId": "104",
    "roletypeName": "chung.hoeger",
    "priority": 675,
    "isSuper": true
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:29",
    "lastTime": "2025-11-12 15:29:29",
    "roleId": 17,
    "roleName": "chung.hoeger",
    "roleKey": "vf9jov",
    "roleSort": 327,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 319,
    "flag": true,
    "menuIds": [
      730
    ],
    "deptIds": [
      491
    ],
    "permissions": [
      "bnummz"
    ],
    "remark": "mk957q",
    "parentName": "chung.hoeger",
    "appName": "chung.hoeger",
    "roletypeId": "104",
    "roletypeName": "chung.hoeger",
    "priority": 947,
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
  "data": "dima20",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:29",
    "lastTime": "2025-11-12 15:29:29",
    "roleId": 970,
    "roleName": "chung.hoeger",
    "roleKey": "foxfhn",
    "roleSort": 377,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 233,
    "flag": true,
    "menuIds": [
      502
    ],
    "deptIds": [
      158
    ],
    "permissions": [
      "8i6zdu"
    ],
    "remark": "5gbwry",
    "parentName": "chung.hoeger",
    "appName": "chung.hoeger",
    "roletypeId": "104",
    "roletypeName": "chung.hoeger",
    "priority": 453,
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
  "data": "fj22as",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:29",
    "lastTime": "2025-11-12 15:29:29",
    "roleId": 990,
    "roleName": "chung.hoeger",
    "roleKey": "opmfij",
    "roleSort": 974,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 178,
    "flag": true,
    "menuIds": [
      214
    ],
    "deptIds": [
      672
    ],
    "permissions": [
      "8oined"
    ],
    "remark": "xl34c7",
    "parentName": "chung.hoeger",
    "appName": "chung.hoeger",
    "roletypeId": "104",
    "roletypeName": "chung.hoeger",
    "priority": 363,
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
  "data": "1icizo",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:29",
    "lastTime": "2025-11-12 15:29:29",
    "roleId": 670,
    "roleName": "chung.hoeger",
    "roleKey": "kga4sd",
    "roleSort": 833,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 977,
    "flag": true,
    "menuIds": [
      737
    ],
    "deptIds": [
      786
    ],
    "permissions": [
      "a05yzn"
    ],
    "remark": "tfod3q",
    "parentName": "chung.hoeger",
    "appName": "chung.hoeger",
    "roletypeId": "104",
    "roletypeName": "chung.hoeger",
    "priority": 617,
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
  "data": "3sacga",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "v0ejvd",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:29",
    "lastTime": "2025-11-12 15:29:29",
    "id": 192,
    "roletypeId": "104",
    "appId": "104",
    "name": "chung.hoeger",
    "code": "74128",
    "priority": 485,
    "isRegular": true,
    "isSuper": true,
    "isPublic": true,
    "status": 880,
    "description": "syerou",
    "areaType": "1bvais"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ltfomn",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:29",
    "lastTime": "2025-11-12 15:29:29",
    "roleId": 708,
    "roleName": "chung.hoeger",
    "roleKey": "yiq185",
    "roleSort": 116,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 57,
    "flag": true,
    "menuIds": [
      217
    ],
    "deptIds": [
      585
    ],
    "permissions": [
      "ll2ezx"
    ],
    "remark": "iehrbg",
    "parentName": "chung.hoeger",
    "appName": "chung.hoeger",
    "roletypeId": "104",
    "roletypeName": "chung.hoeger",
    "priority": 248,
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
  "data": "ce3elt",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:29",
    "lastTime": "2025-11-12 15:29:29",
    "roleId": 846,
    "roleName": "chung.hoeger",
    "roleKey": "q78wvl",
    "roleSort": 272,
    "menuCheckStrictly": true,
    "deptCheckStrictly": true,
    "status": 815,
    "flag": true,
    "menuIds": [
      365
    ],
    "deptIds": [
      242
    ],
    "permissions": [
      "ophgh0"
    ],
    "remark": "od2lev",
    "parentName": "chung.hoeger",
    "appName": "chung.hoeger",
    "roletypeId": "104",
    "roletypeName": "chung.hoeger",
    "priority": 684,
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
  "data": "vbps89",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:29",
      "lastTime": "2025-11-12 15:29:29",
      "roleId": 463,
      "roleName": "chung.hoeger",
      "roleKey": "lo1nv1",
      "roleSort": 127,
      "menuCheckStrictly": true,
      "deptCheckStrictly": true,
      "status": 284,
      "flag": true,
      "menuIds": [
        629
      ],
      "deptIds": [
        126
      ],
      "permissions": [
        "zlimrg"
      ],
      "remark": "nbrzz6",
      "parentName": "chung.hoeger",
      "appName": "chung.hoeger",
      "roletypeId": "104",
      "roletypeName": "chung.hoeger",
      "priority": 16,
      "isSuper": true
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/allocatedList.do?page=1&nickName=deon.watsica&email=antone.stark@hotmail.com&endTime=2025-11-12 15:24:04&delFlag=9&mobile=(567) 281-2291&q=hcgaiq&orderBy=218&status=46osfv&limit=10&adminId=302&startTime=2025-11-12 15:24:04&userId=104&organId=104&deptId=273&username=chung.hoeger
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:29",
      "lastTime": "2025-11-12 15:29:29",
      "id": 391,
      "userId": "104",
      "deptId": 370,
      "deptName": "chung.hoeger",
      "organId": "104",
      "organName": "chung.hoeger",
      "name": "chung.hoeger",
      "username": "chung.hoeger",
      "nickName": "deon.watsica",
      "email": "antone.stark@hotmail.com",
      "mobile": "(567) 281-2291",
      "imagePath": "6moxf7",
      "password": "b1cnx3",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 428,
      "delFlag": 9,
      "lastLoginIp": "239.116.167.16",
      "lastLoginTime": "2025-11-12 15:29:29",
      "description": "v9yg0l",
      "dept": {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:29",
        "lastTime": "2025-11-12 15:29:29",
        "id": 457,
        "organId": "104",
        "parentId": 452,
        "appId": "104",
        "depttypeId": 582,
        "foreignId": "104",
        "createType": 921,
        "type": "fskxfp",
        "name": "chung.hoeger",
        "sname": "chung.hoeger",
        "areaCode": "74128",
        "organLeader": "t44mw9",
        "leaderId": "104",
        "leaderMobile": "(567) 281-2291",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "74128",
        "imagePath": "jryjnk",
        "priority": 163,
        "status": 344,
        "delFlag": 9,
        "description": "qm7l18",
        "spare1": "dogpvo",
        "spare2": "j8jrrw",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "104",
          "createTime": "2025-11-12 15:29:29",
          "lastTime": "2025-11-12 15:29:29",
          "id": 545,
          "roletypeId": "104",
          "appId": "104",
          "name": "chung.hoeger",
          "code": "74128",
          "priority": 408,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 366,
          "description": "ntiblu",
          "areaType": "bdqun8"
        }
      ],
      "roleIds": [
        802
      ],
      "positionIds": [
        "wujs2n"
      ],
      "roleId": 327,
      "userRoleList": [
        {
          "id": 906,
          "deptId": 970,
          "deptName": "chung.hoeger",
          "organId": "104",
          "organName": "chung.hoeger",
          "roleId": 378,
          "roleName": "chung.hoeger",
          "adminId": 631
        }
      ],
      "code": "74128",
      "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/unallocatedList.do?q=o2rvgl&deptId=899&organId=104&email=antone.stark@hotmail.com&orderBy=627&page=1&username=chung.hoeger&adminId=902&startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&mobile=(567) 281-2291&status=r8e8xc&delFlag=9&userId=104&limit=10&nickName=deon.watsica
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:29",
      "lastTime": "2025-11-12 15:29:29",
      "id": 136,
      "userId": "104",
      "deptId": 74,
      "deptName": "chung.hoeger",
      "organId": "104",
      "organName": "chung.hoeger",
      "name": "chung.hoeger",
      "username": "chung.hoeger",
      "nickName": "deon.watsica",
      "email": "antone.stark@hotmail.com",
      "mobile": "(567) 281-2291",
      "imagePath": "jxemyg",
      "password": "uom1ng",
      "isSuperAdmin": true,
      "isAuditAdmin": true,
      "isSelfAdmin": true,
      "status": 213,
      "delFlag": 9,
      "lastLoginIp": "239.116.167.16",
      "lastLoginTime": "2025-11-12 15:29:29",
      "description": "v20bgl",
      "dept": {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:29",
        "lastTime": "2025-11-12 15:29:29",
        "id": 279,
        "organId": "104",
        "parentId": 375,
        "appId": "104",
        "depttypeId": 46,
        "foreignId": "104",
        "createType": 582,
        "type": "znt01l",
        "name": "chung.hoeger",
        "sname": "chung.hoeger",
        "areaCode": "74128",
        "organLeader": "a2tn2k",
        "leaderId": "104",
        "leaderMobile": "(567) 281-2291",
        "isOrganLevel": true,
        "isVirtual": true,
        "isLeaf": true,
        "isDisabled": true,
        "searchCode": "74128",
        "imagePath": "d9o6dp",
        "priority": 426,
        "status": 412,
        "delFlag": 9,
        "description": "9dp18k",
        "spare1": "zuv59e",
        "spare2": "zn3v1n",
        "children": [
          {
            "$ref": ".."
          }
        ]
      },
      "roles": [
        {
          "creatorId": "104",
          "createTime": "2025-11-12 15:29:29",
          "lastTime": "2025-11-12 15:29:29",
          "id": 748,
          "roletypeId": "104",
          "appId": "104",
          "name": "chung.hoeger",
          "code": "74128",
          "priority": 715,
          "isRegular": true,
          "isSuper": true,
          "isPublic": true,
          "status": 386,
          "description": "awbruz",
          "areaType": "eyau2a"
        }
      ],
      "roleIds": [
        125
      ],
      "positionIds": [
        "r50n10"
      ],
      "roleId": 419,
      "userRoleList": [
        {
          "id": 135,
          "deptId": 996,
          "deptName": "chung.hoeger",
          "organId": "104",
          "organName": "chung.hoeger",
          "roleId": 36,
          "roleName": "chung.hoeger",
          "adminId": 507
        }
      ],
      "code": "74128",
      "uuid": "751dd19a-c431-414c-be28-4d0be16947d8"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "id": 762,
    "roleId": 774,
    "adminId": 997
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "kq4xm9",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/cancelAll.do --data 'adminIds=9yakmn&adminIds=9yakmn&roleId=201'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "4rxi9w",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/authUser/selectAll.do --data 'adminIds=5d1u6q&adminIds=5d1u6q&roleId=947'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "5qapvb",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/admin/role/deptTree/685.do
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
      244
    ],
    "depts": [
      {
        "id": 212,
        "label": "a1pl5p",
        "children": [
          {
            "$ref": ".."
          }
        ]
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/list.do?id=104&todoType=zrhhxn&todoOrganId=104&todoOrganName=chung.hoeger&type=xefmh1&limit=10&todoModuleName=chung.hoeger&todoModuleId=104&todoProcessStatus=qv9si2&todoAccountId=104&todoAccountName=chung.hoeger&todoUserName=chung.hoeger&todoUrl=www.winston-nienow.name&spare2=f8zkfs&todoUserId=104&creatorId=104&opTime=2025-11-12 15:29:39&spare1=e79dkj&todoAbstract=lzlff8&opOrganId=104&opUserId=104&foreignId=104&q=xtigh7&orderBy=495&startTime=2025-11-12 15:24:04&endTime=2025-11-12 15:24:04&todoProcessInfo=00e4uy&todoName=chung.hoeger&status=210nb4&appId=104&todoId=104&todoProcessName=chung.hoeger&todoContent=c961p7&todoCreateTime=2025-11-12 15:29:39&opOrganName=chung.hoeger&description=adw17f&todoNextInfo=u2tsz2&todoCurrInfo=3dgh13&page=1&bizType=hvld1e&todoLabels=pwrktq
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:39",
      "lastTime": "2025-11-12 15:29:39",
      "id": "104",
      "appId": "104",
      "foreignId": "104",
      "type": "srdcpy",
      "bizType": "edb1es",
      "todoCreateTime": "2025-11-12 15:29:39",
      "todoId": "104",
      "todoType": "ftrm6v",
      "todoName": "chung.hoeger",
      "todoAbstract": "4zyo2g",
      "todoAccountId": "104",
      "todoAccountName": "chung.hoeger",
      "todoModuleId": "104",
      "todoModuleName": "chung.hoeger",
      "todoUserId": "104",
      "todoUserName": "chung.hoeger",
      "todoOrganId": "104",
      "todoOrganName": "chung.hoeger",
      "todoProcessName": "chung.hoeger",
      "todoProcessStatus": "xddf1v",
      "todoProcessInfo": "awf3r6",
      "todoCurrInfo": "ys5tdv",
      "todoNextInfo": "bcxsh4",
      "todoUrl": "www.winston-nienow.name",
      "todoLabels": "0f5wad",
      "todoContent": "mv2als",
      "status": "3vdp9h",
      "opUserId": "104",
      "opTime": "2025-11-12 15:29:39",
      "opOrganId": "104",
      "opOrganName": "chung.hoeger",
      "description": "gcfxwp",
      "spare1": "a3wcbr",
      "spare2": "i4cv3r"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/todo/export.do --data 'type=ldjbn6&q=lkkilg&page=1&todoName=chung.hoeger&todoModuleName=chung.hoeger&todoCreateTime=2025-11-12 15:29:39&id=104&todoUserId=104&foreignId=104&todoUserName=chung.hoeger&todoOrganId=104&limit=10&todoProcessStatus=e8xhwd&todoContent=7b1jqh&opTime=2025-11-12 15:29:39&opOrganName=chung.hoeger&startTime=2025-11-12 15:24:04&opOrganId=104&todoModuleId=104&creatorId=104&todoUrl=www.winston-nienow.name&todoProcessName=chung.hoeger&todoAccountName=chung.hoeger&orderBy=997&opUserId=104&todoAccountId=104&endTime=2025-11-12 15:24:04&todoId=104&spare1=fjot5m&todoOrganName=chung.hoeger&appId=104&todoProcessInfo=id5q5t&status=4j44cz&todoCurrInfo=3t4i4n&todoNextInfo=pnhy2j&spare2=emjj8o&todoType=nlgnj3&todoAbstract=1yq2w6&bizType=pyhdtf&description=kf7qfp&todoLabels=q27qkk'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "vxgbnt",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:39",
    "lastTime": "2025-11-12 15:29:39",
    "id": "104",
    "appId": "104",
    "foreignId": "104",
    "type": "96ofsc",
    "bizType": "2i8mpa",
    "todoCreateTime": "2025-11-12 15:29:39",
    "todoId": "104",
    "todoType": "385t3g",
    "todoName": "chung.hoeger",
    "todoAbstract": "vloo3c",
    "todoAccountId": "104",
    "todoAccountName": "chung.hoeger",
    "todoModuleId": "104",
    "todoModuleName": "chung.hoeger",
    "todoUserId": "104",
    "todoUserName": "chung.hoeger",
    "todoOrganId": "104",
    "todoOrganName": "chung.hoeger",
    "todoProcessName": "chung.hoeger",
    "todoProcessStatus": "q4eucx",
    "todoProcessInfo": "rdc75t",
    "todoCurrInfo": "fwoy9y",
    "todoNextInfo": "xvi3h5",
    "todoUrl": "www.winston-nienow.name",
    "todoLabels": "kn7dd7",
    "todoContent": "pbx90k",
    "status": "yhofgn",
    "opUserId": "104",
    "opTime": "2025-11-12 15:29:39",
    "opOrganId": "104",
    "opOrganName": "chung.hoeger",
    "description": "bosus1",
    "spare1": "s937gd",
    "spare2": "0190tc"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:39",
    "lastTime": "2025-11-12 15:29:39",
    "id": "104",
    "appId": "104",
    "foreignId": "104",
    "type": "ufbkvh",
    "bizType": "h2mj0i",
    "todoCreateTime": "2025-11-12 15:29:39",
    "todoId": "104",
    "todoType": "6wkd6z",
    "todoName": "chung.hoeger",
    "todoAbstract": "ftj2zt",
    "todoAccountId": "104",
    "todoAccountName": "chung.hoeger",
    "todoModuleId": "104",
    "todoModuleName": "chung.hoeger",
    "todoUserId": "104",
    "todoUserName": "chung.hoeger",
    "todoOrganId": "104",
    "todoOrganName": "chung.hoeger",
    "todoProcessName": "chung.hoeger",
    "todoProcessStatus": "25ai2t",
    "todoProcessInfo": "8xrem0",
    "todoCurrInfo": "y18mln",
    "todoNextInfo": "g3fnfv",
    "todoUrl": "www.winston-nienow.name",
    "todoLabels": "lx9ac5",
    "todoContent": "9uj7fm",
    "status": "6ixx1p",
    "opUserId": "104",
    "opTime": "2025-11-12 15:29:39",
    "opOrganId": "104",
    "opOrganName": "chung.hoeger",
    "description": "537w9q",
    "spare1": "mwqbrp",
    "spare2": "rgfa2c"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "b4igmo",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:39",
    "lastTime": "2025-11-12 15:29:39",
    "id": "104",
    "appId": "104",
    "foreignId": "104",
    "type": "tun7lo",
    "bizType": "ew3e22",
    "todoCreateTime": "2025-11-12 15:29:39",
    "todoId": "104",
    "todoType": "kkckth",
    "todoName": "chung.hoeger",
    "todoAbstract": "yemiea",
    "todoAccountId": "104",
    "todoAccountName": "chung.hoeger",
    "todoModuleId": "104",
    "todoModuleName": "chung.hoeger",
    "todoUserId": "104",
    "todoUserName": "chung.hoeger",
    "todoOrganId": "104",
    "todoOrganName": "chung.hoeger",
    "todoProcessName": "chung.hoeger",
    "todoProcessStatus": "nja46l",
    "todoProcessInfo": "8hkx6k",
    "todoCurrInfo": "f7zc9k",
    "todoNextInfo": "eefhpc",
    "todoUrl": "www.winston-nienow.name",
    "todoLabels": "hyzodu",
    "todoContent": "693lnw",
    "status": "fxomzx",
    "opUserId": "104",
    "opTime": "2025-11-12 15:29:39",
    "opOrganId": "104",
    "opOrganName": "chung.hoeger",
    "description": "cccy3f",
    "spare1": "1vd2jj",
    "spare2": "xfrms4"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "atrc2r",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "c0ekq9",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/list.do?ids=fnyohc&ids=fnyohc&nameTotal=jvprz0&name=chung.hoeger&delFlag=9&nameEn=x63z0y&areatypeIds=dwdylb&areatypeIds=dwdylb&parentId=822&areatypeId=104&code=74128&searchCode=74128&orderBy=331&deleteTime=2025-11-12 15:24:04&rgt=255&q=zth62v&countryId=104&limit=10&sname=chung.hoeger&isDisplay=true&description=nl2hd0&startTime=2025-11-12 15:24:04&parentIds=ptqpdp&parentIds=ptqpdp&lft=615&likeQuery=63vebc&endTime=2025-11-12 15:24:04&hasContent=true&page=1
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:33",
      "lastTime": "2025-11-12 15:29:33",
      "id": 627,
      "parentId": 371,
      "countryId": "104",
      "areatypeId": "104",
      "lft": 366,
      "rgt": 817,
      "code": "74128",
      "name": "chung.hoeger",
      "nameTotal": "n7aibw",
      "sname": "chung.hoeger",
      "nameEn": "6e4cqw",
      "searchCode": "74128",
      "isDisplay": true,
      "hasContent": true,
      "priority": 54,
      "delFlag": 9,
      "deleteTime": "2025-11-12 15:29:33",
      "description": "7nbg1w"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/xzqh/export.do --data 'parentId=739&code=74128&hasContent=true&isDisplay=true&likeQuery=r02t3v&rgt=198&limit=10&description=sinp6d&countryId=104&q=eu6r7q&nameTotal=1cftwb&orderBy=79&parentIds=bqd5ij&parentIds=bqd5ij&delFlag=9&searchCode=74128&sname=chung.hoeger&areatypeId=104&lft=287&deleteTime=2025-11-12 15:24:04&nameEn=y5txu2&ids=w36pna&ids=w36pna&name=chung.hoeger&page=1&areatypeIds=4cnifw&areatypeIds=4cnifw&endTime=2025-11-12 15:24:04&startTime=2025-11-12 15:24:04'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "gnx6oh",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:33",
    "lastTime": "2025-11-12 15:29:33",
    "id": 24,
    "parentId": 578,
    "countryId": "104",
    "areatypeId": "104",
    "lft": 357,
    "rgt": 647,
    "code": "74128",
    "name": "chung.hoeger",
    "nameTotal": "n84ebx",
    "sname": "chung.hoeger",
    "nameEn": "dyiwsi",
    "searchCode": "74128",
    "isDisplay": true,
    "hasContent": true,
    "priority": 910,
    "delFlag": 9,
    "deleteTime": "2025-11-12 15:29:33",
    "description": "3w6owi"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:33",
    "lastTime": "2025-11-12 15:29:33",
    "id": 626,
    "parentId": 389,
    "countryId": "104",
    "areatypeId": "104",
    "lft": 79,
    "rgt": 851,
    "code": "74128",
    "name": "chung.hoeger",
    "nameTotal": "t89bz9",
    "sname": "chung.hoeger",
    "nameEn": "v3us2k",
    "searchCode": "74128",
    "isDisplay": true,
    "hasContent": true,
    "priority": 420,
    "delFlag": 9,
    "deleteTime": "2025-11-12 15:29:33",
    "description": "y0lop7"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "pwelhg",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:33",
    "lastTime": "2025-11-12 15:29:33",
    "id": 950,
    "parentId": 382,
    "countryId": "104",
    "areatypeId": "104",
    "lft": 696,
    "rgt": 655,
    "code": "74128",
    "name": "chung.hoeger",
    "nameTotal": "njkfcx",
    "sname": "chung.hoeger",
    "nameEn": "n7wpia",
    "searchCode": "74128",
    "isDisplay": true,
    "hasContent": true,
    "priority": 419,
    "delFlag": 9,
    "deleteTime": "2025-11-12 15:29:33",
    "description": "gf3mrs"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ndn4k8",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "wxh93u",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/list.do?orderBy=305&endTime=2025-11-12 15:24:04&page=1&description=1e6ubw&limit=10&type=ccrq2b&delFlag=9&q=yoaqgy&code=74128&existKey=8iv9a1&startTime=2025-11-12 15:24:04&name=chung.hoeger
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:34",
      "lastTime": "2025-11-12 15:29:34",
      "id": "104",
      "name": "chung.hoeger",
      "type": "4131wo",
      "code": "74128",
      "priority": 473,
      "delFlag": 9,
      "description": "0ganof"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/roletype/export.do --data 'page=1&description=9h4goo&limit=10&endTime=2025-11-12 15:24:04&name=chung.hoeger&code=74128&orderBy=160&existKey=eq9sii&delFlag=9&startTime=2025-11-12 15:24:04&type=fv3cqh&q=hendjg'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "y1b6hj",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:34",
    "lastTime": "2025-11-12 15:29:34",
    "id": "104",
    "name": "chung.hoeger",
    "type": "ua7334",
    "code": "74128",
    "priority": 845,
    "delFlag": 9,
    "description": "vhci8e"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:34",
    "lastTime": "2025-11-12 15:29:34",
    "id": "104",
    "name": "chung.hoeger",
    "type": "mj30ex",
    "code": "74128",
    "priority": 678,
    "delFlag": 9,
    "description": "wue2lh"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "0bpmsy",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:34",
    "lastTime": "2025-11-12 15:29:34",
    "id": "104",
    "name": "chung.hoeger",
    "type": "76gt5f",
    "code": "74128",
    "priority": 244,
    "delFlag": 9,
    "description": "0kkvi6"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "aat9hr",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "vmutic",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/list.do?q=uno0l9&page=1&limit=10&ids=umjr07&ids=umjr07&cfgKey=hfyxzn&startTime=2025-11-12 15:24:04&cfgValue=ot33ao&orderBy=416&endTime=2025-11-12 15:24:04
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
    "totalCount": 84,
    "pageSize": 10,
    "totalPage": 1,
    "currPage": 1,
    "list": [
      {
        "cfgKey": "r8kxgd",
        "cfgValue": "ziw2bq"
      }
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/export.do --data 'ids=dcjlkx&ids=dcjlkx&startTime=2025-11-12 15:24:04&cfgValue=6x05zy&limit=10&orderBy=827&endTime=2025-11-12 15:24:04&cfgKey=zho20s&q=4wyk5x&page=1'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "a7hujt",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/system/parts/6yo43p.do
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
    "cfgKey": "x1b77u",
    "cfgValue": "k7n5qz"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "cfgKey": "jqlgq2",
    "cfgValue": "tpvm55"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "vqi46n",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "cfgKey": "q6g5wn",
    "cfgValue": "qohgdd"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "bt2q4l",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "f0od8p",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "mqrhik",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8",
    "img": "1jwpp9",
    "code": "74128"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8",
    "img": "ojllx3",
    "code": "74128"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/list.do?pkColumn.columnType=6fixrp&subTable.formColNum=28&subTable.pkColumn.isList=vrhcdk&subTable.columns[0].priority=31&columns[0].isRequired=r5cfsk&subTable.tableComment=5hjfcl&page=1&subTable.moduleName=chung.hoeger&subTable.pkColumn.dictType=9gk9tg&subTable.subTable.tplCategory=tsxkub&subTable.columns[0].queryType=qyopfa&columns[0].javaField=5vm44n&subTable.pkColumn.isInsert=dww7fv&subTable.pkColumn.columnName=chung.hoeger&pkColumn.isRequired=8oqdu6&subTable.treeCode=74128&pkColumn.javaField=maqknm&limit=10&pkColumn.dictType=9cymk3&columns[0].columnType=9eecr9&tplCategory=8xb94v&treeName=chung.hoeger&subTable.columns[0].isRequired=uzv4ni&subTable.subTable.className=chung.hoeger&subTable.columns[0].columnId=963&subTable.subTable.parentMenuId=557&subTable.treeName=chung.hoeger&subTable.pkColumn.queryType=4910dv&pkColumn.htmlType=kknriw&subTable.subTable.tplWebType=vafsyr&Description=2iszoq&subTable.subTable.tableComment=527rwp&subTable.functionAuthor=Mrs. Cecilia Muller&subTable.pkColumn.isPk=ah1u87&subTableFkName=chung.hoeger&subTable.subTable.moduleName=chung.hoeger&subTable.subTable.treeCode=74128&subTable.columns[0].creatorId=104&subTable.columns[0].javaType=nmey98&subTable.subTable.parentMenuName=chung.hoeger&columns[0].columnId=667&columns[0].columnName=chung.hoeger&columns[0].javaType=a9y5b6&columns[0].queryType=xzrmf6&columns[0].dictType=p8ffgc&subTableName=chung.hoeger&subTable.pkColumn.isRequired=qobihw&columns[0].isIncrement=2bdget&subTable.subTable.page=1&tableId=822&subTable.columns[0].javaField=zh9al8&pkColumn.javaType=c96s7i&createTime=2025-11-12 15:29:40&subTable.pkColumn.columnComment=2le0rc&subTable.subTable.functionName=chung.hoeger&subTable.columns[0].isPk=rq2q4k&subTable.pkColumn.columnType=su6zgf&subTable.subTable.tableName=chung.hoeger&columns[0].creatorId=104&functionName=chung.hoeger&subTable.tableName=chung.hoeger&subTable.pkColumn.columnId=970&pkColumn.isList=to5n4v&subTable.pkColumn.tableId=667&subTable.pkColumn.priority=593&moduleName=chung.hoeger&subTable.columns[0].isList=xzm3iy&subTable.columns[0].tableId=700&subTable.optionLists=v6s46k&className=chung.hoeger&columns[0].createTime=2025-11-12 15:29:40&parentMenuId=336&subTable.functionName=chung.hoeger&subTable.pkColumn.javaField=739twq&subTable.page=1&columns[0].priority=12&subTable.pkColumn.isEdit=rugtz5&subTable.genPath=ylz20i&subTable.tableId=228&functionAuthor=Mrs. Cecilia Muller&subTable.tplCategory=f1g30j&subTable.columns[0].isQuery=mwlsvm&subTable.columns[0].htmlType=ktqnpz&subTable.subTableFkName=chung.hoeger&subTable.subTable.treeParentCode=74128&columns[0].isEdit=09ityc&subTable.subTable.limit=10&subTable.parentMenuName=chung.hoeger&pkColumn.isPk=gm68v0&pkColumn.isEdit=uzoloq&treeParentCode=74128&pkColumn.isIncrement=wokw6u&genPath=obs2cy&subTable.subTable.functionAuthor=Mrs. Cecilia Muller&subTable.lastTime=2025-11-12 15:29:40&lastTime=2025-11-12 15:29:40&tplWebType=xrfwuf&subTable.className=chung.hoeger&pkColumn.priority=678&subTable.subTableName=chung.hoeger&subTable.subTable.subTableName=chung.hoeger&subTable.subTable.subTableFkName=chung.hoeger&columns[0].columnComment=e5q49h&subTable.subTable.packageName=chung.hoeger&columns[0].isInsert=dru2ne&subTable.pkColumn.isQuery=f6jaf9&columns[0].tableId=350&businessName=chung.hoeger&subTable.treeParentCode=74128&genType=3i3gln&columns[0].lastTime=2025-11-12 15:29:40&parentMenuName=chung.hoeger&subTable.subTable.creatorId=104&subTable.subTable.treeName=chung.hoeger&subTable.columns[0].columnName=chung.hoeger&pkColumn.columnId=453&subTable.columns[0].dictType=284c6m&subTable.limit=10&columns[0].isList=rh2qhb&subTable.subTable.genPath=snujgh&subTable.columns[0].columnType=vvsq5z&tableName=chung.hoeger&subTable.subTable.tableId=872&formColNum=992&subTable.pkColumn.htmlType=czmttt&subTable.columns[0].createTime=2025-11-12 15:29:40&subTable.parentMenuId=668&columns[0].isPk=xnxr4j&pkColumn.createTime=2025-11-12 15:29:40&subTable.packageName=chung.hoeger&columns[0].isQuery=nvzws8&columns[0].htmlType=cns2g5&treeCode=74128&creatorId=104&subTable.subTable.Description=7g0769&subTable.pkColumn.creatorId=104&subTable.subTable.createTime=2025-11-12 15:29:40&subTable.subTable.genType=s3u203&subTable.pkColumn.lastTime=2025-11-12 15:29:40&tableComment=24kuts&subTable.creatorId=104&subTable.subTable.formColNum=270&pkColumn.queryType=iikpss&subTable.tplWebType=jbpdtl&subTable.businessName=chung.hoeger&subTable.pkColumn.javaType=926djn&subTable.subTable.lastTime=2025-11-12 15:29:40&subTable.pkColumn.isIncrement=1x3dgr&subTable.Description=cxwuun&optionLists=qcsvd7&subTable.createTime=2025-11-12 15:29:40&pkColumn.lastTime=2025-11-12 15:29:40&pkColumn.tableId=765&subTable.pkColumn.createTime=2025-11-12 15:29:40&pkColumn.isQuery=pxvhny&pkColumn.columnName=chung.hoeger&subTable.columns[0].isEdit=by0064&packageName=chung.hoeger&subTable.columns[0].isInsert=ro59is&pkColumn.creatorId=104&subTable.columns[0].lastTime=2025-11-12 15:29:40&subTable.subTable.optionLists=grmyeg&pkColumn.columnComment=32iv0s&subTable.genType=fvpul6&pkColumn.isInsert=d3ewsl&subTable.subTable.businessName=chung.hoeger&subTable.columns[0].columnComment=aevbly&subTable.columns[0].isIncrement=mq4ovu
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:40",
      "lastTime": "2025-11-12 15:29:40",
      "tableId": 668,
      "tableName": "chung.hoeger",
      "tableComment": "0gyp2o",
      "subTableName": "chung.hoeger",
      "subTableFkName": "chung.hoeger",
      "className": "chung.hoeger",
      "tplCategory": "dga9qk",
      "tplWebType": "3gnqi1",
      "packageName": "chung.hoeger",
      "moduleName": "chung.hoeger",
      "businessName": "chung.hoeger",
      "functionName": "chung.hoeger",
      "functionAuthor": "Mrs. Cecilia Muller",
      "formColNum": 102,
      "genType": "1hz7gy",
      "genPath": "vc1t39",
      "pkColumn": {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:40",
        "lastTime": "2025-11-12 15:29:40",
        "columnId": 231,
        "tableId": 139,
        "columnName": "chung.hoeger",
        "columnComment": "w0j71e",
        "columnType": "swbqt7",
        "javaType": "57qv16",
        "javaField": "cbimx4",
        "isPk": "livbrh",
        "isIncrement": "ukli7b",
        "isRequired": "nurzrw",
        "isInsert": "ikpv1y",
        "isEdit": "sz2c85",
        "isList": "r7ktfx",
        "isQuery": "cbwnvu",
        "queryType": "ebmuwh",
        "htmlType": "1cdw4k",
        "dictType": "7t6ehh",
        "priority": 868
      },
      "subTable": {
        "$ref": "..."
      },
      "columns": [
        {
          "creatorId": "104",
          "createTime": "2025-11-12 15:29:40",
          "lastTime": "2025-11-12 15:29:40",
          "columnId": 949,
          "tableId": 415,
          "columnName": "chung.hoeger",
          "columnComment": "hufjwd",
          "columnType": "4b02nu",
          "javaType": "dry4f0",
          "javaField": "ykjsyh",
          "isPk": "xil0lq",
          "isIncrement": "yz14yl",
          "isRequired": "rewhct",
          "isInsert": "hl5dpa",
          "isEdit": "dhfaw7",
          "isList": "g3emkf",
          "isQuery": "d6meih",
          "queryType": "hrvne7",
          "htmlType": "vtoxps",
          "dictType": "grn4xq",
          "priority": 953
        }
      ],
      "optionLists": "wj8ok5",
      "treeCode": "74128",
      "treeParentCode": "74128",
      "treeName": "chung.hoeger",
      "parentMenuId": 408,
      "parentMenuName": "chung.hoeger",
      "Description": "gy12df",
      "page": 1,
      "limit": 10,
      "params": {
        "mapKey": {}
      }
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/202.do
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/db/list.do?subTable.functionAuthor=Mrs. Cecilia Muller&subTable.packageName=chung.hoeger&subTable.columns[0].queryType=j1g0hn&columns[0].columnComment=8bsacf&subTable.lastTime=2025-11-12 15:29:40&pkColumn.isList=dqeql3&subTable.columns[0].isIncrement=43omiu&subTable.treeParentCode=74128&columns[0].isEdit=ubaxs0&columns[0].queryType=og36mo&treeCode=74128&subTable.pkColumn.columnType=icpco0&subTable.pkColumn.priority=627&subTable.pkColumn.tableId=685&treeName=chung.hoeger&subTable.functionName=chung.hoeger&subTable.columns[0].columnId=950&pkColumn.creatorId=104&tplCategory=96rncz&subTable.pkColumn.lastTime=2025-11-12 15:29:40&columns[0].columnName=chung.hoeger&subTable.columns[0].javaType=iky7nu&subTable.subTable.parentMenuId=453&className=chung.hoeger&subTable.subTableFkName=chung.hoeger&pkColumn.isIncrement=zoxpaf&Description=o2bcq2&subTable.className=chung.hoeger&businessName=chung.hoeger&subTable.subTable.lastTime=2025-11-12 15:29:40&columns[0].htmlType=8h3hg2&subTable.subTable.Description=yfyht6&subTable.pkColumn.columnName=chung.hoeger&columns[0].tableId=708&functionAuthor=Mrs. Cecilia Muller&subTable.pkColumn.columnComment=hl5t7o&subTable.subTable.optionLists=v81jt9&functionName=chung.hoeger&genPath=jbzs7j&subTable.columns[0].creatorId=104&subTable.treeName=chung.hoeger&pkColumn.isInsert=fhz4xp&parentMenuId=784&columns[0].dictType=z6gs3a&columns[0].lastTime=2025-11-12 15:29:40&subTable.columns[0].isEdit=e0540k&subTable.businessName=chung.hoeger&packageName=chung.hoeger&subTable.pkColumn.isList=0d47cl&pkColumn.lastTime=2025-11-12 15:29:40&genType=eqkbri&creatorId=104&subTable.pkColumn.createTime=2025-11-12 15:29:40&pkColumn.columnName=chung.hoeger&subTable.createTime=2025-11-12 15:29:40&subTableName=chung.hoeger&tableId=47&subTable.pkColumn.isRequired=0ogdum&pkColumn.columnType=bv9p6c&subTable.subTable.businessName=chung.hoeger&pkColumn.isQuery=yrymj3&subTable.pkColumn.creatorId=104&subTable.pkColumn.dictType=k2cou0&subTable.pkColumn.columnId=76&subTable.subTable.genType=z4yyja&subTable.subTable.page=1&subTable.columns[0].columnComment=ms2x46&subTable.columns[0].javaField=x94wf9&subTable.columns[0].priority=923&columns[0].isInsert=rgcps2&subTable.columns[0].isPk=yu4h2r&subTable.columns[0].createTime=2025-11-12 15:29:40&subTable.tableName=chung.hoeger&limit=10&columns[0].creatorId=104&subTable.pkColumn.isQuery=xjxknt&subTable.columns[0].isList=jw0xt5&subTable.columns[0].isRequired=s9s9uh&pkColumn.queryType=11xjn3&subTable.columns[0].dictType=fl7u8g&subTable.pkColumn.htmlType=zcqpav&subTable.subTable.subTableName=chung.hoeger&pkColumn.priority=605&pkColumn.isRequired=qdwxoo&subTable.tableComment=kugull&subTable.subTable.tableName=chung.hoeger&subTable.columns[0].tableId=232&subTable.Description=8r3n2n&pkColumn.columnComment=opocn8&columns[0].columnId=206&columns[0].priority=277&pkColumn.javaType=qcdsd0&tableName=chung.hoeger&columns[0].columnType=14z8ek&subTable.subTable.moduleName=chung.hoeger&subTable.pkColumn.isIncrement=63fq9c&pkColumn.isEdit=st8z01&subTable.genType=gdzwbp&subTable.subTable.tableComment=9trl3p&subTable.subTable.tplCategory=1t4mvo&subTable.subTable.tplWebType=k5s8ym&pkColumn.columnId=107&subTable.tableId=988&subTable.subTable.treeParentCode=74128&subTable.page=1&subTable.subTable.parentMenuName=chung.hoeger&parentMenuName=chung.hoeger&subTable.subTable.genPath=4npdt5&pkColumn.javaField=zbiwk8&subTable.pkColumn.queryType=5j8tbd&columns[0].javaType=xwprhs&subTable.subTable.functionName=chung.hoeger&columns[0].isRequired=e7z198&columns[0].javaField=turmqu&subTable.parentMenuName=chung.hoeger&treeParentCode=74128&subTable.treeCode=74128&subTable.subTable.treeCode=74128&subTable.subTable.className=chung.hoeger&subTable.tplCategory=mww8l9&subTable.moduleName=chung.hoeger&subTable.subTable.tableId=158&formColNum=89&subTable.pkColumn.isInsert=05i3r3&subTable.genPath=hpqvu2&subTable.columns[0].lastTime=2025-11-12 15:29:40&subTable.columns[0].columnType=3jq15p&subTable.subTable.limit=10&subTable.subTable.subTableFkName=chung.hoeger&columns[0].isIncrement=e107j1&pkColumn.htmlType=0lh746&pkColumn.isPk=3bscoj&subTable.pkColumn.isPk=wbrr4b&subTable.columns[0].htmlType=b1lbqi&subTable.formColNum=67&subTable.creatorId=104&subTable.subTableName=chung.hoeger&pkColumn.tableId=409&lastTime=2025-11-12 15:29:40&columns[0].isList=uhhnns&tplWebType=8c6ksk&subTable.subTable.packageName=chung.hoeger&subTable.columns[0].isQuery=13kvyu&subTable.limit=10&subTableFkName=chung.hoeger&columns[0].createTime=2025-11-12 15:29:40&subTable.tplWebType=18lr6y&tableComment=gaqaf2&page=1&subTable.subTable.createTime=2025-11-12 15:29:40&subTable.columns[0].isInsert=6slxpb&subTable.columns[0].columnName=chung.hoeger&subTable.optionLists=byicxu&pkColumn.dictType=hgioy9&createTime=2025-11-12 15:29:40&moduleName=chung.hoeger&subTable.pkColumn.javaType=35sver&subTable.parentMenuId=849&columns[0].isPk=htnqau&columns[0].isQuery=pzgiva&optionLists=uypckn&pkColumn.createTime=2025-11-12 15:29:40&subTable.pkColumn.isEdit=b7dg1k&subTable.pkColumn.javaField=pqrgyl&subTable.subTable.functionAuthor=Mrs. Cecilia Muller&subTable.subTable.treeName=chung.hoeger&subTable.subTable.creatorId=104&subTable.subTable.formColNum=722
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
    "stackTrace": "gf8wxj",
    "pageNum": 765,
    "pageSize": 10,
    "startRow": 979,
    "endRow": 91,
    "total": 785,
    "pages": 540,
    "count": true,
    "reasonable": true,
    "pageSizeZero": true,
    "countColumn": "1hhxq5",
    "orderBy": "svfx6z",
    "orderByOnly": true,
    "boundSqlInterceptor": {},
    "dialectClass": "lpaggz",
    "keepOrderBy": true,
    "keepSubSelectOrderBy": true,
    "asyncCount": true
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/column/{tableId}.do?tableId=715
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:40",
      "lastTime": "2025-11-12 15:29:40",
      "columnId": 463,
      "tableId": 553,
      "columnName": "chung.hoeger",
      "columnComment": "kfwv7s",
      "columnType": "zk7o1c",
      "javaType": "phf0jb",
      "javaField": "b0uycm",
      "isPk": "seqvon",
      "isIncrement": "tmub9d",
      "isRequired": "pun2bh",
      "isInsert": "vg3nnz",
      "isEdit": "ekde47",
      "isList": "ivv35t",
      "isQuery": "3i2f0q",
      "queryType": "0clmjv",
      "htmlType": "6m0ozv",
      "dictType": "7yxe2e",
      "priority": 520
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/importTable.do --data 'tables=quniv1'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "l3sss2",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/createTable.do --data 'sql=w1q5k8'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "xhaxue",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:40",
    "lastTime": "2025-11-12 15:29:40",
    "tableId": 382,
    "tableName": "chung.hoeger",
    "tableComment": "9see56",
    "subTableName": "chung.hoeger",
    "subTableFkName": "chung.hoeger",
    "className": "chung.hoeger",
    "tplCategory": "34xk3q",
    "tplWebType": "rys93i",
    "packageName": "chung.hoeger",
    "moduleName": "chung.hoeger",
    "businessName": "chung.hoeger",
    "functionName": "chung.hoeger",
    "functionAuthor": "Mrs. Cecilia Muller",
    "formColNum": 870,
    "genType": "95piqb",
    "genPath": "b71tu5",
    "pkColumn": {
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:40",
      "lastTime": "2025-11-12 15:29:40",
      "columnId": 949,
      "tableId": 206,
      "columnName": "chung.hoeger",
      "columnComment": "nd5a8r",
      "columnType": "zofnvi",
      "javaType": "qn57cn",
      "javaField": "imybt4",
      "isPk": "w7y1ox",
      "isIncrement": "2r5pk4",
      "isRequired": "vp3plh",
      "isInsert": "li8146",
      "isEdit": "yef93n",
      "isList": "sx68xc",
      "isQuery": "36xe23",
      "queryType": "iejp1q",
      "htmlType": "b6ypcy",
      "dictType": "tby4qg",
      "priority": 65
    },
    "subTable": {
      "$ref": "..."
    },
    "columns": [
      {
        "creatorId": "104",
        "createTime": "2025-11-12 15:29:40",
        "lastTime": "2025-11-12 15:29:40",
        "columnId": 906,
        "tableId": 696,
        "columnName": "chung.hoeger",
        "columnComment": "ph66im",
        "columnType": "ptx12q",
        "javaType": "ukfkil",
        "javaField": "t3hvah",
        "isPk": "yxux5q",
        "isIncrement": "wjxmwh",
        "isRequired": "p94et6",
        "isInsert": "nt66w1",
        "isEdit": "u3fwjr",
        "isList": "pv323x",
        "isQuery": "hppgft",
        "queryType": "rp3gom",
        "htmlType": "d3xjb5",
        "dictType": "6r043h",
        "priority": 784
      }
    ],
    "optionLists": "68nnzn",
    "treeCode": "74128",
    "treeParentCode": "74128",
    "treeName": "chung.hoeger",
    "parentMenuId": 624,
    "parentMenuName": "chung.hoeger",
    "Description": "km249u",
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
  "data": "qe90s6",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "jpe99w",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/preview/503.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
    "mapKey1": "s33s12",
    "mapKey2": "7nsjrc"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/download/chung.hoeger.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "u9jdfv",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/genCode/chung.hoeger.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "72i1u7",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/synchDb/chung.hoeger.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ao5xpc",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/tool/gen/batchGenCode.do?tables=n7fdx0
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "i3x0bu",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/token/list.do?expireTime=2025-11-12 15:29:22&username=chung.hoeger&id=531&orderBy=406&description=zbzn3y&startTime=2025-11-12 15:24:04&q=z300yd&page=1&limit=10&foreignId=104&loginIp=239.116.167.16&token=fb1szm&updateTime=2025-11-12 15:29:22&endTime=2025-11-12 15:24:04
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:22",
      "lastTime": "2025-11-12 15:29:22",
      "id": 420,
      "userId": "104",
      "token": "tf3gw6",
      "foreignId": "104",
      "username": "chung.hoeger",
      "loginIp": "239.116.167.16",
      "updateTime": "2025-11-12 15:29:22",
      "expireTime": "2025-11-12 15:29:22",
      "description": "3xjy04"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "fxl08h",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
}
```

## 微信扫码、消息订阅等接口相关控制器
### 获取微信扫码登录验证码
**URL:** https://linlan.net/eframe_backend/api/open/wechat/getCode.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取微信扫码登录验证码

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/api/open/wechat/getCode.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "31n0zo",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
}
```

### 获取微信扫码是否已登录
**URL:** https://linlan.net/eframe_backend/api/open/wechat/isLogin/{loginCode}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 获取微信扫码是否已登录

**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
loginCode|string|登录代码|true|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/api/open/wechat/isLogin/74128.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─activation|boolean|是否激活0否1是|-
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
  "code": "0",
  "msg": "正常",
  "data": {
    "user": {
      "id": 269,
      "userId": "104",
      "xzqhId": 448,
      "source": "skeozb",
      "username": "chung.hoeger",
      "mobile": "(567) 281-2291",
      "email": "antone.stark@hotmail.com",
      "password": "vli205",
      "organId": "104",
      "foreignId": "104",
      "accountId": "104",
      "accountType": "7pljei",
      "unionId": "104",
      "openId": "104",
      "nickName": "deon.watsica",
      "avatarUrl": "www.winston-nienow.name",
      "registerTime": "2025-11-12 15:29:23",
      "lastLoginTime": "2025-11-12 15:29:23",
      "lastLoginIp": "239.116.167.16",
      "loginCount": 694,
      "lockTime": "2025-11-12 15:29:23",
      "activation": true,
      "activationCode": "74128",
      "priority": 667,
      "createTime": "2025-11-12 15:29:23",
      "delFlag": 9,
      "description": "ubkxic",
      "spare1": "ikgb3j",
      "spare2": "saag4s"
    },
    "roles": [
      303
    ],
    "permissions": [
      "yxl1mi"
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
}
```

### 微信小程序登录
**URL:** https://linlan.net/eframe_backend/api/open/wechat/miniLogin/{code}.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 微信小程序登录

**Path-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
code|string|代码|true|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/api/open/wechat/miniLogin/74128.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─activation|boolean|是否激活0否1是|-
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
  "code": "0",
  "msg": "正常",
  "data": {
    "user": {
      "id": 433,
      "userId": "104",
      "xzqhId": 21,
      "source": "bj8icr",
      "username": "chung.hoeger",
      "mobile": "(567) 281-2291",
      "email": "antone.stark@hotmail.com",
      "password": "1c6yed",
      "organId": "104",
      "foreignId": "104",
      "accountId": "104",
      "accountType": "sxpce2",
      "unionId": "104",
      "openId": "104",
      "nickName": "deon.watsica",
      "avatarUrl": "www.winston-nienow.name",
      "registerTime": "2025-11-12 15:29:23",
      "lastLoginTime": "2025-11-12 15:29:23",
      "lastLoginIp": "239.116.167.16",
      "loginCount": 267,
      "lockTime": "2025-11-12 15:29:23",
      "activation": true,
      "activationCode": "74128",
      "priority": 762,
      "createTime": "2025-11-12 15:29:23",
      "delFlag": 9,
      "description": "vxp20n",
      "spare1": "t8t4m0",
      "spare2": "n6wwjq"
    },
    "roles": [
      932
    ],
    "permissions": [
      "apfcq1"
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
}
```

## 微信服务号接口相关控制器
### 微信公众号token验证
**URL:** https://linlan.net/eframe_backend/api/open/wechat/.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 微信公众号token验证

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
signature|string|签名|false|-
timestamp|string|时间|false|-
nonce|string|有效期|false|-
echostr|string|响应字符串|false|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/api/open/wechat/.do?echostr=cqq146&nonce=jqakel&signature=20st9s&timestamp=2025-11-12 15:24:04
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "yrw9id",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
}
```

### 微信公众号消息对接
**URL:** https://linlan.net/eframe_backend/api/open/wechat/.do

**Type:** POST

**Author:** Linlan

**Content-Type:** application/json; charset=utf-8

**Description:** 微信公众号消息对接

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
signature|string|签名|true|-
timestamp|string|时间|true|-
nonce|string|有效期|true|-
encrypt_type|string|加密类型|false|-
msg_signature|string|消息签名|false|-

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
data|object|请求数据对象，放入RequestBody内|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/api/open/wechat/.do?encrypt_type=vbzg6m&signature=blt6ny&timestamp=2025-11-12 15:24:04&nonce=i2sivt&msg_signature=0k2ws0 --data '{
  "requestBody": "3rgp2a"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "8vt1kt",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
}
```

### 微信公众号 获取oauth2完整授权地址
**URL:** https://linlan.net/eframe_backend/api/open/wechat/getRedirect.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 微信公众号 获取oauth2完整授权地址

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/api/open/wechat/getRedirect.do
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
  "data": {},
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
}
```

### 微信公众号 oauth2授权后 获取用户信息
**URL:** https://linlan.net/eframe_backend/api/open/wechat/login.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 微信公众号 oauth2授权后 获取用户信息

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
code|string| 代码|false|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/api/open/wechat/login.do?code=74128
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
  "data": {},
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
}
```

### 微信公众号 页面端原生能力调用
**URL:** https://linlan.net/eframe_backend/api/open/wechat/getJsapiTicket.do

**Type:** GET

**Author:** Linlan

**Content-Type:** application/x-www-form-urlencoded;charset=utf-8

**Description:** 微信公众号 页面端原生能力调用

**Query-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
url|string|  路径URL|true|-

**Request-example:**
```
curl -X GET -k -i https://linlan.net/eframe_backend/api/open/wechat/getJsapiTicket.do?url=www.winston-nienow.name
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
  "data": {},
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/smssendrecord/list.do?endTime=2025-11-12 15:24:04&sendStatus=nkyh70&page=1&creatorId=104&id=101&foreignId=104&receiverMobile=(567) 281-2291&limit=10&msgUrl=www.winston-nienow.name&sendTime=2025-11-12&bizSubtype=qoe3ab&startTime=2025-11-12 15:24:04&spare2=xqyst3&orderBy=283&delFlag=9&description=efx8g7&bizType=uawddp&status=wi12y2&providerName=chung.hoeger&providerId=104&appId=104&spare1=bv17mj&returnTime=2025-11-12 15:29:21&q=sygxjb&returnInfo=ksp7sb&receiverName=chung.hoeger&content=8gn40n
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:21",
      "lastTime": "2025-11-12 15:29:21",
      "id": 679,
      "appId": "104",
      "providerId": "104",
      "providerName": "chung.hoeger",
      "foreignId": "104",
      "receiverMobile": "(567) 281-2291",
      "receiverName": "chung.hoeger",
      "bizType": "q3ag9o",
      "bizSubtype": "ym9ft4",
      "content": "v7lex1",
      "msgUrl": "www.winston-nienow.name",
      "status": "t51m96",
      "sendTime": "2025-11-12",
      "sendStatus": "hj7cwz",
      "returnTime": "2025-11-12 15:29:21",
      "returnInfo": "j6eog9",
      "delFlag": 9,
      "description": "hyrlod",
      "spare1": "1b5a60",
      "spare2": "j1hckv"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:21",
    "lastTime": "2025-11-12 15:29:21",
    "id": 765,
    "appId": "104",
    "providerId": "104",
    "providerName": "chung.hoeger",
    "foreignId": "104",
    "receiverMobile": "(567) 281-2291",
    "receiverName": "chung.hoeger",
    "bizType": "u9lgmb",
    "bizSubtype": "wt4yr1",
    "content": "2hh7rp",
    "msgUrl": "www.winston-nienow.name",
    "status": "kejja3",
    "sendTime": "2025-11-12",
    "sendStatus": "bk55yr",
    "returnTime": "2025-11-12 15:29:21",
    "returnInfo": "sw1gg0",
    "delFlag": 9,
    "description": "yd9x5e",
    "spare1": "5c8a31",
    "spare2": "zsidp0"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:21",
    "lastTime": "2025-11-12 15:29:21",
    "id": 486,
    "appId": "104",
    "providerId": "104",
    "providerName": "chung.hoeger",
    "foreignId": "104",
    "receiverMobile": "(567) 281-2291",
    "receiverName": "chung.hoeger",
    "bizType": "980uk8",
    "bizSubtype": "9a7ieu",
    "content": "h1bdat",
    "msgUrl": "www.winston-nienow.name",
    "status": "bfpwt6",
    "sendTime": "2025-11-12",
    "sendStatus": "sim8ny",
    "returnTime": "2025-11-12 15:29:21",
    "returnInfo": "tuooks",
    "delFlag": 9,
    "description": "vjmsuw",
    "spare1": "al8pn8",
    "spare2": "4xpl55"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "icv2wg",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:21",
    "lastTime": "2025-11-12 15:29:21",
    "id": 685,
    "appId": "104",
    "providerId": "104",
    "providerName": "chung.hoeger",
    "foreignId": "104",
    "receiverMobile": "(567) 281-2291",
    "receiverName": "chung.hoeger",
    "bizType": "xe2i0y",
    "bizSubtype": "onhr4n",
    "content": "g262zl",
    "msgUrl": "www.winston-nienow.name",
    "status": "gdzqbu",
    "sendTime": "2025-11-12",
    "sendStatus": "7k8i02",
    "returnTime": "2025-11-12 15:29:21",
    "returnInfo": "rpypjn",
    "delFlag": 9,
    "description": "f7ayud",
    "spare1": "krgx5a",
    "spare2": "uwdjav"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "y2nya5",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "4dg6qf",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "mobile": "(567) 281-2291",
    "code": "74128",
    "uuid": "751dd19a-c431-414c-be28-4d0be16947d8",
    "appId": "104"
  }
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
    "userId": "104",
    "token": "e9tq3a",
    "updateTime": "2025-11-12 15:29:21",
    "expireTime": "2025-11-12 15:29:21"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -i https://linlan.net/eframe_backend/login/otp/send.do --data 'mobile=(567) 281-2291'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "0ssahe",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
data|object|请求数据对象，放入RequestBody内|false|-
└─id|int64|主键ID|false|-
└─platform|int32|平台|false|-
└─mailFormat|string|邮件格式|false|-
└─mailFrom|string|发件人邮箱|false|-
└─formAlias|string|发件人昵称|false|-
└─mailTos|string|接收人邮箱|false|-
└─receiversName|string|收件人列表|false|-
└─templateName|string|模板名|false|-
└─tagName|string|标签名|false|-
└─subject|string|邮件主题|false|-
└─content|string|邮件正文|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/mail/send.do --data '{
  "data": {
    "id": 784,
    "platform": 368,
    "mailFormat": "carhzl",
    "mailFrom": "097gxd",
    "formAlias": "j5gbzf",
    "mailTos": "hfbt4g",
    "receiversName": "chung.hoeger",
    "templateName": "chung.hoeger",
    "tagName": "chung.hoeger",
    "subject": "zmeuv4",
    "content": "g876ls"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "522gga",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
data|object|请求数据对象，放入RequestBody内|false|-
└─email|string|邮箱|true|-
└─code|string|验证码|true|-
└─password|string|密码|true|-
└─nickname|string|昵称|true|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/mail/register.do --data '{
  "data": {
    "email": "antone.stark@hotmail.com",
    "code": "74128",
    "password": "qhure0",
    "nickname": "deon.watsica"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
data|object|请求数据对象，放入RequestBody内|false|-
└─email|string|邮箱|true|-
└─code|string|验证码|true|-
└─password|string|密码|true|-
└─nickname|string|昵称|true|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/mail/email/forgot.do --data '{
  "data": {
    "email": "antone.stark@hotmail.com",
    "code": "74128",
    "password": "fwbu2d",
    "nickname": "deon.watsica"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/member/list.do?mobile=(567) 281-2291&orderBy=841&accountId=104&openId=104&page=1&spare1=wt19tt&email=antone.stark@hotmail.com&foreignId=104&creatorId=104&endTime=2025-11-12 15:24:04&description=datc1r&limit=10&id=427&organId=104&q=dq0xx9&startTime=2025-11-12 15:24:04&nickName=deon.watsica&additionInfo=66fiji&serverType=r6kq36&spare2=31pkxn&areaCode=74128&unionId=104&avatarUrl=www.winston-nienow.name&delFlag=9
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
  "code": "0",
  "msg": "正常",
  "data": [
    {
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:22",
      "lastTime": "2025-11-12 15:29:22",
      "id": 101,
      "userId": "104",
      "organId": "104",
      "foreignId": "104",
      "accountId": "104",
      "accountType": "1ggbjc",
      "unionId": "104",
      "openId": "104",
      "email": "antone.stark@hotmail.com",
      "areaCode": "74128",
      "mobile": "(567) 281-2291",
      "nickName": "deon.watsica",
      "avatarUrl": "www.winston-nienow.name",
      "additionInfo": "k3yeta",
      "delFlag": 9,
      "description": "1gqd0a",
      "spare1": "7emc2g",
      "spare2": "avrest"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "code": "0",
  "msg": "正常",
  "data": {
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:22",
    "lastTime": "2025-11-12 15:29:22",
    "id": 509,
    "userId": "104",
    "organId": "104",
    "foreignId": "104",
    "accountId": "104",
    "accountType": "ph9yc5",
    "unionId": "104",
    "openId": "104",
    "email": "antone.stark@hotmail.com",
    "areaCode": "74128",
    "mobile": "(567) 281-2291",
    "nickName": "deon.watsica",
    "avatarUrl": "www.winston-nienow.name",
    "additionInfo": "nvg4rs",
    "delFlag": 9,
    "description": "u72c8p",
    "spare1": "uw7qrc",
    "spare2": "wrstmz"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
└─accountType|string|开放平台认证平台类型|false|-
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:22",
    "lastTime": "2025-11-12 15:29:22",
    "id": 154,
    "userId": "104",
    "organId": "104",
    "foreignId": "104",
    "accountId": "104",
    "accountType": "xu8jsv",
    "unionId": "104",
    "openId": "104",
    "email": "antone.stark@hotmail.com",
    "areaCode": "74128",
    "mobile": "(567) 281-2291",
    "nickName": "deon.watsica",
    "avatarUrl": "www.winston-nienow.name",
    "additionInfo": "9jv4x8",
    "delFlag": 9,
    "description": "v8x886",
    "spare1": "jsooe1",
    "spare2": "7sbq3y"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "6nmq7l",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
└─accountType|string|开放平台认证平台类型|false|-
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:22",
    "lastTime": "2025-11-12 15:29:22",
    "id": 489,
    "userId": "104",
    "organId": "104",
    "foreignId": "104",
    "accountId": "104",
    "accountType": "o3isvj",
    "unionId": "104",
    "openId": "104",
    "email": "antone.stark@hotmail.com",
    "areaCode": "74128",
    "mobile": "(567) 281-2291",
    "nickName": "deon.watsica",
    "avatarUrl": "www.winston-nienow.name",
    "additionInfo": "0xxsax",
    "delFlag": 9,
    "description": "b4c1gm",
    "spare1": "ze37em",
    "spare2": "pjek43"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "rhs198",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "y76vd6",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/list.do?page=1&memberId=625&username=chung.hoeger&endTime=2025-11-12 15:24:04&orderBy=956&q=ym9i3f&bindTime=2025-11-12 15:29:22&startTime=2025-11-12 15:24:04&limit=10&accountId=104&delFlag=9&spare1=y4ezxa&additionInfo=cg9jhy&id=104&accountKey=9q15bc&userId=104&creatorId=104&description=ti96hm&spare2=dw86ig
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
└─openType|string|第三方平台|-
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:22",
      "lastTime": "2025-11-12 15:29:22",
      "id": "104",
      "memberId": 49,
      "userId": "104",
      "username": "chung.hoeger",
      "accountId": "104",
      "accountKey": "04bgo1",
      "bindTime": "2025-11-12 15:29:22",
      "additionInfo": "6jwmmy",
      "delFlag": 9,
      "description": "stzpab",
      "spare1": "nx2173",
      "spare2": "kuoxrx",
      "openType": "2a4oju"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:22",
    "lastTime": "2025-11-12 15:29:22",
    "id": "104",
    "memberId": 866,
    "userId": "104",
    "username": "chung.hoeger",
    "accountId": "104",
    "accountKey": "tmavmx",
    "bindTime": "2025-11-12 15:29:22",
    "additionInfo": "997137",
    "delFlag": 9,
    "description": "hkoa6q",
    "spare1": "qx302v",
    "spare2": "n6ooo1"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:22",
    "lastTime": "2025-11-12 15:29:22",
    "id": "104",
    "memberId": 815,
    "userId": "104",
    "username": "chung.hoeger",
    "accountId": "104",
    "accountKey": "xo4jdg",
    "bindTime": "2025-11-12 15:29:22",
    "additionInfo": "4z1wiw",
    "delFlag": 9,
    "description": "xutxkb",
    "spare1": "yv36sy",
    "spare2": "zc5h7z"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "nvhw6e",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:22",
    "lastTime": "2025-11-12 15:29:22",
    "id": "104",
    "memberId": 807,
    "userId": "104",
    "username": "chung.hoeger",
    "accountId": "104",
    "accountKey": "wjpplg",
    "bindTime": "2025-11-12 15:29:22",
    "additionInfo": "e5pg5i",
    "delFlag": 9,
    "description": "4snvuy",
    "spare1": "ajo3c4",
    "spare2": "zt1pgm"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "uvsgqd",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "dv9k48",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/third/memberbind/mylist.do?accountKey=zjwumg&limit=10&accountId=104&id=104&memberId=156&startTime=2025-11-12 15:24:04&additionInfo=llf3mq&spare2=720xq6&orderBy=421&page=1&bindTime=2025-11-12 15:29:22&creatorId=104&username=chung.hoeger&q=szuks0&endTime=2025-11-12 15:24:04&userId=104&delFlag=9&description=57dezo&spare1=ngr643
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
└─openType|string|第三方平台|-
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:22",
      "lastTime": "2025-11-12 15:29:22",
      "id": "104",
      "memberId": 356,
      "userId": "104",
      "username": "chung.hoeger",
      "accountId": "104",
      "accountKey": "1ebju8",
      "bindTime": "2025-11-12 15:29:22",
      "additionInfo": "y5ova7",
      "delFlag": 9,
      "description": "0ckds4",
      "spare1": "zxd0pg",
      "spare2": "nkengs",
      "openType": "gu96y0"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "coo7cy",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/callback/其他.do?auth_code=74128&code=74128&state=2b2gml&authorization_code=74128&oauth_verifier=ryn7x9&oauth_token=jshzq2
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
{"success":true,"code":"0","msg":"正常","data":Forward or redirect to a page view.,"requestId":"104","timestamp":"2025-11-12 15:24:04"}
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
data|object|请求数据对象，放入RequestBody内|false|-
└─platformType|string|开放平台类型|false|-
└─code|string|开放平台Code|false|-
└─state|string|state|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/social.do --data '{
  "data": {
    "platformType": "ujwk83",
    "code": "74128",
    "state": "k9cdg4"
  }
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
    "userId": "104",
    "token": "h9ng95",
    "updateTime": "2025-11-12 15:29:23",
    "expireTime": "2025-11-12 15:29:23"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
data|object|请求数据对象，放入RequestBody内|false|-
└─platformType|string|开放平台类型|false|-
└─code|string|开放平台Code|false|-
└─state|string|状态信息|false|-
└─bindFrom|string|绑定来自，关联BindFromEnum, admin_work:管理WEB端;web:门户前台;h5:移动端前台;web_work:门户工作;h5_work:移动端工作;other:其他|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/social/bind.do --data '{
  "data": {
    "platformType": "kddaz0",
    "code": "74128",
    "state": "0rh49c",
    "bindFrom": "orwfn6"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "ql5ppp",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
data|object|请求数据对象，放入RequestBody内|false|-
└─platformType|string|开放平台类型|false|-
└─code|string|开放平台Code|false|-
└─state|string|状态信息|false|-
└─bindFrom|string|绑定来自，关联BindFromEnum, admin_work:管理WEB端;web:门户前台;h5:移动端前台;web_work:门户工作;h5_work:移动端工作;other:其他|false|-

**Request-example:**
```
curl -X POST -k -H 'Content-Type: application/json; charset=utf-8' -i https://linlan.net/eframe_backend/login/social/unBind.do --data '{
  "data": {
    "platformType": "9b6137",
    "code": "74128",
    "state": "qo416d",
    "bindFrom": "2viqw3"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "2a3c31",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/revoke/其他/751dd19a-c431-414c-be28-4d0be16947d8.do
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
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
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/refresh/其他/751dd19a-c431-414c-be28-4d0be16947d8.do
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
  "data": {},
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
{"success":true,"code":"0","msg":"正常","data":Forward or redirect to a page view.,"requestId":"104","timestamp":"2025-11-12 15:24:04"}
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
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/userInfo.do?source=0rhxvq
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─activation|boolean|是否激活0否1是|-
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
  "code": "0",
  "msg": "正常",
  "data": {
    "user": {
      "id": 224,
      "userId": "104",
      "xzqhId": 524,
      "source": "yc9fjs",
      "username": "chung.hoeger",
      "mobile": "(567) 281-2291",
      "email": "antone.stark@hotmail.com",
      "password": "bmeort",
      "organId": "104",
      "foreignId": "104",
      "accountId": "104",
      "accountType": "3v5tms",
      "unionId": "104",
      "openId": "104",
      "nickName": "deon.watsica",
      "avatarUrl": "www.winston-nienow.name",
      "registerTime": "2025-11-12 15:29:23",
      "lastLoginTime": "2025-11-12 15:29:23",
      "lastLoginIp": "239.116.167.16",
      "loginCount": 515,
      "lockTime": "2025-11-12 15:29:23",
      "activation": true,
      "activationCode": "74128",
      "priority": 51,
      "createTime": "2025-11-12 15:29:23",
      "delFlag": 9,
      "description": "h52yg5",
      "spare1": "jz0zs8",
      "spare2": "no4o9m"
    },
    "roles": [
      570
    ],
    "permissions": [
      "gtkwj4"
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -i https://linlan.net/eframe_backend/login/social/workUserInfo.do?source=bs1aj4
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─activation|boolean|是否激活0否1是|-
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
  "code": "0",
  "msg": "正常",
  "data": {
    "user": {
      "id": 342,
      "userId": "104",
      "xzqhId": 627,
      "source": "dsutsn",
      "username": "chung.hoeger",
      "mobile": "(567) 281-2291",
      "email": "antone.stark@hotmail.com",
      "password": "yy97bh",
      "organId": "104",
      "foreignId": "104",
      "accountId": "104",
      "accountType": "wgzeuy",
      "unionId": "104",
      "openId": "104",
      "nickName": "deon.watsica",
      "avatarUrl": "www.winston-nienow.name",
      "registerTime": "2025-11-12 15:29:23",
      "lastLoginTime": "2025-11-12 15:29:23",
      "lastLoginIp": "239.116.167.16",
      "loginCount": 517,
      "lockTime": "2025-11-12 15:29:23",
      "activation": true,
      "activationCode": "74128",
      "priority": 825,
      "createTime": "2025-11-12 15:29:23",
      "delFlag": 9,
      "description": "1bok2y",
      "spare1": "rq6tsf",
      "spare2": "6w8i4l"
    },
    "roles": [
      312
    ],
    "permissions": [
      "k09uac"
    ]
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/list.do?concurrent=lc1m5e&remark=es89te&jobGroup=5vf6ax&jobId=923&status=975&invokeTarget=clwed6&cronExpression=nsi0tx&misfirePolicy=p8pvju&jobName=chung.hoeger
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
      "jobId": "104",
      "jobName": "chung.hoeger",
      "jobGroup": "i0t0q4",
      "invokeTarget": "87euhm",
      "cronExpression": "fmqz39",
      "misfirePolicy": "mh6fis",
      "concurrent": "khxr5j",
      "status": 288,
      "remark": "2cosfq"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/export.do --data 'invokeTarget=3jdopz&cronExpression=bpqt4z&jobName=chung.hoeger&jobId=838&remark=qnje8d&concurrent=wa6hyn&status=223&jobGroup=406wlq&misfirePolicy=b6vjob'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "bo2887",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/job/104.do
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
    "jobId": "104",
    "jobName": "chung.hoeger",
    "jobGroup": "gtx6kv",
    "invokeTarget": "90vn5n",
    "cronExpression": "fhwpb2",
    "misfirePolicy": "ctvadh",
    "concurrent": "oelz2c",
    "status": 956,
    "remark": "utqka7"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "jobId": "104",
    "jobName": "chung.hoeger",
    "jobGroup": "i3i2ex",
    "invokeTarget": "3qeklx",
    "cronExpression": "d47kf7",
    "misfirePolicy": "88te6z",
    "concurrent": "tki95s",
    "status": 0,
    "remark": "r0ktwr"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "zz1bdp",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "jobId": "104",
    "jobName": "chung.hoeger",
    "jobGroup": "73h69g",
    "invokeTarget": "m9vgn0",
    "cronExpression": "e6u162",
    "misfirePolicy": "r48s73",
    "concurrent": "qllld1",
    "status": 193,
    "remark": "qqloix"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "z5xcfx",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "jobId": "104",
    "jobName": "chung.hoeger",
    "jobGroup": "mj1pag",
    "invokeTarget": "c71g6k",
    "cronExpression": "7cfk13",
    "misfirePolicy": "nnflyf",
    "concurrent": "0ts8dj",
    "status": 646,
    "remark": "239glg"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "qoew4i",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "jobId": "104",
    "jobName": "chung.hoeger",
    "jobGroup": "u8oe9h",
    "invokeTarget": "jvn0mc",
    "cronExpression": "sboxj9",
    "misfirePolicy": "y29qh3",
    "concurrent": "ftlbfu",
    "status": 689,
    "remark": "bibcop"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "n6lucn",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "nt3trf",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/list.do?jobId=104&remark=j69ccx&stopTime=2025-11-12 15:29:24&invokeTarget=8hqhmf&jobMessage=success&lastTime=2025-11-12 15:29:24&jobLogId=350&createTime=2025-11-12 15:29:24&jobName=chung.hoeger&exceptionInfo=tzhsij&creatorId=104&status=759&jobGroup=ssydx1&startTime=2025-11-12 15:29:24
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:24",
      "lastTime": "2025-11-12 15:29:24",
      "jobLogId": "104",
      "jobId": "104",
      "jobMessage": "success",
      "status": 485,
      "exceptionInfo": "n1m82x",
      "startTime": "2025-11-12 15:29:24",
      "stopTime": "2025-11-12 15:29:24",
      "remark": "fa457a"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X POST -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/export.do --data 'exceptionInfo=zibdst&jobName=chung.hoeger&jobGroup=3024zv&lastTime=2025-11-12 15:29:24&invokeTarget=au1tr3&creatorId=104&startTime=2025-11-12 15:29:24&status=32&createTime=2025-11-12 15:29:24&jobMessage=success&jobLogId=271&jobId=104&stopTime=2025-11-12 15:29:24&remark=4mvm6z'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "8u2gij",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/monitor/joblog/104.do
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:24",
    "lastTime": "2025-11-12 15:29:24",
    "jobLogId": "104",
    "jobId": "104",
    "jobMessage": "success",
    "status": 711,
    "exceptionInfo": "nwdji6",
    "startTime": "2025-11-12 15:29:24",
    "stopTime": "2025-11-12 15:29:24",
    "remark": "o3kiq4"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "hot3jb",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
curl -X GET -k -H 'token:${token}' -i https://linlan.net/eframe_backend/api/store/mailsendrecord/list.do?providerId=104&startTime=2025-11-12 15:24:04&appId=104&receiverEmail=antone.stark@hotmail.com&delFlag=9&readStatus=quzc5c&description=8hjvsb&receiverName=chung.hoeger&msgUrl=www.winston-nienow.name&title=xrekz9&orderBy=665&status=ginfic&q=oy1b64&readTime=2025-11-12 15:29:20&page=1&endTime=2025-11-12 15:24:04&foreignId=104&spare2=ixsbl0&sendTime=2025-11-12&content=jip3mh&id=617&senderName=chung.hoeger&providerName=chung.hoeger&bizType=sz682c&sendStatus=9x8tgr&spare1=a5dbov&limit=10&creatorId=104
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
      "creatorId": "104",
      "createTime": "2025-11-12 15:29:20",
      "lastTime": "2025-11-12 15:29:20",
      "id": 417,
      "appId": "104",
      "providerId": "104",
      "providerName": "chung.hoeger",
      "foreignId": "104",
      "senderName": "chung.hoeger",
      "receiverEmail": "antone.stark@hotmail.com",
      "receiverName": "chung.hoeger",
      "bizType": "r9cr4z",
      "title": "3f779r",
      "content": "u7xpmm",
      "msgUrl": "www.winston-nienow.name",
      "status": "lt5ft2",
      "sendTime": "2025-11-12",
      "sendStatus": "cflsfz",
      "readTime": "2025-11-12 15:29:20",
      "readStatus": "ah32ji",
      "delFlag": 9,
      "description": "2hdnq9",
      "spare1": "wnkn5b",
      "spare2": "vnay2e"
    }
  ],
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:20",
    "lastTime": "2025-11-12 15:29:20",
    "id": 205,
    "appId": "104",
    "providerId": "104",
    "providerName": "chung.hoeger",
    "foreignId": "104",
    "senderName": "chung.hoeger",
    "receiverEmail": "antone.stark@hotmail.com",
    "receiverName": "chung.hoeger",
    "bizType": "jitauq",
    "title": "qcfmpn",
    "content": "zrzqii",
    "msgUrl": "www.winston-nienow.name",
    "status": "hzd6vb",
    "sendTime": "2025-11-12",
    "sendStatus": "lhcbww",
    "readTime": "2025-11-12 15:29:20",
    "readStatus": "vn687q",
    "delFlag": 9,
    "description": "7wwh7f",
    "spare1": "ycrd8r",
    "spare2": "zjq254"
  },
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:20",
    "lastTime": "2025-11-12 15:29:20",
    "id": 78,
    "appId": "104",
    "providerId": "104",
    "providerName": "chung.hoeger",
    "foreignId": "104",
    "senderName": "chung.hoeger",
    "receiverEmail": "antone.stark@hotmail.com",
    "receiverName": "chung.hoeger",
    "bizType": "qp6mpa",
    "title": "ru7zo6",
    "content": "du2vgp",
    "msgUrl": "www.winston-nienow.name",
    "status": "36nx00",
    "sendTime": "2025-11-12",
    "sendStatus": "4324s1",
    "readTime": "2025-11-12 15:29:20",
    "readStatus": "8llnj3",
    "delFlag": 9,
    "description": "pk88hl",
    "spare1": "jsiy1s",
    "spare2": "ld3xds"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "3wl4gm",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
    "creatorId": "104",
    "createTime": "2025-11-12 15:29:21",
    "lastTime": "2025-11-12 15:29:21",
    "id": 103,
    "appId": "104",
    "providerId": "104",
    "providerName": "chung.hoeger",
    "foreignId": "104",
    "senderName": "chung.hoeger",
    "receiverEmail": "antone.stark@hotmail.com",
    "receiverName": "chung.hoeger",
    "bizType": "mwmp3c",
    "title": "ps0jac",
    "content": "nkawir",
    "msgUrl": "www.winston-nienow.name",
    "status": "0oyrte",
    "sendTime": "2025-11-12",
    "sendStatus": "a8wkm0",
    "readTime": "2025-11-12 15:29:21",
    "readStatus": "vjy9gz",
    "delFlag": 9,
    "description": "olwk2r",
    "spare1": "lenapw",
    "spare2": "ik2c09"
  }
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
success|boolean|成功标记:正常为true,错误为false|-
code|string|返回状态码:正常状态为0|-
msg|string|返回消息|-
data|object|返回数据对象|-
requestId|string|请求ID|-
timestamp|string|返回时间戳字符串|-

**Response-example:**
```
{
  "success": true,
  "code": "0",
  "msg": "正常",
  "data": "jprb1j",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
  "data": "wseug0",
  "requestId": "104",
  "timestamp": "2025-11-12 15:24:04"
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
