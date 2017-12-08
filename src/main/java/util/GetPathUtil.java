package util;

import java.io.File;
import java.io.IOException;


/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/8 10:19
 * \* 获取项目根路径
 */
public class GetPathUtil {


    public static String getPath() {
        File directory = new File("");//参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(courseFile);
        return courseFile;
    }
}
