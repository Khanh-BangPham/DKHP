package sqlserver_connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class ConnectionHelper {

    public ConnectionHelper() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception ex) {
            System.out.println("Cann't load driver!");
            ex.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        Connection connect = null;
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DKHocPhan_final;encrypt=false;user=sa;password=12345";
            connect = DriverManager.getConnection(connectionUrl);
            if(connect != null)
                System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return connect;
    }
    public Connection closeConnection(Connection connect){
        try{
            connect.close();
            System.out.println("Connection is closed!");
        } catch(Exception ex){
            System.out.println("Cann't close connection!");
            ex.printStackTrace();
        }
        return connect;
    }
}
