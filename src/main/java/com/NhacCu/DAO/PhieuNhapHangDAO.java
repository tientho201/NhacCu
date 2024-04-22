package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.PhieuNhapHangDTO;
import com.NhacCu.Connect.ConnectJDBC;

public class PhieuNhapHangDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public PhieuNhapHangDAO() {

	}
	public ArrayList<PhieuNhapHangDTO> list() {
		ArrayList<PhieuNhapHangDTO> ds = new ArrayList<PhieuNhapHangDTO>();
		try {
			String sql = "SELECT * FROM PhieuNhap  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaPNH = rs.getString("MaPNH");
				String MaNhanVien = rs.getString("MaNhanVien");
				String MaNCC = rs.getString("MaNCC");
				String NgayNhap = rs.getString("NgayNhap");
				int TongTien = rs.getInt("TongTien");
				int Enable = rs.getInt("Enable");
			
				PhieuNhapHangDTO pnhDTO = new PhieuNhapHangDTO(MaPNH,MaNCC,MaNhanVien,NgayNhap,TongTien,Enable);
				ds.add(pnhDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}
	public void update(PhieuNhapHangDTO pnh) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE PhieuNhap SET ";
		sql += "MaNCC = N'" + pnh.getMaNCC() + "', ";
		sql += "MaNhanVien = N'" + pnh.getMaNhanVien() + "', ";
		sql += "NgayNhap = N'" + pnh.getNgayNhap() + "', ";
		sql += "TongTien = " + pnh.getTongTien() + ",";
		sql += "Enable = " + pnh.getEnable() + " ";
		sql += "Where MaPNH = '" + pnh.getMaPNH() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(PhieuNhapHangDTO pnh) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO PhieuNhap  VALUES(";
		sql += "N'" +   pnh.getMaPNH() + "',";
		sql += "N'" +  pnh.getMaNCC() + "',";
		sql += "N'" + pnh.getMaNhanVien() + "',";
		sql += "N'" +  pnh.getNgayNhap() +  "',";
		sql += "" + pnh.getTongTien() + ",";
		sql += "" +  pnh.getEnable() + ");";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaPNH ) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "DELETE FROM PhieuNhap WHERE MaPNH = '" + MaPNH + "'";
		String sqlCTPN = "DELETE FROM ChiTietPhieuNhap WHERE MaPNH = '" + MaPNH + "'";
		System.out.println(sqlCTPN);
		System.out.println(sql);
		connection.executeUpdate(sqlCTPN);
		connection.executeUpdate(sql);
	}
}
