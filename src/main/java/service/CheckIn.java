package service;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import util.AnalysisJsonUtil;
import util.ServerChanUtli;

import java.io.IOException;
import java.util.HashMap;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/7 23:38
 * \
 */
public class CheckIn {
    public static String checkIn(String nick, HashMap cookie, String key) {
        String url = "http://book.sfacg.com/ajax/ashx/Common.ashx?op=signinNew&nid=0&_=" + System.currentTimeMillis();
        Document document = null;

        try {
            document = Jsoup.connect(url).cookies(cookie).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String returnMsg = document.select("body").text();
        JSONObject Msg = AnalysisJsonUtil.jsonStringToJsonObject(returnMsg);

        //判断是否签到成功如果Msg.get("status") = 200 成功 400失败
        // 利用Server酱 推送签到状态到微信
        try {
            switch (Msg.getInteger("status")) {
                case 200: {
                    String days = Msg.getString("coupons");
                    ServerChanUtli.ServerChan(key, "主人，我已经帮你吧<" + nick + ">这个账号签到了呢~~~","(๑•̀ㅂ•́)و✧本月我已经为您连续签到"+days+"天了呢");
                    break;
                }
                case 400:{
                    String error = Msg.getString("msg");
                    ServerChanUtli.ServerChan(key, "主人很抱歉<" + nick + ">签到失败了", "失败原因：" + error);
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Server酱坏掉了");
        }

        //利用Server酱 推送签到状态到微信

        return null;
    }


}
