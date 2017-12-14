package util;

import org.jsoup.Jsoup;
import java.io.IOException;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/9 18:25
 * \https://sc.ftqq.com/SCU16894T7bc1c15fefbb7902826a77d854646cf35a1e0eaa17b12.send?text=主人服务器又挂掉啦~
 */
public class ServerChanUtli {

    public static void ServerChan(String key, StringBuffer text, StringBuffer desp) throws IOException {
        Jsoup.connect("https://sc.ftqq.com/" + key + ".send?text=" + text + "~&desp=" + desp).get();

    }
}
