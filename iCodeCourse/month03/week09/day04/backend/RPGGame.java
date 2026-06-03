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

    void takeDamage(int damage) {
        hp = hp - damage;
    }

    void heal(int damage) {
        hp = hp + damage / 10;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    void levelUp() {
        maxHp = maxHp + 1000;
        hp = hp + 1000;
    }

    boolean isAlive() {
        if (hp > 0)
            return true;
        return false;
    }

    void showStatus() {
        System.out.println("Character Type: " + getClass().getSimpleName());
        System.out.println("Character Name: " + name);
        System.out.println("Character HP: " + hp);
        System.out.println("====================================");
    }

    String getName() {
        return name;
    }

    int getHp() {
        return hp;
    }

    int getMaxHp() {
        return maxHp;
    }

    int getAttack() {
        return attack;
    }
}

class Warrior extends Character {
    int armor;

    Warrior(String name, int hp, int maxHp, int attack, int armor) {
        super(name, hp, maxHp, attack);
        this.armor = armor;
    }

    @Override
    void takeDamage(int damage) {

    }
}

class Mage extends Character {
    int mana;

    Mage(String name, int hp, int maxHp, int attack, int mana) {
        super(name, hp, maxHp, attack);
        this.mana = mana;
    }

    void castSpell(Character target) {
        mana = mana - 20;
    }

    @Override
    void levelUp() {
        super.levelUp();
        mana += 10;
    }
}

class Archer extends Character {
    int arrows;

    Archer(String name, int hp, int maxHp, int attack, int arrows) {
        super(name, hp, maxHp, attack);
        this.arrows = arrows;
    }

    @Override
    void showStatus() {
        super.showStatus();
        System.out.println("Arrows: " + arrows);
    }
}

public class RPGGame {
    public static void main(String[] args) {

        Mage m = new Mage("Vexana", 4000, 4000, 300, 100);
        Warrior w = new Warrior("Ruby", 4000, 4000, 300, 100);
        Archer a = new Archer("Granger", 4000, 4000, 300, 15);

        m.showStatus();
        m.levelUp();
        w.showStatus();
        a.showStatus();
    }
}
