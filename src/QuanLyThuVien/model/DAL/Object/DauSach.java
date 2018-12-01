package QuanLyThuVien.model.DAL.Object;

import java.sql.Date;

/**
 * Object ï¿½?áº§u sÃ¡ch:
 * 
 * @author IT 1006
 * @since 23/11/2018
 */
public class DauSach {
	private int maDauSach;
	private int maNxb;
	private int maTheLoai;
	private String tenSach;
	private String moTa;
	private String tacGia;
	private String anhTacGia;
	private Date namXuatBan;
	private String ngonNgu;
	private String anhBia;
	private String trangThai;
	private float gia;
	private String filePDF;

	public DauSach() {
		this.namXuatBan = new Date(0);
	}

	/**
	 * Phá»¥c vá»¥ cho viá»‡c xÃ³a
	 */
	public DauSach(int madausach) {
		this.setMaDauSach(madausach);
	}

	public DauSach(int manxb, int matheloai, String tensach, String mota, String tacgia, String anhtacgia,
			Date namxuatban, String ngonngu, String anhbia, String trangthai, float gia, String filepdf) {
		this.setMaTheLoai(matheloai);
		this.setMaNxb(manxb);
		this.setTenSach(tensach);
		this.setMoTa(mota);
		this.setTacGia(tacgia);
		this.setAnhTacGia(anhtacgia);
		this.setNamXuatBan(namxuatban);
		this.setNgonNgu(ngonngu);
		this.setAnhBia(anhbia);
		this.setTrangThai(trangthai);
		this.setGia(gia);
		this.setFilePDF(filepdf);
	}

	public DauSach(int madausach, int manxb, int matheloai, String tensach, String mota, String tacgia,
			String anhtacgia, Date namxuatban, String ngonngu, String anhbia, String trangthai, float gia,
			String filepdf) {
		this(manxb, matheloai, tensach, mota, tacgia, anhtacgia, namxuatban, ngonngu, anhbia, trangthai, gia, filepdf);
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

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getAnhTacGia() {
		return anhTacGia;
	}

	public void setAnhTacGia(String anhTacGia) {
		this.anhTacGia = anhTacGia;
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

	/**
	 * Pháº§n xá»­ lÃ½ dá»¯ liá»‡u Ä‘á»�u Ä‘Æ°á»£c lÃ m á»Ÿ Ä‘Ã¢y
	 */
	public String getAnhBia() {

		return anhBia;
	}

	/**
	 * Pháº§n convert dá»¯ liá»‡u lÃ m á»Ÿ Ä‘Ã¢y
	 */
	public void setAnhBia(String anhBia) {

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