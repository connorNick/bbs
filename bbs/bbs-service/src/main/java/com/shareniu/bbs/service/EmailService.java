package com.shareniu.bbs.service;

import com.shareniu.bbs.common.po.email.MessagePo;

/**
 * 邮件发送服务接口
 *
 * Created by wzy on 2015/5/12.
 */
public interface EmailService {

    /**
     * 邮件发送接口
     *
     * @param mailMessagePo 邮件发送信息po
     * @return 发送结果
     */
    int sendEmail(MessagePo mailMessagePo);
}