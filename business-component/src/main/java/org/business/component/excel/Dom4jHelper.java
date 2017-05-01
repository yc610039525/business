package org.business.component.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jHelper {
	/**
	 * 创建xml 写入属性 添加元素
	 */
	public static void createXmlFile() {
		String fileName = "./text.xml";
		Document document = DocumentHelper.createDocument();// 建立document对象，用来操作xml文件
		Element booksElement = document.addElement("books");// 建立根节点
		booksElement.addComment("This is a test for dom4j ");// 加入一行注释
		Element bookElement = booksElement.addElement("book");// 添加一个book节点
		bookElement.addAttribute("show", "yes");// 添加属性内容
		Element titleElement = bookElement.addElement("title");// 添加文本节点
		titleElement.setText("ajax in action");// 添加文本内容
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(new File(fileName)));
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Document load(String filename) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(new File(filename)); // 读取XML文件,获得document对象
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}
	public static Document load2(URL url) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(url); // 读取XML文件,获得document对象
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}
	/**
	 * 遍历节点
	 * @param args
	 * @throws Exception
	 * @throws FileNotFoundException
	 */
	public static void scanXml(Element root) {
		for (Iterator i = root.elementIterator(); i.hasNext();) {
			Element el = (Element) i.next();
			System.out.println("Name:"+el.getName());
		}
		}
	public static void main(String[] args) throws Exception, FileNotFoundException {
		// Dom4jHelper.createXmlFile();

		Document dom = Dom4jHelper.load("./text.xml");
		Element root = dom.getRootElement();
		root.setText("书架1");
		XMLWriter writer = new XMLWriter( new OutputStreamWriter(new FileOutputStream("./text.xml"),"UTF-8"));
		writer.write(dom);
		writer.close();
		String name = root.getName();
		System.out.println(name);
		Dom4jHelper.scanXml(root);
	}
}
