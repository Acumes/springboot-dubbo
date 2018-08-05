package com.htf.dao;

import com.htf.api.po.SysUser;
import com.htf.api.vo.response.SysUserResult;
import com.htf.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author acumes
 * @date 2018/8/1 16:16
 */
@Repository
public interface ISysUserDao extends BaseMapper<SysUser, Integer> {
    List<SysUser> searchUsers();

    SysUser getUserByUsername(@Param("loginName") String loginName);
}
