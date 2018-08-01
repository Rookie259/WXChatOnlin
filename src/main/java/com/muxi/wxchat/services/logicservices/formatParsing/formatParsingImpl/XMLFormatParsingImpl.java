package com.muxi.wxchat.services.logicservices.formatParsing.formatParsingImpl;


/*
 *------------------------------.
 *@ClassName : XMLFormatParsingImpl
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 11:47
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.pojo.formatParsing.XmlReceive;
import com.muxi.wxchat.services.logicservices.formatParsing.XMLFormatParsing;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;

import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.AritificialMenu;
import com.muxi.wxchat.util.LoggerUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XMLFormatParsingImpl implements XMLFormatParsing {

    @Autowired
    private AritificialMenu aritificialMenu;

    /*
    *------------------------------.
    *@ClassName : XMLFormatParsingImpl
    *@创建人 : 沐惜
    *@创建时间 : 2018/7/30 11:50
    *@方法描述 : 解析XML(接收到的信息)
    *@Param :InputStream
    @Return :String
    *@Version : 1.0
    *------------------------------
    */
    @Override
    public String analysisXML(String xml) {
        /** 解析xml数据 */
        XmlReceive xmlReceive = getMsgEntity(xml);

        /** 以文本消息为例，调用图灵机器人api接口，获取回复内容 */
        String result = "";
        if ("text".endsWith(xmlReceive.getMsgType())) {
            result = aritificialMenu.getTulingResult(xmlReceive.getContent());
        }
        result = formatXmlAnswer(xmlReceive.getFromUserName(), xmlReceive.getToUserName(), result);
        return result;
    }

    @Override
    public XmlReceive getMsgEntity(String strXml) {
        XmlReceive xmlReceive = null;
        try {
            if (strXml.length() <= 0 || strXml == null)
                return null;

            // 将字符串转化为XML文档对象
            Document document = DocumentHelper.parseText(strXml);
            // 获得文档的根节点
            Element root = document.getRootElement();
            // 遍历根节点下所有子节点
            Iterator<?> iter = root.elementIterator();

            // 遍历所有结点
            xmlReceive = new XmlReceive();
            //利用反射机制，调用set方法
            //获取该实体的元类型
            Class<?> c = Class.forName("com.muxi.wxvipcn.entity.ReceiveXmlEntity");
            xmlReceive = (XmlReceive) c.newInstance();//创建这个实体的对象

            while (iter.hasNext()) {
                Element ele = (Element) iter.next();
                //获取set方法中的参数字段（实体类的属性）
                Field field = c.getDeclaredField(ele.getName());
                //获取set方法，field.getType())获取它的参数数据类型
                Method method = c.getDeclaredMethod("set" + ele.getName(), field.getType());
                //调用set方法
                method.invoke(xmlReceive, ele.getText());
            }
        } catch (Exception e) {
            LoggerUtil.setLogger("xml 格式异常: " + strXml);
            e.printStackTrace();
        }
        return xmlReceive;
    }

    @Override
    public String formatXmlAnswer(String to, String from, String content) {
        StringBuffer sb = new StringBuffer();
        Date date = new Date();
        sb.append("<xml><ToUserName><![CDATA[");
        sb.append(to);
        sb.append("]]></ToUserName><FromUserName><![CDATA[");
        sb.append(from);
        sb.append("]]></FromUserName><CreateTime>");
        sb.append(date.getTime());
        sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");
        sb.append(content);
        sb.append("]]></Content><FuncFlag>0</FuncFlag></xml>");
        return sb.toString();
    }
}
