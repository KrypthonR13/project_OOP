package Connected;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connect {

    private Connection con;
    private String DB = "db_datamhs";
    private String URL = "jdbc:mysql://localhost:3306/"+DB;
    private String USER = "root";
    private String PASWD = "";

    public Connect() {
        if (con == null) {
            
            try {
                
                DriverManager.registerDriver(new Driver());
                con = DriverManager.getConnection(URL, USER, PASWD);
                
                System.out.println("Berhasil Terkoneksi ke DataBase");
                
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err);
            }
        }
    }

    public Connection getCon() {
        return con;
    }
    
    public static void main(String[] args) {
        new Connect();
    }

}
