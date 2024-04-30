package com.NhacCu.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.DTO.NhaSanXuatDTO;
import com.NhacCu.BUS.NhaSanXuatBUS;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class QuanLyKho_NhaSanXuat extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textFieldMaNSX;
	private JTextField textFieldTenNSX;
	private NhaSanXuatBUS nsxBUS = new NhaSanXuatBUS();
	private JLabel lblThongBao;
	/**
	 * Create the panel.
	 */
	public QuanLyKho_NhaSanXuat() {
		initComponents();

		if (nsxBUS.getList() == null)
			nsxBUS.list();
		initTable(nsxBUS.getList());
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
		panel_4.setBounds(10, 489, 659, 51);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon(QuanLyKho_NhaSanXuat.class.getResource("/com/NhacCu/item/Awicons-Vista-Artistic-Add.16.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(27, 10, 103, 31);
		panel_4.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(QuanLyKho_NhaSanXuat.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-10-Edit-validated.16.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(189, 10, 103, 31);
		panel_4.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(QuanLyKho_NhaSanXuat.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-1-Delete-1.16.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(356, 10, 103, 31);
		panel_4.add(btnXoa);
		
		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnReload.setIcon(new ImageIcon(QuanLyKho_NhaSanXuat.class.getResource("/com/NhacCu/item/Hopstarter-Button-Button-Reload.16.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReload.setBounds(529, 10, 103, 31);
		panel_4.add(btnReload);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 300, 659, 172);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Nhà Sản Xuất");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 30, 173, 30);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên Sản Xuất");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(35, 91, 173, 30);
		panel_3.add(lblNewLabel_2_1);
		
		textFieldMaNSX = new JTextField();
		textFieldMaNSX.setBounds(218, 30, 210, 30);
		panel_3.add(textFieldMaNSX);
		textFieldMaNSX.setColumns(10);
		
		textFieldTenNSX = new JTextField();
		textFieldTenNSX.setColumns(10);
		textFieldTenNSX.setBounds(218, 91, 210, 30);
		panel_3.add(textFieldTenNSX);
		
		JLabel lblThongBao = new JLabel("");
		lblThongBao.setForeground(new Color(255, 0, 0));
		lblThongBao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThongBao.setBounds(206, 131, 305, 31);
		panel_3.add(lblThongBao);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 65, 659, 225);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 639, 205);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nhà Sản Xuất");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(10, 10, 659, 45);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(QuanLyKho_NhaSanXuat.class.getResource("/com/NhacCu/item/Anh_Nen.jpg")));
		lblNewLabel.setBounds(0, 0, 679, 559);
		panel_1.add(lblNewLabel);
		
	}
	public void them() {
		if (kiemtraRong()) {
			if (!nsxBUS.checkMaNSX(textFieldMaNSX.getText())) {
				NhaSanXuatDTO nsxDTO = new NhaSanXuatDTO(textFieldMaNSX.getText(), textFieldTenNSX.getText());
				nsxBUS.add(nsxDTO);
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable(nsxBUS.getList());
				reload();

			} else {
				JOptionPane.showMessageDialog(null, "NSX bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);

			}
		}
	}

	public void sua() {
		if (kiemtraRong()) {
			NhaSanXuatDTO nsxDTO = new NhaSanXuatDTO(textFieldMaNSX.getText(), textFieldTenNSX.getText());
			nsxBUS.update(nsxDTO);
			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(nsxBUS.getList());
			reload();
		}
	}

	public void xoa() {
		if (kiemtraRong()) {
			nsxBUS.delete(textFieldMaNSX.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(nsxBUS.getList());
			reload();
		}
	}

	public void reload() {
		textFieldMaNSX.setText("");
		textFieldMaNSX.setEditable(true);
		textFieldMaNSX.setEnabled(true);
		textFieldTenNSX.setText("");
	}

	public void initTable(ArrayList<NhaSanXuatDTO> list) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã NSX");
		model.addColumn("Tên NSX");

		// Đổ dữ liệu vào DefaultTableModel
		for (NhaSanXuatDTO nsx : list) {
			model.addRow(new Object[] { nsx.getMaNSX(), nsx.getTenNSX() });

		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table.setModel(model);
		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaNSX.setText((String) table.getValueAt(index, 0));
				textFieldMaNSX.setEditable(false);
				textFieldMaNSX.setEnabled(false);
				textFieldTenNSX.setText((String) table.getValueAt(index, 1));
			}
		});
	}

	public boolean kiemtraRong() {
		if (textFieldMaNSX.getText() == null || textFieldMaNSX.getText().equals("")) {
			lblThongBao.setText("Mã NSX không được trống!");
			textFieldMaNSX.requestFocus();
			return false;
		}
		if (textFieldTenNSX.getText() == null || textFieldTenNSX.getText().equals("")) {
			lblThongBao.setText("Tên NSX không được trống!");
			textFieldTenNSX.requestFocus();
			return false;
		}

		return true;
	}
}
