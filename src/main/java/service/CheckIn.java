package service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import util.AnalysisJsonUtil;
import util.ServerChanUtli;
import util.UrlToJsonStringUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/7 23:38
 * \
 */
public class CheckIn {
    public static String checkIn(String nick, HashMap cookie, String key) {
        long dateMillionSeconds = System.currentTimeMillis();
        String YearS = new SimpleDateFormat("yyyy").format(dateMillionSeconds);
        String MonthS = new SimpleDateFormat("MM").format(dateMillionSeconds);

        String signinNewUrl = "http://book.sfacg.com/ajax/ashx/Common.ashx?op=signinNew&nid=0&_=" + dateMillionSeconds;
        String getSigninInfoNewUrl = "http://book.sfacg.com/ajax/ashx/Common.ashx?op=getSigninInfoNew&year=" + YearS + "&month=" + MonthS + "&_=" + dateMillionSeconds;
        String signinNew = null;
        String getSigninInfoNew = null;
        try {
            signinNew = UrlToJsonStringUtil.urlToJsonString(signinNewUrl, cookie);
            getSigninInfoNew = UrlToJsonStringUtil.urlToJsonString(getSigninInfoNewUrl, cookie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject signinNewJsonObj = AnalysisJsonUtil.jsonStringToJsonObject(signinNew);

        //读取json字符串 转 jsonObj
        JSONObject Msg = AnalysisJsonUtil.jsonStringToJsonObject(getSigninInfoNew);
        //读取data 转 jsonObj
        JSONObject data = Msg.getJSONObject("data");
        //获取当前几号
        Integer curDay = data.getInteger("curDay");
        //读取daySignin 转jsonArray
        JSONArray daySignins = data.getJSONArray("daySignin");
        //几号-1等于 数组下标 转 jsonObj
        JSONObject daySignin = daySignins.getJSONObject(curDay - 1);
        //连续签到期日
        String continuousSignin = daySignin.getString("continuousSignin");

        //判断是否签到成功如果Msg.get("status") = 200 成功 400失败
        // 利用Server酱 推送签到状态到微信

        String text = null;
        String desp = null;

        try {
            switch (signinNewJsonObj.getInteger("status")) {
                case 200: {
                    String coupons = signinNewJsonObj.getString("coupons");
                    text = "主人，我已经帮你吧<" + nick + ">这个账号签到了呢~~~";
                    desp = "(๑•̀ㅂ•́)و✧本次签到获得了" + coupons + "代券，今天是"+MonthS+"月"+curDay+"号，已经连续签到了"+continuousSignin+"天~";
                    ServerChanUtli.ServerChan(key, text, desp);
                    System.out.println(text + desp);
                    break;
                }
                case 400: {
                    String error = signinNewJsonObj.getString("msg");
                    text = "主人很抱歉<" + nick + ">签到失败了";
                    desp = "失败原因：" + error+"，今天是"+MonthS+"月"+curDay+"号，已经连续签到了"+continuousSignin+"天~";

                    ServerChanUtli.ServerChan(key, text, desp);
                    System.out.println("主人很抱歉<" + nick + ">签到失败了失败原因：" + error);
                    break;
                }
                default: {
                    String error = signinNewJsonObj.getString("msg");
                    text = "主人很抱歉<" + nick + ">签到失败了";
                    desp = "失败原因：" + error;
                    ServerChanUtli.ServerChan(key, text, desp);
                    System.out.println("主人很抱歉<" + nick + ">签到失败了失败原因：" + error);
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
