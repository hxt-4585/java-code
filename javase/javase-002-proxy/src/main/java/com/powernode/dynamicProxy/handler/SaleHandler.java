package com.powernode.dynamicProxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SaleHandler implements InvocationHandler {
    private Object target;
    public SaleHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = null;
        res = method.invoke(target, args);

        if (res != null){
            return (Float)res;
        }

        return 0f;
    }
}
