import org.junit.Test;
import static org.junit.Assert.*;

public class TestGroupe {

    @Test
    public void testAjouterEtudiantMemeFormation() {
        Formation formation = new Formation("BUT1");
        Groupe groupe = new Groupe(formation);
        Etudiant etudiant = new Etudiant(new Identite("1", "Dupont", "Jean"), formation);
        groupe.ajouterEtudiant(etudiant);
        assertTrue(groupe.getEtudiants().contains(etudiant));
    }

    @Test
    public void testAjouterEtudiantFormationDifferente() {
        Formation formation1 = new Formation("BUT1");
        Formation formation2 = new Formation("BUT2");
        Groupe groupe = new Groupe(formation1);
        Etudiant etudiant = new Etudiant(new Identite("1", "Dupont", "Jean"), formation2);
        groupe.ajouterEtudiant(etudiant);
        assertFalse(groupe.getEtudiants().contains(etudiant));
    }

    @Test
    public void testSupprimerEtudiant() {
        Formation formation = new Formation("BUT1");
        Groupe groupe = new Groupe(formation);
        Etudiant etudiant = new Etudiant(new Identite("1", "Dupont", "Jean"), formation);
        groupe.ajouterEtudiant(etudiant);
        groupe.supprimerEtudiant(etudiant);
        assertFalse(groupe.getEtudiants().contains(etudiant));
    }

    @Test
    public void testTriAlpha() {
        Formation formation = new Formation("BUT1");
        Groupe groupe = new Groupe(formation);
        Etudiant e1 = new Etudiant(new Identite("1", "Zola", "Emile"), formation);
        Etudiant e2 = new Etudiant(new Identite("2", "Dupont", "Jean"), formation);
        Etudiant e3 = new Etudiant(new Identite("3", "Martin", "Paul"), formation);
        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);
        groupe.ajouterEtudiant(e3);
        groupe.triAlpha();
        assertEquals(e2, groupe.getEtudiants().get(0));
        assertEquals(e3, groupe.getEtudiants().get(1));
        assertEquals(e1, groupe.getEtudiants().get(2));
    }

    @Test
    public void testTriAntiAlpha() {
        Formation formation = new Formation("BUT1");
        Groupe groupe = new Groupe(formation);
        Etudiant e1 = new Etudiant(new Identite("1", "Zola", "Emile"), formation);
        Etudiant e2 = new Etudiant(new Identite("2", "Dupont", "Jean"), formation);
        Etudiant e3 = new Etudiant(new Identite("3", "Martin", "Paul"), formation);
        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);
        groupe.ajouterEtudiant(e3);
        groupe.triAntiAlpha();
        assertEquals(e1, groupe.getEtudiants().get(0));
        assertEquals(e3, groupe.getEtudiants().get(1));
        assertEquals(e2, groupe.getEtudiants().get(2));
    }

    @Test
    public void testTriParMerite() {
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathematiques");
        formation.ajouterMatiere(maths, 1);
        Groupe groupe = new Groupe(formation);
        Etudiant e1 = new Etudiant(new Identite("1", "Dupont", "Jean"), formation);
        Etudiant e2 = new Etudiant(new Identite("2", "Martin", "Paul"), formation);
        e1.ajouterNote(maths, 8);
        e2.ajouterNote(maths, 16);
        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);
        groupe.triParMerite();
        assertEquals(e2, groupe.getEtudiants().get(0));
        assertEquals(e1, groupe.getEtudiants().get(1));
    }
}