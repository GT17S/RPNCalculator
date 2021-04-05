package fr.uvsq.poo.RPNCalculator;

/**
 * @author GT17S
 *
 * Interface ajoutée pour annuler Undo et Exit
 * # COMMANDE
 */
public interface Undoable extends Command {

    public void undo();

}
