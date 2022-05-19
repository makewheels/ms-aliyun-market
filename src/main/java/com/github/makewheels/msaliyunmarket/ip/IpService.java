package com.github.makewheels.msaliyunmarket.ip;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class IpService {
    /**
     * {"code":100,
     * "message":"success",
     * "ip":"61.166.161.143",
     * "result":
     * {"en_short":"CN",
     * "en_name":"China",
     * "nation":"中国","province":"云南省","city":"昆明市",
     * "district":"","adcode":"530100",
     * "lat":24.97406,"lng":102.63587}}
     */
    public JSONObject queryIp(JSONObject body) {
        String ip = body.getString("ip");
        String appCode = Base64.decodeStr("ZDc4MmQ4NTNkNmYzNDYxMjkzYTFkMWIxYWQ5ZWRiZjM=");
        String json = HttpUtil.createGet("https://ips.market.alicloudapi.com/iplocaltion?ip=" + ip)
                .header("Authorization", "APPCODE " + appCode).execute().body();
        return JSON.parseObject(json);
    }
}
