package org.joao.ronzani;

import com.joao.ronzani.jokenpo.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JokenpoServer {

    private final Map<String, String> moves = new HashMap<>();
    private final Map<String, String> playerResults = new HashMap<>();

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
        private final Map<String, String> moves = new HashMap<>();
        private final Map<String, String> playerResults = new HashMap<>();

        @Override
        public void playRound(JokenpoProto.PlayRequest request, StreamObserver<JokenpoProto.PlayResponse> responseObserver) {
            String playerId = request.getPlayerId();
            String move = request.getMove().toLowerCase();
            moves.put(playerId, move);

            if (moves.size() == 2) {
                String[] players = moves.keySet().toArray(new String[0]);
                String resultMessage = determineWinner(players[0], players[1]);
                for (String player : players) {
                    JokenpoProto.PlayResponse response = JokenpoProto.PlayResponse.newBuilder()
                            .setResult(playerResults.get(player))
                            .setMessage(resultMessage)
                            .build();
                    responseObserver.onNext(response);
                }
                moves.clear();
                playerResults.clear();
                responseObserver.onCompleted();
            } else {
                System.out.println("Waiting for another player...");
            }
        }

        private String determineWinner(String player1, String player2) {
            String move1 = moves.get(player1);
            String move2 = moves.get(player2);
            if (move1.equals(move2)) {
                playerResults.put(player1, "draw");
                playerResults.put(player2, "draw");
                return "It's a draw!";
            }
            String winner, loser;
            if ((move1.equals("rock") && move2.equals("scissors")) ||
                    (move1.equals("scissors") && move2.equals("paper")) ||
                    (move1.equals("paper") && move2.equals("rock"))) {
                winner = player1;
                loser = player2;
                playerResults.put(winner, "win");
                playerResults.put(loser, "lose");
            } else {
                winner = player2;
                loser = player1;
                playerResults.put(winner, "win");
                playerResults.put(loser, "lose");
            }
            return String.format("Player %s wins with %s against %s", winner, moves.get(winner), moves.get(loser));
        }
    }
}
