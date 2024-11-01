package com.powernode.factoryMethod;

import com.powernode.factory.Weapon;

public class DaggerFactory implements WeaponFactory{
    @Override
    public Weapon get() {
        return new Fighter();
    }
}
