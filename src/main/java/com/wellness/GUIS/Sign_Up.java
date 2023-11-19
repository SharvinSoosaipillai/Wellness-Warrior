package com.wellness.GUIS;

// import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import com.wellness.Constants.Constants;

public class Sign_Up {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
    private JLabel usernameText = new JLabel("Username"), heading = new JLabel("Sign Up"), passwordText = new JLabel("Password"), passwordReEnterText = new JLabel("Re-Enter Password"), signUp = new JLabel("Back to Login");
    private JTextField usernameInput = new JTextField();
    private JPasswordField passwordInput = new JPasswordField(), passwordInputConfirm = new JPasswordField();
    private JButton login = new JButton("Create");
    ImageIcon image;


    public Sign_Up(){
        initalize();
    }

    private void initalize(){

        // Initialize the frame
        this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage("misc/Images/icon.png"));
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setTitle("Wellness Warrior");
        this.frame.setSize(400,600);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setName("Wellness Warrior");
        this.frame.setResizable(false);
        this.frame.setLayout(null);
        this.frame.getContentPane().setBackground(Color.BLACK);
        
        // Adding Panel features
        this.panel.setBackground(Constants.BLACK);


        this.heading.setForeground(Constants.TEXT_COLOR);
        this.heading.setFont(new Font("Dialog", Font.BOLD, 30));
        this.heading.setBounds(145,20,150,100);


        // // Adding username text
        this.usernameText.setBounds(50,100, 100, 100);
        this.usernameText.setFont(new Font("Dialog", Font.BOLD, 20));
        this.usernameText.setForeground(Constants.TEXT_COLOR);

        // Adding Password text
        this.passwordText.setBounds(50,200, 100, 100);
        this.passwordText.setFont(new Font("Dialog", Font.BOLD, 20));
        this.passwordText.setForeground(Constants.TEXT_COLOR);


        // Adding Username Input
        this.usernameInput.setBounds(60,175,275,35);
        this.usernameInput.setBackground(Constants.BACKGROUN_COLOR_1);
        this.usernameInput.setForeground(Constants.TEXT_COLOR);
        this.usernameInput.setFont(new Font("Dialog", Font.BOLD, 12));


        // Adding password Input
        this.passwordInput.setBounds(60,275,275,35);
        this.passwordInput.setBackground(Constants.BACKGROUN_COLOR_1);
        this.passwordInput.setForeground(Constants.TEXT_COLOR);
        this.passwordInput.setFont(new Font("Dialog", Font.BOLD, 20));

        //reenter password text
        this.passwordReEnterText.setBounds(50,325,275,35);
        this.passwordReEnterText.setBackground(Constants.BACKGROUN_COLOR_1);
        this.passwordReEnterText.setForeground(Constants.TEXT_COLOR);
        this.passwordReEnterText.setFont(new Font("Dialog", Font.BOLD, 20));


        // Adding password Input
        this.passwordInputConfirm.setBounds(60,375,275,35);
        this.passwordInputConfirm.setBackground(Constants.BACKGROUN_COLOR_1);
        this.passwordInputConfirm.setForeground(Constants.TEXT_COLOR);
        this.passwordInputConfirm.setFont(new Font("Dialog", Font.BOLD, 20));


        // Adding the sign up feature at the bottom

        this.signUp.setBounds(145,480,100,100);
        this.signUp.setFont(new Font("Dialog", Font.BOLD, 15));
        this.signUp.setForeground(Constants.TEXT_COLOR);
        this.signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        // Login Button
        this.login.setBounds(145,475,100,30);
        this.login.setHorizontalAlignment(JButton.CENTER);
        this.login.setFont(new Font("Dialog", Font.BOLD, 15));
        this.login.setForeground(Constants.TEXT_COLOR);
        this.login.setBackground(Constants.BACKGROUN_COLOR_1);
        this.login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.signUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                Sign_Up.this.frame.dispose();
                Login main = new Login();
                
            }
        });


        // Adding all of the elements 
        this.frame.add(heading);
        this.frame.add(signUp);
        this.frame.add(passwordReEnterText);
        this.frame.add(passwordInputConfirm);
        this.frame.add(usernameInput);
        this.frame.add(usernameText);
        this.frame.add(passwordText);
        this.frame.add(passwordInput);
        this.frame.add(login);
        this.frame.add(panel, BorderLayout.CENTER);





        
        // ADD THIS LATER ONCE YOU UNDERSTAND HOW TO INHERIT IT PROPERLY
        // this.testButton.addActionListener(this);


        // panel.setBackground(Color.RED);

        



    }
}
