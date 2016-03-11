package ru.esvila;

import java.util.ArrayList;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Battle {

    private static Monster currentMonster;
    public enum MonsterType {Гоблин, Нежить}
    private MonsterType type;

    private static int inputNum;


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

        //цикл боя
        do {

            hero.getInfo();
            System.out.println("<против>");
            monster.getInfo();

            //ход героя
            hero.makeNewRoundOfBattle();
            inputNum = Utilites.getAction(0, 2, "1 - атака, 2 - защита, 0 - убежать");

            switch (inputNum) {

                case 0:
                    hero.setRunaway(true);
                    break;
                case 1:
                    //атака героем
                    monster.getDamage(hero.makeAttack());


                    break;
                case 2:
                    //защита героем

            }

            //ход монстра

            //пока монстр умеет только атаковать
            hero.getDamage(monster.makeAttack());


            //проверка условия выхода из цикла боя
            if (hero.getRunaway()) {
                System.out.println(hero.getName() + " сбежал с поля боя!");
                break;
            }

            if (!hero.alive) {
                System.out.println(monster.getDescription() + " победил героя!");
                break;
            }
            else if (!monster.alive) {
                System.out.println(hero.getDescription() + " убил монстра " + monster.getDescription());
                break;
            }


        } while (true);

        //после боя



    }



}
