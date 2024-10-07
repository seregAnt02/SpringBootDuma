package lesson;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class CalculatorTest {

    @Test
    public void testSum(){
        CalculatorHistory calculatorHistoryMock = Mockito.mock(CalculatorHistory.class);

        Calculator calculator = new Calculator(calculatorHistoryMock);
        int sum = calculator.sum(6, 3);
        Assertions.assertEquals(9, sum);

        Mockito.verify(calculatorHistoryMock).logSumOperation(6, 3, 9);
    }
}
