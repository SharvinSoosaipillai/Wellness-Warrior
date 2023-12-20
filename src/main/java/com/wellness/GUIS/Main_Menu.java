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

import com.wellness.Constants.Constants;

public class Main_Menu {
    private JFrame frame = new JFrame();
    private JPanel firstPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5)), 
                   secondJPanel = new JPanel(new BorderLayout()), 
                   thirdJPanel = new JPanel(new GridLayout(2, 2, 20, 20));

    private JLabel title = new JLabel("WELLNESS WARRIOR"), 
                   heartText = new JLabel("HeartRate: 0"), 
                   humidityText = new JLabel("get user humidity"), 
                   temperatureText = new JLabel("get user temp"), 
                   userText = new JLabel("get username"), 
                   bloodText = new JLabel("get blood oxygen text");

    private JButton humidityTestButton = new JButton("Test Humidity"), 
                    HeartRateTestButton = new JButton("Test Heartrate"),
                    TemperatureTestButton = new JButton("Test Temperature"), 
                    BloodOxygenTestButton = new JButton("Test BloodOxygen Levels"),
                    exitButton = new JButton("Exit");





    public Main_Menu() {
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

        // Setting the title element
        this.title.setBackground(Constants.BACKGROUN_COLOR_1);
        this.title.setForeground(Constants.TEXT_COLOR);
        this.title.setFont(new Font("Dialog", Font.BOLD, 40));
        this.title.setHorizontalAlignment(SwingConstants.CENTER);

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



    private ImageIcon createScaledImageIcon(String imagePath, int width, int height) {
        return new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    private JLabel createJLabel(ImageIcon icon) {
        return new JLabel(icon);
    }

    private JButton createButtonWithImage(String imagePath, int width, int height, String buttonText) {
        JButton button = new JButton(buttonText);
        button.setBackground(Constants.BLACK);
        ImageIcon icon = createScaledImageIcon(imagePath, width, height);
  
        button.setIcon(icon);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setForeground(Constants.TEXT_COLOR2);
        button.setFont(new Font("Dialog", Font.BOLD, 20)); 
        button.setIconTextGap(20); 
        button.setFocusPainted(false);


        return button;
    }


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
