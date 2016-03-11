package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public abstract class Monster extends GameCharacter {

    protected Inventory monsterInv;
    protected int baseGold = 10;


    public Monster(String monsterClass, String nameMonster, int strength, int intellect, int agility, int stamina) {
        super(monsterClass, nameMonster, strength, intellect, agility, stamina);
        monsterInv = new Inventory();
        monsterInv.addGold((int)(baseGold * 0.8 + Utilites.rand.nextInt((int)(baseGold * 0.4))));
    }


    @Override
    public abstract void calculateSecondaryParameters();

    @Override
    public abstract void levelUp(int numLevels); //метод, увеличивающий уровень персонажа на NumLevels уровней

    public void addGold(int gold) {

    }


}