import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nombre = (int)(Math.random() * 100) + 1;
        int nb_essais = 0;
        int nombre_saisi = 0; // déclaration avant la boucle

        while (nombre_saisi != nombre) {

            System.out.print("Faites votre choix : ");
            nombre_saisi = sc.nextInt();
            nb_essais++;

            if (nombre_saisi < nombre) {
                System.out.println("Le nombre est plus grand que " + nombre_saisi);
            } 
            else if (nombre_saisi > nombre) {
                System.out.println("Le nombre est plus petit que " + nombre_saisi);
            } 
            else {
                System.out.println("Félicitations, vous avez trouvé le bon numéro : " + nombre);
                System.out.println("Nombre de tentatives : " + nb_essais);
            }
        }

        sc.close();
    }
}