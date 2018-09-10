package com.arduino.ui;

import com.arduino.Constants;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// The Mqtt Client Connections

public class MainFormUI extends JFrame {
    private JPanel contentPane;
    private JButton ledControlButton;
    private JButton proximitySensorButton;
    private JButton temperatureSensorButton;
    private JLabel message_text;

    private MqttClient mqtt_client;

    public MainFormUI() throws Exception {

        setDefaultCloseOperation(super.DISPOSE_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        ledControlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Start the LED Controller
                try {
                    if (mqtt_client.isConnected())
                        startFrameAndHideCurrent(new LEDControllerUI(MainFormUI.this, mqtt_client));
                    else
                        message_text.setText("Client Not Connected. Wait for Connection To Occur");
                } catch (Exception ex) {
                    MessageDialog.ErrorMessageDialog("Exception thrown" + ex);
                }
            }
        });
        proximitySensorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Start the Proximity Sensor Controller
                try {
                    if (mqtt_client.isConnected())
                        startFrameAndHideCurrent(new ProximityDisplayUI(MainFormUI.this, mqtt_client));
                    else
                        message_text.setText("Client Not Connected. Wait for Connection To Occur");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageDialog.ErrorMessageDialog("Exception thrown" + ex + ex.getMessage());
                }
            }
        });
        temperatureSensorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Start the Temperature Sensor Controller
                try {
                    if (mqtt_client.isConnected())
                        startFrameAndHideCurrent(new TemperatureSensorUI(MainFormUI.this, mqtt_client));
                    else
                        message_text.setText("Client Not Connected. Wait for Connection To Occur");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    MessageDialog.ErrorMessageDialog("Exception thrown" + ex + ex.getMessage());
                }

            }
        });

        setVisible(true);
        setSize(getPreferredSize());
        setResizable(false);
        show();

        initialiseMQTTClient();
        message_text.setText("Connection with Server Established");
    }

    public void initialiseMQTTClient() throws Exception {
        mqtt_client = new MqttClient(Constants.MQTT_BROKER, Constants.MQT_CLIENT_ID, new MemoryPersistence());
        final MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(Constants.MQTT_USER_NAME);
        options.setPassword(Constants.MQTT_USER_KEY);
        options.setAutomaticReconnect(true);
        options.setConnectionTimeout(100);
        options.setCleanSession(true);

        message_text.setText("Trying to Connect to MQTT Server");

        while (!mqtt_client.isConnected())
            mqtt_client.connect(options);

        while (true) {
            final IMqttToken token = mqtt_client.subscribeWithResponse(Constants.MQTT_TOPIC);
            if (token.isComplete())
                break;
        }
        message_text.setText("Subscription to Topic Successful");
        mqtt_client.setCallback(null);
    }

    private void startFrameAndHideCurrent(final JDialog dialog) {
        dialog.setSize(dialog.getPreferredSize());
        dialog.setResizable(false);
        dialog.show();
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                setVisible(true);
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setPreferredSize(new Dimension(182, 140));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(panel1, gbc);
        ledControlButton = new JButton();
        ledControlButton.setText("LED Controller    ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(ledControlButton, gbc);
        proximitySensorButton = new JButton();
        proximitySensorButton.setText("Proximity Sensor");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(proximitySensorButton, gbc);
        temperatureSensorButton = new JButton();
        temperatureSensorButton.setText("Temp Sensor      ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(temperatureSensorButton, gbc);
        message_text = new JLabel();
        message_text.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(message_text, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}