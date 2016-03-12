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

    public Item getItemFromInventory(int indexItem) {
        return inv.get(indexItem);
    }

    public void setItemInInventory(int indexItem, Item item) {
        inv.set(indexItem, item);
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

    public void remGold(int gold) {
        this.gold -= gold;
    }

    public static void transferItemsFromFirstInvToSecondInv(Inventory firstInv, Inventory secondInv) {

        for (int i = 0; i < firstInv.getSizeInventory(); i++) {
            secondInv.addItemInInventory(firstInv.getItemFromInventory(i));
            System.out.println("Добыча: " + firstInv.getItemFromInventory(i));
        }
        sortInv(secondInv);
    }

    public static void sortInv(Inventory _inv) {

        if (_inv.getSizeInventory() > 1) {

            for (int j = 0; j < _inv.getSizeInventory(); j++) {
                for (int i = 0; i < _inv.getSizeInventory() - 1; i++) {
                    Item itemI = _inv.getItemFromInventory(i);
                    Item itemIPlusOne = _inv.getItemFromInventory(i + 1);

                    String nameOfItemI = itemI.getName();
                    String nameOfItemIPlusOne = itemIPlusOne.getName();

                    int Str1MoreStr2 = nameOfItemI.compareTo(nameOfItemIPlusOne);

                    if (Str1MoreStr2 > 0) {
                        Item tmp = itemI;
                        _inv.setItemInInventory(i, _inv.getItemFromInventory(i + 1));
                        _inv.setItemInInventory(i + 1, tmp);
                    }
                } //конец внутреннего цикла
            } //конец внешнего цикла
        } //конец if
    } //конец метода


    public static void transferOneItemFromFirstInvToSecondInv(Inventory inv1, Inventory inv2, Item item, int cost) {


        if (inv2.getGold() < cost) {
            System.out.println("Недостаточно золота!");
        }
        else {
            inv1.removeItemFromInventory(item);
            inv2.addItemInInventory(item);

            inv2.remGold(cost);
            inv1.addGold(cost);
            sortInv(inv2);
        }
    }




}
