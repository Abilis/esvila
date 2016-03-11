package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public abstract class GameCharacter {

    protected String charClass;
    protected String charName;
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
    protected boolean alive;

    private static boolean runaway;

    public boolean getRunaway() {
        return runaway;
    }

    public void setRunaway(boolean value) {
        runaway = value;
    }



    public GameCharacter (String charClass, String charName, int strength, int intellect, int agility, int stamina) {
        this.charClass = charClass;
        this.charName = charName;

        baseStrength = strength;
        baseIntellect = intellect;
        baseAgility = agility;
        baseStamina = stamina;

        this.strength = baseStrength;
        this.intellect = baseIntellect;
        this.agility = baseAgility;
        this.stamina = baseStamina;
        this.alive = true;

        level = 1;

        calculateSecondaryParameters();
    }

    public abstract void calculateSecondaryParameters();


    public void getInfo() {
        System.out.println(charClass + " " + charName + ". hp: " + hp + "/" + hpMax + ", уровень: " + level);
    }

    public String getDescription() {
        return (charClass + " " + charName);
    }

    public String getName() {
        return charName;
    }

    public abstract void levelUp (int numLevels); //метод, увеличивающий уровень персонажа на NumLevels уровней

    public int makeAttack() {

        int currentAttack;
        int minCurrentAttack = (int)(attack * 0.8);
        int deltaCurrentAttack = (int)(attack * 0.4);

        currentAttack = minCurrentAttack + Utilites.rand.nextInt(deltaCurrentAttack);
        System.out.println(charName + " наносит удар в " + currentAttack + " единиц урона");

        if (critChance > Utilites.rand.nextInt(100)) {
            currentAttack = currentAttack * 2;
            System.out.println(charName + " наносит критический удар в " + currentAttack + " единиц урона!");
        }

        return currentAttack;
    }

    public void getDamage(int inputDamage) {

        int currentDefense;
        int minCurrentDefense = (int)(defense * 0.8);
        int deltaCurrentDefense = (int)(defense * 0.4);

        currentDefense = minCurrentDefense + Utilites.rand.nextInt(deltaCurrentDefense);

        int currentInputDamage = inputDamage - currentDefense;

        if (currentInputDamage < 0) {
            currentInputDamage = 0;        }

        System.out.println(charName + " получает " + currentInputDamage + " единиц урона");

        hp -= currentInputDamage;

        if (hp <= 0) {
            alive = false;
        }


    }

    public void makeNewRoundOfBattle() {
        runaway = false;
    }

}
