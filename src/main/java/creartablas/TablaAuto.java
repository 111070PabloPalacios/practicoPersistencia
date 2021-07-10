package creartablas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TablaAuto {
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
            String sql =  "create table Autos(" +
                    "patente varchar NOT NULL," +
                    "tieneEstereo varchar," +
                    "cantidadPuertas int," +
                    "traccion int," +
                    "constraint fk_patenteAuto foreign key(patente) references Vehiculos);";
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
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
