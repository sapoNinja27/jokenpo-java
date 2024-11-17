package org.joao.ronzani;

import javax.annotation.Nonnull;

public enum JokenpoRaw {
    PEDRA,
    PAPEL,
    TESOURA,
    LAGARTO,
    SPOCK;

    public static JokenpoRaw from(@Nonnull Jokenpo jkp) {
        return JokenpoRaw.valueOf(jkp.name());
    }
}
