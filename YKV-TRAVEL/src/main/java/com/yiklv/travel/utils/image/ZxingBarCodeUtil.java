package com.yiklv.travel.utils.image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionMapping;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
/**
 * 
 * <b>Description:</b><br> 根据字符串生成条形码
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.utils.image
 * <br><b>ClassName:</b> ZxingBarCodeUtil
 * <br><b>Date:</b> 2018年3月24日 上午12:30:38
 */
public class ZxingBarCodeUtil {
    /**
     * 根据字符串生成条形码
     * 
     * @param code字符串
     * @return
     */
    public static BitMatrix getShapeCode(String code) {
        // 编码条形码
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "GBK");
        BitMatrix matrix = null;
        try {
            // 使用code_128格式进行编码生成100*25的条形码
            matrix = new MultiFormatWriter().encode(code,
                    BarcodeFormat.CODE_128, 100, 25, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    /** 获取条形码 */
    /*public void getShapeCode(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        BitMatrix matrix = this.getShapeCode(request.getParameter("printCode"));
        // 返回png图片流
        // 获得Servlet输出流
        ServletOutputStream outStream = null;
        try {
            outStream = response.getOutputStream();
            ImageIO.write(MatrixToImageWriter.toBufferedImage(matrix), "png",
                    outStream);
            outStream.flush();
            // 关闭输出流
            outStream.close();
        } catch (IOException e) {
            String simplename = e.getClass().getSimpleName();
            if (!"ClientAbortException".equals(simplename)) {
                e.printStackTrace();
            }
        }
    }*/

    /*public static void main(String[] args) {
        BufferedImage buff = MatrixToImageWriter
                .toBufferedImage(getShapeCode("TG201603280003"));// 123
        try {
            ImageIO.write(buff, "png", new File("D://1.png"));
            System.out.println("已生成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}