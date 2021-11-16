import java.sql.*;
import java.util.*;

public class BookDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String url, user, password;
	
	public BookDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "jsp02";
		password = "jsp02";
	}
	
	public int insertBook(String bookname, String writer, String publisher, int price) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "insert into book values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, bookname);
			ps.setString(2, writer);
			ps.setString(3, publisher);
			ps.setInt(4, price);
			int res = ps.executeUpdate();
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public ArrayList<BookDTO> listBook() throws SQLException {
		try {
			String sql = "select * from book";
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<BookDTO> list = makeArrayList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public int deleteBook(String bookname) throws SQLException {
		try {
			String sql ="delete from book where bookname = ?";
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			ps.setString(1, bookname);
			int res = ps.executeUpdate();
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}

	public ArrayList<BookDTO> makeArrayList(ResultSet rs) throws SQLException{
		ArrayList<BookDTO> list = new ArrayList<>();
		while(rs.next()) {
			BookDTO dto = new BookDTO();
			dto.setBookname(rs.getString("bookname"));
			dto.setWriter(rs.getString("writer"));
			dto.setPublisher(rs.getString("publisher"));
			dto.setPrice(rs.getInt("price"));
			list.add(dto);
		}
		return list;
	}

	public ArrayList<BookDTO> findBook(String search, String searchString)	
														throws SQLException{
		try {
			String sql = "select * from book where  "+search+" = ?";
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			ps.setString(1, searchString);
			rs = ps.executeQuery();
			ArrayList<BookDTO> find = makeArrayList(rs);
			return find;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}











