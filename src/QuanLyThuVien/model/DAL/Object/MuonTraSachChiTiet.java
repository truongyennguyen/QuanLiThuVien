package QuanLyThuVien.model.DAL.Object;

public class MuonTraSachChiTiet {
	private int maMuonSach;
	private int maCuonSach;
	private String trangThai;
	private int soLuong;
	
	
	
	public MuonTraSachChiTiet(int maMuonSach, int maCuonSach) {
		super();
		this.maMuonSach = maMuonSach;
		this.maCuonSach = maCuonSach;
	}



	public MuonTraSachChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MuonTraSachChiTiet(int maMuonSach, int maCuonSach, String trangThai, int soLuong) {
		super();
		this.maMuonSach = maMuonSach;
		this.maCuonSach = maCuonSach;
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
