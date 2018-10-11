package com.yiklv.travel.utils.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import sun.misc.BASE64Decoder;

/**
 * @ClassName:  EncryptUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 一科律科技  
 * @date:   2018年6月10日 下午11:52:06   
 *     
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved. 
 * 注意：本内容仅限于一科律科技公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class EncryptUtil {
    private static final String KEY          = "abcdefgabcdefg12";
    private static final String IV          = KEY;
    private static final String KEY_ALGORITHM = "AES";
    private static final String ALGORITHMSTR_ECB = "AES/ECB/PKCS5Padding";
    private static final String ALGORITHMSTR_CBC = "AES/CBC/PKCS5Padding";

    public static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static byte[] base64Decode(String base64Code) throws Exception {
        return new BASE64Decoder().decodeBuffer(base64Code);
    }

    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR_ECB);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), KEY_ALGORITHM));

        return cipher.doFinal(content.getBytes("utf-8"));
    }

    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
        kgen.init(128);

        Cipher cipher = Cipher.getInstance(ALGORITHMSTR_ECB);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), KEY_ALGORITHM));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);
    }

    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }
    
    
    public static String encryptCryptoJS(String content, String key) throws Exception {
        try {

            Key keySpec = new SecretKeySpec(key.getBytes(), KEY_ALGORITHM);    //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES

            String iv   = IV;//初始化向量参数，AES 为16bytes. DES 为8bytes.

            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

            Cipher cipher = Cipher.getInstance(ALGORITHMSTR_CBC);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec,ivSpec);
            //Cipher cipher = AesUtil.generateCipher(Cipher.ENCRYPT_MODE,"1234567890123456".getBytes(),"1234567890123456".getBytes());

            byte[] byteResult = cipher.doFinal(content.getBytes());

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteResult.length; i++) {
                String hex = Integer.toHexString(byteResult[i] & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                sb.append(hex.toUpperCase());
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Title: AES_CBC_Decrypt   
     * @Description: TODO(AES CBC模式解密)   
     * @param: @param mode
     * @param: @param crypto
     * @param: @param key
     * @param: @param iv
     * @param: @return
     * @param: @throws Exception      
     * @return: String      
     * @throws
     */
    public static String AES_CBC_Decrypt(String crypto, byte[] key, byte[] iv) throws Exception{
        byte[] data = Hex.decodeHex(crypto.toCharArray());
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR_CBC);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
        byte[] reByte = cipher.doFinal(data);
        return new String(reByte);
    }
    
    
    public static byte[] AES_CBC_Decrypt(byte[] data, byte[] key, byte[] iv) throws Exception{
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE, key, iv);
        return cipher.doFinal(data);
    }

    private static Cipher getCipher(int mode, byte[] key, byte[] iv) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR_CBC);

        SecretKeySpec secretKeySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        cipher.init(mode, secretKeySpec, new IvParameterSpec(iv));

        return cipher;
    }

    /**
     * 测试
     * 
     */
    public static void main(String[] args) throws Exception {

        /*String content = "zhangsan"; // 0gqIDaFNAAmwvv3tKsFOFf9P9m/6MWlmtB8SspgxqpWKYnELb/lXkyXm7P4sMf3e
        System.out.println("加密前：" + content);

        System.out.println("加密密钥和解密密钥：" + KEY);

        String encrypt = aesEncrypt(content, KEY);
        System.out.println(encrypt.length() + ":加密后：" + encrypt);

        String decrypt = aesDecrypt(encrypt, KEY);
        System.out.println("解密后：" + decrypt);*/
        
        /*String encryptCrypto =encryptCryptoJS("08a3367dd9a317a9f82e4391ef87d105", "dufy20170329java");
        System.out.println(encryptCrypto);
        */
      //传给crypto的key、iv要使用base64格式
        //ZGIyMTM5NTYxYzlmZTA2OA==
        byte[] bytes = "dufy20170329java".getBytes();
        String base64Str = Base64.encodeBase64String(bytes);
        System.out.println(base64Str);

        String crypto = "c3de2ab197113316ba886ad4ab49c581";
        /*byte[] data = Hex.decodeHex(crypto.toCharArray());
        byte[] s = AES_CBC_Decrypt(data, bytes, bytes);
        System.out.println(new String(s));*/
        String s = AES_CBC_Decrypt(crypto, bytes, bytes);
        System.out.println(s);
    }
}
