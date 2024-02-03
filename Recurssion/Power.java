/*
 * 50. Pow(x, n)
 * 
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */

class Power {
    public double myPow(double x, int n) {
        // base cases.
        if(n == 0) {
            return 1.0;
        }
        else if(n == 1) {
            return x;
        }
        else if(n < 0) {
            return myPow(1/x, (n * -1));
        }

        // recursive case.
        double root = myPow(x, Math.floor(n / 2));
        if(n % 2 == 0) {
            return root * root;
        }
        else {
            return root * root * x;
        }
        
    }

    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.myPow(2.00000, 10));
    }
}