import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestionEtudiant {

    Scanner clavier = new Scanner(System.in);
    //Etudiant[] etudiants;

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
        return " 1. Afficher les étudiants par ordre de mérite \n " +
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

        return new Etudiant(matriculeEtudiant,nomEtudiant,genreEtudiant,date);
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
            if(genre == 'F' || genre == 'f') goodGenre = true;
            if(genre != 'M' ^ genre != 'm') System.err.println("Genre invalide!");
            if(genre != 'M' ^ genre != 'f') System.err.println("Genre invalide!");
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
}
