package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/8 10:17
 * \* 从文json读取json字符串 并转为jsonObject返回
 */
public class AnalysisJsonUtil {


    public static JSONObject AnalysisJson(String path) {

        StringBuilder jsonString = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(path))
        ){
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("配置文件，或者路径" + path + "不存在");
        }

        JSONObject jsonObject = JSON.parseObject(String.valueOf(jsonString));

        return jsonObject;
    }
}
