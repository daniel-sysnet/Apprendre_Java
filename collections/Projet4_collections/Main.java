import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Saisissez une taille de tableau : ");
        int taille = sc.nextInt();

        double[] notes = new double[taille];

        for (int i = 0; i < notes.length; i++) {
            System.out.print("Saisissez la note " + (i + 1) + " : ");
            notes[i] = sc.nextDouble();
        }

        System.out.println("Notes saisies :");
        for (double note : notes) {
            System.out.println("  " + note);
        }

        double moyenne = 0.0;
        for (double note : notes) {
            moyenne += note;
        }
        moyenne /= notes.length;
        System.out.println("Moyenne : " + moyenne);

        double min = notes[0];
        double max = notes[0];

        for (double note : notes) {
            if(note < min){
                min = note;
            }
            else if(note > max){
                max = note;
            }
        }
        System.out.println("Note minimale : " + min);
        System.out.println("Note maximale : " + max);
        sc.close();
    }
}