//package QuanLyThuVien.model.DAO;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import 4java.util.List;
//
//import QuanLyThuVien.model.DAO.Object.*;
//
//public class DAL_TheLoai extends ConnectDatabase implements I_DAO<TheLoai> {
//
//	public DAL_TheLoai(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
//		super(jdbcURL, jdbcUsername, jdbcPassword);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public List<TheLoai> getAllData() throws SQLException, ClassNotFoundException {
//		openConnection();
//		List<TheLoai> TheLoais = new ArrayList<>();
//		String sqlExec = "EXEC LayTheLoai";
//
//		PreparedStatement statement = connection.prepareStatement(sqlExec);
//		statement.setEscapeProcessing(true);
//		statement.setQueryTimeout(15);
//		ResultSet res = statement.executeQuery();
//
//		while (res.next()) {
//			TheLoai TheLoai = new TheLoai();
//
//			TheLoai.setMaTheLoai(res.getInt(1));
//			TheLoai.setTenTheLoai(res.getString(5));
//			
//			TheLoais.add(TheLoai);
//		}
//
//		closeConnection();
//		return TheLoais;
//	}
//
//	@Override
//	public int Add(TheLoai record) throws SQLException, ClassNotFoundException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int Update(TheLoai record) throws SQLException, ClassNotFoundException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public TheLoai GetOne(Object... code) throws SQLException, ClassNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//}
