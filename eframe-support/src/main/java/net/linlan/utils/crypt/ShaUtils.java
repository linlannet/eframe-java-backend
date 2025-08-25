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
package net.linlan.utils.crypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Description:SHA256加密 解密
 * CreateTime 2020/6/2 10:31
 */
public class ShaUtils {

    /**  加密算法 */
    public final static String  hashAlgorithmName = "SHA-256";
    /**  循环次数 */
    public final static int     hashIterations    = 16;
    /**
     * 解密全局混淆密码的密码
     */
    private static final String SALT              = "Linlan_20230613!";

    /**
     * 利用java原生的类实现SHA256加密
     *
     * @param   content 输入的内容
     * @return  SHA256之后的内容
     */
    public static String getSHA256(String content) {
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            messageDigest = MessageDigest.getInstance(hashAlgorithmName);
            messageDigest.update(content.getBytes("UTF-8"));
            encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodestr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes    字符流
     * @return    返回结果
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    // shuxiaobo add 20250205 保存BCryptPasswordEncoder的密码
    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptBcryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesBcryptPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public static void main(String[] args) {
        System.out.println(ShaUtils.getSHA256(SALT));
        //0bc78708b2d0e8541cf1ff618e2c5e330c1475ef7c336e22276bc82685725003
        System.out.println(AESUtil.encryptAes(SALT, SALT));
        System.out.println(AESUtil.encryptAes("Linlan_Prod_2024!", SALT));
        //2d62c81540d116040e610777b7186d45836e3f6a8b369be2e7dc4c92d527cc50

        System.out.println(ShaUtils.getSHA256("Z123456"));

    }

}
