package fr.uvsq.poo.RPNCalculator;
/**
 * @author Koussaila 21805388
 * Class Quit est la classe qui permet de quitter la calculatrice RPN et arreter le traitement.
 */
public class Quit implements Command {

    private Interrupteur interrupteur;

    /**
     * Constructeur permettant de creer un objet interrupteur.
     * @param interrupteur
     * @see  Interrupteur
     */
    public Quit(Interrupteur interrupteur) {
        this.interrupteur = interrupteur;
    }

    /**
     * @see  Command
     */
    @Override
    public void apply() {
        interrupteur.Eteindre();
    }
}
