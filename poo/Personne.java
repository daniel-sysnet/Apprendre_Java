public class Personne {
    String nom;
    String prenom;
    int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public void sePresenter() {
        System.out.println("Je m'appelle " + this.prenom + " " + this.nom + " et j'ai " + this.age + " ans.");
    }

    public boolean estMajeur() {
        if (this.age < 0) {
            throw new IllegalArgumentException("L'âge ne peut pas être négatif.");
        }else if (this.age < 18) {
            return false;
        }else{
            return this.age >= 18;
        }
    }
}
