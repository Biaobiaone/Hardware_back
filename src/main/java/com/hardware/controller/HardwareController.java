package com.hardware.controller;

import com.hardware.common.Result;
import com.hardware.entity.Hardware;
import com.hardware.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hardware")
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;

    @GetMapping("/list")
    public Result<List<Hardware>> list() {
        return Result.success(hardwareService.listAll());
    }
}
