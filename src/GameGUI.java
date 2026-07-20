import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class GameGUI {

    // Decks of cards
    ArrayList<Card> deckPlayer = new ArrayList<>();
    ArrayList<Card> deckMachine = new ArrayList<>();

    public GameGUI() {
        // Creates the window
        JFrame GameFrame = new JFrame("Test Windows");
        GameFrame.setLayout(new BorderLayout());
        GameFrame.setSize(400, 300);
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adds the menu
        JPanel menuLayout = new JPanel();
        menuLayout.setLayout(new GridLayout());
        GameFrame.add(menuLayout, BorderLayout.CENTER);
        JButton button1 = new JButton("Battle");
        JButton button2 = new JButton("Heal");
        JButton button3 = new JButton("End Game");
        menuLayout.add(button1);
        menuLayout.add(button2);
        menuLayout.add(button3);

        // Asks Player Name
        JPanel playerInfo = new JPanel();
        playerInfo.setLayout(new GridLayout());
        JLabel myLabel = new JLabel("What is yout Name");
        JTextField playerName = new JTextField();
        JButton submitName = new JButton("Submit Name");
        playerInfo.add(myLabel);
        playerInfo.add(playerName);
        playerInfo.add(submitName);
        GameFrame.add(playerInfo, BorderLayout.NORTH);
        submitName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(playerName.getText());
                System.out.println(player.hpInfo());
                GameFrame.remove(playerInfo);
                GameFrame.add(menuLayout);
                GameFrame.revalidate();
                GameFrame.repaint();
            }
        });

        // Adds The cardLayout
        JPanel cardLayout = new JPanel();
        cardLayout.setLayout(new GridLayout());
        JButton card1 = new JButton("Card 1");
        JButton card2 = new JButton("Card 2");
        JButton card3 = new JButton("Card 3");
        cardLayout.add(card1);
        cardLayout.add(card2);
        cardLayout.add(card3);

        // Battle button
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameFrame.remove(menuLayout);
                GameFrame.add(cardLayout, BorderLayout.CENTER);
                GameFrame.revalidate();
                GameFrame.repaint();
            }
        });
        GameFrame.setVisible(true);

    }
}