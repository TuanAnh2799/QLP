package PhieuModel;

public class Phieu {
	
	private int id;
	private String tenSP;
	private String loaiSP;
	private String trangThai;
	private String idKho;
	private String idcuaHang;
	private int soLuong;
	private String ngayThang;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getLoaiSP() {
		return loaiSP;
	}
	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getIdKho() {
		return idKho;
	}
	public void setIdKho(String idKho) {
		this.idKho = idKho;
	}
	public String getIdcuaHang() {
		return idcuaHang;
	}
	public void setIdcuaHang(String idcuaHang) {
		this.idcuaHang = idcuaHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getNgayThang() {
		return ngayThang;
	}
	public void setNgayThang(String ngayThang) {
		this.ngayThang = ngayThang;
	}
	
	
	public Phieu(String tenSP, String loaiSP, String trangThai, String idKho, String idcuaHang,int soLuong, String ngayThang) {
		super();
		this.tenSP = tenSP;
		this.loaiSP = loaiSP;
		this.trangThai = trangThai;
		this.idKho = idKho;
		this.idcuaHang = idcuaHang;
		this.soLuong = soLuong;
		this.ngayThang = ngayThang;
	}
	public Phieu(int id, String tenSP, String loaiSP, String trangThai, String idKho, String idcuaHang, int soLuong,
			String ngayThang) {
		super();
		this.id = id;
		this.tenSP = tenSP;
		this.loaiSP = loaiSP;
		this.trangThai = trangThai;
		this.idKho = idKho;
		this.idcuaHang = idcuaHang;
		this.soLuong = soLuong;
		this.ngayThang = ngayThang;
	}
	public Phieu() {
		
	}
}
