package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

   
    /**
     * Testira sqrt funkciju
     */
    @Test
    void sqrtTest(){
        String s = "( 1 + ( sqrt ( 144 ) / 6 ) )";
        assertEquals(3D, ExpressionEvaluator.evaluate(s));
    }

    /**
     * Nema zagrade nikako
     */
    @Test
    void faliZagradaTest(){
        String s = "2 + 2";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

    /**
     * Dobar broj zagrada ali nisu dobri operandi
     */
    @Test
    void pogresniOperandiTest(){
        String s = "( 7 + ( 8 * ( + ) ) )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

    /**
     * Jednak broj otvorenih i zatvorenih zagrada, ali su na pogresnim mjestima
     */
    @Test
    void rasporedZagradaTest(){
        String s = "( 1 + ( ( 2 + 3 ) * 5 ( ) )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

    /**
     * Fali razmak
     */
    @Test
    void razmakManjkaTest(){
        String s = "( 1 + 2 )( 3 + 4 )";
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate(s));
    }

}