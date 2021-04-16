public class Subsequence {

    public static final int UNKNOWN = -1;

    public static void main (String[] args){


        System.out.println("v1");
        System.out.println(llis ( new int[] {47, 38, 39, 25, 44}) );
        System.out.println(llisMem ( new int[] {47, 38, 39, 25, 44}) );
        System.out.println("v2");
        System.out.println( llisIter ( new int[] {47, 38, 39, 25, 44}) );
        System.out.println("v3");
        System.out.println( llisDP ( new int[] {47, 38, 39, 25, 44}) );
        System.out.println(llisDP(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1}));

    }


//programma con ricorsione senza ottimizzazione

    public static int llis( int[] s){
        return llisRec( s, 0, 0);
    }

    public static int llisRec( int[] s, int i, int t){
        final int n = s.length;

        if( i == n ){
            return 0;
        } else if ( s[i] <= t ){
            return llisRec( s, i+1, t );
        }else{
            return Math.max( 1+llisRec( s, i+1, s[i]), llisRec(s, i+1, t) );
        }
    }



//ottimizzazione top down

    public static int llisMem( int[] s ){

        final int n = s.length;
        int[] vet = new int[n+1];

        for (int i=0; i<n; i++) {
            vet[i] = s[i];
        }
        vet[n]=0;

        int[][] h = new int[n+2][n+2];

        for (int i=0; i<=n; i++){
            for (int j=0; j<=n; j++) {
                h[i][j] = UNKNOWN;
            }
        }

        return llisMemRec (vet, h,1, n);

    }


    public static int llisMemRec(int[] vet, int m[][], int i, int j) {

        final int n = vet.length;

        if ( m[i][j] == UNKNOWN) {

            if (i == n)
                m[i][j] = 0;
            else if (vet[i] < vet[j])
                m[i][j] = llisMemRec(vet, m, i + 1, j);
            else
                m[i][j] = Math.max(1 + llisMemRec(vet, m, i + 1, i), llisMemRec(vet, m, i + 1, j));
        }

        return m[i][j];
    }


//programma iterativo sequanza di indice consecutivo

    public static int llisIter (int [] vec) {

        int n = vec.length;
        int count=0;
        int out=0;
        int i=0;

        while (i < n-1){

            for (int j = i+1; j < n; j++) {
                if(vec[j] > vec[i]) {
                    count++;
                    i++;
                }
                    i++;
            }
            if (out < count)
                out=count;
            count = 0;
        }
        return out;
    }

    public static int llis_B_UP(){
        return 1;
    }



    public static long llisDP (int s[]){
        int n = s.length;

        int[] a = new int[n + 1];

        System.arraycopy(s, 0, a, 0, n);
        a[n] = 0;

        int[][] h = new int[n+1][n+1];

        for(int j = n; j>= 0; j--){ h[n][j] = 0; }

        for( int i = n-1; i >= 0; i--){
            for( int j = n; j >= 0; j--){
                if (a[i] <= a[j]){
                    h[i][j] = h[i+1][j];
                } else {
                    h[i][j] = Math.max(1 + h[i+1][i], h[i+1][j]);
                }
            }
        }

        for( int i = n; i < n; i++) {
            for (int j = n; j < n; j++) {
                System.out.print(h[i][j]+" ");
            }
        }


        return h[0][n];
    }
}
