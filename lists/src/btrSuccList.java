import java.util.Scanner;

public class btrSuccList {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        System.out.println("Inserisci la stringa btr:");
        String btr = input.next();
        System.out.println("Inserisci n:");
        int n = input.nextInt();

        //System.out.println();
        System.out.println(nextList(btr, n).toString()); //nota: si stampa anche senza il toString()

    }

    public static StringSList nextList(String btr, int n) {

        StringSList lst = new StringSList();

        for(int i=0; i<n; i++) {
            lst = lst.append(new StringSList(btr, StringSList.NULL_STRINGLIST));
            btr = btrSucc.succ(btr);
        }

        return lst;

    }

}
