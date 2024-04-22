package com.NhacCu.DTO;

public class ChiTietPhieuBaoTriDTO {
	private String MaSP ; 
	private String MaBT ; 
	private String GhiChu ;
	public ChiTietPhieuBaoTriDTO() {
	
	}
	public ChiTietPhieuBaoTriDTO(String maSP, String maBT, String ghiChu) {
		
		MaSP = maSP;
		MaBT = maBT;
		GhiChu = ghiChu;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getMaBT() {
		return MaBT;
	}
	public void setMaBT(String maBT) {
		MaBT = maBT;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "ChiTietPhieuBaoTriDTO [MaSP=" + MaSP + ", MaBT=" + MaBT + ", GhiChu=" + GhiChu + "]";
	} 
	
}
