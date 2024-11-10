import org.joao.ronzani.Jokenpo;
import org.joao.ronzani.JokenpoRaw;
import org.junit.Assert;
import org.junit.Test;

public class JokenpoTest {


    @Test
    public void test() {
        Jokenpo p1 = Jokenpo.LAGARTO;
        Jokenpo p2 = Jokenpo.SPOCK;

        JokenpoRaw winner = Jokenpo.validateWin(p1, p2);
        Assert.assertEquals(winner, JokenpoRaw.LAGARTO);
    }


}
