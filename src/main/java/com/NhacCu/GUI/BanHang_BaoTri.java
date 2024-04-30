package com.NhacCu.GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.NhacCu.BUS.ChiTietPhieuBaoTriBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.PhieuBaoTriBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.DTO.ChiTietPhieuBaoTriDTO;
import com.NhacCu.DTO.PhieuBaoTriDTO;
import com.NhacCu.DTO.SanPhamDTO;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BanHang_BaoTri extends JPanel {
	Color DefaultColor = new Color(240, 240, 240);
	Color ClickedColor = new Color(128, 255, 0);
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldMaBT;
	private JTextField textFieldMaNV;
	private JTextField textFieldMaKH;
	private JTextField textFieldMaHD;
	private JTextField textFieldNgayLap;
	private JTextArea textAreaMoTa;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private ChiTietPhieuBaoTriBUS ctpbtBUS = new ChiTietPhieuBaoTriBUS();
	private PhieuBaoTriBUS pbtBUS = new PhieuBaoTriBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private JComboBox comboBoxTrangThai;
	private JComboBox comboBoxMaSP;
	private JComboBox comboBoxTimKiem;

	/**
	 * Create the panel.
	 */
	public BanHang_BaoTri() {
		initComponents();
		if (spBUS.getList() == null) {
			spBUS.listSP();
		}
		if (ctpbtBUS.getList() == null) {
			ctpbtBUS.list();
		}
		if (pbtBUS.getList() == null) {
			pbtBUS.list();
		}
		initTable(pbtBUS.getList(), spBUS.getList(), ctpbtBUS.getList());
		initCTPBT(spBUS.getList(), ctpbtBUS.getList());
		setcomboBoxMaSP(spBUS.getList());
		setcomboBoxTrangThai();
		setcomboBoxTiemKiem();
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
		lblNewLabel.setIcon(new ImageIcon(BanHang_DonHang.class.getResource("/com/NhacCu/item/LOGO.png")));
		lblNewLabel.setBounds(0, 0, 316, 115);
		panel.add(lblNewLabel);

		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(false);
		toolBar.setBorder(
				new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		toolBar.setBounds(336, 10, 274, 115);
		add(toolBar);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnNewButton.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNewButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnNewButton.setFocusable(false);
		btnNewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btnNewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		toolBar.add(btnNewButton);

		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXa.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXa.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnXa.setFocusable(false);
		toolBar.add(btnXa);

		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSa.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSa.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnSa.setFocusable(false);
		toolBar.add(btnSa);

		JButton btnXa_1_1 = new JButton("Đặt lại");
		btnXa_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnXa_1_1.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnXa_1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXa_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXa_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnXa_1_1.setFocusable(false);
		toolBar.add(btnXa_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_1.setBounds(628, 10, 698, 115);
		add(panel_1);

		comboBoxTimKiem = new JComboBox();
		comboBoxTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		comboBoxTimKiem.setModel(
				new DefaultComboBoxModel(new String[] { "Tất cả", "Hoàn thành", "Chưa hoàn thành", "Chờ xác nhận" }));
		comboBoxTimKiem.setBounds(30, 45, 158, 41);
		panel_1.add(comboBoxTimKiem);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(232, 45, 243, 41);
		panel_1.add(textField);
		// Thêm bộ lắng nghe sự kiện vào textfield tìm kiếm
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchAndUpdateTable();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchAndUpdateTable();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				searchAndUpdateTable();
			}

		});

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lammoi();
			}
		});
		btnLamMoi.setIcon(new ImageIcon(BanHang_BaoTri.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLamMoi.setBounds(527, 41, 139, 41);
		panel_1.add(btnLamMoi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 706, 314);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "M\u00E3 Phi\u1EBFu B\u1EA3o Tr\u00EC", "M\u00E3 Nh\u00E2n Vi\u00EAn", "M\u00E3 User",
						"M\u00E3 H\u00F3a \u0110\u01A1n", "Ng\u00E0y L\u1EADp", "Tr\u1EA1ng Th\u00E1i",
						"Chuy\u1EC3n Phi\u1EBFu" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 471, 706, 210);
		add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Phi\u1EBFu B\u1EA3o Tr\u00EC", "Ghi Ch\u00FA" }));
		scrollPane_1.setViewportView(table_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(726, 147, 600, 314);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã phiếu bảo trì");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 20, 122, 24);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(12, 73, 108, 24);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Mã khách hàng");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(11, 123, 122, 24);
		panel_2.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(11, 172, 144, 34);
		panel_2.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày lập");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(10, 225, 144, 34);
		panel_2.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Trạng thái");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 279, 122, 24);
		panel_2.add(lblNewLabel_1_1_1_1_1_1);

		textFieldMaBT = new JTextField();
		textFieldMaBT.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldMaBT.setBounds(164, 17, 239, 32);
		panel_2.add(textFieldMaBT);
		textFieldMaBT.setColumns(10);

		textFieldMaNV = new JTextField();
		textFieldMaNV.setColumns(10);
		textFieldMaNV.setBounds(164, 68, 239, 34);
		panel_2.add(textFieldMaNV);

		textFieldMaKH = new JTextField();
		textFieldMaKH.setColumns(10);
		textFieldMaKH.setBounds(165, 117, 239, 34);
		panel_2.add(textFieldMaKH);

		textFieldMaHD = new JTextField();
		textFieldMaHD.setColumns(10);
		textFieldMaHD.setBounds(165, 167, 239, 32);
		panel_2.add(textFieldMaHD);

		textFieldNgayLap = new JTextField();
		textFieldNgayLap.setColumns(10);
		textFieldNgayLap.setBounds(164, 220, 239, 33);
		panel_2.add(textFieldNgayLap);

		comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxTrangThai
				.setModel(new DefaultComboBoxModel(new String[] { "Chờ xác nhận", "Hoàn thành", "Chưa hoàn thành" }));
		comboBoxTrangThai.setBounds(164, 269, 239, 35);
		panel_2.add(comboBoxTrangThai);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(726, 471, 600, 210);
		add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblNewLabel_1_2 = new JLabel("Mã sản phẩm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(14, 29, 122, 24);
		panel_2_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ghi Chú");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(14, 68, 122, 24);
		panel_2_1.add(lblNewLabel_1_2_1_1);

		comboBoxMaSP = new JComboBox();
		comboBoxMaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxMaSP.setModel(new DefaultComboBoxModel(new String[] { "SP1  Đàn Piano Apollo", "SP2  Đàn Violin" }));
		comboBoxMaSP.setBounds(142, 26, 294, 24);
		panel_2_1.add(comboBoxMaSP);

		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(143, 69, 294, 112);
		panel_2_1.add(scrollPane1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// dọc
		scrollPane1.setAutoscrolls(true);
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

	public void setcomboBoxTrangThai() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Xác Nhận");
		model.addElement("Chờ Xác Nhận");
		model.addElement("Hủy");
		comboBoxTrangThai.setModel(model);
	}

	public void setcomboBoxTiemKiem() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Tất cả");
		model.addElement("Mã phiếu bảo trì");
		model.addElement("Mã hóa đơn");
		model.addElement("Mã nhân viên");
		model.addElement("Mã khách hàng");
		model.addElement("Ngày lập");
		model.addElement("Xác Nhận");
		model.addElement("Chờ Xác Nhận");
		model.addElement("Hủy");
		comboBoxTimKiem.setModel(model);
	}

	public void setcomboBoxMaSP(ArrayList<SanPhamDTO> list) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (SanPhamDTO sp : list) {
			model.addElement(sp.getMaSanPham() + "   " + sp.getTenSanPham());
		}
		comboBoxMaSP.setModel(model);
	}

	public void initTable(ArrayList<PhieuBaoTriDTO> list, ArrayList<SanPhamDTO> listSP,
			ArrayList<ChiTietPhieuBaoTriDTO> listCTPBT) {
		// Tạo DefaultTableModel mớia
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã BT");
		model.addColumn("Mã NV");
		model.addColumn("Mã KH");
		model.addColumn("Mã HĐ");
		model.addColumn("Ngày Lập");
		model.addColumn("Trạng Thái");

		// Đổ dữ liệu vào DefaultTableModel
		for (PhieuBaoTriDTO pbt : list) {
			if (pbt.getEnable() == 1) {
				model.addRow(new Object[] { pbt.getMaBT(), pbt.getMaNV(), pbt.getMaUser(), pbt.getMaHD(),
						pbt.getNgayLap(), "Xác Nhận" });
			} else {
				if (pbt.getEnable() == 0) {
					model.addRow(new Object[] { pbt.getMaBT(), pbt.getMaNV(), pbt.getMaUser(), pbt.getMaHD(),
							pbt.getNgayLap(), "Chờ Xác Nhận" });
				} else {
					model.addRow(new Object[] { pbt.getMaBT(), pbt.getMaNV(), pbt.getMaUser(), pbt.getMaHD(),
							pbt.getNgayLap(), "Hủy" });
				}
			}
		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table.setModel(model);

		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaBT.setText(String.valueOf(table.getValueAt(index, 0)));
				textFieldMaBT.setEditable(false);
				textFieldMaBT.setEnabled(false);
				DefaultTableModel model1 = new DefaultTableModel();
				model1.addColumn("Mã Bảo Trì");
				model1.addColumn("Mã Sản Phẩm");
				model1.addColumn("Ghi Chú");

				// Đổ dữ liệu vào DefaultTableModel
				for (ChiTietPhieuBaoTriDTO ctpbt : listCTPBT) {
					if (ctpbt.getMaBT().equals(String.valueOf(table.getValueAt(index, 0)))) {
						model1.addRow(new Object[] { ctpbt.getMaBT(), ctpbt.getMaSP(), ctpbt.getGhiChu() });
					}
				}

				// Sử dụng DefaultTableModel để tạo JTable
				table_1.setModel(model1);

				// Cho phép table sắp xếp
				table_1.setAutoCreateRowSorter(true);
				table_1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						int index = table_1.getSelectedRow();
						String selectedMaSP = String.valueOf(table_1.getValueAt(index, 1));
						int count = 0;
						for (SanPhamDTO sp : listSP) {
							if (selectedMaSP.equals(sp.getMaSanPham())) {
								comboBoxMaSP.setSelectedIndex(count);
								break;
							}
							count++;
						}
						comboBoxMaSP.setEnabled(false);
						textAreaMoTa.setText(String.valueOf(table_1.getValueAt(index, 2)));
					}
				});
				textFieldMaNV.setText(String.valueOf(table.getValueAt(index, 2)));
				textFieldMaNV.setEditable(false);
				textFieldMaNV.setEnabled(false);
				textFieldMaKH.setText(String.valueOf(table.getValueAt(index, 3)));
				textFieldMaKH.setEditable(false);
				textFieldMaKH.setEnabled(false);
				textFieldMaHD.setText(String.valueOf(table.getValueAt(index, 4)));
				textFieldMaHD.setEditable(false);
				textFieldMaHD.setEnabled(false);
				textFieldNgayLap.setText(String.valueOf(table.getValueAt(index, 4)));
				String selectedTrangThai = String.valueOf(table.getValueAt(index, 5));
				comboBoxTrangThai.setSelectedItem(selectedTrangThai);

			}
		});
	}

	public void initCTPBT(ArrayList<SanPhamDTO> listSP, ArrayList<ChiTietPhieuBaoTriDTO> listCTPBT) {
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Mã Bảo Trì");
		model1.addColumn("Mã Sản Phẩm");
		model1.addColumn("Ghi Chú");

		// Đổ dữ liệu vào DefaultTableModel
		for (ChiTietPhieuBaoTriDTO ctpbt : listCTPBT) {

			model1.addRow(new Object[] { ctpbt.getMaBT(), ctpbt.getMaSP(), ctpbt.getGhiChu() });

		}

		// Sử dụng DefaultTableModel để tạo JTable
		table_1.setModel(model1);

		// Cho phép table sắp xếp
		table_1.setAutoCreateRowSorter(true);
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table_1.getSelectedRow();
				String selectedMaSP = String.valueOf(table_1.getValueAt(index, 1));
				int count = 0;
				for (SanPhamDTO sp : listSP) {
					if (selectedMaSP.equals(sp.getMaSanPham())) {
						comboBoxMaSP.setSelectedIndex(count);
						break;
					}
					count++;
				}
				comboBoxMaSP.setEnabled(false);
				textAreaMoTa.setText(String.valueOf(table_1.getValueAt(index, 4)));

			}
		});
	}

	public void reload() {
		textFieldMaBT.setText("");
		textFieldMaBT.setEditable(true);
		textFieldMaBT.setEnabled(true);
		textFieldMaHD.setText("");
		textFieldMaHD.setEditable(true);
		textFieldMaHD.setEnabled(true);
		textFieldMaKH.setText("");
		textFieldMaKH.setEditable(true);
		textFieldMaKH.setEnabled(true);
		textFieldMaNV.setText("");
		textFieldMaNV.setEditable(true);
		textFieldMaNV.setEnabled(true);
		textAreaMoTa.setText("");
		textFieldNgayLap.setText("");
		comboBoxTrangThai.setSelectedIndex(0);
		comboBoxMaSP.setSelectedIndex(0);
		NhanVienBUS nvBUStest = new NhanVienBUS();
		SanPhamBUS spBUStest = new SanPhamBUS();
		ChiTietPhieuBaoTriBUS ctpbtBUStest = new ChiTietPhieuBaoTriBUS();
		PhieuBaoTriBUS pbtBUStest = new PhieuBaoTriBUS();
		if (nvBUStest.getList() == null)
			nvBUStest.listNV();
		if (spBUStest.getList() == null)
			spBUStest.listSP();
		if (pbtBUStest.getList() == null)
			pbtBUStest.list();
		if (ctpbtBUStest.getList() == null)
			ctpbtBUStest.list();
		setcomboBoxMaSP(spBUStest.getList());
		initTable(pbtBUStest.getList(), spBUStest.getList(), ctpbtBUStest.getList());
		initCTPBT(spBUStest.getList(), ctpbtBUStest.getList());
		textField.setText("");
		comboBoxTimKiem.setSelectedIndex(0);
	}

	public void lammoi() {
		textField.setText("");
		NhanVienBUS nvBUStest = new NhanVienBUS();
		SanPhamBUS spBUStest = new SanPhamBUS();
		ChiTietPhieuBaoTriBUS ctpbtBUStest = new ChiTietPhieuBaoTriBUS();
		PhieuBaoTriBUS pbtBUStest = new PhieuBaoTriBUS();
		if (nvBUStest.getList() == null)
			nvBUStest.listNV();
		if (spBUStest.getList() == null)
			spBUStest.listSP();
		if (pbtBUStest.getList() == null)
			pbtBUStest.list();
		if (ctpbtBUStest.getList() == null)
			ctpbtBUStest.list();
		setcomboBoxMaSP(spBUStest.getList());
		comboBoxTimKiem.setSelectedIndex(0);
		initTable(pbtBUStest.getList(), spBUStest.getList(), ctpbtBUStest.getList());
		initCTPBT(spBUStest.getList(), ctpbtBUStest.getList());
	}

	private boolean KiemTraTrong() {
		if (textFieldMaBT.getText() == null || textFieldMaBT.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Phiếu Bảo Trì không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldMaBT.requestFocus();
			return false;
		}
		if (textFieldMaHD.getText() == null || textFieldMaHD.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Hóa Đơn không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldMaHD.requestFocus();
			return false;
		}
		if (textFieldMaKH.getText() == null || textFieldMaKH.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Khách Hàng không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldMaKH.requestFocus();
			return false;
		}
		if (textFieldMaNV.getText() == null || textFieldMaNV.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Nhân Viên không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldMaNV.requestFocus();
			return false;
		}
		if (textFieldNgayLap.getText() == null || textFieldNgayLap.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ngày Lập không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldNgayLap.requestFocus();
			return false;
		}
		return true;
	}

	public void them() {
		if (KiemTraTrong()) {
			String sp = (String) comboBoxMaSP.getSelectedItem();
			String[] maSP = sp.split(" ");
			if (pbtBUS.checkMaBT(textFieldMaBT.getText())) {

				if (pbtBUS.checkMaBTvaMaNVvaMaKHvaMaHDvaNgayNhap(textFieldMaBT.getText(), textFieldMaNV.getText(),
						textFieldMaKH.getText(), textFieldMaHD.getText(), textFieldNgayLap.getText())) {

					if (!ctpbtBUS.checkMaBTvaMaSP(textFieldMaBT.getText(), maSP[0])) {

						try {
							ChiTietPhieuBaoTriDTO ctpbtDTO = new ChiTietPhieuBaoTriDTO(textFieldMaBT.getText(), maSP[0],
									textAreaMoTa.getText());
							ctpbtBUS.add(ctpbtDTO);

							// Thông báo thành công và cập nhật bảng
							JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo",
									JOptionPane.DEFAULT_OPTION);

						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
						}
						reload();
					} else {

						JOptionPane.showMessageDialog(null, "Chi Tiết Phiếu Bảo Trì bị trùng", "Thông báo",
								JOptionPane.DEFAULT_OPTION);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Phiếu Bảo Trì bị trùng", "Thông báo",
							JOptionPane.DEFAULT_OPTION);
				}
			} else {

				try {

					PhieuBaoTriDTO pbtDTO = new PhieuBaoTriDTO(textFieldMaBT.getText(), textFieldMaNV.getText(),
							textFieldMaKH.getText(), textFieldMaHD.getText(), textFieldNgayLap.getText(), 1);
					ChiTietPhieuBaoTriDTO ctpbtDTO = new ChiTietPhieuBaoTriDTO(textFieldMaBT.getText(), maSP[0],
							textAreaMoTa.getText());
					pbtBUS.add(pbtDTO);
					ctpbtBUS.add(ctpbtDTO);

					// Thông báo thành công và cập nhật bảng
					JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				reload();

			}
		}
	}

	public void sua() {
		if (KiemTraTrong()) {
			String sp = (String) comboBoxMaSP.getSelectedItem();
			String[] maSP = sp.split(" ");
			try {
				if (comboBoxTrangThai.getSelectedItem().equals("Xác Nhận")) {
					PhieuBaoTriDTO pbtDTO = new PhieuBaoTriDTO(textFieldMaBT.getText(), textFieldMaNV.getText(),
							textFieldMaKH.getText(), textFieldMaHD.getText(), textFieldNgayLap.getText(), 1);
					pbtBUS.update(pbtDTO);

				} else {
					if (comboBoxTrangThai.getSelectedItem().equals("Chờ Xác Nhận")) {
						PhieuBaoTriDTO pbtDTO = new PhieuBaoTriDTO(textFieldMaBT.getText(), textFieldMaNV.getText(),
								textFieldMaKH.getText(), textFieldMaHD.getText(), textFieldNgayLap.getText(), 0);
						pbtBUS.update(pbtDTO);

					} else {
						PhieuBaoTriDTO pbtDTO = new PhieuBaoTriDTO(textFieldMaBT.getText(), textFieldMaNV.getText(),
								textFieldMaKH.getText(), textFieldMaHD.getText(), textFieldNgayLap.getText(), 2);
						pbtBUS.update(pbtDTO);
					}
				}
				ChiTietPhieuBaoTriDTO ctpbtDTO = new ChiTietPhieuBaoTriDTO(textFieldMaBT.getText(), maSP[0],
						textAreaMoTa.getText());
				ctpbtBUS.update(ctpbtDTO);

				// Thông báo thành công và cập nhật bảng
				JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, ex, "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
			reload();
		} else {

			JOptionPane.showMessageDialog(null, "Chi Tiết Phiếu Nhập bị trùng", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
		}

	}

	private void xoa() {
		if (KiemTraTrong()) {
			pbtBUS.delete(textFieldMaBT.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			reload();
		}
	}

	private void searchAndUpdateTable() {
		String selectedOption = comboBoxTimKiem.getSelectedItem().toString();
		String keyword = textField.getText().trim();

		// Thực hiện tìm kiếm
		ArrayList<PhieuBaoTriDTO> searchResult = pbtBUS.search(selectedOption, keyword);
		ArrayList<ChiTietPhieuBaoTriDTO> ctsearchResult = ctpbtBUS.search(selectedOption, keyword);
		// Cập nhật bảng hiển thị
		initTable(searchResult, spBUS.getList(), ctpbtBUS.getList());
		initCTPBT(spBUS.getList(), ctsearchResult);
	}
	public void printTable(final JTable table) {
		final JTable finalTable = table;
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		printerJob.setJobName("Print Table");

		if (nvBUS.getList() == null)
			nvBUS.listNV();

		printerJob.setPrintable(new Printable() {
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
				if (pageIndex > 0) {
					return Printable.NO_SUCH_PAGE;
				}

				// Thêm tiêu đề vào đầu trang
				Graphics2D g2d = (Graphics2D) graphics;
				g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
				g2d.setFont(new Font("Arial", Font.BOLD, 14));
				String title = "Thống Kê Phiếu Nhập";
				int titleWidth = g2d.getFontMetrics().stringWidth(title);
				int centerX = (int) (pageFormat.getImageableWidth() / 2 - titleWidth / 2);
				g2d.drawString(title, centerX, 50);

				// Thêm thời gian cụ thể vào trang
				g2d.setFont(new Font("Arial", Font.PLAIN, 10));
				g2d.drawString("Ngày: " + java.time.LocalDate.now(), 100, 70);

				final String tendangnhapnv = BanHang.MenuTenDangNhap.getText();
				String chuoi = tendangnhapnv;
				String[] mangChuoi = chuoi.split(":"); // Tách chuỗi theo dấu ":"
				if (mangChuoi.length > 1) {
					String tuCanTim = mangChuoi[1].trim(); // Lấy phần sau dấu ":" và loại bỏ các khoảng trắng ở đầu và
															// cuối

					g2d.drawString("Mã Nhân Viên: " + nvBUS.PutOnMaNVEqualTenDangNhap(tuCanTim), 100, 90);
					g2d.drawString("Tên Nhân Viên: " + nvBUS.PutOnTenNhanVienEqualTenDangNhap(tuCanTim), 100, 110);
				} else {
					System.out.println("Không tìm thấy từ cần lấy.");
				}

				// Vẽ tên cột
				int y = 140;
				g2d.setFont(new Font("Arial", Font.BOLD, 10));
				TableColumnModel columnModel = table.getColumnModel();
				int x = 93; // starting x-coordinate for the first column
				for (int i = 0; i < columnModel.getColumnCount(); i++) {
					TableColumn column = columnModel.getColumn(i);
					String columnName = (String) column.getHeaderValue();
					int columnWidth = g2d.getFontMetrics().stringWidth(columnName); // width of the column header text
					g2d.drawString(columnName, x + (column.getWidth() - columnWidth) / 2, y); // center-align column
																								// header
					x += column.getWidth() + 10; // move to the next column position with additional padding of 10
				}

				// Vẽ dữ liệu của bảng
				g2d.setFont(new Font("Arial", Font.PLAIN, 10)); // Set the font size for the table data
				int rowHeight = table.getRowHeight();
				int tableHeight = table.getRowCount() * rowHeight;
				int maxRowCount = (int) ((pageFormat.getImageableHeight() - y) / rowHeight);
				int startRow = pageIndex * maxRowCount;
				int endRow = Math.min(startRow + maxRowCount, table.getRowCount());
				for (int row = startRow; row < endRow; row++) {
					x = 110; // reset x-coordinate for each row
					y += rowHeight; // move to the next row
					for (int col = 0; col < table.getColumnCount(); col++) {
						g2d.drawString(table.getValueAt(row, col).toString(), x, y);
						x += table.getColumnModel().getColumn(col).getWidth() + 10; // move to the next column position
																					// with additional padding of 10
					}
				}
				return Printable.PAGE_EXISTS;
			}
		});

		if (printerJob.printDialog()) {
			try {
				printerJob.print();
				JOptionPane.showMessageDialog(null, "In và Lưu Thành Công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			} catch (PrinterException ex) {
				ex.printStackTrace();
			}
		}
	}
}
