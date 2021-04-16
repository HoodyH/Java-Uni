public class LIS {

    public static void main(String[] args) {
        System.out.println(llisMem(new int[] {5, 4, 3, 2, 1}));
        System.out.println(llisMem(new int[] {47, 38, 39, 25, 44}));
        System.out.println(llisMem(new int[] {27, 90, 7, 29, 49, 8, 53, 1, 28, 6}));
        System.out.println(llisMem(new int[] {9, 46, 54, 71, 60, 47, 0, 32, 25, 61}));
        System.out.println(llisMem(new int[] {54, 52, 42, 33, 14, 40, 37, 61, 53, 1}));
        System.out.println(llisDP(new int[] {5, 4, 3, 2, 1}));
        System.out.println(llisDP(new int[] {47, 38, 39, 25, 44}));
        System.out.println(llisDP(new int[] {27, 90, 7, 29, 49, 8, 53, 1, 28, 6}));
        System.out.println(llisDP(new int[] {9, 46, 54, 71, 60, 47, 0, 32, 25, 61}));
        System.out.println(llisDP(new int[] {54, 52, 42, 33, 14, 40, 37, 61, 53, 1}));
    }

    public static int llis( int[] s ) {   // s[i] > 0 per i in [0,n-1], dove n = s.length

        return llisRec( s, 0, 0 );
    }

    public static int llisRec( int[] s, int i, int t ) {
        final int n = s.length;
        if ( i == n ) {
            return 0;
        } else if ( s[i] <= t ) {
            return llisRec( s, i+1, t );
        } else {
            return Math.max( 1+llisRec(s,i+1,s[i]), llisRec(s,i+1,t) );
        }
    }

    public static long llisMem(int[] s) {
        int n = s.length;
        int[] q = new int[n+1];
        for (int a=0; a<n; a++) {
            q[a] = s[a];
        }
        q[n] = 0;
        long[][] h = new long [n+1][n+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                h[i][j] = UNKNOWN;
            }
        }
        return (llisRecMem(q, 0, n, h));
    }

    public static long llisRecMem( int[] s, int i, int j, long[][] h) {
        int n = s.length - 1;
        if (h[i][j] == UNKNOWN) {
            if (i == n) {
                h[i][j] = 0;
            } else if (s[i] <= s[j]) {
                h[i][j] = (llisRecMem(s, i + 1, j, h));
            } else {
                h[i][j] = Math.max(1+llisRecMem(s, i+1, i, h), llisRecMem(s, i+1, j, h));
            }
        }
        return h[i][j];
    }


    private static final long UNKNOWN = -1;

    public static int[] llisDP(int[] s) {
        int n = s.length;
        int[] q = new int[n + 1];
        for (int a=0; a<n; a++) {
            q[a] = s[a];
        }
        q[n] = 0;

        int[][] h = new int [n+1][n+1];

        for (int i = 0; i <= n; i++) {
            h[n][i] = 0;
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (q[i] <= q[j]) {
                    h[i][j] = h[i+1][j];
                } else {
                    h[i][j] = Math.max(1 + h[i+1][i], h[i+1][j]);
                }
            }
        }
        //return h[0][n];

        int i = 0;
        int j = n;
        int[] z = new int[h[0][n]];
        int a = 0;

        while ( h[i][j] > 0 ) {
            if (q[i] <= q[j]) {
                i = i + 1;
            } else {
                if ((1 + h[i+1][i]) > h[i+1][j]) {
                    z[a] = q[i];
                    a = a + 1;
                    j = i;
                    i = i + 1;
                } else {
                    i = i + 1;
                }
            }
        }
        for (int b=0; b<z.length; b++) {
            System.out.print(z[b] + " ");
        }
        return z;
    }

}
