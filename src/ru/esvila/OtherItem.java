package ru.esvila;

/**
 * Created by Abilis on 13.03.2016.
 */
public class OtherItem extends Item {

    public OtherItem(String nameOfItem, int cost) {
        super(nameOfItem, cost);
        this.type = ItemType.other;
    }

}
