package creartablas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaVehiculo {

    static final String DRIVER = "org.h2.Driver";
    static final String URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL,USER,PASS);

            stmt = conn.createStatement();
            String sql =  "CREATE TABLE vehiculos (" +
                    "patente varchar NOT NULL," +
                    "modelo varchar," +
                    "tipo varchar," +
                    "usado varchar," +
                    "color varchar, " +
                    "marca varchar," +
                    "constraint pk_Patente primary key (patente) );";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
