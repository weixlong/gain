package com.wxl.mvp.util;

import java.security.MessageDigest;

/**
 * Copyright：贵州玄机科技有限公司
 * Created by wxl on 2020/7/20 11:08
 * Description：
 * Modify time：
 * Modified by：
 */
public class MD5Util {
    private static char sHexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getMD5(String source) {
        try {
            byte[] bytes = source.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            md.update(bytes);
            // 获得密文
            byte[] mdBytes = md.digest();
            // 把密文转换成十六进制的字符串形式
            int length = mdBytes.length;
            char[] chars = new char[length * 2];
            int k = 0;
            for (int i = 0; i < length; i++) {
                byte byte0 = mdBytes[i];
                chars[k++] = sHexDigits[byte0 >>> 4 & 0xf];
                chars[k++] = sHexDigits[byte0 & 0xf];
            }
            return new String(chars);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
