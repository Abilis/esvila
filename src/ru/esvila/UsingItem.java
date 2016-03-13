package ru.esvila;

/**
 * Created by Abilis on 13.03.2016.
 */
public class UsingItem extends Item {

    private int hpPlus;

    public int getHpPlus() {
        return hpPlus;
    }

    private int manaPlus;

    public int getManaPlus() {
        return manaPlus;
    }

    public UsingItem(String nameOfItem, int cost, int hpPlus, int manaPlus) {
        super(nameOfItem, cost);
        this.type = ItemType.using;
        this.hpPlus = hpPlus;
        this.manaPlus = manaPlus;
    }

}
