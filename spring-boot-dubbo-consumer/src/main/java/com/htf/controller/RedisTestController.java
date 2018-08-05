package com.htf.controller;

import com.htf.common.config.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author acumes
 * @date 2018/8/2 9:52
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    private RedisRepository redisRepository;

    @RequestMapping(value = "/set",method = RequestMethod.POST)
    public String setRedis(@RequestParam String key,@RequestParam String value ){
        redisRepository.set(key,value);
        return "success";
    }

}
