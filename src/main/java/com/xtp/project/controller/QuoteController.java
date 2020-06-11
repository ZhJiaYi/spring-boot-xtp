package com.xtp.project.controller;

import com.xtp.project.configurer.XtpInfoConfigurer;
import com.xtp.project.core.Result;
import com.xtp.project.core.ResultGenerator;
import com.xtp.project.service.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private XtpInfoConfigurer xtpInfoConfigurer;
    private final Logger logger = LoggerFactory.getLogger(QuoteController.class);

    @RequestMapping("/login")
    public void login() {
        logger.info("user:" + xtpInfoConfigurer.getAccount() +
                " time:" + (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).
                format(System.currentTimeMillis()));
        quoteService.login();
    }

    @RequestMapping("/subscribeMarketData")
    public Result subscribeMarketData(@RequestParam String[] ticker,
                                      @RequestParam int count,
                                      @RequestParam int exchangeId) {
        quoteService.subscribeMarketData(new String[]{"600000"}, count, exchangeId);
        return ResultGenerator.getSuccessResult();
    }

    @RequestMapping("/test")
    public void test() {
        quoteService.test();
    }
}
