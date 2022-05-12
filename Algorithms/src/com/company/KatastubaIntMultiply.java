package com.company;

public class KatastubaIntMultiply {
    public static long mult(long x, long y) {
        if (x < 10 && y < 10) {
            return x * y;
        }

        int noOneLength = numLength(x);
        int noTwoLength = numLength(y);

        int maxNumLength = Math.max(noOneLength, noTwoLength);

        Integer halfMaxNumLength = (maxNumLength / 2) + (maxNumLength % 2);

        long maxNumLengthTen = (long)Math.pow(10, halfMaxNumLength);

        long a = x / maxNumLengthTen;
        long b = x % maxNumLengthTen;
        long c = y / maxNumLengthTen;
        long d = y % maxNumLengthTen;

        long z0 = mult(a, c);
        long z1 = mult(a + b, c + d);
        long z2 = mult(b, d);

        long ans = (z0 * (long)Math.pow(10, halfMaxNumLength * 2) + ((z1 - z0 - z2) * (long)Math.pow(10, halfMaxNumLength) + z2));

        return ans;

    }


    public static int numLength(long n) {
        int noLen = 0;
        while (n > 0) {
            noLen++;
            n /= 10;
        }

        return noLen;
    }

    public static void main(String[] args) {

        long expectedProduct = 1234 * 5678;
        long actualProduct = mult(1234, 5678);

        System.out.println("Expected 1 : " + expectedProduct);
        System.out.println("Actual 1 : " + actualProduct + "\n\n");

    }
}
