package com.wellness.GUIS;

// import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wellness.Backend.User;
import com.wellness.Backend.Validation;
import com.wellness.Constants.Constants;


public class Login extends JFrame{

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
    private JLabel logo, usernameText = new JLabel("Username"), passwordText = new JLabel("Password"), signUp = new JLabel("Sign Up");
    private JTextField usernameInput = new JTextField();
    private JPasswordField passwordInput = new JPasswordField();
    private JButton login = new JButton("Login");
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
        this.usernameText.setBounds(50,200, 200, 200);
        this.usernameText.setFont(new Font("Dialog", Font.BOLD, 20));
        this.usernameText.setForeground(Constants.TEXT_COLOR);

        // Adding Username Input
        this.usernameInput.setBounds(60,325,275,35);
        this.usernameInput.setBackground(Constants.BACKGROUN_COLOR_1);
        this.usernameInput.setForeground(Constants.TEXT_COLOR);
        this.usernameInput.setFont(new Font("Dialog", Font.BOLD, 20));


        // Adding Password text
        this.passwordText.setBounds(50,300, 200, 200);
        this.passwordText.setFont(new Font("Dialog", Font.BOLD, 20));
        this.passwordText.setForeground(Constants.TEXT_COLOR);


        // Adding password Input
        this.passwordInput.setBounds(60,425,275,35);
        this.passwordInput.setBackground(Constants.BACKGROUN_COLOR_1);
        this.passwordInput.setForeground(Constants.TEXT_COLOR);
        this.passwordInput.setFont(new Font("Dialog", Font.BOLD, 20));

        // Adding the sign up feature at the bottom

        this.signUp.setBounds(165,480,100,100);
        this.signUp.setFont(new Font("Dialog", Font.BOLD, 15));
        this.signUp.setForeground(Constants.TEXT_COLOR);
        this.signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Dimension signupDimension = this.signUp.getPreferredSize();
        this.signUp.setBounds(165, 540, signupDimension.width, signupDimension.height);

        // transfer use to the next page
        this.signUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                Login.this.frame.dispose();
                Sign_Up signup = new Sign_Up();

            }
        });



        // Login Button
        this.login.setBounds(145,475,100,30);
        this.login.setHorizontalAlignment(JButton.CENTER);
        this.login.setFont(new Font("Dialog", Font.BOLD, 15));
        this.login.setForeground(Constants.TEXT_COLOR);
        this.login.setBackground(Constants.BACKGROUN_COLOR_1);
        this.login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = Login.this.usernameInput.getText();
                String password = new String(Login.this.passwordInput.getPassword());
                
                // creating instance of validation class to use functions from that class
                Validation validator = new Validation();
                
                // checks to see if the information entered was valid
                if (validator.checkUser(username,password, Constants.connectionString)){
                    Main_Menu main = new Main_Menu(new User(username));
                    Login.this.frame.dispose();


                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Information, Please try again");
                }
            }
        });


        // Adding all of the elements 
        this.frame.add(signUp);
        this.frame.add(usernameInput);
        this.frame.add(usernameText);
        this.frame.add(passwordText);
        this.frame.add(passwordInput);
        this.frame.add(login);
        this.frame.add(logo, BorderLayout.CENTER);
        this.frame.add(panel, BorderLayout.CENTER);


    }

}
