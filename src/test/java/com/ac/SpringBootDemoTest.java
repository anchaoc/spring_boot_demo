package com.ac;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * @author anchao
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringBootDemoTest {
////
////    @Autowired
////    private TemplateEngine templateEngine;
////
////    @Autowired
////    private MailServer mailServer;
//
////    @Test
////    public void test() throws MessagingException, UnsupportedEncodingException {
////        String id ="new_001";
////        String text ="<html>\n"+
////                "<body>\n"+
////                "<h4>hello world，这是一封含图片邮件:</h4><img src=\'cid:"+id+"\'/>"+
////                "</body>\n</html>";
////        String to ="13182370572@163.com";
////        String subject ="来自JAVA_MAIL";
////        String filePath ="D:/资料/images/手捧花.jpg";
////
////        mailServer.sendImageMail(to,subject,text,filePath,id);
////    }
//
////    @Test
////    public void test2(){
////        Context context = new Context();
////        context.setVariable("id","007");
////        String emailTemplate = templateEngine.process("emailTemplate", context);
////
////        String to ="13182370572@163.com";
////        String subject ="这是一个模板邮件";
////
////        mailServer.sendHTMLMail(to,subject,emailTemplate);
////    }
//
//
//
//}
