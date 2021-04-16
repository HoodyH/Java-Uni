//coefficiente binomiale
/*

   if ( not inside M )
   {
        equal n = r or r = 0
        M[n,r] = 1;
        else
            M[n,r] = recursion (n-1,r-1,M) + recursion(n-1, r, M);

*/
public class Coef_Bin_Topdown {

    private static int UNKNOWN = -1;

    public static void main(String[] args)
    {
        //creare la matrice vuota

        System.out.print( Top_down_aux(4, 2));
    }

    private static int Top_down_aux(int n, int r) {

        int mat[][] = new int[n+1][r+1];

        for(int i=0;i<n+1;i++)
        {
            System.out.print("| ");

            for(int j=0;j<r+1;j++) {

                mat[i][j] = UNKNOWN;
                System.out.print(" " + mat[i][j] + " | ");
            }

            System.out.print("\n");
        }

        System.out.print("\n");

        return risultato(n,r,mat);

    }

    private static int risultato(int n, int r, int mat[][])
    {

        if(mat[n][r] == UNKNOWN)
        {
            if(n==r || r==0)
                mat[n][r] = 1;

            else

                mat[n][r] = risultato(n-1, r-1, mat)+ risultato(n-1, r, mat);

        }


        return mat[n][r];
    }



}
