package com.wellness.GUIS;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wellness.Constants.Constants;
import com.wellness.Backend.User;


public class Main_Menu {

    // elements part of the class
    private User user;
    private int test;
    private JFrame frame = new JFrame();
    private JPanel firstPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5)), 
                   secondJPanel = new JPanel(new BorderLayout()), 
                   thirdJPanel = new JPanel(new GridLayout(2, 2, 20, 20));

    private JLabel title = new JLabel("WELLNESS WARRIOR"), 
                   heartText = new JLabel("HeartRate: "), 
                   humidityText = new JLabel("Humidity: "), 
                   temperatureText = new JLabel("Temperature:"), 
                   userText = new JLabel(),
                   bloodText = new JLabel("Blood %:");

    private JButton exitButton = new JButton("Exit");


    public Main_Menu(User username) {
        this.user = username;
        initialize();
    }

    public void initialize() {
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage("misc/Images/icon.png"));
        this.frame.setSize(800, 600);
        this.frame.setName("Wellness Warrior");
        this.frame.setResizable(false);
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null);

        try {
            createIconPanel("misc/Images/User_Icon.png", 32, 32, userText);
            createIconPanel("misc/Images/Heart_Icon.png", 32, 32, heartText);
            createIconPanel("misc/Images/Humidity_Icon.png", 32, 32, humidityText);
            createIconPanel("misc/Images/Temperature_Icon.png", 32, 32, temperatureText);
            createIconPanel("misc/Images/Blood_Icon.png", 32, 32, bloodText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.test = 0;

        // Setting the title element
        this.title.setBackground(Constants.BACKGROUN_COLOR_1);
        this.title.setForeground(Constants.TEXT_COLOR);
        this.title.setFont(new Font("Dialog", Font.BOLD, 40));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);

        // Setting text element values
        this.heartText.setText("HeartRate: "+ this.user.getHeartRate());
        this.humidityText.setText("humidity: " + this.user.getHumidity());
        this.userText.setText(this.user.getUsername());
        this.temperatureText.setText("Temperature: " + this.user.getTemperature());
        this.bloodText.setText("Blood %: " + this.user.getBloodOxygen());

        // JPanel1 Code
        Dimension preferredJPaneloneSize = new Dimension(200, 600);
        this.firstPanel.setPreferredSize(preferredJPaneloneSize);
        this.firstPanel.setBackground(Constants.LIGHTBLACK);
        this.firstPanel.setLayout(new GridLayout(0, 1, 10, 5));

        // JPanel 2
        Dimension preferredJPaneltwoSize = new Dimension(800, 75);
        this.secondJPanel.setPreferredSize(preferredJPaneltwoSize);
        this.secondJPanel.setBackground(Constants.BLACK);
        this.secondJPanel.setLayout(new BorderLayout());

        // Create a panel for the exit button with FlowLayout.RIGHT
        JPanel exitButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitButtonPanel.setOpaque(false); // Make the panel transparent
        exitButtonPanel.add(exitButton);

        // Add the exitButtonPanel and title to the east (right) of secondJPanel
        this.secondJPanel.add(exitButtonPanel, BorderLayout.EAST);
        this.secondJPanel.add(title, BorderLayout.CENTER);

        // JPanel 3
        this.thirdJPanel.setBackground(Constants.BACKGROUN_COLOR_1);
        this.thirdJPanel.setLayout(new GridLayout(2, 2, 20, 20));
        this.thirdJPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Adding the panels to the frame
        this.frame.add(firstPanel, BorderLayout.WEST);
        this.frame.add(secondJPanel, BorderLayout.NORTH);
        this.frame.add(thirdJPanel, BorderLayout.CENTER);

        // Adding components to the third JPanel
        this.thirdJPanel.add(createButtonWithImage("misc/Images/Heart_Icon.png", 64, 64, "Test Heart Rate"));
        this.thirdJPanel.add(createButtonWithImage("misc/Images/Humidity_Icon.png", 64, 64, "Test Humidity"));
        this.thirdJPanel.add(createButtonWithImage("misc/Images/Temperature_Icon.png", 64, 64, "Test Temperature"));
        this.thirdJPanel.add(createButtonWithImage("misc/Images/Blood_Icon.png", 64, 64, "Test Blood Level"));

    }



    // rescaling image function
    private ImageIcon createScaledImageIcon(String imagePath, int width, int height) {
        return new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    // creating new Label Icon
    private JLabel createJLabel(ImageIcon icon) {
        return new JLabel(icon);
    }

    private JButton createButtonWithImage(String imagePath, int width, int height, String buttonText) {
        JButton button = new JButton(buttonText);
        button.setBackground(Constants.BLACK);
        ImageIcon icon = createScaledImageIcon(imagePath, width, height);

        // set button attributes
        button.setIcon(icon);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setForeground(Constants.TEXT_COLOR2);
        button.setFont(new Font("Dialog", Font.BOLD, 20));
        button.setIconTextGap(20);
        button.setFocusPainted(false);

        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event
                if (e.getSource() == button) {
                    // Perform actions based on which button was clicked
                    if ("Test Heart Rate".equals(buttonText)) {
                        Main_Menu.this.frame.dispose();
                        test = 1;
                        Test_Data collectData = new Test_Data(test, user);
                    } else if ("Test Humidity".equals(buttonText)) {

                        Main_Menu.this.frame.dispose();
                        test = 2;
                        Test_Data collectData = new Test_Data(test,user);
                    } else if ("Test Temperature".equals(test)) {

                        Main_Menu.this.frame.dispose();
                        test = 3;
                        Test_Data collectData = new Test_Data(test,user);
                    } else if ("Test Blood Level".equals(buttonText)) {

                        Main_Menu.this.frame.dispose();
                        test = 4;
                        Test_Data collectData = new Test_Data(test,user);
                    }
                }
            }
        });

        return button;
    }

    // Displays leftside stats about users health
    private void createIconPanel(String imagePath, int width, int height, JLabel textLabel) {
        ImageIcon icon = createScaledImageIcon(imagePath, width, height);
        JLabel iconLabel = createJLabel(icon);

        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.X_AXIS));
        iconPanel.setBackground(Constants.LIGHTBLACK);
        iconPanel.add(iconLabel);
        iconPanel.add(textLabel);

        iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        textLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        textLabel.setForeground(Constants.TEXT_COLOR);

        this.firstPanel.add(iconPanel);
    }
}
