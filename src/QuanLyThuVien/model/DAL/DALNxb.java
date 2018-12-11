package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class DALNxb extends ConnectDatabase implements I_DAL<Nxb> {

	public DALNxb(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<Nxb> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<Nxb> Nxbs = new ArrayList<>();
		String sqlExec = "EXEC spLayNxb";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			Nxb Nxb = new Nxb();
			Nxb.setMaNxb(res.getInt(1));
			Nxb.setTenNxb(res.getString(2));
			Nxb.setGhiChu(res.getString(3));
			Nxbs.add(Nxb);
		}

		closeConnection();
		return Nxbs;
	}

	@Override
	public int Add(Nxb record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spNxb ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaNxb());
		statement.setString(2, record.getTenNxb());
		statement.setString(3, record.getGhiChu());
		statement.setString(14, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaNxb ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(Nxb record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spNxb ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setInt(1, record.getMaNxb());
		statement.setString(2, record.getTenNxb());
		statement.setString(3, record.getGhiChu());
		statement.setString(14, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public Nxb GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotNxb ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		Nxb Nxb = new Nxb();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			Nxb.setMaNxb(res.getInt(1));
			Nxb.setTenNxb(res.getString(2));
			Nxb.setGhiChu(res.getString(3));
		}
		closeConnection();
		return Nxb;
	}

}
