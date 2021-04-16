
/*
 * Classe RoundTable:
 *
 * Modello alla base del problema di Giuseppe Flavio
 * (rivisto in termini di cavalieri attorno al tavolo)
 *
 * Gli oggetti creati sono "immutabili".
 *
 * Ultimo aggiornamento: 10/04/2018
 */


public class RoundTable {


  // ----- Rappresentazione interna del modello: private!
  
  public final IntSList knights;          // lista dei cavalieri (numerati)
  public final int num;                   // numero dei cavalieri a tavola
  
  
  // ----- Costruttore pubblico
  
  public RoundTable( int n ) {             // creazione di una tavola
                                           // con n cavalieri
    knights = range( 1, n );
    num = n;
  }
  
  
  // ----- Costruttore non pubblico di supporto
  
  private RoundTable( IntSList kns, int n ) {
    
    knights = kns;
    num = n;
  }

  
  // ----- Metodi del protocollo: acquisizione di informazioni sulla configurazione
  
  public int numberOfKnightsIn() {         // numero di cavalieri a tavola
  
    return num;
  }
  

  public int knightWithJugIn() {           // cavaliere con la brocca di sidro
  
    return knights.car();
  }
  
  
  // ----- Metodi del protocollo: configurazione successiva a una mossa
  
  public RoundTable afterNextKnightQuits() {
  
    IntSList singleton = ( IntSList.NULL_INTLIST ).cons( knights.car() );
    
    return new RoundTable( knights.cdr().cdr().append(singleton), num-1 );
  }
  
  
  // ----- Procedura interna di supporto (private!)
  
  private static IntSList range( int inf, int sup ) {
  
    if ( inf > sup ) {
      return IntSList.NULL_INTLIST;
    } else {
      return range( inf+1, sup ).cons( inf );
    }
  }


}  // class RoundTable

