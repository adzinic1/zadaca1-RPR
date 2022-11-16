package ba.unsa.etf.rpr;

import java.util.Scanner;

public class StdIn {
    static Scanner unos = new Scanner(System.in);

    public static boolean isEmpty() {
        return unos == null;
    }

    public static String readString() {
        return unos.next();
    }
}
