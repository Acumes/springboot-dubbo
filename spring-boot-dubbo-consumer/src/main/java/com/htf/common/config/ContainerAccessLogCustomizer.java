package com.htf.common.config;

import ch.qos.logback.access.tomcat.LogbackValve;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

/**
 * @author acumes
 * @date 2018/7/26 16:00
 * desc: 访问日志
 */
public class ContainerAccessLogCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    /**
     * 访问日志文件
     */
    private String logbackAccessFile;

    public ContainerAccessLogCustomizer(String logbackAccessFile) {
        this.logbackAccessFile = logbackAccessFile;
    }

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) factory;

        //访问日志设置
        LogbackValve logbackValve = new LogbackValve();
        logbackValve.setQuiet(true);
        logbackValve.setFilename(logbackAccessFile);
        tomcatServletWebServerFactory.addContextValves(logbackValve);
    }
}
