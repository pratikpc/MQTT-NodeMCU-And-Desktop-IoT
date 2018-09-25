#pragma once

// Set Pin as Byte
typedef byte Pin;

// Proximity Sensor Trigger Pin
const Pin PROXIMITY_TRIGGER = D4;
// Proximity Sensor Echo Pin
const Pin PROXIMITY_ECHO = D3;

// Define the Maximum Distance of Proxmity Sensor Reading
const uint16_t PROXIMITY_MAX_DIST_CM = 100;
// Define the Minimum Distance of Proxmity Sensor Reading
const uint16_t PROXMITY_MIN_DIST_CM = 0;

// LED Connected to Pin
const Pin LED_CONNECTED = D5;

// The WIFI Details

// WiFi SSID
// This is essentially the name of the Wifi
const char WIFI_SSID[] = "WiFi";
// WIFI Password
const char WIFI_PASSWORD[] = "kanakhalivajau?";

// MQTT Broker Configuration Information

// Using Adafruit as Broker
// Note that the tcp part may have to be changed
const char MQTT_BROKER_SERVER[] = "io.adafruit.com";
// Broker Port
const uint16_t MQTT_BROKER_PORT = 1883;
// Broker Account User Name
const char MQTT_BROKER_USER_NAME[] = "dldaminiproject";
// Broker Account Key for Security
const char MQTT_BROKER_KEY[] = "1093a17ba6e4473a816909540c727919";
// Broker Client ID
const char MQTT_CLIENT_ID[] = "Arduino Client ID";
// Topic Data
const char MQTT_TOPIC[] = "dldaminiproject/feeds/arduinoiot";

// Store the Different Information Messages Received

// Message Received to Start LED
const char MSG_LED_ON[] = "LED_ON";
// Message Received to Stop LED
const char MSG_LED_OFF[] = "LED_OFF";
// Message Received to Disable All Sensors
const char MSG_DISABLE_SENSOR[] = "DISABLE";
// Enable Proximity Sensor
const char MSG_PROXIMITY_SENSOR_ENABLE[] = "ENABLE_PSS";
// Enable Temperature Sensor
const char MSG_TEMPERATURE_SENSOR_ENABLE[] = "ENABLE_TSS";
// Proximity Sensor Value Sending Code
const char MSG_PROXIMITY_SENSOR_START_CODE[] = "PSS:";
// Temperature Sensor Value Sending Code
const char MSG_TEMPERATURE_SENSOR_START_CODE[] = "TSS:";
// Arduino On Message
// Send When Arduino Initialised
const char MSG_ARDUINO_ON[] = "ARDUINO_ON";

// Store the time constants here

// Minimum Time in Which to check Loop Condition
const uint32_t MIN_TIME_LOOP_CHECK_MS = 2000;
// Minimum Time in Which to Send Data
const uint32_t MIN_TIME_DATA_SEND_MS = 3000;

// Minimum Temperature Threshold
const int16_t TEMPERATURE_MIN_CELSIUS = 20;
