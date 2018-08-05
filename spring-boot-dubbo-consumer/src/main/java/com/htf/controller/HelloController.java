package com.htf.controller;

import com.htf.api.service.IHelloService;
import com.htf.common.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author acumes
 * @date 2018/7/25 15:43
 */
@RestController
public class HelloController {

    Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private IHelloService helloService;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){
        log.info("======================");

        System.out.println(SpringUtil.getBean("containerCustomizer"));
        return helloService.sayHello(name);
    }

}
