package leerdatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeerDatosAutos {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "";

    public void leerDatosAutos()
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql = "SELECT patente, tieneEstereo, cantidadPuertas, traccion FROM Autos";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String patente  = rs.getString("patente");
                String tieneEstereo = rs.getString("tieneEstereo");
                String cantidadPuertas = rs.getString("cantidadPuertas");
                String traccion = rs.getString("traccion");

                System.out.print("Patente: " + patente);
                System.out.print(", Tiene Estereo: " + tieneEstereo);
                System.out.print(", Cantidad de Puertas: " + cantidadPuertas);
                System.out.print(", traccion: " + traccion);
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
