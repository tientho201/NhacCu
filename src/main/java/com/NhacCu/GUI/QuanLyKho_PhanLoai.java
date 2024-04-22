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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.DTO.LoaiDTO;
import com.NhacCu.BUS.LoaiBUS;

public class QuanLyKho_PhanLoai extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaLoai;
	private JTextField textFieldTenLoai;
	private JLabel lblThongBao;
	private JTable table;
	private LoaiBUS loaiBUS = new LoaiBUS();
	/**
	 * Create the panel.
	 */
	public QuanLyKho_PhanLoai() {
		initComponents();
		if (loaiBUS.getList() == null)
			loaiBUS.listLoai();
		initTable(loaiBUS.getList());
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
				reload();
			}
		});
		btnReload.setIcon(
				new ImageIcon(QuanLyKho_DoiTac.class.getResource("/com/NhacCu/item/Hopstarter-Button-Button-Reload.16.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBounds(544, 10, 105, 38);
		panel_4.add(btnReload);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 301, 659, 169);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblMaLoai = new JLabel("Mã Loại");
		lblMaLoai.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMaLoai.setBounds(33, 23, 100, 28);
		panel_3.add(lblMaLoai);

		textFieldMaLoai = new JTextField();
		textFieldMaLoai.setBounds(164, 23, 221, 30);
		panel_3.add(textFieldMaLoai);
		textFieldMaLoai.setColumns(10);

		JLabel lblTenLoai = new JLabel("Tên Loại");
		lblTenLoai.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTenLoai.setBounds(33, 83, 95, 28);
		panel_3.add(lblTenLoai);

		textFieldTenLoai = new JTextField();
		textFieldTenLoai.setColumns(10);
		textFieldTenLoai.setBounds(164, 83, 221, 28);
		panel_3.add(textFieldTenLoai);

		lblThongBao = new JLabel("");
		lblThongBao.setBounds(151, 131, 296, 28);
		panel_3.add(lblThongBao);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 89, 659, 202);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 639, 182);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Phân Loại");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(0, 0, 679, 79);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(QuanLyKho_DoiTac.class.getResource("/com/NhacCu/item/Anh_Nen.jpg")));
		lblNewLabel.setBounds(0, 0, 679, 559);
		panel_1.add(lblNewLabel);
	}

	public void them() {
		if (kiemtraRong()) {
			if (!loaiBUS.checkMaLoai(textFieldMaLoai.getText())) {
				LoaiDTO loaiDTO = new LoaiDTO(textFieldMaLoai.getText(), textFieldTenLoai.getText());
				loaiBUS.add(loaiDTO);
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable(loaiBUS.getList());
				reload();

			} else {
				JOptionPane.showMessageDialog(null, "Loại bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);

			}
		}
	}

	public void sua() {
		if (kiemtraRong()) {
			LoaiDTO loaiDTO = new LoaiDTO(textFieldMaLoai.getText(), textFieldTenLoai.getText());
			loaiBUS.update(loaiDTO);
			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(loaiBUS.getList());
			reload();
		}
	}

	public void xoa() {
		if (kiemtraRong()) {
			loaiBUS.delete(textFieldMaLoai.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(loaiBUS.getList());
			reload();
		}
	}

	public void reload() {
		textFieldMaLoai.setText("");
		textFieldMaLoai.setEditable(true);
		textFieldMaLoai.setEnabled(true);
		textFieldTenLoai.setText("");
	}

	public void initTable(ArrayList<LoaiDTO> listLoai) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Loại");
		model.addColumn("Tên Loại");

		// Đổ dữ liệu vào DefaultTableModel
		for (LoaiDTO loai : listLoai) {
			model.addRow(new Object[] { loai.getMaLoai(), loai.getTenLoai() });

		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table.setModel(model);
		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaLoai.setText((String) table.getValueAt(index, 0));
				textFieldMaLoai.setEditable(false);
				textFieldMaLoai.setEnabled(false);
				textFieldTenLoai.setText((String) table.getValueAt(index, 1));
			}
		});
	}

	public boolean kiemtraRong() {
		if (textFieldMaLoai.getText() == null || textFieldMaLoai.getText().equals("")) {
			lblThongBao.setText("Mã Loại không được trống!");
			textFieldMaLoai.requestFocus();
			return false;
		}
		if (textFieldTenLoai.getText() == null || textFieldTenLoai.getText().equals("")) {
			lblThongBao.setText("Tên Loại không được trống!");
			textFieldTenLoai.requestFocus();
			return false;
		}

		return true;
	}
}
