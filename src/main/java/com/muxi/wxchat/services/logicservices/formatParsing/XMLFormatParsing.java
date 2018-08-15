package com.muxi.wxchat.services.logicservices.formatParsing;


import com.muxi.wxchat.pojo.formatParsing.XmlReceive;

import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
/*
 *------------------------------.
 *@ClassName : XMLFormatParsing
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 11:46
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */
public interface XMLFormatParsing {


    public String analysisXML(String xml);

    public XmlReceive getMsgEntity(String strXml);

    public String formatXmlAnswer(String to, String from, String content);

    /*将微信请求封装为Map，并转换为对Message象*/
    public  <T> T tranRequestOfMessage(HttpServletRequest request);

    /*bean转xml*/
    public String beanTranXML(Class<?> cls);


}
