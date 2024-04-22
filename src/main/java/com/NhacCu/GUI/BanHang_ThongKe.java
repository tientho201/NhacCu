package com.NhacCu.GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class BanHang_ThongKe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField textField_2;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public BanHang_ThongKe() {
		setBackground(new Color(0, 0, 255));
		setBounds(0, 0, 1336, 691);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 316, 115);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BanHang_LSDonHang.class.getResource("/com/NhacCu/item/LOGO.png")));
		lblNewLabel.setBounds(0, 0, 316, 115);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(336, 10, 990, 115);
		panel_2.setBorder(new TitledBorder(null, "T\u1ED5ng quan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 0));
		panel_1.setBounds(22, 20, 287, 74);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("    ");
		lblNewLabel_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/products_64.png")));
		lblNewLabel_1.setBounds(10, 0, 87, 74);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("100");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(107, 0, 170, 36);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sản phẩm trong kho");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(107, 38, 170, 36);
		panel_1.add(lblNewLabel_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1.setBounds(352, 20, 287, 74);
		panel_2.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("100");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2.setBounds(107, 0, 170, 36);
		panel_1_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Người dùng");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(107, 38, 170, 36);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("    ");
		lblNewLabel_1_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/multiple-users-silhouette_64.png")));
		lblNewLabel_1_1.setBounds(27, 0, 87, 74);
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1.setBounds(680, 20, 287, 74);
		panel_2.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("    ");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/bill_64.png")));
		lblNewLabel_1_1_1.setBounds(25, 0, 87, 74);
		panel_1_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("100");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2_1.setBounds(107, 0, 170, 36);
		panel_1_1_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Tổng hóa đơn");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(107, 38, 170, 36);
		panel_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 138, 1319, 537);
		add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Sản phẩm", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 10, 336, 88);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(23, 30, 282, 36);
		panel_6.add(textField);
		textField.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(356, 10, 948, 88);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JDateChooser dateFromSP = new JDateChooser();
		dateFromSP.setBounds(86, 30, 199, 34);
		panel_7.add(dateFromSP);
		
		JLabel lblNewLabel_3 = new JLabel("Từ ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(31, 30, 45, 34);
		panel_7.add(lblNewLabel_3);
		
		JDateChooser dateFromSP_1 = new JDateChooser();
		dateFromSP_1.setBounds(449, 30, 176, 34);
		panel_7.add(dateFromSP_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Đến");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(338, 30, 45, 34);
		panel_7.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Làm mới");
		btnNewButton.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton.setBounds(745, 30, 168, 34);
		panel_7.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 1294, 317);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng Nh\u1EADp", "S\u1ED1 L\u01B0\u1EE3ng Xu\u1EA5t"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("In và Lưu Trữ");
		btnNewButton_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/download-file_32.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1.setBounds(617, 448, 246, 52);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Xuất Excel");
		btnNewButton_1_1.setFocusCycleRoot(true);
		btnNewButton_1_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/sheets_32.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1_1.setBounds(997, 448, 246, 52);
		panel_3.add(btnNewButton_1_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Người dùng", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6_1.setBounds(187, 10, 1035, 88);
		panel_4.add(panel_6_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(167, 31, 446, 36);
		panel_6_1.add(textField_1);
		
		JButton btnNewButton_2 = new JButton("Làm mới");
		btnNewButton_2.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_2.setBounds(754, 31, 168, 36);
		panel_6_1.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 114, 1294, 316);
		panel_4.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch H\u00E0ng", "H\u1ECD v\u00E0 T\u00EAn", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "\u0110\u1ECBa Ch\u1EC9", "Ghi Ch\u00FA", "S\u1EA3n Ph\u1EA9m B\u1EA3o Tr\u00EC", "T\u1ED5ng H\u00F3a \u0110\u01A1n"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Xuất Excel");
		btnNewButton_1_1_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/sheets_32.png")));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1_1_1.setFocusCycleRoot(true);
		btnNewButton_1_1_1.setBounds(1020, 448, 246, 52);
		panel_4.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_2 = new JButton("In và Lưu Trữ");
		btnNewButton_1_2.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/download-file_32.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1_2.setBounds(675, 448, 246, 52);
		panel_4.add(btnNewButton_1_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Hóa đơn", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setLayout(null);
		panel_6_2.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6_2.setBounds(10, 10, 454, 88);
		panel_5.add(panel_6_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(179, 30, 242, 36);
		panel_6_2.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Hóa đơn bán hàng", "Hóa đơn bảo trì"}));
		comboBox.setBounds(10, 28, 148, 36);
		panel_6_2.add(comboBox);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBorder(new TitledBorder(null, "L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7_1.setBounds(487, 10, 817, 88);
		panel_5.add(panel_7_1);
		
		JDateChooser dateFromSP_2 = new JDateChooser();
		dateFromSP_2.setBounds(86, 30, 176, 34);
		panel_7_1.add(dateFromSP_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Từ ");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(31, 30, 45, 34);
		panel_7_1.add(lblNewLabel_3_2);
		
		JDateChooser dateFromSP_1_1 = new JDateChooser();
		dateFromSP_1_1.setBounds(410, 30, 176, 34);
		panel_7_1.add(dateFromSP_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Đến");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(310, 30, 45, 34);
		panel_7_1.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton_3 = new JButton("Làm mới");
		btnNewButton_3.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_3.setBounds(647, 30, 146, 34);
		panel_7_1.add(btnNewButton_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 108, 1294, 307);
		panel_5.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Nh\u00E2n Vi\u00EAn", "M\u00E3 Kh\u00E1ch H\u00E0ng", "Ng\u00E0y L\u1EADp", "T\u1ED5ng Ti\u1EC1n", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_4 = new JLabel("Tổng hóa đơn: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(10, 453, 197, 33);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("0");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_5.setBounds(217, 453, 45, 29);
		panel_5.add(lblNewLabel_5);
		
		JButton btnNewButton_1_2_1 = new JButton("In và Lưu Trữ");
		btnNewButton_1_2_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/download-file_32.png")));
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1_2_1.setBounds(704, 443, 246, 52);
		panel_5.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Xuất Excel");
		btnNewButton_1_1_2.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/sheets_32.png")));
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1_1_2.setFocusCycleRoot(true);
		btnNewButton_1_1_2.setBounds(1038, 443, 246, 52);
		panel_5.add(btnNewButton_1_1_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tổng Tiền: ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4_1.setBounds(343, 453, 197, 33);
		panel_5.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("0");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_5_1.setBounds(509, 453, 45, 29);
		panel_5.add(lblNewLabel_5_1);
	}
}
