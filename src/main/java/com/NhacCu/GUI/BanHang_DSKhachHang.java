package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class BanHang_DSKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextArea textAreaMoTa;

	/**
	 * Create the panel.
	 */
	public BanHang_DSKhachHang() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 1336, 691);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 1326, 78);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 80, 1315, 280);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1296, 259);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn \u0110\u0103ng Nh\u1EADp", "H\u1ECD v\u00E0 T\u00EAn", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "\u0110\u1ECBa Ch\u1EC9", "Ghi Ch\u00FA", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 370, 1316, 245);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_1.setBounds(10, 10, 107, 35);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setBounds(143, 12, 149, 35);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 105, 107, 35);
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 107, 149, 35);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Họ và Tên");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 190, 107, 35);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 192, 149, 35);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Giới Tính");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(337, 10, 107, 35);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Địa Chỉ");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(705, 10, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Ghi Chú");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2.setBounds(1049, 10, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(464, 12, 149, 35);
		panel_1.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(464, 107, 149, 35);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_1_2_3 = new JLabel("Ngày Sinh");
		lblNewLabel_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_3.setBounds(337, 105, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_3);
		
		JLabel lblNewLabel_1_1_2_3_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_1_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_3_1.setBounds(337, 190, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(464, 192, 149, 35);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(822, 10, 149, 35);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_1.setBounds(705, 105, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(822, 105, 149, 35);
		panel_1.add(comboBox_1);
		
		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(1049, 62, 257, 163);
		panel_1.add(scrollPane1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// dọc
		scrollPane1.setAutoscrolls(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 625, 1316, 56);
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setIcon(new ImageIcon(BanHang_DSKhachHang.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(10, 10, 144, 36);
		panel_2.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon(BanHang_DSKhachHang.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXa.setBounds(361, 10, 144, 36);
		panel_2.add(btnXa);
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.setIcon(new ImageIcon(BanHang_DSKhachHang.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(779, 10, 144, 36);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Reload");
		btnNewButton_1_2.setIcon(new ImageIcon(BanHang_DSKhachHang.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(1162, 10, 144, 36);
		panel_2.add(btnNewButton_1_2);
	}
}
