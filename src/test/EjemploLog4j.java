package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class EjemploLog4j {

    private final static Logger log = Logger.getLogger(EjemploLog4j.class);


    public static void main(String[] args) {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\test\\logeer.properties");
        log.warn("un warning");
        log.error("un error");
    }

}