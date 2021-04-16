
/*
 * Modulo Josephus:
 *
 * Programma per risolvere il problema di Giuseppe Flavio
 * (metodi statici))
 *
 * Ultimo aggiornamento: 10/04/2018
 */


public class Josephus {

  public static int josephus( int n ) {
  
    return josephusRec( new RoundTable(n) );
  }
  
  private static int josephusRec( RoundTable rt ) {

    if ( rt.numberOfKnightsIn() > 1 ) {
      return josephusRec( rt.afterNextKnightQuits() );
    } else {
      //System.out.println( "2. " + rt.knights.car() );
      return rt.knightWithJugIn();
    }
  }

  
  public static void main( String args[] ) {
  
    int n = 10;
    
    for ( int k=1; k<=n; k=k+1 ) {
      System.out.println( josephus(k) );
    }
  }


}  // class Josephus

