/** 
 * @Project: travel
 * @Title: FileUtils.java  
 * @Package com.yiklv.travel.utils.file
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月23日 下午9:17:22  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.utils.file <br>
 *       <b>ClassName:</b> FileUtils <br>
 *       <b>Date:</b> 2018年3月23日 下午9:17:22
 */
public class FileUtils {
    public static void fileCopy(File in, File out) throws IOException {
        FileChannel inChannel = new FileInputStream(in).getChannel();
        FileChannel outChannel = new FileOutputStream(out).getChannel();
        try {
            // inChannel.transferTo(0, inChannel.size(), outChannel); // original -- apparently has trouble copying
            // large files on Windows

            // magic number for Windows, 64Mb - 32Kb)
            int maxCount = (64 * 1024 * 1024) - (32 * 1024);
            long size = inChannel.size();
            long position = 0;
            while (position < size) {
                position += inChannel.transferTo(position, maxCount, outChannel);
            }
        } finally {
            if (inChannel != null) {
                inChannel.close();
            }
            if (outChannel != null) {
                outChannel.close();
            }
        }
    }
}
