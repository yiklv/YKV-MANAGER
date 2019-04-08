package com.yiklv.trvAdmin.utils.image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN8Encoder;
import org.jbarcode.paint.EAN8TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

/**
 * 支持EAN13, EAN8, UPCA, UPCE, Code 3 of 9, Codabar, Code 11, Code 93, Code 128,
 * MSI/Plessey, Interleaved 2 of PostNet等
 */
/**
 * 
 * <b>Description:</b><br/> 生成条形码(条形码下方包含  本身的含义，即：条码下方有数字字母等) <br/>
 * 支持EAN13, EAN8, UPCA, UPCE, Code 3 of 9, Codabar, Code 11, Code 93, Code 128, MSI/Plessey,<br/> Interleaved 2 of PostNet等
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.utils.image
 * <br><b>ClassName:</b> JBarcodeByEAN8Util
 * <br><b>Date:</b> 2018年3月24日 上午12:33:49
 */
public class JBarcodeByEAN8Util {

    public void encodeByEAN8(String content, String imgPath, int with,
            int height) {
        try {
            JBarcode jBarcode = new JBarcode(EAN8Encoder.getInstance(),
                    WidthCodedPainter.getInstance(), EAN8TextPainter.getInstance());
            BufferedImage bufferedImage = jBarcode.createBarcode(content);
            FileOutputStream outputStream = new FileOutputStream(imgPath);
            ImageUtil.encodeAndWrite(bufferedImage, "jpeg", outputStream, with,height);
            outputStream.close();
            System.out.println("===");
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public static void main(String[] paramArrayOfString) {
        /*JBarcodeByEAN8Util jBarCodeUtil = new JBarcodeByEAN8Util();
        jBarCodeUtil.encodeByEAN8("110120119", "D:/EAN8.jpg", 100, 70);*/
        System.out.println(computeCheckSum("110120119"));
    }
    
    
    
    public static String computeCheckSum(String s)
        {
            int i = 0;
            boolean flag = true;
            for(int j = s.length() - 1; j >= 0; j--)
            {
                if(flag)
                    i += 3 * charToInt(s.charAt(j));
                else
                    i += charToInt(s.charAt(j));
                flag = !flag;
            }

            int k = i % 10;
            if(k == 0)
                return "0";
            else
                return Integer.toString(10 - k);
        }
    
    
    protected static int charToInt(char c)
            throws NumberFormatException
        {
            if(!Character.isDigit(c))
                throw new NumberFormatException("Invalid number");
            else
                return c - 48;
        }
}