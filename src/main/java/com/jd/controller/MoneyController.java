package com.jd.controller;

import com.alibaba.fastjson.JSONObject;
import com.jd.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("money")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String findMoneyById(int id) {
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("data", moneyService.selectMoneyById(id));
        return result.toString();
        //return moneyService.selectMoneyById(id);
    }
}
