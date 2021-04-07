package fr.uvsq.poo.RPNCalculator.Exceptions;
/**
 * Exception pour le cas d'une devision sur 0
 * @author Koussaila 21805388
 */
public class DivisionParZeroException extends ArithmeticException {
    /**
     * le Constructeur de notre exception
     */
    public DivisionParZeroException() {

        super("Division par zéro ! Veuillez revoir vos cours de maths");
    }
}













