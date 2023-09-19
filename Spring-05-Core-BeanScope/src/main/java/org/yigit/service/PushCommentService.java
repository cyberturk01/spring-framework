package org.yigit.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.yigit.model.Comment;
import org.yigit.proxy.CommentNotificationProxy;
import org.yigit.repository.CommentRepository;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Lazy //creates when it is called the class otherwise doesn't instantiate(load) the class in the sprint container
public class PushCommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy notificationProxy;

    public PushCommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy notificationProxy) {
        this.commentRepository = commentRepository;
        this.notificationProxy = notificationProxy;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        notificationProxy.sendComment(comment);
    }
}
