public class IntStringStack {

    private boolean empty;
    private int num;
    private String txt;
    private IntStringStack rest;

    public IntStringStack() {

        empty = true;
        num = 0;
        txt = null;
        rest = null;
    }

    private IntStringStack(boolean e, int n, String t, IntStringStack r) {

        empty = e;
        num = n;
        txt = t;
        rest = r;
    }

    public boolean isEmpty() {

        return empty;
    }

    public void push(int n, String t) {

        IntStringStack clone = new IntStringStack(empty, num, txt, rest);

        empty = false;
        num = n;
        txt = t;
        rest = clone;
    }

    public void pop() {

        empty = rest.isEmpty();
        num = rest.topInt();
        txt = rest.topString();
        rest = rest.rest;
    }

    public int topInt() {

        return num;
    }

    public String topString() {

        return txt;
    }

}// class NodeIntStack

