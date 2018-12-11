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

import QuanLyThuVien.model.DAL.DALNxb;
import QuanLyThuVien.model.DAL.Object.Nxb;

public class BLLNxb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALNxb dal_Nxb;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_Nxb = new DALNxb(jdbcURL);
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
			case "/NxbQuanLy/insert":
				insertNxb(request, response);
				break;
			case "/NxbQuanLy/delete":
				deleteNxb(request, response);
				break;
			case "/NxbQuanLy/update":
				updateNxb(request, response);
				break;
			default: // list
				listNxb(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void updateNxb(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Nxb record = new Nxb();
		record.setMaNxb(Integer.parseInt(request.getParameter("txtMaNxb")));
		record.setTenNxb(request.getParameter("txtTenNxb"));
		record.setGhiChu(request.getParameter("txtGhiChu"));
		try {
			dal_Nxb.Update(record);
			response.sendRedirect("/QuanLyThuVien/NxbQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteNxb(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maNxb"));

		try {
			dal_Nxb.Delete(code);
			response.sendRedirect("/QuanLyThuVien/NxbQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertNxb(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Nxb record = new Nxb();
		record.setMaNxb(Integer.parseInt(request.getParameter("txtMaNxb")));
		record.setTenNxb(request.getParameter("txtTenNxb"));
		record.setGhiChu(request.getParameter("txtGhiChu"));
		try {
			dal_Nxb.Add(record);
			response.sendRedirect("/QuanLyThuVien/NxbQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listNxb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Nxb> listNxb = new ArrayList<Nxb>();

		try {
			listNxb = dal_Nxb.getAll();
			request.setAttribute("listNxb", listNxb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("NxbQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
