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

import QuanLyThuVien.model.DAL.DALTaiKhoan;
import QuanLyThuVien.model.DAL.Object.PhongPhucVu;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;
@WebServlet(name = "TaiKhoanQuanLy", urlPatterns = { "/TaiKhoanQuanLy", "/TaiKhoanQuanLy/delete", "/TaiKhoanQuanLy/list",
		"/TaiKhoanQuanLy/insert", "/TaiKhoanQuanLy/update", "/TaiKhoanQuanLy/edit", "/TaiKhoanDanhSach",
		"/TaiKhoanNoiDung" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
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
			case "/TaiKhoanQuanLy/edit":
				editTaiKhoan(request, response);
				break;
			default: // list
				listTaiKhoan(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void editTaiKhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("maTaiKhoan"));

		try {
			TaiKhoan taiKhoan = new TaiKhoan();
			 taiKhoan = dal_taiKhoan.GetOne(code);
			request.setAttribute(" taiKhoanIU",  taiKhoan);
			request.getRequestDispatcher("/TaiKhoan").forward(request, response);
			;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void listTaiKhoan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<TaiKhoan> listtaiKhoan = new ArrayList<TaiKhoan>();
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
			total = dal_taiKhoan.getSoLuongPhanTu(0, search);
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
			maxCode = dal_taiKhoan.maxCode("TaiKhoan");
			listtaiKhoan = dal_taiKhoan.getAllPhanTrang(minRes, maxRes, 0, sort, search);
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listTaiKhoan", listtaiKhoan);
			RequestDispatcher dispatcher = request.getRequestDispatcher("TaiKhoan.jsp");
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
