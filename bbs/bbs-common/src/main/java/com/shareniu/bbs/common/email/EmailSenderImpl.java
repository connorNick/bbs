package com.shareniu.bbs.common.email;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import javax.activation.FileTypeMap;
import javax.mail.util.ByteArrayDataSource;

import com.shareniu.bbs.common.po.email.Attachment;
import com.shareniu.bbs.common.util.Base64Util;
import com.shareniu.bbs.common.util.EmailUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

public class EmailSenderImpl extends AbstractEmailSender {
    private static final Log log = LogFactory.getLog(EmailSenderImpl.class);

    public EmailSenderImpl() {
    }

    public void htmlSend(MailMessage mailMessage) throws Exception {
        try {
            String e = mailMessage.getHtmlContent();
            if(e == null) {
                throw new NullPointerException("邮件发送内容为null");
            } else {
                HtmlEmail htmlEmail = new HtmlEmail();
                this.init(htmlEmail, mailMessage);
                if(EmailUtils.isNotEmpty(mailMessage.getAttachments())) {
                    this.addAttach(htmlEmail, mailMessage);
                }

                htmlEmail.setSubject(mailMessage.getSubject());
                htmlEmail.setMsg(mailMessage.getContent() == null?"":mailMessage.getContent());
                htmlEmail.setHtmlMsg(e);
                String messageId = htmlEmail.send();
                if(log.isDebugEnabled()) {
                    log.debug("邮件发送结果id = " + messageId);
                }


            }
        } catch (Exception var6) {
            log.error("邮件发送异常", var6);
            this.writeAttach(mailMessage.getAttachments());
            throw new Exception(var6);
        }
    }

    private void addAttach(MultiPartEmail email, MailMessage mailMessage) throws UnsupportedEncodingException, EmailException {
        Iterator i$ = mailMessage.getAttachments().iterator();

        while(i$.hasNext()) {
            Attachment attachment = (Attachment)i$.next();
            EmailAttachment emailAttachment;
            if(StringUtils.isNotEmpty(attachment.getPath())) {
                emailAttachment = new EmailAttachment();
                emailAttachment.setDescription("=?" + mailMessage.getCharset() + "?B?" + Base64Util.encode(attachment.getDescription(), mailMessage.getCharset()) + "?=");
                emailAttachment.setName("=?" + mailMessage.getCharset() + "?B?" + Base64Util.encode(attachment.getAttachName(), mailMessage.getCharset()) + "?=");
                emailAttachment.setDisposition("attachment");
                emailAttachment.setPath(attachment.getPath());
                email.attach(emailAttachment);
            } else if(attachment.getUrl() != null) {
                emailAttachment = new EmailAttachment();
                emailAttachment.setDescription("=?" + mailMessage.getCharset() + "?B?" + Base64Util.encode(attachment.getDescription(), mailMessage.getCharset()) + "?=");
                emailAttachment.setName("=?" + mailMessage.getCharset() + "?B?" + Base64Util.encode(attachment.getAttachName(), mailMessage.getCharset()) + "?=");
                emailAttachment.setDisposition("attachment");
                emailAttachment.setURL(attachment.getUrl());
                email.attach(emailAttachment);
            } else if(attachment.getBytes() != null) {
                String contentType = FileTypeMap.getDefaultFileTypeMap().getContentType(attachment.getAttachName());
                ByteArrayDataSource dataSource = new ByteArrayDataSource(attachment.getBytes(), contentType);
                String name = "=?" + mailMessage.getCharset() + "?B?" + Base64Util.encode(attachment.getAttachName(), mailMessage.getCharset()) + "?=";
                String description = "=?" + mailMessage.getCharset() + "?B?" + Base64Util.encode(attachment.getDescription(), mailMessage.getCharset()) + "?=";
                email.attach(dataSource, name, description, "attachment");
            }
        }

    }

    private void writeAttach(List<Attachment> list) {
        if(list != null) {
            Iterator i$ = list.iterator();

            while(i$.hasNext()) {
                Attachment attachment = (Attachment)i$.next();
                if(attachment.getBytes() != null) {
                    attachment.writeBytesToFile();
                }
            }

        }
    }
}
