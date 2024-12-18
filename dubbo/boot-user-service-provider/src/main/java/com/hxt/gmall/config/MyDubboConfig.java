package com.hxt.gmall.config;

import com.alibaba.dubbo.config.*;
import com.hxt.gmall.service.UserService;
import com.hxt.gmall.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class MyDubboConfig {

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

//    <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

//    <dubbo:protocol name="dubbo" port="20882"></dubbo:protocol>
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20883);
        return protocolConfig;
    }

//    <dubbo:service interface="com.hxt.gmall.service.UserService" ref="userServiceImpl"></dubbo:service>
    @Bean
    public ServiceConfig<UserService> userServiceConfig(UserService userService){
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        // 已经注入了在UserServiceImpl.java中
        serviceConfig.setRef(userService);
//        serviceConfig.setVersion("1.0.0");

        // 配置每一个method信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
//        methodConfig.setTimeout(1000);

        // 将method关联到ServiceConfig中
        ArrayList<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);
        serviceConfig.setMethods(methods);

        // ProviderConfig
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(5000);
        serviceConfig.setProvider(providerConfig);

        // MonitorConfig
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("zookeeper");
        serviceConfig.setMonitor(monitorConfig);

        return serviceConfig;
    }
}