import puzzleboard.*;

public class play {


    public tavoletta tav;
    public PuzzleBoard board;

    public play (int n){

        tav =new tavoletta(n);
        board = new PuzzleBoard(tav.dim);

        for(int i=0; i<tav.dim; i++){
            for(int j=0; j<tav.dim; j++) {
                board.setNumber(i+1, j+1, tav.m[i][j]);
            }
        }
    }

    public void findAndReplace(int k){

        int i;
        int j;

        System.out.println("Il numero selezionato è: "+k);

        for(i=0; i<tav.dim; i++){
            for(j=0; j<tav.dim; j++){
                if(tav.m[i][j] == k) {
                    tav.GUICeckMove(i,j,board);
                    k = -1;
                    break;
                }
            }
        }
    }


    public void ingame(){

        do{

            int k = board.get();
            findAndReplace(k);
            board.display();
        }
        while( tav.sequenceOk() == false );

        long t1 = System.currentTimeMillis();
        System.out.println("Complimenti, hai completato il gioco in: " + tav.Nmosse + " mosse");
        System.out.println("Hai impiegato "+ (t1-tav.t0)/1000 + " secondi");
    }


    public static void main(String[] args){

        play P = new play(4);
        P.ingame();

    }//end main
}
