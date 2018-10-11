package com.yiklv.travel.utils.image.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.utils.image.code
 * <br><b>ClassName:</b> RandomValidateCode
 * <br><b>Date:</b> 2018年3月24日 下午6:32:35
 */
public class RandomValidateCode {

    public static String       validateCode  = null;
    public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";                // 放到session中的key
    private Random             random        = new Random();
    private String             randString    = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 随机产生的字符串

    private int                width         = 80;                                     // 图片宽
    private int                height        = 26;                                     // 图片高
    private int                lineSize      = 40;                                     // 干扰线数量
    private int                stringNum     = 4;                                      // 随机产生字符数量

    
    /**
     * 
     * <b>Description:</b><br> 获得字体
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月24日 下午6:32:57
     * <br><b>Version:</b> 1.0
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
    }

    /**
     * 
     * <b>Description:</b><br> 获得颜色
     * @param fc
     * @param bc
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月24日 下午6:33:16
     * <br><b>Version:</b> 1.0
     */
    private Color getRandColor(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 
     * <b>Description:</b><br> 生成随机图片
     * @param request
     * @param response
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月24日 下午6:33:27
     * <br><b>Version:</b> 1.0
     */
    public void getRandcode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        g.setColor(getRandColor(110, 133));
        // 绘制干扰线
        for (int i = 0; i <= lineSize; i++) {
            drowLine(g);
        }
        // 绘制随机字符
        String randomString = "";
        for (int i = 1; i <= stringNum; i++) {
            randomString = drowString(g, randomString, i);
        }
        session.removeAttribute(RANDOMCODEKEY);
        session.setAttribute(RANDOMCODEKEY, randomString);
        validateCode = randomString.toUpperCase();
        g.dispose();
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * <b>Description:</b><br> 绘制字符串
     * @param g
     * @param randomString
     * @param i
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月24日 下午6:35:00
     * <br><b>Version:</b> 1.0
     */
    private String drowString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));
        randomString += rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13 * i, 16);
        return randomString;
    }

    /**
     * 
     * <b>Description:</b><br>绘制干扰线 
     * @param g
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月24日 下午6:35:11
     * <br><b>Version:</b> 1.0
     */
    private void drowLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }
    
    /**
     * 
     * <b>Description:</b><br> 获取随机的字符
     * @param num
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月24日 下午6:35:20
     * <br><b>Version:</b> 1.0
     */
    public String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }
}
