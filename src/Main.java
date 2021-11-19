public class Main {
    public static void main(String[] args) {

        Etudiant etudiant = Etudiant.createEtudiant();
        etudiant.afficher();
        etudiant.bonifier(10);
        etudiant.afficher();

    }
}
