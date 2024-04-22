package com.NhacCu.BUS;

import java.util.ArrayList;

import com.NhacCu.DAO.UserDAO;
import com.NhacCu.DTO.UserDTO;

public class UserBUS {
	private ArrayList<UserDTO> dsUS;

	public UserBUS() {

	}

	public UserBUS(int i1) {
		listUs();
	}

	public UserDTO get(String MaUser) {
		for (UserDTO us : dsUS) {
			if (us.getMaUser().equals(MaUser) && us.getEnable() == 1) {
				return us;
			}
		}
		return null;
	}

	public void listUs() {
		UserDAO usDAO = new UserDAO();
		dsUS = new ArrayList<>();
		dsUS = usDAO.list();
	}

	public void addUs(UserDTO us) {
		dsUS.add(us);
		UserDAO usDAO = new UserDAO();
		usDAO.add(us);
	}


	public void deleteUs(String MaUser) {
		for (UserDTO us : dsUS) {
			if (us.getMaUser().equals(MaUser)) {
				dsUS.remove(us);
				UserDAO usDAO = new UserDAO();
				usDAO.delete(MaUser);
				return;
			}
		}
	}
	public void updateUs(UserDTO us) {

		for (int i = 0; i < dsUS.size(); i++) {
			if (dsUS.get(i).getTenDangNhap().equals(us.getTenDangNhap()) && dsUS.get(i).getEnable() == 1) {
				dsUS.set(i, us);
				UserDAO usDAO = new UserDAO();
				usDAO.update(us);
			}
		}
	}

	public ArrayList<UserDTO> getList() {
		return dsUS;
	}

	public void deleteUs(String text, int i) {
		listUs();
		deleteUs(text);
	}

	public boolean checkMaUser(String MaUser) {
		for (UserDTO Us : dsUS) {
			if (Us.getMaUser().equals(MaUser) ) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkTenDangNhap(String MaUser) {
		for (UserDTO Us : dsUS) {
			if (Us.getMaUser().equals(MaUser) && Us.getEnable() == 1) {
				return true;
			}
		}
		return false;
	}
	public String increaseMaUser() {
		// Tạo biến lưu trữ số lớn nhất
        int maxNumber = Integer.MIN_VALUE;
        
        // Lặp qua từng chuỗi trong danh sách
        for (UserDTO Us : dsUS) {
            // Trích xuất phần số từ chuỗi và chuyển đổi sang số nguyên
            int number = Integer.parseInt(Us.getMaUser().substring(2));
            
            // So sánh với số lớn nhất hiện tại và cập nhật nếu cần
            if (number > maxNumber) {
                maxNumber = number;
          
            }
        }
        
       return "Us" + (maxNumber + 1); 
 	}
	
}
