package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.PagesPerMinute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import QuanLyThuVien.model.DAL.DALDauSach;
import QuanLyThuVien.model.DAL.DALNxb;
import QuanLyThuVien.model.DAL.DALTheLoai;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.TheLoai;

/**
 * BLLdal_dauSach.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @author IT1006
 */
@WebServlet(name = "DauSachQuanLy", urlPatterns = { "/DauSachQuanLy", "/DauSachQuanLy/delete", "/DauSachQuanLy/list",
		"/DauSachQuanLy/insert", "/DauSachQuanLy/update", "/DauSachQuanLy/edit", "/DauSachDanhSach",
		"/DauSachNoiDung" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BLLDauSach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DALDauSach dal_dauSach;
	private DALNxb dal_nxb;
	private DALTheLoai dal_theLoai;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_dauSach = new DALDauSach(jdbcURL);
			dal_nxb = new DALNxb(jdbcURL);
			dal_theLoai = new DALTheLoai(jdbcURL);

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
		try {
			switch (action) {
			case "/DauSachQuanLy/insert":
				insertDauSach(request, response);
				break;
			case "/DauSachQuanLy/delete":
				deleteDauSach(request, response);
				break;
			case "/DauSachQuanLy/update":
				updateDauSach(request, response);
				break;
			case "/DauSachQuanLy/edit":
				editDauSach(request, response);
				break;
			case "/DauSachDanhSach":
				listDauSachDanhSachPhanTrang(request, response);
				break;
			case "/DauSachNoiDung":
				dauSachNoiDung(request, response);
				break;
			default:
				listDauSach(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Nxb> listNxb = new ArrayList<Nxb>();
		List<TheLoai> listTheLoai = new ArrayList<TheLoai>();
		List<DauSach> listDauSach = new ArrayList<DauSach>();

		int pages = 0, minRes = 0, maxRes = 0, total = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			total = dal_dauSach.getSoLuongPhanTu(0, "default");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if (total <= 5) {
			minRes = 1;
			maxRes = total;
		} else {
			minRes = (pages - 1) * 5 + 1;
			maxRes = minRes + 5 - 1;
		}

		int soTrang = (int) (total / 5) + 1;

		try {
			listDauSach = dal_dauSach.getAllPhanTrang(minRes, maxRes, 0, "default", "default");
			listNxb = dal_nxb.getAll();
			listTheLoai = dal_theLoai.getAll();
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listDauSach", listDauSach);
			request.setAttribute("listTheLoai", listTheLoai);
			request.setAttribute("listNxb", listNxb);

			request.getRequestDispatcher("DauSachQuanLy.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void listDauSachDanhSachPhanTrang(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Nxb> listNxb = new ArrayList<Nxb>();
		List<TheLoai> listTheLoai = new ArrayList<TheLoai>();
		List<DauSach> listDauSach = new ArrayList<DauSach>();

		int pages = 0, minRes = 0, maxRes = 0, total = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}
		int maTheLoai = 0;
		if (request.getParameter("maTheLoai") != null) {
			maTheLoai = (int) Integer.parseInt(request.getParameter("maTheLoai"));
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
			total = dal_dauSach.getSoLuongPhanTu(maTheLoai, search);
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

		int soTrang = (int) (total / 6) + 1;

		try {
			listDauSach = dal_dauSach.getAllPhanTrang(minRes, maxRes, maTheLoai, sort, search);
			listNxb = dal_nxb.getAll();
			listTheLoai = dal_theLoai.getAll();
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listDauSach", listDauSach);
			request.setAttribute("listTheLoai", listTheLoai);
			request.setAttribute("listNxb", listNxb);

			request.getRequestDispatcher("DauSachDanhSach.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void listDauSachDanhSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<DauSach> listDauSach = new ArrayList<DauSach>();
		try {
			listDauSach = dal_dauSach.getAll();
			request.setAttribute("listDauSach", listDauSach);

			request.getRequestDispatcher("DauSachDanhSach.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		DauSach record = new DauSach();

		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		// Chuyển cái tên của NXB và Thể loại từ Parameter txtMaNxb và txtMaTheLoai
		// thành số tương ứng
		try {
			record.setMaNxb((dal_dauSach.getMaNxb(request.getParameter("txtTenNxb"))).getMaNxb());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			record.setMaTheLoai((dal_dauSach.getMaTheLoai(request.getParameter("txtTenTheLoai"))).getMaTheLoai());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		record.setTenSach(request.getParameter("txtTenSach"));
		record.setMoTa(request.getParameter("txtMoTa"));
		record.setTacGia(request.getParameter("txtTacGia"));
		int i = 0;
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					InputStream is = part.getInputStream();
					if (i == 0) {
						record.setAnhBia(is);
						i++;
					} else if (i == 1) {
						record.setAnhTacGia(is);
						i++;
					} else if (i == 2) {
						record.setFilePDF(is);
						i++;
					}
				}
			}
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		if (request.getParameter("dateNamXuatBan") != null) {
			try {
				Date namXuatBan = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNamXuatBan"));
				record.setNamXuatBan(new java.sql.Date(namXuatBan.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setNgonNgu(request.getParameter("txtNgonNgu"));
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setGia(Integer.parseInt(request.getParameter("numberGia")));
		try {
			dal_dauSach.Add(record);
			response.sendRedirect("/QuanLyThuVien/DauSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		DauSach record = new DauSach();

		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		// Chuyển cái tên của NXB và Thể loại từ Parameter txtMaNxb và txtMaTheLoai
		// thành số tương ứng
		try {
			record.setMaNxb((dal_dauSach.getMaNxb(request.getParameter("txtTenNxb"))).getMaNxb());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			record.setMaTheLoai((dal_dauSach.getMaTheLoai(request.getParameter("txtTenTheLoai"))).getMaTheLoai());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		record.setTenSach(request.getParameter("txtTenSach"));
		record.setMoTa(request.getParameter("txtMoTa"));
		record.setTacGia(request.getParameter("txtTacGia"));
		int i = 0;
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					InputStream is = part.getInputStream();
					if (i == 0) {
						record.setAnhBia(is);
						i++;
					} else if (i == 1) {
						record.setAnhTacGia(is);
						i++;
					} else if (i == 2) {
						record.setFilePDF(is);
						i++;
					}
				}
			}
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		if (request.getParameter("dateNamXuatBan") != null) {
			try {
				Date namXuatBan = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNamXuatBan"));
				record.setNamXuatBan(new java.sql.Date(namXuatBan.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setNgonNgu(request.getParameter("txtNgonNgu"));
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setGia(Integer.parseInt(request.getParameter("numberGia")));
		try {
			dal_dauSach.Update(record);
			response.sendRedirect("/QuanLyThuVien/DauSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void editDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("maDauSach"));

		List<Nxb> listNxb = new ArrayList<Nxb>();
		List<TheLoai> listTheLoai = new ArrayList<TheLoai>();
		try {
			listNxb = dal_nxb.getAll();
			listTheLoai = dal_theLoai.getAll();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		request.setAttribute("listTheLoai", listTheLoai);
		request.setAttribute("listNxb", listNxb);

		try {
			DauSach dauSach = new DauSach();
			dauSach = dal_dauSach.GetOne(code);
			request.setAttribute("dauSachIU", dauSach);
			request.getRequestDispatcher("/DauSachQuanLy").forward(request, response);
			;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void dauSachNoiDung(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("maDauSach"));

		try {
			DauSach dauSach = new DauSach();
			dauSach = dal_dauSach.GetOne(code);
			request.setAttribute("dauSachDetail", dauSach);
			request.getRequestDispatcher("DauSachNoiDung.jsp").forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maDauSach"));

		try {
			dal_dauSach.Delete(code);
			response.sendRedirect("/QuanLyThuVien/DauSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private String extractFileName(Part part) {
		// form-data; name="file"; filename="C:\file1.zip"
		// form-data; name="file"; filename="C:\Note\file2.zip"
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				// C:\file1.zip
				// C:\Note\file2.zip
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				// file1.zip
				// file2.zip
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}
}
