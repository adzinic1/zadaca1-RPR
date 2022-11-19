package ba.unsa.etf.rpr;
import java.util.Objects;
import java.util.Stack;


public class ExpressionEvaluator {


    /**
     * Used to split a string without whitespaces
     * @param args A string containing the entered expression.
     * @param first Index of the initial position of the search.
     * @return Index of the next whitespace character.
     */
    private static int nextWhitespace(String args, int first) {
        for (int i = first; i < args.length(); i++) {
            if (args.charAt(i) == ' ') {
                return i;
            }
        }
        return args.length();
    }

    /**
     * Checks the number of parentheses in the entered expression
     * @param args A string containing the entered expression.
     * @return 1 if an empty expression is entered, 2 if the number of open and closed parentheses is the same and 0 if the number of parentheses is different.
     */
    public static int parenthesisNumber(String args){
        int openParenthesisCounter=0;
        int closedParenthesisCounter=0;
        for (int i = 0 ; i < args.length() ; i++) {
            if (args.charAt(i)=='(') openParenthesisCounter = 1 + openParenthesisCounter;
            if (args.charAt(i)==')') closedParenthesisCounter = 1 + closedParenthesisCounter;
            }
        if(openParenthesisCounter==0 && closedParenthesisCounter==0) return 1;
        if(Objects.equals(openParenthesisCounter, closedParenthesisCounter)) return 2;
        return 0;
    }

    /**
     * A method that receives an arithmetic expression suitable for the Dijkstra algorithm which calculates the value of the given expression.
     * @param args A string containing the entered expression.
     * @return The result of the entered arithmetic expression.
     * @throws RuntimeException In case the expression is not arithmetically valid.
     */
    public static Double evaluate(String args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        int razmak = 0;

            try {
                if (parenthesisNumber(args) == 0 || parenthesisNumber(args) == 1 ) throw new RuntimeException("Uneseni izraz nije aritmeticki validan.");
            }catch (RuntimeException e){
                throw new RuntimeException("Uneseni izraz nije aritmeticki validan.");
            }

        for (int i = 0; i < args.length();) {
            if (args.charAt(i) == ' ') {
                if (razmak++ > 0) {
                    throw new RuntimeException("Uneseni izraz nije aritmeticki validan.");
                }
                i++;
                continue;
            } else {
                razmak= 0;
            }
            int pom = i;
            String znak = args.substring(pom, i = nextWhitespace(args, pom));

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
                        throw new RuntimeException("Uneseni izraz nije aritmeticki validan.");
                    }
                    break;
            }
        }

        return vals.peek();

    }}




