package com.zk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private Castle castle;
    private King king;
    private Army army;

    public void createKingdom(KingdomFactory factory) {
        setCastle(factory.createCastle());
        setKing(factory.createKing());
        setArmy(factory.createArmy());
    }

    public void setCastle(final Castle castle) {
        this.castle = castle;
    }

    public void setKing(final King king) {
        this.king = king;
    }

    public void setArmy(final Army army) {
        this.army = army;
    }

    public Castle getCastle() {
        return castle;
    }

    public King getKing() {
        return king;
    }

    public Army getArmy() {
        return army;
    }

    public static void main(String[] args) {
        var app = new App();
        LOGGER.info("ELF Kingdom");
        app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF));
        LOGGER.info(app.getArmy().getDescription());
        LOGGER.info(app.getCastle().getDescription());
        LOGGER.info(app.getKing().getDescription());

        LOGGER.info("Orc Kingdom");
        app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ORC));
        LOGGER.info(app.getArmy().getDescription());
        LOGGER.info(app.getCastle().getDescription());
        LOGGER.info(app.getKing().getDescription());

    }

    /**
     * The factory of kingdom factories.
     */
    public static class FactoryMaker {

        /**
         * Enumeration for the different types of Kingdoms.
         */
        public enum KingdomType {
            ELF,
            ORC
        }

        /**
         * The factory method to create KingdomFactory concrete objects.
         *
         * @param type The kingdom type.
         * @return A kingdom factory concrete objects that according to kingdom type.
         */
        public static KingdomFactory makeFactory(KingdomType type) {
            switch (type) {
                case ELF:
                    return new ElfKingdomFactory();
                case ORC:
                    return new OrcKingdomFactory();
                default:
                    throw new IllegalArgumentException("KingdomType not supported.");
            }
        }
    }
}
