import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception {

        boolean surrender = true;
        Scanner text = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player();
        Player machine1 = new Player();

        // Decks of cards
        ArrayList<Card> deck1 = new ArrayList<>();
        ArrayList<Card> deck2 = new ArrayList<>();

        // Gives Cards to the decks
        for (int i = 1; i < 5; i++) {
            Card card = new Card();
            Card card2 = new Card();
            deck1.add(card);
            deck2.add(card2);
        }
        // Game Information
        info();

        // Displays the current players HP
        do {
            System.out.println(player1.hpInfo());
            System.out.println(machine1.hpInfo());
            menuOptions();
            int option = text.nextInt();
            switch (option) {
                case 1:
                    // Round 1 Player on the offence
                    int cardNumber = 1;
                    System.out.println("*** Deck ***");
                    for (Card i : deck1) {
                        System.out.println("*** Card " + cardNumber + " ***");
                        System.out.println(i);
                        System.out.println("*********");
                        cardNumber++;
                    }
                    System.out.println("What Card do you choose Ofence");
                    int cardChosen = sc.nextInt() - 1;
                    Random rand = new Random();
                    int numberMachine = rand.nextInt(deck2.size());
                    Card machine = deck2.get(numberMachine);
                    // Todo remove The show case and make something better
                    // Card Showcase
                    System.out.print("------\nPlayer Card: \n" + deck1.get(cardChosen) + "\n------");
                    System.out.print("------\nMachine Card: \n" + deck2.get(numberMachine) + "\n------");

                    // Result of battle
                    int result = Game.battle(deck1.get(cardChosen), machine);
                    if (result == 13) {
                        System.out.println("New Hp of Card : " + deck2.get(numberMachine).getHp());
                    } else if (result == 14) {
                        System.out.println("Card Destroyed");
                        deck2.remove(numberMachine);
                        System.out.println("Cards left: " + deck2.size());
                        // If the hp from card is destroyed the remaining hp is subtracted from Machine
                    } else {
                        System.out.println("Your attack: " + deck1.get(cardChosen).getAttack() + "\nTheir Deffence: "
                                + deck2.get(numberMachine).getDef());
                    }
                    if (deck2.size() == 0) {
                        System.out.println("You have won the game");
                        surrender = false;
                    }
                    // Round 2 Player on the defence
                    cardNumber = 1; // Reset The card number back to 1 from original
                    System.out.println("*** Deck ***");
                    for (Card i : deck1) {
                        System.out.println("*** Card " + cardNumber + " ***");
                        System.out.print(i);
                        System.out.println("*********");
                        cardNumber++;
                    }
                    // Card election
                    System.out.println("What Card do you choose Defence");
                    cardChosen = sc.nextInt() - 1;
                    rand = new Random();
                    numberMachine = rand.nextInt(deck2.size());
                    machine = deck2.get(numberMachine);

                    // Todo remove The show case and make something better
                    // Card Showcase
                    System.out.print("------\nPlayer Card: \n" + deck1.get(cardChosen) + "\n------");
                    System.out.print("------\nMachine Card: \n" + deck2.get(numberMachine) + "\n------");
                    // Result of battle
                    result = Game.battle(machine, deck1.get(cardChosen));
                    if (result == 13) {
                        System.out.println("New Hp of Card : " + deck1.get(cardChosen).getHp());
                    } else if (result == 14) {
                        System.out.println("Card Destroyed");
                        deck1.remove(cardChosen);
                        System.out.println("Cards left: " + deck1.size());
                        // If the hp from card is destroyed the remaining hp is subtracted from player
                    } else {
                        System.out
                                .println("Their attack: " + deck2.get(numberMachine).getAttack() + "\nYour Defence: "
                                        + deck1.get(cardChosen).getDef());
                        System.out.println("You Won The Defence");
                    }
                    if (deck1.size() == 0) {
                        System.out.println("You have lost the game");
                        surrender = false;
                    }
                    break;
                case 2:
                    // Heal kinda not gonna do this :o
                    /*
                     * Have to trak when a card is destroyed and is gives the player a tipe of bonus
                     * or object for the player to heal. Should heal like 5 hp or maybe instead fo
                     * heal can add bonus to a card for the next round. Will do in future
                     * 
                     */

                    break;
                case 3:
                    // Surrender
                    System.out.println("Game Over :) ");
                    surrender = false;
                    break;
                default:
                    break;
            }
        } while (surrender);
        text.close();
        sc.close();
    }

    public static void info() {
        System.out.println("-+-+- Welcome To Seal Wars -+-+-");
        System.out.println(
                "This is a card game where you battle againt your opponent with cards\neach player can use a card once each player has 100 hp you can heal when you win against the opponents card");
    }

    public static void menuOptions() {
        System.out.println("Options: \n1. Use Card\n2. Heal \n3. Surrender");
    }

    // Battle function where is compared in attack vs defence
    public static int battle(Card one, Card two) {
        int attack = one.getAttack();
        int defence = two.getDef();
        int hp = two.getHp();
        if ((attack - defence) > 0) {
            if ((attack - defence) <= hp) {
                two.damageHp(attack, defence);
                // Hp reduction
                return 13;
            } else {
                // Card Destroyed
                return 14;
            }
        } else {
            // Loose Battle Show Stats
            return 15;
        }
    }
}
