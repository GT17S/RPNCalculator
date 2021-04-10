package fr.uvsq.poo.RPNCalculator;

/**
 * @author Koussaila 21805388 and GT17S
 *Main
 */

public enum CalculatriceRPN {
    ENV ;

    public void run( String[] args) {
        SaisieRPN saisie = new SaisieRPN();
        saisie.saisie();
    }

    public static void main( String[] args ) {
        ENV.run(args);

    }
}
