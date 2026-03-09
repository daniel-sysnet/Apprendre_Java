public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private String titulaire;

    public CompteBancaire(String numeroCompte, String titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = 0.0;
    }

    public double getSolde() {
        return solde;
    }

    public boolean setDeposer(double montant) {
        if (montant <= 0) {
            return false;
        }else{
            this.solde += montant;
            return true;
        }
    }

    public boolean setRetirer(double montant) {
        if (montant <= 0 || montant > this.solde) {
            return false;
        }else{
            this.solde -= montant;
            return true;
        }
    }
}
