import java.util.*;

class LongestPalindrome {
    public static int longestPalindrome(String s) {
        // count of number of characters.
        // aggregate all even one's, then select the largest odd length.
        int sum = 0;
        int biggest_odd = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        for(char c : s.toCharArray()) {
            // check if out character is there or not.
            if(h.containsKey(c)) {
                h.put(c, h.get(c) + 1);
            }
            else {
                h.put(c, 1);
            }
        }

        for(char c : h.keySet()) {
            // EVEN.
            System.out.println(c);
            if(h.get(c) % 2 == 0) {
                sum += h.get(c);
            }
            // ODD
            else {
                // check biggest odd.
                if(h.get(c) > biggest_odd) {
                    biggest_odd = h.get(c);
                }
            }
        }
        sum += biggest_odd;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}