import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Groupe {

    private Formation formation;
    private List<Etudiant> etudiants;

    public Groupe(Formation formation) {
        this.formation = formation;
        this.etudiants = new ArrayList<Etudiant>();
    }

    public Formation getFormation() {
        return formation;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        if (etudiant.getFormation() != formation) {
            System.out.println("Erreur : l'etudiant n'a pas la meme formation que le groupe.");
        } else if (etudiants.contains(etudiant)) {
            System.out.println("Erreur : l'etudiant est deja dans le groupe.");
        } else {
            etudiants.add(etudiant);
        }
    }

    public void supprimerEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
    }

    public double moyenneGroupePourMatiere(Matiere matiere) {
        double somme = 0;
        int compteur = 0;
        for (Etudiant etudiant : etudiants) {
            double moyenne = etudiant.calculerMoyenne(matiere);
            if (moyenne != -1) {
                somme = somme + moyenne;
                compteur = compteur + 1;
            }
        }
        if (compteur == 0) {
            System.out.println("Erreur : aucun etudiant n'a de note dans cette matiere.");
            return -1;
        } else {
            return somme / compteur;
        }
    }

    public double moyenneGeneraleGroupe() {
        double somme = 0;
        int compteur = 0;
        for (Etudiant etudiant : etudiants) {
            double moyenne = etudiant.calculerMoyenneGenerale();
            if (moyenne != -1) {
                somme = somme + moyenne;
                compteur = compteur + 1;
            }
        }
        if (compteur == 0) {
            System.out.println("Erreur : aucun etudiant n'a de moyenne generale.");
            return -1;
        } else {
            return somme / compteur;
        }
    }

    public void triAlpha() {
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            public int compare(Etudiant e1, Etudiant e2) {
                return e1.getIdentite().getNom().compareTo(e2.getIdentite().getNom());
            }
        });
    }

    public void triAntiAlpha() {
        triAlpha();
        List<Etudiant> inverse = new ArrayList<Etudiant>();
        for (Etudiant etudiant : etudiants) {
            inverse.add(0, etudiant);
        }
        etudiants = inverse;
    }

    public void triParMerite() {
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            public int compare(Etudiant e1, Etudiant e2) {
                double m1 = e1.calculerMoyenneGenerale();
                double m2 = e2.calculerMoyenneGenerale();
                return Double.compare(m2, m1);
            }
        });
    }

    public String toString() {
        return "Groupe (" + formation.getIdentifiant() + ") : " + etudiants;
    }
}
