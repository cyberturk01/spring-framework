package com.demo.repository;

import com.demo.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
