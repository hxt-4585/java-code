package com.powernode.factoryMethod;

import com.powernode.factory.Weapon;

public class FighterFactory implements WeaponFactory{
    @Override
    public Weapon get() {
        return new Fighter();
    }
}
