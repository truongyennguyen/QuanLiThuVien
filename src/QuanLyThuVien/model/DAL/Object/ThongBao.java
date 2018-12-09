package QuanLyThuVien.model.DAL.Object;

import java.sql.Blob;

public class ThongBao {
	private int iDThongBao;
	private String tenThongBao;
	private String noiDung;
	private Blob hinhAnh;
	private int maTaiKhoan;

	public ThongBao(int iDThongBao) {
		super();
		this.iDThongBao = iDThongBao;
	}

	public ThongBao() {
		super();
	}

	public ThongBao(int iDThongBao, String tenThongBao, String noiDung, Blob hinhAnh, int maTaiKhoan) {
		super();
		this.iDThongBao = iDThongBao;
		this.tenThongBao = tenThongBao;
		this.noiDung = noiDung;
		this.hinhAnh = hinhAnh;
		this.maTaiKhoan = maTaiKhoan;
	}

	public int getiDThongBao() {
		return iDThongBao;
	}

	public void setiDThongBao(int iDThongBao) {
		this.iDThongBao = iDThongBao;
	}

	public String getTenThongBao() {
		return tenThongBao;
	}

	public void setTenThongBao(String tenThongBao) {
		this.tenThongBao = tenThongBao;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Blob getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(Blob hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

}
