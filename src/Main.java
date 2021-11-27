import java.util.Date;

public class Main {

    public static void main(String[] args){

        System.out.println("-[Gestion de Etudiants]-");

        Etudiant[] etudiants; // Déclaration d'un tableau pour les Etudiants
        GestionEtudiant gestionnaire = new GestionEtudiant();
        int choixMenu; Etudiant etudiant = null;

        int nombreEtudiant = gestionnaire.nombreEtudiant();
        etudiants = new Etudiant[nombreEtudiant];

        System.out.println("Enregistrement des étudiants: ");
        for(int i = 0; i < nombreEtudiant; i++){
            System.out.println("\nEtudiant numéro "+ (i+1) +" : ");
            etudiants[i] = gestionnaire.createEtudiant();
            etudiants[i].moyenne += etudiants[i].bonifier(gestionnaire.bonification());
        }
        System.out.println("Fin d'enregistrements..\n");

        System.out.println("Voulez-vous Calculer l'âge d'un Étudiant? ");
        if (gestionnaire.demaderCalculeAge()) {
            int etudiantChoisi = gestionnaire.choisireEtudiant(etudiants);
            Date dateEtudiant = etudiants[etudiantChoisi].dateNaissance;
            int ageEtudiant = etudiants[etudiantChoisi].calculerAge(dateEtudiant);
            if (ageEtudiant != -1) {
                System.out.println("Âge de "+ etudiants[etudiantChoisi].nom +" est: "+ ageEtudiant +" ans");
            }
        }

        do{
            System.out.println("Menu d'utilisation du programme");
            System.out.println(gestionnaire.afficheMenuProgramme());

            choixMenu = gestionnaire.faireChoixMenu();

            switch (choixMenu){
                case 1 : gestionnaire.listEtudiantOrdonnee(etudiants); break;
                case 2 : gestionnaire.inforamtionPremierEtudiant(etudiants); break;
                case 3 : gestionnaire.inforamtionDernierEtudiant(etudiants); break;
                case 4 : etudiants = null; System.out.println("La liste est bien réinitialiser..!"); break;
                case 5 : System.out.println("---------- FIN DU PROGRAMME ----------"); break;
            }

        }while (choixMenu != 5);
    }
}
