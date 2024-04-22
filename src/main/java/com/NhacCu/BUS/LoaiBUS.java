package com.NhacCu.BUS;

import java.util.ArrayList;

import com.NhacCu.DAO.LoaiDAO;
import com.NhacCu.DTO.LoaiDTO;


public class LoaiBUS {
	private ArrayList<LoaiDTO> dsLoai;
	public LoaiBUS() {

	}

	public LoaiBUS(int i1) {
		listLoai();
	}
	public ArrayList<LoaiDTO> getList() {
		return dsLoai;
	}
	
	public LoaiDTO get(String MaLoai) {
		for (LoaiDTO loai : dsLoai) {
			if (loai.getMaLoai().equals(MaLoai)) {
				return loai;
			}
		}
		return null;
	}

	public void listLoai() {
		LoaiDAO loaiDAO = new LoaiDAO();
		dsLoai = new ArrayList<>();
		dsLoai = loaiDAO.list();
	
	}

	public void add(LoaiDTO loai) {
		dsLoai.add(loai);
		LoaiDAO loaiDAO = new LoaiDAO();
		loaiDAO.add(loai);
	}

	public void update(LoaiDTO loai) {
		for (int i = 0; i < dsLoai.size(); i++) {
			if (dsLoai.get(i).getMaLoai().equals(loai.getMaLoai())) {
				dsLoai.set(i, loai);
				LoaiDAO loaiDAO = new LoaiDAO();
				loaiDAO.update(loai);
			}
		}
	}

	public void delete(String MaLoai) {
		for (LoaiDTO loai : dsLoai) {
			if (loai.getMaLoai().equals(MaLoai)) {
				dsLoai.remove(loai);
				LoaiDAO loaiDAO = new LoaiDAO();
				loaiDAO.delete(MaLoai);
				return;
			}
		}
	}
	public String PutOutTenLoai(String maLoai) {
		for (LoaiDTO loai : dsLoai) {
			if (loai.getMaLoai().equals(maLoai)) {
				return loai.getTenLoai();
			}
		}
		return null ; 
	}
	public boolean checkMaLoai(String maLoai) {
		for (LoaiDTO loai : dsLoai) {
			if (loai.getMaLoai().equals(maLoai)) {
				return true;
			}
		}
		return false ; 
	}
}
