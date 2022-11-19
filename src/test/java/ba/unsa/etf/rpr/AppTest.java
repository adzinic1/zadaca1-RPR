package ba.unsa.etf.rpr;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Test za main kada uneseni izraz nije aritmetički validan
     */
    @Test
    public void pogresanUnos()
    {
        String[] izraz = new String[] {"4", "+", "3"};
        App.main(izraz);
    }

    /**
     * Test za main kada je uneseni izraz aritmetički validan
     */
    @Test
    public void validanUnos() {
        String[] izraz = new String[]{"(", "4", "+", "3", ")"};
        App.main(izraz);
    }
}




