import queens.*;

public class QueensV2 {




        public static final SList<BoardV2> NULL_BOARDLIST = new SList<BoardV2>();



        public static int numberOfSolutions( int n) {

            return numberOfCompletions( new BoardV2(n));
        }



        private static int numberOfCompletions( BoardV2 b ) {

            int n = b.size();
            int q = b.queensOn();

            if ( q == n ) {


                return 1;
            } else {

                int i = q + 1;
                int count = 0;

                for ( int j=1; j<=n; j=j+1 ) {
                    if ( !b.underAttack(i,j) ) {

                        count = count + numberOfCompletions( b.addQueen(i,j));
                    }}
                 return count;
            }
        }



        public static SList<BoardV2> listOfAllSolutions( int n, ChessboardView v ) {

            return listOfAllCompletions( new BoardV2(n), v );
        }


        private static SList<BoardV2> listOfAllCompletions( BoardV2 b, ChessboardView v) {

            int n = b.size();
            int q = b.queensOn();

            if ( q == n ) {

                b.arrangiament( v );
                return ( NULL_BOARDLIST.cons(b) );

            } else {

                int i = q + 1;
                SList<BoardV2> solutions = NULL_BOARDLIST;

                for ( int j=1; j<=n; j=j+1 ) {
                    if ( !b.underAttack(i,j) ) {

                        solutions = solutions.append( listOfAllCompletions(b.addQueen(i,j), v) );
                        b.arrangiament( v );
                    }}
                return solutions;
            }
        }


        // Eventuale programma principale





        public static void main( String args[] ) {



            int n = 8;
            ChessboardView view = new ChessboardView( n );
            System.out.println( numberOfSolutions(n));
            System.out.println( listOfAllSolutions(n, view) );

        }
}
