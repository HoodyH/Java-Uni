

public class Board{

    public final int dim;
    public final int queens;
    public final SList<Integer> rig;
    public final SList<Integer>  col;
    public final SList<Integer>  dAscDx;
    public final SList<Integer>  dAscSx;
    public final SList<String> txt;


    public Board (int n){
        dim = n;
        queens = 0;
        rig=SList.NULL_LIST;
        col=SList.NULL_LIST;
        dAscDx=SList.NULL_LIST;
        dAscSx=SList.NULL_LIST;
        txt=SList.NULL_STRING;

    }//end costruttore


    public Board (int n, int q, SList<Integer>  r, SList<Integer>  c, SList<Integer>  Dx, SList<Integer>  Sx, SList<String> t){
        dim = n;
        queens = q;
        rig = r;
        col = c;
        dAscDx= Dx;
        dAscSx= Sx;
        txt = t;
        arrangiament();

    }//end costruttore

    public Board (int n, int q, SList<Integer>  r, SList<Integer>  c, SList<Integer>  Dx, SList<Integer>  Sx, SList<String> a, String s){
        dim = n;
        queens = q;
        rig = r;
        col = c;
        dAscDx= Dx;
        dAscSx= Sx;
        txt = a;


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


    public Board addQueen(int i, int j){

        SList<Integer>  Srig = rig.append( (SList.NULL_LIST).cons(i) );
        SList<Integer>  Scol = col.append( (SList.NULL_LIST).cons(j) );
        SList<Integer>  SdAscDx = dAscDx.append( (SList.NULL_LIST).cons( i-j ) );
        SList<Integer>  SdAscSx = dAscSx.append( (SList.NULL_LIST).cons( i+j ) );

        return new Board( dim,queens+1, Srig, Scol, SdAscDx, SdAscSx, txt);

    }//end addQueen

    public Board arrangiament(){

        String alfabeto[] = {"a","b","c","d","e","f","g","h","i","l","m","n","o","p","q","r","s","m"};

        StringBuilder  str = new StringBuilder ();
        for (int i = 0; i < queens; i++) {
            str.append(alfabeto[col.listRef(i)-1] + (rig.listRef(i)) + " ");
        }//end for

        String sout = str.toString();
        SList<String> t = txt.append(SList.NULL_STRING.cons(sout));

        System.out.println(sout);
        System.out.println(txt);

        return new Board ( dim, queens, rig, col, dAscDx, dAscSx, t, sout);

    }




}//end class

