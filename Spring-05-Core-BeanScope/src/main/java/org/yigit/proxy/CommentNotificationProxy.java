package org.yigit.proxy;

import org.yigit.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
