package com.NhacCu.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.PatternSyntaxException;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import com.NhacCu.BUS.*;
import com.NhacCu.DTO.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BanHang_ThongKe extends JPanel {
	Color DefaultColor = new Color(240, 240, 240);
	Color ClickedColor = new Color(128, 255, 0);
	private static final long serialVersionUID = 1L;
	private JTextField textFieldTimKiemSanPham;
	private JTable table;
	private JTextField textFieldTimKiemNguoiDung;
	private JTable table_1;
	private JTextField textFieldTimKiemHoaDon;
	private JTable table_2;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private PhieuNhapHangBUS pnBUS = new PhieuNhapHangBUS();
	private ChiTietPhieuNhapBUS ctpnBUS = new ChiTietPhieuNhapBUS();
	private HoaDonBUS hdBUS = new HoaDonBUS();
	private UserBUS usBUS = new UserBUS();
	private ChiTietHoaDonBUS cthdBUS = new ChiTietHoaDonBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private JDateChooser dateFromSP;
	private JDateChooser dateFromSP_1;
	private DefaultTableModel model;
	private JLabel lblNewLabelSanPhamTrongKho;
	private JLabel lblNewLabelNguoiDung;
	private JLabel lblNewLabelTongHoaDon;
	private JComboBox comboBoxTimKiemNguoiDung;
	private DefaultTableModel model1;
	private JComboBox comboBoxTimKiemHoaDon;
	private JTable table_3;
	private DefaultTableModel model3;
	private DefaultTableModel model4;
	private JDateChooser dateFromSP_2;
	private JDateChooser dateFromSP_3;
	private JLabel lblNewLabelTongTien;

	/**
	 * Create the panel.
	 */
	public BanHang_ThongKe() {
		initComponents();
		if (spBUS.getList() == null) {
			spBUS.listSP();
		}
		if (pnBUS.getList() == null) {
			pnBUS.list();
		}
		if (ctpnBUS.getList() == null) {
			ctpnBUS.list();
		}
		if (hdBUS.getList() == null) {
			hdBUS.list();
		}
		if (usBUS.getList() == null) {
			usBUS.listUs();
		}
		if (cthdBUS.getList() == null)
			cthdBUS.list();
		if (nvBUS.getList() == null) {
			nvBUS.listNV();
		}
		initTableSanPham(spBUS.getList(), pnBUS.getList(), ctpnBUS.getList());
		initTableNguoiDung(usBUS.getList());
		initTableHoaDon(hdBUS.getList(), nvBUS.getList(), usBUS.getList(), cthdBUS.getList(), spBUS.getList());
		initCTHD(cthdBUS.getList(), spBUS.getList());
		TongKet(ctpnBUS.getList(), usBUS.getList() , hdBUS.getList() , cthdBUS.getList());
	}

	public void initComponents() {
		setBackground(new Color(0, 0, 255));
		setBounds(0, 0, 1336, 691);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 316, 115);
		add(panel);
		panel.setLayout(null);
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				TrangChuMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				TrangChuMouseClicked(e);
			}
		});

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

		lblNewLabelSanPhamTrongKho = new JLabel("100");
		lblNewLabelSanPhamTrongKho.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelSanPhamTrongKho.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabelSanPhamTrongKho.setBounds(107, 0, 170, 36);
		panel_1.add(lblNewLabelSanPhamTrongKho);

		JLabel lblNewLabel_2_1 = new JLabel("Tổng sản phẩm trong kho");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(81, 38, 206, 36);
		panel_1.add(lblNewLabel_2_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1.setBounds(352, 20, 287, 74);
		panel_2.add(panel_1_1);
		panel_1_1.setLayout(null);

		lblNewLabelNguoiDung = new JLabel("100");
		lblNewLabelNguoiDung.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelNguoiDung.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabelNguoiDung.setBounds(107, 0, 170, 36);
		panel_1_1.add(lblNewLabelNguoiDung);

		JLabel lblNewLabel_2_1_1 = new JLabel("Người dùng");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(107, 38, 170, 36);
		panel_1_1.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("    ");
		lblNewLabel_1_1.setIcon(
				new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/multiple-users-silhouette_64.png")));
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

		lblNewLabelTongHoaDon = new JLabel("100");
		lblNewLabelTongHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTongHoaDon.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabelTongHoaDon.setBounds(107, 0, 170, 36);
		panel_1_1_1.add(lblNewLabelTongHoaDon);

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
		panel_6.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00ECm ki\u1EBFm t\u00EAn s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_6.setBounds(10, 10, 364, 88);
		panel_3.add(panel_6);
		panel_6.setLayout(null);

		textFieldTimKiemSanPham = new JTextField();
		textFieldTimKiemSanPham.setBounds(23, 30, 136, 36);
		panel_6.add(textFieldTimKiemSanPham);
		textFieldTimKiemSanPham.setColumns(10);

		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textFieldTimKiemSanPham.getText();

				TableRowSorter<? extends TableModel> sorter = (TableRowSorter<? extends TableModel>) table
						.getRowSorter();

				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);

				} else {
					try {
						// Apply the filter based on the selected column index
						sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));

					} catch (PatternSyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnTmKim.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/search_24.png")));
		btnTmKim.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnTmKim.setBounds(187, 30, 147, 36);
		panel_6.add(btnTmKim);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(384, 10, 920, 88);
		panel_3.add(panel_7);
		panel_7.setLayout(null);

		dateFromSP = new JDateChooser();
		dateFromSP.setBounds(86, 30, 153, 34);
		panel_7.add(dateFromSP);

		JLabel lblNewLabel_3 = new JLabel("Từ ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(31, 30, 45, 34);
		panel_7.add(lblNewLabel_3);

		dateFromSP_1 = new JDateChooser();
		dateFromSP_1.setBounds(378, 30, 147, 34);
		panel_7.add(dateFromSP_1);

		JLabel lblNewLabel_3_1 = new JLabel("Đến");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(280, 30, 45, 34);
		panel_7.add(lblNewLabel_3_1);

		JButton btnNewButton = new JButton("Làm mới");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnNewButton.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton.setBounds(752, 30, 147, 34);
		panel_7.add(btnNewButton);

		JButton btnLc = new JButton("Lọc");
		btnLc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkDateRangeAndDisplay(spBUS.getList(), pnBUS.getList(), ctpnBUS.getList());
			}
		});
		btnLc.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/filter_24.png")));
		btnLc.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLc.setBounds(585, 30, 147, 34);
		panel_7.add(btnLc);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 1294, 317);
		panel_3.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m",
						"S\u1ED1 L\u01B0\u1EE3ng Nh\u1EADp", "S\u1ED1 L\u01B0\u1EE3ng Xu\u1EA5t" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton_1_1 = new JButton("Xuất Excel");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuatExcel(table);
			}
		});
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
		panel_6_1.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6_1.setBounds(187, 10, 1035, 88);
		panel_4.add(panel_6_1);

		textFieldTimKiemNguoiDung = new JTextField();
		textFieldTimKiemNguoiDung.setColumns(10);
		textFieldTimKiemNguoiDung.setBounds(254, 31, 343, 36);
		panel_6_1.add(textFieldTimKiemNguoiDung);

		JButton btnNewButton_2 = new JButton("Làm mới");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_2.setBounds(843, 31, 168, 36);
		panel_6_1.add(btnNewButton_2);

		comboBoxTimKiemNguoiDung = new JComboBox();
		comboBoxTimKiemNguoiDung.setBounds(23, 31, 173, 28);
		comboBoxTimKiemNguoiDung.setModel(new DefaultComboBoxModel(new String[] { "Mã Khách Hàng", "Tên Khách Hàng" }));
		panel_6_1.add(comboBoxTimKiemNguoiDung);

		JButton btnNewButton_2_1 = new JButton("Tìm kiếm");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textFieldTimKiemNguoiDung.getText();
				int columnIndex = comboBoxTimKiemNguoiDung.getSelectedIndex(); // Get the index of the selected item in
																				// the combo box
				TableRowSorter<? extends TableModel> sorter = (TableRowSorter<? extends TableModel>) table_1
						.getRowSorter();

				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);

				} else {
					try {
						// Apply the filter based on the selected column index
						sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));

					} catch (PatternSyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}

		});
		btnNewButton_2_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/search_24.png")));
		btnNewButton_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_2_1.setBounds(651, 31, 168, 36);
		panel_6_1.add(btnNewButton_2_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 114, 1294, 316);
		panel_4.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "M\u00E3 Kh\u00E1ch H\u00E0ng", "H\u1ECD v\u00E0 T\u00EAn", "Gi\u1EDBi T\u00EDnh",
						"Ng\u00E0y Sinh", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "\u0110\u1ECBa Ch\u1EC9", "Ghi Ch\u00FA",
						"S\u1EA3n Ph\u1EA9m B\u1EA3o Tr\u00EC", "T\u1ED5ng H\u00F3a \u0110\u01A1n" }));
		scrollPane_1.setViewportView(table_1);

		JButton btnNewButton_1_1_1 = new JButton("Xuất Excel");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuatExcel(table_1);
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/sheets_32.png")));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1_1_1.setFocusCycleRoot(true);
		btnNewButton_1_1_1.setBounds(1020, 448, 246, 52);
		panel_4.add(btnNewButton_1_1_1);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Hóa đơn", null, panel_5, null);
		panel_5.setLayout(null);

		JPanel panel_6_2 = new JPanel();
		panel_6_2.setLayout(null);
		panel_6_2.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6_2.setBounds(10, 10, 501, 88);
		panel_5.add(panel_6_2);

		textFieldTimKiemHoaDon = new JTextField();
		textFieldTimKiemHoaDon.setColumns(10);
		textFieldTimKiemHoaDon.setBounds(146, 30, 158, 36);
		panel_6_2.add(textFieldTimKiemHoaDon);

		comboBoxTimKiemHoaDon = new JComboBox();
		comboBoxTimKiemHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		comboBoxTimKiemHoaDon
				.setModel(new DefaultComboBoxModel(new String[] { "Mã Hóa Đơn", "Mã Nhân Viên", "Mã Khách Hàng" }));
		comboBoxTimKiemHoaDon.setBounds(10, 28, 115, 36);
		panel_6_2.add(comboBoxTimKiemHoaDon);

		JButton btnNewButton_3_1_1 = new JButton("Tìm kiếm");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textFieldTimKiemHoaDon.getText();
				int columnIndex = comboBoxTimKiemHoaDon.getSelectedIndex(); // Get the index of the selected item in the
																			// combo box
				TableRowSorter<? extends TableModel> sorter = (TableRowSorter<? extends TableModel>) table_2
						.getRowSorter();

				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);

				} else {
					try {
						// Apply the filter based on the selected column index
						sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));

					} catch (PatternSyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}

		});
		btnNewButton_3_1_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/search_24.png")));
		btnNewButton_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_3_1_1.setBounds(331, 30, 146, 34);
		panel_6_2.add(btnNewButton_3_1_1);

		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBorder(new TitledBorder(null, "L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7_1.setBounds(521, 10, 783, 88);
		panel_5.add(panel_7_1);

		dateFromSP_2 = new JDateChooser();
		dateFromSP_2.setBounds(82, 30, 153, 34);
		panel_7_1.add(dateFromSP_2);

		JLabel lblNewLabel_3_2 = new JLabel("Từ ");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(27, 30, 45, 34);
		panel_7_1.add(lblNewLabel_3_2);

		dateFromSP_3 = new JDateChooser();
		dateFromSP_3.setBounds(334, 30, 143, 34);
		panel_7_1.add(dateFromSP_3);

		JLabel lblNewLabel_3_1_1 = new JLabel("Đến");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(260, 30, 45, 34);
		panel_7_1.add(lblNewLabel_3_1_1);

		JButton btnNewButton_3 = new JButton("Làm mới");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_3.setBounds(642, 30, 131, 34);
		panel_7_1.add(btnNewButton_3);

		JButton btnNewButton_3_1 = new JButton("Lọc");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkDateRangeAndDisplay1(hdBUS.getList(), nvBUS.getList(), usBUS.getList(), cthdBUS.getList(),
						spBUS.getList());
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/filter_24.png")));
		btnNewButton_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton_3_1.setBounds(501, 30, 131, 34);
		panel_7_1.add(btnNewButton_3_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 108, 605, 307);
		panel_5.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Nh\u00E2n Vi\u00EAn",
						"M\u00E3 Kh\u00E1ch H\u00E0ng", "Ng\u00E0y L\u1EADp", "T\u1ED5ng Ti\u1EC1n",
						"Tr\u1EA1ng Th\u00E1i" }));
		scrollPane_2.setViewportView(table_2);

		JButton btnNewButton_1_1_2 = new JButton("Xuất Excel");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuatHoaDon();
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon(BanHang_ThongKe.class.getResource("/com/NhacCu/item/sheets_32.png")));
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1_1_2.setFocusCycleRoot(true);
		btnNewButton_1_1_2.setBounds(1038, 443, 246, 52);
		panel_5.add(btnNewButton_1_1_2);

		JLabel lblNewLabel_4_1 = new JLabel("Tổng Tiền: ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4_1.setBounds(35, 453, 197, 33);
		panel_5.add(lblNewLabel_4_1);

		 lblNewLabelTongTien = new JLabel("0");
		lblNewLabelTongTien.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabelTongTien.setBounds(219, 453, 374, 29);
		panel_5.add(lblNewLabelTongTien);

		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(625, 108, 679, 307);
		panel_5.add(scrollPane_2_1);

		table_3 = new JTable();
		scrollPane_2_1.setViewportView(table_3);
	}

	public void TrangChuMousePressed(MouseEvent evt) {
		BanHang.menuTrangChu.setBackground(DefaultColor);
		BanHang.menuDonHang.setBackground(DefaultColor);
		BanHang.menuDsKH.setBackground(DefaultColor);
		BanHang.menuBaoTri.setBackground(DefaultColor);
		BanHang.menuLSDonHang.setBackground(DefaultColor);
		BanHang.menuThongKe.setBackground(ClickedColor);
		BanHang.MainContent.removeAll();
		BanHang_TrangChu trangchu = new BanHang_TrangChu();
		BanHang.MainContent.add(trangchu).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void TrangChuMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		BanHang.MainContent.removeAll();
		BanHang_TrangChu trangchu = new BanHang_TrangChu();
		BanHang.MainContent.add(trangchu).setVisible(true);
		BanHang.MainContent.revalidate();
		BanHang.MainContent.repaint();
	}

	public void initTableSanPham(ArrayList<SanPhamDTO> listSP, ArrayList<PhieuNhapHangDTO> listPN,
			ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
		model = new DefaultTableModel();
		model.addColumn("Mã Sản Phẩm");
		model.addColumn("Tên Sản Phẩm");
		model.addColumn("Ngày Nhập");
		model.addColumn("Số Lượng");
		model.addColumn("Giá");
		for (ChiTietPhieuNhapDTO ctpnDTO : listCTPN) {
			model.addRow(new Object[] { ctpnDTO.getMaSP(), spBUS.PutOnTenSP(ctpnDTO.getMaSP()),
					pnBUS.PutOnNgayNhap(ctpnDTO.getMaPNH()), ctpnDTO.getSoLuong(), ctpnDTO.getDonGiaNhap() });

		}
		this.table.setModel(model);

		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
	}

	public void initTableNguoiDung(ArrayList<UserDTO> listUS) {
		model1 = new DefaultTableModel();
		model1.addColumn("Mã Khách Hàng");
		model1.addColumn("Họ Và Tên");
		model1.addColumn("Giới Tính");
		model1.addColumn("Ngày Sinh");
		model1.addColumn("Số Điện Thoại");
		model1.addColumn("Địa Chỉ");
		model1.addColumn("Tổng Hóa Đơn");
		for (UserDTO usDTO : listUS) {
			model1.addRow(new Object[] { usDTO.getMaUser(), usDTO.getHovaTen(), usDTO.getGioiTinh(),
					usDTO.getNgaySinh(), usDTO.getSDT(), usDTO.getDiaChi(), hdBUS.CountBuyProduct(usDTO.getMaUser()) });
		}
		this.table_1.setModel(model1);

		// Cho phép table sắp xếp
		table_1.setAutoCreateRowSorter(true);
	}

	public void initTableHoaDon(ArrayList<HoaDonDTO> list, ArrayList<NhanVienDTO> listNV, ArrayList<UserDTO> listUs,
			ArrayList<ChiTietHoaDonDTO> listCTHD, ArrayList<SanPhamDTO> listSP) {
		// Tạo DefaultTableModel mớia
		model3 = new DefaultTableModel();
		model3.addColumn("Mã Hóa Đơn");
		model3.addColumn("Mã Khách Hàng");
		model3.addColumn("Mã Nhân Viên");
		model3.addColumn("Ngày Lập");
		model3.addColumn("Tổng Tiền");
		model3.addColumn("Trạng Thái");
		model3.addColumn("Thanh Toán");
		// Đổ dữ liệu vào DefaultTableModel
		for (HoaDonDTO hd : list) {
			if (hd.getEnable() == 1) {
				if (hd.getThanhToan() == 1) {
					model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(), hd.getNgayLap(),
							hd.getTongTien(), "Xác Nhận", "Đã Thanh Toán" });
				} else {
					model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(), hd.getNgayLap(),
							hd.getTongTien(), "Xác Nhận", "Chưa Thanh Toán" });
				}
			} else {
				if (hd.getEnable() == 0) {
					if (hd.getThanhToan() == 1) {
						model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
								hd.getNgayLap(), hd.getTongTien(), "Chờ Xác Nhận", "Đã Thanh Toán" });
					} else {
						model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
								hd.getNgayLap(), hd.getTongTien(), "Chờ Xác Nhận", "Chưa Thanh Toán" });
					}

				} else {
					if (hd.getThanhToan() == 1) {
						model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
								hd.getNgayLap(), hd.getTongTien(), "Hủy", "Đã Thanh Toán" });
					} else {
						model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
								hd.getNgayLap(), hd.getTongTien(), "Hủy", "Chưa Thanh Toán" });
					}
				}
			}
		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table_2.setModel(model3);

		// Cho phép table sắp xếp
		table_2.setAutoCreateRowSorter(true);

	}

	public void initCTHD(ArrayList<ChiTietHoaDonDTO> listCTHD, ArrayList<SanPhamDTO> listSP) {
		model4 = new DefaultTableModel();
		model4.addColumn("Mã Sản Phẩm");
		model4.addColumn("Mã Hóa Đơn");
		model4.addColumn("Số Lượng");
		model4.addColumn("Giá");
		model4.addColumn("Thời Gian Bảo Hành");
		model4.addColumn("Ghi Chú");

		// Đổ dữ liệu vào DefaultTableModel
		for (ChiTietHoaDonDTO cthd : listCTHD) {
			model4.addRow(new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(), cthd.getSoLuong(), cthd.getGia(),
					cthd.getThoiGianBaoHanh(), cthd.getGhiChu() });
		}

		// Sử dụng DefaultTableModel để tạo JTable
		table_3.setModel(model4);

		// Cho phép table sắp xếp
		table_3.setAutoCreateRowSorter(true);
	}

	private void checkDateRangeAndDisplay(ArrayList<SanPhamDTO> listSP, ArrayList<PhieuNhapHangDTO> listPN,
			ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(dateFromSP.getDate());
		String dateString1 = dateFormat.format(dateFromSP_1.getDate());
		String startDateStr = dateString;
		String endDateStr = dateString1;
		System.out.println(dateString);
		System.out.println(dateString1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Kiểm tra xem các chuỗi nhập vào có đúng định dạng không
		if (!isValidDateFormat(startDateStr) || !isValidDateFormat(endDateStr)) {
			JOptionPane.showMessageDialog(this,
					"Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng yyyy-MM-dd.");
			return;
		}

		try {
			Date startDate = sdf.parse(startDateStr);
			Date endDate = sdf.parse(endDateStr);

			// Xóa dữ liệu cũ trong bảng
			model.setRowCount(0);
			for (ChiTietPhieuNhapDTO ctpnDTO : listCTPN) {
				Date importDate = sdf.parse(pnBUS.PutOnNgayNhap(ctpnDTO.getMaPNH()));
				if (importDate.compareTo(startDate) >= 0 && importDate.compareTo(endDate) <= 0) {
					model.addRow(new Object[] { ctpnDTO.getMaSP(), spBUS.PutOnTenSP(ctpnDTO.getMaSP()),
							pnBUS.PutOnNgayNhap(ctpnDTO.getMaPNH()), ctpnDTO.getSoLuong(), ctpnDTO.getDonGiaNhap() });
				}

			}

		} catch (ParseException ex) {
			ex.printStackTrace();
		}

	}

	private void checkDateRangeAndDisplay1(ArrayList<HoaDonDTO> list, ArrayList<NhanVienDTO> listNV,
			ArrayList<UserDTO> listUs, ArrayList<ChiTietHoaDonDTO> listCTHD, ArrayList<SanPhamDTO> listSP) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(dateFromSP_2.getDate());
		String dateString1 = dateFormat.format(dateFromSP_3.getDate());
		String startDateStr = dateString;
		String endDateStr = dateString1;
		System.out.println(dateString);
		System.out.println(dateString1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Kiểm tra xem các chuỗi nhập vào có đúng định dạng không
		if (!isValidDateFormat(startDateStr) || !isValidDateFormat(endDateStr)) {
			JOptionPane.showMessageDialog(this,
					"Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng yyyy-MM-dd.");
			return;
		}

		try {
			Date startDate = sdf.parse(startDateStr);
			Date endDate = sdf.parse(endDateStr);

			// Xóa dữ liệu cũ trong bảng
			model3.setRowCount(0);
			model4.setRowCount(0);

			for (HoaDonDTO hd : list) {
				Date importDate = sdf.parse(hd.getNgayLap());
				if (importDate.compareTo(startDate) >= 0 && importDate.compareTo(endDate) <= 0) {
					if (hd.getEnable() == 1) {
						if (hd.getThanhToan() == 1) {
							model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
									hd.getNgayLap(), hd.getTongTien(), "Xác Nhận", "Đã Thanh Toán" });
						} else {
							model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
									hd.getNgayLap(), hd.getTongTien(), "Xác Nhận", "Chưa Thanh Toán" });
						}
					} else {
						if (hd.getEnable() == 0) {
							if (hd.getThanhToan() == 1) {
								model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
										hd.getNgayLap(), hd.getTongTien(), "Chờ Xác Nhận", "Đã Thanh Toán" });
							} else {
								model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
										hd.getNgayLap(), hd.getTongTien(), "Chờ Xác Nhận", "Chưa Thanh Toán" });
							}

						} else {
							if (hd.getThanhToan() == 1) {
								model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
										hd.getNgayLap(), hd.getTongTien(), "Hủy", "Đã Thanh Toán" });
							} else {
								model3.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
										hd.getNgayLap(), hd.getTongTien(), "Hủy", "Chưa Thanh Toán" });
							}
						}
					}
				}

			}

			for (ChiTietHoaDonDTO cthd : listCTHD) {
				Date importDate = sdf.parse(hdBUS.PutOnNgayLap(cthd.getMaHoaDon()));
				if (importDate.compareTo(startDate) >= 0 && importDate.compareTo(endDate) <= 0) {
					model4.addRow(new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(), cthd.getSoLuong(),
							cthd.getGia(), cthd.getThoiGianBaoHanh(), cthd.getGhiChu() });

				}
			}

		} catch (ParseException ex) {
			ex.printStackTrace();
		}

	}

	private boolean isValidDateFormat(String dateStr) {
		// Sử dụng regular expression để kiểm tra định dạng yyyy-MM-dd
		return dateStr.matches("\\d{4}-\\d{2}-\\d{2}");
	}

	public void reload() {
		textFieldTimKiemSanPham.setText("");
		textFieldTimKiemHoaDon.setText("");
		textFieldTimKiemNguoiDung.setText("");
		dateFromSP.setDate(null);
		dateFromSP_1.setDate(null);
		dateFromSP_2.setDate(null);
		dateFromSP_3.setDate(null);
		SanPhamBUS spBUSupdate = new SanPhamBUS();
		PhieuNhapHangBUS pnBUSupdate = new PhieuNhapHangBUS();
		ChiTietPhieuNhapBUS ctpnBUSupdate = new ChiTietPhieuNhapBUS();
		HoaDonBUS hdBUSupdate = new HoaDonBUS();
		UserBUS usBUSupdate = new UserBUS();
		ChiTietHoaDonBUS cthdBUSupdate = new ChiTietHoaDonBUS();
		NhanVienBUS nvBUSupdate = new NhanVienBUS();
		if (spBUSupdate.getList() == null) {
			spBUSupdate.listSP();
		}
		if (pnBUSupdate.getList() == null) {
			pnBUSupdate.list();
		}
		if (ctpnBUSupdate.getList() == null) {
			ctpnBUSupdate.list();
		}
		if (hdBUSupdate.getList() == null) {
			hdBUSupdate.list();
		}
		if (usBUSupdate.getList() == null) {
			usBUSupdate.listUs();
		}
		if (cthdBUSupdate.getList() == null)
			cthdBUSupdate.list();
		if (nvBUSupdate.getList() == null) {
			nvBUSupdate.listNV();
		}
		initTableSanPham(spBUSupdate.getList(), pnBUSupdate.getList(), ctpnBUSupdate.getList());
		initTableNguoiDung(usBUSupdate.getList());
		initTableHoaDon(hdBUSupdate.getList(), nvBUSupdate.getList(), usBUSupdate.getList(), cthdBUSupdate.getList(),
				spBUSupdate.getList());
		initCTHD(cthdBUSupdate.getList(), spBUSupdate.getList());
	}

	public void TongKet(ArrayList<ChiTietPhieuNhapDTO> list, ArrayList<UserDTO> listUS, ArrayList<HoaDonDTO> listHD , ArrayList<ChiTietHoaDonDTO> listCTHD) {
		int countSoLuongSP = 0;
		for (ChiTietPhieuNhapDTO ctpnDTO : list) {
			countSoLuongSP += ctpnDTO.getSoLuong();
		}
		int countNguoiDung = 0;
		for (UserDTO usDTO : listUS) {
			countNguoiDung++;
		}
		int countTongHoaDon = 0;
		for (HoaDonDTO hdDTO : listHD) {
			countTongHoaDon++;
		}
		int countTongTien = 0;
		for (ChiTietHoaDonDTO cthdDTO : listCTHD) {
			countTongTien += (cthdDTO.getGia() * cthdDTO.getSoLuong()) ;
		}
		lblNewLabelSanPhamTrongKho.setText(String.valueOf(countSoLuongSP));
		lblNewLabelNguoiDung.setText(String.valueOf(countNguoiDung));
		lblNewLabelTongHoaDon.setText(String.valueOf(countTongHoaDon));
		lblNewLabelTongTien.setText(String.valueOf(countTongTien) + " VNĐ");
	}

	private void xuatExcel(JTable table) {
		try {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.showSaveDialog(this);
			File saveFile = jFileChooser.getSelectedFile();

			if (saveFile != null) {
				saveFile = new File(saveFile.toString() + ".xlsx");
				Workbook wb = new XSSFWorkbook();
				Sheet sheet = wb.createSheet("ThongKe");

				// Xuất dữ liệu từ table_1
				exportTableToSheet(table, sheet, 0);

				FileOutputStream out = new FileOutputStream(saveFile);
				wb.write(out);
				out.close();
				wb.close();

				openFile(saveFile.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void exportTableToSheet(JTable table, Sheet sheet, int startRow) {
		Row rowCol = sheet.createRow(startRow);
		for (int i = 0; i < table.getColumnCount(); i++) {
			Cell cell = rowCol.createCell(i);
			cell.setCellValue(table.getColumnName(i));
		}

		for (int j = 0; j < table.getRowCount(); j++) {
			Row row = sheet.createRow(startRow + j + 1);
			for (int k = 0; k < table.getColumnCount(); k++) {
				Cell cell = row.createCell(k);
				Object value = table.getValueAt(j, k);
				if (value != null) {
					cell.setCellValue(value.toString());
				}
			}
		}
	}

	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	private void xuatHoaDon() {
	    try {
	        JFileChooser jFileChooser = new JFileChooser();
	        jFileChooser.showSaveDialog(this);
	        File saveFile = jFileChooser.getSelectedFile();
	        
	        if (saveFile != null) {
	            saveFile = new File(saveFile.toString() + ".xlsx");
	            Workbook wb = new XSSFWorkbook();
	            Sheet sheet = wb.createSheet("LsDonHang");

	            // Xuất dữ liệu từ table_2
	            exportTableToSheet(table_2, sheet, 0);

	            // Xuất dữ liệu từ table_2
	            exportTableToSheet(table_3, sheet, table_2.getRowCount() + 2);

	            FileOutputStream out = new FileOutputStream(saveFile);
	            wb.write(out);
	            out.close();
	            wb.close();

	            openFile(saveFile.toString());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
