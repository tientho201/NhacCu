package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.BUS.ChiTietHoaDonBUS;
import com.NhacCu.BUS.ChiTietPhieuNhapBUS;
import com.NhacCu.BUS.HoaDonBUS;
import com.NhacCu.BUS.LoaiBUS;
import com.NhacCu.BUS.NhaCungCapBUS;
import com.NhacCu.BUS.NhaSanXuatBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.PhieuNhapHangBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.BUS.UserBUS;
import com.NhacCu.DTO.ChiTietHoaDonDTO;
import com.NhacCu.DTO.ChiTietPhieuNhapDTO;
import com.NhacCu.DTO.HoaDonDTO;
import com.NhacCu.DTO.NhaCungCapDTO;
import com.NhacCu.DTO.NhanVienDTO;
import com.NhacCu.DTO.PhieuNhapHangDTO;
import com.NhacCu.DTO.SanPhamDTO;
import com.NhacCu.DTO.UserDTO;

import java.util.*;

public class Admin_ThongKe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_2;
	private JTable table_1;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private LoaiBUS loaiBUS = new LoaiBUS();
	private NhaSanXuatBUS nsxBUS = new NhaSanXuatBUS();
	private HoaDonBUS hdBUS = new HoaDonBUS();
	private ChiTietHoaDonBUS cthdBUS = new ChiTietHoaDonBUS();
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private UserBUS usBUS = new UserBUS();
	private PhieuNhapHangBUS pnhBUS = new PhieuNhapHangBUS();
	private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
	private ChiTietPhieuNhapBUS ctpnBUS = new ChiTietPhieuNhapBUS();
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private DefaultTableModel model3;
	private DefaultTableModel model4;
	private JLabel lblNewLabelSPNhieuNhat;
	private JLabel lblNewLabelTongSanPhamDaBan;
	private JLabel lblNewLabelTongTienThuDuoc;
	private JTable table_3;
	private JLabel lblNewLabelSanPhamNhapNhieuNhat;
	private JLabel lblNewLabelTongSanPhamDaNhap;
	private JLabel lblNewLabelTongTienDaNhap;

	/**
	 * Create the panel.
	 */
	public Admin_ThongKe() {
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
		if (pnhBUS.getList() == null) {
			pnhBUS.list();
		}
		if (nccBUS.getList() == null)
			nccBUS.listNCC();
		if (ctpnBUS.getList() == null)
			ctpnBUS.list();
		initComponents();

		initTableHoaDonNhapHang(hdBUS.getList(), nvBUS.getList(), usBUS.getList(), cthdBUS.getList(), spBUS.getList());
		initCTHD(cthdBUS.getList(), spBUS.getList());
		initTableNhapHang(pnhBUS.getList(), nvBUS.getList(), nccBUS.getList(), spBUS.getList(), ctpnBUS.getList());
		initCTPN(spBUS.getList(), ctpnBUS.getList());
		ThongKeMuaBan(cthdBUS.getList());
		ThongKeNhapKho(ctpnBUS.getList());

	}

	public void initComponents() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 1097, 665);
		add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Mua Bán", null, panel, null);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "T\u1ED5ng quan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 10, 1072, 131);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.GREEN);
		panel_1_1.setBounds(43, 29, 331, 74);
		panel_3.add(panel_1_1);

		JLabel lblNewLabel_1 = new JLabel("    ");
		lblNewLabel_1.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/products_64.png")));
		lblNewLabel_1.setBounds(10, 0, 87, 74);
		panel_1_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2_1 = new JLabel("Sản phẩm mua nhiều nhất");
		lblNewLabel_2_1.setBounds(78, 0, 253, 36);
		panel_1_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		 lblNewLabelSPNhieuNhat = new JLabel("Đàn Piano");
		lblNewLabelSPNhieuNhat.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelSPNhieuNhat.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabelSPNhieuNhat.setBounds(78, 31, 253, 43);
		panel_1_1.add(lblNewLabelSPNhieuNhat);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1.setBounds(397, 29, 304, 74);
		panel_3.add(panel_1_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("    ");
		lblNewLabel_1_1.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/network_64.png")));
		lblNewLabel_1_1.setBounds(10, 0, 87, 74);
		panel_1_1_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tổng sản phẩm đã bán");
		lblNewLabel_2_1_1.setBounds(77, 0, 200, 37);
		panel_1_1_1.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		 lblNewLabelTongSanPhamDaBan = new JLabel("100");
		lblNewLabelTongSanPhamDaBan.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabelTongSanPhamDaBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTongSanPhamDaBan.setBounds(87, 31, 190, 43);
		panel_1_1_1.add(lblNewLabelTongSanPhamDaBan);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1_1.setBounds(724, 29, 322, 74);
		panel_3.add(panel_1_1_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("    ");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/salary_64.png")));
		lblNewLabel_1_1_1.setBounds(10, 0, 87, 74);
		panel_1_1_1_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Tổng tiền thu được");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(77, 0, 245, 37);
		panel_1_1_1_1.add(lblNewLabel_2_1_1_1);

		 lblNewLabelTongTienThuDuoc = new JLabel("1000000");
		lblNewLabelTongTienThuDuoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTongTienThuDuoc.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabelTongTienThuDuoc.setBounds(87, 31, 235, 43);
		panel_1_1_1_1.add(lblNewLabelTongTienThuDuoc);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 1072, 243);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "M\u00E3 Kh\u00E1ch H\u00E0ng", "M\u00E3 Nh\u00E2n Vi\u00EAn",
						"M\u00E3 S\u1EA3n Ph\u1EA9m", "Ng\u00E0y Mua", "T\u1ED5ng Ti\u1EC1n",
						"Tr\u1EA1ng Th\u00E1i" }));
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 404, 1072, 224);
		panel.add(scrollPane_2);

		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Nhập Kho", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(
				new TitledBorder(null, "T\u1ED5ng quan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3_1.setBounds(10, 10, 1072, 131);
		panel_2.add(panel_3_1);

		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBackground(Color.GREEN);
		panel_1_1_2.setBounds(43, 29, 329, 74);
		panel_3_1.add(panel_1_1_2);

		JLabel lblNewLabel_1_2 = new JLabel("    ");
		lblNewLabel_1_2.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/products_64.png")));
		lblNewLabel_1_2.setBounds(10, 0, 87, 74);
		panel_1_1_2.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2_1_2 = new JLabel("Sản phẩm nhập nhiều nhất");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(78, 0, 251, 36);
		panel_1_1_2.add(lblNewLabel_2_1_2);

		 lblNewLabelSanPhamNhapNhieuNhat = new JLabel("Đàn Piano");
		lblNewLabelSanPhamNhapNhieuNhat.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelSanPhamNhapNhieuNhat.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabelSanPhamNhapNhieuNhat.setBounds(78, 31, 251, 43);
		panel_1_1_2.add(lblNewLabelSanPhamNhapNhieuNhat);

		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setLayout(null);
		panel_1_1_1_2.setBackground(new Color(128, 255, 255));
		panel_1_1_1_2.setBounds(390, 29, 329, 74);
		panel_3_1.add(panel_1_1_1_2);

		JLabel lblNewLabel_1_1_2 = new JLabel("    ");
		lblNewLabel_1_1_2.setIcon(
				new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/checklist_64.png")));
		lblNewLabel_1_1_2.setBounds(10, 0, 87, 74);
		panel_1_1_1_2.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Tổng sản phẩm đã nhập");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2.setBounds(77, 0, 252, 37);
		panel_1_1_1_2.add(lblNewLabel_2_1_1_2);

		 lblNewLabelTongSanPhamDaNhap = new JLabel("0");
		lblNewLabelTongSanPhamDaNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTongSanPhamDaNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabelTongSanPhamDaNhap.setBounds(87, 31, 242, 43);
		panel_1_1_1_2.add(lblNewLabelTongSanPhamDaNhap);

		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1_1_1.setBounds(740, 29, 306, 74);
		panel_3_1.add(panel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("    ");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Admin_ThongKe.class.getResource("/com/NhacCu/item/note_64.png")));
		lblNewLabel_1_1_1_1.setBounds(10, 0, 87, 74);
		panel_1_1_1_1_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Tổng tiền đã nhập");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1.setBounds(77, 0, 229, 37);
		panel_1_1_1_1_1.add(lblNewLabel_2_1_1_1_1);

		 lblNewLabelTongTienDaNhap = new JLabel("1000000");
		lblNewLabelTongTienDaNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTongTienDaNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabelTongTienDaNhap.setBounds(88, 27, 218, 43);
		panel_1_1_1_1_1.add(lblNewLabelTongTienDaNhap);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 151, 1072, 238);
		panel_2.add(scrollPane_1);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "Gi\u00E1 Nh\u1EADp", "S\u1ED1 L\u01B0\u1EE3ng",
						"Ng\u00E0y Nh\u1EADp", "T\u1ED5ng Ti\u1EC1n" }));
		scrollPane_1.setViewportView(table_2);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 399, 1072, 229);
		panel_2.add(scrollPane_1_1);
		
		table_3 = new JTable();
		scrollPane_1_1.setViewportView(table_3);
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
		this.table.setModel(model2);

		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);

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
		table_1.setModel(model1);

		// Cho phép table sắp xếp
		table_1.setAutoCreateRowSorter(true);
	}
	
	public void initTableNhapHang(ArrayList<PhieuNhapHangDTO> list,  ArrayList<NhanVienDTO> listNV,
			 ArrayList<NhaCungCapDTO> listNCC,  ArrayList<SanPhamDTO> listSP,
			 ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
		// Tạo DefaultTableModel mớia
		model3 = new DefaultTableModel();
		model3.addColumn("Mã Phiếu Nhập");
		model3.addColumn("Mã Nhà Cung Cấp");
		model3.addColumn("Mã Nhân Viên");
		model3.addColumn("Ngày Nhập");
		model3.addColumn("Tổng Tiền");
		model3.addColumn("Trạng Thái");

		// Đổ dữ liệu vào DefaultTableModel
		for (PhieuNhapHangDTO pnh : list) {
			if (pnh.getEnable() == 1) {
				model3.addRow(new Object[] { pnh.getMaPNH(), pnh.getMaNCC(), pnh.getMaNhanVien(), pnh.getNgayNhap(),
						pnh.getTongTien(), "Xác Nhận" });
			} else {
				model3.addRow(new Object[] { pnh.getMaPNH(), pnh.getMaNCC(), pnh.getMaNhanVien(), pnh.getNgayNhap(),
						pnh.getTongTien(), "Chờ Xác Nhận" });
			}
		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table_2.setModel(model3);

		// Cho phép table sắp xếp
		table_2.setAutoCreateRowSorter(true);
		
	}
	public void initCTPN( ArrayList<SanPhamDTO> listSP, ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
		model4 = new DefaultTableModel();
		model4.addColumn("Mã Phiếu Nhập");
		model4.addColumn("Mã Sản Phẩm");
		model4.addColumn("Giá");
		model4.addColumn("Số Lượng");
		model4.addColumn("Ghi Chú");

		// Đổ dữ liệu vào DefaultTableModel
		for (ChiTietPhieuNhapDTO ctpn : listCTPN) {

			model4.addRow(new Object[] { ctpn.getMaPNH(), ctpn.getMaSP(), ctpn.getDonGiaNhap(), ctpn.getSoLuong(),
					ctpn.getGhiChu() });

		}

		// Sử dụng DefaultTableModel để tạo JTable
		table_3.setModel(model4);

		// Cho phép table sắp xếp
		table_3.setAutoCreateRowSorter(true);
		
	}
	
	
	
	
	public void ThongKeMuaBan(ArrayList<ChiTietHoaDonDTO> listCTHD) {
		  // HashMap để lưu mã sản phẩm và tổng số lượng
        HashMap<String, Integer> sumQuantities = new HashMap<>();
        for (ChiTietHoaDonDTO cthd : listCTHD) {
        	  String maSanPham = cthd.getMaSanPham();
        	  int soLuong = cthd.getSoLuong();
        	  // Nếu sản phẩm đã tồn tại trong HashMap, cập nhật tổng số lượng
              if (sumQuantities.containsKey(maSanPham)) {
                  int tongSoLuong = sumQuantities.get(maSanPham);
                  sumQuantities.put(maSanPham, tongSoLuong + soLuong);
              } else {
                  // Nếu sản phẩm chưa tồn tại, thêm mới vào HashMap
                  sumQuantities.put(maSanPham, soLuong);
              }
        }
        // Tìm mã sản phẩm có tổng số lượng lớn nhất
        String maMax = null;
        int soLuongMax = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : sumQuantities.entrySet()) {
            if (entry.getValue() > soLuongMax) {
                maMax = entry.getKey();
                soLuongMax = entry.getValue();
            }
        }
        
        lblNewLabelSPNhieuNhat.setText(spBUS.PutOnTenSP(maMax));
        
        int countSanPhamDaBan = 0  ; 
        int countTongTienThuDuoc = 0 ;
        for (ChiTietHoaDonDTO cthd : listCTHD) {
        	countSanPhamDaBan += cthd.getSoLuong();
        	countTongTienThuDuoc += cthd.getGia() * cthd.getSoLuong() ; 
        }
        lblNewLabelTongSanPhamDaBan.setText(String.valueOf(countSanPhamDaBan));
        lblNewLabelTongTienThuDuoc.setText(String.valueOf(countTongTienThuDuoc + " VNĐ"));
        
	}
	public void ThongKeNhapKho(ArrayList<ChiTietPhieuNhapDTO> list) {
		 HashMap<String, Integer> sumQuantities = new HashMap<>();
	        for (ChiTietPhieuNhapDTO ctpn : list) {
	        	  String maSanPham = ctpn.getMaSP();
	        	  int soLuong = ctpn.getSoLuong();
	        	  // Nếu sản phẩm đã tồn tại trong HashMap, cập nhật tổng số lượng
	              if (sumQuantities.containsKey(maSanPham)) {
	                  int tongSoLuong = sumQuantities.get(maSanPham);
	                  sumQuantities.put(maSanPham, tongSoLuong + soLuong);
	              } else {
	                  // Nếu sản phẩm chưa tồn tại, thêm mới vào HashMap
	                  sumQuantities.put(maSanPham, soLuong);
	              }
	        }
	        // Tìm mã sản phẩm có tổng số lượng lớn nhất
	        String maMax = null;
	        int soLuongMax = Integer.MIN_VALUE;
	        for (Map.Entry<String, Integer> entry : sumQuantities.entrySet()) {
	            if (entry.getValue() > soLuongMax) {
	                maMax = entry.getKey();
	                soLuongMax = entry.getValue();
	            }
	        }
	        lblNewLabelSanPhamNhapNhieuNhat.setText(spBUS.PutOnTenSP(maMax));
	        
	        int countSanPhamDaNhap = 0  ; 
	        int countTongTienDaNhap = 0 ;
	        for (ChiTietPhieuNhapDTO ctpn : list) {
	        	countSanPhamDaNhap += ctpn.getSoLuong();
	        	countTongTienDaNhap += (ctpn.getDonGiaNhap() * ctpn.getSoLuong()) ; 
	        }
	        lblNewLabelTongSanPhamDaNhap.setText(String.valueOf(countSanPhamDaNhap));
	        lblNewLabelTongTienDaNhap.setText(String.valueOf(countTongTienDaNhap + " VNĐ"));
	}
}
