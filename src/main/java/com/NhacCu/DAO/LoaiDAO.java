package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.LoaiDTO;
import com.NhacCu.Connect.ConnectJDBC;

public class LoaiDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public LoaiDAO() {

	}
	public ArrayList<LoaiDTO> list() {
		ArrayList<LoaiDTO> dsLoai = new ArrayList<LoaiDTO>();
		try {
			String sql = "SELECT * FROM Loai  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaLoai = rs.getString("MaLoai");
				String TenLoai = rs.getString("TenLoai");
				LoaiDTO loaiDTO = new LoaiDTO(MaLoai,TenLoai);
				dsLoai.add(loaiDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return dsLoai;
	}
	public void update(LoaiDTO Loai) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE Loai SET ";
		sql += "TenLoai = N'" + Loai.getTenLoai() + "' ";
		sql += "Where MaLoai = '" + Loai.getMaLoai() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(LoaiDTO loai) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO Loai  VALUES(";
		sql += "'" +  loai.getMaLoai()+ "',";
		sql += "N'" +loai.getTenLoai()  + "');";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaLoai) {
		ConnectJDBC connection = new ConnectJDBC();
		String sqlLoai = "DELETE FROM Loai WHERE MaLoai = '" + MaLoai + "'";
		String sqlSanPham = "UPDATE SanPham SET MaLoai = NULL WHERE MaLoai = '" + MaLoai+"'";
		System.out.println(sqlSanPham);
		connection.executeUpdate(sqlSanPham);
		System.out.println(sqlLoai);
		connection.executeUpdate(sqlLoai);
	}
}
