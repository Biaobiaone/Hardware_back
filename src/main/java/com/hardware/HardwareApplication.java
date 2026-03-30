package com.hardware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hardware.mapper")
public class HardwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(HardwareApplication.class, args);
    }

}
