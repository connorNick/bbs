package com.shareniu.bbs.common.util;

import java.security.MessageDigest;

public class MD5 {
    public MD5() {
    }

    public static String md5(String text, String key) throws Exception {
        byte[] bytes = (text + key).getBytes();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bytes);
        bytes = messageDigest.digest();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < bytes.length; ++i) {
            if((bytes[i] & 255) < 16) {
                sb.append("0");
            }

            sb.append(Long.toString((long)(bytes[i] & 255), 16));
        }

        return sb.toString().toLowerCase();
    }

    public static boolean verify(String text, String key, String md5) throws Exception {
        String md5Text = md5(text, key);
        return md5Text.equalsIgnoreCase(md5);
    }

    public static void main(String[] args) throws Exception {
        String a = "dddddddddddddddddddddddddddfasdfasORDER000123145";
        String md5 = md5(a, "test");
        System.out.println(md5);
        System.out.println("length:" + md5.length());
        System.out.println(verify(a, "test", md5));
    }
}
