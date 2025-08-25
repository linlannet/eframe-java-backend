/*
 * eframe-core - core核心共性模块
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
package net.linlan.frame.mbiz.constant;

/**
 * Filename:HttpStatusEnum.java
 * Desc:前台Api响应枚举类，支持plat、member 和 pub 三种模式
 * @author Linlan
 * CreateTime:2023/07/20 18:06
 * @version 1.0
 * @since 1.0
 */
public enum HttpStatusEnum {

                            SUCCESS("200",
                                    "Success[正常]"), RETURN_NONE("201",
                                                                "None[未查询到数据]"), BAD_REQUEST("400",
                                                                                             "Bad Request[请求错误]"), UNAUTHORIZED("401",
                                                                                                                                "Unauthorized[TOKEN失效，请重新登录]"), FORBIDDEN("403",
                                                                                                                                                                          "Forbidden[页面禁止访问]"), NOT_FOUND("404",
                                                                                                                                                                                                          "Not Found[页面未找到]"), UNSUPPORTED_MEDIA_TYPE("415",
                                                                                                                                                                                                                                                      "Unsupported Media Type[数据类型不支持]"), INTERNAL_SERVER_ERROR("500",
                                                                                                                                                                                                                                                                                                                "Internal Server Error[未知错误]"), NOT_LOGIN("501",
                                                                                                                                                                                                                                                                                                                                                          "Not Login[用户未登录]"), BAD_GATEWAY("502",
                                                                                                                                                                                                                                                                                                                                                                                           "Bad Gateway[网关错误]"), SERVICE_UNAVAILABLE("503",
                                                                                                                                                                                                                                                                                                                                                                                                                                     "Service Unavailable[服务不可用]"),

                            TOKEN_ERROR("700",
                                        "Token Error[TOKEN信息错误]"), INPUT_ERROR_CODE("701",
                                                                                    "Input Error Code[信息传入有误(code)]"), INPUT_ERROR_SOURCE("702",
                                                                                                                                          "Input Error Source[信息传入有误(source)]"), ACCOUNT_NOT_EXIST("703",
                                                                                                                                                                                                   "Account Not Exist[对接平台账户不存在]"), CHANNEL_NOT_EXIST("704",
                                                                                                                                                                                                                                                      "Channel Not Exist[该栏目版面不存在]"), PARAMETER_ERROR("711",
                                                                                                                                                                                                                                                                                                      "Parameter Error[传递参数信息错误]"), NETWORK_ERROR("712",
                                                                                                                                                                                                                                                                                                                                                  "Network Error[网络异常，请联系系统管理员]"), THIRD_INFO_ERROR("721",
                                                                                                                                                                                                                                                                                                                                                                                                    "Third Info Error[第三方数据信息验证失败]"), IP_WHITELIST_ERROR("731",
                                                                                                                                                                                                                                                                                                                                                                                                                                                         "IP Whitelist Error[白名单校验失败]"), INFO_SEND_FAIL("741",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "Info Send Fail[消息推送失败]"),

                            ERROR_USER_INFO("1001",
                                            "Error User Info[用户数据信息验证失败]"), ERROR_USER_BY_SSO("1002",
                                                                                              "Error User SSO[SSO用户数据信息验证失败]"), ERROR_USER_BY_APP("1003",
                                                                                                                                                  "Error User APP[APP用户数据信息验证失败]"), ERROR_USER_BY_APP_STEP1("1004",
                                                                                                                                                                                                            "Error User APP Step1[APP用户在调取第三方接口时失败]"), ERROR_USER_BY_APP_STEP2("1005",
                                                                                                                                                                                                                                                                               "Error User APP Step2[APP用户数据调取第三方接口成功但是返回的数据不正确]"), ERROR_USER_BY_OUT("1006",
                                                                                                                                                                                                                                                                                                                                                      "Error User Out[外部用户数据信息验证失败]"),

                            ERROR_USER_KEY("1011",
                                           "Error User Key[用户关键信息错误]"), ERROR_USER_PASSWORD("1012",
                                                                                            "Error User Password[用户密码信息错误]"), ERROR_USER_REAL_NAME("1013",
                                                                                                                                                   "Error User Real Name[需要实名认证绑定]"), ERROR_USER_NEED_LOGIN("1014",
                                                                                                                                                                                                            "Error User Need Login[请用户重新登录]"), ERROR_USER_NEED_FACE("1015",
                                                                                                                                                                                                                                                                    "Error User Need Face[需要人脸识别二次认证]"), ERROR_USER_IDENTITY("1016",
                                                                                                                                                                                                                                                                                                                             "Error User Identity[认证失败，请重新认证]"), ERROR_USER_FACE("1017",
                                                                                                                                                                                                                                                                                                                                                                                 "Error User Face[人脸识别信息与系统不一致]"), ERROR_USER_NEED_REG("1018",
                                                                                                                                                                                                                                                                                                                                                                                                                                       "Error User Need Reg[用户信息未注册，请注册]"), ERROR_PARAMS_MATE("1019",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              "Error Params Mate[传参不匹配]"), ERROR_RETURN_MANY("1020",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             "Error Return Many[查询出多条数据]"), ERROR_NUMBER_FORMAT("1021",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "Error Number Format[数字格式转换异常]"), ERROR_DATA_DUPLICATE("1022",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       "Error Data Duplicate[数据重复]"), ERROR_DATA_FORMAT("1023",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "Error Data Format[数据格式错误]"), ERROR_DATA("1024",
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 "Error Data[数据错误]"),

                            ERROR_ADDRESS_INVALID("1101",
                                                  "Error Address Invalid[无效访问地址]"), ERROR_UPLOAD("1102",
                                                                                                 "Error With Upload[上传出现错误，请联系管理员]"), ERROR_INPUT("1103",
                                                                                                                                                  "Error With Input填写信息错误，请检查]"), ERROR_PASSWORD("1104",
                                                                                                                                                                                                 "Error With Password[密码必须为大小写字母,数字,特殊字符中的至少3种且8位-20位之内]"),

                            ERROR_ENT("1201",
                                      "Error With Enterprise Info[企业关键信息错误]"), ERROR_INIT("1202",
                                                                                          "Error With Not Initial[关键信息未初始化]"),

                            ERROR_IMPORT_TPL("1301", "Error Template Info[模板信息错误]");

    public String code;

    public String msg;

    HttpStatusEnum(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
