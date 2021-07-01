package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import PhieuModel.Phieu;

public class PhieuDAO {
	
	Connection cnn = null;
	private String url;
	private String user;
	private String pass;

	public PhieuDAO(String _url, String _user, String _pass) {
		url = _url;
		user = _user;
		pass = _pass;
	}
	protected Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnn = DriverManager.getConnection(url, user, pass);
			System.out.println("Ket noi csdl");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnn;
	}
	
public void closeConnection() throws SQLException {
		if(cnn != null || !cnn.isClosed())
		{
			cnn.close();
		}
		
	}

public List<Phieu> getAllPhieu() throws SQLException
{
	List<Phieu> list= new ArrayList<Phieu>();
	String sql  = "select * from `phieu1`";
	getConnection();
	Statement statement = (Statement) cnn.createStatement();
	ResultSet rs = statement.executeQuery(sql);
	while(rs.next())
	{
		Phieu phieu = new Phieu();
		phieu.setId(rs.getInt(1));
		phieu.setTenSP(rs.getString(2));
		phieu.setLoaiSP(rs.getString(3));
		phieu.setTrangThai(rs.getString(4));
		phieu.setIdKho(rs.getString(5));
		phieu.setIdcuaHang(rs.getString(6));
		phieu.setSoLuong(rs.getInt(7));
		phieu.setNgayThang(rs.getString(8));
		list.add(phieu);
		
	}
	cnn.close();
	
	return list;
}

public List<Phieu> search(String s) throws SQLException {
	List<Phieu> list = new ArrayList<Phieu>();
	String sql = "SELECT * FROM `phieu1` WHERE `tensp` LIKE '%"+s+"%'";
	getConnection();
	Phieu phieu = null;
	PreparedStatement statement = cnn.prepareStatement(sql);
	ResultSet rs = statement.executeQuery();
	System.out.println("data: "+s);
	while(rs.next())
	{
		int id = rs.getInt(1);
		String tensp = rs.getString(2);
		String loaisp = rs.getString(3);
		String trangthai = rs.getString(4);
		String idkho = rs.getString(5);
		String idcuahang = rs.getString(6);
		int soluong = rs.getInt(7);
		String ngaythang = rs.getString(8);
		phieu = new Phieu(id, tensp, loaisp, trangthai, idkho, idcuahang, soluong, ngaythang);
		list.add(phieu);
	}
	System.out.println("tim thanh cong!");
	cnn.close();
	statement.close();
	return list;
}

public boolean Insert(Phieu phieu)throws SQLException { // theo cach gege
	
	getConnection();
	
	String sql = "INSERT INTO `phieu1`( `tensp`, `loaisp`, `trangthai`, `idkho`, `idcuahang`, `soluong`, `ngaythang`) VALUES (?,?,?,?,?,?,?)";
	System.out.println("Ham insert nhan dc data");
	PreparedStatement statement = cnn.prepareStatement(sql);
	
	statement.setString(1,phieu.getTenSP());
	statement.setString(2,phieu.getLoaiSP());
	statement.setString(3,phieu.getTrangThai());
	statement.setString(4,phieu.getIdKho());
	statement.setString(5,phieu.getIdcuaHang());
	statement.setInt(6, phieu.getSoLuong());
	statement.setString(7, phieu.getNgayThang());
	
	System.out.println("Ham insert nhan dc data:");
	System.out.println(""+phieu.getTenSP());
	System.out.println(""+phieu.getLoaiSP());
	System.out.println(""+phieu.getTrangThai());
	System.out.println(""+phieu.getSoLuong());
	System.out.println(""+phieu.getNgayThang());
	
	boolean InsertData = statement.executeUpdate() >0;
	cnn.close();
	statement.close();
	System.out.println("thanh cong");
	return InsertData;
	
}

public Phieu selectPhieu(int id) throws SQLException { //code tu viet đầu tiên
	getConnection();
	Phieu phieu = null;
	System.out.println("select id: "+id);
	String sql = "SELECT * FROM `phieu1` WHERE `id`="+id;
	PreparedStatement statement = cnn.prepareStatement(sql);
	ResultSet rs = statement.executeQuery();
	while (rs.next()) {
		String tenSP = rs.getString(2);
		String loaiSP = rs.getString(3);
		String trangThai = rs.getString(4);
		String idkho = rs.getString(5);
		String idcuahang = rs.getString(6);
		int soLuong = rs.getInt(7);
		String ngayThang = rs.getString(8);
		phieu = new Phieu(id, tenSP, loaiSP, trangThai, idkho, idcuahang, soLuong, ngayThang);
		
	}
	cnn.close();
	statement.close();
	return phieu;
	
}
//Search.....

public List<Phieu> searchPhieu(String s) throws SQLException {
	List<Phieu> list = new ArrayList<Phieu>();
	//String sql = "SELECT * FROM `phieu1` WHERE `tensp` LIKE '%"+s+"%'";
	String sql ="SELECT * FROM `phieu1` WHERE `tensp` LIKE `"+s+"`";
	System.out.println("DAO nhan dc search:"+s);
	getConnection();
	Phieu phieu = null;
	PreparedStatement statement = cnn.prepareStatement(sql);
	ResultSet rs = statement.executeQuery();
	while(rs.next())
	{
		int id = rs.getInt(1);
		String tensp = rs.getString(2);
		String loaisp = rs.getString(3);
		String trangthai = rs.getString(4);
		String idkho = rs.getString(5);
		String idcuahang = rs.getString(6);
		int soluong = rs.getInt(7);
		String ngaythang = rs.getString(8);
		phieu = new Phieu(id, tensp, loaisp, trangthai, idkho, idcuahang, soluong, ngaythang);
		list.add(phieu);
		
	}
	System.out.println("Tim kiem thanh cong!");
	cnn.close();
	statement.close();
	return list;
}
public boolean delete(int id) throws SQLException {
	String sql = "DELETE FROM `phieu1` WHERE `id`="+id+"";
	getConnection();
	System.out.println("Xoa id: "+id);
	PreparedStatement statement = cnn.prepareStatement(sql);
	boolean x = statement.executeUpdate()>0;
	System.out.println("Xoa thanh cong! ");
	cnn.close();
	statement.close();
	return x;
}

public boolean updatePhieu(Phieu phieu) throws SQLException {
	//String sql = "UPDATE `phieu` SET tenSP=?, loaiSP=?, trangThai=? WHERE id =?";
	String sql="UPDATE `phieu1` SET `tensp`=?,`loaisp`=?,`trangthai`=?,`idkho`=?,`idcuahang`=?,`soluong`=?,`ngaythang`=? WHERE `id`=?";
	getConnection();
	PreparedStatement statement = cnn.prepareStatement(sql);
	statement.setString(1,phieu.getTenSP());
	statement.setString(2, phieu.getLoaiSP());
	statement.setString(3, phieu.getTrangThai());
	statement.setString(4, phieu.getIdKho());
	statement.setString(5, phieu.getIdcuaHang());
	statement.setInt(6, phieu.getSoLuong());
	statement.setString(7, phieu.getNgayThang());
	statement.setInt(8, phieu.getId());
	
	System.out.println("DAO update nhan dc data:");
	System.out.println("id :"+phieu.getIdKho());
	System.out.println("ten:"+phieu.getTenSP());
	System.out.println("loai:"+phieu.getLoaiSP());
	System.out.println("trang thai:"+phieu.getTrangThai());
	System.out.println("so luong:"+phieu.getSoLuong());
	System.out.println("ngay thang:"+phieu.getNgayThang());
	System.out.println("id:"+phieu.getId());
	
	
	boolean x = statement.executeUpdate() >0;
	cnn.close();
	statement.close();
	return x;
}
}
