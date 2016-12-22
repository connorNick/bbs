package com.shareniu.bbs.service.impl;

import com.shareniu.bbs.common.common.EnumEmailType;
import com.shareniu.bbs.common.email.EmailSender;
import com.shareniu.bbs.common.email.EmailSenderImpl;
import com.shareniu.bbs.common.email.MailMessageBean;
import com.shareniu.bbs.common.po.email.MessagePo;
import com.shareniu.bbs.common.util.CollectionUtil;
import com.shareniu.bbs.common.util.StringUtil;
import com.shareniu.bbs.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 邮件发送服务
 *
 * Created by wzy on 2015/5/12.
 */
@Service
public class EmailServiceImpl  implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailSenderImpl.class);

    private EmailSender emailSender=new EmailSenderImpl();

/*
    @Resource
    private TemplateReplace templateReplace;
*/

    /*@Autowired
    private MessageManager messageManager;*/


    /**
     * 邮件发送接口
     *
     * @param mailMessagePo 邮件发送信息po
     * @return 发送结果
     */
    public int sendEmail(MessagePo mailMessagePo) {

        boolean ok = checkParam(mailMessagePo);

        if (!ok) {
            return 0;
        }

        MailMessageBean mailMessageBean = new MailMessageBean(mailMessagePo);

        try {
            /*String content = emailTemplate.getTemplate(mailMessageBean.getTemplateId());
            content = templateReplace.replate(content, mailMessageBean.getParams());
*/
            if (EnumEmailType.HTML.compare(mailMessagePo.getEmailType().getCode())) {
                mailMessagePo.setHtmlContent(mailMessagePo.getContent());
            } else if (EnumEmailType.TEXT.compare(mailMessagePo.getEmailType().getCode())) {
                mailMessagePo.setContent(mailMessagePo.getContent());//content
            }
            emailSender.htmlSend(mailMessageBean);

        } catch (Exception e) {
            log.error("发送邮件异常", e);
        }

        return 1;
    }

    private boolean checkParam(MessagePo mailMessagePo) {
        /*if (StringUtil.isEmpty(mailMessagePo.getTemplateId())) {
            return false;
        }*/

        if (CollectionUtil.isEmpty(mailMessagePo.getToAddresses())) {
            return false;
        }

        if (StringUtil.isEmpty(mailMessagePo.getCharset())) {
            return false;
        }
        return true;
    }
}