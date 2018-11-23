package QuanLyThuVien.model.DAO.Object;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Date;

/**
 * Object Đầu sách:
 * 
 * @author IT 1006
 * @since 23/11/2018
 */
public class DauSach {
	private int maDauSach;
	private int maNxb;
	private int maTheLoai;
	private String tenSach;
	private String tacGia;
	private Date namXuatBan;
	private String ngonNgu;
	private byte[] anhBia;
	private String trangThai;
	private float gia;
	private String filePDF;

	public DauSach() {
		this.namXuatBan = new Date(0);
		this.anhBia = null;
	}

	public DauSach(int madausach) {
		this.setMaDauSach(madausach);
	}

	public DauSach(int matheloai, String tensach, String tacgia, Date namxuatban, String ngonngu, byte[] anhbia,
			String trangthai, float gia, String filepdf) {
		this.setMaTheLoai(matheloai);
		this.setTenSach(tensach);
		this.setTacGia(tacgia);
		this.setNamXuatBan(namxuatban);
		this.setNgonNgu(ngonngu);
		this.setAnhBia(anhbia);
		this.setTrangThai(trangthai);
		this.setGia(gia);
		this.setFilePDF(filepdf);
	}

	public DauSach(int madausach, int manxb, int matheloai, String tensach, String tacgia, Date namxuatban,
			String ngonngu, byte[] anhbia, String trangthai, float gia, String filepdf) {
		this(matheloai, tensach, tacgia, namxuatban, ngonngu, anhbia, trangthai, gia, filepdf);
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

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
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

	public byte[] getAnhBia() {
		return anhBia;
	}

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

	public String getFilePDF() {
		return filePDF;
	}

	public void setFilePDF(String filePDF) {
		this.filePDF = filePDF;
	}
}