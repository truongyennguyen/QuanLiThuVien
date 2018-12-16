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

import QuanLyThuVien.model.DAL.DALNhanVien;
import QuanLyThuVien.model.DAL.Object.NhanVien;
import QuanLyThuVien.model.DAL.Object.NhanVien;
@WebServlet(name = "NhanVienQuanLy", urlPatterns = { "/NhanVienQuanLy", "/NhanVienQuanLy/delete", "/NhanVienQuanLy/list",
		"/NhanVienQuanLy/insert", "/NhanVienQuanLy/update", "/NhanVienQuanLy/edit", "/NhanVienDanhSach",
		"/NhanVienNoiDung" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
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
			case "/NhanVienQuanLy/edit":
				editNhanVien(request, response);
				break;
			default: // list
				listNhanVien(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void editNhanVien(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("maNhanVien"));

		try {
			NhanVien nhanVien = new NhanVien();
			nhanVien = dal_nhanVien.GetOne(code);
			request.setAttribute("nhanVienIU", nhanVien);
			request.getRequestDispatcher("/NhanVien").forward(request, response);
			;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}

	private void listNhanVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
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
			total = dal_nhanVien.getSoLuongPhanTu(0, search);
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
			maxCode = dal_nhanVien.maxCode("NhanVien");
			listNhanVien = dal_nhanVien.getAllPhanTrang(minRes, maxRes, 0, sort, search);
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listNhanVien", listNhanVien);
			RequestDispatcher dispatcher = request.getRequestDispatcher("NhanVien.jsp");
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
		if (request.getParameter("dateNgaySinh") != null) {
			try {
				Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgaySinh"));
				record.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
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
		if (request.getParameter("dateNgaySinh") != null) {
			try {
				Date ngayMuon = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgaySinh"));
				record.setNgaySinh(new java.sql.Date(ngayMuon.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));
		try {
			dal_nhanVien.Add(record);
			response.sendRedirect("/QuanLyThuVien/NhanVienQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
