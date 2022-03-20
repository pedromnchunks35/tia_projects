import org.jpl7.Query;

public class App {
    public static void main(String[] args) throws Exception {
        //HELLO
        System.out.println("Hello, World!");
        Query q=new Query("consult('bd.pl')");
        q.hasSolution();
    }
}
