# Wellness Warrior
This is an all in one Java Health application that enables users to track realtime stats about their Heartrate, Humidity, Bloody Oxygen levels and Temperature. 
The Java application on host device and forwards live data to Arduino (ATmega328) through USB serial. This system operates without the need of a WiFi module.

# Configuration 
Ensure that you have the latest version of Apache Maven downloaded, along with an up to date version of the Arduino IDE and its supported libraries (DHT11 and ProtoCentral Pulse Express with MAX30102 and MAX32664D)



# Hardware
For this project, ensure that you have the following pieces of hardware:
* ATmega328 microcontroller board with USB or equivalent
* Max30102 Heartrate and SPO2 Sensor
* DHT11 Temperature and Humidity Sensor
* Wires

  
# Instalation and Execution
First, clone the repository by running 
`https://github.com/SharvinSoosaipillai/Wellness-Warrior.git`

Afterwards, install the necessary packages using:
```
mvn clean install
```

Next, run the application by running:
```
mvn exec:java
```

Finally, when running any of the tests, ensure that you have flashed the Arduino Uno with the appropriate Arduino.ino file (found in Arduino Files) through the Arduino IDE. 

