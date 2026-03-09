import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Personne p1 = new Personne("AGOMa", "Daniel", 21);
        p1.sePresenter();
        System.out.println(p1.estMajeur());

        CompteBancaire cb1 = new CompteBancaire("123456789", "AGOMa Daniel");

        System.out.println("Le solde du compte est : " + cb1.getSolde());

        System.out.println("Saisissez le montant à déposer : ");
        Scanner sc = new Scanner(System.in);
        double montantDeposer = sc.nextDouble();
        cb1.setDeposer(montantDeposer);

        System.out.println("Le solde du compte est : " + cb1.getSolde());

        System.out.println("Saisissez le montant à retirer : ");
        double montantaRetirer = sc.nextDouble();
        cb1.setRetirer(montantaRetirer);

        System.out.println("Le solde du compte est : " + cb1.getSolde());
    }
}
