package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.Connect.ConnectJDBC;
import com.NhacCu.DTO.*;

public class PhieuBaoTriDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public PhieuBaoTriDAO() {

	}
	public ArrayList<PhieuBaoTriDTO> list() {
		ArrayList<PhieuBaoTriDTO> ds = new ArrayList<PhieuBaoTriDTO>();
		try {
			String sql = "SELECT * FROM PhieuBaoTri  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaBT = rs.getString("MaBT");
				String MaNhanVien = rs.getString("MaNhanVien");
				String MaUser = rs.getString("MaUser");
				String MaHD = rs.getString("MaHD");
				String NgayNhap = rs.getString("NgayLap");
				int Enable = rs.getInt("Enable");
			
				PhieuBaoTriDTO pbtDTO = new PhieuBaoTriDTO(MaBT,MaNhanVien,MaUser,MaHD,NgayNhap,Enable);
				ds.add(pbtDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}
	public void update(PhieuBaoTriDTO pbt) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE PhieuBaoTri SET ";
		sql += "MaNhanVien = '" + pbt.getMaNV() + "', ";
		sql += "MaUser = '" + pbt.getMaUser() + "',";
		sql += "MaHD = '" + pbt.getMaHD() + "',";
		sql += "NgayLap = N'" + pbt.getNgayLap() + "', ";
		sql += "Enable = " + pbt.getEnable() + " ";
		sql += "Where MaBT = '" + pbt.getMaBT() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(PhieuBaoTriDTO pbt) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO PhieuBaoTri  VALUES(";
		sql += "'" +   pbt.getMaBT() + "',";
		sql += "'" +  pbt.getMaNV() + "',";
		sql += "'" + pbt.getMaUser() + "',";
		sql += "'" +  pbt.getMaHD() +  "',";
		sql += "N'" +  pbt.getNgayLap() +  "',";
		sql += "" +  pbt.getEnable() + ");";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaBT ) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "DELETE FROM PhieuBaoTri WHERE MaBT = '" + MaBT + "'";
		String sqlCTPBT = "DELETE FROM ChiTietPhieuBaoTri WHERE MaBT = '" + MaBT + "'";
		System.out.println(sqlCTPBT);
		System.out.println(sql);
		connection.executeUpdate(sqlCTPBT);
		connection.executeUpdate(sql);
	}
}
