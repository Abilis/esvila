package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public abstract class Hero extends GameCharacter {

    protected int killedMonsters;
    protected int exp;
    protected int expToLevel;
    protected Inventory heroInv;


    public Hero(String heroClass, String nameHero, int strength, int intellect, int agility, int stamina) {
        super(heroClass, nameHero, strength, intellect, agility, stamina);
        killedMonsters = 0;
        exp = 0;
        expToLevel = 1000;
        heroInv = new Inventory();
        showInventory = false;
    }


    @Override
    public abstract void calculateSecondaryParameters();

    @Override
    public void getInfo() {
        System.out.println(charClass + " " + charName + ". hp: " + hp + "/" + hpMax + ", опыт: " + exp + "/"
                + expToLevel + ", уровень: " + level +
                            ". Убито монстров: " + killedMonsters);
    }

    public abstract void levelUp (int numLevels);

    public void addExp(int addExp) {
        exp += addExp;

        if (exp >= expToLevel) {

            do {
                exp -= expToLevel;
                levelUp(1);

                if (exp < expToLevel) {
                    break;
                }
            } while (exp >= expToLevel);
        }
    }

    public int inputNum() {
        int inputNum = Utilites.getAction(0, 3, "1 - атака, 2 - защита, 3 - инвентарь, 0 - убежать");
        return inputNum;
    }



}
