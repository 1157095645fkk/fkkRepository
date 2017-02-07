package cn.damai.beautiful_article.core.serviceutils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
@Service
public class SMSUtils {
    Logger logger = LoggerFactory.getLogger(SMSUtils.class);
    public  int send(String phone,String code) {
        String url = "http://gw.api.taobao.com/router/rest";
        //成为开发者，创建应用后系统自动生成
        String appkey = "23534937";
        String secret = "19a2d4b37b54ffa56158f823c25c2166";
        //短信模板的内容
        String json = "{code:\'"+code+"\'}";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");
        req.setSmsType("normal");
        req.setSmsFreeSignName("隔帘惟小赋");
        req.setSmsParamString(json);
        req.setRecNum(phone);
        req.setSmsTemplateCode("SMS_26215158");
        try {
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
            System.out.println(rsp.getBody());
            logger.info(rsp.getBody());
            JSONObject jsonObject = JSONObject.parseObject(rsp.getBody());
            JSONObject jsonObject1 =  jsonObject.getJSONObject("alibaba_aliqin_fc_sms_num_send_response");
            JSONObject jsonObject2 = (JSONObject) jsonObject1.get("result");
            int result = jsonObject2.getInteger("err_code");
            return  result;
        } catch (Exception e) {
            // TODO: handle exception
            return -1;
        }
    }
}
