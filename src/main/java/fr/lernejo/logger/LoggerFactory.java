package fr.lernejo.logger;

public abstract class LoggerFactory implements Logger{

    public static Logger getLogger(String name) {
        return new ConsoleLogger();
    }

}
