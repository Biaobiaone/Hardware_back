package com.hardware.mapper;

import com.hardware.entity.Hardware;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HardwareMapper {

    @Select("select id, model, manufacturer, type from hardware order by id desc")
    List<Hardware> selectAll();
}
