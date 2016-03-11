package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Item {

    private String nameOfItem;
    public enum ItemType {using, quest, weapon, armor, infinity, other}
    private ItemType type;

    public Item(String nameOfItem, ItemType type) {
        this.nameOfItem = nameOfItem;
        this.type = type;
    }

    @Override
    public String toString() {
        return nameOfItem;
    }

    public String getName() {
        return nameOfItem;
    }

    public ItemType getType() {
        return type;
    }

}
