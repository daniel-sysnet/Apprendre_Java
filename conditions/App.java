import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //< <= > >= == != &&
        Scanner sc = new Scanner(System.in);
        
        //System.out.print("Entrez un nombre : ");
        //int nombre = sc.nextInt();
        //System.out.println("Le nombre saisi est : " + nombre);
        //System.out.println("est positif ? " + (nombre > 0));
        //System.out.println("est pair ? " + (nombre % 2 == 0));

        //int age = 65;
        //if (age >= 65) {
        //    System.out.println("Vous etes senior");
        //} else if (age >= 18) {
        //    System.out.println("Vous etes majeur");
        //} else{
        //    System.out.println("Vous etes mineur");
        //}

        //System.out.println(true || true); // true
        //System.out.println(true || false); // true
        //System.out.println(false || true); // true
        //System.out.println(false || false); // false
    
        /*(if(nombre >0 && nombre %2==0){
            System.out.println("Le nombre est positif et pair");
        } else if (nombre > 0 && nombre %2 != 0) {
            System.out.println("Le nombre est positif et impair");
        } else if (nombre < 0 && nombre %2 == 0) {
            System.out.println("Le nombre est negatif et pair");
        } else if (nombre < 0 && nombre %2 != 0) {
            System.out.println("Le nombre est negatif et impair");
        } else {
            System.out.println("Le nombre est nul");
        }*/
        
        System.out.print("Entrez un nombre de jour (1-7) : ");
        int jour =sc.nextInt();
        switch(jour) {
            case 1:
                System.out.println("Lundi");
                break;
            case 2:
                System.out.println("Mardi");
                break;
            case 3:
                System.out.println("Mercredi");
                break;
            case 4:
                System.out.println("Jeudi");
                break;
            case 5:
                System.out.println("Vendredi");
                break;
            case 6:
                System.out.println("Samedi");
                break;
            case 7:
                System.out.println("Dimanche");
                break;
            default:
                System.out.println("Jour invalide");
        }
    }
}
