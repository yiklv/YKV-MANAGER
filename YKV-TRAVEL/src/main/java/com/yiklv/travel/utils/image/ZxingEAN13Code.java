package com.yiklv.travel.utils.image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * <b>Description:</b><br> 条形码
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.utils.image
 * <br><b>ClassName:</b> ZxingEAN13Code
 * <br><b>Date:</b> 2018年3月24日 上午12:26:24
 */
public class ZxingEAN13Code {
    /**
     * 条形码编码
     * @param contents
     * @param width
     * @param height
     * @param imgPath
     */
    public void encode(String contents, int width, int height, String imgPath) {
        //保证最小为70*25的大小
        int codeWidth = Math.max(70, width);
        int codeHeight = Math.max(25, height);
        try {
            //使用EAN_13编码格式进行编码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.EAN_13, codeWidth, codeHeight, null);
            //生成png格式的图片保存到imgPath路径
            MatrixToImageWriter.writeToStream(bitMatrix, "png",
                    new FileOutputStream(imgPath));
            System.out.println("encode success! the img's path is "+imgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析条形码
     * @param imgPath
     * @return
     */
    public String decode(String imgPath) {
        BufferedImage image = null;
        Result result = null;
        try {
            image = ImageIO.read(new File(imgPath));
            if (image == null) {
                System.out.println("the decode image may be not exit.");
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            result = new MultiFormatReader().decode(bitmap, null);
            return result.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String decodeImgPath = "D:/1.png";
        ZxingEAN13Code EAN13Code = new ZxingEAN13Code();
        System.out.println(EAN13Code.decode(decodeImgPath));
        
        String encodeImgPath = "D:/2.png";
        String contents = "6923450657713";
        int width = 150, height = 40;
        EAN13Code.encode(contents, width, height, encodeImgPath);
    }
}