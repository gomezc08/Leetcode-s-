import java.util.*;

public class PolishNotation {
    public int evalRPN(String[] tokens) {
        // define variables.
        HashSet<String> operands = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> s = new Stack<>();

        // go through tokens.
        for(int i = 0; i < tokens.length; i++) {
            // check if it's an operand or not.
            if(operands.contains(tokens[i]) && !s.isEmpty()) {
                int num2 = s.pop();
                // update hashmap + stack.
                s.push(evalRPNHelper(s.pop(), num2, tokens[i]));
            }

            // check if it's a "number"
            else if(!operands.contains(tokens[i])) {
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return s.pop();
    }

    public int evalRPNHelper(int a, int b, String operator) {
        switch(operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        PolishNotation p = new PolishNotation();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(p.evalRPN(tokens));
    }
}
