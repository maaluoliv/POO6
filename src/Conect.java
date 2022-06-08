import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Conect {

    private String url = "jdbc:postgresql://localhost:5432/BDlivrariaUniversitaria";
    private String user = "postgres";
    private String password = "root";
    private Connection con;


    public Statement start() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            return st;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void end() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}