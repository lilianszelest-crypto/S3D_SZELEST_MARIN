import java.util.HashMap;
import java.util.Map;


public class Formation{
    private String identifiant;
    private Map<Matiere , Integer> matieres;

    public Formation(String i) {
        this.identifiant = i;
        this.matieres = new HashMap<Matiere, Integer>();
    }

    public String getIdentifiant(){
        return matieres;
    }

    public void ajouterMatiere(Matiere matiere, int coefficient) {
        matieres.put(matiere, coefficient);
    }

    public void supprimerMatiere(Matiere matiere) {
        matieres.remove(matiere);
    }

    public boolean contientMatiere(Matiere matiere) {
        return matieres.containsKey(matiere);
    }


    public int getCoefficient(Matiere matiere) {
        if (matieres.containsKey(matiere)) {
            return matieres.get(matiere);
        } else {
            System.out.println("Erreur : la matiere " + matiere + " n'est pas dans la formation.");
            return -1;
        }
    }

    public String toString() {
        return "Formation " + identifiant + " : " + matieres;
    }


}