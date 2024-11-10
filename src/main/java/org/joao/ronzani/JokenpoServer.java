package org.joao.ronzani;

import com.joao.ronzani.jokenpo.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JokenpoServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new JokenpoServiceImpl())
                .build();
        System.out.println("Server starting...");
        server.start();
        System.out.println("Server started on port 8080.");
        server.awaitTermination();
    }

    static class JokenpoServiceImpl extends JokenpoServiceGrpc.JokenpoServiceImplBase {
        private final List<Player> moves = new ArrayList<>();
        private final Map<String, StreamObserver<JokenpoProto.PlayResponse>> observers = new HashMap<>();

        @Override
        public void playRound(JokenpoProto.PlayRequest request, StreamObserver<JokenpoProto.PlayResponse> responseObserver) {
            Player player = new Player(request.getPlayerId(), Jokenpo.fromName(request.getMove()));
            moves.add(player);
            observers.put(player.getNome(), responseObserver);

            if (moves.size() == 2) {
//                String[] players = moves.keySet().toArray(new String[0]);
//                Jokenpo winner = Jokenpo.validateWin(moves.get(0).getJogada(), moves.get(1).getJogada());
//                Player loser = moves.stream().filter(p ->{
//                    return p.getJogada()
//                })
//                String resultMessage = Jokenpo.winMessage(winner, players[1]);
//
//                for (String player : players) {
//                    JokenpoProto.PlayResponse response = JokenpoProto.PlayResponse.newBuilder()
//                            .setResult(player.equals(players[0]) ? "win" : "lose")  // ajustar conforme necessário
//                            .setMessage(resultMessage)
//                            .build();
//                    observers.get(player).onNext(response);
//                    observers.get(player).onCompleted();  // Chama onCompleted para cada observer
//                }

                // Limpa os mapas para a próxima rodada
                moves.clear();
                observers.clear();
            } else {
                System.out.println("Waiting for another player...");
            }
        }

//        private String determineWinner(String player1, String player2) {
//            String move1 = moves.get(player1);
//            String move2 = moves.get(player2);
//            if (move1.equals(move2)) {
//                return "It's a draw!";
//            }
//            if ((move1.equals("rock") && move2.equals("scissors")) ||
//                    (move1.equals("scissors") && move2.equals("paper")) ||
//                    (move1.equals("paper") && move2.equals("rock"))) {
//                return String.format("Player %s wins with %s against %s", player1, move1, move2);
//            } else {
//                return String.format("Player %s wins with %s against %s", player2, move2, move1);
//            }
//        }
    }
}
