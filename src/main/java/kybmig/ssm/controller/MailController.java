package kybmig.ssm.controller;

import kybmig.ssm.Utility;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Component
class AsyncTask {
    private final MailSender sender;
    private final MailProperties mailProperties;

    public AsyncTask(MailSender sender, MailProperties mailProperties) {
        this.sender = sender;
        this.mailProperties = mailProperties;
    }

    @Async
    public void sendMail(String address, String title, String content) {
        Utility.log("异步发送邮件函数");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailProperties.getUsername());
        mailMessage.setSubject(title);
        mailMessage.setTo(address);
        mailMessage.setText(content);
        try {
            sender.send(mailMessage);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}



@Controller
@RequestMapping("/mail")
public class MailController {

    private final MailSender sender;
    private final MailProperties mailProperties;

    private AsyncTask task;

    public MailController(MailSender sender, MailProperties mailProperties, AsyncTask task) {
        this.sender = sender;
        this.mailProperties = mailProperties;
        this.task = task;
    }



    @GetMapping("/index")
    public ModelAndView indexView() {
        return new ModelAndView("mail/index");
    }

    private void sendMail(String address, String title, String content) {
        Utility.log("同步发送邮件函数");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailProperties.getUsername());
        mailMessage.setSubject(title);
        mailMessage.setTo(address);
        mailMessage.setText(content);
        try {
            sender.send(mailMessage);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }


    @PostMapping("/send")
    @ResponseBody
    public String send(String address, String content, String title) {
        Utility.log("同步发送");
        if (address != null && title != null  && content != null) {
            Utility.log("同步发送之前");
            this.sendMail(address, title, content);
            Utility.log("同步发送结束");
            return "发送成功";
        } else {
            return "发送失败";
        }

    }

    @PostMapping("/send/async")
    @ResponseBody
    public String sendAsync(String address, String content, String title) {
        Utility.log("异步发送");
        if (address != null && title != null  && content != null) {
            Utility.log("异步发送之前");
            this.task.sendMail(address, title, content);
            Utility.log("异步发送结束");
            return "发送成功";
        } else {
            return "发送失败";
        }

    }
}
