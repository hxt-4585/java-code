package com.powernode.dynamicProxy;

import com.powernode.dynamicProxy.factory.UsbKingFactory;
import com.powernode.dynamicProxy.handler.SaleHandler;
import com.powernode.dynamicProxy.handler.SellHandler;
import com.powernode.dynamicProxy.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainShop {
    public static void main(String[] args) {
        UsbSell factory = new UsbKingFactory();
        InvocationHandler sellHandler = new SellHandler(factory);
        InvocationHandler saleHandler = new SaleHandler(factory);

        UsbSell proxySell = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), sellHandler);
        UsbSell proxySale = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), saleHandler);

        float sell = proxySell.sell(2);
        float sale = proxySale.sale();
        System.out.println(sell);
        System.out.println(sale);
    }
}
