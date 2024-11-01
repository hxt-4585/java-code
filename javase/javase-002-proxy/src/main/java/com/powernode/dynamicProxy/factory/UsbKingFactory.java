package com.powernode.dynamicProxy.factory;

import com.powernode.dynamicProxy.service.UsbSell;

public class UsbKingFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        return amount * 85.0f;
    }

    @Override
    public float sale() {
        return 50f;
    }
}
