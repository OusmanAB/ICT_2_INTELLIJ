import java.util.Date;

public class Etudiant
{
    // Déclaration de variables
    String matricule;
    String nom;
    char genre;
    Date dateNaissance;
    double moyenne;

    // Les constructeur
    public Etudiant(String matricule, String nom, char genre, Date dateNaissance) {
        this.matricule = matricule;
        this.nom = nom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.moyenne = 0;
    }

    // La procedure qui affiche les informations de l'étudiant
    void afficher(){
        System.out.println(" Matricule : " + matricule + "\n" +
                " NOM : " + nom + "\n" +
                " GENRE : " + genre +
                " DATE DE NAISSANCE : " + dateNaissance +
                " MOYENNE : " + moyenne);
    }

    // La fonction qui fait le Calcule de âge
    public int calculerAge(){
        return (new Date().getYear() - this.dateNaissance.getYear());
    }

    // Donne du bonus a un étudiant
    public double bonifier(double bonus){
        moyenne += bonus;
        return moyenne;
    }
}
