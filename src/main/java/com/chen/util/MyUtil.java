package com.chen.util;

import com.alibaba.fastjson.JSON;
import com.chen.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: CHEN
 * @date: 2020-11-19 16:31
 **/
public class MyUtil {
    public static String toJSONString(String key, Object o) {
        Map<String, Object> map = new HashMap<>();
        map.put(key,o);
        return JSON.toJSONString(map);
    }

}
