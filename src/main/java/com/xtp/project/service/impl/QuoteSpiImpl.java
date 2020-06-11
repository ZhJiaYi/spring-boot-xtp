package com.xtp.project.service.impl;

import com.zts.xtp.common.model.ErrorMessage;
import com.zts.xtp.quote.model.response.*;
import com.zts.xtp.quote.spi.QuoteSpi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuoteSpiImpl implements QuoteSpi {

    private final Logger logger = LoggerFactory.getLogger(QuoteSpiImpl.class);

    @Override
    /*
     当客户端与行情后台通信连接断开时，该方法被调用。
     reason	错误原因，请与错误代码表对应
     api不会自动重连，当断线发生时，请用户自行选择后续操作。
     可以在此函数中调用Login重新登录。注意用户重新登录后，需要重新订阅行情
     */
    public void onDisconnected(int reason) {
        logger.info("Disconnected:" + reason);
    }

    @Override
    public void onError(ErrorMessage errorMessage) {
        logger.error("error_id:" + errorMessage.getErrorId() + " error_msg:" + errorMessage.getErrorMsg());
    }

    @Override
    /*
    订阅行情应答，包括股票、指数和期权
     */
    public void onSubMarketData(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info(ticker.toString());
        } else {
            logger.error("onSubMarketData:" + errorMessage.getErrorMsg());
        }

    }

    @Override
    /*
    退订行情应答，包括股票、指数和期权
     */
    public void onUnSubMarketData(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info(ticker.toString());
        } else {
            logger.error("onUnSubMarketData:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onDepthMarketData(DepthMarketDataResponse depthMarketData, DepthMarketDataExResponse depthQuote) {
        logger.info(depthMarketData.toString());
        logger.info(depthQuote.toString());
    }

    @Override
    /*
    订阅行情订单簿应答，包括股票、指数和期权
     */
    public void onSubOrderBook(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info(ticker.toString());
        } else {
            logger.error("onSubOrderBook:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onUnSubOrderBook(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info(ticker.toString());
        } else {
            logger.error("onUnSubOrderBook:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onOrderBook(OrderBookResponse orderBook) {

    }

    @Override
    public void onSubTickByTick(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info(ticker.toString());
        } else {
            logger.error("onSubTickByTick:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onUnSubTickByTick(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info(ticker.toString());
        } else {
            logger.error("onUnSubTickByTick:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onTickByTickEntrust(int exchange_id, String ticker, long seq, long data_time, int type, int channel_no, long order_seq, double price, long qty, char side, char ord_type) {

    }

    @Override
    public void onTickByTickTrade(int exchange_id, String ticker, long seq, long data_time, int type, int channel_no, long order_seq, double price, long qty, double money, long bid_no, long ask_no, char trade_flag) {

    }

    @Override
    public void onSubscribeAllMarketData(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onSubscribeAllMarketData:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onUnSubscribeAllMarketData(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onUnSubscribeAllMarketData:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onSubscribeAllOrderBook(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onSubscribeAllOrderBook:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onUnSubscribeAllOrderBook(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onUnSubscribeAllOrderBook:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onSubscribeAllTickByTick(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onSubscribeAllTickByTick:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onUnSubscribeAllTickByTick(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onUnSubscribeAllTickByTick:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onQueryAllTickers(TickerInfoResponse tickerInfo, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("tickerInfo:" + tickerInfo);
        } else {
            logger.error("onQueryAllTickers:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onQueryTickersPriceInfo(TickerPriceInfoResponse tickerInfo, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("tickerInfo:" + tickerInfo);
        } else {
            logger.error("onQueryTickersPriceInfo:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onSubscribeAllOptionMarketData(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onSubscribeAllOptionMarketData:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onUnSubscribeAllOptionMarketData(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onUnSubscribeAllOptionMarketData:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onSubscribeAllOptionOrderBook(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onSubscribeAllOptionOrderBook:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onUnSubscribeAllOptionOrderBook(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onUnSubscribeAllOptionOrderBook:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onSubscribeAllOptionTickByTick(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onSubscribeAllOptionTickByTick:" + errorMessage.getErrorMsg());
        }
    }

    @Override
    public void onUnSubscribeAllOptionTickByTick(int exchangeId, ErrorMessage errorMessage) {
        if (errorMessage.getErrorId() == 0) {
            logger.info("exchangeId:" + exchangeId);
        } else {
            logger.error("onUnSubscribeAllOptionTickByTick:" + errorMessage.getErrorMsg());
        }
    }
}
