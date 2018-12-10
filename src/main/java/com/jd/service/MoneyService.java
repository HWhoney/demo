package com.jd.service;

import com.jd.bean.Money;
import com.jd.dao.MoneyDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class MoneyService {
    private static final Logger LOG= LoggerFactory.getLogger(MoneyService.class);
    @Autowired
    private MoneyDao moneyDao;

    public Money selectMoneyById(int id){
        LOG.info("selectMoneyById,{}",moneyDao.findMoneyById(id));
        return moneyDao.findMoneyById(id);
    }
}
