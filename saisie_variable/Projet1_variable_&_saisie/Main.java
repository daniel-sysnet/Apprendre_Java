import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // exercice : saisie d'une chaîne (nom) et affichage
        System.out.print("Entrez votre nom : ");
        String nom = sc.nextLine();
        System.out.println("Votre nom est : " + nom + "\n");

        // exercice : conversion de kilomètres en miles
        System.out.print("Saisissez une distance (km) : ");
        double distanceKm = sc.nextDouble();
        double distanceMiles = distanceKm * 0.621371;
        System.out.println("La valeur en Miles est : " + distanceMiles + "\n");

        // exercice : conversion Celsius → Fahrenheit
        System.out.print("Saisissez une temperature (Celsius) : ");
        double degreC = sc.nextDouble();
        double degreF = (degreC * 1.8) + 32;
        System.out.println("La valeur en Fahrenheit est : " + degreF + "\n");

        // exercice : conversion de kilogrammes en livres
        System.out.print("Saisissez un poids (kg) : ");
        double poids = sc.nextDouble();
        double livres = poids * 2.20462;
        System.out.println("La valeur en livres est de : " + livres + "\n");

        // toujours fermer le scanner pour libérer la ressource
        sc.close();
    }
}