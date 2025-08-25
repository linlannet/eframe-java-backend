/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.ip;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson2.JSONObject;

import net.linlan.commons.core.StringUtils;
import net.linlan.commons.core.abs.CharsetConstants;
import net.linlan.utils.config.PlatformConfig;
import net.linlan.utils.http.HttpUtils;

/**
 * 获取地址类
 * 
 * @author Linlan
 */
public class IPAddressUtils {
    private static final Logger log     = LoggerFactory.getLogger(IPAddressUtils.class);

    // IP地址查询
    public static final String  IP_URL  = "http://whois.pconline.com.cn/ipJson.jsp";

    // 未知地址
    public static final String  UNKNOWN = "XX XX";

    public static String getRealAddressByIP(String ip) {
        // 内网不查询
        if (IPUtils.internalIp(ip)) {
            return "内网IP";
        }
        if (PlatformConfig.isAddressEnabled()) {
            try {
                String rspStr = HttpUtils.sendGet(IP_URL, "ip=" + ip + "&json=true",
                    CharsetConstants.GBK);
                if (StringUtils.isEmpty(rspStr)) {
                    log.error("获取地理位置异常 {}", ip);
                    return UNKNOWN;
                }
                JSONObject obj = JSONObject.parseObject(rspStr);
                String region = obj.getString("pro");
                String city = obj.getString("city");
                return String.format("%s %s", region, city);
            } catch (Exception e) {
                log.error("获取地理位置异常 {}", ip);
            }
        }
        return UNKNOWN;
    }

    /**
     * 通过城市返回经纬度
     *
     * @param city  城市
     * @return  城市经纬度JSON
     */
    public static String getLatitudeAndLongitude(String city) {
        String BAIDU_URL = "https://api.map.baidu.com/geocoder";
        String baiduResponse = HttpUtils.sendGet(BAIDU_URL, "address=" + city + "&output=json",
            CharsetConstants.GBK);
        if (!StringUtils.isEmpty(baiduResponse)) {
            JSONObject baiduObject = JSONObject.parseObject(baiduResponse);
            JSONObject location = baiduObject.getJSONObject("result").getJSONObject("location");
            BigDecimal longitude = location.getBigDecimal("lng");
            BigDecimal latitude = location.getBigDecimal("lat");
            System.out.println("设置经度：" + longitude + "，设置纬度：" + latitude);
            return String.format("%s %s", longitude, latitude);
        }
        return UNKNOWN;
    }

}
