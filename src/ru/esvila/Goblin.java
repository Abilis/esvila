package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Goblin extends Monster {


    public Goblin(String nameGoblin, int strength, int intellect, int agility, int stamina) {
        super("Гоблин", nameGoblin, strength, intellect, agility, stamina);
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
            strength += (int) (baseStrength * 0.3);
            intellect += (int) (baseIntellect * 0.1);
            agility += (int) (baseAgility * 0.1);
            stamina += (int) (baseStamina * 0.3);
            level++;
            monsterInv.addGold(getLevel() * (int)(baseGold * 0.8 + Utilites.rand.nextInt((int)(baseGold * 0.4))));
        }

        calculateSecondaryParameters();

    }

}
