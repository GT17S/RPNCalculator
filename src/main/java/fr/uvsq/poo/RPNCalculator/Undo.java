package fr.uvsq.poo.RPNCalculator;

import fr.uvsq.poo.RPNCalculator.Exceptions.HandlerException;

import java.util.Stack;

/**
 * @author Koussaila
 * Class Undo est la classe qui permet d'annuler une commande de la calculatrice RPN.
 */

public class Undo implements Command {


    private Undoable derniereCommande;

    /**
     * Constructeur permettant d'annuler une commande.
     * @param historique qui une pile de operandes et operations
     * @see  Undoable
     * @see  Stack
     */

    public Undo(Stack<Undoable> historique)
    {
        HandlerException.HandleStackSize(historique.size(), 1);
        this.derniereCommande = historique.pop();
    }

    @Override
    public void apply() {
        derniereCommande.undo();
    }
}
