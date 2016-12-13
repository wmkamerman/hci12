package controller;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.*;

import java.util.ArrayList;
import java.util.List;

public class Listener implements Runnable {

    @Override
    public void run() {
        System.out.println("<--Pi4J--> GPIO Listen Example ... started.");
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01, PinPullResistance.PULL_UP);
        myButton.setShutdownOptions(true);

        myButton.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());List<String> strings = new ArrayList<>();
                strings.add("hoi");
                strings.add("oi");
                strings.add("boddddi");
                //TODO drawtext
            }
        });

        System.out.println(" ... complete the GPIO #02 circuit and see the listener feedback here in the console.");

        while(true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Interrupted while listening");
            }
        }
    }
}
