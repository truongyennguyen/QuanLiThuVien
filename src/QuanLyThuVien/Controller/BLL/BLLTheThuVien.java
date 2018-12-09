package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALTheThuVien;
import QuanLyThuVien.model.DAL.Object.TheThuVien;

public class BLLTheThuVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALTheThuVien dal_theThuVien;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_theThuVien = new DALTheThuVien(jdbcURL);
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
			case "/TheThuVienQuanLy/insert":
				insertTheThuVien(request, response);
				break;
			case "/TheThuVienQuanLy/delete":
				deleteTheThuVien(request, response);
				break;
			case "/TheThuVienQuanLy/update":
				updateTheThuVien(request, response);
				break;
			default: // list
				listTheThuVien(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void listTheThuVien(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void updateTheThuVien(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TheThuVien record = new TheThuVien();

		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		record.setMaDocGia(Integer.parseInt(request.getParameter("txtMaDocGia")));
		//record.setNgayCapThe(Integer.parseInt(request.getParameter("txtNgayCapThe")));-sai biến date--
		//record.setNgayHetHan(request.getParameter("txtNgayHetHan"));-sai biến date--
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setSoSachDuocMuon(Integer.parseInt(request.getParameter("txtSoSachDuocMuon")));
		record.setSoSachDangMuon(Integer.parseInt(request.getParameter("txtSoSachDangMuon")));


		try {
			dal_theThuVien.Update(record);
			response.sendRedirect("/QuanLyThuVien/TheThuVienQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteTheThuVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maTheThuVien"));

		try {
			dal_theThuVien.Delete(code);
			response.sendRedirect("/QuanLyThuVien/TheThuVienQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void insertTheThuVien(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TheThuVien record = new TheThuVien();


		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		record.setMaDocGia(Integer.parseInt(request.getParameter("txtMaDocGia")));
		//record.setNgayCapThe(Integer.parseInt(request.getParameter("txtNgayCapThe")));-sai biến date--
		//record.setNgayHetHan(request.getParameter("txtNgayHetHan"));-sai biến date--S
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setSoSachDuocMuon(Integer.parseInt(request.getParameter("txtSoSachDuocMuon")));
		record.setSoSachDangMuon(Integer.parseInt(request.getParameter("txtSoSachDangMuon")));

		try {
			dal_theThuVien.Add(record);
			response.sendRedirect("/QuanLyThuVien/TheThuVienQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
