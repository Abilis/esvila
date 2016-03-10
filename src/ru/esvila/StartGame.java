package ru.esvila;

import javax.print.attribute.standard.MediaSize;

/**
 * Created by Abilis on 10.03.2016.
 */
public class StartGame {



    public static void initGame() {


        System.out.println("В один прекрасный день один из жителей маленького, но гордого города" +
                " с звучным названием \"Эсвила\", понял, что" +
                " он - авантюрист. Ему захотелось путешествий и приключений. ");

        System.out.println();

        String nameHero = Utilites.inputStr("Как зовут героя?");

        int x = Utilites.getAction(1, 2, "Выберите класс героя. 1 - Воин, 2 - Маг");


        System.out.println("Путешествие героя " + getHeroClass(x) + " с именем " + nameHero + " началось!");

    }

    public static String getHeroClass(int x) {

        String HeroClass = "";

        switch (x) {

            case 1: HeroClass = "Воин";
                break;
            case 2: HeroClass = "Маг";
                break;

        }
        return HeroClass;
    }



}
