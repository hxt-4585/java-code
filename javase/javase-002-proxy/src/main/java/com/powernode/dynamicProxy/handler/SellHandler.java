package com.powernode.dynamicProxy.handler;

import com.powernode.dynamicProxy.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SellHandler implements InvocationHandler {

    // 传入是谁的对象，就给谁创建代理
    private Object target;
    public SellHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = null;

        res = method.invoke(target, args);

        if (res != null){
            Float price = (Float) res;
            price += 25;
            res = price;
        }

        return res;
    }
}
