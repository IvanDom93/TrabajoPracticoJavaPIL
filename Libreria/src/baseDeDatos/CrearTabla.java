package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void crearBaseDatos(){
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query

            stmt = conn.createStatement();
            String sql =  "CREATE TABLE LIBRO " +
                    "(id_libro INTEGER not NULL, " +
                    " titulo VARCHAR(100), " +
                    " autor VARCHAR(100), " +
                    " precio number(10,2), " +
                    " genero VARCHAR(50), " +
                    " editorial VARCHAR(50), "+
                    " anioPublicacion INTEGER,"+
                    " PRIMARY KEY (id_libro))";
            String sql1 = "CREATE TABLE Comic " +
                    "(id_comic INTEGER not NULL, " +
                    " titulo VARCHAR(100), " +
                    " autor VARCHAR(100), " +
                    " precio number(10,2), " +
                    " genero VARCHAR(50), " +
                    " editorial VARCHAR(50), "+
                    " anioPublicacion INTEGER,"+
                    " dibujante VARCHAR(50),"+
                    " colorista VARCHAR(50),"+
                    " PRIMARY KEY (id_comic))";
            String sql2 = "CREATE TABLE Revista " +
                    "(id_revista INTEGER not NULL, " +
                    " titulo VARCHAR(100), " +
                    " precio number(10,2), " +
                    " fechaPublicacion DATE,"+
                    " PRIMARY KEY ( id_revista ))";
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);


            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
          //  se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
          //  e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
              //  se.printStackTrace();
            } //end finally try
        } //end try

    }
}
