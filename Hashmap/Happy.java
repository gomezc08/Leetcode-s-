import java.util.HashSet;

class Happy {
    public boolean isHappy(int n) {
        HashSet<Integer> h = new HashSet<>();
        return isHappyHelper(n, h);
    }

    public boolean isHappyHelper(int n, HashSet<Integer> h) {
        // base case: duplicate found.
        if(h.contains(n)) {
            return false;
        }
        // case 2: found 1!
        int sum = 0;
        char[] s = (Integer.toString(n)).toCharArray();
        for(char c : s) {
            int tempNum = Character.getNumericValue(c);
            sum += (tempNum * tempNum);
        }
        if(sum == 1) {
            return true;
        }
        h.add(n);
        // case 3: recurssion.
        return isHappyHelper(sum, h);
    }
    public static void main(String[] args) {
        Happy h = new Happy();
        System.out.println(h.isHappy(2));
    }
}