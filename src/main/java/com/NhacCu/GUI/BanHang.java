package com.NhacCu.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.DTO.NhanVienDTO;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class BanHang extends JFrame {
	Color DefaultColor = new Color(240, 240, 240);
	Color ClickedColor = new Color(128, 255, 0);
	private static final long serialVersionUID = 1L;
	public static JPanel MainContent;
	public static JMenuItem menuTrangChu;
	public static JMenuItem menuDonHang;
	public static JMenuItem menuDsKH;
	public static JMenuItem menuLSDonHang;
	public static JMenuItem menuThongKe;
	public JMenuItem MenuDangXuat;
	public JMenuItem menuThoat;
	private JMenuItem menuDoiThongTin;
	public static JMenuItem MenuTenDangNhap;
	public static JMenuItem menuBaoTri;
	private NhanVienBUS nhanVienBUS = new NhanVienBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					final BanHang frame = new BanHang();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							int result = JOptionPane.showConfirmDialog(frame, "Bạn có chắc muốn thoát?", "Xác nhận",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.YES_OPTION) {
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							} else {
								frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BanHang() {
		setTitle("Bán Hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 750);
		MainContent = new JPanel();
		MainContent.setBackground(new Color(0, 128, 255));
		MainContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		BanHang_TrangChu trangchu = new BanHang_TrangChu();
		MainContent.add(trangchu);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Tùy chọn");
		menuBar.add(mnNewMenu);

		menuTrangChu = new JMenuItem("Trang chủ");
		menuTrangChu.setIcon(new ImageIcon(BanHang.class.getResource("/com/NhacCu/item/home_16.png")));
		mnNewMenu.add(menuTrangChu);
		menuTrangChu.setBackground(new Color(128, 255, 0));
		menuTrangChu.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				TrangChuMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				TrangChuMouseClicked(e);
			}
		});

		mnNewMenu.addSeparator();

		menuDonHang = new JMenuItem("Đơn hàng");
		menuDonHang.setIcon(new ImageIcon(BanHang.class.getResource("/com/NhacCu/item/order_16.png")));
		mnNewMenu.add(menuDonHang);
		menuDonHang.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DonHangMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				DonHangMouseClicked(e);
			}
		});

		menuDsKH = new JMenuItem("Danh sách khách hàng");
		menuDsKH.setIcon(
				new ImageIcon(BanHang.class.getResource("/com/NhacCu/item/Pictogrammers-Material-Account-cog.16.png")));
		mnNewMenu.add(menuDsKH);
		menuDsKH.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DsKHMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				DsKHMouseClicked(e);
			}
		});

		menuLSDonHang = new JMenuItem("Lịch sử đơn hàng");
		menuLSDonHang.setIcon(new ImageIcon(BanHang.class.getResource("/com/NhacCu/item/checklist_16.png")));
		mnNewMenu.add(menuLSDonHang);
		menuLSDonHang.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				LSDonHangMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				LSDonhangMouseClicked(e);
			}
		});

		menuBaoTri = new JMenuItem("Bảo trì");
		menuBaoTri.setIcon(new ImageIcon(BanHang.class.getResource("/com/NhacCu/item/manufacture_16.png")));
		mnNewMenu.add(menuBaoTri);
		menuBaoTri.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				BaoTriMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				BaoTriMouseClicked(e);
			}
		});

		menuThongKe = new JMenuItem("Thống kê");
		menuThongKe.setIcon(new ImageIcon(BanHang.class.getResource("/com/NhacCu/item/trend_16.png")));
		mnNewMenu.add(menuThongKe);
		menuThongKe.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ThongKeMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				ThongKeMouseClicked(e);
			}
		});

		mnNewMenu.addSeparator();
		
		 menuDoiThongTin = new JMenuItem("Đổi thông tin");
		menuDoiThongTin.setIcon(new ImageIcon(BanHang.class.getResource("/com/NhacCu/item/Pictogrammers-Material-Account-cog.16.png")));
		mnNewMenu.add(menuDoiThongTin);
		menuDoiThongTin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DoiThongTinMousePressed(e);
			}

			
		});

		MenuDangXuat = new JMenuItem("Đăng xuất");
		MenuDangXuat.setIcon(new ImageIcon(BanHang.class.getResource("/com/NhacCu/item/logout-icon.jpg")));
		mnNewMenu.add(MenuDangXuat);
		MenuDangXuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn đăng xuất không?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					setVisible(false);
					Login login = new Login();
					login.setVisible(true);
				}
			}
		});

		menuThoat = new JMenuItem("Thoát");
		menuThoat.setIcon(new ImageIcon(
				BanHang.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Pretty-Office-6-Logout.16.png")));
		mnNewMenu.add(menuThoat);
		menuThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát không?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					setVisible(false);
				}
			}
		});

		MenuTenDangNhap = new JMenuItem("BanHang");
		menuBar.add(MenuTenDangNhap);

		setContentPane(MainContent);
		MainContent.setLayout(null);
	}

	public void TrangChuMousePressed(MouseEvent evt) {
		menuTrangChu.setBackground(ClickedColor);
		menuDonHang.setBackground(DefaultColor);
		menuDsKH.setBackground(DefaultColor);
		menuBaoTri.setBackground(DefaultColor);
		menuLSDonHang.setBackground(DefaultColor);
		menuThongKe.setBackground(DefaultColor);
		menuDoiThongTin.setBackground(DefaultColor);
		MainContent.removeAll();
		BanHang_TrangChu trangchu = new BanHang_TrangChu();
		MainContent.add(trangchu).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void TrangChuMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		BanHang_TrangChu trangchu = new BanHang_TrangChu();
		MainContent.add(trangchu).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void DonHangMousePressed(MouseEvent evt) {
		menuTrangChu.setBackground(DefaultColor);
		menuDonHang.setBackground(ClickedColor);
		menuDsKH.setBackground(DefaultColor);
		menuBaoTri.setBackground(DefaultColor);
		menuLSDonHang.setBackground(DefaultColor);
		menuThongKe.setBackground(DefaultColor);
		menuDoiThongTin.setBackground(DefaultColor);
		MainContent.removeAll();
		BanHang_DonHang donHang = new BanHang_DonHang();
		MainContent.add(donHang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void DonHangMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		BanHang_DonHang donHang = new BanHang_DonHang();
		MainContent.add(donHang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void DsKHMousePressed(MouseEvent evt) {
		menuTrangChu.setBackground(DefaultColor);
		menuDonHang.setBackground(DefaultColor);
		menuDsKH.setBackground(ClickedColor);
		menuBaoTri.setBackground(DefaultColor);
		menuLSDonHang.setBackground(DefaultColor);
		menuThongKe.setBackground(DefaultColor);		menuDoiThongTin.setBackground(DefaultColor);
		MainContent.removeAll();
		BanHang_DSKhachHang dsKH = new BanHang_DSKhachHang();
		MainContent.add(dsKH).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void DsKHMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		BanHang_DSKhachHang dsKH = new BanHang_DSKhachHang();
		MainContent.add(dsKH).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void BaoTriMousePressed(MouseEvent evt) {
		menuTrangChu.setBackground(DefaultColor);
		menuDonHang.setBackground(DefaultColor);
		menuDsKH.setBackground(DefaultColor);
		menuBaoTri.setBackground(ClickedColor);
		menuLSDonHang.setBackground(DefaultColor);
		menuThongKe.setBackground(DefaultColor);		menuDoiThongTin.setBackground(DefaultColor);
		MainContent.removeAll();
		BanHang_BaoTri baoTri = new BanHang_BaoTri();
		MainContent.add(baoTri).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void BaoTriMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		BanHang_BaoTri baoTri = new BanHang_BaoTri();
		MainContent.add(baoTri).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void LSDonHangMousePressed(MouseEvent evt) {
		menuTrangChu.setBackground(DefaultColor);
		menuDonHang.setBackground(DefaultColor);
		menuDsKH.setBackground(DefaultColor);
		menuBaoTri.setBackground(DefaultColor);
		menuLSDonHang.setBackground(ClickedColor);
		menuThongKe.setBackground(DefaultColor);		menuDoiThongTin.setBackground(DefaultColor);
		MainContent.removeAll();
		BanHang_LSDonHang LSdonhang = new BanHang_LSDonHang();
		MainContent.add(LSdonhang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void LSDonhangMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		BanHang_LSDonHang LSdonhang = new BanHang_LSDonHang();
		MainContent.add(LSdonhang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void ThongKeMousePressed(MouseEvent evt) {
		menuTrangChu.setBackground(DefaultColor);
		menuDonHang.setBackground(DefaultColor);
		menuDsKH.setBackground(DefaultColor);
		menuBaoTri.setBackground(DefaultColor);
		menuLSDonHang.setBackground(DefaultColor);
		menuThongKe.setBackground(ClickedColor);		menuDoiThongTin.setBackground(DefaultColor);
		MainContent.removeAll();
		BanHang_ThongKe thongKe = new BanHang_ThongKe();
		MainContent.add(thongKe).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void ThongKeMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		BanHang_ThongKe thongKe = new BanHang_ThongKe();
		MainContent.add(thongKe).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}
	public void DoiThongTinMousePressed(MouseEvent evt) {
		menuTrangChu.setBackground(DefaultColor);
		menuDonHang.setBackground(DefaultColor);
		menuDsKH.setBackground(DefaultColor);
		menuBaoTri.setBackground(DefaultColor);
		menuLSDonHang.setBackground(DefaultColor);
		menuThongKe.setBackground(DefaultColor);
		menuDoiThongTin.setBackground(ClickedColor);
	
		DoiThongTin doiThongTin = new DoiThongTin();
		doiThongTin.setVisible(true);
	
		nhanVienBUS.listNV();

		String chuoiCon = MenuTenDangNhap.getText().substring(MenuTenDangNhap.getText().indexOf(":") + 1).trim();
		doiThongTin.textFieldTenDangNhap.setText(chuoiCon);

		for (NhanVienDTO nvDTO : nhanVienBUS.getList()) {
			if (nvDTO.getTenDangNhap().equals(chuoiCon)) {
				doiThongTin.textFieldMaNguoiDung.setText(nvDTO.getMaNhanVien());
				doiThongTin.textFieldHovaTen.setText(nvDTO.getTenNhanVien());
				doiThongTin.textFieldDiaChi.setText(nvDTO.getDiaChi());
				doiThongTin.textFieldNgaySinh.setText(nvDTO.getNgaySinh());
				doiThongTin.textFieldSoDienThoai.setText(nvDTO.getSDT());
				if (nvDTO.getGioiTinh().equals("Nam")) {
					doiThongTin.rdbtnNam.setSelected(true);
					

				} else {
					doiThongTin.rdbtnNu.setSelected(true);
					
				}
				break;
			}
		}

	}
}
