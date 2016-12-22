package com.shareniu.bbs.common.email;

import com.shareniu.bbs.common.util.EmailUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.Email;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractEmailSender implements EmailSender {
    private MailServer mailServer;

    public AbstractEmailSender() {
    }

    protected void init(Email email, MailMessage mailMessage) throws Exception {
        if(email == null) {
            throw new NullPointerException("邮件发送对象为空");
        } else {
            email.setHostName(this.mailServer.getHost());
            if(this.mailServer.isUseSSL()) {
                email.setSSLOnConnect(this.mailServer.isUseSSL());
                email.setSslSmtpPort(String.valueOf(this.mailServer.getSslPort()));
            } else {
                email.setSmtpPort(this.mailServer.getPort());
            }

            email.setSendPartial(false);
            email.setSocketConnectionTimeout(this.mailServer.getConnectTimeout());
            email.setSocketTimeout(this.mailServer.getSocketTimeout());
            if(this.mailServer.isStartTls()) {
                email.setStartTLSRequired(true);
                email.setStartTLSEnabled(true);
            }

            email.setCharset(mailMessage.getCharset());
            String senderName;
            if(StringUtils.isBlank(mailMessage.getSendName())) {
                senderName = this.mailServer.getFromName();
            } else {
                senderName = mailMessage.getSendName();
            }

            if(StringUtils.isBlank(mailMessage.getFromAddress()) && StringUtils.isBlank(mailMessage.getPassword())) {
                email.setAuthentication(this.mailServer.getUserName(), this.mailServer.getPassword());
                email.setFrom(this.mailServer.getUserName(), senderName);
                email.setBounceAddress(this.mailServer.getUserName());
            } else {
                email.setAuthentication(mailMessage.getFromAddress(), mailMessage.getPassword());
                email.setFrom(mailMessage.getFromAddress(), senderName);
                email.setBounceAddress(mailMessage.getFromAddress());
            }

            email.setTo(this.getAddressList(mailMessage.getToAddresses()));
            if(EmailUtils.isNotEmpty(mailMessage.getCcAddresses())) {
                email.setCc(this.getAddressList(mailMessage.getCcAddresses()));
            }

            if(EmailUtils.isNotEmpty(mailMessage.getBcAddresses())) {
                email.setBcc(this.getAddressList(mailMessage.getBcAddresses()));
            }

            email.setSentDate(new Date());
        }
    }

    private List<InternetAddress> getAddressList(List<String> list) throws Exception {
        if(EmailUtils.isEmpty(list)) {
            throw new Exception("convert address is null");
        } else {
            ArrayList addressList = new ArrayList();
            InternetAddress address = null;
            this.check(list);
            Iterator i$ = list.iterator();

            while(i$.hasNext()) {
                String str = (String)i$.next();
                address = new InternetAddress(str);
                addressList.add(address);
            }

            if(EmailUtils.isEmpty(addressList)) {
                throw new Exception("converted address is null");
            } else {
                return addressList;
            }
        }
    }

    protected void check(String email) throws Exception {
        if(email != null) {
            if(!EmailUtils.isEmail(email)) {
                throw new Exception("邮件地址格式不正确");
            }
        }
    }

    protected void check(List<String> emailList) throws Exception {
        if(emailList != null) {
            Iterator i$ = emailList.iterator();

            while(i$.hasNext()) {
                String email = (String)i$.next();
                this.check(email);
            }

        }
    }

    public void setMailServer(MailServer mailServer) {
        this.mailServer = mailServer;
    }
}
