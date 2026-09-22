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
        Identite identite = new Identite("12345", "Dupont", "Lola");
        Etudiant etudiant = new Etudiant(identite, formation);
        etudiant.ajouterNote(maths, 10);
        etudiant.ajouterNote(ArchiReseaux, 16);
        assertEquals(12.0, etudiant.calculerMoyenneGenerale(), 0.01);
    }

    @Test
    public void testMoyenneGAvecTroisCoefficients() {
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathematiques");
        Matiere info = new Matiere("Informatique");
        Matiere anglais = new Matiere("Anglais");
        formation.ajouterMatiere(maths, 3);
        formation.ajouterMatiere(info, 2);
        formation.ajouterMatiere(anglais, 1);
        Identite identite = new Identite("12345", "Dupont", "Minas");
        Etudiant etudiant = new Etudiant(identite, formation);
        etudiant.ajouterNote(maths, 12);
        etudiant.ajouterNote(info, 8);
        etudiant.ajouterNote(anglais, 18);
        assertEquals(70.0 / 6, etudiant.calculerMoyenneGenerale(), 0.01);
    }

    @Test
    public void testMoyenneGSansNote() {
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathematiques");
        formation.ajouterMatiere(maths, 3);
        Identite identite = new Identite("12345", "Dupont", "Maxime");
        Etudiant etudiant = new Etudiant(identite, formation);
        assertEquals(-1.0, etudiant.calculerMoyenneGenerale(), 0.01);
    }

    @Test
    public void testMoyenneGMatiereSansNoteIgnoree() {
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathematiques");
        Matiere info = new Matiere("Informatique");
        Matiere anglais = new Matiere("Anglais");
        formation.ajouterMatiere(maths, 3);
        formation.ajouterMatiere(info, 2);
        formation.ajouterMatiere(anglais, 1);
        Identite identite = new Identite("12345", "Dupont", "lilian");
        Etudiant etudiant = new Etudiant(identite, formation);
        etudiant.ajouterNote(maths, 10);
        etudiant.ajouterNote(info, 14);
        assertEquals(58.0 / 5, etudiant.calculerMoyenneGenerale(), 0.01);
    }

    @Test
    public void testMoyenneGValeursLimites() {
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathematiques");
        Matiere sport = new Matiere("Sport");
        formation.ajouterMatiere(maths, 4);
        formation.ajouterMatiere(sport, 1);
        Identite identite = new Identite("12345", "Dupont", "Jean");
        Etudiant etudiant = new Etudiant(identite, formation);
        etudiant.ajouterNote(maths, 0);
        etudiant.ajouterNote(maths, 20);
        etudiant.ajouterNote(maths, 10);
        etudiant.ajouterNote(sport, 20);
        assertEquals(10.0, etudiant.calculerMoyenne(maths), 0.01);
        assertEquals(12.0, etudiant.calculerMoyenneGenerale(), 0.01);
    }
}
