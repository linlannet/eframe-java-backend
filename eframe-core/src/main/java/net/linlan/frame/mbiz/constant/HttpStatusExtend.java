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

import net.linlan.commons.core.http.HttpStatus;

/**
 * Filename:HttpStatusEnum.java
 * Desc:前台Api响应枚举类，支持plat、member 和 pub 三种模式
 * @author Linlan
 * CreateTime:2023/07/20 18:06
 * @version 1.0
 * @since 1.0
 */
public enum HttpStatusExtend {

                              /**
                               * 3100700, Token Error[TOKEN信息错误]
                               */
                              TOKEN_ERROR(3100700, HttpStatus.Series.CLIENT_ERROR,
                                          "Token Error[TOKEN信息错误]"),
                              /**
                               * 3100701, Input Error Code[信息传入有误(code)]
                               */
                              INPUT_ERROR_CODE(3100701, HttpStatus.Series.CLIENT_ERROR,
                                               "Input Error Code[信息传入有误(code)]"),
                              /**
                               * 3100702, Input Error Source[信息传入有误(source)]
                               */
                              INPUT_ERROR_SOURCE(3100702, HttpStatus.Series.CLIENT_ERROR,
                                                 "Input Error Source[信息传入有误(source)]"),
                              /**
                               * 3100703, Account Not Exist[对接平台账户不存在]
                               */
                              ACCOUNT_NOT_EXIST(3100703, HttpStatus.Series.CLIENT_ERROR,
                                                "Account Not Exist[对接平台账户不存在]"),
                              /**
                               *
                               */
                              CHANNEL_NOT_EXIST(3100704, HttpStatus.Series.CLIENT_ERROR,
                                                "Channel Not Exist[该栏目版面不存在]"),
                              /**
                               *
                               */
                              PARAMETER_ERROR(3100705, HttpStatus.Series.CLIENT_ERROR,
                                              "Parameter Error[传递参数信息错误]"),
                              /**
                               *
                               */
                              NETWORK_ERROR(3100706, HttpStatus.Series.CLIENT_ERROR,
                                            "Network Error[网络异常，请联系系统管理员]"),
                              /**
                               *
                               */
                              THIRD_INFO_ERROR(3100721, HttpStatus.Series.CLIENT_ERROR,
                                               "Third Info Error[第三方数据信息验证失败]"),
                              /**
                               *
                               */
                              IP_WHITELIST_ERROR(3100731, HttpStatus.Series.CLIENT_ERROR,
                                                 "IP Whitelist Error[白名单校验失败]"),
                              /**
                               *
                               */
                              INFO_SEND_FAIL(3100741, HttpStatus.Series.CLIENT_ERROR,
                                             "Info Send Fail[消息推送失败]"),
                              /**
                               *
                               */
                              ERROR_USER_INFO(3101001, HttpStatus.Series.CLIENT_ERROR,
                                              "Error User Info[用户数据信息验证失败]"),
                              /**
                               *
                               */
                              ERROR_USER_BY_SSO(3101002, HttpStatus.Series.CLIENT_ERROR,
                                                "Error User SSO[SSO用户数据信息验证失败]"),
                              /**
                               *
                               */
                              ERROR_USER_BY_APP(3101003, HttpStatus.Series.CLIENT_ERROR,
                                                "Error User APP[APP用户数据信息验证失败]"),
                              /**
                               *
                               */
                              ERROR_USER_BY_APP_STEP1(3101004, HttpStatus.Series.CLIENT_ERROR,
                                                      "Error User APP Step1[APP用户在调取第三方接口时失败]"),
                              /**
                               *
                               */
                              ERROR_USER_BY_APP_STEP2(3101005, HttpStatus.Series.CLIENT_ERROR,
                                                      "Error User APP Step2[APP用户数据调取第三方接口成功但是返回的数据不正确]"),
                              /**
                               *
                               */
                              ERROR_USER_BY_OUT(3101006, HttpStatus.Series.CLIENT_ERROR,
                                                "Error User Out[外部用户数据信息验证失败]"),
                              /**
                               *
                               */
                              ERROR_USER_KEY(3101011, HttpStatus.Series.CLIENT_ERROR,
                                             "Error User Key[用户关键信息错误]"),
                              /**
                               *
                               */
                              ERROR_USER_PASSWORD(3101012, HttpStatus.Series.CLIENT_ERROR,
                                                  "Error User Password[用户密码信息错误]"),
                              /**
                               *
                               */
                              ERROR_USER_REAL_NAME(3101013, HttpStatus.Series.CLIENT_ERROR,
                                                   "Error User Real Name[需要实名认证绑定]"),
                              /**
                               *
                               */
                              ERROR_USER_NEED_LOGIN(3101014, HttpStatus.Series.CLIENT_ERROR,
                                                    "Error User Need Login[请用户重新登录]"),
                              /**
                               *
                               */
                              ERROR_USER_NEED_FACE(3101015, HttpStatus.Series.CLIENT_ERROR,
                                                   "Error User Need Face[需要人脸识别二次认证]"),
                              /**
                               *
                               */
                              ERROR_USER_IDENTITY(3101016, HttpStatus.Series.CLIENT_ERROR,
                                                  "Error User Identity[认证失败，请重新认证]"),
                              /**
                               *
                               */
                              ERROR_USER_FACE(3101017, HttpStatus.Series.CLIENT_ERROR,
                                              "Error User Face[人脸识别信息与系统不一致]"),
                              /**
                               *
                               */
                              ERROR_USER_NEED_REG(3101018, HttpStatus.Series.CLIENT_ERROR,
                                                  "Error User Need Reg[用户信息未注册，请注册]"),
                              /**
                               *
                               */
                              ERROR_PARAMS_MATE(3101019, HttpStatus.Series.CLIENT_ERROR,
                                                "Error Params Mate[传参不匹配]"),
                              /**
                               *
                               */
                              ERROR_RETURN_MANY(3101020, HttpStatus.Series.CLIENT_ERROR,
                                                "Error Return Many[查询出多条数据]"),
                              /**
                               *
                               */
                              ERROR_NUMBER_FORMAT(3101021, HttpStatus.Series.CLIENT_ERROR,
                                                  "Error Number Format[数字格式转换异常]"),
                              /**
                               *
                               */
                              ERROR_DATA_DUPLICATE(3101022, HttpStatus.Series.SERVER_ERROR,
                                                   "Error Data Duplicate[数据重复]"),
                              /**
                               *
                               */
                              ERROR_DATA_FORMAT(3101023, HttpStatus.Series.SERVER_ERROR,
                                                "Error Data Format[数据格式错误]"),
                              /**
                               *
                               */
                              ERROR_DATA(3101024, HttpStatus.Series.SERVER_ERROR,
                                         "Error Data[数据错误]"),
                              /**
                               *
                               */
                              ERROR_ADDRESS_INVALID(3101101, HttpStatus.Series.SERVER_ERROR,
                                                    "Error Address Invalid[无效访问地址]"),
                              /**
                               *
                               */
                              ERROR_UPLOAD(3101102, HttpStatus.Series.SERVER_ERROR,
                                           "Error With Upload[上传出现错误，请联系管理员]"),
                              /**
                               *
                               */
                              ERROR_INPUT(3101103, HttpStatus.Series.SERVER_ERROR,
                                          "Error With Input填写信息错误，请检查]"),
                              /**
                               *
                               */
                              ERROR_PASSWORD(3101104, HttpStatus.Series.SERVER_ERROR,
                                             "Error With Password[密码必须为大小写字母,数字,特殊字符中的至少3种且8位-20位之内]"),
                              /**
                               *
                               */
                              ERROR_ENT(3101201, HttpStatus.Series.SERVER_ERROR,
                                        "Error With Enterprise Info[企业关键信息错误]"),
                              /**
                               *
                               */
                              ERROR_INIT(3101202, HttpStatus.Series.SERVER_ERROR,
                                         "Error With Not Initial[关键信息未初始化]"),
                              /**
                               *
                               */
                              ERROR_IMPORT_TPL(3101301, HttpStatus.Series.SERVER_ERROR,
                                               "Error Template Info[模板信息错误]");

    public final int                code;

    private final HttpStatus.Series series;

    public final String             msg;

    HttpStatusExtend(int code, HttpStatus.Series series, String message) {
        this.code = code;
        this.series = series;
        this.msg = message;
    }

    public int getCode() {
        return code;
    }

    /**
     * Return the HTTP status series of this status code.
     * @see HttpStatus.Series
     */
    public HttpStatus.Series getSeries() {
        return this.series;
    }

    public String getMsg() {
        return msg;
    }
}
