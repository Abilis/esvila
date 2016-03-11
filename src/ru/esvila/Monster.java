package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public abstract class Monster extends GameCharacter {

    public Monster(String monsterClass, String nameMonster, int strength, int intellect, int agility, int stamina) {
        super(monsterClass, nameMonster, strength, intellect, agility, stamina);
    }


    @Override
    public abstract void calculateSecondaryParameters();

    @Override
    public abstract void levelUp(int numLevels); //метод, увеличивающий уровень персонажа на NumLevels уровней


}