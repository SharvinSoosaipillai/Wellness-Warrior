#include <DHT.h>

// Define the pin to which the DHT sensor is connected
#define DHTPIN 9
// Define the type of DHT sensor 
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
    // Attempt to read the humidity value from the DHT sensor.
    float humidity = dht.readHumidity();

    if (!isnan(humidity))
    {
        // Send humidity as a plain string to the serial port
        Serial.println(humidity);
    }
    else
    {
        Serial.println("Failed to read humidity from DHT sensor!");
    }

    delay(1000);
}
