package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.NhacCu.BUS.*;
import com.NhacCu.DTO.*;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

public class QuanLyKho_BaoTri extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldMaBT;
	private JTextField textFieldMaHD;
	private JTextArea textAreaMoTa;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private ChiTietPhieuBaoTriBUS ctpbtBUS = new ChiTietPhieuBaoTriBUS();
	private PhieuBaoTriBUS pbtBUS = new PhieuBaoTriBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private JTextField textFieldMaKH;
	private JTextField textFieldMaNV;
	private JComboBox comboBoxTrangThai;
	private JComboBox comboBoxMaSP;
	private JTextField textFieldNgayLap;

	/**
	 * Create the panel.
	 */
	public QuanLyKho_BaoTri() {
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
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 193, 559);
		add(panel);

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
		btnLoai.setIcon(
				new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/data-classification_16.png")));
		btnLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoai.setBounds(10, 255, 173, 44);
		panel.add(btnLoai);

		JButton btnNhaSanXuat = new JButton("Nhà Sản Xuất");
		btnNhaSanXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyKho_TrangChu.control_QLK.chuyenveNhaSanXuat();
			}
		});
		btnNhaSanXuat
				.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/manufacture_16.png")));
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

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(354, 70, 315, 261);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Mã Bảo Trì");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 10, 123, 28);
		panel_4.add(lblNewLabel_2);

		textFieldMaBT = new JTextField();
		textFieldMaBT.setBounds(143, 13, 149, 28);
		panel_4.add(textFieldMaBT);
		textFieldMaBT.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Mã Nhân Viên");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 55, 110, 28);
		panel_4.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 107, 123, 28);
		panel_4.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(10, 221, 90, 28);
		panel_4.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Mã Hóa Đơn");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_2.setBounds(10, 145, 91, 28);
		panel_4.add(lblNewLabel_2_1_1_2);

		textFieldMaHD = new JTextField();
		textFieldMaHD.setColumns(10);
		textFieldMaHD.setBounds(143, 145, 149, 28);
		panel_4.add(textFieldMaHD);

		comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setBounds(143, 224, 149, 27);
		panel_4.add(comboBoxTrangThai);

		textFieldMaKH = new JTextField();
		textFieldMaKH.setColumns(10);
		textFieldMaKH.setBounds(143, 107, 149, 28);
		panel_4.add(textFieldMaKH);

		textFieldMaNV = new JTextField();
		textFieldMaNV.setColumns(10);
		textFieldMaNV.setBounds(143, 58, 149, 28);
		panel_4.add(textFieldMaNV);

		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Ngày Lập");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_2_1.setBounds(9, 183, 91, 28);
		panel_4.add(lblNewLabel_2_1_1_2_1);

		textFieldNgayLap = new JTextField();
		textFieldNgayLap.setColumns(10);
		textFieldNgayLap.setBounds(143, 183, 149, 28);
		panel_4.add(textFieldNgayLap);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(354, 341, 315, 155);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_2_2 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 17, 86, 31);
		panel_5.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Ghi Chú");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1.setBounds(10, 58, 65, 28);
		panel_5.add(lblNewLabel_2_2_1_1);

		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(106, 61, 149, 84);
		panel_5.add(scrollPane1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// dọc
		scrollPane1.setAutoscrolls(true);

		JButton btnNewButton_2 = new JButton(
				"<html><center><img src='" + QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/folder_16.png")
						+ "'><br>In và Lưu </br>Phiếu</center></html>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTable(table_1);
			}
		});
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(260, 16, 45, 129);
		panel_5.add(btnNewButton_2);

		comboBoxMaSP = new JComboBox();
		comboBoxMaSP.setBounds(106, 17, 149, 27);
		panel_5.add(comboBoxMaSP);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 502, 659, 47);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon(
				QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/Awicons-Vista-Artistic-Add.16.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(10, 10, 110, 30);
		panel_3.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(QuanLyKho_BaoTri.class
				.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-10-Edit-validated.16.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(189, 10, 110, 30);
		panel_3.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(
				QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-1-Delete-1.16.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(369, 10, 110, 30);
		panel_3.add(btnXoa);

		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnReload.setIcon(new ImageIcon(
				QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/Hopstarter-Button-Button-Reload.16.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReload.setBounds(535, 10, 110, 30);
		panel_3.add(btnReload);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(10, 341, 334, 155);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 314, 135);
		panel_2_1.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 B\u1EA3o Tr\u00EC", "Ghi Ch\u00FA" }));
		scrollPane_1.setViewportView(table_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 69, 334, 262);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 314, 242);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "M\u00E3 BT", "M\u00E3 NV", "M\u00E3 KH", "M\u00E3 H\u0110", "Ng\u00E0y L\u1EADp",
						"Tr\u1EA1ng Th\u00E1i" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("PHIẾU BẢO TRÌ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 0, 679, 59);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/Anh_Nen.jpg")));
		lblNewLabel.setBounds(0, -10, 689, 569);
		panel_1.add(lblNewLabel);

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
}
