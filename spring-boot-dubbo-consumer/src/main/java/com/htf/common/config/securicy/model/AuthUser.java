package com.htf.common.config.securicy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Security User
 *
 * @author zhangxd
 */
public class AuthUser extends AbstractAuthUser {

    /**
     * 用户默认角色
     */
    private static final String TRIP_USER_ROLE = "ROLE_USER";
    /**
     * id
     */
    private Integer id;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 冻结
     */
    private String enabled;

    public AuthUser(
            Integer id,
        String mobile,
        String password,
        String enabled
    ) {
        this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean isEnabled() {

        return "1".equals(this.enabled) ? true : false;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public String getUsername() {
        return mobile;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(TRIP_USER_ROLE));
        return authorities;
    }

}
