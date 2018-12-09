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

import QuanLyThuVien.model.DAL.DALMuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;

public class BLLMuonTraSachChiTiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALMuonTraSachChiTiet dal_muonTraSachChiTiet;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_muonTraSachChiTiet = new DALMuonTraSachChiTiet(jdbcURL);
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
			case "/MuonTraSachChiTietQuanLy/insert":
				insertMuonTraSachChiTiet(request, response);
				break;
			case "/MuonTraSachChiTietQuanLy/delete":
				deleteMuonTraSachChiTiet(request, response);
				break;
			case "/MuonTraSachChiTietQuanLy/update":
				updateMuonTraSachChiTiet(request, response);
				break;
			default: // list
				listMuonTraSachChiTiet(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void listMuonTraSachChiTiet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<MuonTraSachChiTiet> listMuonTraSachChiTiet = new ArrayList<MuonTraSachChiTiet>();

		try {
			listMuonTraSachChiTiet = dal_muonTraSachChiTiet.getAll();
			request.setAttribute("listMuonTraSachChiTiet", listMuonTraSachChiTiet);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MuonTraSachChiTietQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void updateMuonTraSachChiTiet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		MuonTraSachChiTiet record = new MuonTraSachChiTiet();
		record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonTra")));
		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setSoLuong(Integer.parseInt(request.getParameter("txtSoLuong")));

		try {
			dal_muonTraSachChiTiet.Update(record);
			response.sendRedirect("/QuanLyThuVien/MuonTraSachChiTietQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}

	private void deleteMuonTraSachChiTiet(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maMuonSach"));

		try {
			dal_muonTraSachChiTiet.Delete(code);
			response.sendRedirect("/QuanLyThuVien/DauSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertMuonTraSachChiTiet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		MuonTraSachChiTiet record = new MuonTraSachChiTiet();
		record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonTra")));
		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setSoLuong(Integer.parseInt(request.getParameter("txtSoLuong")));

		try {
			dal_muonTraSachChiTiet.Add(record);
			response.sendRedirect("/QuanLyThuVien/MuonTraSachChiTietQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
