package com.xtp.project.common;

import com.xtp.project.service.impl.TradeSpiImpl;
import com.zts.xtp.common.enums.*;
import com.zts.xtp.common.jni.JNILoadLibrary;
import com.zts.xtp.trade.api.TradeApi;
import com.zts.xtp.trade.model.request.OrderInsertRequest;

public class TradeMethod {

    private static final TradeApi TRADE_API;
    private static final TradeSpiImpl TRADE_SPI;
    private static String sessionId;

    static {
        JNILoadLibrary.loadLibrary();
        TRADE_SPI = new TradeSpiImpl();
        TRADE_API = new TradeApi(TRADE_SPI);
    }

    public static void login(String ip, int port, String user, String password, short clientId, String key, String dataFolder) {
        TRADE_API.init(clientId, key, dataFolder, XtpLogLevel.XTP_LOG_LEVEL_INFO, JniLogLevel.JNI_LOG_LEVEL_INFO, XtpTeResumeType.XTP_TERT_RESTART);
        sessionId = TRADE_API.login(ip, port, user, password, TransferProtocol.XTP_PROTOCOL_TCP);
        System.out.println("login OMS result: " + sessionId);
    }

    public static boolean isLogin() {
        return (sessionId != null && !sessionId.equals("0"));
    }

    public static void shutdown() {
        TRADE_API.logout(sessionId);
        TRADE_API.disconnect();
    }

    //下单请求，返回的委托数据在TradeSpiImpl.onOrderEvent()里获得，成交数据在TradeSpiImpl.onTradeEvent()里获得
    public static void insertOrder() {
        System.out.println("testInsertOrder");
        OrderInsertRequest req = OrderInsertRequest.builder()
                .orderXtpId("0").orderClientId(13).ticker("000002").marketType(MarketType.XTP_MKT_SZ_A)
                .price(22.44).stopPrice(0).quantity(200).priceType(PriceType.XTP_PRICE_LIMIT)
                .sideType(SideType.XTP_SIDE_BUY).businessType(BusinessType.XTP_BUSINESS_TYPE_CASH).build();
        String orderXtpId = TRADE_API.insertOrder(req, sessionId);
        System.out.println("testInsertOrder orderXtpId: " + orderXtpId);
    }
}
