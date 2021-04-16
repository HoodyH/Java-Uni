public class Bottom_Up {

    public static void main(String[] args)
    {
        System.out.print("Il risultato e': " + start(5));
    }

    public static int start(int n)
    {
        int value[] = new int[n+1];

        return fibDP(n, value);


    }

    public static int fibDP(int n, int value[]) {


        value[0] = 1;
        if (n > 0)
            value[1] = 1;

        for (int k = 2; k <= n; k++) {
            value[k] = value[k - 2] + value[k - 1];

        }

        System.out.println();
        return value[n];
    }


}
