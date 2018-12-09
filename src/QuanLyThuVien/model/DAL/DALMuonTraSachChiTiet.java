package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class DALMuonTraSachChiTiet extends ConnectDatabase implements I_DAL<MuonTraSachChiTiet> {

	public DALMuonTraSachChiTiet(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<MuonTraSachChiTiet> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<MuonTraSachChiTiet> MuonTraSachChiTiets= new ArrayList<>();
		String sqlExec = "EXEC spLayMuonTraSachChiTiet";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			MuonTraSachChiTiet muonTraSachChiTiet = new MuonTraSachChiTiet();
			muonTraSachChiTiet.setMaMuonSach(res.getInt(1));
			muonTraSachChiTiet.setMaCuonSach(res.getInt(2));
			muonTraSachChiTiet.setTrangThai(res.getString(3));
			muonTraSachChiTiet.setSoLuong(res.getInt(4));
			MuonTraSachChiTiets.add(muonTraSachChiTiet);
		}
		closeConnection();
		return MuonTraSachChiTiets;
	}
	@Override
	public int Add(MuonTraSachChiTiet record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spPhieuPhat ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaMuonSach());
		statement.setInt(2, record.getMaCuonSach());
		statement.setString(3, record.getTrangThai());
		statement.setInt(4, record.getSoLuong());
		statement.setString(14, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaMuonTraSachChiTiet?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(MuonTraSachChiTiet record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spMuonTraSachChiTiet ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaMuonSach());
		statement.setInt(2, record.getMaCuonSach());
		statement.setString(3, record.getTrangThai());
		statement.setInt(4, record.getSoLuong());
		statement.setString(14, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public MuonTraSachChiTiet GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotPhieuPhat ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		MuonTraSachChiTiet muonTraSachChiTiet = new MuonTraSachChiTiet();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			muonTraSachChiTiet.setMaMuonSach(res.getInt(1));
			muonTraSachChiTiet.setMaCuonSach(res.getInt(2));
			muonTraSachChiTiet.setTrangThai(res.getString(3));
			muonTraSachChiTiet.setSoLuong(res.getInt(4));
		}
		closeConnection();
		return muonTraSachChiTiet;
	}

}
