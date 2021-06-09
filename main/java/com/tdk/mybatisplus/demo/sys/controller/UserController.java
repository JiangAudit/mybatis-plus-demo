package com.tdk.mybatisplus.demo.sys.controller;

import com.tdk.mybatisplus.demo.sys.service.UserService;
import com.tdk.mybatisplus.demo.sys.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tdk.mybatisplus.demo.common.entity.Query;
import com.tdk.mybatisplus.demo.common.entity.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author tdk
 * @since 2021-05-18
 */
@Slf4j
@Api(tags = "用户表")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    public UserService userService;

    @ApiOperation(value = "用户表新增")
    @PostMapping("/save")
    public Result<Long> save(@RequestBody User user){
        userService.save(user);
        return Result.success(user.getId());
    }

    @ApiOperation(value = "用户表按id删除")
    @PostMapping("/delete/{id}")
    public Result<Long> delete(@PathVariable("id") Long id){
        userService.removeById(id);
        return Result.success(id);
    }
    
    @ApiOperation(value = "用户表按id修改")
    @PostMapping("/update/{id}")
    public Result<Long> update(@PathVariable("id") Long id, @RequestBody User user){
        user.setId(id);
        userService.updateById(user);
        return Result.success(user.getId());
    }

    @ApiOperation(value = "用户表按id查询")
    @GetMapping("/get/{id}")
    public Result<User> get(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return Result.success(user);
    }
 
    @ApiOperation(value = "用户表条件查询带分页")
    @PostMapping("/list")
    public Result<IPage<User>> list(@RequestBody Query<User> userQuery){
        Long pageNum=userQuery.getPageNum();
        Long pageSize=userQuery.getPageSize();
        User user=userQuery.getCondition();
        IPage<User> userList = userService.page(new Page<>(pageNum, pageSize), new QueryWrapper<>(user));
        return Result.success(userList);
    }

}
