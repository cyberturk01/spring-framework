package org.yigit.proxy;

import org.springframework.stereotype.Component;
import org.yigit.model.Comment;

@Component
public class EmailCommentNotification implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending Notification Comment:" + comment.getText());
    }
}
