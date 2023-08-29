package org.yigit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.yigit.config.ConfigProject;
import org.yigit.model.Comment;
import org.yigit.service.EmailCommentService;
import org.yigit.service.PushCommentService;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment= new Comment();
        comment.setAuthor("Mike Johnson");
        comment.setText("Set a Spring Framework");
        ApplicationContext context= new AnnotationConfigApplicationContext(ConfigProject.class);

        PushCommentService pushCommentService = context.getBean(PushCommentService.class);
        pushCommentService.publishComment(comment);

        EmailCommentService emailCommentService = context.getBean(EmailCommentService.class);
        emailCommentService.publishComment(comment);
    }
}
