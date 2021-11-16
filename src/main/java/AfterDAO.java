import java.sql.*;
import java.util.ArrayList;

public class AfterDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private DbManager dbManager;

	public AfterDAO(){
		dbManager.driverLoad();
	}
	
	public int insertBook(BookDTO bookDTO) throws SQLException{
		try {
			con = dbManager.getConnection();
			String sql = "insert into book values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, bookname);
			ps.setString(2, writer);
			ps.setString(3, publisher);
			ps.setInt(4, price);
			int res = ps.executeUpdate();
			return res;
		}finally {
			dbManager.valid(con, ps, rs);
		}
	}



	public ArrayList<BookDTO> listBook() throws SQLException {
		try {
			String sql = "select * from book";
			con = dbManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<BookDTO> list = makeArrayList(rs);
			return list;
		}finally {
			dbManager.valid(con, ps, rs);
		}
	}

	public int deleteBook(String bookname) throws SQLException {
		try {
			String sql ="delete from book where bookname = ?";
			con = dbManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bookname);
			int res = ps.executeUpdate();
			return res;
		}finally {
			dbManager.valid(con, ps, rs);
		}
	}

	public ArrayList<BookDTO> findBook(String search, String searchString) throws SQLException{
		try {
			String sql = "select * from book where  "+search+" = ?";
			con = dbManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, searchString);
			rs = ps.executeQuery();
			ArrayList<BookDTO> find = makeArrayList(rs);
			return find;
		}finally {
			dbManager.valid(con, ps, rs);
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
}











