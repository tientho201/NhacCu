package com.NhacCu.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.SanPhamDTO;
import com.NhacCu.Connect.ConnectJDBC;

public class SanPhamDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public SanPhamDAO() {

	}

	public ArrayList<SanPhamDTO> list() {
		ArrayList<SanPhamDTO> dssp = new ArrayList<SanPhamDTO>();
		try {
			String sql = "SELECT * FROM SanPham  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaSP = rs.getString("MaSP");
				String TenSP = rs.getString("TenSP");
				int SoLuong = rs.getInt("SoLuong");
				int Gia = rs.getInt("Gia");
				String MaLoai = rs.getString("MaLoai");
				String MaNSX = rs.getString("MaNSX");
				String Image = rs.getString("Image");
				String GhiChu = rs.getString("GhiChu");
				SanPhamDTO spDTO = new SanPhamDTO(MaSP, TenSP, SoLuong, Gia, MaLoai, MaNSX, Image, GhiChu);
				dssp.add(spDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return dssp;
	}

	public void update(SanPhamDTO sp) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE SanPham SET ";
		sql += "TenSP = N'" + sp.getTenSanPham() + "', ";
		sql += "SoLuong = '" + sp.getSoLuong() + "', ";
		sql += "Gia = '" + sp.getGia() + "', ";
		sql += "MaLoai = N'" + sp.getMaLoai() + "', ";
		sql += "MaNSX = N'" + sp.getMaNSX() + "', ";
		sql += "Image = N'" + sp.getImage() + "',";
		sql += "GhiChu = N'" + sp.getGhiChu() + "' ";
		sql += "Where MaSP = '" + sp.getMaSanPham() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void add(SanPhamDTO sp) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO SanPham  VALUES(";
		sql += "N'" + sp.getMaSanPham() + "',";
		sql += "N'" + sp.getTenSanPham() + "',";
		sql += "'" + sp.getSoLuong() + "', ";
		sql += "'" + sp.getGia() + "',";
		sql += "N'" + sp.getMaLoai() + "',";
		sql += "N'" + sp.getMaNSX() + "',";
		sql += "N'" + sp.getImage() + "',";
		sql += "N'" + sp.getGhiChu() + "');";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String maSP) {
		ConnectJDBC connection = new ConnectJDBC();
		String sqlHD = "UPDATE ChiTietHD SET MaSP = NULL WHERE MaSP = '" + maSP + "'";
		String sqlpbt = "UPDATE ChiTietPhieuBaoTri SET MaSP = NULL WHERE MaSP = '" + maSP + "'";
		String sqlPNH = "UPDATE ChiTietPhieuNhap SET MaSP = NULL WHERE MaSP = '" + maSP + "'";
		String sqlSanPham = "DELETE FROM SanPham WHERE MaSP = '" + maSP + "'";
		System.out.println(sqlPNH);
		connection.executeUpdate(sqlPNH);
		System.out.println(sqlHD);
		connection.executeUpdate(sqlHD);
		System.out.println(sqlpbt);
		connection.executeUpdate(sqlpbt);
		System.out.println(sqlSanPham);
		connection.executeUpdate(sqlSanPham);
	}
}
