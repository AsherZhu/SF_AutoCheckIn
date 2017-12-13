package util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/13 23:56
 * \
 */
public class UrlToJsonStringUtil {
    /**
     *  url字符串转为jsonString返回
     * @param url cookie
     * @return text
     */
    public static String urlToJsonString(String url, HashMap cookie) throws IOException {
        Document document = Jsoup.connect(url).cookies(cookie).get();
        String text = document.select("body").text();
        return text;
    }


}
