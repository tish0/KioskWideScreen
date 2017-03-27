/**
 * 
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Tihomir Penev
 *
 */
public class MysqlConnect {
	Connection conn = null;

    public static Connection ConnecrDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/MeetingBooker","root","root");
            System.out.println("Connection success!");
            Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select*from Staff");
			while(rs.next()){
				String name = rs.getString("name");
				System.out.println(name);
			}
            return conn;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}