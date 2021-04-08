package fr.uvsq.poo.RPNCalculator;

/**
 * @author GT17S
 * Class Operations est classe qui contenant toutes les operations de la calculatrice RPN.
 */
import fr.uvsq.poo.RPNCalculator.Exceptions.HandlerException;

import java.util.Stack;

public class Operations implements Undoable {

    private double dernier,avantDernier;
    private OperationEnum operation;
    private Stack<Double> pile;

    public Operations(Stack<Double> pile, OperationEnum operation) {
        HandlerException.HandleStackSize(pile.size(), 2);
        this.pile = pile;
        this.operation = operation;
    }

    @Override
    public void apply() {
        double result;
        this.dernier = this.pile.pop();
        this.avantDernier = this.pile.pop();
        try {
            result = operation.eval(avantDernier, dernier);
            HandlerException.HandleMinMax(result);
            this.pile.push(result);
        }
        catch (ArithmeticException e) {
            this.pile.push(avantDernier);
            this.pile.push(dernier);
            throw e;
        }
    }

    @Override
    public void undo() {
        this.pile.pop();
        this.pile.push(avantDernier);
        this.pile.push(dernier);
    }

}
