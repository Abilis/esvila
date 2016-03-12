package ru.esvila;

/**
 * Created by Abilis on 13.03.2016.
 */
public class StartLocation {

    private static int inputNum;
    private static boolean exit = false;

    public static void stastLocationLoop(Hero mainHero) {

        do {
            inputNum = Utilites.getAction(1, 4, "Что вы хотите сделать? 1 - найти монстра, 2 - восстановить силы" +
                    ", 3 - торговать, 4 - отправиться на поиски приключений");

            switch (inputNum) {

                case 1: //создаем случайного монстра
                    Monster currentMonster = Battle.createRandomMonster();


                    //Даем монстру случайный разброс +-2 левела от уровня героя
                    currentMonster.doRandomLevel(mainHero.getLevel(), mainHero.getLevel() - 1, mainHero.getLevel() + 2);

                    //запускаем бой между героем и созданным монстром
                    Battle.startBattle(mainHero, currentMonster);
                    break;
                case 2:

                    mainHero.cure(mainHero.hpMax);

                    if (mainHero instanceof Mag) {
                        mainHero.recovMana(mainHero.getManaMax());
                    }
                    if (!mainHero.alive) {
                        mainHero.alive = true;
                        System.out.println(mainHero.getName() + " был успешно воскрешен!");
                    }
                    break;
                case 3:
                    //торговля
                    StartGame.vendorStartLoc.trading(mainHero);
                    break;

                case 4:
                    //выход из этой петли
                    exit = true;
            }

        } while (!exit);
    }

}
