package com.demo.repository;

import org.springframework.stereotype.Component;
import com.demo.model.Comment;

@Component
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
