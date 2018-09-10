package com.arduino;

public class Constants {

    public static final String MQT_CLIENT_ID = "MQTT Desktop Application";

    public static final String MQTT_BROKER = "tcp://io.adafruit.com:1883";

    public static final String APP_NAME = "Arduino Communicator DLDA";

    public static final String MQTT_USER_NAME = "dldaminiproject";
    public static final char[] MQTT_USER_KEY = "1093a17ba6e4473a816909540c727919".toCharArray();

    public static final String MQTT_TOPIC = MQTT_USER_NAME + "/feeds/arduinoiot";

    public static final String PROXIMITY_SENSOR_TYPE = "PSS";
    public static final String TEMPERATURE_SENSOR_TYPE = "TSS";

    public static final String ENABLE_PROXIMITY_SENSOR = "ENABLE_" + PROXIMITY_SENSOR_TYPE;
    public static final String ENABLE_TEMPERATURE_SENSOR = "ENABLE_" + TEMPERATURE_SENSOR_TYPE;

    public static final String DISABLE_SENSORS = "DISABLE";

    public static final String LOCK_FILE_NAME = "MQTT_LOCK.lck";
}
