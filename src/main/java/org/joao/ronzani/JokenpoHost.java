package org.joao.ronzani;

import com.joao.ronzani.jokenpo.JokenpoProto;
import com.joao.ronzani.jokenpo.JokenpoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class JokenpoHost {

    public static void main(String[] args) {
        // Configuração do canal gRPC para conectar ao servidor na porta 8080
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        // Criando o cliente stub para se comunicar com o servidor
        JokenpoServiceGrpc.JokenpoServiceBlockingStub stub =
                JokenpoServiceGrpc.newBlockingStub(channel);

        // Coletando a jogada do jogador via entrada do console
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu ID de jogador: ");
        String playerId = scanner.nextLine();

        System.out.print("Escolha sua jogada (rock, paper ou scissors): ");
        String move = scanner.nextLine().toLowerCase();

        // Enviando a jogada ao servidor
        JokenpoProto.PlayRequest request = JokenpoProto.PlayRequest.newBuilder()
                .setPlayerId(playerId)
                .setMove(move)
                .build();

        try {
            // Recebendo a resposta do servidor com o resultado da partida
            JokenpoProto.PlayResponse response = stub.playRound(request);
            System.out.println("Resultado: " + response.getResult());
            System.out.println("Mensagem: " + response.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao se comunicar com o servidor: " + e.getMessage());
        }

        // Encerrando o canal
        channel.shutdown();
    }
}
