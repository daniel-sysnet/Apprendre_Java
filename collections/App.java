import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        double[] notes = {10.0, 9.5, 8.0, 7.5};

        // ✅ ArrayList avec un seul type
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Daniel"); // ✅ un seul argument
        noms.add("Alice");
        noms.add("Bob");
        noms.remove("Alice");
        for (String nom : noms) {
            System.out.println(nom);
        }

        /*ArrayList<Integer> nombres = new ArrayList<>();
        nombres.add(10);
        nombres.add(20);
        nombres.add(30);
        for(Integer nombre : nombres){
            System.out.println(nombre);
        }

        Map<Integer, String> client_list = new HashMap<>();
        client_list.put(1, "Daniel");
        client_list.put(2, "Alice");
        client_list.put(3, "Bob");

        for (Integer key : client_list.keySet()) {
            String name = client_list.get(key);
            System.out.println("ID: " + key + ", Name: " + name);
        }*/
    }
}