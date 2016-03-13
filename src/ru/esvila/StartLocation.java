package ru.esvila;

/**
 * Created by Abilis on 13.03.2016.
 */
public class StartLocation {

    private static int inputNum;
    private static boolean exit = false;

    public static void startLocationLoop(Hero mainHero) {

        do {

            if (!mainHero.isAlive()) {
                inputNum = Utilites.getAction(4, 4, "Вы мертвы. 4 - воскреснуть");
            }

            else {
                inputNum = Utilites.getAction(1, 4, "Что вы хотите сделать? 1 - найти монстра, 2 - торговать" +
                        ", 3 - отправиться на поиски приключений, 4 - восстановить силы");
            }

            switch (inputNum) {

                case 1: //создаем случайного монстра
                    Monster currentMonster = Battle.createRandomMonster();

                    //Даем монстру случайный разброс уровней 1-3
                    currentMonster.doRandomLevel(1, 1, 3);

                    //запускаем бой между героем и созданным монстром
                    Battle.startBattle(mainHero, currentMonster);
                    break;
                case 2:
                    //торговля
                    Trade.trading(mainHero, StartGame.startLocationVendor);
                    break;
                case 3:
                    //выход из этой петли
                    exit = true;
                    break;
                case 4:

                    mainHero.cure(mainHero.getHpMax());

                    if (mainHero instanceof Mag) {
                        mainHero.recovMana(((Mag) mainHero).getManaMax());
                    }
                    if (!mainHero.alive) {
                        mainHero.alive = true;
                        System.out.println(mainHero.getName() + " был успешно воскрешен!");
                    }
                    break;

            }

        } while (!exit);
    }

}
