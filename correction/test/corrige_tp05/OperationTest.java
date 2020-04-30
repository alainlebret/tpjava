package test.corrige_tp05;

import corrige_tp05.Operation;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationTest {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    final String[] correctOperations = {"1+2",
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
            "-1.1 - -2.2",
            "-1.1 * -2.2",
            "-1.1 / -2.2",
            "1.0e+10+2.0e+2",
            "2.2e-2-3.3e-3",
            "3.3e+2*4.4e+2",
            "4.44e-10/5.55e-10"
    };
    String[] incorrectOperations = {"taratata+2",
            "2 - taratata",
            "Il était une bergère et rond et rond...",
            "~!@#$%^&*()-_+=\\|}{][\"';:/?.,><"
    };
    Operation operation = new Operation();

    @Test
    public void getOperation() {
        LOGGER.log(Level.INFO, "Operation::getOperation()");
        for (String op : correctOperations) {
            operation.setOperation(op);
            LOGGER.log(Level.INFO, operation.getOperation());
        }
        for (String op : incorrectOperations) {
            operation.setOperation(op);
            LOGGER.log(Level.INFO, operation.getOperation());
        }

    }

    @Test
    public void setOperation() {
        LOGGER.log(Level.INFO, "Operation::setOperation()");
        for (String op : correctOperations) {
            operation.setOperation(op);
        }
        for (String op : incorrectOperations) {
            operation.setOperation(op);
        }
    }
}