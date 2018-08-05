package com.htf.api.vo.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author acumes
 * @date 2018/8/1 16:26
 */

@Data
public class SysUserRequest implements Serializable {
    private String loginName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String remarks;
}
