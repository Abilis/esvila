package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class MainClass {

    public static void main(String[] args) {

        //Инициализируем главного героя
        Hero mainHero = StartGame.initGame();

        //создаем монстра
        Monster currentMonster = Battle.createRandomMonster();

        //запускаем бой между героем и созданным монстром
        Battle.startBattle(mainHero, currentMonster);


    }

}
