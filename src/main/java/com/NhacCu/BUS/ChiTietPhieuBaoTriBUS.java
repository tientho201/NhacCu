package com.NhacCu.BUS;

import java.util.ArrayList;

import com.NhacCu.DAO.*;
import com.NhacCu.DTO.*;

public class ChiTietPhieuBaoTriBUS {
	private ArrayList<ChiTietPhieuBaoTriDTO> ds;

	public ChiTietPhieuBaoTriBUS() {

	}

	public ChiTietPhieuBaoTriBUS(int i1) {
		list();
	}

	public ArrayList<ChiTietPhieuBaoTriDTO> getList() {
		return ds;
	}

	public ChiTietPhieuBaoTriDTO get(String MaBT, String MaSP) {
		for (ChiTietPhieuBaoTriDTO ctpbt : ds) {
			if (ctpbt.getMaBT().equals(MaBT) && ctpbt.getMaSP().equals(MaSP)) {
				return ctpbt;
			}
		}
		return null;
	}

	public void list() {
		ChiTietPhieuBaoTriDAO ctpbtDAO = new ChiTietPhieuBaoTriDAO();
		ds = new ArrayList<>();
		ds = ctpbtDAO.list();

	}

	public void add(ChiTietPhieuBaoTriDTO ctpbt) {
		ds.add(ctpbt);
		ChiTietPhieuBaoTriDAO ctpbtDAO = new ChiTietPhieuBaoTriDAO();
		ctpbtDAO.add(ctpbt);
	}

	public void update(ChiTietPhieuBaoTriDTO ctpbt) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaBT().equals(ctpbt.getMaBT()) && ds.get(i).getMaSP().equals(ctpbt.getMaSP())) {
				ds.set(i, ctpbt);
				ChiTietPhieuBaoTriDAO ctpbtDAO = new ChiTietPhieuBaoTriDAO();
						ctpbtDAO.update(ctpbt);
				return;
			}
		}
	}

	public void delete(String MaBT, String MaSP) {
		for (ChiTietPhieuBaoTriDTO ctpbt : ds) {
			if (ctpbt.getMaBT().equals(MaBT) && ctpbt.getMaSP().equals(MaSP)) {
				ds.remove(ctpbt);
				ChiTietPhieuBaoTriDAO ctpbtDAO = new ChiTietPhieuBaoTriDAO();
				ctpbtDAO.delete(MaBT , MaSP);
				return;
			}
		}
	}
	public boolean checkMaBTvaMaSP(String MaBT, String MaSP) {
		for (ChiTietPhieuBaoTriDTO ctpbt : ds) {
			if (ctpbt.getMaSP().equals(MaSP) && ctpbt.getMaBT().equals(MaBT)) {
				return true;
			}
		}
		return false;

	}
	public ArrayList<ChiTietPhieuBaoTriDTO> search(String selectedOption, String keyword) {
        ArrayList<ChiTietPhieuBaoTriDTO> resultList = new ArrayList<>();
        
        // Lặp qua danh sách các nhà cung cấp
        for (ChiTietPhieuBaoTriDTO ctpbt : getList()) {
            switch (selectedOption) {
            	case "Tất cả":
            		if(keyword.isEmpty()){
            			return getList();
            		}else {
            			if (ctpbt.getMaBT().toLowerCase().contains(keyword.toLowerCase()) ||
            					ctpbt.getMaSP().toLowerCase().contains(keyword.toLowerCase()) ||
            					ctpbt.getGhiChu().toLowerCase().contains(keyword.toLowerCase())) {
                            resultList.add(ctpbt);
                        }
                    }
                    break;
                case "Mã phiếu bảo trì":
                    if (ctpbt.getMaBT().toLowerCase().contains(keyword.toLowerCase())  ) {
                        resultList.add(ctpbt);
                    }
                    break;
                
                default:
                	
                    break;
            }
        }
        
        return resultList;
    }
}
