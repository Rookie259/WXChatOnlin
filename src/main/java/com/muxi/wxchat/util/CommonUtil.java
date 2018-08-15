package com.muxi.wxchat.util;


/*
 *------------------------------.
 *@ClassName : CommonUtil
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/12 0:26
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.constant.WXStaticConstant;
import com.muxi.wxchat.pojo.WXPOJO.Token;
import com.muxi.wxchat.pojo.WXPOJO.WxAttentionUser;
import com.muxi.wxchat.services.logicservices.MyX509TrustManager.MyX509TrustManager;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.util.Date;

public class CommonUtil {
    private static long tokenTime = 0;
    private static long jsTicketTime = 0;
    private static Token token = null;
    private static String ticket = null;


    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            LoggerUtil.setLogger("连接超时：{}"+ce);
        } catch (Exception e) {
            LoggerUtil.setLogger("https请求异常：{}"+e);
        }
        return jsonObject;
    }

    /**
     * 获取接口访问凭证
     *
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    public static Token getToken(String appid, String appsecret) {
        long now = new Date().getTime();
        if(tokenTime!=0&&now-tokenTime<7000000){//token有效时间 7e6 毫秒
            return token;
        }
        String requestUrl = WXStaticConstant.ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
        // 发起GET请求获取凭证
        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                token = new Token();
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInt("expires_in"));
                tokenTime = now;
            } catch (JSONException e) {
                token = null;
                // 获取token失败
                LoggerUtil.setLogger("获取token失败 errcode:{} errmsg:{}"+jsonObject.getInt("errcode")+"\n"+jsonObject.getString("errmsg"));
            }
        }
        return token;
    }

    /**
     * 根据内容类型判断文件扩展名
     *
     * @param contentType 内容类型
     * @return
     */
    public static String getFileExt(String contentType) {
        String fileExt = "";
        if ("image/jpeg".equals(contentType))
            fileExt = ".jpg";
        else if ("audio/mpeg".equals(contentType))
            fileExt = ".mp3";
        else if ("audio/amr".equals(contentType))
            fileExt = ".amr";
        else if ("video/mp4".equals(contentType))
            fileExt = ".mp4";
        else if ("video/mpeg4".equals(contentType))
            fileExt = ".mp4";
        return fileExt;
    }



    public static WxAttentionUser getUserInfo(String accessToken, String openId) {
        WxAttentionUser weixinUserInfo = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 获取用户信息
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                weixinUserInfo = new WxAttentionUser();
                // 用户的标识
                weixinUserInfo.setWxoppenid(jsonObject.getString("openid"));
                // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
                weixinUserInfo.setWxsubscribe(jsonObject.getInt("subscribe"));
                // 用户关注时间
                weixinUserInfo.setWxsubscribetime(jsonObject.getString("subscribe_time"));
                // 昵称
                weixinUserInfo.setWxnickname(jsonObject.getString("nickname"));
                // 用户的性别（1是男性，2是女性，0是未知）
                weixinUserInfo.setWxsex(jsonObject.getInt("sex"));
                // 用户所在国家
                weixinUserInfo.setWxcountry(jsonObject.getString("country"));
                // 用户所在省份
                weixinUserInfo.setWxprovince(jsonObject.getString("province"));
                // 用户所在城市
                weixinUserInfo.setWxcity(jsonObject.getString("city"));
                // 用户的语言，简体中文为zh_CN
                weixinUserInfo.setWxlanguage(jsonObject.getString("language"));
                // 用户头像
                weixinUserInfo.setWxheadimgurl(jsonObject.getString("headimgurl"));
            } catch (Exception e) {
                System.out.println(weixinUserInfo.toString());
                if (0 == weixinUserInfo.getWxsubscribe()) {
                    System.err.printf("用户{}已取消关注", weixinUserInfo.getWxoppenid());
                } else {
                    int errorCode = jsonObject.getInt("errcode");
                    String errorMsg = jsonObject.getString("errmsg");
                    System.err.printf("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
                }
            }
        }
        return weixinUserInfo;
    }


    public static void main(String args[]) {
        // 获取接口访问凭证
        String accessToken = CommonUtil.getToken("wx3188b7c5b23d9857", "78b1a9ec808f854cbc29625866c22b52").getAccessToken();
        /**
         * 获取用户信息
         */
        WxAttentionUser user = getUserInfo(accessToken, "\"ooK-yuJvd9gEegH6nRIen-gnLrVw\"");
        //做这个测试的时候可以先关注，或者取消关注，控制台会打印出来此用户的openid
        System.out.println("OpenID：" + user.getWxoppenid());
        System.out.println("关注状态：" + user.getWxsubscribe());
        System.out.println("关注时间：" + user.getWxsubscribetime());
        System.out.println("昵称：" + user.getWxnickname());
        System.out.println("性别：" + user.getWxsex());
        System.out.println("国家：" + user.getWxcountry());
        System.out.println("省份：" + user.getWxprovince());
        System.out.println("城市：" + user.getWxcity());
        System.out.println("语言：" + user.getWxlanguage());
        System.out.println("头像：" + user.getWxheadimgurl());
    }


}
