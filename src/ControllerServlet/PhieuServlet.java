package ControllerServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PhieuDAO;
import PhieuModel.Phieu;


 @WebServlet(urlPatterns = {"/"})
 
public class PhieuServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	//khai bao
	
	PhieuDAO bd;

	public PhieuServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		String url = "jdbc:mysql://localhost:3306/qlp";
		String user="root";
		String pass ="";
		bd = new PhieuDAO(url, user, pass);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
			case "/list":
				listPhieu(request, response);
				break;
			case "/new":
				newForm(request, response);
				break;
				
			case "/insert":
				insertPhieu(request, response);
				break;
			case "/delete":
				delete(request, response);
				break;
			case "/edit":
				//showEditForm(request, response);
				editForm(request, response);
				break;
			case "/update":
				updatePhieu(request, response);
				break;
			case "/search":
				listPhieuSearch(request, response);
				break;
				
			default:
				listPhieu(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
	}
	
	private void listPhieu(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
		try {
			
			List<Phieu> listphieu = bd.getAllPhieu();
			request.setAttribute("listPhieu", listphieu); //truyn du lieu listBook sang file jsp
			//Sử dụng đối tượng RequestDispatcher trong java servlet  để phân phối các request
			//từ client đến các nguồn tài nguyên khác nhau trên server và trả về response
			RequestDispatcher dispatcher= request.getRequestDispatcher("ListPhieu.jsp");
			//chuyển tiếp yêu cầu là chuyển đến tài nguyên khác trong cùng một máy chủ để tiếp tục xử lý.
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void newForm(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("PhieuForm.jsp");
		dispatcher.forward(request, response);
	}
	//Search------------------------------------------------
	private void listPhieuSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String src = request.getParameter("src");
		System.out.println("Tìm: "+src);
		List<Phieu> listphieu = bd.search(src);
		request.setAttribute("listPhieu", listphieu);
		RequestDispatcher dispatcher= request.getRequestDispatcher("ListPhieu.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertPhieu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

		String tenSP = request.getParameter("tenSP");
		String loaiSP = request.getParameter("loaiSP");
		String trangThai = request.getParameter("trangThai");
		String idKho = request.getParameter("idKho");
		String idcuaHang = request.getParameter("idcuaHang");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		String ngayThang = request.getParameter("ngayThang");
		Phieu phieu = new Phieu(tenSP, loaiSP, trangThai, idKho, idcuaHang, soLuong, ngayThang);

		System.out.println("ten: "+tenSP);
		System.out.println("loai: "+loaiSP);
		System.out.println("tt: "+trangThai);
		System.out.println("soluong: "+soLuong);
		System.out.println("ngaythang: "+ngayThang);
		bd.Insert(phieu);
		System.out.println("insert thanh cong");
		response.sendRedirect("list");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));	
		System.out.println("id: "+id);
		bd.delete(id);
		System.out.println("Xoa thanh cong!");
		//chuyển hướng đến tài nguyên khác như tên miền khác hoặc các đường dẫn là các máy chủ khác
		response.sendRedirect("list");
	}
	
	private void updatePhieu(HttpServletRequest request, HttpServletResponse response)  //tu viết
			throws SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));	
		String ten = request.getParameter("tenSP");
		String loai = request.getParameter("loaiSP");
		String trangT = request.getParameter("trangThai");
		String idKho = request.getParameter("idKho");
		String idcuaHang = request.getParameter("idcuaHang");
		int soL = Integer.parseInt(request.getParameter("soLuong"));
		String ngay = request.getParameter("ngayThang");
		Phieu phieu = new Phieu(id, ten, loai, trangT, idKho, idcuaHang, soL, ngay);
		bd.updatePhieu(phieu);
		response.sendRedirect("list");
	}
	
	
	private void editForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException, SQLException{ //code gốc
		int id = Integer.parseInt(request.getParameter("id"));	
		Phieu phieu = bd.selectPhieu(id);
		request.setAttribute("phieu",phieu);
		RequestDispatcher dispatcher=request.getRequestDispatcher("PhieuForm.jsp");
		dispatcher.forward(request, response);		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}