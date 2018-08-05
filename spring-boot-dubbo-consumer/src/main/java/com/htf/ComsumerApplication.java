package com.htf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author acumes
 * @date 2018/7/25 15:05
 */
@SpringBootApplication
//@EnableWebMvc
@ImportResource("classpath:dubbo-consumer.xml")
public class ComsumerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ComsumerApplication.class);
        application.setRegisterShutdownHook(false);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        LOGGER.info("Client started success!!!");
    }
}
