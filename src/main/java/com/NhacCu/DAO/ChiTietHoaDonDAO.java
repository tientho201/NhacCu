package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.ChiTietHoaDonDTO;
import com.NhacCu.Connect.ConnectJDBC;

public class ChiTietHoaDonDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public ChiTietHoaDonDAO() {

	}
	public ArrayList<ChiTietHoaDonDTO> list() {
		ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<ChiTietHoaDonDTO>();
		try {
			String sql = "SELECT * FROM ChiTietHD  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaSP = rs.getString("MaSP");
				String MaHD = rs.getString("MaHD");
				int SoLuong = rs.getInt("SoLuong");
				int Gia = rs.getInt("Gia");
				int ThoiGianBaoHang = rs.getInt("ThoiGianBaoHanh");
				String GhiChu = rs.getString("GhiChu");
				ChiTietHoaDonDTO cthdDTO = new  ChiTietHoaDonDTO(MaSP , MaHD , SoLuong , Gia  ,ThoiGianBaoHang, GhiChu);
				ds.add(cthdDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}
	public void update(ChiTietHoaDonDTO cthd) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE ChiTietHD SET ";
		sql += "SoLuong = " + cthd.getSoLuong() + ", ";
		sql += "Gia = " + cthd.getGia() + ", ";
		sql += "ThoiGianBaoHanh = " + cthd.getThoiGianBaoHanh() + ", ";
		sql += "GhiChu = N'" + cthd.getGhiChu() + "'  ";
		sql += "Where MaSP = '" + cthd.getMaSanPham() + "' AND  MaHD = '" + cthd.getMaHoaDon() +"';" ;
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(ChiTietHoaDonDTO cthd) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO ChiTietHD  VALUES(";
		sql += "'" +  cthd.getMaSanPham()+ "',";
		sql += "'" +  cthd.getMaHoaDon()+ "',";
		sql += "" +  cthd.getSoLuong()+ ",";
		sql += "" +  cthd.getGia()+ ",";
		sql += "" +  cthd.getThoiGianBaoHanh()+ ",";
		sql += "N'" +  cthd.getGhiChu()+ "');";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaSP , String MaHD) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "DELETE FROM ChiTietPhieuNhap WHERE MaHD = '" + MaHD + "' AND MaSP = '" + MaSP + "'"  ;
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
}
