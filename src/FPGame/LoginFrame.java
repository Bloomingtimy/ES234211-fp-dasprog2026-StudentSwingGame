package FPGame;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;


    public LoginFrame(){

        setTitle("Login Game");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Login");


        add(new JLabel("Username"));
        add(usernameField);

        add(new JLabel("Password"));
        add(passwordField);

        add(loginButton);



        loginButton.addActionListener(e -> {


            PlayerService service =
                    new PlayerService();


            Player player =
                    service.login(
                            usernameField.getText(),
                            new String(passwordField.getPassword())
                    );


            if(player != null){

                JOptionPane.showMessageDialog(
                        this,
                        "Login Success"
                );

                MainMenuFrame menu = new MainMenuFrame(player);
                menu.setVisible(true);
                dispose();


            }else{

                JOptionPane.showMessageDialog(
                        this,
                        "Login Failed"
                );

            }

        });


    }
}