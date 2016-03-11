package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Mag extends Hero{

    protected int spellPower;
    protected int mana;
    protected int manaMax;
    protected int magicAttack;

    public Mag(String heroClass, String nameHero, int strength, int intellect, int agility, int stamina) {
        super(heroClass, nameHero, strength, intellect, agility, stamina);
    }


    @Override
    public void calculateSecondaryParameters() {

        magicAttack = (int) (intellect * 1.7);
        attack = (int)(strength * 1.2);
        defense = (int)(strength / 2);
        hp = stamina * 4;
        critChance = 3 + intellect / 3;
        avoidChance = 5 + agility / 3;
        mana = intellect * 4;
        manaMax = mana;

        hp = stamina * 4;
        hpMax = hp;

    }

    @Override
    public void levelUp (int numLevels) {

        for (int i = 1; i <= numLevels; i++) {
            strength += (int) (baseStrength * 0.1);
            intellect += (int) (baseIntellect * 0.3);
            agility += (int) (baseAgility * 0.1);
            stamina += (int) (baseStamina * 0.2);
            level++;
            expToLevel *= 1.3;
        }

        calculateSecondaryParameters();
    }

    @Override
    public void getInfo() {
        System.out.println(charClass + " " + charName + ". hp: " + hp + "/" + hpMax + ", мана: " +
                mana + "/" + manaMax + ", опыт: " + exp + "/"
                + expToLevel + ", уровень: " + level +
                ". Убито монстров: " + killedMonsters);
    }

    @Override
    public void recovMana (int _mana) {

        mana += _mana;

        if (mana > manaMax) {
            _mana = manaMax - (mana - _mana);
            mana = manaMax;
        }
        System.out.println(charName + " восстановил " + _mana + " единиц маны!");
    }

}
