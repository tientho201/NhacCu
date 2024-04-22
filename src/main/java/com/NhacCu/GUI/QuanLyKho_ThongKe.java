package com.NhacCu.GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JTextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.NhacCu.BUS.PhieuNhapHangBUS;
import com.NhacCu.DTO.ChiTietPhieuNhapDTO;
import com.NhacCu.DTO.LoaiDTO;
import com.NhacCu.DTO.NhaCungCapDTO;
import com.NhacCu.DTO.NhaSanXuatDTO;
import com.NhacCu.DTO.NhanVienDTO;
import com.NhacCu.DTO.PhieuNhapHangDTO;
import com.NhacCu.DTO.SanPhamDTO;
import com.NhacCu.BUS.ChiTietPhieuNhapBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.NhaCungCapBUS;

public class QuanLyKho_ThongKe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textFieldNgayBatDau;
	private JTextField textFieldNgayKetThuc;
	private PhieuNhapHangBUS pnBUS = new PhieuNhapHangBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private ChiTietPhieuNhapBUS ctpnBUS = new ChiTietPhieuNhapBUS();
	private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public QuanLyKho_ThongKe() {
		if (pnBUS.getList() == null) {
			pnBUS.list();
		}
		if (nvBUS.getList() == null) {
			nvBUS.listNV();
		}
		if (ctpnBUS.getList() == null) {
			ctpnBUS.list();
		}
		if (nccBUS.getList() == null) {
			nccBUS.listNCC();
		}
		initComponents();
		initTable(pnBUS.getList(), nvBUS.getList(), ctpnBUS.getList(), nccBUS.getList());

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
		
		JButton btnReloadTable = new JButton("Làm Mới");
		btnReloadTable.setIcon(new ImageIcon(QuanLyKho_ThongKe.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReloadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadTable();
			}
		});
		btnReloadTable.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReloadTable.setBounds(452, 501, 171, 48);
		panel_1.add(btnReloadTable);

		JButton btnXemThongKe = new JButton("Xuất Excel");
		btnXemThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();
			}
		});
		btnXemThongKe.setIcon(new ImageIcon(QuanLyKho_ThongKe.class.getResource("/com/NhacCu/item/sheets_32.png")));
		btnXemThongKe.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXemThongKe.setBounds(452, 433, 171, 48);
		panel_1.add(btnXemThongKe);

		JButton btnXem = new JButton("Xem");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkDateRangeAndDisplay(pnBUS.getList(),nvBUS.getList() , ctpnBUS.getList(), nccBUS.getList());
			}
		});
		btnXem.setIcon(new ImageIcon(QuanLyKho_ThongKe.class.getResource("/com/NhacCu/item/eye_24.png")));
		btnXem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXem.setBounds(452, 371, 171, 48);
		panel_1.add(btnXem);

		JLabel lblThongBao = new JLabel("");
		lblThongBao.setForeground(new Color(255, 255, 255));
		lblThongBao.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblThongBao.setBounds(75, 509, 313, 40);
		panel_1.add(lblThongBao);

		textFieldNgayKetThuc = new JTextField();
		textFieldNgayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNgayKetThuc.setColumns(10);
		textFieldNgayKetThuc.setBounds(102, 447, 198, 34);
		panel_1.add(textFieldNgayKetThuc);

		JLabel lblNewLabel_2_1 = new JLabel("Đến Ngày");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(10, 447, 94, 34);
		panel_1.add(lblNewLabel_2_1);

		textFieldNgayBatDau = new JTextField();
		textFieldNgayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNgayBatDau.setBounds(102, 376, 198, 34);
		panel_1.add(textFieldNgayBatDau);
		textFieldNgayBatDau.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Ngày theo YYYY-MM-DD");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(113, 341, 207, 34);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("Từ Ngày");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(10, 376, 94, 34);
		panel_1.add(lblNewLabel_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 54, 659, 277);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 639, 257);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
	
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("THỐNG KÊ NHẬP KHO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 0, 679, 34);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(QuanLyKho_ThongKe.class.getResource("/com/NhacCu/item/Anh_Nen.jpg")));
		lblNewLabel.setBounds(0, 0, 679, 559);
		panel_1.add(lblNewLabel);
	}

	public void initTable(ArrayList<PhieuNhapHangDTO> listPN, ArrayList<NhanVienDTO> listNV,
			ArrayList<ChiTietPhieuNhapDTO> listCTPN, ArrayList<NhaCungCapDTO> listNCC) {
		 model = new DefaultTableModel();
		model.addColumn("Mã PNH");
		model.addColumn("Mã NCC");
		model.addColumn("Tên NCC");
		model.addColumn("Mã NV");
		model.addColumn("Tên Nhân Viên");
		model.addColumn("Ngày Nhập");

		for (PhieuNhapHangDTO pnh : listPN) {
			model.addRow(new Object[] { pnh.getMaPNH(), pnh.getMaNCC(), nccBUS.PutOnTenNCC(pnh.getMaNCC()),
					pnh.getMaNhanVien(), nvBUS.PutOnTenNhanVien(pnh.getMaNhanVien()), pnh.getNgayNhap() });
		}
		
		this.table.setModel(model);
		  table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.setAutoCreateRowSorter(true);
	}

	private void checkDateRangeAndDisplay(ArrayList<PhieuNhapHangDTO> listPN, ArrayList<NhanVienDTO> listNV,
			ArrayList<ChiTietPhieuNhapDTO> listCTPN, ArrayList<NhaCungCapDTO> listNCC) {
		String startDateStr = textFieldNgayBatDau.getText();
		String endDateStr = textFieldNgayKetThuc.getText();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 // Kiểm tra xem các chuỗi nhập vào có đúng định dạng không
	    if (!isValidDateFormat(startDateStr) || !isValidDateFormat(endDateStr)) {
	        JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng yyyy-MM-dd.");
	        return;
	    }

		try {
			Date startDate = sdf.parse(startDateStr);
			Date endDate = sdf.parse(endDateStr);

			// Xóa dữ liệu cũ trong bảng
			model.setRowCount(0);

			// Hiển thị các sản phẩm trong khoảng thời gian đã nhập
			for (PhieuNhapHangDTO pnh : listPN) {
				Date importDate = sdf.parse(pnh.getNgayNhap());
				if (importDate.compareTo(startDate) >= 0 && importDate.compareTo(endDate) <= 0) {
					model.addRow(new Object[] { pnh.getMaPNH(), pnh.getMaNCC(), nccBUS.PutOnTenNCC(pnh.getMaNCC()),
							pnh.getMaNhanVien(), nvBUS.PutOnTenNhanVien(pnh.getMaNhanVien()), pnh.getNgayNhap() });
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
	public void reloadTable() {
		PhieuNhapHangBUS pnhBUSreload = new PhieuNhapHangBUS();
		NhanVienBUS nvBUSreload = new NhanVienBUS();
		ChiTietPhieuNhapBUS ctpnBUSreload = new ChiTietPhieuNhapBUS();
		NhaCungCapBUS nccBUSreload = new NhaCungCapBUS();
		if (pnhBUSreload.getList() == null) {
			pnhBUSreload.list();
		}
		if (nvBUSreload.getList() == null) {
			nvBUSreload.listNV();
		}
		if (ctpnBUSreload.getList() == null) {
			ctpnBUSreload.list();
		}
		if (nccBUSreload.getList() == null) {
			nccBUSreload.listNCC();
		}
		initTable(pnhBUSreload.getList(),nvBUSreload.getList(),ctpnBUSreload.getList(),nccBUSreload.getList());
	}

public void exportExcel() {
	try {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showSaveDialog(this);
        File saveFile = jFileChooser.getSelectedFile();
        if (saveFile != null) {
            saveFile = new File(saveFile.toString() + ".xlsx");
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Account");

            Row rowCol = sheet.createRow(0);
            for (int i = 0; i < table.getColumnCount(); i++) {
                Cell cell = rowCol.createCell(i);
                cell.setCellValue(table.getColumnName(i));
            }

            for (int j = 0; j < table.getRowCount(); j++) {
                Row row = sheet.createRow(j + 1);
                for (int k = 0; k < table.getColumnCount(); k++) {
                    Cell cell = row.createCell(k);
                    if (table.getValueAt(j, k) != null) {
                        cell.setCellValue(table.getValueAt(j, k).toString());
                    }

                }
            }
            FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
            wb.write(out);
            wb.close();
            out.close();
            openFile(saveFile.toString());
        }
    } catch (Exception e) {
        e.printStackTrace();
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
}
