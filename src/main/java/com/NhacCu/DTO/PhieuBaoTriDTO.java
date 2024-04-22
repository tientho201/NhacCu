package com.NhacCu.DTO;

public class PhieuBaoTriDTO {
	private String MaBT ; 
	private String MaNV ; 
	private String MaUser ; 
	private String MaHD  ; 
	private String NgayLap ; 
	private int Enable ;
	public PhieuBaoTriDTO(String maBT, String maNV, String maUser, String maHD, String ngayLap, int enable) {
		
		MaBT = maBT;
		MaNV = maNV;
		MaUser = maUser;
		MaHD = maHD;
		NgayLap = ngayLap;
		Enable = enable;
	}
	public PhieuBaoTriDTO() {
		
	}
	public String getMaBT() {
		return MaBT;
	}
	public void setMaBT(String maBT) {
		MaBT = maBT;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getMaUser() {
		return MaUser;
	}
	public void setMaUser(String maUser) {
		MaUser = maUser;
	}
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public String getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(String ngayLap) {
		NgayLap = ngayLap;
	}
	public int getEnable() {
		return Enable;
	}
	public void setEnable(int enable) {
		Enable = enable;
	}
	@Override
	public String toString() {
		return "PhieuBaoTriDTO [MaBT=" + MaBT + ", MaNV=" + MaNV + ", MaUser=" + MaUser + ", MaHD=" + MaHD
				+ ", NgayLap=" + NgayLap + ", Enable=" + Enable + "]";
	} 
}
