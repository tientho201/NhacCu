package com.NhacCu.DTO;

public class ChiTietHoaDonDTO {
	private String MaSanPham;
	private String MaHoaDon;
	private int SoLuong;
	private int Gia;
	private int ThoiGianBaoHanh ; 
	private String GhiChu ;
	public ChiTietHoaDonDTO(String maSanPham, String maHoaDon, int soLuong, int gia, int thoiGianBaoHanh,
			String ghiChu) {
		MaSanPham = maSanPham;
		MaHoaDon = maHoaDon;
		SoLuong = soLuong;
		Gia = gia;
		ThoiGianBaoHanh = thoiGianBaoHanh;
		GhiChu = ghiChu;
	}
	public ChiTietHoaDonDTO() {
	
	}
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
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
	public int getThoiGianBaoHanh() {
		return ThoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		ThoiGianBaoHanh = thoiGianBaoHanh;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDonDTO [MaSanPham=" + MaSanPham + ", MaHoaDon=" + MaHoaDon + ", SoLuong=" + SoLuong + ", Gia="
				+ Gia + ", ThoiGianBaoHanh=" + ThoiGianBaoHanh + ", GhiChu=" + GhiChu + "]";
	}
	

}
