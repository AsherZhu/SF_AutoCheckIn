package service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import service.CheckIn;

import java.io.IOException;
import java.util.HashMap;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/7 23:38
 * \
 */
public class CheckInImpl implements CheckIn {

    @Override
    public String checkIn(String url, HashMap cookie) {
        Document document = null;

        try {
            document = Jsoup.connect(url).cookies(cookie).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert document != null;
//        System.out.println(document.toString());
        String string = document.select("body").text();
        System.out.println(string);


        //利用Server酱 推送签到状态到微信
        try {
            Jsoup.connect("https://sc.ftqq.com/SCU16894T7bc1c15fefbb7902826a77d854646cf35a1e0eaa17b12.send?text=主人我已经帮你签到了哦~&desp="+string).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
