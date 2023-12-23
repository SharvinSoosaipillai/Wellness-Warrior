package com.wellness.GUIS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import com.wellness.Backend.User;

public class Test_Data extends JFrame {

    private int testType;
    private User user;
    private JButton stopButton = new JButton("Stop"),
            confirmButton = new JButton("Confirm"),
            restartButton = new JButton("Restart"),
            exitButton = new JButton("Exit");

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private int currentTime = 0;
    private int yOffset = 0;
    private int step = 5;
    private Timer timer;

    private List<Point> dataPoints;

    private JFrame imageFrame; // JFrame to display the image

    public Test_Data(int Type_of_Test, User username) {

        this.testType = Type_of_Test;
        this.user = username;
        setTitle("Graph Animation");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeGraph(); // Initialize the graph components

        setVisible(true);


        initializeImageFrame(); // Initialize the image display frame
        
        

        dataPoints = new ArrayList<>();

        // Initialize the timer
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGraph();
                repaint();
            }
        });
    }

    // Initialize the image display frame
    private void initializeImageFrame() {
        imageFrame = new JFrame("Image Display");
        imageFrame.setSize(400, 300);
        imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load an image (replace "your_image_file_path" with the actual path)
        ImageIcon imageIcon = new ImageIcon("misc/Images/Heart_Icon.png");
        JLabel label = new JLabel(imageIcon);
        imageFrame.add(label);

        // Add a listener to close the imageFrame when the user clicks the label
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageFrame.dispose(); // Close the imageFrame
                showGraphAfterImageClosed(); // Show the graph after closing the imageFrame
            }
        });

        // Center the imageFrame on the screen
        imageFrame.setLocationRelativeTo(null);
        imageFrame.setVisible(true);
    }

    // Initialize the graph components
    private void initializeGraph() {
        // You can add any initialization code for the graph here
    }

    private void showGraphAfterImageClosed() {
        // Start the animation after the imageFrame is closed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                startAnimation();
            }
        });
    }


    private void updateGraph() {
        // Update the function here (replace with your own function)
        yOffset = (int) (Math.sin(Math.toRadians(currentTime)) * HEIGHT / 4);

        // Add current data point
        dataPoints.add(new Point(currentTime, HEIGHT / 2 - yOffset));

        // Increment time
        currentTime += step;

        // Check if reached the end of the JFrame, then reset
        if (currentTime >= WIDTH) {
            currentTime = 0;
            // Clear the previous points when looping
            dataPoints.clear();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawAxis(g);
        drawGraph(g);
    }

    private void drawAxis(Graphics g) {
        int centerY = HEIGHT / 2;
        int xAxisLabelY = centerY + 30; // Adjust the position of the X-axis labels

        // Draw Y-axis on the left side
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 0, HEIGHT);
        g.drawString("Y", 5, 15);

        // Draw X-axis
        g.drawLine(0, centerY, WIDTH, centerY);
        g.drawString("Time", WIDTH - 30, xAxisLabelY);

        // Draw values on Y-axis
        for (int i = -HEIGHT / 2; i <= HEIGHT / 2; i += HEIGHT / 10) {
            g.drawString(Integer.toString(i), 5, centerY - i);
        }

        // Draw values on X-axis
        int labelIncrement = WIDTH / 5; // Adjust the number of labels displayed
        for (int i = 0; i <= 5; i++) {
            int timeLabel = i; // Start from 0 and go up to 5
            g.drawString(Integer.toString(timeLabel), i * labelIncrement + 10, xAxisLabelY); // Adjust the starting position
        }
    }

    private void drawGraph(Graphics g) {
        // Draw the plotted data
        g.setColor(Color.RED);
        for (int i = 1; i < dataPoints.size(); i++) {
            Point p1 = dataPoints.get(i - 1);
            Point p2 = dataPoints.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public void startAnimation() {
        timer.start();
    }
}
