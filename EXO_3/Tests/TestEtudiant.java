import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEtudiant {

    @Test
    public void testAjouterNoteValides(){
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathématiques");
        formation.ajouterMatiere(maths , 3);
        Identite identite = new Identite("12345" , "Dupont" , "Jean");
        Etudiant etudiant = new Etudiant(identite, formation);
        etudiant.ajouterNote(maths,15);
        assertEquals(15.0, etudiant.calculerMoyenne(maths), 0.01);
    }

    @Test
    public void testAjouterNoteHorsIntervalle() {
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathematiques");
        formation.ajouterMatiere(maths, 3);
        Identite identite = new Identite("12345", "Dupont", "Jean");
        Etudiant etudiant = new Etudiant(identite, formation);
        etudiant.ajouterNote(maths, 25);
        assertEquals(-1.0, etudiant.calculerMoyenne(maths), 0.01);
    }

    @Test
    public void testAjouterNoteMatiereHorsFormation() {
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathematiques");
        Matiere musique = new Matiere("Musique");
        formation.ajouterMatiere(maths, 3);
        Identite identite = new Identite("12345", "Dupont", "Jean");
        Etudiant etudiant = new Etudiant(identite, formation);
        etudiant.ajouterNote(musique, 15);
        assertEquals(-1.0, etudiant.calculerMoyenne(musique), 0.01);
    }

    @Test
    public void testMoyenneGenerale() {
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathematiques");
        Matiere ArchiReseaux = new Matiere("ArchiReseaux");
        formation.ajouterMatiere(maths, 2);
        formation.ajouterMatiere(ArchiReseaux, 1);
        Identite identite = new Identite("12345", "Dupont", "Jean");
        Etudiant etudiant = new Etudiant(identite, formation);
        etudiant.ajouterNote(maths, 10);
        etudiant.ajouterNote(ArchiReseaux, 16);
        assertEquals(12.0, etudiant.calculerMoyenneGenerale(), 0.01);
    }
}
