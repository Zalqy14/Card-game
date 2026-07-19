public class Player {
    protected int playerHp;

    public Player() {
        this.playerHp = 100;
    };

    // public void hpDamage(int damage) {
    // this.playerHp -= damage;
    // };

    // public void hpHealing(int healing) {
    // this.playerHp += healing;
    // };

    public int getPlayerHp() {
        return playerHp;
    }

    public String hpInfo() {
        return "Player Hp: " + getPlayerHp();
    }
}
