package ba.unsa.etf.rpr;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;



public class StdOut{

    private static String unos;
    private static PrintWriter out;

    static{
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, unos), true);
        }
        catch (UnsupportedEncodingException e) {
            System.out.println();
        }
    }

    public static void println(Double pop) {
        out.println();
    }
}