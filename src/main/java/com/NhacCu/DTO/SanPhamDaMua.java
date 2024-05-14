package com.NhacCu.DTO;


public class SanPhamDaMua {
    private String maSP;
    private String tenSP;
    private int gia;
    private int soLuong;

    public SanPhamDaMua(String maSP, String tenSP, int gia, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }
}
