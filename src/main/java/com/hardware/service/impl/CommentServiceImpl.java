package com.hardware.service.impl;

import com.hardware.entity.Comment;
import com.hardware.mapper.CommentMapper;
import com.hardware.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentsByHardwareId(Long hardwareId) {
        return commentMapper.selectByHardwareId(hardwareId);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.insertComment(comment);
    }
}
