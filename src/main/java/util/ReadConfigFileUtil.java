package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/10 0:15
 * \ 根据路径读取配置文件字符串 并返回
 */
public class ReadConfigFileUtil {
    public static String readConfigFile(String path) {
        StringBuilder ConfigString = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(path))
        ){
            String line;
            while ((line = reader.readLine()) != null) {
                ConfigString.append(line);
            }
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("配置文件，或者路径" + path + "不存在");
        }
        return String.valueOf(ConfigString);
    }

}
