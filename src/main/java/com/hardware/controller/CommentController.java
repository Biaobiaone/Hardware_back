package com.hardware.controller;

import com.hardware.common.Result;
import com.hardware.entity.Comment;
import com.hardware.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public Result<List<Comment>> list(@RequestParam Long hardwareId) {
        return Result.success(commentService.getCommentsByHardwareId(hardwareId));
    }

    @PostMapping("/add")
    public Result<Object> add(@RequestBody Comment comment, HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        String username = (String) request.getAttribute("username");
        
        if (comment.getHardwareId() == null || comment.getContent() == null || comment.getContent().trim().isEmpty()) {
            return Result.error("硬件ID或评论内容不能为空");
        }
        
        comment.setUserId(userId);
        comment.setUsername(username);
        commentService.addComment(comment);
        
        return Result.success();
    }
}
