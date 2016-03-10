package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public abstract class Hero extends GameCharacter {

    protected int killedMonsters;
    protected int exp;
    protected int expToLevel;



    public Hero(String heroClass, String nameHero, int strength, int intellect, int agility, int stamina) {
        super(heroClass, nameHero, strength, intellect, agility, stamina);
        killedMonsters = 0;
        exp = 0;
        expToLevel = 1000;
    }


    @Override
    public abstract void calculateSecondaryParameters();

    @Override
    public void getInfo() {
        System.out.println(heroClass + " " + nameHero + ". hp: " + hp + "/" + hpMax + ", опыт: " + exp + "/"
                + expToLevel + ", уровень: " + level +
                            ". Убито монстров: " + killedMonsters);
    }

    public abstract void levelUp (int numLevels);

    public void addExp(int addExp) {
        exp += addExp;

        if (exp >= expToLevel) {
            int numLevels = (int) (exp / expToLevel);

            for (int i = 1; i <= numLevels; i++) {

                if (exp < expToLevel) {
                    break;
                }

                exp -= expToLevel;
                levelUp(1);
            }
        }
    }

}
