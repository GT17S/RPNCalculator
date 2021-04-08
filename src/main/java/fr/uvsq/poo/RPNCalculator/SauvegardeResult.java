package fr.uvsq.poo.RPNCalculator;
import java.util.Stack;
import fr.uvsq.poo.RPNCalculator.Exceptions.HandlerException;

/**
 * @author Koussaila 21805388
 * Class SauvegardeResult qui permet de sauvegarder le nombre dans notre pile
 */


public class SauvegardeResult implements Undoable  {

    private double nombre;
    private Stack<Double> pile;

    public SauvegardeResult(Stack<Double> pile, double nombre) {
        this.pile = pile;
        this.nombre = nombre;
    }

    @Override
    public void apply() {
        HandlerException.HandleMinMax(nombre);
        this.pile.push(nombre);
    }

    @Override
    public void undo() {
        this.pile.pop();
    }
}
