package FPGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GameFrame extends JFrame {
    private Player player;
    private GameLogic logic;
    private JButton[][] buttons;
    private char turn='X';

    public GameFrame(Player player){
        this.player = player;
        logic = new GameLogic();

        setTitle("Tic Tac Toe Game");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3,3));

        buttons = new JButton[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int row = i;
                int col = j;

                buttons[i][j] = new JButton(" ");

                buttons[i][j].setFont(
                        new Font("Arial", Font.BOLD, 40)
                );
                buttons[i][j].addActionListener(e -> {
                    playerMove(row,col);
                });

                add(buttons[i][j]);

            }

        }

    }


    private void playerMove(
            int row,
            int col
    ){
        if(logic.makeMove(row, col, 'X')){
            buttons[row][col].setText("X");

            if(logic.checkWin('X')){
                PlayerService service = new PlayerService();

                service.updateResult(player.getUsername(), "WIN");

                JOptionPane.showMessageDialog(this, "You Win!");

                dispose();
                return;
            }

            computerMove();

        }

    }


    private void computerMove(){
        Random r = new Random();

        int row,col;

        do{
            row=r.nextInt(3);
            col=r.nextInt(3);
        }while(!logic.makeMove(row, col, 'O'));

        buttons[row][col].setText("O");

        if(logic.checkWin('O')){
            PlayerService service = new PlayerService();

            service.updateResult(player.getUsername(), "LOSS");

            JOptionPane.showMessageDialog(this, "Computer Wins!");

            dispose();
            return;
        }

        else if(logic.isDraw()){
            PlayerService service = new PlayerService();

            service.updateResult(player.getUsername(), "DRAW");

            JOptionPane.showMessageDialog(this, "Draw!");

            dispose();
            return;
        }
    }
}