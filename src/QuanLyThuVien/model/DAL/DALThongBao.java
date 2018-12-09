package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.PhieuPhat;
import QuanLyThuVien.model.DAL.Object.ThongBao;

public class DALThongBao extends ConnectDatabase implements I_DAL<ThongBao> {

	public DALThongBao(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<ThongBao> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<ThongBao> ThongBaos = new ArrayList<>();
		String sqlExec = "EXEC spLayThongBao";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			ThongBao thongBao = new ThongBao();
			thongBao.setiDThongBao(res.getInt(1));
			thongBao.setTenThongBao(res.getString(2));
			thongBao.setNoiDung(res.getString(3));
			thongBao.setHinhAnh(res.getString(4));
			thongBao.setMaTaiKhoan(res.getInt(5));
			ThongBaos.add(thongBao);
		}

		closeConnection();
		return ThongBaos;
	}

	@Override
	public int Add(ThongBao record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spThongBao ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getiDThongBao());
		statement.setString(2, record.getTenThongBao());
		statement.setString(3, record.getNoiDung());
		statement.setString(4, record.getHinhAnh());
		statement.setInt(5, record.getMaTaiKhoan());
		statement.setString(14, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaThongBao?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(ThongBao record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spThongBao ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getiDThongBao());
		statement.setString(2, record.getTenThongBao());
		statement.setString(3, record.getNoiDung());
		statement.setString(4, record.getHinhAnh());
		statement.setInt(5, record.getMaTaiKhoan());
		statement.setString(14, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public ThongBao GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotThongBao ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		ThongBao thongBao = new ThongBao();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			thongBao.setiDThongBao(res.getInt(1));
			thongBao.setTenThongBao(res.getString(2));
			thongBao.setNoiDung(res.getString(3));
			thongBao.setHinhAnh(res.getString(4));
			thongBao.setMaTaiKhoan(res.getInt(5));
		}
		closeConnection();
		return thongBao;
	}

}
