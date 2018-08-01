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
    public String getRequestInitializationMenu() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("感谢关注XX之家!");
        stringBuffer.append("\n");
        stringBuffer.append("你从哪里知道XX微信的?");
        stringBuffer.append("告诉我,有干货领取哦!");
        stringBuffer.append("A:今日头条");
        stringBuffer.append("B:百度贴吧");
        stringBuffer.append("C:知乎问答");
        stringBuffer.append("回复上一任何选项字母即可领取干货！");
        stringBuffer.append("点一点，即领取！");
        stringBuffer.append("想领取其他干货或了解其他内容的,到菜单栏看一看有=哟！总会有惊喜的!");
        return null;
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
}
