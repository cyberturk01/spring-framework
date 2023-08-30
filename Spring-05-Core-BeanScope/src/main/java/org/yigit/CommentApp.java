package org.yigit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.yigit.config.ConfigProject;
import org.yigit.model.Comment;
import org.yigit.service.EmailCommentService;
import org.yigit.service.PushCommentService;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Mike Johnson");
        comment.setText("Set a Spring Framework");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigProject.class);

        EmailCommentService ecs1 = context.getBean(EmailCommentService.class);
        EmailCommentService ecs2 = context.getBean(EmailCommentService.class);
        System.out.println(ecs1);
        System.out.println(ecs2);
        System.out.println(ecs1 == ecs2); //true both uses same objects because of singleton

        PushCommentService pcs1 = context.getBean(PushCommentService.class);
        PushCommentService pcs2 = context.getBean(PushCommentService.class);
        System.out.println(pcs1);
        System.out.println(pcs2);
        System.out.println(pcs1 == pcs2); //false both uses different objects because of prototype
    }
}
