package com.muxi.wxchat.util;


/*
 *------------------------------.
 *@ClassName : UUIDUtil
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/12 0:46
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID(){

        String preUuid2 = UUID.randomUUID().toString();

        String changUuid = preUuid2.substring(0,8)+preUuid2.substring(9,13)+preUuid2.substring(14,18)+preUuid2.substring(19,23)+preUuid2.substring(24);

        return changUuid;
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
