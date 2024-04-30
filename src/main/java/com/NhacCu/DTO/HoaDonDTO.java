package com.NhacCu.DTO;

public class HoaDonDTO {
	private String MaHoaDon ; 
	private String  MaNhanVien ; 
	private String MaUser ; 
	private String NgayLap ; 
	private int TongTien ;
	private int Enable ;
	private int ThanhToan ;
	public HoaDonDTO(String maHoaDon, String maNhanVien, String maUser, String ngayLap, int tongTien, int enable,
			int thanhToan) {
	
		MaHoaDon = maHoaDon;
		MaNhanVien = maNhanVien;
		MaUser = maUser;
		NgayLap = ngayLap;
		TongTien = tongTien;
		Enable = enable;
		ThanhToan = thanhToan;
	}
	public HoaDonDTO() {
	
	}
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getMaUser() {
		return MaUser;
	}
	public void setMaUser(String maUser) {
		MaUser = maUser;
	}
	public String getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(String ngayLap) {
		NgayLap = ngayLap;
	}
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	public int getEnable() {
		return Enable;
	}
	public void setEnable(int enable) {
		Enable = enable;
	}
	public int getThanhToan() {
		return ThanhToan;
	}
	public void setThanhToan(int thanhToan) {
		ThanhToan = thanhToan;
	} 
	
	
	
}
