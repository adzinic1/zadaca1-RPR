package ba.unsa.etf.rpr;
import java.util.Objects;
import java.util.Stack;


public class ExpressionEvaluator {

    private static int naredniRazmak(String string, int pocetni_index) {
        for (int i = pocetni_index; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                return i;
            }
        }
        return string.length();
    }
    public static int brojZagrada(String args){
        int brojacOtvorene=0;
        int brojacZatvorene=0;
        for (int i = 0 ; i < args.length() ; i++) {
            if (args.charAt(i)=='(') brojacOtvorene = 1 + brojacOtvorene;
            if (args.charAt(i)==')') brojacZatvorene = 1 + brojacZatvorene;
            }
        if(brojacOtvorene==0 && brojacZatvorene==0) return 1;
        if(Objects.equals(brojacOtvorene, brojacZatvorene)) return 2;
        return 0;
    }

    public static Double evaluate(String args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        int razmak = 0;

            try {
                if (brojZagrada(args) == 0 || brojZagrada(args) == 1 ) throw new RuntimeException("Uneseni izraz nije aritmetički validan.");
            }catch (RuntimeException e){
                throw new RuntimeException("Uneseni izraz nije aritmetički validan.");
            }

        for (int i = 0; i < args.length();) {
            if (args.charAt(i) == ' ') {
                if (razmak++ > 0) {
                    throw new RuntimeException("Uneseni izraz nije aritmetički validan.");
                }
                i++;
                continue;
            } else {
                razmak= 0;
            }
            int pom = i;
            String znak = args.substring(pom, i = naredniRazmak(args, pom));

            switch (znak) {
                case "(":
                    break;
                case "+":
                    ops.push("+");
                    break;
                case "-":
                    ops.push("-");
                    break;
                case "*":
                    ops.push("*");
                    break;
                case "/":
                    ops.push("/");
                    break;
                case "sqrt":
                    ops.push("sqrt");
                    break;
                case ")":

                    String op = ops.pop();
                    double v = vals.pop();

                    switch (op) {
                        case "+":
                            v = v + vals.pop();
                            break;
                        case "-":
                            v = vals.pop() - v;
                            break;
                        case "*":
                            v = v * vals.pop();
                            break;
                        case "/":
                            v = vals.pop() / v;
                            break;
                        case "sqrt":
                            v = Math.sqrt(v);
                            break;
                    }

                    vals.push(v);
                    break;
                default:
                    try {
                        vals.push(Double.parseDouble(znak));
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("Uneseni izraz nije aritmetički validan.");
                    }
                    break;
            }
        }

        return vals.peek();

    }}




