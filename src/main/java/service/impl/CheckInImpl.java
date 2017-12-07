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
        System.out.println(document.toString());

        return null;
    }
}
