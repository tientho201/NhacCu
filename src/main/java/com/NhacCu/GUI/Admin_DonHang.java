package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

public class Admin_DonHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public Admin_DonHang() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1117, 685);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 23, 1097, 652);
		add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		tabbedPane.addTab("Kiểm tra số lượng", null, panel_4, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(10, 10, 1072, 115);
		panel_4.add(panel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(200, 38, 560, 43);
		panel_3.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Mã SP");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(30, 38, 90, 43);
		panel_3.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(new ImageIcon(Admin_DonHang.class.getResource("/com/NhacCu/item/search_24.png")));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton.setBounds(897, 33, 145, 43);
		panel_3.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 135, 1072, 318);
		panel_4.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "T\u00EAn Lo\u1EA1i", "T\u00EAn Nh\u00E0 S\u1EA3n Xu\u1EA5t", "Image", "Ghi Ch\u00FA"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("HÌNH ẢNH");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_2.setBounds(782, 479, 259, 136);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Hóa Đơn", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 10, 1072, 605);
		panel.add(panel_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 643, 232);
		panel_1.add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "H\u1ECD v\u00E0 T\u00EAn", "Ng\u00E0y \u0110\u1EB7t", "T\u1ED5ng Ti\u1EC1n", "Tr\u1EA1ng Th\u00E1i", "M\u00E3 Nh\u00E2n Vi\u00EAn L\u1EADp"
			}
		));
		scrollPane_2.setViewportView(table_1);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(10, 252, 643, 261);
		panel_1.add(scrollPane_2_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Th\u1EDDi Gian B\u1EA3o H\u00E0nh", "Ghi Ch\u00FA"
			}
		));
		scrollPane_2_1.setViewportView(table_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(null);
		panel_5.setBounds(663, 10, 403, 232);
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Mã hóa đơn");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 10, 150, 25);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Họ và Tên");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(10, 45, 150, 25);
		panel_5.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Ngày đặt");
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBounds(10, 80, 171, 25);
		panel_5.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Tổng tiền");
		lblNewLabel_3_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1.setBounds(10, 115, 155, 25);
		panel_5.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Trạng thái");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1_1.setBounds(10, 150, 150, 25);
		panel_5.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Mã NV");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1_1_1.setBounds(10, 191, 76, 25);
		panel_5.add(lblNewLabel_3_1_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(212, 12, 171, 25);
		panel_5.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(212, 47, 171, 25);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(212, 82, 171, 25);
		panel_5.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(212, 117, 171, 25);
		panel_5.add(textField_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBox.setBounds(212, 152, 171, 25);
		panel_5.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBox_1.setBounds(212, 187, 171, 35);
		panel_5.add(comboBox_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(255, 255, 255));
		panel_5_1.setLayout(null);
		panel_5_1.setBounds(663, 252, 403, 261);
		panel_1.add(panel_5_1);
		
		JLabel lblNewLabel_3_1_1_1_1_2 = new JLabel("Mã sản phẩm");
		lblNewLabel_3_1_1_1_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2.setBounds(10, 20, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBox_2.setBounds(170, 21, 196, 25);
		panel_5_1.add(comboBox_2);
		
		JLabel lblNewLabel_3_1_1_1_1_2_1 = new JLabel("Số Lượng");
		lblNewLabel_3_1_1_1_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2_1.setBounds(10, 69, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2_1);
		
		JLabel lblNewLabel_3_1_1_1_1_2_1_1 = new JLabel("Giá");
		lblNewLabel_3_1_1_1_1_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2_1_1.setBounds(10, 113, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_2_1_1_1 = new JLabel("Thời gian bảo hành");
		lblNewLabel_3_1_1_1_1_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2_1_1_1.setBounds(10, 159, 172, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(170, 69, 196, 25);
		panel_5_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(170, 113, 196, 25);
		panel_5_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(170, 159, 196, 25);
		panel_5_1.add(textField_7);
		
		JLabel lblNewLabel_3_1_1_1_1_2_1_2 = new JLabel("Ghi Chú");
		lblNewLabel_3_1_1_1_1_2_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2_1_2.setBounds(10, 209, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2_1_2);
		
		JScrollPane scrollPane1 = new JScrollPane((Component) null);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setAutoscrolls(true);
		scrollPane1.setBounds(170, 195, 196, 56);
		panel_5_1.add(scrollPane1);
		
		JButton btnNewButton_1 = new JButton("XÁC NHẬN");
		btnNewButton_1.setIcon(new ImageIcon(Admin_DonHang.class.getResource("/com/NhacCu/item/verified_32.png")));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton_1.setBounds(829, 543, 237, 52);
		panel_1.add(btnNewButton_1);
	}
}
