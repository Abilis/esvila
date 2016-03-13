package ru.esvila;

import javax.print.attribute.standard.MediaSize;

/**
 * Created by Abilis on 10.03.2016.
 */
public class StartGame {

    public static Hero mainHero;
    public static String nameHero;
    public static StartLocationVendor startLocationVendor;

    public static Hero initGame() {


        System.out.println("В один прекрасный день один из жителей маленького, но гордого города" +
                " с звучным названием \"Эсвила\", понял, что" +
                " он - авантюрист. Ему захотелось путешествий и приключений. ");

        System.out.println();

        do {
            nameHero = Utilites.inputStr("Как зовут героя?");
        } while (nameHero.length() == 0);

        int x = Utilites.getAction(1, 3, "Выберите класс героя. 1 - Воин, 2 - Маг, 3 - Разбойник");


        String mainHeroClass = getHeroClass(x);

        System.out.println("Путешествие героя " + mainHeroClass + " с именем " + nameHero + " началось!");


        //создаем героя
        if (x == 1) {
                mainHero = new Warrior(mainHeroClass, nameHero, 15, 10, 10, 15);
                mainHero.heroInv.addItemInInventory(new UsingItem("Слабое зелье лечения", 10, 50, 0));
        }
        else if (x == 2) {
            mainHero = new Mag(mainHeroClass, nameHero, 10, 15, 10, 15);
            mainHero.heroInv.addItemInInventory(new UsingItem("Слабое зелье маны", 10, 0, 50));
        }
        else if (x == 3) {
            mainHero = new Rogue (mainHeroClass,nameHero , 10, 10, 15, 15);
            mainHero.heroInv.addItemInInventory(new UsingItem("Слабое зелье лечения", 10, 50, 0));
        }

        mainHero.getInfo();

        //создаем торговца в стартовой локации
        startLocationVendor = new StartLocationVendor("Торговый Джо");



        return mainHero;
    }

    public static String getHeroClass(int x) {

        String HeroClass = "";

        switch (x) {

            case 1: HeroClass = "Воин";
                break;
            case 2: HeroClass = "Маг";
                break;
            case 3: HeroClass = "Разбойник";
                break;

        }
        return HeroClass;
    }



}
