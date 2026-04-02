package com.hardware.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Comment {

    private Long id;

    private Long userId;

    private Long hardwareId;

    private String type;

    private String content;

    private Long parentCommentId;

    private Integer likes;

    private Date commentTime;

    private Integer status;

    // 非数据库字段，用于连表查询展示用户名
    private String username;
}
