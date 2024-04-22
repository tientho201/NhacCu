package com.NhacCu.DTO;

public class NhanVienDTO {
	private String  MaNhanVien, TenDangNhap , TenNhanVien ,GioiTinh ,NgaySinh , SDT, DiaChi,  ChucVu , GhiChu; 
	private int   Enable; 
	public NhanVienDTO() {
		
	}
	
	public NhanVienDTO(String maNhanVien ,String tenDangNhap, String tenNhanVien,String gioiTinh ,  String ngaySinh, String sDT, String diaChi,String chucVu,String ghiChu, int enable ) {
		MaNhanVien  = maNhanVien;
		TenDangNhap = tenDangNhap;
		TenNhanVien = tenNhanVien;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		SDT = sDT;
		DiaChi = diaChi; 
		ChucVu = chucVu;
		Enable = enable ; 
		GhiChu =  ghiChu;
	}

	

	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
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

	public String getTenNhanVien() {
		return TenNhanVien;
	}																																			

	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
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
	
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	public int getEnable() {
		return Enable;
	}
	public void setEnable(int enable) {
		Enable = enable;
	}



	
}
