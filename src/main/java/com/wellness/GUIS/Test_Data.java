package com.wellness.GUIS;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;

import com.wellness.Constants.Constants;
import com.wellness.Backend.User;


public class Test_Data {
 
    private int testType;
    private User user;
    
    public Test_Data(int Type_of_Test, User username){
        this.testType = Type_of_Test;
        this.user = username;
        initialize();
    }

    private JFrame frame = new JFrame();
    private JLabel title = new JLabel("WELLNESS WARRIOR");


    public void initialize() {
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage("misc/Images/icon.png"));
        this.frame.setSize(800, 600);
        this.frame.setName("Wellness Warrior");
        this.frame.setResizable(false);
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null);

        // Setting the title element
        this.title.setBackground(Constants.BACKGROUN_COLOR_1);
        this.title.setForeground(Constants.TEXT_COLOR);
        this.title.setFont(new Font("Dialog", Font.BOLD, 40));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);

        // Setting text element values


    }


    
}
