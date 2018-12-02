package QuanLyThuVien.model.DAL.Object;

public class Nxb {
	private int maNXB;
	private String tenNXB;
	private String ghiChu;
	
	
	public Nxb(int maNXB) {
		super();
		this.maNXB = maNXB;
	}


	public Nxb() {
		super();

	}


	public Nxb(int maNXB, String tenNXB, String ghiChu) {
		super();
		this.maNXB = maNXB;
		this.tenNXB = tenNXB;
		this.ghiChu = ghiChu;
	}


	public int getMaNXB() {
		return maNXB;
	}


	public void setMaNXB(int maNXB) {
		this.maNXB = maNXB;
	}


	public String getTenNXB() {
		return tenNXB;
	}


	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}


	public String getGhiChu() {
		return ghiChu;
	}


	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
