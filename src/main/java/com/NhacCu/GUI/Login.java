package com.NhacCu.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import com.NhacCu.BUS.AccountBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.UserBUS;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField TenDangNhapValue;
	private JPasswordField MatKhauValue;
	private JLabel NotifiError;
	private AccountBUS accBUS = new AccountBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private UserBUS usBUS = new UserBUS();

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
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 579);
		setTitle("Đăng Nhập");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel TenDangNhap = new JLabel("Tên Đăng Nhập");
		TenDangNhap.setForeground(new Color(255, 255, 255));
		TenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		TenDangNhap.setBounds(76, 219, 234, 51);
		contentPane.add(TenDangNhap);

		JLabel MatKhau = new JLabel("Mật Khẩu");
		MatKhau.setForeground(new Color(255, 255, 255));
		MatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		MatKhau.setBounds(76, 304, 200, 50);
		contentPane.add(MatKhau);

		TenDangNhapValue = new JTextField();
		TenDangNhapValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		TenDangNhapValue.setBounds(355, 219, 281, 51);
		contentPane.add(TenDangNhapValue);
		TenDangNhapValue.setToolTipText("Điền tên đăng nhập");
		TenDangNhapValue.setColumns(10);

		JButton BtnDangNhap = new JButton("Đăng Nhập");
		BtnDangNhap.setIgnoreRepaint(true);
		BtnDangNhap.setIconTextGap(2);
		BtnDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		BtnDangNhap.setBounds(87, 440, 189, 51);
		BtnDangNhap.setIcon(new ImageIcon(getClass().getResource("/com/NhacCu/item/icon-login.jpg")));
		BtnDangNhap.setToolTipText("Đăng nhập vào hệ thống");
		contentPane.add(BtnDangNhap);

		JButton BtnDangKi = new JButton("Đăng Kí");
		BtnDangKi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		BtnDangKi.setBounds(637, 440, 189, 51);
		BtnDangKi.setIcon(new ImageIcon(getClass().getResource("/com/NhacCu/item/Chuyen_Huong.png")));
		BtnDangKi.setToolTipText("Chuyển hướng sang đăng kí");
		contentPane.add(BtnDangKi);

		JLabel lblNewLabel_2 = new JLabel("Đăng Nhập");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_2.setBounds(0, 0, 888, 209);
		contentPane.add(lblNewLabel_2);

		MatKhauValue = new JPasswordField();
		MatKhauValue.setBounds(355, 304, 281, 50);
		MatKhauValue.setToolTipText("Điền mật khẩu");
		contentPane.add(MatKhauValue);

		NotifiError = new JLabel("");
		NotifiError.setForeground(new Color(255, 0, 0));
		NotifiError.setFont(new Font("Tahoma", Font.PLAIN, 17));
		NotifiError.setBounds(365, 364, 511, 33);
		contentPane.add(NotifiError);
		
//		Nút thay đổi mật khẩu
		
		JButton BtnChangePassword = new JButton("Đổi Mật Khẩu");
		BtnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword changPassword = new ChangePassword();
				changPassword.setVisible(true);
			}
		});
		BtnChangePassword.setIcon(new ImageIcon(Login.class.getResource("/com/NhacCu/item/Pictogrammers-Material-Form-textbox-password.16.png")));
		BtnChangePassword.setToolTipText("Thay Đổi Mật Khẩu");
		BtnChangePassword.setIgnoreRepaint(true);
		BtnChangePassword.setIconTextGap(2);
		BtnChangePassword.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		BtnChangePassword.setBounds(365, 440, 189, 51);
		contentPane.add(BtnChangePassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/com/NhacCu/item/Anh_Nen.jpg")));
		lblNewLabel.setBounds(0, 0, 888, 553);
		contentPane.add(lblNewLabel);

//		Xử lí  Nút Đăng Kí 
		
		BtnDangKi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Tạo và hiển thị frame mới khi nút được nhấn
				SignUp signUp = new SignUp();
				signUp.setVisible(true);
				setVisible(false);
			}
		});
		TenDangNhapValue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MatKhauValue.requestFocusInWindow(); // Di chuyển focus đến textField2
			}
		});
		BtnDangNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Lấy giá trị của tên đăng nhập và mật khẩu được nhập từ bàn phím
				BtnLogin();
			}
		});
		BtnDangNhap.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				"enter");
		BtnDangNhap.getActionMap().put("enter", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Thực hiện hành động tương tự khi nhấn nút "Enter Button"
				BtnLogin();
			}
		});
	}

	public void BtnLogin() {
		String tenDangNhapValue = TenDangNhapValue.getText();
		String matKhauValue = new String(MatKhauValue.getPassword());

		// Đảm bảo dữ liệu đã được tải vào từ cơ sở dữ liệu
		if (accBUS.getList() == null)
			accBUS.listAcc();
		if (nvBUS.getList() == null)
			nvBUS.listNV();
		if (usBUS.getList() == null) {
			usBUS.listUs();
		}
		if (tenDangNhapValue.isEmpty()) {
			System.out.println("Vui lòng nhập tên đăng nhập!");
			NotifiError.setText("Vui lòng nhập tên đăng nhập!");
		} else {
			if (matKhauValue.isEmpty()) {
				System.out.println("Vui lòng nhập mật khẩu!");
				NotifiError.setText("Vui lòng nhập mật khẩu!");
			} else {
				if (accBUS.checkPassword(tenDangNhapValue, matKhauValue) == true && accBUS.checkEnable(tenDangNhapValue) == 1) {					
						System.out.println("");
						NotifiError.setText("");
						JFrame frame = new JFrame("JOptionPane showMessageDialog");
						JOptionPane.showMessageDialog(frame, "Xin chào " + accBUS.checkRole(tenDangNhapValue) + " !",
								"", JOptionPane.INFORMATION_MESSAGE);
						if (accBUS.checkRole(tenDangNhapValue).equals("Admin")) {
							QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
							quanLyNhanVien.show();
							quanLyNhanVien.TextShowName.setText(tenDangNhapValue);
						}else {
							if(accBUS.checkRole(tenDangNhapValue).equals("QLK")) {
								QuanLyKho_TrangChu QLK_TrangChu = new QuanLyKho_TrangChu();
								QLK_TrangChu.show();
								QLK_TrangChu.tenDangNhap.setText("Xin Chào:  " + tenDangNhapValue);
							}else {
								if(accBUS.checkRole(tenDangNhapValue).equals("NhanVien")) {
									BanHang banHang = new BanHang();
									banHang.show();
									banHang.MenuTenDangNhap.setText("Xin Chào:  " + tenDangNhapValue);
								}else{
									if(accBUS.checkRole(tenDangNhapValue).equals("ChuDoanhNghiep")) {
										Admin admin = new Admin();
						
										admin.setVisible(true);
										admin.tendangnhap.setText("Xin Chào:  " + tenDangNhapValue);
									}
								}
							}
						}
						this.hide();
				} else {
					System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác!");
					NotifiError.setText("Tên đăng nhập hoặc mật khẩu không chính xác!");
				}
			}
		}
	}
}
