package com.NhacCu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.UserDTO;
import com.NhacCu.Connect.ConnectJDBC;
public class UserDAO {
	private ConnectJDBC connection = new ConnectJDBC();
	public UserDAO() {
		
	}
	public ArrayList<UserDTO> list(){
		ArrayList<UserDTO> dsU = new ArrayList<UserDTO>();
		   try {
	           
	            String sql = "SELECT * FROM Userr  ";
	            ResultSet rs = connection.executeQuery(sql);
	            while(rs.next())
	            {
	            	String MaUser = rs.getString("MaUser");
	                String tenDangNhap = rs.getString("TenDangNhap");
	                String hovaTen = rs.getString("HovaTen");
	                String gioiTinh = rs.getString("GioiTinh");
	                String ngaySinh = rs.getString("NgaySinh");
	                String sDT = rs.getString("SDT");
	                String diaChi = rs.getString("DiaChi");
	                String ghiChu = rs.getString("GhiChu");
	                int enable = rs.getInt("enable");
	                UserDTO us= new UserDTO( MaUser,tenDangNhap, hovaTen,gioiTinh ,ngaySinh, sDT , diaChi ,ghiChu, enable  );
	                dsU.add(us);
	            }
	            rs.close();
	            connection.disConnect();
	        } catch (SQLException ex) {
	            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
		return dsU;
	}
	public void update(UserDTO us) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE Userr SET "; 
		sql += "TenDangNhap = N'" + us.getTenDangNhap() +"', ";
		sql += "TenNhanVien = N'" + us.getHovaTen() +"', ";
		sql += "GioiTinh = N'" + us.getGioiTinh() +"', ";
		sql += "NgaySinh = N'" + us.getNgaySinh() +"', ";
		sql += "SDT = N'" + us.getSDT() +"', ";
		sql += "DiaChi = N'" + us.getDiaChi() +"', ";
		sql += "GhiChu = N'" + us.getGhiChu() +"', ";
		sql += "enable = " + us.getEnable() +" ";
		sql += "Where MaUser = '"+us.getMaUser()+"';";
	    System.out.println(sql);
	    connection.executeUpdate(sql);
	}
	public void add(UserDTO us) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO Userr  VALUES(";
		sql += "N'" + us.getMaUser() +"',";
		sql += "N'" + us.getTenDangNhap() +"',";
		sql += "N'" + us.getHovaTen() +"',";
		sql += "N'" + us.getGioiTinh() +"', ";
		sql += "N'" + us.getNgaySinh() +"',";
		sql += "N'" + us.getSDT() +"',";
		sql += "N'" + us.getDiaChi() +"',";
		sql += "N'" + us.getGhiChu() +"',";
		sql += "" + us.getEnable() +");";
		System.out.println(sql);
	    connection.executeUpdate(sql);
	}
	public void delete(String MaNhanVien) {
	  	ConnectJDBC connection = new ConnectJDBC();
		String sqlUser = "UPDATE Userr SET enable = 0 WHERE MaUser='"+ MaNhanVien+"'";
        connection.executeUpdate(sqlUser);
	}
}
