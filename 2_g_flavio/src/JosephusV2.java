public class JosephusV2 {

    public static int josephusV2( int n ) {

        return josephusV2Rec( new RoundTableV2(n) );
    }

    private static int josephusV2Rec( RoundTableV2 rt ) {

        if ( rt.numberOfKnightsIn() > 1 ) {
            return josephusV2Rec( rt.afterNextKnightQuits() );
        } else {
            //System.out.println( "2) " + rt.lista1.car() );
            return rt.knightWithJugIn();
        }
    }


    public static void main( String args[] ) {

        int n = 10;

        for ( int k=1; k<=n; k=k+1 ) {
            System.out.println( josephusV2(k) );
        }
    }
}
