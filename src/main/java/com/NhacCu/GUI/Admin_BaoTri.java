package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
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

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_BaoTri extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaBT;
	private JTextField textFieldMaHD;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldMaNV;
	private JTextField textFieldMaKH;
	private JComboBox comboBoxTrangThai;
	private JTextArea textAreaMoTa;
	private JComboBox comboBoxMaSP;
	
	private SanPhamBUS spBUS = new SanPhamBUS();
	private ChiTietPhieuBaoTriBUS ctpbtBUS = new ChiTietPhieuBaoTriBUS();
	private PhieuBaoTriBUS pbtBUS = new PhieuBaoTriBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private JTextField textFieldNgayLap;

	/**
	 * Create the panel.
	 */
	public Admin_BaoTri() {
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
	}

	public void initComponents() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 32, 544, 316);
		add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 524, 296);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Phi\u1EBFu B\u1EA3o Tr\u00EC", "M\u00E3 Nh\u00E2n Vi\u00EAn", "M\u00E3 Kh\u00E1ch H\u00E0ng", "M\u00E3 H\u00F3a \u0110\u01A1n", "Ng\u00E0y L\u1EADp", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(null);
		panel_4.setBounds(617, 32, 474, 316);
		add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Bảo Trì");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(36, 10, 178, 28);
		panel_4.add(lblNewLabel_2);
		
		textFieldMaBT = new JTextField();
		textFieldMaBT.setColumns(10);
		textFieldMaBT.setBounds(245, 13, 149, 28);
		panel_4.add(textFieldMaBT);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã Nhân Viên");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(36, 65, 199, 28);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(36, 115, 178, 28);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(36, 256, 90, 28);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Mã Hóa Đơn");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_2.setBounds(40, 164, 162, 28);
		panel_4.add(lblNewLabel_2_1_1_2);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setColumns(10);
		textFieldMaHD.setBounds(245, 167, 149, 28);
		panel_4.add(textFieldMaHD);
		
		 comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setBounds(245, 259, 149, 27);
		panel_4.add(comboBoxTrangThai);
		
		textFieldMaNV = new JTextField();
		textFieldMaNV.setColumns(10);
		textFieldMaNV.setBounds(245, 65, 149, 28);
		panel_4.add(textFieldMaNV);
		
		textFieldMaKH = new JTextField();
		textFieldMaKH.setColumns(10);
		textFieldMaKH.setBounds(245, 118, 149, 28);
		panel_4.add(textFieldMaKH);
		
		textFieldNgayLap = new JTextField();
		textFieldNgayLap.setColumns(10);
		textFieldNgayLap.setBounds(245, 216, 149, 28);
		panel_4.add(textFieldNgayLap);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Ngày Lập");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_2_1.setBounds(40, 218, 162, 28);
		panel_4.add(lblNewLabel_2_1_1_2_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 358, 544, 223);
		add(panel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 524, 203);
		panel_2_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Phi\u1EBFu B\u1EA3o Tr\u00EC", "Ghi Ch\u00FA"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(null);
		panel_5.setBounds(617, 358, 474, 223);
		add(panel_5);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 17, 86, 31);
		panel_5.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Ghi Chú");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1.setBounds(10, 81, 65, 28);
		panel_5.add(lblNewLabel_2_2_1_1);
		
		JScrollPane scrollPane1 = new JScrollPane((Component) null);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setAutoscrolls(true);
		scrollPane1.setBounds(137, 84, 230, 129);
		panel_5.add(scrollPane1);
		
		 textAreaMoTa = new JTextArea();
		scrollPane1.setViewportView(textAreaMoTa);
		
		JButton btnNewButton_2 = new JButton("<html><center><img src='" + Admin_BaoTri.class.getResource("/com/NhacCu/item/folder_16.png") + "'><br>In và Lưu </br>Phiếu</center></html>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTable(table_1);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(419, 30, 45, 156);
		panel_5.add(btnNewButton_2);
		
		 comboBoxMaSP = new JComboBox();
		comboBoxMaSP.setBounds(137, 21, 230, 27);
		panel_5.add(comboBoxMaSP);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 605, 1081, 70);
		add(panel_3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon(Admin_BaoTri.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(10, 10, 169, 50);
		panel_3.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(Admin_BaoTri.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(285, 10, 169, 50);
		panel_3.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(Admin_BaoTri.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(594, 10, 169, 50);
		panel_3.add(btnXoa);
		
		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnReload.setIcon(new ImageIcon(Admin_BaoTri.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReload.setBounds(902, 10, 169, 50);
		panel_3.add(btnReload);
	}
	public void setcomboBoxTrangThai() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Xác Nhận");
		model.addElement("Chờ Xác Nhận");
		model.addElement("Hủy");
		comboBoxTrangThai.setModel(model);
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
						
					}else {
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
				JOptionPane.showMessageDialog(null, ex, "Lỗi",
						JOptionPane.ERROR_MESSAGE);
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

				final String tendangnhapnv = Admin.tendangnhap.getText();
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
