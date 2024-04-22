package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.NhaSanXuatDTO;
import com.NhacCu.Connect.ConnectJDBC;

public class NhaSanXuatDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public NhaSanXuatDAO() {

	}
	public ArrayList<NhaSanXuatDTO> list() {
		ArrayList<NhaSanXuatDTO> dsnsx = new ArrayList<NhaSanXuatDTO>();
		try {
			String sql = "SELECT * FROM NhaSanXuat  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaNSX = rs.getString("MaNSX");
				String TenNSX = rs.getString("TenNSX");
			
				NhaSanXuatDTO nsxDTO = new NhaSanXuatDTO(MaNSX,TenNSX);
				dsnsx.add(nsxDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return dsnsx;
	}
	public void update(NhaSanXuatDTO nsx) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE NhaSanXuat SET ";
		sql += "TenNCC = N'" + nsx.getTenNSX() + "', ";
		sql += "Where MaNCC = '" + nsx.getMaNSX() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(NhaSanXuatDTO nsx ) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO NhaSanXuat  VALUES(";
		sql += "'" +  nsx.getMaNSX()+ "',";
		sql += "N'" +  nsx.getTenNSX()+ "');";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaNSX) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "DELETE FROM NhaSanXuat WHERE MaNSX = '" + MaNSX + "'";
		String sqlSanPham = "UPDATE SanPham SET MaNSX = NULL WHERE MaNSX = '" + MaNSX+"'";
		System.out.println(sql);
		System.out.println(sqlSanPham);
		connection.executeUpdate(sqlSanPham);
		connection.executeUpdate(sql);
	}
}
