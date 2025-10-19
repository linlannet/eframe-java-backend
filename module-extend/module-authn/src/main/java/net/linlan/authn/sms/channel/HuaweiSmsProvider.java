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
package net.linlan.authn.sms.channel;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.net.ssl.*;

import org.apache.commons.collections4.MapUtils;
import org.springframework.http.HttpStatus;

import com.alibaba.fastjson2.JSONObject;

import lombok.Data;

import net.linlan.authn.sms.vo.SmsConfigVo;
import net.linlan.commons.core.CharsetUtils;
import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.io.IoUtils;
import net.linlan.commons.script.json.JsonUtils;
import net.linlan.utils.exception.CommonException;

/**
 * 华为云短信提供商
 *
 * @author Linlan
 * 
 */
public class HuaweiSmsProvider implements SmsProvider {
    // 无需修改，用于格式化鉴权头域，给"X-WSSE"参数赋值
    private static final String WSSE_HEADER_FORMAT = "UsernameToken Username=\"%s\",PasswordDigest=\"%s\",Nonce=\"%s\",Created=\"%s\"";
    // 无需修改，用于格式化鉴权头域，给"Authorization"参数赋值
    private static final String AUTH_HEADER_VALUE  = "WSSE realm=\"SDP\",profile=\"UsernameToken\",type=\"Appkey\"";
    private final SmsConfigVo   smsConfig;

    public HuaweiSmsProvider(SmsConfigVo smsConfig) {
        this.smsConfig = smsConfig;
    }

    @Override
    public void send(String mobile, Map<String, String> params) {
        // 有参数则设置
        String templateParas = null;
        if (MapUtils.isNotEmpty(params)) {
            templateParas = JsonUtils.toJson(params.values().toArray(new String[0]));
        }

        // 请求Body,不携带签名名称时,signature请填null
        String body = buildRequestBody(smsConfig.getSenderId(), "+86" + mobile,
            smsConfig.getTemplateId(), templateParas, null, smsConfig.getSignName());
        if (StringUtils.isBlank(body)) {
            throw new CommonException("body is null.");
        }

        // 请求Headers中的X-WSSE参数值
        String wsseHeader = buildWsseHeader(smsConfig.getAccessKey(), smsConfig.getSecretKey());
        if (StringUtils.isBlank(wsseHeader)) {
            throw new CommonException("wsse header is null.");
        }

        try {
            // 使用 https
            trustAllHttpsCertificates();

            // 接入地址
            String url = smsConfig.getUrl() + "/sms/batchSendSms/v1";
            URL realUrl = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) realUrl.openConnection();
            HostnameVerifier hv = (hostname, session) -> true;
            connection.setHostnameVerifier(hv);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Authorization", AUTH_HEADER_VALUE);
            connection.setRequestProperty("X-WSSE", wsseHeader);
            connection.connect();

            IoUtils.write(connection.getOutputStream(), CharsetUtils.CHARSET_UTF_8, true, body);

            int status = connection.getResponseCode();
            if (status == HttpStatus.OK.value()) {
                String response = IoUtils.readToByte(connection.getInputStream()).toString();
                HuaweiSmsResult result = JSONObject.parseObject(response, HuaweiSmsResult.class);

                // 短信是否发送成功
                assert result != null;
                if (!"000000".equals(result.code)) {
                    throw new CommonException(result.description);
                }
            } else { //400 401
                throw new CommonException(
                    IoUtils.readToByte(connection.getErrorStream()).toString());
            }
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }
    }

    /**
     * 构造请求Body体
     *
     * @param signature | 签名名称,使用国内短信通用模板时填写
     */
    static String buildRequestBody(String sender, String receiver, String templateId,
                                   String templateParas, String statusCallBack, String signature) {
        if (null == sender || null == receiver || null == templateId || sender.isEmpty()
            || receiver.isEmpty() || templateId.isEmpty()) {
            throw new CommonException(
                "buildRequestBody(): sender, receiver or templateId is null.");
        }
        Map<String, String> map = new HashMap<>();

        map.put("from", sender);
        map.put("to", receiver);
        map.put("templateId", templateId);
        if (null != templateParas && !templateParas.isEmpty()) {
            map.put("templateParas", templateParas);
        }
        if (null != statusCallBack && !statusCallBack.isEmpty()) {
            map.put("statusCallback", statusCallBack);
        }
        if (null != signature && !signature.isEmpty()) {
            map.put("signature", signature);
        }

        StringBuilder sb = new StringBuilder();
        String temp = "";

        for (String s : map.keySet()) {
            try {
                temp = URLEncoder.encode(map.get(s), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sb.append(s).append("=").append(temp).append("&");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * 构造X-WSSE参数值
     */
    static String buildWsseHeader(String appKey, String appSecret) {
        if (null == appKey || null == appSecret || appKey.isEmpty() || appSecret.isEmpty()) {
            throw new CommonException("buildWsseHeader(): appKey or appSecret is null.");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String time = sdf.format(new Date());
        String nonce = UUID.randomUUID().toString().replace("-", "");

        MessageDigest md;
        byte[] passwordDigest = null;

        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update((nonce + time + appSecret).getBytes());
            passwordDigest = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String passwordDigestBase64Str = Base64.getEncoder().encodeToString(passwordDigest);

        return String.format(WSSE_HEADER_FORMAT, appKey, passwordDigestBase64Str, nonce, time);
    }

    static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) {

            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {

            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        } };
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    @Data
    static class HuaweiSmsResult {
        // code为000000，表示成功
        private String       code;
        private String       description;
        private List<Object> result;
    }
}
