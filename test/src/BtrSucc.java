import java.util.Scanner;
public class Btr_Succ {

    public static void main(String[] args)
    {
        String sommaStringa;
        String numero;
        Scanner keyboard = new Scanner(System.in);

        numero = keyboard.next();

        sommaStringa = funz(numero);
        System.out.println("La somma finale è " + sommaStringa);
    }

    private static String funz(String numero) {

        int lunghezza = numero.length();
        char ultimoCarattere = numero.charAt(lunghezza - 1);

        if(lunghezza == 1)
        {
            if(ultimoCarattere == '+')
                numero = "+-";

            else numero = "+";

        }

        else {
            if (ultimoCarattere == '+') {
                numero = funz(numero.substring(0, lunghezza - 1)) + "-";

            }
            else {
                if(ultimoCarattere == '-')
                {
                    numero = numero.substring(0, lunghezza - 1) + ".";
                }


            }

        }
        return numero;



    }


} //FINE CLASSE
