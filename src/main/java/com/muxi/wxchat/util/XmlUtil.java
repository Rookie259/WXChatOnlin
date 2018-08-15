package com.muxi.wxchat.util;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.muxi.wxchat.pojo.ImageTextAriticlePojo;
import com.muxi.wxchat.pojo.ImageTextArticleListPojo;
import com.muxi.wxchat.pojo.MessageText;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.commons.codec.CharEncoding;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * xml的工具类
 * 
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public final class XmlUtil {

	/*
	*------------------------------.
	*@ClassName : XmlUtil
	*@创建人 : 沐惜
	*@创建时间 : 2018/8/6 17:22
	*@方法描述 : 采用递归吧对象转为xml
	*@Param :
	@Return :
	*@Version : 1.0
	*------------------------------
	*/
	public static String toXml(Object object, boolean isHead) {
		String result = (isHead ? "<?xml version=\"1.0\" encoding=\"" + CharEncoding.UTF_8 + "\" ?>" : "") + "<xml>\n";
		if (null != object) {
			result += toXml(object);
		}
		return result + "</xml>\n";
	}

	private static String toXml(Object object) {
		String result = "";
		JSONObject json = JSONObject.fromObject(object);
		Set set = json.keySet();
		for (Object key : set) {
			Object value = json.get(key);
			if (null == value) {
				result += "<" + key + "></" + key + ">\n";
			} else if (value instanceof JSONObject) {
				result += "<" + key + ">\n" + toXml(value) + "</" + key + ">\n";
			} else if (value instanceof JSONArray) {
				result += "<" + key + ">\n";
				JSONArray array = (JSONArray) value;
				for (Object obj : array) {
					result += toXml(obj);
				}
				result += "</" + key + ">\n";
			} else {
				result += "<" + key + "><![CDATA[" + value + "]]></" + key + ">\n";
			}
		}
		return result;
	}

	/*
	*------------------------------.
	*@ClassName : XmlUtil
	*@创建人 : 沐惜
	*@创建时间 : 2018/8/6 19:39
	*@方法描述 : 文本消息XML
	*@Param :
	@Return :
	*@Version : 1.0
	*------------------------------
	*/

	public static String textMessageToXml(MessageText textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}





	/*
	*------------------------------.
	*@ClassName : XmlUtil
	*@创建人 : 沐惜
	*@创建时间 : 2018/8/6 17:22
	*@方法描述 : 图文信息转xml
	*@Param :
	@Return :
	*@Version : 1.0
	*------------------------------
	*/
	public static String newsImageTextArticleListPojoToXml(ImageTextArticleListPojo imageTextArticleListPojo) {
		xstream.alias("xml", imageTextArticleListPojo.getClass());
		xstream.alias("item", new ImageTextAriticlePojo().getClass());
		return xstream.toXML(imageTextArticleListPojo);
	}



	private static XStream xstream = new XStream(new XppDriver() {

		public HierarchicalStreamWriter createWriter(Writer out) {

			return new PrettyPrintWriter(out) {

				// 对全部xml节点的转换都添加CDATA标记

				boolean cdata = true;

				public void startNode(String name, Class clazz) {

					super.startNode(name, clazz);

					if(name.equals("CreateTime")){

						cdata = false;

					}

				}

				protected void writeText(QuickWriter writer, String text) {

					if (cdata) {

						writer.write("<![CDATA[");

						writer.write(text);

						writer.write("]]>");

					} else {

						writer.write(text);

					}

				}

			};

		}

	});










}
