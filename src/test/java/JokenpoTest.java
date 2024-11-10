import org.joao.ronzani.Jokenpo;
import org.joao.ronzani.JokenpoRaw;
import org.joao.ronzani.Player;
import org.junit.Assert;
import org.junit.Test;

public class JokenpoTest {

    // primeiro jogador vence
    @Test
    public void testPedraEsmagaTesoura() {
        Jokenpo p1 = Jokenpo.PEDRA;
        Jokenpo p2 = Jokenpo.TESOURA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    @Test
    public void testPedraEsmagaLagarto() {
        Jokenpo p1 = Jokenpo.PEDRA;
        Jokenpo p2 = Jokenpo.LAGARTO;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    @Test
    public void testPapelCobrePedra() {
        Jokenpo p1 = Jokenpo.PAPEL;
        Jokenpo p2 = Jokenpo.PEDRA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    @Test
    public void testPapelRefutaSpock() {
        Jokenpo p1 = Jokenpo.PAPEL;
        Jokenpo p2 = Jokenpo.SPOCK;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    @Test
    public void testTesouraCortaPapel() {
        Jokenpo p1 = Jokenpo.TESOURA;
        Jokenpo p2 = Jokenpo.PAPEL;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    @Test
    public void testTesouraDecapitaLagarto() {
        Jokenpo p1 = Jokenpo.TESOURA;
        Jokenpo p2 = Jokenpo.LAGARTO;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    @Test
    public void testLagartoEnvenenaSpock() {
        Jokenpo p1 = Jokenpo.LAGARTO;
        Jokenpo p2 = Jokenpo.SPOCK;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    @Test
    public void testLagartoComePapel() {
        Jokenpo p1 = Jokenpo.LAGARTO;
        Jokenpo p2 = Jokenpo.PAPEL;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    @Test
    public void testSpockVaporizaPedra() {
        Jokenpo p1 = Jokenpo.SPOCK;
        Jokenpo p2 = Jokenpo.PEDRA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    @Test
    public void testSpockEsmagaTesoura() {
        Jokenpo p1 = Jokenpo.SPOCK;
        Jokenpo p2 = Jokenpo.TESOURA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p1), winner);
    }

    // segundo jogador vence
    @Test
    public void testPedraPerdeParaPapel() {
        Jokenpo p1 = Jokenpo.PEDRA;
        Jokenpo p2 = Jokenpo.PAPEL;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    @Test
    public void testPedraPerdeParaSpock() {
        Jokenpo p1 = Jokenpo.PEDRA;
        Jokenpo p2 = Jokenpo.SPOCK;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    @Test
    public void testPapelPerdeParaTesoura() {
        Jokenpo p1 = Jokenpo.PAPEL;
        Jokenpo p2 = Jokenpo.TESOURA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    @Test
    public void testPapelPerdeParaLagarto() {
        Jokenpo p1 = Jokenpo.PAPEL;
        Jokenpo p2 = Jokenpo.LAGARTO;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    @Test
    public void testTesouraPerdeParaPedra() {
        Jokenpo p1 = Jokenpo.TESOURA;
        Jokenpo p2 = Jokenpo.PEDRA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    @Test
    public void testTesouraPerdeParaSpock() {
        Jokenpo p1 = Jokenpo.TESOURA;
        Jokenpo p2 = Jokenpo.SPOCK;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    @Test
    public void testLagartoPerdeParaPedra() {
        Jokenpo p1 = Jokenpo.LAGARTO;
        Jokenpo p2 = Jokenpo.PEDRA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    @Test
    public void testLagartoPerdeParaTesoura() {
        Jokenpo p1 = Jokenpo.LAGARTO;
        Jokenpo p2 = Jokenpo.TESOURA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    @Test
    public void testSpockPerdeParaPapel() {
        Jokenpo p1 = Jokenpo.SPOCK;
        Jokenpo p2 = Jokenpo.PAPEL;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    @Test
    public void testSpockPerdeParaLagarto() {
        Jokenpo p1 = Jokenpo.SPOCK;
        Jokenpo p2 = Jokenpo.LAGARTO;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(JokenpoRaw.from(p2), winner);
    }

    // empate
    @Test
    public void testEmpatePedra() {
        Jokenpo p1 = Jokenpo.PEDRA;
        Jokenpo p2 = Jokenpo.PEDRA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertNull(winner);
    }

    @Test
    public void testEmpatePapel() {
        Jokenpo p1 = Jokenpo.PAPEL;
        Jokenpo p2 = Jokenpo.PAPEL;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertNull(winner);
    }

    @Test
    public void testEmpateTesoura() {
        Jokenpo p1 = Jokenpo.TESOURA;
        Jokenpo p2 = Jokenpo.TESOURA;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertNull(winner);
    }

    @Test
    public void testEmpateLagarto() {
        Jokenpo p1 = Jokenpo.LAGARTO;
        Jokenpo p2 = Jokenpo.LAGARTO;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertNull(winner);
    }

    @Test
    public void testEmpateSpock() {
        Jokenpo p1 = Jokenpo.SPOCK;
        Jokenpo p2 = Jokenpo.SPOCK;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertNull(winner);
    }
}
