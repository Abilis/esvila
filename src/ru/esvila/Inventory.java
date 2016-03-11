package ru.esvila;

import java.util.ArrayList;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Inventory {

    private ArrayList<Item> inv;
    private int gold;


    public Inventory() {
        inv = new ArrayList<Item>();
        gold = 0;
    }

    public void addItemInInventory(Item newItem) {
        inv.add(newItem);
    }

    public void removeItemFromInventory(Item oldItem) {
        inv.remove(oldItem);
    }

    public void showInventory() {

        if (inv.size() == 0) {
            System.out.println("Инвентарь пуст!");
            System.out.println(gold + " золотых монет");
        }
        else {

            System.out.println("Содержимое инвентаря:");

            for (int i = 1; i <= inv.size(); i++) {
                System.out.println(i + ". " + inv.get(i - 1).toString());
            }
            System.out.println(gold + " золотых монет");
        }
    }

    public int getSizeInventory() {
        return inv.size();
    }

    public String getUseItem(int itemID) {
        //метод возвращает название предмета из инвентаря по его индексу
        String itemName = inv.get(itemID).getName();

        if (inv.get(itemID).getType() == Item.ItemType.using) {
            inv.remove(itemID);
            return itemName;
        }

        return "";
    }


    public int getGold() {
        return gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }




}
