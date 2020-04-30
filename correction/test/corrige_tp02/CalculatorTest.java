package test.corrige_tp02;

import corrige_tp02.Calculator;
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
            "1   +   2",
            "2   -   3",
            "3   *   4",
            "4   /   5",
            "1.1+2.2",
            "2.2-3.3",
            "3.3*4.4",
            "4.4/5.5",
            "1.1   +   2.2",
            "2.2   -   3.3",
            "3.3   *   4.4",
            "4.4   /   5.5",
            "-1.1 + -2.2",
            "-0.56 * 1.26",
            "-1.1 + -2.2",
            "-1.1 - -2.2",
            "-1.1 * -2.2",
            "-1.1 / -2.2",
            "1.0e+10+2.0e+2",
            "2.2e-2-3.3e-3",
            "3.3e+2*4.4e+2",
            "4.44e-10/5.55e-10",
            "-2.0e+3+ -2.0e+2"
    };
    String[] uncorrectOperations = {"taratata+2",
            "2 - taratata"
    };
    Calculator calc = new Calculator();

    @Test
    public void calculate() {
        LOGGER.log(Level.INFO, "Calculator::solve()");
        for (String op : correctOperations) {
            calc.solve(op);
            LOGGER.log(Level.INFO, calc.toString());
        }
    }
}