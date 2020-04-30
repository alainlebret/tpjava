package test.corrige_tp06;

import corrige_tp06.BackupCalculator;
import corrige_tp06.TextFile;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BackupCalculatorTest {
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
    BackupCalculator calc = new BackupCalculator(5);

    @Test
    public void save() {
        LOGGER.log(Level.INFO, "BackupCalculator::save()");
        for (String op : correctOperations) {
            calc.solve(op);
            calc.save();
            LOGGER.log(Level.INFO, "\n" + calc.toString());
        }
        BackupCalculatorTest.read();
    }

    static void read() {
        LOGGER.log(Level.INFO, "BackupCalculator: reading file");
        try {
            TextFile file = new TextFile();
            file.open("calculette.txt", "L");
            String operation;

            LOGGER.log(Level.INFO, "Reading operations");
            while ((operation = file.read()) != null) {
                LOGGER.log(Level.INFO, operation);
            }
            file.close();
        } catch (java.io.IOException e) {
            System.err.println("BackupCalculator: erreur lors de la lecture");
        }
    }


}
