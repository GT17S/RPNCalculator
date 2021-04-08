package fr.uvsq.poo.RPNCalculator;
import java.util.Stack;
/**
 * Gestion de notre  pile d'opérandes
 * @author koussaila 21805388
 */

public class MoteurRPN  extends Interpreter{
    /**
     * la pile dans laquelle seront stockés les opérandes.
     */

    private Stack<Double> pile;

    /**
     * Constructeur de la  pile
     */

    public MoteurRPN() {
        this.pile = new Stack<Double>();
    }

    /**
     * ajoute une opérande nombre dans la pile, telque     -500000 <= op <= 500000
     * @param nombre
     */
    public void enregistrerNB(double nombre) {
        this.applyStoreCommand(new SauvegardeResult(pile, nombre));
    }

     /** applique l'opération op aux deux dernières opérandes de notre pile
      * (lance une exception lorsque la pile ne contient pas assez d'opérandes  < 2 ).
      * @param op
	 */
    public void appliquerOperation(OperationEnum op) {
        this.applyStoreCommand(new Operations(pile, op));
    }

    /**
     * méthode qui affichage les opérandes de notre pile
     * @return chaîne de caractères à afficher
     */
    public String afficherPile() {
        String Result  = "[";
        for (Double n : this.pile) {
            Result += (n + " ");
        }
        return Result.trim() + "]";
    }

    /**
     * méthode donnant la taille de la pile
     * @return nombre d'opérandes dans la pile
     */
    public int getTaillePile(){
        return this.pile.size();
    }

}
