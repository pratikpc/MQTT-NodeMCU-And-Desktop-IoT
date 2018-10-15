package com.arduino.sensor;

import com.arduino.Constants;

public class TemperatureSensor implements Sensor {
    private final String type = Constants.TEMPERATURE_SENSOR_VALUE_START_WITH;
    private long m_celsius;

    public TemperatureSensor() {
        setReading(0);
    }

    public TemperatureSensor(final long p_reading) {
        setReading(p_reading);
    }

    public long getReading() {
        return m_celsius;
    }

    public void setReading(final long p_reading) {
        m_celsius = p_reading;
    }

    public long getReadingAsCelsius() {
        return m_celsius;
    }

    public long getReadingAsFahrenheit() {
        return (long) (m_celsius * 1.8) + 32;
    }

    public String getType() {
        return type;
    }

    public boolean equals(final Sensor p_compare) {
        // Initially verify if both are of the same type
        // If they are, check the readings
        return (p_compare != null) && (this.getType() == p_compare.getType()) && (p_compare.getReading() == this.getReading());
    }

    // Returns true if Object Detected
    public boolean detected() {
        return this.getReading() != 0;
    }

    public void convertFromString(final String p_sensor_reading) {
        if (p_sensor_reading == null)
            return;
        // Check if it Starts with Same Type
        if (p_sensor_reading.startsWith(getType())) {
            // The values are ':' Separated
            // Example Type:Value
            // So this extract Value as String
            final String sensor_read_str = p_sensor_reading.substring(p_sensor_reading.indexOf(':') + 1);
            // This String is Converted to an integer
            final int sensor_val = Integer.valueOf(sensor_read_str);

            setReading(sensor_val);
        }

    }

}
