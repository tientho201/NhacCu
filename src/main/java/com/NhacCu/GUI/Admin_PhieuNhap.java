package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.NhacCu.BUS.ChiTietPhieuNhapBUS;
import com.NhacCu.BUS.NhaCungCapBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.PhieuNhapHangBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.DTO.*;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.IOException;

public class Admin_PhieuNhap extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaPNH;
	private JTextField textFieldNgayNhap;
	private JTextField textFieldTongTien;
	private JTextField textFieldGia;
	private JTextField textFieldSoLuong;
	private JTable table;
	private JTable table_1;
	private PhieuNhapHangBUS pnhBUS = new PhieuNhapHangBUS();
	private SanPhamBUS spBUS = new SanPhamBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
	private ChiTietPhieuNhapBUS ctpnBUS = new ChiTietPhieuNhapBUS();
	private JComboBox comboBoxMaNCC;
	private JComboBox comboBoxMaNV;
	private JComboBox comboBoxTrangThai;
	private JComboBox comboBoxMaSP;
	private JTextArea textAreaMoTa;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnReload;

	/**
	 * Create the panel.
	 */
	public Admin_PhieuNhap() {
		initComponents();
		if (nvBUS.getList() == null) {
			nvBUS.listNV();
		}
		if (spBUS.getList() == null)
			spBUS.listSP();
		if (pnhBUS.getList() == null) {
			pnhBUS.list();
		}
		if (nccBUS.getList() == null)
			nccBUS.listNCC();
		if (ctpnBUS.getList() == null)
			ctpnBUS.list();
		initTableNhapHang(pnhBUS.getList(), nvBUS.getList(), nccBUS.getList(), spBUS.getList(), ctpnBUS.getList());
		initCTPN(spBUS.getList(), ctpnBUS.getList());
		setcomboBoxMaNCC(nccBUS.getList());
		setcomboBoxMaSP(spBUS.getList());
		setcomboBoxMaNV(nvBUS.getList());
		setcomboBoxTrangThai();
	}

	public void initComponents() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Phiếu Nhập Kho Hàng");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(0, 10, 1117, 47);
		add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 68, 633, 281);
		add(panel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 613, 261);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "M\u00C3 Phi\u1EBFu Nh\u1EADp", "M\u00E3 Nh\u00E0 Cung C\u1EA5p",
						"M\u00E3 Nh\u00E2n Vi\u00EAn", "Ng\u00E0y Nh\u1EADp", "T\u1ED5ng Ti\u1EC1n",
						"Tr\u1EA1ng Th\u00E1i" }));
		scrollPane.setViewportView(table);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setLayout(null);
		panel_6.setBounds(10, 368, 633, 228);
		add(panel_6);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 613, 208);
		panel_6.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "M\u00E3 Phi\u1EBFu Nh\u1EADp", "M\u00E3 S\u1EA3n Ph\u1EA9m", "Gi\u00E1",
						"S\u1ED1 L\u01B0\u1EE3ng", "Ghi Ch\u00FA" }));
		scrollPane_1.setViewportView(table_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(null);
		panel_5.setBounds(673, 67, 425, 282);
		add(panel_5);

		JLabel lblNewLabel_2 = new JLabel("Mã PNH");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(72, 9, 76, 26);
		panel_5.add(lblNewLabel_2);

		textFieldMaPNH = new JTextField();
		textFieldMaPNH.setColumns(10);
		textFieldMaPNH.setBounds(220, 10, 172, 28);
		panel_5.add(textFieldMaPNH);

		JLabel lblNewLabel_2_1_1 = new JLabel("Mã NCC");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(72, 52, 76, 26);
		panel_5.add(lblNewLabel_2_1_1);

		comboBoxMaNCC = new JComboBox();
		comboBoxMaNCC.setBounds(220, 53, 172, 26);
		panel_5.add(comboBoxMaNCC);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Mã NV");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_1.setBounds(72, 97, 76, 26);
		panel_5.add(lblNewLabel_2_1_1_1);

		comboBoxMaNV = new JComboBox();
		comboBoxMaNV.setBounds(220, 98, 172, 26);
		panel_5.add(comboBoxMaNV);

		JLabel lblNewLabel_2_2 = new JLabel("Ngày Nhập");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(72, 147, 76, 26);
		panel_5.add(lblNewLabel_2_2);

		textFieldNgayNhap = new JTextField();
		textFieldNgayNhap.setColumns(10);
		textFieldNgayNhap.setBounds(220, 149, 172, 26);
		panel_5.add(textFieldNgayNhap);

		JLabel lblNewLabel_2_2_2 = new JLabel("Trạng Thái");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_2.setBounds(72, 245, 76, 26);
		panel_5.add(lblNewLabel_2_2_2);

		comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setBounds(220, 246, 172, 26);
		panel_5.add(comboBoxTrangThai);

		textFieldTongTien = new JTextField();
		textFieldTongTien.setEnabled(false);
		textFieldTongTien.setEditable(false);
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBounds(220, 199, 172, 26);
		panel_5.add(textFieldTongTien);

		JLabel lblNewLabel_2_2_1_2 = new JLabel("Tổng Tiền");
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1_2.setBounds(72, 197, 76, 26);
		panel_5.add(lblNewLabel_2_2_1_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(673, 368, 425, 228);
		add(panel_3);

		JLabel lblNewLabel_2_1 = new JLabel("Mã SP");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 10, 76, 26);
		panel_3.add(lblNewLabel_2_1);

		comboBoxMaSP = new JComboBox();
		comboBoxMaSP.setBounds(96, 11, 209, 26);
		panel_3.add(comboBoxMaSP);

		JLabel lblNewLabel_2_2_1 = new JLabel("Giá ");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1.setBounds(10, 53, 65, 26);
		panel_3.add(lblNewLabel_2_2_1);

		textFieldGia = new JTextField();
		textFieldGia.setColumns(10);
		textFieldGia.setBounds(96, 55, 209, 26);
		panel_3.add(textFieldGia);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Số Lượng");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1_1.setBounds(10, 90, 65, 26);
		panel_3.add(lblNewLabel_2_2_1_1);

		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(96, 91, 209, 27);
		panel_3.add(textFieldSoLuong);

		JLabel lblNewLabel_2_2_1_2_1 = new JLabel("Ghi Chú");
		lblNewLabel_2_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_1_2_1.setBounds(9, 136, 76, 26);
		panel_3.add(lblNewLabel_2_2_1_2_1);

		JScrollPane scrollPane1 = new JScrollPane((Component) null);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setAutoscrolls(true);
		scrollPane1.setBounds(97, 137, 208, 81);
		panel_3.add(scrollPane1);

		textAreaMoTa = new JTextArea();
		scrollPane1.setViewportView(textAreaMoTa);

		JButton btnLuuPhieu = new JButton(
				"<html><center><img src='" + Admin_PhieuNhap.class.getResource("/com/NhacCu/item/folder_16.png")
						+ "'><br>In và Lưu </br>Phiếu</center></html>");
		btnLuuPhieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTable(table_1);
			}
		});
		btnLuuPhieu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLuuPhieu.setBounds(356, 10, 47, 208);
		panel_3.add(btnLuuPhieu);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(null);
		panel_4.setBounds(10, 613, 1088, 50);
		add(panel_4);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon(Admin_PhieuNhap.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(10, 10, 110, 30);
		panel_4.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(Admin_PhieuNhap.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(301, 10, 110, 30);
		panel_4.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(Admin_PhieuNhap.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(631, 10, 110, 30);
		panel_4.add(btnXoa);

		btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnReload.setIcon(new ImageIcon(Admin_PhieuNhap.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReload.setBounds(951, 10, 127, 30);
		panel_4.add(btnReload);
		textFieldSoLuong.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateTongTien();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateTongTien();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateTongTien();
			}
		});
		textFieldGia.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateTongTien();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateTongTien();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateTongTien();
			}

		});
	}

	public void initTableNhapHang(ArrayList<PhieuNhapHangDTO> list, final ArrayList<NhanVienDTO> listNV,
			final ArrayList<NhaCungCapDTO> listNCC, final ArrayList<SanPhamDTO> listSP,
			final ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
		// Tạo DefaultTableModel mớia
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Phiếu Nhập");
		model.addColumn("Mã Nhà Cung Cấp");
		model.addColumn("Mã Nhân Viên");
		model.addColumn("Ngày Nhập");
		model.addColumn("Tổng Tiền");
		model.addColumn("Trạng Thái");

		// Đổ dữ liệu vào DefaultTableModel
		for (PhieuNhapHangDTO pnh : list) {
			if (pnh.getEnable() == 1) {
				model.addRow(new Object[] { pnh.getMaPNH(), pnh.getMaNCC(), pnh.getMaNhanVien(), pnh.getNgayNhap(),
						pnh.getTongTien(), "Xác Nhận" });
			} else {
				model.addRow(new Object[] { pnh.getMaPNH(), pnh.getMaNCC(), pnh.getMaNhanVien(), pnh.getNgayNhap(),
						pnh.getTongTien(), "Chờ Xác Nhận" });
			}
		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table.setModel(model);

		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaPNH.setText(String.valueOf(table.getValueAt(index, 0)));
				textFieldMaPNH.setEditable(false);
				textFieldMaPNH.setEnabled(false);
				DefaultTableModel model1 = new DefaultTableModel();
				model1.addColumn("Mã Phiếu Nhập");
				model1.addColumn("Mã Sản Phẩm");
				model1.addColumn("Giá");
				model1.addColumn("Số Lượng");
				model1.addColumn("Ghi Chú");

				// Đổ dữ liệu vào DefaultTableModel
				for (ChiTietPhieuNhapDTO ctpn : listCTPN) {
					if (ctpn.getMaPNH().equals(String.valueOf(table.getValueAt(index, 0)))) {
						model1.addRow(new Object[] { ctpn.getMaPNH(), ctpn.getMaSP(), ctpn.getDonGiaNhap(),
								ctpn.getSoLuong(), ctpn.getGhiChu() });
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
						textFieldGia.setText(String.valueOf(table_1.getValueAt(index, 2)));
						textFieldSoLuong.setText(String.valueOf(table_1.getValueAt(index, 3)));
						textFieldTongTien.setText(String.valueOf(table_1.getValueAt(index, 4)));

					}
				});
				String selectedMaNCC = String.valueOf(table.getValueAt(index, 1));
				int count = 0;
				for (NhaCungCapDTO ncc : listNCC) {
					if (selectedMaNCC.equals(ncc.getMaNCC())) {
						comboBoxMaNCC.setSelectedIndex(count);
						break;
					}
					count++;
				}
				String selectedNV = String.valueOf(table.getValueAt(index, 2));
				int count1 = 0;
				for (NhanVienDTO nv : listNV) {
					if (nv.getEnable() == 1 && nv.getChucVu().equals("QLK")) {
						if (selectedNV.equals(nv.getMaNhanVien())) {
							comboBoxMaNV.setSelectedIndex(count1);
							break;
						}
						count1++;
					}

				}
				textFieldNgayNhap.setText(String.valueOf(table.getValueAt(index, 3)));
				textFieldTongTien.setText(String.valueOf(table.getValueAt(index, 4)));
				String selectedTrangThai = String.valueOf(table.getValueAt(index, 5));
				comboBoxTrangThai.setSelectedItem(selectedTrangThai);
				comboBoxTrangThai.setEnabled(true);
			}
		});
	}

	public void setcomboBoxTrangThai() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Chờ Xác Nhận");
		model.addElement("Xác Nhận");
		comboBoxTrangThai.setModel(model);
	}

	public void setcomboBoxMaSP(ArrayList<SanPhamDTO> list) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (SanPhamDTO sp : list) {
			model.addElement(sp.getMaSanPham() + "   " + sp.getTenSanPham());
		}
		comboBoxMaSP.setModel(model);
	}

	public void setcomboBoxMaNCC(ArrayList<NhaCungCapDTO> list) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (NhaCungCapDTO ncc : list) {

			model.addElement(ncc.getMaNCC() + "   " + ncc.getTenNCC());
		}
		comboBoxMaNCC.setModel(model);
	}

	public void setcomboBoxMaNV(ArrayList<NhanVienDTO> list) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (NhanVienDTO nv : list) {
			if (nv.getEnable() == 1 && nv.getChucVu().equals("QLK")) {
				model.addElement(nv.getMaNhanVien() + "   " + nv.getTenNhanVien());
			}
		}
		comboBoxMaNV.setModel(model);
	}

	public void initCTPN(final ArrayList<SanPhamDTO> listSP, ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Mã Phiếu Nhập");
		model1.addColumn("Mã Sản Phẩm");
		model1.addColumn("Giá");
		model1.addColumn("Số Lượng");
		model1.addColumn("Ghi Chú");

		// Đổ dữ liệu vào DefaultTableModel
		for (ChiTietPhieuNhapDTO ctpn : listCTPN) {

			model1.addRow(new Object[] { ctpn.getMaPNH(), ctpn.getMaSP(), ctpn.getDonGiaNhap(), ctpn.getSoLuong(),
					ctpn.getGhiChu() });

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
				textFieldGia.setText(String.valueOf(table_1.getValueAt(index, 2)));
				textFieldSoLuong.setText(String.valueOf(table_1.getValueAt(index, 3)));
				textAreaMoTa.setText(String.valueOf(table_1.getValueAt(index, 4)));

			}
		});
	}

	public void reload() {
		textFieldMaPNH.setText("");
		textFieldMaPNH.setEditable(true);
		textFieldMaPNH.setEnabled(true);
		textFieldNgayNhap.setText("");
		textFieldGia.setText("");
		textFieldSoLuong.setText("");
		textAreaMoTa.setText("");
		textFieldTongTien.setText("");
	
		comboBoxTrangThai.setSelectedIndex(0);
		comboBoxTrangThai.setEnabled(false);
		comboBoxMaNCC.setSelectedIndex(0);
		comboBoxMaSP.setSelectedIndex(0);
		comboBoxMaSP.setEnabled(true);
		comboBoxMaNV.setSelectedIndex(0);
		NhaCungCapBUS nccBUStest = new NhaCungCapBUS();
		NhanVienBUS nvBUStest = new NhanVienBUS();
		SanPhamBUS spBUStest = new SanPhamBUS();
		ChiTietPhieuNhapBUS ctpnBUStest = new ChiTietPhieuNhapBUS();
		PhieuNhapHangBUS pnhBUStest = new PhieuNhapHangBUS();
		if (nccBUStest.getList() == null)
			nccBUStest.listNCC();
		if (nvBUStest.getList() == null)
			nvBUStest.listNV();
		if (spBUStest.getList() == null)
			spBUStest.listSP();
		if (pnhBUStest.getList() == null)
			pnhBUStest.list();
		if (ctpnBUStest.getList() == null)
			ctpnBUStest.list();
		setcomboBoxMaNCC(nccBUStest.getList());
		setcomboBoxMaSP(spBUStest.getList());
		initTableNhapHang(pnhBUStest.getList(), nvBUStest.getList(), nccBUStest.getList(), spBUStest.getList(),
				ctpnBUStest.getList());
		initCTPN(spBUStest.getList(), ctpnBUStest.getList());
	}

	private boolean KiemTraTrong() {
		if (textFieldMaPNH.getText() == null || textFieldMaPNH.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Phiếu Nhập Hàng không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldMaPNH.requestFocus();
			return false;
		}
		if (textFieldGia.getText() == null || textFieldGia.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Giá Nhập không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldGia.requestFocus();
			return false;
		}
		if (textFieldSoLuong.getText() == null || textFieldSoLuong.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số lượng không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldSoLuong.requestFocus();
			return false;
		}
		if (textFieldNgayNhap.getText() == null || textFieldNgayNhap.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ngày Nhập không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldNgayNhap.requestFocus();
			return false;
		}
		return true;
	}

	public void them() {
		if (KiemTraTrong()) {

			String ncc = (String) comboBoxMaNCC.getSelectedItem();
			String[] maNCC = ncc.split(" ");
			String sp = (String) comboBoxMaSP.getSelectedItem();
			String[] maSP = sp.split(" ");
			String nv = (String) comboBoxMaNV.getSelectedItem();
			String[] maNV = nv.split(" ");

			if (pnhBUS.checkMaPNH(textFieldMaPNH.getText())) {

				if (pnhBUS.checkMaPNHvaMaNCCvaMaNVvaNgayNhap(textFieldMaPNH.getText(), maNCC[0], maNV[0],
						textFieldNgayNhap.getText())) {

					if (!ctpnBUS.checkMaPNHvaMaSP(textFieldMaPNH.getText(), maSP[0])) {

						try {
							int soLuong = Integer.parseInt(textFieldSoLuong.getText());
							int gia = Integer.parseInt(textFieldGia.getText());
							int tongTien = Integer.parseInt(textFieldTongTien.getText());

							ChiTietPhieuNhapDTO ctpnDTO = new ChiTietPhieuNhapDTO(maSP[0], textFieldMaPNH.getText(),
									gia, soLuong, textAreaMoTa.getText());
							ctpnBUS.add(ctpnDTO);

							// Thông báo thành công và cập nhật bảng
							JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo",
									JOptionPane.DEFAULT_OPTION);
							initTableNhapHang(pnhBUS.getList(), nvBUS.getList(), nccBUS.getList(), spBUS.getList(),
									ctpnBUS.getList());
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Số lượng và giá phải là số nguyên dương!", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
						reload();
					} else {

						JOptionPane.showMessageDialog(null, "Chi Tiết Phiếu Nhập bị trùng", "Thông báo",
								JOptionPane.DEFAULT_OPTION);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Phiếu Nhập bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
				}
			} else {

				try {
					int soLuong = Integer.parseInt(textFieldSoLuong.getText());
					int gia = Integer.parseInt(textFieldGia.getText());
					int tongTien = Integer.parseInt(textFieldTongTien.getText());

					PhieuNhapHangDTO pnhDTO = new PhieuNhapHangDTO(textFieldMaPNH.getText(), maNCC[0], maNV[0],
							textFieldNgayNhap.getText(), tongTien, 0);
					ChiTietPhieuNhapDTO ctpnDTO = new ChiTietPhieuNhapDTO(maSP[0], textFieldMaPNH.getText(), gia,
							soLuong, textAreaMoTa.getText());
					pnhBUS.add(pnhDTO);
					ctpnBUS.add(ctpnDTO);

					// Thông báo thành công và cập nhật bảng
					JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
					initTableNhapHang(pnhBUS.getList(), nvBUS.getList(), nccBUS.getList(), spBUS.getList(),
							ctpnBUS.getList());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Số lượng và giá phải là số nguyên dương!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
				reload();

			}
		}
	}

	public void sua() {
		if (KiemTraTrong()) {

			String ncc = (String) comboBoxMaNCC.getSelectedItem();
			String[] maNCC = ncc.split(" ");
			String sp = (String) comboBoxMaSP.getSelectedItem();
			String[] maSP = sp.split(" ");
			String nv = (String) comboBoxMaNV.getSelectedItem();
			String[] maNV = nv.split(" ");
			try {
				int soLuong = Integer.parseInt(textFieldSoLuong.getText());
				int gia = Integer.parseInt(textFieldGia.getText());
				int tongTien = Integer.parseInt(textFieldTongTien.getText());
				if (comboBoxTrangThai.getSelectedItem().equals("Xác Nhận")) {
					PhieuNhapHangDTO pnhDTO = new PhieuNhapHangDTO(textFieldMaPNH.getText(), maNCC[0], maNV[0],
							textFieldNgayNhap.getText(), tongTien, 1);
					pnhBUS.update(pnhDTO);

				} else {
					PhieuNhapHangDTO pnhDTO = new PhieuNhapHangDTO(textFieldMaPNH.getText(), maNCC[0], maNV[0],
							textFieldNgayNhap.getText(), tongTien, 0);
					pnhBUS.update(pnhDTO);
				}
				ChiTietPhieuNhapDTO ctpnDTO = new ChiTietPhieuNhapDTO(maSP[0], textFieldMaPNH.getText(), gia, soLuong,
						textAreaMoTa.getText());
				ctpnBUS.update(ctpnDTO);

				// Thông báo thành công và cập nhật bảng
				JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTableNhapHang(pnhBUS.getList(), nvBUS.getList(), nccBUS.getList(), spBUS.getList(),
						ctpnBUS.getList());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số lượng và giá phải là số nguyên dương!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
			reload();
		} else {

			JOptionPane.showMessageDialog(null, "Chi Tiết Phiếu Nhập bị trùng", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
		}

	}

	private void xoa() {
		if (!(textFieldMaPNH.getText().equals("") || textFieldMaPNH.getText() == null)
				&& !(textFieldNgayNhap.getText().equals("") || textFieldNgayNhap.getText() == null)) {
			pnhBUS.delete(textFieldMaPNH.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			reload();
		}
	}

	public void updateTongTien() {
		if ((textFieldGia.getText().equals("") && textFieldSoLuong.equals(""))
				|| (!textFieldGia.getText().equals("") && textFieldSoLuong.equals(""))
				|| (textFieldGia.getText().equals("") && !textFieldSoLuong.equals(""))) {
			textFieldTongTien.setText("0");
		} else {
			try {
				int gia = Integer.valueOf(textFieldGia.getText());
				int soLuong = Integer.valueOf(textFieldSoLuong.getText());
				// Thực hiện tính toán tổng tiền ở đây
				int tongTien = gia * soLuong;
				textFieldTongTien.setText(String.valueOf(tongTien));
			} catch (NumberFormatException ex) {
				// Xử lý ngoại lệ nếu giá trị không hợp lệ
				textFieldTongTien.setText("0"); // Hoặc giá trị mặc định khác
			}
		}
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

				final String tendangnhapnv = QuanLyKho_TrangChu.tenDangNhap.getText();
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
