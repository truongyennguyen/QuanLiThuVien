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

import QuanLyThuVien.model.DAL.DALMuonTraSach;
import QuanLyThuVien.model.DAL.Object.MuonTraSach;

public class BLLMuonTraSach  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private DALMuonTraSach dal_muonTraSach;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_muonTraSach = new DALMuonTraSach(jdbcURL);
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
			case "/MuonTraSachQuanLy/insert":
				insertMuonTraSach(request, response);
				break;
			case "/MuonTraSachQuanLy/delete":
				deleteMuonTraSach(request, response);
				break;
			case "/MuonTraSachQuanLy/update":
				updateMuonTraSach(request, response);
				break;
			default: // list
				listMuonTraSach(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void deleteMuonTraSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maMuonSach"));

		try {
			dal_muonTraSach.Delete(code);
			response.sendRedirect("/QuanLyThuVien/MuonTraSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void listMuonTraSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<MuonTraSach> listMuonTraSach = new ArrayList<MuonTraSach>();

		try {
			listMuonTraSach = dal_muonTraSach.getAll();
			request.setAttribute("listMuonTraSach", listMuonTraSach);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MuonTraSachQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateMuonTraSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		MuonTraSach record = new MuonTraSach();

		record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonSach")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		//record.setNgayMuon(Integer.parseInt(request.getParameter("txtNgayMuon")));
		//record.setNgayHenTra((request.getDate("txtNgayHenTra")));
		//record.setNgayTra(request.getParameter("txtNgayTra"));
		record.setTienDatCoc(request.getParameter("txtTienDatCoc"));
		record.setGhiChu(request.getParameter("txtGhiChu"));

		try {
			dal_muonTraSach.Update(record);
			response.sendRedirect("/QuanLyThuVien/DauSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertMuonTraSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		MuonTraSach record = new MuonTraSach();

		record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonSach")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		//record.setNgayMuon(request.getParameter("txtNgayMuon"));
		//record.setNgayHenTra(request.getParameter("txtNgayHenTra"));
		//record.setNgayTra(request.getDate("txtNgayTra"));
		record.setTienDatCoc(request.getParameter("txtTienDatCoc"));
		record.setGhiChu(request.getParameter("txtGhiChu"));

		try {
			dal_muonTraSach.Add(record);
			response.sendRedirect("/QuanLyThuVien/MuonTraSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
