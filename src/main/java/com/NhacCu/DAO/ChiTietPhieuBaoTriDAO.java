package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.Connect.ConnectJDBC;
import com.NhacCu.DTO.*;

public class ChiTietPhieuBaoTriDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public ChiTietPhieuBaoTriDAO() {

	}
	public ArrayList<ChiTietPhieuBaoTriDTO> list() {
		ArrayList<ChiTietPhieuBaoTriDTO> ds = new ArrayList<ChiTietPhieuBaoTriDTO>();
		try {
			String sql = "SELECT * FROM ChiTietPhieuBaoTri  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaSP = rs.getString("MaSP");
				String MaBT = rs.getString("MaBT");
				String GhiChu = rs.getString("GhiChu");
				ChiTietPhieuBaoTriDTO ctpbtDTO = new  ChiTietPhieuBaoTriDTO(MaSP , MaBT , GhiChu);
				ds.add(ctpbtDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}
	public void update(ChiTietPhieuBaoTriDTO ctpbt) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE ChiTietPhieuBaoTri SET ";
		sql += "GhiChu = N'" + ctpbt.getGhiChu() + "'  ";
		sql += "Where MaSP = '" + ctpbt.getMaSP() + "' AND  MaBT = '" + ctpbt.getMaBT() +"';" ;
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(ChiTietPhieuBaoTriDTO ctpbt) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO ChiTietPhieuBaoTri  VALUES(";
		sql += "'" +  ctpbt.getMaSP()+ "',";
		sql += "'" +  ctpbt.getMaBT()+ "',";
		sql += "N'" +  ctpbt.getGhiChu()+ "');";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaBT , String MaSP) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "DELETE FROM ChiTietPhieuBaoTri WHERE MaBT = '" + MaBT + "' AND MaSP = '" + MaSP + "'"  ;
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
}
