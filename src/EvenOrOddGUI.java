//frontend
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EvenOrOddGUI extends JFrame implements ActionListener{
    //private variables
    private JLabel computerScoreLabel, playerScoreLabel;
    private JLabel computerChoiceLabel;
    private JLabel resultLabel;
    private JButton evenButton, oddButton, oneButton, twoButton;
    private EvenOrOdd evenOrOdd;
    String playerNum;
    String playerChoice;

    //constructor
    public EvenOrOddGUI() {
        super("Even Or Odd");
        setSize(500, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        evenOrOdd = new EvenOrOdd();
        addGuiComponents();
    }
    
    //helper methods
    public void addGuiComponents() {
        //define computerScoreLabel, with the label text
        computerScoreLabel = new JLabel("Computer: 0");

        //Give the label its position and dimensions using setBound
        computerScoreLabel.setBounds(0, 50, 500, 40);

        //Change the font of the label text
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));

        //Make the text centered horizontally
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add to the JFrame
        add(computerScoreLabel);

        //Necessary calls for computerChoiceLabel
        computerChoiceLabel = new JLabel("?");
        computerChoiceLabel.setBounds(200, 130, 100, 80);
        computerChoiceLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        computerChoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoiceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoiceLabel);

        //Necessary calls for resultLabel
        resultLabel = new JLabel("Game Result");
        resultLabel.setBounds(100, 250, 300, 100);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        //Necessary calls for oddButton
        oddButton = new JButton("Odd");
        oddButton.setBounds(75, 380, 150, 80);
        oddButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        oddButton.setHorizontalAlignment(SwingConstants.CENTER);
        oddButton.addActionListener(this);
        add(oddButton);

        //Necessary calls for evenButton
        evenButton = new JButton("Even");
        evenButton.setBounds(275, 380, 150, 80);
        evenButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        evenButton.setHorizontalAlignment(SwingConstants.CENTER);
        evenButton.addActionListener(this);
        add(evenButton);

        //Necessary calls for choice 1
        oneButton = new JButton("1");
        oneButton.setBounds(75, 480, 150, 80);
        oneButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        oneButton.setHorizontalAlignment(SwingConstants.CENTER);
        oneButton.addActionListener(this);
        add(oneButton);

        //Necessary calls for choice 2
        twoButton = new JButton("2");
        twoButton.setBounds(275, 480, 150, 80);
        twoButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        twoButton.setHorizontalAlignment(SwingConstants.CENTER);
        twoButton.addActionListener(this);
        add(twoButton);

        //Necessary calls for playerScoreLabel
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0, 600, 500, 40);
        playerScoreLabel.setFont(new Font("Dialong", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == evenButton || e.getSource() == oddButton) {
            playerChoice = e.getActionCommand().toString();
            return;
        }
        //Get player number
        playerNum = e.getActionCommand().toString();

        //Start the game now that the player has chosen
        resultLabel.setText(evenOrOdd.playEvenOrOdd(playerChoice, playerNum));

        //load computer choice visually
        computerChoiceLabel.setText(evenOrOdd.getComputerNum());

        //Update computer score and player score visually
        playerScoreLabel.setText("Player: " + evenOrOdd.getPlayerScore());
        computerScoreLabel.setText("Computer: " + evenOrOdd.getComputerScore());
    }
}
