package com.wellness.GUIS;

// import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.event.ActionListener;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.IOException;
// import java.awt.Graphics;
// import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wellness.Constants.Constants;

public class Login extends JFrame{

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
    private JLabel logo, usernameText = new JLabel("Username"), passwordText = new JLabel("Password");
    private JTextField usernameInput = new JTextField();
    private JPasswordField passwordInput = new JPasswordField();
    ImageIcon image;


    public Login(){
        initalize();
    }

    private void initalize(){
        try {
            // Get the logo from the stored file 
            image = new ImageIcon("misc/Images/icon.png");
            Image scaledImage = image.getImage().getScaledInstance(550, 400, Image.SCALE_SMOOTH);
            image = new ImageIcon(scaledImage);
            logo = new JLabel(image);
            logo.setBounds((frame.getWidth() - 150) / 2, (frame.getHeight() - 80) / 2, 550, 400);
        } catch (Exception e){
            System.out.println("Unable to print line");
        }

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


        // // Adding username text
        this.usernameText.setBounds(50,225, 200, 200);
        this.usernameText.setFont(new Font("Dialog", Font.BOLD, 20));
        this.usernameText.setForeground(Constants.TEXT_COLOR);

        // Adding Password text
        this.passwordText.setBounds(50,325, 200, 200);
        this.passwordText.setFont(new Font("Dialog", Font.BOLD, 20));
        this.passwordText.setForeground(Constants.TEXT_COLOR);


        // Adding Username Input
        this.usernameInput.setBounds(60,350,275,35);
        this.usernameInput.setBackground(Constants.BACKGROUN_COLOR_1);
        this.usernameInput.setForeground(Constants.TEXT_COLOR);
        this.usernameInput.setFont(new Font("Dialog", Font.BOLD, 12));


        // Adding password Input
        this.passwordInput.setBounds(60,450,275,35);
        this.passwordInput.setBackground(Constants.BACKGROUN_COLOR_1);
        this.passwordInput.setForeground(Constants.TEXT_COLOR);
        this.passwordInput.setFont(new Font("Dialog", Font.BOLD, 12));


        // Adding all of the elements 
        this.frame.add(usernameInput);
        this.frame.add(usernameText);
        this.frame.add(passwordText);
        this.frame.add(passwordInput);
        this.frame.add(logo, BorderLayout.CENTER);
        this.frame.add(panel, BorderLayout.CENTER);





        
        // ADD THIS LATER ONCE YOU UNDERSTAND HOW TO INHERIT IT PROPERLY
        // this.testButton.addActionListener(this);


        // panel.setBackground(Color.RED);

        



    }
    public void add(ActionListener ae){
        
    }

}
