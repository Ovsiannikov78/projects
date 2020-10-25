package de.ovsiannikov;

public class Game {

    private int attempt;
    private int number;
    private GameMessenger messenger;
    private GameNumberReader reader;

    public Game(int attempt, int number, GameMessenger messenger, GameNumberReader reader) {
        this.attempt = attempt;
        this.number = number;
        this.messenger = messenger;
        this.reader = reader;
    }

    public void play() {
        greeting();
        guessTheNumber();
    }

    private void guessTheNumber() {
        while (attempt >= 1) {
            enterYourNumber();
            int inputNumber = reader.getInputNumber();
            if (inputNumber < 0 || inputNumber > 10) {
                wrongNumber();
                break;
            } else if (inputNumber == number) {
                youAreWinner();
                break;
            } else if (attempt != 1) {
                attempt--;
                nextAttempt();
            } else {
                gameOver();
                break;
            }
        }
    }

    private void greeting() {
        messenger.printString("Let's start our game. You have 3 attempts.");
        messenger.printString("You can enter numbers from 0 to 10.");
    }

    private void enterYourNumber() {
        messenger.printString("-------- Please, enter your number ----------");
    }

    private void wrongNumber() {
        messenger.printString(" Wrong number ! You can enter numbers ONLY from 0 to 10 !!! ");
    }

    private void youAreWinner() {
        messenger.printString(" You are winner :-) !!!");
    }

    private void nextAttempt() {
        messenger.printString("You didn't guess. You have left  " + (attempt) + "  attempt.");

    }

    private void gameOver() {
        messenger.printString("You didn't guess. Game over :-( ");
    }
}



