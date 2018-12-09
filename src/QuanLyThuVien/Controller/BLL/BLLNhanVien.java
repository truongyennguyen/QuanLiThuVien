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

import QuanLyThuVien.model.DAL.DALNhanVien;
import QuanLyThuVien.model.DAL.Object.NhanVien;

public class BLLNhanVien extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private DALNhanVien dal_nhanVien;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_nhanVien = new DALNhanVien(jdbcURL);
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
			case "/NhanVienQuanLy/insert":
				insertNhanVien(request, response);
				break;
			case "/NhanVienQuanLy/delete":
				deleteNhanVien(request, response);
				break;
			case "/NhanVienQuanLy/update":
				updateNhanVien(request, response);
				break;
			default: // list
				listNhanVien(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void listNhanVien(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException, ServletException {

			List<NhanVien> listNhanVien = new ArrayList<NhanVien>();

			try {
				listNhanVien = dal_nhanVien.getAll();
				request.setAttribute("listNhanVien", listNhanVien);
				RequestDispatcher dispatcher = request.getRequestDispatcher("NhanVienQuanLy.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}

	private void updateNhanVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		NhanVien record = new NhanVien();

		record.setMaNhanVien(Integer.parseInt(request.getParameter("txtMaNhanVien")));
		record.setHoVaTen(request.getParameter("txtHoVaTen"));
		record.setEmail(request.getParameter("txtEmail"));
		record.setSoDienThoai(request.getParameter("txtSoDienThoai"));
		//record.setNgaySinh(request.getDateInstance("txtNgaySinh"));-- sai chỗ date/--
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));

		try {
			dal_nhanVien.Update(record);
			response.sendRedirect("/QuanLyThuVien/NhanVienQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maNhanVien"));

		try {
			dal_nhanVien.Delete(code);
			response.sendRedirect("/QuanLyThuVien/NhanVienQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertNhanVien(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		NhanVien record = new NhanVien();
		record.setMaNhanVien(Integer.parseInt(request.getParameter("txtMaNhanVien")));
		record.setHoVaTen(request.getParameter("txtHoVaTen"));
		record.setEmail(request.getParameter("txtEmail"));
		record.setSoDienThoai(request.getParameter("txtSoDienThoai"));
		//record.setNgaySinh(request.getParameter("txtNgaySinh"));-- sai chỗ ngày --S
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));
		try {
			dal_nhanVien.Add(record);
			response.sendRedirect("/QuanLyThuVien/NhanVienQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
