package test.corrige_tp07;

import corrige_tp03.Calculator;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorTest {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    final String[] correctOperations = {
            "1+2",
            "2-3",
            "3*4",
            "4/5",
            "5+6",
            "6-7",
            "7*8",
            "8/9",
            "9+10",
            "10-11",
            "11*12",
            "12/13"
    };
    Calculator calc = new Calculator(5);

    @Test
    public void calculate() {
        LOGGER.log(Level.INFO, "Calculator::solve()");
        for (String op : correctOperations) {
            calc.solve(op);
            LOGGER.log(Level.INFO, "\n" + calc.toString());
        }
    }
}