
public class BoardV2{

    public final int dim;
    public final int queens;
    public final SList<Integer> rig;
    public final SList<Integer> col;
    public final SList<Integer> dAscDx;
    public final SList<Integer> dAscSx;



    public BoardV2 (int n){
        dim = n;
        queens = 0;
        rig=SList.NULL_LIST;
        col=SList.NULL_LIST;
        dAscDx=SList.NULL_LIST;
        dAscSx=SList.NULL_LIST;


    }//end costruttore


    public BoardV2 (int n, int q, SList<Integer> r, SList<Integer> c, SList<Integer> Dx, SList<Integer> Sx){
        dim = n;
        queens = q;
        rig = r;
        col = c;
        dAscDx= Dx;
        dAscSx= Sx;

    }//end costruttore


    public int size(){
        return dim;
    }

    public int queensOn(){
        return queens;
    }

    public boolean underAttack(int i, int j) {

        for (int a = 0; a < queens; a++) {

            if (rig.listRef(a) == i) {
                return true;
            }//end if rig
            else if (col.listRef(a) == j) {
                return true;
            }//end if col
            else if (dAscDx.listRef(a) == (i - j)) {
                return true;
            }//end if dAscDx
            else if (dAscSx.listRef(a) == (i + j)) {
                return true;
            }
        }//end for

        return false;

    }//end underAttack


    public BoardV2 addQueen(int i, int j){

        SList Srig = rig.append( (SList.NULL_LIST).cons(i) );
        SList Scol = col.append( (SList.NULL_LIST).cons(j) );
        SList SdAscDx = dAscDx.append( (SList.NULL_LIST).cons( i-j ) );
        SList SdAscSx = dAscSx.append( (SList.NULL_LIST).cons( i+j ) );

        return new BoardV2( dim,queens+1, Srig, Scol, SdAscDx, SdAscSx);

    }//end addQueen
/*
    public void arrangiament(ChessboardView v){


        String alfabeto[] = {"a","b","c","d","e","f","g","h","i","l","m","n","o","p","q","r","s","m","n","o","p","q"};

        StringBuilder  str = new StringBuilder ();
        for (int i = 0; i < queens; i++) {
            str.append(alfabeto[col.listRef(i)-1] + (rig.listRef(i)) + " ");
        }//end for

        String sout = str.toString();

        if (sout.length()== dim*3) {

            System.out.println("< "+dim+"x"+dim+" , "+queens+" , "+rig.toString()+" , "+col+" , "+dAscDx+" , "+dAscDx+" , "+sout+" >");
            v.setQueens(sout);
        }


    }
*/
}
