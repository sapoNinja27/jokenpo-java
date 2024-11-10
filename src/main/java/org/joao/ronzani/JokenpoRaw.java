package org.joao.ronzani;

import javax.annotation.Nonnull;

public enum JokenpoRaw {
    PEDRA,
    LAGARTO,
    SPOCK,
    TESOURA,
    PAPEL;

    public static JokenpoRaw from(@Nonnull Jokenpo jkp) {
        return JokenpoRaw.valueOf(jkp.name());
    }
}
