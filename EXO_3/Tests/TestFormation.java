import org.junit.Test;


import static org.junit.Assert.*;


public class TestFormation {

    @Test
    public void testAjoutMatiere(){
        Formation formation = new Formation("BUT1");
        Matiere maths = new Matiere("Mathematiques");
        formation.ajouterMatiere(maths, 3);
        assertTrue(formation.contientMatiere(maths));
        assertEquals(3, formation.getCoefficient(maths));
    }
    @Test
    public void testSupprMatiere(){
        Formation formation = new Formation("BUT1");
        Matiere Qdev = new Matiere("QualiteDev");
        formation.ajouterMatiere(Qdev, 67);
        formation.supprimerMatiere(Qdev);
        assertFalse(formation.contientMatiere(Qdev));
    }

    @Test
    public void testCoefMatPasLa(){
        Formation formation = new Formation("BUT1");
        Matiere WEB = new Matiere("DevWeb");
        assertEquals(-1, formation.getCoefficient(WEB));

    }





}
