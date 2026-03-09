public class App {

    static void afficher(String message) {
        System.out.println("Bonjour " + message);
    }

    static void factoriel(int n) {
        int resultat = 1;
        for (int i = 1; i <= n; i++) {
            resultat *= i;
        }
        System.out.println("Le factoriel de " + n + " est " + resultat);
    }

    public static void main(String[] args) {
        afficher("tout le monde");

        factoriel(5);
    }
}
