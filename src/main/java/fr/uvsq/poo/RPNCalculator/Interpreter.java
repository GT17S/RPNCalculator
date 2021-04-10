package fr.uvsq.poo.RPNCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author GT17S
 * Class Interpreter qui interprete les differentes etapes de calcule RPN et qui permet par la suite de les stockées.
 */
@SuppressWarnings("JavaDoc")
public class Interpreter{

    private Stack<Undoable> historique;
    private Interrupteur interrupteur;
    private List<String> logger;

    public Interpreter() {
        this.historique = new Stack<Undoable>();
        this.interrupteur = new Interrupteur();
        this.logger = new ArrayList<String>();
    }

    /**
     * Exécuter une commande (Operation)
     * @param command de type Command l'interface initiale de projet.
     */
    private void applyCommand(Command command) {
        command.apply();
    }

    /**
     * Exécute une commande annulable puis la sauvegarder dans l'historique
     * La commande n'est pas ajouté dans l'historique si elle lance une exception.
     * @param command de type Command l'interface initiale de projet.
     */
    public void applyStoreCommand(Undoable command) {
        try {
            command.apply();
            this.historique.add(command);
        } catch (Exception e) {
            throw e;
        }
    }

    public void undo() {
        this.applyCommand(new Undo(historique));
    }

    public void log(String string) {
        this.applyCommand(() -> logger.add(string));
    }

    public String getLastLog() {
        return logger.get(logger.size() - 1);
    }

    public void Eteindre() {
        this.applyCommand(new Quit(interrupteur));
    }

    public boolean isOn() {
        return interrupteur.estAllumer();
    }

}
