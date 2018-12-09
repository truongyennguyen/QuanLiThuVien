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

import QuanLyThuVien.model.DAL.DALPhongPhucVu;
import QuanLyThuVien.model.DAL.Object.PhongPhucVu;

public class BLLPhongPhucVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALPhongPhucVu dal_phongPhucVu;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_phongPhucVu = new DALPhongPhucVu(jdbcURL);
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
			case "/PhongPhucVuQuanLy/insert":
				insertPhongPhucVu(request, response);
				break;
			case "/PhongPhucVuQuanLy/delete":
				deletePhongPhucVu(request, response);
				break;
			case "/PhongPhucVuQuanLy/update":
				updatePhongPhucVu(request, response);
				break;
			default: // list
				listPhongPhucVu(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void listPhongPhucVu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<PhongPhucVu> listPhongPhucVu = new ArrayList<PhongPhucVu>();

		try {
			listPhongPhucVu = dal_phongPhucVu.getAll();
			request.setAttribute("listPhongPhucVu", listPhongPhucVu);
			RequestDispatcher dispatcher = request.getRequestDispatcher("PhongPhucVuQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatePhongPhucVu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PhongPhucVu record = new PhongPhucVu();

		record.setIdPhong(Integer.parseInt(request.getParameter("txtidPhong")));
		record.setTenPhong(request.getParameter("txtTenPhong"));
		//.setGioBatDau(Integer.parseInt(request.getParameter("txtGioBatDau")));
		//record.setGioKetThuc(request.getParameter("txtGioKetThuc"));
		record.setMaNhanVien(Integer.parseInt(request.getParameter("txtMaNhanVien")));

		try {
			dal_phongPhucVu.Update(record);
			response.sendRedirect("/QuanLyThuVien/PhongPhucVuQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}

	private void deletePhongPhucVu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maPhongPhucVu"));

		try {
			dal_phongPhucVu.Delete(code);
			response.sendRedirect("/QuanLyThuVien/PhongPhucVuQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void insertPhongPhucVu(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PhongPhucVu record = new PhongPhucVu();

		record.setIdPhong(Integer.parseInt(request.getParameter("txtidPhong")));
		record.setTenPhong(request.getParameter("txtTenPhong"));
		//record.setGioBatDau(Integer.parseInt(request.getParameter("txtGioBatDau")));--sai biến time--
		//record.setGioKetThuc(request.getParameter("txtGioKetThuc"));-- sai biến time=--Á
		record.setMaNhanVien(Integer.parseInt(request.getParameter("txtMaNhanVien")));

		try {
			dal_phongPhucVu.Add(record);
			response.sendRedirect("/QuanLyThuVien/PhongPhucVuQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
