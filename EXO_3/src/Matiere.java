public class Matiere {

    private String nom;

    public Matiere(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Matiere) {
            Matiere autre = (Matiere) o;
            return nom.equals(autre.nom);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return nom.hashCode();
    }

    public String toString() {
        return nom;
    }
}