package com.NhacCu.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.NhacCu.Controller.control_TrangChu_QuanLyKho;
import com.NhacCu.DTO.NhanVienDTO;

import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

import com.NhacCu.BUS.*;
public class QuanLyKho_TrangChu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel jLabel1;
	public static JLabel tenDangNhap;
	public static JSplitPane splitPane;
	public static control_TrangChu_QuanLyKho control_QLK = new control_TrangChu_QuanLyKho();
	public static QuanLyKho_SanPham QLK_SP = new QuanLyKho_SanPham();
	public static QuanLyKho_PhieuNhap QLK_PN = new QuanLyKho_PhieuNhap();
	public static QuanLyKho_ThongKe QLK_TK = new QuanLyKho_ThongKe();
	public static QuanLyKho_DoiTac QLK_DT = new QuanLyKho_DoiTac();
	public static QuanLyKho_PhanLoai QLK_PL = new QuanLyKho_PhanLoai();
	public static QuanLyKho_NhaSanXuat QLK_NSX = new QuanLyKho_NhaSanXuat();
	public static QuanLyKho_BaoTri QLK_BH = new QuanLyKho_BaoTri();
	public Login login = new Login();
	private JMenuItem menuDoiThongTin;
	private NhanVienBUS nvBUS = new NhanVienBUS();

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
					QuanLyKho_TrangChu frame = new QuanLyKho_TrangChu();
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
	public QuanLyKho_TrangChu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 701);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Quản Lý Kho");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Tùy Chọn");
		menuBar.add(mnNewMenu);
		
		 menuDoiThongTin = new JMenuItem("Đổi thông tin");
		menuDoiThongTin.setIcon(new ImageIcon(QuanLyKho_TrangChu.class.getResource("/com/NhacCu/item/Pictogrammers-Material-Account-cog.16.png")));
		mnNewMenu.add(menuDoiThongTin);
		menuDoiThongTin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DoiThongTinMousePressed(e);
			}

		});
		JMenuItem mntmLogOut = new JMenuItem("LogOut");
		mntmLogOut.setIcon(new ImageIcon(
				QuanLyKho_TrangChu.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Pretty-Office-6-Logout.16.png")));
		mnNewMenu.add(mntmLogOut);
		
		mntmLogOut.addActionListener(new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
	                int result = JOptionPane.showConfirmDialog(null,
	                        "Bạn có chắc chắn đăng xuất không?",
	                        "Xác nhận",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
	                	setVisible(false);
	    				login.setVisible(true);
	                }
	            }
		});
		
		JMenuItem mntmThoat = new JMenuItem("Thoát");
		mntmThoat.setIcon(new ImageIcon(QuanLyKho_TrangChu.class.getResource("/com/NhacCu/item/exit_16.png")));
		mnNewMenu.add(mntmThoat);
		mntmThoat.addActionListener(new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
	                int result = JOptionPane.showConfirmDialog(null,
	                        "Bạn có chắc chắn thoát không?",
	                        "Xác nhận",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
	                	setVisible(false);
	                }
	            }
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 10, 904, 630);
		contentPane.add(splitPane);

		JPanel TopPane = new JPanel();
		splitPane.setLeftComponent(TopPane);
		TopPane.setLayout(new BorderLayout(0, 0));

		jLabel1 = new JLabel();
		jLabel1.setForeground(new Color(255, 0, 0));
		jLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("SHOP NHẠC CỤ");
		TopPane.add(jLabel1, java.awt.BorderLayout.CENTER);

		tenDangNhap = new JLabel();
		tenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		tenDangNhap.setText("");
		TopPane.add(tenDangNhap, java.awt.BorderLayout.SOUTH);

		JPanel BottomPane = new JPanel();
		BottomPane.setBackground(new Color(128, 128, 0));
		splitPane.setRightComponent(BottomPane);
		BottomPane.setLayout(new BorderLayout(0, 0));
		BottomPane.add(QLK_SP);
	}
	public void DoiThongTinMousePressed(MouseEvent evt) {
	
		DoiThongTin doiThongTin = new DoiThongTin();
		doiThongTin.setVisible(true);
	
		nvBUS.listNV();

		String chuoiCon = tenDangNhap.getText().substring(tenDangNhap.getText().indexOf(":") + 1).trim();
		doiThongTin.textFieldTenDangNhap.setText(chuoiCon);

		for (NhanVienDTO nvDTO : nvBUS.getList()) {
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