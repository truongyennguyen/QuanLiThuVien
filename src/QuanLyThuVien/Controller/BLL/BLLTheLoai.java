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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALTheLoai;
import QuanLyThuVien.model.DAL.Object.TheLoai;

@WebServlet(name = "TheLoaiQuanLy", urlPatterns = { "/TheLoaiQuanLy", "/TheLoaiQuanLy/delete", "/TheLoaiQuanLy/list",
		"/TheLoaiQuanLy/insert", "/TheLoaiQuanLy/update" })
public class BLLTheLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALTheLoai dal_theLoai;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
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
		System.out.println(action);
		try {
			switch (action) {
			case "/TheLoaiQuanLy/insert":
				insertTheLoai(request, response);
				break;
			case "/TheLoaiQuanLy/delete":
				deleteTheLoai(request, response);
				break;
			case "/TheLoaiQuanLy/update":
				updateTheLoai(request, response);
				break;
			default: // list
				listTheLoai(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
			}
}

	private void listTheLoai(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException, ServletException {

			List<TheLoai> listTheLoai = new ArrayList<TheLoai>();

			try {
				listTheLoai = dal_theLoai.getAll();
				request.setAttribute("listTheLoai", listTheLoai);
				RequestDispatcher dispatcher = request.getRequestDispatcher("TheLoaiQuanLy.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}

	private void updateTheLoai(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {

	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");

	TheLoai record = new TheLoai();

	record.setMaTheLoai(Integer.parseInt(request.getParameter("txtMaTheLoai")));
	record.setTenTheLoai((request.getParameter("txtTenTheLoai")));
	try {
		dal_theLoai.Update(record);
		response.sendRedirect("/QuanLyThuVienTheLoaiQuanLy");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	}

	private void deleteTheLoai(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {
			int code = Integer.parseInt(request.getParameter("maTheLoai"));

			try {
				dal_theLoai.Delete(code);
				response.sendRedirect("/QuanLyThuVien/TheLoaiQuanLy");
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			}
	
		
	private void insertTheLoai(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			TheLoai record = new TheLoai();

			record.setMaTheLoai(Integer.parseInt(request.getParameter("txtMaTheLoai")));
			record.setTenTheLoai(request.getParameter("txtMaNxb"));
			try {
				dal_theLoai.Add(record);
				response.sendRedirect("/QuanLyThuVien/TheLoaiQuanLy");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

	}

	}

