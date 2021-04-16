
import java.util.*;


public class MyFirstOOProgram {


  public static void main( String[] args ) {
  
    Vector<String> words = new Vector<String>();
    
    Scanner input = new Scanner( System.in );
    System.out.println( "enter words:" );
    String line = input.nextLine();
    
    while ( !line.equals("") ) {
    
      StringTokenizer tokens = new StringTokenizer( line );
      
      while ( tokens.hasMoreTokens() ) {
      
        String word = tokens.nextToken();
        
        if ( words.indexOf(word) < 0 ) {
        
          words.add( word );
      }}
      line = input.nextLine();
    }
    Collections.sort( words );
    
    for ( String word : words ) {
    
      System.out.println( word ); 
    }
  }
  
}  // class MyFirstOOProgram


