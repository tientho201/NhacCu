package com.NhacCu.Controller;

import com.NhacCu.GUI.QuanLyKho_TrangChu;
import static com.NhacCu.GUI.QuanLyKho_TrangChu.splitPane;
public class control_TrangChu_QuanLyKho {
	public void chuyenveSanPham(){ 
		splitPane.setRightComponent(QuanLyKho_TrangChu.QLK_SP);
	}
	
	public void chuyenvePhieuNhap(){ 
		splitPane.setRightComponent(QuanLyKho_TrangChu.QLK_PN);
	}
	public void chuyenveThongKe(){ 
		splitPane.setRightComponent(QuanLyKho_TrangChu.QLK_TK);
	}
	public void chuyenveDoiTac(){ 
		splitPane.setRightComponent(QuanLyKho_TrangChu.QLK_DT);
	}
	public void chuyenvePhanLoai(){ 
		splitPane.setRightComponent(QuanLyKho_TrangChu.QLK_PL);
	}
	public void chuyenveNhaSanXuat(){ 
		splitPane.setRightComponent(QuanLyKho_TrangChu.QLK_NSX);
	}
	public void chuyenveBaoTri(){ 
		splitPane.setRightComponent(QuanLyKho_TrangChu.QLK_BH);
	}
}
