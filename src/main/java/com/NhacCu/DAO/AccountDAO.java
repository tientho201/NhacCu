package com.NhacCu.DAO;

import com.NhacCu.DTO.AccountDTO;
import com.NhacCu.Connect.ConnectJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AccountDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public AccountDAO() {
		
	}
	public ArrayList<AccountDTO> list(){
		 ArrayList<AccountDTO> dsAC = new ArrayList<AccountDTO>();
		 try {
			 String sql = "SELECT * FROM Account "; 
			  ResultSet rs = connection.executeQuery(sql);
			  while(rs.next()) {
				  String tenDangNhap = rs.getString("TenDangNhap");
				  String password = rs.getString("password"); 
				  String role = rs.getString("role"); 
				  int enable = rs.getInt("enable"); 
				  AccountDTO accountDTO = new AccountDTO(tenDangNhap , password , role, enable);
				  dsAC.add(accountDTO);
			  }
			  rs.close();
			  connection.disConnect();
		 }catch(SQLException ex) {
			 Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
		 }
		return dsAC;
		
	}
	public void add(AccountDTO acc) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO Account  VALUES(";
		sql += "'" + acc.getTenDangNhap() +"',";
		sql += "'" + acc.getPassword() +"', ";
		sql += "'" + acc.getRole() +"',";
		sql += "" + acc.getEnable() +");";
		System.out.println(sql);
	    connection.executeUpdate(sql);
	}
	public void update(AccountDTO acc) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE Account SET ";
		sql += "password = '" + acc.getPassword() +"', ";
		sql += "role = '" + acc.getRole() +"', ";
		sql += "enable = " + acc.getEnable() +" ";
		sql += "Where TenDangNhap = '"+acc.getTenDangNhap()+"';";
	    System.out.println(sql);
	    connection.executeUpdate(sql);
	}
	public void delete(String TenDangNhap) {
		ConnectJDBC connection = new ConnectJDBC();
        String sqlAccount = "UPDATE Account SET enable = 0 WHERE TenDangNhap='"+ TenDangNhap+"'";
//        String sqlAccount = "DELETE FROM Account WHERE TenDangNhap = '" + TenDangNhap + "'";
        connection.executeUpdate(sqlAccount);
	}
	public void deleteAcc_NV(String TenDangNhap) {
		ConnectJDBC connection = new ConnectJDBC();
		String sqlNhanVien = "DELETE FROM NhanVien WHERE TenDangNhap = '" + TenDangNhap + "'";
		String sqlAccount = "DELETE FROM Account WHERE TenDangNhap = '" + TenDangNhap + "'";
		System.out.println(sqlNhanVien);
		System.out.println(sqlAccount);
		connection.executeUpdate(sqlNhanVien);
		connection.executeUpdate(sqlAccount);
	}
	public void deleteAcc_User(String TenDangNhap) {
		ConnectJDBC connection = new ConnectJDBC();
		String sqlUser = "DELETE FROM Userr WHERE TenDangNhap = '" + TenDangNhap + "'";
		String sqlAccount = "DELETE FROM Account WHERE TenDangNhap = '" + TenDangNhap + "'";
		System.out.println(sqlUser);
		System.out.println(sqlAccount);
		connection.executeUpdate(sqlUser);
		connection.executeUpdate(sqlAccount);
	}
}
