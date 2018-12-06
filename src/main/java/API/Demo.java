package API;

import com.wxapi.WxApiCall.WxApiCall;
import com.wxapi.model.RequestModel;

import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        RequestModel model = new RequestModel();
        StringBuilder buffer=new StringBuilder("");
        model.setGwUrl("https://aiapi.jd.com/jdai/SnapshopAPI");
        model.setAppkey("b148a7f7cc27a4f336e75c83a3ada768");
        model.setSecretKey("c92d4ebd0d21a198af18bc53d7524eda");
        model.setBodyStr(buffer.toString());	//body参数
        Map queryMap = new HashMap();
        model.setQueryParams(queryMap);
        WxApiCall call = new WxApiCall();
        call.setModel(model);
        call.request();
    }
}