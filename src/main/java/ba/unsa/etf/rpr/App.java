package ba.unsa.etf.rpr;

import java.util.Scanner;
public class App {

    public static void main(String[] args) throws IllegalArgumentException {

        Scanner unos = new Scanner(System.in);

        //unos zeljenog izraza sa razmacima
        System.out.println("Unesite željeni izraz: ");
        String[] izraz = unos.nextLine().split(" ");

        //objasnjenje
        String arg = unos.toString();

        try {
            System.out.println(ExpressionEvaluator.evaluate(arg));
        } catch (RuntimeException e) {
            System.out.println("Greška" + e.getMessage());
        }
    }
}





