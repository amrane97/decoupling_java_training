package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private Logger logger = LoggerFactory.getLogger("player");

    private Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.println("inserez un nombre entre 0 et 100: ");
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == true) {
            System.out.println("--Moins--");
            logger.log("le nombre inserer est superieur !");
        } else {
            System.out.println("++Plus++");
            logger.log("le nombre inserer est inferieur !");
        }
    }


}
