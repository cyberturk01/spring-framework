package org.yigit.repository;

import org.springframework.stereotype.Component;
import org.yigit.model.Comment;

@Component
public class DBCommentRepository implements  CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
