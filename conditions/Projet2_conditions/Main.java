import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        System.out.println("Saisissez un nom : ");
        String nom = sc.nextLine();

        System.out.println("Saisissez la note 1 : ");
        double note1=sc.nextDouble();
        System.out.println("Saisissez la note 2 : ");
        double note2=sc.nextDouble();
        System.out.println("Saisissez la note 3 : ");
        double note3=sc.nextDouble();
        System.out.println("Saisissez la note 4 : ");
        double note4=sc.nextDouble();

        double moyenne = (note1+note2+note3+note4) /4.0;

        System.out.println("La moyenne de " + nom + " est : " + moyenne);

        if(moyenne > 18){
            System.out.println("Tres bien + Felicitations du jury !");
        }else if(moyenne > 16){
            System.out.println("Tres bien");
        }else if(moyenne > 14){
            System.out.println("Bien");
        }else if(moyenne > 12){
            System.out.println("Assez bien");
        }else if(moyenne > 10){
            System.out.println("Passable");
        }else{
            System.out.println("Echoue");
        }
        sc.close();
    }

}
