package com.hxt.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * Listener先要从 META-INF/spring.factories
 *
 * 1、引导：利用 BootstrapContext 引导整个项目启动
 *      starting：               应用开始，SpringApplication的run方法一调用，只要有了 BootstrapContext 就执行
 *      environmentPrepared：    环境准备好（把启动参数等绑定到环境变量中），但是ioc还没有创建
 * 2、启动
 *      contextPrepared：        ioc容器创建并准备好，但是sources（主配置类）没有加载。并关闭引导上下文；组件都没创建
 *      contextLoaded：          ioc容器加载。主配置类加载进去。但是ioc容器还没刷新（bean没创建）
 *      ===============截至以前，ioc容器还没有bean
 *      started：                ioc容器刷新（所有bean创建），但是runner没调用
 *      ready：                  ioc容器刷新（所有bean创建），所有runner调用
 * 3、运行
 */
public class AppListener implements SpringApplicationRunListener {
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("==========starting===========正在启动====");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("==========environmentPrepared===========环境准备完成====");    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("==========contextPrepared===========上下文准备完成====");    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("==========contextLoaded===========IOC容器加载完成====");

}

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("==========started===========启动完成====");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("==========ready===========准备就绪====");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("==========failed===========启动失败====");
    }
}
