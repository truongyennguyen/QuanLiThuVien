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

import QuanLyThuVien.model.DAL.DALThongBao;
import QuanLyThuVien.model.DAL.Object.ThongBao;

public class BLLThongBao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALThongBao dal_thongBao;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_thongBao = new DALThongBao(jdbcURL);
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
			case "/ThongBaoQuanLy/insert":
				insertThongBao(request, response);
				break;
			case "/ThongBaoQuanLy/delete":
				deleteThongBao(request, response);
				break;
			case "/ThongBaoQuanLy/update":
				updateThongBao(request, response);
				break;
			default: // list
				listThongBao(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void listThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<ThongBao> listThongBao = new ArrayList<ThongBao>();

		try {
			listThongBao = dal_thongBao.getAll();
			request.setAttribute("listThongBao", listThongBao);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ThongBaoQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void updateThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ThongBao record = new ThongBao();
		record.setiDThongBao(Integer.parseInt(request.getParameter("txtMaThongBao")));
		record.setTenThongBao(request.getParameter("txtTenThongBao"));
		record.setNoiDung(request.getParameter("txtNoiDung"));
		record.setHinhAnh(request.getParameter("txtHinhAnh"));
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));
		try {
			dal_thongBao.Update(record);
			response.sendRedirect("/QuanLyThuVien/ThongBaoQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maThongBao"));

		try {
			dal_thongBao.Delete(code);
			response.sendRedirect("/QuanLyThuVien/ThongBaoQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void insertThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		ThongBao record = new ThongBao();
		record.setiDThongBao(Integer.parseInt(request.getParameter("txtMaThongBao")));
		record.setTenThongBao(request.getParameter("txtTenThongBao"));
		record.setNoiDung(request.getParameter("txtNoiDung"));
		record.setHinhAnh(request.getParameter("txtHinhAnh"));
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));

		try {
			dal_thongBao.Add(record);
			response.sendRedirect("/QuanLyThuVien/ThongBaoQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}
