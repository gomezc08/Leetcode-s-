import java.util.*;

public class GenerateParenthesis {

    // global variables.
    Stack<String> s = new Stack<>();
    ArrayList<String> a = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int open_count = 0;
        int closed_count = 0;
        generateParenthesisHelper(open_count, closed_count, n);
        return a;
    }

    public void generateParenthesisHelper(int open, int closed, int n) {
        // base case.
        if (open == n && closed == n) {
            a.add(String.join("", s));
            return;
        }

        // nondeterminism case(s).

        // open.
        if (open < n) {
            s.push("(");
            generateParenthesisHelper(open + 1, closed, n);
            s.pop();
        }

        // closed.
        if (closed < open) {
            s.push(")");
            generateParenthesisHelper(open, closed + 1, n);
            s.pop();
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis p = new GenerateParenthesis();
        System.out.println(p.generateParenthesis(3));
    }
}
