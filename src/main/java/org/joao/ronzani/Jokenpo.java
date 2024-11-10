package org.joao.ronzani;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum Jokenpo {
    PEDRA(convert(JokenpoRaw.LAGARTO, JokenpoRaw.TESOURA), "Pedra"),
    LAGARTO(convert(JokenpoRaw.SPOCK, JokenpoRaw.PAPEL), "Lagarto"),
    SPOCK(convert(JokenpoRaw.PEDRA, JokenpoRaw.TESOURA), "Spock"),
    TESOURA(convert(JokenpoRaw.PAPEL, JokenpoRaw.LAGARTO), "Tesoura"),
    PAPEL(convert(JokenpoRaw.PEDRA, JokenpoRaw.SPOCK), "Papel");

    private final JokenpoRaw[] strongAt;
    private final String nome;

    public static Jokenpo fromName(String name) {
        for (Jokenpo jokenpo : Jokenpo.values()) {
            if (jokenpo.nome.equalsIgnoreCase(name) || jokenpo.name().equalsIgnoreCase(name)) {
                return jokenpo;
            }
        }
        throw new IllegalArgumentException("Nome inválido para Jokenpo: " + name);
    }

    public static Player validateWin(Player p1, Player p2) {
        if (Arrays
                .stream(p1.getJogada().strongAt)
                .anyMatch(jokenpoRaw -> jokenpoRaw.toString()
                        .equals(p2.getJogada().toString()))) {
            return p1;
        }
        if (Arrays
                .stream(p2.getJogada().strongAt)
                .anyMatch(jokenpoRaw -> jokenpoRaw.toString()
                        .equals(p1.getJogada().toString()))) {
            return p2;
        }
        return null;
    }

    public static String winMessage(Player winner, Jokenpo loser) {
        return String.format("%s %s %s", winner.getJogada().nome, getAtaque(winner.getJogada(), loser), loser.nome.toLowerCase());
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

