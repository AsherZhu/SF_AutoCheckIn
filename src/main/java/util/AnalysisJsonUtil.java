package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.HashMap;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/8 10:17
 */
public class AnalysisJsonUtil {

    /**
     *  从文json读取json字符串 并转为jsonObject返回
     * @param path
     * @return jsonObject
     */
    public static JSONObject jsonFileToJsonObject(String path) {

        String jsonString = ReadConfigFileUtil.readConfigFile(path);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        return jsonObject;
    }

    /**
     *  json字符串转为jsonObject返回
     * @param jsonString
     * @return jsonObject
     */
    public static JSONObject jsonStringToJsonObject(String jsonString) {
        JSONObject jsonObject = JSON.parseObject(jsonString);
        return jsonObject;
    }

}
