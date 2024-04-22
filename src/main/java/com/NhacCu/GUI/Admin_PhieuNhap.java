package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Admin_PhieuNhap extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public Admin_PhieuNhap() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Phiếu Nhập Kho Hàng");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(0, 10, 1117, 47);
		add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 68, 633, 281);
		add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 613, 261);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00C3 Phi\u1EBFu Nh\u1EADp", "M\u00E3 Nh\u00E0 Cung C\u1EA5p", "M\u00E3 Nh\u00E2n Vi\u00EAn", "Ng\u00E0y Nh\u1EADp", "T\u1ED5ng Ti\u1EC1n", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setLayout(null);
		panel_6.setBounds(10, 368, 633, 228);
		add(panel_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 613, 208);
		panel_6.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Phi\u1EBFu Nh\u1EADp", "M\u00E3 S\u1EA3n Ph\u1EA9m", "Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Ghi Ch\u00FA"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(null);
		panel_5.setBounds(673, 67, 425, 282);
		add(panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Mã PNH");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(72, 9, 76, 26);
		panel_5.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(220, 10, 172, 28);
		panel_5.add(textField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mã NCC");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(72, 52, 76, 26);
		panel_5.add(lblNewLabel_2_1_1);
		
		JComboBox comboBoxMaNCC = new JComboBox();
		comboBoxMaNCC.setBounds(220, 53, 172, 26);
		panel_5.add(comboBoxMaNCC);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Mã NV");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_1.setBounds(72, 97, 76, 26);
		panel_5.add(lblNewLabel_2_1_1_1);
		
		JComboBox comboBoxMaNV = new JComboBox();
		comboBoxMaNV.setBounds(220, 98, 172, 26);
		panel_5.add(comboBoxMaNV);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày Nhập");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(72, 147, 76, 26);
		panel_5.add(lblNewLabel_2_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(220, 149, 172, 26);
		panel_5.add(textField_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Trạng Thái");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_2.setBounds(72, 245, 76, 26);
		panel_5.add(lblNewLabel_2_2_2);
		
		JComboBox comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setBounds(220, 246, 172, 26);
		panel_5.add(comboBoxTrangThai);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(220, 199, 172, 26);
		panel_5.add(textField_2);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Tổng Tiền");
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1_2.setBounds(72, 197, 76, 26);
		panel_5.add(lblNewLabel_2_2_1_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(673, 368, 425, 228);
		add(panel_3);
		
		JLabel lblThongBao = new JLabel("");
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThongBao.setBounds(43, 197, 262, 26);
		panel_3.add(lblThongBao);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã SP");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 10, 76, 26);
		panel_3.add(lblNewLabel_2_1);
		
		JComboBox comboBoxMaSP = new JComboBox();
		comboBoxMaSP.setBounds(96, 11, 209, 26);
		panel_3.add(comboBoxMaSP);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Giá ");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1.setBounds(10, 53, 65, 26);
		panel_3.add(lblNewLabel_2_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 55, 209, 26);
		panel_3.add(textField_3);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Số Lượng");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1_1.setBounds(10, 90, 65, 26);
		panel_3.add(lblNewLabel_2_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(96, 91, 209, 27);
		panel_3.add(textField_4);
		
		JLabel lblNewLabel_2_2_1_2_1 = new JLabel("Ghi Chú");
		lblNewLabel_2_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1_2_1.setBounds(9, 136, 76, 26);
		panel_3.add(lblNewLabel_2_2_1_2_1);
		
		JScrollPane scrollPane1 = new JScrollPane((Component) null);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setAutoscrolls(true);
		scrollPane1.setBounds(97, 137, 208, 81);
		panel_3.add(scrollPane1);
		
		JButton btnLuuPhieu_1 = new JButton("<html><center><img src='file:/F:/TÀI%20LIỆU%20HỌC%20TẬP/Lập%20Trình%20Java/Đồ_án/bin/item/folder_16.png'><br>In và Lưu </br>Phiếu</center></html>");
		btnLuuPhieu_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLuuPhieu_1.setBounds(356, 10, 47, 208);
		panel_3.add(btnLuuPhieu_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(null);
		panel_4.setBounds(10, 613, 1088, 50);
		add(panel_4);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(Admin_PhieuNhap.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(10, 10, 110, 30);
		panel_4.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(Admin_PhieuNhap.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(301, 10, 110, 30);
		panel_4.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(Admin_PhieuNhap.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(631, 10, 110, 30);
		panel_4.add(btnXoa);
		
		JButton btnReload = new JButton("Reload");
		btnReload.setIcon(new ImageIcon(Admin_PhieuNhap.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReload.setBounds(951, 10, 127, 30);
		panel_4.add(btnReload);
	}

}
