package ru.esvila;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Utilites {

    Random rand = new Random(); //ГСЧ

    public static String inputStr(String message) { //метод, возвращающий введенную строку

        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        if (message != null) {
            System.out.println(message);
        }

        String str = null;
        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static int getAction(int min, int max, String message) { //метод, возвращающий валидный код действия

        int x;

        do {

            try {
                x = Integer.parseInt(inputStr(message));
            }
            catch (NumberFormatException e) {
                x = -1;
                continue;
            }

        } while (x < min || x > max);

        return x;
    }

}
