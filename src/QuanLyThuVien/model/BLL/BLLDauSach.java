package QuanLyThuVien.model.BLL;

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

import QuanLyThuVien.model.DAO.DAL_DauSach;
import QuanLyThuVien.model.DAO.Object.DauSach;

/**
 * BLLdal_dauSach.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @author IT1006
 */
@WebServlet(name = "DauSachList", urlPatterns = { "/DauSachList" })
public class BLLDauSach extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private DAL_DauSach dal_dauSach;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_dauSach = new DAL_DauSach(jdbcURL);
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
			case "/DauSachList/new":
				showNewForm(request, response);
				break;
			case "/DauSachList/insert":
				insertDauSach(request, response);
				break;
			case "/DauSachList/delete":
				deleteDauSach(request, response);
				break;
			case "/DauSachList/edit":
				showEditForm(request, response);
				break;
			case "/DauSachList/update":
				updateDauSach(request, response);
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
		List<DauSach> listDauSach = new ArrayList<DauSach>();
		
			try {
				listDauSach = dal_dauSach.getAllData();
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			}
	
		request.setAttribute("listDauSach", listDauSach);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DauSachList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("XXXXX.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("id"));
		DauSach existingBook = new DauSach();
		try {
			existingBook = dal_dauSach.GetOne(code);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("XXXXX.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);

	}

	private void insertDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
//		int MaDauSach = request.getParamete("MaDauSach");
//		String title = request.getParameter("title");
//		String author = request.getParameter("author");
//		float price = Float.parseFloat(request.getParameter("price"));
//
//		DauSach newDauSach = new DauSach(title, author, price);
//		dal_dauSach.Add(newDauSach);
		response.sendRedirect("list");
	}

	private void updateDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
		DauSach record = new DauSach();
		
		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		record.setMaNxb(Integer.parseInt(request.getParameter("txtMaNxb")));
		record.setMaTheLoai(Integer.parseInt(request.getParameter("txtMaTheLoai")));
		record.setTenSach(request.getParameter("txtTenSach"));
		record.setTacGia(request.getParameter("txtTacGia"));
		if (request.getParameter("dateNamXuatBan") != null) {
            try {
				Date namXuatBan = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNamXuatBan"));
				record.setNamXuatBan(new java.sql.Date(namXuatBan.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
		record.setNgonNgu(request.getParameter("txtNgonNgu"));
		//Giaiar quyết byte[] khi nào có thể
		
//		record.setAnhBia(request.getParameter("txtMaDauSach"));
//		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
//		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
//		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		
		
		try {
			dal_dauSach.Update(record);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("list");
	}

	private void deleteDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("id"));

		try {
			dal_dauSach.Delete(code);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("list");

	}

}
