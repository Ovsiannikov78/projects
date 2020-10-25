package de.ovsiannikov;

import java.util.Scanner;

public class ConsoleGameNumberReader implements GameNumberReader {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int getInputNumber() {
        return scanner.nextInt();
    }
}