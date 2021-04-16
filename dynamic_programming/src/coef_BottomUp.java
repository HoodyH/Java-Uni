public class coef_BottomUp {

    private static int UNKNOWN = -1;

    public static void main(String[] agrs)
    {
        System.out.print(coef_BottomUp_aux(4, 2));
    }

    private static int coef_BottomUp_aux(int n, int r) {

        int mat[][] = new int[n+1][r+1];

        return risultato(n, r, mat);

    }

    private static int risultato(int n, int r, int[][] mat) {


        for(int i = 0; i<=n-r;i++)
        {
            mat[i][0] = 1;
        }

        for(int i = 0;i<=r;i++)
        {
            mat[i][i] = 1;
        }

        for(int j=1;j<=r;j++)
        {
            for(int i = j+1; i<=n-r+j;i++)
            {
                mat[i][j] = mat[i-1][j-1]+mat[i-1][j];
            }
        }


        return mat[n][r];





    }


}
