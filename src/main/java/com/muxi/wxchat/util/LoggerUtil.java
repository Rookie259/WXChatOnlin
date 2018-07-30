package com.muxi.wxchat.util;


/*
 *------------------------------.
 *@ClassName : LoggerUtil
 *@创建人 : 沐惜
 *@创建时间 : 2018/7/30 0:55
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import com.muxi.wxchat.controller.WxChatEntrance;
import org.apache.log4j.Logger;

public class LoggerUtil {
    final static Logger logger = Logger.getLogger(WxChatEntrance.class);

    public static void setLogger(String loggerStr){
        logger.info(DateUtil.getNowTime()+"-------------"+loggerStr);
    }
}
