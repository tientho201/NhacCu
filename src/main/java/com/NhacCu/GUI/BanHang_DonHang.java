package com.NhacCu.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class BanHang_DonHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextArea textAreaMoTa;

	/**
	 * Create the panel.
	 */
	public BanHang_DonHang() {
		setBackground(new Color(0, 0, 255));
		setBounds(0, 0, 1336, 691);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 316, 115);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BanHang_DonHang.class.getResource("/com/NhacCu/item/LOGO.png")));
		lblNewLabel.setBounds(0, 0, 316, 115);
		panel.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 136, 1316, 545);
		add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Kiểm tra số lượng", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(10, 10, 1291, 115);
		panel_4.add(panel_3);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(200, 38, 803, 43);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã SP");
		lblNewLabel_1.setBounds(30, 38, 90, 43);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBounds(1103, 33, 145, 43);
		panel_3.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(BanHang_DonHang.class.getResource("/com/NhacCu/item/search_24.png")));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 135, 1291, 217);
		panel_4.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "T\u00EAn Lo\u1EA1i", "T\u00EAn Nh\u00E0 S\u1EA3n Xu\u1EA5t", "Image", "Ghi Ch\u00FA"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("HÌNH ẢNH");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel_2.setBounds(983, 372, 259, 136);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hóa Đơn", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 743, 232);
		panel_1.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "H\u1ECD v\u00E0 T\u00EAn Kh\u00E1ch H\u00E0ng", "Ng\u00E0y \u0110\u1EB7t", "T\u1ED5ng Ti\u1EC1n", "Tr\u1EA1ng Th\u00E1i", "M\u00E3 Nh\u00E2n Vi\u00EAn L\u1EADp"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(10, 252, 743, 194);
		panel_1.add(scrollPane_2_1);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Th\u1EDDi Gian B\u1EA3o H\u00E0nh", "Ghi Ch\u00FA"
			}
		));
		scrollPane_2_1.setViewportView(table_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setBounds(763, 10, 538, 232);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
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
		textField_1.setBounds(212, 12, 171, 25);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chờ Xác Nhận", "Xác Nhận"}));
		comboBox.setBounds(212, 152, 171, 25);
		panel_5.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BH1  BanHang1", "BH2  BanHang2"}));
		comboBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBox_1.setBounds(212, 187, 171, 35);
		panel_5.add(comboBox_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5_1.setBounds(763, 252, 538, 194);
		panel_1.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1_1_2 = new JLabel("Mã sản phẩm");
		lblNewLabel_3_1_1_1_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2.setBounds(10, 20, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBox_2.setBounds(170, 21, 141, 25);
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
		textField_5.setBounds(170, 69, 141, 25);
		panel_5_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(170, 113, 141, 25);
		panel_5_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(170, 159, 141, 25);
		panel_5_1.add(textField_7);
		
		JLabel lblNewLabel_3_1_1_1_1_2_1_2 = new JLabel("Ghi Chú");
		lblNewLabel_3_1_1_1_1_2_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2_1_2.setBounds(339, 20, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2_1_2);
		
		textAreaMoTa = new JTextArea();
		textAreaMoTa.setEnabled(false);
		textAreaMoTa.setEditable(false);
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(339, 55, 189, 129);
		panel_5_1.add(scrollPane1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// dọc
		scrollPane1.setAutoscrolls(true);
		
		JButton btnNewButton_1 = new JButton("XÁC NHẬN");
		btnNewButton_1.setIcon(new ImageIcon(BanHang_DonHang.class.getResource("/com/NhacCu/item/verified_32.png")));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton_1.setBounds(941, 456, 237, 52);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("HÓA ĐƠN");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_4.setBounds(330, 10, 875, 115);
		add(lblNewLabel_4);
	}
}
