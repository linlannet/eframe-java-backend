# eframe-java-backend

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
![java version](https://img.shields.io/badge/JAVA-1.8-green.svg)
![gitee star](https://gitee.com/linlannet/eframe-java-backend/badge/star.svg)

## Introduce

The enterprise-level back-end framework (EFRAME) developed by JAVA is based on Springboot, and adopts the framework and security supporting the highest version of JAVA 1.8. The back-end data access adopts Mybatis framework, which supports a set of code adaptation of various databases, and provides scaffolding to quickly generate Mapper, etc. 
Learn from the framework, realize the most basic administrator, organization, role, authority, grouping, message management, and provide framework support application extension for various enterprise applications.

**common tools：** <a target="_blank">https://gitee.com/linlannet/java-tools-parent

**code generate：** <a target="_blank">https://gitee.com/linlannet/java-tools-generate

**smart doc plugin：** <a target="_blank">https://gitee.com/linlannet/java-plugin-doc-generate


Front-end engineering path:

**VUE+TS：** <a target="_blank">https://gitee.com/linlannet/eframe-java-backend


## Change Log

[CHANGELOG](./CHANGELOG.md)


## Application effect

**Guide to the use of EFRAME ：** <a target="_blank">https://gitee.com/linlannet/eframe-docs

## Sub Package
1. eframe-support: frame support module, various tools and data toolkits. 
2. eframe-model: model data module, service and dao resource toolkit for database reading. 
3. eframe-core: Core common module, universal business logic core tool.
4. eframe-view: view logical data module, which uses read-write separation to logically split some services.
5. eframe-api: API interface gateway module, a common API resource package at the framework layer.
6. module-generator: generator code generation module, which supports simple control and read-write separation control and integrates service gateway.
7. module-quartz: quartz timing task module, which configures, starts, stops and monitors tasks. 
8. eframe-Web: Web application service module, service application API configuration injection, providing interface.
9. module-extend: module extension module, back-end service extension, followed by sms, social and other general configurations and jar references to achieve extension.
10. scripts: database scripts, API interface documents, sh scripts running on the server side, etc.


## Technical Guidelines
### Software Architecture
```
Springboot + Framework + Security + Mybatis
```

### Installation
1. mvn clean install
2. mvn clean deploy

### Instructions
1. use by maven
```
   <dependency>
      <groupId>${groupId}</groupId>
      <artifactId>${artifactId}</artifactId>
      <version>${project.version}</version>
      <scope>test</scope>
   </dependency>
```
2. use direct jar

## Contribution
1.  Fork repository
2.  new Feat_1.0.0 branch
3.  commit
```
git config user.name linlaninfo
git config user.email linlannet@163.com
git config --global --list
git config --list
```
4. new Pull Request
5. create and commit tag
```
create
git tag -a 1.0.0 -m "initial version"
list
git tag
commit
git push origin --tags
delete
git tag -d 1.0.0

install: mvn clean install
deploy: mvn clean deploy

```
6. other

## Licence

[Apache 2.0 © eframe-java-backend 2023](./LICENSE)
