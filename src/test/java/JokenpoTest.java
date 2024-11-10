import org.joao.ronzani.Jokenpo;
import org.joao.ronzani.Player;
import org.junit.Assert;
import org.junit.Test;

public class JokenpoTest {

    @Test
    public void testPedraAmassaTesoura() {
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
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Pedra esmaga lagarto");
    }

    @Test
    public void testPapelCobrePedra() {
        Player p1 = new Player("p1", Jokenpo.PAPEL);
        Player p2 = new Player("p2", Jokenpo.PEDRA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Papel cobre pedra");
    }

    @Test
    public void testPapelRefutaSpock() {
        Player p1 = new Player("p1", Jokenpo.PAPEL);
        Player p2 = new Player("p2", Jokenpo.SPOCK);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Papel refuta spock");
    }

    @Test
    public void testTesouraCortaPapel() {
        Player p1 = new Player("p1", Jokenpo.TESOURA);
        Player p2 = new Player("p2", Jokenpo.PAPEL);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Tesoura corta papel");
    }

    @Test
    public void testTesouraDecapitaLagarto() {
        Player p1 = new Player("p1", Jokenpo.TESOURA);
        Player p2 = new Player("p2", Jokenpo.LAGARTO);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Tesoura decapita lagarto");
    }

    @Test
    public void testLagartoEnvenenaSpock() {
        Player p1 = new Player("p1", Jokenpo.LAGARTO);
        Player p2 = new Player("p2", Jokenpo.SPOCK);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Lagarto envenena spock");
    }

    @Test
    public void testLagartoComePapel() {
        Player p1 = new Player("p1", Jokenpo.LAGARTO);
        Player p2 = new Player("p2", Jokenpo.PAPEL);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Lagarto come papel");
    }

    @Test
    public void testSpockVaporizaPedra() {
        Player p1 = new Player("p1", Jokenpo.SPOCK);
        Player p2 = new Player("p2", Jokenpo.PEDRA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Spock vaporiza pedra");
    }

    @Test
    public void testSpockEsmagaTesoura() {
        Player p1 = new Player("p1", Jokenpo.SPOCK);
        Player p2 = new Player("p2", Jokenpo.TESOURA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(p1, winner);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Spock derrete tesoura");
    }

    @Test
    public void testEmpate() {
        Player p1 = new Player("p1", Jokenpo.PEDRA);
        Player p2 = new Player("p2", Jokenpo.PEDRA);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertNull(winner);
    }
}