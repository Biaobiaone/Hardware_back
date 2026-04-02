package com.hardware.mapper;

import com.hardware.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select c.*, u.username as username " +
            "from comments c left join users u on c.user_id = u.id " +
            "where c.hardware_id = #{hardwareId} and c.status = 1 " +
            "order by c.id desc")
    List<Comment> selectByHardwareId(Long hardwareId);

    @Insert("insert into comments(user_id, hardware_id, type, content, parent_comment_id, likes, comment_time, status) " +
            "values(#{userId}, #{hardwareId}, 'general', #{content}, 0, 0, now(), 1)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertComment(Comment comment);
}
