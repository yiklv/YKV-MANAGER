/** 
 * @Project: travel
 * @Title: StringUtils.java  
 * @Package com.yiklv.travel.utils.str
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月23日 下午9:07:10  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.utils.str;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;


/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.utils.str <br>
 *       <b>ClassName:</b> StringUtils <br>
 *       <b>Date:</b> 2018年3月23日 下午9:07:10
 */
public class StringUtils {
    
    private final static String ERROR = "error";
    private final static String ERRORMSG = "errorMsg";
    private final static String SUCCESSFLAG = "Success";
    private final static String SUCCESSMSG = "SuccessMsg";
    /**
     * @Title: isEmpty   
     * @Description: TODO(判断空)   
     * @param: @param str
     * @param: @return      
     * @return: boolean      
     * @throws
     */
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str)){
            return true;
        }
        return false;
    }
    
    /**
     * @Title: base64Decode   
     * @Description: TODO(Str转换成base64)   
     * @param: @param base64Code
     * @param: @return
     * @param: @throws Exception      
     * @return: String      
     * @throws
     */
    public static String base64Encode(String base64Code) throws Exception {
        if(isEmpty(base64Code)){
            throw new Exception();
        }
        String result = Base64.encodeBase64String(base64Code.getBytes());
        result = result.replaceAll("[\\s*\t\n\r]", "");
        return result;
    }
    /**
     * 
     * @Title: base64encode   
     * @Description: TODO(Base64加密)   
     * @param: @param message
     * @param: @return      
     * @return: String      
     * @throws
     */
    public static String base64encode(String message) {  
        try {
            if(isEmpty(message)){
                throw new RuntimeException();
            }
            byte[] encodeBase64 = Base64.encodeBase64(message.getBytes("UTF-8"));  
            return new String(encodeBase64);  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException();  
        }  
  
    }
    /**
     * 
     * @Title: base64decode   
     * @Description: TODO(Base64解密)   
     * @param: @param message
     * @param: @return      
     * @return: String      
     * @throws
     */
    public static String base64decode(String message) { 
        if(isEmpty(message)){
            throw new RuntimeException();
        }
        byte[] encodeBase64 = Base64.decodeBase64(message);  
        return new String(encodeBase64);  
  
    }  
    
    
    /**
     * 
     * <b>Description:</b><br>
     * 左补0
     * 
     * @param param
     *            参数
     * @param num
     *            补的位数
     * @return
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月23日 下午9:13:39 <br>
     *       <b>Version:</b> 1.0
     */
    public static String leftFillStr(int param, int num) {
        // 得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        // 设置是否使用分组
        nf.setGroupingUsed(false);
        // 设置最大整数位数
        nf.setMaximumIntegerDigits(num);
        // 设置最小整数位数
        nf.setMinimumIntegerDigits(num);

        return nf.format(param);
    }
    /**
     * 
     * <b>Description:</b><br> 防止sql注入
     * @param s
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月24日 下午10:15:06
     * <br><b>Version:</b> 1.0
     */
    public final static String filterSQLInjection(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        try {
            s = s.trim().replaceAll("</?[s,S][c,C][r,R][i,I][p,P][t,T]>?", "");// script
            s = s.trim().replaceAll("[a,A][l,L][e,E][r,R][t,T]\\(", "").replace("\"", "");// alert
            s = s.trim().replace("\\.swf", "").replaceAll("\\.htc", "");
            s = s.trim().replace("\\.php\\b", "").replaceAll("\\.asp\\b", "");
            s = s.trim().replace("document\\.", "").replaceAll("[e,E][v,V][a,A][l,L]\\(", "");
            s = s.trim().replaceAll("'", "").replaceAll(">", "");
            s = s.trim().replaceAll("<", "").replaceAll("=", "");
            s = s.trim().replaceAll(" [o,O][r,R]", "");
            s = s.trim().replaceAll("etc/", "").replaceAll("cat ", "");
            s = s.trim().replaceAll("/passwd ", "");
            s = s.trim().replaceAll("sleep\\(", "").replaceAll("limit ", "").replaceAll("LIMIT ", "");
            s = s.trim().replaceAll("[d,D][e,E][l,L][e,E][t,T][e,E] ", "");// delete
            s = s.trim().replaceAll("[s,S][e,E][l,L][e,E][c,C][t,T] ", "");// select;
            s = s.trim().replaceAll("[u,U][p,P][d,D][a,A][t,T][e,E] ", "");// update
            s = s.trim().replaceAll("[d,D][e,E][l,L][a,A][y,Y] ", "").replaceAll("waitfor ", "");
            s = s.trim().replaceAll("print\\(", "").replaceAll("md5\\(", "");
            s = s.trim().replaceAll("cookie\\(", "").replaceAll("send\\(", "");
            s = s.trim().replaceAll("response\\.", "").replaceAll("write\\(", "").replaceAll("&", "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return s;
    }
    
    /**
     * @Title: errorParam   
     * @Description: TODO(返回错误的结果方法)   
     * @param: @param error
     * @param: @param erroMessage
     * @param: @return      
     * @return: Map<String,Object>      
     * @throws
     */
    public static Map<String, Object> errorParam(String error, String erroMessage){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put(ERROR, error);
        resultMap.put(ERRORMSG, erroMessage);
        return resultMap;
    }
    /**
     * @Title: resultParam   
     * @Description: TODO(返回结果集方法)   
     * @param: @param error
     * @param: @param erroMessage
     * @param: @return      
     * @return: Map<String,Object>      
     * @throws
     */
    public static Map<String, Object> resultParam(String successFlag, String successMsg){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put(SUCCESSFLAG, successFlag);
        resultMap.put(SUCCESSMSG, successMsg);
        return resultMap;
    }
}
