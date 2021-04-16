public class es4 {

    public static long q (int i, int j, String x){
        int a,b=0,c=0,k=0;
        int u = x.length();
        System.out.println(x.length());
        int[][][] h = new int[u+1][u+1][u+1];



        for( a = i; a > 0; a--) {
            for (b = j; b > 0; b--) {
                for (c = u; c > 0; c--) {

                    if (i + j < u)
                        h[a][b][c] = 0;

                    if (i + j == 0)
                        h[a][b][c] = 1;

                    else {

                        k = 0;

                        if (i > 0) {
                            if ((u > 0) && (x.charAt(0) == '0')){
                                h[a][b][c] = h[a - 1][b][c - 1];
                                k = k + h[a][b][c] ;
                            }

                            else {
                                h[a][b][c] = h[a - 1][b][c];
                                k = k + h[a][b][c];
                            }
                        }
                        if (j > 0) {
                            if ((u > 0) && (x.charAt(0) == '1')) {
                                h[a][b][c] = h[a][b - 1][c - 1];
                                k = k + h[a][b][c];
                            }
                            else {
                                h[a][b][c] = h[a][b - 1][c];
                                k = k + h[a][b][c];
                            }
                        }
                    }

                    System.out.println(k);
                }
            }
        }


        return h[a][b][c];
    }


    public static void main (String [] args){
        System.out.println(q(0, 0, "1011"));

    }




}
