package insertardatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterarTablaVehiculo {
    static final String DRIVER = "org.h2.Driver";
    static final String URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(DRIVER);

            //STEP 2: Open a connection
            System.out.println("Conectando a base de datos");
            conn = DriverManager.getConnection(URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Crear tabla en base de datos");
            stmt = conn.createStatement();
            String sql =  "ALTER TABLE VEHICULOS" + "\n" +
                    "ALTER COLUMN usado varchar;";
            stmt.executeUpdate(sql);
            System.out.println("Se creo la tabla");

            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }
}
