package de.ovsiannikov;

public class ConsoleGameMessenger implements GameMessenger {
    @Override
    public void printString(String s) {
        System.out.println(s);
    }
}