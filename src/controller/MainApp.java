package controller;

import view.GUI;

import javax.swing.*;

public class MainApp {

    private static GUI gui;
    private static Clock clock;
    private static Listener listener;

    public static void main(String[] args) {
        gui = new GUI();
        clock = new Clock();
        listener = new Listener();

        SwingUtilities.invokeLater();
        Thread clockThread = new Thread(new Clock());
        clockThread.start();
        Thread listenerThread = new Thread(new Listener());
        listenerThread.start();
    }

    public static GUI getGui() {
        return gui;
    }

    public static void setGui(GUI gui) {
        MainApp.gui = gui;
    }

    public static Clock getClock() {
        return clock;
    }

    public static void setClock(Clock clock) {
        MainApp.clock = clock;
    }

    public static Listener getListener() {
        return listener;
    }

    public static void setListener(Listener listener) {
        MainApp.listener = listener;
    }
}
