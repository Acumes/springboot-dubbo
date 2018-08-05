package com.htf.serviceimpl;

import com.htf.api.service.IHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author acumes
 * @date 2018/7/25 11:51
 */
@Service
public class HelloService implements IHelloService {
    private Logger log = LoggerFactory.getLogger(HelloService.class);

    @Override
    public String sayHello(String name) {
        log.debug(" ===== " + name);
        return "hello " + name;
    }
}
