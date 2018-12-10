package com.jd.service;

import com.jd.bean.User;
import com.jd.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    private static final Logger LOG= LoggerFactory.getLogger(UserService.class) ;
    @Autowired
    private UserDao userDao;

    public User selectUserByName(String name){
        LOG.info("selectUserByName,{}",userDao.findUserByName(name));
        return userDao.findUserByName(name);
    }
}
