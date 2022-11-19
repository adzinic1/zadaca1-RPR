package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {


    /**
     * Tests sqrt function
     */
    @Test
    void sqrtTest(){
        String s = "( 1 + ( sqrt ( 144 ) / 6 ) )";
        assertEquals(3D, ExpressionEvaluator.evaluate(s));
    }

    /**
     * Tests when there are no parentheses
     */
    @Test
    void faliZagradaTest(){
        String s = "2 + 2";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

    /**
     * Tests correct number of parentheses but not appropriate operands
     */
    @Test
    void pogresniOperandiTest(){
        String s = "( 7 + ( 8 * ( + ) ) )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

    /**
     * Tests the same number of open and closed parentheses, but they are in the wrong places
     */
    @Test
    void rasporedZagradaTest(){
        String s = "( 1 + ( ( 2 + 3 ) * 5 ( ) )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

    /**
     * Tests missing whitespace
     */
    @Test
    void razmakManjkaTest(){
        String s = "( 1 + 2 )( 3 + 4 )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

}