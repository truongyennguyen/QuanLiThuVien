package QuanLyThuVien.model.DAL.Object;


public class MuonTraSach {
	private int maMuonSach;
	private int maThe;
	private String tienDatCoc;
	private String ghiChu;
	
	
	public MuonTraSach(int maMuonSach) {
		super();
		this.maMuonSach = maMuonSach;
	}


	public MuonTraSach() {
		super();
	}


	public MuonTraSach(int maMuonSach, int maThe, String tienDatCoc,
			String ghiChu) {
		super();
		this.maMuonSach = maMuonSach;
		this.maThe = maThe;
		this.tienDatCoc = tienDatCoc;
		this.ghiChu = ghiChu;
	}


	public int getMaMuonSach() {
		return maMuonSach;
	}


	public void setMaMuonSach(int maMuonSach) {
		this.maMuonSach = maMuonSach;
	}


	public int getMaThe() {
		return maThe;
	}


	public void setMaThe(int maThe) {
		this.maThe = maThe;
	}

	public String getTienDatCoc() {
		return tienDatCoc;
	}


	public void setTienDatCoc(String tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}


	public String getGhiChu() {
		return ghiChu;
	}


	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
