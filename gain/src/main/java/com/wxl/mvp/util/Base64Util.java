package com.wxl.mvp.util;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Copyright：贵州玄机科技有限公司
 * Created by wxl on 2020/8/11 16:26
 * Description：
 * Modify time：
 * Modified by：
 */
public class Base64Util {


    /**
     * 编码
     *
     * @param message 需编码的信息
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encodeWord(String message) throws UnsupportedEncodingException {
        return Base64.encodeToString(message.getBytes("utf-8"), Base64.NO_WRAP);
    }

    /**
     * 解码
     *
     * @param encodeWord 编码后的内容
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decodeWord(String encodeWord) throws UnsupportedEncodingException {
        return new String(Base64.decode(encodeWord, Base64.NO_WRAP), "utf-8");
    }

}
