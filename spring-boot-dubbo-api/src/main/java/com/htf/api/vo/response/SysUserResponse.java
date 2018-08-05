package com.htf.api.vo.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author acumes
 * @date 2018/8/2 8:55
 */
@Data
public class SysUserResponse implements Serializable {

    private Integer id;
    private String loginName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String enabled;
    private String remarks;
    private Date createDate;
    private Date updateDate;
    private String delFlag;
}
