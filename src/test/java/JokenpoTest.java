import org.joao.ronzani.Jokenpo;
import org.joao.ronzani.JokenpoRaw;
import org.joao.ronzani.Player;
import org.junit.Assert;
import org.junit.Test;

public class JokenpoTest {


    @Test
    public void test() {
        Player p1 = new Player("teste1", Jokenpo.fromName("LAgarto"));
        Player p2 = new Player("teste2", Jokenpo.SPOCK);

        Player winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(winner, p1);
        Assert.assertEquals(Jokenpo.winMessage(winner, p2.getJogada()), "Lagarto envenena Spock");
    }


}
