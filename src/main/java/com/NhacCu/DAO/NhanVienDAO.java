package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.NhanVienDTO;
import com.NhacCu.Connect.ConnectJDBC;

public class NhanVienDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public NhanVienDAO() {

	}

	public ArrayList<NhanVienDTO> list() {
		ArrayList<NhanVienDTO> dsnv = new ArrayList<NhanVienDTO>();
		try {
			String sql = "SELECT * FROM NhanVien  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaNhanVien = rs.getString("MaNhanVien");
				String tenDangNhap = rs.getString("TenDangNhap");
				String tenNhanVien = rs.getString("TenNhanVien");
				String gioiTinh = rs.getString("GioiTinh");
				String ngaySinh = rs.getString("NgaySinh");
				String sDT = rs.getString("SDT");
				String diaChi = rs.getString("DiaChi");
				String chucVu = rs.getString("ChucVu");
				String GhiChu = rs.getString("GhiChu");
				int enable = rs.getInt("enable");
				NhanVienDTO nv = new NhanVienDTO(MaNhanVien,tenDangNhap, tenNhanVien, gioiTinh, ngaySinh, sDT, diaChi,chucVu,GhiChu, enable);
				dsnv.add(nv);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return dsnv;
	}

	public void update(NhanVienDTO nv) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE NhanVien SET ";
		sql += "TenDangNhap = N'" + nv.getTenDangNhap() + "', ";
		sql += "TenNhanVien = N'" + nv.getTenNhanVien() + "', ";
		sql += "GioiTinh = N'" + nv.getGioiTinh() + "', ";
		sql += "NgaySinh = N'" + nv.getNgaySinh() + "', ";
		sql += "SDT = N'" + nv.getSDT() + "', ";
		sql += "DiaChi = N'" + nv.getDiaChi() + "', ";
		sql += "ChucVu = N'" + nv.getChucVu() + "', ";
		sql += "GhiChu = N'" + nv.getGhiChu() + "', ";
		sql += "enable = " + nv.getEnable() + " ";
		sql += "Where MaNhanVien = '" + nv.getMaNhanVien() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void add(NhanVienDTO nv) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO NhanVien  VALUES(";
		sql += "N'" + nv.getMaNhanVien() + "',";
		sql += "N'" + nv.getTenDangNhap() + "',";
		sql += "N'" + nv.getTenNhanVien() + "',";
		sql += "N'" + nv.getGioiTinh() + "', ";
		sql += "N'" + nv.getNgaySinh() + "',";
		sql += "N'" + nv.getSDT() + "',";
		sql += "N'" + nv.getDiaChi() + "',";
		sql += "N'" + nv.getChucVu() + "',";
		sql += "N'" + nv.getGhiChu() + "',";
		sql += "" + nv.getEnable() + ");";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String maNhanVien) {
		ConnectJDBC connection = new ConnectJDBC();
		String sqlNhanVien = "UPDATE NhanVien SET enable = 0 WHERE MaNhanVien='"+ maNhanVien+"'";
		connection.executeUpdate(sqlNhanVien);
	}
	
}
