package com.NhacCu.DTO;

public class LoaiDTO {
	private String MaLoai ; 
	private String TenLoai ;
	public LoaiDTO(String maLoai, String tenLoai) {
		
		MaLoai = maLoai;
		TenLoai = tenLoai;
	}
	public LoaiDTO() {
	
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	@Override
	public String toString() {
		return "Loai [MaLoai=" + MaLoai + ", TenLoai=" + TenLoai + "]";
	}
	
}
