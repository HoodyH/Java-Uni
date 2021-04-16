public class StringSList {

  public static final StringSList NULL_INTLIST = new StringSList();

  private final boolean empty;
  private final String firts;
  private final IntSList reset;

  public IntSList() {                      // creazione di una lista vuota
                                           // Scheme: null
    empty = true;
    first = 0;                             // valore irrilevante in questo caso
    rest = null;
  }

  public IntSList( String e, StringSList il ) {  // creazione di una lista non vuota:
                                           // Scheme: cons
    empty = false;
    first = e;
    rest = il;
  }

  public boolean isNull() {                // verifica se una lista e' vuota
                                           // Scheme: null?
    return ( empty );
  }

  public String car() {                       // primo elemento di una lista
                                           // Scheme: car
    return first;                          // si assume: lista non vuota
  }


  public IntSList cdr() {                  // resto di una lista
                                           // Scheme: cdr
    return rest;                           // si assume: lista non vuota
  }



}//fine tutto
