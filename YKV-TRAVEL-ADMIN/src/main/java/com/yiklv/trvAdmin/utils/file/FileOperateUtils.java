/** 
 * @Project: travel
 * @Title: FileOperateUtils.java  
 * @Package com.yiklv.travel.utils.file
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月24日 上午1:19:55  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.trvAdmin.utils.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.utils.file <br>
 *       <b>ClassName:</b> FileOperateUtils <br>
 *       <b>Date:</b> 2018年3月24日 上午1:19:55
 */
public class FileOperateUtils {
    /**
     * <b>Description:</b><br>
     * 1.创建文件夹
     * 
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 上午1:27:42 <br>
     *       <b>Version:</b> 1.0
     */
    /*public void createFolder(String path) {
        // import java.io.*;
        File myFolderPath = new File(path);
        try {
            if (!myFolderPath.exists())
                myFolderPath.mkdir();
        } catch (IOException e) {
            System.err.println("新建目录操作出错");
        }
    }*/

    /**
     * 
     * <b>Description:</b><br>
     * 2.创建文件
     * 
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 上午1:29:29 <br>
     *       <b>Version:</b> 1.0
     */
    public void createFile(String file, String path) {
        // import java.io.*;
        File myFilePath = new File(path + File.separator + file);
        try {
            if (!myFilePath.exists())
                myFilePath.createNewFile();
            FileWriter resultFile = new FileWriter(myFilePath);
            PrintWriter myFile = new PrintWriter(resultFile);
            myFile.println();
            myFile.flush();
            resultFile.close();
        } catch (IOException e) {
            System.err.println("新建文件操作出错");
        }
    }

    /**
     * 
     * <b>Description:</b><br>
     * 3.删除文件
     * 
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 上午1:30:13 <br>
     *       <b>Version:</b> 1.0
     */
    public void deleteFile() {
        // import java.io.*;
        File myDelFile = new File("");
        if (myDelFile.delete()) {

        }

    }

    /**
     * 
     * <b>Description:</b><br>
     * 4.删除文件夹
     * 
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 上午1:30:52 <br>
     *       <b>Version:</b> 1.0
     */
    public void deleteFolder(){
      /*
      import java.io.*;
      import java.util.*;
      */
      LinkedList<String> folderList = new LinkedList<String>();
      folderList.add("");
      while (folderList.size() > 0) {
      File file = new File((String)folderList.poll());
      File[] files = file.listFiles();
      ArrayList<File> fileList = new ArrayList<File>();
      for (int i = 0; i < files.length; i++) {
      if (files[i].isDirectory()) {
      folderList.add(files[i].getPath());
      } else {
      fileList.add(files[i]);
      }
      }
      for (File f : fileList) {
      f.delete();
      }
      }
      folderList = new LinkedList<String>();
      folderList.add("");
      while (folderList.size() > 0) {
      File file = new File((String)folderList.getLast());
      if (file.delete())
      folderList.removeLast();
      else {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; i++) {
      folderList.add(files[i].getPath());
      }
      }
      }
      
  }

    /**
     * 
     * <b>Description:</b><br>
     * 5.删除一个文件下夹所有的文件夹
     * 
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 上午1:31:33 <br>
     *       <b>Version:</b> 1.0
     */
    /*public void deleteAllFile(){
      
      
      import java.io.*;
      private static LinkedList<String> folderList=null;
      
      File delfile=new File("");
      File[] files=delfile.listFiles();
      for(int i=0;i<files.length;i++){
      if(files[i].isDirectory()){
      if(!files[i].delete()){
      folderList = new LinkedList<String>();
      folderList.add(files[i]);
      while (folderList.size() > 0) {
      File file = new File((String)folderList.poll());
      File[] files = file.listFiles();
      ArrayList<File> fileList = new ArrayList<File>();
      for (int i = 0; i < files.length; i++) {
      if (files[i].isDirectory())
      folderList.add(files[i].getPath());
      else
      fileList.add(files[i]);
      }
      for (File f : fileList)
      f.delete();
      }
      folderList = new LinkedList<String>();
      folderList.add(files[i]);
      while (folderList.size() > 0) {
      File file = new File((String)folderList.getLast());
      if (file.delete())
      folderList.removeLast();
      else {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; i++) {
      folderList.add(files[i].getPath());
      }
      }
      }
      }
      }
      }
  }*/

    /**
     * 
     * <b>Description:</b><br>
     * 6.清空文件夹
     * 
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月24日 上午1:32:21 <br>
     *       <b>Version:</b> 1.0
     */
    /*public void clearFolder(){
      
      
  
  
  //import java.io.*;
  File delfilefolder=new File(%%1);
  if (!delfilefolder.exists() && !delfilefolder.delete()){
  LinkedList<String> folderList = new LinkedList<String>();
  folderList.add(delfilefolder.getAbsolutePath());
  while (folderList.size() > 0) {
  File file = new File((String)folderList.poll());
  File[] files = file.listFiles();
  ArrayList<File> fileList = new ArrayList<File>();
  for (int i = 0; i < files.length; i++) {
  if (files[i].isDirectory())
  folderList.add(files[i].getPath());
  else
  fileList.add(files[i]);
  }
  for (File f : fileList)
  f.delete();
  }
  folderList = new LinkedList<String>();
  folderList.add(delfilefolder.getAbsolutePath());
  while (folderList.size() > 0) {
  File file = new File((String)folderList.getLast());
  if (file.delete())
  folderList.removeLast();
  else {
  File[] files = file.listFiles();
  for (int i = 0; i < files.length; i++) {
  folderList.add(files[i].getPath());
  }
  }
  }
  }
  delfilefolder.mkdir();
  }*/
    /*
     * 7.读取文件 //import java.io.*; 7.1.操作系统默认编码 FileReader fr=new FileReader(%%1); BufferedReader br = new
     * BufferedReader(); String %%2=nul; try { while ((%%2 = reader.readLine()) != null) { %%3 } } catch (IOException e)
     * { e.printStackTrace(); } finally{ try { br.close(); fr.close(); } catch (IOException e) { e.printStackTrace(); }
     * }
     * 
     * 7.2.UTF-8编码 FileInputStream fis=new FileInputStream(new File(%%1)); InputStreamReader read = new
     * InputStreamReader(fis,"UTF-8"); BufferedReader reader=new BufferedReader(read); String %%2=null; try { while
     * ((%%2 = reader.readLine()) != null) { %%3 } } catch (IOException e) { e.printStackTrace(); } finally{ try {
     * br.close(); read.close(); fis.close(); } catch (IOException e) { e.printStackTrace(); } }
     * 
     * 7.3.分块读取 FileInputStream fis=new FileInputStream(new File(%%1)); byte[] buffer=new byte[10240]; try { int
     * byteread; while ((byteread=fis.read(buffer)) != -1) { String %%2=new String(buffer); %%3 } } catch (IOException
     * e) { e.printStackTrace(); } finally{ try { read.close(); fis.close(); } catch (IOException e) {
     * e.printStackTrace(); } }
     * 
     * 8.写入文件 //import java.io.*; 8.1.操作系统默认编码 try { FileWriter fw = new FileWriter(%%1); fw.write(%%2); fw.flush();
     * fw.close(); } catch (IOException e) { e.printStackTrace(); }
     * 
     * 8.2.UTF-8编码 try { OutputStreamWriter out = new OutputStreamWriter( new FileOutputStream(%%1),"UTF-8");
     * out.write(sb.toString()); out.flush(); out.close(); } catch (UnsupportedEncodingException e) {
     * e.printStackTrace(); } catch (FileNotFoundException e){ e.printStackTrace(); } catch (IOException e){
     * e.printStackTrace(); }
     * 
     * 9.写入随机文件 //import java.io.*; try { RandomAcessFile logFile=new RandomAcessFile(%%1,"rw"); long
     * lg=logFile.length(); logFile.seek(%%2); logFile.writeByte(%%3); }catch(IOException ioe){
     * System.out.println("无法写入文件："+ioe.getMessage()); }
     * 
     * 10.读取文件属性 //import java.io.*; // 文件属性的取得 File af = new File(%%1); if (af.exists()) {
     * System.out.println(f.getName() + "的属性如下： 文件长度为：" + f.length()); System.out.println(f.isFile() ? "是文件" : "不是文件");
     * System.out.println(f.isDirectory() ? "是目录" : "不是目录"); System.out.println(f.canRead() ? "可读取" : "不");
     * System.out.println(f.canWrite() ? "是隐藏文件" : ""); System.out.println("文件夹的最后修改日期为：" + new Date(f.lastModified()));
     * } else { System.out.println(f.getName() + "的属性如下："); System.out.println(f.isFile() ? "是文件" : "不是文件");
     * System.out.println(f.isDirectory() ? "是目录" : "不是目录"); System.out.println(f.canRead() ? "可读取" : "不");
     * System.out.println(f.canWrite() ? "是隐藏文件" : ""); System.out.println("文件的最后修改日期为：" + new Date(f.lastModified()));
     * } if(f.canRead()){ %%2 } if(f.canWrite()){ %%3 }
     * 
     * 11.写入属性 //import java.io.*; File filereadonly=new File(%%1); try { boolean %%2=filereadonly.setReadOnly(); }
     * catch (IOException e) { System.err.println("拒绝写访问："+e.printStackTrace()); }
     * 
     * 12.枚举一个文件夹中的所有文件
     * 
     * import java.io.*; import java.util.*;
     * 
     * LinkedList<String> folderList = new LinkedList<String>(); folderList.add(%%1); while (folderList.size() > 0) {
     * File file = new File((String)folderList.poll()); File[] files = file.listFiles(); List<File> fileList = new
     * ArrayList<File>(); for (int i = 0; i < files.length; i++) { if (files[i].isDirectory())
     * folderList.add(files[i].getPath()); else fileList.add(files[i]); } for (File f : fileList) {
     * %%2=f.getAbsoluteFile(); %%3 } }
     * 
     * 13.复制文件夹
     * 
     * import java.io.*; import java.util.*;
     * 
     * LinkedList<String> folderList = new LinkedList<String>(); folderList.add(%%1); LinkedList<String> folderList2 =
     * new LinkedList<String>(); folderList2.add(%%2+ %%1.substring(%%1.lastIndexOf("\\"))); while (folderList.size() >
     * 0) { (new File(folderList2.peek())).mkdirs(); // 如果文件夹不存在 则建立新文件夹 File folders = new File(folderList.peek());
     * String[] file = folders.list(); File temp = null; try { for (int i = 0; i < file.length; i++) { if
     * (folderList.peek().endsWith(File.separator)) temp = new File(folderList.peek() + File.separator + file[i]); else
     * temp = new File(folderList.peek() + File.separator + file[i]); if (temp.isFile()) { FileInputStream input = new
     * FileInputStream(temp); FileOutputStream output = new FileOutputStream(new File( folderList2.peek()
     * ,temp.getName().toString())); byte[] b = new byte[10240]; int len; while ((len = input.read(b)) != -1)
     * output.write(b, 0, len); output.flush(); output.close(); input.close(); } else if (temp.isDirectory()) {//
     * 如果是子文件夹 for (File f : temp.listFiles()) { if (f.isDirectory()) { folderList.add(f.getPath());
     * folderList2.add(folderList2.peek() + File.separator + f.getName()); } else if(f.isFile()) { FileInputStream input
     * = new FileInputStream(f); FileOutputStream output = new
     * FileOutputStream(folderList2.peek()+File.separator+temp.getName()+File.separator+ f.getName()); byte[] b = new
     * byte[10240]; int len; while ((len = input.read(b)) != -1) output.write(b, 0, len); output.flush();
     * output.close(); input.close(); } } } } } catch (IOException e) { System.err.println("复制整个文件夹内容操作出错"); }
     * folderList.removeFirst(); folderList2.removeFirst(); }
     * 
     * 14.复制一个目录下所有的文件夹到另一个文件夹下
     * 
     * import java.io.*; import java.util.*;
     * 
     * File copyfolders=new File(%%1); File[] copyfoldersList=copyfolders.listFiles(); for(int
     * k=0;k<copyfoldersList.length;k++){ if(copyfoldersList[k].isDirectory()){ List<String>folderList=new
     * ArrayList<String>(); folderList.add(copyfoldersList[k].getPath()); List<String>folderList2=new
     * ArrayList<String>(); folderList2.add(%%2+"/"+copyfoldersList[k].getName()); for(int j=0;j<folderList.size();j++){
     * (new File(folderList2.get(j))).mkdirs(); //如果文件夹不存在 则建立新文件夹 File folders=new File(folderList.get(j)); String[]
     * file=folders.list(); File temp=null; try { for (int i = 0; i < file.length; i++) {
     * if(folderList.get(j).endsWith(File.separator)) temp=new File(folderList.get(j),file[i]); else temp=new
     * File(folderList.get(j),file[i]); FileInputStream input = new FileInputStream(temp); if(temp.isFile()){
     * FileOutputStream output = new FileOutputStream(new File(folderList2.get(j) ,temp.getName()).toString())); byte[]
     * b = new byte[10240]; while ( (int len = input.read(b)) != -1) output.write(b, 0, len); output.flush();
     * output.close(); input.close(); } else if(temp.isDirectory()){//如果是子文件夹 for (File f : temp.listFiles()) { if
     * (f.isDirectory()) { folderList.add(f.getPath()); folderList2.add(folderList2.peek() + File.separator +
     * f.getName()); } else if(f.isFile()) { FileInputStream input = new FileInputStream(f); FileOutputStream output =
     * new FileOutputStream(folderList2.peek()+File.separator+temp.getName()+File.separator+ f.getName()); byte[] b =
     * new byte[10240]; int len; while ((len = input.read(b)) != -1) { output.write(b, 0, len); } output.flush();
     * output.close(); input.close(); } } } } } } catch (IOException e) { System.err.println("复制整个文件夹内容操作出错"); } } } }
     * 
     * 15.移动文件夹
     * 
     * import java.io.*; import java.util.*;
     * 
     * LinkedList<String> folderList = new LinkedList<String>(); folderList.add(%%1); LinkedList<String> folderList2 =
     * new LinkedList<String>(); folderList2.add(%%2 + %%1.substring(%%1.lastIndexOf("\\"))); while (folderList.size() >
     * 0) { (new File(folderList2.peek())).mkdirs(); // 如果文件夹不存在 则建立新文件夹 File folders = new File(folderList.peek());
     * String[] file = folders.list(); File temp = null; try { for (int i = 0; i < file.length; i++) { if
     * (folderList.peek().endsWith(File.separator)) { temp = new File(folderList.peek() , file[i]); } else { temp = new
     * File(folderList.peek() ,file[i]); } if (temp.isFile()) { FileInputStream input = new FileInputStream(temp);
     * FileOutputStream output = new FileOutputStream( folderList2.peek() + File.separator +
     * (temp.getName()).toString()); byte[] b = new byte[10240]; while ((int len = input.read(b)) != -1) output.write(b,
     * 0, len); output.flush(); output.close(); input.close(); if (!temp.delete()) //删除单个文件操作出错 } else if
     * (temp.isDirectory()) {// 如果是子文件夹 for (File f : temp.listFiles()) { if (f.isDirectory()) {
     * folderList.add(f.getPath()); folderList2.add(folderList2.peek() + File.separator + f.getName()); } else if
     * (f.isFile()) { FileInputStream input = new FileInputStream(f); FileOutputStream output = new
     * FileOutputStream(folderList2.peek()+File.separator+temp.getName()+File.separator+ f.getName()); byte[] b = new
     * byte[10240]; while ((int len = input.read(b)) != -1) output.write(b, 0, len); output.flush(); output.close();
     * input.close(); if (!temp.delete()) //删除单个文件操作出错 } } } } } catch (IOException e) { //复制整个文件夹内容操作出错
     * e.printStackTrace(); } folderList.removeFirst(); folderList2.removeFirst();
     * 
     * } File f = new File(%%1); if (!f.delete()) { for (File file : f.listFiles()) { if (file.list().length == 0)
     * file.delete(); } }
     * 
     * 16.移动一个目录下所有的文件夹到另一个目录下
     * 
     * import java.io.*; import java.util.*;
     * 
     * File movefolders=new File(%%1); File[] movefoldersList=movefolders.listFiles(); for(int
     * k=0;k<movefoldersList.length;k++){ if(movefoldersList[k].isDirectory()){ List<String>folderList=new
     * ArrayList<String>(); folderList.add(movefoldersList[k].getPath()); List<String>folderList2=new
     * ArrayList<String>(); folderList2.add(%%2+File.separator+movefoldersList[k].getName()); for(int
     * j=0;j<folderList.size();j++){ (new File(folderList2.get(j))).mkdirs(); //如果文件夹不存在 则建立新文件夹 File folders=new
     * File(folderList.get(j)); String[] file=folders.list(); File temp=null; try { for (int i = 0; i < file.length;
     * i++) { if(folderList.get(j).endsWith(File.separator)) temp=new File(folderList.get(j),file[i]); else temp=new
     * File(folderList.get(j),file[i]); FileInputStream input = new FileInputStream(temp); if(temp.isFile()){
     * FileInputStream input = new FileInputStream(temp); FileOutputStream output = new FileOutputStream(new
     * File(folderList2.get(j),temp.getName().toString())); byte[] b = new byte[10240]; while ( (int len =
     * input.read(b)) != -1) output.write(b, 0, len); output.flush(); output.close(); input.close(); temp.delete(); }
     * else if(temp.isDirectory()){//如果是子文件夹 for (File f : temp.listFiles()) { if (f.isDirectory()) {
     * folderList.add(f.getPath()); folderList2.add(folderList2.peek() + File.separator + f.getName()); } else if
     * (f.isFile()) { FileInputStream input = new FileInputStream(f); FileOutputStream output = new
     * FileOutputStream(folderList2.peek()+File.separator+temp.getName()+File.separator+ f.getName()); byte[] b = new
     * byte[10240]; while ((int len = input.read(b)) != -1) output.write(b, 0, len); output.flush(); output.close();
     * input.close(); if (!temp.delete()) //删除单个文件操作出错 } } } } catch (IOException e) { //复制整个文件夹内容操作出错
     * e.printStackTrace(); } } movefoldersList[k].delete(); } }
     * 
     * 17.以一个文件夹的框架在另一个目录创建文件夹和空文件
     * 
     * import java.io.*; import java.util.*;
     * 
     * boolean b=false;//不创建空文件 List<String>folderList=new ArrayList<String>(); folderList.add(%%1);
     * List<String>folderList2=new ArrayList<String>(); folderList2.add(%%2); for(int j=0;j<folderList.size();j++){ (new
     * File(folderList2.get(j))).mkdirs(); //如果文件夹不存在 则建立新文件夹 File folders=new File(folderList.get(j)); String[]
     * file=folders.list(); File temp=null; try { for (int i = 0; i < file.length; i++) {
     * if(folderList.get(j).endsWith(File.separator)) temp=new File(folderList.get(j),file[i]); else temp=new
     * File(folderList.get(j),file[i]); if(temp.isFile() && b) temp.createNewFile(); else
     * if(temp.isDirectory()){//如果是子文件夹 folderList.add(folderList.get(j)+File.separator+file[i]);
     * folderList2.add(folderList2.get(j)+File.separator+file[i]); } } } catch (IOException e) { //复制整个文件夹内容操作出错
     * e.printStackTrace(); } }
     * 
     * 18.复制文件 //import java.io.*; File oldfile = new File(%%1); try { if (oldfile.exists()) { //文件存在时 FileInputStream
     * inStream = new FileInputStream(oldfile); //读入原文件 FileOutputStream fs = new FileOutputStream(new
     * File(%%2,oldfile.getName())); byte[] buffer = new byte[10240]; int byteread; while ( (byteread =
     * inStream.read(buffer)) != -1) fs.write(buffer, 0, byteread); inStream.close(); } } catch (IOException e) {
     * //复制单个文件操作出错 e.printStackTrace(); }
     * 
     * 19.复制一个目录下所有的文件到另一个目录 //import java.io.*; File copyfiles=new File(%%1); File targetfiles = new File(%%2); if
     * (!targetfiles.exists()) targetfiles.mkdirs(); File[] files=copyfiles.listFiles(); for(int
     * i=0;i<files.length;i++){ if(files[i].isFile()){ try { InputStream inStream = new FileInputStream(files[i]);
     * //读入原文件 FileOutputStream fs = new FileOutputStream(new File(%%2,files[i].getName())); byte[] buffer = new
     * byte[10240]; int byteread; while ( (byteread = inStream.read(buffer)) != -1) fs.write(buffer, 0, byteread);
     * inStream.close(); } catch (IOException e) { //复制单个文件操作出错 e.printStackTrace(); } } }
     * 
     * 20.提取扩展名 String %%2=%%1.substring(%%1.lastIndexOf('.'));
     * 
     * 21.提取文件名 String %%2=%%1.substring(%%1.lastIndexOf("\\")+1);
     * 
     * 22.提取文件路径 String %%2=%%1.substring(0,%%1.lastIndexOf("\\"));
     * 
     * 23.替换扩展名 //import java.io.*; File replaceExt=new File(%%1);
     * replaceExt.renameTo(replaceExt.getName().split(".")[0]+"."+%%2);
     * 
     * 24.追加路径 final String path=%%1.endsWith("\\")?%%1:%%1+"\\"; %%3=path+%%2;
     * 
     * 25.移动文件 //import java.io.*; File oldfile = new File(%%1); try { if (oldfile.exists()) { //文件存在时 InputStream
     * inStream = new FileInputStream(oldfile); //读入原文件 FileOutputStream fs = new FileOutputStream(new
     * File(%%2,oldfile.getName())); byte[] buffer = new byte[10240]; int byteread; while ( (byteread =
     * inStream.read(buffer)) != -1) fs.write(buffer, 0, byteread); inStream.close(); oldfile.delete(); } } catch
     * (IOException e) { //复制单个文件操作出错 e.printStackTrace(); }
     * 
     * 26.移动一个目录下所有文件到另一个目录 //import java.io.*; File movefile=new File(%%1); File[] movefiles=movefile.listFiles();
     * for(int i=0;i<movefiles.length;i++){ if(movefiles[i].isFile()){ File oldfile = new File(movefiles[i]); try { if
     * (oldfile.exists()) { //文件存在时 InputStream inStream = new FileInputStream(oldfile); //读入原文件 FileOutputStream fs =
     * new FileOutputStream(new File(%%2,oldfile.getName())); byte[] buffer = new byte[10240]; int byteread; while (
     * (byteread = inStream.read(buffer)) != -1) fs.write(buffer, 0, byteread); inStream.close(); oldfile.delete(); } }
     * catch (IOException e) { //复制单个文件操作出错 e.printStackTrace(); } } }
     * 
     * 27.指定目录下搜索文件 //import java.io.*; private static final String filter=%%1; //"*.*" private static void
     * doSearch(String path){ File file = new File(path); if(file.exists()) { if(file.isDirectory()) { File[] fileArray
     * = file.listFiles(); for(File f:fileArray) { if(f.isDirectory()) { doSearch(f.getPath()); } else {
     * if(f.getName().indexOf(filter) >= 0) { //f.getPath() } } //f.getPath() } //"The numbers of files had been found:"
     * + countFiles } else { //"Couldn't open the path!" } } else { System.err.println("目录不存在"); } } doSearch(%%1);
     * 
     * 28.打开对话框
     * 
     * import java.io.*; import javax.swing.*;
     * 
     * JFileChooser Jfc = new JFileChooser(); //建立选择档案对话方块盒 Jfc Jfc.showDialog(null, %%1); if (Jfc.getSelectedFile() !=
     * null) { File %%2 = Jfc.getSelectedFile(); }
     * 
     * 29.文件分割 //import java.io.*; try { File f=new File(%%1); FileInputStream fileInputStream = new FileInputStream(f);
     * byte[] buffer = new byte[fileInputStream.available()]; FileInputStream.read(buffer); fileInputStream.close();
     * String strFileName = f.getName(); FileOutputStream fileOutputStream = new FileOutputStream(new File(%%2+"\\"+
     * strFileName + "1")); fileOutputStream.write(buffer,0,buffer.length/2); fileOutputStream.close(); fileOutputStream
     * = new FileOutputStream(new File(%%2+"\\"+ strFileName + "2")); fileOutputStream.write(buffer, buffer.length/2,
     * buffer.length-buffer.length/2); fileOutputStream.close(); } catch (ArrayIndexOutOfBoundsException e) {
     * e.printStackTrace(); } catch(IOException e){ e.printStackTrace(); }
     * 
     * 30.文件合并 //import java.io.*; String strFileName = %%1.substring(%%1.LastIndexOf("\\") + 1); try { FileInputStream
     * fileInputStream1 = new FileInputStream(new File(%%2 + strFileName + "1")); FileInputStream fileInputStream2 = new
     * FileInputStream(new File(%%2 + strFileName + "2")); byte[] buffer = new
     * byte[fileInputStream1.available()+fileInputStream2.available()]; FileInputStream.read(buffer, 0,
     * fileInputStream1.available()); FileInputStream2.read(buffer, fileInputStream1.available(),
     * fileInputStream2.available()); fileInputStream.close(); fileInputStream2.close(); FileOutputStream
     * fileOutputStream = new FileOutputStream(new File(%%2+"\\"+ strFileName));
     * fileOutputStream.write(buffer,0,buffer.length); fileOutputStream.close(); } catch(IOException e){
     * e.printStackTrace(); }
     * 
     * 31.文件简单加密
     * 
     * import java.io.*; import javax.swing.*; private static final String CharSet = "0123456789ABCDEF";
     * 
     * JFileChooser jfc = new JFileChooser(); JFileChooser jfc2 = new JFileChooser(); jfc.showDialog(null,
     * "请选择要加密编码的文件"); jfc2.showDialog(null, "请选择要输出的文件名"); if (jfc.getSelectedFile() != null && jfc2.getSelectedFile()
     * != null) { File oldfile = jfc.getSelectedFile(); FileInputStream inStream = null; FileWriter fw = null; try { if
     * (oldfile.exists()) { inStream = new FileInputStream(oldfile); fw = new FileWriter(jfc2.getSelectedFile()); byte[]
     * sRead = new byte[10240]; int byteread; while ((byteread = inStream.read(sRead)) != -1) { StringBuilder smi = new
     * StringBuilder(byteread * 2); int ka = 3, kb = 5, kc = 2, kd = 7, js = 0; if (byteread % 2 != 0) js = 1; for (int
     * i = 0; i < byteread - 1; i += 2) { char c1 = (char) sRead[i]; char c2 = (char) sRead[i + 1]; int tmp = ka * c1 +
     * kc * c2; while (tmp < 0) tmp += 1024; byte s1 = (byte) (tmp % 1024); int js1 = (int) s1 >> 4 & 0xf;
     * smi.append(CharSet.substring(js1, js1 + 1)); int ks1 = s1 & 0xf; smi.append(CharSet.substring(ks1, ks1 + 1)); tmp
     * = kb * c1 + kd * c2; while (tmp < 0) tmp += 1024; byte s2 = (byte) (tmp % 1024); int js2 = (int) s2 >> 4 & 0xf;
     * smi.append(CharSet.substring(js2, js2 + 1)); int ks2 = s2 & 0xf; smi.append(CharSet.substring(ks2, ks2 + 1)); }
     * if (js == 1) { byte s3 = (byte) ((sRead[byteread - 1] - 4) % 1024); int js3 = (int) s3 >> 4 & 0xf;
     * smi.append(CharSet.substring(js3, js3 + 1)); int ks3 = (int) s3 & 0xf; smi.append(CharSet.substring(ks3, ks3 +
     * 1)); } fw.write(smi.toString()); } fw.flush(); } } catch (IOException e) { e.printStackTrace(); } finally { try {
     * fw.close(); inStream.close(); } catch (IOException e) { e.printStackTrace(); } } }
     * 
     * 32.文件简单解密
     * 
     * import java.io.*; import javax.swing.*; private static final String CharSet = "0123456789ABCDEF";
     * 
     * private static int niyuan(int m, int n) { int a, b, c, d, t, yu = 0, shang, mod; a = m; b = n; mod = a; c = 0; d
     * = 1; while (b < 0) b += a; if (a % b == 0 || b % 2 == 0) return 0; while (b != 1) { t = a % b; shang = a / b; a =
     * b; b = t; yu = c - shang * d; c = d; d = yu; } if (yu < 0) yu += mod; return yu; } JFileChooser jfc = new
     * JFileChooser(); JFileChooser jfc2 = new JFileChooser(); jfc.showDialog(null, "请选择要解码解密的文件");
     * jfc2.showDialog(null, "请选择要输出的文件名"); if (jfc.getSelectedFile() != null && jfc2.getSelectedFile() != null) {
     * FileOutputStream fw = null; try { FileInputStream fis = new FileInputStream(jfc.getSelectedFile()); fw = new
     * FileOutputStream(jfc2 .getSelectedFile()); byte[] buffer = new byte[20480]; int ka = 3, kb = 5, kc = 2, kd = 7,
     * js = 0, tmp; int aany, ddny; int r00 = ka * kc * kd; int r01 = -ka * kb * kc; int r10 = -kb * kc * kc; int r11 =
     * ka * kb * kc; int x00 = ka * ka * kc * kd - ka * kb * kc * kc; int x11 = ka * kb * kc * kd - kb * kb * kc * kc;
     * while (x00 % 2 == 0) { x00 /= 2; r00 /= 2; r01 /= 2; } while (x11 % 2 == 0) { x11 /= 2; r10 /= 2; r11 /= 2; }
     * aany = x00; ddny = x11; if (niyuan(1024, aany) != 0 && niyuan(1024, ddny) != 0) { int kn00 = r00 * niyuan(1024,
     * x00); int kn01 = r01 * niyuan(1024, x00); int kn10 = r10 * niyuan(1024, x11); int kn11 = r11 * niyuan(1024, x11);
     * ka = kn00; kb = kn01; kc = kn10; kd = kn11; } else { JOptionPane.showMessageDialog(null, "无逆矩阵！");
     * System.exit(0); } while (ka < 0) ka += 1024; while (kb < 0) kb += 1024; while (kc < 0) kc += 1024; while (kd < 0)
     * kd += 1024; ka %= 1024; kb %= 1024; kc %= 1024; kd %= 1024; try { int byteread; while ((byteread =
     * fis.read(buffer)) != -1) { int nLen = byteread / 2; byte[] sming = new byte[nLen]; String chs=new
     * String(buffer,"US-ASCII"); for (int i = 0; i < nLen; i++) { byte bTmp; if (byteread < 2) bTmp = -1; bTmp = (byte)
     * (CharSet.indexOf(chs.substring(i * 2,i * 2+1)) * 16 + CharSet .indexOf(chs.substring(i * 2 + 1,i * 2 + 2)));
     * sming[i] = bTmp; } if (nLen % 2 != 0) js = 1; for (int i = 0; i < nLen - 1; i += 2) { char c1 = (char) sming[i];
     * char c2 = (char) sming[i + 1]; tmp = ka * c1 + kc * c2; while (tmp < 0) tmp += 1024; char s1 = (char) (tmp %
     * 1024); fw.write(s1); tmp = kb * c1 + kd * c2; while (tmp < 0) tmp += 1024; char s2 = (char) (tmp % 1024);
     * fw.write(s2); } if (js == 1) { char c3 = (char) ((sming[nLen - 1] - 4) % 1024); fw.write(c3); } } fw.flush(); }
     * catch (IOException e) { e.printStackTrace(); } finally { try { fis.close(); fw.close(); } catch (IOException e) {
     * e.printStackTrace(); } } } catch (FileNotFoundException e1) { // TODO Auto-generated catch block
     * e1.printStackTrace(); } }
     * 
     * 33.读取ini文件属性
     * 
     * import java.io.*; import java.util.*; import java.util.regex.*; private static HashMap configMap=null; private
     * static FileReader fileReader = null;
     * 
     * private static boolean readIni() { if (configMap == null) { configMap = new HashMap<String, ArrayList>(); String
     * strLine = null; String currentNode = null; String previousNode = null; ArrayList<Properties> vec = new
     * ArrayList<Properties>(); int row = 0; BufferedReader bufferedReader = new BufferedReader(fileReader); try { while
     * ((strLine = bufferedReader.readLine()) != null) { String oneLine = strLine.trim(); if (oneLine.length() >= 1) {
     * Pattern p = Pattern.compile("\\[\\s*.*\\s*\\]"); int nodelen = oneLine.split("[;]").length; String[] strArray1 =
     * new String[4]; if (nodelen == 1) { oneLine = oneLine.split("[;]")[0].trim(); } else if (nodelen == 2) {
     * strArray1[3] = oneLine.split("[;]")[1].trim(); oneLine = oneLine.split("[;]")[0].trim(); } Matcher m =
     * p.matcher(oneLine); if (m.matches()) { strArray1[0] = "@Node"; strArray1[1] = oneLine; strArray1[2] = ""; } else
     * { int keylen = oneLine.split("=").length; if (keylen == 1) { strArray1[0] = "@Key"; strArray1[1] =
     * oneLine.split("=")[0]; strArray1[2] = ""; } else if (keylen == 2) { strArray1[0] = "@Key"; strArray1[1] =
     * oneLine.split("=")[0]; strArray1[2] = oneLine.split("=")[1]; } else { strArray1[0] = "@ElementError";
     * strArray1[1] = ""; strArray1[2] = ""; strArray1[3] = ""; } } if (strArray1[0].equals("@Node")) { previousNode =
     * currentNode; currentNode = strArray1[1]; if (row > 0) { configMap.put(previousNode, (ArrayList)vec.clone());
     * vec.clear(); row = 0; } } else if (strArray1[0].equals("@Key") && row == 0) { Properties ht = new Properties();
     * ht.setProperty(strArray1[1], strArray1[2]); vec.add(ht); row++; } else if (strArray1[0].equals("@Key") && row >
     * 0) { Properties ht2 = new Properties(); ht2.put(strArray1[1], strArray1[2]); vec.add(ht2); row++; } } }
     * configMap.put(currentNode, (ArrayList)vec.clone()); } catch (FileNotFoundException e) { configMap = null;
     * e.printStackTrace(); return false; } catch (IOException e) { configMap = null; e.printStackTrace(); return false;
     * } } return true; } try { fileReader = new FileReader(%%1); //"Setup.ini" } catch (FileNotFoundException e1) {
     * e1.printStackTrace(); } if (readIni()) { ArrayList<Properties> li = null; li = (ArrayList<Properties>)
     * configMap.get(%%2); //"[DataSource]" for (Properties pro : li) { if(pro.containsKey(%%3))
     * %%4=pro.getProperty(%%3); } } try { fileReader.close(); } catch (IOException e) { e.printStackTrace(); }
     * 
     * 34.合并一个目录下所有的文件 //import java.io.*; File combinefiles=new File(%%1); File[] files=combinefiles.listFiles();
     * FileOutputStream fs; try { fs=new FileOutputStream(new File(%%2)); } catch(IOException e){ e.printStackTrace(); }
     * for(int i=0;i<files.length;i++){ if(files[i].isFile()){ try { FileInputStream inStream=new
     * FileInputStream(files[i]); byte[] buffer = new byte[10240]; int byteread;
     * while((byteread=inStream.read(buffer))!=-1) fs.write(buffer,0,byteread); inStream.close(); } catch(Exception e){
     * //复制文件出错 e.printStackTrace(); } } } try { fs.close(); } catch(IOException e){ e.printStackTrace(); }
     * 
     * 35.写入ini文件属性
     * 
     * import java.io.*; import java.util.*; import java.util.regex.*; private static HashMap configMap=null;
     * 
     * if (readIni()) { ArrayList<Properties> li = null; try { FileWriter fw = new FileWriter(%%1); li =
     * (ArrayList<Properties>) configMap.get(%%2); //"[DataSource]" fw.write("%%2\r\n"); for (Properties pro : li) { if
     * (pro.containsKey(%%3)) //"ip" fw.write("%%3=" + %%6 + "\r\n"); } fw.flush(); fw.close(); } catch (IOException e)
     * { e.printStackTrace(); } }
     * 
     * 36.获得当前路径 String %%1=getClass().getResource("/").getPath(); //String %%1=System.getProperty("user.dir");
     * 
     * 37.读取XML数据库
     * 
     * import java.io.*; import javax.xml.parsers.*; import org.w3c.dom.*; private static Document document; private
     * static Element node;
     * 
     * File xml_file = new File(%%1); DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); try {
     * DocumentBuilder builder = factory.newDocumentBuilder(); document = builder.parse(xml_file); } catch (Exception e)
     * { e.printStackTrace(); } String subNodeTag = %%2; Element rootNode = document.getDocumentElement();
     * //%%2="Product" //%%4="id" //%%6="port" //%%3="Name" //%%5="001" NodeList nlist =
     * rootNode.getElementsByTagName(subNodeTag); int len = nlist.getLength(); for (int i = 0; i < len; i++) { node =
     * nlist.item(i); String getNodeAttrValue = null; NamedNodeMap attrList = node.getAttributes(); for (int j = 0; j <
     * attrList.getLength(); j++) { if (attrList.item(j).getNodeName().equals(%%4)) { getNodeAttrValue =
     * attrList.item(j).getNodeValue(); break; } } if (getNodeAttrValue.equals(%%5)) { nlist = node.getChildNodes();
     * String %%9=((Element) node).getElementsByTagName(%%3).item(0) .getFirstChild().getNodeValue(); break; } }
     * 
     * 38.写入XML数据库
     * 
     * import java.io.*; import javax.xml.parsers.*; import org.w3c.dom.*; import javax.xml.transform.*; import
     * javax.xml.transform.dom.*; import javax.xml.transform.stream.*; private Document document; private Element node;
     * 
     * File xml_file = new File(%%1); DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); try {
     * DocumentBuilder builder = factory.newDocumentBuilder(); document = builder.parse(xml_file); } catch (Exception e)
     * { e.printStackTrace(); } String subNodeTag = %%2; Element rootNode = document.getDocumentElement(); //
     * %%2="Product" //%%4="pid" //%%6="author" // %%3="Name" //%%5="price" NodeList nlist =
     * rootNode.getElementsByTagName(subNodeTag); String ss = null; int len = nlist.getLength(); for (int i = 0; i <
     * len; i++) { node = (Element) nlist.item(i); //node.setAttribute(%%4, "0"+String.valueOf(i)); //ID格式化 String
     * getNodeAttrValue = null; NamedNodeMap attrList = node.getAttributes(); for (int j = 0; j < attrList.getLength();
     * j++) { if (attrList.item(j).getNodeName().equals(%%4)) { getNodeAttrValue = attrList.item(j).getNodeValue();
     * break; } } if (getNodeAttrValue.equals("001")) { nlist = node.getChildNodes(); ss = ((Element)
     * node).getElementsByTagName(%%3).item(0) .getFirstChild().getNodeValue(); ss = ((Element)
     * node).getElementsByTagName(%%6).item(0) .getFirstChild().getNodeValue(); ss = ((Element)
     * node).getElementsByTagName(%%5).item(0) .getFirstChild().getNodeValue(); ((Element)
     * node).getElementsByTagName(%%3).item(0) .getFirstChild().setTextContent(%%7); ((Element)
     * node).getElementsByTagName(%%6).item(0) .getFirstChild().setTextContent(%%8); ((Element)
     * node).getElementsByTagName(%%5).item(0) .getFirstChild().setTextContent(%%9); break; } } if (ss == null) { node =
     * document.createElement(%%2); node.setAttribute(%%4, String.valueOf(nlist.getLength() + 1));
     * node.appendChild(document.createTextNode("\n")); Element server = document.createElement(%%3);
     * server.appendChild(document.createTextNode(%%7)); node.appendChild(server); Element ipNode =
     * document.createElement(%%6); ipNode.appendChild(document.createTextNode(%%8)); node.appendChild(ipNode);
     * node.appendChild(document.createTextNode("\n")); Element port = document.createElement(%%5);
     * port.appendChild(document.createTextNode(%%9)); node.appendChild(port);
     * node.appendChild(document.createTextNode("\n")); rootNode.appendChild(node); } TransformerFactory tFactory =
     * TransformerFactory.newInstance(); Transformer transformer = null; try { transformer = tFactory.newTransformer();
     * DOMSource source = new DOMSource(document); StreamResult result = new StreamResult(xml_file);
     * transformer.transform(source, result); } catch (IOException e) { e.printStackTrace(); }
     * 
     * 39.ZIP压缩文件
     * 
     * import java.io.*; import java.util.zip.*;
     * 
     * //创建文件输入流对象 FileInputStream fis=new FileInputStream(%%1); //创建文件输出流对象 FileOutputStream fos=new
     * FileOutputStream(%%2); //创建ZIP数据输出流对象 ZipOutputStream zipOut=new ZipOutputStream(fos); //创建指向压缩原始文件的入口 ZipEntry
     * entry=new ZipEntry(args[0]); try { zipOut.putNextEntry(entry); //向压缩文件中输出数据 int nNumber; byte[] buffer=new
     * byte[1024]; while((nNumber=fis.read(buffer))!=-1) zipOut.write(buffer,0,nNumber); //关闭创建的流对象 zipOut.close();
     * fos.close(); fis.close(); } catch(IOException e) { e.printStackTrace(); }
     * 
     * 40.ZIP解压缩
     * 
     * import java.io.*; import java.util.zip.*;
     * 
     * //创建文件输入流对象实例 FileInputStream fis=new FileInputStream(%%1); //创建ZIP压缩格式输入流对象实例 ZipInputStream zipin=new
     * ZipInputStream(fis); //创建文件输出流对象实例 FileOutputStream fos=new FileOutputStream(%%2); //获取Entry对象实例 ZipEntry
     * entry=zipin.getNextEntry(); byte[] buffer=new byte[1024]; int nNumber; try{
     * while((nNumber=zipin.read(buffer,0,buffer.length))!=-1) fos.write(buffer,0,nNumber); //关闭文件流对象 zipin.close();
     * fos.close(); fis.close(); } catch(IOException e) { e.printStackTrace(); }
     * 
     * 41.获得应用程序完整路径 String %%1=System.getProperty("user.dir");
     * 
     * 42.递归删除目录中的文件
     * 
     * import java.io.*; import java.util.*;
     * 
     * ArrayList<String> folderList = new ArrayList<String>(); folderList.add(%%1); for (int j = 0; j <
     * folderList.size(); j++) { File file = new File(folderList.get(j)); File[] files = file.listFiles();
     * ArrayList<File> fileList = new ArrayList<File>(); for (int i = 0; i < files.length; i++) { if
     * (files[i].isDirectory()) { folderList.add(files[i].getPath()); } else { fileList.add(files[i]); } } for (File f :
     * fileList) { f.delete(); } }
     * 
     * 43.ZIP压缩文件夹
     * 
     * import java.io.*; import java.util.*; import java.util.zip.*;
     * 
     * public static String zipFileProcess(ArrayList outputZipFileNameList, String outputZipNameAndPath) { ArrayList
     * fileNames = new ArrayList(); ArrayList files = new ArrayList(); FileOutputStream fileOut = null; ZipOutputStream
     * outputStream = null; FileInputStream fileIn = null; StringBuffer sb = new StringBuffer(outputZipNameAndPath); //
     * FileInputStream fileIn =null; try { if (outputZipNameAndPath.indexOf(".zip") != -1) { outputZipNameAndPath =
     * outputZipNameAndPath; } else { sb.append(".zip"); outputZipNameAndPath = sb.toString(); } fileOut = new
     * FileOutputStream(outputZipNameAndPath); outputStream = new ZipOutputStream(fileOut); int
     * outputZipFileNameListSize = 0; if (outputZipFileNameList != null) { outputZipFileNameListSize =
     * outputZipFileNameList.size(); } for (int i = 0; i < outputZipFileNameListSize; i++) { File rootFile = new
     * File(outputZipFileNameList.get(i).toString()); listFile(rootFile, fileNames, files, ""); } for (int loop = 0;
     * loop < files.size(); loop++) { fileIn = new FileInputStream((File) files.get(loop));
     * outputStream.putNextEntry(new ZipEntry((String) fileNames.get(loop))); byte[] buffer = new byte[1024]; while
     * (fileIn.read(buffer) != -1) { outputStream.write(buffer); } outputStream.closeEntry(); fileIn.close(); } return
     * outputZipNameAndPath; } catch (IOException ioe) { return null; } finally { if (outputStream != null) { try {
     * outputStream.close(); } catch (IOException e) { } } if (fileIn != null) { try { fileIn.close(); } catch
     * (IOException e) { } } } } private static void listFile(File parentFile, List nameList, List fileList, String
     * directoryName) { if (parentFile.isDirectory()) { File[] files = parentFile.listFiles(); for (int loop = 0; loop <
     * files.length; loop++) { listFile(files[loop], nameList, fileList, directoryName + parentFile.getName() + "/"); }
     * } else { fileList.add(parentFile); nameList.add(directoryName + parentFile.getName()); } } String savePath=%%1;
     * ArrayList<String> outputZipFileName=new ArrayList<String>(); outputZipFileName.add(%%2);
     * zipFileProcess(outputZipFileName,savePath);
     * 
     * 44.IDEA加密算法 private byte[] bytekey; public byte[] getKey(String key){ int len1 =key.length(); if (len1>=16) {
     * key=key.substring(0, 16); } else { for (int i=0;i<16-len1;i++){ key=key.concat("0"); } } bytekey=key.getBytes();
     * return bytekey; }
     *//**
     * 加密String明文输入,String密文输出
     * 
     * @param strMing
     * @return
     */
    /*
     * public String getEncString(String strMing) { byte[] byteMi = null; byte[] byteMing = null; String strMi = ""; try
     * { return byte2hex(IdeaEncrypt(bytekey,strMing.getBytes(),true) ); } catch(Exception e){ e.printStackTrace(); }
     * finally { byteMing = null; byteMi = null; } return strMi; }
     *//**
     * 解密 以String密文输入,String明文输出
     * 
     * @param strMi
     * @return
     */
    /*
     * public String getDesString(String strMi) { byte[] byteMing = null; byte[] byteMi = null; String strMing = ""; try
     * { String tmp= new String(IdeaEncrypt(bytekey,hex2byte(strMi.getBytes()),false )); int len1=tmp.length(); return
     * tmp.substring(0, len1-6); } catch(Exception e) { e.printStackTrace(); } finally { byteMing = null; byteMi = null;
     * } return strMing; } private byte[] Encrypt(byte[] bytekey, byte[] inputBytes, boolean flag) { byte[] encryptCode
     * = new byte[8]; // 分解子密钥 int[] key = get_subkey(flag, bytekey); // 进行加密操作 encrypt(key, inputBytes, encryptCode);
     * // 返回加密数据 return encryptCode; }
     * 
     * private int bytesToInt(byte[] inBytes, int startPos) { return ((inBytes[startPos] << 8) & 0xff00) +
     * (inBytes[startPos + 1] & 0xff); }
     * 
     * private void intToBytes(int inputInt, byte[] outBytes, int startPos) { outBytes[startPos] = (byte) (inputInt >>>
     * 8); outBytes[startPos + 1] = (byte) inputInt; }
     * 
     * private int x_multiply_y(int x, int y) { if (x == 0) { x = 0x10001 - y; } else if (y == 0) { x = 0x10001 - x; }
     * else { int tmp = x * y; y = tmp & 0xffff; x = tmp >>> 16; x = (y - x) + ((y < x) ? 1 : 0); }
     * 
     * return x & 0xffff; }
     * 
     * private void encrypt(int[] key, byte[] inbytes, byte[] outbytes) { int k = 0; int a = bytesToInt(inbytes, 0); int
     * b = bytesToInt(inbytes, 2); int c = bytesToInt(inbytes, 4); int d = bytesToInt(inbytes, 6);
     * 
     * for (int i = 0; i < 8; i++) { a = x_multiply_y(a, key[k++]); b += key[k++]; b &= 0xffff; c += key[k++]; c &=
     * 0xffff; d = x_multiply_y(d, key[k++]);
     * 
     * int tmp1 = b; int tmp2 = c; c ^= a; b ^= d; c = x_multiply_y(c, key[k++]); b += c; b &= 0xffff; b =
     * x_multiply_y(b, key[k++]); c += b; c &= 0xffff; a ^= b; d ^= c; b ^= tmp2; c ^= tmp1; }
     * 
     * intToBytes(x_multiply_y(a, key[k++]), outbytes, 0); intToBytes(c + key[k++], outbytes, 2); intToBytes(b +
     * key[k++], outbytes, 4); intToBytes(x_multiply_y(d, key[k]), outbytes, 6); }
     * 
     * private int[] encrypt_subkey(byte[] byteKey) { int[] key = new int[52];
     * 
     * if (byteKey.length < 16) { byte[] tmpkey = new byte[16]; System.arraycopy(byteKey, 0, tmpkey, tmpkey.length -
     * byteKey.length, byteKey.length); byteKey = tmpkey; }
     * 
     * for (int i = 0; i < 8; i++) { key[i] = bytesToInt(byteKey, i * 2); }
     * 
     * for (int j = 8; j < 52; j++) { if ((j & 0x7) < 6) { key[j] = (((key[j - 7] & 0x7f) << 9) | (key[j - 6] >> 7)) &
     * 0xffff; } else if ((j & 0x7) == 6) { key[j] = (((key[j - 7] & 0x7f) << 9) | (key[j - 14] >> 7)) & 0xffff; } else
     * { key[j] = (((key[j - 15] & 0x7f) << 9) | (key[j - 14] >> 7)) & 0xffff; } }
     * 
     * return key; }
     * 
     * private int fun_a(int a) { if (a < 2) { return a; }
     * 
     * int b = 1; int c = 0x10001 / a;
     * 
     * for (int i = 0x10001 % a; i != 1;) { int d = a / i; a %= i; b = (b + (c * d)) & 0xffff;
     * 
     * if (a == 1) { return b; } d = i / a; i %= a; c = (c + (b * d)) & 0xffff; }
     * 
     * return (1 - c) & 0xffff; }
     * 
     * private int fun_b(int b) { return (0 - b) & 0xffff; }
     * 
     * private int[] uncrypt_subkey(int[] key) { int dec = 52; int asc = 0; int[] unkey = new int[52]; int aa =
     * fun_a(key[asc++]); int bb = fun_b(key[asc++]); int cc = fun_b(key[asc++]); int dd = fun_a(key[asc++]);
     * unkey[--dec] = dd; unkey[--dec] = cc; unkey[--dec] = bb; unkey[--dec] = aa;
     * 
     * for (int k1 = 1; k1 < 8; k1++) { aa = key[asc++]; bb = key[asc++]; unkey[--dec] = bb; unkey[--dec] = aa; aa =
     * fun_a(key[asc++]); bb = fun_b(key[asc++]); cc = fun_b(key[asc++]); dd = fun_a(key[asc++]); unkey[--dec] = dd;
     * unkey[--dec] = bb; unkey[--dec] = cc; unkey[--dec] = aa; }
     * 
     * aa = key[asc++]; bb = key[asc++]; unkey[--dec] = bb; unkey[--dec] = aa; aa = fun_a(key[asc++]); bb =
     * fun_b(key[asc++]); cc = fun_b(key[asc++]); dd = fun_a(key[asc]); unkey[--dec] = dd; unkey[--dec] = cc;
     * unkey[--dec] = bb; unkey[--dec] = aa;
     * 
     * return unkey; }
     * 
     * private int[] get_subkey(boolean flag, byte[] bytekey) { if (flag) { return encrypt_subkey(bytekey); } else {
     * return uncrypt_subkey(encrypt_subkey(bytekey)); } }
     * 
     * private byte[] ByteDataFormat(byte[] data, int unit) { int len = data.length; int padlen = unit - (len % unit);
     * int newlen = len + padlen; byte[] newdata = new byte[newlen]; System.arraycopy(data, 0, newdata, 0, len);
     * 
     * for (int i = len; i < newlen; i++) newdata[i] = (byte) padlen;
     * 
     * return newdata; }
     * 
     * public byte[] IdeaEncrypt(byte[] idea_key, byte[] idea_data, boolean flag) { byte[] format_key =
     * ByteDataFormat(idea_key, 16); byte[] format_data = ByteDataFormat(idea_data, 8);
     * 
     * int datalen = format_data.length; int unitcount = datalen / 8; byte[] result_data = new byte[datalen];
     * 
     * for (int i = 0; i < unitcount; i++) { byte[] tmpkey = new byte[16]; byte[] tmpdata = new byte[8];
     * System.arraycopy(format_key, 0, tmpkey, 0, 16); System.arraycopy(format_data, i * 8, tmpdata, 0, 8);
     * 
     * byte[] tmpresult = Encrypt(tmpkey, tmpdata, flag); System.arraycopy(tmpresult, 0, result_data, i * 8, 8); }
     * 
     * return result_data; }
     *//**
     * 二行制转字符串
     * 
     * @param b
     * @return
     */
    /*
     * public static String byte2hex(byte[] b) { //一个字节的数， // 转成16进制字符串 String hs = ""; String stmp = ""; for (int n =
     * 0; n < b.length; n++) { //整数转成十六进制表示 stmp = (java.lang.Integer.toHexString(b[n] & 0XFF)); if (stmp.length() == 1)
     * hs = hs + "0" + stmp; else hs = hs + stmp; } return hs.toUpperCase(); //转成大写 }
     * 
     * public static byte[] hex2byte(byte[] b) { if((b.length%2)!=0) throw new IllegalArgumentException("长度不是偶数");
     * byte[] b2 = new byte[b.length/2]; for (int n = 0; n < b.length; n+=2) { String item = new String(b,n,2); //
     * 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节 b2[n/2] = (byte)Integer.parseInt(item,16); }
     * 
     * return b2; }
     * 
     * public static void main(String[] args) {
     * 
     * 
     * IDEA idea = new IDEA();
     * 
     * idea.getKey("aadd");//生成密匙
     * 
     * String strEnc = idea.getEncString("1234567890");//加密字符串,返回String的密文 System.out.println(strEnc);
     * 
     * String strDes = idea.getDesString(strEnc);//把String 类型的密文解密 System.out.println(strDes);
     * 
     * 
     * // String key = "0000000000000000"; // String data = "11111111冯"; // byte[] bytekey = key.getBytes(); // byte[]
     * bytedata = data.getBytes(); // // IDEA idea = new IDEA(); // byte[] encryptdata = idea.IdeaEncrypt(bytekey,
     * bytedata, true); // byte[] decryptdata = idea.IdeaEncrypt(bytekey, encryptdata, false); // //
     * System.out.println("--------------------------------"); // // for (int i = 0; i < bytedata.length; i++) { //
     * System.out.print(" " + bytedata[i] + " "); // } // // System.out.println(""); // // for (int i = 0; i <
     * encryptdata.length; i++) { // System.out.print(" " + encryptdata[i] + " "); // } // // System.out.println(""); //
     * // for (int i = 0; i < decryptdata.length; i++) { // System.out.print(" " + decryptdata[i] + " "); // }
     * 
     * }
     * 
     * 45.验证Schema
     * 
     * import javax.xml.*; import javax.xml.transform.stream.*; import javax.xml.validation.*; import org.xml.sax.*;
     * 
     * SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); StreamSource ss = new
     * StreamSource(%%1); //"mySchema.xsd" try { Schema schema = factory.newSchema(ss); } catch (SAXException e) {
     * e.printStackTrace(); }
     * 
     * 46.Grep
     * 
     * import java.util.regex.*; import java.io.*;
     * 
     * throws Exception Pattern pattern = Pattern.compile(%%1); // 第一个参数为需要匹配的字符串 Matcher matcher = pattern.matcher("");
     * String file = %%2; BufferedReader br = null; String line; try { br = new BufferedReader (new FileReader (file));
     * // 打开文件 } catch (IOException e) { // 没有打开文件，则产生异常 System.err.println ("Cannot read '" + file + "': " +
     * e.getMessage()); } while ((line = br.readLine()) != null) { // 读入一行，直到文件结束 matcher.reset (line); // 匹配字符串 if
     * (matcher.find()) { // 如果有匹配的字符串，则输出 //line } } br.close(); // 关闭文件
     * 
     * 47.直接创建多级目录 //import java.io.*; File f=new File(%%1); f.mkdirs();
     * 
     * 48.批量重命名 //import java.io.*; File target = new File("%%1"); String[] files = target.list(); File f = null; String
     * filename = null; for (String file : files) { f = new File(target, file); filename = f.getName(); if
     * (filename.substring(filename.lastIndexOf('.')).equalsIgnoreCase( "%%2")) { f.renameTo(new
     * File(target.getAbsolutePath(), filename.replace( "%%2", "%%3"))); // 这里可以反复使用replace替换,当然也可以使用正则表达式来替换了 ".txt"
     * ".bat" } }
     * 
     * 49.文本查找替换 //import java.nio.*; String s1=%%1; String s2=%%2; String s3=%%3; int pos=%%4;
     * 变量i和j分别表示主串和模式串中当前字符串的位置，k表示匹配次数 int i,j,k=0; i = pos; j = 0; //将s1转化成StringBuffer型进行操作 repStr = new
     * StringBuffer(s1); while(i<repStr.length()&&j<s2.length()) { if(repStr.charAt(i) == s2.charAt(j)) { ++i; ++j;
     * if(j==s2.length()) { j=s2.length()表示字符串匹配成功，匹配次数加1，此外对主串进行字符串替换 k = k+1; repStr.replace(i-j,i,s3);
     * //将j进行重新赋值开始新的比较 j = 0; } } else {i = i-j+1; j = 0;} } return k;
     * 
     * 50.文件关联 //import java.io.*; try { Runtime.getRuntime().exec(%%1); //"assoc .txt =mynote"
     * "assoc [.ext[=[filetype]]]" } catch (IOException e) { e.printStackTrace(); }
     * 
     * 51.批量转换编码从GB2312到Unicode
     * 
     * 
     * 52.设置JDK环境变量
     * 
     * @echo off IF EXIST %1\bin\java.exe ( rem 如输入正确的 Java2SDK 安装目录，开始设置环境变量
     * 
     * @setx JAVA_HOME %1
     * 
     * @setx path %path%;%JAVA_HOME%\bin
     * 
     * @setx classpath %classpath%;.
     * 
     * @setx classpath %classpath%;%JAVA_HOME%\lib\tools.jar
     * 
     * @setx classpath %classpath%;%JAVA_HOME%\lib\dt.jar
     * 
     * @setx classpath %classpath%;%JAVA_HOME%\jre\lib\rt.jar
     * 
     * @echo on
     * 
     * @echo Java 2 SDK 环境参数设置完毕，正常退出。 ) ELSE ( IF "%1"=="" ( rem 如没有提供安装目录，提示之后退出
     * 
     * @echo on
     * 
     * @echo 没有提供 Java2SDK 的安装目录,不做任何设置，现在退出环境变量设置。 ) ELSE ( rem 如果提供非空的安装目录但没有bin\java.exe，则指定的目录为错误的目录
     * 
     * @echo on
     * 
     * @echo 非法的 Java2SDK 的安装目录,不做任何设置，现在退出环境变量设置。 ) ) //http://sourceforge.net/projects/jregistrykey/ //import
     * ca.beq.util.win32.registry.*; //import java.util.*; 1.打开键 RegistryKey r = new
     * RegistryKey(RootKey.HKEY_LOCAL_MACHINE, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders");
     * 2.添加键 RegistryKey r = new RegistryKey(RootKey.HKEY_CURRENT_USER, "Software\\BEQ Technologies"); r.create();
     * 9.写入字符串值 RegistryKey r = new RegistryKey(RootKey.HKEY_CURRENT_USER, "Software\\BEQ Technologies"); RegistryValue
     * v = new RegistryValue("myVal", ValueType.REG_SZ, "data"); r.setValue(v); 6.获取DWORD值 RegistryKey r = new
     * RegistryKey(RootKey.HKEY_CURRENT_USER, "Software\\BEQ Technologies"); if(r.hasValue("myValue")) { RegistryValue v
     * = r.getValue("myValue"); v.setType(ValueType.REG_DWORD); } // if
     * 
     * 
     * 53.批量转换编码从Unicode到GB2312
     * 
     * 54.删除空文件夹 //import java.io.*; File f=new File(%%1); if (isFolerNull(f)) { for (File file :f.listFiles()) { if
     * (file.list().length == 0) file.delete(); } }
     * 
     * 55.GB2312文件转UTF-8格式 //import java.io.*; public class CharsetConvertor { public static void main(String[] args) {
     * String str = "This is a test for *中网!@#$。，？"; try { File f = new File("D:/test.txt"); FileOutputStream fio = new
     * FileOutputStream(f); String s = gbToUtf8(str); fio.write(s.getBytes("UTF-8")); fio.close(); } catch (Exception e)
     * { e.printStackTrace(); } }
     * 
     * public static String gbToUtf8(String str) throws UnsupportedEncodingException { StringBuffer sb = new
     * StringBuffer(); for (int i = 0; i < str.length(); i++) { String s = str.substring(i, i + 1); if (s.charAt(0) >
     * 0x80) { byte[] bytes = s.getBytes("Unicode"); String binaryStr = ""; for (int j = 2; j < bytes.length; j += 2) {
     * // the first byte String hexStr = getHexString(bytes[j + 1]); String binStr =
     * getBinaryString(Integer.valueOf(hexStr, 16)); binaryStr += binStr; // the second byte hexStr =
     * getHexString(bytes[j]); binStr = getBinaryString(Integer.valueOf(hexStr, 16)); binaryStr += binStr; } // convert
     * unicode to utf-8 String s1 = "1110" + binaryStr.substring(0, 4); String s2 = "10" + binaryStr.substring(4, 10);
     * String s3 = "10" + binaryStr.substring(10, 16); byte[] bs = new byte[3]; bs[0] = Integer.valueOf(s1,
     * 2).byteValue(); bs[1] = Integer.valueOf(s2, 2).byteValue(); bs[2] = Integer.valueOf(s3, 2).byteValue(); String ss
     * = new String(bs, "UTF-8"); sb.append(ss); } else { sb.append(s); } } return sb.toString(); }
     * 
     * private static String getHexString(byte b) { String hexStr = Integer.toHexString(b); int m = hexStr.length(); if
     * (m < 2) { hexStr = "0" + hexStr; } else { hexStr = hexStr.substring(m - 2); } return hexStr; }
     * 
     * private static String getBinaryString(int i) { String binaryStr = Integer.toBinaryString(i); int length =
     * binaryStr.length(); for (int l = 0; l < 8 - length; l++) { binaryStr = "0" + binaryStr; } return binaryStr; } }
     * 
     * 
     * 56.UTF-8文件转GB2312格式 private String utf8Togb2312(String str){ StringBuffer sb = new StringBuffer(); for(int i=0;
     * i<str.length(); i++) { char c = str.charAt(i); switch (c) { case '+': sb.append(' '); break; case '%': try {
     * sb.append((char)Integer.parseInt( str.substring(i+1,i+3),16)); } catch (NumberFormatException e) { throw new
     * IllegalArgumentException(); } i += 2; break; default: sb.append(c); break; } } // Undo conversion to external
     * encoding String result = sb.toString(); String res=null; try{ byte[] inputBytes = result.getBytes("8859_1"); res=
     * new String(inputBytes,"UTF-8"); } catch(Exception e){} return res; }
     * 
     * 57.获取文件路径的父路径 String %%2=%%1.substring(0,%%1.lastIndexOf("\\"));
     * 
     * 58.Unicode文件转UTF-8格式 try { // Convert from Unicode to UTF-8 String string = "abc\u5639\u563b"; byte[] utf8 =
     * string.getBytes("UTF-8"); // Convert from UTF-8 to Unicode string = new String(utf8, "UTF-8"); } catch
     * (UnsupportedEncodingException e) { }
     *//**
     * unicode 转换成 utf-8
     * 
     * @author fanhui 2007-3-15
     * @param theString
     * @return
     */
    /*
     * public static String unicodeToUtf8(String theString) { char aChar; int len = theString.length(); StringBuffer
     * outBuffer = new StringBuffer(len); for (int x = 0; x < len;) { aChar = theString.charAt(x++); if (aChar == '\\')
     * { aChar = theString.charAt(x++); if (aChar == 'u') { // Read the xxxx int value = 0; for (int i = 0; i < 4; i++)
     * { aChar = theString.charAt(x++); switch (aChar) { case '0': case '1': case '2': case '3': case '4': case '5':
     * case '6': case '7': case '8': case '9': value = (value << 4) + aChar - '0'; break; case 'a': case 'b': case 'c':
     * case 'd': case 'e': case 'f': value = (value << 4) + 10 + aChar - 'a'; break; case 'A': case 'B': case 'C': case
     * 'D': case 'E': case 'F': value = (value << 4) + 10 + aChar - 'A'; break; default: throw new
     * IllegalArgumentException( "Malformed \\uxxxx encoding."); } } outBuffer.append((char) value); } else { if (aChar
     * == 't') aChar = '\t'; else if (aChar == 'r') aChar = '\r'; else if (aChar == 'n') aChar = '\n'; else if (aChar ==
     * 'f') aChar = '\f'; outBuffer.append(aChar); } } else outBuffer.append(aChar); } return outBuffer.toString(); }
     * 
     * 59.CRC循环冗余校验
     * 
     * import java.nio.*; import java.util.zip.*;
     * 
     * try { FileInputStream in = new FileInputStream(%%1); FileChannel channel = in.getChannel(); CRC32 crc = new
     * CRC32(); int length = (int)channel.size(); MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,
     * 0, length); for(int i = 0;i<length;i++) { int c = buffer.get(i); crc.update(c); }
     * System.out.println("crc校验和："+(Long.toHexString(crc.getValue())).toUpperCase()); } catch (Exception e) {
     * e.printStackTrace(); }
     * 
     * 60.判断是否为空文件 //import java.io.*; FileReader fr=new FileReader(%%1); if(fr.read()==1) //空白文件
     * 
     * 61.终止程序 Runtime.exec("taskkill /F /IM %%1.exe");
     * 
     * 62.定时关机 import java.awt.*; import java.awt.event.*; import java.awt.geom.*; import java.util.*; import
     * javax.swing.*;
     * 
     * public class ClockFrame extends JFrame { private JComboBox hourBox, minuteBox, secondBox;
     * 
     * private int hour, minute, second, totalSeconds, currentSeconds;
     * 
     * private long argue;
     * 
     * private GregorianCalendar calendar;
     * 
     * private boolean change = true;
     * 
     * private static final int WIDTH = 200;
     * 
     * private static final int HEIGHT = 150;
     * 
     * public ClockFrame() {
     * 
     * setTitle("关机定时"); setSize(200, 150);
     * 
     * Container contentPanel = getContentPane();
     * 
     * JPanel timePanel = new JPanel(); timePanel.setLayout(new GridLayout(4, 2));
     * 
     * JLabel minuteLable = new JLabel("设置分钟"); timePanel.add(minuteLable); minuteBox = new JComboBox();
     * timePanel.add(minuteBox); for (int i = 0; i < 60; i++) { minuteBox.addItem(i); } minuteBox.addActionListener(new
     * ActionListener() { public void actionPerformed(ActionEvent evt) { minute = ((Integer)
     * minuteBox.getSelectedItem()).intValue(); } });
     * 
     * JLabel secondLable = new JLabel("设置秒钟"); timePanel.add(secondLable); secondBox = new JComboBox();
     * timePanel.add(secondBox); for (int i = 0; i < 60; i++) { secondBox.addItem(i); } secondBox.addActionListener(new
     * ActionListener() { public void actionPerformed(ActionEvent evt) { second = ((Integer)
     * secondBox.getSelectedItem()).intValue(); } }); contentPanel.add(timePanel, BorderLayout.CENTER);
     * 
     * JButton check = new JButton("确定"); contentPanel.add(check, BorderLayout.SOUTH); check.addActionListener(new
     * ActionListener() { public void actionPerformed(ActionEvent evt) { JButton check=(JButton) evt.getSource(); if
     * (check.getText().equals("确定")) { calendar = new GregorianCalendar(); int currentSeconds =
     * calendar.get(Calendar.HOUR_OF_DAY) 3600 + calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.SECOND);
     * totalSeconds = hour * 3600 + minute * 60 + second;
     * 
     * if (totalSeconds - currentSeconds >= 0) { argue = (totalSeconds - currentSeconds) * 1000;
     * JOptionPane.showMessageDialog(ClockFrame.this, "您设置的时间为 " + hour + ":" + minute + ":" + second +
     * "\n程序将在后台运行，并在此时自动关闭计算机！", "设置成功", JOptionPane.INFORMATION_MESSAGE); hideFrame(); } try { //
     * Thread.sleep(argue);//这句没用 Runtime.getRuntime().exec( "shutdown.exe -s -c \"我要关机了噢！不好意思！\" -t " + totalSeconds);
     * check.setText("取消"); } catch (Exception e) { e.printStackTrace(); } }else{ try {
     * Runtime.getRuntime().exec("shutdown.exe -a"); check.setText("确定"); } catch (Exception e) { e.printStackTrace(); }
     * } } }); }
     * 
     * private void hideFrame() { this.setVisible(false); }
     * 
     * public static void main(String[] args) { JFrame frame = new ClockFrame();
     * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setLocationByPlatform(true); frame.show(); } }
     * 
     * 63.显示进程列表 //import java.io.*; BufferedReader br=null; try { Process proc=Runtime.getRuntime().exec("tasklist");
     * br=new BufferedReader(new InputStreamReader(proc.getInputStream()));
     * 
     * @SuppressWarnings("unused") String line=null; while((line=br.readLine())!=null){ //br.readLine() } } catch
     * (IOException e) { e.printStackTrace(); }finally{ if(br!=null){ try { br.close(); } catch (Exception e) {
     * e.printStackTrace(); } } }
     * 
     * 64.遍历文件夹列出文件大小
     * 
     * 65.目录下所有文件移动到整合操作
     * 
     * import java.io.*; import java.util.*; import javax.swing.*;
     * 
     * JFileChooser Jfc = new JFileChooser("请选择源路径"); // 建立选择档案对话方块盒 Jfc Jfc.showDialog(null, %%1); if
     * (!Jfc.getSelectedFile() != null) { return; } String %%1 = Jfc.getSelectedFile().getParent(); Jfc = new
     * JFileChooser("请选择目标路径"); // 建立选择档案对话方块盒 Jfc Jfc.showDialog(null, %%1); if (!Jfc.getSelectedFile() != null) {
     * return; } String %%2 = Jfc.getSelectedFile().getParent();
     * 
     * 66.对目标压缩文件解压缩到指定文件夹
     * 
     * import java.io.*; import java.util.zip.*;
     * 
     * String zipFileName=%%1; String extPlace=%%2; File myFolderPath = new File(extPlace); try { if
     * (!myFolderPath.exists()) { myFolderPath.mkdir(); } } catch (Exception e) { //新建目录操作出错 e.printStackTrace();
     * return; } try { ZipInputStream in = new ZipInputStream(new FileInputStream( zipFileName)); ZipEntry entry = null;
     * while ((entry = in.getNextEntry()) != null) { String entryName = entry.getName(); File file = new File(extPlace ,
     * entryName); if (entry.isDirectory()) { file.mkdirs(); } else { FileOutputStream os = new FileOutputStream(file);
     * // Transfer bytes from the ZIP file to the output // file byte[] buf = new byte[10240]; int len; while ((len =
     * in.read(buf)) > 0) { os.write(buf, 0, len); } os.close(); in.closeEntry(); } } } catch (IOException e) {
     * e.printStackTrace(); }
     * 
     * 67.创建目录副本整合操作
     * 
     * import java.io.*; import java.util.*; import javax.swing.*;
     * 
     * JFileChooser Jfc = new JFileChooser("请选择源路径"); // 建立选择档案对话方块盒 Jfc Jfc.showDialog(null, %%1); if
     * (!Jfc.getSelectedFile() != null) { return; } String %%1 = Jfc.getSelectedFile().getParent(); Jfc = new
     * JFileChooser("请选择目标路径"); // 建立选择档案对话方块盒 Jfc Jfc.showDialog(null, %%1); if (!Jfc.getSelectedFile() != null) {
     * return; } String %%2 = Jfc.getSelectedFile().getParent();
     * 
     * 68.打开网页 //import java.io.*; try{ String command = "C:\\Program Files\\Internet Explorer\\Iexplore.exe "+%%1;
     * Runtime.getRuntime().exec(command); } catch (IOException ex) { ex.printStackTrace(); }
     * 
     * 69.删除空文件夹整合操作
     * 
     * import java.io.*; import java.util.*; import javax.swing.*;
     * 
     * 
     * 70.获取磁盘所有分区，把结果放在数组drives中 String root; //root代表盘符路径 for(i=0;i<20;i++) //0-20代表最大的盘符数 {
     * root.Format("%c:\\",allfenqu[i]); if(GetDriveType(root)==5) allfenqu[i]='\0'; }
     * 
     * 但我用这样的代码时结果却无法去掉光驱盘符，allfenqu[]中还是会包含光驱盘符： String root; for(i=0;i<20;i++) { root=allfenqu[i]+":\\";
     * if(GetDriveType(root)==5) allfenqu[i]='\0'; }
     * 
     * 71.激活一个程序或程序关联的文件 //import java.io.*; try { Runtime.getRuntime().exec(%%1); } catch (IOException e) {
     * e.printStackTrace(); }
     * 
     * 72.MP3播放 //必须下载 jmf包 //import javax.media.bean.playerbean.MediaPlayer; //必须下载 jmf 媒体播放包 MediaPlayer player;
     * player = new MediaPlayer(); setLayout(new FlowLayout()); try{
     * player.setMediaLocation("file:/F:\\音乐\\mp3\\黑白配.mp3");// <<file:/>>不能删除 音频文件路径 } catch (Exception e) {
     * System.err.println("文件不存在"); } player.start(); player.stop();
     * 
     * 73.WAV播放
     * 
     * import javax.sound.sampled.*; import java.io.*;
     * 
     * private AudioFormat format; private byte[] samples; private String filename; try { // open the audio input stream
     * AudioInputStream stream =AudioSystem.getAudioInputStream(new File(filename)); format = stream.getFormat(); // get
     * the audio samples samples = getSamples(stream); } catch (UnsupportedAudioFileException ex) {
     * ex.printStackTrace(); } catch (IOException ex) { ex.printStackTrace(); }
     * 
     * private byte[] getSamples(AudioInputStream audioStream) { // get the number of bytes to read int length =
     * (int)(audioStream.getFrameLength() * format.getFrameSize());
     * 
     * // read the entire stream byte[] samples = new byte[length]; DataInputStream is = new
     * DataInputStream(audioStream); try { is.readFully(samples); } catch (IOException ex) { ex.printStackTrace(); }
     * 
     * // return the samples return samples; }
     * 
     * public void play(InputStream source) {
     * 
     * // use a short, 100ms (1/10th sec) buffer for real-time // change to the sound stream int bufferSize =
     * format.getFrameSize() * Math.round(format.getSampleRate() / 10); byte[] buffer = new byte[bufferSize];
     * 
     * // create a line to play to SourceDataLine line; try { DataLine.Info info = new
     * DataLine.Info(SourceDataLine.class, format); line = (SourceDataLine)AudioSystem.getLine(info); line.open(format,
     * bufferSize); } catch (LineUnavailableException ex) { ex.printStackTrace(); return; }
     * 
     * // start the line line.start();
     * 
     * // copy data to the line try { int numBytesRead = 0; while (numBytesRead != -1) { numBytesRead =
     * source.read(buffer, 0, buffer.length); if (numBytesRead != -1) { line.write(buffer, 0, numBytesRead); } } } catch
     * (IOException ex) { ex.printStackTrace(); }
     * 
     * // wait until all data is played, then close the line line.drain(); line.close(); }
     * 
     * throws Exception String filename=%%1; InputStream stream =new ByteArrayInputStream(sound.getSamples()); // play
     * the sound sound.play(stream);
     * 
     * 74.写图像到剪切板
     * 
     * import java.awt.*; import java.awt.datatransfer.*; import java.io.*; private final Image image;
     * 
     * Transferable trans = new Transferable() { public DataFlavor[] getTransferDataFlavors() { return new DataFlavor[]
     * { DataFlavor.imageFlavor }; }
     * 
     * public boolean isDataFlavorSupported(DataFlavor flavor) { return DataFlavor.imageFlavor.equals(flavor); }
     * 
     * public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException { if
     * (isDataFlavorSupported(flavor)) return image; throw new UnsupportedFlavorException(flavor); } };
     * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);
     * 
     * 75.从剪贴板复制图像到窗体
     * 
     * 76.删除文件夹下的所有文件且不删除文件夹下的文件夹
     * 
     * import java.io.*; import java.util.*;
     * 
     * LinkedList<String> folderList = new LinkedList<String>(); folderList.add(%%1); while (folderList.size() > 0) {
     * File file = new File((String)folderList.poll()); File[] files = file.listFiles(); ArrayList<File> fileList = new
     * ArrayList<File>(); for (int i = 0; i < files.length; i++) { if (files[i].isDirectory()) {
     * folderList.add(files[i].getPath()); } else { fileList.add(files[i]); } } for (File f : fileList) { f.delete(); }
     * }
     * 
     * 78.Unicode文件转GB2312格式 private static boolean isNeedConvert(char para){ return ((para&(0x00FF))!=para); } String
     * dataStr=%%1;"\\u9009 \\u5173"; int index = 0; StringBuffer buffer = new StringBuffer();
     * while(index<dataStr.length()) { if(!"\\u".equals(dataStr.substring(index,index+2))){
     * buffer.append(dataStr.charAt(index)); index++; continue; } String charStr = ""; charStr =
     * dataStr.substring(index+2,index+6); char letter = (char) Integer.parseInt(charStr, 16 ); buffer.append(letter);
     * index+=6; } String %%2=buffer.toString();
     * 
     * 79.开源程序库Xercesc-C++代码工程中内联 import java.io.*; import java.util.*; import java.util.regex.*; public class
     * InlineXercesc { private final String filter = ".cpp";
     * 
     * private ArrayList<String> all = new ArrayList<String>();
     * 
     * private LinkedList<String> fal2 = new LinkedList<String>();
     * 
     * private static String CurDir = System.getProperty("user.dir");
     * 
     * private void doSearch(String path) { File filepath = new File(path); if (filepath.exists() &&
     * filepath.isDirectory()) { File[] fileArray = filepath.listFiles(); for (File f : fileArray) { if
     * (f.isDirectory()) { doSearch(f.getPath()); } else { if (f.getName().indexOf(filter) >= 0) { for (String file :
     * all) { if (file.substring(file.lastIndexOf("\\") + 1) .equals(f.getName())) { fal2.add(f.getAbsolutePath()); } }
     * } } } } }
     * 
     * public InlineXercesc(String lib) throws IOException { String SourceLib = "D:\\Desktop\\大项目\\xerces-c-3.0.1\\src";
     * Pattern pattern = Pattern.compile("include.*?" + lib + ".*?>"); // 第一个参数为需要匹配的字符串 Matcher matcher =
     * pattern.matcher(""); LinkedList<String> fal = new LinkedList<String>(); File delfile = new File(CurDir); File[]
     * files2 = delfile.listFiles(); for (int l = 0; l < files2.length; l++) { if (files2[l].isDirectory()) { String
     * enumDir = CurDir + "\\" + files2[l].getName() + "\\"; LinkedList<String> folderList = new LinkedList<String>();
     * folderList.add(files2[l].getAbsolutePath()); while (folderList.size() > 0) { File file = new
     * File((String)folderList.poll()); File[] files = file.listFiles(); for (int i = 0; i < files.length; i++) { if
     * (files[i].isDirectory()) { folderList.add(files[i].getPath()); } else { String fileStr =
     * files[i].getAbsolutePath(); // 第2个参数开始，均为文件名。 BufferedReader br = null; String line; try { br = new
     * BufferedReader(new FileReader(fileStr)); // 打开文件 } catch (IOException e) { // 没有打开文件，则产生异常
     * System.err.println("Cannot read '" + fileStr + "': " + e.getMessage()); continue; } StringBuilder sb = new
     * StringBuilder(2048); while ((line = br.readLine()) != null) { // 读入一行，直到文件结束 matcher.reset(line); // 匹配字符串 if
     * (matcher.find()) { // 如果有匹配的字符串，则输出 sb.append(line.replace( line.substring(line.indexOf("<"),
     * line.lastIndexOf("/") + 1), "\"").replace('>', '\"')); line = line.substring( line.indexOf("<") + 1,
     * line.lastIndexOf(">")).replace('/', '\\'); fal.add(SourceLib + "\\" + line); } else { sb.append(line); }
     * sb.append("\r\n"); } br.close(); // 关闭文件 FileWriter fw2 = new FileWriter(fileStr); fw2.write(sb.toString());
     * fw2.flush(); fw2.close(); } } } while (fal.size() > 0) { String file = fal.poll(); // 第2个参数开始，均为文件名。 String
     * targetPath = enumDir + file.substring(file.lastIndexOf("\\") + 1); if (!new File(targetPath).exists()) {
     * BufferedReader br = null; String line; try { br = new BufferedReader(new FileReader(file)); // 打开文件 } catch
     * (IOException e) { // 没有打开文件，则产生异常 System.err.println("Cannot read '" + file + "': " + e.getMessage()); continue;
     * } FileWriter fw = new FileWriter(targetPath); while ((line = br.readLine()) != null) { // 读入一行，直到文件结束
     * matcher.reset(line); // 匹配字符串 if (matcher.find()) { // 如果有匹配的字符串，则输出 fal.add(SourceLib + "\\" +
     * line.substring(line.indexOf("<") + 1, line.lastIndexOf(">")).replace( '/', '\\')); line =
     * line.replace(line.substring(line .indexOf("<"), line.lastIndexOf("/") + 1), "\""); line = line.replace(">",
     * "\"");
     * 
     * } fw.write(line + "\r\n"); } fw.flush(); fw.close(); br.close(); // 关闭文件
     * 
     * } } LinkedList<String> folderListArr = new LinkedList<String>(); folderListArr.add(CurDir); while
     * (folderListArr.size() > 0) { File file = new File(folderListArr.poll()); File[] files = file.listFiles(); for
     * (int i = 0; i < files.length; i++) { if (files[i].isDirectory()) { folderListArr.add(files[i].getPath()); } else
     * { if (files[i].getName().substring( files[i].getName().lastIndexOf('.')) .equals(".hpp"))
     * all.add(files[i].getAbsoluteFile().toString() .replace(".hpp", ".cpp")); } } } int count = 1; while (count > 0) {
     * doSearch(SourceLib); all.clear(); while (fal2.size() > 0) { String file1 = fal2.poll(); // 第2个参数开始，均为文件名。 String
     * targetPath = enumDir + file1.substring(file1.lastIndexOf("\\") + 1); if (!new File(targetPath).exists()) {
     * BufferedReader br = null; String line; try { br = new BufferedReader(new FileReader(file1)); // 打开文件 } catch
     * (IOException e) { // 没有打开文件，则产生异常 System.err.println("Cannot read '" + file1 + "': " + e.getMessage()); continue;
     * } FileWriter fw; try { fw = new FileWriter(targetPath); while ((line = br.readLine()) != null) { // 读入一行，直到文件结束
     * matcher.reset(line); // 匹配字符串 if (matcher.find()) { // 如果有匹配的字符串，则输出 fal2.add(SourceLib + "\\" + line.substring(
     * line.indexOf('<') + 1, line.lastIndexOf('>')) .replace('/', '\\')); all.add(fal2.getLast().replace(".hpp",
     * ".cpp")); line = line.replace(line.substring(line .indexOf('<'), line .lastIndexOf('/') + 1), "\""); line =
     * line.replace('>', '\"'); } fw.write(line + "\r\n"); } fw.flush(); fw.close(); br.close(); // 关闭文件 } catch
     * (IOException e) { e.printStackTrace(); } } } count = all.size(); } } } }
     * 
     * public static void main(String[] args) { try { new InlineXercesc("xercesc"); // 将数据写入文件 try { FileWriter fw = new
     * FileWriter(CurDir + "\\DetailCpp.cmd"); fw.write("copy StdAfx.cpp+*.c+*.cpp " + CurDir +
     * "\\StdAfx.cpp && del *.c && del *.cpp"); fw.flush(); fw.close(); } catch (IOException e) { e.printStackTrace(); }
     * } catch (IOException e) { } } }
     * 
     * 80.提取包含头文件列表 import java.io.*; import java.util.regex.*; import java.util.*; public class InlineExt { private
     * String CurDir = System.getProperty("user.dir"); public InlineExt() { Pattern pattern =
     * Pattern.compile("include.*?\".*?.hpp\""); // 第一个参数为需要匹配的字符串 Matcher matcher = pattern.matcher(""); File delfile =
     * new File(CurDir); File[] files2 = delfile.listFiles(); for (int l = 0; l < files2.length; l++) { if
     * (files2[l].isDirectory()) { Set<String> ts = new LinkedHashSet<String>(); File file = new
     * File(files2[l].getPath(), "StdAfx.cpp"); BufferedReader br = null; FileWriter fw = null; String line; try { br =
     * new BufferedReader(new FileReader(file)); // 打开文件 while ((line = br.readLine()) != null) { matcher.reset(line);
     * // 匹配字符串 if (matcher.find()) { // 如果有匹配的字符串，则输出 ts.add(line.substring(line.indexOf('\"') + 1, line
     * .lastIndexOf('\"'))); } } Iterator<String> it = ts.iterator(); File file2 = new File(files2[l], "ReadMe.txt"); if
     * (file2.exists()) { fw = new FileWriter(file2); while (it.hasNext()) { fw.write("#include \"" + it.next() +
     * "\"\r\n"); } } } catch (IOException e) { // 没有打开文件，则产生异常 System.err.println("Cannot read '" + file + "': " +
     * e.getMessage()); continue; } finally { try { if (br != null) br.close(); if (fw != null) fw.close(); } catch
     * (IOException e) { e.printStackTrace(); } } } } } public static void main(String[] args) { new InlineExt(); } }
     * 
     * 81.GB2312文件转Unicode格式
     * 
     * 
     * 82.Java程序打包
     * 
     * import java.io.*; import java.util.*; private static String className; private static File myFilePath;
     * 
     * String path=%%1; ProcessBuilder pb = null; myFilePath = new File(path, "conf.txt"); LinkedList<String> folderList
     * = new LinkedList<String>(); folderList.add(path); while (folderList.size() > 0) { File file = new
     * File((String)folderList.poll()); File[] files = file.listFiles(); for (int i = 0; i < files.length; i++) { if
     * (files[i].isDirectory()) { folderList.add(files[i].getPath()); } else { if
     * (files[i].getName().substring(2).contains(".") && files[i].getName().substring(
     * files[i].getName().lastIndexOf('.')) .equals(".java")) {
     * 
     * try { className = files[i].getName().substring(0, files[i].getName().lastIndexOf('.')); if (!myFilePath.exists())
     * myFilePath.createNewFile(); FileWriter resultFile = new FileWriter(myFilePath); PrintWriter myFile = new
     * PrintWriter(resultFile); myFile.println("Main-Class:" + className); myFile.flush(); myFile.close();
     * resultFile.close(); pb = new ProcessBuilder("javac", files[i] .getAbsolutePath() + " && jar cmf " +
     * myFilePath.getAbsolutePath() + " " + className + ".jar " + className + ".class"); pb.start(); } catch
     * (IOException e) { e.printStackTrace(); } } } } } folderList = new LinkedList<String>(); folderList.add(path);
     * while (folderList.size() > 0) { File file = new File((String)folderList.poll()); File[] files = file.listFiles();
     * for (int i = 0; i < files.length; i++) { if (files[i].isDirectory()) { folderList.add(files[i].getPath()); } else
     * { if (files[i].getName().substring(2).contains(".") && files[i].getName().substring(
     * files[i].getName().lastIndexOf('.')) .equals(".class")) { files[i].delete(); } } } }
     * 
     * 83.UTF-8文件转Unicode格式
     *//**
     * utf-8 转换成 unicode
     * 
     * @author fanhui 2007-3-15
     * @param inStr
     * @return
     */
    /*
     * public static String utf8ToUnicode(String inStr) { char[] myBuffer = inStr.toCharArray();
     * 
     * StringBuffer sb = new StringBuffer(); for (int i = 0; i < inStr.length(); i++) { UnicodeBlock ub =
     * UnicodeBlock.of(myBuffer[i]); if(ub == UnicodeBlock.BASIC_LATIN){ //英文及数字等 sb.append(myBuffer[i]); }else if(ub ==
     * UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS){ //全角半角字符 int j = (int) myBuffer[i] - 65248; sb.append((char)j);
     * }else{ //汉字 short s = (short) myBuffer[i]; String hexS = Integer.toHexString(s); String unicode = "\\u"+hexS;
     * sb.append(unicode.toLowerCase()); } } return sb.toString(); }
     * 
     * 84.创建PDF文档
     * 
     * http://www.lowagie.com/iText/ http://jaist.dl.sourceforge.net/sourceforge/itext/itext-1.4.jar
     * http://itextdocs.lowagie.com/downloads/iTextAsian.jar http://itextdocs.lowagie.com/downloads/iTextAsianCmaps.jar
     * import java.io.*; import com.lowagie.text.*; import com.lowagie.text.pdf.PdfWriter;
     * 
     * Document document = new Document(); try { PdfWriter.getInstance(document, new FileOutputStream(%%1));
     * //"HelloWorld.pdf" // 添加PDF文档的一些信息 document.addTitle("Hello World example"); document.addAuthor("Bruno Lowagie");
     * document.addSubject("This example explains how to add metadata.");
     * document.addKeywords("iText, Hello World, step 3, metadata"); document.addCreator("My program using iText");
     * document.open(); // 插入一个段落 document.add(new Paragraph("Hello World!"));
     * 
     * } catch (DocumentException de) { System.err.println(de.getMessage()); } catch (IOException ioe) {
     * System.err.println(ioe.getMessage()); }
     * 
     * // 关闭打开的文档 document.close();
     * 
     * 三、中文问题：
     * 
     * 由于iText不支持东亚语言，我们下载了iTextAsian.jar 以后，就可以在PDF里面写中文：
     *//**
     * AsianTest.java
     */
    /*
     * import java.io.*; import com.lowagie.text.*; import com.lowagie.text.pdf.*; import java.awt.*;
     * 
     * public class AsianTest{
     * 
     * public static void main(String[] args) {
     * 
     * // 创建一个Document对象 Document document = new Document();
     * 
     * try {
     * 
     * // 生成名为 AsianTest.pdf 的文档 PdfWriter.getInstance(document, new FileOutputStream("AsianTest.pdf"));
     *//**
     * 新建一个字体,iText的方法 STSongStd-Light 是字体，在iTextAsian.jar 中以property为后缀 UniGB-UCS2-H 是编码，在iTextAsian.jar 中以cmap为后缀 H
     * 代表文字版式是 横版， 相应的 V 代表 竖版
     */
    /*
     * BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
     * 
     * Font fontChinese = new Font(bfChinese, 12, Font.NORMAL, Color.GREEN);
     * 
     * // 打开文档，将要写入内容 document.open();
     * 
     * // 插入一个段落 Paragraph par = new Paragraph("我们",fontChinese);
     * 
     * document.add(par);
     * 
     * } catch (DocumentException de) { System.err.println(de.getMessage()); } catch (IOException ioe) {
     * System.err.println(ioe.getMessage()); }
     * 
     * // 关闭打开的文档 document.close(); } }
     * 
     * 就可以显示中文了。
     * 
     * 
     * 四、其他问题：（应导入相应的包）
     * 
     * 1. 换页：
     * 
     * document.newPage();
     * 
     * 2. 表格：
     * 
     * // 设置 Table Table aTable = new Table(3); int width[] = {25,25,50}; aTable.setWidths(width); aTable.setWidth(80);
     * // 占页面宽度 80%
     * 
     * aTable.setDefaultHorizontalAlignment(Element.ALIGN_LEFT);
     * aTable.setDefaultVerticalAlignment(Element.ALIGN_MIDDLE); aTable.setAutoFillEmptyCells(true); //自动填满
     * aTable.setPadding(1); aTable.setSpacing(1); aTable.setDefaultCellBorder(0); aTable.setBorder(0);
     * 
     * Cell cell = new Cell(new Phrase("这是一个测试的 3*3 Table 数据", fontChinese ));
     * cell.setVerticalAlignment(Element.ALIGN_TOP); cell.setRowspan(3); aTable.addCell(cell);
     * 
     * aTable.addCell(new Cell("#1")); aTable.addCell(new Cell("#2")); aTable.addCell(new Cell("#3"));
     * 
     * aTable.addCell(new Cell("#4")); aTable.addCell(new Cell("#5")); aTable.addCell(new Cell("#6"));
     * 
     * document.add(aTable);
     * 
     * 3. 图片：
     * 
     * // 可以是绝对路径，也可以是URL Image img = Image.getInstance("logo.gif");
     * 
     * // Image image = Image.getInstance(new URL(http://xxx.com/logo.jpg));
     * 
     * img.setAbsolutePosition(0, 0);
     * 
     * document.add(img);
     * 
     * 五、参考文档：
     * 
     * iText http://www.lowagie.com/iText/
     * 
     * iText API: http://itext.sourceforge.net/docs/
     * 
     * http://www.sentom.net/list.asp?id=42
     * 
     * 85.创建Word文档
     * 
     * import java.awt.*; import java.io.*; import com.lowagie.text.*; import com.lowagie.text.pdf.*; import
     * com.lowagie.text.rtf.*;
     * 
     * public void createDocContext(String file) throws DocumentException, IOException { // 设置纸张大小 Document document =
     * new Document(PageSize.A4); // 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
     * RtfWriter2.getInstance(document, new FileOutputStream(file)); document.open(); // 设置中文字体 BaseFont bfChinese =
     * BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); // 标题字体风格 Font titleFont = new
     * Font(bfChinese, 12, Font.BOLD); // 正文字体风格 Font contextFont = new Font(bfChinese, 10, Font.NORMAL); Paragraph
     * title = new Paragraph("标题"); // 设置标题格式对齐方式 title.setAlignment(Element.ALIGN_CENTER); title.setFont(titleFont);
     * document.add(title);
     * 
     * String contextString = "iText是一个能够快速产生PDF文件的java类库。" + " \n"// 换行 + "iText的java类对于那些要产生包含文本，" +
     * "表格，图形的只读文档是很有用的。它的类库尤其与java Servlet有很好的给合。" + "使用iText与PDF能够使你正确的控制Servlet的输出。"; Paragraph context = new
     * Paragraph(contextString); // 正文格式左对齐 context.setAlignment(Element.ALIGN_LEFT); context.setFont(contextFont); //
     * 离上一段落（标题）空的行数 context.setSpacingBefore(5); // 设置第一行空的列数 context.setFirstLineIndent(20); document.add(context);
     * 
     * //利用类FontFactory结合Font和Color可以设置各种各样字体样式
     *//**
     * Font.UNDERLINE 下划线，Font.BOLD 粗体
     */
    /*
     * Paragraph underline = new Paragraph("下划线的实现", FontFactory.getFont( FontFactory.HELVETICA_BOLDOBLIQUE, 18,
     * Font.UNDERLINE, new Color(0, 0, 255))); document.add(underline);
     * 
     * // 设置 Table 表格 Table aTable = new Table(3); int width[] = {25,25,50}; aTable.setWidths(width);//设置每列所占比例
     * aTable.setWidth(90); // 占页面宽度 90%
     * 
     * aTable.setAlignment(Element.ALIGN_CENTER);//居中显示 aTable.setAlignment(Element.ALIGN_MIDDLE);//纵向居中显示
     * aTable.setAutoFillEmptyCells(true); //自动填满 aTable.setBorderWidth(1); //边框宽度 aTable.setBorderColor(new Color(0,
     * 125, 255)); //边框颜色 aTable.setPadding(2);//衬距，看效果就知道什么意思了 aTable.setSpacing(3);//即单元格之间的间距
     * aTable.setBorder(2);//边框
     * 
     * //设置表头
     *//**
     * cell.setHeader(true);是将该单元格作为表头信息显示； cell.setColspan(3);指定了该单元格占3列； 为表格添加表头信息时，要注意的是一旦表头信息添加完了之后， 必须调用
     * endHeaders()方法，否则当表格跨页后，表头信息不会再显示
     */
    /*
     * Cell haderCell = new Cell("表格表头"); haderCell.setHeader(true); haderCell.setColspan(3); aTable.addCell(haderCell);
     * aTable.endHeaders();
     * 
     * Font fontChinese = new Font(bfChinese, 12, Font.NORMAL, Color.GREEN); Cell cell = new Cell(new
     * Phrase("这是一个测试的 3*3 Table 数据", fontChinese )); cell.setVerticalAlignment(Element.ALIGN_TOP);
     * cell.setBorderColor(new Color(255, 0, 0)); cell.setRowspan(2); aTable.addCell(cell);
     * 
     * aTable.addCell(new Cell("#1")); aTable.addCell(new Cell("#2")); aTable.addCell(new Cell("#3"));
     * aTable.addCell(new Cell("#4")); Cell cell3 = new Cell(new Phrase("一行三列数据", fontChinese )); cell3.setColspan(3);
     * cell3.setVerticalAlignment(Element.ALIGN_CENTER); aTable.addCell(cell3);
     * 
     * document.add(aTable); document.add(new Paragraph("\n")); //添加图片 Image img=Image.getInstance("d:\\img01800.jpg");
     * img.setAbsolutePosition(0, 0); img.setAlignment(Image.RIGHT);//设置图片显示位置 img.scaleAbsolute(12,35);//直接设定显示尺寸
     * img.scalePercent(50);//表示显示的大小为原尺寸的50% img.scalePercent(25, 12);//图像高宽的显示比例 img.setRotation(30);//图像旋转一定角度
     * document.add(img);
     * 
     * document.close(); }
     *//**
     * @param args
     */
    /*
     * public static void main(String[] args) { CreateWordDemo word = new CreateWordDemo(); String file =
     * "c:/demo1.doc"; try { word.createDocContext(file); } catch (DocumentException e) { e.printStackTrace(); } catch
     * (IOException e) { e.printStackTrace(); } }
     * 
     * 内部线程类 class Son extends Thread { private ICallBack event; public Son(ICallBack callback) { event=callback; }
     * public void run() { try { java.text.SimpleDateFormat fmt=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     * while(true) { Thread.currentThread().sleep(3000); event.output(fmt.format(new java.util.Date()));
     * Thread.currentThread().sleep(3000); } } catch (Exception e) { } } }
     * 
     * 回调接口 interface ICallBack { public void output(); }
     * 
     * 86.快速高效的文件加密
     * 
     * import java.util.*; import java.io.*; import javax.swing.*;
     * 
     * private static final String CharSet = "0123456789ABCDEF"; private static final int a[] = { 2, 2, 2, 2, 2, 2, 2,
     * 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }; private static final int b[] = { 3, 3,
     * 3, 5, 5, 3, 3, 3, 5, 3, 5, 3, 7, 3, 11, 7, 11, 3, 5, 3, 3, 3, 7, 5, 5, 3, 7, 3, 11, 13, 3 }; private static final
     * int c[] = { 3, 5, 7, 5, 7, 11, 13, 19, 17, 29, 19, 31, 17, 41, 11, 19, 13, 47, 29, 53, 59, 67, 29, 41, 43, 71,
     * 31, 73, 23, 23, 101 }; private static final int d[] = { 5, 7, 11, 13, 17, 17, 19, 29, 43, 43, 47, 47, 59, 61, 61,
     * 67, 71, 71, 73, 79, 89, 101, 101, 103, 107, 107, 109, 109, 127, 149, 151 }; private static int ka, kb, kc, kd;
     * 
     * private static void init() { Date t1 = new Date(); Date t2 = new Date(79, 8, 23, 8, 30, 0); // "9-23-1979 8:30"
     * int GetDays = 0; int result = 0; Calendar start = new GregorianCalendar(); Calendar end = new
     * GregorianCalendar(); start.setTime(t2); end.setTime(t1); Calendar startCalendar = start; int startYear =
     * start.get(Calendar.YEAR); int startMonth = start.get(Calendar.MONTH); int startDayOfM =
     * start.get(Calendar.DAY_OF_MONTH); int startDayOfY = start.get(Calendar.DAY_OF_YEAR);
     * 
     * Calendar endCalendar = end; int endYear = end.get(Calendar.YEAR); int endMonth = end.get(Calendar.MONTH); int
     * endDayOfM = end.get(Calendar.DAY_OF_MONTH); int endDayOfY = end.get(Calendar.DAY_OF_YEAR); int startLastYear = 0,
     * startLastDayOfY = 0; if (endYear == startYear) { startLastYear = endDayOfY < startDayOfY ? startYear : endYear;
     * startLastDayOfY = endDayOfY < startDayOfY ? startDayOfY : endDayOfY; } else if (endYear < startYear) {
     * startLastYear = startYear; startLastDayOfY = startDayOfY; } else { startLastYear = endYear; startLastDayOfY =
     * endDayOfY; }
     * 
     * if ((endYear == startYear && endDayOfY == startDayOfY) || (startLastYear == startYear && startLastDayOfY ==
     * startDayOfY)) { GetDays = result; } else if (startYear == endYear) { GetDays = endDayOfY - startDayOfY; } else {
     * Calendar tmp = Calendar.getInstance(); result = startCalendar.getActualMaximum(Calendar.DAY_OF_YEAR) -
     * startDayOfY; for (int i = startYear + 1; i < endYear; i++) { tmp.set(i, tmp.get(Calendar.MONTH), tmp
     * .get(Calendar.DAY_OF_MONTH)); result += tmp.getActualMaximum(Calendar.DAY_OF_YEAR); } result +=
     * end.get(Calendar.DAY_OF_YEAR); GetDays = result; } Random rand = new Random(GetDays * 8 - 55); int r =
     * rand.nextInt(GetDaysInMoths(t2.getMonth() + 1)); r=0; ka = a[r]; kb = b[r]; kc = c[r]; kd = d[r]; }
     * 
     * private static int GetDaysInMoths(int nMoths) { switch (nMoths) { case 2: { int nYear = new Date().getYear() +
     * 1900; if ((nYear % 4 == 0) && (nYear % 400) != 0) { return 29; } else { return 28; } } case 1: case 3: case 5:
     * case 7: case 8: case 10: case 12: return 31; case 4: case 6: case 9: case 11: return 30; default: return -1; } }
     * 
     * private static int niyuan(int m, int n) { int a, b, c, d, t, yu = 0, shang, mod; a = m; b = n; mod = a; c = 0; d
     * = 1; while (b < 0) b += a; if (a % b == 0 || b % 2 == 0) return 0; while (b != 1) { t = a % b; shang = a / b; a =
     * b; b = t; yu = c - shang * d; c = d; d = yu; } if (yu < 0) yu += mod; return yu; } JFileChooser chooser = new
     * JFileChooser(); chooser.setCurrentDirectory(new File("E:")); chooser .addChoosableFileFilter(new
     * javax.swing.filechooser.FileFilter() { public boolean accept(File f) { return
     * f.getName().toLowerCase().endsWith(".zip") || f.isDirectory(); }
     * 
     * public String getDescription() { return "Compress Files(*.zip)"; } }); chooser .addChoosableFileFilter(new
     * javax.swing.filechooser.FileFilter() { public boolean accept(File f) { return
     * f.getName().toLowerCase().endsWith(".txt") || f.isDirectory(); }
     * 
     * public String getDescription() { return "Text Files(*.txt)"; } }); chooser .addChoosableFileFilter(new
     * javax.swing.filechooser.FileFilter() { public boolean accept(File f) { return
     * f.getName().toLowerCase().endsWith(".exe") || f.isDirectory(); }
     * 
     * public String getDescription() { return "Executeable Files(*.exe)"; } }); if (chooser.showOpenDialog(null) ==
     * JFileChooser.APPROVE_OPTION) { String name = chooser.getSelectedFile().getPath(); JFileChooser chooser2 = new
     * JFileChooser(); chooser2.setCurrentDirectory(new File("E:")); if
     * (name.substring(name.lastIndexOf('.')).equals(".txt")) { char[] sRead = new char[10240]; char[] hexstr = new
     * char[10240]; char[] pbuf = new char[20480]; char[] rRead = new char[20480]; char[] out2 = new char[10240];
     * chooser2 .addChoosableFileFilter(new javax.swing.filechooser.FileFilter() { public boolean accept(File f) {
     * return f.getName().toLowerCase().endsWith( ".zip") || f.isDirectory(); }
     * 
     * public String getDescription() { return "Compress Files(*.zip)"; } }); chooser2 .addChoosableFileFilter(new
     * javax.swing.filechooser.FileFilter() { public boolean accept(File f) { return f.getName().toLowerCase().endsWith(
     * ".exe") || f.isDirectory(); }
     * 
     * public String getDescription() { return "Executeable Files(*.exe)"; } }); if (chooser2.showOpenDialog(null) ==
     * JFileChooser.APPROVE_OPTION) { init(); FileOutputStream fw = null; try { FileInputStream fis = new
     * FileInputStream(chooser .getSelectedFile()); fw = new FileOutputStream(chooser2.getSelectedFile()); byte[] buffer
     * = new byte[20480]; int js = 0, tmp; int aany, ddny; int r00 = ka * kc * kd; int r01 = -ka * kb * kc; int r10 =
     * -kb * kc * kc; int r11 = ka * kb * kc; int x00 = ka * ka * kc * kd - ka * kb * kc * kc; int x11 = ka * kb * kc *
     * kd - kb * kb * kc * kc; while (x00 % 2 == 0) { x00 /= 2; r00 /= 2; r01 /= 2; } while (x11 % 2 == 0) { x11 /= 2;
     * r10 /= 2; r11 /= 2; } aany = x00; ddny = x11; if (niyuan(1024, aany) != 0 && niyuan(1024, ddny) != 0) { int kn00
     * = r00 * niyuan(1024, x00); int kn01 = r01 * niyuan(1024, x00); int kn10 = r10 * niyuan(1024, x11); int kn11 = r11
     * * niyuan(1024, x11); ka = kn00; kb = kn01; kc = kn10; kd = kn11; } else { JOptionPane.showMessageDialog(null,
     * "无逆矩阵！"); System.exit(0); } while (ka < 0) ka += 1024; while (kb < 0) kb += 1024; while (kc < 0) kc += 1024;
     * while (kd < 0) kd += 1024; ka %= 1024; kb %= 1024; kc %= 1024; kd %= 1024; try { int byteread; while ((byteread =
     * fis.read(buffer)) != -1) { int nLen = byteread / 2; byte[] sming = new byte[nLen]; String chs = new
     * String(buffer, "US-ASCII"); for (int i = 0; i < nLen; i++) { byte bTmp; if (byteread < 2) bTmp = -1; bTmp =
     * (byte) (CharSet.indexOf(chs .substring(i * 2, i * 2 + 1)) * 16 + CharSet .indexOf(chs.substring(i * 2 + 1, i * 2
     * + 2))); sming[i] = bTmp; } if (nLen % 2 != 0) js = 1; for (int i = 0; i < nLen - 1; i += 2) { char c1 = (char)
     * sming[i]; char c2 = (char) sming[i + 1]; tmp = ka * c1 + kc * c2; while (tmp < 0) tmp += 1024; char s1 = (char)
     * (tmp % 1024); fw.write(s1); tmp = kb * c1 + kd * c2; while (tmp < 0) tmp += 1024; char s2 = (char) (tmp % 1024);
     * fw.write(s2); } if (js == 1) { char c3 = (char) ((sming[nLen - 1] - 4) % 1024); fw.write(c3); } } fw.flush(); }
     * catch (IOException e) { e.printStackTrace(); } finally { try { fis.close(); fw.close(); } catch (IOException e) {
     * e.printStackTrace(); } } } catch (FileNotFoundException e1) { e1.printStackTrace(); }
     * if(!chooser2.getFileFilter().accept(chooser2.getSelectedFile())){
     * if(chooser2.getFileFilter().getDescription().equals("Compress Files(*.zip)"))
     * chooser2.getSelectedFile().renameTo(new File(chooser2.getSelectedFile().getAbsolutePath()+".zip")); else
     * if(chooser2.getFileFilter().getDescription().equals("Executeable Files(*.exe)"))
     * chooser2.getSelectedFile().renameTo(new File(chooser2.getSelectedFile().getAbsolutePath()+".exe")); }
     * 
     * } } else { chooser2 .setFileFilter(new javax.swing.filechooser.FileFilter() { public boolean accept(File f) {
     * return f.getName().toLowerCase().endsWith( ".txt") || f.isDirectory(); }
     * 
     * public String getDescription() { return "Text Files"; } }); if (chooser2.showOpenDialog(null) ==
     * JFileChooser.APPROVE_OPTION) {
     * 
     * if (chooser2.getSelectedFile() != null) { init(); File oldfile = chooser.getSelectedFile(); FileInputStream
     * inStream = null; FileWriter fw = null; try { if (oldfile.exists()) { inStream = new FileInputStream(oldfile); fw
     * = new FileWriter(chooser2.getSelectedFile()); byte[] sRead = new byte[10240]; int byteread; while ((byteread =
     * inStream.read(sRead)) != -1) { StringBuilder smi = new StringBuilder( byteread * 2); int js = 0; if (byteread % 2
     * != 0) js = 1; for (int i = 0; i < byteread - 1; i += 2) { char c1 = (char) sRead[i]; char c2 = (char) sRead[i +
     * 1]; int tmp = ka * c1 + kc * c2; while (tmp < 0) tmp += 1024; byte s1 = (byte) (tmp % 1024); int js1 = (int) s1
     * >> 4 & 0xf; smi.append(CharSet.substring(js1, js1 + 1)); int ks1 = s1 & 0xf; smi.append(CharSet.substring(ks1,
     * ks1 + 1)); tmp = kb * c1 + kd * c2; while (tmp < 0) tmp += 1024; byte s2 = (byte) (tmp % 1024); int js2 = (int)
     * s2 >> 4 & 0xf; smi.append(CharSet.substring(js2, js2 + 1)); int ks2 = s2 & 0xf; smi.append(CharSet.substring(ks2,
     * ks2 + 1)); } if (js == 1) { byte s3 = (byte) ((sRead[byteread - 1] - 4) % 1024); int js3 = (int) s3 >> 4 & 0xf;
     * smi.append(CharSet.substring(js3, js3 + 1)); int ks3 = (int) s3 & 0xf; smi.append(CharSet.substring(ks3, ks3 +
     * 1)); } fw.write(smi.toString()); } fw.flush(); } } catch (IOException e) { e.printStackTrace(); } finally { try {
     * fw.close(); inStream.close(); } catch (IOException e) { e.printStackTrace(); } }
     * if(!chooser2.getFileFilter().accept(chooser2.getSelectedFile())) chooser2.getSelectedFile().renameTo(new
     * File(chooser2.getSelectedFile().getAbsolutePath()+".txt")); } } } }
     * 
     * 87.菜单勾选/取消开机自启动程序
     * 
     * 88.菜单勾选/取消自动登录系统
     * 
     * 89.模拟键盘输入字符串
     * 
     * import java.awt.*; import java.awt.event.*; throws Exception{
     * 
     * static Robot robot; static{ try { robot = new Robot(); } catch (AWTException e) {} }
     * 
     * static void sendKey(String ks){ KeyStore k = KeyStore.findKeyStore(ks); if(k!=null){ if(k.upCase) upCase(k.v);
     * else sendKey(k.v); } else{ for(int i=0; i<ks.length(); i++){ char c = ks.charAt(i); if(c>='0'&&c<='9'){
     * sendKey(c); } else if(c>='a'&&c<='z'){ sendKey(c-32); } else if(c>='A'&&c<='Z'){ upCase(c); } } } } private
     * static void upCase(int kc){ robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(kc); robot.keyRelease(kc);
     * robot.keyRelease(KeyEvent.VK_SHIFT); } private static void sendKey(int kc){ robot.keyPress(kc);
     * robot.keyRelease(kc); } static class KeyStore{ //special keys final static KeyStore[] sp = { new
     * KeyStore("{Tab}",KeyEvent.VK_TAB),//tab new KeyStore("{Enter}",KeyEvent.VK_ENTER),//enter new
     * KeyStore("{PUp}",KeyEvent.VK_PAGE_UP),//page up new KeyStore("{<}",KeyEvent.VK_LESS),//< new
     * KeyStore("{Up}",KeyEvent.VK_UP),//up key new KeyStore("{At}",KeyEvent.VK_AT,true),//@ new
     * KeyStore("{Dollar}",KeyEvent.VK_DOLLAR,true),//$ };
     * 
     * String k; int v; boolean upCase; KeyStore(String k,int v){ this(k,v,false); }
     * 
     * KeyStore(String s,int i,boolean up){ k=s; v=i; upCase=up; } static KeyStore findKeyStore(String k){ for(int i=0;
     * i<sp.length; i++){ if(sp[i].k.equals(k)) return sp[i]; } return null; } } Thread.sleep(1000);
     * sendKey("{Tab}");//tab sendKey("{<}");//< sendKey("abcd123AHahahAA");//abcd123AHahahAA sendKey("{At}");//@
     * sendKey("{Dollar}");//$ sendKey("{Up}");//up arrow
     * 
     * 90.提取PDF文件中的文本 //http://incubator.apache.org/pdfbox/
     * 
     * import java.io.*; import org.pdfbox.pdfparser.*; import org.pdfbox.pdmodel.*; import org.pdfbox.util.*;
     * 
     * public class SimplePDFReader {
     *//**
     * simply reader all the text from a pdf file. You have to deal with the format of the output text by yourself.
     * 2008-2-25
     * 
     * @param pdfFilePath
     *            file path
     * @return all text in the pdf file
     */
    /*
     * public static String getTextFromPDF(String pdfFilePath) { String result = null; FileInputStream is = null;
     * PDDocument document = null; try { is = new FileInputStream(pdfFilePath); PDFParser parser = new PDFParser(is);
     * parser.parse(); document = parser.getPDDocument(); PDFTextStripper stripper = new PDFTextStripper(); result =
     * stripper.getText(document); } catch (FileNotFoundException e) { // TODO Auto-generated catch block
     * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } finally
     * { if (is != null) { try { is.close(); } catch (IOException e) { // TODO Auto-generated catch block
     * e.printStackTrace(); } } if (document != null) { try { document.close(); } catch (IOException e) { // TODO
     * Auto-generated catch block e.printStackTrace(); } } } return result; } }
     * 得到PDF的文本内容之后，自己根据文件的格式，取得想要的文本（这里我找的就是文章的标题，在文本中恰巧都是文件的第一行的内容），然后通过java的File相关api，对文件进行更名操作。 import java.io.File;
     * import java.io.FilenameFilter;
     * 
     * public class PaperNameMender { public static void changePaperName(String filePath) { //使用SimplePDFReader得到pdf文本
     * String ts = SimplePDFReader.getTextFromPDF(filePath); //取得一行内容 String result = ts.substring(0, ts.indexOf('\n'));
     * //得到源文件名中的最后一个逗点.的位置 int index = filePath.indexOf('.'); int nextIndex = filePath.indexOf('.', index + 1);
     * while(nextIndex != -1) { index = nextIndex; nextIndex = filePath.indexOf('.', index + 1); } //合成新文件名 String
     * newFilename = filePath.substring(0, index) + " " + result.trim() + ".pdf"; File originalFile = new
     * File(filePath); //修改文件名 originalFile.renameTo(new File(newFilename)); } }
     * 
     * 
     * 91.操作内存映射文件
     * 
     * import java.io.*; import java.nio.*; import java.nio.channels.*;
     * 
     * private static int length = 0x8FFFFFF; // 128 Mb MappedByteBuffer out = new RandomAccessFile("test.dat",
     * "rw").getChannel() .map(FileChannel.MapMode.READ_WRITE, 0, length); for(int i = 0; i < length; i++)
     * out.put((byte)'x'); for(int i = length/2; i < length/2 + 6; i++) //(char)out.get(i);
     * 
     * 92.重定向windows控制台程序的输出信息 92.1 取得Runtime.getRuntime().exec("cmd /c dir")的输入输出 //import java.io.*; try { String
     * command = "cmd /c dir"; Process proc = Runtime.getRuntime().exec(command); InputStreamReader ir = new
     * InputStreamReader(proc.getInputStream()); LineNumberReader lnr = new LineNumberReader(ir); String line; while(
     * (line = lnr.readLine()) != null) { //line } } catch (IOException e) { e.printStackTrace(); }
     * 
     * 92.2 利用ProcessBuilder来创建Process对象，执行外部可执行程序 // //Eg1: // String address = null; // // String os =
     * System.getProperty("os.name"); // System.out.println(os); // // if (os != null) { // if
     * (os.startsWith("Windows")) { // try { // ProcessBuilder pb = new ProcessBuilder("ipconfig", "/all"); // Process p
     * = pb.start(); // // BufferedReader br = new BufferedReader( // new InputStreamReader(p.getInputStream())); // //
     * String line; // while ((line = br.readLine()) != null) { // if (line.indexOf("Physical Address") != -1) { // int
     * index = line.indexOf(":"); // address = line.substring(index + 1); // break; // } // } // br.close(); // address
     * = address.trim(); // } catch (IOException e) { // // TODO Auto-generated catch block // e.printStackTrace(); // }
     * // } else if (os.startsWith("Linux")) { // try { // ProcessBuilder pb = new ProcessBuilder( // // "ifconfig",
     * "/all"); // // Process p = pb.start(); // BufferedReader br = new BufferedReader( // new
     * InputStreamReader(p.getInputStream())); // String line; // while ((line = br.readLine()) != null) { // int index
     * = line.indexOf("硬件地址"); // if (index != -1) { // address = line.substring(index + 4); // break; // } // } //
     * br.close(); // address = address.trim(); // } catch (IOException e) { // e.printStackTrace(); // } // } // }
     * 
     * // //Eg2: // try { // Process proc; // proc = Runtime.getRuntime().exec("cmd.exe"); // BufferedReader read = new
     * BufferedReader(new InputStreamReader(proc // .getInputStream())); // new Thread(new Echo(read)).start(); // //
     * PrintWriter out = new PrintWriter(new OutputStreamWriter(proc // .getOutputStream())); // BufferedReader in = new
     * BufferedReader(new InputStreamReader( // System.in)); // String instr = in.readLine(); // while
     * (!"exit".equals(instr)) { // instr = in.readLine(); // out.println(instr); // out.flush(); // } // //
     * in.readLine(); // read.close(); // out.close(); // } catch (IOException e) { // // TODO Auto-generated catch
     * block // e.printStackTrace(); // }
     * 
     * } }
     * 
     * class Echo implements Runnable { private BufferedReader read;
     * 
     * public Echo(BufferedReader read) { read = read; }
     * 
     * public void run() { try { String line = read.readLine(); while (line != null) { //line line = read.readLine(); }
     * } catch (IOException ex) { ex.printStackTrace(); } } }
     * 
     * 93.序列化 //import java.io.*; class tree implements Serializable{ public tree left; public tree right; public int
     * id; public int level;
     * 
     * private static int count = 0 ;
     * 
     * public tree( int depth) { id = count ++ ; level = depth; if (depth > 0 ) { left = new tree(depth - 1 ); right =
     * new tree(depth - 1 ); } }
     * 
     * public void print( int levels) { for ( int i = 0 ; i < level; i ++ ) System.out.print( " " ); System.out.println(
     * " node " + id);
     * 
     * if (level <= levels && left != null ) left.print(levels);
     * 
     * if (level <= levels && right != null ) right.print(levels); } } try { 创建一个文件写入序列化树。 FileOutputStream ostream =
     * new FileOutputStream(%%1); 创建输出流 ObjectOutputStream p = new ObjectOutputStream(ostream);
     * 
     * 创建一个二层的树。 tree base = new tree( 2 );
     * 
     * p.writeObject(base); // 将树写入流中。 p.writeObject( " LiLy is 惠止南国 " ); p.flush(); ostream.close(); // 关闭文件。 } catch
     * (Exception ex) { ex.printStackTrace(); } }
     * 
     * 94.反序列化 //import java.io.*; class tree implements Serializable{ public tree left; public tree right; public int
     * id; public int level;
     * 
     * private static int count = 0 ;
     * 
     * public tree( int depth) { id = count ++ ; level = depth; if (depth > 0 ) { left = new tree(depth - 1 ); right =
     * new tree(depth - 1 ); } }
     * 
     * public void print( int levels) { for ( int i = 0 ; i < level; i ++ ) System.out.print( " " ); System.out.println(
     * " node " + id);
     * 
     * if (level <= levels && left != null ) left.print(levels);
     * 
     * if (level <= levels && right != null ) right.print(levels); } } try { FileInputStream istream = new
     * FileInputStream(%%1); ObjectInputStream q = new ObjectInputStream(istream);
     * 
     * 读取树对象，以及所有子树 tree new_tree = (tree)q.readObject();
     * 
     * new_tree.print( 2 ); // 打印出树形结构的最上面 ２级 String name = (String)q.readObject(); System.out.println( " \n " + name);
     * } catch (Exception ex) { ex.printStackTrace(); } }
     * 
     * 95.报表相关 //http://www.jfree.org/jfreechart/
     * 
     * import java.io.*; import java.awt.*; import org.jfree.chart.*; import org.jfree.chart.title.TextTitle; import
     * org.jfree.data.general.*;
     * 
     * String title = "梦泽科技员工学历情况统计"; DefaultPieDataset piedata = new DefaultPieDataset(); piedata.setValue("大专", 8.1);
     * piedata.setValue("大学", 27.6); piedata.setValue("硕士", 53.2); piedata.setValue("博士及以上", 19.2);
     * piedata.setValue("大专以下", 1.9); JFreeChart chart = ChartFactory.createPieChart(title, piedata, true, true, true);
     * chart.setTitle(new TextTitle(title, new Font("宋体", Font.BOLD, 25))); chart.addSubtitle(new
     * TextTitle("最后更新日期：2005年5月19日", new Font("楷书", Font.ITALIC, 18))); chart.setBackgroundPaint(Color.white); try {
     * ChartUtilities.saveChartAsJPEG(new File("PieChart.jpg"), chart, 360, 300); } catch (IOException exz) {
     * System.err.print("....Cant′t Create image File"); }
     * 
     * 96.全屏幕截取
     * 
     * import java.awt.*; import java.awt.image.*; import java.io.*; import javax.imageio.*;
     * 
     * try{ Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); BufferedImage screenshot = (new Robot())
     * .createScreenCapture(new Rectangle(0, 0, (int) d.getWidth(), (int) d.getHeight())); // 根据文件前缀变量和文件格式变量，自动生成文件名
     * String name = %%1 + "." + %%2; //"png" File f = new File(name); ImageIO.write(screenshot, %%2, f); } catch
     * (Exception ex) { ex.printStackTrace(); }
     * 
     * 97.区域截屏
     * 
     * import java.awt.*; import java.awt.image.*; import java.io.*; import java.util.*; import javax.imageio.*;
     * 
     * interface ImageType { public final static String JPG = "JPG"; public final static String PNG = "PNG"; public
     * final static String GIF = "GIF"; } public class ScreenDumpHelper {
     *//** ScreenDumpHelper 静态对象 */
    /*
     * private static ScreenDumpHelper defaultScreenDumpHelper; public static ScreenDumpHelper
     * getDefaultScreenDumpHelper() { if (defaultScreenDumpHelper == null) return new ScreenDumpHelper(); return
     * defaultScreenDumpHelper; } public ScreenDumpHelper() { Dimension dime =
     * Toolkit.getDefaultToolkit().getScreenSize(); setScreenArea(new Rectangle(dime)); } private Rectangle screenArea;
     * 
     * public Rectangle getScreenArea() { return screenArea; }
     * 
     * public void setScreenArea(Rectangle screenArea) { screenArea = screenArea; }
     * 
     * public void setScreenArea(int x, int y, int width, int height) { screenArea = new Rectangle(x, y, width, height);
     * } private BufferedImage getBufferedImage() throws AWTException { BufferedImage imgBuf = null; ; imgBuf = (new
     * Robot()).createScreenCapture(getScreenArea()); return imgBuf; }
     *//**
     * 将 图像数据写到 输出流中去,方便再处理
     *
     * @param fileFormat
     * @param output
     * @return
     */
    /*
     * public boolean saveToOutputStream(String fileFormat, OutputStream output) { try {
     * ImageIO.write(getBufferedImage(), fileFormat, output); } catch (AWTException e) { return false; //
     * e.printStackTrace(); } catch (IOException e) { return false; // e.printStackTrace(); } return true; }
     *//**
     * 根据文件格式 返回随机文件名称
     *
     * @param fileFormat
     * @return
     */
    /*
     * public String getRandomFileName(String fileFormat) { return "screenDump_" + (new Date()).getTime() + "." +
     * fileFormat; }
     *//**
     * 抓取 指定区域的截图 到指定格式的文件中 -- 这个函数是核心,所有的都是围绕它来展开的 * 图片的编码并不是以后缀名来判断: 比如s.jpg 如果其采用png编码,那么这个图片就是png格式的
     *
     * @param fileName
     * @param fileFormat
     * @return boolean
     */
    /*
     * public boolean saveToFile(String fileName, String fileFormat) { if (fileName == null) fileName =
     * getRandomFileName(fileFormat); try { FileOutputStream fos = new FileOutputStream(fileName);
     * saveToOutputStream(fileFormat, fos); } catch (FileNotFoundException e) { System.err.println("非常规文件或不能创建抑或覆盖此文件: "
     * + fileName); } return true; }
     *//**
     * 抓取 指定 Rectangle 区域的截图 到指定格式的文件中
     *
     * @param fileName
     * @param fileFormat
     * @param screenArea
     * @return
     */
    /*
     * public boolean saveToFile(String fileName, String fileFormat, Rectangle screenArea) { setScreenArea(screenArea);
     * return saveToFile(fileName, fileFormat); }
     *//**
     * 抓取 指定区域的截图 到指定格式的文件中
     *
     * @param fileName
     * @param fileFormat
     * @param x
     * @param y
     * @param width
     * @param height
     */
    /*
     * public boolean saveToFile(String fileName, String fileFormat, int x, int y, int width, int height) {
     * setScreenArea(x, y, width, height); return saveToFile(fileName, fileFormat); }
     *//**
     * 将截图使用 JPG 编码
     *
     * @param fileName
     */
    /*
     * public void saveToJPG(String fileName) { saveToFile(fileName, ImageType.JPG); }
     * 
     * public void saveToJPG(String fileName, Rectangle screenArea) { saveToFile(fileName, ImageType.JPG, screenArea); }
     * 
     * public void saveToJPG(String fileName, int x, int y, int width, int height) { saveToFile(fileName, ImageType.JPG,
     * x, y, width, height); }
     *//**
     * 将截图使用 PNG 编码
     *
     * @param fileName
     */
    /*
     * public void saveToPNG(String fileName) { saveToFile(fileName, ImageType.PNG); }
     * 
     * public void saveToPNG(String fileName, Rectangle screenArea) { saveToFile(fileName, ImageType.PNG, screenArea); }
     * 
     * public void saveToPNG(String fileName, int x, int y, int width, int height) { saveToFile(fileName, ImageType.PNG,
     * x, y, width, height); }
     * 
     * public void saveToGIF(String fileName) { throw new UnsupportedOperationException("不支持保存到GIF文件"); //
     * saveToFile(fileName, ImageType.GIF); }
     *//**
     * @param args
     */
    /*
     * public static void main(String[] args) { for (int i = 0; i < 5; i++)
     * ScreenDumpHelper.getDefaultScreenDumpHelper().saveToJPG(null, i * 150, i * 150, 400, 300); } }
     * 
     * 98.计算文件MD5值
     * 
     * import java.io.*; import java.math.*; import java.security.*; import java.util.*;
     * 
     * File file=new File(%%1); if (!file.isFile()){ return null; } MessageDigest digest = null; FileInputStream
     * in=null; byte buffer[] = new byte[1024]; int len; try { digest = MessageDigest.getInstance("MD5"); in = new
     * FileInputStream(file); while ((len = in.read(buffer, 0, 1024)) != -1) { digest.update(buffer, 0, len); }
     * in.close(); } catch (Exception e) { e.printStackTrace(); return null; } BigInteger bigInt = new BigInteger(1,
     * digest.digest()); return bigInt.toString(16); }
     * 
     * 99.计算获取文件夹中文件的MD5值
     * 
     * import java.io.*; import java.math.*; import java.security.*; import java.util.*;
     * 
     * public static String getFileMD5(File file) { if (!file.isFile()){ return null; } MessageDigest digest = null;
     * FileInputStream in=null; byte buffer[] = new byte[1024]; int len; try { digest =
     * MessageDigest.getInstance("MD5"); in = new FileInputStream(file); while ((len = in.read(buffer, 0, 1024)) != -1)
     * { digest.update(buffer, 0, len); } in.close(); } catch (Exception e) { e.printStackTrace(); return null; }
     * BigInteger bigInt = new BigInteger(1, digest.digest()); return bigInt.toString(16); }
     *//**
     * 获取文件夹中文件的MD5值
     * 
     * @param file
     * @param listChild
     *            ;true递归子目录中的文件
     * @return
     */
    /*
     * public static Map<String, String> getDirMD5(File file,boolean listChild) { if(!file.isDirectory()){ return null;
     * } //<filepath,md5> Map<String, String> map=new HashMap<String, String>(); String md5; File
     * files[]=file.listFiles(); for(int i=0;i<files.length;i++){ File f=files[i]; if(f.isDirectory()&&listChild){
     * map.putAll(getDirMD5(f, listChild)); } else { md5=getFileMD5(f); if(md5!=null){ map.put(f.getPath(), md5); } } }
     * return map; } getDirMD5(%%1,%%2);
     * 
     * 100.复制一个目录下所有文件到一个文件夹中
     * 
     * import java.io.*; import java.util.*;
     * 
     * LinkedList<String> folderList = new LinkedList<String>(); folderList.add(%%1); LinkedList<String> folderList2 =
     * new LinkedList<String>(); folderList2.add(%%2+ %%1.substring(%%1.lastIndexOf("\\"))); while (folderList.size() >
     * 0) { File folders = new File(folderList.peek()); String[] file = folders.list(); File temp = null; try { for (int
     * i = 0; i < file.length; i++) { if (folderList.peek().endsWith(File.separator)) { temp = new
     * File(folderList.peek() + File.separator + file[i]); } else { temp = new File(folderList.peek() + File.separator +
     * file[i]); } if (temp.isFile()) { FileInputStream input = new FileInputStream(temp); FileOutputStream output = new
     * FileOutputStream( new File(%%2,temp.getName())); byte[] b = new byte[10240]; int len; while ((len =
     * input.read(b)) != -1) { output.write(b, 0, len); } output.flush(); output.close(); input.close(); } if
     * (temp.isDirectory()) {// 如果是子文件夹 for (File f : temp.listFiles()) { if (f.isDirectory()) {
     * folderList.add(f.getPath()); folderList2.add(folderList2.peek() + File.separator + f.getName()); } } } } } catch
     * (IOException e) { System.err.println("复制整个文件夹内容操作出错"); } folderList.removeFirst(); folderList2.removeFirst(); }
     * 
     * 101.移动一个目录下所有文件到一个文件夹中
     * 
     * import java.io.*; import java.util.*;
     * 
     * LinkedList<String> folderList = new LinkedList<String>(); folderList.add(%%1); LinkedList<String> folderList2 =
     * new LinkedList<String>(); folderList2.add(%%2 + %%1.substring(%%1.lastIndexOf("\\"))); while (folderList.size() >
     * 0) { File folders = new File(folderList.peek()); String[] file = folders.list(); File temp = null; try { for (int
     * i = 0; i < file.length; i++) { if (folderList.peek().endsWith(File.separator)) { temp = new
     * File(folderList.peek() + File.separator + file[i]); } else { temp = new File(folderList.peek() + File.separator +
     * file[i]); } if (temp.isFile()) { FileInputStream input = new FileInputStream(temp); FileOutputStream output = new
     * FileOutputStream( new File(%%2,temp.getName())); byte[] b = new byte[10240]; int len; while ((len =
     * input.read(b)) != -1) { output.write(b, 0, len); } output.flush(); output.close(); input.close(); if
     * (!temp.delete()) //删除单个文件操作出错 } if (temp.isDirectory()) {// 如果是子文件夹 for (File f : temp.listFiles()) { if
     * (f.isDirectory()) { folderList.add(f.getPath()); folderList2.add(folderList2.peek() + File.separator +
     * f.getName()); } } } } } catch (Exception e) { //复制整个文件夹内容操作出错 e.printStackTrace(); } folderList.removeFirst();
     * folderList2.removeFirst(); } File f = new File(%%1); if (!f.delete()) { for (File file : f.listFiles()) { if
     * (file.list().length == 0) { file.delete(); } } }
     * 
     * 102.文件RSA高级加密
     * 
     * import javax.crypto.*; import java.security.*; import java.security.spec.*; import java.security.interfaces.*;
     * import java.io.*; import java.math.BigInteger;
     *//**
     * 
     * 生成密钥对
     * 
     * @return KeyPair
     * 
     * @throws EncryptException
     */
    /*
     * 
     * public static KeyPair generateKeyPair() throws EncryptException {
     * 
     * try {
     * 
     * KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA",
     * 
     * new org.bouncycastle.jce.provider.BouncyCastleProvider());
     * 
     * final int KEY_SIZE = 1024;//没什么好说的了，这个值关系到块加密的大小，可以更改，但是不要太大，否则效率会低
     * 
     * keyPairGen.initialize(KEY_SIZE, new SecureRandom());
     * 
     * KeyPair keyPair = keyPairGen.genKeyPair();
     * 
     * return keyPair;
     * 
     * } catch (Exception e) {
     * 
     * throw new EncryptException(e.getMessage());
     * 
     * }
     * 
     * }
     *//**
     * 
     * 生成公钥
     * 
     * @param modulus
     * 
     * @param publicExponent
     * 
     * @return RSAPublicKey
     * 
     * @throws EncryptException
     */
    /*
     * 
     * public static RSAPublicKey generateRSAPublicKey(byte[] modulus, byte[] publicExponent) throws EncryptException {
     * 
     * KeyFactory keyFac = null;
     * 
     * try {
     * 
     * keyFac = KeyFactory.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
     * 
     * } catch (NoSuchAlgorithmException ex) {
     * 
     * throw new EncryptException(ex.getMessage());
     * 
     * }
     * 
     * RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent));
     * 
     * try {
     * 
     * return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);
     * 
     * } catch (InvalidKeySpecException ex) {
     * 
     * throw new EncryptException(ex.getMessage());
     * 
     * }
     * 
     * }
     *//**
     * 
     * 生成私钥
     * 
     * @param modulus
     * 
     * @param privateExponent
     * 
     * @return RSAPrivateKey
     * 
     * @throws EncryptException
     */
    /*
     * 
     * public static RSAPrivateKey generateRSAPrivateKey(byte[] modulus, byte[] privateExponent) throws EncryptException
     * {
     * 
     * KeyFactory keyFac = null;
     * 
     * try {
     * 
     * keyFac = KeyFactory.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
     * 
     * } catch (NoSuchAlgorithmException ex) {
     * 
     * throw new EncryptException(ex.getMessage());
     * 
     * }
     * 
     * RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(new BigInteger(modulus), new BigInteger(privateExponent));
     * 
     * try {
     * 
     * return (RSAPrivateKey) keyFac.generatePrivate(priKeySpec);
     * 
     * } catch (InvalidKeySpecException ex) {
     * 
     * throw new EncryptException(ex.getMessage());
     * 
     * }
     * 
     * }
     *//**
     * 
     * 加密
     * 
     * @param key
     *            加密的密钥
     * 
     * @param data
     *            待加密的明文数据
     * 
     * @return 加密后的数据
     * 
     * @throws EncryptException
     */
    /*
     * 
     * public static byte[] encrypt(Key key, byte[] data) throws EncryptException {
     * 
     * try {
     * 
     * Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
     * 
     * cipher.init(Cipher.ENCRYPT_MODE, key);
     * 
     * int blockSize = cipher.getBlockSize();//获得加密块大小，如：加密前数据为128个byte，而key_size=1024 加密块大小为127
     * byte,加密后为128个byte;因此共有2个加密块，第一个127 byte第二个为1个byte
     * 
     * int outputSize = cipher.getOutputSize(data.length);//获得加密块加密后块大小
     * 
     * int leavedSize = data.length % blockSize;
     * 
     * int blocksSize = leavedSize != 0 ? data.length / blockSize + 1 : data.length / blockSize;
     * 
     * byte[] raw = new byte[outputSize * blocksSize];
     * 
     * int i = 0;
     * 
     * while (data.length - i * blockSize > 0) {
     * 
     * if (data.length - i * blockSize > blockSize)
     * 
     * cipher.doFinal(data, i * blockSize, blockSize, raw, i * outputSize);
     * 
     * else
     * 
     * cipher.doFinal(data, i * blockSize, data.length - i * blockSize, raw, i * outputSize);
     * //这里面doUpdate方法不可用，查看源代码后发现每次doUpdate后并没有什么实际动作除了把byte
     * []放到ByteArrayOutputStream中，而最后doFinal的时候才将所有的byte[]进行加密，可是到了此时加密块大小很可能已经超出了OutputSize所以只好用dofinal方法。
     * 
     * i++;
     * 
     * }
     * 
     * return raw;
     * 
     * } catch (Exception e) {
     * 
     * throw new EncryptException(e.getMessage());
     * 
     * }
     * 
     * }
     *//**
     * 
     * 解密
     * 
     * @param key
     *            解密的密钥
     * 
     * @param raw
     *            已经加密的数据
     * 
     * @return 解密后的明文
     * 
     * @throws EncryptException
     */
    /*
     * 
     * public static byte[] decrypt(Key key, byte[] raw) throws EncryptException {
     * 
     * try {
     * 
     * Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
     * 
     * cipher.init(cipher.DECRYPT_MODE, key);
     * 
     * int blockSize = cipher.getBlockSize();
     * 
     * ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
     * 
     * int j = 0;
     * 
     * while (raw.length - j * blockSize > 0) {
     * 
     * bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
     * 
     * j++;
     * 
     * }
     * 
     * return bout.toByteArray();
     * 
     * } catch (Exception e) {
     * 
     * throw new EncryptException(e.getMessage());
     * 
     * }
     * 
     * }
     * 
     * 
     * File file = new File("test.html");
     * 
     * FileInputStream in = new FileInputStream(file);
     * 
     * ByteArrayOutputStream bout = new ByteArrayOutputStream();
     * 
     * byte[] tmpbuf = new byte[1024];
     * 
     * int count = 0;
     * 
     * while ((count = in.read(tmpbuf)) != -1) {
     * 
     * bout.write(tmpbuf, 0, count);
     * 
     * tmpbuf = new byte[1024];
     * 
     * }
     * 
     * in.close();
     * 
     * byte[] orgData = bout.toByteArray();
     * 
     * KeyPair keyPair = RSAUtil.generateKeyPair();
     * 
     * RSAPublicKey pubKey = (RSAPublicKey) keyPair.getPublic();
     * 
     * RSAPrivateKey priKey = (RSAPrivateKey) keyPair.getPrivate();
     * 
     * byte[] pubModBytes = pubKey.getModulus().toByteArray();
     * 
     * byte[] pubPubExpBytes = pubKey.getPublicExponent().toByteArray();
     * 
     * byte[] priModBytes = priKey.getModulus().toByteArray();
     * 
     * byte[] priPriExpBytes = priKey.getPrivateExponent().toByteArray();
     * 
     * RSAPublicKey recoveryPubKey = RSAUtil.generateRSAPublicKey(pubModBytes,pubPubExpBytes);
     * 
     * RSAPrivateKey recoveryPriKey = RSAUtil.generateRSAPrivateKey(priModBytes,priPriExpBytes);
     * 
     * byte[] raw = RSAUtil.encrypt(priKey, orgData);
     * 
     * file = new File("encrypt_result.dat");
     * 
     * OutputStream out = new FileOutputStream(file);
     * 
     * out.write(raw);
     * 
     * out.close();
     * 
     * byte[] data = RSAUtil.decrypt(recoveryPubKey, raw);
     * 
     * file = new File("decrypt_result.html");
     * 
     * out = new FileOutputStream(file);
     * 
     * out.write(data);
     * 
     * out.flush();
     * 
     * out.close();
     * 
     * 103.计算文件大小
     * 
     * import java.io.*; private final long KB=1024; private final long MB=1024*KB; private final long GB=1024*MB;
     * 
     * //文件属性 File file=new File(%%1); //如果文件存在而且是文件，直接返回文件大小 if(file.exists()&&file.isFile()) { long filesize=
     * file.length(); String showsize; if(filesize>=GB) showsize=filesize/GB+" GB"; else if(filesize>=MB)
     * showsize=filesize/MB+" MB"; else if(filesize>=KB) showsize=filesize/KB+" KB"; else if(filesize>1)
     * showsize=filesize/GB+" Bytes"; else showsize="1 Byte"; String %%2=showsize; }
     * 
     * 104.计算文件夹的大小
     * 
     * import java.io.*; import java.math.*; //bt字节参考量 private static final long SIZE_BT=1024L; //KB字节参考量 private static
     * final long SIZE_KB=SIZE_BT*1024L; //MB字节参考量 private static final long SIZE_MB=SIZE_KB*1024L; //GB字节参考量 private
     * static final long SIZE_GB=SIZE_MB*1024L; //TB字节参考量 private static final long SIZE_TB=SIZE_GB*1024L; private
     * static final int SACLE=2; //文件大小属性 private static long longSize;
     * 
     * private void getFileSize(File file) { // 获得文件目录下文件对象数组 File[] fileArray = file.listFiles(); //
     * 如果文件目录数组不为空或者length!=0,即目录为空目录 if (fileArray != null && fileArray.length != 0) { // 遍历文件对象数组 for (int i = 0; i <
     * fileArray.length; i++) { File fileSI = fileArray[i]; // 如果是目录递归遍历 if (fileSI.isDirectory()) { // 递归遍历
     * getFileSize(fileSI); } // 如果是文件 if (fileSI.isFile()) { longSize += fileSI.length(); } } } else { //
     * 如果文件目录数组为空或者length==0,即目录为空目录 longSize = 0; } } // 文件存在而且是目录，递归遍历文件目录计算文件大小 File file = new File(folderPath); if
     * (file.exists() && file.isDirectory()) { getFileSize(file);// 递归遍历 } String %%2="0 Byte"; if (longSize == 1) {
     * %%2="1 Byte"; } else if (longSize >= 2 && longSize < SIZE_BT) { %%2=longSize + " Bytes"; } else if (longSize >=
     * SIZE_BT && longSize < SIZE_KB) { %%2=longSize / SIZE_BT + " KB"; } else if (longSize >= SIZE_KB && longSize <
     * SIZE_MB) { %%2=longSize / SIZE_KB + " MB"; } else if (longSize >= SIZE_MB && longSize < SIZE_GB) { BigDecimal
     * longs = new BigDecimal(Double.valueOf(longSize + "") .toString()); BigDecimal sizeMB = new
     * BigDecimal(Double.valueOf(SIZE_MB + "") .toString()); String result = longs.divide(sizeMB, SACLE,
     * BigDecimal.ROUND_HALF_UP).toString(); // double result=longSize/(double)SIZE_MB; %%2=result + " GB"; } else {
     * BigDecimal longs = new BigDecimal(Double.valueOf(longSize + "") .toString()); BigDecimal sizeMB = new
     * BigDecimal(Double.valueOf(SIZE_GB + "") .toString()); String result = longs.divide(sizeMB, SACLE,
     * BigDecimal.ROUND_HALF_UP).toString(); %%2=result + " TB"; }
     * 
     * 105.快速获得当前程序的驱动器、路径、文件名和扩展名 String %%2=%%1.substring(0,%%1.lastIndexOf(":")); String
     * %%5=%%1.substring(0,%%1.lastIndexOf("\\")); String %%4=%%1.substring(%%1.lastIndexOf("\\")+1); String
     * %%3=%%1.substring(%%1.lastIndexOf('.'));
     * 
     * 106.磁盘剩余空间计算 //import java.io.*; File file = new File(%%1); //"C:" long %%2 = file.getFreeSpace();
     * //file.getTotalSpace()
     * 
     * 107.获取当前程序进程ID java是在jvm上跑的，jvm本身作为系统的一个进程在跑， 所以平时见到的都是java多线程，没有进程间通信， 为什么呢，就是因为java中没有进程这一说法，
     * 除非指的是程序本身这个进程。这个进程的话需要用到系统命令或者底层c语言才能够得到。呃，本人jni不是太熟悉，可以参考
     * http://hi.baidu.com/lff0305/blog/item/4f301a7b20d3d3f20bd187e3.html， linux下直接调用ps-ef再用管道提取吧。
     * 
     * 108.全盘搜索文件 import java.io.*; //ArrayList fileNames=new ArrayList(); void listDirectory(String dir) { File f=new
     * File(dir); File[] files=f.listFiles(); if(files==null) return; for(int i=0;i<files.length;i++) {
     * if(files[i].isDirectory()) { System.out.println("-----------"+files[i]+" is a directory has more files bellow:");
     * listDirectory(files[i].getAbsolutePath()); //listDirectory(files[i].getName());
     * //listDirectory(files[i].toString()); }
     * 
     * else { System.out.println(files[i]); } } } File[] roots=File.listRoots(); for(int i=0;i<roots.length;i++) {
     * System.out.println(roots[i]); } } lrt.listDirectory("D:"+File.separator);
     */
}
