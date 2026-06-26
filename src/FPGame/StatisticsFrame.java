package FPGame;

import javax.swing.*;
import java.awt.*;


public class StatisticsFrame extends JFrame {
    private Player currentPlayer;
    public StatisticsFrame(Player player){
        this.currentPlayer = player;

        setTitle("My Statistics");
        setSize(300,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5,1));

        JLabel title = new JLabel("Player Statistics", SwingConstants.CENTER);

        JLabel username = new JLabel("Username: " + player.getUsername());

        JLabel wins = new JLabel("Wins: " + player.getWins());

        JLabel losses = new JLabel("Losses: " + player.getLosses());

        JLabel draws = new JLabel("Draws:" + player.getDraws());

        JLabel score = new JLabel("Score: " + player.getScore());


        add(title);
        add(username);
        add(wins);
        add(losses);
        add(draws);
        add(score);

    }
}