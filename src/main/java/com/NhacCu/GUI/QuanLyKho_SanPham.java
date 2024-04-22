package com.NhacCu.GUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.BUS.NhaSanXuatBUS;
import com.NhacCu.BUS.LoaiBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.DTO.LoaiDTO;
import com.NhacCu.DTO.SanPhamDTO;
import com.NhacCu.DTO.NhaSanXuatDTO;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class QuanLyKho_SanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	public JTextField textFieldMaSP;
	public JTextField textFieldGia;
	public JTextField textFieldSoLuong;
	public JTextField textFieldTenSP;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private LoaiBUS loaiBUS = new LoaiBUS();
	private NhaSanXuatBUS nsxBUS = new NhaSanXuatBUS();
	private JComboBox comboBoxMaLoai;
	private JComboBox comboBoxNSX;
	private JTextArea textAreaMoTa;
	private JLabel lblThongBaoLoi;
	private JLabel lblImg;

	/**
	 * Create the panel.
	 */
	public QuanLyKho_SanPham() {
		if (spBUS.getList() == null)
			spBUS.listSP();
		if (loaiBUS.getList() == null)
			loaiBUS.listLoai();
		if (nsxBUS.getList() == null)
			nsxBUS.list();
		initComponents();
		setcomboBoxMaLoai(loaiBUS.getList());
		setcomboBoxNSX(nsxBUS.getList());
		initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());
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

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 44, 659, 193);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		// Hiển thị dữ liệu trong jtable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 639, 173);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("BẢNG SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 0, 679, 34);
		panel_1.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 247, 659, 302);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Mã SP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(13, 10, 74, 31);
		panel_3.add(lblNewLabel_2);

		textFieldMaSP = new JTextField();
		textFieldMaSP.setBounds(97, 10, 146, 32);
		panel_3.add(textFieldMaSP);
		textFieldMaSP.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Mã Loại");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(13, 65, 74, 31);
		panel_3.add(lblNewLabel_2_1);

		comboBoxMaLoai = new JComboBox();
		comboBoxMaLoai.setBounds(97, 65, 146, 31);
		panel_3.add(comboBoxMaLoai);
		comboBoxMaLoai.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		JLabel lblNewLabel_2_1_1 = new JLabel("Nhà SX");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(13, 127, 85, 31);
		panel_3.add(lblNewLabel_2_1_1);

		comboBoxNSX = new JComboBox();
		comboBoxNSX.setBounds(97, 127, 146, 31);
		panel_3.add(comboBoxNSX);
		comboBoxNSX.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		JLabel lblNewLabel_2_2 = new JLabel("Giá");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(303, 10, 74, 31);
		panel_3.add(lblNewLabel_2_2);

		textFieldGia = new JTextField();
		textFieldGia.setColumns(10);
		textFieldGia.setBounds(387, 10, 146, 32);
		panel_3.add(textFieldGia);

		JLabel lblNewLabel_2_2_1 = new JLabel("Tên SP");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(303, 65, 74, 31);
		panel_3.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Số Lượng");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(303, 127, 74, 31);
		panel_3.add(lblNewLabel_2_2_1_1);

		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(387, 127, 146, 32);
		panel_3.add(textFieldSoLuong);

		textFieldTenSP = new JTextField();
		textFieldTenSP.setColumns(10);
		textFieldTenSP.setBounds(387, 64, 146, 32);
		panel_3.add(textFieldTenSP);

		JLabel lblNewLabel_2_2_2 = new JLabel("Mô Tả");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(564, 10, 85, 31);
		panel_3.add(lblNewLabel_2_2_2);

		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(543, 36, 106, 120);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Hiển thị thanh cuộn theo chiều
																						// dọc
		scrollPane1.setAutoscrolls(true); // Tự động cuộn theo con trỏ chuột
		panel_3.add(scrollPane1);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSanPham();
			}
		});
		btnNewButton
				.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/Awicons-Vista-Artistic-Add.16.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(55, 261, 95, 31);
		panel_3.add(btnNewButton);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sửa();
			}
		});
		btnSua.setIcon(new ImageIcon(
				QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-10-Edit-validated.16.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(207, 261, 95, 31);
		panel_3.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(
				QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-1-Delete-1.16.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(375, 261, 95, 31);
		panel_3.add(btnXoa);

		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
		btnReload.setIcon(
				new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/Hopstarter-Button-Button-Reload.16.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBounds(522, 261, 106, 31);
		panel_3.add(btnReload);

		lblThongBaoLoi = new JLabel("");
		lblThongBaoLoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThongBaoLoi.setForeground(new Color(255, 0, 0));
		lblThongBaoLoi.setBounds(97, 168, 327, 27);
		panel_3.add(lblThongBaoLoi);

		JButton btnAddImg = new JButton("Chọn ảnh");
		btnAddImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addImage();
			}
		});
		btnAddImg.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/add-image_16.png")));
		btnAddImg.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddImg.setBounds(98, 215, 146, 31);
		panel_3.add(btnAddImg);

		lblImg = new JLabel("Hình Ảnh");
		lblImg.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImg.setBounds(462, 169, 131, 82);
		panel_3.add(lblImg);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(QuanLyKho_SanPham.class.getResource("/com/NhacCu/item/Anh_Nen.jpg")));
		lblNewLabel.setBounds(0, 0, 679, 559);
		panel_1.add(lblNewLabel);
	}

	private void initTable(final ArrayList<SanPhamDTO> list,final ArrayList<LoaiDTO> listLoai,final ArrayList<NhaSanXuatDTO> listNSX) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Sản Phẩm");
		model.addColumn("Mã Loại");
		model.addColumn("Tên Sản Phẩm");
		model.addColumn("Số Lượng");
		model.addColumn("Giá");
		model.addColumn("Nhà Sản Xuất");
		model.addColumn("Ảnh");
		model.addColumn("Mô tả");

		for (SanPhamDTO sp : list) {
			model.addRow(new Object[] { sp.getMaSanPham(), sp.getMaLoai(), sp.getTenSanPham(), sp.getSoLuong(),
					sp.getGia(), sp.getMaNSX(), sp.getImage(), sp.getGhiChu() });
		}

		this.table.setModel(model);

		table.setAutoCreateRowSorter(true);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaSP.setText((String) table.getValueAt(index, 0));
				textFieldMaSP.setEditable(false);
				textFieldMaSP.setEnabled(false);
				String selectedMaLoai = String.valueOf(table.getValueAt(index, 1));
				int count = 0;
				for (LoaiDTO loai : listLoai) {
					if (selectedMaLoai.equals(loai.getMaLoai())) {
						comboBoxMaLoai.setSelectedIndex(count);
						break;
					}
					count++;
				}
				textFieldTenSP.setText(String.valueOf(table.getValueAt(index, 2)));
				textFieldSoLuong.setText(String.valueOf(table.getValueAt(index, 3)));
				textFieldGia.setText(String.valueOf(table.getValueAt(index, 4)));
				String selectedNSX = String.valueOf(table.getValueAt(index, 5));
				int count1 = 0;
				for (NhaSanXuatDTO nsx : listNSX) {
					if (selectedNSX.equals(nsx.getMaNSX())) {
						comboBoxNSX.setSelectedIndex(count1);
						break;
					}
					count1++;
				}
				lblImg.setName(String.valueOf(table.getValueAt(index, 6)));
		        lblImg.setIcon( setIC(String.valueOf(table.getValueAt(index, 6))));
				textAreaMoTa.setText(String.valueOf(table.getValueAt(index, 7))); // Set text for textAreaMoTa
			}
		});
	}

	public void setcomboBoxMaLoai(ArrayList<LoaiDTO> listLoai) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (LoaiDTO loai : listLoai) {
			model.addElement(loai.getMaLoai() + "   " + loai.getTenLoai());
		}
		comboBoxMaLoai.setModel(model);
	}

	public void setcomboBoxNSX(ArrayList<NhaSanXuatDTO> listNSX) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (NhaSanXuatDTO nsx : listNSX) {
			model.addElement(nsx.getMaNSX() + "   " + nsx.getTenNSX());
		}
		comboBoxNSX.setModel(model);
	}

	private void themSanPham() {
		if (KiemTraTrong() && !spBUS.checkMaSP(textFieldMaSP.getText())) {
			String loai = (String) comboBoxMaLoai.getSelectedItem();
			String[] maLoai = loai.split(" ");
			String nsx = (String) comboBoxNSX.getSelectedItem();
			String[] maNSX = nsx.split(" ");

			// Kiểm tra định dạng số cho Số lượng và Giá
			try {
				int soLuong = Integer.parseInt(textFieldSoLuong.getText());
				int gia = Integer.parseInt(textFieldGia.getText());
				SanPhamDTO spDTO = new SanPhamDTO(textFieldMaSP.getText(), textFieldTenSP.getText(), soLuong, gia,
						maLoai[0], maNSX[0],lblImg.getName(), textAreaMoTa.getText());
				spBUS.addSP(spDTO);

				// Thông báo thành công và cập nhật bảng
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số lượng và giá phải là số nguyên dương!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
			Reload();
		} else {
			JOptionPane.showMessageDialog(null, "Sản phẩm bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
		}
	}

	private boolean KiemTraTrong() {
		if (textFieldMaSP.getText() == null || textFieldMaSP.getText().equals("")) {
			lblThongBaoLoi.setText("Mã sản phẩm không được trống!");
			textFieldMaSP.requestFocus();
			return false;
		}
		if (textFieldTenSP.getText() == null || textFieldTenSP.getText().equals("")) {
			lblThongBaoLoi.setText("Tên sản phẩm không được trống!");
			textFieldTenSP.requestFocus();
			return false;
		}
		if (textFieldSoLuong.getText() == null || textFieldSoLuong.getText().equals("")) {
			lblThongBaoLoi.setText("Số lượng không được trống!");
			textFieldSoLuong.requestFocus();
			return false;
		}
		if (textFieldGia.getText() == null || textFieldGia.getText().equals("")) {
			lblThongBaoLoi.setText("Giá không được trống!");
			textFieldGia.requestFocus();
			return false;
		}
		return true;
	}

	private void Sửa() {
		if (KiemTraTrong()) {
			String loai = (String) comboBoxMaLoai.getSelectedItem();
			String[] maLoai = loai.split(" ");
			String nsx = (String) comboBoxNSX.getSelectedItem();
			String[] maNSX = nsx.split(" ");
			try {
				int soLuong = Integer.parseInt(textFieldSoLuong.getText());
				int gia = Integer.parseInt(textFieldGia.getText());

				SanPhamDTO spDTO = new SanPhamDTO(textFieldMaSP.getText(), textFieldTenSP.getText(), soLuong, gia,
						maLoai[0], maNSX[0],lblImg.getName(), textAreaMoTa.getText());
				spBUS.updateSP(spDTO);
				JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());
				Reload();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số lượng và giá phải là số nguyên dương!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	
	}

	private void Xoa() {
		if (KiemTraTrong()) {
			spBUS.delete(textFieldMaSP.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());
		}
	}

	private void Reload() {
		textFieldMaSP.setText("");
		textFieldMaSP.setEditable(true);
		textFieldMaSP.setEnabled(true);
		textFieldTenSP.setText("");
		textFieldSoLuong.setText("");
		textFieldGia.setText("");
		textAreaMoTa.setText("");
		lblThongBaoLoi.setText("");
		lblImg.setName("Hình Ảnh");
        lblImg.setIcon( setIC(""));
		comboBoxMaLoai.setSelectedIndex(0);
		comboBoxNSX.setSelectedIndex(0);
		NhaSanXuatBUS nsxBUStest = new NhaSanXuatBUS();
		SanPhamBUS spBUStest = new SanPhamBUS();
		LoaiBUS loaiBUStest = new LoaiBUS();
		if (nsxBUStest.getList() == null)
			nsxBUStest.list();
		if (spBUStest.getList() == null)
			spBUStest.listSP();
		if (loaiBUStest.getList() == null)
			loaiBUStest.listLoai();
		setcomboBoxNSX(nsxBUStest.getList());
		setcomboBoxMaLoai(loaiBUStest.getList());
		initTable(spBUStest.getList(), loaiBUStest.getList(), nsxBUStest.getList());

	}
	  public ImageIcon setIC(String path){
		     ImageIcon imgs=new ImageIcon(path);
		           Image ig= imgs.getImage().getScaledInstance(lblImg.getWidth() + 15, lblImg.getHeight(),Image.SCALE_SMOOTH);
		            ImageIcon ic=new ImageIcon(ig);
		            return ic;
		    }
	private void addImage() {
		try {
	        JFileChooser chooser = new JFileChooser();
	        int returnVal = chooser.showOpenDialog(this);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            java.io.File file = chooser.getSelectedFile();
	            String filePath = file.getPath();
	            filePath = filePath.replace("\\", "\\\\");
	            // Kiểm tra nếu tệp là hình ảnh hợp lệ
	            if (filePath.toLowerCase().endsWith(".jpg") || filePath.toLowerCase().endsWith(".jpeg") ||
	                    filePath.toLowerCase().endsWith(".png") || filePath.toLowerCase().endsWith(".gif") ||
	                    filePath.toLowerCase().endsWith(".bmp")) {
	                // Đặt hình ảnh vào lblImg
	            	lblImg.setIcon( setIC(filePath));
	         
	                lblImg.setName(filePath);
	            } else {
	                // Nếu tệp không phải là hình ảnh hợp lệ, hiển thị thông báo
	                JOptionPane.showMessageDialog(this, "Chỉ chấp nhận các định dạng ảnh: JPG, JPEG, PNG, GIF, BMP",
	                        "Lỗi", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
