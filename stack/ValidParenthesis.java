import java.util.*;

class ValidParenthesis {
    public boolean isValid(String s) {
        // define variables.
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(char i : c) {
            // open parenthesis.
            if(i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } 

            // closed parenthesis.
            else if(i == ')' || i == ']' || i == '}') {
                // pop off the string and check if it's valid or not.
                if(stack.isEmpty()) {
                    return false; // No matching opening parenthesis
                }
                char popped_parenthesis = stack.pop();
                if(!(i == ')' && popped_parenthesis == '(') && !(i == ']' && popped_parenthesis == '[') && !(i == '}' && popped_parenthesis == '{')) {
                    return false; // Invalid closing parenthesis
                }
            }
        } 

        return stack.isEmpty(); // Ensure the stack is empty (all opened parentheses are closed)
    }

    public static void main(String[] args) {
        ValidParenthesis v = new ValidParenthesis();
        System.out.println(v.isValid("()[]{}"));
    }
}
