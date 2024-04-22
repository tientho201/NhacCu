package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Admin_SanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Admin_SanPham() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("BẢNG SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(6, 3, 1099, 53);
		add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 65, 1092, 254);
		add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1069, 233);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Lo\u1EA1i", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Nh\u00E0 S\u1EA3n Xu\u1EA5t", "\u1EA2nh", "M\u00F4 T\u1EA3"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(6, 334, 1103, 328);
		add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Mã SP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(13, 10, 74, 31);
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(129, 10, 146, 32);
		panel_3.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã Loại");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(13, 65, 74, 31);
		panel_3.add(lblNewLabel_2_1);
		
		JComboBox comboBoxMaLoai = new JComboBox();
		comboBoxMaLoai.setBounds(128, 66, 146, 31);
		panel_3.add(comboBoxMaLoai);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Nhà SX");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(13, 127, 85, 31);
		panel_3.add(lblNewLabel_2_1_1);
		
		JComboBox comboBoxNSX = new JComboBox();
		comboBoxNSX.setBounds(129, 125, 146, 31);
		panel_3.add(comboBoxNSX);
		
		JLabel lblNewLabel_2_2 = new JLabel("Giá");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(365, 8, 74, 31);
		panel_3.add(lblNewLabel_2_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(540, 11, 146, 32);
		panel_3.add(textField_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Tên SP");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(364, 64, 74, 31);
		panel_3.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Số Lượng");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(369, 131, 74, 31);
		panel_3.add(lblNewLabel_2_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(543, 127, 146, 32);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(541, 65, 146, 32);
		panel_3.add(textField_3);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Mô Tả");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(908, 10, 85, 31);
		panel_3.add(lblNewLabel_2_2_2);
		
		JScrollPane scrollPane1 = new JScrollPane((Component) null);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setAutoscrolls(true);
		scrollPane1.setBounds(908, 56, 146, 120);
		panel_3.add(scrollPane1);
		
		JTextArea textArea = new JTextArea();
		scrollPane1.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(23, 284, 103, 31);
		panel_3.add(btnNewButton);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(308, 283, 95, 31);
		panel_3.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(613, 281, 95, 31);
		panel_3.add(btnXoa);
		
		JButton btnReload = new JButton("Reload");
		btnReload.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBounds(908, 278, 124, 31);
		panel_3.add(btnReload);
		
		JLabel lblThongBaoLoi = new JLabel("");
		lblThongBaoLoi.setForeground(Color.RED);
		lblThongBaoLoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThongBaoLoi.setBounds(97, 168, 327, 27);
		panel_3.add(lblThongBaoLoi);
		
		JButton btnAddImg = new JButton("Chọn ảnh");
		btnAddImg.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/add-image_16.png")));
		btnAddImg.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddImg.setBounds(170, 224, 146, 31);
		panel_3.add(btnAddImg);
		
		JLabel lblImg = new JLabel("Hình Ảnh");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImg.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblImg.setBounds(713, 176, 131, 82);
		panel_3.add(lblImg);
	}

}
