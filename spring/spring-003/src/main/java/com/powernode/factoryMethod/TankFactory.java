package com.powernode.factoryMethod;

import com.powernode.factory.Weapon;

public class TankFactory implements WeaponFactory{
    @Override
    public Weapon get() {
        return new Tank();
    }
}
