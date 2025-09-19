package net.linlan.frame.comm.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 用户类型
 *
 * @author Linlan
 */
public class AdminType implements Serializable {
    /**
     * 用户
     */
    public static final AdminType USER      = new AdminType("user", "用户");
    /**
     * 管理员
     */
    public static final AdminType ADMIN     = new AdminType("admin", "管理员");
    /**
     * 演示人员
     */
    public static final AdminType DEMO = new AdminType("demo", "演示人员");
    /**
     * 未知
     */
    public static final AdminType UNKNOWN   = new AdminType("unknown", "未知");

    /**
     * 用户类型，如admin，user
     */
    private String               type;

    /**
     * 用户类型名称，如管理员，用户
     */
    private String               name;

    AdminType() {

    }

    AdminType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
