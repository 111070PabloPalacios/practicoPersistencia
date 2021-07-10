package insertardatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatosAuto {
    static final String DRIVER = "org.h2.Driver";
    static final String URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "";

    public void insertarDatosAuto(String patente, String tieneEstereo, int cantidadDePuertas, int traccion)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(DRIVER);

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connected database successfully...");

            stmt = conn.createStatement();
            String sql = "INSERT INTO Autos " + "VALUES('" + patente + "', '" + tieneEstereo + "' , " +
                    cantidadDePuertas + ", " + traccion + ");";

            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");

            stmt.close();
            conn.close();
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
