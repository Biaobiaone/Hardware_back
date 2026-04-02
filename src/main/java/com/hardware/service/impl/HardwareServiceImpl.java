package com.hardware.service.impl;

import com.hardware.entity.Hardware;
import com.hardware.mapper.HardwareMapper;
import com.hardware.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardwareServiceImpl implements HardwareService {

    @Autowired
    private HardwareMapper hardwareMapper;

    @Override
    public List<Hardware> listAll() {
        return hardwareMapper.selectAll();
    }
}
