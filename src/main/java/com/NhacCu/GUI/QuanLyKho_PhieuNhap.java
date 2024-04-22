package com.NhacCu.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.NhacCu.BUS.ChiTietPhieuNhapBUS;
import com.NhacCu.BUS.LoaiBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.NhaCungCapBUS;
import com.NhacCu.BUS.NhaSanXuatBUS;
import com.NhacCu.BUS.PhieuNhapHangBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.DTO.LoaiDTO;
import com.NhacCu.DTO.NhaCungCapDTO;
import com.NhacCu.DTO.NhaSanXuatDTO;
import com.NhacCu.DTO.SanPhamDTO;
import com.NhacCu.DTO.NhanVienDTO;
import com.NhacCu.DTO.PhieuNhapHangDTO;
import com.NhacCu.DTO.ChiTietPhieuNhapDTO;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.FileOutputStream;
import java.io.IOException;

public class QuanLyKho_PhieuNhap extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private PhieuNhapHangBUS pnhBUS = new PhieuNhapHangBUS();
	private SanPhamBUS spBUS = new SanPhamBUS();
	private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private ChiTietPhieuNhapBUS ctpnBUS = new ChiTietPhieuNhapBUS();
	private JTextField textFieldMaPNH;
	private JTextField textFieldNgayNhap;
	private JTextField textFieldGia;
	private JTextField textFieldSoLuong;
	private JTextField textFieldTongTien;
	private JComboBox comboBoxMaSP;
	private JComboBox comboBoxMaNCC;
	private JTextArea textAreaMoTa;
	private JLabel lblThongBao;
	private Object columns;
	private JTable table_1;
	private JComboBox comboBoxMaNV;
	private JComboBox comboBoxTrangThai;

	/**
	 * Create the panel.
	 */
	public QuanLyKho_PhieuNhap() {
		initComponents();
		if (pnhBUS.getList() == null) {
			pnhBUS.list();
		}
		if (nvBUS.getList() == null) {
			nvBUS.listNV();
		}
		if (spBUS.getList() == null)
			spBUS.listSP();
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
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 193, 559);
		add(panel);
		panel.setLayout(null);

		JButton btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/products_24.png")));
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKho_TrangChu.control_QLK.chuyenveSanPham();
			}
		});
		panel.setLayout(null);
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSanPham.setBounds(10, 10, 173, 44);
		panel.add(btnSanPham);

		JButton btnPhieuNhap = new JButton("Phiếu Nhập");
		btnPhieuNhap.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/business_24.png")));
		btnPhieuNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKho_TrangChu.control_QLK.chuyenvePhieuNhap();
			}
		});
		btnPhieuNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPhieuNhap.setBounds(10, 92, 173, 44);
		panel.add(btnPhieuNhap);

		JButton btnThongKe = new JButton("Thống Kê");
		btnThongKe.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/trend_24.png")));
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKho_TrangChu.control_QLK.chuyenveThongKe();
			}
		});
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongKe.setBounds(10, 505, 173, 44);
		panel.add(btnThongKe);

		JButton btnDoiTac = new JButton("Đối Tác");
		btnDoiTac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKho_TrangChu.control_QLK.chuyenveDoiTac();
			}
		});
		btnDoiTac.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/supplier_24.png")));
		btnDoiTac.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDoiTac.setBounds(10, 175, 173, 44);
		panel.add(btnDoiTac);

		JButton btnLoai = new JButton("Phân Loại");
		btnLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKho_TrangChu.control_QLK.chuyenvePhanLoai();
			}
		});
		btnLoai.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/data-classification_16.png")));
		btnLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoai.setBounds(10, 255, 173, 44);
		panel.add(btnLoai);
		
		JButton btnNhaSanXuat = new JButton("Nhà Sản Xuất");
		btnNhaSanXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKho_TrangChu.control_QLK.chuyenveNhaSanXuat();
			}
		});
		btnNhaSanXuat.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/manufacture_16.png")));
		btnNhaSanXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNhaSanXuat.setBounds(9, 335, 174, 44);
		panel.add(btnNhaSanXuat);
		
		JButton btnBaoTri = new JButton("Bảo Trì");
		btnBaoTri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKho_TrangChu.control_QLK.chuyenveBaoTri();
			}
		});
		btnBaoTri.setIcon(new ImageIcon(QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/maintenance_24.png")));
		btnBaoTri.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBaoTri.setBounds(10, 422, 173, 44);
		panel.add(btnBaoTri);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(213, 10, 679, 559);
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 301, 334, 194);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 314, 174);
		panel_6.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 PNH", "M\u00E3 SP",
				"Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "T\u1ED5ng Ti\u1EC1n", "Ghi Ch\u00FA" }));
		scrollPane_1.setViewportView(table_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(354, 44, 315, 247);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Mã PNH");
		lblNewLabel_2.setBounds(10, 9, 76, 26);
		panel_5.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));

		textFieldMaPNH = new JTextField();
		textFieldMaPNH.setBounds(97, 10, 130, 28);
		panel_5.add(textFieldMaPNH);
		textFieldMaPNH.setColumns(10);

		JLabel lblNewLabel_2_1_1 = new JLabel("Mã NCC");
		lblNewLabel_2_1_1.setBounds(13, 52, 76, 26);
		panel_5.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		comboBoxMaNCC = new JComboBox();
		comboBoxMaNCC.setBounds(98, 53, 130, 26);
		panel_5.add(comboBoxMaNCC);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Mã NV");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_1.setBounds(13, 97, 76, 26);
		panel_5.add(lblNewLabel_2_1_1_1);

		comboBoxMaNV = new JComboBox();
		comboBoxMaNV.setBounds(97, 96, 130, 26);
		panel_5.add(comboBoxMaNV);

		JLabel lblNewLabel_2_2 = new JLabel("Ngày Nhập");
		lblNewLabel_2_2.setBounds(8, 135, 76, 26);
		panel_5.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));

		textFieldNgayNhap = new JTextField();
		textFieldNgayNhap.setBounds(98, 135, 130, 26);
		panel_5.add(textFieldNgayNhap);
		textFieldNgayNhap.setColumns(10);

		JLabel lblNewLabel_2_2_2 = new JLabel("Trạng Thái");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2_2.setBounds(10, 211, 76, 26);
		panel_5.add(lblNewLabel_2_2_2);

		comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setEnabled(false);
		comboBoxTrangThai.setBounds(101, 212, 125, 26);
		panel_5.add(comboBoxTrangThai);

		textFieldTongTien = new JTextField();
		textFieldTongTien.setBounds(100, 175, 127, 26);
		panel_5.add(textFieldTongTien);
		textFieldTongTien.setEditable(false);
		textFieldTongTien.setEnabled(false);
		textFieldTongTien.setColumns(10);

		JLabel lblNewLabel_2_2_1_2 = new JLabel("Tổng Tiền");
		lblNewLabel_2_2_1_2.setBounds(10, 176, 76, 26);
		panel_5.add(lblNewLabel_2_2_1_2);
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 505, 659, 50);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(
				new ImageIcon(QuanLyKho_PhieuNhap.class.getResource("/com/NhacCu/item/Awicons-Vista-Artistic-Add.16.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(10, 10, 110, 30);
		panel_4.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(
				QuanLyKho_PhieuNhap.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-10-Edit-validated.16.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(189, 10, 110, 30);
		panel_4.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(
				QuanLyKho_PhieuNhap.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-1-Delete-1.16.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(369, 10, 110, 30);
		panel_4.add(btnXoa);

		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnReload.setIcon(
				new ImageIcon(QuanLyKho_PhieuNhap.class.getResource("/com/NhacCu/item/Hopstarter-Button-Button-Reload.16.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReload.setBounds(535, 10, 110, 30);
		panel_4.add(btnReload);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(354, 301, 315, 194);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		lblThongBao = new JLabel("");
		lblThongBao.setForeground(new Color(255, 0, 0));
		lblThongBao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThongBao.setBounds(43, 197, 262, 26);
		panel_3.add(lblThongBao);

		JLabel lblNewLabel_2_1 = new JLabel("Mã SP");
		lblNewLabel_2_1.setBounds(10, 10, 76, 26);
		panel_3.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		comboBoxMaSP = new JComboBox();
		comboBoxMaSP.setBounds(96, 11, 130, 26);
		panel_3.add(comboBoxMaSP);

		JLabel lblNewLabel_2_2_1 = new JLabel("Giá ");
		lblNewLabel_2_2_1.setBounds(10, 53, 65, 26);
		panel_3.add(lblNewLabel_2_2_1);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		textFieldGia = new JTextField();
		textFieldGia.setBounds(96, 55, 130, 26);
		panel_3.add(textFieldGia);
		textFieldGia.setColumns(10);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Số Lượng");
		lblNewLabel_2_2_1_1.setBounds(10, 90, 65, 26);
		panel_3.add(lblNewLabel_2_2_1_1);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setBounds(96, 91, 130, 27);
		panel_3.add(textFieldSoLuong);
		textFieldSoLuong.setColumns(10);

		JLabel lblNewLabel_2_2_1_2_1 = new JLabel("Ghi Chú");
		lblNewLabel_2_2_1_2_1.setBounds(9, 136, 76, 26);
		panel_3.add(lblNewLabel_2_2_1_2_1);
		lblNewLabel_2_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(97, 137, 130, 44);
		panel_3.add(scrollPane1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// dọc
		scrollPane1.setAutoscrolls(true);

		JButton btnLuuPhieu_1 = new JButton(
				"<html><center><img src='" + QuanLyKho_PhieuNhap.class.getResource("/com/NhacCu/item/folder_16.png")
						+ "'><br>In và Lưu </br>Phiếu</center></html>");
		btnLuuPhieu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTable(table_1);
			}
		});
		btnLuuPhieu_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLuuPhieu_1.setBounds(258, 10, 47, 172);
		panel_3.add(btnLuuPhieu_1);
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

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 44, 334, 247);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 314, 227);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Phiếu Nhập Kho Hàng");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 0, 679, 34);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(QuanLyKho_PhieuNhap.class.getResource("/com/NhacCu/item/Anh_Nen.jpg")));
		lblNewLabel.setBounds(0, 0, 679, 559);
		panel_1.add(lblNewLabel);
	}

	public void initTableNhapHang(ArrayList<PhieuNhapHangDTO> list, final ArrayList<NhanVienDTO> listNV,
			final ArrayList<NhaCungCapDTO> listNCC, final ArrayList<SanPhamDTO> listSP, final ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
		// Tạo DefaultTableModel mớia
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã PNH");
		model.addColumn("Mã NCC");
		model.addColumn("Mã NV");
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
				model1.addColumn("Mã PNH");
				model1.addColumn("Mã SP");
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
		model.addElement("Xác Nhận");
		model.addElement("Chờ Xác Nhận");
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
		model1.addColumn("Mã PNH");
		model1.addColumn("Mã SP");
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
		lblThongBao.setText("");
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
			lblThongBao.setText("Mã Phiếu Nhập Hàng không được trống!");
			textFieldMaPNH.requestFocus();
			return false;
		}
		if (textFieldGia.getText() == null || textFieldGia.getText().equals("")) {
			lblThongBao.setText("Giá Nhập không được trống!");
			textFieldGia.requestFocus();
			return false;
		}
		if (textFieldSoLuong.getText() == null || textFieldSoLuong.getText().equals("")) {
			lblThongBao.setText("Số lượng không được trống!");
			textFieldSoLuong.requestFocus();
			return false;
		}
		if (textFieldNgayNhap.getText() == null || textFieldNgayNhap.getText().equals("")) {
			lblThongBao.setText("Ngày Nhập không được trống!");
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
				
				if (pnhBUS.checkMaPNHvaMaNCCvaMaNVvaNgayNhap(textFieldMaPNH.getText(),maNCC[0],maNV[0], textFieldNgayNhap.getText())) {
					
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
					JOptionPane.showMessageDialog(null, "Phiếu Nhập bị trùng", "Thông báo",
							JOptionPane.DEFAULT_OPTION);
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
							textFieldNgayNhap.getText(), tongTien,1 );
					pnhBUS.update(pnhDTO);
					
				}else {
					PhieuNhapHangDTO pnhDTO = new PhieuNhapHangDTO(textFieldMaPNH.getText(), maNCC[0], maNV[0],
							textFieldNgayNhap.getText(), tongTien,0 );
					pnhBUS.update(pnhDTO);
				}
				ChiTietPhieuNhapDTO ctpnDTO = new ChiTietPhieuNhapDTO(maSP[0], textFieldMaPNH.getText(), gia, soLuong,
						textAreaMoTa.getText());
				ctpnBUS.update(ctpnDTO);

				// Thông báo thành công và cập nhật bảng
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
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
				
				final String tendangnhapnv = 	QuanLyKho_TrangChu.tenDangNhap.getText();
				 String chuoi = tendangnhapnv;
			        String[] mangChuoi = chuoi.split(":"); // Tách chuỗi theo dấu ":"
			        if (mangChuoi.length > 1) {
			            String tuCanTim = mangChuoi[1].trim(); // Lấy phần sau dấu ":" và loại bỏ các khoảng trắng ở đầu và cuối
			           
								g2d.drawString("Mã Nhân Viên: " + nvBUS.PutOnMaNVEqualTenDangNhap(tuCanTim) , 100, 90);
								g2d.drawString("Tên Nhân Viên: " + nvBUS.PutOnTenNhanVienEqualTenDangNhap(tuCanTim) , 100, 110);
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
