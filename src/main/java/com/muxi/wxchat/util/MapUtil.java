package com.muxi.wxchat.util;


/*
 *------------------------------.
 *@ClassName : Map
 *@创建人 : 沐惜
 *@创建时间 : 2018/8/2 11:47
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */

import org.apache.commons.beanutils.ConvertUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class MapUtil {

    /*
    *------------------------------.
    *@ClassName : MapUtil
    *@创建人 : 沐惜
    *@创建时间 : 2018/8/2 16:22
    *@方法描述 : Map转对象
    *@Param :
    @Return :
    *@Version : 1.0
    *------------------------------
    */
    public static <T> T mapToBean(Map<String, String> map, T bean) {
        Class<?> clazz = bean.getClass();
        // 得到对象的字段
        List<Field> fields = getAccessibleFields(clazz);
        // 迭代字段
        for (Field f : fields) {
            String name = f.getName();
            Object objVal = map.get(name);
            // 找到对应值，进行转化设置
            if (objVal != null) {
                try {
                    if (f.getType().equals(String.class)) {
                        objVal = String.valueOf(objVal);
                    } else if (!f.getType().isAssignableFrom(objVal.getClass())) {
                        if (isNotBlank(String.valueOf(objVal))) {
                            //转换依赖方法：org.apache.commons.beanutils.ConvertUtils.convert(Object, Class<?>)
                            objVal = ConvertUtils.convert(objVal, f.getType());
                        } else {
                            objVal = null;
                        }
                    }
                    f.set(bean, objVal);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;

    }

    /*
    *------------------------------.
    *@ClassName : MapUtil
    *@创建人 : 沐惜
    *@创建时间 : 2018/8/2 16:55
    *@方法描述 : 循环向上转型, 获取对象所有的DeclaredField       如向上转型到Object仍无法找到, 返回null.
    *@Param :
    @Return : 
    *@Version : 1.0
    *------------------------------
    */
    public static List<Field> getAccessibleFields(final Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            for (Field f : superClass.getDeclaredFields()) {
                boolean hasInSubClass = false;
                for (Field f2 : fields) {
                    if (f2.getName().equals(f.getName())) {
                        hasInSubClass = true;
                        break;
                    }
                }
                if (!hasInSubClass) {
                    makeAccessible(f);
                    fields.add(f);
                }
            }
        }
        return fields;
    }

       /*
       *------------------------------.
       *@ClassName : MapUtil
       *@创建人 : 沐惜
       *@创建时间 : 2018/8/2 16:55
       *@方法描述 : 改变private/protected的成员变量为public，尽量不调用实际改动的语句，避免JDK的SecurityManager抱怨
       *@Param :
       @Return :
       *@Version : 1.0
       *------------------------------
       */
        public static void makeAccessible(Field field) {
            if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())
                    || Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
                field.setAccessible(true);
            }


        }
}