package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Admin_PhanLoai extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Admin_PhanLoai() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Phân Loại");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(10, 10, 1097, 79);
		add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 99, 1097, 274);
		add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1077, 254);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"M\u00E3 Lo\u1EA1i", "T\u00EAn Lo\u1EA1i"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 383, 1097, 169);
		add(panel_3);
		
		JLabel lblMaLoai = new JLabel("Mã Loại");
		lblMaLoai.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMaLoai.setBounds(159, 23, 100, 28);
		panel_3.add(lblMaLoai);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(376, 26, 221, 30);
		panel_3.add(textField);
		
		JLabel lblTenLoai = new JLabel("Tên Loại");
		lblTenLoai.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTenLoai.setBounds(164, 93, 95, 28);
		panel_3.add(lblTenLoai);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(376, 97, 221, 28);
		panel_3.add(textField_1);
		
		JLabel lblThongBao = new JLabel("");
		lblThongBao.setBounds(151, 131, 296, 28);
		panel_3.add(lblThongBao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 592, 1097, 58);
		add(panel_4);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(Admin_PhanLoai.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(10, 10, 111, 38);
		panel_4.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(Admin_PhanLoai.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(333, 10, 111, 38);
		panel_4.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(Admin_PhanLoai.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(684, 10, 111, 38);
		panel_4.add(btnXoa);
		
		JButton btnReload = new JButton("Reload");
		btnReload.setIcon(new ImageIcon(Admin_PhanLoai.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBounds(956, 10, 119, 38);
		panel_4.add(btnReload);
	}

}
