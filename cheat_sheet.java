//library------------------------------------------

import java.util.Scanner; //importo una singola funzione di libreria
import java.util.*; //all library

public class name{

  //costructor
  public CS() { // la classe CS è una super class
    // contiene varie operazioni da eseguire
  }
}//end of file

//estensione della classe, sottoclasse, questo viene utilizzato in un file classe diverso
public class C1 extends CS{
//in questo modo tutto ciò che c'è in CS è disponibile in c1
}

//tipi e variabili-------------------------------------

public //modalità d'accesso libero
private //accesso solo dai metodi della classe
protected //acesso consentito solo dalle classi del pachetto (src)
static
final //can't be Overridden and Subclassed

boolean
int
long
float
double
char
String

//example of declaration of variable
public static final double name = 100.2231;
private String name;


//operatori in un if-------------------------------------------
^  //ritorna vero se c'è una condizione vera ed una falsa.
&& // vero se: entrambe sono veri (se la prima è falsa la seconda non viene controllata)
&  // come sopra solo che entrabe le variabili vengono controllate anche se la prima è falsa
|  // esattamente come per il singolo &
|| // vero se: anche solo uno è vero
//in java || e && operano solamente con tipi (boole) viceversa & e | operano su tutti i tipi eseguendo il confronto bit a bit

~  // esegue il complemento ad 1 dell'elemento (ossia fa diventare 1->0 e 0->1)
!  //inverte il valore di verità di un bool

//conversioni-------------------------------------------------------
int number;
//da int a tipo(in questo caso int)
String stringNum = int.toString(number);
//da tipo a string
int numString = Integer.parseInt(stringNum);
double numString = double.parseInt(stringNum);
int n = Integer.parseInt( args[0] ); //utilizza l'array del main per leggere i caratteri digitati

//generazione di un carattere casuale tramite codice ascii
int randomNum = (int) (math.random()* 126) + 1;
//conversione in un carattere
char character = (char) randomNum;



//user imput----------------------------------------------------
static Scanner userimput = new Scanner(System.in);

if (userimput.hasNexLine()) //serve per verificare se è stato terminato l'inserimento della stringa
{
  //esegui quello che c'è tra parentesi
}

//main---------------------------------------------------------------
//per eseguire è necessario un main ed un costruttore

public static void main(String[] args) {
  CS nameCS = new CS(); //cre oggetto che esegue il costruttore
}

//this utilizzi---------------------------------------------------------
//se nella classe è definito un metodo C1() è possibile chiamare quel metodo da un altro metodo tramite this
public class CS
{
  public (tipo) C1(){
  }
  public (tipo) C2(){
    this.C1();
  }
}//end class, end of file

//modo di utilizzo 2
public class Actor
{
    String lastName;
    String firstName;
    public Actor(String lastName, String firstName)
    {
        this.lastName = lastName; //si riferisce alle variabili grobali
        this.firstName = firstName;
    }
}
// modo di utilizzo 3
System.out.println(this);


public class Conto {

    private double amount;
    private String owner;

    // costruttore
    public Conto(String owner, double initialAmount) {
        this.owner = owner;
        this.amount = initialAmount;
    }

    public void versamento(double qty) {
        amount += qty;
    }

//Classe, oggetti e costruttori-----------------------------------------
/*
Una classe è esattamente il “blueprint” (il prototipo) di un oggetto in cui
vengono definiti tutti i messaggi che ciascuna istanza sarà in grado di
ricevere.
ALl'interno troviamo i metodi (ossia le funzioni)
e gli attributi (che sono le variabili, le costanti ecc.)

In Java intendiamo per “oggetto” l’istanza particolare di una certa classe,
e esso può possedere (o esporre) alcuni metodi.
Quindi un oggetto può ricevere un certo messaggio se possiede un metodo
che l’oggetto sender è in grado di chiamare (con la opportuna visibilità).

Il costruttore è quel metodo di una classe il cui compito è proprio
quello di creare nuove istanze.
il costruttore è spesso usato per effettuare le inizializzazioni dello
stato delle nuove istanze. Possono esserci molteplici costruttori,
se non ne viene specificato il compilatore ne crea uno senza argomenti
*/


public class Conto {

    private double amount;
    private String owner;

    // costruttore, viene distindo per l'assenza del tipo
    public Conto(String owner, double initialAmount) {
        this.owner = owner;
        this.amount = initialAmount;
    }

    public void versamento(double qty) {
        amount += qty;
    }
    public boolean prelievo(double qty) {
        if(amount < qty)
            return false;
        amount -= qty;
        return true;
    }
    public double getAmount() {
        return amount;
    }

    public String getOwner() {
        return owner;
    }
}//end of file
