# eframe-java-backend

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
![java version](https://img.shields.io/badge/JAVA-1.8-green.svg)
![gitee star](https://gitee.com/linlannet/eframe-java-backend/badge/star.svg)

## 介绍

JAVA企业级后端框架（EFRAME），基于Springboot，采用支持 JAVA 17的framework、security，后端数据访问采用Mybatis框架，支持多种数据库一套代码适配，提供脚手架可快速生成Mapper等。
借鉴若依框架，实现最基础的管理员、机构、角色、权限、分组、消息管理，为各类企业级应用提供框架支撑应用扩展。

**工具类代码地址：** <a target="_blank">https://gitee.com/linlannet/java-tools-parent

**智能代码生成工具地址：** <a target="_blank">https://gitee.com/linlannet/java-tools-generate

**非浸入式自动生成接口API代码地址：** <a target="_blank">https://gitee.com/linlannet/java-plugin-doc-generate


前端工程路径：

**VUE+TS前端工程地址：** <a target="_blank">https://gitee.com/linlannet/eframe-vue-frontend


## 版本历史

[CHANGELOG](./CHANGELOG.md)

## 应用效果

**企业框架（EFRAME）使用指南及效果：** <a target="_blank">https://gitee.com/linlannet/eframe-docs

## 子包简介
1. eframe-support: frame支撑模块，各类工具类、数据工具包.
2. eframe-model: model模型数据模块，数据库读取的service和dao资源工具包.
3. eframe-core: core核心共性模块，通用的业务逻辑核心工具.
4. eframe-view: view视图逻辑模块，采用读写分离方式，对部分业务进行视图逻辑拆分.
5. eframe-api: api接口网关模块，框架层的通用api资源包.
6. module-generator: generator代码生成模块，代码生成支持简单控制和读写分离控制，一体化服务网关.
7. module-quartz: quartz定时任务模块，对任务进行配置、启动、停止和监控.
8. eframe-web: web应用服务模块，服务应用API配置注入，提供接口.
9. module-extend: module扩展模块，后端服务扩展，后续增加sms、social等通用配置和jar引用，实现扩展.
10. scripts: 数据库脚本、API接口文档、服务器端运行的sh脚本等.


## 技术路径
### 软件架构
```
Springboot + Framework + Security + Mybatis
```

### 安装教程
1. mvn clean install
2. mvn clean deploy

### 使用说明
1. 通过依赖使用
```
   <dependency>
      <groupId>${groupId}</groupId>
      <artifactId>${artifactId}</artifactId>
      <version>${project.version}</version>
      <scope>test</scope>
   </dependency>
```
2. 直接拷贝打包后的jar包

## 参与贡献
1.  Fork 本仓库
2.  新建 Feat_1.0.0 分支
3.  提交代码
```
git config user.name linlaninfo
git config user.email linlannet@163.com
git config --global --list
git config --list
```
4. 新建 Pull Request
5. 创建和提交tag
```
创建
git tag -a 1.0.0 -m "初始化版本"
查看
git tag
提交
git push origin --tags
删除
git tag -d 1.0.0

本地编译：mvn clean install
发布到github：mvn clean deploy

```
6. 其他

## 版权

[Apache 2.0 © eframe-java-backend 2023](./LICENSE)
