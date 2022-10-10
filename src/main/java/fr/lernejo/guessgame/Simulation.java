package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private Player player;
    private long numberToGuess;



    public Simulation(Player player) {// constructeur
        this.player = player;
    }

    public void initialize(long numberToGuess) {
     this.numberToGuess = numberToGuess;
    }

    private boolean nextRound() {
        long insertedNumberByPlayer = player.askNextGuess(); // demander au joueur d'inserer un nombre
        if (this.numberToGuess == insertedNumberByPlayer) {
            logger.log("le joueur a trouvé le bon nombre !");
            return true;
        } else {
            player.respond(insertedNumberByPlayer > this.numberToGuess);
            return false;
        }

    }

    public void loopUntilPlayerSucceed(long maxIteration) {


        boolean succeed = nextRound();
        long debutPartie = System.currentTimeMillis();
        long i = 0;

        while (succeed == false && i < maxIteration) {
            i++;
            succeed = nextRound();
        }

        long finPartie = System.currentTimeMillis();
        long tempsDePartie = finPartie - debutPartie;
        Date date = new Date(finPartie);


        if (succeed == true){
            System.out.println("*****   *o* bravo *o*    *****     en: "+ i +" operations \n Cette partie a prit : " + tempsDePartie +"ms" + "\n le " + date);
        } else if (i >= maxIteration) {
            logger.log("** PERDU ** vous avez dépassé le nombre d'iterations maximum !");
        } else {
            logger.log("ERROR DANS LE CODE DU JEU !!!");
        }
    }
}
