package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.DocGia;
import QuanLyThuVien.model.DAL.Object.DocGia;

public class DALDocGia extends ConnectDatabase implements I_DAL<DocGia> {

	public DALDocGia(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<DocGia> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<DocGia> DocGias = new ArrayList<>();
		String sqlExec = "EXEC spLayDocGia";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			DocGia docGia = new DocGia();
			docGia.setMaDocGia(res.getInt(1));
			docGia.setTenDocGia(res.getString(2));
			docGia.setGioiTinh(res.getString(3));
			docGia.setNgaySinh(res.getDate(4));
			docGia.setDiaChi(res.getString(5));
			docGia.setEmail(res.getString(6));
			docGia.setSoDienThoai(res.getString(7));
			DocGias.add(docGia);
		}

		closeConnection();
		return DocGias;
	}

	@Override
	public int Add(DocGia record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spDocGia ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaDocGia());
		statement.setString(2, record.getTenDocGia());
		statement.setString(3, record.getGioiTinh());
		statement.setDate(4, record.getNgaySinh());
		statement.setString(5, record.getDiaChi());
		statement.setString(6, record.getEmail());
		statement.setString(7, record.getSoDienThoai());
		statement.setString(14, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaDocGia ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(DocGia record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spDocGia ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaDocGia());
		statement.setString(2, record.getTenDocGia());
		statement.setString(3, record.getGioiTinh());
		statement.setDate(4, record.getNgaySinh());
		statement.setString(5, record.getDiaChi());
		statement.setString(6, record.getEmail());
		statement.setString(7, record.getSoDienThoai());
		statement.setString(14, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public DocGia GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotDocGia ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		DocGia docGia = new DocGia();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			docGia.setMaDocGia(res.getInt(1));
			docGia.setTenDocGia(res.getString(2));
			docGia.setGioiTinh(res.getString(3));
			docGia.setNgaySinh(res.getDate(4));
			docGia.setDiaChi(res.getString(5));
			docGia.setEmail(res.getString(6));
			docGia.setSoDienThoai(res.getString(7));
		}
		closeConnection();
		return docGia;
	}

}

