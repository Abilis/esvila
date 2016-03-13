package ru.esvila;

/**
 * Created by Abilis on 13.03.2016.
 */
public class StartLocationVendor extends Vendor{





    public StartLocationVendor(String vendorName) {
        super(vendorName);
        vendorInv.addItemInInventory(new UsingItem("Слабое зелье лечения", 12, 50, 0));
        vendorInv.addItemInInventory(new UsingItem("Слабое зелье лечения", 12, 50, 0));
        vendorInv.addItemInInventory(new UsingItem("Слабое зелье маны", 12, 0, 50));
        vendorInv.addItemInInventory(new UsingItem("Слабое зелье маны", 12, 0, 50));
        vendorInv.addItemInInventory(new WeaponItem("Меч воина", 300, 10, 0, 0));
        vendorInv.addItemInInventory(new WeaponItem("Посох мага", 300, 0, 10, 0));
        vendorInv.addItemInInventory(new WeaponItem("Кинжал разбойника", 300, 0, 0, 10));
        vendorInv.addGold(300);
    }


}
