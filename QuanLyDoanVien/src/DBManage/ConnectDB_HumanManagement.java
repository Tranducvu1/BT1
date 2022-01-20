package DBManage;

import java.sql.*;
import java.util.Objects;

public class ConnectDB_HumanManagement {
    Connection conn;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    public Connection connectSQL(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://LT-THAOLV\\SQLEXPRESS:1433;database=HumanManagement;user=sa;password=123456";
            conn = DriverManager.getConnection(url);
            System.out.printf("Connected...");
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public int excuteDB(String sql){
        int record = 0;
        try {
            connectSQL();
            stmt = conn.createStatement();
            record = stmt.executeUpdate(sql);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        finally {
            try {
                conn.close();
                stmt.close();
            } catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return record;
    }
    public ResultSet ListHuman(String sql){
        try {
            connectSQL();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (Exception e3){
            e3.printStackTrace();
        }
        finally {
            try{

            }catch (Exception e4){
                e4.printStackTrace();
            }
        }
        return rs;

    }

}
