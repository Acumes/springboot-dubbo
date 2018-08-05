package com.htf.controller;

import com.htf.api.service.ISysUserService;
import com.htf.api.vo.request.SysUserRequest;
import com.htf.api.vo.response.SysUserResponse;
import com.htf.api.vo.response.SysUserResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author acumes
 * @date 2018/8/1 16:22
 */
@RestController
@RequestMapping(value = "/users")
@Api(value = "users", description = "用户API")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "用户新增")
    @ApiImplicitParam(value = "user",dataType = "SysUserRequest",paramType = "SysUserRequest")
    public String addUser(@RequestBody SysUserRequest user){
        sysUserService.addUser(user);
        return "success";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    @ApiOperation(value = "用户修改")
    @ApiImplicitParam(value = "user",dataType = "SysUserRequest",paramType = "SysUserRequest")
    public String updateUser(@PathVariable Integer id,  @RequestBody SysUserRequest user){
        sysUserService.updateUser(user,id);
        return "success";
    }

    @RequestMapping(value = "/search/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "用户查询")
    @ApiImplicitParam(value = "id",dataType = "Integer",paramType = "Integer")
    public SysUserResponse searchUser(@PathVariable Integer id){
        SysUserResponse response = sysUserService.searchUser(id);
        return response;
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    @ApiOperation(value = "用户列表查询")
    @ApiImplicitParam(value = "id",dataType = "Integer",paramType = "Integer")
    public SysUserResult searchUser(){
        SysUserResult response = sysUserService.searchUsers();
        return response;
    }
}
