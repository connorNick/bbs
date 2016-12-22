package com.shareniu.bbs.common.email;

import com.shareniu.bbs.common.po.email.Attachment;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface MailMessage extends Serializable {
    String getTemplateId();

    String getSendName();

    String getFromAddress();

    String getPassword();

    String getCharset();

    List<String> getToAddresses();

    List<String> getCcAddresses();

    List<String> getBcAddresses();

    String getSubject();

    String getContent();

    String getHtmlContent();

    Map<String, Object> getParams();

    List<Attachment> getAttachments();
}
