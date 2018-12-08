package QuanLyThuVien.model.DAL.Object;

public class PhieuPhat {
	private int idPhieuPhat;
	private int maNhanVien;
	private int maThe;
	private int ngayLap;
	private int tienPhat;
	
	
	public PhieuPhat(int idPhieuPhat) {
		super();
		this.idPhieuPhat = idPhieuPhat;
	}


	public PhieuPhat() {
		super();
	}


	public PhieuPhat(int idPhieuPhat, int maNhanVien, int maThe, int ngayLap, int tienPhat) {
		super();
		this.idPhieuPhat = idPhieuPhat;
		this.maNhanVien = maNhanVien;
		this.maThe = maThe;
		this.ngayLap = ngayLap;
		this.tienPhat = tienPhat;
	}


	public int getIdPhieuPhat() {
		return idPhieuPhat;
	}


	public void setIdPhieuPhat(int idPhieuPhat) {
		this.idPhieuPhat = idPhieuPhat;
	}


	public int getMaNhanVien() {
		return maNhanVien;
	}


	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	public int getMaThe() {
		return maThe;
	}


	public void setMaThe(int maThe) {
		this.maThe = maThe;
	}


	public int getNgayLap() {
		return ngayLap;
	}


	public void setNgayLap(int ngayLap) {
		this.ngayLap = ngayLap;
	}


	public int getTienPhat() {
		return tienPhat;
	}


	public void setTienPhat(int tienPhat) {
		this.tienPhat = tienPhat;
	}

	
}
