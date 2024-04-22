package com.NhacCu.DTO;

public class PhieuNhapHangDTO {
	private String MaPNH ; 
	private String MaNCC ; 
	private String MaNhanVien ; 
	private String NgayNhap ; 
	private int TongTien ;
	private int Enable ;
	public PhieuNhapHangDTO(String maPNH, String maNCC, String maNhanVien, String ngayNhap, int tongTien, int enable) {
		
		MaPNH = maPNH;
		MaNCC = maNCC;
		MaNhanVien = maNhanVien;
		NgayNhap = ngayNhap;
		TongTien = tongTien;
		Enable = enable;
	}
	public PhieuNhapHangDTO() {
		
	}
	public String getMaPNH() {
		return MaPNH;
	}
	public void setMaPNH(String maPNH) {
		MaPNH = maPNH;
	}
	public String getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		NgayNhap = ngayNhap;
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
	@Override
	public String toString() {
		return "PhieuNhapHangDTO [MaPNH=" + MaPNH + ", MaNCC=" + MaNCC + ", MaNhanVien=" + MaNhanVien + ", NgayNhap="
				+ NgayNhap + ", TongTien=" + TongTien + ", Enable=" + Enable + "]";
	}

	
	
}
