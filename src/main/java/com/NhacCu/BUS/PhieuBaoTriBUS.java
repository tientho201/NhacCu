package com.NhacCu.BUS;

import java.util.ArrayList;

import com.NhacCu.DAO.*;
import com.NhacCu.DTO.*;

public class PhieuBaoTriBUS {
	private ArrayList<PhieuBaoTriDTO> ds;

	public PhieuBaoTriBUS() {

	}

	public PhieuBaoTriBUS(int i1) {
		list();
	}

	public ArrayList<PhieuBaoTriDTO> getList() {
		return ds;
	}

	public PhieuBaoTriDTO get(String MaBT) {
		for (PhieuBaoTriDTO pbt : ds) {
			if (pbt.getMaBT().equals(MaBT)) {
				return pbt;
			}
		}
		return null;
	}

	public void list() {
		PhieuBaoTriDAO pbtDAO = new PhieuBaoTriDAO();
		ds = new ArrayList<>();
		ds = pbtDAO.list();

	}

	public void add(PhieuBaoTriDTO pbt) {
		ds.add(pbt);
		PhieuBaoTriDAO pbtDAO = new PhieuBaoTriDAO();
		pbtDAO.add(pbt);
	}

	public void update(PhieuBaoTriDTO pbt) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaBT().equals(pbt.getMaBT())) {
				ds.set(i, pbt);
				PhieuBaoTriDAO pbtDAO = new PhieuBaoTriDAO();
				pbtDAO.update(pbt);
				return;
			}
		}
	}

	public void delete(String MaBT) {
		for (PhieuBaoTriDTO pbt : ds) {
			if (pbt.getMaBT().equals(MaBT)) {
				ds.remove(pbt);
				PhieuBaoTriDAO pbtDAO = new PhieuBaoTriDAO();
				pbtDAO.delete(MaBT);
				return;
			}
		}
	}
	public boolean checkMaBT(String maBT) {
		for (PhieuBaoTriDTO pbt : ds) {
			if (pbt.getMaBT().equals(maBT)) {
				return true ; 
			}
		}
		return false ; 
		
	}
	public boolean checkMaBTvaMaNVvaMaKHvaMaHDvaNgayNhap(String mabt , String manv , String makh , String mahd, String ngaynhap) {
		for (PhieuBaoTriDTO pbt : ds) {
			if (pbt.getMaBT().equals(mabt) && pbt.getMaHD().equals(mahd) &&  pbt.getMaNV().equals(manv) && pbt.getNgayLap().equals(ngaynhap) && pbt.getMaUser().equals(makh)) {
				return true ; 
			}
		}
		return false ; 
	}
	public ArrayList<PhieuBaoTriDTO> search(String selectedOption, String keyword) {
        ArrayList<PhieuBaoTriDTO> resultList = new ArrayList<>();
        
        // Lặp qua danh sách các nhà cung cấp
        for (PhieuBaoTriDTO pbt : getList()) {
            switch (selectedOption) {
            	case "Tất cả":
            		if(keyword.isEmpty()){
            			return getList();
            		}else {
            			if (pbt.getMaBT().toLowerCase().contains(keyword.toLowerCase()) ||
            				pbt.getMaHD().toLowerCase().contains(keyword.toLowerCase()) ||
            				pbt.getMaNV().toLowerCase().contains(keyword.toLowerCase()) ||
            				pbt.getMaUser().toLowerCase().contains(keyword.toLowerCase()) ||
            				pbt.getNgayLap().toLowerCase().contains(keyword.toLowerCase())) {
                            resultList.add(pbt);
                        }
                    }
                    break;
                case "Mã phiếu bảo trì":
                    if (pbt.getMaBT().toLowerCase().contains(keyword.toLowerCase()) ) {
                        resultList.add(pbt);
                    }
                    break;
                case "Mã hóa đơn":
                    if (pbt.getMaHD().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(pbt);
                    }
                    break;
                case "Mã nhân viên":
                    if (pbt.getMaNV().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(pbt);
                    }
                    break;
                case "Mã khách hàng":
                    if (pbt.getMaUser().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(pbt);
                    }
                    break;
                case "Ngày lập":
                    if (pbt.getNgayLap().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(pbt);
                    }
                    break;
                case "Xác nhận":
                    if (pbt.getEnable() == 1) {
                        resultList.add(pbt);
                    }
                    break;
                case "Chờ xác nhận":
                    if (pbt.getEnable() == 0) {
                        resultList.add(pbt);
                    }
                    break;
                case "Hủy":
                    if (pbt.getEnable() == 2) {
                        resultList.add(pbt);
                    }
                    break;
                default:
                	
                    break;
            }
        }
        
        return resultList;
    }
}
