/** 
 * @Project: travel
 * @Title: FileViewUtils.java  
 * @Package com.yiklv.travel.utils.file
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月24日 下午10:55:13  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.utils.file;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.utils.file <br>
 *       <b>ClassName:</b> FileViewUtils <br>
 *       <b>Date:</b> 2018年3月24日 下午10:55:13
 */
public class FileViewUtils {

    /*public void viewWrod() {
        BufferedInputStream bis = null;
        URL url = null;
        HttpURLConnection httpUrl = null; // 建立链接
        url = new URL(urlReal);
        httpUrl = (HttpURLConnection) url.openConnection();// 连接指定的资源
        httpUrl.connect();// 获取网络输入流
        bis = new BufferedInputStream(httpUrl.getInputStream());

        String bodyText = null;
        WordExtractor ex = new WordExtractor(bis);
        bodyText = ex.getText();
        response.getWriter().write(bodyText);
    }

    public void viewExcel() {
        BufferedInputStream bis = null;
        URL url = null;
        HttpURLConnection httpUrl = null; // 建立链接
        url = new URL(urlReal);
        httpUrl = (HttpURLConnection) url.openConnection();// 连接指定的资源
        httpUrl.connect();// 获取网络输入流
        bis = new BufferedInputStream(httpUrl.getInputStream());

        content = new StringBuffer();
        HSSFWorkbook workbook = new HSSFWorkbook(bis);
        for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
            HSSFSheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
            content.append("/n");
            if (null == aSheet) {
                continue;
            }
            for (int rowNum = 0; rowNum <= aSheet.getLastRowNum(); rowNum++) {
                content.append("/n");
                HSSFRow aRow = aSheet.getRow(rowNum);
                if (null == aRow) {
                    continue;
                }
                for (short cellNum = 0; cellNum <= aRow.getLastCellNum(); cellNum++) {
                    HSSFCell aCell = aRow.getCell(cellNum);
                    if (null == aCell) {
                        continue;
                    }
                    if (aCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        content.append(aCell.getRichStringCellValue().getString());
                    }
                    else if (aCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        boolean b = HSSFDateUtil.isCellDateFormatted(aCell);
                        if (b) {
                            Date date = aCell.getDateCellValue();
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                            content.append(df.format(date));
                        }
                    }
                }
            }
        }
        response.getWriter().write(content.toString());

    }*/
}
