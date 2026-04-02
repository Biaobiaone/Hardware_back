package com.hardware.mapper;

import com.hardware.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("select id, identity, username, password, last_login_time from users where username = #{username} limit 1")
    User selectByUsername(String username);

    @Insert("insert into users(identity, username, password) values(#{identity}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    @Update("update users set last_login_time = now() where id = #{id}")
    int updateLastLoginTime(Long id);
}
