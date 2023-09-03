package com.demo;

import com.demo.model.Comment;
import com.demo.service.EmailCommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Mike Johnson");
        comment.setText("Set a Spring Framework");
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        EmailCommentService emailCommentService = context.getBean(EmailCommentService.class);
        emailCommentService.publishComment(comment);
    }

}
