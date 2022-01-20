package DBManage;

import java.sql.*;

public class ConnectDB {

        Connection conn;
        Statement stmt;
        PreparedStatement ps;
        ResultSet rs;
        public Connection connectSQL() {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getConstructor().newInstance(); // nạp driver
                String connectionURL = "jdbc:sqlserver://LT-THAOLV\\SQLEXPRESS:1433;database=FB_DB;user=sa;password=123456";
                conn = DriverManager.getConnection(connectionURL);
                System.out.println("Connected...");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
        public int excuteDB(String sql) {
            int record=0;
            try {
                connectSQL();
                stmt = conn.createStatement();
                record = stmt.executeUpdate(sql); 	// executeUpdate(): [Update, Delete, Insert] --> Làm thay đổi dữ liệu trong DB
            } catch (Exception e) {
                e.printStackTrace();
            }
            // đóng kết nối
            finally{
                try {
                    conn.close();
                    stmt.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return record;
        }
        public ResultSet ListAccount(String sql){
            try {
                connectSQL();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql); // executeQuery() : --> Không làm thay đổi dữ liệu trong DB
            } catch (Exception e) {
                e.printStackTrace();
            }
            // đóng kết nối
            finally{
                try {
                    // conn.close();
                    // stmt.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return rs;

        }
    }

