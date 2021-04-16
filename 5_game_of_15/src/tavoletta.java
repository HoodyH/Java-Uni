import java.util.*;
import puzzleboard.*;

public class tavoletta {

    public final int dim;
    public int [][] m;
    public final int gap;
    public int Nmosse;
    public long t0;

    private int i0;
    private int j0;


    public tavoletta(int n) {

        dim = n;
        gap = dim*dim;
        m = new int[dim][dim];
        Nmosse=0;
        t0 = System.currentTimeMillis();

        int a = 1;

        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++) {
                m[i][j] = a;
                a++;
            }
        }

        Random random = new Random();
        int iswap;
        int jswap;

        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++) {

                do {
                    iswap = random.nextInt(dim - 1);
                    jswap = random.nextInt(dim - 1);
                }while (i==iswap && j==jswap);
                int swap = m[i][j];
                m[i][j]=m[iswap][jswap];
                m[iswap][jswap]=swap;

            }
        }

        for(int i=0; i<dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (m[i][j] == gap) {
                    i0 = i;
                    j0 = j;
                }
            }
        }
    }



    public boolean sequenceOk(){

        int count = 1;

        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                if(m[i][j] != count)
                    return false;
                count++;
            }
        }
        return true;
    }


    public int move (int i, int j){

        if (  (i==i0 && (j==j0+1 || j==j0-1)) || ((i==i0+1 || i==i0-1) && j==j0) ){
            m[i0][j0] = m[i][j];
            m[i][j]=gap;
            i0=i;
            j0=j;
            Nmosse++;
            System.out.println(txtConfig());
            return 1;
        }
    return -1;
    }

    public void CeckMove(int i, int j){

        if(move(i,j)==-1)
            System.out.println("La casella non può essere mossa\r\n");
    }





    private int GUImove (int i, int j, PuzzleBoard b){

        if (  (i==i0 && (j==j0+1 || j==j0-1)) || ((i==i0+1 || i==i0-1) && j==j0) ){
            m[i0][j0] = m[i][j];
            b.setNumber( i0+1,j0+1, m[i][j]); //GUI
            m[i][j]=gap;
            i0=i;
            j0=j;
            b.clear( i0+1,j0+1 ); //GUI
            Nmosse++;
            System.out.println(txtConfig());
            return 1;
        }
        return -1;
    }

    public void GUICeckMove(int i, int j, PuzzleBoard b){

        if(GUImove(i,j,b)==-1)
            System.out.println("La casella non può essere mossa\r\n");
    }




    public String txtConfig(){

        StringBuilder str = new StringBuilder ();

        for(int i=0; i<dim; i++){
            str.append("| ");
            for(int j=0; j<dim; j++){
                if(m[i][j]<10)
                    str.append(m[i][j]+"  | ");
                else
                    str.append(m[i][j]+" | ");
            }
            str.append("\r\n");
        }

        str.append("posizione dello 0:\r\n"+"i0: "+i0 +"  j0: "+j0+"\r\n");
        str.append("Numero di mosse: "+Nmosse+"\r\n");

        String sout = str.toString();

        return sout;
    }//end txtConfig



}
