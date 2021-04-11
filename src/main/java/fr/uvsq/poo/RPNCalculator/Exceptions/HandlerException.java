package fr.uvsq.poo.RPNCalculator.Exceptions;
/**
 * Exception pour gerer la taille de la pile et la valeur maximale autorisé.
 * @author GT17S
 */

public class HandlerException {

    private static final double MAXIMUM_VALUE = 500000;

    public static void HandleMinMax(double numbre) {
        if(numbre > MAXIMUM_VALUE || numbre < -MAXIMUM_VALUE) {
            throw new MinMaxValueException();
        }
    }

    public static void HandleStackSize(int actualSize, int wantedSize) {
        if(actualSize < wantedSize) {
            throw new IllegalArgumentException("Vous avez pas assez d'éléments dans la pile pour cette opération.");
        }
    }

}
