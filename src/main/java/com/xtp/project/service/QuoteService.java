package com.xtp.project.service;

import com.xtp.project.common.QuoteMethod;
import com.xtp.project.configurer.XtpInfoConfigurer;
import com.xtp.project.core.ServiceException;
import com.xtp.project.service.impl.QuoteSpiImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class QuoteService {

    @Autowired
    private XtpInfoConfigurer xtpInfoConfigurer;
    private final Logger logger = LoggerFactory.getLogger(QuoteSpiImpl.class);

    public void login() {
        try {
            QuoteMethod.login(xtpInfoConfigurer.getClientId(), xtpInfoConfigurer.getLogFolder(),
                    xtpInfoConfigurer.getQuoteServerIp(), xtpInfoConfigurer.getQuoteServerPort(),
                    xtpInfoConfigurer.getAccount(), xtpInfoConfigurer.getUserPwd());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public void subscribeMarketData(String[] ticker, int count, int exchangeId) {
        try {
            QuoteMethod.subscribeMarketData(ticker, count, exchangeId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public void test() {
        QuoteMethod.test();
    }

    public void loginOut() {
        QuoteMethod.loginOut();
    }
}
