package com.shareniu.bbs.common.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;

public class Base64Util {
    public Base64Util() {
    }

    public static String encodeUrlString(String str) {
        return encodeUrlString(str.getBytes(Charsets.UTF_8));
    }

    public static String encodeUrlString(byte[] bytes) {
        return Base64.encodeBase64URLSafeString(bytes);
    }

    public static byte[] encodeUrl(byte[] bytes) {
        return Base64.encodeBase64URLSafe(bytes);
    }

    public static byte[] encodeUrl(String str) {
        return encodeUrl(str.getBytes(Charsets.UTF_8));
    }

    public static byte[] encode(byte[] b) {
        return Base64.encodeBase64(b);
    }

    public static byte[] encode(String b) {
        byte[] bytes = b.getBytes(Charsets.UTF_8);
        return encode(bytes);
    }

    public static String encodeStr(byte[] b) {
        return Base64.encodeBase64String(b);
    }

    public static String encodeStr(String s) throws UnsupportedEncodingException {
        return Base64.encodeBase64String(s.getBytes(Charsets.UTF_8));
    }

    public static String encode(String s, String charset) throws UnsupportedEncodingException {
        if(charset == null) {
            charset = Charset.defaultCharset().toString();
        }

        if(s == null) {
            s = "";
        }

        return new String(Base64.encodeBase64(s.getBytes(charset)), charset);
    }

    public static byte[] decode(byte[] b) {
        return Base64.decodeBase64(b);
    }

    public static byte[] decode(String b) {
        byte[] bytes = b.getBytes(Charsets.UTF_8);
        return decode(bytes);
    }

    public static String decodeStr(byte[] b) {
        return new String(Base64.decodeBase64(b), Charsets.UTF_8);
    }

    public static String decodeString(String s) {
        return new String(Base64.decodeBase64(s), Charsets.UTF_8);
    }

    public static String decode(String s, String charset) throws UnsupportedEncodingException {
        if(charset == null) {
            charset = Charset.defaultCharset().toString();
        }

        return new String(Base64.decodeBase64(s.getBytes(charset)), charset);
    }
}