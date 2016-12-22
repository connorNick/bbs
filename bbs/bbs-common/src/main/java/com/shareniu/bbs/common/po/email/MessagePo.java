package com.shareniu.bbs.common.po.email;

import com.shareniu.bbs.common.common.EnumEmailType;
import com.shareniu.bbs.common.po.email.AttachmentPo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public class MessagePo {
    /**
     * 模板id
     */
    private String templateId;

    /**
     * 邮件类型
     */
    private EnumEmailType emailType = EnumEmailType.HTML;

    /**
     * 是否实时
     *
     * 根据业务情况定
     */
    private Boolean realTime;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 发送人姓名，可为空，为空默认使用系统发送人姓名
     */
    private String sendName;

    /**
     * 发送人邮件地址，可为空，为空默认使用系统发送邮箱
     */
    private String fromAddress;

    /**
     * 发送人邮件密码，可为空，为空使用系统邮箱密码
     */
    private String password;

    /**
     * 邮件编码
     */
    private String charset = "gbk";

    /**
     * 收件人地址
     */
    private List<String> toAddresses;

    /**
     * 抄送人地址
     */
    private List<String> ccAddresses;

    /**
     * 密送人地址
     */
    private List<String> bcAddresses;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件文本内容
     */
    private String content;

    /**
     * 邮件html内容
     */
    private String htmlContent;

    /**
     * 模板参数
     */
    private Map<String, Object> params;

    /**
     * 附件
     */
    private List<AttachmentPo> attachmentList;


    public void addToAddress(String toAddress) {
        if (this.toAddresses == null) {
            this.toAddresses = new ArrayList<String>();
        }

        this.toAddresses.add(toAddress);
    }

    public void addCcAddress(String ccAddress) {
        if (this.ccAddresses == null) {
            this.ccAddresses = new ArrayList<String>();
        }

        this.ccAddresses.add(ccAddress);
    }

    public void addBcAddress(String bcAddress) {
        if (this.bcAddresses == null) {
            this.bcAddresses = new ArrayList<String>();
        }

        this.bcAddresses.add(bcAddress);
    }

    public void addParam(String key, Object value) {
        if (this.params == null) {
            this.params = new HashMap<String, Object>();
        }

        this.params.put(key, value);
    }

    public void addAttachment(AttachmentPo attachment) {
        if (this.attachmentList == null) {
            this.attachmentList = new ArrayList<AttachmentPo>();
        }

        this.attachmentList.add(attachment);
    }

    /**
     * Gets 密送人地址.
     *
     * @return Value of 密送人地址.
     */
    public List<String> getBcAddresses() {
        return bcAddresses;
    }

    /**
     * Sets new 邮件主题.
     *
     * @param subject New value of 邮件主题.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Sets new 邮件文本内容.
     *
     * @param content New value of 邮件文本内容.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Sets new 邮件类型.
     *
     * @param emailType New value of 邮件类型.
     */
    public void setEmailType(EnumEmailType emailType) {
        this.emailType = emailType;
    }

    /**
     * Gets 收件人地址.
     *
     * @return Value of 收件人地址.
     */
    public List<String> getToAddresses() {
        return toAddresses;
    }

    /**
     * Sets new 附件.
     *
     * @param attachmentList New value of 附件.
     */
    public void setAttachmentList(List<AttachmentPo> attachmentList) {
        this.attachmentList = attachmentList;
    }

    /**
     * Sets new 发送人邮件密码，可为空，为空使用系统邮箱密码.
     *
     * @param password New value of 发送人邮件密码，可为空，为空使用系统邮箱密码.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets new 收件人地址.
     *
     * @param toAddresses New value of 收件人地址.
     */
    public void setToAddresses(List<String> toAddresses) {
        this.toAddresses = toAddresses;
    }

    /**
     * Gets 附件.
     *
     * @return Value of 附件.
     */
    public List<AttachmentPo> getAttachmentList() {
        return attachmentList;
    }

    /**
     * Gets 是否实时
     * <p/>
     * 根据业务情况定.
     *
     * @return Value of 是否实时
     * <p/>
     * 根据业务情况定.
     */
    public Boolean getRealTime() {
        return realTime;
    }

    /**
     * Sets new 模板参数.
     *
     * @param params New value of 模板参数.
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    /**
     * Gets 模板参数.
     *
     * @return Value of 模板参数.
     */
    public Map<String, Object> getParams() {
        return params;
    }

    /**
     * Gets 邮件编码.
     *
     * @return Value of 邮件编码.
     */
    public String getCharset() {
        return charset;
    }

    /**
     * Gets 业务类型.
     *
     * @return Value of 业务类型.
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * Gets 邮件文本内容.
     *
     * @return Value of 邮件文本内容.
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets 发送人邮件地址，可为空，为空默认使用系统发送邮箱.
     *
     * @return Value of 发送人邮件地址，可为空，为空默认使用系统发送邮箱.
     */
    public String getFromAddress() {
        return fromAddress;
    }

    /**
     * Gets 邮件类型.
     *
     * @return Value of 邮件类型.
     */
    public EnumEmailType getEmailType() {
        return emailType;
    }

    /**
     * Sets new 模板id.
     *
     * @param templateId New value of 模板id.
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * Sets new 发送人姓名，可为空，为空默认使用系统发送人姓名.
     *
     * @param sendName New value of 发送人姓名，可为空，为空默认使用系统发送人姓名.
     */
    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    /**
     * Gets 抄送人地址.
     *
     * @return Value of 抄送人地址.
     */
    public List<String> getCcAddresses() {
        return ccAddresses;
    }

    /**
     * Gets 发送人姓名，可为空，为空默认使用系统发送人姓名.
     *
     * @return Value of 发送人姓名，可为空，为空默认使用系统发送人姓名.
     */
    public String getSendName() {
        return sendName;
    }

    /**
     * Gets 模板id.
     *
     * @return Value of 模板id.
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * Sets new 邮件编码.
     *
     * @param charset New value of 邮件编码.
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * Sets new 密送人地址.
     *
     * @param bcAddresses New value of 密送人地址.
     */
    public void setBcAddresses(List<String> bcAddresses) {
        this.bcAddresses = bcAddresses;
    }

    /**
     * Sets new 抄送人地址.
     *
     * @param ccAddresses New value of 抄送人地址.
     */
    public void setCcAddresses(List<String> ccAddresses) {
        this.ccAddresses = ccAddresses;
    }

    /**
     * Gets 发送人邮件密码，可为空，为空使用系统邮箱密码.
     *
     * @return Value of 发送人邮件密码，可为空，为空使用系统邮箱密码.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets new 是否实时
     * <p/>
     * 根据业务情况定.
     *
     * @param realTime New value of 是否实时
     *                 <p/>
     *                 根据业务情况定.
     */
    public void setRealTime(Boolean realTime) {
        this.realTime = realTime;
    }

    /**
     * Sets new 发送人邮件地址，可为空，为空默认使用系统发送邮箱.
     *
     * @param fromAddress New value of 发送人邮件地址，可为空，为空默认使用系统发送邮箱.
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    /**
     * Sets new 业务类型.
     *
     * @param businessType New value of 业务类型.
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * Sets new 邮件html内容.
     *
     * @param htmlContent New value of 邮件html内容.
     */
    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    /**
     * Gets 邮件html内容.
     *
     * @return Value of 邮件html内容.
     */
    public String getHtmlContent() {
        return htmlContent;
    }

    /**
     * Gets 邮件主题.
     *
     * @return Value of 邮件主题.
     */
    public String getSubject() {
        return subject;
    }
}
