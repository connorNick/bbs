package com.shareniu.bbs.common.email;

import java.io.Serializable;

import com.shareniu.bbs.common.util.SimpleAes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MailServer implements Serializable {
    private static final Log log = LogFactory.getLog(MailServer.class);
    private static final long serialVersionUID = -8444197225070840926L;
    private String host;
    private int port = 25;
    private int sslPort = 465;
    private boolean useSSL = false;
    private boolean startTls = true;
    private String userName;
    private String fromName;
    private String password;
    private int connectTimeout = 5000;
    private int socketTimeout = 10000;

    public MailServer() {
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getFromName() {
        return this.fromName;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setSslPort(int sslPort) {
        this.sslPort = sslPort;
    }

    public void setStartTls(boolean startTls) {
        this.startTls = startTls;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getPassword() {
        return this.password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public String getHost() {
        return this.host;
    }

    public void setPassword(String password) {
        try {
            this.password = new String(SimpleAes.decode(password));
        } catch (Exception var3) {
            log.warn("邮件密码未设置为密文");
        }

        this.password = password;
    }

    public int getSslPort() {
        return this.sslPort;
    }

    public boolean isStartTls() {
        return this.startTls;
    }

    public int getPort() {
        return this.port;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    public boolean isUseSSL() {
        return this.useSSL;
    }
}
