package com.NhacCu.BUS;

import java.util.ArrayList;

import com.NhacCu.DAO.NhaCungCapDAO;
import com.NhacCu.DTO.NhaCungCapDTO;

public class NhaCungCapBUS {
	private ArrayList<NhaCungCapDTO> dsNCC;

	public NhaCungCapBUS() {

	}

	public NhaCungCapBUS(int i1) {
		listNCC();
	}

	public ArrayList<NhaCungCapDTO> getList() {
		return dsNCC;
	}

	public NhaCungCapDTO get(String MaNCC) {
		for (NhaCungCapDTO ncc : dsNCC) {
			if (ncc.getMaNCC().equals(MaNCC)) {
				return ncc;
			}
		}
		return null;
	}

	public void listNCC() {
		NhaCungCapDAO nccDAO = new NhaCungCapDAO();
		dsNCC = new ArrayList<>();
		dsNCC = nccDAO.list();

	}

	public void addSP(NhaCungCapDTO ncc) {
		dsNCC.add(ncc);
		NhaCungCapDAO nccDAO = new NhaCungCapDAO();
		nccDAO.add(ncc);
	}

	public void updateSP(NhaCungCapDTO ncc) {
		for (int i = 0; i < dsNCC.size(); i++) {
			if (dsNCC.get(i).getMaNCC().equals(ncc.getMaNCC())) {
				dsNCC.set(i, ncc);
				NhaCungCapDAO nccDAO = new NhaCungCapDAO();
				nccDAO.update(ncc);
				return;
			}
		}
	}

	public void delete(String MaNCC) {
		for (NhaCungCapDTO ncc : dsNCC) {
			if (ncc.getMaNCC().equals(MaNCC)) {
				dsNCC.remove(ncc);
				NhaCungCapDAO nccDAO = new NhaCungCapDAO();
				nccDAO.delete(MaNCC);
				return;
			}
		}
	}

	public boolean checkMaNCC(String MaNCC) {
		for (NhaCungCapDTO ncc : dsNCC) {
			if (ncc.getMaNCC().equals(MaNCC)) {
				return true;
			}

		}
		return false;
	}

	public String PutOnTenNCC(String MaNCC) {
		for (NhaCungCapDTO ncc : dsNCC) {
			if (ncc.getMaNCC().equals(MaNCC)) {
				return ncc.getTenNCC();
			}

		}
		return null;
	}

}
