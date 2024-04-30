package com.NhacCu.BUS;

import java.util.ArrayList;

import com.NhacCu.DAO.SanPhamDAO;
import com.NhacCu.DTO.SanPhamDTO;

public class SanPhamBUS {
	private ArrayList<SanPhamDTO> dssp;

	public SanPhamBUS() {

	}

	public SanPhamBUS(int i1) {
		listSP();
	}

	public ArrayList<SanPhamDTO> getList() {
		return dssp;
	}

	public SanPhamDTO get(String MaSP) {
		for (SanPhamDTO sp : dssp) {
			if (sp.getMaSanPham().equals(MaSP)) {
				return sp;
			}
		}
		return null;
	}

	public void listSP() {
		SanPhamDAO spDAO = new SanPhamDAO();
		dssp = new ArrayList<>();
		dssp = spDAO.list();

	}

	public void addSP(SanPhamDTO sp) {
		dssp.add(sp);
		SanPhamDAO spDAO = new SanPhamDAO();
		spDAO.add(sp);
	}

	public void updateSP(SanPhamDTO sp) {
		for (int i = 0; i < dssp.size(); i++) {
			if (dssp.get(i).getMaSanPham().equals(sp.getMaSanPham())) {
				dssp.set(i, sp);
				SanPhamDAO spDAO = new SanPhamDAO();
				spDAO.update(sp);
			}
		}
	}

	public void delete(String MaSP) {
		for (SanPhamDTO sp : dssp) {
			if (sp.getMaSanPham().equals(MaSP)) {
				dssp.remove(sp);
				SanPhamDAO spDAO = new SanPhamDAO();
				spDAO.delete(MaSP);
				return;
			}
		}
	}

	

	public boolean checkMaSP(String maSP) {
		for (SanPhamDTO sp : dssp) {
			if (sp.getMaSanPham().equals(maSP)) {
				return true;
			}
		}
		return false;
	}
	public String PutOnTenSP(String maSP) {
		for (SanPhamDTO sp : dssp) {
			if (sp.getMaSanPham().equals(maSP)) {
				return sp.getTenSanPham();
			}
		}
		return null ; 
	}

}
