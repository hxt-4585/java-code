package com.powernode.factoryMethod;

import com.powernode.factory.Weapon;

public class Tank extends Weapon {
    @Override
    public void attack() {
        System.out.println("tank");
    }
}
