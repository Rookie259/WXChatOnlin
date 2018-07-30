package com.muxi.wxchat.services.logicservices.http.httpImpl;


/*
 *------------------------------.
 *@ClassName : httpRequestImpl
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 0:48
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.services.logicservices.MyX509TrustManager.MyX509TrustManager;
import com.muxi.wxchat.services.logicservices.http.HttpRequest;
import com.muxi.wxchat.util.DateUtil;
import com.muxi.wxchat.util.LoggerUtil;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;

public class httpRequestImpl implements HttpRequest {


    /*
    *------------------------------.
    *@ClassName : httpRequestImpl
    *@创建人 : 沐惜
    *@创建时间 : 2018/7/30 0:49
    *@方法描述 : http获取微信URL连接
    *@Param :requestURL:wxURL requestMethod:请求方法 outputStr:...
    @Return :JSONObject
    *@Version : 1.0
    *------------------------------
    */
    @Override
    public JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        LoggerUtil.setLogger("requestUrl= "+requestUrl);
        LoggerUtil.setLogger("requestMethod= "+requestMethod);
        LoggerUtil.setLogger("outputStr= "+outputStr);

        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();

        try{
            TrustManager[] trustManagers = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, trustManagers, new SecureRandom());

            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            LoggerUtil.setLogger("url="+url);

            HttpsURLConnection httpUrlConn = (HttpsURLConnection)url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String nowLine = null;

            while ((nowLine = bufferedReader.readLine()) != null) {
                buffer.append(nowLine);
            }

            bufferedReader.close();
            inputStreamReader.close();

            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());


        }catch (ConnectException ce){
            LoggerUtil.setLogger("微信服务连接超时");
        } catch (Exception e) {
            LoggerUtil.setLogger("连接失败。失败原因: " + e);
        }
        return jsonObject;
    }
}
