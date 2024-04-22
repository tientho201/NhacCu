package com.NhacCu.DTO;

public class SanPhamDTO {
	private String MaSanPham;
	private String TenSanPham ;
	private int SoLuong ; 
	private int Gia  ;
	private String MaLoai ; 
	private String MaNSX;
	private String Image ; 
	private String GhiChu ; 
	public SanPhamDTO(String maSanPham, String tenSanPham, int soLuong, int gia, String maLoai, String maNSX , String image ,  String ghiChu) {
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		SoLuong = soLuong;
		Gia = gia;
		MaLoai = maLoai;
		MaNSX = maNSX;
		Image = image ; 
		GhiChu = ghiChu ; 
	}
	public SanPhamDTO() {
	
	}
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getMaNSX() {
		return MaNSX;
	}
	public void setMaNSX(String maNSX) {
		MaNSX = maNSX;
	}
	@Override
	public String toString() {
		return "SanPhamDTO [MaSanPham=" + MaSanPham + ", TenSanPham=" + TenSanPham + ", SoLuong=" + SoLuong + ", Gia="
				+ Gia + ", MaLoai=" + MaLoai + ", MaNSX=" + MaNSX + ", Image=" + Image + ", GhiChu=" + GhiChu + "]";
	}
	
	
}
