package com.NhacCu.DTO;

public class HoaDonDTO {
	private String MaHoaDon ; 
	private String  MaNhanVien ; 
	private String MaUser ; 
	private String NgayLap ; 
	private int TongTien ;
	private String TrangThai ;
	public HoaDonDTO(String maHoaDon, String maNhanVien, String maUser, String ngayLap, int tongTien,
			String trangThai) {
		
		MaHoaDon = maHoaDon;
		MaNhanVien = maNhanVien;
		MaUser = maUser;
		NgayLap = ngayLap;
		TongTien = tongTien;
		TrangThai = trangThai;
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
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	@Override
	public String toString() {
		return "HoaDonDTO [MaHoaDon=" + MaHoaDon + ", MaNhanVien=" + MaNhanVien + ", MaUser=" + MaUser + ", NgayLap="
				+ NgayLap + ", TongTien=" + TongTien + ", TrangThai=" + TrangThai + "]";
	} 
	
	
}
