package ru.esvila;

/**
 * Created by Abilis on 13.03.2016.
 */
public class StartLocationVendor extends Vendor{





    public StartLocationVendor(String vendorName) {
        super(vendorName);
        vendorInv.addItemInInventory(new Item("Слабое зелье лечения", Item.ItemType.using, 12));
        vendorInv.addItemInInventory(new Item("Слабое зелье лечения", Item.ItemType.using, 12));
        vendorInv.addItemInInventory(new Item("Слабое зелье маны", Item.ItemType.using, 12));
        vendorInv.addItemInInventory(new Item("Слабое зелье маны", Item.ItemType.using, 12));
        vendorInv.addItemInInventory(new Item("Посох мага", Item.ItemType.armor, 300));
        vendorInv.addItemInInventory(new Item("Меч воина", Item.ItemType.armor, 300));
        vendorInv.addItemInInventory(new Item("Кинжал разбойника", Item.ItemType.armor, 300));
        vendorInv.addGold(300);
    }


}
