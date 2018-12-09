package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.MuonTraSach;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class DALMuonTraSach extends ConnectDatabase implements I_DAL<MuonTraSach> {

	public DALMuonTraSach(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<MuonTraSach> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<MuonTraSach> MuonTraSachs = new ArrayList<>();
		String sqlExec = "EXEC spLayMuonTraSach";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			MuonTraSach muonTraSach = new MuonTraSach();
			 muonTraSach.setMaMuonSach(res.getInt(1));
			 muonTraSach.setMaThe(res.getInt(2));
			 muonTraSach.setNgayMuon(res.getDate(3));
			 muonTraSach.setNgayHenTra(res.getDate(4));
			 muonTraSach.setNgayTra(res.getDate(5));
			 muonTraSach.setTienDatCoc(res.getString(6));
			 muonTraSach.setGhiChu(res.getString(7));
			 MuonTraSachs.add(muonTraSach);
		}

		closeConnection();
		return  MuonTraSachs;
	}

	@Override
	public int Add(MuonTraSach record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spPhieuPhat ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaMuonSach());
		statement.setInt(2, record.getMaThe());
		statement.setDate(3, record.getNgayMuon());
		statement.setDate(4, record.getNgayHenTra());
		statement.setDate(5, record.getNgayTra());
		statement.setString(6, record.getTienDatCoc());
		statement.setString(7, record.getGhiChu());
		statement.setString(14, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaMuonTraSach ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(MuonTraSach record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spMuonTraSach ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaMuonSach());
		statement.setInt(2, record.getMaThe());
		statement.setDate(3, record.getNgayMuon());
		statement.setDate(4, record.getNgayHenTra());
		statement.setDate(5, record.getNgayTra());
		statement.setString(6, record.getTienDatCoc());
		statement.setString(7, record.getGhiChu());
		statement.setString(14, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public MuonTraSach GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotMuonTraSach ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		MuonTraSach muonTraSach = new MuonTraSach();
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			 muonTraSach.setMaMuonSach(res.getInt(1));
			 muonTraSach.setMaThe(res.getInt(2));
			 muonTraSach.setNgayMuon(res.getDate(3));
			 muonTraSach.setNgayHenTra(res.getDate(4));
			 muonTraSach.setNgayTra(res.getDate(5));
			 muonTraSach.setTienDatCoc(res.getString(6));
			 muonTraSach.setGhiChu(res.getString(7));
		}
		closeConnection();
		return muonTraSach;
	}

}
