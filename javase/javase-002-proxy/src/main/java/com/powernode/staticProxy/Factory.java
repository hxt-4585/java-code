package com.powernode.staticProxy;

public class Factory implements UsbSell{
    @Override
    public float sell(int amount) {
        return 85.0f * amount;
    }
}
