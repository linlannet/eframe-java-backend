/*

 Source Server         : LLDB
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : framedb_1.1

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 13/10/2025 16:08:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for PUBLIC_GROUP
-- ----------------------------
DROP TABLE IF EXISTS `PUBLIC_GROUP`;
CREATE TABLE `PUBLIC_GROUP`  (
                                 `GROUP_ID` bigint(0) NOT NULL COMMENT '组编号',
                                 `ROLE_ID` bigint(0) NULL DEFAULT NULL COMMENT '角色ID',
                                 `MGROUP_ID` bigint(0) NULL DEFAULT NULL COMMENT '会员类型ID',
                                 `NAME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
                                 `CODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '代码',
                                 `ICON_STYLE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标样式',
                                 `IMAGE_PATH` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员组图标',
                                 `TPL_SOLUTION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '当前组的默认布局',
                                 `IS_COMMON_GROUP` tinyint(1) NULL DEFAULT 0 COMMENT '是否通用组0否1是，表示市民组，不需要进行权限控制',
                                 `IS_LEADER_GROUP` tinyint(1) NULL DEFAULT 0 COMMENT '是否领导组0否1是，工作组的一种情况',
                                 `LEADER_LEVEL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '领导组级别',
                                 `IS_WORK_GROUP` tinyint(1) NULL DEFAULT 0 COMMENT '是否工作组0否1是，工作组的其他缺省情况',
                                 `IS_GRID_GROUP` tinyint(1) NULL DEFAULT 0 COMMENT '是否网格组0否1是，工作组的一种',
                                 `IS_PARTY_GROUP` tinyint(1) NULL DEFAULT 0 COMMENT '是否党员组0否1是，运营运维组',
                                 `IS_VILLAGE_GROUP` tinyint(1) NULL DEFAULT 0 COMMENT '是否村民组0否1是，租户机构用户组',
                                 `IS_DISABLED` tinyint(1) NULL DEFAULT 0 COMMENT '是否禁用0否1是',
                                 `PRIORITY` int(0) NULL DEFAULT 10 COMMENT '排序',
                                 `CREATOR_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人ID',
                                 `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                 `DESCRIPTION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
                                 PRIMARY KEY (`GROUP_ID`) USING BTREE,
                                 INDEX `IDX_PUBLIC_GROUP_PRI`(`PRIORITY`) USING BTREE,
                                 INDEX `IDX_PUBLIC_GROUP_CODE`(`CODE`) USING BTREE,
                                 INDEX `IDX_PUBLIC_GROUP_G_ID`(`MGROUP_ID`) USING BTREE,
                                 INDEX `IDX_PUBLIC_GROUP_R_ID`(`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员用户组' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PUBLIC_GROUP
-- ----------------------------
INSERT INTO `PUBLIC_GROUP` VALUES (10, 10, NULL, '互联网门户通用', 'web', NULL, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, 10, NULL, '2025-11-10 12:48:05', NULL);
INSERT INTO `PUBLIC_GROUP` VALUES (11, 11, NULL, '互联网门户工作通用', 'web_work', NULL, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, 10, NULL, '2025-11-10 12:48:05', NULL);
INSERT INTO `PUBLIC_GROUP` VALUES (20, 20, NULL, '移动端小程序通用', 'h5', NULL, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, 10, NULL, '2025-11-10 12:48:05', NULL);
INSERT INTO `PUBLIC_GROUP` VALUES (21, 21, NULL, '移动端小程序工作通用', 'h5_work', NULL, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, 10, NULL, '2025-11-10 12:48:05', NULL);
INSERT INTO `PUBLIC_GROUP` VALUES (30, 30, NULL, '大屏端智能终端通用', 'screen', NULL, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, 10, NULL, '2025-11-10 12:48:05', NULL);
INSERT INTO `PUBLIC_GROUP` VALUES (90, 90, NULL, '其他', 'other', NULL, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, 10, NULL, '2025-11-10 12:48:05', NULL);

-- ----------------------------
-- Table structure for PUBLIC_GROUP_POSITION
-- ----------------------------
DROP TABLE IF EXISTS `PUBLIC_GROUP_POSITION`;
CREATE TABLE `PUBLIC_GROUP_POSITION`  (
  `GROUPPOS_ID` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户管理组ID',
  `GROUP_ID` bigint(0) NULL DEFAULT NULL COMMENT '组编号',
  `POSITION_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '岗位ID',
  PRIMARY KEY (`GROUPPOS_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户组岗位关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PUBLIC_GROUP_POSITION
-- ----------------------------

-- ----------------------------
-- Table structure for USER_RANGE_ORGAN
-- ----------------------------
DROP TABLE IF EXISTS `USER_RANGE_ORGAN`;
CREATE TABLE `USER_RANGE_ORGAN`  (
  `RELATION_ID` bigint(0) NOT NULL COMMENT '人员机构关系ID',
  `ORGAN_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机构ID',
  `USER_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户ID',
  `USERL_ID` bigint(0) NULL DEFAULT NULL COMMENT '会员ID，用户的LONG类型ID，管理用户ID',
  `GROUP_ID` bigint(0) NULL DEFAULT NULL COMMENT '分组ID',
  `POSITION_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '岗位ID',
  `DEPT_ID` bigint(0) NULL DEFAULT NULL COMMENT '机构下级单位ID',
  `FOREIGN_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地域ID, 关联地域ID，关注的地域ID，入驻的地域ID，可查询数据范围的地域ID',
  `IS_MEMBER` tinyint(1) NULL DEFAULT 0 COMMENT '是否会员0否1是',
  `TYPE` int(0) NULL DEFAULT NULL COMMENT '类型：0所属1挂靠2虚拟，10小区生活，11小区房屋关系，20物业服务，21志愿服务22生活服务30公共设施服务',
  `POWER` int(0) NULL DEFAULT NULL COMMENT '类型，10属于所属，11自有房屋12租赁房屋13群租房屋20管理30服务90其他',
  `IS_DEF` tinyint(1) NULL DEFAULT 0 COMMENT '是否主岗位0否1是',
  `DEL_FLAG` int(0) NULL DEFAULT NULL COMMENT '是否删除1已删除0正常',
  `STATUS` int(0) NULL DEFAULT 0 COMMENT '状态0默认1验证通过2验证不通过，部分审核工作的标记',
  `CREATOR_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATOR_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `SPARE1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用1',
  `SPARE2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备用2',
  PRIMARY KEY (`RELATION_ID`) USING BTREE,
  INDEX `IDX_USER_R_O_O_ID`(`ORGAN_ID`) USING BTREE,
  INDEX `IDX_USER_R_O_U_ID`(`USER_ID`) USING BTREE,
  INDEX `IDX_USER_R_O_UL_ID`(`USERL_ID`) USING BTREE,
  INDEX `IDX_USER_R_O_P_ID`(`POSITION_ID`) USING BTREE,
  INDEX `IDX_USER_R_O_F_ID`(`FOREIGN_ID`) USING BTREE,
  INDEX `IDX_USER_R_O_G_ID`(`GROUP_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '人员应用范围机构关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of USER_RANGE_ORGAN
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
