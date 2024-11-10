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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

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
                Player winner = Jokenpo.validateWin(moves.get(0), moves.get(1));

                JokenpoProto.PlayResponse response = returnMessage(player, winner);
                observers.get(player).onNext(response);
                observers.get(player).onCompleted();

                moves.clear();
                observers.clear();
            } else {
                System.out.println("Waiting for another player...");
            }
        }

        private JokenpoProto.PlayResponse returnMessage(Player player, Player winner) {
            String result = "empate";
            String message = "portanto não há vencedor";
            if (nonNull(winner)) {
                Player loser = moves
                        .stream()
                        .filter(p -> !JokenpoRaw.from(p.getJogada()).equals(winner))
                        .findFirst()
                        .orElse(moves.get(0));
                String resultMessage = Jokenpo.winMessage(winner, loser.getJogada());
                result = player.equals(loser) ? "perdeu" : "venceu";
                message = String.format("%s, logo, o jogador %s venceu", resultMessage, moves
                        .stream()
                        .filter(p -> JokenpoRaw.from(p.getJogada()).equals(winner))
                        .findFirst()
                        .map(win -> win.getNome())
                        .orElse(""));
            }

            return JokenpoProto.PlayResponse.newBuilder()
                    .setResult(result)
                    .setMessage(message)
                    .build();
        }
    }
}
