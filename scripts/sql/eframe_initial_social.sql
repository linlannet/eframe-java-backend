-- 社交平台新增表

-- ----------------------------
-- Table structure for THIRD_MEMBER
-- ----------------------------
DROP TABLE IF EXISTS `THIRD_MEMBER`;
CREATE TABLE `THIRD_MEMBER`  (
                                 `MEMBER_ID` bigint(20) NOT NULL COMMENT '主键ID',
                                 `USER_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户ID',
                                 `ORGAN_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机构ID',
                                 `FOREIGN_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '外键ID，人口库ID',
                                 `ACCOUNT_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份提供商ID',
                                 `ACCOUNT_TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份提供商类型',
                                 `UNION_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '三方全局D',
                                 `OPEN_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '开放平台ID',
                                 `EMAIL` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
                                 `AREA_CODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号对应的国家号',
                                 `MOBILE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
                                 `NICK_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
                                 `AVATAR_URL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
                                 `ADDITION_INFO` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '附加信息',
                                 `CREATOR_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人ID',
                                 `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                 `LAST_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
                                 `DEL_FLAG` int(10) NULL DEFAULT NULL COMMENT '删除标记，0未删除1已删除',
                                 `DESCRIPTION` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
                                 `SPARE1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用1',
                                 `SPARE2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用2',
                                 PRIMARY KEY (`MEMBER_ID`) USING BTREE,
                                 INDEX `AK_UK_THIRD_MEMBER_USER_ID`(`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '第三方用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for THIRD_MEMBER_BIND
-- ----------------------------
DROP TABLE IF EXISTS `THIRD_MEMBER_BIND`;
CREATE TABLE `THIRD_MEMBER_BIND`  (
                                      `BIND_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键ID',
                                      `MEMBER_ID` bigint(20) NOT NULL COMMENT '会员ID',
                                      `USER_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户ID',
                                      `USERNAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '系统用户名，手机号',
                                      `ACCOUNT_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份提供商ID',
                                      `ACCOUNT_KEY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第三方账号KEY，市民云、微信等的UnionId或OpenId',
                                      `BIND_TIME` datetime(0) NULL DEFAULT NULL COMMENT '绑定时间',
                                      `ADDITION_INFO` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '附加信息',
                                      `CREATOR_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人ID',
                                      `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                      `LAST_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
                                      `DEL_FLAG` int(10) NULL DEFAULT NULL COMMENT '删除标记，0未删除1已删除',
                                      `DESCRIPTION` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
                                      `SPARE1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用1',
                                      `SPARE2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用2',
                                      PRIMARY KEY (`BIND_ID`) USING BTREE,
                                      INDEX `UK_USER_IDP_BIND`(`USER_ID`, `ACCOUNT_ID`, `ACCOUNT_KEY`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户身份提供商绑定' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for THIRD_MEMBER_TOKEN
-- ----------------------------
DROP TABLE IF EXISTS `THIRD_MEMBER_TOKEN`;
CREATE TABLE `THIRD_MEMBER_TOKEN`  (
                                       `MEMBER_ID` bigint(20) NOT NULL COMMENT '主键ID',
                                       `USER_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户ID',
                                       `TOKEN` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '令牌TOKEN',
                                       `FOREIGN_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '前台应用或站点ID',
                                       `USERNAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
                                       `LOGIN_IP` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录IP',
                                       `UPDATE_TIME` datetime(0) NOT NULL COMMENT '更新时间',
                                       `EXPIRE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
                                       `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                       `DESCRIPTION` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
                                       PRIMARY KEY (`MEMBER_ID`) USING BTREE,
                                       INDEX `AK_UK_THIRD_MEMBER_TOKEN`(`TOKEN`) USING BTREE,
                                       INDEX `AK_UK_THIRD_MEMBER_USERNAME`(`USERNAME`) USING BTREE,
                                       INDEX `IDX_THIRD_MEMBER_T_TOKEN`(`TOKEN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员用户令牌' ROW_FORMAT = Dynamic;

