package com.limbo.sdk_demo.util;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Project :  yunaandroid.
 * Package name: com.renwei.yunlong.utils
 * Created by :  Benjamin.
 * Created time: 2017/10/18 14:39
 * Changed by :  Benjamin.
 * Changed time: 2017/10/18 14:39
 * Class description:
 */

public class JsonMapUtil {
    @SuppressWarnings("unchecked")
    public static Map<Object, Object> Json2Map(String jsonStr) {
        Map<Object, Object> resultMap = new HashMap<Object, Object>();
        String[] array = jsonStr.substring(1, jsonStr.length() - 1).split(",");
        for (int i = 0; i < array.length; i++) {
            String[] tempArray = array[i].split(":");
            resultMap.put(tempArray[0].substring(1, tempArray[0].length() - 1).trim(), tempArray[1].substring(1, tempArray[1].length() - 1).trim());
        }
        return resultMap;
    }

    public static <T> String mapToJson(Map<String, String> map) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }


    /**
     * 把map转成用，逗号分隔的一个数组String
     * 【“qweqwe,asdas,34534534”,"nihdoas,wodwhsid,7123890719"】
     *
     * @param <T>
     * @return
     */
    public static <T> String[] map2Array(HashMap<String,String> map) {
        String[] arry = new String[2];
        Iterator iter = map.keySet().iterator();
        String keys = "";
        String values = "";
        while (iter.hasNext()) {
           String key = (String) iter.next();
            String value = map.get(key);
            keys += key + ",";
            values += value + ",";
            if (!iter.hasNext()) {
                keys = keys.substring(0, keys.length() - 1);
                values = values.substring(0, values.length() - 1);
            }
        }
        arry[0] = keys;
        arry[1] = values;
        return arry;
    }
}
