#include <Wire.h>
#include "MAX30105.h"
#include "heartRate.h"

MAX30105 particleSensor;

void setup()
{
  Serial.begin(9600);
  
  if (!particleSensor.begin(Wire, I2C_SPEED_FAST)) //Use default I2C port, 400kHz speed
  {
    Serial.println(F("MAX30105 not found. Please check wiring/power."));
    while (1);
  }

  Serial.println(F("Attach sensor to finger with rubber band. Press any key to start conversion"));

  // Initialize sensor settings
  particleSensor.setup();
}

void loop()
{
  // Check if a finger is placed on the sensor
  if (particleSensor.getFIFOIR() > 50000)
  {
    Serial.println("Heartbeat detected!");

    // Begin reading the heart rate and SpO2
    float heartRate = particleSensor.getHeartRate();
    float SpO2 = particleSensor.getSpO2();

    // Print the results
    Serial.print(SpO2);


    // Wait for a moment before taking the next reading
  }
    delay(2000);
}
