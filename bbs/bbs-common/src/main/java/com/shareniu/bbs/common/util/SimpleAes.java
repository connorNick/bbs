package com.shareniu.bbs.common.util;

import org.apache.commons.lang.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * simple aes
 *
 * Created by wzy on 2015/3/16.
 */
public class SimpleAes {
    private static byte[] ENC_KEY_BYTES = "This is a finger".getBytes();

    public static String encode(String encKey, String secret) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] kbytes = SimpleAes.ENC_KEY_BYTES;
        if (StringUtils.isNotBlank(encKey)) {
            kbytes = encKey.getBytes();
        }
        SecretKeySpec key = new SecretKeySpec(kbytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encoding = cipher.doFinal(secret.getBytes());
        BigInteger n = new BigInteger(encoding);
        return n.toString(16);
    }

    public static String encode(String secret) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return SimpleAes.encode(null, secret);
    }

    public static String decode(String encKey, String secret) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] kbytes = SimpleAes.ENC_KEY_BYTES;
        if (StringUtils.isNotBlank(encKey)) {
            kbytes = encKey.getBytes();
        }
        SecretKeySpec key = new SecretKeySpec(kbytes, "AES");
        BigInteger n = new BigInteger(secret, 16);
        byte[] encoding = n.toByteArray();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decode = cipher.doFinal(encoding);
        return new String(decode);
    }

    public static char[] decode(String secret) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return SimpleAes.decode(null, secret).toCharArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(SimpleAes.encode(MD5.md5("SDK-WSS-010-07929", "eea644-]")));
        System.out.println(SimpleAes.decode("-fcb157b3a3cb585734ed1a62de8aa94d71c2365b351cc1c8392691b719c402e6b702c9cf7a1c7ab6d0f5dc3b728af68"));
    }
}
