public class RoundTableV2 {


        // ----- Rappresentazione interna del modello: private!

        public final IntSList lista2;
        public final IntSList lista1;
        public final int num;


    // ----- Costruttore pubblico

        public RoundTableV2( int n ) {             // creazione di una tavola
            // con n cavalieri
            lista1 = range( 1, n );
            lista2 = IntSList.NULL_INTLIST;
            num = n;


        }


        // ----- Costruttore non pubblico di supporto

        private RoundTableV2( IntSList kns1, IntSList kns2, int n ) {

            lista1 = kns1;
            lista2 = kns2;
            num = n;
        }


        // ----- Metodi del protocollo: acquisizione di informazioni sulla configurazione

        public int numberOfKnightsIn() {         // numero di cavalieri a tavola

            return num;
        }


        public int knightWithJugIn() {           // cavaliere con la brocca di sidro

            return lista1.car();
        }


        // ----- Metodi del protocollo: configurazione successiva a una mossa

        public RoundTableV2 afterNextKnightQuits() {

            switch (lista1.length()) {
                case 1:
                    return new RoundTableV2(lista2.reverse().cdr().append(lista1), IntSList.NULL_INTLIST, num-1 );

                case 2:
                    return new RoundTableV2((lista2.reverse()).append(IntSList.NULL_INTLIST.cons(lista1.car())), IntSList.NULL_INTLIST, num-1 );

                default:
                    return new RoundTableV2(lista1.cdr().cdr(), lista2.cons( lista1.car()), num-1 );

            }//end case


        }


        // ----- Procedura interna di supporto (private!)

        private static IntSList range( int inf, int sup ) {

            if ( inf > sup ) {
                return IntSList.NULL_INTLIST;
            } else {
                return range( inf+1, sup ).cons( inf );
            }
        }
}//RoundTableV2
