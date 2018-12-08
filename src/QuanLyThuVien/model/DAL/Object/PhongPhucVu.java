package QuanLyThuVien.model.DAL.Object;

import java.sql.Date;

public class PhongPhucVu {
	private int idPhong;
	private String tenPhong;
	private Date gioBatDau;
	private Date gioKetThuc;
	private int maNhanVien;
	
	public PhongPhucVu(int idPhong) {
		super();
		this.idPhong = idPhong;
	}

	public PhongPhucVu() {
		super();
	}

	public PhongPhucVu(int idPhong, String tenPhong, Date gioBatDau, Date gioKetThuc, int maNhanVien) {
		super();
		this.idPhong = idPhong;
		this.tenPhong = tenPhong;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.maNhanVien = maNhanVien;
	}

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public Date getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(Date gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public Date getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(Date gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
}
