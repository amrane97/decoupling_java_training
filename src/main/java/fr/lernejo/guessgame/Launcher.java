package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    public static void main (String [] args ) {

        Logger logger = LoggerFactory.getLogger("Launcher");
        SecureRandom random = new SecureRandom();
        Simulation simulation = null;
        long randomNumber = random.nextInt(100);
        //Simulation
        if (args.length > 0) {
            if (args[0].equals("-interactive")) {

                Player player = new HumanPlayer();
                simulation = new Simulation(player);
                simulation.initialize(randomNumber);
                simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

            } else if (args[0].equals("-auto")) {

                Player computerPlayer = new ComputerPlayer();
                simulation = new Simulation(computerPlayer);
                simulation.initialize(randomNumber);

                if (args.length > 1) {
                    try {

                        simulation.loopUntilPlayerSucceed(Integer.parseInt(args[1]));

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                        logger.log("ERROR ! INVALIDE ARGUMENT");
                    }
                }
                else if (args.length > 0 && args.length < 2) {
                    simulation.loopUntilPlayerSucceed(1000);
                }
                else {
                    logger.log("Something went wrong");
                }
            }
        } else {
            logger.log("INVALIDE ! PAS D'ARGUMENTS !");
        }

    }
}
