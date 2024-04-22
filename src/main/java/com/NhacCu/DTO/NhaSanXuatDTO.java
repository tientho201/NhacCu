package com.NhacCu.DTO;

public class NhaSanXuatDTO {
	private String MaNSX ; 
	private String TenNSX ;
	public NhaSanXuatDTO(String maNSX, String tenNSX) {
		MaNSX = maNSX;
		TenNSX = tenNSX;
	}
	
	public NhaSanXuatDTO() {
		
	}

	public String getMaNSX() {
		return MaNSX;
	}

	public void setMaNSX(String maNSX) {
		MaNSX = maNSX;
	}

	public String getTenNSX() {
		return TenNSX;
	}

	public void setTenNSX(String tenNSX) {
		TenNSX = tenNSX;
	}

	@Override
	public String toString() {
		return "NhaSanXuatDTO [MaNSX=" + MaNSX + ", TenNSX=" + TenNSX + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	} 
	
}
