package com.powernode.factoryMethod;

import com.powernode.factory.Weapon;

public class Fighter extends Weapon {
    @Override
    public void attack() {
        System.out.println("fighter");
    }
}
