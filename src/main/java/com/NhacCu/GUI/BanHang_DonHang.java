package com.NhacCu.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.NhacCu.BUS.ChiTietHoaDonBUS;
import com.NhacCu.BUS.HoaDonBUS;
import com.NhacCu.BUS.LoaiBUS;
import com.NhacCu.BUS.NhaSanXuatBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.BUS.UserBUS;
import com.NhacCu.DTO.ChiTietHoaDonDTO;
import com.NhacCu.DTO.HoaDonDTO;
import com.NhacCu.DTO.LoaiDTO;
import com.NhacCu.DTO.NhaSanXuatDTO;
import com.NhacCu.DTO.NhanVienDTO;
import com.NhacCu.DTO.SanPhamDTO;
import com.NhacCu.DTO.UserDTO;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BanHang_DonHang extends JPanel {
	Color DefaultColor = new Color(240, 240, 240);
	Color ClickedColor = new Color(128, 255, 0);
	private static final long serialVersionUID = 1L;
	private JTextField textFieldKiemTraSoLuong;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textFieldSoLuong;
	private JTextField textFieldGia;
	private JTextField textFieldTGBH;
	private JTextArea textAreaMoTa;
	private JTextField textFieldMaHD;
	private JTextField textFieldMaKH;
	private JTextField textFieldNgayDat;
	private JTextField textFieldTongTien;

	private SanPhamBUS spBUS = new SanPhamBUS();
	private LoaiBUS loaiBUS = new LoaiBUS();
	private NhaSanXuatBUS nsxBUS = new NhaSanXuatBUS();
	private HoaDonBUS hdBUS = new HoaDonBUS();
	private ChiTietHoaDonBUS cthdBUS = new ChiTietHoaDonBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private UserBUS usBUS = new UserBUS();
	private JComboBox comboBoxTrangThai;
	private JComboBox comboBoxMaNhanVien;
	private JComboBox comboBoxThanhToan;
	private JLabel lblImg;
	private JComboBox comboBoxMaSP;
	private JComboBox comboBox_3;
	
	/**
	 * Create the panel.
	 */
	public BanHang_DonHang() {
		if (spBUS.getList() == null)
			spBUS.listSP();
		if (loaiBUS.getList() == null)
			loaiBUS.listLoai();
		if (nsxBUS.getList() == null)
			nsxBUS.list();
		if (hdBUS.getList() == null)
			hdBUS.list();
		if (cthdBUS.getList() == null)
			cthdBUS.list();
		if (nvBUS.getList() == null) {
			nvBUS.listNV();
		}
		if (usBUS.getList() == null) {
			usBUS.listUs();
		}

		initComponents();

		initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());

		initTableHoaDonNhapHang(hdBUS.getList(), nvBUS.getList(), usBUS.getList(), cthdBUS.getList(), spBUS.getList());
		initCTHD(cthdBUS.getList(), spBUS.getList());
		setcomboBoxMaSP(spBUS.getList());
		setcomboBoxMaNV(nvBUS.getList());
		setcomboBoxTrangThai();
		setcomboBoxThanhToan();
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 133, 1316, 548);
		add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Kiểm tra số lượng", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(10, 10, 1291, 115);
		panel_4.add(panel_3);
		panel_3.setLayout(null);
		
		textFieldKiemTraSoLuong = new JTextField();
		textFieldKiemTraSoLuong.setBounds(200, 38, 735, 43);
		panel_3.add(textFieldKiemTraSoLuong);
		textFieldKiemTraSoLuong.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textFieldKiemTraSoLuong.getText();
				int columnIndex = comboBox_3.getSelectedIndex(); // Get the index of the selected item in the combo box
				TableRowSorter<? extends TableModel> sorter = (TableRowSorter<? extends TableModel>) table
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
		btnNewButton.setBounds(969, 35, 128, 43);
		panel_3.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(BanHang_DonHang.class.getResource("/com/NhacCu/item/search_24.png")));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		 comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Mã Sản Phẩm", "Tên Sản Phẩm" }));
		comboBox_3.setBounds(20, 38, 158, 43);
		panel_3.add(comboBox_3);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnLmMi.setIcon(new ImageIcon(BanHang_DonHang.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnLmMi.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLmMi.setBounds(1126, 35, 141, 43);
		panel_3.add(btnLmMi);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 135, 1291, 217);
		panel_4.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "T\u00EAn Lo\u1EA1i", "T\u00EAn Nh\u00E0 S\u1EA3n Xu\u1EA5t", "Image", "Ghi Ch\u00FA"
			}
		));
		scrollPane_1.setViewportView(table);
		
		 lblImg = new JLabel("HÌNH ẢNH");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblImg.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblImg.setBounds(983, 372, 259, 136);
		panel_4.add(lblImg);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hóa Đơn", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 743, 267);
		panel_1.add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "H\u1ECD v\u00E0 T\u00EAn Kh\u00E1ch H\u00E0ng", "Ng\u00E0y \u0110\u1EB7t", "T\u1ED5ng Ti\u1EC1n", "Tr\u1EA1ng Th\u00E1i", "M\u00E3 Nh\u00E2n Vi\u00EAn L\u1EADp"
			}
		));
		scrollPane_2.setViewportView(table_1);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(10, 287, 743, 159);
		panel_1.add(scrollPane_2_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Th\u1EDDi Gian B\u1EA3o H\u00E0nh", "Ghi Ch\u00FA"
			}
		));
		scrollPane_2_1.setViewportView(table_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setBounds(763, 10, 538, 267);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Mã hóa đơn");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 10, 128, 25);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(10, 45, 150, 25);
		panel_5.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Ngày đặt");
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1.setBounds(10, 80, 150, 25);
		panel_5.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Tổng tiền");
		lblNewLabel_3_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1.setBounds(10, 115, 155, 25);
		panel_5.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Trạng thái");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1.setBounds(10, 150, 150, 25);
		panel_5.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Mã NV");
		lblNewLabel_3_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_1.setBounds(10, 191, 76, 25);
		panel_5.add(lblNewLabel_3_1_1_1_1_1);
		
		 comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBoxTrangThai.setModel(new DefaultComboBoxModel(new String[] {"Chờ Xác Nhận", "Xác Nhận"}));
		comboBoxTrangThai.setBounds(170, 150, 202, 33);
		panel_5.add(comboBoxTrangThai);
		
		 comboBoxMaNhanVien = new JComboBox();
		comboBoxMaNhanVien.setModel(new DefaultComboBoxModel(new String[] {"BH1  BanHang1", "BH2  BanHang2"}));
		comboBoxMaNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBoxMaNhanVien.setBounds(170, 193, 202, 31);
		panel_5.add(comboBoxMaNhanVien);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setEnabled(false);
		textFieldMaHD.setEditable(false);
		textFieldMaHD.setColumns(10);
		textFieldMaHD.setBounds(170, 10, 202, 25);
		panel_5.add(textFieldMaHD);
		
		textFieldMaKH = new JTextField();
		textFieldMaKH.setEnabled(false);
		textFieldMaKH.setEditable(false);
		textFieldMaKH.setColumns(10);
		textFieldMaKH.setBounds(170, 50, 202, 25);
		panel_5.add(textFieldMaKH);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Thanh Toán");
		lblNewLabel_3_1_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_1_1.setBounds(10, 232, 155, 25);
		panel_5.add(lblNewLabel_3_1_1_1_1_1_1);
		
		textFieldNgayDat = new JTextField();
		textFieldNgayDat.setEnabled(false);
		textFieldNgayDat.setEditable(false);
		textFieldNgayDat.setColumns(10);
		textFieldNgayDat.setBounds(170, 86, 202, 25);
		panel_5.add(textFieldNgayDat);
		
		textFieldTongTien = new JTextField();
		textFieldTongTien.setEnabled(false);
		textFieldTongTien.setEditable(false);
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBounds(170, 121, 202, 25);
		panel_5.add(textFieldTongTien);
		
		 comboBoxThanhToan = new JComboBox();
		comboBoxThanhToan.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBoxThanhToan.setBounds(170, 231, 202, 26);
		panel_5.add(comboBoxThanhToan);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5_1.setBounds(763, 287, 538, 159);
		panel_1.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1_1_2 = new JLabel("Mã sản phẩm");
		lblNewLabel_3_1_1_1_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2.setBounds(10, 10, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2);
		
		 comboBoxMaSP = new JComboBox();
		comboBoxMaSP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBoxMaSP.setBounds(170, 9, 141, 25);
		panel_5_1.add(comboBoxMaSP);
		
		JLabel lblNewLabel_3_1_1_1_1_2_1 = new JLabel("Số Lượng");
		lblNewLabel_3_1_1_1_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2_1.setBounds(10, 52, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2_1);
		
		JLabel lblNewLabel_3_1_1_1_1_2_1_1 = new JLabel("Giá");
		lblNewLabel_3_1_1_1_1_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2_1_1.setBounds(10, 87, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1_2_1_1_1 = new JLabel("Thời gian bảo hành");
		lblNewLabel_3_1_1_1_1_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2_1_1_1.setBounds(10, 122, 172, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2_1_1_1);
		
		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(170, 55, 141, 25);
		panel_5_1.add(textFieldSoLuong);
		
		textFieldGia = new JTextField();
		textFieldGia.setColumns(10);
		textFieldGia.setBounds(170, 90, 141, 25);
		panel_5_1.add(textFieldGia);
		
		textFieldTGBH = new JTextField();
		textFieldTGBH.setColumns(10);
		textFieldTGBH.setBounds(170, 125, 141, 25);
		panel_5_1.add(textFieldTGBH);
		
		JLabel lblNewLabel_3_1_1_1_1_2_1_2 = new JLabel("Ghi Chú");
		lblNewLabel_3_1_1_1_1_2_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1_1_2_1_2.setBounds(339, 10, 150, 25);
		panel_5_1.add(lblNewLabel_3_1_1_1_1_2_1_2);
		
		textAreaMoTa = new JTextArea();
		textAreaMoTa.setEnabled(false);
		textAreaMoTa.setEditable(false);
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(339, 54, 189, 95);
		panel_5_1.add(scrollPane1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// dọc
		scrollPane1.setAutoscrolls(true);
		
		JButton btnNewButton_1 = new JButton("XÁC NHẬN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacnhan();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BanHang_DonHang.class.getResource("/com/NhacCu/item/verified_32.png")));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton_1.setBounds(941, 456, 237, 52);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton(" XÓA");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(BanHang_DonHang.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(343, 456, 237, 52);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("IN PHIẾU");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTable(table_2);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BanHang_DonHang.class.getResource("/com/NhacCu/item/bill_32.png")));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton_2.setBounds(631, 457, 237, 51);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("HÓA ĐƠN");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_4.setBounds(330, 10, 875, 115);
		add(lblNewLabel_4);
	}
	private void initTable(ArrayList<SanPhamDTO> list, ArrayList<LoaiDTO> listLoai, ArrayList<NhaSanXuatDTO> listNSX) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Sản Phẩm");
		model.addColumn("Tên Sản Phẩm");
		model.addColumn("Số Lượng");
		model.addColumn("Giá");
		model.addColumn("Tên Loại");
		model.addColumn("Tên Nhà Sản Xuất");
		model.addColumn("Ảnh");
		model.addColumn("Mô tả");

		for (SanPhamDTO sp : list) {
			model.addRow(new Object[] { sp.getMaSanPham(), sp.getTenSanPham(), sp.getSoLuong(), sp.getGia(),
					loaiBUS.PutOutTenLoai(sp.getMaLoai()), nsxBUS.PutOnTenNSX(sp.getMaNSX()), sp.getImage(),
					sp.getGhiChu() });
		}

		this.table.setModel(model);

		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				lblImg.setName(String.valueOf(table.getValueAt(index, 6)));
				lblImg.setIcon(setIC(String.valueOf(table.getValueAt(index, 6))));
			}
		});
	}

	public ImageIcon setIC(String path) {
		ImageIcon imgs = new ImageIcon(path);
		Image ig = imgs.getImage().getScaledInstance(lblImg.getWidth() + 15, lblImg.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(ig);
		return ic;
	}

	public void reload() {
		textFieldKiemTraSoLuong.setText("");
		initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());
		lblImg.setName("Hình Ảnh");
		lblImg.setIcon(setIC(""));
	}

	public void initTableHoaDonNhapHang(ArrayList<HoaDonDTO> list, ArrayList<NhanVienDTO> listNV,
			ArrayList<UserDTO> listUs, ArrayList<ChiTietHoaDonDTO> listCTHD, ArrayList<SanPhamDTO> listSP) {
		// Tạo DefaultTableModel mớia
		DefaultTableModel model2 = new DefaultTableModel();
		model2.addColumn("Mã Hóa Đơn");
		model2.addColumn("Mã Khách Hàng");
		model2.addColumn("Mã Nhân Viên");
		model2.addColumn("Ngày Lập");
		model2.addColumn("Tổng Tiền");
		model2.addColumn("Trạng Thái");
		model2.addColumn("Thanh Toán");
		// Đổ dữ liệu vào DefaultTableModel
		for (HoaDonDTO hd : list) {
			if (hd.getEnable() == 1) {
				if (hd.getThanhToan() == 1) {
					model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(), hd.getNgayLap(),
							hd.getTongTien(), "Xác Nhận", "Đã Thanh Toán" });
				} else {
					model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(), hd.getNgayLap(),
							hd.getTongTien(), "Xác Nhận", "Chưa Thanh Toán" });
				}
			} else {
				if (hd.getEnable() == 0) {
					if (hd.getThanhToan() == 1) {
						model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(), hd.getNgayLap(),
								hd.getTongTien(), "Chờ Xác Nhận", "Đã Thanh Toán" });
					} else {
						model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(), hd.getNgayLap(),
								hd.getTongTien(), "Chờ Xác Nhận", "Chưa Thanh Toán" });
					}
					
				}else {
					if (hd.getThanhToan() == 1) {
						model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(), hd.getNgayLap(),
								hd.getTongTien(), "Hủy", "Đã Thanh Toán" });
					} else {
						model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(), hd.getNgayLap(),
								hd.getTongTien(), "Hủy", "Chưa Thanh Toán" });
					}
				}
			}
		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table_1.setModel(model2);

		// Cho phép table sắp xếp
		table_1.setAutoCreateRowSorter(true);
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table_1.getSelectedRow();
				textFieldMaHD.setText(String.valueOf(table_1.getValueAt(index, 0)));
				textFieldMaHD.setEditable(false);
				textFieldMaHD.setEnabled(false);
				DefaultTableModel model1 = new DefaultTableModel();
				model1.addColumn("Mã Sản Phẩm");
				model1.addColumn("Số Lượng");
				model1.addColumn("Giá");
				model1.addColumn("Thời Gian Bảo Hành");
				model1.addColumn("Ghi Chú");

				// Đổ dữ liệu vào DefaultTableModel
				for (ChiTietHoaDonDTO cthd : listCTHD) {
					if (cthd.getMaHoaDon().equals(String.valueOf(table_1.getValueAt(index, 0)))) {
						model1.addRow(new Object[] { cthd.getMaSanPham(), cthd.getSoLuong(), cthd.getGia(),
								cthd.getThoiGianBaoHanh(), cthd.getGhiChu() });
					}
				}

				// Sử dụng DefaultTableModel để tạo JTable
				table_2.setModel(model1);

				// Cho phép table sắp xếp
				table_2.setAutoCreateRowSorter(true);
				table_2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						int index = table_2.getSelectedRow();
						String selectedMaSP = String.valueOf(table_2.getValueAt(index, 0));
						int count = 0;
						for (SanPhamDTO sp : listSP) {
							if (selectedMaSP.equals(sp.getMaSanPham())) {
								comboBoxMaSP.setSelectedIndex(count);
								break;
							}
							count++;
						}
						comboBoxMaSP.setEnabled(false);
						textFieldSoLuong.setText(String.valueOf(table_2.getValueAt(index, 1)));
						textFieldGia.setText(String.valueOf(table_2.getValueAt(index, 2)));
						textFieldTGBH.setText(String.valueOf(table_2.getValueAt(index, 3)));
						textAreaMoTa.setText(String.valueOf(table_2.getValueAt(index, 4)));

					}
				});

				textFieldMaKH.setText(String.valueOf(table_1.getValueAt(index, 1)));
				String selectedNV = String.valueOf(table_1.getValueAt(index, 2));
				comboBoxMaNhanVien.setSelectedItem(selectedNV);

				textFieldNgayDat.setText(String.valueOf(table_1.getValueAt(index, 3)));
				textFieldTongTien.setText(String.valueOf(table_1.getValueAt(index, 4)));
				String selectedTrangThai = String.valueOf(table_1.getValueAt(index, 5));
				comboBoxTrangThai.setSelectedItem(selectedTrangThai);
				if (selectedTrangThai.equals("Xác Nhận")) {
					comboBoxTrangThai.setEnabled(true );
				}
				if (selectedTrangThai.equals("Chờ Xác Nhận")) {
					comboBoxTrangThai.setEnabled(true );
				}
				if (selectedTrangThai.equals("Hủy")) {
					comboBoxTrangThai.setEnabled(false );
				}
				String selectedThanhToan = String.valueOf(table_1.getValueAt(index, 6));
				comboBoxThanhToan.setSelectedItem(selectedThanhToan);
				if (selectedThanhToan.equals("Chưa Thanh Toán")) {
					comboBoxThanhToan.setEnabled(true );
				}
				if (selectedThanhToan.equals("Đã Thanh Toán")) {
					comboBoxThanhToan.setEnabled(false );
				}
			}
		});
	}

	public void setcomboBoxTrangThai() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Xác Nhận");
		model.addElement("Hủy");
		model.addElement("Chờ Xác Nhận");
		comboBoxTrangThai.setModel(model);
	}

	public void setcomboBoxThanhToan() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Đã Thanh Toán");
		model.addElement("Chưa Thanh Toán");
		comboBoxThanhToan.setModel(model);
	}

	public void setcomboBoxMaSP(ArrayList<SanPhamDTO> list) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (SanPhamDTO sp : list) {
			model.addElement(sp.getMaSanPham() + "   " + sp.getTenSanPham());
		}
		comboBoxMaSP.setModel(model);
	}

	public void setcomboBoxMaNV(ArrayList<NhanVienDTO> list) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (NhanVienDTO nv : list) {
			if (nv.getChucVu().equals("ChuDoanhNghiep")) {
				model.addElement(nv.getMaNhanVien());
			}
			if (nv.getChucVu().equals("NhanVien")) {
				model.addElement(nv.getMaNhanVien());
			}
		}
		comboBoxMaNhanVien.setModel(model);
	}

	public void initCTHD(ArrayList<ChiTietHoaDonDTO> listCTHD, ArrayList<SanPhamDTO> listSP) {
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Mã Sản Phẩm");
		model1.addColumn("Số Lượng");
		model1.addColumn("Giá");
		model1.addColumn("Thời Gian Bảo Hành");
		model1.addColumn("Ghi Chú");

		// Đổ dữ liệu vào DefaultTableModel
		for (ChiTietHoaDonDTO cthd : listCTHD) {

			model1.addRow(new Object[] { cthd.getMaSanPham(), cthd.getSoLuong(), cthd.getGia(),
					cthd.getThoiGianBaoHanh(), cthd.getGhiChu() });
		}

		// Sử dụng DefaultTableModel để tạo JTable
		table_2.setModel(model1);

		// Cho phép table sắp xếp
		table_2.setAutoCreateRowSorter(true);
		table_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table_2.getSelectedRow();
				String selectedMaSP = String.valueOf(table_2.getValueAt(index, 0));
				int count = 0;
				for (SanPhamDTO sp : listSP) {
					if (selectedMaSP.equals(sp.getMaSanPham())) {
						comboBoxMaSP.setSelectedIndex(count);
						break;
					}
					count++;
				}
				comboBoxMaSP.setEnabled(false);
				textFieldSoLuong.setText(String.valueOf(table_2.getValueAt(index, 1)));
				textFieldGia.setText(String.valueOf(table_2.getValueAt(index, 2)));
				textFieldTGBH.setText(String.valueOf(table_2.getValueAt(index, 3)));
				textAreaMoTa.setText(String.valueOf(table_2.getValueAt(index, 4)));

			}
		});
	}

	private boolean KiemTraTrong() {
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
		if (textFieldNgayDat.getText() == null || textFieldNgayDat.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ngày Đặt không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldNgayDat.requestFocus();
			return false;
		}
		if (textFieldTongTien.getText() == null || textFieldTongTien.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tổng Tiền không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldTongTien.requestFocus();
			return false;
		}
		return true;
	}

	private void xoa() {
		if (KiemTraTrong()) {
			hdBUS.delete(textFieldMaHD.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			reload1();
		}
	}

	public void reload1() {
		textFieldMaHD.setText("");
		textAreaMoTa.setText("");
		textFieldGia.setText("");
		textFieldMaKH.setText("");
		textFieldMaKH.setText("");
		textFieldNgayDat.setText("");
		textFieldSoLuong.setText("");
		textFieldTGBH.setText("");
		textFieldTongTien.setText("");
		comboBoxMaNhanVien.setSelectedIndex(0);
		comboBoxMaSP.setSelectedIndex(0);
		comboBoxThanhToan.setSelectedIndex(0);
		comboBoxTrangThai.setSelectedIndex(0);
		 SanPhamBUS spBUSupdate = new SanPhamBUS();
		 LoaiBUS loaiBUSupdate = new LoaiBUS();
		 NhaSanXuatBUS nsxBUSupdate = new NhaSanXuatBUS();
		 HoaDonBUS hdBUSupdate = new HoaDonBUS();
		 ChiTietHoaDonBUS cthdBUSupdate = new ChiTietHoaDonBUS();
		 NhanVienBUS nvBUSupdate = new NhanVienBUS();
		 UserBUS usBUSupdate = new UserBUS();
		if (spBUSupdate.getList() == null)
			spBUSupdate.listSP();
		if (loaiBUSupdate.getList() == null)
			loaiBUSupdate.listLoai();
		if (nsxBUSupdate.getList() == null)
			nsxBUSupdate.list();
		if (hdBUSupdate.getList() == null)
			hdBUSupdate.list();
		if (cthdBUSupdate.getList() == null)
			cthdBUSupdate.list();
		if (nvBUSupdate.getList() == null) {
			nvBUSupdate.listNV();
		}
		if (usBUSupdate.getList() == null) {
			usBUSupdate.listUs();
		}
		initTableHoaDonNhapHang(hdBUSupdate.getList(), nvBUSupdate.getList(), usBUSupdate.getList(), cthdBUSupdate.getList(),
				spBUSupdate.getList());
		initCTHD(cthdBUSupdate.getList(), spBUSupdate.getList());
	}
	public void xacnhan() {
		if (KiemTraTrong()) {
			String sp = (String) comboBoxMaSP.getSelectedItem();
			String[] maSP = sp.split(" ");
			if (comboBoxTrangThai.getSelectedItem().equals("Xác Nhận")) {
				if (comboBoxThanhToan.getSelectedItem().equals("Đã Thanh Toán")) {
					HoaDonDTO hdDTO = new HoaDonDTO(textFieldMaHD.getText(),
							(String) comboBoxMaNhanVien.getSelectedItem(), textFieldMaKH.getText(),
							textFieldNgayDat.getText(), Integer.parseInt(textFieldTongTien.getText()), 1, 1);
					hdBUS.update(hdDTO);
					
				} else {
					HoaDonDTO hdDTO = new HoaDonDTO(textFieldMaHD.getText(),
							(String) comboBoxMaNhanVien.getSelectedItem(), textFieldMaKH.getText(),
							textFieldNgayDat.getText(), Integer.parseInt(textFieldTongTien.getText()), 1, 0);
					hdBUS.update(hdDTO);
					
				}
			} else {
				if (comboBoxTrangThai.getSelectedItem().equals("Hủy")) {
					if (comboBoxThanhToan.getSelectedItem().equals("Đã Thanh Toán")) {
						HoaDonDTO hdDTO = new HoaDonDTO(textFieldMaHD.getText(),
								(String) comboBoxMaNhanVien.getSelectedItem(), textFieldMaKH.getText(),
								textFieldNgayDat.getText(), Integer.parseInt(textFieldTongTien.getText()), 2, 1);
						hdBUS.update(hdDTO);
						for (ChiTietHoaDonDTO cthdDTO : cthdBUS.getList()) {
							if (cthdDTO.getMaHoaDon().equals(textFieldMaHD.getText())) {
								for (SanPhamDTO spDTO : spBUS.getList()) {
									if (spDTO.getMaSanPham().equals(cthdDTO.getMaSanPham())) {
										int soluongcapnhat = spDTO.getSoLuong() + cthdDTO.getSoLuong();
										SanPhamDTO sp1DTO = new SanPhamDTO(spDTO.getMaSanPham(), spDTO.getTenSanPham(),
												soluongcapnhat, spDTO.getGia(), spDTO.getMaLoai(), spDTO.getMaNSX(),
												spDTO.getImage(), spDTO.getGhiChu());
										spBUS.updateSP(sp1DTO);
									}
								}
							}
						}
					} else {
						HoaDonDTO hdDTO = new HoaDonDTO(textFieldMaHD.getText(),
								(String) comboBoxMaNhanVien.getSelectedItem(), textFieldMaKH.getText(),
								textFieldNgayDat.getText(), Integer.parseInt(textFieldTongTien.getText()), 2, 0);
						hdBUS.update(hdDTO);
						for (ChiTietHoaDonDTO cthdDTO : cthdBUS.getList()) {
							if (cthdDTO.getMaHoaDon().equals(textFieldMaHD.getText())) {
								for (SanPhamDTO spDTO : spBUS.getList()) {
									if (spDTO.getMaSanPham().equals(cthdDTO.getMaSanPham())) {
										int soluongcapnhat = spDTO.getSoLuong() + cthdDTO.getSoLuong();
										SanPhamDTO sp1DTO = new SanPhamDTO(spDTO.getMaSanPham(), spDTO.getTenSanPham(),
												soluongcapnhat, spDTO.getGia(), spDTO.getMaLoai(), spDTO.getMaNSX(),
												spDTO.getImage(), spDTO.getGhiChu());
										spBUS.updateSP(sp1DTO);
									}
								}
							}
						}
					}
					
				}else {
					if (comboBoxThanhToan.getSelectedItem().equals("Đã Thanh Toán")) {
						HoaDonDTO hdDTO = new HoaDonDTO(textFieldMaHD.getText(),
								(String) comboBoxMaNhanVien.getSelectedItem(), textFieldMaKH.getText(),
								textFieldNgayDat.getText(), Integer.parseInt(textFieldTongTien.getText()), 0, 1);
						hdBUS.update(hdDTO);
						
					} else {
						HoaDonDTO hdDTO = new HoaDonDTO(textFieldMaHD.getText(),
								(String) comboBoxMaNhanVien.getSelectedItem(), textFieldMaKH.getText(),
								textFieldNgayDat.getText(), Integer.parseInt(textFieldTongTien.getText()), 0, 0);
						hdBUS.update(hdDTO);
						
					}
				}
			}

			// Thông báo thành công và cập nhật bảng
			JOptionPane.showMessageDialog(null, "Xác nhận thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			
			reload1();

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

}
