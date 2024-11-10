package org.joao.ronzani;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import javax.annotation.Nonnull;
import java.util.Arrays;

@AllArgsConstructor
public enum Jokenpo {
    PEDRA(convert(JokenpoRaw.LAGARTO, JokenpoRaw.TESOURA), "Pedra"),
    LAGARTO(convert(JokenpoRaw.SPOCK, JokenpoRaw.PAPEL), "Lagarto"),
    SPOCK(convert(JokenpoRaw.PEDRA, JokenpoRaw.TESOURA), "Spock"),
    TESOURA(convert(JokenpoRaw.PAPEL, JokenpoRaw.LAGARTO), "Tesoura"),
    PAPEL(convert(JokenpoRaw.PEDRA, JokenpoRaw.SPOCK), "Papel");

    private JokenpoRaw[] strongAt;
    private String nome;

    public static Jokenpo fromName(String name) {
        for (Jokenpo jokenpo : Jokenpo.values()) {
            if (jokenpo.nome.equalsIgnoreCase(name)) {
                return jokenpo;
            }
        }
        throw new IllegalArgumentException("Nome inválido para Jokenpo: " + name);
    }
    public static JokenpoRaw validateWin(Jokenpo p1, Jokenpo p2) {
        if (Arrays
                .stream(p1.strongAt)
                .anyMatch(jokenpoRaw -> jokenpoRaw.toString()
                        .equals(p2.toString()))) {
            return JokenpoRaw.from(p1);
        }
        if (Arrays
                .stream(p2.strongAt)
                .anyMatch(jokenpoRaw -> jokenpoRaw.toString()
                        .equals(p1.toString()))) {
            return JokenpoRaw.from(p2);
        }
        return null;
    }

    public static String winMessage(Jokenpo winner, Jokenpo loser) {
        return String.format("%s %s s%", winner.nome, getAtaque(winner, loser), loser.nome);
    }

    private static String getAtaque(Jokenpo winner, Jokenpo loser) {
        switch (winner) {
            case PAPEL -> {
                switch (loser) {
                    case PEDRA -> {
                        return "cobre";
                    }
                    case SPOCK -> {
                        return "refuta";
                    }
                }
            }
            case TESOURA -> {
                switch (loser) {
                    case PAPEL -> {
                        return "corta";
                    }
                    case LAGARTO -> {
                        return "decapita";
                    }
                }
            }
            case PEDRA -> {
                switch (loser) {
                    case LAGARTO -> {
                        return "esmaga";
                    }
                    case TESOURA -> {
                        return "amassa";
                    }
                }
            }
            case LAGARTO -> {
                switch (loser) {
                    case SPOCK -> {
                        return "envenena";
                    }
                    case PAPEL -> {
                        return "come";
                    }
                }
            }
            case SPOCK -> {
                switch (loser) {
                    case TESOURA -> {
                        return "derrete";
                    }
                    case PEDRA -> {
                        return "vaporiza";
                    }
                }
            }
        }
        return "";
    }

    private static JokenpoRaw[] convert(JokenpoRaw... objects) {
        return objects;
    }
}

enum JokenpoRaw {
    PEDRA,
    LAGARTO,
    SPOCK,
    TESOURA,
    PAPEL;

    public static JokenpoRaw from(@Nonnull Jokenpo jkp) {
        return JokenpoRaw.valueOf(jkp.name());
    }
}
