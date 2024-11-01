package com.powernode.staticProxy;

public class TaoBao implements UsbSell{

    private UsbSell factory = new Factory();

    @Override
    public float sell(int amount) {
        float price = factory.sell(1);
        price = price + 25.0f;
        return price;
    }
}
