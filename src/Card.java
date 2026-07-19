import java.util.Random;

public class Card {

    private int attack;
    private int def;
    private int hp;
    private static Random rand = new Random();

    public Card() {
        this.attack = randomNumber();
        this.def = randomNumber();
        this.hp = randomNumber();
    };

    // Random generator of Stats
    public int randomNumber() {
        return rand.nextInt(11);
    };

    // Hard Coded Injection of stats
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setDef(int def) {
        this.def = def;
    };

    public int getDef() {
        return this.def;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    };

    // Todo: Damage system defence and attack

    public void damageHp(int num, int num2) {
        this.hp -= (num - num2);
    }

    //

    public String toString() {
        return "Attack: " + getAttack() + "\nDefence: " + getDef() + "\nHp: " + getHp();
    }
}
