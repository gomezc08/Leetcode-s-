/*
 * 44. Wildcard Matching
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 */

public class WildCardMatch {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean isMatchHelper(char[] a, char[] b, int i, int j) {
        // Check if both strings are at the end
        if (i == a.length && j == b.length) {
            return true;
        }

        // Check if only the pattern is at the end (considering '*' as an empty sequence)
        if (j < b.length && b[j] == '*') {
            return isMatchHelper(a, b, i, j + 1) || (i < a.length && isMatchHelper(a, b, i + 1, j));
        }

        // Check if characters match or if it's a '?' wildcard
        if (i < a.length && j < b.length && (a[i] == b[j] || b[j] == '?')) {
            return isMatchHelper(a, b, i + 1, j + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        WildCardMatch w = new WildCardMatch();
        System.out.println(w.isMatch("aa", "a")); 
    }
}