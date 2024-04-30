package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.HoaDonDTO;
import com.NhacCu.Connect.ConnectJDBC;

public class HoaDonDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public HoaDonDAO() {

	}
	public ArrayList<HoaDonDTO> list() {
		ArrayList<HoaDonDTO> ds = new ArrayList<HoaDonDTO>();
		try {
			String sql = "SELECT * FROM HoaDon  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaHoaDon = rs.getString("MaHD");
				String MaNhanVien = rs.getString("MaNhanVien");
				String MaUser = rs.getString("MaUser");
				String NgayLap = rs.getString("NgayLap");
				int TongTien = rs.getInt("TongTien");
				int TrangThai = rs.getInt("Enable");
				int ThanhToan = rs.getInt("ThanhToan");
				HoaDonDTO hoaDonDTO = new HoaDonDTO(MaHoaDon , MaNhanVien , MaUser , NgayLap , TongTien , TrangThai , ThanhToan);
				ds.add(hoaDonDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}
	public void update(HoaDonDTO hd) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE HoaDon SET ";
		sql += "MaNhanVien = N'" + hd.getMaNhanVien() + "', ";
		sql += "MaUser = N'" + hd.getMaUser() + "', ";
		sql += "NgayLap = N'" + hd.getNgayLap() + "', ";
		sql += "TongTien = " + hd.getTongTien() + ", ";
		sql += "Enable = " + hd.getEnable() + " , ";
		sql += "ThanhToan = " + hd.getThanhToan() + "  ";
		sql += "Where MaHD = '" + hd.getMaHoaDon() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(HoaDonDTO hd) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO HoaDon  VALUES(";
		sql += "N'" +   hd.getMaHoaDon() + "',";
		sql += "N'" +  hd.getMaNhanVien() + "',";
		sql += "N'" + hd.getMaUser() + "',";
		sql += "N'" + hd.getNgayLap() + "',";
		sql += "" + hd.getTongTien() + ",";
		sql += "" + hd.getEnable() + ",";
		sql += "" +  hd.getThanhToan() + ");";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaHoaDon ) {
		ConnectJDBC connection = new ConnectJDBC();
		String sqlCTHD = "DELETE FROM ChiTietHD WHERE MaHD = '" + MaHoaDon + "'";
		String sql = "DELETE FROM HoaDon WHERE MaHD = '" + MaHoaDon + "'";
		System.out.println(sqlCTHD);
		System.out.println(sql);
		connection.executeUpdate(sqlCTHD);
		connection.executeUpdate(sql);
	}
}
