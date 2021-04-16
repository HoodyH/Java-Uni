import java.util.*;

public class SubsequenceExplain {

    public static void main (String [] args){

        //System.out.println(llisDP(new int[]{5, 6, 7})); //1
        //System.out.println(llisDP(new int[]{5, 6, 7, 8})); //1
        //System.out.println(llisDP(new int[]{5, 4, 3, 2 ,5, 33, 6, 31, 7, 8 })); //1
        //System.out.println(llisDP(new int[]{47, 38, 39, 25, 44})); //3
        System.out.println(llisDP(new int[]{27, 90, 7, 29, 49, 8, 53, 1, 28, 6})); //4
        //System.out.println(llisDP(new int[]{9, 46, 54, 71, 60, 47, 0, 32, 25, 61})); //5
        //System.out.println(llisDP(new int[]{54, 52, 42, 33, 14, 40, 37, 61, 53, 1})); //3

    }


    public static long llisDP (int s[]){
        int n = s.length;

        int[] a = new int[n + 1];

        System.arraycopy(s, 0, a, 0, n);

        a[n] = 0;

        int[][] h = new int[n+1][n+1];

        for(int j = n; j>= 0; j--) {
            h[n][j] = 0;
        }

        System.out.println("\r\n");

        for( int i = n-1; i >= 0; i--){
            for( int j = n; j >= 0; j--){

                if (a[i] <= a[j]){
                    h[i][j] = h[i+1][j];

                    System.out.println("(if ok)\r\nsiccome: \r\na["+i+"] <= a["+j+"] --->  "+ a[i]+" <= "+a[j]+" allora:");
                    System.out.println("h["+i+"]["+j+"] = h["+(i+1)+"]["+j+"] ");
                    System.out.println("h["+i+"]["+j+"] = "+h[(i+1)][j] );

                    } else {
                    h[i][j] = Math.max(1 + h[i+1][i], h[i+1][j]);

                    System.out.println("(else ok)\r\ndato che non è vera la condizione:\r\na["+i+"] <= a["+j+"] --->  "+ a[i]+" <= "+a[j]);
                    System.out.println("h["+i+"]["+j+"] = Math.max(1 + h["+(i+1)+"]["+i+"] , h["+(i+1)+"]["+j+"]");
                    System.out.println("h["+i+"]["+j+"] = Math.max(1 + "+h[(i+1)][i]+" , "+ h[(i+1)][j]+" )");
                }

                System.out.print("      ");
                for (int c = 0; c <= n; c++) {
                    System.out.print(c+")"); }
                System.out.println();
                System.out.print("      ");
                for (int m = 0; m <= n; m++) {
                    System.out.print(a[m]+","); }
                System.out.println();

                for( int x = 0; x <= n; x++) {
                    System.out.print(x+ "),"+a[x]+") ");
                    for (int y = 0; y <= n; y++) {
                        System.out.print(h[x][y]+" "); }
                    System.out.println(" ");
                }
                System.out.println("\n\r");
            }
        }

        System.out.print(sottosequenza(h, s, n));



        return h[0][n];
    }

    public static String sottosequenza( int [][]h, int []vet, int n){

        int a[] = new int [n+1];
        int val=0;
        int p1=0;
        int p2=n;
        int out=1;

        for(int i = 0; i<=n; i++){
            a[i]=h[i][n];
            System.out.print(a[i]+" ");
        }
        System.out.println();

        while(p2!=0) {

            val++;
            p1 = p2 - 1;
            System.out.println("P2: "+ p2+ " P1: "+p1+" val: "+val+"\r\n");
            for (int i = p1; i >= 0; i--) {
                if(i==0){
                    p2 = 0;
                    System.out.println("if P2: "+ p2+ " P1: "+p1+" val: "+val+"\r\n");
                    break;
                }else if (a[i] != val) {
                    p2 = i+1;
                    System.out.println("else P2: "+ p2+ " P1: "+p1+" val: "+val+"\r\n");
                    break;
                }
            }

            out=vet[p1];
            for (int i = p1; i>= p2; i--){
                if(vet[i]<out)
                    out=vet[i];
            }
            System.out.print(out+" ");

        }
        //Integer.toString(out

        return "fine";
    }
}
