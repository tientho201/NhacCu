package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Admin_ThongKe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public Admin_ThongKe() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 1097, 665);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Mua Bán", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "T\u1ED5ng quan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 10, 1072, 131);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.GREEN);
		panel_1_1.setBounds(43, 29, 287, 74);
		panel_3.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("    ");
		lblNewLabel_1.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/products_64.png")));
		lblNewLabel_1.setBounds(10, 0, 87, 74);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sản phẩm mua nhiều nhất");
		lblNewLabel_2_1.setBounds(62, 0, 225, 36);
		panel_1_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Đàn Piano");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setBounds(92, 31, 185, 43);
		panel_1_1.add(lblNewLabel);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1.setBounds(397, 29, 287, 74);
		panel_3.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("    ");
		lblNewLabel_1_1.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/network_64.png")));
		lblNewLabel_1_1.setBounds(10, 0, 87, 74);
		panel_1_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tổng sản phẩm đã bán");
		lblNewLabel_2_1_1.setBounds(77, 0, 200, 37);
		panel_1_1_1.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("100");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(87, 31, 190, 43);
		panel_1_1_1.add(lblNewLabel_2);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1_1.setBounds(759, 29, 287, 74);
		panel_3.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("    ");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/salary_64.png")));
		lblNewLabel_1_1_1.setBounds(10, 0, 87, 74);
		panel_1_1_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Tổng tiền thu được");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(77, 0, 200, 37);
		panel_1_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("1000000");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_2_2.setBounds(87, 31, 190, 43);
		panel_1_1_1_1.add(lblNewLabel_2_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 1072, 477);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch H\u00E0ng", "M\u00E3 Nh\u00E2n Vi\u00EAn", "M\u00E3 S\u1EA3n Ph\u1EA9m", "Ng\u00E0y Mua", "T\u1ED5ng Ti\u1EC1n", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Nhập Kho", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(null, "T\u1ED5ng quan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3_1.setBounds(10, 10, 1072, 131);
		panel_2.add(panel_3_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBackground(Color.GREEN);
		panel_1_1_2.setBounds(43, 29, 287, 74);
		panel_3_1.add(panel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("    ");
		lblNewLabel_1_2.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/products_64.png")));
		lblNewLabel_1_2.setBounds(10, 0, 87, 74);
		panel_1_1_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Sản phẩm nhập nhiều nhất");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(62, 0, 225, 36);
		panel_1_1_2.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("Đàn Piano");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_3.setBounds(92, 31, 185, 43);
		panel_1_1_2.add(lblNewLabel_3);
		
		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setLayout(null);
		panel_1_1_1_2.setBackground(new Color(128, 255, 255));
		panel_1_1_1_2.setBounds(397, 29, 287, 74);
		panel_3_1.add(panel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("    ");
		lblNewLabel_1_1_2.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/multiple-users-silhouette_64.png")));
		lblNewLabel_1_1_2.setBounds(10, 0, 87, 74);
		panel_1_1_1_2.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Nhà Cung Cấp nhiều nhất");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2.setBounds(77, 0, 210, 37);
		panel_1_1_1_2.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("NCC Hồ Chí Minh");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(87, 31, 190, 43);
		panel_1_1_1_2.add(lblNewLabel_2_3);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1_1_1.setBounds(759, 29, 287, 74);
		panel_3_1.add(panel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("    ");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/note_64.png")));
		lblNewLabel_1_1_1_1.setBounds(10, 0, 87, 74);
		panel_1_1_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Số phiếu bảo trì");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1.setBounds(77, 0, 200, 37);
		panel_1_1_1_1_1.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("1000000");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_2_2_1.setBounds(87, 31, 190, 43);
		panel_1_1_1_1_1.add(lblNewLabel_2_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 151, 1072, 477);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "Gi\u00E1 Nh\u1EADp", "S\u1ED1 L\u01B0\u1EE3ng", "Ng\u00E0y Nh\u1EADp", "T\u1ED5ng Ti\u1EC1n"
			}
		));
		scrollPane_1.setViewportView(table_1);
	}
}
