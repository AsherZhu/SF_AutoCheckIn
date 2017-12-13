import com.alibaba.fastjson.JSONObject;
import service.CheckIn;
import util.AnalysisJsonUtil;
import util.GetPathUtil;
import util.ProcessCookieUtil;
import java.util.HashMap;


/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/7 23:07
 * \
 */
public class Entrance {
    public static void main(String[] args) {
        String path = GetPathUtil.getPath() + "/UserInfo.json";
        JSONObject userInfo = AnalysisJsonUtil.jsonFileToJsonObject(path);

        for (String nick : userInfo.keySet()) {

            JSONObject info = AnalysisJsonUtil.jsonStringToJsonObject(userInfo.getString(nick));

            HashMap cookie = ProcessCookieUtil.getCookie(info.getString("Cookie"));

            CheckIn.checkIn(nick, cookie, info.getString("SCKEY"));

        }
    }
}