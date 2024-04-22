package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.NhacCu.BUS.NhaCungCapBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.SanPhamBUS;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

public class QuanLyKho_BaoTri extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textAreaMoTa;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();

	/**
	 * Create the panel.
	 */
	public QuanLyKho_BaoTri() {
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(354, 70, 315, 234);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã BT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 10, 65, 28);
		panel_4.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(101, 10, 149, 28);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã NV");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 55, 65, 28);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mã User");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 107, 65, 28);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(10, 196, 90, 28);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Mã HĐ");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_2.setBounds(9, 154, 65, 28);
		panel_4.add(lblNewLabel_2_1_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 156, 149, 28);
		panel_4.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 54, 149, 27);
		panel_4.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(100, 108, 149, 27);
		panel_4.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(102, 198, 149, 27);
		panel_4.add(comboBox_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(354, 314, 315, 182);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 17, 86, 31);
		panel_5.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Mã Bảo Trì");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(10, 58, 86, 28);
		panel_5.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Ghi Chú");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1.setBounds(10, 106, 65, 28);
		panel_5.add(lblNewLabel_2_2_1_1);
		
		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(106, 109, 149, 63);
		panel_5.add(scrollPane1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// dọc
		scrollPane1.setAutoscrolls(true);
		
		JButton btnNewButton_2 = new JButton("<html><center><img src='" + QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/folder_16.png")
				+ "'><br>In và Lưu </br>Phiếu</center></html>");
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(260, 16, 45, 156);
		panel_5.add(btnNewButton_2);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBounds(106, 17, 149, 27);
		panel_5.add(comboBox_1_1_1);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setBounds(106, 61, 149, 27);
		panel_5.add(comboBox_1_1_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 502, 659, 47);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnThem.setIcon(
				new ImageIcon(QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/Awicons-Vista-Artistic-Add.16.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(10, 10, 110, 30);
		panel_3.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSua.setIcon(new ImageIcon(
				QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-10-Edit-validated.16.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(189, 10, 110, 30);
		panel_3.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
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
				
			}
		});
		btnReload.setIcon(
				new ImageIcon(QuanLyKho_BaoTri.class.getResource("/com/NhacCu/item/Hopstarter-Button-Button-Reload.16.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReload.setBounds(535, 10, 110, 30);
		panel_3.add(btnReload);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(10, 314, 334, 182);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 314, 162);
		panel_2_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 B\u1EA3o Tr\u00EC", "Ghi Ch\u00FA"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 69, 334, 235);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 314, 215);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 BT", "M\u00E3 NV", "M\u00E3 User", "M\u00E3 H\u00F3a \u0110\u01A1n", "Ng\u00E0y L\u1EADp", "Tr\u1EA1ng Th\u00E1i"
			}
		));
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
	public void them() {
		
	}
}
