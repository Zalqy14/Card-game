public class Player {
    protected int playerHp;
    private String name;

    public Player() {
        this.playerHp = 100;
        this.name = "Machine";
    };

    public Player(String playerName) {
        this.playerHp = 100;
        this.name = playerName;
    }

    public void hpDamage(int damage) {
        this.playerHp -= damage;
    };

    public void hpHealing(int healing) {
        this.playerHp += healing;
    };

    public int getPlayerHp() {
        return playerHp;
    }

    public String getPlayerName() {
        return name;
    }

    public String hpInfo() {
        return getPlayerName() + " Hp: " + getPlayerHp();
    }
}
