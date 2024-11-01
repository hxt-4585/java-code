package com.powernode.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean , DisposableBean {
    private String name;

    public User() {
        System.out.println("第一步、实例化Bean");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("第二步、Bean属性赋值");
        this.name = name;
    }

    public void initBean(){
        System.out.println("第六步、初始化Bean");
    }

    public void destroyBean(){
        System.out.println("第十步、销毁Bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("第三步、类加载器：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第三步、Bean工厂：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("第三步、Bean名字：" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第五步、afterPropertiesSet执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第九步、DisposableBean destroy");
    }
}
