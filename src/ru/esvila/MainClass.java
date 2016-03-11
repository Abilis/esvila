package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class MainClass {

    private static int inputNum;

    public static void main(String[] args) {

        //Инициализируем главного героя
        Hero mainHero = StartGame.initGame();


        do {
            inputNum = Utilites.getAction(1, 2, "Что вы хотите сделать? 1 - вступить в сражение, 2 - восстановить силы");

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
                    mainHero.recovMana(100);

                    if (!mainHero.alive) {
                        mainHero.alive = true;
                        System.out.println(mainHero.getName() + " был успешно воскрешен!");
                    }
            }

        } while (true);




    }

}
