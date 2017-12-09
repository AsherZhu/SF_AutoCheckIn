package util;

import java.util.HashMap;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/7 23:18
 * \处理cookie 从字符串转变为HashMap
 */
public class ProcessCookieUtil {

    public static HashMap<String, String> getCookie(String cookieString) {

        HashMap<String, String> hashMap = new HashMap<String, String>();

        String[] cookiess = cookieString.split(";");

        for (String cookies : cookiess) {
            String[] coolie = cookies.split("=",2);
            hashMap.put(coolie[0].trim(),coolie[1].trim());
        }
        return hashMap;
    }
}
