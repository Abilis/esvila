package ru.esvila;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Mag extends Hero{



    public Mag(String heroClass, String nameHero, int strength, int intellect, int agility, int stamina) {
        super(heroClass, nameHero, strength, intellect, agility, stamina);
    }


    @Override
    public void calculateSecondaryParameters() {

        magicAttack = (int) (intellect * 1.7);
        attack = (int)(strength * 1.2);
        defense = (int)(strength / 2);
        hp = stamina * 4;
        hpMax = hp;
        critChance = 3 + intellect / 3;
        avoidChance = 5 + agility / 3;
        baseMana = intellect * 4;
        mana = baseMana;
        manaMax = mana;
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

    @Override
    public int inputNum() {
        int inputNum = Utilites.getAction(0, 4, "1 - атака, 2 - защита, 3 - инвентарь, 4 - магическое исцеление, 0 - убежать");
        return inputNum;
    }

    @Override
    public int makeAttack() {

        if (mana < baseMana * 0.2) {
            System.out.println("Недостаточно маны для атаки!");
            return 0;
        }
        else {

            int currentAttack;
            int minCurrentAttack = (int) (magicAttack * 0.8);
            int deltaCurrentAttack = (int) (magicAttack * 0.4);

            mana -= baseMana * 0.2;

            currentAttack = minCurrentAttack + Utilites.rand.nextInt(deltaCurrentAttack);
            System.out.println(charName + " наносит удар в " + currentAttack + " единиц урона с помощью файербола");

            if (critChance > Utilites.rand.nextInt(100)) {
                currentAttack = currentAttack * 2;
                System.out.println(charName + " наносит критический удар в " + currentAttack + " единиц урона с помощью файербола!");
            }

            return currentAttack;
        }
    }

    @Override
    public void magicHeal() {

        if (mana < baseMana * 0.25) {
            System.out.println("Недостаточно маны для лечения!");
        }
        else {
            cure((int)(hpMax * 0.6));
            mana -= baseMana * 0.25;
        }

    }



}
