package com.NhacCu.DTO;

public class AccountDTO {
	private String TenDangNhap , Password , Role ; 
	private int Enable ; 
	public AccountDTO() {
	
	}
	public AccountDTO(String tenDangNhap, String password, String role , int enable ) {
		TenDangNhap = tenDangNhap;
		Password = password;
		Role = role;
		Enable = enable ; 
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getEnable() {
		return Enable;
	}
	public void setEnable(int enable) {
		Enable = enable;
	}
	

	
}
