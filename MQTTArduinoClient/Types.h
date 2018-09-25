#pragma once

enum SensorEnabled
{
	// Disable All Sensors
	NONE,
	// Enable the Proximity Sensor
	PROXIMITY,
	// Enable the Temperature Sensor
	TEMPERATURE
};

inline String convertFromByteArray(const byte* p_array, const unsigned int p_size)
{
	String s;

	// Reserves the Given Amount of Size in String
	s.reserve(p_size);

	for (unsigned int i = 0; i < p_size; ++i)
	{
		// Convert the element byte to String
		s += static_cast<char>(p_array[i]);
	}

	return s;
}
