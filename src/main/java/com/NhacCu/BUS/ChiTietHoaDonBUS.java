package com.NhacCu.BUS;

import java.util.ArrayList;

import com.NhacCu.DAO.ChiTietHoaDonDAO;
import com.NhacCu.DTO.ChiTietHoaDonDTO;


public class ChiTietHoaDonBUS {
	private ArrayList<ChiTietHoaDonDTO> ds;

	public ChiTietHoaDonBUS() {

	}

	public ChiTietHoaDonBUS(int i1) {
		list();
	}

	public ArrayList<ChiTietHoaDonDTO> getList() {
		return ds;
	}

	public ChiTietHoaDonDTO get(String MaHoaDon, String MaSP) {
		for (ChiTietHoaDonDTO cthd : ds) {
			if (cthd.getMaHoaDon().equals(MaHoaDon) && cthd.getMaSanPham().equals(MaSP)) {
				return cthd;
			}
		}
		return null;
	}

	public void list() {
		ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
		ds = new ArrayList<>();
		ds = cthdDAO.list();

	}

	public void add(ChiTietHoaDonDTO cthd) {
		ds.add(cthd);
		ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
		cthdDAO.add(cthd);
	}

	public void update(ChiTietHoaDonDTO cthd) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaHoaDon().equals(cthd.getMaHoaDon()) && ds.get(i).getMaSanPham().equals(cthd.getMaSanPham())) {
				ds.set(i, cthd);
				ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
				cthdDAO.update(cthd);
				return;
			}
		}
	}

	public void delete(String MaSP, String MaHoaDon) {
		for (ChiTietHoaDonDTO cthd : ds) {
			if (cthd.getMaHoaDon().equals(MaHoaDon) && cthd.getMaSanPham().equals(MaSP)) {
				ds.remove(cthd);
				ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
				cthdDAO.delete(MaSP, MaHoaDon);
				return;
			}
		}
	}

}
