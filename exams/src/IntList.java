public class IntList {

    public static final IntList NULL_INTLIST = new IntList();


    // ----- Rappresentazione interna di una lista: private!

    private final boolean empty;             // oggetti immutabili:
    private final int first;                 // variabili di istanza "final"
    private final IntList rest;


    // ----- Operazioni di base sulle liste, mutuate da Scheme

    public IntList() {                      // creazione di una lista vuota
        // Scheme: null
        empty = true;
        first = 0;                             // valore irrilevante in questo caso
        rest = null;
    }

    public IntList( int n, IntList u) {  // creazione di una lista non vuota:
        // Scheme: cons
        empty = false;
        first = n;
        rest = u;
    }


    public boolean isNull() {                // verifica se una lista e' vuota
        // Scheme: null?
        return ( empty );
    }


    public int car() {                       // primo elemento di una lista
        // Scheme: car
        return first;                          // si assume: lista non vuota
    }


    public IntList cdr() {                  // resto di una lista
        // Scheme: cdr
        return rest;                           // si assume: lista non vuota
    }

    // ----- Operazioni aggiuntive, definite in termini dei precedenti metodi

    public int length() {                    // lunghezza di una lista
        // Scheme: length
        if ( isNull() ) {
            return 0;
        } else {
            return ( 1 + cdr().length() );
        }
    }

    public IntList append( IntList v ) {  // fusione di liste
        // Scheme: append
        if ( isNull() ) {
            return v;
        } else {
            return new IntList( car(), cdr().append(v) );
        }
    }

    public String toString() {               // ridefinizione del metodo generale
        // per la visualizzazione testuale
        if ( empty ) {
            return "()";
        } else if ( rest.isNull() ) {
            return "(" + first + ")";
        } else {
            String rep = "(" + first;
            IntList r = rest;
            while ( !r.isNull() ) {
                rep = rep + ", " + r.car();
                r = r.cdr();
            }
            return ( rep + ")" );
        }
    }


}
