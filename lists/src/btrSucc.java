public class btrSucc {

    public static String succ(String btr) {

        int n = btr.length();
        char lsb = btr.charAt(n-1);

        if (n == 1) {

            if (lsb == '+') {
                return "+-";
            } else {
                return "+";
            }

        } else {

            btr = btr.substring(0, n-1);

            switch (lsb) {
                case '+':
                    return succ(btr) + "-";

                case '.':
                    return btr + "+";

                case '-':
                    return btr + ".";

                default:
                    return "";

            }
        }
    }

}

