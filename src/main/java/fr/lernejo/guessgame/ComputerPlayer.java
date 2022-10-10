package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player {

    private Logger logger = LoggerFactory.getLogger("Computer");
    private long max = Long.MAX_VALUE;
    private long min = Long.MIN_VALUE;


    @Override
    public long askNextGuess() {
        System.out.println("computer inserez un nombre: " +(this.max + this.min)/2);
        return (max + min)/2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == true) {

            logger.log("le nombre est moins grand");
            this.max = askNextGuess();

        } else {

            logger.log("le nombre est plus grand");
            this.min = askNextGuess();
        }
    }

}
