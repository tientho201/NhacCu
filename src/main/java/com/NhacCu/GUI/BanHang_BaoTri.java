package com.NhacCu.GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class BanHang_BaoTri extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextArea textAreaMoTa;

	/**
	 * Create the panel.
	 */
	public BanHang_BaoTri() {
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
		
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(false);
		toolBar.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		toolBar.setBounds(336, 10, 274, 115);
		add(toolBar);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNewButton.setFocusable(false);
		btnNewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btnNewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		toolBar.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXa.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnXa.setFocusable(false);
		toolBar.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSa.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnSa.setFocusable(false);
		toolBar.add(btnSa);
		
		JButton btnXa_1_1 = new JButton("Đặt lại");
		btnXa_1_1.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnXa_1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXa_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXa_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnXa_1_1.setFocusable(false);
		toolBar.add(btnXa_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_1.setBounds(628, 10, 698, 115);
		add(panel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Hoàn thành", "Chưa hoàn thành", "Chờ xác nhận"}));
		comboBox.setBounds(30, 45, 158, 41);
		panel_1.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(232, 45, 243, 41);
		panel_1.add(textField);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLamMoi.setBounds(527, 41, 139, 41);
		panel_1.add(btnLamMoi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 706, 280);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Phi\u1EBFu B\u1EA3o Tr\u00EC", "M\u00E3 Nh\u00E2n Vi\u00EAn", "M\u00E3 User", "M\u00E3 H\u00F3a \u0110\u01A1n", "Ng\u00E0y L\u1EADp", "Tr\u1EA1ng Th\u00E1i", "Chuy\u1EC3n Phi\u1EBFu"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 436, 706, 245);
		add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Phi\u1EBFu B\u1EA3o Tr\u00EC", "Ghi Ch\u00FA"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(726, 147, 600, 280);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phiếu bảo trì");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 10, 122, 24);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 54, 108, 24);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã khách hàng");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 101, 122, 24);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 151, 122, 24);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày lập");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(10, 195, 68, 24);
		panel_2.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Trạng thái");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(9, 235, 122, 24);
		panel_2.add(lblNewLabel_1_1_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField_1.setBounds(164, 13, 239, 24);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 57, 239, 24);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(164, 101, 239, 24);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(164, 151, 239, 24);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(164, 195, 239, 24);
		panel_2.add(textField_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Hoàn thành", "Chưa hoàn thành", "Chờ xác nhận"}));
		comboBox_1.setBounds(164, 235, 239, 25);
		panel_2.add(comboBox_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(726, 436, 600, 245);
		add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã sản phẩm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 21, 122, 24);
		panel_2_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ghi Chú");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(10, 96, 122, 24);
		panel_2_1.add(lblNewLabel_1_2_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"SP1  Đàn Piano Apollo", "SP2  Đàn Violin"}));
		comboBox_2.setBounds(142, 21, 294, 24);
		panel_2_1.add(comboBox_2);
		
		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(142, 97, 294, 138);
		panel_2_1.add(scrollPane1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// dọc
		scrollPane1.setAutoscrolls(true);
	}
}
