package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class BanHang_TrangChu extends JPanel {
	Color DefaultColor = new Color(240, 240, 240);
	Color ClickedColor = new Color(128, 255, 0);
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public BanHang_TrangChu() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 1336, 691);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("TRANG CHỦ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 10, 1336, 83);
		add(lblNewLabel);

		JButton btnDonHang = new JButton("ĐƠN HÀNG");
		btnDonHang.setIcon(new ImageIcon(BanHang_TrangChu.class.getResource("/com/NhacCu/item/order_24.png")));
		btnDonHang.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDonHang.setBounds(70, 424, 286, 171);
		add(btnDonHang);
		btnDonHang.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DonHangMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				DonHangMouseClicked(e);
			}
		});

		JButton btnDanhSchKhch = new JButton("DANH SÁCH KHÁCH HÀNG");
		btnDanhSchKhch.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDanhSchKhch.setIcon(new ImageIcon(BanHang_TrangChu.class.getResource("/com/NhacCu/item/user_24.png")));
		btnDanhSchKhch.setBounds(755, 163, 412, 171);
		add(btnDanhSchKhch);
		btnDanhSchKhch.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DsKHMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				DsKHMouseClicked(e);
			}
		});


		JButton btnLchSn = new JButton("LỊCH SỬ ĐƠN HÀNG");
		btnLchSn.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLchSn.setIcon(new ImageIcon(BanHang_TrangChu.class.getResource("/com/NhacCu/item/checklist_24.png")));
		btnLchSn.setBounds(143, 161, 412, 171);
		add(btnLchSn);
		btnLchSn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				LSDonHangMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				LSDonhangMouseClicked(e);
			}
		});

		JButton btnThongKe = new JButton("THỐNG KÊ");
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnThongKe.setIcon(new ImageIcon(BanHang_TrangChu.class.getResource("/com/NhacCu/item/trend_24.png")));
		btnThongKe.setBounds(962, 427, 286, 168);
		add(btnThongKe);
		btnThongKe.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ThongKeMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				ThongKeMouseClicked(e);
			}
		});

		JButton btnBaoTri = new JButton("BẢO TRÌ");
		btnBaoTri.setIcon(new ImageIcon(BanHang_TrangChu.class.getResource("/com/NhacCu/item/maintenance_24.png")));
		btnBaoTri.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBaoTri.setBounds(512, 424, 286, 171);
		add(btnBaoTri);
		btnBaoTri.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				BaoTriMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				BaoTriMouseClicked(e);
			}
		});
	}

	public void DonHangMousePressed(MouseEvent evt) {
		BanHang.menuTrangChu.setBackground(DefaultColor);
		BanHang.menuDonHang.setBackground(ClickedColor);
		BanHang.menuDsKH.setBackground(DefaultColor);
		BanHang.menuBaoTri.setBackground(DefaultColor);
		BanHang.menuLSDonHang.setBackground(DefaultColor);
		BanHang.menuThongKe.setBackground(DefaultColor);
		BanHang.MainContent.removeAll();
		BanHang_DonHang donHang = new BanHang_DonHang();
		BanHang.MainContent.add(donHang).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void DonHangMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		BanHang.MainContent.removeAll();
		BanHang_DonHang donHang = new BanHang_DonHang();
		BanHang.MainContent.add(donHang).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void DsKHMousePressed(MouseEvent evt) {
		BanHang.menuTrangChu.setBackground(DefaultColor);
		BanHang.menuDonHang.setBackground(DefaultColor);
		BanHang.menuDsKH.setBackground(ClickedColor);
		BanHang.menuBaoTri.setBackground(DefaultColor);
		BanHang.menuLSDonHang.setBackground(DefaultColor);
		BanHang.menuThongKe.setBackground(DefaultColor);
		BanHang.MainContent.removeAll();
		BanHang_DSKhachHang dsKH = new BanHang_DSKhachHang();
		BanHang.MainContent.add(dsKH).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void DsKHMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		BanHang.MainContent.removeAll();
		BanHang_DSKhachHang dsKH = new BanHang_DSKhachHang();
		BanHang.MainContent.add(dsKH).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void BaoTriMousePressed(MouseEvent evt) {
		BanHang.menuTrangChu.setBackground(DefaultColor);
		BanHang.menuDonHang.setBackground(DefaultColor);
		BanHang.menuDsKH.setBackground(DefaultColor);
		BanHang.menuBaoTri.setBackground(ClickedColor);
		BanHang.menuLSDonHang.setBackground(DefaultColor);
		BanHang.menuThongKe.setBackground(DefaultColor);
		BanHang.MainContent.removeAll();
		BanHang_BaoTri baoTri = new BanHang_BaoTri();
		BanHang.MainContent.add(baoTri).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void BaoTriMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		BanHang.MainContent.removeAll();
		BanHang_BaoTri baoTri = new BanHang_BaoTri();
		BanHang.MainContent.add(baoTri).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void LSDonHangMousePressed(MouseEvent evt) {
		BanHang.menuTrangChu.setBackground(DefaultColor);
		BanHang.menuDonHang.setBackground(DefaultColor);
		BanHang.menuDsKH.setBackground(DefaultColor);
		BanHang.menuBaoTri.setBackground(DefaultColor);
		BanHang.menuLSDonHang.setBackground(ClickedColor);
		BanHang.menuThongKe.setBackground(DefaultColor);
		BanHang.MainContent.removeAll();
		BanHang_LSDonHang LSdonhang = new BanHang_LSDonHang();
		BanHang.MainContent.add(LSdonhang).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void LSDonhangMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		BanHang.MainContent.removeAll();
		BanHang_LSDonHang LSdonhang = new BanHang_LSDonHang();
		BanHang.MainContent.add(LSdonhang).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void ThongKeMousePressed(MouseEvent evt) {
		BanHang.menuTrangChu.setBackground(DefaultColor);
		BanHang.menuDonHang.setBackground(DefaultColor);
		BanHang.menuDsKH.setBackground(DefaultColor);
		BanHang.menuBaoTri.setBackground(DefaultColor);
		BanHang.menuLSDonHang.setBackground(DefaultColor);
		BanHang.menuThongKe.setBackground(ClickedColor);
		BanHang.MainContent.removeAll();
		BanHang_ThongKe thongKe = new BanHang_ThongKe();
		BanHang.MainContent.add(thongKe).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void ThongKeMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		BanHang.MainContent.removeAll();
		BanHang_ThongKe thongKe = new BanHang_ThongKe();
		BanHang.MainContent.add(thongKe).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}
}
