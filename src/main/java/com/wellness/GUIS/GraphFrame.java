package com.wellness.GUIS;


import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortTimeoutException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;


public class GraphFrame extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private int currentTime = 0, step = 5;
    private JButton stopButton = new JButton("Stop"), restartButton = new JButton("Restart"), exitButton = new JButton("Exit");
    private SerialPort serialPort;
    private InputStream inputStream;
    private Timer timer;
    private List<Point> dataPoints;



    public GraphFrame() {
        setTitle("Graph Frame");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        dataPoints = new ArrayList<>();


        serialPort = SerialPort.getCommPort("COM3");
        
        serialPort.setBaudRate(9600); 
        serialPort.setNumDataBits(8);
        serialPort.setNumStopBits(1);
        serialPort.setParity(SerialPort.NO_PARITY);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 2000, 0);
        serialPort.openPort();
        inputStream = serialPort.getInputStream();



        timer = new Timer(50, e -> {
            updateGraph(0);
            startReadingData();
            repaint();
        });

        initializeGraph();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                startAnimation();
            }
        });
    }


    private void startReadingData() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    while (true) {
                        if (inputStream.available() > 0) {
                            byte[] buffer = new byte[1024];
                            int bytesRead = inputStream.read(buffer);
                            processSerialData(buffer, bytesRead);
                        } else {
                            Thread.sleep(500);
                        }
                    }
                } catch (SerialPortTimeoutException e ){
                    System.out.println("No Data Recieved");
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        worker.execute();
    }


    private void processSerialData(byte[] buffer, int bytesRead) {
        try {
            if (bytesRead > 0) {
                String data = new String(buffer, 0, bytesRead);
                updateGraph(Integer.parseInt(data));
            } else {
                System.err.println("Received empty data from serial port.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid data format: " + e.getMessage());
        }
    }


    private void startAnimation() {
        timer.start();
    }

    private void stopAnimation() {
        timer.stop();
    }

    private void restartAnimation() {
        currentTime = 0;
        dataPoints.clear();
        timer.start();
    }

    private void updateGraph(int sensorValue) {

        if (sensorValue != 0){
            dataPoints.add(new Point(currentTime, HEIGHT / 2 - sensorValue));
        

            currentTime += step;
            if (currentTime >= WIDTH) {
                currentTime = 0;
                dataPoints.clear();
            }
        }
    }

    private void drawGraph(Graphics g) {
        g.setColor(Color.RED);
        for (int i = 1; i < dataPoints.size(); i++) {
            Point p1 = dataPoints.get(i - 1);
            Point p2 = dataPoints.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    private void initializeGraph() {
        // Set layout manager for the main frame
        setLayout(new BorderLayout());
        setResizable(false);

        // create a new frame and add components there
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(stopButton);
        buttonPanel.add(restartButton);

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.add(exitButton);

        // Add the exit panel to the NORTH
        add(exitPanel, BorderLayout.NORTH);

        // Add the button panel to the SOUTH
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners for buttons
        restartButton.addActionListener(e -> restartAnimation());
        stopButton.addActionListener(e -> stopAnimation());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawAxis(g);
        drawGraph(g);
    }


    private void drawAxis(Graphics g) {
        int centerY = HEIGHT / 2;
        g.setColor(Color.BLACK);
        g.drawLine(5, 0, 5, HEIGHT);
        g.drawString("Y", 30, 15);

        g.drawLine(0, centerY, WIDTH, centerY);
        g.drawString("Time", WIDTH - 30, centerY);

        int desiredYAxisPoints = 30;  
        int yAxisLabelIncrement = HEIGHT / desiredYAxisPoints;
        int yLabelValue = -((desiredYAxisPoints / 2) * 24);

        for (int i = desiredYAxisPoints / 2; i >= -desiredYAxisPoints / 2; i--) {
            g.drawString(Integer.toString(yLabelValue), 10, centerY + i * yAxisLabelIncrement);
            yLabelValue += 24;
        }

        int labelIncrement = WIDTH / 30;
        for (int i = 0; i <= 30; i++) {
            int timeLabel = i;
            g.drawString(Integer.toString(timeLabel), i * labelIncrement + 10, centerY);
        }
    }

}
