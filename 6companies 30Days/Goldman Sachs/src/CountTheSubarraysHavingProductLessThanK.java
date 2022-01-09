public class CountTheSubarraysHavingProductLessThanK {

    public static int countSubArrayProductLessThanK(long a[], long n, long k) {
        int prod = 1;
        int j = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            prod *= a[i];
            while(prod >= k) {
                prod /= a[j];
                j++;
            }
            count += (i - j + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int n =7;
        int k = 100;
        long[] a = {1, 9, 2, 8, 6, 4, 3};
        System.out.println(countSubArrayProductLessThanK(a,n,k));
    }
}
