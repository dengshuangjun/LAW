package com.yc.law.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.yc.law.entity.Style;

public class StyleDomXml {

	/**
	 * doc转换成xml
	 * @param doc
	 * @param fileName
	 * @return
	 */
	public boolean docToXml(Document doc,String fileName){
		boolean flag;
		try {
			//创建一个工厂
			TransformerFactory factory=TransformerFactory.newInstance(); 
			//创建一个转换器
			Transformer tf=factory.newTransformer();
			//设置XML属性
			tf.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			//输出xml
			DOMSource domSource=new DOMSource(doc);
			
			StreamResult sr=new StreamResult(new File(fileName));
			tf.transform(domSource, sr);
			flag=true;
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 修改结点
	 */
	public void update(Style b,String fileName) {
		try {
			//1.dom解析工厂
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			//2.解析器
			DocumentBuilder builder=factory.newDocumentBuilder();
			//3.xml放到解析器
			Document doc=builder.parse(new File(fileName));
			//4.开始解析
			NodeList nl=doc.getElementsByTagName("style");
			//5.找到Style name  (这里不需要)
			Element e=(Element) nl.item(0);//e代表的是Style這個結點
			//6.修改值
			e.getElementsByTagName("main").item(0).getFirstChild().setNodeValue(b.getMain());
			e.getElementsByTagName("devMain").item(0).getFirstChild().setNodeValue(b.getDevMain());
			e.getElementsByTagName("dev").item(0).getFirstChild().setNodeValue(b.getDev());
			//7.输出xml
			if(docToXml(doc,fileName)){
				LogManager.getLogger().debug("前台样式修改成功。");
			}else{
				LogManager.getLogger().error("前台样式修改失败。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查找结点
	 */
	public Style find(String fileName) {
		try {
			//1.dom解析工厂
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			//2.解析器
			DocumentBuilder builder=factory.newDocumentBuilder();
			//3.xml放到解析器
			Document doc=builder.parse(new File(fileName));
			//4.开始解析
			NodeList nl=doc.getElementsByTagName("style");
			//5.找到Style name  (这里不需要)
			Element e=(Element) nl.item(0);//e代表的是Style這個結點
			//6.查找值
			Style style = new Style();
			style.setMain( e.getElementsByTagName("main").item(0).getFirstChild().getNodeValue() );
			style.setDevMain( e.getElementsByTagName("devMain").item(0).getFirstChild().getNodeValue() );
			style.setDev( e.getElementsByTagName("dev").item(0).getFirstChild().getNodeValue() );
			return style;
		} catch (Exception e) {
			LogManager.getLogger().error("解析样式xml出错。");
		}
		return null;
	}
}
