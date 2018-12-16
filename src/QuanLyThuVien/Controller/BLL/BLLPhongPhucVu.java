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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALPhongPhucVu;
import QuanLyThuVien.model.DAL.Object.PhongPhucVu;
@WebServlet(name = "PhongPhucVuQuanLy", urlPatterns = { "/PhongPhucVuQuanLy", "/PhongPhucVuQuanLy/delete", "/PhongPhucVuQuanLy/list",
		"/PhongPhucVuQuanLy/insert", "/PhongPhucVuQuanLy/update", "/PhongPhucVuQuanLy/edit", "/PhongPhucVuDanhSach",
		"/PhongPhucVuNoiDung" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
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
			case "/PhongPhucVuQuanLy/edit":
				editPhongPhucVu(request, response);
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

	private void editPhongPhucVu(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("PhongPhucVu"));

		try {
			PhongPhucVu phongPhucVu = new PhongPhucVu();
			phongPhucVu = dal_phongPhucVu.GetOne(code);
			request.setAttribute("phongPhucVuIU", phongPhucVu);
			request.getRequestDispatcher("/phongPhucVuQuanLy").forward(request, response);
			;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listPhongPhucVu(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<PhongPhucVu> listPhongPhucVu = new ArrayList<PhongPhucVu>();
		int pages = 0, minRes = 0, maxRes = 0, total = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}
		String search = "default";
		if (request.getParameter("txtSearch") != null) {
			search = request.getParameter("txtSearch");
		}
		String sort = "default";
		if (request.getParameter("selectSort") != null) {
			sort = request.getParameter("selectSort");
		}
		try {
			total = dal_phongPhucVu.getSoLuongPhanTu(0, search);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if (total <= 6) {
			minRes = 1;
			maxRes = total;
		} else {
			minRes = (pages - 1) * 6 + 1;
			maxRes = minRes + 6 - 1;
		}

		int soTrang = 0;
		if (total % 6 == 0) {
			soTrang = (int) (total / 6);
		} else {
			soTrang = (int) (total / 6) + 1;
		}

		int maxCode = 0;
		try {
			maxCode = dal_phongPhucVu.maxCode("PhongPhucVu");
			listPhongPhucVu = dal_phongPhucVu.getAllPhanTrang(minRes, maxRes, 0, sort, search);
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
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
