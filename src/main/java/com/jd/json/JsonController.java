package com.jd.json;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class JsonController {
    @ResponseBody
    @RequestMapping(value = "/body/data", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String writeByBody(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam);
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "@ResponseBody");
        result.put("data", jsonParam);
        return result.toString();
    }

    @RequestMapping(value = "/resp/data", method = RequestMethod.POST)
    public void writeByResp(@RequestBody JSONObject jsonParam, HttpServletResponse resp) {
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "HttpServletResponse");
        result.put("data", jsonParam);

        this.writeJson(resp, result);//写json数据到客户端

    }

    private static final Logger LOG = LoggerFactory.getLogger(JsonController.class);

    public void writeJson(HttpServletResponse resp, JSONObject json) {
        PrintWriter out = null;
        //设定格式为json内容
        resp.setContentType("application/json;charset=UTF-8");
        try {
            out = resp.getWriter();
            //写到客户端
            out.write(json.toString());
            out.flush();
        } catch (IOException e) {
            LOG.error("json输出失败，{}", e.getMessage());

        } finally {
            if (null != out) {
                out.close();
            }
        }


    }
}
