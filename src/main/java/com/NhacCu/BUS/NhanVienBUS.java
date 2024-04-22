package com.NhacCu.BUS;

import com.NhacCu.DAO.NhanVienDAO;
import com.NhacCu.DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {
	private ArrayList<NhanVienDTO> dsnv;

	public NhanVienBUS() {

	}

	public NhanVienBUS(int i1) {
		listNV();
	}

	public NhanVienDTO get(String MaNhanVien) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getMaNhanVien().equals(MaNhanVien)) {
				return nv;
			}
		}
		return null;
	}

	public void listNV() {
		NhanVienDAO nvDAO = new NhanVienDAO();
		dsnv = new ArrayList<>();
		dsnv = nvDAO.list();	
	}

	public void addNV(NhanVienDTO nv) {
		dsnv.add(nv);
		NhanVienDAO nvDAO = new NhanVienDAO();
		nvDAO.add(nv);
	}

	public void deleteNV(String MaNhanVien) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getMaNhanVien().equals(MaNhanVien)) {
				dsnv.remove(nv);
				NhanVienDAO nvDAO = new NhanVienDAO();
				nvDAO.delete(MaNhanVien);
				return;
			}
		}
	}

	public void updateNV(NhanVienDTO nv) {
		for (int i = 0; i < dsnv.size(); i++) {
			if (dsnv.get(i).getTenDangNhap().equals(nv.getTenDangNhap())) {
				dsnv.set(i, nv);
				NhanVienDAO nvDAO = new NhanVienDAO();
				nvDAO.update(nv);
				return;
			}
		}
	}

	public ArrayList<NhanVienDTO> getList() {
		return dsnv;
	}

	public void deleteNV(String text, int i) {
		listNV();
		deleteNV(text);
	}

	public boolean checkHoatDong(String maNhanVien) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getMaNhanVien().equals(maNhanVien) && nv.getEnable() == 1) {
				return true;
			}
		}
		return false;
	}
	public boolean checkMaNV(String maNhanVien) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getMaNhanVien().equals(maNhanVien)) {
				return true;
			}
		}
		return false;
	}
	public String checkTenNhanVien(String maNhanVien) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getMaNhanVien().equals(maNhanVien) && nv.getEnable() == 1) {
				return nv.getTenNhanVien();
			}
		}
		return null;
	}
	public boolean checkTenDangNhap(String maNhanVien) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getMaNhanVien().equals(maNhanVien) && nv.getEnable() == 1) {
				return true;
			}
		}
		return false;
	}
	public String checkMaNVHoatDong(String maNhanVien) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getMaNhanVien().equals(maNhanVien) && nv.getEnable() == 1) {
				return nv.getMaNhanVien();
			}
		}
		return (String) null;
	}
	public String PutOutChucVu(String maNhanVien) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getMaNhanVien().equals(maNhanVien) && nv.getEnable() == 1) {
				return nv.getChucVu();
			}
		}
		return null;
	}
	public String PutOnTenNhanVien(String MaNhanVien) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getMaNhanVien().equals(MaNhanVien) && nv.getEnable() == 1) {
				return nv.getTenNhanVien();
			}
		}
		return null;
	}
	public String PutOnTenNhanVienEqualTenDangNhap(String tendangnhap) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getTenDangNhap().equals(tendangnhap) && nv.getEnable() == 1) {
				return nv.getTenNhanVien();
			}
		}
		return null;
	}
	public String PutOnMaNVEqualTenDangNhap(String tendangnhap) {
		for (NhanVienDTO nv : dsnv) {
			if (nv.getTenDangNhap().equals(tendangnhap) && nv.getEnable() == 1) {
				return nv.getMaNhanVien();
			}
		}
		return null;
	}
}
