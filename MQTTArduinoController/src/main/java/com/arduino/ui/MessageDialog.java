package com.arduino.ui;

// Use this to create a Message Dialog

import com.arduino.Constants;

import javax.swing.*;

// Use this to get APP_Name Constants

public class MessageDialog {
    public static void InformationMessageDialog(final String message) {
        JOptionPane.showMessageDialog(null, message, Constants.APP_NAME, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ErrorMessageDialog(final String message) {
        JOptionPane.showMessageDialog(null, message, Constants.APP_NAME, JOptionPane.ERROR_MESSAGE);
    }
}
