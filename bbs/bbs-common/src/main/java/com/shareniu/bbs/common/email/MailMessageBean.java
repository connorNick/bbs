package com.shareniu.bbs.common.email;


import com.shareniu.bbs.common.po.email.Attachment;
import com.shareniu.bbs.common.po.email.AttachmentPo;
import com.shareniu.bbs.common.po.email.MessagePo;
import com.shareniu.bbs.common.po.email.AttachmentBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 邮件内容
 *
 * Created by wzy on 2015/5/12.
 */
public class MailMessageBean implements MailMessage {
    private static final long serialVersionUID = 6333864013917010042L;

    private MessagePo mailMessagePo;

    public MailMessageBean(MessagePo mailMessagePo) {
        this.mailMessagePo = mailMessagePo;
    }

    @Override
    public String getTemplateId() {
        return mailMessagePo.getTemplateId();
    }

    @Override
    public String getSendName() {
        return mailMessagePo.getSendName();
    }

    @Override
    public String getFromAddress() {
        return mailMessagePo.getFromAddress();
    }

    @Override
    public String getPassword() {
        return mailMessagePo.getPassword();
    }

    @Override
    public String getCharset() {
        return mailMessagePo.getCharset();
    }

    @Override
    public List<String> getToAddresses() {
        return mailMessagePo.getToAddresses();
    }

    @Override
    public List<String> getCcAddresses() {
        return mailMessagePo.getCcAddresses();
    }

    @Override
    public List<String> getBcAddresses() {
        return mailMessagePo.getBcAddresses();
    }

    @Override
    public String getSubject() {
        return mailMessagePo.getSubject();
    }

    @Override
    public String getContent() {
        return mailMessagePo.getSubject();
    }

    @Override
    public String getHtmlContent() {
        return mailMessagePo.getHtmlContent();
    }

    @Override
    public Map<String, Object> getParams() {
        return mailMessagePo.getParams();
    }

    public List<Attachment> getAttachments() {
        if (this.mailMessagePo.getAttachmentList() != null && this.mailMessagePo.getAttachmentList().size() > 0) {
            List<Attachment> list = new ArrayList<Attachment>();
            for (AttachmentPo attachmentPo : this.mailMessagePo.getAttachmentList()) {
                AttachmentBean attachmentBean = new AttachmentBean(attachmentPo);
                list.add(attachmentBean);
            }
            return list;
        }
        return null;
    }

    /**
     * Sets new mailMessagePo.
     *
     * @param mailMessagePo New value of mailMessagePo.
     */
    public void setMailMessagePo(MessagePo mailMessagePo) {
        this.mailMessagePo = mailMessagePo;
    }

    /**
     * Gets mailMessagePo.
     *
     * @return Value of mailMessagePo.
     */
    public MessagePo getMailMessagePo() {
        return mailMessagePo;
    }
}
