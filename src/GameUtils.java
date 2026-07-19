import java.util.ArrayList;

public class GameUtils {
    public static void info() {
        System.out.println("-+-+- Welcome To Seal Wars -+-+-");
        System.out.println(
                "This is a card game where you battle againt your opponent with cards\neach player can use a card once each player has 100 hp you can heal when you win against the opponents card");
    }

    public static void menuOptions() {
        System.out.println("Options: \n1. Use Card\n2. Heal \n3. Surrender");
    }

    // Battle function where is compared in attack vs defence
    public static OutComes battle(Card one, Card two, Player targetPlayer) {
        int attack = one.getAttack();
        int defence = two.getDef();
        int hp = two.getHp();
        int damage = attack - defence;
        if ((attack - defence) > 0) {
            if ((attack - defence) <= hp) {
                two.damageHp(attack, defence);
                // Hp reduction
                return OutComes.DAMAGE_HP;
            } else {
                targetPlayer.hpDamage(damage);
                // Card Destroyed
                return OutComes.CARD_DESTROYED;
            }
        } else {
            // Loose Battle Show Stats
            return OutComes.BATTLE_LOST;
        }
    }

    // Result of the standoff function
    /*
     * Should change to a switch for the three cases therefore not needing to
     * compare and go directly to the case ???
     */
    public static void battleResult(OutComes result, ArrayList<Card> targetDeck,
            ArrayList<Card> attackDeck,
            int targetIndex,
            int attackIndex) {
        if (result == OutComes.DAMAGE_HP) {
            System.out.println("New Hp of Card : " + targetDeck.get(targetIndex).getHp());
        } else if (result == OutComes.CARD_DESTROYED) {
            System.out.println("Card Destroyed");
            targetDeck.remove(targetIndex);
            System.out.println("Cards left: " + targetDeck.size());
            // If the hp from card is destroyed the remaining hp is subtracted from player
        } else {
            System.out
                    .println("Your attack: " + attackDeck.get(attackIndex).getAttack() + "\nYour Defence: "
                            + targetDeck.get(targetIndex).getDef());
            System.out.println("You Won The Defence");
        }

    }

    public static void cardShowcase(ArrayList<Card> deckPlayer, ArrayList<Card> deckmachine, int cardChosen,
            int numberMachine) {
        System.out.print("------\nPlayer Card: \n" + deckPlayer.get(cardChosen) + "\n------");
        System.out.print("------\nMachine Card: \n" + deckmachine.get(numberMachine) + "\n------");
    }

    public static void cardShowcaseBattle(int cardNumber, ArrayList<Card> deck) {
        System.out.println("*** Deck ***");
        for (Card i : deck) {
            System.out.println("*** Card " + cardNumber + " ***");
            System.out.println(i);
            System.out.println("*********");
            cardNumber++;
        }
    }

    // Checks the state of the deck if to end the game
    public static boolean gameChecker(ArrayList<Card> deck, Player tagetPlayer) {
        if (deck.size() == 0) {
            return false;
        } else if (tagetPlayer.getPlayerHp() <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
