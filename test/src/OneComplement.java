import java.util.Scanner;

public class OnrComplement {


    public static void main(String[] args)
    {
        String numero;
        String stringa;

        Scanner keyboard = new Scanner(System.in);
        numero = keyboard.next();

        stringa = funz(numero);
        System.out.println("La stringa finale è: " + stringa);
    }

    public static String funz(String n)
    {
        char carattere;
        String risultato = "";


        for(int i = 0; i < n.length(); i++)
        {
            carattere = n.charAt(i);

            if(carattere == '1')
            {
                carattere = '0';

            }

            else carattere = '1';

            risultato = carattere + risultato;

        }

        return risultato;

    }

}
