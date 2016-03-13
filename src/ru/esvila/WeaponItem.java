package ru.esvila;

/**
 * Created by Abilis on 13.03.2016.
 */
public class WeaponItem extends Item {

    private int strengthPlus;

    public int getStrengthPlus() {
        return strengthPlus;
    }

    private int intellectPlus;

    public int getIntellectPlus() {
        return intellectPlus;
    }

    private int agilityPlus;

    public int getAgilityPlus() {
        return agilityPlus;
    }

    public WeaponItem(String nameOfItem, int cost, int strengthPlus, int intellectPlus, int agilityPlus) {
        super(nameOfItem, ItemType.weapon, cost);
        this.strengthPlus = strengthPlus;
        this.intellectPlus = intellectPlus;
        this.agilityPlus = agilityPlus;
    }

}
