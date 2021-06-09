package com.tdk.mybatisplus.demo.common.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.tdk.mybatisplus.demo",markerInterface = BaseMapper.class)
public class MybatisPlusConfig {

}