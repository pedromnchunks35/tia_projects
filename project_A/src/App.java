import org.jpl7.Query;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Query q=new Query("consult('t.pl')");
        q.hasSolution();
    }
}
