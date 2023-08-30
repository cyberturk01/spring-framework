package org.yigit.repository;

import org.yigit.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
