package com.powernode.staticProxy;

public class Buyer {
    public static void main(String[] args) {
        UsbSell taoBao = new TaoBao();
        System.out.println(taoBao.sell(1));

    }
}
