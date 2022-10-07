package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {// constructeur
        this.player = player;
    }

    public void initialize(long numberToGuess) {

        // TODO pourquoi on initialise pas le nombre a deviner ici ?
     this.numberToGuess = numberToGuess;
    }

    private boolean nextRound() {
        long insertedNumberByPlayer = player.askNextGuess(); // demander au joueur d'inserer un nombre
        if (this.numberToGuess == insertedNumberByPlayer) {
            System.out.println("*****   *o* bravo *o*    *****");
            logger.log("le joueur a trouvé le bon nombre !");
            return true;
        } else {
            player.respond(insertedNumberByPlayer > this.numberToGuess);
            return false;
        }

    }

    public void loopUntilPlayerSucceed() {
        boolean succeed = nextRound();

        while (succeed == false) {
           succeed = nextRound();
        }
    }
}
