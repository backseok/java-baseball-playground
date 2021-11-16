import java.sql.*;

public class DbManager {
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "jsp02",
                "jsp02");
    }

    public void driverLoad() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void valid(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (con != null) con.close();
    }
}
