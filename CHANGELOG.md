### 版本号：1.1.4
- 更新日期：2025-09-05
- 更新内容：
1. 增加http内工具类
2. HttpContextUtils内方法增加
3. BaseConfigWholeService内增加getByKeys，getByKeyLike等方法

### 版本号：1.1.3
- 更新日期：2025-08-31
- 更新内容：
1. encryptPassword、matchesPassword方法统一到ShaUtils内
2. 增加BaseEnumInteger、BaseEnumString接口
3. AdminDept内name、sname、searchCode意义更新

### 版本号：1.1.2
- 更新日期：2025-08-26
- 更新内容：
1. 修改数据库查询的别名
2. 更新菜单查询的list方法
3. 更新缓存名称，统一字典、全局配置的缓存名称
4. 全局配置的api路径调整

### 版本号：1.1.1
- 更新日期：2025-08-25
- 更新内容：
1. 修复发布web文件过大
2. 增加每个pom文件中必要的配置，name，develop，version，package等
3. 增加module的扩展，后续增加sms和social融合模块

### 版本号：1.1.0
- 更新日期：2025-08-25
- 更新内容：
1. 新增已有的资源和代码
2. Q&A修改为FAQ
3. 更新代码中的注释信息，生成javadoc
4. 核对自动生成的doc接口api文档
   1. [EFRAME-API-HTML](./scripts/doc/ent-frame.html)
   2. [EFRAME-API-MD](./scripts/doc/ent-frame.html.md)
5. 增加数据库默认结构SQL  [DB_STRUCTURE](./scripts/sql/db_structure.sql)
6. 配置代码文件增加Formatter和Licence


### 版本号：1.0.0
- 更新日期：2025-08-23
- 更新内容：
1. 初始化工程目录
2. 增加根目录的README、Q&A、CHANGELOG
3. 增加THIRD_PARTY.md
4. 采用maven方式进行打包，新增初始化pom文件
5. 修改README.en文件信息
