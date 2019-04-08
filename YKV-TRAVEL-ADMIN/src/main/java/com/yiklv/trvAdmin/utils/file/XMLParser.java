package com.yiklv.trvAdmin.utils.file;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * 
 * <b>Description:</b><br> xml
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.utils.file
 * <br><b>ClassName:</b> XMLParser
 * <br><b>Date:</b> 2018年3月23日 下午9:19:42
 */
public class XMLParser {
    /**
     * 
     * <b>Description:</b><br> xml文件解析
     * @param fileName
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月23日 下午9:19:46
     * <br><b>Version:</b> 1.0
     */
    public void getAllUserNames(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileName);
            if (file.exists()) {
                Document doc = db.parse(file);
                Element docEle = doc.getDocumentElement();

                // Print root element of the document
                System.out.println("Root element of the document: " + docEle.getNodeName());

                NodeList studentList = docEle.getElementsByTagName("student");

                // Print total student elements in document
                System.out.println("Total students: " + studentList.getLength());

                if (studentList != null && studentList.getLength() > 0) {
                    for (int i = 0; i < studentList.getLength(); i++) {

                        Node node = studentList.item(i);

                        if (node.getNodeType() == Node.ELEMENT_NODE) {

                            System.out.println("=====================");

                            Element e = (Element) node;
                            NodeList nodeList = e.getElementsByTagName("name");
                            System.out.println("Name: " + nodeList.item(0).getChildNodes().item(0).getNodeValue());

                            nodeList = e.getElementsByTagName("grade");
                            System.out.println("Grade: " + nodeList.item(0).getChildNodes().item(0).getNodeValue());

                            nodeList = e.getElementsByTagName("age");
                            System.out.println("Age: " + nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        }
                    }
                }
                else {
                    System.exit(1);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        XMLParser parser = new XMLParser();
        parser.getAllUserNames("c:\\test.xml");
    }
}
