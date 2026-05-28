class Character {
    private String name;
    private int hp;
    private int maxHp;
    private int attack;

    Character(String name, int hp, int maxHp, int attack) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
    }

    void takeDamage(int) {
        
    }

    void heal(int) {

    }

    void levelUp() {

    }

    boolean isAlive() {

    }

    void showStatus() {

    }
}

class Warrior extends Character {
    int armor;

    Warrior(String name, int hp, int maxHp, int attack, int armor) {
        super(name, hp, maxHp, attack);
        this.armor = armor;
    }
}

class Mage extends Character {
    int mana;

    Mage(String name, int hp, int maxHp, int attack, int mana) {
        super(name, hp, maxHp, attack);
        this.mana = mana;
    }
}

class Archer extends Character {
    int arrows;

    Archer(String name, int hp, int maxHp, int attack, int arrows) {
        super(name, hp, maxHp, attack);
        this.arrows = arrows;
    }
}

public class RPGGame {
    public static void main(String[] args) {

        Mage m = new Mage("Vexana", 2000, 2000, 300, 100);
        Warrior w = new Warrior("Ruby", 2000, 2000, 300, 100);
        Archer a = new Archer("Granger", 2000, 2000, 300, 15);

    }
}
