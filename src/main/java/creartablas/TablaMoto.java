package creartablas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaMoto {
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

            stmt = conn.createStatement();
            String sql =  "create table Motos (" +
                    "patente varchar NOT NULL," +
                    "cilindrada varchar," +
                    "tieneAsientoAcompañante varchar," +
                    "constraint fk_patente foreign key(patente) references Vehiculos);";
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
