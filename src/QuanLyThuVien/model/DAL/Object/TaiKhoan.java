package QuanLyThuVien.model.DAL.Object;

public class TaiKhoan {
	private int maTaiKhoan;
	private String eMail;
	private int soDienThoai;
	private String matKhau;
	private String Avartar;
	private int idQuyen;
	private int maThe;
	
	
	public TaiKhoan(int maTaiKhoan) {
		super();
		this.maTaiKhoan = maTaiKhoan;
	}


	public TaiKhoan() {
		super();
	}


	public TaiKhoan(int maTaiKhoan, String eMail, int soDienThoai, String matKhau, String avartar, int idQuyen,
			int maThe) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.eMail = eMail;
		this.soDienThoai = soDienThoai;
		this.matKhau = matKhau;
		Avartar = avartar;
		this.idQuyen = idQuyen;
		this.maThe = maThe;
	}


	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}


	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public int getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public String getMatKhau() {
		return matKhau;
	}


	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}


	public String getAvartar() {
		return Avartar;
	}


	public void setAvartar(String avartar) {
		Avartar = avartar;
	}


	public int getIdQuyen() {
		return idQuyen;
	}


	public void setIdQuyen(int idQuyen) {
		this.idQuyen = idQuyen;
	}


	public int getMaThe() {
		return maThe;
	}


	public void setMaThe(int maThe) {
		this.maThe = maThe;
	}
	
	
}
