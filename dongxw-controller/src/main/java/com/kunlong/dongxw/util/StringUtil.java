package com.kunlong.dongxw.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kunlong.platform.utils.KunlongUtils;

public class StringUtil {
    public static <T> T buildQueryLikeValue(T obj, Class<T> cls) {
        JSONObject jsonObject = JSONObject.parseObject(KunlongUtils.toJSONString(obj));
        for (String key : jsonObject.keySet()) {
            if (jsonObject.get(key) instanceof String) {
                jsonObject.put(key, "%" + jsonObject.get(key).toString() + "%");
            }
        }
        return JSON.toJavaObject(jsonObject, cls);

    }

}
