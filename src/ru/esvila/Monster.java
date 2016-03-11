package ru.esvila;

import java.util.ArrayList;

/**
 * Created by Abilis on 10.03.2016.
 */
public abstract class Monster extends GameCharacter {

    protected Inventory monsterInv;
    protected int baseGold = 10;
    protected int dropChance = 100;


    public Monster(String monsterClass, String nameMonster, int strength, int intellect, int agility, int stamina) {
        super(monsterClass, nameMonster, strength, intellect, agility, stamina);
        monsterInv = new Inventory();
        monsterInv.addGold((int)(baseGold * 0.8 + Utilites.rand.nextInt((int)(baseGold * 0.4))));

        if (dropChance >= Utilites.rand.nextInt(101)) {
            monsterInv.addItemInInventory(new Item(getRandomOtherItem(), Item.ItemType.other));
        }
    }


    @Override
    public abstract void calculateSecondaryParameters();

    @Override
    public abstract void levelUp(int numLevels); //метод, увеличивающий уровень персонажа на NumLevels уровней

    public void doRandomLevel(int currentLevel, int minLevel, int maxLevel) {

        if (currentLevel - minLevel < 1) {
            minLevel = 1;
        }

        int randomLevel = Utilites.rand.nextInt(maxLevel - minLevel) + minLevel;
        levelUp(randomLevel);

    }

    public int getMonsterAction(){

        int monsterAction;

        int monsterActionRandom = Utilites.rand.nextInt(101);

        if (monsterActionRandom < 80) {
            monsterAction = 1;
        }
        else {
            monsterAction = 2;
        }

        return monsterAction;
    }

    private String getRandomOtherItem() {
        ArrayList<String> listOfOtherItems = new ArrayList<String>();

        listOfOtherItems.add("Сломанный меч");
        listOfOtherItems.add("Истертая древняя монета");
        listOfOtherItems.add("Сломанный посох");
        listOfOtherItems.add("Обмломок кастета");
        listOfOtherItems.add("Разбитый монокль");
        listOfOtherItems.add("Наконечник стрелы");
        listOfOtherItems.add("Пуговица");
        listOfOtherItems.add("Свеча");

        int randomItemIndex = Utilites.rand.nextInt(listOfOtherItems.size());
        String nameOfItem = listOfOtherItems.get(randomItemIndex);


        return nameOfItem;
    }




}