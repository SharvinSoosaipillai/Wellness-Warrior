package com.wellness.GUIS;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.wellness.Backend.User;


public class Test_Data extends JFrame {

    private int testType;
    private User user;
    private JFrame imageFrame;
    private GraphFrame graphFrame;

    public Test_Data(int Type_of_Test, User username) {
        this.testType = Type_of_Test;
        this.user = username;
        imageFrame = new JFrame();
        imageFrame.setSize(400, 300);
        imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageFrame.setVisible(true);
        switch (this.testType) {
            case 1:
                imageFrame.setTitle("HeartRate Test");
                break;
            case 2:
                imageFrame.setTitle("Blood Oxygen Test");
                break;
            case 3:
                imageFrame.setTitle("Humidity Test");
                break;
            case 4:
                imageFrame.setTitle("Temperature Test");
                break;
        }

        BufferedImage originalImage = null;

        try {
            if (testType > 2) {
                originalImage = ImageIO.read(new File("misc/Images/Icon.png"));
            } else {
                originalImage = ImageIO.read(new File("misc/Images/Temperature_And_Humidity_Circuit.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (originalImage != null) {
            int newWidth = 400;
            int newHeight = 300;
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            BufferedImage bufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bufferedImage.getGraphics();
            g.drawImage(resizedImage, 0, 0, null);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 10));

            String text1 = "Please construct the following circuit";
            String text2 = "When finished, click this screen to continue";

            int textX = 20;
            int textY1 = 40;
            int textY2 = 60;

            g.drawString(text1, textX, textY1);
            g.drawString(text2, textX, textY2);
            g.dispose();

            ImageIcon resizedImageIcon = new ImageIcon(bufferedImage);
            JLabel label = new JLabel(resizedImageIcon);

            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    imageFrame.dispose();
                    showGraphAfterImageClosed();
                }
            });

            imageFrame.add(label);
            imageFrame.setLocationRelativeTo(null);
        } else {
            System.err.println("Error loading the image.");
        }
    }

    private void showGraphAfterImageClosed() {
        SwingUtilities.invokeLater(() -> {
            if (graphFrame == null) {
                graphFrame = new GraphFrame();
                graphFrame.setVisible(true);
            }
        });
    }

}