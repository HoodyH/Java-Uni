
/*
 * Semplici procedure iterative realizzate in Java
 *
 * Ultimo aggiornamento: 20/03/18
 */


public class MyFirstIterativeProgram {


/* Massimo comun divisore

  (define gcd            ; valore: intero
    (lambda (x y)        ; x, y > 0 interi
      (cond ((= x y) x)
            ((< x y) (gcd x (- y x)))
            (else    (gcd (- x y) y))
            )))

*/
  
  public static int gcd( int x, int y ) {  // x, y > 0
  
    while ( x != y ) {       //  (= x y) : condizione di uscita
    
      if ( x < y ) {
        y = y - x;           //  (< x y) : (gcd x (- y x))
      } else {
        x = x - y;           //  else    : (gcd (- x y) y)
    }}
    return x;                //  x
  }
  
  
// Minimo comune multiplo
  
  public static int lcm( int x, int y ) {  // x, y > 0
  
    int s = x;
    
    while ( s % y != 0 ) {   //  s non e' multiplo di y
    
      s = s + x;
    }
    return s;
  }
  
  
// Test di primalita'
  
  public static boolean isPrime( int n ) {  // n >= 2
  
    if ( n % 2 == 0 ) {
    
      return ( n == 2 );
    }
    for ( int p = 3;  p*p <= n;  p = p+2 ) {
    
      if ( n % p == 0 ) {
        return false;
    }}
    return true;
  }
  
  
/* Procedura "UFO" iterativa
 
  (define ufo           ; valore: ?
    (lambda (x)         ; x > 0 naturale
      (cond ((= x 1)
             1)
            ((even? x)  ; x pari
             (- (* 2 (ufo (quotient x 2))) 1))
            (else       ; x dispari
             (+ (* 2 (ufo (quotient x 2))) 1))
            )))

*/

  public static int ufo( int n ) {  // n > 0
  
    int[] stack = new int[ 32 ];    // numero invocazioni ricorsive < 32
    int t = 0;                      // = numero di bit dei dati di tipo int
    
    while ( n > 1 ) {               // processo discendente
    
      stack[t] = n;                 // registrazione valori argomento
      n = n / 2;                    // invocazioni ricorsive
      
      t = t + 1;
    }
    int v = 1;                      // n = 1 : caso base

    for ( t=t-1; t>=0; t=t-1 ) {    // processo ascendente (a ritroso)
    
      if ( stack[t] % 2 == 0 ) {    // calcolo valori restituiti
        v = 2 * v - 1;              // dalle invocazioni ricorsive
      } else {
        v = 2 * v + 1;
    }}
    return v;
  }


}  // class MyFirstIterativeProgram

