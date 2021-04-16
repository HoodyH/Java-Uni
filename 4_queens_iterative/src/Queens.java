import java.util.*;

public class Queens {

    public static int numberOfSolutions (int n){

        Stack<BoardV2> stack = new Stack<BoardV2>();
        stack.push( new BoardV2(n) );
        int count = 0;

        while (!stack.empty() ){
            BoardV2 b = stack.pop();
            int q = b.queensOn();
            if (q==n)
                count = count + 1;
            else{

                int i=q+1;
                for(int j= n ; j>=1; j--){

                    if(!b.underAttack(i,j) )
                        stack.push(b.addQueen(i,j) );

                }
            }
        }
        return count;
    }

    /*
    public static SList<Board> listOfAllSolutions (int n){

        Stack<Board> stack = new Stack<Board>();
        stack.push( new BoardV2( n ) );
        int count = 0;

        while (!stack.empty() ){
            Board b = stack.pop();
            int q = b.queensOn();
            if (q==n)
                count = count + 1;
            else{

                int i=q+1;
                for(int j= n ; j>=1; j--){

                    if(!b.underAttacK(i,j) )
                        stack.push(b.addQueen(i,j) );

                }
            }
            return count;
        }
    }
*/

    public static void main (String[] args){

        System.out.print( numberOfSolutions(5) );
    }
}
