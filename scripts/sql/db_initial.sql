-- 初始化数据

INSERT INTO `unie_db4`.`BASE_CONFIG_WHOLE`(`CFG_ID`, `CFG_KEY`, `CFG_VALUE`, `CFG_CATAGORY`, `IS_DISABLED`, `DESCRIPTION`) VALUES ('1', 'sys.index.skinName', 'skin-blue', '主框架页-默认皮肤样式名称', 0, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `unie_db4`.`BASE_CONFIG_WHOLE`(`CFG_ID`, `CFG_KEY`, `CFG_VALUE`, `CFG_CATAGORY`, `IS_DISABLED`, `DESCRIPTION`) VALUES ('2', 'sys.user.initPassword', '123456', '用户管理-账号初始密码', 0, '初始化密码 123456');
INSERT INTO `unie_db4`.`BASE_CONFIG_WHOLE`(`CFG_ID`, `CFG_KEY`, `CFG_VALUE`, `CFG_CATAGORY`, `IS_DISABLED`, `DESCRIPTION`) VALUES ('3', 'sys.index.sideTheme', 'theme-dark', '主框架页-侧边栏主题', 0, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `unie_db4`.`BASE_CONFIG_WHOLE`(`CFG_ID`, `CFG_KEY`, `CFG_VALUE`, `CFG_CATAGORY`, `IS_DISABLED`, `DESCRIPTION`) VALUES ('4', 'sys.account.captchaEnabled', 'true', '账号自助-验证码开关', 0, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `unie_db4`.`BASE_CONFIG_WHOLE`(`CFG_ID`, `CFG_KEY`, `CFG_VALUE`, `CFG_CATAGORY`, `IS_DISABLED`, `DESCRIPTION`) VALUES ('5', 'sys.account.registerUser', 'false', '账号自助-是否开启用户注册功能', 0, '是否开启注册用户功能（true开启，false关闭）');
INSERT INTO `unie_db4`.`BASE_CONFIG_WHOLE`(`CFG_ID`, `CFG_KEY`, `CFG_VALUE`, `CFG_CATAGORY`, `IS_DISABLED`, `DESCRIPTION`) VALUES ('6', 'sys.login.blackIPList', '', '用户登录-黑名单列表', 0, '设置登录IP黑名单限制，多个匹配项以;分隔，支持匹配（*通配、网段）');
