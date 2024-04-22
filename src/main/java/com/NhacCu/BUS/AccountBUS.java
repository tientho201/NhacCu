package com.NhacCu.BUS;

import java.util.ArrayList;
import com.NhacCu.DTO.AccountDTO;
import com.NhacCu.DAO.AccountDAO;

public class AccountBUS {
	private ArrayList<AccountDTO> dsAC;

	public AccountBUS() {

	}

	public AccountBUS(int i1) {
		listAcc();
	}

	public AccountDTO get(String TenDangNhap) {
		for (AccountDTO AC : dsAC) {
			if (AC.getTenDangNhap().equals(TenDangNhap)) {
				return AC;
			}
		}
		return null;
	}

	public void listAcc() {
		AccountDAO accDAO = new AccountDAO();
		dsAC = new ArrayList<>();
		dsAC = accDAO.list();
	
	}

	public void addAcc(AccountDTO acc) {
		dsAC.add(acc);
		AccountDAO accDAO = new AccountDAO();
		accDAO.add(acc);
	}

	public void updateAcc(AccountDTO acc) {
		for (int i = 0; i < dsAC.size(); i++) {
			if (dsAC.get(i).getTenDangNhap().equals(acc.getTenDangNhap())) {
				dsAC.set(i, acc);
				AccountDAO accDAO = new AccountDAO();
				accDAO.update(acc);
			}
		}
	}

	public void delete(String tenDangNhap) {
		for (AccountDTO acc : dsAC) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				AccountDAO accDAO = new AccountDAO();
				accDAO.delete(tenDangNhap);
				 dsAC.remove(acc); 
				return;
			}
		}
	}

	public void delete_accNV(String tenDangNhap) {
		for (AccountDTO acc : dsAC) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				AccountDAO accDAO = new AccountDAO();
				accDAO.deleteAcc_NV(tenDangNhap);
				 dsAC.remove(acc); 
				return;
			}
		}
	}
	public void delete_accUS(String tenDangNhap) {
		for (AccountDTO acc : dsAC) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				AccountDAO accDAO = new AccountDAO();
				accDAO.deleteAcc_User(tenDangNhap);
				 dsAC.remove(acc); 
				return;
			}
		}
	}
	public ArrayList<AccountDTO> getList() {
		return dsAC;
	}

	public boolean checkTenDangNhap(String tenDangNhap) {
		for (AccountDTO acc : dsAC) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkPassword(String tenDangNhap, String password) {
		for (AccountDTO acc : dsAC) {
			if (acc.getPassword().equals(password) && acc.getTenDangNhap().equals(tenDangNhap)) {
				return true;
			}
		}
		return false;
	}

	public String checkRole(String tenDangNhap) {
		for (AccountDTO acc : dsAC) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				return acc.getRole();
			}
		}
		return null;
	}

	public int checkEnable(String tenDangNhap) {
		for (AccountDTO acc : dsAC) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				return acc.getEnable();
			}
		}
		return 3;
	}

	public void deleteAcc(String text, int i) {
		listAcc();
		delete(text);
	}
}
