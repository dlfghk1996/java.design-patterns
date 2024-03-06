package designpattern.behavioral.command.basic;

// Receiver Class
public class Receiver {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}
