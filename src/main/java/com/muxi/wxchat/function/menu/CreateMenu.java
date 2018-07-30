package com.muxi.wxchat.function.menu;


/*
 *------------------------------.
 *@ClassName : CreateMenu
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 1:52
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.constant.WXStaticConstant;
import com.muxi.wxchat.pojo.menu.Menu;
import com.muxi.wxchat.services.logicservices.http.HttpRequest;
import com.muxi.wxchat.util.LoggerUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateMenu {

    @Autowired
    private HttpRequest httpRequest;


    public  int createMenu(Menu menu, String accessToken)
    {
        LoggerUtil.setLogger("accessToken=" + accessToken);
        int result = 0;

        String url = WXStaticConstant.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
        LoggerUtil.setLogger("url=" + url);

        String jsonMenu = JSONObject.fromObject(menu).toString();
        LoggerUtil.setLogger("jsonMenu=" + jsonMenu);

        JSONObject jsonObject = httpRequest.httpRequest(url, "POST", jsonMenu);
        LoggerUtil.setLogger("jsonObject=" + jsonObject);

        if (null != jsonObject) {
            LoggerUtil.setLogger("errcode=" + jsonObject.getInt("errcode"));
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
            }
        }
        return result;
    }
}
