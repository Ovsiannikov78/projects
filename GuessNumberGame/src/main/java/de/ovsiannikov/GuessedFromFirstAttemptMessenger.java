package de.ovsiannikov;

public class GuessedFromFirstAttemptMessenger implements GameMessenger {

    private boolean isGuessed = true;

    @Override
    public void printString(String s) {

        isGuessed = s.equals("Congratulation, you won !!! :-) ");
    }

    public boolean isGuessed() {
        return isGuessed;
    }
}
