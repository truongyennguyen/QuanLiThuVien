package QuanLyThuVien.model.DAO;

import QuanLyThuVien.model.DAO.Object.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAL_DauSach extends ConnectDatabase implements I_DAO<DauSach> {

	public DAL_DauSach(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		super(jdbcURL, jdbcUsername, jdbcPassword);
	}

	@Override
	public List<DauSach> getAllData() throws SQLException, ClassNotFoundException {
		openConnection();
		List<DauSach> DauSachs = new ArrayList<>();
		String sqlExec = "EXEC LayDauSach";

		PreparedStatement statement = connection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			DauSach dauSach = new DauSach();

			dauSach.setMaDauSach(res.getInt(1));
			dauSach.setMaNxb(res.getInt(2));
			dauSach.setMaTheLoai(res.getInt(3));
			dauSach.setTenSach(res.getString(4));
			dauSach.setTacGia(res.getString(5));
			dauSach.setNamXuatBan(res.getDate(6));
			dauSach.setNgonNgu(res.getString(7));
			dauSach.setAnhBia(res.getBytes(8));
			dauSach.setTrangThai(res.getString(9));
			dauSach.setGia(res.getFloat(10));
			dauSach.setFilePDF(res.getString(11));

			DauSachs.add(dauSach);
		}

		closeConnection();
		return DauSachs;
	}

	/**
	 * record là dòng truyền vào. Chung cho tất cả
	 * 
	 * @author IT 1006
	 */
	@Override
	public int Add(DauSach record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC ThemDauSach ?,?,?,?,?, ?,?,?,?,?, ?";// 11 @param
		PreparedStatement statement = connection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaDauSach());
		statement.setInt(2, record.getMaNxb());
		statement.setInt(3, record.getMaTheLoai());
		statement.setString(4, record.getTenSach());
		statement.setString(5, record.getTacGia());
		statement.setDate(6, record.getNamXuatBan());
		statement.setString(7, record.getNgonNgu());
		statement.setObject(8, record.getAnhBia());
		statement.setString(9, record.getTrangThai());
		statement.setFloat(10, record.getGia());
		statement.setString(11, record.getFilePDF());

		int rowInsert = statement.executeUpdate();

		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC XoaDauSach ?";
		PreparedStatement statement = connection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		int rowDelete = statement.executeUpdate();

		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(DauSach record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC SuaDauSach ?,?";
		PreparedStatement statement = connection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaDauSach());
		statement.setInt(2, record.getMaNxb());
		statement.setInt(3, record.getMaTheLoai());
		statement.setString(4, record.getTenSach());
		statement.setString(5, record.getTacGia());
		statement.setDate(6, record.getNamXuatBan());
		statement.setString(7, record.getNgonNgu());
		statement.setObject(8, record.getAnhBia());
		statement.setString(9, record.getTrangThai());
		statement.setFloat(10, record.getGia());
		statement.setString(11, record.getFilePDF());

		int rowUpdate = statement.executeUpdate();

		closeConnection();
		return rowUpdate;
	}

	@Override
	public DauSach GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC LayMotDauSach ?";
		PreparedStatement statement = connection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		DauSach dauSach = new DauSach();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			dauSach.setMaDauSach(res.getInt(1));
			dauSach.setMaNxb(res.getInt(2));
			dauSach.setMaTheLoai(res.getInt(3));
			dauSach.setTenSach(res.getString(4));
			dauSach.setTacGia(res.getString(5));
			dauSach.setNamXuatBan(res.getDate(6));
			dauSach.setNgonNgu(res.getString(7));
			dauSach.setAnhBia(res.getBytes(8));
			dauSach.setTrangThai(res.getString(9));
			dauSach.setGia(res.getFloat(10));
			dauSach.setFilePDF(res.getString(11));
		}
		closeConnection();
		return dauSach;
	}
}
