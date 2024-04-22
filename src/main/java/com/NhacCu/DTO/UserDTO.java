package com.NhacCu.DTO;

public class UserDTO {
	private String MaUser, TenDangNhap , HovaTen ,GioiTinh, NgaySinh , SDT , DiaChi , GhiChu ;
	private int Enable  ; 
	public UserDTO() {
	
	}
	
	public UserDTO(String maUser,  String tenDangNhap, String hovaTen,String gioiTinh ,String ngaySinh, String sDT, String diaChi ,String ghiChu, int enable ) {
		MaUser = maUser;
		TenDangNhap = tenDangNhap;
		HovaTen = hovaTen;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		SDT = sDT;
		DiaChi = diaChi;
		Enable = enable ; 
		GhiChu =  ghiChu;
	}
	
	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	public String getMaUser() {
		return MaUser;
	}
	public void setMaUser(String maUser) {
		MaUser = maUser;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getTenDangNhap() {
		return TenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}


	public String getHovaTen() {
		return HovaTen;
	}

	public void setHovaTen(String hovaTen) {
		HovaTen = hovaTen;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public int getEnable() {
		return Enable;
	}

	public void setEnable(int enable) {
		Enable = enable;
	}


	
}
