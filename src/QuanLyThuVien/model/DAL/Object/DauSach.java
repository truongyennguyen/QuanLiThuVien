package QuanLyThuVien.model.DAL.Object;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Object �?ầu sách:
 * 
 * @author IT 1006
 * @since 23/11/2018
 */
public class DauSach {
	private int maDauSach;
	private int maNxb;
	private int maTheLoai;
	private String tenSach;
	private String moTa;
	private String tacGia;
	private byte[] anhTacGia;
	private Date namXuatBan;
	private String ngonNgu;
	private byte[] anhBia;
	private String trangThai;
	private float gia;
	private Blob filePDF;

	public DauSach() {
		this.namXuatBan = new Date(0);
		this.anhTacGia = new byte[8096];
		this.anhBia = new byte[8096];
		this.filePDF = new Blob() {
			
			@Override
			public void truncate(long len) throws SQLException {
				
			}
			
			@Override
			public int setBytes(long pos, byte[] bytes, int offset, int len) throws SQLException {
				return 0;
			}
			
			@Override
			public int setBytes(long pos, byte[] bytes) throws SQLException {
				return 0;
			}
			
			@Override
			public OutputStream setBinaryStream(long pos) throws SQLException {
				return null;
			}
			
			@Override
			public long position(Blob pattern, long start) throws SQLException {
				return 0;
			}
			
			@Override
			public long position(byte[] pattern, long start) throws SQLException {
				return 0;
			}
			
			@Override
			public long length() throws SQLException {
				return 0;
			}
			
			@Override
			public byte[] getBytes(long pos, int length) throws SQLException {
				return null;
			}
			
			@Override
			public InputStream getBinaryStream(long pos, long length) throws SQLException {
				return null;
			}
			
			@Override
			public InputStream getBinaryStream() throws SQLException {
				return null;
			}
			
			@Override
			public void free() throws SQLException {
				
			}
		};
	}

	/**
	 * Phục vụ cho việc xóa
	 */
	public DauSach(int madausach) {
		this.setMaDauSach(madausach);
	}

	public DauSach(int manxb, int matheloai, String tensach, String mota, String tacgia, byte[] anhtacgia,
			Date namxuatban, String ngonngu, byte[] anhbia, String trangthai, float gia, Blob filepdf) {
		this.setMaTheLoai(matheloai);
		this.setMaNxb(manxb);
		this.setTenSach(tensach);
		this.setMoTa(mota);
		this.setTacGia(tacgia);
		this.setAnhTacGia(anhtacgia);
		this.setNamXuatBan(namxuatban);
		this.setNgonNgu(ngonngu);
		this.setAnhBia(anhbia);
		this.setTrangThai(trangthai);
		this.setGia(gia);
		this.setFilePDF(filepdf);
	}

	public DauSach(int madausach, int manxb, int matheloai, String tensach, String mota, String tacgia,
			byte[] anhtacgia, Date namxuatban, String ngonngu, byte[] anhbia, String trangthai, float gia,
			Blob filepdf) {
		this(manxb, matheloai, tensach, mota, tacgia, anhtacgia, namxuatban, ngonngu, anhbia, trangthai, gia, filepdf);
		this.setMaDauSach(madausach);
	}

	public int getMaDauSach() {
		return maDauSach;
	}

	public void setMaDauSach(int maDauSach) {
		this.maDauSach = maDauSach;
	}

	public int getMaNxb() {
		return maNxb;
	}

	public void setMaNxb(int maNxb) {
		this.maNxb = maNxb;
	}

	public int getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public byte[] getAnhTacGia() {
		return anhTacGia;
	}

	public void setAnhTacGia(byte[] anhTacGia) {
		this.anhTacGia = anhTacGia;
	}

	public Date getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(Date namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	/**
	 * Phần xử lý dữ liệu đều được làm ở đây*/
	public byte[] getAnhBia() {
		
		return anhBia;
	}

	/**
	 * Phần convert dữ liệu làm ở đây*/
	public void setAnhBia(byte[] anhBia) {
		
		this.anhBia = anhBia;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public Blob getFilePDF() {
		return filePDF;
	}

	public void setFilePDF(Blob filePDF) {
		this.filePDF = filePDF;
	}
}