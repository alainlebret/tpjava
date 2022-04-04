package tp04.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Dbms {
    private String _dbName;
    Connection _conn;

    public Dbms(String dbName) {
        _dbName = dbName;

        try {
            Class.forName("org.sqlite.JDBC");
            _conn= DriverManager.getConnection("jdbc:sqlite:" + _dbName);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println ("Erreur: " + ex.getMessage()) ;
            System.exit (1) ;
        }
    }

    private String createListOfFields(String[] fields) {
        StringBuilder listOfFields;
        String delim;

        listOfFields = new StringBuilder();
        delim = "";
        for (String f : fields) {
            listOfFields.append(delim).append(f);
            delim = ",";
        }
        return listOfFields.toString();
    }

    public String request(String[] fields, String table, String condition) throws SQLException {
        PreparedStatement statement;
        ResultSet rs;
        String listOfFields;
        StringBuilder result;
        String request;
        String delim;

        result = new StringBuilder();
        request = "SELECT " + createListOfFields(fields) + " FROM " + table;
        if (!condition.isEmpty()) {
            request += " WHERE " + condition + ";";
        }

        statement = _conn.prepareStatement(request);
        rs = statement.executeQuery();

        while (rs.next()) {
            delim = "";
            for (String f: fields) {
                result.append(delim).append(rs.getString(f));
                delim = ",";
            }
            result.append("\n");
        }

        return result.toString();
    }
}
