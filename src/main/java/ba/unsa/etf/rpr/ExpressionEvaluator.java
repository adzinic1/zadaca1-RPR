package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    public static Stack<Double> evaluate(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

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
                    v = vals.pop() - v;
                } else if(op.equals("/")) {
                    v = vals.pop() - v;
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



