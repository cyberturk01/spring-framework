package org.yigit.proxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yigit.model.Comment;

@Component
//@Primary
@Qualifier("EMAIL")
public class EmailCommentNotification implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending Notification for comment:" + comment.getText());
    }
}
