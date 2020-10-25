package com.atguigu.springboot;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器，应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听器，应用销毁");
    }
}
