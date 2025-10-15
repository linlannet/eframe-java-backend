package net.linlan.frame.config.param;

import java.util.Date;

import lombok.Data;

import net.linlan.utils.param.BaseParam;

/**
 *
 * PublicTemplateInfo数据域:模板信息配置查询参数实体类
 * 
 * @author Linlan
 * CreateTime 2025-10-15 13:52:44
 * @version 1.0
 * @since 1.0
 *
 */
@Data
public class PublicTemplateInfoParam extends BaseParam {

    /**
     * 模板ID
     */
    private String id;
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 机构ID
     */
    private String organId;
    /**
     * 提供商ID，平台ID
     */
    private String providerId;
    /**
     * 提供商名称，平台名称
     */
    private String providerName;
    /**
     * 外键ID
     */
    private String foreignId;
    /**
     * 模板类型，邮件模板，短信模板
     */
    private String type;
    /**
     * 模板子类型
     */
    private String subType;
    /**
     * 模板名称，标题名称
     */
    private String name;
    /**
     * 签名，发送人名称
     */
    private String signature;
    /**
     * 内容JSON，发布版本的JSON配置
     */
    private String content;
    /**
     * 状态0未生效1正常2受限3锁定
     */
    private Integer status;
    /**
     * 创建者ID
     */
    private String creatorId;
    /**
     * 删除标记0正常1已删除2应用内受限3回收站
     */
    private Integer delFlag;
    /**
     * 备注
     */
    private String description;
    /**
     * 备用1
     */
    private String spare1;
    /**
     * 备用2
     */
    private String spare2;

}
