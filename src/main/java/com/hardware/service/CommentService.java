package com.hardware.service;

import com.hardware.entity.Comment;
import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByHardwareId(Long hardwareId);

    void addComment(Comment comment);
}
