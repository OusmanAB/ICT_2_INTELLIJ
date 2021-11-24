public class Main {

    public static void main(String[] args){

        System.out.println("-[Gestion de Etudiants]-");

        Etudiant[] etudiants; // Déclaration d'un tableau pour les Etudiants
        GestionEtudiant gestionnaire = new GestionEtudiant();
        int choixMenu;

        int nombreEtudiant = gestionnaire.nombreEtudiant();
        etudiants = new Etudiant[nombreEtudiant];

        System.out.println("Enregistrement des étudiants: ");
        for(int i = 0; i < nombreEtudiant; i++){
            System.out.println("\nEtudiant numéro "+ (i+1) +" : ");
            etudiants[i] = gestionnaire.createEtudiant();
        }
        System.out.println("Fin d'enregistrements..");

        do{
            System.out.println("Menu d'utilisation du programme");
            System.out.println(gestionnaire.afficheMenuProgramme());

            choixMenu = gestionnaire.faireChoixMenu();

            switch (choixMenu){
                case 1 : gestionnaire.listEtudiantOrdonnee(etudiants); break;
                case 2 : gestionnaire.inforamtionPremierEtudiant(etudiants); break;
                case 3 : gestionnaire.inforamtionDernierEtudiant(etudiants); break;
                case 4 : etudiants = null; break;
                case 5 : System.out.println("---------- FIN DU PROGRAMME ----------"); break;
            }

        }while (choixMenu != 5);
    }
}
