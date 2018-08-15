package com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.aritificialMenuImpl;


/*
 *------------------------------.
 *@ClassName : AritificialMenuImpl
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 14:53
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.constant.TuLingStaticConstant;
import com.muxi.wxchat.services.logicservices.informationInteraction.artificialMenu.AritificialMenu;
import com.muxi.wxchat.util.LoggerUtil;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
@Service
public class AritificialMenuImpl implements AritificialMenu {


    @Override
    public void sendStatement(HttpServletResponse response, String statement) {
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            os.write(statement.getBytes("UTF-8"));
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            LoggerUtil.setLogger("发送\n"+statement+"\n失败\n原因: "+e);
        }
    }



    @Override
    public String getDry() {
        return null;
    }

    @Override
    public String getTulingResult(String content) {
        String param = "";
        try {
            param = TuLingStaticConstant.API_URL + URLEncoder.encode(content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            LoggerUtil.setLogger("图灵机器人编码异常: "+e);
        }
        //将参数转为url编码
        /** 发送httpget请求 */
        HttpGet request = new HttpGet(param);
        String result = "";
        try {
            HttpResponse response = HttpClients.createDefault().execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /** 请求失败处理 */
        if (null == result) {
            return "小灵还没有理解您说的意思呢.....";
        }
        try {
            JSONObject json = JSONObject.fromObject(result);
            if (100000 == json.getInt("code")) {
                result = json.getString("text");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            LoggerUtil.setLogger("图灵机器人请求失败: "+e);
        }
        return result;
    }

    /*----------------------------------------------------------------------------------------------------------------*/
    /*信息模本*/
    /*后期需放在数据库*/
    @Override
    public String getRequestInitializationMenu() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("感谢关注千博之家!\ue032\ue032\ue032\ue032\ue032\n");
        stringBuffer.append("你从哪里知道T园的?\n");
        stringBuffer.append("告诉我,有干货领取哦!\n");
        stringBuffer.append("1:今日头条\n");
        stringBuffer.append("2:百度贴吧\n");
        stringBuffer.append("3:知乎问答\n");
        stringBuffer.append("4:其他\n");
        stringBuffer.append("回复任何选项即可领取干货！\n");
        stringBuffer.append("点一点，即领取！\n");
        stringBuffer.append("想领取其他干货或了解其他内容的,到菜单栏看一看哟！总会有惊喜的!\n");
        stringBuffer.append("\n");
        stringBuffer.append("如您在使用改公众号的过程中,有任何的宝贵意见以及为满足的需求都可在以下邮箱中留下宝贵意见\n");
        stringBuffer.append("\n");
        stringBuffer.append("rookiegdn@163.com\ue032\ue032\ue032\ue032");
        return stringBuffer.toString();
    }

    @Override
    public String fontBackOrg() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("点一点,干货到手:\n");
        stringBuffer.append("回复 A 领取前端资料\n");
        stringBuffer.append("回复 B 领取JAVA资料\n");
       /* stringBuffer.append("回复 C 领取Python资料\n");
        stringBuffer.append("回复 D 领取PHP资料\n");*/
        stringBuffer.append("回复 C 领取Android资料\n");
        stringBuffer.append("回复 D 领取PS资料\n");
        stringBuffer.append("\ue032\ue032\ue032\ue032\ue032\ue032\ue032");
        return stringBuffer.toString();
    }

    @Override
    public String attentionReplyHandle(String param) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("干活领取地址:\n");
        switch (param){
            case "A" :
                stringBuffer.append("前端基础领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/1BWunCMhPiYRRh4ZCRlDh1Q 密码：ew4j\n");
                stringBuffer.append("前端中级领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/1bPgLnrKSlmuonsqNqfWleg 密码：schp\n");
                stringBuffer.append("前端项目实战领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/10855JuMGaPQ9s6NOHE_5Aw 密码：jd1m\n");
                  break;
            case "a" :
                stringBuffer.append("前端基础领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/1BWunCMhPiYRRh4ZCRlDh1Q 密码：ew4j\n");
                stringBuffer.append("前端中级领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/1bPgLnrKSlmuonsqNqfWleg 密码：schp\n");
                stringBuffer.append("前端项目实战领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/10855JuMGaPQ9s6NOHE_5Aw 密码：jd1m\n");
                break;

            case "B" :
                stringBuffer.append("JAVA基础领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/10FL3CKBaArahtRocrCo4og 密码：3y70\n");
                stringBuffer.append("JAVA中级领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/14Me1BoNCmTh_CZ-UKkfW2A 密码：74ng\n");
                stringBuffer.append("JAVA高级领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/1y3MBSHx7VYSc6fN17Q6XuQ 密码：l40b\n");
                  break;
            case "b" :
                stringBuffer.append("JAVA基础领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/10FL3CKBaArahtRocrCo4og 密码：3y70\n");
                stringBuffer.append("JAVA中级领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/14Me1BoNCmTh_CZ-UKkfW2A 密码：74ng\n");
                stringBuffer.append("JAVA高级领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/1y3MBSHx7VYSc6fN17Q6XuQ 密码：l40b\n");
                break;
            case "C" :
                stringBuffer.append("Android领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/11n-XkHhI7jLiC8vbSF8jWg 密码：eagc\n");
                  break;
            case "c" :
                stringBuffer.append("Android领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/11n-XkHhI7jLiC8vbSF8jWg 密码：eagc\n");
                break;
            case "D" :
                stringBuffer.append("PS领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/1o1A_61rkjqzkC9fPiScF3A 密码：ajx1\n");
                   break;
            case "d" :
                stringBuffer.append("PS领取地址:\n");
                stringBuffer.append("链接：https://pan.baidu.com/s/1o1A_61rkjqzkC9fPiScF3A 密码：ajx1\n");
                break;
        }
        return stringBuffer.toString();
    }

    @Override
    public String unknowMenu() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PS领取地址:\n");
        return null;
    }

}
