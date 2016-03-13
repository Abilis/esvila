package ru.esvila;

/**
 * Created by Abilis on 13.03.2016.
 */
public class StartLocation {

    private static int inputNum;
    private static boolean exit = false;

    public static void startLocationLoop(Hero mainHero) {

        do {
            inputNum = Utilites.getAction(1, 4, "Что вы хотите сделать? 1 - найти монстра, 2 - восстановить силы" +
                    ", 3 - торговать, 4 - отправиться на поиски приключений");

            switch (inputNum) {

                case 1: //создаем случайного монстра
                    Monster currentMonster = Battle.createRandomMonster();


                    //Даем монстру случайный разброс уровней 1-3
                    currentMonster.doRandomLevel(1, 1, 3);

                    //запускаем бой между героем и созданным монстром
                    Battle.startBattle(mainHero, currentMonster);
                    break;
                case 2:

                    mainHero.cure(mainHero.hpMax);

                    if (mainHero instanceof Mag) {
                        mainHero.recovMana(((Mag) mainHero).getManaMax());
                    }
                    if (!mainHero.alive) {
                        mainHero.alive = true;
                        System.out.println(mainHero.getName() + " был успешно воскрешен!");
                    }
                    break;
                case 3:
                    //торговля
                    Trade.trading(mainHero, StartGame.startLocationVendor);
                    break;

                case 4:
                    //выход из этой петли
                    exit = true;
            }

        } while (!exit);
    }

}
