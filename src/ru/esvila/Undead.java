package ru.esvila;

import java.util.ArrayList;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Undead extends Monster {

    private int dropChanceFromUndeadUnique = 10;

    public Undead(String nameUndead, int strength, int intellect, int agility, int stamina) {
        super("Нежить", nameUndead, strength, intellect, agility, stamina);

        if (dropChanceFromUndeadUnique >= Utilites.rand.nextInt(101)) {
            monsterInv.addItemInInventory(new Item(getRandomUniqueItem(), Item.ItemType.other));
        }
    }




    @Override
    public void calculateSecondaryParameters() {

        attack = (int)(strength * 1.5);
        defense = (int)(strength / 2);
        hp = stamina * 4;
        critChance = 3 + agility / 3;
        avoidChance = 5 + agility / 3;

        hp = stamina * 4;
        hpMax = hp;

    }

    @Override
    public void levelUp(int numLevels) {

        for (int i = 1; i <= numLevels; i++) {
            strength += (int) (baseStrength * 0.2);
            intellect += (int) (baseIntellect * 0.2);
            agility += (int) (baseAgility * 0.2);
            stamina += (int) (baseStamina * 0.3);
            level++;
            monsterInv.addGold(getLevel() * (int)(baseGold * 0.8 + Utilites.rand.nextInt((int)(baseGold * 0.4))));
        }

        calculateSecondaryParameters();

    }

    private String getRandomUniqueItem() {
        ArrayList<String> listOfUndeadUniqueItems = new ArrayList<String>();

        listOfUndeadUniqueItems.add("Бедренная кость");

        int randomItemIndex = Utilites.rand.nextInt(listOfUndeadUniqueItems.size());
        String nameOfItem = listOfUndeadUniqueItems.get(randomItemIndex);

        return nameOfItem;
    }


}
