package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class MainClass {

    private static int inputNum;

    public static void main(String[] args) {

        //Инициализируем главного героя
        Hero mainHero = StartGame.initGame();

        //Запускаем стартовую петлю игры
        StartLocation.startLocationLoop(mainHero);










    }

}
