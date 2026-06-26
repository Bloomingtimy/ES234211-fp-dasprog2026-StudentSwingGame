package FPGame;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    private Player currentPlayer;

    public MainMenuFrame(Player player){

        this.currentPlayer = player;

        setTitle("Main Menu");
        setSize(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4,1));

        JButton startButton = new JButton("Start Game");
        JButton statButton = new JButton("My Statistics");
        JButton topButton = new JButton("Top 5 Scorers");
        JButton exitButton = new JButton("Exit");

        add(startButton);
        add(statButton);
        add(topButton);
        add(exitButton);


        // START GAME

        startButton.addActionListener(e -> {
            GameFrame game = new GameFrame(currentPlayer);
            game.setVisible(true);
            dispose();

        });


        // STATISTICS

        statButton.addActionListener(e -> {
            StatisticsFrame stat = new StatisticsFrame(currentPlayer);
            stat.setVisible(true);
        });


        // TOP 5

        topButton.addActionListener(e -> {
            TopScorersFrame top = new TopScorersFrame();
            top.setVisible(true);
        });



        // EXIT

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

    }

}