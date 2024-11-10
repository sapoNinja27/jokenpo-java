package org.joao.ronzani;

import com.joao.ronzani.jokenpo.JokenpoProto;
import com.joao.ronzani.jokenpo.JokenpoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Arrays;
import java.util.Scanner;

public class JokenpoHost {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        JokenpoServiceGrpc.JokenpoServiceBlockingStub stub = JokenpoServiceGrpc.newBlockingStub(channel);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu ID de jogador: ");
        String playerId = scanner.nextLine();

        System.out.printf("Escolha sua jogada (%s): ", Arrays.toString(JokenpoRaw.values()));
        String move = scanner.nextLine().toLowerCase();

        JokenpoProto.PlayRequest request = JokenpoProto.PlayRequest.newBuilder()
                .setPlayerId(playerId)
                .setMove(move)
                .build();

        try {
            JokenpoProto.PlayResponse response = stub.playRound(request);
            System.out.println("Resultado: " + response.getResult());
            System.out.println("Mensagem: " + response.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao se comunicar com o servidor: " + e.getMessage());
        }

        channel.shutdown();
    }
}
