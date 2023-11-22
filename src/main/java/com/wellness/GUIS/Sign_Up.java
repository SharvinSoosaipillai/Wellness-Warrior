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
import com.wellness.Constants.Constants;
import com.wellness.Backend.Validation;


public class Sign_Up {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
    private JLabel usernameText = new JLabel("Username"), heading = new JLabel("Sign Up"), passwordText = new JLabel("Password"), passwordReEnterText = new JLabel("Re-Enter Password"), backToHome = new JLabel("Back to Login");
    private JTextField usernameInput = new JTextField();
    private JPasswordField passwordInput = new JPasswordField(), passwordInputConfirm = new JPasswordField();
    private JButton Create = new JButton("Create");
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
       

        // Adding Username Input
        this.usernameInput.setBounds(60,175,275,35);
        this.usernameInput.setBackground(Constants.BACKGROUN_COLOR_1);
        this.usernameInput.setForeground(Constants.TEXT_COLOR);
        this.usernameInput.setFont(new Font("Dialog", Font.BOLD, 20));

        // Adding Password text
        this.passwordText.setBounds(50,200, 100, 100);
        this.passwordText.setFont(new Font("Dialog", Font.BOLD, 20));
        this.passwordText.setForeground(Constants.TEXT_COLOR);


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


        // Adding the back to home feature at the bottom
        this.backToHome.setFont(new Font("Dialog", Font.BOLD, 15));
        this.backToHome.setForeground(Constants.TEXT_COLOR);
        this.backToHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // set the size dynamically
        Dimension backtoHomeDimension = this.backToHome.getPreferredSize();
        this.backToHome.setBounds(145, 540, (backtoHomeDimension.width + 5), backtoHomeDimension.height);

        this.backToHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                Sign_Up.this.frame.dispose();
                Login login = new Login();

            }
        });



        // create User Button Button
        this.Create.setBounds(145,475,100,30);
        this.Create.setHorizontalAlignment(JButton.CENTER);
        this.Create.setFont(new Font("Dialog", Font.BOLD, 15));
        this.Create.setForeground(Constants.TEXT_COLOR);
        this.Create.setBackground(Constants.BACKGROUN_COLOR_1);
        this.Create.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = Sign_Up.this.usernameInput.getText();
                String password = new String(Sign_Up.this.passwordInput.getPassword());
                String confirmPassword = new String(Sign_Up.this.passwordInputConfirm.getPassword());
                
                // creating instance of validation class to use functions from that class
                Validation validator = new Validation();
                
                // checks to see if the information entered was valid
                if (validator.validatePassword(username,password,confirmPassword, Constants.connectionString)){

                    validator.addUser(username, password, Constants.connectionString);
                    Sign_Up.this.frame.dispose();
                    Login login = new Login();


                } else {
                    JOptionPane.showMessageDialog(frame, "Username exists, please try a different name");
                }
            }
        });


        // Adding all of the elements 
        this.frame.add(heading);
        this.frame.add(backToHome);
        this.frame.add(passwordReEnterText);
        this.frame.add(passwordInputConfirm);
        this.frame.add(usernameInput);
        this.frame.add(usernameText);
        this.frame.add(passwordText);
        this.frame.add(passwordInput);
        this.frame.add(Create);
        this.frame.add(panel, BorderLayout.CENTER);
        
        // ADD THIS LATER ONCE YOU UNDERSTAND HOW TO INHERIT IT PROPERLY
        // this.testButton.addActionListener(this);




    }


}
