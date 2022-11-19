package ba.unsa.etf.rpr;

import java.util.Scanner;
public class App  {

    public static void main(String[] args) throws RuntimeException{

        Scanner unos = new Scanner(System.in);
        System.out.println("Unesite željeni izraz: ");
        String izraz = unos.nextLine();

        try {
            System.out.println(ExpressionEvaluator.evaluate(String.valueOf(izraz)));
        } catch (RuntimeException e) {
            System.out.println("Uneseni izraz nije aritmetički validan.");
        }
    }
}





