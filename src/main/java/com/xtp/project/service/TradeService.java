package com.xtp.project.service;

import com.xtp.project.common.TradeMethod;
import com.xtp.project.configurer.XtpInfoConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    @Autowired
    private XtpInfoConfigurer xtpInfoConfigurer;

    public void login() {
        TradeMethod.login(xtpInfoConfigurer.getTradeServerIp(), xtpInfoConfigurer.getTradeServerPort(),
                xtpInfoConfigurer.getAccount(), xtpInfoConfigurer.getUserPwd(), xtpInfoConfigurer.getClientId(),
                xtpInfoConfigurer.getServerKey(), xtpInfoConfigurer.getLogFolder());
    }

    public void loginOut() {
        TradeMethod.shutdown();
    }

    public void insertOrder() {
        TradeMethod.insertOrder();
    }
}
