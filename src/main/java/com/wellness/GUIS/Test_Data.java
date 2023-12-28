package com.wellness.GUIS;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.wellness.Backend.User;

// public class Test_Data extends JFrame {

//     private int testType;
//     private User user;
//     private JButton stopButton = new JButton("Stop"),
//             //confirmButton = new JButton("Confirm"),
//             restartButton = new JButton("Restart"),
//             exitButton = new JButton("Exit");

//     private static final int WIDTH = 800;
//     private static final int HEIGHT = 600;

//     private int currentTime = 0, step = 5;
//     private Timer timer;
//     private SerialPort serialPort;
//     private InputStream inputStream;
//     private List<Point> dataPoints;

//     private JFrame imageFrame; // JFrame to display the image

//     public Test_Data(int Type_of_Test, User username) {

//         this.testType = Type_of_Test;
//         this.user = username;
//         switch (this.testType) {
//             case 1:
//                 setTitle("HeartRate Test");
//                 break;
//             case 2: 
//                 setTitle("Blood Oxygen Test");
//                 break;
//             case 3:
//                 setTitle("Humidity Test");
//                 break;
//             case 4:
//                 setTitle("Temperature Test");
//                 break;
//         }

//         setSize(WIDTH, HEIGHT);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);
//         initializeGraph(); // Initialize the graph components
//         setVisible(true);


//         serialPort = SerialPort.getCommPort("COM3");
//         serialPort.setBaudRate(9600); // Set your Arduino's baud rate
//         serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 1000, 0); // Set a longer timeout
//         serialPort.openPort();
//         inputStream = serialPort.getInputStream();

//         initializeImageFrame(this.testType); // Initialize the image display frame
//         dataPoints = Collections.synchronizedList(new ArrayList<>());

//         // Initialize the timer
//         timer = new Timer(50, new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 startReadingData();
//                 updateGraph(0);
//                 repaint();
//             }
//         });
//     }


//     private void startReadingData() {
//         try {
//             while (true) {
//                 if (inputStream.available() > 0) {
//                     byte[] buffer = new byte[1024];
//                     int bytesRead = inputStream.read(buffer);
//                     processSerialData(buffer, bytesRead);
//                 } else {
//                     Thread.sleep(10);
//                 }
//             }
//         } catch (IOException | InterruptedException e) {
//             e.printStackTrace();
//         }
//     }

//     private void processSerialData(byte[] buffer, int bytesRead) {
//         try {
//             if (bytesRead > 0) {
//                 String data = new String(buffer, 0, bytesRead);
//                 System.out.println("Received data: " + data);
//                 int sensorValue = Integer.parseInt(data);
//                 updateGraph(sensorValue);
//             } else {
//                 System.err.println("Received empty data from serial port.");
//             }
//         } catch (NumberFormatException e) {
//             System.err.println("Invalid data format: " + e.getMessage());
//         }
//     }

//     private void updateGraph(int sensorValue) {
        
//         int yOffset = (int) (Math.sin(Math.toRadians(currentTime)) * HEIGHT / 4);

//         // Add current data point
//         dataPoints.add(new Point(currentTime, HEIGHT / 2 - yOffset));

//         // Increment time
//         currentTime += step;

//         // Check if reached the end of the JFrame, then reset
//         if (currentTime >= WIDTH) {
//             currentTime = 0;
//             // Clear the previous points when looping
//             dataPoints.clear();
//         }
//     }

//     private void drawGraph(Graphics g) {
//         // Draw the plotted data
//         g.setColor(Color.RED);
//         for (int i = 1; i < dataPoints.size(); i++) {
//             Point p1 = dataPoints.get(i - 1);
//             Point p2 = dataPoints.get(i);
//             g.drawLine(p1.x, p1.y, p2.x, p2.y);
//         }
//     }



//     private void initializeImageFrame(int testType) {
//         this.imageFrame = new JFrame("Image Display");
//         this.imageFrame.setSize(400, 300);
//         this.imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         // Load an image based on the test type
//         BufferedImage originalImage = null;

//         try {
//             if (testType > 2) {
//                 // Load a different image for testType greater than 2
//                 originalImage = ImageIO.read(new File("misc/Images/Icon.png"));
//             } else {
//                 // Load the default image for testType less than or equal to 2
//                 originalImage = ImageIO.read(new File("misc/Images/Temperature_And_Humidity_Circuit.png"));
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         if (originalImage != null) {
//             // Resize the image
//             int newWidth = 400; // Set the new width
//             int newHeight = 300; // Set the new height
//             Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

//             // Create a BufferedImage from the resizedImage
//             BufferedImage bufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
//             Graphics g = bufferedImage.getGraphics();
//             g.drawImage(resizedImage, 0, 0, null);
//             g.setColor(Color.BLACK);
//             g.setFont(new Font("Arial", Font.BOLD, 10)); // Set font properties

//             // Display the text on the image
//             String text1 = "Please construct the following circuit";
//             String text2 = "When finished, click this screen to continue";

//             int textX = 20;
//             int textY1 = 40; 
//             int textY2 = 60; 

//             g.drawString(text1, textX, textY1);
//             g.drawString(text2, textX, textY2);
//             g.dispose(); // Dispose of the graphics object

//             ImageIcon resizedImageIcon = new ImageIcon(bufferedImage);
//             JLabel label = new JLabel(resizedImageIcon);

//             // Add a listener to close the imageFrame when the user clicks the label
//             label.addMouseListener(new java.awt.event.MouseAdapter() {
//                 public void mouseClicked(java.awt.event.MouseEvent evt) {
//                     imageFrame.dispose(); 
//                     showGraphAfterImageClosed(); 
//                 }
//             });

//             imageFrame.add(label);

//             // Center the imageFrame on the screen
//             imageFrame.setLocationRelativeTo(null);
//             imageFrame.setVisible(true);
//         } else {
//             // Handle the case where the image couldn't be loaded
//             System.err.println("Error loading the image.");
//         }
//     }

    
//     // Initialize the graph components
//     private void initializeGraph() {
//         // Set layout manager for the main frame
//         setLayout(new BorderLayout());
//         setResizable(false);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         // create a new frame and add components there
//         JPanel buttonPanel = new JPanel();
//         buttonPanel.add(stopButton);
//         buttonPanel.add(restartButton);


//         JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//         exitPanel.add(exitButton);

//         // Add the exit panel to the NORTH 
//         add(exitPanel, BorderLayout.NORTH);

//         // Add the button panel to the SOUTH
//         add(buttonPanel, BorderLayout.SOUTH);

//         // Add action listeners for buttons


//         restartButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 restartAnimation();
//             }
//         });

//         stopButton.addActionListener(new ActionListener(){
//             @Override
//             public void actionPerformed(ActionEvent a){
//                 stopAnimation();
//             }
//         });

        
//     }



//     private void stopAnimation() {
//         timer.stop();
//     }



//     private void restartAnimation() {
//         currentTime = 0;
//         dataPoints.clear();
//         timer.start();
//     }



//     private void showGraphAfterImageClosed() {
//         // Start the animation after the imageFrame is closed
//         SwingUtilities.invokeLater(new Runnable() {
//             @Override
//             public void run() {
//                 updateGraph(0);
//                 startAnimation();
//             }
//         });
//     }


//     @Override
//     public void paint(Graphics g) {
//         super.paint(g);
//         drawAxis(g);
//         drawGraph(g);
//     }

//     private void drawAxis(Graphics g) {
//         int centerY = HEIGHT / 2;
//         int xAxisLabelY = centerY + 30; 

//         // Draw Y-axis on the left side
//         g.setColor(Color.BLACK);
//         g.drawLine(0, 0, 0, HEIGHT);
//         g.drawString("Y", 5, 15);

//         // Draw X-axis
//         g.drawLine(0, centerY, WIDTH, centerY);
//         g.drawString("Time", WIDTH - 30, xAxisLabelY);

//         // Draw values on Y-axis
//         for (int i = -HEIGHT / 2; i <= HEIGHT / 2; i += HEIGHT / 10) {
//             g.drawString(Integer.toString(i), 5, centerY - i);
//         }

//         // Draw values on X-axis
//         int labelIncrement = WIDTH / 5;
//         for (int i = 0; i <= 5; i++) {
//             int timeLabel = i; // Start from 0 and go up to 5
//             g.drawString(Integer.toString(timeLabel), i * labelIncrement + 10, xAxisLabelY); 
//         }
//     }

//     public void startAnimation() {
//         timer.start();
//     }
// }


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
