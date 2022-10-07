package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private Logger logger = LoggerFactory.getLogger("player");

    private Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.println("inserez un nombre: ");
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == true) {
            System.out.println("--Moins--");
        } else {
            System.out.println("++Plus++");
        }
    }


}
