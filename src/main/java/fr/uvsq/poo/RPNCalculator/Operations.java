package fr.uvsq.poo.RPNCalculator;

/**
 * @author GT17S
 * Class Operations est classe qui contenant toutes les operations de la calculatrice RPN.
 */
import java.util.Stack;

public class Operations implements Undoable {

    private double dernier,avantDernier;
    private OperationEnum operation;
    private Stack<Double> pile;

    public Operations(Stack<Double> pile, OperationEnum operation) {
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
