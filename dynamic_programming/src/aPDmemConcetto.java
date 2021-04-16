import java.math.*;

public class aPDmemConcetto {
    /*
     * Approccio imperativo: Tecniche di memoization e programmazione dinamica
     *
     * Ultimo aggiornamento: 3/04/2014
     */


  // BigInteger

/* Numeri di Fibonacci (tree recursion)

  (define fibonacci
    (lambda (n)      ; n naturale
      (if (< n 2)
          1
          (+ (fibonacci (- n 2)) (fibonacci (- n 1)))
          )
      ))
*/

// Traduzione in Java:

        public static long fibonacci( int n ) {  // n >= 0

            if ( n < 2 ) {
                return  1;
            } else {
                return  fibonacci( n-2 ) + fibonacci( n-1 );
            }
        }


// Nuova versione che applica la tecnica di memoization:

        public static long fibonacciMem( int n ) {  // n >= 0

            long[] value = new long[ n+1 ];

            for ( int i=0; i<=n; i=i+1 ) {
                value[i] = UNKNOWN;
            }
            return fibonacciRec( n, value );
        }

        public static long fibonacciRec( int n, long[] value ) {

            if ( value[n] == UNKNOWN ) {

                if ( n < 2 ) {
                    value[n] = 1;
                } else {
                    value[n] = fibonacciRec( n-2, value ) + fibonacciRec( n-1, value );
                }}
            return value[n];
        }

        private static final long UNKNOWN = 0;


// Superamento dei limiti delle rappresentazioni numeriche a parola fissa:
// int:         risultato rappresentabile per n <= 45
// long:        risultato rappresentabile per n <= 91
// BigInteger:  rappresentazione intera equiparabile a quella di Scheme

        public static BigInteger fibonacciBig( int n ) {  // n >= 0

            BigInteger[] value = new BigInteger[ n+1 ];

            for ( int i=0; i<=n; i=i+1 ) {
                value[i] = BIG_UNKNOWN;
            }
            return fibonacciBigRec( n, value );
        }

        public static BigInteger fibonacciBigRec( int n, BigInteger[] value ) {

            if ( value[n] == BIG_UNKNOWN ) {

                if ( n < 2 ) {
                    value[n] = new BigInteger( "1" );
                } else {
                    value[n] = fibonacciBigRec( n-2, value ).add( fibonacciBigRec(n-1,value) );
                }}
            return value[n];
        }

        private static final BigInteger BIG_UNKNOWN = null;


// Diversa versione che applica una tecnica di programmazione dinamica:

        public static long fibonacciDp( int n ) {  // n >= 0

            long[] value = new long[ n+1 ];

            value[0] = 1;
            if ( n > 0 ) {
                value[1] = 1;
            }
            for ( int k=2; k<=n; k=k+1 ) {

                value[k] = value[k-2] + value[k-1];
            }
            return value[n];
        }


/* Problema dei "Percorsi di Manhattan"

  (define manhattan
    (lambda (i j)    ; i, j naturali
      (if (or (= i 0) (= j 0))
          1
          (+ (manhattan (- i 1) j) (manhattan i (- j 1)))
          )
      ))
*/

// Traduzione in Java:

        public static long manhattan( int i, int j ) {  // i, j >= 0

            if ( (i == 0) || (j == 0) ) {
                return  1;
            } else {
                return  manhattan( i-1, j ) + manhattan( i, j-1 );
            }
        }


// Nuova versione che applica la tecnica di memoization:

        public static long manhattanMem( int i, int j ) {  // i, j >= 0

            long[][] value = new long[ i+1 ][ j+1 ];

            for ( int u=0; u<=i; u=u+1 ) {
                for ( int v=0; v<=j; v=v+1 ) {
                    value[u][v] = UNKNOWN;
                }}
            return manhattanRec( i,j, value );
        }

        public static long manhattanRec( int i, int j, long[][] value ) {

            if ( value[i][j] == UNKNOWN ) {

                if ( (i == 0) || (j == 0) ) {
                    value[i][j] = 1;
                } else {
                    value[i][j] = manhattanRec( i-1, j, value ) + manhattanRec( i, j-1, value );
                }}
            return value[i][j];
        }


// Altra versione che applica una tecnica di programmazione dinamica:

        public static long manhattanDp( int i, int j ) {  // i, j >= 0

            long[] value = new long[j+1];         // Economia di spazio di memoria

            for ( int v=0; v<=j; v=v+1 ) {        // manhattan(0,v), v in [0,j]
                value[v] = 1;
            }
            for ( int u=1; u<=i; u=u+1 ) {
                for ( int v=1; v<=j; v=v+1 ) {      // manhattan(u,v), v in [0,j]
                    value[v] = value[v-1] + value[v];
                }
            }
            return value[j];                      // manhattan(i,j)
        }

    }  // class Memoization
