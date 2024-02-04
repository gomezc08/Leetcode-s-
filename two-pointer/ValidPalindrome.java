public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // define variables.
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while(left <= right) {
            // check if it's not string.
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left += 1;
                continue;
            }
            else if(!Character.isLetterOrDigit(s.charAt(right))) {
                right -= 1;
                continue;
            }

            // compare characters.
            if(s.charAt(right) != s.charAt(left)) {
                return false;
            }
            
            // update pointers.
            left += 1;
            right -= 1;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
