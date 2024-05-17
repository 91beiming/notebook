package com.beiming.notebook.common.utils;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailUtil {
    private final JavaMailSender mailSender;
    private final MailProperties mailProperties;

    public MailUtil(JavaMailSender mailSender, MailProperties mailProperties) {
        this.mailSender = mailSender;
        this.mailProperties = mailProperties;
    }

    /**
     * 发送邮件
     *
     * @param toEmail         要发送的邮箱
     * @param sendDisplayName 展示的名称
     * @param subject         主题
     * @param content         内容
     * @param isHtml          是否是html
     */
    public boolean sendMail(String toEmail, String sendDisplayName, String subject, String content, boolean isHtml) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false);
            helper.setFrom(mailProperties.getUsername(), sendDisplayName);
            helper.setCc(toEmail); //抄送人
            helper.setSubject(subject);
            helper.setText(content, isHtml);
            mailSender.send(helper.getMimeMessage());
            log.info("发送邮件成功: {}", toEmail);
            return true;
        } catch (Exception e) {
            log.error("发送邮件失败: {}", toEmail, e);
            return false;
        }
    }
}
