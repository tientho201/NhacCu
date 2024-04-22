package com.NhacCu.BUS;

import java.util.ArrayList;

import com.NhacCu.DAO.HoaDonDAO;
import com.NhacCu.DTO.HoaDonDTO;

public class HoaDonBUS {
	private ArrayList<HoaDonDTO> ds;

	public HoaDonBUS() {

	}

	public HoaDonBUS(int i1) {
		list();
	}

	public ArrayList<HoaDonDTO> getList() {
		return ds;
	}

	public HoaDonDTO get(String MaHD) {
		for (HoaDonDTO hd : ds) {
			if (hd.getMaHoaDon().equals(MaHD)) {
				return hd;
			}
		}
		return null;
	}

	public void list() {
		HoaDonDAO hoaDonDAO = new HoaDonDAO();
		ds = new ArrayList<>();
		ds = hoaDonDAO.list();

	}

	public void add(HoaDonDTO hd) {
		ds.add(hd);
		HoaDonDAO hoaDonDAO = new HoaDonDAO();
		hoaDonDAO.add(hd);
	}

	public void update(HoaDonDTO hd) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaHoaDon().equals(hd.getMaHoaDon())) {
				ds.set(i, hd);
				HoaDonDAO hoaDonDAO = new HoaDonDAO();
				hoaDonDAO.update(hd);
				return;
			}
		}
	}

	public void delete(String MaHD) {
		for (HoaDonDTO hd : ds) {
			if (hd.getMaHoaDon().equals(MaHD)) {
				ds.remove(hd);
				HoaDonDAO hoaDonDAO = new HoaDonDAO();
				hoaDonDAO.delete(MaHD);
				return;
			}
		}
	}

	
}
