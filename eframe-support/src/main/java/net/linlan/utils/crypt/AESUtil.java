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
import java.security.Security;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.DecoderException;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.linlan.commons.core.CharsetUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Filename:AESUtil.java
 * Desc: AES非对称加密工具类
 * 用于健康云加密
 * 前后台加解密
 *
 * @author Linlan
 * CreateTime:2/13/20 5:38 PM
 * @version 1.0
 * @since 1.0
 */
public class AESUtil {

    private Logger              logger               = LoggerFactory.getLogger(getClass());

    // 编码
    private static final String ENCODING             = CharsetUtils.UTF_8;
    //算法
    public static final String  ALGORITHM_AES        = "AES";
    public static final String  KEY_AES              = "AES";

    // 默认的加密算法
    public static final String  CIPHER_ALGORITHM     = "AES/CBC/PKCS7Padding";

    public static final String  transformation       = "AES/ECB/NOPadding";

    private static final String ECB_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String CBC_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    public static final int     CODE_BASE64          = 1;
    public static final int     CODE_HEX             = 2;

    /**
     * Convert byte[] to hex string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。
     *
     * @param src byte[] data
     * @return hex string
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * Convert hex string to byte[]
     *
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * Convert char to byte
     *
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /*
     * 加密
     */
    public static String encode(String secret, String iv, String content) throws Exception {
        byte[] secretBytes = secret.getBytes();
        SecretKey secretKey = new SecretKeySpec(secretBytes, ALGORITHM_AES);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] contentBytes = content.getBytes(ENCODING);
        byte[] bytes = cipher.doFinal(contentBytes);
        String encode = new String(new BASE64Encoder().encode(bytes));
        //String encode = bytesToHexString(bytes);
        return encode;
    }

    /*
     * 解密
     */
    public static String decode(String secret, String iv, String content) throws Exception {
        byte[] secretKeyBytes = secret.getBytes();
        SecretKey secretKey = new SecretKeySpec(secretKeyBytes, ALGORITHM_AES);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] contentBytes = new BASE64Decoder().decodeBuffer(content);
        //byte[] contentBytes = hexStringToBytes(content);
        byte[] decodeBytes = cipher.doFinal(contentBytes);
        String decode = new String(decodeBytes, ENCODING);
        return decode;
    }

    /**
     * 解密
     *
     * @param data            待解密数据base64字符串
     * @param secretKeyString aes密钥的base64字符串
     * @param ivString        aes偏移量的base64字符串
     * @return  加密后字符串
     * @throws Exception    异常
     */
    public static String decrypt(String data, String secretKeyString,
                                 String ivString) throws Exception {
        byte[] secretKey = stringTransferToByteArray(secretKeyString);
        byte[] iv = stringTransferToByteArray(ivString);
        Cipher cipher = Cipher.getInstance(CBC_CIPHER_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, KEY_AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
        String result = new String(cipher.doFinal(stringTransferToByteArray(data)));
        return result;
    }

    /**
     * 加密
     *
     * @param data            待加密数据的base64字符串
     * @param secretKeyString aes密钥的base64字符串
     * @param ivString        aes偏移量的base64字符串
     * @return  解密后字符串
     * @throws Exception    异常
     */
    public static String encrypt(String data, String secretKeyString,
                                 String ivString) throws Exception {
        byte[] secretKey = stringTransferToByteArray(secretKeyString);
        byte[] iv = stringTransferToByteArray(ivString);
        Cipher cipher = Cipher.getInstance(CBC_CIPHER_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, KEY_AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
        String result = byteArrayTransferToString(cipher.doFinal(stringTransferToByteArray(data)));
        return result;
    }

    /**
     * byte[]转base64字符串
     *
     * @param bytes 输入流
     * @return  转换后的字符串
     */
    public static String byteArrayTransferToString(byte[] bytes) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bytes);
    }

    /**
     * base64字符串转byte[]
     * @param s 输入字符串
     * @return  流数组
     */
    public static byte[] stringTransferToByteArray(String s) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            return decoder.decode(s.getBytes(ENCODING));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * MySQL  AES解密, 对应mysql语法 ：select AES_DECRYPT(UNHEX(content),password) from dual
     *
     * @param contents  aes解密内容
     * @param password  解密混淆码
     * @return  解密后的字符串
     * @throws DecoderException 异常
     */
    public static String decryptAes(String contents, String password) throws DecoderException {
        try {
            byte[] content = Hex.decode(contents.getBytes());
            SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * * MySQL  AES加密, 对应mysql语法 ：select HEX(AES_DECRYPT(content,password)) from dual
     * @param context   加密内容
     * @param password  加密混淆码
     * @return  加密内容
     * @throws DecoderException 异常
     */
    public static String encryptAes(String context, String password) throws DecoderException {
        byte[] encryptResult = encrypt(context, password);
        //密码文Hex编码
        byte[] encryptResultStr = Hex.encode(encryptResult);
        return new String(encryptResultStr);
    }

    private static byte[] encrypt(String content, String password) throws DecoderException {
        try {
            String private_key = password;
            byte[] encodeFormat = private_key.getBytes();
            try {
                //秘钥 Hex解码为什么秘钥要进行解码，因为秘钥是某个秘钥明文进行了Hex编码后的值，所以在使用的时候要进行解码
            } catch (DecoderException e) {
                e.printStackTrace();
            }
            SecretKeySpec key = new SecretKeySpec(encodeFormat, "AES");
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // 加密内容进行编码
            byte[] byteContent = content.getBytes("UTF8");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 正式执行加密操作
            byte[] result = cipher.doFinal(byteContent);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
