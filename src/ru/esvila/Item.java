package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public abstract class Item {

    protected String nameOfItem;
    protected enum ItemType {using, quest, weapon, armor, infinity, other}
    protected ItemType type;

    public ItemType getType() {
        return type;
    }

    protected int cost;

    public int getCost() {
        return cost;
    }


    public Item(String nameOfItem, int cost) {
        this.nameOfItem = nameOfItem;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return nameOfItem;
    }

    public String getName() {
        return nameOfItem;
    }





}
