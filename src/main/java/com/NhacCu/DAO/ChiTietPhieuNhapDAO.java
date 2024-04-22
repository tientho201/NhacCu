package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.ChiTietPhieuNhapDTO;
import com.NhacCu.Connect.ConnectJDBC;

public class ChiTietPhieuNhapDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public ChiTietPhieuNhapDAO() {

	}
	public ArrayList<ChiTietPhieuNhapDTO> list() {
		ArrayList<ChiTietPhieuNhapDTO> ds = new ArrayList<ChiTietPhieuNhapDTO>();
		try {
			String sql = "SELECT * FROM ChiTietPhieuNhap  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaSP = rs.getString("MaSP");
				String MaPNH = rs.getString("MaPNH");
				int DonGiaNhap = rs.getInt("DonGiaNhap");
				int SoLuong = rs.getInt("SoLuong");
				String GhiChu = rs.getString("GhiChu");
				ChiTietPhieuNhapDTO ctpnDTO = new  ChiTietPhieuNhapDTO(MaSP , MaPNH , DonGiaNhap , SoLuong  , GhiChu);
				ds.add(ctpnDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}
	public void update(ChiTietPhieuNhapDTO ctpn) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE ChiTietPhieuNhap SET ";
		sql += "DonGiaNhap = " + ctpn.getDonGiaNhap() + ", ";
		sql += "SoLuong = " + ctpn.getSoLuong() + ", ";
		sql += "GhiChu = N'" + ctpn.getGhiChu() + "'  ";
		sql += "Where MaSP = '" + ctpn.getMaSP() + "' AND  MaPNH = '" + ctpn.getMaPNH() +"';" ;
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(ChiTietPhieuNhapDTO ctpn) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO ChiTietPhieuNhap  VALUES(";
		sql += "'" +  ctpn.getMaSP()+ "',";
		sql += "'" +  ctpn.getMaPNH()+ "',";
		sql += "" +  ctpn.getDonGiaNhap()+ ",";
		sql += "" +  ctpn.getSoLuong()+ ",";
		sql += "N'" +  ctpn.getGhiChu()+ "');";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaPNH , String MaSP) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "DELETE FROM ChiTietPhieuNhap WHERE MaPNH = '" + MaPNH + "' AND MaSP = '" + MaSP + "'"  ;
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
}
