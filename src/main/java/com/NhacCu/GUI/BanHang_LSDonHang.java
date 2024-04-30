package com.NhacCu.GUI;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.NhacCu.BUS.ChiTietHoaDonBUS;
import com.NhacCu.BUS.HoaDonBUS;
import com.NhacCu.BUS.LoaiBUS;
import com.NhacCu.BUS.NhaSanXuatBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.BUS.UserBUS;
import com.NhacCu.DTO.ChiTietHoaDonDTO;
import com.NhacCu.DTO.HoaDonDTO;
import com.NhacCu.DTO.NhanVienDTO;
import com.NhacCu.DTO.SanPhamDTO;
import com.NhacCu.DTO.UserDTO;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BanHang_LSDonHang extends JPanel {
	Color DefaultColor = new Color(240, 240, 240);
	Color ClickedColor = new Color(128, 255, 0);
	private static final long serialVersionUID = 1L;
	private JTable table_1;
	private JTable table_2;
	private JTextField textFieldNgayBatDau;
	private JTextField textFieldNgayKetThuc;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private LoaiBUS loaiBUS = new LoaiBUS();
	private NhaSanXuatBUS nsxBUS = new NhaSanXuatBUS();
	private HoaDonBUS hdBUS = new HoaDonBUS();
	private ChiTietHoaDonBUS cthdBUS = new ChiTietHoaDonBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private UserBUS usBUS = new UserBUS();
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	/**
	 * Create the panel.
	 */
	public BanHang_LSDonHang() {
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

		initTableHoaDonNhapHang(hdBUS.getList(), nvBUS.getList(), usBUS.getList(), cthdBUS.getList(), spBUS.getList());
		initCTHD(cthdBUS.getList(), spBUS.getList());

	}

	public void initComponents()  {
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
		
		JLabel lblNewLabel_1 = new JLabel("LỊCH SỬ ĐƠN HÀNG");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_1.setBounds(245, 10, 990, 115);
		add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 135, 705, 341);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 685, 321);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Nh\u00E2n Vi\u00EAn", "M\u00E3 Kh\u00E1ch H\u00E0ng", "Ng\u00E0y L\u1EADp", "T\u1ED5ng Ti\u1EC1n", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(725, 135, 601, 341);
		add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 581, 321);
		panel_2.add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 H\u00F3a \u0110\u01A1n", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Th\u1EDDi Gian B\u1EA3o H\u00E0nh", "Ghi Ch\u00FA"
			}
		));
		scrollPane_1.setViewportView(table_2);
		
		JButton btnNewButton = new JButton(" XEM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkDateRangeAndDisplay(hdBUS.getList(), nvBUS.getList(), usBUS.getList(), cthdBUS.getList(),
						spBUS.getList());
			}
		});
		btnNewButton.setIcon(new ImageIcon(BanHang_LSDonHang.class.getResource("/com/NhacCu/item/eye_24.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(735, 491, 251, 67);
		add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(125, 486, 562, 184);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày theo YYYY-MM-DD");
		lblNewLabel_3.setBounds(219, 0, 207, 34);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textFieldNgayBatDau = new JTextField();
		textFieldNgayBatDau.setBounds(203, 52, 212, 34);
		panel_3.add(textFieldNgayBatDau);
		textFieldNgayBatDau.setBackground(new Color(255, 255, 255));
		textFieldNgayBatDau.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textFieldNgayBatDau.setColumns(10);
		
		textFieldNgayKetThuc = new JTextField();
		textFieldNgayKetThuc.setBounds(203, 128, 212, 34);
		panel_3.add(textFieldNgayKetThuc);
		textFieldNgayKetThuc.setBackground(new Color(255, 255, 255));
		textFieldNgayKetThuc.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textFieldNgayKetThuc.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Đến ngày");
		lblNewLabel_2_1.setBounds(32, 124, 94, 34);
		panel_3.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_2 = new JLabel("Từ ngày");
		lblNewLabel_2.setBounds(32, 48, 94, 34);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JButton btnLmMi = new JButton("LÀM MỚI");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lammoi();
			}
		});
		btnLmMi.setIcon(new ImageIcon(BanHang_LSDonHang.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnLmMi.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLmMi.setBounds(735, 603, 251, 67);
		add(btnLmMi);
		
		JButton btnXutExcel = new JButton("XUẤT EXCEL");
		btnXutExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuatHoaDon();
			}
		});
		btnXutExcel.setIcon(new ImageIcon(BanHang_LSDonHang.class.getResource("/com/NhacCu/item/sheets_32.png")));
		btnXutExcel.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnXutExcel.setBounds(1025, 548, 251, 67);
		add(btnXutExcel);
	}
	public void initTableHoaDonNhapHang(ArrayList<HoaDonDTO> list, ArrayList<NhanVienDTO> listNV,
			ArrayList<UserDTO> listUs, ArrayList<ChiTietHoaDonDTO> listCTHD, ArrayList<SanPhamDTO> listSP) {
		// Tạo DefaultTableModel mớia
		model2 = new DefaultTableModel();
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
						model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
								hd.getNgayLap(), hd.getTongTien(), "Chờ Xác Nhận", "Đã Thanh Toán" });
					} else {
						model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
								hd.getNgayLap(), hd.getTongTien(), "Chờ Xác Nhận", "Chưa Thanh Toán" });
					}

				} else {
					if (hd.getThanhToan() == 1) {
						model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
								hd.getNgayLap(), hd.getTongTien(), "Hủy", "Đã Thanh Toán" });
					} else {
						model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
								hd.getNgayLap(), hd.getTongTien(), "Hủy", "Chưa Thanh Toán" });
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
				model1 = new DefaultTableModel();
				model1.addColumn("Mã Sản Phẩm");
				model1.addColumn("Mã Hóa Đơn");
				model1.addColumn("Số Lượng");
				model1.addColumn("Giá");
				model1.addColumn("Thời Gian Bảo Hành");
				model1.addColumn("Ghi Chú");

				// Đổ dữ liệu vào DefaultTableModel
				for (ChiTietHoaDonDTO cthd : listCTHD) {
					if (cthd.getMaHoaDon().equals(String.valueOf(table_1.getValueAt(index, 0)))) {
						model1.addRow(new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(), cthd.getSoLuong(),
								cthd.getGia(), cthd.getThoiGianBaoHanh(), cthd.getGhiChu() });
					}
				}

				// Sử dụng DefaultTableModel để tạo JTable
				table_2.setModel(model1);

				// Cho phép table sắp xếp
				table_2.setAutoCreateRowSorter(true);

			}
		});
	}

	public void initCTHD(ArrayList<ChiTietHoaDonDTO> listCTHD, ArrayList<SanPhamDTO> listSP) {
		model1 = new DefaultTableModel();
		model1.addColumn("Mã Sản Phẩm");
		model1.addColumn("Mã Hóa Đơn");
		model1.addColumn("Số Lượng");
		model1.addColumn("Giá");
		model1.addColumn("Thời Gian Bảo Hành");
		model1.addColumn("Ghi Chú");

		// Đổ dữ liệu vào DefaultTableModel
		for (ChiTietHoaDonDTO cthd : listCTHD) {

			model1.addRow(new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(), cthd.getSoLuong(), cthd.getGia(),
					cthd.getThoiGianBaoHanh(), cthd.getGhiChu() });
		}

		// Sử dụng DefaultTableModel để tạo JTable
		table_2.setModel(model1);

		// Cho phép table sắp xếp
		table_2.setAutoCreateRowSorter(true);

	}

	private void checkDateRangeAndDisplay(ArrayList<HoaDonDTO> list, ArrayList<NhanVienDTO> listNV,
			ArrayList<UserDTO> listUs, ArrayList<ChiTietHoaDonDTO> listCTHD, ArrayList<SanPhamDTO> listSP) {
		String startDateStr = textFieldNgayBatDau.getText();
		String endDateStr = textFieldNgayKetThuc.getText();

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
			model1.setRowCount(0);
			model2.setRowCount(0);
			// Hiển thị các sản phẩm trong khoảng thời gian đã nhập
			for (HoaDonDTO hd : list) {
				Date importDate = sdf.parse(hd.getNgayLap());
				if (importDate.compareTo(startDate) >= 0 && importDate.compareTo(endDate) <= 0) {
					if (hd.getEnable() == 1) {
						if (hd.getThanhToan() == 1) {
							model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
									hd.getNgayLap(), hd.getTongTien(), "Xác Nhận", "Đã Thanh Toán" });
							for (ChiTietHoaDonDTO cthd : listCTHD) {
								if (cthd.getMaHoaDon().equals(hd.getMaHoaDon())) {
									model1.addRow(
											new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(), cthd.getSoLuong(),
													cthd.getGia(), cthd.getThoiGianBaoHanh(), cthd.getGhiChu() });
								}
							}
						} else {
							model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
									hd.getNgayLap(), hd.getTongTien(), "Xác Nhận", "Chưa Thanh Toán" });
							for (ChiTietHoaDonDTO cthd : listCTHD) {
								if (cthd.getMaHoaDon().equals(hd.getMaHoaDon())) {
									model1.addRow(
											new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(), cthd.getSoLuong(),
													cthd.getGia(), cthd.getThoiGianBaoHanh(), cthd.getGhiChu() });
								}
							}
						}
					} else {
						if (hd.getEnable() == 0) {
							if (hd.getThanhToan() == 1) {
								model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
										hd.getNgayLap(), hd.getTongTien(), "Chờ Xác Nhận", "Đã Thanh Toán" });
								for (ChiTietHoaDonDTO cthd : listCTHD) {
									if (cthd.getMaHoaDon().equals(hd.getMaHoaDon())) {
										model1.addRow(new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(),
												cthd.getSoLuong(), cthd.getGia(), cthd.getThoiGianBaoHanh(),
												cthd.getGhiChu() });
									}
								}
							} else {
								model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
										hd.getNgayLap(), hd.getTongTien(), "Chờ Xác Nhận", "Chưa Thanh Toán" });
								for (ChiTietHoaDonDTO cthd : listCTHD) {
									if (cthd.getMaHoaDon().equals(hd.getMaHoaDon())) {
										model1.addRow(new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(),
												cthd.getSoLuong(), cthd.getGia(), cthd.getThoiGianBaoHanh(),
												cthd.getGhiChu() });
									}
								}
							}

						} else {
							if (hd.getThanhToan() == 1) {
								model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
										hd.getNgayLap(), hd.getTongTien(), "Hủy", "Đã Thanh Toán" });
								for (ChiTietHoaDonDTO cthd : listCTHD) {
									if (cthd.getMaHoaDon().equals(hd.getMaHoaDon())) {
										model1.addRow(new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(),
												cthd.getSoLuong(), cthd.getGia(), cthd.getThoiGianBaoHanh(),
												cthd.getGhiChu() });
									}
								}
							} else {
								model2.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaUser(), hd.getMaNhanVien(),
										hd.getNgayLap(), hd.getTongTien(), "Hủy", "Chưa Thanh Toán" });
								for (ChiTietHoaDonDTO cthd : listCTHD) {
									if (cthd.getMaHoaDon().equals(hd.getMaHoaDon())) {
										model1.addRow(new Object[] { cthd.getMaSanPham(), cthd.getMaHoaDon(),
												cthd.getSoLuong(), cthd.getGia(), cthd.getThoiGianBaoHanh(),
												cthd.getGhiChu() });
									}
								}
							}
						}
					}
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

	public void lammoi() {
		textFieldNgayBatDau.setText("");
		textFieldNgayKetThuc.setText("");
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
			nvBUS.listNV();
		}
		if (usBUSupdate.getList() == null) {
			usBUSupdate.listUs();
		}
		initTableHoaDonNhapHang(hdBUSupdate.getList(), nvBUSupdate.getList(), usBUSupdate.getList(),
				cthdBUSupdate.getList(), spBUSupdate.getList());
		initCTHD(cthdBUSupdate.getList(), spBUSupdate.getList());
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

	            // Xuất dữ liệu từ table_1
	            exportTableToSheet(table_1, sheet, 0);

	            // Xuất dữ liệu từ table_2
	            exportTableToSheet(table_2, sheet, table_1.getRowCount() + 2);

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
