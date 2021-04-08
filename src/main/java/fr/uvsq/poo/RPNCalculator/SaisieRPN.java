package fr.uvsq.poo.RPNCalculator;

import java.util.Scanner;

import fr.uvsq.poo.RPNCalculator.Exceptions.DivisionParZeroException;
import fr.uvsq.poo.RPNCalculator.Exceptions.MinMaxValueException;

/**
 * Class SaisieRPN fait la gestion des de la saisie pour la calculatrice RPN.
 * Les nombres sont empilés dans la pile du moteur et les opérations sont appliquées au sommet de la pile.
 *
 * @author GT17S
 *
 */

public class SaisieRPN {

    private MoteurRPN moteur;
    private Scanner scanner;

    /**
     * Constructeur de la classe SaisieRPN.
     */
    public SaisieRPN(){
        moteur = new MoteurRPN();
    }

    /**
     * Initialise le Scanner
     * @param scanner instance de Scanner
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Methode qui Ferme le Scanner, et arrete la saisie.
     */
    public void fermerScanner() {
        scanner.close();
    }

    /**
     * Fonction pour la saisie de la calculatrice et l'affichage de la pile
     * Sera Appeler par CalculatriceRPN
     */
    public void saisie() {
        this.setScanner(new Scanner(System.in));

        String inputValues = "";
        String string = "";

        while(moteur.isOn()) {
            System.out.println("Veuillez saisir un entier, ou une opération,ou undo pour revenir vers l'état d'avant" +
                    " ou exit pour sortir, puis taper sur entrer");
            try {
                inputValues = scanneLigne();
                string += inputValues + " ";
                System.out.println(string);
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.println(moteur.afficherPile());
        }

        System.out.println("Fin du programme !");
        this.fermerScanner();
    }

    /**
     * Scanne une ligne
     * @return operande, double ou exit
     * @throws DivisionParZeroException
     * @throws MinMaxValueException
     */
    public String scanneLigne() throws DivisionParZeroException, MinMaxValueException
    {
        String input;
        if (scanner.hasNextDouble()) {
            Double db = scanner.nextDouble();
            moteur.enregistrerNB(db);
            scanner.nextLine();
            input = db.toString();
        }
        else {
            input = scanner.nextLine();
            if (input.equals("exit")) {
                moteur.Eteindre();
            }
            else if (input.equals("undo")) {
                moteur.undo();
            }
            else if (isOperation(input)) {
                moteur.appliquerOperation(renvoieOperation(input));
            }
            else {
                throw new IllegalArgumentException("Erreur de saisie");
            }
        }
        return input;
    }

    /**
     * Retourne vrai si le string correspond à une opération
     * @param string
     * @return booleen
     */
    private boolean isOperation(String string) {
        return this.renvoieOperation(string) != null;
    }

    /**
     * Retourne une opération correspondante au string de l'opération entre par l'utulisateur
     * @param string
     * @return OperationEnum
     */
    private OperationEnum renvoieOperation(String string) {
        for (OperationEnum op : OperationEnum.values())
            if (string.equals(op.getOperationSymbole()))
                return op;
        return null;
    }

    /**
     * Vérifie que l'état de la pile est conforme à la fin de la saisie de l'utilisateur
     */
    public void isStackValid()  {
        if (!(this.moteur.getTaillePile() == 1)) {throw new IllegalArgumentException("Il n'y a pas assez d'opérations, il reste au moins deux nombres dans la pile");}
    }


    /**
     * verifier le nombre d'opérations dans la pile
     * si c'est pas valide il renvoie une exception.
     */
    private void checkNombreOperations() {
        try {
            this.isStackValid();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}