package com.yc.law.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.yc.law.entity.Footer;

public class FooterDomXml {

	/**
	 * 获取节点信息
	 * @return
	 */
	public Footer getFootInfo(String paths) {
		Footer footer=new Footer();
		try {
			//1.得到DOM工厂解析实例
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			//2.从工厂中得到解析器
			DocumentBuilder builder=factory.newDocumentBuilder();
			//3.把要解析的xml放入解析器中
			Document doc=builder.parse(new File(paths));
			//4.开始解析根据节点来获取里面的内容
			NodeList nl=doc.getElementsByTagName("footer");
			Element e=(Element) nl.item(0);
			footer.setInfo(e.getElementsByTagName("info").item(0).getFirstChild().getNodeValue().trim());
			footer.setPhone(e.getElementsByTagName("phone").item(0).getFirstChild().getNodeValue().trim());
			footer.setEmail(e.getElementsByTagName("email").item(0).getFirstChild().getNodeValue().trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return footer;
	}

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
	public void update(Footer b,String fileName) {
		try {
			//1.dom解析工厂
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			//2.解析器
			DocumentBuilder builder=factory.newDocumentBuilder();
			//3.xml放到解析器
			Document doc=builder.parse(new File(fileName));
			//4.开始解析
			NodeList nl=doc.getElementsByTagName("footer");
			//5.找到Style name  (这里不需要)
			Element e=(Element) nl.item(0);//e代表的是footer這個結點
			//6.修改值
			e.getElementsByTagName("info").item(0).getFirstChild().setNodeValue(b.getInfo());
			e.getElementsByTagName("phone").item(0).getFirstChild().setNodeValue(b.getPhone());
			e.getElementsByTagName("email").item(0).getFirstChild().setNodeValue(b.getEmail());
			//7.输出xml
			if(docToXml(doc,fileName)){
				System.out.println("尾部信息修改成功");
			}else{
				System.out.println("尾部信息修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
