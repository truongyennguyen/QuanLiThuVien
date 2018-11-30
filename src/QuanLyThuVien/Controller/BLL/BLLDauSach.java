package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import QuanLyThuVien.model.DAL.DALDauSach;
import QuanLyThuVien.model.DAL.Object.DauSach;

/**
 * BLLdal_dauSach.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @author IT1006
 */
@WebServlet(name = "DauSachQuanLy", urlPatterns = { "/DauSachQuanLy/delete", "/DauSachQuanLy", "/DauSachQuanLy/list",
		"/DauSachQuanLy/insert", "/DauSachQuanLy/update", "/DauSachQuanLy/new", "/DauSachQuanLy/edit" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BLLDauSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALDauSach dal_dauSach;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_dauSach = new DALDauSach(jdbcURL);
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
			case "/DauSachQuanLy/new":
				showNewForm(request, response);
				break;
			case "/DauSachQuanLy/insert":
				insertDauSach(request, response);
				break;
			case "/DauSachQuanLy/delete":
				deleteDauSach(request, response);
				break;
			case "/DauSachQuanLy/edit":
				showEditForm(request, response);
				break;
			case "/DauSachQuanLy/update":
				updateDauSach(request, response);
				break;
			default: // list
				listDauSach(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<DauSach> listDauSach = new ArrayList<DauSach>();

		try {
			listDauSach = dal_dauSach.getAll();
			request.setAttribute("listDauSach", listDauSach);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DauSachQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLiThuVien/DauSachForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("maDauSach"));
		DauSach DauSach = new DauSach();
		try {
			DauSach = dal_dauSach.GetOne(code);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DauSachForm.jsp");
			request.setAttribute("DauSachEdit", DauSach);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		DauSach record = new DauSach();

		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		record.setMaNxb(Integer.parseInt(request.getParameter("txtMaNxb")));
		record.setMaTheLoai(Integer.parseInt(request.getParameter("txtMaTheLoai")));
		record.setTenSach(request.getParameter("txtTenSach"));
		record.setMoTa(request.getParameter("txtMoTa"));
		record.setTacGia(request.getParameter("txtTacGia"));
//		Part part = (Part) request.getParts();
//		InputStream is = part.getInputStream();
//		record.setAnhTacGia(is);
		byte[] anhTacGia = new byte[8096];
		record.setAnhTacGia(anhTacGia);
		if (request.getParameter("dateNamXuatBan") != null) {
			try {
				Date namXuatBan = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNamXuatBan"));
				record.setNamXuatBan(new java.sql.Date(namXuatBan.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setNgonNgu(request.getParameter("txtNamXuatBan"));
		byte[] anhBia = new byte[8096];
		record.setAnhBia(anhBia);
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setGia(Float.parseFloat(request.getParameter("numberGia")));
		Blob filePDF = null;
		record.setFilePDF(filePDF);

		try {
			dal_dauSach.Add(record);
			response.sendRedirect("/QuanLiThuVien/DauSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		DauSach record = new DauSach();

		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		record.setMaNxb(Integer.parseInt(request.getParameter("txtMaNxb")));
		record.setMaTheLoai(Integer.parseInt(request.getParameter("txtMaTheLoai")));
		record.setTenSach(request.getParameter("txtTenSach"));
		record.setMoTa(request.getParameter("txtMoTa"));
		record.setTacGia(request.getParameter("txtTacGia"));
//		Part part = (Part) request.getParts();
//		InputStream is = part.getInputStream();
//		record.setAnhTacGia(is);
		byte[] anhTacGia = new byte[8096];
		record.setAnhTacGia(anhTacGia);
		if (request.getParameter("dateNamXuatBan") != null) {
			try {
				Date namXuatBan = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNamXuatBan"));
				record.setNamXuatBan(new java.sql.Date(namXuatBan.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setNgonNgu(request.getParameter("txtNamXuatBan"));
		byte[] anhBia = new byte[8096];
		record.setAnhBia(anhBia);
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setGia(Float.parseFloat(request.getParameter("numberGia")));
		Blob filePDF = null;
		record.setFilePDF(filePDF);

		try {
			dal_dauSach.Update(record);
			response.sendRedirect("/QuanLiThuVien/DauSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maDauSach"));// id này chính là id của request gửi tới

		try {
			dal_dauSach.Delete(code);
			response.sendRedirect("/QuanLiThuVien/DauSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
