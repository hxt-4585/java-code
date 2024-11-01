package com.powernode.factoryMethod;

import com.powernode.factory.Weapon;

public class Dagger extends Weapon {
    @Override
    public void attack() {
        System.out.println("dagger");
    }
}
