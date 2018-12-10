package com.jd.controller;

import com.alibaba.fastjson.JSONObject;
import com.jd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String findUserByName(String name) {

        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("data", userService.selectUserByName(name).getAge());
        return result.toString();
        //return userService.selectUserByName(name);
    }

}
