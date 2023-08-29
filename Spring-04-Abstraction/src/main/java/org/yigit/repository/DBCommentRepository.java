package org.yigit.repository;

import org.yigit.model.Comment;

public class DBCommentRepository implements  CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
