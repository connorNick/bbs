package com.shareniu.bbs.controller;

import com.shareniu.bbs.common.common.EnumEmailType;
import com.shareniu.bbs.common.common.RedisMessageTypeEnum;
import com.shareniu.bbs.common.po.email.MessagePo;
import com.shareniu.bbs.redis.RedisClientTemplate;
import com.shareniu.bbs.service.EmailService;
import com.shareniu.bbs.utils.MyWebUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Created by Administrator on 2016/12/17 0017.
 */
public class CommonController {

    /**
     * 邮箱服务
     */
    @Autowired
    private EmailService emailService;

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    /**
     * 发送邮件
     *
     * @param email
     * @return
     */
    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(String email, HttpServletRequest request, HttpServletResponse response) {
       /* String emailCodeId = UUID.randomUUID().toString() + "emailCodeKey";
        MyWebUtils.addCookie(request, response, "emailCodeKey", emailCodeId);*/
        String randomString = getCharAndNumr(6);
        /*HashMap<String, Object> session = getEmailCodeSession(emailCodeId);
        if (session != null) {
            session.put(Constant.EMAILCODEVAL_REDIS_ATTR_NAME, randomString);
            redisSessionManager.setSession(session, Constant.EMAILCODE_REDIS_TIMEOUT);
        } else {
            storeEmailCodeSession(emailCodeId, randomString);
        }*/

        redisClientTemplate.set(RedisMessageTypeEnum.EMAIL.ordinal()+"_"+email,randomString,18000);
        MessagePo mailMessagePo = new MessagePo();
        //mailMessagePo.setTemplateId("/usercenter/emailCode.ftl");
        mailMessagePo.addToAddress(email);
        mailMessagePo.setContent(randomString);
        mailMessagePo.setSubject("博纳优品邮箱验证码");
        mailMessagePo.setEmailType(EnumEmailType.HTML);
        mailMessagePo.setRealTime(true);
        mailMessagePo.setBusinessType("check");
        //mailMessagePo.addParam("sendTime", new Date());
       // mailMessagePo.addParam("emailCode", randomString);
        int i = emailService.sendEmail(mailMessagePo);
        if (i<1) {
            //"发送失败"
        }
        return "success";
    }
    /**
     * 校验效验码
     *
     * @return
     */
    @RequestMapping("/checkEmailCode")
    @ResponseBody
    public String checkEmailCode(HttpServletRequest request, String emailCode) {
        String emailCodeKey = MyWebUtils.getCookie(request, "emailCodeKey");
        if (!validateEmailCode(emailCodeKey, emailCode)) {
            return "success";
        }
        return "fail";
    }
    public boolean validateEmailCode(String emailCodeID, String emailCodeVal) {
        try {
            if (StringUtils.isEmpty(emailCodeID) || StringUtils.isBlank(emailCodeID)) {
                return false;
            }
            String code=redisClientTemplate.get(RedisMessageTypeEnum.EMAIL + "_" + emailCodeID, "0");
            if (code.equals("0")) {
                return false;
            }else if(code.equals(emailCodeVal)){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }


    public String getCharAndNumr(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) // 字符串
            {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) // 数字
            {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
