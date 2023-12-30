#include <DHT.h>

// Define the pin to which the DHT sensor is connected
#define DHTPIN 9
// Define the type of DHT sensor (DHT11 or DHT22)
#define DHTTYPE DHT11

// Create an instance of the DHT class
DHT dht(DHTPIN, DHTTYPE);

void setup()
{
    // Initialize serial communication to allow debugging and data readout.
    // Using a baud rate of 9600 bps.
    Serial.begin(9600);
    // Initialize the DHT sensor
    dht.begin();
}

void loop()
{
    // Attempt to read the temperature value from the DHT sensor.
    int temperature = dht.readTemperature();


    if (!isnan(temperature))
    {
        // Send temperature as a plain string to the serial port
        Serial.println(temperature);
        
    }
    else
    {
        Serial.println("Failed to read temperature from DHT sensor!");
    }

}
