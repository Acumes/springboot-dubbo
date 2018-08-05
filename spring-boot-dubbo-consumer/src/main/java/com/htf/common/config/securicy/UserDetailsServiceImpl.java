package com.htf.common.config.securicy;

import com.htf.api.po.SysUser;
import com.htf.api.service.ISysUserService;
import com.htf.common.config.securicy.model.AuthUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Security User Detail Service
 *
 * @author zhangxd
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 用户服务
     */
    @Autowired
    private ISysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String loginName) {
        SysUser user = sysUserService.getUserByUsername(loginName);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", loginName));
        } else {
            return AuthUserFactory.create(user);
        }
    }
}
