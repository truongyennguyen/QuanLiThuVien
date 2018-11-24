package QuanLyThuVien.model.DAO.Object;

public class TheLoai {
	private int maTheLoai;
	private String tenTheLoai;
	

	public TheLoai() {
		
	}
	
	public TheLoai(int matheloai, String tentheloai) {
		this.setMaTheLoai(matheloai);
		this.setTenTheLoai(tentheloai);
}

	public int getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	
	
	
}
