package ba.unsa.etf.rpr;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Tests for main when the entered expression is not arithmetically valid
     */
    @Test
    public void wrongInput()
    {
        String[] string = new String[] {"4", "+", "3"};
        App.main(string);
    }


    /**
     * Tests for main when the entered expression is arithmetically valid
     */
    @Test
    public void validInput() {
        String[] string = new String[]{"(", "4", "+", "3", ")"};
        App.main(string);
    }
}




