package com.NhacCu.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.BUS.NhaCungCapBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.DTO.NhaCungCapDTO;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuanLyKho_DoiTac extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private NhaCungCapBUS NCCBUS = new NhaCungCapBUS();
	private SanPhamBUS spBUS = new SanPhamBUS();
	private JTextField textFieldMaNCC;
	private JTextField textFieldTenNCC;
	private JTextField textFieldDiaChiNCC;
	private JTextField textFieldSDTNCC;
	private JTextArea textAreaMoTa;
	private JLabel lblThongBao;
	/**
	 * Create the panel.
	 */
	public QuanLyKho_DoiTac() {
		initComponents();
		if (NCCBUS.getList() == null) {
			NCCBUS.listNCC();
		}
		
		if (spBUS.getList() == null)
			spBUS.listSP();
		initTable(NCCBUS.getList());
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

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(10, 480, 659, 58);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon(QuanLyKho_DoiTac.class.getResource("/com/NhacCu/item/Awicons-Vista-Artistic-Add.16.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(10, 10, 111, 38);
		panel_4.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(
				QuanLyKho_DoiTac.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-10-Edit-validated.16.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(195, 10, 111, 38);
		panel_4.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(
				QuanLyKho_DoiTac.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-1-Delete-1.16.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(373, 10, 111, 38);
		panel_4.add(btnXoa);

		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
		btnReload.setIcon(
				new ImageIcon(QuanLyKho_DoiTac.class.getResource("/com/NhacCu/item/Hopstarter-Button-Button-Reload.16.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBounds(544, 10, 105, 38);
		panel_4.add(btnReload);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(360, 89, 309, 381);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Mã NCC");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 10, 55, 28);
		panel_3.add(lblNewLabel_2);

		textFieldMaNCC = new JTextField();
		textFieldMaNCC.setBounds(118, 12, 158, 28);
		panel_3.add(textFieldMaNCC);
		textFieldMaNCC.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Tên NCC");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 58, 95, 28);
		panel_3.add(lblNewLabel_2_1);

		textFieldTenNCC = new JTextField();
		textFieldTenNCC.setColumns(10);
		textFieldTenNCC.setBounds(118, 58, 158, 28);
		panel_3.add(textFieldTenNCC);

		JLabel lblNewLabel_2_1_1 = new JLabel("Địa Chỉ NCC");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(10, 108, 95, 28);
		panel_3.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("SĐT NCC");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_1.setBounds(10, 158, 95, 28);
		panel_3.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Mô tả");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1_1_1_1.setBounds(10, 207, 95, 28);
		panel_3.add(lblNewLabel_2_1_1_1_1);

		textFieldDiaChiNCC = new JTextField();
		textFieldDiaChiNCC.setColumns(10);
		textFieldDiaChiNCC.setBounds(118, 108, 158, 28);
		panel_3.add(textFieldDiaChiNCC);

		textFieldSDTNCC = new JTextField();
		textFieldSDTNCC.setColumns(10);
		textFieldSDTNCC.setBounds(118, 158, 158, 28);
		panel_3.add(textFieldSDTNCC);

		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(33, 245, 243, 79);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Hiển thị thanh cuộn theo chiều
																						// dọc
		scrollPane1.setAutoscrolls(true); // Tự động cuộn theo con trỏ chuột
		panel_3.add(scrollPane1);
		
		lblThongBao = new JLabel("");
		lblThongBao.setBounds(33, 334, 243, 37);
		panel_3.add(lblThongBao);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 89, 340, 381);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 320, 356);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Nhà Cung Cấp");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 0, 679, 34);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(QuanLyKho_DoiTac.class.getResource("/com/NhacCu/item/Anh_Nen.jpg")));
		lblNewLabel.setBounds(0, 0, 679, 559);
		panel_1.add(lblNewLabel);
	}

	public void initTable(ArrayList<NhaCungCapDTO> listNCC) {
		// Tạo DefaultTableModel mới
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã NCC");
		model.addColumn("Tên NCC");
		model.addColumn("Địa Chỉ");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Mô Tả");

		// Đổ dữ liệu vào DefaultTableModel
		for (NhaCungCapDTO ncc : listNCC) {
			model.addRow(new Object[] { ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChiNCC(), ncc.getSDTNCC(),
					ncc.getGhiChu() });

		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table.setModel(model);

		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaNCC.setText((String) table.getValueAt(index, 0));
				textFieldMaNCC.setEditable(false);
				textFieldMaNCC.setEnabled(false);
				textFieldTenNCC.setText((String) table.getValueAt(index, 1));
				textFieldDiaChiNCC.setText((String) table.getValueAt(index, 2));
				textFieldSDTNCC.setText((String) table.getValueAt(index, 3));
				textAreaMoTa.setText((String) table.getValueAt(index, 4));

			}
		});
	}
	public boolean kiemtraRong() {
		if (textFieldMaNCC.getText() == null || textFieldMaNCC.getText().equals("")) {
			lblThongBao.setText("Mã Nhà Cung Cấp không được trống!");
			textFieldMaNCC.requestFocus();
			return false;
		}
		if (textFieldTenNCC.getText() == null || textFieldTenNCC.getText().equals("")) {
			lblThongBao.setText("Tên Nhà Cung Cấp không được trống!");
			textFieldTenNCC.requestFocus();
			return false;
		}
		if (textFieldDiaChiNCC.getText() == null || textFieldDiaChiNCC.getText().equals("")) {
			lblThongBao.setText("Địa Chỉ Nhà Cung Cấp không được trống!");
			textFieldTenNCC.requestFocus();
			return false;
		}
		if (textFieldSDTNCC.getText() == null || textFieldSDTNCC.getText().equals("")) {
			lblThongBao.setText("Số Điện Thoại không được trống!");
			textFieldSDTNCC.requestFocus();
			return false;
		}
		return true;
	}
	public void them() {
		if(kiemtraRong() ) {
			if ( !NCCBUS.checkMaNCC(textFieldMaNCC.getText())){
				NhaCungCapDTO nccDTO = new NhaCungCapDTO(textFieldMaNCC.getText() , textFieldTenNCC.getText() , textFieldDiaChiNCC.getText() , textFieldSDTNCC.getText() , textAreaMoTa.getText());
				NCCBUS.addSP(nccDTO);
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable( NCCBUS.getList());
				Reload();
				
			}else {

				JOptionPane.showMessageDialog(null, "Nhà Cung Cấp bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}
		}
	}
	public void sua() {
		if(kiemtraRong()) {
			NhaCungCapDTO nccDTO = new NhaCungCapDTO(textFieldMaNCC.getText() , textFieldTenNCC.getText() , textFieldDiaChiNCC.getText() , textFieldSDTNCC.getText() , textAreaMoTa.getText());
			NCCBUS.updateSP(nccDTO);
			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(NCCBUS.getList());
			Reload();
		}
	}
	public void xoa() {
		if (kiemtraRong()) {
			NCCBUS.delete(textFieldMaNCC.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable( NCCBUS.getList());
			Reload();
		}
	}
	public void Reload() {
		textFieldMaNCC.setText("");
		textFieldMaNCC.setEditable(true);
		textFieldMaNCC.setEnabled(true);
		textFieldDiaChiNCC.setText("");
		textFieldSDTNCC.setText("");
		textAreaMoTa.setText("");
		textFieldTenNCC.setText("");
		lblThongBao.setText("");
	}
}