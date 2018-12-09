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

import QuanLyThuVien.model.DAL.DALDocGia;
import QuanLyThuVien.model.DAL.Object.DocGia;

public class BLLDocGia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALDocGia dal_docGia;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_docGia = new DALDocGia(jdbcURL);
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
			case "/DocGiaQuanLy/insert":
				insertDocGia(request, response);
				break;
			case "/DocGiaQuanLy/delete":
				deleteDocGia(request, response);
				break;
			case "/DocGiaQuanLy/update":
				updateDocGia(request, response);
				break;
			default: // list
				listDocGia(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void updateDocGia(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		DocGia record = new DocGia();

		record.setMaDocGia(Integer.parseInt(request.getParameter("txtMaDocGia")));
		record.setTenDocGia(request.getParameter("txtTenDocGia"));
		record.setGioiTinh(request.getParameter("txtGioiTinh"));
		//record.setNgaySinh(request.getParameter("txtNgaySinh"));/*--chỗ sai biến date--*/
		record.setDiaChi(request.getParameter("txtDiaChi"));
		record.setEmail(request.getParameter("txteMail"));
		record.setSoDienThoai(request.getParameter("txtSoDienThoai"));

		try {
			dal_docGia.Update(record);
			response.sendRedirect("/QuanLyThuVien/DocGiaQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteDocGia(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maDocGia"));

		try {
			dal_docGia.Delete(code);
			response.sendRedirect("/QuanLyThuVien/DocGiaQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDocGia(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		DocGia record = new DocGia();
		record.setMaDocGia(Integer.parseInt(request.getParameter("txtMaDocGia")));
		record.setTenDocGia(request.getParameter("txtTenDocGia"));
		record.setGioiTinh(request.getParameter("txtGioiTinh"));
		//record.setNgaySinh(request.getParameter("txtNgaySinh"));--chỗ sai biến date--
		record.setDiaChi(request.getParameter("txtDiaChi"));
		record.setEmail(request.getParameter("txteMail"));
		record.setSoDienThoai(request.getParameter("txtSoDienThoai"));
		try {
			dal_docGia.Add(record);
			response.sendRedirect("/QuanLyThuVien/DocGiaQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void listDocGia(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<DocGia> listDocGia = new ArrayList<DocGia>();

		try {
			listDocGia = dal_docGia.getAll();
			request.setAttribute("listDocGia", listDocGia);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DocGiaQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
