import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etudiant {

    private Identite identite;
    private Formation formation;
    private Map<Matiere, List<Double>> notes;

    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.notes = new HashMap<Matiere, List<Double>>();
    }
    public Identite getIdentite() {
        return identite;
    }

    public Formation getFormation(){
        return formation;
    }

    public void ajouterNote(Matiere matiere, double note) {
        if (note < 0 || note > 20) {
            System.out.println("Erreur : la note doit etre comprise entre 0 et 20.");
        } else if (!formation.contientMatiere(matiere)) {
            System.out.println("Erreur : la matiere " + matiere + " n'est pas dans la formation de l'etudiant.");
        } else {
            if (!notes.containsKey(matiere)) {
                notes.put(matiere, new ArrayList<Double>());
            }
            notes.get(matiere).add(note);
        }
    }

    public double calculerMoyenne(Matiere matiere) {
        if (!formation.contientMatiere(matiere)) {
            System.out.println("Erreur : la matiere " + matiere + " n'est pas dans la formation de l'etudiant.");
            return -1;
        } else if (!notes.containsKey(matiere) || notes.get(matiere).isEmpty()) {
            System.out.println("Erreur : aucune note dans cette matiere.");
            return -1;
        } else {
            double somme = 0;
            List<Double> listeNotes = notes.get(matiere);
            for (double note : listeNotes) {
                somme = somme + note;
            }
            return somme / listeNotes.size();
        }
    }

    public double calculerMoyenneGenerale() {
        double sommePonderee = 0;
        int sommeCoefficients = 0;
        for (Matiere matiere : formation.getMatieres().keySet()) {
            if (notes.containsKey(matiere) && !notes.get(matiere).isEmpty()) {
                int coefficient = formation.getCoefficient(matiere);
                double moyenneMatiere = calculerMoyenne(matiere);
                sommePonderee = sommePonderee + moyenneMatiere * coefficient;
                sommeCoefficients = sommeCoefficients + coefficient;
            }
        }
        if (sommeCoefficients == 0) {
            System.out.println("Erreur : l'etudiant n'a aucune note.");
            return -1;
        } else {
            return sommePonderee / sommeCoefficients;
        }
    }

    public String toString() {
        return identite.toString();
    }
}
