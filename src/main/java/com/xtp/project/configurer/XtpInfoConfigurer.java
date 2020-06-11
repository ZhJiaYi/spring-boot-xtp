package com.xtp.project.configurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:xtp.properties"})
public class XtpInfoConfigurer {

    @Value("${inner}")
    private int inner;
    @Value("${client.id}")
    private short clientId;
    @Value("${server.key}")
    private String serverKey;
    @Value("${log.folder}")
    private String logFolder;
    @Value("${trade.server.ip}")
    private String tradeServerIp;
    @Value("${trade.server.port}")
    private int tradeServerPort;
    @Value("${user.account}")
    private String account;
    @Value("${user.pwd}")
    private String userPwd;
    @Value("${trade.transfer.protocol}")
    private String tradeTransferProtocol;
    @Value("${quote.server.ip}")
    private String quoteServerIp;
    @Value("${quote.server.port}")
    private int quoteServerPort;
    @Value("${quote.transfer.protocol}")
    private String quoteTransferProtocol;
    @Value("${udp.buffer.size}")
    private int udpBufferSize;

    public int getInner() {
        return inner;
    }

    public void setInner(int inner) {
        this.inner = inner;
    }

    public String getServerKey() {
        return serverKey;
    }

    public void setServerKey(String serverKey) {
        this.serverKey = serverKey;
    }

    public String getLogFolder() {
        return logFolder;
    }

    public void setLogFolder(String logFolder) {
        this.logFolder = logFolder;
    }

    public String getTradeServerIp() {
        return tradeServerIp;
    }

    public void setTradeServerIp(String tradeServerIp) {
        this.tradeServerIp = tradeServerIp;
    }

    public int getTradeServerPort() {
        return tradeServerPort;
    }

    public void setTradeServerPort(int tradeServerPort) {
        this.tradeServerPort = tradeServerPort;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getTradeTransferProtocol() {
        return tradeTransferProtocol;
    }

    public void setTradeTransferProtocol(String tradeTransferProtocol) {
        this.tradeTransferProtocol = tradeTransferProtocol;
    }

    public String getQuoteServerIp() {
        return quoteServerIp;
    }

    public void setQuoteServerIp(String quoteServerIp) {
        this.quoteServerIp = quoteServerIp;
    }

    public int getQuoteServerPort() {
        return quoteServerPort;
    }

    public void setQuoteServerPort(int quoteServerPort) {
        this.quoteServerPort = quoteServerPort;
    }

    public String getQuoteTransferProtocol() {
        return quoteTransferProtocol;
    }

    public void setQuoteTransferProtocol(String quoteTransferProtocol) {
        this.quoteTransferProtocol = quoteTransferProtocol;
    }

    public int getUdpBufferSize() {
        return udpBufferSize;
    }

    public void setUdpBufferSize(int udpBufferSize) {
        this.udpBufferSize = udpBufferSize;
    }

    public short getClientId() {
        return clientId;
    }

    public void setClientId(short clientId) {
        this.clientId = clientId;
    }
}
