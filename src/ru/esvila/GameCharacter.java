package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public abstract class GameCharacter {

    protected String heroClass;
    protected String nameHero;
    protected int baseStrength;
    protected int baseIntellect;
    protected int baseAgility;
    protected int baseStamina;

    protected int strength;
    protected int intellect;
    protected int agility;
    protected int stamina;

    protected int hp;
    protected int hpMax;

    protected int attack;
    protected int defense;
    protected float critChance;
    protected float avoidChance;

    protected int level;



    public GameCharacter (String heroClass, String nameHero, int strength, int intellect, int agility, int stamina) {
        this.heroClass = heroClass;
        this.nameHero = nameHero;

        baseStrength = strength;
        baseIntellect = intellect;
        baseAgility = agility;
        baseStamina = stamina;

        this.strength = baseStrength;
        this.intellect = baseIntellect;
        this.agility = baseAgility;
        this.stamina = baseStamina;

        level = 1;

        calculateSecondaryParameters();
    }

    public abstract void calculateSecondaryParameters();


    public void getInfo() {
        System.out.println(heroClass + " " + nameHero + ". hp: " + hp + "/" + hpMax + ", уровень: " + level);
    }

    public abstract void levelUp (int numLevels); //метод, увеличивающий уровень персонажа на NumLevels уровней


}
