package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import QuanLyThuVien.model.DAL.DALDauSach;
import QuanLyThuVien.model.DAL.Object.DauSach;

/**
 * @author IT 1006
 * @since 3:55PM 9/12/2018 LoadImage from Database for all Website
 */
@WebServlet(urlPatterns = { "/getAnhTacGia", "/getAnhBia", "/getFilePDF" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BLLXuLyHinhAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALDauSach dal_dauSach;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_dauSach = new DALDauSach(jdbcURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/getAnhTacGia":
			getAnhTacGia(request, response);
			break;
		case "/getAnhBia":
			getAnhBia(request, response);
			break;
		case "/getFilePDF":
			getFilePDF(request, response);
			break;
		default:
			getImageError(request, response);
			break;
		}

	}

	private void getImageError(HttpServletRequest request, HttpServletResponse response) {

	}

	private void getFilePDF(HttpServletRequest request, HttpServletResponse response) {
		try {

			int maDauSach = 0;
			try {
				maDauSach = Integer.parseInt(request.getParameter("maDauSach"));
			} catch (Exception e) {

			}
			DauSach dauSach = dal_dauSach.GetOne(maDauSach);

			Blob fileData = dauSach.getFilePDFBlob();
			InputStream is = fileData.getBinaryStream();

			byte[] bytes = new byte[(int) fileData.length()];
			int bytesRead;

			response.resetBuffer();
			response.reset();

			while ((bytesRead = is.read(bytes)) != -1) {
				response.getOutputStream().write(bytes, 0, bytesRead);
			}
			is.close();

		} catch (Exception e) {
			try {
				throw new ServletException(e);
			} catch (ServletException e1) {
				e1.printStackTrace();
			}
		}

	}

	private void getAnhBia(HttpServletRequest request, HttpServletResponse response) {
		try {

			int maDauSach = 0;
			maDauSach = Integer.parseInt(request.getParameter("maDauSach"));

			DauSach dauSach = dal_dauSach.GetOne(maDauSach);
			Blob fileData = dauSach.getAnhBiaBlob();
			InputStream is = fileData.getBinaryStream();

			byte[] bytes = new byte[(int) fileData.length()];

			bytes = fileData.getBytes(1, (int) fileData.length());
			response.resetBuffer();
			response.reset();
			response.setContentType("image/*");
//			response.getOutputStream().write(bytes);

			int bytesRead = 0;
			while ((bytesRead = is.read(bytes)) != -1) {
				response.getOutputStream().write(bytes, 0, bytesRead);
			}
			is.close();

		} catch (Exception e) {
			try {
				throw new ServletException(e);
			} catch (ServletException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void getAnhTacGia(HttpServletRequest request, HttpServletResponse response) {
		try {
			int maDauSach = 0;
			try {
				maDauSach = Integer.parseInt(request.getParameter("maDauSach"));
			} catch (Exception e) {

			}
			DauSach dauSach = dal_dauSach.GetOne(maDauSach);
			Blob fileData = dauSach.getAnhTacGiaBlob();
			InputStream is = fileData.getBinaryStream();
			byte[] bytes = new byte[(int) fileData.length()];
			bytes = fileData.getBytes(1, (int) fileData.length());

			response.resetBuffer();
			response.reset();
			response.setContentType("image/*");
//			response.getOutputStream().write(bytes);

			int bytesRead;
			while ((bytesRead = is.read(bytes)) != -1) {
				response.getOutputStream().write(bytes, 0, bytesRead);
			}
			is.close();

		} catch (Exception e) {
			try {
				throw new ServletException(e);
			} catch (ServletException e1) {
				e1.printStackTrace();
			}
		}

	}

}