package fr.uvsq.poo.RPNCalculator;

/**
 * @author GT17S
 * enum gérant les quatres opérations possibles pour la Calcalutrice RPN.
 */

public enum OperationEnum {

    PLUS("+"){
        @Override
        public double eval(double x, double y) {
            return x + y;
        }

    },

    MOINS("-"){

        @Override
        public double eval(double x, double y) {
            return x - y;
        }

    },

    DIV("/"){

        @Override
        public double eval(double x, double y) {
            return x / y;
        }

    },

    MULT("*"){

        @Override
        public double eval(double x, double y) {
            return x * y;
        }

    };

    private String operation;

    /**
     * Initialisation de l'opération
     * @param operationsymbole
     */
    private OperationEnum(String operationsymbole) {
        this.operation = operationsymbole;
    }

    /**
     * méthode d'évaluation abstraite (redefinie pour chaque opération).
     * @param x
     * @param y
     * @return
     */
    public abstract double eval(double x , double y);

    /**
     * récupération de sympbole de l'opération
     * @return the operation
     */
    public String getOperationSymbole() {
        return operation;
    }

}