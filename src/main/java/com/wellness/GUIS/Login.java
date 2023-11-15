package com.wellness.GUIS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.IOException;
// import java.awt.Graphics;
// import java.awt.event.ActionEvent;

// import javax.imageio.ImageIO;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login extends JFrame{
    private JFrame frame = new JFrame();
    private JButton testButton = new JButton("This is a button");;
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
    private JLabel logo;
    ImageIcon image;


    public Login(){
        initalize();
    }

    private void initalize(){
        try {
            image = new ImageIcon("misc/Images/icon.png");
            logo = new JLabel(image);
            logo.setSize(200,200);
        } catch (Exception e){

        }
        this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage("misc/Images/icon.png"));
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setTitle("Wellness Warrior");
        this.frame.setSize(400,600);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setName("Wellness Warrior");
        this.frame.setResizable(false);
        

        panel.setBackground(Color.decode("#000000"));
        this.frame.add(logo, BorderLayout.CENTER);
        this.frame.add(panel, BorderLayout.CENTER);



        
        // ADD THIS LATER ONCE YOU UNDERSTAND HOW TO INHERIT IT PROPERLY
        // this.testButton.addActionListener(this);


        // panel.setBackground(Color.RED);

        



    }
    public void add(ActionListener ae){
        
    }

}
