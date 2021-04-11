package fr.uvsq.poo.RPNCalculator;
import fr.uvsq.poo.RPNCalculator.Exceptions.DivisionParZeroException;
import fr.uvsq.poo.RPNCalculator.Exceptions.MinMaxValueException;
import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class RPNCalculatorTest {

    @Test
    public void AdditionOperationShouldWork()
    {
        OperationEnum operation=OperationEnum.PLUS;
        double s= operation.eval(17, 13);
        assertThat(s, is(equalTo(30.0)));
    }

    @Test
    public void SubOperationShouldWork()
    {
        OperationEnum operation=OperationEnum.MOINS;
        double s= operation.eval(17, 13);
        assertThat(s, is(equalTo(4.0)));
    }

    @Test
    public void MultiplicationOperationShouldWork()
    {
        OperationEnum operation=OperationEnum.MULT;
        double s= operation.eval(20, 4);
        assertThat(s, is(equalTo(80.0)));
    }

    @Test
    public void DivisionOperationShouldWork()
    {
        OperationEnum operation=OperationEnum.DIV;
        double s= operation.eval(15, 5);
        assertThat(s, is(equalTo(3.0)));
    }

    @Test(expected = DivisionParZeroException.class)
    public void DivisionOperationOnzeroShouldFail()
    {
        OperationEnum operation=OperationEnum.DIV;
        double s= operation.eval(10, 0);
    }


    @Test
    public void applyOperationsWork()
    {
        Stack<Double> s= new Stack<Double>();
        s.push(5.0);
        s.push(2.0);

        Operations operation= new Operations(s,OperationEnum.PLUS);
        operation.apply();
        Double d= s.peek();
        assertThat(d, is(equalTo(7.0)));
    }

    @Test
    public void UndoWork()
    {
        Stack<Double> s= new Stack<Double>();
        s.push(5.0);
        s.push(2.0);

        Operations operation= new Operations(s,OperationEnum.PLUS);
        operation.apply();
        operation.undo();

        Double d= s.peek();
        assertThat(d, is(equalTo(2.0)));
    }

    @Test
    public void ExitWork()
    {
        MoteurRPN moteurRPN= new MoteurRPN();

        Stack<Double> s= new Stack<Double>();
        s.push(5.0);
        s.push(2.0);

        Operations operation= new Operations(s,OperationEnum.PLUS);

        moteurRPN.Eteindre();//quit part, quand etteint le moteur forcement on quitte le programme de la calculatrice.

        if(moteurRPN.isOn()) //si moteur est allumer, on effectue l'operation sinon on le fait pas
        operation.apply();

        Double d= s.peek();
        assertThat(d, is(equalTo(2.0)));
    }

    @Test
    public void AddHandeledValueWork()
    {
        MoteurRPN moteurRPN= new MoteurRPN();
        moteurRPN.enregistrerNB(10.0);
    }

    @Test(expected = MinMaxValueException.class)
    public void AddUnhadeledValueFail()
    {
        MoteurRPN moteurRPN= new MoteurRPN();
        moteurRPN.enregistrerNB(5500001.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void UnhadeledUndoOnEmptyStackFail()
    {
        Stack<Double> s= new Stack<Double>();

        Operations operation= new Operations(s,OperationEnum.PLUS);
        operation.undo();
    }
    
    @Test
    public void TestLogerString() {
        Interpreter i = new Interpreter();
        i.log("Bonjour!");
        assertThat(i.getLastLog(), is(equalTo("Bonjour!")));
    }

}
