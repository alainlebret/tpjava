package tp04.db.test;

import org.junit.jupiter.api.Test;
import tp04.db.Dbms;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DbmsTest {

    @Test
    void request() {
        String result = null;
        Dbms dbms = new Dbms("divers/tp04/ressources/cinema.db");
        String[] fields = { "anneesortie", "titre" };

        try {
            result = dbms.request(fields, "films", "");
            System.out.println(result);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}