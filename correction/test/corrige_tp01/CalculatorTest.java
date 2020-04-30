package test.corrige_tp01;

import corrige_tp01.Calculator;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorTest {

    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    final Calculator calc = new Calculator();
    final String[] correctOperations = {
            "1+2",
            "2-3",
            "3*4",
            "4/5",
            "1 + 2",
            "2 - 3",
            "3 * 4",
            "4 / 5",
            "1.1+2.2",
            "2.2-3.3",
            "3.3*4.4",
            "4.4/5.5",
            "1.1 + 2.2",
            "2.2 - 3.3",
            "3.3 * 4.4",
            "4.4 / 5.5",
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
    String[] incorrectOperations = {
            "taratata+23g",
            "23a - taratata",
            "Il était une bergère et rond et rond...",
            "~!@#$%^&*()-_+=\\|}{][\"';:/?.,><"
    };

    /**
     * Method: split(String operation)
     */
    @Test
    public void testSplit() throws Exception {
        LOGGER.log(Level.INFO, "Décomposition de l'opération");
        for (String op : correctOperations) {
            calc.split(op);
            LOGGER.log(Level.INFO, calc.toString());
        }
    }

    /**
     * Method: solve(String operation)
     */
    @Test
    public void testCalculate() throws Exception {
        LOGGER.log(Level.INFO, "Calculator::calculate()");
        for (String op : correctOperations) {
            calc.solve(op);
            LOGGER.log(Level.INFO, calc.toString());
        }
    }

} 
