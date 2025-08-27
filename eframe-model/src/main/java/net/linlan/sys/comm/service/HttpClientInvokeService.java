/*
 * eframe-model - model模型数据模块
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
package net.linlan.sys.comm.service;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

import net.linlan.utils.constant.Constants;
import net.linlan.utils.crypt.ShaUtils;
import static net.linlan.utils.constant.Constants.TOKEN_KEY;

@Slf4j
@Service
public class HttpClientInvokeService {

    public String doPost(String url, String token, MultipartFile file) {
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String responseContent = null;
        try {
            HttpPost httppost = new HttpPost(url);
            String nonce = "123456789abcdefg";
            String timeStamp = System.currentTimeMillis() / 1000L + "";
            //签名
            String sign_date = String.format("%s%s%s,%s,%s,%s,%s%s", timeStamp, token, nonce, token,
                "", "", "", timeStamp);
            String sign = ShaUtils.getSHA256(sign_date).toUpperCase();
            httppost.addHeader("x-ll-uid", token);
            httppost.addHeader("x-ll-timestamp", timeStamp);
            httppost.addHeader("x-ll-signature", sign);
            httppost.addHeader("x-ll-nonce", nonce);
            httppost.addHeader(Constants.ACCOUNT_KEY, token);
            //            FileBody fileBody = new FileBody(file);
            httppost.addHeader(TOKEN_KEY, token);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();//.addPart("file", fileBody).build();
            builder.setCharset(Charset.forName("UTF-8"));
            //            builder.addBinaryBody(file.getOriginalFilename())
            builder.addBinaryBody("file", file.getInputStream(), ContentType.MULTIPART_FORM_DATA,
                file.getOriginalFilename());// 文件流
            HttpEntity reqEntity = builder.build();
            httppost.setEntity(reqEntity);

            response = httpclient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                responseContent = EntityUtils.toString(resEntity, "UTF-8");
                log.info("上传文件返回结果：{}", responseContent);
            }
            EntityUtils.consume(resEntity);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
}
