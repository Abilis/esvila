package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Trade {

    public Inventory vendorInv;
    private int inputNum;
    private boolean goOut;
    private int inputInv;


    public Trade() {
        this.vendorInv = new Inventory();
        vendorInv.addItemInInventory(new Item("Слабое зелье лечения", Item.ItemType.using, 12));
        vendorInv.addItemInInventory(new Item("Слабое зелье маны", Item.ItemType.using, 12));
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

                    inputInv = Utilites.getAction(0, hero.heroInv.getSizeInventory(), "0 - закончить торговлю");

                    if (inputInv != 0) {

                    Item itemForSell = hero.heroInv.getItemFromInventory(inputInv - 1);
                    Inventory.transferOneItemFromFirstInvToSecondInv(hero.heroInv, vendorInv, itemForSell, itemForSell.getCost());

                        System.out.println(hero.getName() + " продал " + itemForSell.toString() +
                                " за " + itemForSell.getCost() + " золотых!");
                    }
                    break;
                case 2:
                    //покупка героем
                    System.out.println("Здесь " + hero.getName() + " может чего-нибудь купить");
                    System.out.println("Ассортимент у торговца:");
                    vendorInv.showInventory();

                    inputInv = Utilites.getAction(0, vendorInv.getSizeInventory(), "0 - закончить торговлю");

                    if (inputInv != 0) {

                    Item itemForBuy = vendorInv.getItemFromInventory(inputInv - 1);
                        Inventory.transferOneItemFromFirstInvToSecondInv(vendorInv, hero.heroInv,itemForBuy, 10);

                        System.out.println(hero.getName() + " купил " + itemForBuy.toString() +
                                " за " + itemForBuy.getCost() + " золотых!");
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
