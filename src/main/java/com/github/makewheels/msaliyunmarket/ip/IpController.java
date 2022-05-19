package com.github.makewheels.msaliyunmarket.ip;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("ip")
public class IpController {
    @Resource
    private IpService ipService;

    @PostMapping("query")
    public JSONObject query(@RequestBody JSONObject body) {
        return ipService.queryIp(body);
    }
}
