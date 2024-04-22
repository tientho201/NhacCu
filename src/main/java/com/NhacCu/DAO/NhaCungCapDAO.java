package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.NhaCungCapDTO;
import com.NhacCu.Connect.ConnectJDBC;

public class NhaCungCapDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public NhaCungCapDAO() {

	}
	public ArrayList<NhaCungCapDTO> list() {
		ArrayList<NhaCungCapDTO> dsNCC = new ArrayList<NhaCungCapDTO>();
		try {
			String sql = "SELECT * FROM NhaCungCap  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaNCC = rs.getString("MaNCC");
				String TenNCC = rs.getString("TenNCC");
				String DiaChiNCC = rs.getString("DiaChiNCC");
				String SDTNCC = rs.getString("SDTNCC");
				String GhiChu = rs.getString("GhiChu");
			
				NhaCungCapDTO nccDTO = new NhaCungCapDTO(MaNCC,TenNCC,DiaChiNCC,SDTNCC,GhiChu);
				dsNCC.add(nccDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return dsNCC;
	}
	public void update(NhaCungCapDTO ncc) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE NhaCungCap SET ";
		sql += "TenNCC = N'" + ncc.getTenNCC() + "', ";
		sql += "DiaChiNCC = N'" + ncc.getDiaChiNCC() + "', ";
		sql += "SDTNCC = N'" + ncc.getSDTNCC() + "', ";
		sql += "GhiChu = N'" + ncc.getGhiChu() + "'";
		sql += "Where MaNCC = '" + ncc.getMaNCC() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(NhaCungCapDTO ncc) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO NhaCungCap  VALUES(";
		sql += "N'" +  ncc.getMaNCC()+ "',";
		sql += "N'" +  ncc.getTenNCC()+ "',";
		sql += "N'" +  ncc.getDiaChiNCC()+ "',";
		sql += "N'" +  ncc.getSDTNCC()+ "',";
		sql += "N'" +  ncc.getGhiChu()+ "');";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaNCC) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "DELETE FROM NhaCungCap WHERE MaNCC = '" + MaNCC + "'";
		String sqlPNH = "UPDATE PhieuNhap SET MaNCC = NULL WHERE MaNCC = '" + MaNCC+"'";
		System.out.println(sqlPNH);
		System.out.println(sql);
		connection.executeUpdate(sqlPNH);
		connection.executeUpdate(sql);
	}
}
