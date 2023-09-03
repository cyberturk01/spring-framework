package com.demo.proxy;

import com.demo.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
