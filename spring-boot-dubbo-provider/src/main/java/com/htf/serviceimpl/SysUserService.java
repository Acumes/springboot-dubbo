package com.htf.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.htf.api.po.SysUser;
import com.htf.api.service.ISysUserService;
import com.htf.api.vo.request.SysUserRequest;
import com.htf.api.vo.response.SysUserResponse;
import com.htf.api.vo.response.SysUserResult;
import com.htf.dao.ISysUserDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acumes
 * @date 2018/8/1 16:01
 */
@Service
@Transactional
public class SysUserService implements ISysUserService {
    @Autowired
    private ISysUserDao sysUserDao;
    @Override
    public void addUser(SysUserRequest user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user,sysUser);
        sysUserDao.insert(sysUser);
    }

    @Override
    public void updateUser(SysUserRequest user, Integer id) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user,sysUser);
        sysUser.setId(id);
        sysUserDao.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public SysUserResponse searchUser(Integer id) {
        SysUser sysUser = sysUserDao.selectByPrimaryKey(id);
        if(sysUser != null){
            SysUserResponse response = new SysUserResponse();
            BeanUtils.copyProperties(sysUser,response);
            return response;
        }
        return null;
    }

    @Override
    public SysUserResult searchUsers() {
        SysUserResult result = new SysUserResult();
        Page<SysUser> page = PageHelper.startPage(1,20,true);
        List<SysUser> results = sysUserDao.searchUsers();
        List<SysUserResponse> responses = new ArrayList<>();
        if(results.size() != 0){
            results.forEach(item -> {
                SysUserResponse response = new SysUserResponse();
                BeanUtils.copyProperties(item,response);
                responses.add(response);
            });
        }
        result.setUsers(responses);
        result.setTotle(page.getTotal());
        return result;
    }

    @Override
    public SysUser getUserByUsername(String loginName) {
        SysUser sysUser = sysUserDao.getUserByUsername(loginName);
        return sysUser;
    }
}
