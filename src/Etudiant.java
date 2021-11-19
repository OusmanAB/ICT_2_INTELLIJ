import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Etudiant {
    private String matricule;
    private String nom;
    private char genre;
    private Date dateNaissance;
    private double moyenne;

    public static Etudiant createEtudiant(){
        Scanner scanner = new Scanner(System.in);

        String nomEtudiant = "";
        while (nomEtudiant.length() < 3){
            System.out.println("Quelle est le nom de l'étudiant");
            nomEtudiant = scanner.nextLine();
        }



        String matriculeEtudiant = "";
        while (matriculeEtudiant.length() != 7){
            System.out.println("Quelle est le matricule de l'étudiant");
            matriculeEtudiant = scanner.nextLine();
        }

        char genreEtudiant = 'A';
        boolean goodGenre = false;
        while (!goodGenre){
            System.out.println("Quelle est le genre de l'étudiant");
            genreEtudiant = scanner.nextLine().charAt(0);
            if(genreEtudiant == 'M')
                goodGenre = true;
            if(genreEtudiant == 'F')
                goodGenre = true;
        }


        Date date = null;
        boolean goodDate = false;
        while (!goodDate){
            System.out.println("Quelle est la date de naissance d el'étudiant: format dd/MM/yyyy");
            String dateInString = scanner.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try{
                date= formatter.parse(dateInString);
                goodDate = true;
            }catch (Exception e){

            }
        }


        return new Etudiant(matriculeEtudiant,nomEtudiant,genreEtudiant,date);

    }

    public Etudiant(String matricule, String nom, char genre, Date dateNaissance) {
        this.matricule = matricule;
        this.nom = nom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.moyenne = 0;
    }

    void afficher(){
        System.out.println("Etudiant{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", genre=" + genre +
                ", dateNaissance=" + dateNaissance +
                ", moyenne=" + moyenne +
                '}');
    }

    public int calculerAge(){
        return new Date().getYear() - dateNaissance.getYear();
    }

    public double bonifier(double bonus){
        moyenne += bonus;
        return moyenne;
    }
}
