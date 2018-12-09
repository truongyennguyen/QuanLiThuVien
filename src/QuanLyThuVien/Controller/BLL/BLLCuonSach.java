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

import QuanLyThuVien.model.DAL.DALCuonSach;
import QuanLyThuVien.model.DAL.Object.CuonSach;

public class BLLCuonSach extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private DALCuonSach dal_cuonSach;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_cuonSach = new DALCuonSach(jdbcURL);
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
			case "/CuonSachQuanLy/insert":
				insertCuonSach(request, response);
				break;
			case "/CuonSachQuanLy/delete":
				deleteCuonSach(request, response);
				break;
			case "/CuonSachQuanLy/update":
				updateCuonSach(request, response);
				break;
			default: // list
				listCuonSach(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void listCuonSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<CuonSach> listCuonSach = new ArrayList<CuonSach>();

		try {
			listCuonSach = dal_cuonSach.getAll();
			request.setAttribute("listCuonSach", listCuonSach);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CuonSachQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void insertCuonSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		CuonSach record = new CuonSach();

		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		record.setViTri(request.getParameter("txtViTri"));
		try {
			dal_cuonSach.Add(record);
			response.sendRedirect("/QuanLyThuVien/CuonSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void updateCuonSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		CuonSach record = new CuonSach();

		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		record.setViTri(request.getParameter("txtViTri"));
		record.setTrangThai(request.getParameter("txtTrangThai"));
		try {
			dal_cuonSach.Update(record);
			response.sendRedirect("/QuanLyThuVien/CuonSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void deleteCuonSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maCuonSach"));

		try {
			dal_cuonSach.Delete(code);
			response.sendRedirect("/QuanLyThuVien/CuonSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}



	}
	
	}
