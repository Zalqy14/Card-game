import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception {

        boolean surrender = true;
        Scanner sc = new Scanner(System.in);
        Player machine1 = new Player();
        Random rand = new Random();

        // Decks of cards
        ArrayList<Card> deckPlayer = new ArrayList<>();
        ArrayList<Card> deckMachine = new ArrayList<>();

        // Gives Cards to the decks
        for (int i = 1; i < 5; i++) {
            Card card = new Card();
            Card card2 = new Card();
            deckPlayer.add(card);
            deckMachine.add(card2);
        }
        // Game Information
        // todo change the player to machine title
        System.out.println("Whats your Name ?");
        String playerName = sc.nextLine();
        Player player1 = new Player(playerName);
        GameUtils.info();

        // Displays the current players HP
        do {
            System.out.println(player1.hpInfo());
            System.out.println(machine1.hpInfo());
            GameUtils.menuOptions();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    // All to do with card selection and showcase of cards
                    int cardNumber = 1;
                    GameUtils.cardShowcaseBattle(cardNumber, deckPlayer);
                    System.out.println("What Card do you choose Ofence");
                    int cardChosen = sc.nextInt() - 1;

                    // This is the card that the machine chooses
                    int numberMachine = rand.nextInt(deckMachine.size());

                    // This Saves the card choosen by the machine in a object
                    Card machine = deckMachine.get(numberMachine);
                    // Todo make something better to showcase the cards
                    // Card Showcase
                    GameUtils.cardShowcase(deckPlayer, deckMachine, cardChosen, numberMachine);
                    // Round 1 Player on the offence
                    OutComes result = GameUtils.battle(deckPlayer.get(cardChosen), machine, machine1);
                    GameUtils.battleResult(result, deckMachine, deckPlayer, numberMachine, cardChosen);
                    surrender = GameUtils.gameChecker(deckMachine, machine1);
                    if (surrender == false) {
                        break;
                    }
                    // Round 2 Player on the defence
                    cardNumber = 1; // Reset The card number back to 1 from original
                    GameUtils.cardShowcaseBattle(cardNumber, deckPlayer);
                    // Card election
                    System.out.println("What Card do you choose Defence");
                    cardChosen = sc.nextInt() - 1;
                    numberMachine = rand.nextInt(deckMachine.size());
                    machine = deckMachine.get(numberMachine);

                    // Todo remove The show case and make something better
                    // Card Showcase
                    GameUtils.cardShowcase(deckPlayer, deckMachine, cardChosen, numberMachine);
                    // Result of battle
                    result = GameUtils.battle(machine, deckPlayer.get(cardChosen), player1);
                    GameUtils.battleResult(result, deckPlayer, deckMachine, cardChosen, numberMachine);
                    surrender = GameUtils.gameChecker(deckPlayer, player1);
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
        sc.close();
    }

}
