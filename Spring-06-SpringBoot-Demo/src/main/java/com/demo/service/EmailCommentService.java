package com.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.demo.model.Comment;
import com.demo.proxy.CommentNotificationProxy;
import com.demo.repository.CommentRepository;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class EmailCommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy notificationProxy;

    public EmailCommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy notificationProxy) {
        this.commentRepository = commentRepository;
        this.notificationProxy = notificationProxy;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        notificationProxy.sendComment(comment);
    }
}
