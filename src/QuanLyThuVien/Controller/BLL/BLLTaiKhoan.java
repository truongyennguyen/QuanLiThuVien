package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALTaiKhoan;
import QuanLyThuVien.model.DAL.Object.PhongPhucVu;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;

public class BLLTaiKhoan extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private DALTaiKhoan dal_taiKhoan;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_taiKhoan = new DALTaiKhoan(jdbcURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
			case "/TaiKhoanQuanLy/insert":
				insertTaiKhoan(request, response);
				break;
			case "/TaiKhoanQuanLy/delete":
				deleteTaiKhoan(request, response);
				break;
			case "/TaiKhoanQuanLy/update":
				updateTaiKhoan(request, response);
				break;
			default: // list
				listTaiKhoan(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void listTaiKhoan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();

		try {
			listTaiKhoan = dal_taiKhoan.getAll();
			request.setAttribute("listPhongPhucVu", listTaiKhoan);
			RequestDispatcher dispatcher = request.getRequestDispatcher("PhongPhucVuQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void updateTaiKhoan(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		TaiKhoan record = new TaiKhoan();
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));
		record.seteMail(request.getParameter("txteMail"));
		record.setSoDienThoai(Integer.parseInt(request.getParameter("txtSoDienThoai")));
		record.setMatKhau(request.getParameter("txtMatKhau"));
		record.setAvartar(request.getParameter("txtAvartar"));
		record.setIdQuyen(Integer.parseInt(request.getParameter("txtIQuyen")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));

		try {
			dal_taiKhoan.Update(record);
			response.sendRedirect("/QuanLyThuVien/TaiKhoanQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}

	private void deleteTaiKhoan(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maTaiKhoan"));

		try {
			dal_taiKhoan.Delete(code);
			response.sendRedirect("/QuanLyThuVien/TaiKhoanQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertTaiKhoan(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TaiKhoan record = new TaiKhoan();
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));
		record.seteMail(request.getParameter("txteMail"));
		record.setSoDienThoai(Integer.parseInt(request.getParameter("txtSoDienThoai")));
		record.setMatKhau(request.getParameter("txtMatKhau"));
		record.setAvartar(request.getParameter("txtAvartar"));
		record.setIdQuyen(Integer.parseInt(request.getParameter("txtIQuyen")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		try {
			dal_taiKhoan.Add(record);
			response.sendRedirect("/QuanLyThuVien/TaiKhoanQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
