package com.NhacCu.DTO;

public class NhaCungCapDTO {
	private String MaNCC ; 
	private String TenNCC ; 
	private String DiaChiNCC ; 
	private String SDTNCC ; 
	
	private String GhiChu;
	public NhaCungCapDTO(String maNCC, String tenNCC, String diaChiNCC, String sDTNCC,String ghiChu) {

		MaNCC = maNCC;
		TenNCC = tenNCC;
		DiaChiNCC = diaChiNCC;
		SDTNCC = sDTNCC;
		GhiChu = ghiChu;
		
	}
	public NhaCungCapDTO() {
	
	}
	public String getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}
	public String getTenNCC() {
		return TenNCC;
	}
	public void setTenNCC(String tenNCC) {
		TenNCC = tenNCC;
	}
	public String getDiaChiNCC() {
		return DiaChiNCC;
	}
	public void setDiaChiNCC(String diaChiNCC) {
		DiaChiNCC = diaChiNCC;
	}
	public String getSDTNCC() {
		return SDTNCC;
	}
	public void setSDTNCC(String sDTNCC) {
		SDTNCC = sDTNCC;
	}
	
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}



	
}
