package com.zk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class AbstractFactoryTest {

    private KingdomFactory elfFactory;
    private KingdomFactory orcFactory;

    private final App app = new App();


    @BeforeEach
    public void setup(){
        elfFactory = App.FactoryMaker.makeFactory(App.FactoryMaker.KingdomType.ELF);
        orcFactory = App.FactoryMaker.makeFactory(App.FactoryMaker.KingdomType.ORC);
    }

    @Test
    public void king() {
        final var elfKing = elfFactory.createKing();
        assertThat(elfKing instanceof ElfKing).isTrue();
        assertThat(elfKing.getDescription()).isEqualTo(ElfKing.DESCRIPTION);

        final var orcKing = orcFactory.createKing();
        assertThat(orcKing instanceof OrcKing).isTrue();
        assertThat(orcKing.getDescription()).isEqualTo(OrcKing.DESCRIPTION);
    }

    @Test
    public void castle() {
        final var elfCastle = elfFactory.createCastle();
        assertThat(elfCastle instanceof ElfCastle).isTrue();
        assertThat(elfCastle.getDescription()).isEqualTo(ElfCastle.DESCRIPTION);

        final var orcCastle = orcFactory.createCastle();
        assertThat(orcCastle instanceof OrcCastle).isTrue();
        assertThat(orcCastle.getDescription()).isEqualTo(OrcCastle.DESCRIPTION);
    }

    @Test
    public void army() {
        final var elfArmy = elfFactory.createArmy();
        assertThat(elfArmy instanceof ElfArmy).isTrue();
        assertThat(elfArmy.getDescription()).isEqualTo(ElfArmy.DESCRIPTION);

        final var orcArmy = orcFactory.createArmy();
        assertThat(orcArmy instanceof OrcArmy).isTrue();
        assertThat(orcArmy.getDescription()).isEqualTo(OrcArmy.DESCRIPTION);
    }

    @Test
    public void createElfKingdom() {
        app.createKingdom(elfFactory);

        final var elfArmy = app.getArmy();
        assertThat(elfArmy instanceof ElfArmy).isTrue();
        assertThat(elfArmy.getDescription()).isEqualTo(ElfArmy.DESCRIPTION);

        final var elfCastle = app.getCastle();
        assertThat(elfCastle instanceof ElfCastle).isTrue();
        assertThat(elfCastle.getDescription()).isEqualTo(ElfCastle.DESCRIPTION);

        final var elfKing = app.getKing();
        assertThat(elfKing instanceof ElfKing).isTrue();
        assertThat(elfKing.getDescription()).isEqualTo(ElfKing.DESCRIPTION);
    }

    @Test
    public void createOrcKingdom() {
        app.createKingdom(orcFactory);

        final var orcArmy = app.getArmy();
        assertThat(orcArmy instanceof OrcArmy).isTrue();
        assertThat(orcArmy.getDescription()).isEqualTo(OrcArmy.DESCRIPTION);

        final var orcCastle = app.getCastle();
        assertThat(orcCastle instanceof OrcCastle).isTrue();
        assertThat(orcCastle.getDescription()).isEqualTo(OrcCastle.DESCRIPTION);

        final var orcKing = app.getKing();
        assertThat(orcKing instanceof OrcKing).isTrue();
        assertThat(orcKing.getDescription()).isEqualTo(OrcKing.DESCRIPTION);
    }
}
