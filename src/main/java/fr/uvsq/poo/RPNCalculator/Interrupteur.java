package fr.uvsq.poo.RPNCalculator;

/**
 * @author GT17S
 * Class Interrupteur est classe qui permet d'allumer ou eteindre la calculatrice RPN.
 */

public class Interrupteur {

    private boolean interrupteurAllumer;

    /**
     * Constructeur sans parameters
     */
    public Interrupteur() {
        this.interrupteurAllumer = true;
    }


    /**
     * Methode sans parameters qui verifier si l'interrupteur de la calculatrice est allumer ou pas.
     */
    public boolean EstAllumer() {
        return interrupteurAllumer;
    }


    /**
     * Methode sans parameters qui permet d'allumer l'interrupteur de la calculatrice et allumer cette derniere
     * par la suite.
     */
    public void Allumer() {
        interrupteurAllumer = true;
    }


    /**
     * Methode sans parameters qui permet d'eteindre l'interrupteur de la calculatrice et eteindre cette derniere
     * par la suite.
     */
    public void Eteindre() {
        interrupteurAllumer = false;
    }
}
