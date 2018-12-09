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

import QuanLyThuVien.model.DAL.DALPhieuPhat;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class BLLPhieuPhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALPhieuPhat dal_phieuPhat;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_phieuPhat = new DALPhieuPhat(jdbcURL);
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
			case "/PhieuPhatQuanLy/insert":
				insertPhieuPhat(request, response);
				break;
			case "/PhieuPhatQuanLy/delete":
				deletePhieuPhat(request, response);
				break;
			case "/PhieuPhatQuanLy/update":
				updatePhieuPhat(request, response);
				break;
			default: // list
				listPhieuPhat(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void listPhieuPhat(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {

		List<PhieuPhat> listPhieuPhat = new ArrayList<PhieuPhat>();

		try {
			listPhieuPhat = dal_phieuPhat.getAll();
			request.setAttribute("listPhieuPhat", listPhieuPhat);
			RequestDispatcher dispatcher = request.getRequestDispatcher("PhieuPhatQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatePhieuPhat(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PhieuPhat record = new PhieuPhat();
		record.setIdPhieuPhat(Integer.parseInt(request.getParameter("txtidPhieuPhat")));
		record.setMaNhanVien(Integer.parseInt(request.getParameter("txtMaNhanVien")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		//record.setNgayLap(request.getParameter("txtNgayLap"));--sai này --

		try {
			dal_phieuPhat.Update(record);
			response.sendRedirect("/QuanLyThuVien/PhieuPhatQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deletePhieuPhat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maPhieuPhat"));

		try {
			dal_phieuPhat.Delete(code);
			response.sendRedirect("/QuanLyThuVien/PhieuPhatQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void insertPhieuPhat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PhieuPhat record = new PhieuPhat();
		record.setIdPhieuPhat(Integer.parseInt(request.getParameter("txtidPhieuPhat")));
		record.setMaNhanVien(Integer.parseInt(request.getParameter("txtMaNhanVien")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		//record.setNgayLap(request.getParameter("txtNgayLap"));-- sai này--S


		try {
			dal_phieuPhat.Add(record);
			response.sendRedirect("/QuanLyThuVien/PhieuPhatQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
