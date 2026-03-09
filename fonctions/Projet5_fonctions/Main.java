import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("Menu : ");
            System.out.println("1. Afficher la somme d une suite de nombre");
            System.out.println("2. Calculer le factoriel d'un nombre");
            System.out.println("3. Determiner si un nombre est premier");
            System.out.println("4. Afficher la table de multiplication");
            System.out.println("5. Mettre a la puissance");
            System.out.println("6. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nombre de nombre a additionnes : ");
                    int a = sc.nextInt();
                    double[] nombres = new double[a];
                    for (int i = 0; i < a; i++) {
                        System.out.print("Entrez le nombre " + (i + 1) + " : ");
                        nombres[i] = sc.nextDouble();
                    }
                    System.out.println("La somme est : " + somme(nombres));
                    break;
                case 2:
                    System.out.print("Entrez le nombre : ");
                    int b = sc.nextInt();
                    System.out.println("Le factoriel est : " + factorielle(b));
                    break;
                case 3:
                    System.out.print("Entrez le nombre : ");
                    int c = sc.nextInt();
                    System.out.println(c + " n'est pas premier : ");
                    break;
                case 4:
                    System.out.print("Entrez le nombre : ");
                    int d = sc.nextInt();
                    tableMultiplication(d);
                    break;
                case 5:
                    System.out.print("Entrez la base : ");
                    double base = sc.nextDouble();
                    System.out.print("Entrez l'exposant : ");
                    int exposant = sc.nextInt();
                    System.out.println("Résultat : " + puissance(base, exposant));
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 6);
        sc.close();
    }
    static double somme(double[] nombres) {
        double total = 0;
        for (double nombre : nombres) {
            total += nombre;
        }
        return total;
    }

    static int factorielle(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre doit être positif.");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            int resultat = 1;
            for (int i = 2; i <= n; i++) {
                resultat *= i;
            }
            return resultat;
        }
    }

    static boolean estPremier(int n) {
        if (n <= 1) {
            return false;
        } else if (n <= 2) {
            return true;
        } else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static void tableMultiplication(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    static double puissance(double base, int exposant) {
        if (exposant < 0) {
            return 1 / puissance(base, -exposant);
        } else if (exposant == 0) {
            return 1;
        } else {
            double resultat = 1;
            for (int i = 1; i <= exposant; i++) {
                resultat *= base;
            }
            return resultat;
        }
    }
}