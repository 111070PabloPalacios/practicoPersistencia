package leerdatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeerDatosMotos {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "";

    public void leerDatosMotos()
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql = "SELECT patente, cilindrada, tieneAsientoAcompañante FROM Motos";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String patente  = rs.getString("patente");
                String cilindrada = rs.getString("cilindrada");
                String tieneAsientoAcompañante = rs.getString("tieneAsientoAcompañante");

                System.out.print("Patente: " + patente);
                System.out.print(", cilindrada: " + cilindrada);
                System.out.print(", tieneAsientoAcompañante: " + tieneAsientoAcompañante);
            }
            rs.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }

}
