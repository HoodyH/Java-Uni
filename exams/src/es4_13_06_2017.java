public class es4_13_06_2017 {

    //programma del testo dell'esercizio
    public static IntList lis( IntList s){
        return lisRec(s, 0);
    }

    public static IntList lisRec( IntList s, int t){
        if(s.isNull()){
            return new IntList();
        } else if (s.car() <= t){
            return lisRec( s.cdr(), t);
        } else{
            return longer( new IntList(s.car(), lisRec(s.cdr(), s.car()) ),
                            lisRec( s.cdr(), t)
                            );
        }
    }

    public static IntList longer(IntList u, IntList v){
        if(u.length() < v.length() ){
            return v;
        }else {
            return u;
        }
    }

    //programma in top down

    public static int UNKNOWN= -1;

    public static IntList DPlisMEM( IntList s){

        int n=s.length();

        IntList mat[][]= new IntList[n+1][n+1];

        for(int i=0; i<= n; i++)
            for(int j=0; j<= n; j++)
                mat[i][j]= new IntList(UNKNOWN,IntList.NULL_INTLIST);

        return DPlisRecMEM(s, 0, mat);
    }

    public static IntList DPlisRecMEM( IntList s, int t, IntList mat[][]){

        int i,j=s.length();
        i=j;

        if(mat[i][j].car()==UNKNOWN){

            if(s.isNull()){
                mat[i][j]= new IntList();
            } else if (s.car() <= t){
                mat[i][j]= lisRec( s.cdr(), t);
            } else{
                mat[i][j]= longer( new IntList(s.car(), lisRec(s.cdr(), s.car()) ),
                        lisRec( s.cdr(), t)
                );
            }
        }
        return mat[i][j];

    }

    public static void main (String []args){

        IntList L1 = new IntList( 5, IntList.NULL_INTLIST);
        IntList L2 = new IntList( 4, L1);
        IntList L3 = new IntList( 2, L2);
        IntList L4 = new IntList( 5, L3);


        System.out.println( lis(L4).toString() );
        System.out.println(DPlisMEM(L4).toString());



    }
}
