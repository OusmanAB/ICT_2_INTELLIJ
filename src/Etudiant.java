import java.util.Date;

public class Etudiant
{
    // Déclaration de variables
    String matricule;
    String nom;
    char genre;
    Date dateNaissance;
    double moyenne;
    double nombreAnnee;


    // Les constructeur
    public Etudiant(String matricule, String nom, char genre, Date dateNaissance, double moyenne) {
        this.matricule = matricule;
        this.nom = nom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.moyenne = moyenne;
        this.nombreAnnee = 0;
    }

    // La procedure qui affiche les informations de l'étudiant
    void afficher(){
        System.out.println(" Matricule : " + matricule + "\n" +
                " NOM : " + nom + "\n" +
                " GENRE : " + genre + "\n" +
                " DATE DE NAISSANCE : " + dateNaissance + "\n" +
                " MOYENNE : " + moyenne + "\n");
    }

    // La fonction qui fait le Calcule de âge
    public int calculerAge(Date etudiantDateNaissance){
        return (new Date().getYear() - etudiantDateNaissance.getYear());
    }

    // Donne du bonus a un étudiant
    double bonifier(double bonus){
        if(bonus < 0)
            System.err.println("Erreur! il n'y a pas des bonus négatives!!!");
        else if((this.moyenne + bonus) > 20){
            System.err.println("ATTENTION! la moyenne bonifier ne doit pas excéder 20");
            System.out.println("La moyenne soit initialiser à 20");
            return 20;
        }else
            return bonus;
        return 0;
    }
}
