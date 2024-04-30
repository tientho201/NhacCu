package com.NhacCu.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.border.MatteBorder;

import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.DTO.NhanVienDTO;

public class Admin extends JFrame {
	Color ClickedColor = new Color(255, 128, 128);
	Color DefaultColor = new Color(0, 0, 0);
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel MainContent;
	public static JLabel tendangnhap;
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
					Admin frame = new Admin();
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
	public Admin() {
		setTitle("Chủ doanh nghiệp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 775);
		setResizable(false);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Tùy chọn");
		menuBar.add(mnNewMenu);

		JMenuItem menuDangXuat = new JMenuItem("Đăng xuất");
		menuDangXuat.setIcon(new ImageIcon(
				Admin.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Pretty-Office-6-Logout.16.png")));
		mnNewMenu.add(menuDangXuat);
		menuDangXuat.addActionListener(new ActionListener() {
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

		JMenuItem menuThoat = new JMenuItem("Thoát");
		menuThoat.setIcon(new ImageIcon(Admin.class.getResource("/com/NhacCu/item/out.png")));
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		MainContent = new JPanel();
		MainContent.setBounds(219, 28, 1117, 685);
		contentPane.add(MainContent);
		MainContent.setLayout(null);

		Admin_SanPham sanPham = new Admin_SanPham();

		MainContent.add(sanPham);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1336, 30);
		contentPane.add(panel);
		panel.setLayout(null);

		tendangnhap = new JLabel("xin chào:  ADMIN");
		tendangnhap.setForeground(new Color(255, 255, 255));
		tendangnhap.setFont(new Font("Tahoma", Font.BOLD, 17));
		tendangnhap.setBounds(26, 0, 197, 30);
		panel.add(tendangnhap);

		LocalDate ngayHienTai = LocalDate.now();
		DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String ngayThangNam = ngayHienTai.format(dinhDang);
		JLabel lblNewLabel_1 = new JLabel("Ngày: " + ngayThangNam);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(479, 1, 591, 29);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 28, 218, 685);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 10, 218, 43);
		panel_2.setBackground(new Color(255, 128, 128));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel2MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel2MouseClicked(e);
			}
		});

		JLabel lblNewLabel = new JLabel("Sản  Phẩm");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 10, 198, 23);
		panel_2.add(lblNewLabel);

		panel_3 = new JPanel();
		panel_3.setBounds(0, 61, 218, 43);
		panel_3.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel3MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel3MouseClicked(e);
			}
		});
		JLabel lblPhiuNhp = new JLabel("Phiếu Nhập");
		lblPhiuNhp.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhiuNhp.setForeground(Color.WHITE);
		lblPhiuNhp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhiuNhp.setBounds(10, 10, 198, 23);
		panel_3.add(lblPhiuNhp);

		panel_4 = new JPanel();
		panel_4.setBounds(0, 114, 218, 43);
		panel_4.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel4MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel4MouseClicked(e);
			}
		});

		JLabel lblPhnLoi = new JLabel("Phân Loại");
		lblPhnLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnLoi.setForeground(Color.WHITE);
		lblPhnLoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhnLoi.setBounds(10, 10, 198, 23);
		panel_4.add(lblPhnLoi);

		panel_5 = new JPanel();
		panel_5.setBounds(0, 168, 218, 43);
		panel_5.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel5MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel5MouseClicked(e);
			}
		});
		JLabel lblNhSnXut = new JLabel("Nhà Sản Xuất");
		lblNhSnXut.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhSnXut.setForeground(Color.WHITE);
		lblNhSnXut.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNhSnXut.setBounds(10, 10, 198, 23);
		panel_5.add(lblNhSnXut);

		panel_6 = new JPanel();
		panel_6.setBounds(0, 221, 218, 43);
		panel_6.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_6.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel6MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel6MouseClicked(e);
			}
		});
		JLabel lblLchSn = new JLabel("Lịch Sử Đơn Hàng");
		lblLchSn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLchSn.setForeground(Color.WHITE);
		lblLchSn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLchSn.setBounds(10, 10, 198, 23);
		panel_6.add(lblLchSn);

		panel_7 = new JPanel();
		panel_7.setBounds(0, 277, 218, 43);
		panel_7.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		panel_7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_7.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel7MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel7MouseClicked(e);
			}
		});
		JLabel lblDanhSchKhch = new JLabel("Danh Sách Tài Khoản");
		lblDanhSchKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchKhch.setForeground(Color.WHITE);
		lblDanhSchKhch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDanhSchKhch.setBounds(10, 10, 198, 23);
		panel_7.add(lblDanhSchKhch);

		panel_8 = new JPanel();
		panel_8.setBounds(0, 334, 218, 43);
		panel_8.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		panel_8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_8.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel8MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel8MouseClicked(e);
			}
		});
		JLabel lblnHng = new JLabel("Đơn Hàng");
		lblnHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblnHng.setForeground(Color.WHITE);
		lblnHng.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblnHng.setBounds(10, 10, 198, 23);
		panel_8.add(lblnHng);

		panel_9 = new JPanel();
		panel_9.setBounds(0, 388, 218, 43);
		panel_9.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		panel_9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_9.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel9MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel9MouseClicked(e);
			}
		});
		JLabel lbliTc = new JLabel("Đối Tác");
		lbliTc.setHorizontalAlignment(SwingConstants.CENTER);
		lbliTc.setForeground(Color.WHITE);
		lbliTc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbliTc.setBounds(10, 10, 198, 23);
		panel_9.add(lbliTc);

		panel_10 = new JPanel();
		panel_10.setBounds(0, 441, 218, 43);
		panel_10.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_10);
		panel_10.setLayout(null);
		panel_10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_10.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel10MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel10MouseClicked(e);
			}
		});
		JLabel lblBoTr = new JLabel("Bảo Trì");
		lblBoTr.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoTr.setForeground(Color.WHITE);
		lblBoTr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBoTr.setBounds(10, 10, 198, 23);
		panel_10.add(lblBoTr);

		panel_11 = new JPanel();
		panel_11.setBounds(0, 497, 218, 43);
		panel_11.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_11);
		panel_11.setLayout(null);
		panel_11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_11.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel11MousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				panel11MouseClicked(e);
			}
		});
		JLabel lblThngK = new JLabel("Thống Kê");
		lblThngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngK.setForeground(Color.WHITE);
		lblThngK.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngK.setBounds(10, 10, 198, 23);
		panel_11.add(lblThngK);

		panel_12 = new JPanel();
		panel_12.setBounds(0, 579, 218, 43);
		panel_12.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_12);
		panel_12.setLayout(null);
		panel_12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_12.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel12MousePressed(e);
			}
		});

		JLabel lbliThngTin = new JLabel("Đổi Thông Tin");
		lbliThngTin.setHorizontalAlignment(SwingConstants.CENTER);
		lbliThngTin.setForeground(Color.WHITE);
		lbliThngTin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbliThngTin.setBounds(10, 10, 198, 23);
		panel_12.add(lbliThngTin);

		panel_13 = new JPanel();
		panel_13.setBounds(0, 632, 218, 43);
		panel_13.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_13);
		panel_13.setLayout(null);
		panel_13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_13.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});

		JLabel lblThot = new JLabel("Thoát");
		lblThot.setHorizontalAlignment(SwingConstants.CENTER);
		lblThot.setForeground(Color.WHITE);
		lblThot.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThot.setBounds(10, 10, 198, 23);
		panel_13.add(lblThot);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel_2.setBounds(0, 556, 218, 13);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-1, -4, 223, 9);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public void panel2MousePressed(MouseEvent evt) {
		panel_2.setBackground(ClickedColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_SanPham sanpham = new Admin_SanPham();
		MainContent.add(sanpham).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel2MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_SanPham sanpham = new Admin_SanPham();
		MainContent.add(sanpham).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel3MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(ClickedColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_PhieuNhap phieunhap = new Admin_PhieuNhap();
		MainContent.add(phieunhap).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel3MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_PhieuNhap phieunhap = new Admin_PhieuNhap();
		MainContent.add(phieunhap).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel4MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(ClickedColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_PhanLoai phanLoai = new Admin_PhanLoai();
		MainContent.add(phanLoai).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel4MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_PhanLoai phanLoai = new Admin_PhanLoai();
		MainContent.add(phanLoai).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel5MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(ClickedColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_NSX nsx = new Admin_NSX();
		MainContent.add(nsx).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel5MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_NSX nsx = new Admin_NSX();
		MainContent.add(nsx).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel6MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(ClickedColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_LSDonHang lsdonhang = new Admin_LSDonHang();
		MainContent.add(lsdonhang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel6MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_LSDonHang lsdonhang = new Admin_LSDonHang();
		MainContent.add(lsdonhang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel7MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(ClickedColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_DsTaiKhoan Ds = new Admin_DsTaiKhoan();
		MainContent.add(Ds).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel7MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_DsTaiKhoan Ds = new Admin_DsTaiKhoan();
		MainContent.add(Ds).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel8MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(ClickedColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_DonHang donhang = new Admin_DonHang();
		MainContent.add(donhang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel8MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_DonHang donhang = new Admin_DonHang();
		MainContent.add(donhang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel9MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(ClickedColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_DoiTac doitac = new Admin_DoiTac();
		MainContent.add(doitac).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel9MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_DoiTac doitac = new Admin_DoiTac();
		MainContent.add(doitac).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel10MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(ClickedColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_BaoTri baotri = new Admin_BaoTri();
		MainContent.add(baotri).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel10MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_BaoTri baotri = new Admin_BaoTri();
		MainContent.add(baotri).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel11MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(ClickedColor);
		panel_12.setBackground(DefaultColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		Admin_ThongKe thongke = new Admin_ThongKe();
		MainContent.add(thongke).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel11MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		Admin_ThongKe thongke = new Admin_ThongKe();
		MainContent.add(thongke).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void panel12MousePressed(MouseEvent evt) {
		panel_2.setBackground(DefaultColor);
		panel_3.setBackground(DefaultColor);
		panel_4.setBackground(DefaultColor);
		panel_5.setBackground(DefaultColor);
		panel_6.setBackground(DefaultColor);
		panel_7.setBackground(DefaultColor);
		panel_8.setBackground(DefaultColor);
		panel_9.setBackground(DefaultColor);
		panel_10.setBackground(DefaultColor);
		panel_11.setBackground(DefaultColor);
		panel_12.setBackground(ClickedColor);
		panel_13.setBackground(DefaultColor);
		MainContent.removeAll();
		DoiThongTin doiThongTin = new DoiThongTin();
		doiThongTin.setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

		nhanVienBUS.listNV();

		String chuoiCon = tendangnhap.getText().substring(tendangnhap.getText().indexOf(":") + 1).trim();
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
