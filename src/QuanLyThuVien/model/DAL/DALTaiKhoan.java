package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.TaiKhoan;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;

public class DALTaiKhoan extends ConnectDatabase implements I_DAL<TaiKhoan>{

	public DALTaiKhoan(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<TaiKhoan> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<TaiKhoan> TaiKhoans = new ArrayList<>();
		String sqlExec = "EXEC spLayTaiKhoan";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			TaiKhoan taiKhoan = new TaiKhoan();
			taiKhoan.setMaTaiKhoan(res.getInt(1));
			taiKhoan.seteMail(res.getString(2));
			taiKhoan.setSoDienThoai(res.getInt(3));
			taiKhoan.setMatKhau(res.getString(4));
			taiKhoan.setAvartar(res.getString(5));
			taiKhoan.setIdQuyen(res.getInt(6));
			taiKhoan.setMaThe(res.getInt(7));
			TaiKhoans.add(taiKhoan);
		}

		closeConnection();
		return TaiKhoans;
	}

	@Override
	public int Add(TaiKhoan record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spTaiKhoan ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaTaiKhoan());
		statement.setString(2, record.geteMail());
		statement.setInt(3, record.getSoDienThoai());
		statement.setString(5, record.getMatKhau());
		statement.setString(6, record.getAvartar());
		statement.setInt(7, record.getIdQuyen());
		statement.setInt(8, record.getMaThe());
		statement.setString(14, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaTaiKhoan ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(TaiKhoan record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spTaiKhoan ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaTaiKhoan());
		statement.setString(2, record.geteMail());
		statement.setInt(3, record.getSoDienThoai());
		statement.setString(5, record.getMatKhau());
		statement.setString(6, record.getAvartar());
		statement.setInt(7, record.getIdQuyen());
		statement.setInt(8, record.getMaThe());
		statement.setString(14, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public TaiKhoan GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotTaiKhoan ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		TaiKhoan taiKhoan = new TaiKhoan();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			taiKhoan.setMaTaiKhoan(res.getInt(1));
			taiKhoan.seteMail(res.getString(2));
			taiKhoan.setSoDienThoai(res.getInt(3));
			taiKhoan.setMatKhau(res.getString(4));
			taiKhoan.setAvartar(res.getString(5));
			taiKhoan.setIdQuyen(res.getInt(6));
			taiKhoan.setMaThe(res.getInt(7));
		}
		closeConnection();
		return taiKhoan;
	}

}
