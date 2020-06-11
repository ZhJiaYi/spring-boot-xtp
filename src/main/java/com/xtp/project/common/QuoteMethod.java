package com.xtp.project.common;

import com.xtp.project.core.ServiceException;
import com.xtp.project.service.impl.QuoteSpiImpl;
import com.zts.xtp.common.enums.JniLogLevel;
import com.zts.xtp.common.enums.TransferProtocol;
import com.zts.xtp.common.enums.XtpLogLevel;
import com.zts.xtp.common.jni.JNILoadLibrary;
import com.zts.xtp.quote.api.QuoteApi;

public class QuoteMethod {

    private static final QuoteApi QUOTE_API;
    private static final QuoteSpiImpl QUOTE_SPI;
    private static boolean loginFlag;

    static {
        JNILoadLibrary.loadLibrary();
        QUOTE_SPI = new QuoteSpiImpl();
        QUOTE_API = new QuoteApi(QUOTE_SPI);
    }

    public static void test() {
    }

    public static void login(short clientId, String logFolder, String ip, int port, String user, String password) {
        QUOTE_API.init(clientId, logFolder, XtpLogLevel.XTP_LOG_LEVEL_INFO, JniLogLevel.JNI_LOG_LEVEL_INFO);
        int loginResult = QUOTE_API.login(ip, port, user, password, TransferProtocol.XTP_PROTOCOL_TCP);
        loginFlag = (loginResult == 0);
    }

    public static void loginOut() {
        if (loginFlag) {
            QUOTE_API.logout();
            QUOTE_API.disconnect();
        }
    }

    /**
     * @param ticker     合约ID数组，注意合约代码必须以'\0'结尾，不包含空格
     * @param count      要订阅/退订行情的合约个数
     * @param exchangeId 交易所代码
     */
    public static void subscribeMarketData(String[] ticker, int count, int exchangeId) {
        try {
            QUOTE_API.subscribeMarketData(ticker, count, exchangeId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

    }
}
