package com.muxi.wxchat.util;


/*
 *------------------------------.
 *@ClassName : MessageUtil
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/2 11:20
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.pojo.Message;
import com.muxi.wxchat.pojo.MessageText;
import com.thoughtworks.xstream.XStream;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtil {

    public static String messageToxml(MessageText message) {
        XStream xstream  = new XStream();
        xstream.alias("xml", message.getClass());
        return xstream.toXML(message);
    }

    public static String initMessage(String FromUserName, String ToUserName,String Statement) {
        MessageText text = new MessageText();
        text.setToUserName(FromUserName);
        text.setFromUserName(ToUserName);
        text.setContent(Statement);
        text.setCreateTime(Long.valueOf(DateUtil.getNowTime()));
        text.setMsgType("text");
        return  messageToxml(text);
    }

    /*
    *------------------------------.
    *@ClassName : MessageUtil
    *@创建人 : 沐惜
    *@创建时间 : 2018/8/3 23:42
    *@方法描述 : 公众号发送text文本细信息
    *@Param :FromUserName ToUserName ToUserName
    @Return :String
    *@Version : 1.0
    *------------------------------
    */
    public static String sendMessage(String FromUserName, String ToUserName,String Content,Message message) {
        MessageText text = new MessageText();
        text.setToUserName(FromUserName);
        text.setFromUserName(ToUserName);
        text.setContent(Content);
        text.setCreateTime(message.getCreateTime());
        text.setMsgType("text");
        return  messageToxml(text);
    }







    /*
    *------------------------------.
     *@ClassName : MapUtil
     *@创建人 : 沐惜
     *@创建时间 : 2018/8/2 16:22
     *@方法描述 : XML转Map
     *@Param :
     @Return :
     *@Version : 1.0
     *------------------------------
     */
    public static Map<String,String> xmlToMap(HttpServletRequest request){
        Map<String,String> map = new HashMap<String,String>();
        SAXReader reader = new SAXReader();
        InputStream in = null;
        try {
            in = request.getInputStream();
            Document doc = reader.read(in);
            Element root = doc.getRootElement();
            List<Element> list = root.elements();
            for (Element element : list) {
                map.put(element.getName(), element.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }



    /*
    *------------------------------.
    *@ClassName : MessageUtil
    *@创建人 : 沐惜
    *@创建时间 : 2018/8/11 10:14
    *@方法描述 : 表情int类型编码转string
    *@Param :
    @Return :
    *@Version : 1.0
    *------------------------------
    */
    public static String emoji(int hexEmoji) {
        return String.valueOf(Character.toChars(hexEmoji));
    }












}
