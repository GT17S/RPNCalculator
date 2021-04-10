package fr.uvsq.poo.RPNCalculator;

import fr.uvsq.poo.RPNCalculator.Exceptions.DivisionParZeroException;
import org.junit.Test;

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
}
