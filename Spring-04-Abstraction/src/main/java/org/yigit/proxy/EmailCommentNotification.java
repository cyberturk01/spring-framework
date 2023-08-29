package org.yigit.proxy;

import org.yigit.model.Comment;

public class EmailCommentNotification implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending Notification Comment:" + comment.getText());
    }
}
