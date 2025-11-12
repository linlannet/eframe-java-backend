/*
 * module-authn - 动态认证对接模块
 * Copyright © 2020-2025 Linlan (open@linlan.net)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.linlan.authn.group.constant;

/**
 * 公共分组类型枚举
 */
public enum PublicGroupEnum {
                             /**
                              * 互联网门户通用
                              */
                             WWW_GROUP(10, "web", "互联网门户通用", 10),
                             /**
                              * 互联网门户工作通用
                              */
                             WWW_WORK_GROUP(11, "web_work", "互联网门户工作通用", 11),
                             /**
                                                       * 移动端小程序通用
                                                       */
                             H5_GROUP(20, "h5", "移动端小程序通用", 20),
                             /**
                              * 移动端小程序工作通用
                              */
                             H5_WORK_GROUP(21, "h5_work", "移动端小程序工作通用", 21),
                             /**
                                                       * 大屏端、智能终端通用
                                                       */
                             SCREEN_GROUP(30, "screen", "大屏端智能终端通用", 30),
                             /**
                              * 其他
                              */
                             OTHER(90, "other", "其他", 90);

    /**
     * 组ID
     */
    private long   groupId;
    /**
     * 代码
     */
    private String groupCode;
    /**
     * 组名称
     */
    private String groupName;
    /**
     * 角色ID
     */
    private long   roleId;

    PublicGroupEnum(long groupId, String groupCode, String groupName, long roleId) {
        this.groupId = groupId;
        this.groupCode = groupCode;
        this.groupName = groupName;
        this.roleId = roleId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public static PublicGroupEnum fromGroupId(Long groupId) {
        PublicGroupEnum[] values = values();
        for (PublicGroupEnum value : values) {
            if (value.getGroupId() == groupId) {
                return value;
            }
        }
        return null;
    }

    public static PublicGroupEnum fromCode(String groupCode) {
        PublicGroupEnum[] values = values();
        for (PublicGroupEnum value : values) {
            if (value.getGroupCode().equals(groupCode)) {
                return value;
            }
        }
        return null;
    }
}
