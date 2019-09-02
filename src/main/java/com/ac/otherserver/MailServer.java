package com.ac.otherserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 邮件服务
 * @author anchao
 */
@Component
@Slf4j
public class MailServer {

    /**
     * 发送方
     */
    @Value("${spring.mail.username}")
    private String from;

    private JavaMailSender javaMailSender;

    @Autowired(required=false)
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * 发送文本邮件
     *
     * @param to      接收方
     * @param subject 主题
     * @param text    内容
     */
    public void sendSimpleMail(String to, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        simpleMailMessage.setFrom(from);
        javaMailSender.send(simpleMailMessage);
        log.warn("文本邮件发送完成到-->{}完成", to);
    }


    /**
     * 发送HTML邮件
     *
     * @param to      接收方
     * @param subject 主题
     * @param text    内容
     */
    public void sendHTMLMail(String to, String subject, String text) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text, true);
            mimeMessageHelper.setFrom(from);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage()+"-->运行异常");
        }

        javaMailSender.send(mimeMessage);
        log.warn("HTML邮件发送完成到-->{}完成", to);
    }

    /**
     * 发送多个附件邮件
     *
     * @param to       接收方
     * @param subject  主题
     * @param text     内容
     * @param filePath 附件地址
     */
    public void sendAttachmentMail(String to, String subject, String text, String[] filePath)
            throws MessagingException, UnsupportedEncodingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, true);
        mimeMessageHelper.setFrom(from);

        Arrays.stream(filePath).forEach(f -> {
            try {
                FileSystemResource fileSystemResource = new FileSystemResource(new File(f));
                String fileName = fileSystemResource.getFilename();
                mimeMessageHelper.addAttachment(MimeUtility.encodeText(fileName, "UTF-8", "B"),
                fileSystemResource);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        });

        javaMailSender.send(mimeMessage);
        log.warn("附件邮件发送完成到-->{}完成", to);
    }

    /**
     * 发送图片邮件
     * @param to       接收方
     * @param subject  主题
     * @param text     内容
     * @param src 附件地址
     * @param id 附件id
     */
    public void sendImageMail(String to, String subject, String text, String src,String id)
            throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, true);
        mimeMessageHelper.setFrom(from);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(src));
        mimeMessageHelper.addInline(id,fileSystemResource);

        javaMailSender.send(mimeMessage);
        log.warn("图片邮件发送完成到-->{}完成", to);
    }

}
