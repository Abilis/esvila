package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Trade {

    private static int inputNum;
    private static boolean goOut;
    private static int inputInv;



    public static void trading(Hero hero, Vendor vendor) {

        goOut = false;
        do {
            inputNum = Utilites.getAction(1, 3, "1 - продать что-нибудь, 2 - купить что-нибудь, 3 - вернуться к приключениям");

            switch (inputNum) {

                case 1:
                    //продажа героем
                    System.out.println("Здесь " + hero.getName() + " может чего-нибудь купить");
                    System.out.println("Возможные вещи для продажи:");
                    hero.heroInv.showInventory();

                    inputInv = Utilites.getAction(0, hero.heroInv.getSizeInventory(), "0 - закончить торговлю");

                    if (inputInv != 0) {

                    Item itemForSell = hero.heroInv.getItemFromInventory(inputInv - 1);
                    Inventory.transferOneItemFromFirstInvToSecondInv(hero.heroInv, vendor.getVendorInv(), itemForSell, itemForSell.getCost());

                        if (vendor.getVendorInv().getGold() >= itemForSell.getCost()) {
                            System.out.println(hero.getName() + " продал " + itemForSell.toString() +
                                    " за " + itemForSell.getCost() + " золотых!");
                        }
                    }
                    break;
                case 2:
                    //покупка героем
                    System.out.println("Здесь " + hero.getName() + " может чего-нибудь купить");
                    System.out.println("Ассортимент у торговца:");
                    vendor.getVendorInv().showInventory();

                    inputInv = Utilites.getAction(0, vendor.getVendorInv().getSizeInventory(), "0 - закончить торговлю");

                    if (inputInv != 0) {

                    Item itemForBuy = vendor.getVendorInv().getItemFromInventory(inputInv - 1);
                        Inventory.transferOneItemFromFirstInvToSecondInv(vendor.getVendorInv(), hero.heroInv,itemForBuy, itemForBuy.getCost());

                        if (hero.heroInv.getGold() >= itemForBuy.getCost()) {
                            System.out.println(hero.getName() + " купил " + itemForBuy.toString() +
                                    " за " + itemForBuy.getCost() + " золотых!");
                        }
                    }
                    break;
                case 3:
                    //выход из торговли
                    goOut = true;
            }

        } while (!goOut);

        System.out.println("Торговля завершена");
    }




}
