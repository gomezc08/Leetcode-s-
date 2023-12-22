/*
 * 22. Generate Parentheses

  * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

package DP;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    // memo tool.
    List<List<String>> memo = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // base case: n = 0.
        if (n == 0) {
            return new ArrayList<>();
        }

        // initialize memo.
        List<String> a = new ArrayList<>();
        a.add("");
        memo.add(a);

        // generate parentheses for n = 1 to n.
        for (int i = 1; i <= n; i++) {
            generateParenthesisHelper(i);
        }

        return memo.get(n);
    }

    private void generateParenthesisHelper(int n) {
        List<String> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (String p1 : memo.get(i)) {
                for (String p2 : memo.get(n - 1 - i)) {
                    a.add("(" + p1 + ")" + p2);
                }
            }
        }

        memo.add(a);
    }

    public static void main(String[] args) {
        GenerateParentheses instance = new GenerateParentheses();
        int n = 3;
        System.out.println(instance.generateParenthesis(n));
    }
}


