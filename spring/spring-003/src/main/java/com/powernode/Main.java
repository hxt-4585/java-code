package com.powernode;

import com.powernode.factory.Weapon;
import com.powernode.factoryMethod.DaggerFactory;
import com.powernode.factoryMethod.WeaponFactory;

public class Main {
    public static void main(String[] args) {
        WeaponFactory factory = new DaggerFactory();
        Weapon weapon = factory.get();
        weapon.attack();
    }
}