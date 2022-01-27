
package Model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectDB3 {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	public Connection connect(){
		try {
			String url="jdbc:mysql://localhost:3306/quanlythuenha";
			String user="root";
			String password="";
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected...");
		} catch (Exception e) {
			System.out.println("Failed...");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
public int executeDB3(String sql) { //insert, update, delete
	int record=0;
	try {
		connect();
		stmt = conn.createStatement();
		record = stmt.executeUpdate(sql); //so luong hang thay doi sau khi thuc hien 1 trong 3 cau lenh tren
	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
			stmt.close();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	return record;
}


public ResultSet ListLanlords(String sql){
    try {
        connect();
		stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
    } catch (Exception e){
        e.printStackTrace();
    }
    finally {
        try {

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    return rs;
}

}
