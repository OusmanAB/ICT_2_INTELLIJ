import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestionEtudiant {

    Scanner clavier = new Scanner(System.in);

    int nombreEtudiant(){
        Scanner clavier = new Scanner(System.in);
        int nombre;
        do{
            System.out.print("Donnez l'effectif de la classe : ");
            nombre = clavier.nextInt();
            if(nombre <= 0) System.err.println("ATTENTION! L'entier valeur doit ếtre un entier postif!");
        }while (nombre <= 0);
        return nombre;
    }

    String afficheMenuProgramme(){
        return "\n 1. Afficher les étudiants par ordre de mérite \n" +
                " 2. Afficher les informations sur le premier étudiant\n" +
                " 3. Afficher les informations du dernier étudiant\n" +
                " 4. Réinitialiser la liste de la classe\n" +
                " 5. Sortir du programme\n";
    }

    int faireChoixMenu(){
        int n;
        Scanner clavier = new Scanner(System.in);
        do{
            System.out.print("Faites votre choix : ");
            n = clavier.nextInt();

            if(n <= 0 || n > 5) System.err.println("La valeur doit ếtre comprise entre 1 et 5!");
        }while (n <= 0 || n > 5);

        return n;
    }

    void listEtudiantOrdonnee(Etudiant[] etudiants){
        if(etudiants == null) System.out.println(" La liste est vide.");
        System.out.println("La Liste des Etudants Ordonnée:\n");
        int longueur = etudiants.length;
        for(int i = 0; i < longueur; i++){
            for (int j = 1; j < longueur; j++) {
                if (etudiants[i].moyenne > etudiants[j].moyenne) {
                    Etudiant etudiant = etudiants[i];
                    etudiants[i] = etudiants[j];
                    etudiants[j] = etudiant;
                }
            }
        }

        for (Etudiant etudiant : etudiants) {
            System.out.println(" - Les Informations des Etudiants : ");
            etudiant.afficher();
        }
    }

    void inforamtionPremierEtudiant(Etudiant[] etudiants){
        if(etudiants == null) System.out.println(" La liste est vide.");
        System.out.println("Informations sur le Dernier Etudiant:");
        int longuer = etudiants.length;
        Etudiant premierEtudiant = etudiants[0];
        for(int i = 1; i < longuer; i++){
            if(etudiants[i].moyenne > premierEtudiant.moyenne) premierEtudiant = etudiants[i];
        }
        System.out.println(" - Les Informations du prémière étudiant : "+ premierEtudiant.nom);
        premierEtudiant.afficher();
    }

    void inforamtionDernierEtudiant(Etudiant[] etudiants){
        if(etudiants == null) System.out.println(" La liste est vide.");
        System.out.println("Informations sur le Dernier Etudiant:");
        int longuer = etudiants.length;
        Etudiant dernierEtudiant = etudiants[0];
        for(int i = 1; i < longuer; i++){
            if(etudiants[i].moyenne < dernierEtudiant.moyenne) dernierEtudiant = etudiants[i];
        }

        System.out.println(" - Les Informations du dernier étudiant : "+ dernierEtudiant.nom);
        dernierEtudiant.afficher();
    }

    public Etudiant createEtudiant(){
        String nomEtudiant = nomEtudiant();
        String matriculeEtudiant = matriculeEtudiant();
        char genreEtudiant = genreEtudiant();
        Date date = dateNaissance();
        double moyenneEtudiant = moyenneEtudiant();

        return new Etudiant(matriculeEtudiant,nomEtudiant,genreEtudiant,date,moyenneEtudiant);
    }

    String nomEtudiant(){
        String nom = "";
        while (nom.length() < 3){
            System.out.print("Quelle est le nom de l'étudiant : ");
            nom = clavier.nextLine();
        }
        return nom;
    }

    String matriculeEtudiant(){
        String matricule = "";
        while (matricule.length() != 7){
            System.out.print("Quelle est le matricule de l'étudiant : ");
            matricule = clavier.nextLine();
        }
        return matricule;
    }

    char genreEtudiant(){
        char genre = 'A';
        boolean goodGenre = false;
        while (!goodGenre){
            System.out.print("Quelle est le genre de l'étudiant : ");
            genre = clavier.nextLine().charAt(0);
            if(genre == 'M' || genre == 'm') goodGenre = true;
            else if(genre == 'F' || genre == 'f') goodGenre = true;
            else if(genre != 'M' || genre != 'm') System.err.println("Genre invalide!");
            else if(genre != 'F' || genre != 'f') System.err.println("Genre invalide!");
        }
        return genre;
    }

    Date dateNaissance(){
        Date date = null;
        boolean goodDate = false;
        while (!goodDate){
            System.out.println("Quelle est la date de naissance de l'étudiant: format dd/MM/yyyy");
            String dateInString = clavier.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try{
                date = formatter.parse(dateInString);
                goodDate = true;
            }catch (ParseException e){
                e.getMessage();
            }
        }
        return date;
    }

    double moyenneEtudiant(){
        double moyenne;
        System.out.print("Quelle est la moyenne de l'étudant: ");
        do{
            moyenne = clavier.nextDouble();
            clavier.nextLine();
            if(moyenne > 20 || moyenne < 0) {
                System.err.println("La moyenne doit ếtre comprise entre 0 et 20");
                System.out.print("Recomencer : ");
            }
        }while (moyenne > 20 || moyenne < 0);
        return moyenne;
    }

    double bonification(){
        boolean reponse = demandeBonification();
        if(reponse == false) return 0;

        double bonus;

        System.out.print("Combiens de Bonus? : ");
        do{
            bonus = clavier.nextDouble();
            clavier.nextLine();
            if(bonus > 20 || bonus < 0) {
                System.err.println("Le Bonus doit être comprise entre 0 et 20");
                System.out.print("Recomencer : ");
            }
        }while (bonus > 20 || bonus < 0);
        return bonus;
    }

    boolean demandeBonification(){
        System.out.print("Vouslez-vous bonifier l'étudiant? O/N : ");
        char reponse = clavier.nextLine().charAt(0);
        if(reponse == 'o' || reponse == 'O') return true;
        else if(reponse == 'n' || reponse == 'N') return false;
        else System.out.println("NB: Tous autre reponse est consideré comme(Non) !!"); return false;
    }

    boolean demaderCalculeAge(){
        System.out.print("Reponder par: O/N : ");
        char reponse = clavier.nextLine().charAt(0);
        if(reponse == 'o' || reponse == 'O') return true;
        else if(reponse == 'n' || reponse == 'N') return false;
        else System.out.println("NB: Tous autre reponse est consideré comme(Non) !!"); return false;
    }

    public int choisireEtudiant(Etudiant[] etudiants) {
        System.out.print("Donnez le matricule de l'étudiant : ");
        int longueur = etudiants.length, position = -1;
        String matricule = null;
        do{
            matricule = clavier.nextLine();
            for(int i = 0; i < longueur; i++)
                if (etudiants[i].matricule.equals(matricule)) position = i;

            if(position == -1){
                System.err.println("Matricule incorrect");
                System.out.println("Recommencer : ");
            }
        }while (position == -1);
        return position;
    }
}
R