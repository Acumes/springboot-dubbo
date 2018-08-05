package com.htf.api.service;

import com.htf.api.po.SysUser;
import com.htf.api.vo.request.SysUserRequest;
import com.htf.api.vo.response.SysUserResponse;
import com.htf.api.vo.response.SysUserResult;

/**
 * @author acumes
 * @date 2018/8/1 16:00
 */
public interface ISysUserService {
    void addUser(SysUserRequest user);

    void updateUser(SysUserRequest user, Integer id);

    SysUserResponse searchUser(Integer id);

    SysUserResult searchUsers();

    SysUser getUserByUsername(String loginName);
}
