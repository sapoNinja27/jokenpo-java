import org.joao.ronzani.Jokenpo;
import org.joao.ronzani.Player;
import org.junit.Assert;
import org.junit.Test;

public class JokenpoTest {

    @Test
    public void testPedraEsmagaTesoura() {
        Player p1 = new Player("p1", Jokenpo.PEDRA);
        Player p2 = new Player("p2", Jokenpo.TESOURA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testPedraEsmagaLagarto() {
        Player p1 = new Player("p1", Jokenpo.PEDRA);
        Player p2 = new Player("p2", Jokenpo.LAGARTO);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testPapelCobrePedra() {
        Player p1 = new Player("p1", Jokenpo.PAPEL);
        Player p2 = new Player("p2", Jokenpo.PEDRA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testPapelRefutaSpock() {
        Player p1 = new Player("p1", Jokenpo.PAPEL);
        Player p2 = new Player("p2", Jokenpo.SPOCK);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testTesouraCortaPapel() {
        Player p1 = new Player("p1", Jokenpo.TESOURA);
        Player p2 = new Player("p2", Jokenpo.PAPEL);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testTesouraDecapitaLagarto() {
        Player p1 = new Player("p1", Jokenpo.TESOURA);
        Player p2 = new Player("p2", Jokenpo.LAGARTO);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testLagartoEnvenenaSpock() {
        Player p1 = new Player("p1", Jokenpo.LAGARTO);
        Player p2 = new Player("p2", Jokenpo.SPOCK);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testLagartoComePapel() {
        Player p1 = new Player("p1", Jokenpo.LAGARTO);
        Player p2 = new Player("p2", Jokenpo.PAPEL);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testSpockVaporizaPedra() {
        Player p1 = new Player("p1", Jokenpo.SPOCK);
        Player p2 = new Player("p2", Jokenpo.PEDRA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testSpockEsmagaTesoura() {
        Player p1 = new Player("p1", Jokenpo.SPOCK);
        Player p2 = new Player("p2", Jokenpo.TESOURA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testPedraPerdeParaPapel() {
        Player p1 = new Player("p1", Jokenpo.PEDRA);
        Player p2 = new Player("p2", Jokenpo.PAPEL);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testPedraPerdeParaSpock() {
        Player p1 = new Player("p1", Jokenpo.PEDRA);
        Player p2 = new Player("p2", Jokenpo.SPOCK);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testPapelPerdeParaTesoura() {
        Player p1 = new Player("p1", Jokenpo.PAPEL);
        Player p2 = new Player("p2", Jokenpo.TESOURA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testPapelPerdeParaLagarto() {
        Player p1 = new Player("p1", Jokenpo.PAPEL);
        Player p2 = new Player("p2", Jokenpo.LAGARTO);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testTesouraPerdeParaPedra() {
        Player p1 = new Player("p1", Jokenpo.TESOURA);
        Player p2 = new Player("p2", Jokenpo.PEDRA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testTesouraPerdeParaSpock() {
        Player p1 = new Player("p1", Jokenpo.TESOURA);
        Player p2 = new Player("p2", Jokenpo.SPOCK);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testLagartoPerdeParaPedra() {
        Player p1 = new Player("p1", Jokenpo.LAGARTO);
        Player p2 = new Player("p2", Jokenpo.PEDRA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testLagartoPerdeParaTesoura() {
        Player p1 = new Player("p1", Jokenpo.LAGARTO);
        Player p2 = new Player("p2", Jokenpo.TESOURA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testSpockPerdeParaPapel() {
        Player p1 = new Player("p1", Jokenpo.SPOCK);
        Player p2 = new Player("p2", Jokenpo.PAPEL);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testSpockPerdeParaLagarto() {
        Player p1 = new Player("p1", Jokenpo.SPOCK);
        Player p2 = new Player("p2", Jokenpo.LAGARTO);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p2, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }

    @Test
    public void testEmpate() {
        Player p1 = new Player("p1", Jokenpo.PEDRA);
        Player p2 = new Player("p2", Jokenpo.PEDRA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertNull(winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra amassa tesoura");
    }
}