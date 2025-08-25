/*
 * eframe-core - core核心共性模块
 * Copyright © 2020-2025 Linlan (open@linlan.net)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.linlan.frame.comm.utils;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/**
 * 枚举转Map工具类
 * CreateTime 2021年11月3日14:29:00
 */
public class EnumUtil {
    /**
     * 讲枚举转成 map
     * @param enumT     枚举类
     * @param methodNames   方法名
     * @param <T>   泛型
     * @return  转换后的Map
     */
    public static <T> LinkedHashMap<String, String> enumToMap(Class<T> enumT,
                                                              String... methodNames) {
        LinkedHashMap<String, String> enummap = new LinkedHashMap<String, String>();
        if (!enumT.isEnum()) {
            return enummap;
        }
        T[] enums = enumT.getEnumConstants();
        if (enums == null || enums.length <= 0) {
            return enummap;
        }
        int count = methodNames.length;
        String valueMathod = "getKey";
        String desMathod = "getValue";
        if (count >= 1 && !"".equals(methodNames[0])) { //扩展方法
            valueMathod = methodNames[0];
        }
        if (count == 2 && !"".equals(methodNames[1])) {
            desMathod = methodNames[1];
        }
        for (int i = 0, len = enums.length; i < len; i++) {
            T tobj = enums[i];
            try {
                Object resultValue = getMethodValue(valueMathod, tobj); //获取value值
                if ("".equals(resultValue)) {
                    continue;
                }
                Object resultDes = getMethodValue(desMathod, tobj); //获取description描述值
                if ("".equals(resultDes)) { //如果描述不存在获取属性值
                    resultDes = tobj;
                }
                if (resultValue instanceof Integer) {//如果是integer，强转为String
                    resultValue = String.valueOf(resultValue);
                }
                enummap.put(resultValue.toString(), resultDes + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return enummap;
    }

    /**
     * 根据反射，通过方法名称获取方法值，忽略大小写的
     * @param methodName    方法名
     * @param obj       对象
     * @param args  动态参数
     * @param <T>   泛型
     * @return return value
     */
    private static <T> Object getMethodValue(String methodName, T obj, Object... args) {
        Object resut = "";
        try {
            Method[] methods = obj.getClass().getMethods(); //获取方法数组，这里只要共有的方法
            if (methods.length <= 0) {
                return resut;
            }
            Method method = null;
            for (int i = 0, len = methods.length; i < len; i++) {
                if (methods[i].getName().equalsIgnoreCase(methodName)) { //忽略大小写取方法
                    methodName = methods[i].getName(); //如果存在，则取出正确的方法名称
                    method = methods[i];
                    break;
                }
            }
            if (method == null) {
                return resut;
            }
            resut = method.invoke(obj, args); //方法执行
            if (resut == null) {
                resut = "";
            }
            return resut; //返回结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resut;
    }
}
