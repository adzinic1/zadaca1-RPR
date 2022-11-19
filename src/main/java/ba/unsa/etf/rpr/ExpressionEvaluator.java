package ba.unsa.etf.rpr;

import java.util.Objects;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int brojZagrada(String[] args){
        int brojacOtvorene=0;
        int brojacZatvorene=0;
        for (int i = 0 ; i < args.length ; i++) {
            if (args[i].equals("(")) brojacOtvorene = 1 + brojacOtvorene;
            if (args[i].equals(")")) brojacZatvorene = 1 + brojacZatvorene;
            }
        if(brojacOtvorene==0 && brojacZatvorene==0) return 2;
        if(Objects.equals(brojacOtvorene, brojacZatvorene)) return 1;

        return 0;
    }

    public static Stack<Double> evaluate(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

            try {
                if (brojZagrada(args) == 0 || brojZagrada(args) == 2 ) throw new RuntimeException("Uneseni izraz nije aritmetički validan.");
            }catch (RuntimeException e){
                throw new RuntimeException("Uneseni izraz nije aritmetički validan.");
            }



        for (int i = 0 ; i < args.length ; i++) {
            if (args[i].equals("("));
            else if (args[i].equals("+")) {
                ops.push(args[i]);
            } else if (args[i].equals("-")) {
                ops.push(args[i]);
            } else if (args[i].equals("*")) {
                ops.push(args[i]);
            } else if (args[i].equals("/")) {
                ops.push(args[i]);
            } else if (args[i].equals(")")){

                String op = ops.pop();
                double v = vals.pop();
                if(op.equals("+")){
                    v = vals.pop() + v;
                } else if(op.equals("-")){
                    v = vals.pop() - v;
                } else if(op.equals("*")) {
                    v = vals.pop() * v;
                } else if(op.equals("/")) {
                    v = vals.pop() / v;
                }
                vals.push(v);
            }
            else{
                vals.push(Double.parseDouble(args[i]));
            }
        }

        return vals;
    }
    }



