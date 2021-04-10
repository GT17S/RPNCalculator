package fr.uvsq.poo.RPNCalculator;
import fr.uvsq.poo.RPNCalculator.Exceptions.DivisionParZeroException;
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
            if(y == 0)  throw new DivisionParZeroException();
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
     *@param operationsymbole de type chaine de caracteres string.
     */
    @SuppressWarnings("JavaDoc")
    private OperationEnum(String operationsymbole) {
        this.operation = operationsymbole;
    }

    /**
     * méthode d'évaluation abstraite (redefinie pour chaque opération).
     *@param x de type double
     *@param y de type double
     *@return double
     */
    @SuppressWarnings("JavaDoc")
    public abstract double eval(double x , double y);

    /**
     * récupération de sympbole de l'opération
     * @return the operation
     */
    public String getOperationSymbole() {
        return operation;
    }

}
