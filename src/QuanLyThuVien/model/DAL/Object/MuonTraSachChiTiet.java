package QuanLyThuVien.model.DAL.Object;
import java.sql.Date;

public class MuonTraSachChiTiet {
	private int maMuonSach;
	private int maCuonSach;
	private Date ngayMuon;
	private Date ngayHenTra;
	private Date ngayTra;
	private String trangThai;
	private int soLuong;
	



	public MuonTraSachChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MuonTraSachChiTiet(int maMuonSach, int maCuonSach, Date ngayMuon, Date ngayHenTra, Date ngayTra, String trangThai, int soLuong) {
		super();
		this.maMuonSach = maMuonSach;
		this.maCuonSach = maCuonSach;
		this.ngayMuon = ngayMuon;
		this.ngayHenTra = ngayHenTra;
		this.ngayTra = ngayTra;
		this.trangThai = trangThai;
		this.soLuong = soLuong;
	}



	public int getMaMuonSach() {
		return maMuonSach;
	}



	public void setMaMuonSach(int maMuonSach) {
		this.maMuonSach = maMuonSach;
	}



	public int getMaCuonSach() {
		return maCuonSach;
	}



	public void setMaCuonSach(int maCuonSach) {
		this.maCuonSach = maCuonSach;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}


	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}


	public Date getNgayHenTra() {
		return ngayHenTra;
	}


	public void setNgayHenTra(Date ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}


	public Date getNgayTra() {
		return ngayTra;
	}


	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}


	public String getTrangThai() {
		return trangThai;
	}



	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}



	public int getSoLuong() {
		return soLuong;
	}



	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
}
