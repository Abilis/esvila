package ru.esvila;

import java.util.ArrayList;

/**
 * Created by Abilis on 10.03.2016.
 */
public class Battle {

    private static Monster currentMonster;
    public enum MonsterType {Гоблин, Нежить}
    private MonsterType type;

    private static int inputNum;
    private static int inputInv;
    private static int monsterAction;


    public static Monster createMonster(MonsterType type) {

        switch (type) {

            case Гоблин:
                currentMonster = new Goblin("Злобный гоблин", 10, 10, 10, 10);
                return currentMonster;
            case Нежить:
                currentMonster = new Undead("Восставший скелет", 10, 10, 10, 10);
                return currentMonster;
            default:
                currentMonster = new Goblin("Непонятный монстр", 5, 5, 5, 5) ;
                return currentMonster;

        }


    }

    public static Monster createRandomMonster() {

        int monsterIndex = Utilites.rand.nextInt(MonsterType.values().length); //генерируем случайное целое число от 0 до длины списка типов монстров
        MonsterType randomTypeOfMonster = MonsterType.values()[monsterIndex];   //вытаскиваем название типа монстра
        Monster randomMonster = createMonster(randomTypeOfMonster);             //генерируем этот тип монстра
        return randomMonster;

    }



    public static void startBattle(Hero hero, Monster monster) {

        System.out.println(hero.getDescription() + " и " + monster.getDescription() + " не смогли разойтись на узкой тропинке!");

        //цикл боя
        do {

            hero.getInfo();
            System.out.println("<против>");
            monster.getInfo();

            //ход героя
            hero.makeNewRoundOfBattle();

            monster.makeNewRoundOfBattle();

            inputNum = hero.inputNum();

            monsterAction = monster.getMonsterAction();
            if (monsterAction == 2) {
                monster.defenseStanse = true;
                System.out.println(monster.getName() + " встал в защитную стойку!");
            }

            switch (inputNum) {

                case 0:
                    hero.setRunaway(true);
                    break;
                case 1:
                    //атака героем
                    monster.getDamage(hero.makeAttack());
                    break;
                case 2:
                    //защита героем
                    hero.defenseStanse = true;
                    System.out.println(hero.getName() + " встал в защитную стойку!");
                    break;
                case 3:
                    //вызов инвентаря героя
                    hero.showInventory = true;
                    System.out.println("Содержимое инвентаря:");
                    hero.heroInv.showInventory();

                    inputInv = Utilites.getAction(0, hero.heroInv.getSizeInventory(), "0 - выйти из инвентаря");
                    if (inputInv != 0) {
                        Item usingItem = hero.heroInv.getItemFromInventory(inputInv - 1); //вытаскивание предмета из инвентаря по его индексу
                        if (usingItem.getType().equals(Item.ItemType.using)) {
                            System.out.println(hero.getName() + " использовал " + usingItem.toString());
                            hero.heroInv.removeItemFromInventory(usingItem);
                            hero.useItem(usingItem); //использование
                        }
                        else {
                            System.out.println("Невозможно использовать этот предмет!");
                        }
                    }
                    break;
                case 4:
                    //магическое лечение. Только для магов
                    hero.magicHeal();
                    break;
            }

            //ход монстра

            //если герой смотрел инвентарь в данной итерации, то начинаем итерацию заново
            if (hero.showInventory) {
                continue;
            }

            //ход монстра
            switch (monsterAction) {

                case 1:
                    hero.getDamage(monster.makeAttack());
                    break;

                // если монстр решил использовать защитную стойку, то это уже учтено

            }




            //проверка условия выхода из цикла боя
            if (hero.getRunaway()) {
                System.out.println(hero.getName() + " сбежал с поля боя!");
                break;
            }

            else if (!monster.alive && !hero.alive) {
                System.out.println("Все умерли!");
                break;
            }
            if (!hero.alive) {
                System.out.println(monster.getDescription() + " победил героя!");
                break;
            }
            else if (!monster.alive) {
                System.out.println(hero.getDescription() + " убил монстра " + monster.getDescription());
                hero.addExp(monster.hpMax);
                System.out.println(hero.getName() + " получил " + monster.hpMax + " опыта");
                hero.killedMonsters++;
                hero.heroInv.addGold(monster.monsterInv.getGold());
                System.out.println(hero.getName() + " забирает " + monster.monsterInv.getGold() + " золотых монет");
                Inventory.transferItemsFromFirstInvToSecondInv(monster.monsterInv, hero.heroInv);
                break;
            }


            if (hero instanceof Mag) {
                if (((Mag) hero).getMana() < ((Mag) hero).getManaMax()) {
                    hero.recovMana((int)(((Mag) hero).getBaseMana() * 0.05));
                }
            }

        } while (true);

        //после боя
        hero.getInfo();


    }



}
