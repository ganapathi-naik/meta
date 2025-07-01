
class Solution50 {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 1.0 / myPow(x, Math.abs(n));
        }

        double result = myPow(x, n / 2);

        if(n % 2 == 0) {
            return result * result;
        } else {
            return x * result * result;
        }
    }
}

//Above approch to handle the n = -2147483648
// Time complexity: O(log(n)) and Space complecity: O(log(n))
class Solution50 {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 1.0 / pow(x, Math.abs(n));
        }
        return pow(x, n);
    }

    public double pow(double x, long n) {
        if(n == 0) {
            return 1;
        }
        double result = pow(x, n / 2);
        if(n % 2 == 0) {
            return result * result;
        } else {
            return x * result * result;
        }
    }
}


//Time complexity: O(log(n)) and Space complecity: O(1)
class Solution50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / pow(x, Math.abs(n));
        }
        return pow(x, n);
    }

    public double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double doublingValue = x, result = 1.0;
        while (n != 0) {
            if (n % 2 != 0) {
                result = result * doublingValue;
            }
            doublingValue = doublingValue * doublingValue;
            n = n / 2;
        }
        return result;
    }
}
