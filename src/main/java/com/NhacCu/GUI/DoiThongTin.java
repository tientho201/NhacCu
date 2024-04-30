package com.NhacCu.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import com.NhacCu.BUS.*;
import com.NhacCu.DTO.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoiThongTin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldTenDangNhap;
	public JTextField textFieldMaNguoiDung;
	public JTextField textFieldHovaTen;
	public JTextField textFieldNgaySinh;
	public JTextField textFieldSoDienThoai;
	public JTextField textFieldDiaChi;
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private ButtonGroup buttonGroup;
	public JRadioButton rdbtnNam;
	public JRadioButton rdbtnNu;
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

					DoiThongTin frame = new DoiThongTin();
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
	public DoiThongTin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 613);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Đổi thông tin");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(1, 0, 518, 98);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ĐỔI THÔNG TIN");
		lblNewLabel.setBounds(3, 2, 518, 96);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));

		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 174, 148, 29);
		contentPane.add(lblNewLabel_1);

		textFieldTenDangNhap = new JTextField();
		textFieldTenDangNhap.setEditable(false);
		textFieldTenDangNhap.setEnabled(false);
		textFieldTenDangNhap.setBounds(210, 174, 231, 29);
		contentPane.add(textFieldTenDangNhap);
		textFieldTenDangNhap.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Mã người dùng");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 123, 148, 29);
		contentPane.add(lblNewLabel_1_1);

		textFieldMaNguoiDung = new JTextField();
		textFieldMaNguoiDung.setEnabled(false);
		textFieldMaNguoiDung.setEditable(false);
		textFieldMaNguoiDung.setColumns(10);
		textFieldMaNguoiDung.setBounds(210, 123, 231, 29);
		contentPane.add(textFieldMaNguoiDung);

		JLabel lblNewLabel_1_2 = new JLabel("Họ và tên");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 223, 148, 29);
		contentPane.add(lblNewLabel_1_2);

		textFieldHovaTen = new JTextField();
		textFieldHovaTen.setColumns(10);
		textFieldHovaTen.setBounds(210, 223, 231, 29);
		contentPane.add(textFieldHovaTen);

		JLabel lblNewLabel_1_2_1 = new JLabel("Giới tính");
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(10, 275, 148, 29);
		contentPane.add(lblNewLabel_1_2_1);

		buttonGroup = new ButtonGroup();
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(UIManager.getColor("CheckBox.background"));
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNam.setSelected(true);
		rdbtnNam.setBounds(220, 275, 103, 29);
		buttonGroup.add(rdbtnNam);
		contentPane.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNu.setBounds(338, 275, 103, 29);
		buttonGroup.add(rdbtnNu);
		contentPane.add(rdbtnNu);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1.setBounds(10, 326, 148, 29);
		contentPane.add(lblNewLabel_1_2_1_1);

		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(210, 326, 231, 29);
		contentPane.add(textFieldNgaySinh);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1.setBounds(10, 382, 148, 29);
		contentPane.add(lblNewLabel_1_2_1_1_1);

		textFieldSoDienThoai = new JTextField();
		textFieldSoDienThoai.setColumns(10);
		textFieldSoDienThoai.setBounds(210, 382, 231, 29);
		contentPane.add(textFieldSoDienThoai);

		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1_1.setBounds(10, 437, 148, 29);
		contentPane.add(lblNewLabel_1_2_1_1_1_1);

		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setColumns(10);
		textFieldDiaChi.setBounds(210, 437, 231, 29);
		contentPane.add(textFieldDiaChi);

		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacnhan();
			}
		});
		btnNewButton.setIcon(new ImageIcon(DoiThongTin.class.getResource("/com/NhacCu/item/check_24.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(216, 521, 148, 45);
		contentPane.add(btnNewButton);
	}

	public void xacnhan() {
		if(nvBUS.getList() == null) {
			nvBUS.listNV();
		}
		if (KiemTraRong()) {
			if (rdbtnNam.isSelected()) {
				for (NhanVienDTO nvDTO : nvBUS.getList()) {
					if(nvDTO.getMaNhanVien().equals(textFieldMaNguoiDung.getText())) {
						NhanVienDTO nvDTO1 = new NhanVienDTO(textFieldMaNguoiDung.getText() , textFieldTenDangNhap.getText() , textFieldHovaTen.getText() , "Nam" , textFieldNgaySinh.getText() , textFieldSoDienThoai.getText() , textFieldDiaChi.getText() , nvDTO.getChucVu() , nvDTO.getGhiChu() , nvDTO.getEnable());
						nvBUS.updateNV(nvDTO1);
						break;
					}
				}
			} else {
				for (NhanVienDTO nvDTO : nvBUS.getList()) {
					if(nvDTO.getMaNhanVien().equals(textFieldMaNguoiDung.getText())) {
						NhanVienDTO nvDTO1 = new NhanVienDTO(textFieldMaNguoiDung.getText() , textFieldTenDangNhap.getText() , textFieldHovaTen.getText() , "Nữ" , textFieldNgaySinh.getText() , textFieldSoDienThoai.getText() , textFieldDiaChi.getText() , nvDTO.getChucVu() , nvDTO.getGhiChu() , nvDTO.getEnable());
						nvBUS.updateNV(nvDTO1);
						break;
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Đổi thông tin thành công!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}

	public boolean KiemTraRong() {
		if (textFieldMaNguoiDung.getText() == null || textFieldMaNguoiDung.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Người Dùng không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldMaNguoiDung.requestFocus();
			return false;
		}
		if (textFieldDiaChi.getText() == null || textFieldDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Địa Chỉ không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldDiaChi.requestFocus();
			return false;
		}
		if (textFieldHovaTen.getText() == null || textFieldHovaTen.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Họ và Tên không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldHovaTen.requestFocus();
			return false;
		}
		if (textFieldNgaySinh.getText() == null || textFieldNgaySinh.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ngày Sinh không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldNgaySinh.requestFocus();
			return false;
		}
		if (textFieldSoDienThoai.getText() == null || textFieldSoDienThoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số Điện Thoại không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldSoDienThoai.requestFocus();
			return false;
		}
		if (textFieldTenDangNhap.getText() == null || textFieldTenDangNhap.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên Đăng Nhập không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldTenDangNhap.requestFocus();
			return false;
		}
		return true;
	}
}
