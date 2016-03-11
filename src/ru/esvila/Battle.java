package ru.esvila;

import java.util.ArrayList;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Battle {

    private static Monster currentMonster;
    public enum MonsterType {Гоблин, Нежить}
    private MonsterType type;

    public static Monster createMonster(MonsterType type) {

        switch (type) {

            case Гоблин:
                currentMonster = new Goblin("Злобный гоблин", 10, 10, 10, 10);
                return currentMonster;
            case Нежить:
                currentMonster = new Undead("Восставший скелет", 10, 10, 10, 10);
                return currentMonster;
            default:
                currentMonster = new Goblin("Непонятный монстр", 5, 5, 5, 5) ;
                return currentMonster;

        }


    }

    public static Monster createRandomMonster() {

        int monsterIndex = Utilites.rand.nextInt(MonsterType.values().length); //генерируем случайное целое число от 0 до длины списка типов монстров
        MonsterType randomTypeOfMonster = MonsterType.values()[monsterIndex];   //вытаскиваем название типа монстра
        Monster randomMonster = createMonster(randomTypeOfMonster);             //генерируем этот тип монстра
        return randomMonster;

    }



    public static void startBattle(Hero hero, Monster monster) {

        System.out.println(hero.getDescription() + " и " + monster.getDescription() + " не смогли разойтись на узкой тропинке!");
    }

}
