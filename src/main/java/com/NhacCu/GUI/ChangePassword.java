package com.NhacCu.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.NhacCu.BUS.AccountBUS;
import com.NhacCu.DTO.AccountDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTenDangNhapValue;
	private AccountBUS accountBUS = new AccountBUS();
	private JPasswordField passwordFieldMatKhauCu;
	private JPasswordField passwordFieldMatKhauMoi;
	private JPasswordField passwordFieldXacNhanMKMoi;
	private JLabel lblThongBaoLoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		if (accountBUS.getList() == null)
			accountBUS.listAcc();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thay Đổi Mật Khẩu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 594, 57);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 86, 132, 29);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu Cũ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(23, 151, 132, 29);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Mật Khẩu Mới");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(23, 219, 132, 29);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Xác Nhận Mật Khẩu Mới");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(23, 288, 182, 29);
		contentPane.add(lblNewLabel_1_1_1_1);

		textTenDangNhapValue = new JTextField();
		textTenDangNhapValue.setColumns(10);
		textTenDangNhapValue.setBounds(263, 88, 301, 29);
		contentPane.add(textTenDangNhapValue);

		JButton btnXacNhan = new JButton("Xác Nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacNhan();
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXacNhan.setBounds(93, 398, 141, 35);
		contentPane.add(btnXacNhan);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(396, 398, 141, 35);
		contentPane.add(btnThoat);

		passwordFieldMatKhauCu = new JPasswordField();
		passwordFieldMatKhauCu.setBounds(263, 151, 301, 29);
		contentPane.add(passwordFieldMatKhauCu);

		passwordFieldMatKhauMoi = new JPasswordField();
		passwordFieldMatKhauMoi.setBounds(263, 219, 301, 29);
		contentPane.add(passwordFieldMatKhauMoi);

		passwordFieldXacNhanMKMoi = new JPasswordField();
		passwordFieldXacNhanMKMoi.setBounds(263, 288, 301, 29);
		contentPane.add(passwordFieldXacNhanMKMoi);

		textTenDangNhapValue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordFieldMatKhauCu.requestFocusInWindow();
			}
		});
		passwordFieldMatKhauCu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordFieldMatKhauMoi.requestFocusInWindow();
			}
		});
		passwordFieldMatKhauMoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordFieldXacNhanMKMoi.requestFocusInWindow();
			}
		});
		passwordFieldXacNhanMKMoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnXacNhan();
			}
		});

		lblThongBaoLoi = new JLabel("");
		lblThongBaoLoi.setForeground(new Color(255, 0, 0));
		lblThongBaoLoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThongBaoLoi.setBounds(273, 327, 338, 35);
		contentPane.add(lblThongBaoLoi);
	}

	public void btnXacNhan() {
		String textTenDangNhap = textTenDangNhapValue.getText();
		String matKhauCu = new String(passwordFieldMatKhauCu.getPassword());
		String matKhauMoi = new String(passwordFieldMatKhauMoi.getPassword());
		String xacNhanMatKhauMoi = new String(passwordFieldXacNhanMKMoi.getPassword());
		if (textTenDangNhap.isEmpty()) {
			System.out.println("Vui lòng nhập tên đăng nhập!");
			lblThongBaoLoi.setText("Vui lòng nhập tên đăng nhập!");
		} else {
			if (matKhauCu.isEmpty()) {
				System.out.println("Vui lòng nhập mật khẩu cũ!");
				lblThongBaoLoi.setText("Vui lòng nhập mật khẩu cũ!");
			} else {
				if (matKhauMoi.isEmpty()) {
					System.out.println("Vui lòng nhập mật khẩu mới!");
					lblThongBaoLoi.setText("Vui lòng nhập mật khẩu mới!");
				} else {
					if (xacNhanMatKhauMoi.isEmpty()) {
						System.out.println("Vui lòng nhập xác nhận lại mật khẩu mới!");
						lblThongBaoLoi.setText("Vui lòng nhập xác nhận lại mật khẩu mới!");
					} else {
						if (matKhauMoi.equals(xacNhanMatKhauMoi) == false) {
							System.out.println("Xác nhận mật khẩu mới không giống nhau!");
							lblThongBaoLoi.setText("Xác nhận mật khẩu mới không giống nhau!");
						} else {
							if (matKhauMoi.equals(matKhauCu) == false) {
								System.out.println("Mật khẩu mới trùng với mật khẩu cũ!");
								lblThongBaoLoi.setText("Mật khẩu mới trùng với mật khẩu cũ!");
							}else {
								if (accountBUS.checkPassword(textTenDangNhap, matKhauCu) == true
										&& accountBUS.checkEnable(textTenDangNhap) == 1) {
									System.out.println("");
									lblThongBaoLoi.setText("");
									JFrame frame = new JFrame("JOptionPane showMessageDialog");
									JOptionPane.showMessageDialog(frame, "Đổi mật khẩu thành công", "",
											JOptionPane.INFORMATION_MESSAGE);
									AccountDTO accountDTO = new AccountDTO(textTenDangNhap, matKhauMoi, accountBUS.checkRole(textTenDangNhap), 1);
									accountBUS.updateAcc(accountDTO);
									this.hide();
								} else {
									System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác!");
									lblThongBaoLoi.setText("Tên đăng nhập hoặc mật khẩu không chính xác!");
								}
							}
						}
					}
				}
			}
		}
	}
}
