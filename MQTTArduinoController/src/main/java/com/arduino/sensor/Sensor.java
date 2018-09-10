package com.arduino.sensor;

public interface Sensor {
    long getReading();

    void setReading(final long p_reading);

    // Compare two sensor values
    boolean equals(final Sensor p_compare);

    // Returns true if a Useful Value is detected
    boolean detected();

    // Returns the type of Sensor Used as String
    String getType();

    // Converts to String
    String toString();

    // Get Sensor Value from String
    void convertFromString(final String p_sensor_reading);
}
