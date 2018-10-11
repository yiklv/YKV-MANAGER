package com.yiklv.travel.utils.image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 
 * <b>Description:</b><br> 二维码生成/解码器
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.utils.image
 * <br><b>ClassName:</b> ZxingQRCode
 * <br><b>Date:</b> 2018年3月24日 上午12:30:06
 */
public class ZxingQRCode {

    /**
     * 生成二维码
     * @param contents
     * @param width
     * @param height
     * @param imgPath
     */
    public void encode(String contents, int width, int height, String imgPath) {
        Hashtable<EncodeHintType, Object> hints = new Hashtable();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        // 指定显示格式为GBK
        hints.put(EncodeHintType.CHARACTER_SET, "GBK");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.QR_CODE, width, height, hints);
            //生成png格式的图片保存到imgPath路径位置
            MatrixToImageWriter.writeToStream(bitMatrix, "png",
                    new FileOutputStream(imgPath));
            System.out.println("QR Code encode sucsess! the img's path is "+imgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析二维码
     * @param imgPath
     * @return
     */
    public String decode(String imgPath) {
        BufferedImage image = null;
        Result result = null;
        try {
            //读取图片
            image = ImageIO.read(new File(imgPath));
            if (image == null) {
                System.out.println("the decode image may be not exit.");
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Hashtable<DecodeHintType, Object> hints = new Hashtable();
            //设置显示格式为GBK
            hints.put(DecodeHintType.CHARACTER_SET, "GBK");
            //进行解码
            result = new MultiFormatReader().decode(bitmap, hints);
            return result.getText();//返回结果信息
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ZxingQRCode ORCode = new ZxingQRCode();
        ORCode.encode("http://www.cnblogs.com/zhaoyhBlog/", 150, 150,
                "D:/二维码1.png");

        System.out.println(ORCode.decode("D:/二维码1.png"));
    }
}