import com.alibaba.fastjson.JSONObject;
import service.CheckIn;
import service.impl.CheckInImpl;
import util.AnalysisJsonUtil;
import util.GetPathUtil;
import util.ProcessCookie;

import java.util.HashMap;


/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/7 23:07
 * \
 */
public class Entrance {
    public static void main(String[] args) {
        String path = GetPathUtil.getPath()+"/Cookies.json";
        JSONObject jsonObject = AnalysisJsonUtil.AnalysisJson(path);

        for (String s : jsonObject.keySet()) {
            HashMap<String, String> hashMap = ProcessCookie.getCookie((String) jsonObject.get(s));

            CheckIn checkIn = new CheckInImpl();
            checkIn.checkIn(s,hashMap);

        }
    }
}
