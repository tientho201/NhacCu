package com.NhacCu.BUS;

import java.util.ArrayList;

import com.NhacCu.DAO.NhaSanXuatDAO;
import com.NhacCu.DTO.NhaSanXuatDTO;

public class NhaSanXuatBUS {
	private ArrayList<NhaSanXuatDTO> ds;
	public NhaSanXuatBUS() {

	}

	public NhaSanXuatBUS(int i1) {
		list();
	}
	public ArrayList<NhaSanXuatDTO> getList() {
		return ds;
	}
	
	public NhaSanXuatDTO get(String MaNSX) {
		for (NhaSanXuatDTO nsx : ds) {
			if (nsx.getMaNSX().equals(MaNSX)) {
				return nsx;
			}
		}
		return null;
	}

	public void list() {
		NhaSanXuatDAO nsxDAO = new NhaSanXuatDAO();
		ds = new ArrayList<>();
		ds = nsxDAO.list();
	
	}

	public void add(NhaSanXuatDTO nsx) {
		ds.add(nsx);
		NhaSanXuatDAO nsxDAO = new NhaSanXuatDAO();
		nsxDAO.add(nsx);
	}

	public void update(NhaSanXuatDTO nsx) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaNSX().equals(nsx.getMaNSX())) {
				ds.set(i, nsx);
				NhaSanXuatDAO nsxDAO = new NhaSanXuatDAO();
				nsxDAO.update(nsx);
				return ; 
			}
		}
	}

	public void delete(String MaNSX) {
		for (NhaSanXuatDTO nsx : ds) {
			if (nsx.getMaNSX().equals(MaNSX)) {
				ds.remove(nsx);
				NhaSanXuatDAO nsxDAO = new NhaSanXuatDAO();
				nsxDAO.delete(MaNSX);
				return;
			}
		}
	}
	public boolean checkMaNSX(String maNSX) {
		for (NhaSanXuatDTO nsx : ds) {
			if (nsx.getMaNSX().equals(maNSX)) {
				return true;
			}
		}
			return false;
	}
	public String PutOnTenNSX(String maNSX) {
		for (NhaSanXuatDTO nsx : ds) {
			if (nsx.getMaNSX().equals(maNSX)) {
				return nsx.getTenNSX();
			}
		}
			return null;
	}
}
