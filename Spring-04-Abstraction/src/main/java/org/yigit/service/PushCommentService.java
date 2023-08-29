package org.yigit.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yigit.model.Comment;
import org.yigit.proxy.CommentNotificationProxy;
import org.yigit.repository.CommentRepository;

@Component
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
