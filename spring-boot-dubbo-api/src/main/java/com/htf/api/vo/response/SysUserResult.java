package com.htf.api.vo.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author acumes
 * @date 2018/8/2 9:11
 */
@Data
public class SysUserResult implements Serializable {
    private long totle;
    private List<SysUserResponse> users;
}
