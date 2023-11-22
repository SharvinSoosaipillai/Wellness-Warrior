package com.wellness.GUIS;


import java.awt.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.wellness.Constants.Constants;



public class Main_Menu {
    
    private JFrame frame = new JFrame();
    private JPanel firstPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,5)), secondJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,5)), thirdJPanel =  new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
    private JLabel title = new JLabel("WELLNESS WARRIROR");

    public Main_Menu(){
        initalize();
    }

    public void initalize(){
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage("misc/Images/icon.png"));
        this.frame.setSize(800,600);
        this.frame.setName("Wellness Warrior");
        this.frame.setResizable(false);
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null);


        this.title.setBackground(Constants.BACKGROUN_COLOR_1);
        this.title.setForeground(Constants.TEXT_COLOR);
        this.title.setFont(new Font("Dialog", Font.BOLD, 40));

        // JPanel Code
        Dimension preferredJPaneloneSize = new Dimension(200, 600);
        this.firstPanel.setPreferredSize(preferredJPaneloneSize);
        this.firstPanel.setBackground(Constants.LIGHTBLACK);
        
        // JPanel 2
        Dimension preferredJPaneltwoSize = new Dimension(800, 75);
        this.secondJPanel.setPreferredSize(preferredJPaneltwoSize);
        this.secondJPanel.setBackground(Constants.BLACK);
        this.secondJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // JPanel 3
        this.thirdJPanel.setBackground(Constants.BACKGROUN_COLOR_1); // Set background color for visibility
        this.thirdJPanel.setLayout(new BorderLayout()); // Set BorderLayout to fill the available space


        
        this.frame.add(firstPanel, BorderLayout.WEST);
        this.frame.add(secondJPanel, BorderLayout.NORTH);
        this.frame.add(thirdJPanel, BorderLayout.CENTER);


        this.secondJPanel.add(title);
        






    }




}
