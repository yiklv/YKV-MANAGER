/** 
 * @Project: travel
 * @Title: ImageUtils.java  
 * @Package com.yiklv.travel.utils.image
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月23日 下午9:18:09  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.trvAdmin.utils.image;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.utils.image <br>
 *       <b>ClassName:</b> ImageUtils <br>
 *       <b>Date:</b> 2018年3月23日 下午9:18:09
 */
public class ImageUtils {
    private static Log LOGGER = LogFactory.getLog(ImageUtils.class);
    /**
     * 图片转换成二进制字符串
     *
     * @param imageUrl
     *            图片url
     * @return String 二进制流
     */
    public static String getImgeHexStringByUrl(String imageUrl) {
        String res = null;
        try {
            int httpResult = 0; // 服务器返回的状态
            URL url = new URL(imageUrl); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn = (HttpURLConnection) urlconn;
            httpResult = httpconn.getResponseCode();
            if (httpResult != HttpURLConnection.HTTP_OK) // 不等于HTTP_OK则连接不成功
                LOGGER.info("ImageUtils error: HTTP is faild and status is :  " + httpResult);
            else {
                BufferedInputStream bis = new BufferedInputStream(urlconn.getInputStream());
                BufferedImage bm = ImageIO.read(bis);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                String type = imageUrl.substring(imageUrl.lastIndexOf(".")+1);//imageUrl.substring(imageUrl.length() - 3);
                ImageIO.write(bm, type, bos);
                bos.flush();
                byte[] data = bos.toByteArray();
                res = byte2hex(data);
                bos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 本地图片转换成二进制字符串
     *
     * @param imageUrl
     *            图片url
     * @return String 二进制流
     */
    public static String getImgeHexStringByLocalUrl(String imageUrl) {
        String res = null;

        try {
            File imageFile = new File(imageUrl);
            InputStream inStream = new FileInputStream(imageFile);
            BufferedInputStream bis = new BufferedInputStream(inStream);
            BufferedImage bm = ImageIO.read(bis);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            String type = imageUrl.substring(imageUrl.lastIndexOf(".")+1);
            ImageIO.write(bm, type, bos);
            bos.flush();
            byte[] data = bos.toByteArray();
            res = byte2hex(data);
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * @title 根据二进制字符串生成图片
     * @param data
     *            生成图片的二进制字符串
     * @param fileName
     *            图片名称(完整路径)
     * @param type
     *            图片类型
     * @return
     */
    public static void saveImage(String data, String fileName, String type) {

        BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_BYTE_BINARY);
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, byteOutputStream);
            // byte[] date = byteOutputStream.toByteArray();
            byte[] bytes = hex2byte(data);
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            file.write(bytes);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反格式化byte
     *
     * @param s
     * @return
     */
    public static byte[] hex2byte(String s) {
        byte[] src = s.toLowerCase().getBytes();
        byte[] ret = new byte[src.length / 2];
        for (int i = 0; i < src.length; i += 2) {
            byte hi = src[i];
            byte low = src[i + 1];
            hi = (byte) ((hi >= 'a' && hi <= 'f') ? 0x0a + (hi - 'a') : hi - '0');
            low = (byte) ((low >= 'a' && low <= 'f') ? 0x0a + (low - 'a') : low - '0');
            ret[i / 2] = (byte) (hi << 4 | low);
        }
        return ret;
    }

    /**
     * 格式化byte
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] out = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            byte c = b[i];
            out[i * 2] = Digit[(c >>> 4) & 0X0F];
            out[i * 2 + 1] = Digit[c & 0X0F];
        }

        return new String(out);
    }

    /*
     * 图片转换为二进制base64
     *
     * @param fileName
     *            本地图片路径
     * @return
     *       图片二进制流
     * */
    public static String transformImageToBase64(String path, String fileName) {
        String fullFile = path + File.separator + fileName;
        File f = new File(fullFile);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String imgType = fileName.substring(fileName.lastIndexOf(".")+1);
            ImageIO.write(bi, imgType, baos);
            byte[] bytes = baos.toByteArray();
            return Base64.encodeBase64String(bytes);
            //return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            LOGGER.info("ImageUtils.transformImageToBase64() is exception and exceptin message : " + e.getMessage());
        }
        return null;
    }

    /*
     * 图片转换为二进制
     *
     * @param fileName
     *            本地图片路径
     * @return
     *       图片二进制流
     * */
    public static byte[] transformImageToBinary(String path, String fileName) {
        String fullFile = path + File.separator + fileName;
        File f = new File(fullFile);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String imgType = fileName.substring(fileName.lastIndexOf(".")+1);
            ImageIO.write(bi, imgType, baos);
            byte[] bytes = baos.toByteArray();
            return bytes;
            //return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            LOGGER.info("ImageUtils.transformImageToBinary() is exception and exceptin message : " + e.getMessage());
        }
        return null;
    }

    /**
     * 将二进制转换为图片
     *
     * @param base64String
     *            图片二进制流
     *
     */
    public static void transformToImage(String base64String, String path, String imgName) {
        try {
            byte[] bytes1 = Base64.decodeBase64(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File(path + File.separator + imgName);// 可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", w2);// 不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            LOGGER.info("ImageUtils.transformToImage() is exception and exceptin message : " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        String fileName = "C:\\Users\\thinkpad\\Pictures\\timg.jpg";
        //String url = "http://images.cnitblog.com/blog/536814/201412/051633343733092.png";
        String outImage = "C:\\Users\\thinkpad\\Pictures\\timg1.png";

        String res = transformImageToBase64("C:\\Users\\thinkpad\\Pictures", "timg1.png");
        System.out.println("args = [" + res + "]");

        /*
         * url形式
         * */
//        String result = getImgeHexStringByUrl(url);
//        System.out.println(result);
//        saveImage(result,fileName,"png");
        /*
         * 本地图片形式
         * */
        /*String result1 = getImgeHexStringByLocalUrl(fileName);
        System.out.println(result1);
        saveImage(result1,outImage,"png");*/
    }

}
