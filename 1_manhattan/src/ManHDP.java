public class ManHDP {

    private static int UNKNOWN = -1;


    public static int mahnDP (int i, int j){

        int[][] h = new int [i+1][j+1];

        for (int u=0; u<=i; u++){
            h[u][0]=1;
        }

        for (int v=1; v<=i; v++){
            h[0][v]=1;
        }

        for (int u=1; u<=i; u++){
            for (int v=1; v<=i; v++){
                h[u][v]=h[u-1][v]+h[u][v-1];
            }
        }
        return h[i][j];
    }//end procedura


    public static int llcs(String u, String v){
        if ( u.equals("") || v.equals("") ) {
            return 0;
        } else if ( u.charAt(0) == v.charAt(0) ) {
            return 1 + llcs ( u.substring(1),v.substring(1) );
        } else{
            return Math.max( llcs(u,v.substring(1)),llcs(u.substring(1),v) );
        }
    }//end procedura


    public static int llcsMem(String u, String v){
        int m = u.length();
        int n = v.length();

        int[][] h = new int[m+1][n+1];

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                h[i][j]= UNKNOWN;
            }
        }

        return llcsRec (u, v, h);
    }//end procedura llcsMem


    public static int llcsRec(String u, String v, int h[][]) {

        int m = u.length();
        int n = v.length();

        if (h[m][n] == UNKNOWN) {

            if (u.equals("") || v.equals("")) {
                h[m][n] = 0;
            } else if (u.charAt(0) == v.charAt(0)) {
                h[m][n]= 1 + llcsMem(u.substring(1), v.substring(1));
            } else {
                h[m][n]= Math.max( llcsMem(u, v.substring(1)), llcsMem(u.substring(1), v) );
            }
        }
        return h[m][n];
    }//end procedura llcsRec


    public static void main(String args[]){

        //int d[][] = {{1,2,3,4},{1,2,3,4},{1,2,3,4}}; //new int [3][3];
        //d[][] = mahnDP(3,3);

        //System.out.println( mahnDP(5,5) ); //costruisce la matrice 5x5


        //System.out.println(llcsMem( "casa", "caszo"));
        boolean go = false;
        while(go == false);
    }



}//end class
