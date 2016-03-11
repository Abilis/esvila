package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Trade {

    public Inventory vendorInv;
    private int inputNum;
    private boolean goOut;


    public Trade() {
        this.vendorInv = new Inventory();
        vendorInv.addItemInInventory(new Item("Слабое зелье лечения", Item.ItemType.using));
        vendorInv.addItemInInventory(new Item("Слабое зелье маны", Item.ItemType.using));
        vendorInv.addGold(2000);
    }

    public void trading(Hero hero) {


        do {
            inputNum = Utilites.getAction(1, 3, "1 - продать что-нибудь, 2 - купить что-нибудь, 3 - вернуться к приключениям");

            switch (inputNum) {

                case 1:
                    //продажа героем
                    System.out.println("Здесь " + hero.getName() + " может чего-нибудь купить");
                    System.out.println("Возможные вещи для продажи:");
                    hero.heroInv.showInventory();
                    break;
                case 2:
                    //покупка героем
                    System.out.println("Здесь " + hero.getName() + " может чего-нибудь купить");
                    System.out.println("Ассортимент у торговца:");
                    vendorInv.showInventory();
                    break;
                case 3:
                    //выход из торговли
                    goOut = true;
            }

        } while (!goOut);

        System.out.println("Торговля завершена");
    }


}
