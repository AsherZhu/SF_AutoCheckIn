import service.CheckIn;
import service.impl.CheckInImpl;
import sun.applet.Main;
import util.ProcessCookie;

import java.util.HashMap;

/**
 * \* By:zhushuai.net@gmail.com
 * \* Date:2017/12/7 23:07
 * \
 */
public class Entrance {
    public static void main(String[] args) {
        String url = "http://book.sfacg.com/ajax/ashx/Common.ashx?op=signinNew&nid=0&_=";
        String cookie = "UM_distinctid=15f186efe792b6-0724e1fc5e0cb-c303767-1fa400-15f186efe7a181; _uab_collina=150880910196198154171265; _umdata=85957DF9A4B3B3E8B00A3E8DF81E8F3BCED4D3AE3E490B32E466140690946EE889D2E259F6D36C1FCD43AD3E795C914C2F66C17A5F0B5E1ABFBC76ADB2F6B8E2; bdshare_firstime=1511775810828; middle7=1; .SFCommunity=6C5F76488419AEE418ACAEB9219CA947AC637C2C611BF466269AB7D31BF68C1DE4FD8C30EF8E64ABD01BD5A154146FBFCCC5B14943B58E9A00C4287569A325679AC545A1172D641B835BFF5D89710D5243D63F5F7F085F515B8862CAB151863A; nickNameCookie=A11D9FC7E9CC8257; dnt=userid=4039244&password=1QtI%2fBEJwPzZ667QVVyp1F9QFgb0Xg0gMfgOZ1XQXooFVOeKz8bHNw%3d%3d&avatar=avatars%2fcommon%2f0.gif&tpp=0&ppp=0&pmsound=0&invisible=0&referer=index.aspx&sigstatus=0&expires=21600; Hm_lvt_a65b5d586d8be74ad13b8eb8f8193076=1510293208,1512618003; CNZZDATA30013274=cnzz_eid%3D867432095-1507942049-%26ntime%3D1512655283; Hm_lvt_c35b1f7e895951a1c3dea9225e12ac63=1512649828,1512649839,1512659289,1512659292; Hm_lpvt_c35b1f7e895951a1c3dea9225e12ac63=1512659292";

//        HashMap hashMap = ProcessCookie.getCookie(cookie);
//        System.out.println(hashMap.toString());
//        System.out.println(hashMap.get("dnt"));

        CheckIn checkIn = new CheckInImpl();
        checkIn.checkIn(url, ProcessCookie.getCookie(cookie));
    }
}