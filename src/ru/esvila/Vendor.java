package ru.esvila;

/**
 * Created by Abilis on 13.03.2016.
 */
public abstract class Vendor {

    protected String vendorName;
    protected Inventory vendorInv;

    public Inventory getVendorInv() {
        return vendorInv;
    }

    public Vendor(String vendorName) {
        this.vendorName = vendorName;
        this.vendorInv = new Inventory();
    }

}
