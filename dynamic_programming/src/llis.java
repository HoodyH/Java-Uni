public class llis {

    public static void main( String args[]) {

        System.out.println("\n"+llisMem(new int[]{5, 4, 3, 2, 1})); //1
        System.out.println(llisMem(new int[]{47, 38, 39, 25, 44})); //3
        System.out.println(llisMem(new int[]{27, 90, 7, 29, 49, 8, 53, 1, 28, 6})); //4
        System.out.println(llisMem(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); //5
        System.out.println(llisMem(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1})); //3

    }

    public static long llisMem ( int[] s){
        int n = s.length;
        int[] a = new int[n + 1];
        for (int i = 0; i< n; i++){ a[i] = s[i]; }
        a[n] = 0;

        long[][] h = new long[n+1][n+1];
        for ( int i=0; i<=n; i=i+1 ) {
            for ( int j=0; j<=n; j=j+1 ) {
                h[i][j] = 0;
            }
        }
        return llisRecMeM(a, h, 0, n);
    }

    private static long llisRecMeM ( int[] a, long[][] h, int i, int j) { //con j indice di t

        final int n = a.length-1; //lunghezza vettore di interi

        if (h[i][j] == 0) {

            if (i == n) {
                h[i][j] = 0;
            }else if (a[i] <= a[j]) {
                h[i][j] = llisRecMeM(a, h, i + 1, j);
            }else{
                h[i][j] = Math.max(1 + llisRecMeM(a, h, i + 1, i), llisRecMeM(a, h, i + 1, j));
            }
        }
            return h[i][j];
    }



}
