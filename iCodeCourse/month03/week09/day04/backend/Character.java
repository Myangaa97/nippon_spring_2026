class Characte {
    String name;
    int hp, maxHp, level, attack;

    Characte(String name, int maxHp, int attack) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.level = 1;
        this.attack = attack;
    }

    void takeDamage(int dmg) {
        hp = Math.max(0, hp - dmg);
    }

    void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
        System.out.println(name + " " + amount + " HP сэргээлээ. HP: " + hp + "/" + maxHp);
    }

    void levelUp() {
        level++;
        attack += 5;
        maxHp += 20;
        hp = maxHp;
        System.out.println(name + " level " + level + " болов! ATK:" + attack + " HP:" + maxHp);
    }

    boolean isAlive() {
        return hp > 0;
    }

    void attackEnemy(Characte enemy) {
        System.out.println(name + " довтолж " + attack + " хохирол өгч байна.");
        enemy.takeDamage(attack);
        System.out.println(enemy.name + " HP: " + enemy.hp + "/" + enemy.maxHp);
    }

    void showStatus() {
        int bars = hp * 20 / maxHp;
        String bar = "#".repeat(bars) + "-".repeat(20 - bars);
        System.out.printf("[%s Lv%d] HP:[%s] %d/%d ATK:%d%n",
                name, level, bar, hp, maxHp, attack);
    }
}

class Warrio extends Characte {
    int armor;

    Warrio(String name) {
        super(name, 120, 15);
        this.armor = 10;
    }

    @Override
    void takeDamage(int dmg) {
        int actual = Math.max(1, dmg - armor);
        System.out.println(name + " хуяг " + (dmg - actual) + " хохирол сааруулав.");
        super.takeDamage(actual);
    }

    void shield() {
        armor += 5;
        System.out.println(name + " хамгаалалтаа нэмлээ. Хуяг: " + armor);
    }
}

class Mage extends Characte {
    int mana;

    Mage(String name) {
        super(name, 80, 25);
        this.mana = 100;
    }

    void castSpell(Characte target) {
        if (mana < 20) {
            System.out.println("Мана хүрэлцэхгүй!");
            return;
        }
        mana -= 20;
        int dmg = attack * 2;
        System.out.println(name + " ид шид хэрэглэж " + dmg + " хохирол өгч байна! Мана: " + mana);
        target.takeDamage(dmg);
    }

    @Override
    void levelUp() {
        super.levelUp();
        mana += 10;
        System.out.println("  Мана: " + mana);
    }
}

class Archer extends Characte {
    int arrows;

    Archer(String name) {
        super(name, 90, 20);
        this.arrows = 30;
    }

    void shoot(Characte target) {
        if (arrows < 2) {
            System.out.println("Сум хүрэлцэхгүй!");
            return;
        }
        arrows -= 2;
        int dmg = (int) (attack * 1.5);
        System.out.println(name + " сум харваж " + dmg + " хохирол өгч байна. Сум: " + arrows);
        target.takeDamage(dmg);
    }

    @Override
    void showStatus() {
        super.showStatus();
        System.out.println("  Сум: " + arrows);
    }
}